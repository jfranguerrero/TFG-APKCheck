package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.concurrent.atomic.AtomicBoolean;

@zzmb
public class zzez
{
  private InAppPurchaseListener zzAa;
  private OnCustomRenderedAdLoadedListener zzAb;
  private PlayStorePurchaseListener zzAc;
  private String zzAd;
  private ViewGroup zzAe;
  private int zzAf;
  private final zzeb zzrB;
  private boolean zzsS;
  private VideoOptions zzsb;
  private String zztq;
  private zzdt zzyD;
  private AdListener zzyE;
  private final zzjr zzzU = new zzjr();
  private final AtomicBoolean zzzV;
  private final VideoController zzzW = new VideoController();
  final zzej zzzX = new zzej()
  {
    public void onAdFailedToLoad(int paramAnonymousInt)
    {
      zzez.zza(zzez.this).zza(zzbt());
      super.onAdFailedToLoad(paramAnonymousInt);
    }
    
    public void onAdLoaded()
    {
      zzez.zza(zzez.this).zza(zzbt());
      super.onAdLoaded();
    }
  };
  private Correlator zzzY;
  private zzep zzzZ;
  private AppEventListener zzzq;
  private AdSize[] zzzr;
  
  public zzez(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, zzeb.zzey(), 0);
  }
  
  public zzez(ViewGroup paramViewGroup, int paramInt)
  {
    this(paramViewGroup, null, false, zzeb.zzey(), paramInt);
  }
  
  public zzez(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzeb.zzey(), 0);
  }
  
  public zzez(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, int paramInt)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzeb.zzey(), paramInt);
  }
  
  zzez(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzeb paramZzeb, int paramInt)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, paramZzeb, null, paramInt);
  }
  
  zzez(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzeb paramZzeb, zzep paramZzep, int paramInt)
  {
    zzAe = paramViewGroup;
    zzrB = paramZzeb;
    zzzZ = paramZzep;
    zzzV = new AtomicBoolean(false);
    zzAf = paramInt;
    if (paramAttributeSet != null) {
      paramZzeb = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new zzef(paramZzeb, paramAttributeSet);
      zzzr = paramAttributeSet.zzm(paramBoolean);
      zztq = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        zzeh.zzeO().zza(paramViewGroup, zza(paramZzeb, zzzr[0], zzAf), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      zzeh.zzeO().zza(paramViewGroup, new zzec(paramZzeb, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private static zzec zza(Context paramContext, AdSize paramAdSize, int paramInt)
  {
    paramContext = new zzec(paramContext, paramAdSize);
    paramContext.zzl(zzy(paramInt));
    return paramContext;
  }
  
  private static zzec zza(Context paramContext, AdSize[] paramArrayOfAdSize, int paramInt)
  {
    paramContext = new zzec(paramContext, paramArrayOfAdSize);
    paramContext.zzl(zzy(paramInt));
    return paramContext;
  }
  
  private void zzfc()
  {
    try
    {
      zzd localZzd = zzzZ.zzbC();
      if (localZzd == null) {
        return;
      }
      zzAe.addView((View)zze.zzE(localZzd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private static boolean zzy(int paramInt)
  {
    return paramInt == 1;
  }
  
  public void destroy()
  {
    try
    {
      if (zzzZ != null) {
        zzzZ.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return zzyE;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (zzzZ != null)
      {
        Object localObject = zzzZ.zzbD();
        if (localObject != null)
        {
          localObject = ((zzec)localObject).zzeA();
          return localObject;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to get the current AdSize.", localRemoteException);
      if (zzzr != null) {
        return zzzr[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return zzzr;
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
  
  public VideoController getVideoController()
  {
    return zzzW;
  }
  
  public VideoOptions getVideoOptions()
  {
    return zzsb;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (zzzZ != null)
      {
        boolean bool = zzzZ.isLoading();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void pause()
  {
    try
    {
      if (zzzZ != null) {
        zzzZ.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    if (zzzV.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        if (zzzZ != null)
        {
          zzzZ.zzbF();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzpy.zzc("Failed to record impression.", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    try
    {
      if (zzzZ != null) {
        zzzZ.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to call resume.", localRemoteException);
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzyE = paramAdListener;
    zzzX.zza(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (zzzr != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (zztq != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzsS = paramBoolean;
    try
    {
      if (zzzZ != null) {
        zzzZ.setManualImpressionsEnabled(zzsS);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to set manual impressions.", localRemoteException);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zzAb = paramOnCustomRenderedAdLoadedListener;
    try
    {
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
      zzpy.zzc("Failed to set the onCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (zzAa != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
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
  
  public void setVideoOptions(VideoOptions paramVideoOptions)
  {
    zzsb = paramVideoOptions;
    try
    {
      if (zzzZ != null)
      {
        zzep localZzep = zzzZ;
        if (paramVideoOptions == null) {}
        for (paramVideoOptions = null;; paramVideoOptions = new zzfn(paramVideoOptions))
        {
          localZzep.zza(paramVideoOptions);
          return;
        }
      }
      return;
    }
    catch (RemoteException paramVideoOptions)
    {
      zzpy.zzc("Failed to set video options.", paramVideoOptions);
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
        zzfd();
      }
      if (zzzZ.zzb(zzrB.zza(zzAe.getContext(), paramZzey))) {
        zzzU.zzi(paramZzey.zzeY());
      }
      return;
    }
    catch (RemoteException paramZzey)
    {
      zzpy.zzc("Failed to load ad.", paramZzey);
    }
  }
  
  public void zza(AdSize... paramVarArgs)
  {
    zzzr = paramVarArgs;
    try
    {
      if (zzzZ != null) {
        zzzZ.zza(zza(zzAe.getContext(), zzzr, zzAf));
      }
      zzAe.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        zzpy.zzc("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  public boolean zzb(zzec paramZzec)
  {
    return "search_v2".equals(zzzk);
  }
  
  public zzew zzbt()
  {
    if (zzzZ == null) {
      return null;
    }
    try
    {
      zzew localZzew = zzzZ.zzbG();
      return localZzew;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to retrieve VideoController.", localRemoteException);
    }
    return null;
  }
  
  void zzfd()
    throws RemoteException
  {
    if (((zzzr == null) || (zztq == null)) && (zzzZ == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    zzzZ = zzfe();
    zzzZ.zza(new zzdv(zzzX));
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
    if (zzsb != null) {
      zzzZ.zza(new zzfn(zzsb));
    }
    zzzZ.setManualImpressionsEnabled(zzsS);
    zzfc();
  }
  
  protected zzep zzfe()
    throws RemoteException
  {
    Context localContext = zzAe.getContext();
    zzec localZzec = zza(localContext, zzzr, zzAf);
    if (zzb(localZzec)) {
      return zzeh.zzeP().zza(localContext, localZzec, zztq);
    }
    return zzeh.zzeP().zza(localContext, localZzec, zztq, zzzU);
  }
}
