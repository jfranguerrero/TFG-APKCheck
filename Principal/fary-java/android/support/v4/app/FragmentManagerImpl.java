package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v4.os.BuildCompat;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl
  extends FragmentManager
  implements LayoutInflaterFactory
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  static Field sAnimationListenerField;
  ArrayList<Fragment> mActive;
  ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<Integer> mAvailIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new Runnable()
  {
    public void run()
    {
      execPendingActions();
    }
  };
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  FragmentHostCallback mHost;
  private CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<OpGenerator> mPendingActions;
  ArrayList<StartEnterTransitionListener> mPostponedTransactions;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  ArrayList<Fragment> mTmpAddedFragments;
  ArrayList<Boolean> mTmpIsPop;
  ArrayList<BackStackRecord> mTmpRecords;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    HONEYCOMB = bool;
    sAnimationListenerField = null;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  FragmentManagerImpl() {}
  
  private void checkStateLoss()
  {
    if (mStateSaved) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + mNoTransactionsBecause);
    }
  }
  
  private void cleanupExec()
  {
    mExecutingActions = false;
    mTmpIsPop.clear();
    mTmpRecords.clear();
  }
  
  private void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = new ArrayList(1);
    ArrayList localArrayList = new ArrayList(1);
    ((ArrayList)localObject).add(paramBackStackRecord);
    localArrayList.add(Boolean.valueOf(paramBoolean1));
    executeOps((ArrayList)localObject, localArrayList, 0, 1);
    if (paramBoolean2) {
      FragmentTransition.startTransitions(this, (ArrayList)localObject, localArrayList, 0, 1, true);
    }
    if (paramBoolean3) {
      moveToState(mCurState, true);
    }
    for (;;)
    {
      return;
      if (mActive != null)
      {
        int j = mActive.size();
        int i = 0;
        while (i < j)
        {
          localObject = (Fragment)mActive.get(i);
          if ((mView != null) && (mIsNewlyAdded) && (paramBackStackRecord.interactsWith(mContainerId))) {
            mIsNewlyAdded = false;
          }
          i += 1;
        }
      }
    }
  }
  
  private void endAnimatingAwayFragments()
  {
    if (mActive == null) {}
    for (int i = 0;; i = mActive.size())
    {
      int j = 0;
      while (j < i)
      {
        Fragment localFragment = (Fragment)mActive.get(j);
        if ((localFragment != null) && (localFragment.getAnimatingAway() != null))
        {
          int k = localFragment.getStateAfterAnimating();
          View localView = localFragment.getAnimatingAway();
          localFragment.setAnimatingAway(null);
          localView.clearAnimation();
          moveToState(localFragment, k, 0, 0, false);
        }
        j += 1;
      }
    }
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    if (mExecutingActions) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (Looper.myLooper() != mHost.getHandler().getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    if (!paramBoolean) {
      checkStateLoss();
    }
    if (mTmpRecords == null)
    {
      mTmpRecords = new ArrayList();
      mTmpIsPop = new ArrayList();
    }
    executePostponedTransaction(null, null);
  }
  
  private static void executeOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(paramInt1);
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue()) {
        localBackStackRecord.executePopOps();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localBackStackRecord.executeOps();
      }
    }
  }
  
  private void executeOpsTogether(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool1 = getmAllowOptimization;
    int i = 0;
    label56:
    BackStackRecord localBackStackRecord;
    int k;
    if (mTmpAddedFragments == null)
    {
      mTmpAddedFragments = new ArrayList();
      if (mAdded != null) {
        mTmpAddedFragments.addAll(mAdded);
      }
      j = paramInt1;
      if (j >= paramInt2) {
        break label164;
      }
      localBackStackRecord = (BackStackRecord)paramArrayList.get(j);
      boolean bool2 = ((Boolean)paramArrayList1.get(j)).booleanValue();
      if (!bool2) {
        localBackStackRecord.expandReplaceOps(mTmpAddedFragments);
      }
      if (!bool2) {
        break label152;
      }
      k = -1;
      label110:
      localBackStackRecord.bumpBackStackNesting(k);
      if ((i == 0) && (!mAddToBackStack)) {
        break label158;
      }
    }
    label152:
    label158:
    for (i = 1;; i = 0)
    {
      j += 1;
      break label56;
      mTmpAddedFragments.clear();
      break;
      k = 1;
      break label110;
    }
    label164:
    mTmpAddedFragments.clear();
    if (!bool1) {
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    int j = paramInt2;
    if (bool1)
    {
      moveFragmentsToInvisible();
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    }
    if ((j != paramInt1) && (bool1))
    {
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, j, true);
      moveToState(mCurState, true);
    }
    while (paramInt1 < paramInt2)
    {
      localBackStackRecord = (BackStackRecord)paramArrayList.get(paramInt1);
      if ((((Boolean)paramArrayList1.get(paramInt1)).booleanValue()) && (mIndex >= 0))
      {
        freeBackStackIndex(mIndex);
        mIndex = -1;
      }
      paramInt1 += 1;
    }
    if (i != 0) {
      reportBackStackChanged();
    }
  }
  
  private void executePostponedTransaction(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int k;
    int j;
    label18:
    StartEnterTransitionListener localStartEnterTransitionListener;
    int m;
    if (mPostponedTransactions == null)
    {
      i = 0;
      k = 0;
      j = i;
      i = k;
      if (i >= j) {
        return;
      }
      localStartEnterTransitionListener = (StartEnterTransitionListener)mPostponedTransactions.get(i);
      if ((paramArrayList == null) || (mIsBack)) {
        break label116;
      }
      k = paramArrayList.indexOf(mRecord);
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label116;
      }
      localStartEnterTransitionListener.cancelTransaction();
      m = j;
      k = i;
    }
    for (;;)
    {
      i = k + 1;
      j = m;
      break label18;
      i = mPostponedTransactions.size();
      break;
      label116:
      if (!localStartEnterTransitionListener.isReady())
      {
        k = i;
        m = j;
        if (paramArrayList != null)
        {
          k = i;
          m = j;
          if (!mRecord.interactsWith(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        mPostponedTransactions.remove(i);
        k = i - 1;
        m = j - 1;
        if ((paramArrayList != null) && (!mIsBack))
        {
          i = paramArrayList.indexOf(mRecord);
          if ((i != -1) && (((Boolean)paramArrayList1.get(i)).booleanValue()))
          {
            localStartEnterTransitionListener.cancelTransaction();
            continue;
          }
        }
        localStartEnterTransitionListener.completeTransaction();
      }
    }
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment)
  {
    ViewGroup localViewGroup = mContainer;
    Object localObject = mView;
    if ((localViewGroup == null) || (localObject == null))
    {
      paramFragment = null;
      return paramFragment;
    }
    int i = mAdded.indexOf(paramFragment) - 1;
    for (;;)
    {
      if (i < 0) {
        break label76;
      }
      localObject = (Fragment)mAdded.get(i);
      if (mContainer == localViewGroup)
      {
        paramFragment = (Fragment)localObject;
        if (mView != null) {
          break;
        }
      }
      i -= 1;
    }
    label76:
    return null;
  }
  
  private void forcePostponedTransactions()
  {
    if (mPostponedTransactions != null) {
      while (!mPostponedTransactions.isEmpty()) {
        ((StartEnterTransitionListener)mPostponedTransactions.remove(0)).completeTransaction();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      if ((mPendingActions == null) || (mPendingActions.size() == 0)) {
        return false;
      }
      int j = mPendingActions.size();
      int i = 0;
      while (i < j)
      {
        ((OpGenerator)mPendingActions.get(i)).generateOps(paramArrayList, paramArrayList1);
        i += 1;
      }
      mPendingActions.clear();
      mHost.getHandler().removeCallbacks(mExecCommit);
      if (j > 0) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return paramContext;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return paramContext;
  }
  
  static boolean modifiesAlpha(Animation paramAnimation)
  {
    if ((paramAnimation instanceof AlphaAnimation)) {
      return true;
    }
    if ((paramAnimation instanceof AnimationSet))
    {
      paramAnimation = ((AnimationSet)paramAnimation).getAnimations();
      int i = 0;
      for (;;)
      {
        if (i >= paramAnimation.size()) {
          break label56;
        }
        if ((paramAnimation.get(i) instanceof AlphaAnimation)) {
          break;
        }
        i += 1;
      }
    }
    label56:
    return false;
  }
  
  private void moveFragmentsToInvisible()
  {
    if (mCurState < 1) {
      return;
    }
    int k = Math.min(mCurState, 4);
    if (mAdded == null) {}
    for (int i = 0;; i = mAdded.size())
    {
      int j = 0;
      while (j < i)
      {
        Fragment localFragment = (Fragment)mAdded.get(j);
        if (mState < k)
        {
          moveToState(localFragment, k, localFragment.getNextAnim(), localFragment.getNextTransition(), false);
          if ((mView != null) && (!mHidden) && (mIsNewlyAdded)) {
            mView.setVisibility(4);
          }
        }
        j += 1;
      }
      break;
    }
  }
  
  private void optimizeAndExecuteOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    int n;
    int k;
    do
    {
      return;
      if ((paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size())) {
        throw new IllegalStateException("Internal error with the back stack records");
      }
      executePostponedTransaction(paramArrayList, paramArrayList1);
      n = paramArrayList.size();
      k = 0;
      int i = 0;
      if (i < n)
      {
        int m = i;
        int j = k;
        if (!getmAllowOptimization)
        {
          if (k != i) {
            executeOpsTogether(paramArrayList, paramArrayList1, k, i);
          }
          j = i + 1;
        }
        for (;;)
        {
          if ((j >= n) || (getmAllowOptimization))
          {
            executeOpsTogether(paramArrayList, paramArrayList1, i, j);
            i = j;
            m = j - 1;
            j = i;
            i = m + 1;
            k = j;
            break;
          }
          j += 1;
        }
      }
    } while (k == n);
    executeOpsTogether(paramArrayList, paramArrayList1, k, n);
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions();
    ensureExecReady(true);
    boolean bool = popBackStackState(mTmpRecords, mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      mExecutingActions = true;
    }
    try
    {
      optimizeAndExecuteOps(mTmpRecords, mTmpIsPop);
      cleanupExec();
      doPendingDeferredStart();
      return bool;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  private int postponePostponableTransactions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    int j = paramInt2;
    int i = paramInt2 - 1;
    if (i >= paramInt1)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(i);
      boolean bool = ((Boolean)paramArrayList1.get(i)).booleanValue();
      int m;
      label67:
      int k;
      if ((localBackStackRecord.isPostponed()) && (!localBackStackRecord.interactsWith(paramArrayList, i + 1, paramInt2)))
      {
        m = 1;
        k = j;
        if (m != 0)
        {
          if (mPostponedTransactions == null) {
            mPostponedTransactions = new ArrayList();
          }
          StartEnterTransitionListener localStartEnterTransitionListener = new StartEnterTransitionListener(localBackStackRecord, bool);
          mPostponedTransactions.add(localStartEnterTransitionListener);
          localBackStackRecord.setOnStartPostponedListener(localStartEnterTransitionListener);
          if (!bool) {
            break label185;
          }
          localBackStackRecord.executeOps();
        }
      }
      for (;;)
      {
        k = j - 1;
        if (i != k)
        {
          paramArrayList.remove(i);
          paramArrayList.add(k, localBackStackRecord);
        }
        moveFragmentsToInvisible();
        i -= 1;
        j = k;
        break;
        m = 0;
        break label67;
        label185:
        localBackStackRecord.executePopOps();
      }
    }
    return j;
  }
  
  public static int reverseTransit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void scheduleCommit()
  {
    int j = 1;
    label44:
    label73:
    label92:
    label97:
    label100:
    for (;;)
    {
      int i;
      try
      {
        if ((mPostponedTransactions == null) || (mPostponedTransactions.isEmpty())) {
          break label92;
        }
        i = 1;
        if ((mPendingActions == null) || (mPendingActions.size() != 1)) {
          break label97;
        }
      }
      finally {}
      mHost.getHandler().removeCallbacks(mExecCommit);
      mHost.getHandler().post(mExecCommit);
      return;
      for (;;)
      {
        if (i != 0) {
          break label100;
        }
        if (j == 0) {
          break label73;
        }
        break label44;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  private void setHWLayerAnimListenerIfAlpha(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null)) {}
    while (!shouldRunOnHWLayer(paramView, paramAnimation)) {
      return;
    }
    Object localObject = null;
    try
    {
      if (sAnimationListenerField == null)
      {
        sAnimationListenerField = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField.setAccessible(true);
      }
      Animation.AnimationListener localAnimationListener = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
      localObject = localAnimationListener;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.e("FragmentManager", "No field with the name mListener is found in Animation class", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("FragmentManager", "Cannot access Animation's mListener field", localIllegalAccessException);
      }
    }
    ViewCompat.setLayerType(paramView, 2, null);
    paramAnimation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(paramView, paramAnimation, localObject));
  }
  
  static boolean shouldRunOnHWLayer(View paramView, Animation paramAnimation)
  {
    return (Build.VERSION.SDK_INT >= 19) && (ViewCompat.getLayerType(paramView) == 0) && (ViewCompat.hasOverlappingRendering(paramView)) && (modifiesAlpha(paramAnimation));
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (mHost != null) {}
    for (;;)
    {
      try
      {
        mHost.onDump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 8194: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    }
    if (paramBoolean) {
      return 5;
    }
    return 6;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (mBackStack == null) {
      mBackStack = new ArrayList();
    }
    mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (mAdded == null) {
      mAdded = new ArrayList();
    }
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    makeActive(paramFragment);
    if (!mDetached)
    {
      if (mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      mAdded.add(paramFragment);
      mAdded = true;
      mRemoving = false;
      if (mView == null) {
        mHiddenChanged = false;
      }
      if ((mHasMenu) && (mMenuVisible)) {
        mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (mBackStackChangeListeners == null) {
      mBackStackChangeListeners = new ArrayList();
    }
    mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      if ((mAvailBackStackIndices == null) || (mAvailBackStackIndices.size() <= 0))
      {
        if (mBackStackIndices == null) {
          mBackStackIndices = new ArrayList();
        }
        i = mBackStackIndices.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + paramBackStackRecord);
        }
        mBackStackIndices.add(paramBackStackRecord);
        return i;
      }
      int i = ((Integer)mAvailBackStackIndices.remove(mAvailBackStackIndices.size() - 1)).intValue();
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + i + " with " + paramBackStackRecord);
      }
      mBackStackIndices.set(i, paramBackStackRecord);
      return i;
    }
    finally {}
  }
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    mHost = paramFragmentHostCallback;
    mContainer = paramFragmentContainer;
    mParent = paramFragment;
  }
  
  public void attachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (mDetached)
    {
      mDetached = false;
      if (!mAdded)
      {
        if (mAdded == null) {
          mAdded = new ArrayList();
        }
        if (mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
        mAdded.add(paramFragment);
        mAdded = true;
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
      }
    }
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  void completeShowHideFragment(Fragment paramFragment)
  {
    boolean bool;
    if (mView != null)
    {
      i = paramFragment.getNextTransition();
      if (mHidden) {
        break label150;
      }
      bool = true;
      Animation localAnimation = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if (localAnimation != null)
      {
        setHWLayerAnimListenerIfAlpha(mView, localAnimation);
        mView.startAnimation(localAnimation);
        setHWLayerAnimListenerIfAlpha(mView, localAnimation);
        localAnimation.start();
      }
      if ((!mHidden) || (paramFragment.isHideReplaced())) {
        break label155;
      }
    }
    label150:
    label155:
    for (int i = 8;; i = 0)
    {
      mView.setVisibility(i);
      if (paramFragment.isHideReplaced()) {
        paramFragment.setHideReplaced(false);
      }
      if ((mAdded) && (mHasMenu) && (mMenuVisible)) {
        mNeedMenuInvalidate = true;
      }
      mHiddenChanged = false;
      paramFragment.onHiddenChanged(mHidden);
      return;
      bool = false;
      break;
    }
  }
  
  public void detachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!mDetached)
    {
      mDetached = true;
      if (mAdded)
      {
        if (mAdded != null)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          mAdded.remove(paramFragment);
        }
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
        mAdded = false;
      }
    }
  }
  
  public void dispatchActivityCreated()
  {
    mStateSaved = false;
    moveToState(2, false);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performConfigurationChanged(paramConfiguration);
        }
        i += 1;
      }
    }
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void dispatchCreate()
  {
    mStateSaved = false;
    moveToState(1, false);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (mAdded != null)
    {
      i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (i >= mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)mAdded.get(i);
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
        i += 1;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    if (mCreatedMenus != null)
    {
      i = 0;
      while (i < mCreatedMenus.size())
      {
        paramMenu = (Fragment)mCreatedMenus.get(i);
        if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    mCreatedMenus = ((ArrayList)localObject2);
    return bool2;
  }
  
  public void dispatchDestroy()
  {
    mDestroyed = true;
    execPendingActions();
    moveToState(0, false);
    mHost = null;
    mContainer = null;
    mParent = null;
  }
  
  public void dispatchDestroyView()
  {
    moveToState(1, false);
  }
  
  public void dispatchLowMemory()
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performLowMemory();
        }
        i += 1;
      }
    }
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    if (mAdded == null) {}
    for (;;)
    {
      return;
      int i = mAdded.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performMultiWindowModeChanged(paramBoolean);
        }
        i -= 1;
      }
    }
  }
  
  void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentActivityCreated(this, paramFragment, paramBundle);
        }
      }
    }
  }
  
  void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentAttached(paramFragment, paramContext, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentAttached(this, paramFragment, paramContext);
        }
      }
    }
  }
  
  void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentCreated(paramFragment, paramBundle, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentCreated(this, paramFragment, paramBundle);
        }
      }
    }
  }
  
  void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDestroyed(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentDestroyed(this, paramFragment);
        }
      }
    }
  }
  
  void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDetached(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentDetached(this, paramFragment);
        }
      }
    }
  }
  
  void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPaused(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentPaused(this, paramFragment);
        }
      }
    }
  }
  
  void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreAttached(paramFragment, paramContext, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentPreAttached(this, paramFragment, paramContext);
        }
      }
    }
  }
  
  void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentResumed(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentResumed(this, paramFragment);
        }
      }
    }
  }
  
  void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentSaveInstanceState(this, paramFragment, paramBundle);
        }
      }
    }
  }
  
  void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStarted(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentStarted(this, paramFragment);
        }
      }
    }
  }
  
  void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStopped(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentStopped(this, paramFragment);
        }
      }
    }
  }
  
  void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentViewCreated(this, paramFragment, paramView, paramBundle);
        }
      }
    }
  }
  
  void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewDestroyed(paramFragment, true);
      }
    }
    if (mLifecycleCallbacks == null) {}
    for (;;)
    {
      return;
      localObject = mLifecycleCallbacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((!paramBoolean) || (((Boolean)second).booleanValue())) {
          ((FragmentManager.FragmentLifecycleCallbacks)first).onFragmentViewDestroyed(this, paramFragment);
        }
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (mAdded != null)
    {
      int i = 0;
      while (i < mAdded.size())
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public void dispatchPause()
  {
    moveToState(4, false);
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    if (mAdded == null) {}
    for (;;)
    {
      return;
      int i = mAdded.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)mAdded.get(i);
        if (localFragment != null) {
          localFragment.performPictureInPictureModeChanged(paramBoolean);
        }
        i -= 1;
      }
    }
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (mAdded != null)
    {
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)mAdded.get(i);
        bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (localFragment.performPrepareOptionsMenu(paramMenu)) {
            bool2 = true;
          }
        }
        i += 1;
        bool1 = bool2;
      }
    }
    return bool2;
  }
  
  public void dispatchReallyStop()
  {
    moveToState(2, false);
  }
  
  public void dispatchResume()
  {
    mStateSaved = false;
    moveToState(5, false);
  }
  
  public void dispatchStart()
  {
    mStateSaved = false;
    moveToState(4, false);
  }
  
  public void dispatchStop()
  {
    mStateSaved = true;
    moveToState(3, false);
  }
  
  void doPendingDeferredStart()
  {
    if (mHavePendingDeferredStart)
    {
      boolean bool1 = false;
      int i = 0;
      while (i < mActive.size())
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        boolean bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (mLoaderManager != null) {
            bool2 = bool1 | mLoaderManager.hasRunningLoaders();
          }
        }
        i += 1;
        bool1 = bool2;
      }
      if (!bool1)
      {
        mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString + "    ";
    int j;
    int i;
    Object localObject;
    if (mActive != null)
    {
      j = mActive.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < j)
        {
          localObject = (Fragment)mActive.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject);
          if (localObject != null) {
            ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    if (mAdded != null)
    {
      j = mAdded.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i = 0;
        while (i < j)
        {
          localObject = (Fragment)mAdded.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i += 1;
        }
      }
    }
    if (mCreatedMenus != null)
    {
      j = mCreatedMenus.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < j)
        {
          localObject = (Fragment)mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
          i += 1;
        }
      }
    }
    if (mBackStack != null)
    {
      j = mBackStack.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < j)
        {
          localObject = (BackStackRecord)mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((BackStackRecord)localObject).toString());
          ((BackStackRecord)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    try
    {
      if (mBackStackIndices != null)
      {
        j = mBackStackIndices.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < j)
          {
            paramFileDescriptor = (BackStackRecord)mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((mAvailBackStackIndices != null) && (mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(mAvailBackStackIndices.toArray()));
      }
      if (mPendingActions != null)
      {
        j = mPendingActions.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = 0;
          while (i < j)
          {
            paramFileDescriptor = (OpGenerator)mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(mHost);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(mContainer);
    if (mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(mStateSaved);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(mDestroyed);
    if (mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(mNeedMenuInvalidate);
    }
    if (mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(mNoTransactionsBecause);
    }
    if ((mAvailIndices != null) && (mAvailIndices.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(mAvailIndices.toArray()));
    }
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((mDestroyed) || (mHost == null)) {
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally
    {
      throw paramOpGenerator;
      if (mPendingActions == null) {
        mPendingActions = new ArrayList();
      }
      mPendingActions.add(paramOpGenerator);
    }
  }
  
  public boolean execPendingActions()
  {
    ensureExecReady(true);
    boolean bool = false;
    for (;;)
    {
      if (generateOpsForPendingActions(mTmpRecords, mTmpIsPop)) {
        mExecutingActions = true;
      }
      try
      {
        optimizeAndExecuteOps(mTmpRecords, mTmpIsPop);
        cleanupExec();
        bool = true;
      }
      finally
      {
        cleanupExec();
      }
    }
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(mTmpRecords, mTmpIsPop)) {
      mExecutingActions = true;
    }
    try
    {
      optimizeAndExecuteOps(mTmpRecords, mTmpIsPop);
      cleanupExec();
      doPendingDeferredStart();
      return;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  public boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    int i;
    Object localObject;
    if (mAdded != null)
    {
      i = mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mAdded.get(i);
        if ((localObject != null) && (mFragmentId == paramInt)) {
          return localObject;
        }
        i -= 1;
      }
    }
    if (mActive != null)
    {
      i = mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label112;
        }
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (mFragmentId == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label112:
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    int i;
    Object localObject;
    if ((mAdded != null) && (paramString != null))
    {
      i = mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)mAdded.get(i);
        if ((localObject != null) && (paramString.equals(mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((mActive != null) && (paramString != null))
    {
      i = mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label126;
        }
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label126:
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    if ((mActive != null) && (paramString != null))
    {
      int i = mActive.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      mBackStackIndices.set(paramInt, null);
      if (mAvailBackStackIndices == null) {
        mAvailBackStackIndices = new ArrayList();
      }
      if (DEBUG) {
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      }
      mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    if (mBackStack != null) {
      return mBackStack.size();
    }
    return 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i >= mActive.size()) {
        throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)mActive.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public List<Fragment> getFragments()
  {
    return mActive;
  }
  
  LayoutInflaterFactory getLayoutInflaterFactory()
  {
    return this;
  }
  
  public void hideFragment(Fragment paramFragment)
  {
    boolean bool = true;
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!mHidden)
    {
      mHidden = true;
      if (mHiddenChanged) {
        break label59;
      }
    }
    for (;;)
    {
      mHiddenChanged = bool;
      return;
      label59:
      bool = false;
    }
  }
  
  public boolean isDestroyed()
  {
    return mDestroyed;
  }
  
  boolean isStateAtLeast(int paramInt)
  {
    return mCurState >= paramInt;
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.getNextAnim());
    if (localAnimation != null) {
      return localAnimation;
    }
    if (paramFragment.getNextAnim() != 0)
    {
      paramFragment = AnimationUtils.loadAnimation(mHost.getContext(), paramFragment.getNextAnim());
      if (paramFragment != null) {
        return paramFragment;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (mHost.onHasWindowAnimations()) {
          paramInt1 = mHost.onGetWindowAnimations();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return makeOpenCloseAnimation(mHost.getContext(), 1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return makeOpenCloseAnimation(mHost.getContext(), 1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return makeOpenCloseAnimation(mHost.getContext(), 0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return makeOpenCloseAnimation(mHost.getContext(), 1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return makeFadeAnimation(mHost.getContext(), 0.0F, 1.0F);
    case 6: 
      return makeFadeAnimation(mHost.getContext(), 1.0F, 0.0F);
    }
    return null;
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (mIndex >= 0) {}
    for (;;)
    {
      return;
      if ((mAvailIndices == null) || (mAvailIndices.size() <= 0))
      {
        if (mActive == null) {
          mActive = new ArrayList();
        }
        paramFragment.setIndex(mActive.size(), mParent);
        mActive.add(paramFragment);
      }
      while (DEBUG)
      {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        return;
        paramFragment.setIndex(((Integer)mAvailIndices.remove(mAvailIndices.size() - 1)).intValue(), mParent);
        mActive.set(mIndex, paramFragment);
      }
    }
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (mIndex < 0) {
      return;
    }
    if (DEBUG) {
      Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
    }
    mActive.set(mIndex, null);
    if (mAvailIndices == null) {
      mAvailIndices = new ArrayList();
    }
    mAvailIndices.add(Integer.valueOf(mIndex));
    mHost.inactivateFragment(mWho);
    paramFragment.initState();
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    int j = mCurState;
    int i = j;
    if (mRemoving) {
      if (!paramFragment.isInBackStack()) {
        break label198;
      }
    }
    label198:
    for (i = Math.min(j, 1);; i = Math.min(j, 0))
    {
      moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
      if (mView != null)
      {
        Object localObject = findFragmentUnder(paramFragment);
        if (localObject != null)
        {
          localObject = mView;
          ViewGroup localViewGroup = mContainer;
          i = localViewGroup.indexOfChild((View)localObject);
          j = localViewGroup.indexOfChild(mView);
          if (j < i)
          {
            localViewGroup.removeViewAt(j);
            localViewGroup.addView(mView, i);
          }
        }
        if ((mIsNewlyAdded) && (mContainer != null))
        {
          mView.setVisibility(0);
          mIsNewlyAdded = false;
          localObject = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
          if (localObject != null)
          {
            setHWLayerAnimListenerIfAlpha(mView, (Animation)localObject);
            mView.startAnimation((Animation)localObject);
          }
        }
      }
      if (!mHiddenChanged) {
        break;
      }
      completeShowHideFragment(paramFragment);
      return;
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((mHost == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == mCurState)) {}
    do
    {
      do
      {
        return;
        mCurState = paramInt;
      } while (mActive == null);
      paramInt = 0;
      int i = 0;
      Fragment localFragment;
      if (mAdded != null)
      {
        m = mAdded.size();
        j = 0;
        for (;;)
        {
          paramInt = i;
          if (j >= m) {
            break;
          }
          localFragment = (Fragment)mAdded.get(j);
          moveFragmentToExpectedState(localFragment);
          paramInt = i;
          if (mLoaderManager != null) {
            paramInt = i | mLoaderManager.hasRunningLoaders();
          }
          j += 1;
          i = paramInt;
        }
      }
      int m = mActive.size();
      int j = 0;
      i = paramInt;
      paramInt = j;
      while (paramInt < m)
      {
        localFragment = (Fragment)mActive.get(paramInt);
        j = i;
        int k;
        if (localFragment != null) {
          if (!mRemoving)
          {
            j = i;
            if (!mDetached) {}
          }
          else
          {
            j = i;
            if (!mIsNewlyAdded)
            {
              moveFragmentToExpectedState(localFragment);
              j = i;
              if (mLoaderManager != null) {
                k = i | mLoaderManager.hasRunningLoaders();
              }
            }
          }
        }
        paramInt += 1;
        i = k;
      }
      if (i == 0) {
        startPendingDeferredFragments();
      }
    } while ((!mNeedMenuInvalidate) || (mHost == null) || (mCurState != 5));
    mHost.onSupportInvalidateOptionsMenu();
    mNeedMenuInvalidate = false;
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, mCurState, 0, 0, false);
  }
  
  void moveToState(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    if (mAdded)
    {
      i = paramInt1;
      if (!mDetached) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    int j = i;
    if (mRemoving)
    {
      j = i;
      if (i > mState) {
        j = mState;
      }
    }
    paramInt1 = j;
    if (mDeferStart)
    {
      paramInt1 = j;
      if (mState < 4)
      {
        paramInt1 = j;
        if (j > 3) {
          paramInt1 = 3;
        }
      }
    }
    if (mState < paramInt1)
    {
      if ((mFromLayout) && (!mInLayout)) {
        return;
      }
      if (paramFragment.getAnimatingAway() != null)
      {
        paramFragment.setAnimatingAway(null);
        moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
      }
      paramInt2 = paramInt1;
      i = paramInt1;
      j = paramInt1;
      paramInt3 = paramInt1;
      switch (mState)
      {
      default: 
        i = paramInt1;
      }
    }
    while (mState != i)
    {
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; " + "expected state " + i + " found " + mState);
      mState = i;
      return;
      if (DEBUG) {
        Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
      }
      paramInt3 = paramInt1;
      if (mSavedFragmentState != null)
      {
        mSavedFragmentState.setClassLoader(mHost.getContext().getClassLoader());
        mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
        mTarget = getFragment(mSavedFragmentState, "android:target_state");
        if (mTarget != null) {
          mTargetRequestCode = mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        mUserVisibleHint = mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        paramInt3 = paramInt1;
        if (!mUserVisibleHint)
        {
          mDeferStart = true;
          paramInt3 = paramInt1;
          if (paramInt1 > 3) {
            paramInt3 = 3;
          }
        }
      }
      mHost = mHost;
      mParentFragment = mParent;
      if (mParent != null) {}
      for (Object localObject1 = mParent.mChildFragmentManager;; localObject1 = mHost.getFragmentManagerImpl())
      {
        mFragmentManager = ((FragmentManagerImpl)localObject1);
        dispatchOnFragmentPreAttached(paramFragment, mHost.getContext(), false);
        mCalled = false;
        paramFragment.onAttach(mHost.getContext());
        if (mCalled) {
          break;
        }
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      label545:
      label583:
      label650:
      ViewGroup localViewGroup;
      if (mParentFragment == null)
      {
        mHost.onAttachFragment(paramFragment);
        dispatchOnFragmentAttached(paramFragment, mHost.getContext(), false);
        if (mRetaining) {
          break label1229;
        }
        paramFragment.performCreate(mSavedFragmentState);
        dispatchOnFragmentCreated(paramFragment, mSavedFragmentState, false);
        mRetaining = false;
        paramInt2 = paramInt3;
        if (mFromLayout)
        {
          mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(mSavedFragmentState), null, mSavedFragmentState);
          if (mView == null) {
            break label1259;
          }
          mInnerView = mView;
          if (Build.VERSION.SDK_INT < 11) {
            break label1245;
          }
          ViewCompat.setSaveFromParentEnabled(mView, false);
          if (mHidden) {
            mView.setVisibility(8);
          }
          paramFragment.onViewCreated(mView, mSavedFragmentState);
          dispatchOnFragmentViewCreated(paramFragment, mView, mSavedFragmentState, false);
          paramInt2 = paramInt3;
        }
        i = paramInt2;
        if (paramInt2 > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!mFromLayout)
          {
            localObject1 = null;
            if (mContainerId != 0)
            {
              if (mContainerId == -1) {
                throwException(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
              }
              localViewGroup = (ViewGroup)mContainer.onFindViewById(mContainerId);
              localObject1 = localViewGroup;
              if (localViewGroup == null)
              {
                localObject1 = localViewGroup;
                if (mRestored) {}
              }
            }
          }
        }
      }
      label1229:
      label1245:
      label1259:
      Object localObject2;
      try
      {
        localObject1 = paramFragment.getResources().getResourceName(mContainerId);
        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(mContainerId) + " (" + (String)localObject1 + ") for fragment " + paramFragment));
        localObject1 = localViewGroup;
        mContainer = ((ViewGroup)localObject1);
        mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(mSavedFragmentState), (ViewGroup)localObject1, mSavedFragmentState);
        if (mView != null)
        {
          mInnerView = mView;
          if (Build.VERSION.SDK_INT >= 11)
          {
            ViewCompat.setSaveFromParentEnabled(mView, false);
            if (localObject1 != null)
            {
              ((ViewGroup)localObject1).addView(mView);
              mIsNewlyAdded = true;
            }
            if (mHidden)
            {
              mView.setVisibility(8);
              mIsNewlyAdded = false;
            }
            paramFragment.onViewCreated(mView, mSavedFragmentState);
            dispatchOnFragmentViewCreated(paramFragment, mView, mSavedFragmentState, false);
            paramFragment.performActivityCreated(mSavedFragmentState);
            dispatchOnFragmentActivityCreated(paramFragment, mSavedFragmentState, false);
            if (mView != null) {
              paramFragment.restoreViewState(mSavedFragmentState);
            }
            mSavedFragmentState = null;
            i = paramInt2;
            j = i;
            if (i > 2)
            {
              mState = 3;
              j = i;
            }
            paramInt3 = j;
            if (j > 3)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
              }
              paramFragment.performStart();
              dispatchOnFragmentStarted(paramFragment, false);
              paramInt3 = j;
            }
            i = paramInt3;
            if (paramInt3 <= 4) {
              continue;
            }
            if (DEBUG) {
              Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
            }
            paramFragment.performResume();
            dispatchOnFragmentResumed(paramFragment, false);
            mSavedFragmentState = null;
            mSavedViewState = null;
            i = paramInt3;
            continue;
            mParentFragment.onAttachFragment(paramFragment);
            break label545;
            paramFragment.restoreChildFragmentState(mSavedFragmentState);
            mState = 1;
            break label583;
            mView = NoSaveStateFrameLayout.wrap(mView);
            break label650;
            mInnerView = null;
            paramInt2 = paramInt3;
          }
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          localObject2 = "unknown";
          continue;
          mView = NoSaveStateFrameLayout.wrap(mView);
          continue;
          mInnerView = null;
        }
      }
      i = paramInt1;
      if (mState > paramInt1) {
        switch (mState)
        {
        default: 
          i = paramInt1;
          break;
        case 1: 
        case 5: 
        case 4: 
        case 3: 
        case 2: 
          for (;;)
          {
            i = paramInt1;
            if (paramInt1 >= 1) {
              break;
            }
            if ((mDestroyed) && (paramFragment.getAnimatingAway() != null))
            {
              localObject2 = paramFragment.getAnimatingAway();
              paramFragment.setAnimatingAway(null);
              ((View)localObject2).clearAnimation();
            }
            if (paramFragment.getAnimatingAway() == null) {
              break label1766;
            }
            paramFragment.setStateAfterAnimating(paramInt1);
            i = 1;
            break;
            if (paramInt1 < 5)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
              }
              paramFragment.performPause();
              dispatchOnFragmentPaused(paramFragment, false);
            }
            if (paramInt1 < 4)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
              }
              paramFragment.performStop();
              dispatchOnFragmentStopped(paramFragment, false);
            }
            if (paramInt1 < 3)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
              }
              paramFragment.performReallyStop();
            }
            if (paramInt1 < 2)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
              }
              if ((mView != null) && (mHost.onShouldSaveFragmentState(paramFragment)) && (mSavedViewState == null)) {
                saveFragmentViewState(paramFragment);
              }
              paramFragment.performDestroyView();
              dispatchOnFragmentViewDestroyed(paramFragment, false);
              if ((mView != null) && (mContainer != null))
              {
                localViewGroup = null;
                localObject2 = localViewGroup;
                if (mCurState > 0)
                {
                  localObject2 = localViewGroup;
                  if (!mDestroyed)
                  {
                    localObject2 = localViewGroup;
                    if (mView.getVisibility() == 0) {
                      localObject2 = loadAnimation(paramFragment, paramInt2, false, paramInt3);
                    }
                  }
                }
                if (localObject2 != null)
                {
                  paramFragment.setAnimatingAway(mView);
                  paramFragment.setStateAfterAnimating(paramInt1);
                  ((Animation)localObject2).setAnimationListener(new AnimateOnHWLayerIfNeededListener(mView, (Animation)localObject2)
                  {
                    public void onAnimationEnd(Animation paramAnonymousAnimation)
                    {
                      super.onAnimationEnd(paramAnonymousAnimation);
                      if (paramFragment.getAnimatingAway() != null)
                      {
                        paramFragment.setAnimatingAway(null);
                        moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, false);
                      }
                    }
                  });
                  mView.startAnimation((Animation)localObject2);
                }
                mContainer.removeView(mView);
              }
              mContainer = null;
              mView = null;
              mInnerView = null;
            }
          }
          label1766:
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!mRetaining)
          {
            paramFragment.performDestroy();
            dispatchOnFragmentDestroyed(paramFragment, false);
          }
          for (;;)
          {
            paramFragment.performDetach();
            dispatchOnFragmentDetached(paramFragment, false);
            i = paramInt1;
            if (paramBoolean) {
              break;
            }
            if (mRetaining) {
              break label1859;
            }
            makeInactive(paramFragment);
            i = paramInt1;
            break;
            mState = 0;
          }
          label1859:
          mHost = null;
          mParentFragment = null;
          mFragmentManager = null;
          i = paramInt1;
        }
      }
    }
  }
  
  public void noteStateNotSaved()
  {
    mStateSaved = false;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {}
    String str1;
    int k;
    String str2;
    do
    {
      return null;
      paramString = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
      str1 = paramString;
      if (paramString == null) {
        str1 = localTypedArray.getString(0);
      }
      k = localTypedArray.getResourceId(1, -1);
      str2 = localTypedArray.getString(2);
      localTypedArray.recycle();
    } while (!Fragment.isSupportFragmentClass(mHost.getContext(), str1));
    if (paramView != null) {}
    for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
      throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
    }
    int j;
    if (k != -1)
    {
      paramString = findFragmentById(k);
      paramView = paramString;
      if (paramString == null)
      {
        paramView = paramString;
        if (str2 != null) {
          paramView = findFragmentByTag(str2);
        }
      }
      paramString = paramView;
      if (paramView == null)
      {
        paramString = paramView;
        if (i != -1) {
          paramString = findFragmentById(i);
        }
      }
      if (DEBUG) {
        Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(k) + " fname=" + str1 + " existing=" + paramString);
      }
      if (paramString != null) {
        break label432;
      }
      paramView = Fragment.instantiate(paramContext, str1);
      mFromLayout = true;
      if (k == 0) {
        break label425;
      }
      j = k;
      label295:
      mFragmentId = j;
      mContainerId = i;
      mTag = str2;
      mInLayout = true;
      mFragmentManager = this;
      mHost = mHost;
      paramView.onInflate(mHost.getContext(), paramAttributeSet, mSavedFragmentState);
      addFragment(paramView, true);
      label354:
      if ((mCurState >= 1) || (!mFromLayout)) {
        break label561;
      }
      moveToState(paramView, 1, 0, 0, false);
    }
    for (;;)
    {
      if (mView != null) {
        break label569;
      }
      throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
      paramString = null;
      break;
      label425:
      j = i;
      break label295;
      label432:
      if (mInLayout) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
      }
      mInLayout = true;
      mHost = mHost;
      paramView = paramString;
      if (mRetaining) {
        break label354;
      }
      paramString.onInflate(mHost.getContext(), paramAttributeSet, mSavedFragmentState);
      paramView = paramString;
      break label354;
      label561:
      moveToState(paramView);
    }
    label569:
    if (k != 0) {
      mView.setId(k);
    }
    if (mView.getTag() == null) {
      mView.setTag(str2);
    }
    return mView;
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (mDeferStart)
    {
      if (mExecutingActions) {
        mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    mDeferStart = false;
    moveToState(paramFragment, mCurState, 0, 0, false);
  }
  
  public void popBackStack()
  {
    enqueueAction(new PopBackStackState(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new PopBackStackState(null, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new PopBackStackState(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    if (mBackStack == null) {
      break label124;
    }
    label7:
    do
    {
      return false;
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
        break;
      }
      paramInt1 = mBackStack.size() - 1;
    } while (paramInt1 < 0);
    paramArrayList.add(mBackStack.remove(paramInt1));
    paramArrayList1.add(Boolean.valueOf(true));
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = mBackStack.size() - 1;
        for (;;)
        {
          BackStackRecord localBackStackRecord;
          if (j >= 0)
          {
            localBackStackRecord = (BackStackRecord)mBackStack.get(j);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord.getName()))) {}
          }
          else
          {
            label124:
            if (j < 0) {
              break label7;
            }
            i = j;
            if ((paramInt2 & 0x1) == 0) {
              break label241;
            }
            paramInt2 = j - 1;
            for (;;)
            {
              i = paramInt2;
              if (paramInt2 < 0) {
                break;
              }
              localBackStackRecord = (BackStackRecord)mBackStack.get(paramInt2);
              if ((paramString == null) || (!paramString.equals(localBackStackRecord.getName())))
              {
                i = paramInt2;
                if (paramInt1 < 0) {
                  break;
                }
                i = paramInt2;
                if (paramInt1 != mIndex) {
                  break;
                }
              }
              paramInt2 -= 1;
            }
          }
          if ((paramInt1 >= 0) && (paramInt1 == mIndex)) {
            break;
          }
          j -= 1;
        }
      }
      label241:
      if (i == mBackStack.size() - 1) {
        break label7;
      }
      paramInt1 = mBackStack.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(mBackStack.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
        paramInt1 -= 1;
      }
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, mIndex);
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
  {
    if (mLifecycleCallbacks == null) {
      mLifecycleCallbacks = new CopyOnWriteArrayList();
    }
    mLifecycleCallbacks.add(new Pair(paramFragmentLifecycleCallbacks, Boolean.valueOf(paramBoolean)));
  }
  
  public void removeFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + mBackStackNesting);
    }
    if (!paramFragment.isInBackStack()) {}
    for (int i = 1;; i = 0)
    {
      if ((!mDetached) || (i != 0))
      {
        if (mAdded != null) {
          mAdded.remove(paramFragment);
        }
        if ((mHasMenu) && (mMenuVisible)) {
          mNeedMenuInvalidate = true;
        }
        mAdded = false;
        mRemoving = true;
      }
      return;
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (mBackStackChangeListeners != null) {
      mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void reportBackStackChanged()
  {
    if (mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < mBackStackChangeListeners.size())
      {
        ((FragmentManager.OnBackStackChangedListener)mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (mActive != null)
      {
        paramParcelable = null;
        List localList;
        Object localObject;
        int j;
        FragmentState localFragmentState;
        if (paramFragmentManagerNonConfig != null)
        {
          localList = paramFragmentManagerNonConfig.getFragments();
          localObject = paramFragmentManagerNonConfig.getChildNonConfigs();
          if (localList != null) {}
          for (i = localList.size();; i = 0)
          {
            j = 0;
            for (;;)
            {
              paramParcelable = (Parcelable)localObject;
              if (j >= i) {
                break;
              }
              paramParcelable = (Fragment)localList.get(j);
              if (DEBUG) {
                Log.v("FragmentManager", "restoreAllState: re-attaching retained " + paramParcelable);
              }
              localFragmentState = mActive[mIndex];
              mInstance = paramParcelable;
              mSavedViewState = null;
              mBackStackNesting = 0;
              mInLayout = false;
              mAdded = false;
              mTarget = null;
              if (mSavedFragmentState != null)
              {
                mSavedFragmentState.setClassLoader(mHost.getContext().getClassLoader());
                mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
                mSavedFragmentState = mSavedFragmentState;
              }
              j += 1;
            }
          }
        }
        mActive = new ArrayList(mActive.length);
        if (mAvailIndices != null) {
          mAvailIndices.clear();
        }
        int i = 0;
        if (i < mActive.length)
        {
          localFragmentState = mActive[i];
          if (localFragmentState != null)
          {
            localList = null;
            localObject = localList;
            if (paramParcelable != null)
            {
              localObject = localList;
              if (i < paramParcelable.size()) {
                localObject = (FragmentManagerNonConfig)paramParcelable.get(i);
              }
            }
            localObject = localFragmentState.instantiate(mHost, mParent, (FragmentManagerNonConfig)localObject);
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject);
            }
            mActive.add(localObject);
            mInstance = null;
          }
          for (;;)
          {
            i += 1;
            break;
            mActive.add(null);
            if (mAvailIndices == null) {
              mAvailIndices = new ArrayList();
            }
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: avail #" + i);
            }
            mAvailIndices.add(Integer.valueOf(i));
          }
        }
        if (paramFragmentManagerNonConfig != null)
        {
          paramParcelable = paramFragmentManagerNonConfig.getFragments();
          if (paramParcelable != null)
          {
            i = paramParcelable.size();
            j = 0;
            label487:
            if (j >= i) {
              break label605;
            }
            paramFragmentManagerNonConfig = (Fragment)paramParcelable.get(j);
            if (mTargetIndex >= 0) {
              if (mTargetIndex >= mActive.size()) {
                break label558;
              }
            }
          }
          for (mTarget = ((Fragment)mActive.get(mTargetIndex));; mTarget = null)
          {
            j += 1;
            break label487;
            i = 0;
            break;
            label558:
            Log.w("FragmentManager", "Re-attaching retained fragment " + paramFragmentManagerNonConfig + " target no longer exists: " + mTargetIndex);
          }
        }
        label605:
        if (mAdded != null)
        {
          mAdded = new ArrayList(mAdded.length);
          i = 0;
          while (i < mAdded.length)
          {
            paramParcelable = (Fragment)mActive.get(mAdded[i]);
            if (paramParcelable == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + mAdded[i]));
            }
            mAdded = true;
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramParcelable);
            }
            if (mAdded.contains(paramParcelable)) {
              throw new IllegalStateException("Already added!");
            }
            mAdded.add(paramParcelable);
            i += 1;
          }
        }
        mAdded = null;
        if (mBackStack == null) {
          break;
        }
        mBackStack = new ArrayList(mBackStack.length);
        i = 0;
        while (i < mBackStack.length)
        {
          paramParcelable = mBackStack[i].instantiate(this);
          if (DEBUG)
          {
            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + mIndex + "): " + paramParcelable);
            paramParcelable.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
          }
          mBackStack.add(paramParcelable);
          if (mIndex >= 0) {
            setBackStackIndex(mIndex, paramParcelable);
          }
          i += 1;
        }
      }
    }
    mBackStack = null;
  }
  
  FragmentManagerNonConfig retainNonConfig()
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (mActive != null)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (i >= mActive.size()) {
          break;
        }
        Fragment localFragment = (Fragment)mActive.get(i);
        localObject4 = localObject1;
        Object localObject5 = localObject2;
        if (localFragment != null)
        {
          localObject3 = localObject2;
          if (mRetainInstance)
          {
            localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((ArrayList)localObject4).add(localFragment);
            mRetaining = true;
            if (mTarget == null) {
              break label254;
            }
          }
          label254:
          for (int j = mTarget.mIndex;; j = -1)
          {
            mTargetIndex = j;
            localObject3 = localObject4;
            if (DEBUG)
            {
              Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
              localObject3 = localObject4;
            }
            int k = 0;
            j = k;
            localObject2 = localObject1;
            if (mChildFragmentManager == null) {
              break label269;
            }
            localObject4 = mChildFragmentManager.retainNonConfig();
            j = k;
            localObject2 = localObject1;
            if (localObject4 == null) {
              break label269;
            }
            localObject2 = localObject1;
            if (localObject1 != null) {
              break;
            }
            localObject1 = new ArrayList();
            j = 0;
            for (;;)
            {
              localObject2 = localObject1;
              if (j >= i) {
                break;
              }
              ((ArrayList)localObject1).add(null);
              j += 1;
            }
          }
          localObject2.add(localObject4);
          j = 1;
          label269:
          localObject4 = localObject2;
          localObject5 = localObject3;
          if (localObject2 != null)
          {
            localObject4 = localObject2;
            localObject5 = localObject3;
            if (j == 0)
            {
              localObject2.add(null);
              localObject5 = localObject3;
              localObject4 = localObject2;
            }
          }
        }
        i += 1;
        localObject1 = localObject4;
        localObject2 = localObject5;
      }
    }
    if ((localObject4 == null) && (localObject3 == null)) {
      return null;
    }
    return new FragmentManagerNonConfig((List)localObject4, localObject3);
  }
  
  Parcelable saveAllState()
  {
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    if (HONEYCOMB) {
      mStateSaved = true;
    }
    if ((mActive == null) || (mActive.size() <= 0)) {}
    FragmentState[] arrayOfFragmentState;
    int j;
    int i;
    label369:
    do
    {
      return null;
      int m = mActive.size();
      arrayOfFragmentState = new FragmentState[m];
      j = 0;
      i = 0;
      if (i < m)
      {
        localObject1 = (Fragment)mActive.get(i);
        int k;
        if (localObject1 != null)
        {
          if (mIndex < 0) {
            throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + mIndex));
          }
          k = 1;
          localObject2 = new FragmentState((Fragment)localObject1);
          arrayOfFragmentState[i] = localObject2;
          if ((mState <= 0) || (mSavedFragmentState != null)) {
            break label369;
          }
          mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
          if (mTarget != null)
          {
            if (mTarget.mIndex < 0) {
              throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + mTarget));
            }
            if (mSavedFragmentState == null) {
              mSavedFragmentState = new Bundle();
            }
            putFragment(mSavedFragmentState, "android:target_state", mTarget);
            if (mTargetRequestCode != 0) {
              mSavedFragmentState.putInt("android:target_req_state", mTargetRequestCode);
            }
          }
        }
        for (;;)
        {
          j = k;
          if (DEBUG)
          {
            Log.v("FragmentManager", "Saved state of " + localObject1 + ": " + mSavedFragmentState);
            j = k;
          }
          i += 1;
          break;
          mSavedFragmentState = mSavedFragmentState;
        }
      }
      if (j != 0) {
        break;
      }
    } while (!DEBUG);
    Log.v("FragmentManager", "saveAllState: no fragments!");
    return null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    if (mAdded != null)
    {
      j = mAdded.size();
      localObject1 = localObject2;
      if (j > 0)
      {
        localObject2 = new int[j];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject2[i] = mAdded.get(i)).mIndex;
          if (localObject2[i] < 0) {
            throwException(new IllegalStateException("Failure saving state: active " + mAdded.get(i) + " has cleared index: " + localObject2[i]));
          }
          if (DEBUG) {
            Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + mAdded.get(i));
          }
          i += 1;
        }
      }
    }
    localObject2 = localObject3;
    if (mBackStack != null)
    {
      j = mBackStack.size();
      localObject2 = localObject3;
      if (j > 0)
      {
        localObject3 = new BackStackState[j];
        i = 0;
        for (;;)
        {
          localObject2 = localObject3;
          if (i >= j) {
            break;
          }
          localObject3[i] = new BackStackState((BackStackRecord)mBackStack.get(i));
          if (DEBUG) {
            Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + mBackStack.get(i));
          }
          i += 1;
        }
      }
    }
    localObject3 = new FragmentManagerState();
    mActive = arrayOfFragmentState;
    mAdded = ((int[])localObject1);
    mBackStack = ((BackStackState[])localObject2);
    return localObject3;
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (mStateBundle == null) {
      mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, mStateBundle, false);
    if (!mStateBundle.isEmpty())
    {
      localObject2 = mStateBundle;
      mStateBundle = null;
    }
    if (mView != null) {
      saveFragmentViewState(paramFragment);
    }
    Object localObject1 = localObject2;
    if (mSavedViewState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", mSavedViewState);
    }
    localObject2 = localObject1;
    if (!mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", mUserVisibleHint);
    }
    return localObject2;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return localObject1;
  }
  
  void saveFragmentViewState(Fragment paramFragment)
  {
    if (mInnerView == null) {
      return;
    }
    if (mStateArray == null) {
      mStateArray = new SparseArray();
    }
    for (;;)
    {
      mInnerView.saveHierarchyState(mStateArray);
      if (mStateArray.size() <= 0) {
        break;
      }
      mSavedViewState = mStateArray;
      mStateArray = null;
      return;
      mStateArray.clear();
    }
  }
  
  /* Error */
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 678	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 203	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 311	java/util/ArrayList:<init>	()V
    //   17: putfield 678	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 678	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 241	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +58 -> 93
    //   38: getstatic 119	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   41: ifeq +39 -> 80
    //   44: ldc 55
    //   46: new 185	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 680
    //   56: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_1
    //   60: invokevirtual 683	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc_w 685
    //   66: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 635	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 638	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 678	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   84: iload_1
    //   85: aload_2
    //   86: invokevirtual 698	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iload_3
    //   94: iload_1
    //   95: if_icmpge +81 -> 176
    //   98: aload_0
    //   99: getfield 678	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   102: aconst_null
    //   103: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: getfield 676	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   111: ifnonnull +14 -> 125
    //   114: aload_0
    //   115: new 203	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 311	java/util/ArrayList:<init>	()V
    //   122: putfield 676	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   125: getstatic 119	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   128: ifeq +29 -> 157
    //   131: ldc 55
    //   133: new 185	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 1645
    //   143: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_3
    //   147: invokevirtual 683	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 638	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_0
    //   158: getfield 676	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   161: iload_3
    //   162: invokestatic 1046	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: iload_3
    //   170: iconst_1
    //   171: iadd
    //   172: istore_3
    //   173: goto -80 -> 93
    //   176: getstatic 119	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   179: ifeq +39 -> 218
    //   182: ldc 55
    //   184: new 185	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 692
    //   194: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_1
    //   198: invokevirtual 683	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 694
    //   204: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 635	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 638	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_0
    //   219: getfield 678	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   222: aload_2
    //   223: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -137 -> 90
    //   230: astore_2
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_2
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	FragmentManagerImpl
    //   0	235	1	paramInt	int
    //   0	235	2	paramBackStackRecord	BackStackRecord
    //   31	142	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	230	finally
    //   20	29	230	finally
    //   38	80	230	finally
    //   80	90	230	finally
    //   90	92	230	finally
    //   98	125	230	finally
    //   125	157	230	finally
    //   157	169	230	finally
    //   176	218	230	finally
    //   218	227	230	finally
    //   231	233	230	finally
  }
  
  public void showFragment(Fragment paramFragment)
  {
    boolean bool = false;
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (mHidden)
    {
      mHidden = false;
      if (!mHiddenChanged) {
        bool = true;
      }
      mHiddenChanged = bool;
    }
  }
  
  void startPendingDeferredFragments()
  {
    if (mActive == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < mActive.size())
      {
        Fragment localFragment = (Fragment)mActive.get(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (mParent != null) {
      DebugUtils.buildShortClassTag(mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(mHost, localStringBuilder);
    }
  }
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
  {
    if (mLifecycleCallbacks == null) {
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = mLifecycleCallbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        int j = mLifecycleCallbacks.size();
        if (i < j)
        {
          if (mLifecycleCallbacks.get(i)).first == paramFragmentLifecycleCallbacks) {
            mLifecycleCallbacks.remove(i);
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  static class AnimateOnHWLayerIfNeededListener
    implements Animation.AnimationListener
  {
    private Animation.AnimationListener mOriginalListener;
    private boolean mShouldRunOnHWLayer;
    View mView;
    
    public AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation)
    {
      if ((paramView == null) || (paramAnimation == null)) {
        return;
      }
      mView = paramView;
    }
    
    public AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation, Animation.AnimationListener paramAnimationListener)
    {
      if ((paramView == null) || (paramAnimation == null)) {
        return;
      }
      mOriginalListener = paramAnimationListener;
      mView = paramView;
      mShouldRunOnHWLayer = true;
    }
    
    @CallSuper
    public void onAnimationEnd(Animation paramAnimation)
    {
      if ((mView != null) && (mShouldRunOnHWLayer))
      {
        if ((!ViewCompat.isAttachedToWindow(mView)) && (!BuildCompat.isAtLeastN())) {
          break label64;
        }
        mView.post(new Runnable()
        {
          public void run()
          {
            ViewCompat.setLayerType(mView, 0, null);
          }
        });
      }
      for (;;)
      {
        if (mOriginalListener != null) {
          mOriginalListener.onAnimationEnd(paramAnimation);
        }
        return;
        label64:
        ViewCompat.setLayerType(mView, 0, null);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      if (mOriginalListener != null) {
        mOriginalListener.onAnimationRepeat(paramAnimation);
      }
    }
    
    @CallSuper
    public void onAnimationStart(Animation paramAnimation)
    {
      if (mOriginalListener != null) {
        mOriginalListener.onAnimationStart(paramAnimation);
      }
    }
  }
  
  static class FragmentTag
  {
    public static final int[] Fragment = { 16842755, 16842960, 16842961 };
    public static final int Fragment_id = 1;
    public static final int Fragment_name = 0;
    public static final int Fragment_tag = 2;
    
    FragmentTag() {}
  }
  
  static abstract interface OpGenerator
  {
    public abstract boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  private class PopBackStackState
    implements FragmentManagerImpl.OpGenerator
  {
    final int mFlags;
    final int mId;
    final String mName;
    
    PopBackStackState(String paramString, int paramInt1, int paramInt2)
    {
      mName = paramString;
      mId = paramInt1;
      mFlags = paramInt2;
    }
    
    public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      return popBackStackState(paramArrayList, paramArrayList1, mName, mId, mFlags);
    }
  }
  
  static class StartEnterTransitionListener
    implements Fragment.OnStartEnterTransitionListener
  {
    private final boolean mIsBack;
    private int mNumPostponed;
    private final BackStackRecord mRecord;
    
    StartEnterTransitionListener(BackStackRecord paramBackStackRecord, boolean paramBoolean)
    {
      mIsBack = paramBoolean;
      mRecord = paramBackStackRecord;
    }
    
    public void cancelTransaction()
    {
      mRecord.mManager.completeExecute(mRecord, mIsBack, false, false);
    }
    
    public void completeTransaction()
    {
      boolean bool1 = false;
      if (mNumPostponed > 0) {}
      for (int i = 1;; i = 0)
      {
        localFragmentManagerImpl = mRecord.mManager;
        int k = mAdded.size();
        int j = 0;
        while (j < k)
        {
          localObject = (Fragment)mAdded.get(j);
          ((Fragment)localObject).setOnStartEnterTransitionListener(null);
          if ((i != 0) && (((Fragment)localObject).isPostponed())) {
            ((Fragment)localObject).startPostponedEnterTransition();
          }
          j += 1;
        }
      }
      FragmentManagerImpl localFragmentManagerImpl = mRecord.mManager;
      Object localObject = mRecord;
      boolean bool2 = mIsBack;
      if (i == 0) {
        bool1 = true;
      }
      localFragmentManagerImpl.completeExecute((BackStackRecord)localObject, bool2, bool1, true);
    }
    
    public boolean isReady()
    {
      return mNumPostponed == 0;
    }
    
    public void onStartEnterTransition()
    {
      mNumPostponed -= 1;
      if (mNumPostponed != 0) {
        return;
      }
      mRecord.mManager.scheduleCommit();
    }
    
    public void startListening()
    {
      mNumPostponed += 1;
    }
  }
}
