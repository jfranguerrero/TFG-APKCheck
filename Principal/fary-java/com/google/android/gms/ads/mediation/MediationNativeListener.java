package com.google.android.gms.ads.mediation;

public abstract interface MediationNativeListener
{
  public abstract void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt);
  
  public abstract void onAdImpression(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter);
  
  public abstract void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper);
  
  public abstract void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter);
}
