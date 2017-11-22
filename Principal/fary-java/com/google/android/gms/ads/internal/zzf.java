package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.internal.zzqu;
import java.util.List;

@zzmb
public class zzf
  extends zzc
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private boolean zzsS;
  
  public zzf(Context paramContext, zzec paramZzec, String paramString, zzjs paramZzjs, zzqa paramZzqa, zzd paramZzd)
  {
    super(paramContext, paramZzec, paramString, paramZzjs, paramZzqa, paramZzd);
  }
  
  private zzec zzb(zzov.zza paramZza)
  {
    if (zzVB.zzzo) {
      return zzsw.zzvj;
    }
    paramZza = zzVB.zzRN;
    if (paramZza != null)
    {
      paramZza = paramZza.split("[xX]");
      paramZza[0] = paramZza[0].trim();
      paramZza[1] = paramZza[1].trim();
    }
    for (paramZza = new AdSize(Integer.parseInt(paramZza[0]), Integer.parseInt(paramZza[1]));; paramZza = zzsw.zzvj.zzeA()) {
      return new zzec(zzsw.zzqr, paramZza);
    }
  }
  
  private boolean zzb(@Nullable zzov paramZzov1, zzov paramZzov2)
  {
    View localView1;
    if (zzRK)
    {
      localView1 = zzo.zzg(paramZzov2);
      if (localView1 == null)
      {
        zzpe.zzbe("Could not get mediation view");
        return false;
      }
      View localView2 = zzsw.zzvg.getNextView();
      if (localView2 != null)
      {
        if ((localView2 instanceof zzqp)) {
          ((zzqp)localView2).destroy();
        }
        zzsw.zzvg.removeView(localView2);
      }
      if (zzo.zzh(paramZzov2)) {}
    }
    for (;;)
    {
      try
      {
        zzb(localView1);
        if (zzsw.zzvg.getChildCount() > 1) {
          zzsw.zzvg.showNext();
        }
        if (paramZzov1 != null)
        {
          paramZzov1 = zzsw.zzvg.getNextView();
          if (!(paramZzov1 instanceof zzqp)) {
            break label271;
          }
          ((zzqp)paramZzov1).zza(zzsw.zzqr, zzsw.zzvj, zzsr);
          zzsw.zzdl();
        }
        zzsw.zzvg.setVisibility(0);
        return true;
      }
      catch (Throwable paramZzov1)
      {
        zzpe.zzc("Could not add mediation view to view hierarchy.", paramZzov1);
        return false;
      }
      if ((zzVt != null) && (zzMZ != null))
      {
        zzMZ.zza(zzVt);
        zzsw.zzvg.removeAllViews();
        zzsw.zzvg.setMinimumWidth(zzVt.widthPixels);
        zzsw.zzvg.setMinimumHeight(zzVt.heightPixels);
        zzb(zzMZ.getView());
        continue;
        label271:
        if (paramZzov1 != null) {
          zzsw.zzvg.removeView(paramZzov1);
        }
      }
    }
  }
  
  private void zze(final zzov paramZzov)
  {
    if (!zzs.zzyA()) {}
    do
    {
      do
      {
        return;
        if (!zzsw.zzdm()) {
          break;
        }
      } while (zzMZ == null);
      if (zzVp != null) {
        zzsy.zza(zzsw.zzvj, paramZzov);
      }
      if (paramZzov.zzdz())
      {
        new zzcv(zzsw.zzqr, zzMZ.getView()).zza(zzMZ);
        return;
      }
      zzMZ.zzkV().zza(new zzqq.zzc()
      {
        public void zzcd()
        {
          new zzcv(zzsw.zzqr, paramZzovzzMZ.getView()).zza(paramZzovzzMZ);
        }
      });
      return;
    } while ((zzsw.zzvE == null) || (zzVp == null));
    zzsy.zza(zzsw.zzvj, paramZzov, zzsw.zzvE);
  }
  
  public void onGlobalLayout()
  {
    zzf(zzsw.zzvk);
  }
  
  public void onScrollChanged()
  {
    zzf(zzsw.zzvk);
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzac.zzdn("setManualImpressionsEnabled must be called from the main thread.");
    zzsS = paramBoolean;
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  protected zzqp zza(zzov.zza paramZza, @Nullable zze paramZze, @Nullable zzop paramZzop)
  {
    if ((zzsw.zzvj.zzzm == null) && (zzsw.zzvj.zzzo)) {
      zzsw.zzvj = zzb(paramZza);
    }
    return super.zza(paramZza, paramZze, paramZzop);
  }
  
  protected void zza(@Nullable zzov paramZzov, boolean paramBoolean)
  {
    super.zza(paramZzov, paramBoolean);
    if (zzo.zzh(paramZzov)) {
      zzo.zza(paramZzov, new zza());
    }
  }
  
  public boolean zza(@Nullable zzov paramZzov1, final zzov paramZzov2)
  {
    if (!super.zza(paramZzov1, paramZzov2)) {
      return false;
    }
    if ((zzsw.zzdm()) && (!zzb(paramZzov1, paramZzov2)))
    {
      zzh(0);
      return false;
    }
    Object localObject;
    if (zzSc)
    {
      zzf(paramZzov2);
      zzv.zzdh().zza(zzsw.zzvg, this);
      zzv.zzdh().zza(zzsw.zzvg, this);
      if (!zzVq)
      {
        localObject = new Runnable()
        {
          public void run()
          {
            zzf(zzsw.zzvk);
          }
        };
        if (zzMZ == null) {
          break label205;
        }
        paramZzov1 = zzMZ.zzkV();
        if (paramZzov1 != null) {
          paramZzov1.zza(new zzqq.zze()
          {
            public void zzcc()
            {
              if (!paramZzov2zzVq)
              {
                zzv.zzcJ();
                zzpi.zzb(zzsV);
              }
            }
          });
        }
      }
      label128:
      if (zzMZ == null) {
        break label244;
      }
      localObject = zzMZ.zzlg();
      zzqq localZzqq = zzMZ.zzkV();
      paramZzov1 = (zzov)localObject;
      if (localZzqq != null) {
        localZzqq.zzlt();
      }
    }
    label205:
    label244:
    for (paramZzov1 = (zzov)localObject;; paramZzov1 = null)
    {
      if ((zzsw.zzvy != null) && (paramZzov1 != null)) {
        paramZzov1.zzP(zzsw.zzvy.zzAE);
      }
      zze(paramZzov2);
      return true;
      paramZzov1 = null;
      break;
      if ((zzsw.zzdn()) && (!((Boolean)zzfx.zzDQ.get()).booleanValue())) {
        break label128;
      }
      zza(paramZzov2, false);
      break label128;
    }
  }
  
  public boolean zzb(zzdy paramZzdy)
  {
    return super.zzb(zze(paramZzdy));
  }
  
  @Nullable
  public zzew zzbG()
  {
    zzac.zzdn("getVideoController must be called from the main thread.");
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzMZ != null)) {
      return zzsw.zzvk.zzMZ.zzlg();
    }
    return null;
  }
  
  protected boolean zzbM()
  {
    boolean bool = true;
    if (!zzv.zzcJ().zza(zzsw.zzqr.getPackageManager(), zzsw.zzqr.getPackageName(), "android.permission.INTERNET"))
    {
      zzeh.zzeO().zza(zzsw.zzvg, zzsw.zzvj, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!zzv.zzcJ().zzy(zzsw.zzqr))
    {
      zzeh.zzeO().zza(zzsw.zzvg, zzsw.zzvj, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (zzsw.zzvg != null)) {
      zzsw.zzvg.setVisibility(0);
    }
    return bool;
  }
  
  zzdy zze(zzdy paramZzdy)
  {
    if (zzyK == zzsS) {
      return paramZzdy;
    }
    int i = versionCode;
    long l = zzyF;
    Bundle localBundle = extras;
    int j = zzyG;
    List localList = zzyH;
    boolean bool2 = zzyI;
    int k = zzyJ;
    if ((zzyK) || (zzsS)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new zzdy(i, l, localBundle, j, localList, bool2, k, bool1, zzyL, zzyM, zzyN, zzyO, zzyP, zzyQ, zzyR, zzyS, zzyT, zzyU);
    }
  }
  
  void zzf(@Nullable zzov paramZzov)
  {
    if (paramZzov == null) {}
    while ((zzVq) || (zzsw.zzvg == null) || (!zzv.zzcJ().zza(zzsw.zzvg, zzsw.zzqr)) || (!zzsw.zzvg.getGlobalVisibleRect(new Rect(), null))) {
      return;
    }
    if ((paramZzov != null) && (zzMZ != null) && (zzMZ.zzkV() != null)) {
      zzMZ.zzkV().zza(null);
    }
    zza(paramZzov, false);
    zzVq = true;
  }
  
  public class zza
  {
    public zza() {}
    
    public void onClick()
    {
      onAdClicked();
    }
  }
}
