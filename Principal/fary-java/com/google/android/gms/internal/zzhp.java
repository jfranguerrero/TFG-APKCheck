package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzmb
public class zzhp
  extends zzhk.zza
{
  private final NativeContentAd.OnContentAdLoadedListener zzGZ;
  
  public zzhp(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    zzGZ = paramOnContentAdLoadedListener;
  }
  
  public void zza(zzhf paramZzhf)
  {
    zzGZ.onContentAdLoaded(zzb(paramZzhf));
  }
  
  zzhg zzb(zzhf paramZzhf)
  {
    return new zzhg(paramZzhf);
  }
}
