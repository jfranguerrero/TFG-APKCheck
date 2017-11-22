package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zzaCj;
  protected int zzaCk;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    zzaCj = ((DataBuffer)zzac.zzw(paramDataBuffer));
    zzaCk = -1;
  }
  
  public boolean hasNext()
  {
    return zzaCk < zzaCj.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext())
    {
      i = zzaCk;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    DataBuffer localDataBuffer = zzaCj;
    int i = zzaCk + 1;
    zzaCk = i;
    return localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}
