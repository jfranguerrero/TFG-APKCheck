package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class zzaad
{
  private final Map<zzzx<?>, Boolean> zzazC = Collections.synchronizedMap(new WeakHashMap());
  private final Map<TaskCompletionSource<?>, Boolean> zzazD = Collections.synchronizedMap(new WeakHashMap());
  
  public zzaad() {}
  
  private void zza(boolean paramBoolean, Status paramStatus)
  {
    Object localObject2;
    synchronized (zzazC)
    {
      localObject2 = new HashMap(zzazC);
    }
    synchronized (zzazD)
    {
      ??? = new HashMap(zzazD);
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (Map.Entry)((Iterator)localObject2).next();
        if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue()))
        {
          ((zzzx)((Map.Entry)???).getKey()).zzB(paramStatus);
          continue;
          paramStatus = finally;
          throw paramStatus;
        }
      }
    }
    ??? = ((Map)???).entrySet().iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)???).next();
      if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {
        ((TaskCompletionSource)((Map.Entry)localObject2).getKey()).trySetException(new zza(paramStatus));
      }
    }
  }
  
  void zza(final zzzx<? extends Result> paramZzzx, boolean paramBoolean)
  {
    zzazC.put(paramZzzx, Boolean.valueOf(paramBoolean));
    paramZzzx.zza(new PendingResult.zza()
    {
      public void zzx(Status paramAnonymousStatus)
      {
        zzaad.zza(zzaad.this).remove(paramZzzx);
      }
    });
  }
  
  <TResult> void zza(final TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean)
  {
    zzazD.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener()
    {
      public void onComplete(@NonNull Task<TResult> paramAnonymousTask)
      {
        zzaad.zzb(zzaad.this).remove(paramTaskCompletionSource);
      }
    });
  }
  
  boolean zzvu()
  {
    return (!zzazC.isEmpty()) || (!zzazD.isEmpty());
  }
  
  public void zzvv()
  {
    zza(false, zzaap.zzaAO);
  }
  
  public void zzvw()
  {
    zza(true, zzabq.zzaBV);
  }
}
