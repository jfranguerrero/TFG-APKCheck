package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

class FragmentTransition
{
  private static final int[] INVERSE_OPS = { 0, 3, 0, 1, 5, 4, 7, 6 };
  
  FragmentTransition() {}
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, BackStackRecord.Op paramOp, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = fragment;
    int i3 = mContainerId;
    if (i3 == 0) {
      return;
    }
    int m;
    label33:
    boolean bool2;
    int i1;
    int i2;
    int n;
    boolean bool1;
    int j;
    int k;
    if (paramBoolean1)
    {
      m = INVERSE_OPS[cmd];
      bool2 = false;
      i1 = 0;
      i2 = 0;
      n = 0;
      i = i2;
      bool1 = bool2;
      j = n;
      k = i1;
    }
    switch (m)
    {
    default: 
      k = i1;
      j = n;
      bool1 = bool2;
      i = i2;
    case 2: 
    case 5: 
    case 1: 
    case 7: 
      for (;;)
      {
        Object localObject = (FragmentContainerTransition)paramSparseArray.get(i3);
        paramOp = (BackStackRecord.Op)localObject;
        if (bool1)
        {
          paramOp = ensureContainer((FragmentContainerTransition)localObject, paramSparseArray, i3);
          lastIn = localFragment;
          lastInIsPop = paramBoolean1;
          lastInTransaction = paramBackStackRecord;
        }
        if ((!paramBoolean2) && (j != 0))
        {
          if ((paramOp != null) && (firstOut == localFragment)) {
            firstOut = null;
          }
          localObject = mManager;
          if ((mState < 1) && (mCurState >= 1) && (!mAllowOptimization))
          {
            ((FragmentManagerImpl)localObject).makeActive(localFragment);
            ((FragmentManagerImpl)localObject).moveToState(localFragment, 1, 0, 0, false);
          }
        }
        localObject = paramOp;
        if (i != 0) {
          if (paramOp != null)
          {
            localObject = paramOp;
            if (firstOut != null) {}
          }
          else
          {
            localObject = ensureContainer(paramOp, paramSparseArray, i3);
            firstOut = localFragment;
            firstOutIsPop = paramBoolean1;
            firstOutTransaction = paramBackStackRecord;
          }
        }
        if ((paramBoolean2) || (k == 0) || (localObject == null) || (lastIn != localFragment)) {
          break;
        }
        lastIn = null;
        return;
        m = cmd;
        break label33;
        if (paramBoolean2) {
          if ((mHiddenChanged) && (!mHidden) && (mAdded)) {
            bool1 = true;
          }
        }
        for (;;)
        {
          j = 1;
          i = i2;
          k = i1;
          break;
          bool1 = false;
          continue;
          bool1 = mHidden;
        }
        if (!paramBoolean2) {
          break label420;
        }
        bool1 = mIsNewlyAdded;
        j = 1;
        i = i2;
        k = i1;
      }
      if ((!mAdded) && (!mHidden)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
    case 4: 
      label420:
      if (paramBoolean2)
      {
        if ((mHiddenChanged) && (mAdded) && (mHidden)) {}
        for (i = 1;; i = 0)
        {
          k = 1;
          bool1 = bool2;
          j = n;
          break;
        }
      }
      if ((mAdded) && (!mHidden)) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    if (paramBoolean2)
    {
      if ((!mAdded) && (mView != null) && (mView.getVisibility() == 0)) {}
      for (i = 1;; i = 0)
      {
        k = 1;
        bool1 = bool2;
        j = n;
        break;
      }
    }
    if ((mAdded) && (!mHidden)) {}
    for (int i = 1;; i = 0) {
      break;
    }
  }
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean)
  {
    int j = mOps.size();
    int i = 0;
    while (i < j)
    {
      addToFirstInLastOut(paramBackStackRecord, (BackStackRecord.Op)mOps.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static ArrayMap<String, String> calculateNameOverrides(int paramInt1, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramInt3 -= 1;
    if (paramInt3 >= paramInt2)
    {
      Object localObject = (BackStackRecord)paramArrayList.get(paramInt3);
      if (!((BackStackRecord)localObject).interactsWith(paramInt1)) {}
      boolean bool;
      do
      {
        paramInt3 -= 1;
        break;
        bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
      } while (mSharedElementSourceNames == null);
      int j = mSharedElementSourceNames.size();
      ArrayList localArrayList2;
      ArrayList localArrayList1;
      label101:
      int i;
      label104:
      String str1;
      if (bool)
      {
        localArrayList2 = mSharedElementSourceNames;
        localArrayList1 = mSharedElementTargetNames;
        i = 0;
        if (i < j)
        {
          localObject = (String)localArrayList1.get(i);
          str1 = (String)localArrayList2.get(i);
          String str2 = (String)localArrayMap.remove(str1);
          if (str2 == null) {
            break label188;
          }
          localArrayMap.put(localObject, str2);
        }
      }
      for (;;)
      {
        i += 1;
        break label104;
        break;
        localArrayList1 = mSharedElementSourceNames;
        localArrayList2 = mSharedElementTargetNames;
        break label101;
        label188:
        localArrayMap.put(localObject, str1);
      }
    }
    return localArrayMap;
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean)
  {
    if (!mManager.mContainer.onHasView()) {}
    for (;;)
    {
      return;
      int i = mOps.size() - 1;
      while (i >= 0)
      {
        addToFirstInLastOut(paramBackStackRecord, (BackStackRecord.Op)mOps.get(i), paramSparseArray, true, paramBoolean);
        i -= 1;
      }
    }
  }
  
  private static void callSharedElementStartEnd(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap<String, View> paramArrayMap, boolean paramBoolean2)
  {
    ArrayList localArrayList;
    if (paramBoolean1)
    {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
      if (paramFragment1 == null) {
        break label109;
      }
      paramFragment2 = new ArrayList();
      localArrayList = new ArrayList();
      if (paramArrayMap != null) {
        break label87;
      }
    }
    label87:
    for (int i = 0;; i = paramArrayMap.size())
    {
      int j = 0;
      while (j < i)
      {
        localArrayList.add(paramArrayMap.keyAt(j));
        paramFragment2.add(paramArrayMap.valueAt(j));
        j += 1;
      }
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
      break;
    }
    if (paramBoolean2)
    {
      paramFragment1.onSharedElementStart(localArrayList, paramFragment2, null);
      label109:
      return;
    }
    paramFragment1.onSharedElementEnd(localArrayList, paramFragment2, null);
  }
  
  private static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentContainerTransition paramFragmentContainerTransition)
  {
    Object localObject = lastIn;
    View localView = ((Fragment)localObject).getView();
    if ((paramArrayMap.isEmpty()) || (paramObject == null) || (localView == null))
    {
      paramArrayMap.clear();
      paramFragmentContainerTransition = null;
    }
    ArrayMap localArrayMap;
    int i;
    label101:
    do
    {
      return paramFragmentContainerTransition;
      localArrayMap = new ArrayMap();
      FragmentTransitionCompat21.findNamedViews(localArrayMap, localView);
      paramObject = lastInTransaction;
      if (!lastInIsPop) {
        break;
      }
      paramFragmentContainerTransition = ((Fragment)localObject).getExitTransitionCallback();
      paramObject = mSharedElementSourceNames;
      localArrayMap.retainAll(paramObject);
      if (paramFragmentContainerTransition == null) {
        break label210;
      }
      paramFragmentContainerTransition.onMapSharedElements(paramObject, localArrayMap);
      i = paramObject.size() - 1;
      paramFragmentContainerTransition = localArrayMap;
    } while (i < 0);
    localObject = (String)paramObject.get(i);
    paramFragmentContainerTransition = (View)localArrayMap.get(localObject);
    if (paramFragmentContainerTransition == null)
    {
      paramFragmentContainerTransition = findKeyForValue(paramArrayMap, (String)localObject);
      if (paramFragmentContainerTransition != null) {
        paramArrayMap.remove(paramFragmentContainerTransition);
      }
    }
    for (;;)
    {
      i -= 1;
      break label101;
      paramFragmentContainerTransition = ((Fragment)localObject).getEnterTransitionCallback();
      paramObject = mSharedElementTargetNames;
      break;
      if (!((String)localObject).equals(ViewCompat.getTransitionName(paramFragmentContainerTransition)))
      {
        localObject = findKeyForValue(paramArrayMap, (String)localObject);
        if (localObject != null) {
          paramArrayMap.put(localObject, ViewCompat.getTransitionName(paramFragmentContainerTransition));
        }
      }
    }
    label210:
    retainValues(paramArrayMap, localArrayMap);
    return localArrayMap;
  }
  
  private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentContainerTransition paramFragmentContainerTransition)
  {
    if ((paramArrayMap.isEmpty()) || (paramObject == null))
    {
      paramArrayMap.clear();
      paramFragmentContainerTransition = null;
    }
    ArrayMap localArrayMap;
    int i;
    label92:
    do
    {
      return paramFragmentContainerTransition;
      localObject = firstOut;
      localArrayMap = new ArrayMap();
      FragmentTransitionCompat21.findNamedViews(localArrayMap, ((Fragment)localObject).getView());
      paramObject = firstOutTransaction;
      if (!firstOutIsPop) {
        break;
      }
      paramFragmentContainerTransition = ((Fragment)localObject).getEnterTransitionCallback();
      paramObject = mSharedElementTargetNames;
      localArrayMap.retainAll(paramObject);
      if (paramFragmentContainerTransition == null) {
        break label189;
      }
      paramFragmentContainerTransition.onMapSharedElements(paramObject, localArrayMap);
      i = paramObject.size() - 1;
      paramFragmentContainerTransition = localArrayMap;
    } while (i < 0);
    Object localObject = (String)paramObject.get(i);
    paramFragmentContainerTransition = (View)localArrayMap.get(localObject);
    if (paramFragmentContainerTransition == null) {
      paramArrayMap.remove(localObject);
    }
    for (;;)
    {
      i -= 1;
      break label92;
      paramFragmentContainerTransition = ((Fragment)localObject).getExitTransitionCallback();
      paramObject = mSharedElementSourceNames;
      break;
      if (!((String)localObject).equals(ViewCompat.getTransitionName(paramFragmentContainerTransition)))
      {
        localObject = (String)paramArrayMap.remove(localObject);
        paramArrayMap.put(ViewCompat.getTransitionName(paramFragmentContainerTransition), localObject);
      }
    }
    label189:
    paramArrayMap.retainAll(localArrayMap.keySet());
    return localArrayMap;
  }
  
  private static ArrayList<View> configureEnteringExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      FragmentTransitionCompat21.captureTransitioningViews(localArrayList, paramFragment.getView());
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        FragmentTransitionCompat21.addTargets(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    return localObject;
  }
  
  private static Object configureSharedElementsOptimized(ViewGroup paramViewGroup, final View paramView, final ArrayMap<String, String> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2)
  {
    final Fragment localFragment1 = lastIn;
    final Fragment localFragment2 = firstOut;
    if (localFragment1 != null) {
      localFragment1.getView().setVisibility(0);
    }
    if ((localFragment1 == null) || (localFragment2 == null)) {
      return null;
    }
    final boolean bool = lastInIsPop;
    Object localObject;
    ArrayMap localArrayMap2;
    final ArrayMap localArrayMap1;
    if (paramArrayMap.isEmpty())
    {
      localObject = null;
      localArrayMap2 = captureOutSharedElements(paramArrayMap, localObject, paramFragmentContainerTransition);
      localArrayMap1 = captureInSharedElements(paramArrayMap, localObject, paramFragmentContainerTransition);
      if (!paramArrayMap.isEmpty()) {
        break label113;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((paramObject1 != null) || (paramObject2 != null) || (localObject != null)) {
        break label138;
      }
      return null;
      localObject = getSharedElementTransition(localFragment1, localFragment2, bool);
      break;
      label113:
      paramArrayList1.addAll(localArrayMap2.values());
      paramArrayList2.addAll(localArrayMap1.values());
    }
    label138:
    callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap2, true);
    if (localObject != null)
    {
      paramArrayList2.add(paramView);
      FragmentTransitionCompat21.setSharedElementTargets(localObject, paramView, paramArrayList1);
      setOutEpicenter(localObject, paramObject2, localArrayMap2, firstOutIsPop, firstOutTransaction);
      paramArrayList1 = new Rect();
      paramFragmentContainerTransition = getInEpicenterView(localArrayMap1, paramFragmentContainerTransition, paramObject1, bool);
      paramView = paramFragmentContainerTransition;
      paramArrayMap = paramArrayList1;
      if (paramFragmentContainerTransition != null)
      {
        FragmentTransitionCompat21.setEpicenter(paramObject1, paramArrayList1);
        paramArrayMap = paramArrayList1;
      }
    }
    for (paramView = paramFragmentContainerTransition;; paramView = null)
    {
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
          FragmentTransition.callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap1, false);
          if (paramView != null) {
            FragmentTransitionCompat21.getBoundsOnScreen(paramView, paramArrayMap);
          }
          return true;
        }
      });
      return localObject;
      paramArrayMap = null;
    }
  }
  
  private static Object configureSharedElementsUnoptimized(ViewGroup paramViewGroup, final View paramView, final ArrayMap<String, String> paramArrayMap, final FragmentContainerTransition paramFragmentContainerTransition, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final Object paramObject1, final Object paramObject2)
  {
    final Fragment localFragment1 = lastIn;
    final Fragment localFragment2 = firstOut;
    if ((localFragment1 == null) || (localFragment2 == null)) {
      return null;
    }
    final boolean bool = lastInIsPop;
    final Object localObject;
    ArrayMap localArrayMap;
    if (paramArrayMap.isEmpty())
    {
      localObject = null;
      localArrayMap = captureOutSharedElements(paramArrayMap, localObject, paramFragmentContainerTransition);
      if (!paramArrayMap.isEmpty()) {
        break label90;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((paramObject1 != null) || (paramObject2 != null) || (localObject != null)) {
        break label104;
      }
      return null;
      localObject = getSharedElementTransition(localFragment1, localFragment2, bool);
      break;
      label90:
      paramArrayList1.addAll(localArrayMap.values());
    }
    label104:
    callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap, true);
    Rect localRect;
    if (localObject != null)
    {
      localRect = new Rect();
      FragmentTransitionCompat21.setSharedElementTargets(localObject, paramView, paramArrayList1);
      setOutEpicenter(localObject, paramObject2, localArrayMap, firstOutIsPop, firstOutTransaction);
      paramObject2 = localRect;
      if (paramObject1 != null) {
        FragmentTransitionCompat21.setEpicenter(paramObject1, localRect);
      }
    }
    for (paramObject2 = localRect;; paramObject2 = null)
    {
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
          Object localObject = FragmentTransition.captureInSharedElements(paramArrayMap, localObject, paramFragmentContainerTransition);
          if (localObject != null)
          {
            paramArrayList2.addAll(((ArrayMap)localObject).values());
            paramArrayList2.add(paramView);
          }
          FragmentTransition.callSharedElementStartEnd(localFragment1, localFragment2, bool, (ArrayMap)localObject, false);
          if (localObject != null)
          {
            FragmentTransitionCompat21.swapSharedElementTargets(localObject, paramArrayList1, paramArrayList2);
            localObject = FragmentTransition.getInEpicenterView((ArrayMap)localObject, paramFragmentContainerTransition, paramObject1, bool);
            if (localObject != null) {
              FragmentTransitionCompat21.getBoundsOnScreen((View)localObject, paramObject2);
            }
          }
          return true;
        }
      });
      return localObject;
    }
  }
  
  private static void configureTransitionsOptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap)
  {
    paramFragmentManagerImpl = (ViewGroup)mContainer.onFindViewById(paramInt);
    if (paramFragmentManagerImpl == null) {}
    Object localObject4;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList3;
    do
    {
      boolean bool1;
      do
      {
        return;
        localObject4 = lastIn;
        localObject3 = firstOut;
        bool1 = lastInIsPop;
        boolean bool2 = firstOutIsPop;
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject1 = getEnterTransition((Fragment)localObject4, bool1);
        localObject2 = getExitTransition((Fragment)localObject3, bool2);
        paramFragmentContainerTransition = configureSharedElementsOptimized(paramFragmentManagerImpl, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList2, localArrayList1, localObject1, localObject2);
      } while ((localObject1 == null) && (paramFragmentContainerTransition == null) && (localObject2 == null));
      localArrayList3 = configureEnteringExitingViews(localObject2, (Fragment)localObject3, localArrayList2, paramView);
      paramView = configureEnteringExitingViews(localObject1, (Fragment)localObject4, localArrayList1, paramView);
      setViewVisibility(paramView, 4);
      localObject4 = mergeTransitions(localObject1, localObject2, paramFragmentContainerTransition, (Fragment)localObject4, bool1);
    } while (localObject4 == null);
    replaceHide(localObject2, (Fragment)localObject3, localArrayList3);
    Object localObject3 = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(localArrayList1);
    FragmentTransitionCompat21.scheduleRemoveTargets(localObject4, localObject1, paramView, localObject2, localArrayList3, paramFragmentContainerTransition, localArrayList1);
    FragmentTransitionCompat21.beginDelayedTransition(paramFragmentManagerImpl, localObject4);
    FragmentTransitionCompat21.setNameOverridesOptimized(paramFragmentManagerImpl, localArrayList2, localArrayList1, (ArrayList)localObject3, paramArrayMap);
    setViewVisibility(paramView, 0);
    FragmentTransitionCompat21.swapSharedElementTargets(paramFragmentContainerTransition, localArrayList2, localArrayList1);
  }
  
  private static void configureTransitionsUnoptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap)
  {
    ViewGroup localViewGroup = (ViewGroup)mContainer.onFindViewById(paramInt);
    if (localViewGroup == null) {}
    Fragment localFragment;
    Object localObject3;
    Object localObject1;
    ArrayList localArrayList1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localFragment = lastIn;
        localObject3 = firstOut;
        boolean bool1 = lastInIsPop;
        boolean bool2 = firstOutIsPop;
        localObject1 = getEnterTransition(localFragment, bool1);
        paramFragmentManagerImpl = getExitTransition((Fragment)localObject3, bool2);
        localArrayList2 = new ArrayList();
        localArrayList1 = new ArrayList();
        localObject2 = configureSharedElementsUnoptimized(localViewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList2, localArrayList1, localObject1, paramFragmentManagerImpl);
      } while ((localObject1 == null) && (localObject2 == null) && (paramFragmentManagerImpl == null));
      localObject3 = configureEnteringExitingViews(paramFragmentManagerImpl, (Fragment)localObject3, localArrayList2, paramView);
      if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
        paramFragmentManagerImpl = null;
      }
      FragmentTransitionCompat21.addTarget(localObject1, paramView);
      paramFragmentContainerTransition = mergeTransitions(localObject1, paramFragmentManagerImpl, localObject2, localFragment, lastInIsPop);
    } while (paramFragmentContainerTransition == null);
    ArrayList localArrayList2 = new ArrayList();
    FragmentTransitionCompat21.scheduleRemoveTargets(paramFragmentContainerTransition, localObject1, localArrayList2, paramFragmentManagerImpl, (ArrayList)localObject3, localObject2, localArrayList1);
    scheduleTargetChange(localViewGroup, localFragment, paramView, localArrayList1, localObject1, localArrayList2, paramFragmentManagerImpl, (ArrayList)localObject3);
    FragmentTransitionCompat21.setNameOverridesUnoptimized(localViewGroup, localArrayList1, paramArrayMap);
    FragmentTransitionCompat21.beginDelayedTransition(localViewGroup, paramFragmentContainerTransition);
    FragmentTransitionCompat21.scheduleNameReset(localViewGroup, localArrayList1, paramArrayMap);
  }
  
  private static FragmentContainerTransition ensureContainer(FragmentContainerTransition paramFragmentContainerTransition, SparseArray<FragmentContainerTransition> paramSparseArray, int paramInt)
  {
    FragmentContainerTransition localFragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null)
    {
      localFragmentContainerTransition = new FragmentContainerTransition();
      paramSparseArray.put(paramInt, localFragmentContainerTransition);
    }
    return localFragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap<String, String> paramArrayMap, String paramString)
  {
    int j = paramArrayMap.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramArrayMap.valueAt(i))) {
        return (String)paramArrayMap.keyAt(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static Object getEnterTransition(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition()) {
      return FragmentTransitionCompat21.cloneTransition(paramFragment);
    }
  }
  
  private static Object getExitTransition(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition()) {
      return FragmentTransitionCompat21.cloneTransition(paramFragment);
    }
  }
  
  private static View getInEpicenterView(ArrayMap<String, View> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean)
  {
    paramFragmentContainerTransition = lastInTransaction;
    if ((paramObject != null) && (mSharedElementSourceNames != null) && (!mSharedElementSourceNames.isEmpty()))
    {
      if (paramBoolean) {}
      for (paramFragmentContainerTransition = (String)mSharedElementSourceNames.get(0);; paramFragmentContainerTransition = (String)mSharedElementTargetNames.get(0)) {
        return (View)paramArrayMap.get(paramFragmentContainerTransition);
      }
    }
    return null;
  }
  
  private static Object getSharedElementTransition(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition()) {
      return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(paramFragment1));
    }
  }
  
  private static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramObject1 != null)
    {
      bool1 = bool2;
      if (paramObject2 != null)
      {
        bool1 = bool2;
        if (paramFragment != null) {
          if (!paramBoolean) {
            break label50;
          }
        }
      }
    }
    label50:
    for (bool1 = paramFragment.getAllowReturnTransitionOverlap(); bool1; bool1 = paramFragment.getAllowEnterTransitionOverlap()) {
      return FragmentTransitionCompat21.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3);
    }
    return FragmentTransitionCompat21.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static void replaceHide(Object paramObject, Fragment paramFragment, final ArrayList<View> paramArrayList)
  {
    if ((paramFragment != null) && (paramObject != null) && (mAdded) && (mHidden) && (mHiddenChanged))
    {
      paramFragment.setHideReplaced(true);
      FragmentTransitionCompat21.scheduleHideFragmentView(paramObject, paramFragment.getView(), paramArrayList);
      paramObject = mContainer;
      paramObject.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          val$container.getViewTreeObserver().removeOnPreDrawListener(this);
          FragmentTransition.setViewVisibility(paramArrayList, 4);
          return true;
        }
      });
    }
  }
  
  private static void retainValues(ArrayMap<String, String> paramArrayMap, ArrayMap<String, View> paramArrayMap1)
  {
    int i = paramArrayMap.size() - 1;
    while (i >= 0)
    {
      if (!paramArrayMap1.containsKey((String)paramArrayMap.valueAt(i))) {
        paramArrayMap.removeAt(i);
      }
      i -= 1;
    }
  }
  
  private static void scheduleTargetChange(ViewGroup paramViewGroup, final Fragment paramFragment, final View paramView, final ArrayList<View> paramArrayList1, final Object paramObject1, final ArrayList<View> paramArrayList2, final Object paramObject2, final ArrayList<View> paramArrayList3)
  {
    paramViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
        ArrayList localArrayList;
        if (paramObject1 != null)
        {
          FragmentTransitionCompat21.removeTarget(paramObject1, paramView);
          localArrayList = FragmentTransition.configureEnteringExitingViews(paramObject1, paramFragment, paramArrayList1, paramView);
          paramArrayList2.addAll(localArrayList);
        }
        if (paramArrayList3 != null)
        {
          localArrayList = new ArrayList();
          localArrayList.add(paramView);
          FragmentTransitionCompat21.replaceTargets(paramObject2, paramArrayList3, localArrayList);
          paramArrayList3.clear();
          paramArrayList3.add(paramView);
        }
        return true;
      }
    });
  }
  
  private static void setOutEpicenter(Object paramObject1, Object paramObject2, ArrayMap<String, View> paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord)
  {
    if ((mSharedElementSourceNames != null) && (!mSharedElementSourceNames.isEmpty())) {
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (paramBackStackRecord = (String)mSharedElementTargetNames.get(0);; paramBackStackRecord = (String)mSharedElementSourceNames.get(0))
    {
      paramArrayMap = (View)paramArrayMap.get(paramBackStackRecord);
      FragmentTransitionCompat21.setEpicenter(paramObject1, paramArrayMap);
      if (paramObject2 != null) {
        FragmentTransitionCompat21.setEpicenter(paramObject2, paramArrayMap);
      }
      return;
    }
  }
  
  private static void setViewVisibility(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        ((View)paramArrayList.get(i)).setVisibility(paramInt);
        i -= 1;
      }
    }
  }
  
  static void startTransitions(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((mCurState < 1) || (Build.VERSION.SDK_INT < 21)) {}
    SparseArray localSparseArray;
    do
    {
      return;
      localSparseArray = new SparseArray();
      i = paramInt1;
      if (i < paramInt2)
      {
        localObject = (BackStackRecord)paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
          calculatePopFragments((BackStackRecord)localObject, localSparseArray, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          calculateFragments((BackStackRecord)localObject, localSparseArray, paramBoolean);
        }
      }
    } while (localSparseArray.size() == 0);
    Object localObject = new View(mHost.getContext());
    int j = localSparseArray.size();
    int i = 0;
    label126:
    int k;
    ArrayMap localArrayMap;
    FragmentContainerTransition localFragmentContainerTransition;
    if (i < j)
    {
      k = localSparseArray.keyAt(i);
      localArrayMap = calculateNameOverrides(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
      localFragmentContainerTransition = (FragmentContainerTransition)localSparseArray.valueAt(i);
      if (!paramBoolean) {
        break label192;
      }
      configureTransitionsOptimized(paramFragmentManagerImpl, k, localFragmentContainerTransition, (View)localObject, localArrayMap);
    }
    for (;;)
    {
      i += 1;
      break label126;
      break;
      label192:
      configureTransitionsUnoptimized(paramFragmentManagerImpl, k, localFragmentContainerTransition, (View)localObject, localArrayMap);
    }
  }
  
  static class FragmentContainerTransition
  {
    public Fragment firstOut;
    public boolean firstOutIsPop;
    public BackStackRecord firstOutTransaction;
    public Fragment lastIn;
    public boolean lastInIsPop;
    public BackStackRecord lastInTransaction;
    
    FragmentContainerTransition() {}
  }
}
