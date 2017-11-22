package android.support.v7.util;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil
{
  private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator()
  {
    public int compare(DiffUtil.Snake paramAnonymousSnake1, DiffUtil.Snake paramAnonymousSnake2)
    {
      int j = x - x;
      int i = j;
      if (j == 0) {
        i = y - y;
      }
      return i;
    }
  };
  
  private DiffUtil() {}
  
  public static DiffResult calculateDiff(Callback paramCallback)
  {
    return calculateDiff(paramCallback, true);
  }
  
  public static DiffResult calculateDiff(Callback paramCallback, boolean paramBoolean)
  {
    int i = paramCallback.getOldListSize();
    int j = paramCallback.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new Range(0, i, 0, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      Range localRange2 = (Range)localArrayList2.remove(localArrayList2.size() - 1);
      Snake localSnake = diffPartial(paramCallback, oldListStart, oldListEnd, newListStart, newListEnd, arrayOfInt1, arrayOfInt2, i);
      if (localSnake != null)
      {
        if (size > 0) {
          localArrayList1.add(localSnake);
        }
        x += oldListStart;
        y += newListStart;
        Range localRange1;
        if (localArrayList3.isEmpty())
        {
          localRange1 = new Range();
          label217:
          oldListStart = oldListStart;
          newListStart = newListStart;
          if (!reverse) {
            break label362;
          }
          oldListEnd = x;
          newListEnd = y;
          label265:
          localArrayList2.add(localRange1);
          if (!reverse) {
            break label457;
          }
          if (!removal) {
            break label420;
          }
          oldListStart = (x + size + 1);
          newListStart = (y + size);
        }
        for (;;)
        {
          localArrayList2.add(localRange2);
          break;
          localRange1 = (Range)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (removal)
          {
            oldListEnd = (x - 1);
            newListEnd = y;
            break label265;
          }
          oldListEnd = x;
          newListEnd = (y - 1);
          break label265;
          label420:
          oldListStart = (x + size);
          newListStart = (y + size + 1);
          continue;
          label457:
          oldListStart = (x + size);
          newListStart = (y + size);
        }
      }
      localArrayList3.add(localRange2);
    }
    Collections.sort(localArrayList1, SNAKE_COMPARATOR);
    return new DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static Snake diffPartial(Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int m = paramInt2 - paramInt1;
    int n = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 < 1) || (paramInt4 - paramInt3 < 1)) {
      return null;
    }
    int i1 = m - n;
    int i2 = (m + n + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i2 - 1, paramInt5 + i2 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i2 - 1 + i1, paramInt5 + i2 + 1 + i1, m);
    int i;
    if (i1 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i2) {
        break label658;
      }
      int j = -i;
      boolean bool;
      int k;
      for (;;)
      {
        if (j > i) {
          break label379;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2 - j;
          while ((paramInt2 < m) && (k < n) && (paramCallback.areItemsTheSame(paramInt1 + paramInt2, paramInt3 + k)))
          {
            paramInt2 += 1;
            k += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = paramInt2;
        if ((paramInt4 != 0) && (j >= i1 - i + 1) && (j <= i1 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          paramCallback = new Snake();
          x = paramArrayOfInt2[(paramInt5 + j)];
          y = (x - j);
          size = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          removal = bool;
          reverse = false;
          return paramCallback;
        }
        j += 2;
      }
      label379:
      j = -i;
      while (j <= i)
      {
        int i3 = j + i1;
        if ((i3 == i + i1) || ((i3 != -i + i1) && (paramArrayOfInt2[(paramInt5 + i3 - 1)] < paramArrayOfInt2[(paramInt5 + i3 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 - 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2 - i3;
          while ((paramInt2 > 0) && (k > 0) && (paramCallback.areItemsTheSame(paramInt1 + paramInt2 - 1, paramInt3 + k - 1)))
          {
            paramInt2 -= 1;
            k -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = paramInt2;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramCallback = new Snake();
          x = paramArrayOfInt2[(paramInt5 + i3)];
          y = (x - i3);
          size = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          removal = bool;
          reverse = true;
          return paramCallback;
        }
        j += 2;
      }
      i += 1;
    }
    label658:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
  
  public static abstract class Callback
  {
    public Callback() {}
    
    public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);
    
    public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);
    
    @Nullable
    public Object getChangePayload(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract int getNewListSize();
    
    public abstract int getOldListSize();
  }
  
  public static class DiffResult
  {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_IGNORE = 16;
    private static final int FLAG_MASK = 31;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 5;
    private final DiffUtil.Callback mCallback;
    private final boolean mDetectMoves;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;
    private final List<DiffUtil.Snake> mSnakes;
    
    DiffResult(DiffUtil.Callback paramCallback, List<DiffUtil.Snake> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      mSnakes = paramList;
      mOldItemStatuses = paramArrayOfInt1;
      mNewItemStatuses = paramArrayOfInt2;
      Arrays.fill(mOldItemStatuses, 0);
      Arrays.fill(mNewItemStatuses, 0);
      mCallback = paramCallback;
      mOldListSize = paramCallback.getOldListSize();
      mNewListSize = paramCallback.getNewListSize();
      mDetectMoves = paramBoolean;
      addRootSnake();
      findMatchingItems();
    }
    
    private void addRootSnake()
    {
      if (mSnakes.isEmpty()) {}
      for (DiffUtil.Snake localSnake = null;; localSnake = (DiffUtil.Snake)mSnakes.get(0))
      {
        if ((localSnake == null) || (x != 0) || (y != 0))
        {
          localSnake = new DiffUtil.Snake();
          x = 0;
          y = 0;
          removal = false;
          size = 0;
          reverse = false;
          mSnakes.add(0, localSnake);
        }
        return;
      }
    }
    
    private void dispatchAdditions(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!mDetectMoves) {
        paramListUpdateCallback.onInserted(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = mNewItemStatuses[(paramInt3 + paramInt2)] & 0x1F;
      Iterator localIterator;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt3 + paramInt2) + " " + Long.toBinaryString(i));
      case 0: 
        paramListUpdateCallback.onInserted(paramInt1, 1);
        localIterator = paramList.iterator();
      case 4: 
      case 8: 
        while (localIterator.hasNext())
        {
          DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)localIterator.next();
          currentPos += 1;
          continue;
          int j = mNewItemStatuses[(paramInt3 + paramInt2)] >> 5;
          paramListUpdateCallback.onMoved(removePostponedUpdatecurrentPos, paramInt1);
          if (i == 4) {
            paramListUpdateCallback.onChanged(paramInt1, 1, mCallback.getChangePayload(j, paramInt3 + paramInt2));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new DiffUtil.PostponedUpdate(paramInt3 + paramInt2, paramInt1, false));
      }
    }
    
    private void dispatchRemovals(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!mDetectMoves) {
        paramListUpdateCallback.onRemoved(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = mOldItemStatuses[(paramInt3 + paramInt2)] & 0x1F;
      Object localObject;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt3 + paramInt2) + " " + Long.toBinaryString(i));
      case 0: 
        paramListUpdateCallback.onRemoved(paramInt1 + paramInt2, 1);
        localObject = paramList.iterator();
      case 4: 
      case 8: 
        while (((Iterator)localObject).hasNext())
        {
          DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
          currentPos -= 1;
          continue;
          int j = mOldItemStatuses[(paramInt3 + paramInt2)] >> 5;
          localObject = removePostponedUpdate(paramList, j, false);
          paramListUpdateCallback.onMoved(paramInt1 + paramInt2, currentPos - 1);
          if (i == 4) {
            paramListUpdateCallback.onChanged(currentPos - 1, 1, mCallback.getChangePayload(paramInt3 + paramInt2, j));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new DiffUtil.PostponedUpdate(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
      }
    }
    
    private void findAddition(int paramInt1, int paramInt2, int paramInt3)
    {
      if (mOldItemStatuses[(paramInt1 - 1)] != 0) {
        return;
      }
      findMatchingItem(paramInt1, paramInt2, paramInt3, false);
    }
    
    private boolean findMatchingItem(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int j;
      int k;
      int i;
      if (paramBoolean)
      {
        j = paramInt2 - 1;
        k = paramInt1;
        i = paramInt2 - 1;
        paramInt2 = k;
      }
      while (paramInt3 >= 0)
      {
        DiffUtil.Snake localSnake = (DiffUtil.Snake)mSnakes.get(paramInt3);
        k = x;
        int m = size;
        int n = y;
        int i1 = size;
        if (paramBoolean)
        {
          paramInt2 -= 1;
          for (;;)
          {
            if (paramInt2 < k + m) {
              break label257;
            }
            if (mCallback.areItemsTheSame(paramInt2, j))
            {
              if (mCallback.areContentsTheSame(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                mNewItemStatuses[j] = (paramInt2 << 5 | 0x10);
                mOldItemStatuses[paramInt2] = (j << 5 | paramInt1);
                return true;
                j = paramInt1 - 1;
                k = paramInt1 - 1;
                i = paramInt2;
                paramInt2 = k;
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
        paramInt2 = i - 1;
        while (paramInt2 >= n + i1)
        {
          if (mCallback.areItemsTheSame(j, paramInt2))
          {
            if (mCallback.areContentsTheSame(j, paramInt2)) {}
            for (paramInt3 = 8;; paramInt3 = 4)
            {
              mOldItemStatuses[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              mNewItemStatuses[paramInt2] = (paramInt1 - 1 << 5 | paramInt3);
              return true;
            }
          }
          paramInt2 -= 1;
        }
        label257:
        paramInt2 = x;
        i = y;
        paramInt3 -= 1;
      }
      return false;
    }
    
    private void findMatchingItems()
    {
      int j = mOldListSize;
      int i = mNewListSize;
      int k = mSnakes.size() - 1;
      while (k >= 0)
      {
        DiffUtil.Snake localSnake = (DiffUtil.Snake)mSnakes.get(k);
        int i2 = x;
        int i3 = size;
        int n = y;
        int i1 = size;
        int m;
        if (mDetectMoves)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            findAddition(j, i, k);
            j -= 1;
          }
          while (m > n + i1)
          {
            findRemoval(j, m, k);
            m -= 1;
          }
        }
        i = 0;
        if (i < size)
        {
          m = x + i;
          n = y + i;
          if (mCallback.areContentsTheSame(m, n)) {}
          for (j = 1;; j = 2)
          {
            mOldItemStatuses[m] = (n << 5 | j);
            mNewItemStatuses[n] = (m << 5 | j);
            i += 1;
            break;
          }
        }
        j = x;
        i = y;
        k -= 1;
      }
    }
    
    private void findRemoval(int paramInt1, int paramInt2, int paramInt3)
    {
      if (mNewItemStatuses[(paramInt2 - 1)] != 0) {
        return;
      }
      findMatchingItem(paramInt1, paramInt2, paramInt3, true);
    }
    
    private static DiffUtil.PostponedUpdate removePostponedUpdate(List<DiffUtil.PostponedUpdate> paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        DiffUtil.PostponedUpdate localPostponedUpdate2 = (DiffUtil.PostponedUpdate)paramList.get(i);
        if ((posInOwnerList == paramInt) && (removal == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          localPostponedUpdate1 = localPostponedUpdate2;
          if (paramInt >= paramList.size()) {
            break label123;
          }
          localPostponedUpdate1 = (DiffUtil.PostponedUpdate)paramList.get(paramInt);
          int j = currentPos;
          if (paramBoolean) {}
          for (i = 1;; i = -1)
          {
            currentPos = (i + j);
            paramInt += 1;
            break;
          }
        }
        i -= 1;
      }
      DiffUtil.PostponedUpdate localPostponedUpdate1 = null;
      label123:
      return localPostponedUpdate1;
    }
    
    public void dispatchUpdatesTo(ListUpdateCallback paramListUpdateCallback)
    {
      ArrayList localArrayList;
      int k;
      int j;
      int i;
      if ((paramListUpdateCallback instanceof BatchingListUpdateCallback))
      {
        paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
        localArrayList = new ArrayList();
        k = mOldListSize;
        j = mNewListSize;
        i = mSnakes.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label234;
        }
        DiffUtil.Snake localSnake = (DiffUtil.Snake)mSnakes.get(i);
        int m = size;
        int n = x + m;
        int i1 = y + m;
        if (n < k) {
          dispatchRemovals(localArrayList, paramListUpdateCallback, n, k - n, n);
        }
        if (i1 < j) {
          dispatchAdditions(localArrayList, paramListUpdateCallback, n, j - i1, i1);
        }
        j = m - 1;
        for (;;)
        {
          if (j >= 0)
          {
            if ((mOldItemStatuses[(x + j)] & 0x1F) == 2) {
              paramListUpdateCallback.onChanged(x + j, 1, mCallback.getChangePayload(x + j, y + j));
            }
            j -= 1;
            continue;
            paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
            break;
          }
        }
        k = x;
        j = y;
        i -= 1;
      }
      label234:
      paramListUpdateCallback.dispatchLastEvent();
    }
    
    public void dispatchUpdatesTo(final RecyclerView.Adapter paramAdapter)
    {
      dispatchUpdatesTo(new ListUpdateCallback()
      {
        public void onChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          paramAdapter.notifyItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        
        public void onInserted(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAdapter.notifyItemRangeInserted(paramAnonymousInt1, paramAnonymousInt2);
        }
        
        public void onMoved(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAdapter.notifyItemMoved(paramAnonymousInt1, paramAnonymousInt2);
        }
        
        public void onRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAdapter.notifyItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        }
      });
    }
    
    @VisibleForTesting
    List<DiffUtil.Snake> getSnakes()
    {
      return mSnakes;
    }
  }
  
  private static class PostponedUpdate
  {
    int currentPos;
    int posInOwnerList;
    boolean removal;
    
    public PostponedUpdate(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      posInOwnerList = paramInt1;
      currentPos = paramInt2;
      removal = paramBoolean;
    }
  }
  
  static class Range
  {
    int newListEnd;
    int newListStart;
    int oldListEnd;
    int oldListStart;
    
    public Range() {}
    
    public Range(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      oldListStart = paramInt1;
      oldListEnd = paramInt2;
      newListStart = paramInt3;
      newListEnd = paramInt4;
    }
  }
  
  static class Snake
  {
    boolean removal;
    boolean reverse;
    int size;
    int x;
    int y;
    
    Snake() {}
  }
}
