package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzaa;

public final class zzzs<O extends Api.ApiOptions>
{
  private final Api<O> zzawb;
  private final O zzaxG;
  private final boolean zzayv;
  private final int zzayw;
  
  private zzzs(Api<O> paramApi)
  {
    zzayv = true;
    zzawb = paramApi;
    zzaxG = null;
    zzayw = System.identityHashCode(this);
  }
  
  private zzzs(Api<O> paramApi, O paramO)
  {
    zzayv = false;
    zzawb = paramApi;
    zzaxG = paramO;
    zzayw = zzaa.hashCode(new Object[] { zzawb, zzaxG });
  }
  
  public static <O extends Api.ApiOptions> zzzs<O> zza(Api<O> paramApi, O paramO)
  {
    return new zzzs(paramApi, paramO);
  }
  
  public static <O extends Api.ApiOptions> zzzs<O> zzb(Api<O> paramApi)
  {
    return new zzzs(paramApi);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzzs)) {
        return false;
      }
      paramObject = (zzzs)paramObject;
    } while ((!zzayv) && (!zzayv) && (zzaa.equal(zzawb, zzawb)) && (zzaa.equal(zzaxG, zzaxG)));
    return false;
  }
  
  public int hashCode()
  {
    return zzayw;
  }
  
  public String zzuV()
  {
    return zzawb.getName();
  }
}
