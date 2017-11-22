package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzc;

public class zzaaq<O extends Api.ApiOptions>
  extends zzaah
{
  private final zzc<O> zzaBl;
  
  public zzaaq(zzc<O> paramZzc)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    zzaBl = paramZzc;
  }
  
  public Looper getLooper()
  {
    return zzaBl.getLooper();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(@NonNull T paramT)
  {
    return zzaBl.doRead(paramT);
  }
  
  public void zza(zzabp paramZzabp) {}
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    return zzaBl.doWrite(paramT);
  }
  
  public void zzb(zzabp paramZzabp) {}
}
