package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzig.zza;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmh;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqr;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzl
  extends zzc
  implements zzib, zzig.zza
{
  private int zztA = -1;
  private boolean zztB;
  private float zztC;
  protected transient boolean zztz = false;
  
  public zzl(Context paramContext, zzec paramZzec, String paramString, zzjs paramZzjs, zzqa paramZzqa, zzd paramZzd)
  {
    super(paramContext, paramZzec, paramString, paramZzjs, paramZzqa, paramZzd);
  }
  
  private void zzb(Bundle paramBundle)
  {
    zzv.zzcJ().zzb(zzsw.zzqr, zzsw.zzvf.zzaZ, "gmob-apps", paramBundle, false);
  }
  
  static zzov.zza zzc(zzov.zza paramZza)
  {
    try
    {
      Object localObject1 = zzna.zzc(zzVB).toString();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pubid", zzSF.zzvd);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject2 = new zzji((String)localObject1, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), (String)localObject2, null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
      localObject1 = zzVB;
      localObject2 = new zzjj(Collections.singletonList(localObject2), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzKb, zzKc, "", -1L, 0, 1, null, 0, -1, -1L, false);
      localObject1 = new zzmk(zzSF, zzNb, body, Collections.emptyList(), Collections.emptyList(), zzRJ, true, zzRL, Collections.emptyList(), zzKe, orientation, zzRN, zzRO, zzRP, zzRQ, zzRR, null, zzRT, zzzn, zzRl, zzRU, zzRV, zzRY, zzzo, zzzp, null, Collections.emptyList(), Collections.emptyList(), zzSc, zzSd, zzRB, zzRC, zzKb, zzKc, zzSe, null, zzSg, zzSh);
      return new zzov.zza(zzSF, (zzmk)localObject1, (zzjj)localObject2, zzvj, errorCode, zzVv, zzVw, null);
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzb("Unable to generate ad state for an interstitial ad with pooling.", localJSONException);
    }
    return paramZza;
  }
  
  public void showInterstitial()
  {
    zzac.zzdn("showInterstitial must be called on the main UI thread.");
    if (zzsw.zzvk == null)
    {
      zzpe.zzbe("The interstitial has not loaded.");
      return;
    }
    if (((Boolean)zzfx.zzCR.get()).booleanValue()) {
      if (zzsw.zzqr.getApplicationContext() == null) {
        break label235;
      }
    }
    label235:
    for (String str = zzsw.zzqr.getApplicationContext().getPackageName();; localObject = zzsw.zzqr.getPackageName())
    {
      Bundle localBundle;
      if (!zztz)
      {
        zzpe.zzbe("It is not recommended to show an interstitial before onAdLoaded completes.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_before_load_finish");
        zzb(localBundle);
      }
      if (!zzv.zzcJ().zzE(zzsw.zzqr))
      {
        zzpe.zzbe("It is not recommended to show an interstitial when app is not in foreground.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_app_not_in_foreground");
        zzb(localBundle);
      }
      if (zzsw.zzdn()) {
        break;
      }
      if ((!zzsw.zzvk.zzRK) || (zzsw.zzvk.zzKB == null)) {
        break label249;
      }
      try
      {
        zzsw.zzvk.zzKB.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzpe.zzc("Could not show interstitial.", localRemoteException);
        zzck();
        return;
      }
    }
    label249:
    if (zzsw.zzvk.zzMZ == null)
    {
      zzpe.zzbe("The interstitial failed to load.");
      return;
    }
    if (zzsw.zzvk.zzMZ.zzkZ())
    {
      zzpe.zzbe("The interstitial is already showing.");
      return;
    }
    zzsw.zzvk.zzMZ.zzJ(true);
    if (zzsw.zzvk.zzVp != null) {
      zzsy.zza(zzsw.zzvj, zzsw.zzvk);
    }
    if (com.google.android.gms.common.util.zzs.zzyA())
    {
      localObject = zzsw.zzvk;
      if (((zzov)localObject).zzdz()) {
        new zzcv(zzsw.zzqr, zzMZ.getView()).zza(zzMZ);
      }
    }
    else
    {
      if (!zzsw.zztH) {
        break label490;
      }
    }
    label490:
    for (Object localObject = zzv.zzcJ().zzF(zzsw.zzqr);; localObject = null)
    {
      zztA = zzv.zzde().zzb((Bitmap)localObject);
      if ((!((Boolean)zzfx.zzDJ.get()).booleanValue()) || (localObject == null)) {
        break label495;
      }
      new zza(zztA).zziw();
      return;
      zzMZ.zzkV().zza(new zzqq.zzc()
      {
        public void zzcd()
        {
          new zzcv(zzsw.zzqr, zzsW.zzMZ.getView()).zza(zzsW.zzMZ);
        }
      });
      break;
    }
    label495:
    localObject = new zzm(zzsw.zztH, zzcj(), false, 0.0F, -1);
    int j = zzsw.zzvk.zzMZ.getRequestedOrientation();
    int i = j;
    if (j == -1) {
      i = zzsw.zzvk.orientation;
    }
    localObject = new AdOverlayInfoParcel(this, this, this, zzsw.zzvk.zzMZ, i, zzsw.zzvf, zzsw.zzvk.zzRP, (zzm)localObject);
    zzv.zzcH().zza(zzsw.zzqr, (AdOverlayInfoParcel)localObject);
  }
  
  protected zzqp zza(zzov.zza paramZza, @Nullable zze paramZze, @Nullable zzop paramZzop)
  {
    zzqp localZzqp = zzv.zzcK().zza(zzsw.zzqr, zzsw.zzvj, false, false, zzsw.zzve, zzsw.zzvf, zzsr, this, zzsz);
    localZzqp.zzkV().zza(this, null, this, this, ((Boolean)zzfx.zzCh.get()).booleanValue(), this, this, paramZze, null, paramZzop);
    zza(localZzqp);
    localZzqp.zzbg(zzSF.zzRr);
    zzig.zza(localZzqp, this);
    return localZzqp;
  }
  
  public void zza(zzov.zza paramZza, zzgf paramZzgf)
  {
    int j = 1;
    if (!((Boolean)zzfx.zzCA.get()).booleanValue())
    {
      super.zza(paramZza, paramZzgf);
      return;
    }
    if (errorCode != -2)
    {
      super.zza(paramZza, paramZzgf);
      return;
    }
    Bundle localBundle = zzSF.zzRd.zzyP.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    int i;
    if ((localBundle == null) || (!localBundle.containsKey("gw")))
    {
      i = 1;
      if (zzVB.zzRK) {
        break label124;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0)) {
        zzsw.zzvl = zzc(paramZza);
      }
      super.zza(zzsw.zzvl, paramZzgf);
      return;
      i = 0;
      break;
      label124:
      j = 0;
    }
  }
  
  public void zza(boolean paramBoolean, float paramFloat)
  {
    zztB = paramBoolean;
    zztC = paramFloat;
  }
  
  public boolean zza(zzdy paramZzdy, zzgf paramZzgf)
  {
    if (zzsw.zzvk != null)
    {
      zzpe.zzbe("An interstitial is already loading. Aborting.");
      return false;
    }
    return super.zza(paramZzdy, paramZzgf);
  }
  
  protected boolean zza(zzdy paramZzdy, zzov paramZzov, boolean paramBoolean)
  {
    if ((zzsw.zzdm()) && (zzMZ != null)) {
      zzv.zzcL().zzl(zzMZ);
    }
    return zzsv.zzcv();
  }
  
  public boolean zza(@Nullable zzov paramZzov1, zzov paramZzov2)
  {
    if (!super.zza(paramZzov1, paramZzov2)) {
      return false;
    }
    if ((!zzsw.zzdm()) && (zzsw.zzvE != null) && (zzVp != null)) {
      zzsy.zza(zzsw.zzvj, paramZzov2, zzsw.zzvE);
    }
    return true;
  }
  
  public void zzb(zzok paramZzok)
  {
    zzok localZzok = paramZzok;
    if (zzsw.zzvk != null)
    {
      if (zzsw.zzvk.zzSb != null) {
        zzv.zzcJ().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk.zzSb);
      }
      localZzok = paramZzok;
      if (zzsw.zzvk.zzRZ != null) {
        localZzok = zzsw.zzvk.zzRZ;
      }
    }
    zza(localZzok);
  }
  
  protected void zzbH()
  {
    zzck();
    super.zzbH();
  }
  
  protected void zzbK()
  {
    super.zzbK();
    zztz = true;
  }
  
  public void zzbO()
  {
    recordImpression();
    super.zzbO();
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzMZ != null))
    {
      zzqq localZzqq = zzsw.zzvk.zzMZ.zzkV();
      if (localZzqq != null) {
        localZzqq.zzlt();
      }
    }
  }
  
  protected boolean zzcj()
  {
    if (!(zzsw.zzqr instanceof Activity)) {}
    Window localWindow;
    do
    {
      return false;
      localWindow = ((Activity)zzsw.zzqr).getWindow();
    } while ((localWindow == null) || (localWindow.getDecorView() == null));
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    if ((bottom != 0) && (bottom != 0) && (top == top)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzck()
  {
    zzv.zzde().zzb(Integer.valueOf(zztA));
    if (zzsw.zzdm())
    {
      zzsw.zzdj();
      zzsw.zzvk = null;
      zzsw.zztH = false;
      zztz = false;
    }
  }
  
  public void zzcl()
  {
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzVu != null)) {
      zzv.zzcJ().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk.zzVu);
    }
    zzbL();
  }
  
  public void zzg(boolean paramBoolean)
  {
    zzsw.zztH = paramBoolean;
  }
  
  @zzmb
  private class zza
    extends zzpd
  {
    private final int zztE;
    
    public zza(int paramInt)
    {
      zztE = paramInt;
    }
    
    public void onStop() {}
    
    public void zzcm()
    {
      boolean bool1 = zzsw.zztH;
      boolean bool2 = zzcj();
      boolean bool3 = zzl.zza(zzl.this);
      float f = zzl.zzb(zzl.this);
      int i;
      Object localObject;
      if (zzsw.zztH)
      {
        i = zztE;
        localObject = new zzm(bool1, bool2, bool3, f, i);
        i = zzsw.zzvk.zzMZ.getRequestedOrientation();
        if (i != -1) {
          break label192;
        }
        i = zzsw.zzvk.orientation;
      }
      label192:
      for (;;)
      {
        localObject = new AdOverlayInfoParcel(zzl.this, zzl.this, zzl.this, zzsw.zzvk.zzMZ, i, zzsw.zzvf, zzsw.zzvk.zzRP, (zzm)localObject);
        zzpi.zzWR.post(new Runnable()
        {
          public void run()
          {
            zzv.zzcH().zza(zzsw.zzqr, zztF);
          }
        });
        return;
        i = -1;
        break;
      }
    }
  }
}
