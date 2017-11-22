package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.common.util.zzf;
import java.util.Map;

@zzmb
public class zzid
  implements zzhx
{
  static final Map<String, Integer> zzHP = zzf.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
  private final zze zzHN;
  private final zzkj zzHO;
  
  public zzid(zze paramZze, zzkj paramZzkj)
  {
    zzHN = paramZze;
    zzHO = paramZzkj;
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    int i = ((Integer)zzHP.get(str)).intValue();
    if ((i != 5) && (zzHN != null) && (!zzHN.zzcb()))
    {
      zzHN.zzx(null);
      return;
    }
    switch (i)
    {
    case 2: 
    default: 
      zzpe.zzbd("Unknown MRAID command called.");
      return;
    case 1: 
      zzHO.execute(paramMap);
      return;
    case 4: 
      new zzki(paramZzqp, paramMap).execute();
      return;
    case 3: 
      new zzkl(paramZzqp, paramMap).execute();
      return;
    case 5: 
      new zzkk(paramZzqp, paramMap).execute();
      return;
    }
    zzHO.zzs(true);
  }
}
