package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E>
  implements Collection<E>, Set<E>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean DEBUG = false;
  private static final int[] INT = new int[0];
  private static final Object[] OBJECT = new Object[0];
  private static final String TAG = "ArraySet";
  static Object[] sBaseCache;
  static int sBaseCacheSize;
  static Object[] sTwiceBaseCache;
  static int sTwiceBaseCacheSize;
  Object[] mArray;
  MapCollections<E, E> mCollections;
  int[] mHashes;
  final boolean mIdentityHashCode;
  int mSize;
  
  public ArraySet()
  {
    this(0, false);
  }
  
  public ArraySet(int paramInt)
  {
    this(paramInt, false);
  }
  
  public ArraySet(int paramInt, boolean paramBoolean)
  {
    mIdentityHashCode = paramBoolean;
    if (paramInt == 0)
    {
      mHashes = INT;
      mArray = OBJECT;
    }
    for (;;)
    {
      mSize = 0;
      return;
      allocArrays(paramInt);
    }
  }
  
  public ArraySet(ArraySet<E> paramArraySet)
  {
    this();
    if (paramArraySet != null) {
      addAll(paramArraySet);
    }
  }
  
  public ArraySet(Collection<E> paramCollection)
  {
    this();
    if (paramCollection != null) {
      addAll(paramCollection);
    }
  }
  
  private void allocArrays(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (sTwiceBaseCache != null)
        {
          Object[] arrayOfObject1 = sTwiceBaseCache;
          mArray = arrayOfObject1;
          sTwiceBaseCache = (Object[])arrayOfObject1[0];
          mHashes = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          sTwiceBaseCacheSize -= 1;
          return;
        }
        mHashes = new int[paramInt];
        mArray = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (sBaseCache != null)
          {
            Object[] arrayOfObject2 = sBaseCache;
            mArray = arrayOfObject2;
            sBaseCache = (Object[])arrayOfObject2[0];
            mHashes = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            sBaseCacheSize -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (sTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = sTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          sTwiceBaseCache = paramArrayOfObject;
          sTwiceBaseCacheSize += 1;
        }
        return;
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (sBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = sBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          sBaseCache = paramArrayOfObject;
          sBaseCacheSize += 1;
        }
        return;
      }
      finally {}
      label113:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      return;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private MapCollections<E, E> getCollection()
  {
    if (mCollections == null) {
      mCollections = new MapCollections()
      {
        protected void colClear()
        {
          clear();
        }
        
        protected Object colGetEntry(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return mArray[paramAnonymousInt1];
        }
        
        protected Map<E, E> colGetMap()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected int colGetSize()
        {
          return mSize;
        }
        
        protected int colIndexOfKey(Object paramAnonymousObject)
        {
          return indexOf(paramAnonymousObject);
        }
        
        protected int colIndexOfValue(Object paramAnonymousObject)
        {
          return indexOf(paramAnonymousObject);
        }
        
        protected void colPut(E paramAnonymousE1, E paramAnonymousE2)
        {
          add(paramAnonymousE1);
        }
        
        protected void colRemoveAt(int paramAnonymousInt)
        {
          removeAt(paramAnonymousInt);
        }
        
        protected E colSetValue(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
      };
    }
    return mCollections;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int k = mSize;
    if (k == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = ContainerHelpers.binarySearch(mHashes, k, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(mArray[j]));
    int i = j + 1;
    while ((i < k) && (mHashes[i] == paramInt))
    {
      if (paramObject.equals(mArray[i])) {
        return i;
      }
      i += 1;
    }
    j -= 1;
    while ((j >= 0) && (mHashes[j] == paramInt))
    {
      if (paramObject.equals(mArray[j])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private int indexOfNull()
  {
    int k = mSize;
    if (k == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = ContainerHelpers.binarySearch(mHashes, k, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (mArray[j] == null);
    int i = j + 1;
    while ((i < k) && (mHashes[i] == 0))
    {
      if (mArray[i] == null) {
        return i;
      }
      i += 1;
    }
    j -= 1;
    while ((j >= 0) && (mHashes[j] == 0))
    {
      if (mArray[j] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public boolean add(E paramE)
  {
    int k = 8;
    int j;
    int i;
    if (paramE == null)
    {
      j = 0;
      i = indexOfNull();
      if (i >= 0) {
        return false;
      }
    }
    else
    {
      if (mIdentityHashCode) {}
      for (i = System.identityHashCode(paramE);; i = paramE.hashCode())
      {
        m = indexOf(paramE, i);
        j = i;
        i = m;
        break;
      }
    }
    int m = i ^ 0xFFFFFFFF;
    if (mSize >= mHashes.length)
    {
      if (mSize < 8) {
        break label244;
      }
      i = mSize + (mSize >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = mHashes;
      Object[] arrayOfObject = mArray;
      allocArrays(i);
      if (mHashes.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, mArray, 0, arrayOfObject.length);
      }
      freeArrays(arrayOfInt, arrayOfObject, mSize);
      if (m < mSize)
      {
        System.arraycopy(mHashes, m, mHashes, m + 1, mSize - m);
        System.arraycopy(mArray, m, mArray, m + 1, mSize - m);
      }
      mHashes[m] = j;
      mArray[m] = paramE;
      mSize += 1;
      return true;
      label244:
      i = k;
      if (mSize < 4) {
        i = 4;
      }
    }
  }
  
  public void addAll(ArraySet<? extends E> paramArraySet)
  {
    int j = mSize;
    ensureCapacity(mSize + j);
    if (mSize == 0) {
      if (j > 0)
      {
        System.arraycopy(mHashes, 0, mHashes, 0, j);
        System.arraycopy(mArray, 0, mArray, 0, j);
        mSize = j;
      }
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        add(paramArraySet.valueAt(i));
        i += 1;
      }
    }
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    ensureCapacity(mSize + paramCollection.size());
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public void append(E paramE)
  {
    int j = mSize;
    int i;
    if (paramE == null) {
      i = 0;
    }
    while (j >= mHashes.length)
    {
      throw new IllegalStateException("Array is full");
      if (mIdentityHashCode) {
        i = System.identityHashCode(paramE);
      } else {
        i = paramE.hashCode();
      }
    }
    if ((j > 0) && (mHashes[(j - 1)] > i))
    {
      add(paramE);
      return;
    }
    mSize = (j + 1);
    mHashes[j] = i;
    mArray[j] = paramE;
  }
  
  public void clear()
  {
    if (mSize != 0)
    {
      freeArrays(mHashes, mArray, mSize);
      mHashes = INT;
      mArray = OBJECT;
      mSize = 0;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public void ensureCapacity(int paramInt)
  {
    if (mHashes.length < paramInt)
    {
      int[] arrayOfInt = mHashes;
      Object[] arrayOfObject = mArray;
      allocArrays(paramInt);
      if (mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, mHashes, 0, mSize);
        System.arraycopy(arrayOfObject, 0, mArray, 0, mSize);
      }
      freeArrays(arrayOfInt, arrayOfObject, mSize);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < mSize)
          {
            boolean bool = paramObject.contains(valueAt(i));
            if (!bool) {
              return false;
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = mHashes;
    int j = 0;
    int i = 0;
    int k = mSize;
    while (i < k)
    {
      j += arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return indexOfNull();
    }
    if (mIdentityHashCode) {}
    for (int i = System.identityHashCode(paramObject);; i = paramObject.hashCode()) {
      return indexOf(paramObject, i);
    }
  }
  
  public boolean isEmpty()
  {
    return mSize <= 0;
  }
  
  public Iterator<E> iterator()
  {
    return getCollection().getKeySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(ArraySet<? extends E> paramArraySet)
  {
    int j = mSize;
    int k = mSize;
    int i = 0;
    while (i < j)
    {
      remove(paramArraySet.valueAt(i));
      i += 1;
    }
    return k != mSize;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public E removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = mArray[paramInt];
    if (mSize <= 1)
    {
      freeArrays(mHashes, mArray, mSize);
      mHashes = INT;
      mArray = OBJECT;
      mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((mHashes.length <= 8) || (mSize >= mHashes.length / 3)) {
        break;
      }
      if (mSize > 8) {
        i = mSize + (mSize >> 1);
      }
      arrayOfInt = mHashes;
      arrayOfObject = mArray;
      allocArrays(i);
      mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, mArray, 0, paramInt);
      }
    } while (paramInt >= mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, mHashes, paramInt, mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, mArray, paramInt, mSize - paramInt);
    return localObject;
    mSize -= 1;
    if (paramInt < mSize)
    {
      System.arraycopy(mHashes, paramInt + 1, mHashes, paramInt, mSize - paramInt);
      System.arraycopy(mArray, paramInt + 1, mArray, paramInt, mSize - paramInt);
    }
    mArray[mSize] = null;
    return localObject;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(mArray[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    return bool;
  }
  
  public int size()
  {
    return mSize;
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[mSize];
    System.arraycopy(mArray, 0, arrayOfObject, 0, mSize);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < mSize) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), mSize);
    }
    System.arraycopy(mArray, 0, localObject, 0, mSize);
    if (localObject.length > mSize) {
      localObject[mSize] = null;
    }
    return localObject;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(mSize * 14);
    localStringBuilder.append('{');
    int i = 0;
    if (i < mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Set)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public E valueAt(int paramInt)
  {
    return mArray[paramInt];
  }
}
