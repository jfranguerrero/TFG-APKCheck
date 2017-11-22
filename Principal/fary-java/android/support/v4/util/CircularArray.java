package android.support.v4.util;

public final class CircularArray<E>
{
  private int mCapacityBitmask;
  private E[] mElements;
  private int mHead;
  private int mTail;
  
  public CircularArray()
  {
    this(8);
  }
  
  public CircularArray(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("capacity must be >= 1");
    }
    if (paramInt > 1073741824) {
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    if (Integer.bitCount(paramInt) != 1) {
      paramInt = Integer.highestOneBit(paramInt - 1) << 1;
    }
    for (;;)
    {
      mCapacityBitmask = (paramInt - 1);
      mElements = ((Object[])new Object[paramInt]);
      return;
    }
  }
  
  private void doubleCapacity()
  {
    int i = mElements.length;
    int j = i - mHead;
    int k = i << 1;
    if (k < 0) {
      throw new RuntimeException("Max array capacity exceeded");
    }
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(mElements, mHead, arrayOfObject, 0, j);
    System.arraycopy(mElements, 0, arrayOfObject, j, mHead);
    mElements = ((Object[])arrayOfObject);
    mHead = 0;
    mTail = i;
    mCapacityBitmask = (k - 1);
  }
  
  public void addFirst(E paramE)
  {
    mHead = (mHead - 1 & mCapacityBitmask);
    mElements[mHead] = paramE;
    if (mHead == mTail) {
      doubleCapacity();
    }
  }
  
  public void addLast(E paramE)
  {
    mElements[mTail] = paramE;
    mTail = (mTail + 1 & mCapacityBitmask);
    if (mTail == mHead) {
      doubleCapacity();
    }
  }
  
  public void clear()
  {
    removeFromStart(size());
  }
  
  public E get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size())) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return mElements[(mHead + paramInt & mCapacityBitmask)];
  }
  
  public E getFirst()
  {
    if (mHead == mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return mElements[mHead];
  }
  
  public E getLast()
  {
    if (mHead == mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return mElements[(mTail - 1 & mCapacityBitmask)];
  }
  
  public boolean isEmpty()
  {
    return mHead == mTail;
  }
  
  public E popFirst()
  {
    if (mHead == mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Object localObject = mElements[mHead];
    mElements[mHead] = null;
    mHead = (mHead + 1 & mCapacityBitmask);
    return localObject;
  }
  
  public E popLast()
  {
    if (mHead == mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int i = mTail - 1 & mCapacityBitmask;
    Object localObject = mElements[i];
    mElements[i] = null;
    mTail = i;
    return localObject;
  }
  
  public void removeFromEnd(int paramInt)
  {
    if (paramInt <= 0) {}
    do
    {
      return;
      if (paramInt > size()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      i = 0;
      if (paramInt < mTail) {
        i = mTail - paramInt;
      }
      int j = i;
      while (j < mTail)
      {
        mElements[j] = null;
        j += 1;
      }
      i = mTail - i;
      paramInt -= i;
      mTail -= i;
    } while (paramInt <= 0);
    mTail = mElements.length;
    int i = mTail - paramInt;
    paramInt = i;
    while (paramInt < mTail)
    {
      mElements[paramInt] = null;
      paramInt += 1;
    }
    mTail = i;
  }
  
  public void removeFromStart(int paramInt)
  {
    if (paramInt <= 0) {}
    int i;
    do
    {
      return;
      if (paramInt > size()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      int j = mElements.length;
      i = j;
      if (paramInt < j - mHead) {
        i = mHead + paramInt;
      }
      j = mHead;
      while (j < i)
      {
        mElements[j] = null;
        j += 1;
      }
      j = i - mHead;
      i = paramInt - j;
      mHead = (mHead + j & mCapacityBitmask);
    } while (i <= 0);
    paramInt = 0;
    while (paramInt < i)
    {
      mElements[paramInt] = null;
      paramInt += 1;
    }
    mHead = i;
  }
  
  public int size()
  {
    return mTail - mHead & mCapacityBitmask;
  }
}
