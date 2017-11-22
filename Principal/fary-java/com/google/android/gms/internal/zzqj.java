package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzmb
public class zzqj<T>
  implements zzqi<T>
{
  protected int zzJh = 0;
  protected final BlockingQueue<zza> zzYt = new LinkedBlockingQueue();
  protected T zzYu;
  private final Object zzrN = new Object();
  
  public zzqj() {}
  
  public int getStatus()
  {
    return zzJh;
  }
  
  public void reject()
  {
    synchronized (zzrN)
    {
      if (zzJh != 0) {
        throw new UnsupportedOperationException();
      }
    }
    zzJh = -1;
    Iterator localIterator = zzYt.iterator();
    while (localIterator.hasNext()) {
      nextzzYw.run();
    }
    zzYt.clear();
  }
  
  public void zza(zzqi.zzc<T> paramZzc, zzqi.zza paramZza)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzJh == 1)
        {
          paramZzc.zzd(zzYu);
          return;
        }
        if (zzJh == -1) {
          paramZza.run();
        }
      }
      if (zzJh == 0) {
        zzYt.add(new zza(paramZzc, paramZza));
      }
    }
  }
  
  public void zzg(T paramT)
  {
    synchronized (zzrN)
    {
      if (zzJh != 0) {
        throw new UnsupportedOperationException();
      }
    }
    zzYu = paramT;
    zzJh = 1;
    Iterator localIterator = zzYt.iterator();
    while (localIterator.hasNext()) {
      nextzzYv.zzd(paramT);
    }
    zzYt.clear();
  }
  
  class zza
  {
    public final zzqi.zzc<T> zzYv;
    public final zzqi.zza zzYw;
    
    public zza(zzqi.zza paramZza)
    {
      zzYv = paramZza;
      Object localObject;
      zzYw = localObject;
    }
  }
}
