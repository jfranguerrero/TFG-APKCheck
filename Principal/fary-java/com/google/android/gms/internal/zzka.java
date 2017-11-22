package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzac;

@zzmb
public final class zzka
  implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{
  private final zzju zzKW;
  private NativeAdMapper zzKX;
  
  public zzka(zzju paramZzju)
  {
    zzKW = paramZzju;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzac.zzdn("onAdClicked must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClicked.");
    try
    {
      zzKW.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzac.zzdn("onAdClicked must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClicked.");
    try
    {
      zzKW.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzac.zzdn("onAdClicked must be called on the main UI thread.");
    paramMediationNativeAdapter = zzgN();
    if (paramMediationNativeAdapter == null)
    {
      zzpy.zzbe("Could not call onAdClicked since NativeAdMapper is null.");
      return;
    }
    if (!paramMediationNativeAdapter.getOverrideClickHandling())
    {
      zzpy.zzbc("Could not call onAdClicked since setOverrideClickHandling is not set to true");
      return;
    }
    zzpy.zzbc("Adapter called onAdClicked.");
    try
    {
      zzKW.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdClicked.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzac.zzdn("onAdClosed must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClosed.");
    try
    {
      zzKW.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzac.zzdn("onAdClosed must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClosed.");
    try
    {
      zzKW.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzac.zzdn("onAdClosed must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClosed.");
    try
    {
      zzKW.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdClosed.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    zzac.zzdn("onAdFailedToLoad must be called on the main UI thread.");
    zzpy.zzbc(55 + "Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      zzKW.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    zzac.zzdn("onAdFailedToLoad must be called on the main UI thread.");
    zzpy.zzbc(55 + "Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      zzKW.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt)
  {
    zzac.zzdn("onAdFailedToLoad must be called on the main UI thread.");
    zzpy.zzbc(55 + "Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      zzKW.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdFailedToLoad.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdImpression(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzac.zzdn("onAdImpression must be called on the main UI thread.");
    paramMediationNativeAdapter = zzgN();
    if (paramMediationNativeAdapter == null)
    {
      zzpy.zzbe("Could not call onAdImpression since NativeAdMapper is null. ");
      return;
    }
    if (!paramMediationNativeAdapter.getOverrideImpressionRecording())
    {
      zzpy.zzbc("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
      return;
    }
    zzpy.zzbc("Adapter called onAdImpression.");
    try
    {
      zzKW.onAdImpression();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdImpression.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzac.zzdn("onAdLeftApplication must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLeftApplication.");
    try
    {
      zzKW.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzac.zzdn("onAdLeftApplication must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLeftApplication.");
    try
    {
      zzKW.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzac.zzdn("onAdLeftApplication must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLeftApplication.");
    try
    {
      zzKW.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdLeftApplication.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzac.zzdn("onAdLoaded must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLoaded.");
    try
    {
      zzKW.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzac.zzdn("onAdLoaded must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLoaded.");
    try
    {
      zzKW.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper)
  {
    zzac.zzdn("onAdLoaded must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLoaded.");
    zzKX = paramNativeAdMapper;
    try
    {
      zzKW.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdLoaded.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzac.zzdn("onAdOpened must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdOpened.");
    try
    {
      zzKW.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzac.zzdn("onAdOpened must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdOpened.");
    try
    {
      zzKW.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzac.zzdn("onAdOpened must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdOpened.");
    try
    {
      zzKW.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzpy.zzc("Could not call onAdOpened.", paramMediationNativeAdapter);
    }
  }
  
  public NativeAdMapper zzgN()
  {
    return zzKX;
  }
}
