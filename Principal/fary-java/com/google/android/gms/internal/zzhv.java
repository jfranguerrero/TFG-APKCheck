package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import java.util.Map;

@zzmb
public final class zzhv
  implements zzhx
{
  public zzhv() {}
  
  private void zzc(zzqp paramZzqp, Map<String, String> paramMap)
  {
    String str2 = (String)paramMap.get("label");
    String str1 = (String)paramMap.get("start_label");
    paramMap = (String)paramMap.get("timestamp");
    if (TextUtils.isEmpty(str2))
    {
      zzpe.zzbe("No label given for CSI tick.");
      return;
    }
    if (TextUtils.isEmpty(paramMap))
    {
      zzpe.zzbe("No timestamp given for CSI tick.");
      return;
    }
    try
    {
      long l = zzd(Long.parseLong(paramMap));
      paramMap = str1;
      if (TextUtils.isEmpty(str1)) {
        paramMap = "native:view_load";
      }
      paramZzqp.zzlf().zza(str2, paramMap, l);
      return;
    }
    catch (NumberFormatException paramZzqp)
    {
      zzpe.zzc("Malformed timestamp for CSI tick.", paramZzqp);
    }
  }
  
  private long zzd(long paramLong)
  {
    return paramLong - zzv.zzcP().currentTimeMillis() + zzv.zzcP().elapsedRealtime();
  }
  
  private void zzd(zzqp paramZzqp, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzpe.zzbe("No value given for CSI experiment.");
      return;
    }
    paramZzqp = paramZzqp.zzlf().zzfv();
    if (paramZzqp == null)
    {
      zzpe.zzbe("No ticker for WebView, dropping experiment ID.");
      return;
    }
    paramZzqp.zzg("e", paramMap);
  }
  
  private void zze(zzqp paramZzqp, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzpe.zzbe("No value given for CSI extra.");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      zzpe.zzbe("No name given for CSI extra.");
      return;
    }
    paramZzqp = paramZzqp.zzlf().zzfv();
    if (paramZzqp == null)
    {
      zzpe.zzbe("No ticker for WebView, dropping extra parameter.");
      return;
    }
    paramZzqp.zzg(str, paramMap);
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if ("tick".equals(str)) {
      zzc(paramZzqp, paramMap);
    }
    do
    {
      return;
      if ("experiment".equals(str))
      {
        zzd(paramZzqp, paramMap);
        return;
      }
    } while (!"extra".equals(str));
    zze(paramZzqp, paramMap);
  }
}
