package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzmb
public class zzfa
{
  private final Context mContext;
  private InAppPurchaseListener zzAa;
  private OnCustomRenderedAdLoadedListener zzAb;
  private PlayStorePurchaseListener zzAc;
  private String zzAd;
  private PublisherInterstitialAd zzAh;
  private boolean zzAi;
  private RewardedVideoAdListener zzcI;
  private final zzeb zzrB;
  private String zztq;
  private zzdt zzyD;
  private AdListener zzyE;
  private final zzjr zzzU = new zzjr();
  private Correlator zzzY;
  private zzep zzzZ;
  private AppEventListener zzzq;
  
  public zzfa(Context paramContext)
  {
    this(paramContext, zzeb.zzey(), null);
  }
  
  public zzfa(Context paramContext, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this(paramContext, zzeb.zzey(), paramPublisherInterstitialAd);
  }
  
  public zzfa(Context paramContext, zzeb paramZzeb, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    mContext = paramContext;
    zzrB = paramZzeb;
    zzAh = paramPublisherInterstitialAd;
  }
  
  private void zzS(String paramString)
    throws RemoteException
  {
    if (zztq == null) {
      zzT(paramString);
    }
    if (zzAi) {}
    for (paramString = zzec.zzez();; paramString = new zzec())
    {
      zzzZ = zzeh.zzeP().zzb(mContext, paramString, zztq, zzzU);
      if (zzyE != null) {
        zzzZ.zza(new zzdv(zzyE));
      }
      if (zzyD != null) {
        zzzZ.zza(new zzdu(zzyD));
      }
      if (zzzq != null) {
        zzzZ.zza(new zzee(zzzq));
      }
      if (zzAa != null) {
        zzzZ.zza(new zzle(zzAa));
      }
      if (zzAc != null) {
        zzzZ.zza(new zzli(zzAc), zzAd);
      }
      if (zzAb != null) {
        zzzZ.zza(new zzgk(zzAb));
      }
      if (zzzY != null) {
        zzzZ.zza(zzzY.zzbr());
      }
      if (zzcI != null) {
        zzzZ.zza(new zznw(zzcI));
      }
      return;
    }
  }
  
  private void zzT(String paramString)
  {
    if (zzzZ == null) {
      throw new IllegalStateException(String.valueOf(paramString).length() + 63 + "The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public AdListener getAdListener()
  {
    return zzyE;
  }
  
  public String getAdUnitId()
  {
    return zztq;
  }
  
  public AppEventListener getAppEventListener()
  {
    return zzzq;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zzAa;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (zzzZ != null)
      {
        String str = zzzZ.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zzAb;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (zzzZ == null) {
        return false;
      }
      boolean bool = zzzZ.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (zzzZ == null) {
        return false;
      }
      boolean bool = zzzZ.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      zzyE = paramAdListener;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new zzdv(paramAdListener);; paramAdListener = null)
      {
        localZzep.zza(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      zzpy.zzc("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (zztq != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    zztq = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      zzzq = paramAppEventListener;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new zzee(paramAppEventListener);; paramAppEventListener = null)
      {
        localZzep.zza(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      zzpy.zzc("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    zzzY = paramCorrelator;
    try
    {
      if (zzzZ != null)
      {
        zzep localZzep = zzzZ;
        if (zzzY == null) {}
        for (paramCorrelator = null;; paramCorrelator = zzzY.zzbr())
        {
          localZzep.zza(paramCorrelator);
          return;
        }
      }
      return;
    }
    catch (RemoteException paramCorrelator)
    {
      zzpy.zzc("Failed to set correlator.", paramCorrelator);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (zzAc != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      zzAa = paramInAppPurchaseListener;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramInAppPurchaseListener == null) {
          break label56;
        }
      }
      label56:
      for (paramInAppPurchaseListener = new zzle(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localZzep.zza(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      zzpy.zzc("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    try
    {
      zzAb = paramOnCustomRenderedAdLoadedListener;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label38;
        }
      }
      label38:
      for (paramOnCustomRenderedAdLoadedListener = new zzgk(paramOnCustomRenderedAdLoadedListener);; paramOnCustomRenderedAdLoadedListener = null)
      {
        localZzep.zza(paramOnCustomRenderedAdLoadedListener);
        return;
      }
      return;
    }
    catch (RemoteException paramOnCustomRenderedAdLoadedListener)
    {
      zzpy.zzc("Failed to set the OnCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (zzAa != null) {
      throw new IllegalStateException("In app purchase parameter has already been set.");
    }
    try
    {
      zzAc = paramPlayStorePurchaseListener;
      zzAd = paramString;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramPlayStorePurchaseListener == null) {
          break label62;
        }
      }
      label62:
      for (paramPlayStorePurchaseListener = new zzli(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localZzep.zza(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      zzpy.zzc("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    try
    {
      zzcI = paramRewardedVideoAdListener;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramRewardedVideoAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramRewardedVideoAdListener = new zznw(paramRewardedVideoAdListener);; paramRewardedVideoAdListener = null)
      {
        localZzep.zza(paramRewardedVideoAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramRewardedVideoAdListener)
    {
      zzpy.zzc("Failed to set the AdListener.", paramRewardedVideoAdListener);
    }
  }
  
  public void show()
  {
    try
    {
      zzT("show");
      zzzZ.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to show interstitial.", localRemoteException);
    }
  }
  
  public void zza(zzdt paramZzdt)
  {
    try
    {
      zzyD = paramZzdt;
      zzep localZzep;
      if (zzzZ != null)
      {
        localZzep = zzzZ;
        if (paramZzdt == null) {
          break label38;
        }
      }
      label38:
      for (paramZzdt = new zzdu(paramZzdt);; paramZzdt = null)
      {
        localZzep.zza(paramZzdt);
        return;
      }
      return;
    }
    catch (RemoteException paramZzdt)
    {
      zzpy.zzc("Failed to set the AdClickListener.", paramZzdt);
    }
  }
  
  public void zza(zzey paramZzey)
  {
    try
    {
      if (zzzZ == null) {
        zzS("loadAd");
      }
      if (zzzZ.zzb(zzrB.zza(mContext, paramZzey))) {
        zzzU.zzi(paramZzey.zzeY());
      }
      return;
    }
    catch (RemoteException paramZzey)
    {
      zzpy.zzc("Failed to load ad.", paramZzey);
    }
  }
  
  public void zzd(boolean paramBoolean)
  {
    zzAi = paramBoolean;
  }
}
