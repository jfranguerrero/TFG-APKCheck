package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzmb
public final class zzcj
  extends zzcl.zza
{
  private final zzau zzrS;
  private final zzav zzrT;
  private final zzas zzrU;
  private boolean zzrV = false;
  
  public zzcj(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzrS = zzau.zza(paramString, paramContext, paramBoolean);
    zzrT = new zzav(zzrS);
    if (paramBoolean) {}
    for (paramString = null;; paramString = zzas.zzc(paramContext))
    {
      zzrU = paramString;
      return;
    }
  }
  
  private zzd zza(zzd paramZzd1, zzd paramZzd2, boolean paramBoolean)
  {
    try
    {
      paramZzd1 = (Uri)zze.zzE(paramZzd1);
      paramZzd2 = (Context)zze.zzE(paramZzd2);
      if (paramBoolean) {}
      for (paramZzd1 = zzrT.zza(paramZzd1, paramZzd2);; paramZzd1 = zzrT.zzb(paramZzd1, paramZzd2)) {
        return zze.zzA(paramZzd1);
      }
      return null;
    }
    catch (zzaw paramZzd1) {}
  }
  
  public zzd zza(zzd paramZzd1, zzd paramZzd2)
  {
    return zza(paramZzd1, paramZzd2, true);
  }
  
  public String zza(zzd paramZzd, String paramString)
  {
    paramZzd = (Context)zze.zzE(paramZzd);
    return zzrS.zzb(paramZzd, paramString);
  }
  
  public String zza(zzd paramZzd, byte[] paramArrayOfByte)
  {
    Context localContext = (Context)zze.zzE(paramZzd);
    paramZzd = zzrS.zza(localContext, paramArrayOfByte);
    if ((zzrU != null) && (zzrV))
    {
      paramArrayOfByte = zzrU.zza(localContext, paramArrayOfByte);
      paramZzd = zzrU.zza(paramZzd, paramArrayOfByte);
      zzrV = false;
      return paramZzd;
    }
    return paramZzd;
  }
  
  public boolean zza(zzd paramZzd)
  {
    paramZzd = (Uri)zze.zzE(paramZzd);
    return zzrT.zza(paramZzd);
  }
  
  public zzd zzb(zzd paramZzd1, zzd paramZzd2)
  {
    return zza(paramZzd1, paramZzd2, false);
  }
  
  public void zzb(String paramString1, String paramString2)
  {
    zzrT.zzb(paramString1, paramString2);
  }
  
  public boolean zzb(zzd paramZzd)
  {
    paramZzd = (Uri)zze.zzE(paramZzd);
    return zzrT.zzc(paramZzd);
  }
  
  public boolean zzb(String paramString, boolean paramBoolean)
  {
    if (zzrU == null) {
      return false;
    }
    paramString = new AdvertisingIdClient.Info(paramString, paramBoolean);
    zzrU.zza(paramString);
    zzrV = true;
    return true;
  }
  
  public String zzbu()
  {
    return "ms";
  }
  
  public String zzc(zzd paramZzd)
  {
    return zza(paramZzd, null);
  }
  
  public void zzd(zzd paramZzd)
  {
    paramZzd = (MotionEvent)zze.zzE(paramZzd);
    zzrT.zza(paramZzd);
  }
  
  public void zzm(String paramString)
  {
    zzrT.zzm(paramString);
  }
}
