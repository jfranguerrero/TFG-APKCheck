package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzqr
{
  public zzqr() {}
  
  public zzqp zza(Context paramContext, zzec paramZzec, boolean paramBoolean1, boolean paramBoolean2, @Nullable zzav paramZzav, zzqa paramZzqa)
  {
    return zza(paramContext, paramZzec, paramBoolean1, paramBoolean2, paramZzav, paramZzqa, null, null, null);
  }
  
  public zzqp zza(Context paramContext, zzec paramZzec, boolean paramBoolean1, boolean paramBoolean2, @Nullable zzav paramZzav, zzqa paramZzqa, zzgf paramZzgf, zzt paramZzt, zzd paramZzd)
  {
    paramContext = new zzqs(zzqt.zzb(paramContext, paramZzec, paramBoolean1, paramBoolean2, paramZzav, paramZzqa, paramZzgf, paramZzt, paramZzd));
    paramContext.setWebViewClient(zzv.zzcL().zzb(paramContext, paramBoolean2));
    paramContext.setWebChromeClient(zzv.zzcL().zzn(paramContext));
    return paramContext;
  }
}
