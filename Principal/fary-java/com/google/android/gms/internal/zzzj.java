package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;

public class zzzj
  extends zzc<Api.ApiOptions.NoOptions>
  implements zzzg
{
  zzzj(@NonNull Context paramContext)
  {
    super(paramContext, zzzf.API, null, new zzzr());
  }
  
  public static zzzg zzai(@NonNull Context paramContext)
  {
    return new zzzj(paramContext);
  }
  
  static void zzb(zzzh paramZzzh)
  {
    if ((zzawM != null) && (zzawL.zzcsF.length == 0)) {
      zzawL.zzcsF = zzawM.zzuw();
    }
    if ((zzawN != null) && (zzawL.zzcsL.length == 0)) {
      zzawL.zzcsL = zzawN.zzuw();
    }
    zzawF = zzbut.zzf(zzawL);
  }
  
  public PendingResult<Status> zza(zzzh paramZzzh)
  {
    return doBestEffortWrite(new zza(paramZzzh, asGoogleApiClient()));
  }
  
  static final class zza
    extends zzzv.zza<Status, zzzk>
  {
    private final zzzh zzawO;
    
    zza(zzzh paramZzzh, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
      zzawO = paramZzzh;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      return zzawO.equals(zzawO);
    }
    
    public String toString()
    {
      String str = String.valueOf(zzawO);
      return String.valueOf(str).length() + 20 + "LogEventMethodImpl(" + str + ")";
    }
    
    protected void zza(zzzk paramZzzk)
      throws RemoteException
    {
      zzzm.zza local1 = new zzzm.zza()
      {
        public void zzv(Status paramAnonymousStatus)
        {
          zzb(paramAnonymousStatus);
        }
        
        public void zzw(Status paramAnonymousStatus)
        {
          throw new UnsupportedOperationException();
        }
      };
      try
      {
        zzzj.zzb(zzawO);
        paramZzzk.zza(local1, zzawO);
        return;
      }
      catch (RuntimeException paramZzzk)
      {
        Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", paramZzzk);
        zzA(new Status(10, "MessageProducer"));
      }
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}
