package com.google.android.gms.internal;

import java.util.Map;

@zzmb
public class zzia
  implements zzhx
{
  private final zzib zzHL;
  
  public zzia(zzib paramZzib)
  {
    zzHL = paramZzib;
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") != null)
      {
        f = Float.parseFloat((String)paramMap.get("blurRadius"));
        zzHL.zzg(bool1);
        zzHL.zza(bool2, f);
        return;
      }
    }
    catch (NumberFormatException paramZzqp)
    {
      for (;;)
      {
        zzpe.zzb("Fail to parse float", paramZzqp);
        float f = 0.0F;
      }
    }
  }
}
