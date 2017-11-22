package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult>
{
  private Queue<zzf<TResult>> zzbLD;
  private boolean zzbLE;
  private final Object zzrN = new Object();
  
  zzg() {}
  
  public void zza(@NonNull Task<TResult> paramTask)
  {
    for (;;)
    {
      zzf localZzf;
      synchronized (zzrN)
      {
        if ((zzbLD == null) || (zzbLE)) {
          return;
        }
        zzbLE = true;
        synchronized (zzrN)
        {
          localZzf = (zzf)zzbLD.poll();
          if (localZzf == null)
          {
            zzbLE = false;
            return;
          }
        }
      }
      localZzf.onComplete(paramTask);
    }
  }
  
  public void zza(@NonNull zzf<TResult> paramZzf)
  {
    synchronized (zzrN)
    {
      if (zzbLD == null) {
        zzbLD = new ArrayDeque();
      }
      zzbLD.add(paramZzf);
      return;
    }
  }
}
