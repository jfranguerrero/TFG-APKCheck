package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Queue;

public class zzaak
  implements zzaam
{
  private final zzaan zzazK;
  
  public zzaak(zzaan paramZzaan)
  {
    zzazK = paramZzaan;
  }
  
  public void begin()
  {
    zzazK.zzvQ();
    zzazK.zzazd.zzaAs = Collections.emptySet();
  }
  
  public void connect()
  {
    zzazK.zzvO();
  }
  
  public boolean disconnect()
  {
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt) {}
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(T paramT)
  {
    zzazK.zzazd.zzaAl.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}
