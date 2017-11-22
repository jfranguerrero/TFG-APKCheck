package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzdv;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhq;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzpy;

public class AdLoader
{
  private final Context mContext;
  private final zzeb zzrB;
  private final zzem zzrC;
  
  AdLoader(Context paramContext, zzem paramZzem)
  {
    this(paramContext, paramZzem, zzeb.zzey());
  }
  
  AdLoader(Context paramContext, zzem paramZzem, zzeb paramZzeb)
  {
    mContext = paramContext;
    zzrC = paramZzem;
    zzrB = paramZzeb;
  }
  
  private void zza(zzey paramZzey)
  {
    try
    {
      zzrC.zzf(zzrB.zza(mContext, paramZzey));
      return;
    }
    catch (RemoteException paramZzey)
    {
      zzpy.zzb("Failed to load ad.", paramZzey);
    }
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      String str = zzrC.getMediationAdapterClassName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public boolean isLoading()
  {
    try
    {
      boolean bool = zzrC.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  @RequiresPermission("android.permission.INTERNET")
  public void loadAd(AdRequest paramAdRequest)
  {
    zza(paramAdRequest.zzbq());
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zza(paramPublisherAdRequest.zzbq());
  }
  
  public static class Builder
  {
    private final Context mContext;
    private final zzen zzrD;
    
    Builder(Context paramContext, zzen paramZzen)
    {
      mContext = paramContext;
      zzrD = paramZzen;
    }
    
    public Builder(Context paramContext, String paramString)
    {
      this((Context)zzac.zzb(paramContext, "context cannot be null"), zzeh.zzeP().zzb(paramContext, paramString, new zzjr()));
    }
    
    public AdLoader build()
    {
      try
      {
        AdLoader localAdLoader = new AdLoader(mContext, zzrD.zzci());
        return localAdLoader;
      }
      catch (RemoteException localRemoteException)
      {
        zzpy.zzb("Failed to build AdLoader.", localRemoteException);
      }
      return null;
    }
    
    public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
    {
      try
      {
        zzrD.zza(new zzho(paramOnAppInstallAdLoadedListener));
        return this;
      }
      catch (RemoteException paramOnAppInstallAdLoadedListener)
      {
        zzpy.zzc("Failed to add app install ad listener", paramOnAppInstallAdLoadedListener);
      }
      return this;
    }
    
    public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
    {
      try
      {
        zzrD.zza(new zzhp(paramOnContentAdLoadedListener));
        return this;
      }
      catch (RemoteException paramOnContentAdLoadedListener)
      {
        zzpy.zzc("Failed to add content ad listener", paramOnContentAdLoadedListener);
      }
      return this;
    }
    
    public Builder forCustomTemplateAd(String paramString, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
    {
      try
      {
        zzen localZzen = zzrD;
        zzhr localZzhr = new zzhr(paramOnCustomTemplateAdLoadedListener);
        if (paramOnCustomClickListener == null) {}
        for (paramOnCustomTemplateAdLoadedListener = null;; paramOnCustomTemplateAdLoadedListener = new zzhq(paramOnCustomClickListener))
        {
          localZzen.zza(paramString, localZzhr, paramOnCustomTemplateAdLoadedListener);
          return this;
        }
        return this;
      }
      catch (RemoteException paramString)
      {
        zzpy.zzc("Failed to add custom template ad listener", paramString);
      }
    }
    
    public Builder withAdListener(AdListener paramAdListener)
    {
      try
      {
        zzrD.zzb(new zzdv(paramAdListener));
        return this;
      }
      catch (RemoteException paramAdListener)
      {
        zzpy.zzc("Failed to set AdListener.", paramAdListener);
      }
      return this;
    }
    
    public Builder withCorrelator(@NonNull Correlator paramCorrelator)
    {
      zzac.zzw(paramCorrelator);
      try
      {
        zzrD.zzb(paramCorrelator.zzbr());
        return this;
      }
      catch (RemoteException paramCorrelator)
      {
        zzpy.zzc("Failed to set correlator.", paramCorrelator);
      }
      return this;
    }
    
    public Builder withNativeAdOptions(NativeAdOptions paramNativeAdOptions)
    {
      try
      {
        zzrD.zza(new zzgw(paramNativeAdOptions));
        return this;
      }
      catch (RemoteException paramNativeAdOptions)
      {
        zzpy.zzc("Failed to specify native ad options", paramNativeAdOptions);
      }
      return this;
    }
  }
}
