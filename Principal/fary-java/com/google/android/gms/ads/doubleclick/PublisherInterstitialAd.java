package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.internal.zzfa;

public final class PublisherInterstitialAd
{
  private final zzfa zzrL = new zzfa(paramContext, this);
  
  public PublisherInterstitialAd(Context paramContext) {}
  
  public AdListener getAdListener()
  {
    return zzrL.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return zzrL.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return zzrL.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zzrL.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zzrL.getOnCustomRenderedAdLoadedListener();
  }
  
  public boolean isLoaded()
  {
    return zzrL.isLoaded();
  }
  
  public boolean isLoading()
  {
    return zzrL.isLoading();
  }
  
  @RequiresPermission("android.permission.INTERNET")
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zzrL.zza(paramPublisherAdRequest.zzbq());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzrL.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    zzrL.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    zzrL.setAppEventListener(paramAppEventListener);
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    zzrL.setCorrelator(paramCorrelator);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zzrL.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
  
  public void show()
  {
    zzrL.show();
  }
}
