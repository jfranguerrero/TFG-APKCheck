package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzgu.zza;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqu;
import java.util.List;

@zzmb
public class zzr
  extends zzb
{
  private zzqp zzua;
  
  public zzr(Context paramContext, zzd paramZzd, zzec paramZzec, String paramString, zzjs paramZzjs, zzqa paramZzqa)
  {
    super(paramContext, paramZzec, paramString, paramZzjs, paramZzqa, paramZzd);
  }
  
  private static zzgp zza(zzjw paramZzjw)
    throws RemoteException
  {
    String str1 = paramZzjw.getHeadline();
    List localList = paramZzjw.getImages();
    String str2 = paramZzjw.getBody();
    if (paramZzjw.zzfL() != null) {}
    for (zzgz localZzgz = paramZzjw.zzfL();; localZzgz = null) {
      return new zzgp(str1, localList, str2, localZzgz, paramZzjw.getCallToAction(), paramZzjw.getStarRating(), paramZzjw.getStore(), paramZzjw.getPrice(), null, paramZzjw.getExtras(), paramZzjw.zzbG(), null);
    }
  }
  
  private static zzgq zza(zzjx paramZzjx)
    throws RemoteException
  {
    String str1 = paramZzjx.getHeadline();
    List localList = paramZzjx.getImages();
    String str2 = paramZzjx.getBody();
    if (paramZzjx.zzfQ() != null) {}
    for (zzgz localZzgz = paramZzjx.zzfQ();; localZzgz = null) {
      return new zzgq(str1, localList, str2, localZzgz, paramZzjx.getCallToAction(), paramZzjx.getAdvertiser(), null, paramZzjx.getExtras());
    }
  }
  
  private void zza(final zzgp paramZzgp)
  {
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzsw.zzvt != null) {
            zzsw.zzvt.zza(paramZzgp);
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzpe.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zzgq paramZzgq)
  {
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzsw.zzvu != null) {
            zzsw.zzvu.zza(paramZzgq);
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzpe.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zzov paramZzov, final String paramString)
  {
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        try
        {
          ((zzhm)zzsw.zzvw.get(paramString)).zza((zzgr)paramZzovzzVx);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzpe.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  public void pause()
  {
    throw new IllegalStateException("Native Ad DOES NOT support pause().");
  }
  
  public void resume()
  {
    throw new IllegalStateException("Native Ad DOES NOT support resume().");
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
  }
  
  public void zza(SimpleArrayMap<String, zzhm> paramSimpleArrayMap)
  {
    zzac.zzdn("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    zzsw.zzvw = paramSimpleArrayMap;
  }
  
  public void zza(zzgj paramZzgj)
  {
    throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
  }
  
  public void zza(zzgs paramZzgs)
  {
    if (zzua != null) {
      zzua.zzb(paramZzgs);
    }
  }
  
  public void zza(zzgu paramZzgu)
  {
    if (zzsw.zzvk.zzVp != null) {
      zzv.zzcN().zzjZ().zza(zzsw.zzvj, zzsw.zzvk, paramZzgu);
    }
  }
  
  public void zza(zzkz paramZzkz)
  {
    throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
  }
  
  public void zza(final zzov.zza paramZza, zzgf paramZzgf)
  {
    if (zzvj != null) {
      zzsw.zzvj = zzvj;
    }
    if (errorCode != -2)
    {
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          zzb(new zzov(paramZza, null, null, null, null, null, null, null));
        }
      });
      return;
    }
    zzsw.zzvF = 0;
    zzsw.zzvi = zzv.zzcI().zza(zzsw.zzqr, this, paramZza, zzsw.zzve, null, zzsD, this, paramZzgf);
    paramZza = String.valueOf(zzsw.zzvi.getClass().getName());
    if (paramZza.length() != 0) {}
    for (paramZza = "AdRenderer: ".concat(paramZza);; paramZza = new String("AdRenderer: "))
    {
      zzpe.zzbc(paramZza);
      return;
    }
  }
  
  protected boolean zza(zzdy paramZzdy, zzov paramZzov, boolean paramBoolean)
  {
    return zzsv.zzcv();
  }
  
  protected boolean zza(zzov paramZzov1, zzov paramZzov2)
  {
    zzb(null);
    if (!zzsw.zzdm()) {
      throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }
    if (zzRK) {}
    for (;;)
    {
      try
      {
        if (zzKB == null) {
          continue;
        }
        localObject1 = zzKB.zzgJ();
        if (zzKB == null) {
          continue;
        }
        localObject2 = zzKB.zzgK();
        if ((localObject1 == null) || (zzsw.zzvt == null)) {
          continue;
        }
        localObject2 = zza((zzjw)localObject1);
        ((zzgp)localObject2).zzb(new zzgt(zzsw.zzqr, this, zzsw.zzve, (zzjw)localObject1, (zzgu.zza)localObject2));
        zza((zzgp)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject1;
        Object localObject2;
        zzpe.zzc("Failed to get native ad mapper", localRemoteException);
        continue;
        zzpe.zzbe("No matching mapper/listener for retrieved native ad template.");
        zzh(0);
        return false;
      }
      return super.zza(paramZzov1, paramZzov2);
      localObject1 = null;
      continue;
      localObject2 = null;
      continue;
      if ((localObject2 != null) && (zzsw.zzvu != null))
      {
        localObject1 = zza((zzjx)localObject2);
        ((zzgq)localObject1).zzb(new zzgt(zzsw.zzqr, this, zzsw.zzve, (zzjx)localObject2, (zzgu.zza)localObject1));
        zza((zzgq)localObject1);
      }
      else
      {
        zzgu.zza localZza = zzVx;
        if (((localZza instanceof zzgq)) && (zzsw.zzvu != null))
        {
          zza((zzgq)zzVx);
        }
        else if (((localZza instanceof zzgp)) && (zzsw.zzvt != null))
        {
          zza((zzgp)zzVx);
        }
        else
        {
          if ((!(localZza instanceof zzgr)) || (zzsw.zzvw == null) || (zzsw.zzvw.get(((zzgr)localZza).getCustomTemplateId()) == null)) {
            break;
          }
          zza(paramZzov2, ((zzgr)localZza).getCustomTemplateId());
        }
      }
    }
    zzpe.zzbe("No matching listener for retrieved native ad template.");
    zzh(0);
    return false;
  }
  
  public void zzb(SimpleArrayMap<String, zzhl> paramSimpleArrayMap)
  {
    zzac.zzdn("setOnCustomClickListener must be called on the main UI thread.");
    zzsw.zzvv = paramSimpleArrayMap;
  }
  
  public void zzb(zzgw paramZzgw)
  {
    zzac.zzdn("setNativeAdOptions must be called on the main UI thread.");
    zzsw.zzvx = paramZzgw;
  }
  
  public void zzb(zzhj paramZzhj)
  {
    zzac.zzdn("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
    zzsw.zzvt = paramZzhj;
  }
  
  public void zzb(zzhk paramZzhk)
  {
    zzac.zzdn("setOnContentAdLoadedListener must be called on the main UI thread.");
    zzsw.zzvu = paramZzhk;
  }
  
  public void zzb(@Nullable List<String> paramList)
  {
    zzac.zzdn("setNativeTemplates must be called on the main UI thread.");
    zzsw.zzvB = paramList;
  }
  
  public void zzc(zzqp paramZzqp)
  {
    zzua = paramZzqp;
  }
  
  public void zzcr()
  {
    if ((zzsw.zzvk != null) && (zzua != null))
    {
      zzv.zzcN().zzjZ().zza(zzsw.zzvj, zzsw.zzvk, zzua.getView(), zzua);
      return;
    }
    zzpe.zzbe("Request to enable ActiveView before adState is available.");
  }
  
  public SimpleArrayMap<String, zzhm> zzcs()
  {
    zzac.zzdn("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    return zzsw.zzvw;
  }
  
  public void zzct()
  {
    if (zzua != null)
    {
      zzua.destroy();
      zzua = null;
    }
  }
  
  public void zzcu()
  {
    if ((zzua != null) && (zzua.zzlg() != null) && (zzsw.zzvx != null) && (zzsw.zzvx.zzGH != null)) {
      zzua.zzlg().zzP(zzsw.zzvx.zzGH.zzAE);
    }
  }
  
  @Nullable
  public zzhl zzz(String paramString)
  {
    zzac.zzdn("getOnCustomClickListener must be called on the main UI thread.");
    return (zzhl)zzsw.zzvv.get(paramString);
  }
}
