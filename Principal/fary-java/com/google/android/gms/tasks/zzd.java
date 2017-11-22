package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult>
  implements zzf<TResult>
{
  private final Executor zzbDK;
  private OnFailureListener zzbLz;
  private final Object zzrN = new Object();
  
  public zzd(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener)
  {
    zzbDK = paramExecutor;
    zzbLz = paramOnFailureListener;
  }
  
  public void cancel()
  {
    synchronized (zzrN)
    {
      zzbLz = null;
      return;
    }
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    if (!paramTask.isSuccessful()) {
      synchronized (zzrN)
      {
        if (zzbLz == null) {
          return;
        }
        zzbDK.execute(new Runnable()
        {
          public void run()
          {
            synchronized (zzd.zza(zzd.this))
            {
              if (zzd.zzb(zzd.this) != null) {
                zzd.zzb(zzd.this).onFailure(paramTask.getException());
              }
              return;
            }
          }
        });
        return;
      }
    }
  }
}
