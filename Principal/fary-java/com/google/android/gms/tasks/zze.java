package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult>
  implements zzf<TResult>
{
  private final Executor zzbDK;
  private OnSuccessListener<? super TResult> zzbLB;
  private final Object zzrN = new Object();
  
  public zze(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    zzbDK = paramExecutor;
    zzbLB = paramOnSuccessListener;
  }
  
  public void cancel()
  {
    synchronized (zzrN)
    {
      zzbLB = null;
      return;
    }
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful()) {
      synchronized (zzrN)
      {
        if (zzbLB == null) {
          return;
        }
        zzbDK.execute(new Runnable()
        {
          public void run()
          {
            synchronized (zze.zza(zze.this))
            {
              if (zze.zzb(zze.this) != null) {
                zze.zzb(zze.this).onSuccess(paramTask.getResult());
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
