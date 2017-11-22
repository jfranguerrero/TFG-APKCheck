package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzmb
public class zzqd<T>
  implements zzqf<T>
{
  private final T zzYe;
  private final zzqg zzYh;
  
  public zzqd(T paramT)
  {
    zzYe = paramT;
    zzYh = new zzqg();
    zzYh.zzkM();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public T get()
  {
    return zzYe;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return zzYe;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public void zzc(Runnable paramRunnable)
  {
    zzYh.zzc(paramRunnable);
  }
}
