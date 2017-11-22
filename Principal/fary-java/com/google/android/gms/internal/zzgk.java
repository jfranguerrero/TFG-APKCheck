package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzmb
public final class zzgk
  extends zzgj.zza
{
  private final OnCustomRenderedAdLoadedListener zzAb;
  
  public zzgk(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zzAb = paramOnCustomRenderedAdLoadedListener;
  }
  
  public void zza(zzgi paramZzgi)
  {
    zzAb.onCustomRenderedAdLoaded(new zzgh(paramZzgi));
  }
}
