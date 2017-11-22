package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze
  implements zzn
{
  private final Executor zzr;
  
  public zze(final Handler paramHandler)
  {
    zzr = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public void zza(zzk<?> paramZzk, zzm<?> paramZzm)
  {
    zza(paramZzk, paramZzm, null);
  }
  
  public void zza(zzk<?> paramZzk, zzm<?> paramZzm, Runnable paramRunnable)
  {
    paramZzk.zzr();
    paramZzk.zzc("post-response");
    zzr.execute(new zza(paramZzk, paramZzm, paramRunnable));
  }
  
  public void zza(zzk<?> paramZzk, zzr paramZzr)
  {
    paramZzk.zzc("post-error");
    paramZzr = zzm.zzd(paramZzr);
    zzr.execute(new zza(paramZzk, paramZzr, null));
  }
  
  private class zza
    implements Runnable
  {
    private final zzk zzt;
    private final zzm zzu;
    private final Runnable zzv;
    
    public zza(zzk paramZzk, zzm paramZzm, Runnable paramRunnable)
    {
      zzt = paramZzk;
      zzu = paramZzm;
      zzv = paramRunnable;
    }
    
    public void run()
    {
      if (zzu.isSuccess())
      {
        zzt.zza(zzu.result);
        if (!zzu.zzag) {
          break label77;
        }
        zzt.zzc("intermediate-response");
      }
      for (;;)
      {
        if (zzv != null) {
          zzv.run();
        }
        return;
        zzt.zzc(zzu.zzaf);
        break;
        label77:
        zzt.zzd("done");
      }
    }
  }
}
