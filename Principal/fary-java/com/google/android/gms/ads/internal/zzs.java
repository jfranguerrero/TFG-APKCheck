package com.google.android.gms.ads.internal;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import java.lang.ref.WeakReference;

@zzmb
public class zzs
{
  private final zza zzuf;
  @Nullable
  private zzdy zzug;
  private boolean zzuh = false;
  private boolean zzui = false;
  private long zzuj = 0L;
  private final Runnable zzv;
  
  public zzs(zza paramZza)
  {
    this(paramZza, new zza(zzpi.zzWR));
  }
  
  zzs(zza paramZza, zza paramZza1)
  {
    zzuf = paramZza1;
    zzv = new Runnable()
    {
      public void run()
      {
        zzs.zza(zzs.this, false);
        zza localZza = (zza)zzuk.get();
        if (localZza != null) {
          localZza.zzd(zzs.zza(zzs.this));
        }
      }
    };
  }
  
  public void cancel()
  {
    zzuh = false;
    zzuf.removeCallbacks(zzv);
  }
  
  public void pause()
  {
    zzui = true;
    if (zzuh) {
      zzuf.removeCallbacks(zzv);
    }
  }
  
  public void resume()
  {
    zzui = false;
    if (zzuh)
    {
      zzuh = false;
      zza(zzug, zzuj);
    }
  }
  
  public void zza(zzdy paramZzdy, long paramLong)
  {
    if (zzuh) {
      zzpe.zzbe("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      zzug = paramZzdy;
      zzuh = true;
      zzuj = paramLong;
    } while (zzui);
    zzpe.zzbd(65 + "Scheduling ad refresh " + paramLong + " milliseconds from now.");
    zzuf.postDelayed(zzv, paramLong);
  }
  
  public boolean zzcv()
  {
    return zzuh;
  }
  
  public void zzg(zzdy paramZzdy)
  {
    zzug = paramZzdy;
  }
  
  public void zzh(zzdy paramZzdy)
  {
    zza(paramZzdy, 60000L);
  }
  
  public static class zza
  {
    private final Handler mHandler;
    
    public zza(Handler paramHandler)
    {
      mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      mHandler.removeCallbacks(paramRunnable);
    }
  }
}
