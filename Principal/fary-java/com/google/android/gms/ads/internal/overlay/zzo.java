package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzqp;

@zzmb
public class zzo
  extends zzk
{
  public zzo() {}
  
  @Nullable
  public zzj zza(Context paramContext, zzqp paramZzqp, int paramInt, boolean paramBoolean, zzgf paramZzgf)
  {
    if (!zzp(paramContext)) {
      return null;
    }
    return new zzd(paramContext, paramBoolean, zzh(paramZzqp), new zzz(paramContext, paramZzqp.zzkY(), paramZzqp.getRequestId(), paramZzgf, paramZzqp.zzle()));
  }
}
