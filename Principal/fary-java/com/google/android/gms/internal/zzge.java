package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@zzmb
public class zzge
{
  private final Map<String, zzgd> zzFq;
  @Nullable
  private final zzgf zzsr;
  
  public zzge(@Nullable zzgf paramZzgf)
  {
    zzsr = paramZzgf;
    zzFq = new HashMap();
  }
  
  public void zza(String paramString, zzgd paramZzgd)
  {
    zzFq.put(paramString, paramZzgd);
  }
  
  public void zza(String paramString1, String paramString2, long paramLong)
  {
    zzgb.zza(zzsr, (zzgd)zzFq.get(paramString2), paramLong, new String[] { paramString1 });
    zzFq.put(paramString1, zzgb.zza(zzsr, paramLong));
  }
  
  @Nullable
  public zzgf zzfv()
  {
    return zzsr;
  }
}
