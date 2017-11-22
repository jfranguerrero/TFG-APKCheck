package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
public class zzkk
{
  private final zzqp zzGt;
  private final boolean zzLE;
  private final String zzLF;
  
  public zzkk(zzqp paramZzqp, Map<String, String> paramMap)
  {
    zzGt = paramZzqp;
    zzLF = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      zzLE = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    zzLE = true;
  }
  
  public void execute()
  {
    if (zzGt == null)
    {
      zzpe.zzbe("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(zzLF)) {
      i = zzv.zzcL().zzkq();
    }
    for (;;)
    {
      zzGt.setRequestedOrientation(i);
      return;
      if ("landscape".equalsIgnoreCase(zzLF)) {
        i = zzv.zzcL().zzkp();
      } else if (zzLE) {
        i = -1;
      } else {
        i = zzv.zzcL().zzkr();
      }
    }
  }
}
