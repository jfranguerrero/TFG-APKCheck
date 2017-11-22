package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

@zzmb
public class zzhr
  extends zzhm.zza
{
  private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzHb;
  
  public zzhr(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener)
  {
    zzHb = paramOnCustomTemplateAdLoadedListener;
  }
  
  public void zza(zzhh paramZzhh)
  {
    zzHb.onCustomTemplateAdLoaded(new zzhi(paramZzhh));
  }
}
