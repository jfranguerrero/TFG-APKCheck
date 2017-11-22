package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzmb
public class zzig
  implements zzhx
{
  private final zza zzHS;
  
  public zzig(zza paramZza)
  {
    zzHS = paramZza;
  }
  
  public static void zza(zzqp paramZzqp, zza paramZza)
  {
    paramZzqp.zzkV().zza("/reward", new zzig(paramZza));
  }
  
  private void zzf(Map<String, String> paramMap)
  {
    try
    {
      int i = Integer.parseInt((String)paramMap.get("amount"));
      paramMap = (String)paramMap.get("type");
      if (!TextUtils.isEmpty(paramMap))
      {
        paramMap = new zzok(paramMap, i);
        zzHS.zzb(paramMap);
        return;
      }
    }
    catch (NumberFormatException paramMap)
    {
      for (;;)
      {
        zzpe.zzc("Unable to parse reward amount.", paramMap);
        paramMap = null;
      }
    }
  }
  
  private void zzg(Map<String, String> paramMap)
  {
    zzHS.zzcl();
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    paramZzqp = (String)paramMap.get("action");
    if ("grant".equals(paramZzqp)) {
      zzf(paramMap);
    }
    while (!"video_start".equals(paramZzqp)) {
      return;
    }
    zzg(paramMap);
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(zzok paramZzok);
    
    public abstract void zzcl();
  }
}
