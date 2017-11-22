package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.zzs;

@zzmb
public class zzln
{
  public zzln() {}
  
  public zzpk zza(Context paramContext, zza paramZza, zzov.zza paramZza1, zzav paramZzav, @Nullable zzqp paramZzqp, zzjs paramZzjs, zza paramZza2, zzgf paramZzgf)
  {
    zzmk localZzmk = zzVB;
    if (zzRK)
    {
      paramContext = new zzlr(paramContext, paramZza1, paramZzjs, paramZza2, paramZzgf, paramZzqp);
      paramZza = String.valueOf(paramContext.getClass().getName());
      if (paramZza.length() == 0) {
        break label256;
      }
    }
    label256:
    for (paramZza = "AdRenderer: ".concat(paramZza);; paramZza = new String("AdRenderer: "))
    {
      zzpe.zzbc(paramZza);
      paramContext.zziw();
      return paramContext;
      if ((zzzn) || ((paramZza instanceof zzr)))
      {
        if ((zzzn) && ((paramZza instanceof zzr)))
        {
          paramContext = new zzls(paramContext, (zzr)paramZza, paramZza1, paramZzav, paramZza2, paramZzgf);
          break;
        }
        paramContext = new zzlp(paramZza1, paramZza2);
        break;
      }
      if ((((Boolean)zzfx.zzBN.get()).booleanValue()) && (zzRQ))
      {
        paramContext = new zzll(paramContext, paramZza1, paramZzqp, paramZza2);
        break;
      }
      if ((((Boolean)zzfx.zzCg.get()).booleanValue()) && (zzs.zzyF()) && (!zzs.zzyH()) && (paramZzqp != null) && (zzbDzzzl))
      {
        paramContext = new zzlq(paramContext, paramZza1, paramZzqp, paramZza2);
        break;
      }
      paramContext = new zzlo(paramContext, paramZza1, paramZzqp, paramZza2);
      break;
    }
  }
  
  public zzpk zza(Context paramContext, zzov.zza paramZza, zznp paramZznp)
  {
    paramZza = new zzog(paramContext, paramZza, paramZznp);
    paramContext = String.valueOf(paramZza.getClass().getName());
    if (paramContext.length() != 0) {}
    for (paramContext = "AdRenderer: ".concat(paramContext);; paramContext = new String("AdRenderer: "))
    {
      zzpe.zzbc(paramContext);
      paramZza.zziw();
      return paramZza;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(zzov paramZzov);
  }
}
