package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;

@zzmb
public class zzk
{
  private final String zzAd;
  
  public zzk(String paramString)
  {
    zzAd = paramString;
  }
  
  public boolean zza(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str;
    do
    {
      return false;
      str = zzv.zzcX().zze(paramIntent);
      paramIntent = zzv.zzcX().zzf(paramIntent);
    } while ((str == null) || (paramIntent == null));
    if (!paramString.equals(zzv.zzcX().zzaD(str)))
    {
      zzpe.zzbe("Developer payload not match.");
      return false;
    }
    if ((zzAd != null) && (!zzl.zzc(zzAd, str, paramIntent)))
    {
      zzpe.zzbe("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String zzis()
  {
    return zzv.zzcJ().zzkl();
  }
}
