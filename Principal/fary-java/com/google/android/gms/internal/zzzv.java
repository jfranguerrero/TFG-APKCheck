package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;

public class zzzv
{
  public static abstract class zza<R extends Result, A extends Api.zzb>
    extends zzzx<R>
    implements zzzv.zzb<R>
  {
    private final Api<?> zzawb;
    private final Api.zzc<A> zzayF;
    
    @Deprecated
    protected zza(Api.zzc<A> paramZzc, GoogleApiClient paramGoogleApiClient)
    {
      super();
      zzayF = ((Api.zzc)zzac.zzw(paramZzc));
      zzawb = null;
    }
    
    protected zza(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super();
      zzayF = paramApi.zzuH();
      zzawb = paramApi;
    }
    
    private void zzc(RemoteException paramRemoteException)
    {
      zzA(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    public final Api<?> getApi()
    {
      return zzawb;
    }
    
    public final void zzA(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "Failed result must not be success");
        zzb(zzc(paramStatus));
        return;
      }
    }
    
    protected abstract void zza(A paramA)
      throws RemoteException;
    
    public final void zzb(A paramA)
      throws DeadObjectException
    {
      try
      {
        zza(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        zzc(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        zzc(paramA);
      }
    }
    
    public final Api.zzc<A> zzuH()
    {
      return zzayF;
    }
  }
  
  public static abstract interface zzb<R>
  {
    public abstract void setResult(R paramR);
    
    public abstract void zzA(Status paramStatus);
  }
}