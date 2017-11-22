package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzes.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgy;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zziv;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zzqa;

@zzmb
@Keep
@DynamiteApi
public class ClientApi
  extends zzes.zza
{
  public ClientApi() {}
  
  public zzen createAdLoaderBuilder(com.google.android.gms.dynamic.zzd paramZzd, String paramString, zzjs paramZzjs, int paramInt)
  {
    return new zzk((Context)com.google.android.gms.dynamic.zze.zzE(paramZzd), paramString, paramZzjs, new zzqa(10084000, paramInt, true), zzd.zzca());
  }
  
  public zzkr createAdOverlay(com.google.android.gms.dynamic.zzd paramZzd)
  {
    return new com.google.android.gms.ads.internal.overlay.zze((Activity)com.google.android.gms.dynamic.zze.zzE(paramZzd));
  }
  
  public zzep createBannerAdManager(com.google.android.gms.dynamic.zzd paramZzd, zzec paramZzec, String paramString, zzjs paramZzjs, int paramInt)
    throws RemoteException
  {
    return new zzf((Context)com.google.android.gms.dynamic.zze.zzE(paramZzd), paramZzec, paramString, paramZzjs, new zzqa(10084000, paramInt, true), zzd.zzca());
  }
  
  public zzla createInAppPurchaseManager(com.google.android.gms.dynamic.zzd paramZzd)
  {
    return new com.google.android.gms.ads.internal.purchase.zze((Activity)com.google.android.gms.dynamic.zze.zzE(paramZzd));
  }
  
  public zzep createInterstitialAdManager(com.google.android.gms.dynamic.zzd paramZzd, zzec paramZzec, String paramString, zzjs paramZzjs, int paramInt)
    throws RemoteException
  {
    paramZzd = (Context)com.google.android.gms.dynamic.zze.zzE(paramZzd);
    zzfx.initialize(paramZzd);
    zzqa localZzqa = new zzqa(10084000, paramInt, true);
    boolean bool = "reward_mb".equals(zzzk);
    if (((!bool) && (((Boolean)zzfx.zzCA.get()).booleanValue())) || ((bool) && (((Boolean)zzfx.zzCB.get()).booleanValue()))) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0) {
      return new zziv(paramZzd, paramString, paramZzjs, localZzqa, zzd.zzca());
    }
    return new zzl(paramZzd, paramZzec, paramString, paramZzjs, localZzqa, zzd.zzca());
  }
  
  public zzhb createNativeAdViewDelegate(com.google.android.gms.dynamic.zzd paramZzd1, com.google.android.gms.dynamic.zzd paramZzd2)
  {
    return new zzgy((FrameLayout)com.google.android.gms.dynamic.zze.zzE(paramZzd1), (FrameLayout)com.google.android.gms.dynamic.zze.zzE(paramZzd2));
  }
  
  public zznr createRewardedVideoAd(com.google.android.gms.dynamic.zzd paramZzd, zzjs paramZzjs, int paramInt)
  {
    paramZzd = (Context)com.google.android.gms.dynamic.zze.zzE(paramZzd);
    zzqa localZzqa = new zzqa(10084000, paramInt, true);
    return new zzno(paramZzd, zzd.zzca(), paramZzjs, localZzqa);
  }
  
  public zzep createSearchAdManager(com.google.android.gms.dynamic.zzd paramZzd, zzec paramZzec, String paramString, int paramInt)
    throws RemoteException
  {
    return new zzu((Context)com.google.android.gms.dynamic.zze.zzE(paramZzd), paramZzec, paramString, new zzqa(10084000, paramInt, true));
  }
  
  @Nullable
  public zzeu getMobileAdsSettingsManager(com.google.android.gms.dynamic.zzd paramZzd)
  {
    return null;
  }
  
  public zzeu getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zzd paramZzd, int paramInt)
  {
    return zzp.zza((Context)com.google.android.gms.dynamic.zze.zzE(paramZzd), new zzqa(10084000, paramInt, true));
  }
}
