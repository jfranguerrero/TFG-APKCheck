package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks
{
  private Tasks() {}
  
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask)
    throws ExecutionException, InterruptedException
  {
    zzac.zzxx();
    zzac.zzb(paramTask, "Task must not be null");
    if (paramTask.isComplete()) {
      return zzb(paramTask);
    }
    zza localZza = new zza(null);
    zza(paramTask, localZza);
    localZza.await();
    return zzb(paramTask);
  }
  
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask, long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    zzac.zzxx();
    zzac.zzb(paramTask, "Task must not be null");
    zzac.zzb(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete()) {
      return zzb(paramTask);
    }
    zza localZza = new zza(null);
    zza(paramTask, localZza);
    if (!localZza.await(paramLong, paramTimeUnit)) {
      throw new TimeoutException("Timed out waiting for Task");
    }
    return zzb(paramTask);
  }
  
  public static <TResult> Task<TResult> call(@NonNull Callable<TResult> paramCallable)
  {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  public static <TResult> Task<TResult> call(@NonNull Executor paramExecutor, @NonNull final Callable<TResult> paramCallable)
  {
    zzac.zzb(paramExecutor, "Executor must not be null");
    zzac.zzb(paramCallable, "Callback must not be null");
    zzh localZzh = new zzh();
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          setResult(paramCallable.call());
          return;
        }
        catch (Exception localException)
        {
          setException(localException);
        }
      }
    });
    return localZzh;
  }
  
  public static <TResult> Task<TResult> forException(@NonNull Exception paramException)
  {
    zzh localZzh = new zzh();
    localZzh.setException(paramException);
    return localZzh;
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    zzh localZzh = new zzh();
    localZzh.setResult(paramTResult);
    return localZzh;
  }
  
  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return forResult(null);
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Task)((Iterator)localObject).next() == null) {
        throw new NullPointerException("null tasks are not accepted");
      }
    }
    localObject = new zzh();
    zzc localZzc = new zzc(paramCollection.size(), (zzh)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza((Task)paramCollection.next(), localZzc);
    }
    return localObject;
  }
  
  public static Task<Void> whenAll(Task<?>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return forResult(null);
    }
    return whenAll(Arrays.asList(paramVarArgs));
  }
  
  private static void zza(Task<?> paramTask, zzb paramZzb)
  {
    paramTask.addOnSuccessListener(TaskExecutors.zzbLG, paramZzb);
    paramTask.addOnFailureListener(TaskExecutors.zzbLG, paramZzb);
  }
  
  private static <TResult> TResult zzb(Task<TResult> paramTask)
    throws ExecutionException
  {
    if (paramTask.isSuccessful()) {
      return paramTask.getResult();
    }
    throw new ExecutionException(paramTask.getException());
  }
  
  private static final class zza
    implements Tasks.zzb
  {
    private final CountDownLatch zzth = new CountDownLatch(1);
    
    private zza() {}
    
    public void await()
      throws InterruptedException
    {
      zzth.await();
    }
    
    public boolean await(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return zzth.await(paramLong, paramTimeUnit);
    }
    
    public void onFailure(@NonNull Exception paramException)
    {
      zzth.countDown();
    }
    
    public void onSuccess(Object paramObject)
    {
      zzth.countDown();
    }
  }
  
  static abstract interface zzb
    extends OnFailureListener, OnSuccessListener<Object>
  {}
  
  private static final class zzc
    implements Tasks.zzb
  {
    private final zzh<Void> zzbLF;
    private Exception zzbLK;
    private final int zzbLM;
    private int zzbLN;
    private int zzbLO;
    private final Object zzrN = new Object();
    
    public zzc(int paramInt, zzh<Void> paramZzh)
    {
      zzbLM = paramInt;
      zzbLF = paramZzh;
    }
    
    private void zzSh()
    {
      if (zzbLN + zzbLO == zzbLM)
      {
        if (zzbLK == null) {
          zzbLF.setResult(null);
        }
      }
      else {
        return;
      }
      zzh localZzh = zzbLF;
      int i = zzbLO;
      int j = zzbLM;
      localZzh.setException(new ExecutionException(54 + i + " out of " + j + " underlying tasks failed", zzbLK));
    }
    
    public void onFailure(@NonNull Exception paramException)
    {
      synchronized (zzrN)
      {
        zzbLO += 1;
        zzbLK = paramException;
        zzSh();
        return;
      }
    }
    
    public void onSuccess(Object arg1)
    {
      synchronized (zzrN)
      {
        zzbLN += 1;
        zzSh();
        return;
      }
    }
  }
}
