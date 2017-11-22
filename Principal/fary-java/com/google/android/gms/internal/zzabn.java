package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzabn<A extends Api.zzb, TResult>
{
  public zzabn() {}
  
  protected abstract void zza(A paramA, TaskCompletionSource<TResult> paramTaskCompletionSource)
    throws RemoteException;
}
