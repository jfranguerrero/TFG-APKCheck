package com.google.android.gms.internal;

import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzoe
  extends zzoi.zza
{
  private volatile zzof zzUM;
  private volatile zzoc zzUY;
  private volatile zzod zzUZ;
  
  public zzoe(zzod paramZzod)
  {
    zzUZ = paramZzod;
  }
  
  public void zza(zzd paramZzd, zzok paramZzok)
  {
    if (zzUZ != null) {
      zzUZ.zzc(paramZzok);
    }
  }
  
  public void zza(zzoc paramZzoc)
  {
    zzUY = paramZzoc;
  }
  
  public void zza(zzof paramZzof)
  {
    zzUM = paramZzof;
  }
  
  public void zzb(zzd paramZzd, int paramInt)
  {
    if (zzUY != null) {
      zzUY.zzab(paramInt);
    }
  }
  
  public void zzc(zzd paramZzd, int paramInt)
  {
    if (zzUM != null) {
      zzUM.zza(zze.zzE(paramZzd).getClass().getName(), paramInt);
    }
  }
  
  public void zzq(zzd paramZzd)
  {
    if (zzUY != null) {
      zzUY.zzjs();
    }
  }
  
  public void zzr(zzd paramZzd)
  {
    if (zzUM != null) {
      zzUM.zzaN(zze.zzE(paramZzd).getClass().getName());
    }
  }
  
  public void zzs(zzd paramZzd)
  {
    if (zzUZ != null) {
      zzUZ.onRewardedVideoAdOpened();
    }
  }
  
  public void zzt(zzd paramZzd)
  {
    if (zzUZ != null) {
      zzUZ.onRewardedVideoStarted();
    }
  }
  
  public void zzu(zzd paramZzd)
  {
    if (zzUZ != null) {
      zzUZ.onRewardedVideoAdClosed();
    }
  }
  
  public void zzv(zzd paramZzd)
  {
    if (zzUZ != null) {
      zzUZ.zzjp();
    }
  }
  
  public void zzw(zzd paramZzd)
  {
    if (zzUZ != null) {
      zzUZ.onRewardedVideoAdLeftApplication();
    }
  }
}
