package com.google.android.gms.internal;

import java.util.Map;

@zzmb
public final class zzhs
  implements zzhx
{
  private final zzht zzHc;
  
  public zzhs(zzht paramZzht)
  {
    zzHc = paramZzht;
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    paramZzqp = (String)paramMap.get("name");
    if (paramZzqp == null)
    {
      zzpe.zzbe("App event with no name parameter.");
      return;
    }
    zzHc.onAppEvent(paramZzqp, (String)paramMap.get("info"));
  }
}
