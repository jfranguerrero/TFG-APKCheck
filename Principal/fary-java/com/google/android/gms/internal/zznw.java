package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzmb
public class zznw
  extends zznt.zza
{
  private final RewardedVideoAdListener zzcI;
  
  public zznw(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    zzcI = paramRewardedVideoAdListener;
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (zzcI != null) {
      zzcI.onRewardedVideoAdClosed();
    }
  }
  
  public void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    if (zzcI != null) {
      zzcI.onRewardedVideoAdFailedToLoad(paramInt);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (zzcI != null) {
      zzcI.onRewardedVideoAdLeftApplication();
    }
  }
  
  public void onRewardedVideoAdLoaded()
  {
    if (zzcI != null) {
      zzcI.onRewardedVideoAdLoaded();
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    if (zzcI != null) {
      zzcI.onRewardedVideoAdOpened();
    }
  }
  
  public void onRewardedVideoStarted()
  {
    if (zzcI != null) {
      zzcI.onRewardedVideoStarted();
    }
  }
  
  public void zza(zznq paramZznq)
  {
    if (zzcI != null) {
      zzcI.onRewarded(new zznu(paramZznq));
    }
  }
}
