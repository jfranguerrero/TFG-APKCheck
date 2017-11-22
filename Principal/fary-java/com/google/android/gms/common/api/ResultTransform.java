package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.zzabh;

public abstract class ResultTransform<R extends Result, S extends Result>
{
  public ResultTransform() {}
  
  @NonNull
  public final PendingResult<S> createFailedResult(@NonNull Status paramStatus)
  {
    return new zzabh(paramStatus);
  }
  
  @NonNull
  public Status onFailure(@NonNull Status paramStatus)
  {
    return paramStatus;
  }
  
  @Nullable
  @WorkerThread
  public abstract PendingResult<S> onSuccess(@NonNull R paramR);
}
