package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

@zzmb
public class zzhq
  extends zzhl.zza
{
  private final NativeCustomTemplateAd.OnCustomClickListener zzHa;
  
  public zzhq(NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
  {
    zzHa = paramOnCustomClickListener;
  }
  
  public void zza(zzhh paramZzhh, String paramString)
  {
    zzHa.onCustomClick(new zzhi(paramZzhh), paramString);
  }
}
