package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzmb
public class zzqc<T>
  implements zzqf<T>
{
  private boolean zzKK;
  private T zzYe;
  private Throwable zzYf;
  private boolean zzYg;
  private final zzqg zzYh = new zzqg();
  private final Object zzrN = new Object();
  
  public zzqc() {}
  
  private boolean zzkL()
  {
    return (zzYf != null) || (zzYg);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    synchronized (zzrN)
    {
      if (zzkL()) {
        return false;
      }
    }
    zzKK = true;
    zzYg = true;
    zzrN.notifyAll();
    zzYh.zzkM();
    return true;
  }
  
  public T get()
    throws CancellationException, ExecutionException, InterruptedException
  {
    synchronized (zzrN)
    {
      boolean bool = zzkL();
      if (bool) {}
    }
    if (zzKK) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    Object localObject3 = zzYe;
    return localObject3;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    synchronized (zzrN)
    {
      boolean bool = zzkL();
      if (bool) {}
    }
    if (!zzYg) {
      throw new TimeoutException("CallbackFuture timed out.");
    }
    if (zzKK) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    paramTimeUnit = zzYe;
    return paramTimeUnit;
  }
  
  public boolean isCancelled()
  {
    synchronized (zzrN)
    {
      boolean bool = zzKK;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (zzrN)
    {
      boolean bool = zzkL();
      return bool;
    }
  }
  
  public void zzc(Runnable paramRunnable)
  {
    zzYh.zzc(paramRunnable);
  }
  
  public void zzd(Runnable paramRunnable)
  {
    zzYh.zzd(paramRunnable);
  }
  
  public void zze(Throwable paramThrowable)
  {
    synchronized (zzrN)
    {
      if (zzKK) {
        return;
      }
      if (zzkL())
      {
        zzv.zzcN().zza(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideException");
        return;
      }
    }
    zzYf = paramThrowable;
    zzrN.notifyAll();
    zzYh.zzkM();
  }
  
  public void zzh(@Nullable T paramT)
  {
    synchronized (zzrN)
    {
      if (zzKK) {
        return;
      }
      if (zzkL())
      {
        zzv.zzcN().zza(new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideValue");
        return;
      }
    }
    zzYg = true;
    zzYe = paramT;
    zzrN.notifyAll();
    zzYh.zzkM();
  }
}
