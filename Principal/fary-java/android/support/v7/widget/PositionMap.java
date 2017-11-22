package android.support.v7.widget;

import java.util.ArrayList;

class PositionMap<E>
  implements Cloneable
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private int[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public PositionMap()
  {
    this(10);
  }
  
  public PositionMap(int paramInt)
  {
    if (paramInt == 0) {
      mKeys = ContainerHelpers.EMPTY_INTS;
    }
    for (mValues = ContainerHelpers.EMPTY_OBJECTS;; mValues = new Object[paramInt])
    {
      mSize = 0;
      return;
      paramInt = idealIntArraySize(paramInt);
      mKeys = new int[paramInt];
    }
  }
  
  private void gc()
  {
    int m = mSize;
    int j = 0;
    int[] arrayOfInt = mKeys;
    Object[] arrayOfObject = mValues;
    int i = 0;
    while (i < m)
    {
      Object localObject = arrayOfObject[i];
      int k = j;
      if (localObject != DELETED)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    mGarbage = false;
    mSize = j;
  }
  
  static int idealBooleanArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt);
  }
  
  static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  static int idealCharArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 2) / 2;
  }
  
  static int idealFloatArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
  
  static int idealObjectArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  static int idealShortArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 2) / 2;
  }
  
  public void append(int paramInt, E paramE)
  {
    if ((mSize != 0) && (paramInt <= mKeys[(mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((mGarbage) && (mSize >= mKeys.length)) {
      gc();
    }
    int i = mSize;
    if (i >= mKeys.length)
    {
      int j = idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(mKeys, 0, arrayOfInt, 0, mKeys.length);
      System.arraycopy(mValues, 0, arrayOfObject, 0, mValues.length);
      mKeys = arrayOfInt;
      mValues = arrayOfObject;
    }
    mKeys[i] = paramInt;
    mValues[i] = paramE;
    mSize = (i + 1);
  }
  
  public void clear()
  {
    int j = mSize;
    Object[] arrayOfObject = mValues;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    mSize = 0;
    mGarbage = false;
  }
  
  public PositionMap<E> clone()
  {
    Object localObject = null;
    try
    {
      PositionMap localPositionMap = (PositionMap)super.clone();
      localObject = localPositionMap;
      mKeys = ((int[])mKeys.clone());
      localObject = localPositionMap;
      mValues = ((Object[])mValues.clone());
      return localPositionMap;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return localObject;
  }
  
  public void delete(int paramInt)
  {
    paramInt = ContainerHelpers.binarySearch(mKeys, mSize, paramInt);
    if ((paramInt >= 0) && (mValues[paramInt] != DELETED))
    {
      mValues[paramInt] = DELETED;
      mGarbage = true;
    }
  }
  
  public E get(int paramInt)
  {
    return get(paramInt, null);
  }
  
  public E get(int paramInt, E paramE)
  {
    paramInt = ContainerHelpers.binarySearch(mKeys, mSize, paramInt);
    if ((paramInt < 0) || (mValues[paramInt] == DELETED)) {
      return paramE;
    }
    return mValues[paramInt];
  }
  
  public int indexOfKey(int paramInt)
  {
    if (mGarbage) {
      gc();
    }
    return ContainerHelpers.binarySearch(mKeys, mSize, paramInt);
  }
  
  public int indexOfValue(E paramE)
  {
    if (mGarbage) {
      gc();
    }
    int i = 0;
    while (i < mSize)
    {
      if (mValues[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void insertKeyRange(int paramInt1, int paramInt2) {}
  
  public int keyAt(int paramInt)
  {
    if (mGarbage) {
      gc();
    }
    return mKeys[paramInt];
  }
  
  public void put(int paramInt, E paramE)
  {
    int i = ContainerHelpers.binarySearch(mKeys, mSize, paramInt);
    if (i >= 0)
    {
      mValues[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < mSize) && (mValues[j] == DELETED))
    {
      mKeys[j] = paramInt;
      mValues[j] = paramE;
      return;
    }
    i = j;
    if (mGarbage)
    {
      i = j;
      if (mSize >= mKeys.length)
      {
        gc();
        i = ContainerHelpers.binarySearch(mKeys, mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (mSize >= mKeys.length)
    {
      j = idealIntArraySize(mSize + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(mKeys, 0, arrayOfInt, 0, mKeys.length);
      System.arraycopy(mValues, 0, arrayOfObject, 0, mValues.length);
      mKeys = arrayOfInt;
      mValues = arrayOfObject;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
      System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
    }
    mKeys[i] = paramInt;
    mValues[i] = paramE;
    mSize += 1;
  }
  
  public void remove(int paramInt)
  {
    delete(paramInt);
  }
  
  public void removeAt(int paramInt)
  {
    if (mValues[paramInt] != DELETED)
    {
      mValues[paramInt] = DELETED;
      mGarbage = true;
    }
  }
  
  public void removeAtRange(int paramInt1, int paramInt2)
  {
    paramInt2 = Math.min(mSize, paramInt1 + paramInt2);
    while (paramInt1 < paramInt2)
    {
      removeAt(paramInt1);
      paramInt1 += 1;
    }
  }
  
  public void removeKeyRange(ArrayList<E> paramArrayList, int paramInt1, int paramInt2) {}
  
  public void setValueAt(int paramInt, E paramE)
  {
    if (mGarbage) {
      gc();
    }
    mValues[paramInt] = paramE;
  }
  
  public int size()
  {
    if (mGarbage) {
      gc();
    }
    return mSize;
  }
  
  public String toString()
  {
    if (size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public E valueAt(int paramInt)
  {
    if (mGarbage) {
      gc();
    }
    return mValues[paramInt];
  }
  
  static class ContainerHelpers
  {
    static final boolean[] EMPTY_BOOLEANS = new boolean[0];
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];
    
    ContainerHelpers() {}
    
    static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      int i = 0;
      int j = paramInt1 - 1;
      paramInt1 = i;
      i = j;
      while (paramInt1 <= i)
      {
        j = paramInt1 + i >>> 1;
        int k = paramArrayOfInt[j];
        if (k < paramInt2)
        {
          paramInt1 = j + 1;
        }
        else
        {
          i = j;
          if (k <= paramInt2) {
            return i;
          }
          i = j - 1;
        }
      }
      i = paramInt1 ^ 0xFFFFFFFF;
      return i;
    }
  }
}
