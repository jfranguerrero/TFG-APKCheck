package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzc;
import java.util.Map;

@zzmb
public class zzim
  implements zzhx
{
  public zzim() {}
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    zzik localZzik = zzv.zzdg();
    if (paramMap.containsKey("abort"))
    {
      if (!localZzik.zze(paramZzqp)) {
        zzpe.zzbe("Precache abort but no preload task running.");
      }
      return;
    }
    String str = (String)paramMap.get("src");
    if (str == null)
    {
      zzpe.zzbe("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      i = Integer.parseInt((String)paramMap.get("player"));
      if (paramMap.containsKey("mimetype"))
      {
        paramMap = (String)paramMap.get("mimetype");
        if (!localZzik.zzf(paramZzqp)) {
          break label121;
        }
        zzpe.zzbe("Precache task already running.");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      for (;;)
      {
        i = 0;
        continue;
        paramMap = "";
      }
      label121:
      zzc.zzt(paramZzqp.zzbz());
      new zzij(paramZzqp, zzbzzzsM.zza(paramZzqp, i, paramMap), str).zziw();
    }
  }
}
