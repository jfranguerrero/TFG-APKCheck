package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzeg
{
  private final Object zzrN = new Object();
  private zzes zzzs;
  private final zzdx zzzt;
  private final zzdw zzzu;
  private final zzfd zzzv;
  private final zzhn zzzw;
  private final zznv zzzx;
  private final zzlf zzzy;
  private final zzkq zzzz;
  
  public zzeg(zzdx paramZzdx, zzdw paramZzdw, zzfd paramZzfd, zzhn paramZzhn, zznv paramZznv, zzlf paramZzlf, zzkq paramZzkq)
  {
    zzzt = paramZzdx;
    zzzu = paramZzdw;
    zzzv = paramZzfd;
    zzzw = paramZzhn;
    zzzx = paramZznv;
    zzzy = paramZzlf;
    zzzz = paramZzkq;
  }
  
  private static boolean zza(Activity paramActivity, String paramString)
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra(paramString))
    {
      zzpy.e("useClientJar flag not found in activity intent extras.");
      return false;
    }
    return paramActivity.getBooleanExtra(paramString, false);
  }
  
  private void zzc(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "no_ads_fallback");
    localBundle.putString("flow", paramString);
    zzeh.zzeO().zza(paramContext, null, "gmob-apps", localBundle, true);
  }
  
  @Nullable
  private static zzes zzeB()
  {
    try
    {
      Object localObject = zzeg.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
      if (!(localObject instanceof IBinder))
      {
        zzpy.zzbe("ClientApi class is not an instance of IBinder");
        return null;
      }
      localObject = zzes.zza.asInterface((IBinder)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      zzpy.zzc("Failed to instantiate ClientApi class.", localException);
    }
    return null;
  }
  
  @Nullable
  private zzes zzeC()
  {
    synchronized (zzrN)
    {
      if (zzzs == null) {
        zzzs = zzeB();
      }
      zzes localZzes = zzzs;
      return localZzes;
    }
  }
  
  public zzep zza(final Context paramContext, final zzec paramZzec, final String paramString)
  {
    (zzep)zza(paramContext, false, new zza(paramContext)
    {
      public zzep zza(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createSearchAdManager(zze.zzA(paramContext), paramZzec, paramString, 10084000);
      }
      
      public zzep zzeD()
      {
        zzep localZzep = zzeg.zzb(zzeg.this).zza(paramContext, paramZzec, paramString, null, 3);
        if (localZzep != null) {
          return localZzep;
        }
        zzeg.zza(zzeg.this, paramContext, "search");
        return new zzff();
      }
    });
  }
  
  public zzep zza(final Context paramContext, final zzec paramZzec, final String paramString, final zzjs paramZzjs)
  {
    (zzep)zza(paramContext, false, new zza(paramContext)
    {
      public zzep zza(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createBannerAdManager(zze.zzA(paramContext), paramZzec, paramString, paramZzjs, 10084000);
      }
      
      public zzep zzeD()
      {
        zzep localZzep = zzeg.zzb(zzeg.this).zza(paramContext, paramZzec, paramString, paramZzjs, 1);
        if (localZzep != null) {
          return localZzep;
        }
        zzeg.zza(zzeg.this, paramContext, "banner");
        return new zzff();
      }
    });
  }
  
  public zzhb zza(final Context paramContext, final FrameLayout paramFrameLayout1, final FrameLayout paramFrameLayout2)
  {
    (zzhb)zza(paramContext, false, new zza(paramFrameLayout1)
    {
      public zzhb zze(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createNativeAdViewDelegate(zze.zzA(paramFrameLayout1), zze.zzA(paramFrameLayout2));
      }
      
      public zzhb zzeH()
      {
        zzhb localZzhb = zzeg.zze(zzeg.this).zzb(paramContext, paramFrameLayout1, paramFrameLayout2);
        if (localZzhb != null) {
          return localZzhb;
        }
        zzeg.zza(zzeg.this, paramContext, "native_ad_view_delegate");
        return new zzfh();
      }
    });
  }
  
  public zznr zza(final Context paramContext, final zzjs paramZzjs)
  {
    (zznr)zza(paramContext, false, new zza(paramContext)
    {
      public zznr zzeI()
      {
        zznr localZznr = zzeg.zzf(zzeg.this).zzb(paramContext, paramZzjs);
        if (localZznr != null) {
          return localZznr;
        }
        zzeg.zza(zzeg.this, paramContext, "rewarded_video");
        return new zzfi();
      }
      
      public zznr zzf(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createRewardedVideoAd(zze.zzA(paramContext), paramZzjs, 10084000);
      }
    });
  }
  
  @VisibleForTesting
  <T> T zza(Context paramContext, boolean paramBoolean, zza<T> paramZza)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (!zzeh.zzeO().zzP(paramContext))
      {
        zzpy.zzbc("Google Play Services is not available");
        bool = true;
      }
    }
    Object localObject;
    if (bool)
    {
      localObject = paramZza.zzeL();
      paramContext = localObject;
      if (localObject == null) {
        paramContext = paramZza.zzeM();
      }
    }
    do
    {
      return paramContext;
      localObject = paramZza.zzeM();
      paramContext = localObject;
    } while (localObject != null);
    return paramZza.zzeL();
  }
  
  public zzen zzb(final Context paramContext, final String paramString, final zzjs paramZzjs)
  {
    (zzen)zza(paramContext, false, new zza(paramContext)
    {
      public zzen zzc(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createAdLoaderBuilder(zze.zzA(paramContext), paramString, paramZzjs, 10084000);
      }
      
      public zzen zzeF()
      {
        zzen localZzen = zzeg.zzc(zzeg.this).zza(paramContext, paramString, paramZzjs);
        if (localZzen != null) {
          return localZzen;
        }
        zzeg.zza(zzeg.this, paramContext, "native_ad");
        return new zzfe();
      }
    });
  }
  
  public zzep zzb(final Context paramContext, final zzec paramZzec, final String paramString, final zzjs paramZzjs)
  {
    (zzep)zza(paramContext, false, new zza(paramContext)
    {
      public zzep zza(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createInterstitialAdManager(zze.zzA(paramContext), paramZzec, paramString, paramZzjs, 10084000);
      }
      
      public zzep zzeD()
      {
        zzep localZzep = zzeg.zzb(zzeg.this).zza(paramContext, paramZzec, paramString, paramZzjs, 2);
        if (localZzep != null) {
          return localZzep;
        }
        zzeg.zza(zzeg.this, paramContext, "interstitial");
        return new zzff();
      }
    });
  }
  
  @Nullable
  public zzla zzb(final Activity paramActivity)
  {
    (zzla)zza(paramActivity, zza(paramActivity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new zza(paramActivity)
    {
      public zzla zzeJ()
      {
        zzla localZzla = zzeg.zzg(zzeg.this).zzg(paramActivity);
        if (localZzla != null) {
          return localZzla;
        }
        zzeg.zza(zzeg.this, paramActivity, "iap");
        return null;
      }
      
      public zzla zzg(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createInAppPurchaseManager(zze.zzA(paramActivity));
      }
    });
  }
  
  @Nullable
  public zzkr zzc(final Activity paramActivity)
  {
    (zzkr)zza(paramActivity, zza(paramActivity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new zza(paramActivity)
    {
      public zzkr zzeK()
      {
        zzkr localZzkr = zzeg.zzh(zzeg.this).zzf(paramActivity);
        if (localZzkr != null) {
          return localZzkr;
        }
        zzeg.zza(zzeg.this, paramActivity, "ad_overlay");
        return null;
      }
      
      public zzkr zzh(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.createAdOverlay(zze.zzA(paramActivity));
      }
    });
  }
  
  public zzeu zzk(final Context paramContext)
  {
    (zzeu)zza(paramContext, false, new zza(paramContext)
    {
      public zzeu zzd(zzes paramAnonymousZzes)
        throws RemoteException
      {
        return paramAnonymousZzes.getMobileAdsSettingsManagerWithClientJarVersion(zze.zzA(paramContext), 10084000);
      }
      
      public zzeu zzeG()
      {
        zzeu localZzeu = zzeg.zzd(zzeg.this).zzl(paramContext);
        if (localZzeu != null) {
          return localZzeu;
        }
        zzeg.zza(zzeg.this, paramContext, "mobile_ads_settings");
        return new zzfg();
      }
    });
  }
  
  @VisibleForTesting
  abstract class zza<T>
  {
    zza() {}
    
    @Nullable
    protected abstract T zzb(zzes paramZzes)
      throws RemoteException;
    
    @Nullable
    protected abstract T zzeE()
      throws RemoteException;
    
    @Nullable
    protected final T zzeL()
    {
      Object localObject = zzeg.zza(zzeg.this);
      if (localObject == null)
      {
        zzpy.zzbe("ClientApi class cannot be loaded.");
        return null;
      }
      try
      {
        localObject = zzb((zzes)localObject);
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        zzpy.zzc("Cannot invoke local loader using ClientApi class", localRemoteException);
      }
      return null;
    }
    
    @Nullable
    protected final T zzeM()
    {
      try
      {
        Object localObject = zzeE();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        zzpy.zzc("Cannot invoke remote loader", localRemoteException);
      }
      return null;
    }
  }
}
