package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker
  implements Runnable
{
  static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
  static Comparator<Task> sTaskComparator = new Comparator()
  {
    public int compare(GapWorker.Task paramAnonymousTask1, GapWorker.Task paramAnonymousTask2)
    {
      int k = -1;
      int j;
      if (view == null)
      {
        i = 1;
        if (view != null) {
          break label42;
        }
        j = 1;
      }
      for (;;)
      {
        if (i != j)
        {
          if (view == null)
          {
            return 1;
            i = 0;
            break;
            label42:
            j = 0;
            continue;
          }
          return -1;
        }
      }
      if (immediate != immediate)
      {
        if (immediate) {}
        for (i = k;; i = 1) {
          return i;
        }
      }
      int i = viewVelocity - viewVelocity;
      if (i != 0) {
        return i;
      }
      i = distanceToItem - distanceToItem;
      if (i != 0) {
        return i;
      }
      return 0;
    }
  };
  long mFrameIntervalNs;
  long mPostTimeNs;
  ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
  private ArrayList<Task> mTasks = new ArrayList();
  
  GapWorker() {}
  
  private void buildTaskList()
  {
    int m = mRecyclerViews.size();
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (RecyclerView)mRecyclerViews.get(i);
      mPrefetchRegistry.collectPrefetchPositionsFromView((RecyclerView)localObject, false);
      j += mPrefetchRegistry.mCount;
      i += 1;
    }
    mTasks.ensureCapacity(j);
    j = 0;
    i = 0;
    while (i < m)
    {
      RecyclerView localRecyclerView = (RecyclerView)mRecyclerViews.get(i);
      LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = mPrefetchRegistry;
      int n = Math.abs(mPrefetchDx) + Math.abs(mPrefetchDy);
      int k = 0;
      if (k < mCount * 2)
      {
        label161:
        int i1;
        if (j >= mTasks.size())
        {
          localObject = new Task();
          mTasks.add(localObject);
          i1 = mPrefetchArray[(k + 1)];
          if (i1 > n) {
            break label249;
          }
        }
        label249:
        for (boolean bool = true;; bool = false)
        {
          immediate = bool;
          viewVelocity = n;
          distanceToItem = i1;
          view = localRecyclerView;
          position = mPrefetchArray[k];
          j += 1;
          k += 2;
          break;
          localObject = (Task)mTasks.get(j);
          break label161;
        }
      }
      i += 1;
    }
    Collections.sort(mTasks, sTaskComparator);
  }
  
  private void flushTaskWithDeadline(Task paramTask, long paramLong)
  {
    if (immediate) {}
    for (long l = Long.MAX_VALUE;; l = paramLong)
    {
      paramTask = prefetchPositionWithDeadline(view, position, l);
      if ((paramTask != null) && (mNestedRecyclerView != null)) {
        prefetchInnerRecyclerViewWithDeadline((RecyclerView)mNestedRecyclerView.get(), paramLong);
      }
      return;
    }
  }
  
  private void flushTasksWithDeadline(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      Task localTask;
      if (i < mTasks.size())
      {
        localTask = (Task)mTasks.get(i);
        if (view != null) {}
      }
      else
      {
        return;
      }
      flushTaskWithDeadline(localTask, paramLong);
      localTask.clear();
      i += 1;
    }
  }
  
  static boolean isPrefetchPositionAttached(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if ((mPosition == paramInt) && (!localViewHolder.isInvalid())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {}
    LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl;
    do
    {
      return;
      if ((mDataSetHasChangedAfterLayout) && (mChildHelper.getUnfilteredChildCount() != 0)) {
        paramRecyclerView.removeAndRecycleViews();
      }
      localLayoutPrefetchRegistryImpl = mPrefetchRegistry;
      localLayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(paramRecyclerView, true);
    } while (mCount == 0);
    try
    {
      TraceCompat.beginSection("RV Nested Prefetch");
      mState.prepareForNestedPrefetch(mAdapter);
      int i = 0;
      while (i < mCount * 2)
      {
        prefetchPositionWithDeadline(paramRecyclerView, mPrefetchArray[i], paramLong);
        i += 2;
      }
      return;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (isPrefetchPositionAttached(paramRecyclerView, paramInt)) {
      paramRecyclerView = null;
    }
    RecyclerView.Recycler localRecycler;
    RecyclerView.ViewHolder localViewHolder;
    do
    {
      return paramRecyclerView;
      localRecycler = mRecycler;
      localViewHolder = localRecycler.tryGetViewHolderForPositionByDeadline(paramInt, false, paramLong);
      paramRecyclerView = localViewHolder;
    } while (localViewHolder == null);
    if (localViewHolder.isBound())
    {
      localRecycler.recycleView(itemView);
      return localViewHolder;
    }
    localRecycler.addViewHolderToRecycledViewPool(localViewHolder, false);
    return localViewHolder;
  }
  
  public void add(RecyclerView paramRecyclerView)
  {
    mRecyclerViews.add(paramRecyclerView);
  }
  
  void postFromTraversal(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (mPostTimeNs == 0L))
    {
      mPostTimeNs = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    mPrefetchRegistry.setPrefetchVector(paramInt1, paramInt2);
  }
  
  void prefetch(long paramLong)
  {
    buildTaskList();
    flushTasksWithDeadline(paramLong);
  }
  
  public void remove(RecyclerView paramRecyclerView)
  {
    mRecyclerViews.remove(paramRecyclerView);
  }
  
  public void run()
  {
    try
    {
      TraceCompat.beginSection("RV Prefetch");
      boolean bool = mRecyclerViews.isEmpty();
      if (bool) {
        return;
      }
      long l = TimeUnit.MILLISECONDS.toNanos(((RecyclerView)mRecyclerViews.get(0)).getDrawingTime());
      if (l == 0L) {
        return;
      }
      prefetch(l + mFrameIntervalNs);
      return;
    }
    finally
    {
      mPostTimeNs = 0L;
      TraceCompat.endSection();
    }
  }
  
  static class LayoutPrefetchRegistryImpl
    implements RecyclerView.LayoutManager.LayoutPrefetchRegistry
  {
    int mCount;
    int[] mPrefetchArray;
    int mPrefetchDx;
    int mPrefetchDy;
    
    LayoutPrefetchRegistryImpl() {}
    
    public void addPosition(int paramInt1, int paramInt2)
    {
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      int i = mCount * 2;
      if (mPrefetchArray == null)
      {
        mPrefetchArray = new int[4];
        Arrays.fill(mPrefetchArray, -1);
      }
      for (;;)
      {
        mPrefetchArray[i] = paramInt1;
        mPrefetchArray[(i + 1)] = paramInt2;
        mCount += 1;
        return;
        if (i >= mPrefetchArray.length)
        {
          int[] arrayOfInt = mPrefetchArray;
          mPrefetchArray = new int[i * 2];
          System.arraycopy(arrayOfInt, 0, mPrefetchArray, 0, arrayOfInt.length);
        }
      }
    }
    
    void clearPrefetchPositions()
    {
      if (mPrefetchArray != null) {
        Arrays.fill(mPrefetchArray, -1);
      }
    }
    
    void collectPrefetchPositionsFromView(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      mCount = 0;
      if (mPrefetchArray != null) {
        Arrays.fill(mPrefetchArray, -1);
      }
      RecyclerView.LayoutManager localLayoutManager = mLayout;
      if ((mAdapter != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
      {
        if (!paramBoolean) {
          break label101;
        }
        if (!mAdapterHelper.hasPendingUpdates()) {
          localLayoutManager.collectInitialPrefetchPositions(mAdapter.getItemCount(), this);
        }
      }
      for (;;)
      {
        if (mCount > mPrefetchMaxCountObserved)
        {
          mPrefetchMaxCountObserved = mCount;
          mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          mRecycler.updateViewCacheSize();
        }
        return;
        label101:
        if (!paramRecyclerView.hasPendingAdapterUpdates()) {
          localLayoutManager.collectAdjacentPrefetchPositions(mPrefetchDx, mPrefetchDy, mState, this);
        }
      }
    }
    
    boolean lastPrefetchIncludedPosition(int paramInt)
    {
      if (mPrefetchArray != null)
      {
        int j = mCount;
        int i = 0;
        while (i < j * 2)
        {
          if (mPrefetchArray[i] == paramInt) {
            return true;
          }
          i += 2;
        }
      }
      return false;
    }
    
    void setPrefetchVector(int paramInt1, int paramInt2)
    {
      mPrefetchDx = paramInt1;
      mPrefetchDy = paramInt2;
    }
  }
  
  static class Task
  {
    public int distanceToItem;
    public boolean immediate;
    public int position;
    public RecyclerView view;
    public int viewVelocity;
    
    Task() {}
    
    public void clear()
    {
      immediate = false;
      viewVelocity = 0;
      distanceToItem = 0;
      view = null;
      position = 0;
    }
  }
}
