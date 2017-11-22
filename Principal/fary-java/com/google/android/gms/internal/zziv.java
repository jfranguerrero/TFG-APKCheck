package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zziv
  extends zzep.zza
{
  private final zzip zzIB;
  @Nullable
  private zzl zzIG;
  private final zzir zzIN;
  @Nullable
  private zzld zzIO;
  private String zzIP;
  private final String zztq;
  
  public zziv(Context paramContext, String paramString, zzjs paramZzjs, zzqa paramZzqa, com.google.android.gms.ads.internal.zzd paramZzd)
  {
    this(paramString, new zzip(paramContext, paramZzjs, paramZzqa, paramZzd));
  }
  
  zziv(String paramString, zzip paramZzip)
  {
    zztq = paramString;
    zzIB = paramZzip;
    zzIN = new zzir();
    zzv.zzcY().zza(paramZzip);
  }
  
  private void zzgr()
  {
    if ((zzIG != null) && (zzIO != null)) {
      zzIG.zza(zzIO, zzIP);
    }
  }
  
  static boolean zzq(zzdy paramZzdy)
  {
    paramZzdy = zzis.zzk(paramZzdy);
    return (paramZzdy != null) && (paramZzdy.containsKey("gw"));
  }
  
  static boolean zzr(zzdy paramZzdy)
  {
    paramZzdy = zzis.zzk(paramZzdy);
    return (paramZzdy != null) && (paramZzdy.containsKey("_ad"));
  }
  
  void abort()
  {
    if (zzIG != null) {
      return;
    }
    zzIG = zzIB.zzag(zztq);
    zzIN.zzc(zzIG);
    zzgr();
  }
  
  public void destroy()
    throws RemoteException
  {
    if (zzIG != null) {
      zzIG.destroy();
    }
  }
  
  @Nullable
  public String getMediationAdapterClassName()
    throws RemoteException
  {
    if (zzIG != null) {
      return zzIG.getMediationAdapterClassName();
    }
    return null;
  }
  
  public boolean isLoading()
    throws RemoteException
  {
    return (zzIG != null) && (zzIG.isLoading());
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return (zzIG != null) && (zzIG.isReady());
  }
  
  public void pause()
    throws RemoteException
  {
    if (zzIG != null) {
      zzIG.pause();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    if (zzIG != null) {
      zzIG.resume();
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    abort();
    if (zzIG != null) {
      zzIG.setManualImpressionsEnabled(paramBoolean);
    }
  }
  
  public void setUserId(String paramString) {}
  
  public void showInterstitial()
    throws RemoteException
  {
    if (zzIG != null)
    {
      zzIG.showInterstitial();
      return;
    }
    zzpe.zzbe("Interstitial ad must be loaded before showInterstitial().");
  }
  
  public void stopLoading()
    throws RemoteException
  {
    if (zzIG != null) {
      zzIG.stopLoading();
    }
  }
  
  public void zza(zzec paramZzec)
    throws RemoteException
  {
    if (zzIG != null) {
      zzIG.zza(paramZzec);
    }
  }
  
  public void zza(zzek paramZzek)
    throws RemoteException
  {
    zzIN.zzIw = paramZzek;
    if (zzIG != null) {
      zzIN.zzc(zzIG);
    }
  }
  
  public void zza(zzel paramZzel)
    throws RemoteException
  {
    zzIN.zzti = paramZzel;
    if (zzIG != null) {
      zzIN.zzc(zzIG);
    }
  }
  
  public void zza(zzer paramZzer)
    throws RemoteException
  {
    zzIN.zzIt = paramZzer;
    if (zzIG != null) {
      zzIN.zzc(zzIG);
    }
  }
  
  public void zza(zzet paramZzet)
    throws RemoteException
  {
    abort();
    if (zzIG != null) {
      zzIG.zza(paramZzet);
    }
  }
  
  public void zza(zzfn paramZzfn)
  {
    throw new IllegalStateException("getVideoController not implemented for interstitials");
  }
  
  public void zza(zzgj paramZzgj)
    throws RemoteException
  {
    zzIN.zzIv = paramZzgj;
    if (zzIG != null) {
      zzIN.zzc(zzIG);
    }
  }
  
  public void zza(zzkz paramZzkz)
    throws RemoteException
  {
    zzIN.zzIu = paramZzkz;
    if (zzIG != null) {
      zzIN.zzc(zzIG);
    }
  }
  
  public void zza(zzld paramZzld, String paramString)
    throws RemoteException
  {
    zzIO = paramZzld;
    zzIP = paramString;
    zzgr();
  }
  
  public void zza(zznt paramZznt)
  {
    zzIN.zzIx = paramZznt;
    if (zzIG != null) {
      zzIN.zzc(zzIG);
    }
  }
  
  public boolean zzb(zzdy paramZzdy)
    throws RemoteException
  {
    if (((Boolean)zzfx.zzCy.get()).booleanValue()) {
      zzdy.zzj(paramZzdy);
    }
    if (!zzq(paramZzdy)) {
      abort();
    }
    if (zzis.zzm(paramZzdy)) {
      abort();
    }
    if (zzyM != null) {
      abort();
    }
    if (zzIG != null) {
      return zzIG.zzb(paramZzdy);
    }
    Object localObject = zzv.zzcY();
    if (zzr(paramZzdy)) {
      ((zzis)localObject).zzb(paramZzdy, zztq);
    }
    localObject = ((zzis)localObject).zza(paramZzdy, zztq);
    if (localObject != null)
    {
      if (!zzIK) {
        ((zziu.zza)localObject).zzgq();
      }
      zzIG = zzIG;
      zzII.zza(zzIN);
      zzIN.zzc(zzIG);
      zzgr();
      return zzIL;
    }
    abort();
    return zzIG.zzb(paramZzdy);
  }
  
  @Nullable
  public com.google.android.gms.dynamic.zzd zzbC()
    throws RemoteException
  {
    if (zzIG != null) {
      return zzIG.zzbC();
    }
    return null;
  }
  
  @Nullable
  public zzec zzbD()
    throws RemoteException
  {
    if (zzIG != null) {
      return zzIG.zzbD();
    }
    return null;
  }
  
  public void zzbF()
    throws RemoteException
  {
    if (zzIG != null)
    {
      zzIG.zzbF();
      return;
    }
    zzpe.zzbe("Interstitial ad must be loaded before pingManualTrackingUrl().");
  }
  
  public zzew zzbG()
  {
    throw new IllegalStateException("getVideoController not implemented for interstitials");
  }
}
