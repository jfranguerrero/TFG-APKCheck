package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzno
  extends zznr.zza
{
  private final Context mContext;
  private final zznp zzUE;
  private final Object zzrN = new Object();
  private final zzqa zztr;
  
  public zzno(Context paramContext, com.google.android.gms.ads.internal.zzd paramZzd, zzjs paramZzjs, zzqa paramZzqa)
  {
    this(paramContext, paramZzqa, new zznp(paramContext, paramZzd, zzec.zzez(), paramZzjs, paramZzqa));
  }
  
  zzno(Context paramContext, zzqa paramZzqa, zznp paramZznp)
  {
    mContext = paramContext;
    zztr = paramZzqa;
    zzUE = paramZznp;
  }
  
  public void destroy()
  {
    zzh(null);
  }
  
  public boolean isLoaded()
  {
    synchronized (zzrN)
    {
      boolean bool = zzUE.isLoaded();
      return bool;
    }
  }
  
  public void pause()
  {
    zzf(null);
  }
  
  public void resume()
  {
    zzg(null);
  }
  
  public void setUserId(String paramString)
  {
    zzpe.zzbe("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
  }
  
  public void show()
  {
    synchronized (zzrN)
    {
      zzUE.zzjo();
      return;
    }
  }
  
  public void zza(zznt paramZznt)
  {
    synchronized (zzrN)
    {
      zzUE.zza(paramZznt);
      return;
    }
  }
  
  public void zza(zznx paramZznx)
  {
    synchronized (zzrN)
    {
      zzUE.zza(paramZznx);
      return;
    }
  }
  
  public void zzf(com.google.android.gms.dynamic.zzd arg1)
  {
    synchronized (zzrN)
    {
      zzUE.pause();
      return;
    }
  }
  
  public void zzg(com.google.android.gms.dynamic.zzd paramZzd)
  {
    Object localObject = zzrN;
    if (paramZzd == null) {
      paramZzd = null;
    }
    for (;;)
    {
      if (paramZzd != null) {}
      try
      {
        zzUE.onContextChanged(paramZzd);
        zzUE.resume();
        return;
        paramZzd = (Context)zze.zzE(paramZzd);
      }
      catch (Exception paramZzd)
      {
        for (;;)
        {
          zzpe.zzc("Unable to extract updated context.", paramZzd);
        }
      }
      finally {}
    }
  }
  
  public void zzh(com.google.android.gms.dynamic.zzd arg1)
  {
    synchronized (zzrN)
    {
      zzUE.destroy();
      return;
    }
  }
}
