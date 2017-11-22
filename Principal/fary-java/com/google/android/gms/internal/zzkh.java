package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@zzmb
public class zzkh
  implements MediationInterstitialAdapter
{
  private Uri mUri;
  private Activity zzLg;
  private zzgl zzLh;
  private MediationInterstitialListener zzLi;
  
  public zzkh() {}
  
  public static boolean zzo(Context paramContext)
  {
    return zzgl.zzn(paramContext);
  }
  
  public void onDestroy()
  {
    zzpy.zzbc("Destroying AdMobCustomTabsAdapter adapter.");
    try
    {
      zzLh.zzd(zzLg);
      return;
    }
    catch (Exception localException)
    {
      zzpy.zzb("Exception while unbinding from CustomTabsService.", localException);
    }
  }
  
  public void onPause()
  {
    zzpy.zzbc("Pausing AdMobCustomTabsAdapter adapter.");
  }
  
  public void onResume()
  {
    zzpy.zzbc("Resuming AdMobCustomTabsAdapter adapter.");
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzLi = paramMediationInterstitialListener;
    if (zzLi == null)
    {
      zzpy.zzbe("Listener not set for mediation. Returning.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      zzpy.zzbe("AdMobCustomTabs can only work with Activity context. Bailing out.");
      zzLi.onAdFailedToLoad(this, 0);
      return;
    }
    if (!zzo(paramContext))
    {
      zzpy.zzbe("Default browser does not support custom tabs. Bailing out.");
      zzLi.onAdFailedToLoad(this, 0);
      return;
    }
    paramMediationInterstitialListener = paramBundle1.getString("tab_url");
    if (TextUtils.isEmpty(paramMediationInterstitialListener))
    {
      zzpy.zzbe("The tab_url retrieved from mediation metadata is empty. Bailing out.");
      zzLi.onAdFailedToLoad(this, 0);
      return;
    }
    zzLg = ((Activity)paramContext);
    mUri = Uri.parse(paramMediationInterstitialListener);
    zzLh = new zzgl();
    paramContext = new zzgl.zza()
    {
      public void zzfE()
      {
        zzpy.zzbc("Hinting CustomTabsService for the load of the new url.");
      }
      
      public void zzfF()
      {
        zzpy.zzbc("Disconnecting from CustomTabs service.");
      }
    };
    zzLh.zza(paramContext);
    zzLh.zze(zzLg);
    zzLi.onAdLoaded(this);
  }
  
  public void showInterstitial()
  {
    Object localObject = new CustomTabsIntent.Builder(zzLh.zzfC()).build();
    intent.setData(mUri);
    localObject = new AdOverlayInfoParcel(new zzc(intent), null, new zzh()
    {
      public void onPause()
      {
        zzpy.zzbc("AdMobCustomTabsAdapter overlay is paused.");
      }
      
      public void onResume()
      {
        zzpy.zzbc("AdMobCustomTabsAdapter overlay is resumed.");
      }
      
      public void zzbN()
      {
        zzpy.zzbc("AdMobCustomTabsAdapter overlay is closed.");
        zzkh.zza(zzkh.this).onAdClosed(zzkh.this);
        zzkh.zzc(zzkh.this).zzd(zzkh.zzb(zzkh.this));
      }
      
      public void zzbO()
      {
        zzpy.zzbc("Opening AdMobCustomTabsAdapter overlay.");
        zzkh.zza(zzkh.this).onAdOpened(zzkh.this);
      }
    }, null, new zzqa(0, 0, false));
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        zzv.zzcH().zza(zzkh.zzb(zzkh.this), zztF);
      }
    });
    zzv.zzcN().zzG(false);
  }
}
