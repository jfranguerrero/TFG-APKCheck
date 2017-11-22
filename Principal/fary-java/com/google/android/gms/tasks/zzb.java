package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult>
  implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult>
{
  private final Executor zzbDK;
  private final Continuation<TResult, Task<TContinuationResult>> zzbLs;
  private final zzh<TContinuationResult> zzbLt;
  
  public zzb(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation, @NonNull zzh<TContinuationResult> paramZzh)
  {
    zzbDK = paramExecutor;
    zzbLs = paramContinuation;
    zzbLt = paramZzh;
  }
  
  public void cancel()
  {
    throw new UnsupportedOperationException();
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    zzbDK.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Task localTask = (Task)zzb.zza(zzb.this).then(paramTask);
          if (localTask == null)
          {
            onFailure(new NullPointerException("Continuation returned null"));
            return;
          }
        }
        catch (RuntimeExecutionException localRuntimeExecutionException)
        {
          if ((localRuntimeExecutionException.getCause() instanceof Exception))
          {
            zzb.zzb(zzb.this).setException((Exception)localRuntimeExecutionException.getCause());
            return;
          }
          zzb.zzb(zzb.this).setException(localRuntimeExecutionException);
          return;
        }
        catch (Exception localException)
        {
          zzb.zzb(zzb.this).setException(localException);
          return;
        }
        localException.addOnSuccessListener(TaskExecutors.zzbLG, zzb.this);
        localException.addOnFailureListener(TaskExecutors.zzbLG, zzb.this);
      }
    });
  }
  
  public void onFailure(@NonNull Exception paramException)
  {
    zzbLt.setException(paramException);
  }
  
  public void onSuccess(TContinuationResult paramTContinuationResult)
  {
    zzbLt.setResult(paramTContinuationResult);
  }
}
