package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzmb
public abstract class zzpd
  implements zzpk<Future>
{
  private volatile Thread zzWx;
  private boolean zzWy;
  private final Runnable zzv = new Runnable()
  {
    public final void run()
    {
      zzpd.zza(zzpd.this, Thread.currentThread());
      zzcm();
    }
  };
  
  public zzpd()
  {
    zzWy = false;
  }
  
  public zzpd(boolean paramBoolean)
  {
    zzWy = paramBoolean;
  }
  
  public final void cancel()
  {
    onStop();
    if (zzWx != null) {
      zzWx.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public abstract void zzcm();
  
  public final Future zzkf()
  {
    if (zzWy) {
      return zzph.zza(1, zzv);
    }
    return zzph.zza(zzv);
  }
}
