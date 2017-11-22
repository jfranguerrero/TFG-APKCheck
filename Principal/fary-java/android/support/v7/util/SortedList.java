package android.support.v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T>
{
  private static final int CAPACITY_GROWTH = 10;
  private static final int DELETION = 2;
  private static final int INSERTION = 1;
  public static final int INVALID_POSITION = -1;
  private static final int LOOKUP = 4;
  private static final int MIN_CAPACITY = 10;
  private BatchedCallback mBatchedCallback;
  private Callback mCallback;
  T[] mData;
  private int mMergedSize;
  private T[] mOldData;
  private int mOldDataSize;
  private int mOldDataStart;
  private int mSize;
  private final Class<T> mTClass;
  
  public SortedList(Class<T> paramClass, Callback<T> paramCallback)
  {
    this(paramClass, paramCallback, 10);
  }
  
  public SortedList(Class<T> paramClass, Callback<T> paramCallback, int paramInt)
  {
    mTClass = paramClass;
    mData = ((Object[])Array.newInstance(paramClass, paramInt));
    mCallback = paramCallback;
    mSize = 0;
  }
  
  private int add(T paramT, boolean paramBoolean)
  {
    int j = findIndexOf(paramT, mData, 0, mSize, 1);
    int i;
    if (j == -1) {
      i = 0;
    }
    Object localObject;
    do
    {
      do
      {
        addToData(i, paramT);
        if (paramBoolean) {
          mCallback.onInserted(i, 1);
        }
        return i;
        i = j;
      } while (j >= mSize);
      localObject = mData[j];
      i = j;
    } while (!mCallback.areItemsTheSame(localObject, paramT));
    if (mCallback.areContentsTheSame(localObject, paramT))
    {
      mData[j] = paramT;
      return j;
    }
    mData[j] = paramT;
    mCallback.onChanged(j, 1);
    return j;
  }
  
  private void addAllInternal(T[] paramArrayOfT)
  {
    int i;
    int j;
    if (!(mCallback instanceof BatchedCallback))
    {
      i = 1;
      if (i != 0) {
        beginBatchedUpdates();
      }
      mOldData = mData;
      mOldDataStart = 0;
      mOldDataSize = mSize;
      Arrays.sort(paramArrayOfT, mCallback);
      j = deduplicate(paramArrayOfT);
      if (mSize != 0) {
        break label105;
      }
      mData = paramArrayOfT;
      mSize = j;
      mMergedSize = j;
      mCallback.onInserted(0, j);
    }
    for (;;)
    {
      mOldData = null;
      if (i != 0) {
        endBatchedUpdates();
      }
      return;
      i = 0;
      break;
      label105:
      merge(paramArrayOfT, j);
    }
  }
  
  private void addToData(int paramInt, T paramT)
  {
    if (paramInt > mSize) {
      throw new IndexOutOfBoundsException("cannot add item to " + paramInt + " because size is " + mSize);
    }
    if (mSize == mData.length)
    {
      Object[] arrayOfObject = (Object[])Array.newInstance(mTClass, mData.length + 10);
      System.arraycopy(mData, 0, arrayOfObject, 0, paramInt);
      arrayOfObject[paramInt] = paramT;
      System.arraycopy(mData, paramInt, arrayOfObject, paramInt + 1, mSize - paramInt);
      mData = arrayOfObject;
    }
    for (;;)
    {
      mSize += 1;
      return;
      System.arraycopy(mData, paramInt, mData, paramInt + 1, mSize - paramInt);
      mData[paramInt] = paramT;
    }
  }
  
  private int deduplicate(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length == 0) {
      throw new IllegalArgumentException("Input array must be non-empty");
    }
    int k = 0;
    int i = 1;
    int j = 1;
    if (j < paramArrayOfT.length)
    {
      T ? = paramArrayOfT[j];
      int m = mCallback.compare(paramArrayOfT[k], ?);
      if (m > 0) {
        throw new IllegalArgumentException("Input must be sorted in ascending order.");
      }
      if (m == 0)
      {
        m = findSameItem(?, paramArrayOfT, k, i);
        if (m != -1) {
          paramArrayOfT[m] = ?;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (i != j) {
          paramArrayOfT[i] = ?;
        }
        i += 1;
        continue;
        if (i != j) {
          paramArrayOfT[i] = ?;
        }
        k = i;
        i += 1;
      }
    }
    return i;
  }
  
  private int findIndexOf(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      int i = (paramInt1 + paramInt2) / 2;
      T ? = paramArrayOfT[i];
      int j = mCallback.compare(?, paramT);
      if (j < 0)
      {
        paramInt1 = i + 1;
      }
      else
      {
        if (j == 0)
        {
          if (mCallback.areItemsTheSame(?, paramT)) {}
          do
          {
            return i;
            paramInt1 = linearEqualitySearch(paramT, i, paramInt1, paramInt2);
            if (paramInt3 != 1) {
              break;
            }
          } while (paramInt1 == -1);
          return paramInt1;
          return paramInt1;
        }
        paramInt2 = i;
      }
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      return paramInt1;
      paramInt1 = -1;
    }
  }
  
  private int findSameItem(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (mCallback.areItemsTheSame(paramArrayOfT[paramInt1], paramT)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  private int linearEqualitySearch(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 - 1;
    Object localObject;
    if (i >= paramInt2)
    {
      localObject = mData[i];
      if (mCallback.compare(localObject, paramT) == 0) {}
    }
    else
    {
      paramInt1 += 1;
    }
    for (;;)
    {
      if (paramInt1 < paramInt3)
      {
        localObject = mData[paramInt1];
        if (mCallback.compare(localObject, paramT) == 0) {}
      }
      else
      {
        return -1;
        if (mCallback.areItemsTheSame(localObject, paramT)) {
          return i;
        }
        i -= 1;
        break;
      }
      if (mCallback.areItemsTheSame(localObject, paramT)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
  }
  
  private void merge(T[] paramArrayOfT, int paramInt)
  {
    int i = mSize;
    mData = ((Object[])Array.newInstance(mTClass, i + paramInt + 10));
    mMergedSize = 0;
    i = 0;
    for (;;)
    {
      if ((mOldDataStart < mOldDataSize) || (i < paramInt))
      {
        if (mOldDataStart == mOldDataSize)
        {
          paramInt -= i;
          System.arraycopy(paramArrayOfT, i, mData, mMergedSize, paramInt);
          mMergedSize += paramInt;
          mSize += paramInt;
          mCallback.onInserted(mMergedSize - paramInt, paramInt);
        }
      }
      else {
        return;
      }
      if (i == paramInt)
      {
        paramInt = mOldDataSize - mOldDataStart;
        System.arraycopy(mOldData, mOldDataStart, mData, mMergedSize, paramInt);
        mMergedSize += paramInt;
        return;
      }
      Object localObject1 = mOldData[mOldDataStart];
      Object localObject2 = paramArrayOfT[i];
      int j = mCallback.compare(localObject1, localObject2);
      if (j > 0)
      {
        localObject1 = mData;
        j = mMergedSize;
        mMergedSize = (j + 1);
        localObject1[j] = localObject2;
        mSize += 1;
        i += 1;
        mCallback.onInserted(mMergedSize - 1, 1);
      }
      else if ((j == 0) && (mCallback.areItemsTheSame(localObject1, localObject2)))
      {
        Object[] arrayOfObject = mData;
        j = mMergedSize;
        mMergedSize = (j + 1);
        arrayOfObject[j] = localObject2;
        j = i + 1;
        mOldDataStart += 1;
        i = j;
        if (!mCallback.areContentsTheSame(localObject1, localObject2))
        {
          mCallback.onChanged(mMergedSize - 1, 1);
          i = j;
        }
      }
      else
      {
        localObject2 = mData;
        j = mMergedSize;
        mMergedSize = (j + 1);
        localObject2[j] = localObject1;
        mOldDataStart += 1;
      }
    }
  }
  
  private boolean remove(T paramT, boolean paramBoolean)
  {
    int i = findIndexOf(paramT, mData, 0, mSize, 2);
    if (i == -1) {
      return false;
    }
    removeItemAtIndex(i, paramBoolean);
    return true;
  }
  
  private void removeItemAtIndex(int paramInt, boolean paramBoolean)
  {
    System.arraycopy(mData, paramInt + 1, mData, paramInt, mSize - paramInt - 1);
    mSize -= 1;
    mData[mSize] = null;
    if (paramBoolean) {
      mCallback.onRemoved(paramInt, 1);
    }
  }
  
  private void throwIfMerging()
  {
    if (mOldData != null) {
      throw new IllegalStateException("Cannot call this method from within addAll");
    }
  }
  
  public int add(T paramT)
  {
    throwIfMerging();
    return add(paramT, true);
  }
  
  public void addAll(Collection<T> paramCollection)
  {
    addAll(paramCollection.toArray((Object[])Array.newInstance(mTClass, paramCollection.size())), true);
  }
  
  public void addAll(T... paramVarArgs)
  {
    addAll(paramVarArgs, false);
  }
  
  public void addAll(T[] paramArrayOfT, boolean paramBoolean)
  {
    throwIfMerging();
    if (paramArrayOfT.length == 0) {
      return;
    }
    if (paramBoolean)
    {
      addAllInternal(paramArrayOfT);
      return;
    }
    Object[] arrayOfObject = (Object[])Array.newInstance(mTClass, paramArrayOfT.length);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramArrayOfT.length);
    addAllInternal(arrayOfObject);
  }
  
  public void beginBatchedUpdates()
  {
    throwIfMerging();
    if ((mCallback instanceof BatchedCallback)) {
      return;
    }
    if (mBatchedCallback == null) {
      mBatchedCallback = new BatchedCallback(mCallback);
    }
    mCallback = mBatchedCallback;
  }
  
  public void clear()
  {
    throwIfMerging();
    if (mSize == 0) {
      return;
    }
    int i = mSize;
    Arrays.fill(mData, 0, i, null);
    mSize = 0;
    mCallback.onRemoved(0, i);
  }
  
  public void endBatchedUpdates()
  {
    throwIfMerging();
    if ((mCallback instanceof BatchedCallback)) {
      ((BatchedCallback)mCallback).dispatchLastEvent();
    }
    if (mCallback == mBatchedCallback) {
      mCallback = mBatchedCallback.mWrappedCallback;
    }
  }
  
  public T get(int paramInt)
    throws IndexOutOfBoundsException
  {
    if ((paramInt >= mSize) || (paramInt < 0)) {
      throw new IndexOutOfBoundsException("Asked to get item at " + paramInt + " but size is " + mSize);
    }
    if ((mOldData != null) && (paramInt >= mMergedSize)) {
      return mOldData[(paramInt - mMergedSize + mOldDataStart)];
    }
    return mData[paramInt];
  }
  
  public int indexOf(T paramT)
  {
    if (mOldData != null)
    {
      int i = findIndexOf(paramT, mData, 0, mMergedSize, 4);
      if (i != -1) {
        return i;
      }
      i = findIndexOf(paramT, mOldData, mOldDataStart, mOldDataSize, 4);
      if (i != -1) {
        return i - mOldDataStart + mMergedSize;
      }
      return -1;
    }
    return findIndexOf(paramT, mData, 0, mSize, 4);
  }
  
  public void recalculatePositionOfItemAt(int paramInt)
  {
    throwIfMerging();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, false);
    int i = add(localObject, false);
    if (paramInt != i) {
      mCallback.onMoved(paramInt, i);
    }
  }
  
  public boolean remove(T paramT)
  {
    throwIfMerging();
    return remove(paramT, true);
  }
  
  public T removeItemAt(int paramInt)
  {
    throwIfMerging();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, true);
    return localObject;
  }
  
  public int size()
  {
    return mSize;
  }
  
  public void updateItemAt(int paramInt, T paramT)
  {
    throwIfMerging();
    Object localObject = get(paramInt);
    int i;
    if ((localObject == paramT) || (!mCallback.areContentsTheSame(localObject, paramT)))
    {
      i = 1;
      if ((localObject == paramT) || (mCallback.compare(localObject, paramT) != 0)) {
        break label77;
      }
      mData[paramInt] = paramT;
      if (i != 0) {
        mCallback.onChanged(paramInt, 1);
      }
    }
    label77:
    do
    {
      return;
      i = 0;
      break;
      if (i != 0) {
        mCallback.onChanged(paramInt, 1);
      }
      removeItemAtIndex(paramInt, false);
      i = add(paramT, false);
    } while (paramInt == i);
    mCallback.onMoved(paramInt, i);
  }
  
  public static class BatchedCallback<T2>
    extends SortedList.Callback<T2>
  {
    private final BatchingListUpdateCallback mBatchingListUpdateCallback;
    final SortedList.Callback<T2> mWrappedCallback;
    
    public BatchedCallback(SortedList.Callback<T2> paramCallback)
    {
      mWrappedCallback = paramCallback;
      mBatchingListUpdateCallback = new BatchingListUpdateCallback(mWrappedCallback);
    }
    
    public boolean areContentsTheSame(T2 paramT21, T2 paramT22)
    {
      return mWrappedCallback.areContentsTheSame(paramT21, paramT22);
    }
    
    public boolean areItemsTheSame(T2 paramT21, T2 paramT22)
    {
      return mWrappedCallback.areItemsTheSame(paramT21, paramT22);
    }
    
    public int compare(T2 paramT21, T2 paramT22)
    {
      return mWrappedCallback.compare(paramT21, paramT22);
    }
    
    public void dispatchLastEvent()
    {
      mBatchingListUpdateCallback.dispatchLastEvent();
    }
    
    public void onChanged(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, null);
    }
    
    public void onInserted(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onInserted(paramInt1, paramInt2);
    }
    
    public void onMoved(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onMoved(paramInt1, paramInt2);
    }
    
    public void onRemoved(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onRemoved(paramInt1, paramInt2);
    }
  }
  
  public static abstract class Callback<T2>
    implements Comparator<T2>, ListUpdateCallback
  {
    public Callback() {}
    
    public abstract boolean areContentsTheSame(T2 paramT21, T2 paramT22);
    
    public abstract boolean areItemsTheSame(T2 paramT21, T2 paramT22);
    
    public abstract int compare(T2 paramT21, T2 paramT22);
    
    public abstract void onChanged(int paramInt1, int paramInt2);
    
    public void onChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onChanged(paramInt1, paramInt2);
    }
  }
}
