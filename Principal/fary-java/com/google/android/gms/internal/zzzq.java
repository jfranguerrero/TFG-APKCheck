package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public abstract class zzzq
{
  public final int zzanR;
  
  public zzzq(int paramInt)
  {
    zzanR = paramInt;
  }
  
  private static Status zza(RemoteException paramRemoteException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((zzs.zzyB()) && ((paramRemoteException instanceof TransactionTooLargeException))) {
      localStringBuilder.append("TransactionTooLargeException: ");
    }
    localStringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, localStringBuilder.toString());
  }
  
  public abstract void zza(@NonNull zzaad paramZzaad, boolean paramBoolean);
  
  public abstract void zza(zzaap.zza<?> paramZza)
    throws DeadObjectException;
  
  public abstract void zzy(@NonNull Status paramStatus);
  
  private static abstract class zza
    extends zzzq
  {
    protected final TaskCompletionSource<Void> zzayo;
    
    public zza(int paramInt, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super();
      zzayo = paramTaskCompletionSource;
    }
    
    public void zza(@NonNull zzaad paramZzaad, boolean paramBoolean) {}
    
    public final void zza(zzaap.zza<?> paramZza)
      throws DeadObjectException
    {
      try
      {
        zzb(paramZza);
        return;
      }
      catch (DeadObjectException paramZza)
      {
        zzy(zzzq.zzb(paramZza));
        throw paramZza;
      }
      catch (RemoteException paramZza)
      {
        zzy(zzzq.zzb(paramZza));
      }
    }
    
    protected abstract void zzb(zzaap.zza<?> paramZza)
      throws RemoteException;
    
    public void zzy(@NonNull Status paramStatus)
    {
      zzayo.trySetException(new zza(paramStatus));
    }
  }
  
  public static class zzb<A extends zzzv.zza<? extends Result, Api.zzb>>
    extends zzzq
  {
    protected final A zzayp;
    
    public zzb(int paramInt, A paramA)
    {
      super();
      zzayp = paramA;
    }
    
    public void zza(@NonNull zzaad paramZzaad, boolean paramBoolean)
    {
      paramZzaad.zza(zzayp, paramBoolean);
    }
    
    public void zza(zzaap.zza<?> paramZza)
      throws DeadObjectException
    {
      zzayp.zzb(paramZza.zzvr());
    }
    
    public void zzy(@NonNull Status paramStatus)
    {
      zzayp.zzA(paramStatus);
    }
  }
  
  public static final class zzc
    extends zzzq.zza
  {
    public final zzabe<Api.zzb, ?> zzayq;
    public final zzabr<Api.zzb, ?> zzayr;
    
    public zzc(zzabf paramZzabf, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super(paramTaskCompletionSource);
      zzayq = zzayq;
      zzayr = zzayr;
    }
    
    public void zzb(zzaap.zza<?> paramZza)
      throws RemoteException
    {
      if (zzayq.zzwp() != null) {
        paramZza.zzwc().put(zzayq.zzwp(), new zzabf(zzayq, zzayr));
      }
    }
  }
  
  public static final class zzd<TResult>
    extends zzzq
  {
    private final TaskCompletionSource<TResult> zzayo;
    private final zzabn<Api.zzb, TResult> zzays;
    private final zzabk zzayt;
    
    public zzd(int paramInt, zzabn<Api.zzb, TResult> paramZzabn, TaskCompletionSource<TResult> paramTaskCompletionSource, zzabk paramZzabk)
    {
      super();
      zzayo = paramTaskCompletionSource;
      zzays = paramZzabn;
      zzayt = paramZzabk;
    }
    
    public void zza(@NonNull zzaad paramZzaad, boolean paramBoolean)
    {
      paramZzaad.zza(zzayo, paramBoolean);
    }
    
    public void zza(zzaap.zza<?> paramZza)
      throws DeadObjectException
    {
      try
      {
        zzays.zza(paramZza.zzvr(), zzayo);
        return;
      }
      catch (DeadObjectException paramZza)
      {
        throw paramZza;
      }
      catch (RemoteException paramZza)
      {
        zzy(zzzq.zzb(paramZza));
      }
    }
    
    public void zzy(@NonNull Status paramStatus)
    {
      zzayo.trySetException(zzayt.zzz(paramStatus));
    }
  }
  
  public static final class zze
    extends zzzq.zza
  {
    public final zzaaz.zzb<?> zzayu;
    
    public zze(zzaaz.zzb<?> paramZzb, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super(paramTaskCompletionSource);
      zzayu = paramZzb;
    }
    
    public void zzb(zzaap.zza<?> paramZza)
      throws RemoteException
    {
      paramZza = (zzabf)paramZza.zzwc().remove(zzayu);
      if (paramZza != null)
      {
        zzayq.zzwq();
        return;
      }
      Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
      zzayo.trySetException(new zza(Status.zzayj));
    }
  }
}
