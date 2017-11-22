package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzpy;

@KeepName
public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
  CustomEventBanner zzZQ;
  CustomEventInterstitial zzZR;
  CustomEventNative zzZS;
  private View zzcV;
  
  public CustomEventAdapter() {}
  
  private void zza(View paramView)
  {
    zzcV = paramView;
  }
  
  private static <T> T zzj(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = String.valueOf(localThrowable.getMessage());
      zzpy.zzbe(String.valueOf(paramString).length() + 46 + String.valueOf(str).length() + "Could not instantiate custom event adapter: " + paramString + ". " + str);
    }
    return null;
  }
  
  public View getBannerView()
  {
    return zzcV;
  }
  
  public void onDestroy()
  {
    if (zzZQ != null) {
      zzZQ.onDestroy();
    }
    if (zzZR != null) {
      zzZR.onDestroy();
    }
    if (zzZS != null) {
      zzZS.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (zzZQ != null) {
      zzZQ.onPause();
    }
    if (zzZR != null) {
      zzZR.onPause();
    }
    if (zzZS != null) {
      zzZS.onPause();
    }
  }
  
  public void onResume()
  {
    if (zzZQ != null) {
      zzZQ.onResume();
    }
    if (zzZR != null) {
      zzZR.onResume();
    }
    if (zzZS != null) {
      zzZS.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzZQ = ((CustomEventBanner)zzj(paramBundle1.getString("class_name")));
    if (zzZQ == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      zzZQ.requestBannerAd(paramContext, new zza(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzZR = ((CustomEventInterstitial)zzj(paramBundle1.getString("class_name")));
    if (zzZR == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      zzZR.requestInterstitialAd(paramContext, zza(paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    zzZS = ((CustomEventNative)zzj(paramBundle1.getString("class_name")));
    if (zzZS == null)
    {
      paramMediationNativeListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      zzZS.requestNativeAd(paramContext, new zzc(this, paramMediationNativeListener), paramBundle1.getString("parameter"), paramNativeMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void showInterstitial()
  {
    zzZR.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzZT;
    private final MediationBannerListener zzcN;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      zzZT = paramCustomEventAdapter;
      zzcN = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      zzpy.zzbc("Custom event adapter called onAdClicked.");
      zzcN.onAdClicked(zzZT);
    }
    
    public void onAdClosed()
    {
      zzpy.zzbc("Custom event adapter called onAdClosed.");
      zzcN.onAdClosed(zzZT);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzpy.zzbc("Custom event adapter called onAdFailedToLoad.");
      zzcN.onAdFailedToLoad(zzZT, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzpy.zzbc("Custom event adapter called onAdLeftApplication.");
      zzcN.onAdLeftApplication(zzZT);
    }
    
    public void onAdLoaded(View paramView)
    {
      zzpy.zzbc("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.zza(zzZT, paramView);
      zzcN.onAdLoaded(zzZT);
    }
    
    public void onAdOpened()
    {
      zzpy.zzbc("Custom event adapter called onAdOpened.");
      zzcN.onAdOpened(zzZT);
    }
  }
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzZT;
    private final MediationInterstitialListener zzcO;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      zzZT = paramCustomEventAdapter;
      zzcO = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      zzpy.zzbc("Custom event adapter called onAdClicked.");
      zzcO.onAdClicked(zzZT);
    }
    
    public void onAdClosed()
    {
      zzpy.zzbc("Custom event adapter called onAdClosed.");
      zzcO.onAdClosed(zzZT);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzcO.onAdFailedToLoad(zzZT, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzpy.zzbc("Custom event adapter called onAdLeftApplication.");
      zzcO.onAdLeftApplication(zzZT);
    }
    
    public void onAdLoaded()
    {
      zzpy.zzbc("Custom event adapter called onReceivedAd.");
      zzcO.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      zzpy.zzbc("Custom event adapter called onAdOpened.");
      zzcO.onAdOpened(zzZT);
    }
  }
  
  static class zzc
    implements CustomEventNativeListener
  {
    private final CustomEventAdapter zzZT;
    private final MediationNativeListener zzcP;
    
    public zzc(CustomEventAdapter paramCustomEventAdapter, MediationNativeListener paramMediationNativeListener)
    {
      zzZT = paramCustomEventAdapter;
      zzcP = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      zzpy.zzbc("Custom event adapter called onAdClicked.");
      zzcP.onAdClicked(zzZT);
    }
    
    public void onAdClosed()
    {
      zzpy.zzbc("Custom event adapter called onAdClosed.");
      zzcP.onAdClosed(zzZT);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzpy.zzbc("Custom event adapter called onAdFailedToLoad.");
      zzcP.onAdFailedToLoad(zzZT, paramInt);
    }
    
    public void onAdImpression()
    {
      zzpy.zzbc("Custom event adapter called onAdImpression.");
      zzcP.onAdImpression(zzZT);
    }
    
    public void onAdLeftApplication()
    {
      zzpy.zzbc("Custom event adapter called onAdLeftApplication.");
      zzcP.onAdLeftApplication(zzZT);
    }
    
    public void onAdLoaded(NativeAdMapper paramNativeAdMapper)
    {
      zzpy.zzbc("Custom event adapter called onAdLoaded.");
      zzcP.onAdLoaded(zzZT, paramNativeAdMapper);
    }
    
    public void onAdOpened()
    {
      zzpy.zzbc("Custom event adapter called onAdOpened.");
      zzcP.onAdOpened(zzZT);
    }
  }
}
