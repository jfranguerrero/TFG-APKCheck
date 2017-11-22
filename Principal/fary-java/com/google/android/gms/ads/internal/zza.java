package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Debug;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzep.zza;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzln.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc.zza;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@zzmb
public abstract class zza
  extends zzep.zza
  implements zzq, zzdt, zzht, zzln.zza, zzmc.zza, zzpa
{
  protected zzgf zzsr;
  protected zzgd zzss;
  protected zzgd zzst;
  protected boolean zzsu = false;
  protected final zzs zzsv;
  protected final zzw zzsw;
  @Nullable
  protected transient zzdy zzsx;
  protected final zzcp zzsy;
  protected final zzd zzsz;
  
  zza(zzw paramZzw, @Nullable zzs paramZzs, zzd paramZzd)
  {
    zzsw = paramZzw;
    if (paramZzs != null) {}
    for (;;)
    {
      zzsv = paramZzs;
      zzsz = paramZzd;
      zzv.zzcJ().zzz(zzsw.zzqr);
      zzv.zzcN().zzc(zzsw.zzqr, zzsw.zzvf);
      zzv.zzcO().initialize(zzsw.zzqr);
      zzsy = zzv.zzcN().zzjZ();
      zzv.zzcM().initialize(zzsw.zzqr);
      zzbA();
      return;
      paramZzs = new zzs(this);
    }
  }
  
  private zzdy zza(zzdy paramZzdy)
  {
    zzdy localZzdy = paramZzdy;
    if (zzi.zzaK(zzsw.zzqr))
    {
      localZzdy = paramZzdy;
      if (zzyN != null) {
        localZzdy = new zzdz(paramZzdy).zza(null).zzex();
      }
    }
    return localZzdy;
  }
  
  private TimerTask zza(final Timer paramTimer, final CountDownLatch paramCountDownLatch)
  {
    new TimerTask()
    {
      public void run()
      {
        if (((Integer)zzfx.zzEh.get()).intValue() != paramCountDownLatch.getCount())
        {
          zzpe.zzbc("Stopping method tracing");
          Debug.stopMethodTracing();
          if (paramCountDownLatch.getCount() == 0L)
          {
            paramTimer.cancel();
            return;
          }
        }
        String str = String.valueOf(zzsw.zzqr.getPackageName()).concat("_adsTrace_");
        try
        {
          zzpe.zzbc("Starting method tracing");
          paramCountDownLatch.countDown();
          long l = zzv.zzcP().currentTimeMillis();
          Debug.startMethodTracing(String.valueOf(str).length() + 20 + str + l, ((Integer)zzfx.zzEi.get()).intValue());
          return;
        }
        catch (Exception localException)
        {
          zzpe.zzc("Exception occurred while starting method tracing.", localException);
        }
      }
    };
  }
  
  private void zzbA()
  {
    if (((Boolean)zzfx.zzEf.get()).booleanValue())
    {
      Timer localTimer = new Timer();
      localTimer.schedule(zza(localTimer, new CountDownLatch(((Integer)zzfx.zzEh.get()).intValue())), 0L, ((Long)zzfx.zzEg.get()).longValue());
    }
  }
  
  private void zzd(zzov paramZzov)
  {
    if ((!zzv.zzcR().zzkz()) || (zzVA) || (TextUtils.isEmpty(zzSg))) {
      return;
    }
    zzpe.zzbc("Sending troubleshooting signals to the server.");
    zzv.zzcR().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzSg, zzsw.zzvd);
    zzVA = true;
  }
  
  public void destroy()
  {
    zzac.zzdn("destroy must be called on the main UI thread.");
    zzsv.cancel();
    zzsy.zzk(zzsw.zzvk);
    zzsw.destroy();
  }
  
  public boolean isLoading()
  {
    return zzsu;
  }
  
  public boolean isReady()
  {
    zzac.zzdn("isLoaded must be called on the main UI thread.");
    return (zzsw.zzvh == null) && (zzsw.zzvi == null) && (zzsw.zzvk != null);
  }
  
  public void onAdClicked()
  {
    if (zzsw.zzvk == null) {
      zzpe.zzbe("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      zzpe.zzbc("Pinging click URLs.");
      if (zzsw.zzvm != null) {
        zzsw.zzvm.zzjA();
      }
      if (zzsw.zzvk.zzJY != null) {
        zzv.zzcJ().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk.zzJY);
      }
    } while (zzsw.zzvn == null);
    try
    {
      zzsw.zzvn.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzc("Could not notify onAdClicked event.", localRemoteException);
    }
  }
  
  public void onAppEvent(String paramString1, @Nullable String paramString2)
  {
    if (zzsw.zzvp != null) {}
    try
    {
      zzsw.zzvp.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      zzpe.zzc("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    zzac.zzdn("pause must be called on the main UI thread.");
  }
  
  public void resume()
  {
    zzac.zzdn("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }
  
  public void setUserId(String paramString)
  {
    zzpe.zzbe("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
  }
  
  public void stopLoading()
  {
    zzac.zzdn("stopLoading must be called on the main UI thread.");
    zzsu = false;
    zzsw.zzi(true);
  }
  
  public void zza(zzec paramZzec)
  {
    zzac.zzdn("setAdSize must be called on the main UI thread.");
    zzsw.zzvj = paramZzec;
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzMZ != null) && (zzsw.zzvF == 0)) {
      zzsw.zzvk.zzMZ.zza(paramZzec);
    }
    if (zzsw.zzvg == null) {
      return;
    }
    if (zzsw.zzvg.getChildCount() > 1) {
      zzsw.zzvg.removeView(zzsw.zzvg.getNextView());
    }
    zzsw.zzvg.setMinimumWidth(widthPixels);
    zzsw.zzvg.setMinimumHeight(heightPixels);
    zzsw.zzvg.requestLayout();
  }
  
  public void zza(zzek paramZzek)
  {
    zzac.zzdn("setAdListener must be called on the main UI thread.");
    zzsw.zzvn = paramZzek;
  }
  
  public void zza(zzel paramZzel)
  {
    zzac.zzdn("setAdListener must be called on the main UI thread.");
    zzsw.zzvo = paramZzel;
  }
  
  public void zza(zzer paramZzer)
  {
    zzac.zzdn("setAppEventListener must be called on the main UI thread.");
    zzsw.zzvp = paramZzer;
  }
  
  public void zza(zzet paramZzet)
  {
    zzac.zzdn("setCorrelationIdProvider must be called on the main UI thread");
    zzsw.zzvq = paramZzet;
  }
  
  public void zza(@Nullable zzfn paramZzfn)
  {
    zzac.zzdn("setVideoOptions must be called on the main UI thread.");
    zzsw.zzvy = paramZzfn;
  }
  
  public void zza(zzgj paramZzgj)
  {
    throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
  }
  
  public void zza(zzkz paramZzkz)
  {
    throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
  }
  
  public void zza(zzld paramZzld, String paramString)
  {
    throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
  }
  
  public void zza(zznt paramZznt)
  {
    zzac.zzdn("setRewardedVideoAdListener can only be called from the UI thread.");
    zzsw.zzvA = paramZznt;
  }
  
  protected void zza(@Nullable zzok paramZzok)
  {
    if (zzsw.zzvA == null) {
      return;
    }
    String str = "";
    int i = 0;
    if (paramZzok != null) {}
    try
    {
      str = type;
      i = zzVj;
      zzsw.zzvA.zza(new zznn(str, i));
      return;
    }
    catch (RemoteException paramZzok)
    {
      zzpe.zzc("Could not call RewardedVideoAdListener.onRewarded().", paramZzok);
    }
  }
  
  public void zza(zzov.zza paramZza)
  {
    if ((zzVB.zzRO != -1L) && (!TextUtils.isEmpty(zzVB.zzRX)))
    {
      long l = zzw(zzVB.zzRX);
      if (l != -1L)
      {
        zzgd localZzgd = zzsr.zzc(l + zzVB.zzRO);
        zzsr.zza(localZzgd, new String[] { "stc" });
      }
    }
    zzsr.zzX(zzVB.zzRX);
    zzsr.zza(zzss, new String[] { "arf" });
    zzst = zzsr.zzfw();
    zzsr.zzg("gqi", zzVB.zzRY);
    zzsw.zzvh = null;
    zzsw.zzvl = paramZza;
    zza(paramZza, zzsr);
  }
  
  protected abstract void zza(zzov.zza paramZza, zzgf paramZzgf);
  
  public void zza(HashSet<zzow> paramHashSet)
  {
    zzsw.zza(paramHashSet);
  }
  
  protected abstract boolean zza(zzdy paramZzdy, zzgf paramZzgf);
  
  boolean zza(zzov paramZzov)
  {
    return false;
  }
  
  protected abstract boolean zza(@Nullable zzov paramZzov1, zzov paramZzov2);
  
  protected void zzb(View paramView)
  {
    zzw.zza localZza = zzsw.zzvg;
    if (localZza != null) {
      localZza.addView(paramView, zzv.zzcL().zzks());
    }
  }
  
  public void zzb(zzov paramZzov)
  {
    zzsr.zza(zzst, new String[] { "awr" });
    zzsw.zzvi = null;
    if ((errorCode != -2) && (errorCode != 3)) {
      zzv.zzcN().zzb(zzsw.zzdi());
    }
    if (errorCode == -1)
    {
      zzsu = false;
      return;
    }
    if (zza(paramZzov)) {
      zzpe.zzbc("Ad refresh scheduled.");
    }
    if (errorCode != -2)
    {
      zzh(errorCode);
      return;
    }
    if (zzsw.zzvD == null) {
      zzsw.zzvD = new zzpb(zzsw.zzvd);
    }
    zzsy.zzj(zzsw.zzvk);
    zzgf localZzgf;
    if (zza(zzsw.zzvk, paramZzov))
    {
      zzsw.zzvk = paramZzov;
      zzsw.zzdr();
      localZzgf = zzsr;
      if (!zzsw.zzvk.zzdz()) {
        break label394;
      }
      str = "1";
      label203:
      localZzgf.zzg("is_mraid", str);
      localZzgf = zzsr;
      if (!zzsw.zzvk.zzRK) {
        break label401;
      }
      str = "1";
      label233:
      localZzgf.zzg("is_mediation", str);
      if ((zzsw.zzvk.zzMZ != null) && (zzsw.zzvk.zzMZ.zzkV() != null))
      {
        localZzgf = zzsr;
        if (!zzsw.zzvk.zzMZ.zzkV().zzlr()) {
          break label408;
        }
      }
    }
    label394:
    label401:
    label408:
    for (String str = "1";; str = "0")
    {
      localZzgf.zzg("is_delay_pl", str);
      zzsr.zza(zzss, new String[] { "ttc" });
      if (zzv.zzcN().zzjN() != null) {
        zzv.zzcN().zzjN().zza(zzsr);
      }
      if (zzsw.zzdm()) {
        zzbK();
      }
      if (zzKb == null) {
        break;
      }
      zzv.zzcJ().zza(zzsw.zzqr, zzKb);
      return;
      str = "0";
      break label203;
      str = "0";
      break label233;
    }
  }
  
  public boolean zzb(zzdy paramZzdy)
  {
    zzac.zzdn("loadAd must be called on the main UI thread.");
    zzv.zzcO().zzeq();
    if (((Boolean)zzfx.zzCy.get()).booleanValue()) {
      zzdy.zzj(paramZzdy);
    }
    paramZzdy = zza(paramZzdy);
    if ((zzsw.zzvh != null) || (zzsw.zzvi != null))
    {
      if (zzsx != null) {
        zzpe.zzbe("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      for (;;)
      {
        zzsx = paramZzdy;
        return false;
        zzpe.zzbe("Loading already in progress, saving this object for future refreshes.");
      }
    }
    zzpe.zzbd("Starting ad request.");
    zzbB();
    zzss = zzsr.zzfw();
    if (!zzyI)
    {
      String str = String.valueOf(zzeh.zzeO().zzO(zzsw.zzqr));
      zzpe.zzbd(String.valueOf(str).length() + 71 + "Use AdRequest.Builder.addTestDevice(\"" + str + "\") to get test ads on this device.");
    }
    zzsv.zzg(paramZzdy);
    zzsu = zza(paramZzdy, zzsr);
    return zzsu;
  }
  
  public void zzbB()
  {
    zzsr = new zzgf(((Boolean)zzfx.zzBK.get()).booleanValue(), "load_ad", zzsw.zzvj.zzzk);
    zzss = new zzgd(-1L, null, null);
    zzst = new zzgd(-1L, null, null);
  }
  
  public com.google.android.gms.dynamic.zzd zzbC()
  {
    zzac.zzdn("getAdFrame must be called on the main UI thread.");
    return com.google.android.gms.dynamic.zze.zzA(zzsw.zzvg);
  }
  
  @Nullable
  public zzec zzbD()
  {
    zzac.zzdn("getAdSize must be called on the main UI thread.");
    if (zzsw.zzvj == null) {
      return null;
    }
    return new zzfl(zzsw.zzvj);
  }
  
  public void zzbE()
  {
    zzbI();
  }
  
  public void zzbF()
  {
    zzac.zzdn("recordManualImpression must be called on the main UI thread.");
    if (zzsw.zzvk == null) {
      zzpe.zzbe("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      zzpe.zzbc("Pinging manual tracking URLs.");
    } while ((zzsw.zzvk.zzRM == null) || (zzsw.zzvk.zzVz));
    zzv.zzcJ().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk.zzRM);
    zzsw.zzvk.zzVz = true;
    zzd(zzsw.zzvk);
  }
  
  public zzew zzbG()
  {
    return null;
  }
  
  protected void zzbH()
  {
    zzpe.zzbd("Ad closing.");
    if (zzsw.zzvo != null) {}
    try
    {
      zzsw.zzvo.onAdClosed();
      if (zzsw.zzvA == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzsw.zzvA.onRewardedVideoAdClosed();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzpe.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzpe.zzc("Could not call AdListener.onAdClosed().", localRemoteException1);
      }
    }
  }
  
  protected void zzbI()
  {
    zzpe.zzbd("Ad leaving application.");
    if (zzsw.zzvo != null) {}
    try
    {
      zzsw.zzvo.onAdLeftApplication();
      if (zzsw.zzvA == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzsw.zzvA.onRewardedVideoAdLeftApplication();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzpe.zzc("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzpe.zzc("Could not call AdListener.onAdLeftApplication().", localRemoteException1);
      }
    }
  }
  
  protected void zzbJ()
  {
    zzpe.zzbd("Ad opening.");
    if (zzsw.zzvo != null) {}
    try
    {
      zzsw.zzvo.onAdOpened();
      if (zzsw.zzvA == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzsw.zzvA.onRewardedVideoAdOpened();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzpe.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzpe.zzc("Could not call AdListener.onAdOpened().", localRemoteException1);
      }
    }
  }
  
  protected void zzbK()
  {
    zzpe.zzbd("Ad finished loading.");
    zzsu = false;
    if (zzsw.zzvo != null) {}
    try
    {
      zzsw.zzvo.onAdLoaded();
      if (zzsw.zzvA == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzsw.zzvA.onRewardedVideoAdLoaded();
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzpe.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzpe.zzc("Could not call AdListener.onAdLoaded().", localRemoteException1);
      }
    }
  }
  
  protected void zzbL()
  {
    if (zzsw.zzvA == null) {
      return;
    }
    try
    {
      zzsw.zzvA.onRewardedVideoStarted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzc("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
  
  public zzd zzbz()
  {
    return zzsz;
  }
  
  protected void zzc(@Nullable zzov paramZzov)
  {
    if (paramZzov == null) {
      zzpe.zzbe("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      zzpe.zzbc("Pinging Impression URLs.");
      if (zzsw.zzvm != null) {
        zzsw.zzvm.zzjz();
      }
    } while ((zzJZ == null) || (zzVy));
    zzv.zzcJ().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzJZ);
    zzVy = true;
    zzd(paramZzov);
  }
  
  protected boolean zzc(zzdy paramZzdy)
  {
    if (zzsw.zzvg == null) {
      return false;
    }
    paramZzdy = zzsw.zzvg.getParent();
    if (!(paramZzdy instanceof View)) {
      return false;
    }
    paramZzdy = (View)paramZzdy;
    return zzv.zzcJ().zza(paramZzdy, paramZzdy.getContext());
  }
  
  public void zzd(zzdy paramZzdy)
  {
    if (zzc(paramZzdy))
    {
      zzb(paramZzdy);
      return;
    }
    zzpe.zzbd("Ad is not visible. Not refreshing ad.");
    zzsv.zzh(paramZzdy);
  }
  
  protected void zzh(int paramInt)
  {
    zzpe.zzbe(30 + "Failed to load ad: " + paramInt);
    zzsu = false;
    if (zzsw.zzvo != null) {}
    try
    {
      zzsw.zzvo.onAdFailedToLoad(paramInt);
      if (zzsw.zzvA == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;)
      {
        try
        {
          zzsw.zzvA.onRewardedVideoAdFailedToLoad(paramInt);
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          zzpe.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", localRemoteException2);
        }
        localRemoteException1 = localRemoteException1;
        zzpe.zzc("Could not call AdListener.onAdFailedToLoad().", localRemoteException1);
      }
    }
  }
  
  long zzw(String paramString)
  {
    int k = paramString.indexOf("ufe");
    int j = paramString.indexOf(',', k);
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      long l = Long.parseLong(paramString.substring(k + 4, i));
      return l;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      zzpe.zzbe("Invalid index for Url fetch time in CSI latency info.");
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        zzpe.zzbe("Cannot find valid format of Url fetch time in CSI latency info.");
      }
    }
  }
}
