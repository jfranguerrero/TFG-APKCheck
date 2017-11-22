package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@zzmb
public final class zzdv
  extends zzel.zza
{
  private final AdListener zzyE;
  
  public zzdv(AdListener paramAdListener)
  {
    zzyE = paramAdListener;
  }
  
  public void onAdClosed()
  {
    zzyE.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzyE.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzyE.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    zzyE.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    zzyE.onAdOpened();
  }
}
