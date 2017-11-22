package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder zzazI;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    zzazI = paramDataHolder;
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (zzazI == null) {
      return 0;
    }
    return zzazI.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return (zzazI == null) || (zzazI.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new zzb(this);
  }
  
  public void release()
  {
    if (zzazI != null) {
      zzazI.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }
  
  public Bundle zzwy()
  {
    return zzazI.zzwy();
  }
}
