package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TargetApi(14)
@RequiresApi(14)
abstract class TransitionPort
  implements Cloneable
{
  static final boolean DBG = false;
  private static final String LOG_TAG = "Transition";
  private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal();
  ArrayList<Animator> mAnimators = new ArrayList();
  boolean mCanRemoveViews = false;
  ArrayList<Animator> mCurrentAnimators = new ArrayList();
  long mDuration = -1L;
  private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
  private boolean mEnded = false;
  TimeInterpolator mInterpolator = null;
  ArrayList<TransitionListener> mListeners = null;
  private String mName = getClass().getName();
  int mNumInstances = 0;
  TransitionSetPort mParent = null;
  boolean mPaused = false;
  ViewGroup mSceneRoot = null;
  long mStartDelay = -1L;
  private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
  ArrayList<View> mTargetChildExcludes = null;
  ArrayList<View> mTargetExcludes = null;
  ArrayList<Integer> mTargetIdChildExcludes = null;
  ArrayList<Integer> mTargetIdExcludes = null;
  ArrayList<Integer> mTargetIds = new ArrayList();
  ArrayList<Class> mTargetTypeChildExcludes = null;
  ArrayList<Class> mTargetTypeExcludes = null;
  ArrayList<View> mTargets = new ArrayList();
  
  public TransitionPort() {}
  
  private void captureHierarchy(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int i = 0;
      if ((paramView.getParent() instanceof ListView)) {
        i = 1;
      }
      if ((i == 0) || (((ListView)paramView.getParent()).getAdapter().hasStableIds()))
      {
        int j = -1;
        long l = -1L;
        if (i == 0) {
          j = paramView.getId();
        }
        for (;;)
        {
          if (((mTargetIdExcludes != null) && (mTargetIdExcludes.contains(Integer.valueOf(j)))) || ((mTargetExcludes != null) && (mTargetExcludes.contains(paramView)))) {
            break label180;
          }
          if ((mTargetTypeExcludes == null) || (paramView == null)) {
            break label182;
          }
          int m = mTargetTypeExcludes.size();
          int k = 0;
          for (;;)
          {
            if (k >= m) {
              break label182;
            }
            if (((Class)mTargetTypeExcludes.get(k)).isInstance(paramView)) {
              break;
            }
            k += 1;
          }
          localObject = (ListView)paramView.getParent();
          l = ((ListView)localObject).getItemIdAtPosition(((ListView)localObject).getPositionForView(paramView));
        }
        label180:
        continue;
        label182:
        Object localObject = new TransitionValues();
        view = paramView;
        if (paramBoolean)
        {
          captureStartValues((TransitionValues)localObject);
          label207:
          if (!paramBoolean) {
            break label374;
          }
          if (i != 0) {
            break label357;
          }
          mStartValues.viewValues.put(paramView, localObject);
          if (j >= 0) {
            mStartValues.idValues.put(j, localObject);
          }
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((mTargetIdChildExcludes != null) && (mTargetIdChildExcludes.contains(Integer.valueOf(j)))) || ((mTargetChildExcludes != null) && (mTargetChildExcludes.contains(paramView)))) {
            break label429;
          }
          if ((mTargetTypeChildExcludes == null) || (paramView == null)) {
            break label431;
          }
          j = mTargetTypeChildExcludes.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label431;
            }
            if (((Class)mTargetTypeChildExcludes.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          captureEndValues((TransitionValues)localObject);
          break label207;
          label357:
          mStartValues.itemIdValues.put(l, localObject);
          continue;
          label374:
          if (i == 0)
          {
            mEndValues.viewValues.put(paramView, localObject);
            if (j >= 0) {
              mEndValues.idValues.put(j, localObject);
            }
          }
          else
          {
            mEndValues.itemIdValues.put(l, localObject);
          }
        }
        label429:
        continue;
        label431:
        paramView = (ViewGroup)paramView;
        i = 0;
        while (i < paramView.getChildCount())
        {
          captureHierarchy(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private ArrayList<Integer> excludeId(ArrayList<Integer> paramArrayList, int paramInt, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramInt > 0)
    {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, Integer.valueOf(paramInt));
      }
    }
    else {
      return localObject;
    }
    return ArrayListManager.remove(paramArrayList, Integer.valueOf(paramInt));
  }
  
  private ArrayList<Class> excludeType(ArrayList<Class> paramArrayList, Class paramClass, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramClass != null)
    {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, paramClass);
      }
    }
    else {
      return localObject;
    }
    return ArrayListManager.remove(paramArrayList, paramClass);
  }
  
  private ArrayList<View> excludeView(ArrayList<View> paramArrayList, View paramView, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramView != null)
    {
      if (paramBoolean) {
        localObject = ArrayListManager.add(paramArrayList, paramView);
      }
    }
    else {
      return localObject;
    }
    return ArrayListManager.remove(paramArrayList, paramView);
  }
  
  private static ArrayMap<Animator, AnimationInfo> getRunningAnimators()
  {
    ArrayMap localArrayMap2 = (ArrayMap)sRunningAnimators.get();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      sRunningAnimators.set(localArrayMap1);
    }
    return localArrayMap1;
  }
  
  private void runAnimator(Animator paramAnimator, final ArrayMap<Animator, AnimationInfo> paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramArrayMap.remove(paramAnonymousAnimator);
          mCurrentAnimators.remove(paramAnonymousAnimator);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          mCurrentAnimators.add(paramAnonymousAnimator);
        }
      });
      animate(paramAnimator);
    }
  }
  
  public TransitionPort addListener(TransitionListener paramTransitionListener)
  {
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    mListeners.add(paramTransitionListener);
    return this;
  }
  
  public TransitionPort addTarget(int paramInt)
  {
    if (paramInt > 0) {
      mTargetIds.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public TransitionPort addTarget(View paramView)
  {
    mTargets.add(paramView);
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void animate(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      end();
      return;
    }
    if (getDuration() >= 0L) {
      paramAnimator.setDuration(getDuration());
    }
    if (getStartDelay() >= 0L) {
      paramAnimator.setStartDelay(getStartDelay());
    }
    if (getInterpolator() != null) {
      paramAnimator.setInterpolator(getInterpolator());
    }
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        end();
        paramAnonymousAnimator.removeListener(this);
      }
    });
    paramAnimator.start();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void cancel()
  {
    int i = mCurrentAnimators.size() - 1;
    while (i >= 0)
    {
      ((Animator)mCurrentAnimators.get(i)).cancel();
      i -= 1;
    }
    if ((mListeners != null) && (mListeners.size() > 0))
    {
      ArrayList localArrayList = (ArrayList)mListeners.clone();
      int j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        ((TransitionListener)localArrayList.get(i)).onTransitionCancel(this);
        i += 1;
      }
    }
  }
  
  public abstract void captureEndValues(TransitionValues paramTransitionValues);
  
  public abstract void captureStartValues(TransitionValues paramTransitionValues);
  
  void captureValues(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    clearValues(paramBoolean);
    if ((mTargetIds.size() > 0) || (mTargets.size() > 0))
    {
      int i;
      Object localObject;
      if (mTargetIds.size() > 0)
      {
        i = 0;
        if (i < mTargetIds.size())
        {
          int j = ((Integer)mTargetIds.get(i)).intValue();
          localObject = paramViewGroup.findViewById(j);
          TransitionValues localTransitionValues;
          if (localObject != null)
          {
            localTransitionValues = new TransitionValues();
            view = ((View)localObject);
            if (!paramBoolean) {
              break label148;
            }
            captureStartValues(localTransitionValues);
            label103:
            if (!paramBoolean) {
              break label157;
            }
            mStartValues.viewValues.put(localObject, localTransitionValues);
            if (j >= 0) {
              mStartValues.idValues.put(j, localTransitionValues);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label148:
            captureEndValues(localTransitionValues);
            break label103;
            label157:
            mEndValues.viewValues.put(localObject, localTransitionValues);
            if (j >= 0) {
              mEndValues.idValues.put(j, localTransitionValues);
            }
          }
        }
      }
      if (mTargets.size() > 0)
      {
        i = 0;
        if (i < mTargets.size())
        {
          paramViewGroup = (View)mTargets.get(i);
          if (paramViewGroup != null)
          {
            localObject = new TransitionValues();
            view = paramViewGroup;
            if (!paramBoolean) {
              break label283;
            }
            captureStartValues((TransitionValues)localObject);
            label258:
            if (!paramBoolean) {
              break label292;
            }
            mStartValues.viewValues.put(paramViewGroup, localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            label283:
            captureEndValues((TransitionValues)localObject);
            break label258;
            label292:
            mEndValues.viewValues.put(paramViewGroup, localObject);
          }
        }
      }
    }
    else
    {
      captureHierarchy(paramViewGroup, paramBoolean);
    }
  }
  
  void clearValues(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mStartValues.viewValues.clear();
      mStartValues.idValues.clear();
      mStartValues.itemIdValues.clear();
      return;
    }
    mEndValues.viewValues.clear();
    mEndValues.idValues.clear();
    mEndValues.itemIdValues.clear();
  }
  
  public TransitionPort clone()
  {
    Object localObject = null;
    try
    {
      TransitionPort localTransitionPort = (TransitionPort)super.clone();
      localObject = localTransitionPort;
      mAnimators = new ArrayList();
      localObject = localTransitionPort;
      mStartValues = new TransitionValuesMaps();
      localObject = localTransitionPort;
      mEndValues = new TransitionValuesMaps();
      return localTransitionPort;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return localObject;
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void createAnimators(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2)
  {
    Object localObject7 = new ArrayMap(viewValues);
    Object localObject6 = new SparseArray(idValues.size());
    int i = 0;
    while (i < idValues.size())
    {
      ((SparseArray)localObject6).put(idValues.keyAt(i), idValues.valueAt(i));
      i += 1;
    }
    Object localObject5 = new LongSparseArray(itemIdValues.size());
    i = 0;
    while (i < itemIdValues.size())
    {
      ((LongSparseArray)localObject5).put(itemIdValues.keyAt(i), itemIdValues.valueAt(i));
      i += 1;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = viewValues.keySet().iterator();
    Object localObject1;
    label251:
    label340:
    Object localObject4;
    Object localObject3;
    long l;
    while (localIterator1.hasNext())
    {
      View localView = (View)localIterator1.next();
      localObject1 = null;
      i = 0;
      if ((localView.getParent() instanceof ListView)) {
        i = 1;
      }
      if (i == 0)
      {
        i = localView.getId();
        if (viewValues.get(localView) != null)
        {
          localObject2 = (TransitionValues)viewValues.get(localView);
          if (viewValues.get(localView) == null) {
            break label340;
          }
          localObject1 = (TransitionValues)viewValues.get(localView);
          ((ArrayMap)localObject7).remove(localView);
        }
        for (;;)
        {
          ((SparseArray)localObject6).remove(i);
          if (!isValidTarget(localView, i)) {
            break;
          }
          localArrayList1.add(localObject2);
          localArrayList2.add(localObject1);
          break;
          localObject2 = (TransitionValues)idValues.get(i);
          break label251;
          if (i != -1)
          {
            localObject4 = (TransitionValues)idValues.get(i);
            localObject3 = null;
            Iterator localIterator2 = ((ArrayMap)localObject7).keySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (View)localIterator2.next();
              if (((View)localObject1).getId() == i) {
                localObject3 = localObject1;
              }
            }
            localObject1 = localObject4;
            if (localObject3 != null)
            {
              ((ArrayMap)localObject7).remove(localObject3);
              localObject1 = localObject4;
            }
          }
        }
      }
      localObject1 = (ListView)localView.getParent();
      if (((ListView)localObject1).getAdapter().hasStableIds())
      {
        l = ((ListView)localObject1).getItemIdAtPosition(((ListView)localObject1).getPositionForView(localView));
        localObject1 = (TransitionValues)itemIdValues.get(l);
        ((LongSparseArray)localObject5).remove(l);
        localArrayList1.add(localObject1);
        localArrayList2.add(null);
      }
    }
    int j = itemIdValues.size();
    i = 0;
    while (i < j)
    {
      l = itemIdValues.keyAt(i);
      if (isValidTarget(null, l))
      {
        localObject1 = (TransitionValues)itemIdValues.get(l);
        localObject2 = (TransitionValues)itemIdValues.get(l);
        ((LongSparseArray)localObject5).remove(l);
        localArrayList1.add(localObject1);
        localArrayList2.add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = ((ArrayMap)localObject7).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (View)((Iterator)localObject2).next();
      i = ((View)localObject3).getId();
      if (isValidTarget((View)localObject3, i))
      {
        if (viewValues.get(localObject3) != null) {}
        for (localObject1 = (TransitionValues)viewValues.get(localObject3);; localObject1 = (TransitionValues)idValues.get(i))
        {
          localObject3 = (TransitionValues)((ArrayMap)localObject7).get(localObject3);
          ((SparseArray)localObject6).remove(i);
          localArrayList1.add(localObject1);
          localArrayList2.add(localObject3);
          break;
        }
      }
    }
    j = ((SparseArray)localObject6).size();
    i = 0;
    int k;
    while (i < j)
    {
      k = ((SparseArray)localObject6).keyAt(i);
      if (isValidTarget(null, k))
      {
        localObject1 = (TransitionValues)idValues.get(k);
        localObject2 = (TransitionValues)((SparseArray)localObject6).get(k);
        localArrayList1.add(localObject1);
        localArrayList2.add(localObject2);
      }
      i += 1;
    }
    j = ((LongSparseArray)localObject5).size();
    i = 0;
    while (i < j)
    {
      l = ((LongSparseArray)localObject5).keyAt(i);
      localObject1 = (TransitionValues)itemIdValues.get(l);
      localObject2 = (TransitionValues)((LongSparseArray)localObject5).get(l);
      localArrayList1.add(localObject1);
      localArrayList2.add(localObject2);
      i += 1;
    }
    localObject6 = getRunningAnimators();
    i = 0;
    if (i < localArrayList1.size())
    {
      paramTransitionValuesMaps1 = (TransitionValues)localArrayList1.get(i);
      localObject1 = (TransitionValues)localArrayList2.get(i);
      if (((paramTransitionValuesMaps1 != null) || (localObject1 != null)) && ((paramTransitionValuesMaps1 == null) || (!paramTransitionValuesMaps1.equals(localObject1))))
      {
        localObject3 = createAnimator(paramViewGroup, paramTransitionValuesMaps1, (TransitionValues)localObject1);
        if (localObject3 != null)
        {
          localObject5 = null;
          if (localObject1 == null) {
            break label1316;
          }
          localObject4 = view;
          localObject7 = getTransitionProperties();
          localObject1 = localObject3;
          paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject5;
          localObject2 = localObject4;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject5;
            localObject2 = localObject4;
            if (localObject7 != null)
            {
              localObject1 = localObject3;
              paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject5;
              localObject2 = localObject4;
              if (localObject7.length > 0)
              {
                localObject5 = new TransitionValues();
                view = ((View)localObject4);
                paramTransitionValuesMaps1 = (TransitionValues)viewValues.get(localObject4);
                if (paramTransitionValuesMaps1 != null)
                {
                  j = 0;
                  while (j < localObject7.length)
                  {
                    values.put(localObject7[j], values.get(localObject7[j]));
                    j += 1;
                  }
                }
                k = ((ArrayMap)localObject6).size();
                j = 0;
                label1154:
                localObject1 = localObject3;
                paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject5;
                localObject2 = localObject4;
                if (j < k)
                {
                  paramTransitionValuesMaps1 = (AnimationInfo)((ArrayMap)localObject6).get((Animator)((ArrayMap)localObject6).keyAt(j));
                  if ((values == null) || (view != localObject4) || (((name != null) || (getName() != null)) && ((!name.equals(getName())) || (!values.equals(localObject5))))) {
                    break label1307;
                  }
                  localObject1 = null;
                  localObject2 = localObject4;
                }
              }
            }
          }
        }
      }
      for (paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject5;; paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject5)
      {
        if (localObject1 != null)
        {
          ((ArrayMap)localObject6).put(localObject1, new AnimationInfo((View)localObject2, getName(), WindowIdPort.getWindowId(paramViewGroup), paramTransitionValuesMaps1));
          mAnimators.add(localObject1);
        }
        i += 1;
        break;
        label1307:
        j += 1;
        break label1154;
        label1316:
        localObject2 = view;
        localObject1 = localObject3;
      }
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void end()
  {
    mNumInstances -= 1;
    if (mNumInstances == 0)
    {
      Object localObject;
      if ((mListeners != null) && (mListeners.size() > 0))
      {
        localObject = (ArrayList)mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((TransitionListener)((ArrayList)localObject).get(i)).onTransitionEnd(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < mStartValues.itemIdValues.size())
      {
        localObject = mStartValues.itemIdValues.valueAt(i)).view;
        i += 1;
      }
      i = 0;
      while (i < mEndValues.itemIdValues.size())
      {
        localObject = mEndValues.itemIdValues.valueAt(i)).view;
        i += 1;
      }
      mEnded = true;
    }
  }
  
  public TransitionPort excludeChildren(int paramInt, boolean paramBoolean)
  {
    mTargetIdChildExcludes = excludeId(mTargetIdChildExcludes, paramInt, paramBoolean);
    return this;
  }
  
  public TransitionPort excludeChildren(View paramView, boolean paramBoolean)
  {
    mTargetChildExcludes = excludeView(mTargetChildExcludes, paramView, paramBoolean);
    return this;
  }
  
  public TransitionPort excludeChildren(Class paramClass, boolean paramBoolean)
  {
    mTargetTypeChildExcludes = excludeType(mTargetTypeChildExcludes, paramClass, paramBoolean);
    return this;
  }
  
  public TransitionPort excludeTarget(int paramInt, boolean paramBoolean)
  {
    mTargetIdExcludes = excludeId(mTargetIdExcludes, paramInt, paramBoolean);
    return this;
  }
  
  public TransitionPort excludeTarget(View paramView, boolean paramBoolean)
  {
    mTargetExcludes = excludeView(mTargetExcludes, paramView, paramBoolean);
    return this;
  }
  
  public TransitionPort excludeTarget(Class paramClass, boolean paramBoolean)
  {
    mTargetTypeExcludes = excludeType(mTargetTypeExcludes, paramClass, paramBoolean);
    return this;
  }
  
  public long getDuration()
  {
    return mDuration;
  }
  
  public TimeInterpolator getInterpolator()
  {
    return mInterpolator;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public long getStartDelay()
  {
    return mStartDelay;
  }
  
  public List<Integer> getTargetIds()
  {
    return mTargetIds;
  }
  
  public List<View> getTargets()
  {
    return mTargets;
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  public TransitionValues getTransitionValues(View paramView, boolean paramBoolean)
  {
    Object localObject;
    if (mParent != null)
    {
      localObject = mParent.getTransitionValues(paramView, paramBoolean);
      return localObject;
    }
    if (paramBoolean) {}
    for (TransitionValuesMaps localTransitionValuesMaps = mStartValues;; localTransitionValuesMaps = mEndValues)
    {
      TransitionValues localTransitionValues = (TransitionValues)viewValues.get(paramView);
      localObject = localTransitionValues;
      if (localTransitionValues != null) {
        break;
      }
      int i = paramView.getId();
      if (i >= 0) {
        localTransitionValues = (TransitionValues)idValues.get(i);
      }
      localObject = localTransitionValues;
      if (localTransitionValues != null) {
        break;
      }
      localObject = localTransitionValues;
      if (!(paramView.getParent() instanceof ListView)) {
        break;
      }
      localObject = (ListView)paramView.getParent();
      long l = ((ListView)localObject).getItemIdAtPosition(((ListView)localObject).getPositionForView(paramView));
      return (TransitionValues)itemIdValues.get(l);
    }
  }
  
  boolean isValidTarget(View paramView, long paramLong)
  {
    if ((mTargetIdExcludes != null) && (mTargetIdExcludes.contains(Integer.valueOf((int)paramLong)))) {
      return false;
    }
    if ((mTargetExcludes != null) && (mTargetExcludes.contains(paramView))) {
      return false;
    }
    int i;
    if ((mTargetTypeExcludes != null) && (paramView != null))
    {
      int j = mTargetTypeExcludes.size();
      i = 0;
      while (i < j)
      {
        if (((Class)mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return false;
        }
        i += 1;
      }
    }
    if ((mTargetIds.size() == 0) && (mTargets.size() == 0)) {
      return true;
    }
    if (mTargetIds.size() > 0)
    {
      i = 0;
      while (i < mTargetIds.size())
      {
        if (((Integer)mTargetIds.get(i)).intValue() == paramLong) {
          return true;
        }
        i += 1;
      }
    }
    if ((paramView != null) && (mTargets.size() > 0))
    {
      i = 0;
      while (i < mTargets.size())
      {
        if (mTargets.get(i) == paramView) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void pause(View paramView)
  {
    if (!mEnded)
    {
      ArrayMap localArrayMap = getRunningAnimators();
      int i = localArrayMap.size();
      paramView = WindowIdPort.getWindowId(paramView);
      i -= 1;
      while (i >= 0)
      {
        AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.valueAt(i);
        if ((view != null) && (paramView.equals(windowId))) {
          ((Animator)localArrayMap.keyAt(i)).cancel();
        }
        i -= 1;
      }
      if ((mListeners != null) && (mListeners.size() > 0))
      {
        paramView = (ArrayList)mListeners.clone();
        int j = paramView.size();
        i = 0;
        while (i < j)
        {
          ((TransitionListener)paramView.get(i)).onTransitionPause(this);
          i += 1;
        }
      }
      mPaused = true;
    }
  }
  
  void playTransition(ViewGroup paramViewGroup)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size() - 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i);
      Object localObject1;
      if (localAnimator != null)
      {
        localObject1 = (AnimationInfo)localArrayMap.get(localAnimator);
        if ((localObject1 != null) && (view != null) && (view.getContext() == paramViewGroup.getContext()))
        {
          int k = 0;
          TransitionValues localTransitionValues = values;
          Object localObject3 = view;
          if (mEndValues.viewValues == null) {
            break label286;
          }
          localObject1 = (TransitionValues)mEndValues.viewValues.get(localObject3);
          label117:
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = (TransitionValues)mEndValues.idValues.get(((View)localObject3).getId());
          }
          int j = k;
          if (localTransitionValues != null)
          {
            j = k;
            if (localObject2 != null)
            {
              localObject1 = values.keySet().iterator();
              Object localObject4;
              do
              {
                j = k;
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject4 = (String)((Iterator)localObject1).next();
                localObject3 = values.get(localObject4);
                localObject4 = values.get(localObject4);
              } while ((localObject3 == null) || (localObject4 == null) || (localObject3.equals(localObject4)));
              j = 1;
            }
          }
          if (j != 0)
          {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              break label292;
            }
            localAnimator.cancel();
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label286:
        localObject1 = null;
        break label117;
        label292:
        localArrayMap.remove(localAnimator);
      }
    }
    createAnimators(paramViewGroup, mStartValues, mEndValues);
    runAnimators();
  }
  
  public TransitionPort removeListener(TransitionListener paramTransitionListener)
  {
    if (mListeners == null) {}
    do
    {
      return this;
      mListeners.remove(paramTransitionListener);
    } while (mListeners.size() != 0);
    mListeners = null;
    return this;
  }
  
  public TransitionPort removeTarget(int paramInt)
  {
    if (paramInt > 0) {
      mTargetIds.remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public TransitionPort removeTarget(View paramView)
  {
    if (paramView != null) {
      mTargets.remove(paramView);
    }
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void resume(View paramView)
  {
    if (mPaused)
    {
      if (!mEnded)
      {
        ArrayMap localArrayMap = getRunningAnimators();
        int i = localArrayMap.size();
        paramView = WindowIdPort.getWindowId(paramView);
        i -= 1;
        while (i >= 0)
        {
          AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.valueAt(i);
          if ((view != null) && (paramView.equals(windowId))) {
            ((Animator)localArrayMap.keyAt(i)).end();
          }
          i -= 1;
        }
        if ((mListeners != null) && (mListeners.size() > 0))
        {
          paramView = (ArrayList)mListeners.clone();
          int j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((TransitionListener)paramView.get(i)).onTransitionResume(this);
            i += 1;
          }
        }
      }
      mPaused = false;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void runAnimators()
  {
    start();
    ArrayMap localArrayMap = getRunningAnimators();
    Iterator localIterator = mAnimators.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        start();
        runAnimator(localAnimator, localArrayMap);
      }
    }
    mAnimators.clear();
    end();
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    mCanRemoveViews = paramBoolean;
  }
  
  public TransitionPort setDuration(long paramLong)
  {
    mDuration = paramLong;
    return this;
  }
  
  public TransitionPort setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  TransitionPort setSceneRoot(ViewGroup paramViewGroup)
  {
    mSceneRoot = paramViewGroup;
    return this;
  }
  
  public TransitionPort setStartDelay(long paramLong)
  {
    mStartDelay = paramLong;
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void start()
  {
    if (mNumInstances == 0)
    {
      if ((mListeners != null) && (mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((TransitionListener)localArrayList.get(i)).onTransitionStart(this);
          i += 1;
        }
      }
      mEnded = false;
    }
    mNumInstances += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    String str = paramString + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
    paramString = str;
    if (mDuration != -1L) {
      paramString = str + "dur(" + mDuration + ") ";
    }
    str = paramString;
    if (mStartDelay != -1L) {
      str = paramString + "dly(" + mStartDelay + ") ";
    }
    paramString = str;
    if (mInterpolator != null) {
      paramString = str + "interp(" + mInterpolator + ") ";
    }
    if (mTargetIds.size() <= 0)
    {
      str = paramString;
      if (mTargets.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (mTargetIds.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= mTargetIds.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + mTargetIds.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (mTargets.size() > 0)
      {
        i = 0;
        for (;;)
        {
          str = paramString;
          if (i >= mTargets.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + mTargets.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  private static class AnimationInfo
  {
    String name;
    TransitionValues values;
    View view;
    WindowIdPort windowId;
    
    AnimationInfo(View paramView, String paramString, WindowIdPort paramWindowIdPort, TransitionValues paramTransitionValues)
    {
      view = paramView;
      name = paramString;
      values = paramTransitionValues;
      windowId = paramWindowIdPort;
    }
  }
  
  private static class ArrayListManager
  {
    private ArrayListManager() {}
    
    static <T> ArrayList<T> add(ArrayList<T> paramArrayList, T paramT)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList();
      }
      if (!((ArrayList)localObject).contains(paramT)) {
        ((ArrayList)localObject).add(paramT);
      }
      return localObject;
    }
    
    static <T> ArrayList<T> remove(ArrayList<T> paramArrayList, T paramT)
    {
      ArrayList<T> localArrayList = paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList.remove(paramT);
        localArrayList = paramArrayList;
        if (paramArrayList.isEmpty()) {
          localArrayList = null;
        }
      }
      return localArrayList;
    }
  }
  
  public static abstract interface TransitionListener
  {
    public abstract void onTransitionCancel(TransitionPort paramTransitionPort);
    
    public abstract void onTransitionEnd(TransitionPort paramTransitionPort);
    
    public abstract void onTransitionPause(TransitionPort paramTransitionPort);
    
    public abstract void onTransitionResume(TransitionPort paramTransitionPort);
    
    public abstract void onTransitionStart(TransitionPort paramTransitionPort);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static class TransitionListenerAdapter
    implements TransitionPort.TransitionListener
  {
    public TransitionListenerAdapter() {}
    
    public void onTransitionCancel(TransitionPort paramTransitionPort) {}
    
    public void onTransitionEnd(TransitionPort paramTransitionPort) {}
    
    public void onTransitionPause(TransitionPort paramTransitionPort) {}
    
    public void onTransitionResume(TransitionPort paramTransitionPort) {}
    
    public void onTransitionStart(TransitionPort paramTransitionPort) {}
  }
}
