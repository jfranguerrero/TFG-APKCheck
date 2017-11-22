package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaaw;
import com.google.android.gms.internal.zzaax;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult>
  extends Task<TResult>
{
  private final zzg<TResult> zzbLH = new zzg();
  private boolean zzbLI;
  private TResult zzbLJ;
  private Exception zzbLK;
  private final Object zzrN = new Object();
  
  zzh() {}
  
  private void zzSe()
  {
    zzac.zza(zzbLI, "Task is not yet complete");
  }
  
  private void zzSf()
  {
    if (!zzbLI) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Task is already complete");
      return;
    }
  }
  
  private void zzSg()
  {
    synchronized (zzrN)
    {
      if (!zzbLI) {
        return;
      }
      zzbLH.zza(this);
      return;
    }
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull Activity paramActivity, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    paramOnCompleteListener = new zzc(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    zzbLH.zza(paramOnCompleteListener);
    zza.zzw(paramActivity).zzb(paramOnCompleteListener);
    zzSg();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    zzbLH.zza(new zzc(paramExecutor, paramOnCompleteListener));
    zzSg();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnFailureListener(@NonNull Activity paramActivity, @NonNull OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new zzd(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    zzbLH.zza(paramOnFailureListener);
    zza.zzw(paramActivity).zzb(paramOnFailureListener);
    zzSg();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnFailureListener(@NonNull OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  @NonNull
  public Task<TResult> addOnFailureListener(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener)
  {
    zzbLH.zza(new zzd(paramExecutor, paramOnFailureListener));
    zzSg();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnSuccessListener(@NonNull Activity paramActivity, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    paramOnSuccessListener = new zze(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    zzbLH.zza(paramOnSuccessListener);
    zza.zzw(paramActivity).zzb(paramOnSuccessListener);
    zzSg();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  @NonNull
  public Task<TResult> addOnSuccessListener(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    zzbLH.zza(new zze(paramExecutor, paramOnSuccessListener));
    zzSg();
    return this;
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation)
  {
    zzh localZzh = new zzh();
    zzbLH.zza(new zza(paramExecutor, paramContinuation, localZzh));
    zzSg();
    return localZzh;
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    zzh localZzh = new zzh();
    zzbLH.zza(new zzb(paramExecutor, paramContinuation, localZzh));
    zzSg();
    return localZzh;
  }
  
  @Nullable
  public Exception getException()
  {
    synchronized (zzrN)
    {
      Exception localException = zzbLK;
      return localException;
    }
  }
  
  public TResult getResult()
  {
    synchronized (zzrN)
    {
      zzSe();
      if (zzbLK != null) {
        throw new RuntimeExecutionException(zzbLK);
      }
    }
    Object localObject3 = zzbLJ;
    return localObject3;
  }
  
  public <X extends Throwable> TResult getResult(@NonNull Class<X> paramClass)
    throws Throwable
  {
    synchronized (zzrN)
    {
      zzSe();
      if (paramClass.isInstance(zzbLK)) {
        throw ((Throwable)paramClass.cast(zzbLK));
      }
    }
    if (zzbLK != null) {
      throw new RuntimeExecutionException(zzbLK);
    }
    paramClass = zzbLJ;
    return paramClass;
  }
  
  public boolean isComplete()
  {
    synchronized (zzrN)
    {
      boolean bool = zzbLI;
      return bool;
    }
  }
  
  public boolean isSuccessful()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if ((zzbLI) && (zzbLK == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void setException(@NonNull Exception paramException)
  {
    zzac.zzb(paramException, "Exception must not be null");
    synchronized (zzrN)
    {
      zzSf();
      zzbLI = true;
      zzbLK = paramException;
      zzbLH.zza(this);
      return;
    }
  }
  
  public void setResult(TResult paramTResult)
  {
    synchronized (zzrN)
    {
      zzSf();
      zzbLI = true;
      zzbLJ = paramTResult;
      zzbLH.zza(this);
      return;
    }
  }
  
  public boolean trySetException(@NonNull Exception paramException)
  {
    zzac.zzb(paramException, "Exception must not be null");
    synchronized (zzrN)
    {
      if (zzbLI) {
        return false;
      }
      zzbLI = true;
      zzbLK = paramException;
      zzbLH.zza(this);
      return true;
    }
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    synchronized (zzrN)
    {
      if (zzbLI) {
        return false;
      }
      zzbLI = true;
      zzbLJ = paramTResult;
      zzbLH.zza(this);
      return true;
    }
  }
  
  private static class zza
    extends zzaaw
  {
    private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();
    
    private zza(zzaax paramZzaax)
    {
      super();
      zzaBs.zza("TaskOnStopCallback", this);
    }
    
    public static zza zzw(Activity paramActivity)
    {
      zzaax localZzaax = zzs(paramActivity);
      zza localZza = (zza)localZzaax.zza("TaskOnStopCallback", zza.class);
      paramActivity = localZza;
      if (localZza == null) {
        paramActivity = new zza(localZzaax);
      }
      return paramActivity;
    }
    
    @MainThread
    public void onStop()
    {
      synchronized (mListeners)
      {
        Iterator localIterator = mListeners.iterator();
        while (localIterator.hasNext())
        {
          zzf localZzf = (zzf)((WeakReference)localIterator.next()).get();
          if (localZzf != null) {
            localZzf.cancel();
          }
        }
      }
      mListeners.clear();
    }
    
    public <T> void zzb(zzf<T> paramZzf)
    {
      synchronized (mListeners)
      {
        mListeners.add(new WeakReference(paramZzf));
        return;
      }
    }
  }
}
