package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;

public final class zzzu
{
  private final ArrayMap<zzzs<?>, ConnectionResult> zzaxy = new ArrayMap();
  private final TaskCompletionSource<Void> zzayC = new TaskCompletionSource();
  private int zzayD;
  private boolean zzayE = false;
  
  public zzzu(Iterable<zzc<? extends Api.ApiOptions>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      zzc localZzc = (zzc)paramIterable.next();
      zzaxy.put(localZzc.getApiKey(), null);
    }
    zzayD = zzaxy.keySet().size();
  }
  
  public Task<Void> getTask()
  {
    return zzayC.getTask();
  }
  
  public void zza(zzzs<?> paramZzzs, ConnectionResult paramConnectionResult)
  {
    zzaxy.put(paramZzzs, paramConnectionResult);
    zzayD -= 1;
    if (!paramConnectionResult.isSuccess()) {
      zzayE = true;
    }
    if (zzayD == 0)
    {
      if (zzayE)
      {
        paramZzzs = new zzb(zzaxy);
        zzayC.setException(paramZzzs);
      }
    }
    else {
      return;
    }
    zzayC.setResult(null);
  }
  
  public Set<zzzs<?>> zzuY()
  {
    return zzaxy.keySet();
  }
  
  public void zzuZ()
  {
    zzayC.setResult(null);
  }
}
