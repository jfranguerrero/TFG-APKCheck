package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzmb
public class zzho
  extends zzhj.zza
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzGY;
  
  public zzho(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    zzGY = paramOnAppInstallAdLoadedListener;
  }
  
  public void zza(zzhd paramZzhd)
  {
    zzGY.onAppInstallAdLoaded(zzb(paramZzhd));
  }
  
  zzhe zzb(zzhd paramZzhd)
  {
    return new zzhe(paramZzhd);
  }
}
