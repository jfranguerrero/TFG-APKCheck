package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzi;

@zzmb
public final class zzme
{
  public static zzpk zza(Context paramContext, zzqa paramZzqa, zzqi<zzmh> paramZzqi, zza paramZza)
  {
    zza(paramContext, paramZzqa, paramZzqi, paramZza, new zzb()
    {
      public boolean zza(zzqa paramAnonymousZzqa)
      {
        return (zzYd) || ((zzi.zzaK(zzme.this)) && (!((Boolean)zzfx.zzBF.get()).booleanValue()));
      }
    });
  }
  
  static zzpk zza(Context paramContext, zzqa paramZzqa, zzqi<zzmh> paramZzqi, zza paramZza, zzb paramZzb)
  {
    if (paramZzb.zza(paramZzqa)) {
      return zza(paramContext, paramZzqi, paramZza);
    }
    return zzb(paramContext, paramZzqa, paramZzqi, paramZza);
  }
  
  private static zzpk zza(Context paramContext, zzqi<zzmh> paramZzqi, zza paramZza)
  {
    zzpe.zzbc("Fetching ad response from local ad request service.");
    paramContext = new zzmf.zza(paramContext, paramZzqi, paramZza);
    paramContext.zziw();
    return paramContext;
  }
  
  private static zzpk zzb(Context paramContext, zzqa paramZzqa, zzqi<zzmh> paramZzqi, zza paramZza)
  {
    zzpe.zzbc("Fetching ad response from remote ad request service.");
    if (!zzeh.zzeO().zzP(paramContext))
    {
      zzpe.zzbe("Failed to connect to remote ad request service.");
      return null;
    }
    return new zzmf.zzb(paramContext, paramZzqa, paramZzqi, paramZza);
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(zzmk paramZzmk);
  }
  
  static abstract interface zzb
  {
    public abstract boolean zza(zzqa paramZzqa);
  }
}
