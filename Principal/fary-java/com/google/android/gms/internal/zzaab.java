package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzg;

public final class zzaab<O extends Api.ApiOptions>
  extends zzc<O>
{
  private final Api.zza<? extends zzaxn, zzaxo> zzaxY;
  private final Api.zze zzazq;
  private final zzzy zzazr;
  private final zzg zzazs;
  
  public zzaab(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper, @NonNull Api.zze paramZze, @NonNull zzzy paramZzzy, zzg paramZzg, Api.zza<? extends zzaxn, zzaxo> paramZza)
  {
    super(paramContext, paramApi, paramLooper);
    zzazq = paramZze;
    zzazr = paramZzzy;
    zzazs = paramZzg;
    zzaxY = paramZza;
    zzaxK.zza(this);
  }
  
  public Api.zze buildApiClient(Looper paramLooper, zzaap.zza<O> paramZza)
  {
    zzazr.zza(paramZza);
    return zzazq;
  }
  
  public zzabj createSignInCoordinator(Context paramContext, Handler paramHandler)
  {
    return new zzabj(paramContext, paramHandler, zzazs, zzaxY);
  }
  
  public Api.zze zzvr()
  {
    return zzazq;
  }
}
