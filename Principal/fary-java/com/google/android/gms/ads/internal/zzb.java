package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjl;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmh.zza;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzmb
public abstract class zzb
  extends zza
  implements zzh, zzj, zzt, zzhz, zzjk
{
  private final Messenger mMessenger;
  protected final zzjs zzsD;
  protected transient boolean zzsE;
  
  public zzb(Context paramContext, zzec paramZzec, String paramString, zzjs paramZzjs, zzqa paramZzqa, zzd paramZzd)
  {
    this(new zzw(paramContext, paramZzec, paramString, paramZzqa), paramZzjs, null, paramZzd);
  }
  
  protected zzb(zzw paramZzw, zzjs paramZzjs, @Nullable zzs paramZzs, zzd paramZzd)
  {
    super(paramZzw, paramZzs, paramZzd);
    zzsD = paramZzjs;
    mMessenger = new Messenger(new zzkw(zzsw.zzqr));
    zzsE = false;
  }
  
  private zzmh.zza zza(zzdy paramZzdy, Bundle paramBundle, zzox paramZzox)
  {
    ApplicationInfo localApplicationInfo = zzsw.zzqr.getApplicationInfo();
    DisplayMetrics localDisplayMetrics;
    Object localObject1;
    String str2;
    String str3;
    long l1;
    String str4;
    Bundle localBundle;
    ArrayList localArrayList;
    PackageInfo localPackageInfo2;
    try
    {
      PackageInfo localPackageInfo1 = zzsw.zzqr.getPackageManager().getPackageInfo(packageName, 0);
      localDisplayMetrics = zzsw.zzqr.getResources().getDisplayMetrics();
      Object localObject2 = null;
      localObject1 = localObject2;
      if (zzsw.zzvg != null)
      {
        localObject1 = localObject2;
        if (zzsw.zzvg.getParent() != null)
        {
          localObject1 = new int[2];
          zzsw.zzvg.getLocationOnScreen((int[])localObject1);
          int k = localObject1[0];
          int m = localObject1[1];
          int n = zzsw.zzvg.getWidth();
          int i1 = zzsw.zzvg.getHeight();
          int j = 0;
          i = j;
          if (zzsw.zzvg.isShown())
          {
            i = j;
            if (k + n > 0)
            {
              i = j;
              if (m + i1 > 0)
              {
                i = j;
                if (k <= widthPixels)
                {
                  i = j;
                  if (m <= heightPixels) {
                    i = 1;
                  }
                }
              }
            }
          }
          localObject1 = new Bundle(5);
          ((Bundle)localObject1).putInt("x", k);
          ((Bundle)localObject1).putInt("y", m);
          ((Bundle)localObject1).putInt("width", n);
          ((Bundle)localObject1).putInt("height", i1);
          ((Bundle)localObject1).putInt("visible", i);
        }
      }
      str2 = zzv.zzcN().zzjL();
      zzsw.zzvm = new zzow(str2, zzsw.zzvd);
      zzsw.zzvm.zzt(paramZzdy);
      str3 = zzv.zzcJ().zza(zzsw.zzqr, zzsw.zzvg, zzsw.zzvj);
      l2 = 0L;
      l1 = l2;
      if (zzsw.zzvq == null) {}
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        l1 = zzsw.zzvq.getValue();
        str4 = UUID.randomUUID().toString();
        localBundle = zzv.zzcN().zza(zzsw.zzqr, this, str2);
        localArrayList = new ArrayList();
        int i = 0;
        while (i < zzsw.zzvw.size())
        {
          localArrayList.add((String)zzsw.zzvw.keyAt(i));
          i += 1;
          continue;
          localNameNotFoundException = localNameNotFoundException;
          localPackageInfo2 = null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          long l2;
          zzpe.zzbe("Cannot get correlation id, default to 0.");
          l1 = l2;
        }
      }
    }
    boolean bool1;
    if (zzsw.zzvr != null)
    {
      bool1 = true;
      if ((zzsw.zzvs == null) || (!zzv.zzcN().zzkb())) {
        break label797;
      }
    }
    label797:
    for (boolean bool2 = true;; bool2 = false)
    {
      String str1 = "";
      Object localObject3 = str1;
      if (((Boolean)zzfx.zzEH.get()).booleanValue())
      {
        zzpe.zzbc("Getting webview cookie from CookieManager.");
        CookieManager localCookieManager = zzv.zzcL().zzL(zzsw.zzqr);
        localObject3 = str1;
        if (localCookieManager != null) {
          localObject3 = localCookieManager.getCookie("googleads.g.doubleclick.net");
        }
      }
      str1 = null;
      if (paramZzox != null) {
        str1 = paramZzox.zzjH();
      }
      return new zzmh.zza((Bundle)localObject1, paramZzdy, zzsw.zzvj, zzsw.zzvd, localApplicationInfo, localPackageInfo2, str2, zzv.zzcN().getSessionId(), zzsw.zzvf, localBundle, zzsw.zzvB, localArrayList, paramBundle, zzv.zzcN().zzjP(), mMessenger, widthPixels, heightPixels, density, str3, l1, str4, zzfx.zzfn(), zzsw.zzvc, zzsw.zzvx, new zzmo(bool1, bool2, false), zzsw.zzdq(), zzv.zzcJ().zzco(), zzv.zzcJ().zzcq(), zzv.zzcJ().zzI(zzsw.zzqr), zzv.zzcJ().zzs(zzsw.zzvg), zzsw.zzqr instanceof Activity, zzv.zzcN().zzjU(), (String)localObject3, str1, zzv.zzcN().zzjX(), zzv.zzdg().zzgf(), zzv.zzcJ().zzko(), zzv.zzcR().zzky());
      bool1 = false;
      break;
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (zzsw.zzvk == null) {
      return null;
    }
    return zzsw.zzvk.zzKC;
  }
  
  public void onAdClicked()
  {
    if (zzsw.zzvk == null)
    {
      zzpe.zzbe("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((zzsw.zzvk.zzVr != null) && (zzsw.zzvk.zzVr.zzJY != null)) {
      zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk, zzsw.zzvd, false, zzsw.zzvk.zzVr.zzJY);
    }
    if ((zzsw.zzvk.zzKA != null) && (zzsw.zzvk.zzKA.zzJL != null)) {
      zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk, zzsw.zzvd, false, zzsw.zzvk.zzKA.zzJL);
    }
    super.onAdClicked();
  }
  
  public void onPause()
  {
    zzsy.zzl(zzsw.zzvk);
  }
  
  public void onResume()
  {
    zzsy.zzm(zzsw.zzvk);
  }
  
  public void pause()
  {
    zzac.zzdn("pause must be called on the main UI thread.");
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzMZ != null) && (zzsw.zzdm())) {
      zzv.zzcL().zzl(zzsw.zzvk.zzMZ);
    }
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzKB != null)) {}
    try
    {
      zzsw.zzvk.zzKB.pause();
      zzsy.zzl(zzsw.zzvk);
      zzsv.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpe.zzbe("Could not pause mediation adapter.");
      }
    }
  }
  
  public void recordImpression()
  {
    zza(zzsw.zzvk, false);
  }
  
  public void resume()
  {
    zzac.zzdn("resume must be called on the main UI thread.");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (zzsw.zzvk != null)
    {
      localObject1 = localObject2;
      if (zzsw.zzvk.zzMZ != null) {
        localObject1 = zzsw.zzvk.zzMZ;
      }
    }
    if ((localObject1 != null) && (zzsw.zzdm())) {
      zzv.zzcL().zzm(zzsw.zzvk.zzMZ);
    }
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzKB != null)) {}
    try
    {
      zzsw.zzvk.zzKB.resume();
      if ((localObject1 == null) || (!((zzqp)localObject1).zzlc())) {
        zzsv.resume();
      }
      zzsy.zzm(zzsw.zzvk);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpe.zzbe("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }
  
  public void zza(zzkz paramZzkz)
  {
    zzac.zzdn("setInAppPurchaseListener must be called on the main UI thread.");
    zzsw.zzvr = paramZzkz;
  }
  
  public void zza(zzld paramZzld, @Nullable String paramString)
  {
    zzac.zzdn("setPlayStorePurchaseParams must be called on the main UI thread.");
    zzsw.zzvC = new zzk(paramString);
    zzsw.zzvs = paramZzld;
    if ((!zzv.zzcN().zzjO()) && (paramZzld != null)) {
      new zzc(zzsw.zzqr, zzsw.zzvs, zzsw.zzvC).zziw();
    }
  }
  
  protected void zza(@Nullable zzov paramZzov, boolean paramBoolean)
  {
    if (paramZzov == null) {
      zzpe.zzbe("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      super.zzc(paramZzov);
      if ((zzVr != null) && (zzVr.zzJZ != null)) {
        zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, paramZzov, zzsw.zzvd, paramBoolean, zzVr.zzJZ);
      }
    } while ((zzKA == null) || (zzKA.zzJM == null));
    zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, paramZzov, zzsw.zzvd, paramBoolean, zzKA.zzJM);
  }
  
  public void zza(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new com.google.android.gms.ads.internal.purchase.zzd(paramString, paramArrayList, zzsw.zzqr, zzsw.zzvf.zzaZ);
    if (zzsw.zzvr == null)
    {
      zzpe.zzbe("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (!zzeh.zzeO().zzP(zzsw.zzqr))
      {
        zzpe.zzbe("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (zzsw.zzvs == null)
      {
        zzpe.zzbe("PlayStorePurchaseListener is not set.");
        return;
      }
      if (zzsw.zzvC == null)
      {
        zzpe.zzbe("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (zzsw.zzvG)
      {
        zzpe.zzbe("An in-app purchase request is already in progress, abort");
        return;
      }
      zzsw.zzvG = true;
      try
      {
        if (!zzsw.zzvs.isValidPurchase(paramString))
        {
          zzsw.zzvG = false;
          return;
        }
      }
      catch (RemoteException paramString)
      {
        zzpe.zzbe("Could not start In-App purchase.");
        zzsw.zzvG = false;
        return;
      }
      zzv.zzcX().zza(zzsw.zzqr, zzsw.zzvf.zzYd, new GInAppPurchaseManagerInfoParcel(zzsw.zzqr, zzsw.zzvC, paramArrayList, this));
      return;
    }
    try
    {
      zzsw.zzvr.zza(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      zzpe.zzbe("Could not start In-App purchase.");
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, zzf paramZzf)
  {
    try
    {
      if (zzsw.zzvs != null) {
        zzsw.zzvs.zza(new com.google.android.gms.ads.internal.purchase.zzg(zzsw.zzqr, paramString, paramBoolean, paramInt, paramIntent, paramZzf));
      }
      zzpi.zzWR.postDelayed(new Runnable()
      {
        public void run()
        {
          int i = zzv.zzcX().zzd(paramIntent);
          zzv.zzcX();
          if ((i == 0) && (zzsw.zzvk != null) && (zzsw.zzvk.zzMZ != null) && (zzsw.zzvk.zzMZ.zzkT() != null)) {
            zzsw.zzvk.zzMZ.zzkT().close();
          }
          zzsw.zzvG = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        zzpe.zzbe("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public boolean zza(zzdy paramZzdy, zzgf paramZzgf)
  {
    if (!zzbM()) {
      return false;
    }
    Bundle localBundle = zzv.zzcJ().zzK(zzsw.zzqr);
    zzsv.cancel();
    zzsw.zzvF = 0;
    zzox localZzox = null;
    if (((Boolean)zzfx.zzEp.get()).booleanValue())
    {
      localZzox = zzv.zzcN().zzjY();
      zzv.zzdf().zza(zzsw.zzqr, zzsw.zzvf, false, localZzox, localZzox.zzjI(), zzsw.zzvd);
    }
    paramZzdy = zza(paramZzdy, localBundle, localZzox);
    paramZzgf.zzg("seq_num", zzRg);
    paramZzgf.zzg("request_id", zzRr);
    paramZzgf.zzg("session_id", zzRh);
    if (zzRe != null) {
      paramZzgf.zzg("app_version", String.valueOf(zzRe.versionCode));
    }
    zzsw.zzvh = zzv.zzcF().zza(zzsw.zzqr, paramZzdy, zzsw.zzve, this);
    return true;
  }
  
  protected boolean zza(zzdy paramZzdy, zzov paramZzov, boolean paramBoolean)
  {
    if ((!paramBoolean) && (zzsw.zzdm()))
    {
      if (zzKe <= 0L) {
        break label43;
      }
      zzsv.zza(paramZzdy, zzKe);
    }
    for (;;)
    {
      return zzsv.zzcv();
      label43:
      if ((zzVr != null) && (zzVr.zzKe > 0L)) {
        zzsv.zza(paramZzdy, zzVr.zzKe);
      } else if ((!zzRK) && (errorCode == 2)) {
        zzsv.zzh(paramZzdy);
      }
    }
  }
  
  boolean zza(zzov paramZzov)
  {
    boolean bool = false;
    Object localObject;
    if (zzsx != null)
    {
      localObject = zzsx;
      zzsx = null;
    }
    for (;;)
    {
      return zza((zzdy)localObject, paramZzov, bool);
      zzdy localZzdy = zzRd;
      localObject = localZzdy;
      if (extras != null)
      {
        bool = extras.getBoolean("_noRefresh", false);
        localObject = localZzdy;
      }
    }
  }
  
  protected boolean zza(@Nullable zzov paramZzov1, zzov paramZzov2)
  {
    int i = 0;
    if ((paramZzov1 != null) && (zzKD != null)) {
      zzKD.zza(null);
    }
    if (zzKD != null) {
      zzKD.zza(this);
    }
    int j;
    if (zzVr != null)
    {
      j = zzVr.zzKk;
      i = zzVr.zzKl;
    }
    for (;;)
    {
      zzsw.zzvD.zzj(j, i);
      return true;
      j = 0;
    }
  }
  
  public void zzb(zzov paramZzov)
  {
    super.zzb(paramZzov);
    if (zzKA != null)
    {
      zzpe.zzbc("Disable the debug gesture detector on the mediation ad frame.");
      if (zzsw.zzvg != null) {
        zzsw.zzvg.zzdu();
      }
      zzpe.zzbc("Pinging network fill URLs.");
      zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, paramZzov, zzsw.zzvd, false, zzKA.zzJN);
      if ((zzVr != null) && (zzVr.zzKb != null) && (zzVr.zzKb.size() > 0))
      {
        zzpe.zzbc("Pinging urls remotely");
        zzv.zzcJ().zza(zzsw.zzqr, zzVr.zzKb);
      }
    }
    for (;;)
    {
      if ((errorCode == 3) && (zzVr != null) && (zzVr.zzKa != null))
      {
        zzpe.zzbc("Pinging no fill URLs.");
        zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, paramZzov, zzsw.zzvd, false, zzVr.zzKa);
      }
      return;
      zzpe.zzbc("Enable the debug gesture detector on the admob ad frame.");
      if (zzsw.zzvg != null) {
        zzsw.zzvg.zzdt();
      }
    }
  }
  
  protected boolean zzbM()
  {
    boolean bool = true;
    if ((!zzv.zzcJ().zza(zzsw.zzqr.getPackageManager(), zzsw.zzqr.getPackageName(), "android.permission.INTERNET")) || (!zzv.zzcJ().zzy(zzsw.zzqr))) {
      bool = false;
    }
    return bool;
  }
  
  public void zzbN()
  {
    zzsy.zzj(zzsw.zzvk);
    zzsE = false;
    zzbH();
    zzsw.zzvm.zzjB();
  }
  
  public void zzbO()
  {
    zzsE = true;
    zzbJ();
  }
  
  public void zzbP()
  {
    onAdClicked();
  }
  
  public void zzbQ()
  {
    zzbN();
  }
  
  public void zzbR()
  {
    zzbE();
  }
  
  public void zzbS()
  {
    zzbO();
  }
  
  public void zzbT()
  {
    if (zzsw.zzvk != null)
    {
      String str = zzsw.zzvk.zzKC;
      zzpe.zzbe(String.valueOf(str).length() + 74 + "Mediation adapter " + str + " refreshed, but mediation adapters should never refresh.");
    }
    zza(zzsw.zzvk, true);
    zzbK();
  }
  
  public void zzbU()
  {
    recordImpression();
  }
  
  public void zzbV()
  {
    zzv.zzcJ().runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzsv.pause();
      }
    });
  }
  
  public void zzbW()
  {
    zzv.zzcJ().runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzsv.resume();
      }
    });
  }
  
  protected boolean zzc(zzdy paramZzdy)
  {
    return (super.zzc(paramZzdy)) && (!zzsE);
  }
}
