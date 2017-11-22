package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T>
  extends zzb<T>
{
  private T zzaCF;
  
  public zzg(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext())
    {
      int i = zzaCk;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    zzaCk += 1;
    if (zzaCk == 0)
    {
      zzaCF = zzaCj.get(0);
      if (!(zzaCF instanceof zzc))
      {
        String str = String.valueOf(zzaCF.getClass());
        throw new IllegalStateException(String.valueOf(str).length() + 44 + "DataBuffer reference of type " + str + " is not movable");
      }
    }
    else
    {
      ((zzc)zzaCF).zzcA(zzaCk);
    }
    return zzaCF;
  }
}
