package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzfa;

public final class InterstitialAd
{
  private final zzfa zzrL;
  
  public InterstitialAd(Context paramContext)
  {
    zzrL = new zzfa(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return zzrL.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return zzrL.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zzrL.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zzrL.getMediationAdapterClassName();
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
  public void loadAd(AdRequest paramAdRequest)
  {
    zzrL.zza(paramAdRequest.zzbq());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzrL.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zzdt))) {
      zzrL.zza((zzdt)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zzrL.zza(null);
  }
  
  public void setAdUnitId(String paramString)
  {
    zzrL.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zzrL.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    zzrL.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    zzrL.setRewardedVideoAdListener(paramRewardedVideoAdListener);
  }
  
  public void show()
  {
    zzrL.show();
  }
  
  public void zzd(boolean paramBoolean)
  {
    zzrL.zzd(paramBoolean);
  }
}
