package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabc;
import com.google.android.gms.internal.zzabl;
import com.google.android.gms.internal.zzzx;

public final class PendingResults
{
  private PendingResults() {}
  
  public static PendingResult<Status> canceledPendingResult()
  {
    zzabl localZzabl = new zzabl(Looper.getMainLooper());
    localZzabl.cancel();
    return localZzabl;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    zzac.zzb(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Status code must be CommonStatusCodes.CANCELED");
      paramR = new zza(paramR);
      paramR.cancel();
      return paramR;
    }
  }
  
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    zzac.zzb(paramR, "Result must not be null");
    zzc localZzc = new zzc(null);
    localZzc.zzb(paramR);
    return new zzabc(localZzc);
  }
  
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    zzac.zzb(paramStatus, "Result must not be null");
    zzabl localZzabl = new zzabl(Looper.getMainLooper());
    localZzabl.zzb(paramStatus);
    return localZzabl;
  }
  
  public static <R extends Result> PendingResult<R> zza(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzac.zzb(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Status code must not be SUCCESS");
      paramGoogleApiClient = new zzb(paramGoogleApiClient, paramR);
      paramGoogleApiClient.zzb(paramR);
      return paramGoogleApiClient;
    }
  }
  
  public static PendingResult<Status> zza(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    zzac.zzb(paramStatus, "Result must not be null");
    paramGoogleApiClient = new zzabl(paramGoogleApiClient);
    paramGoogleApiClient.zzb(paramStatus);
    return paramGoogleApiClient;
  }
  
  public static <R extends Result> OptionalPendingResult<R> zzb(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzac.zzb(paramR, "Result must not be null");
    paramGoogleApiClient = new zzc(paramGoogleApiClient);
    paramGoogleApiClient.zzb(paramR);
    return new zzabc(paramGoogleApiClient);
  }
  
  private static final class zza<R extends Result>
    extends zzzx<R>
  {
    private final R zzayc;
    
    public zza(R paramR)
    {
      super();
      zzayc = paramR;
    }
    
    protected R zzc(Status paramStatus)
    {
      if (paramStatus.getStatusCode() != zzayc.getStatus().getStatusCode()) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
      }
      return zzayc;
    }
  }
  
  private static final class zzb<R extends Result>
    extends zzzx<R>
  {
    private final R zzayd;
    
    public zzb(GoogleApiClient paramGoogleApiClient, R paramR)
    {
      super();
      zzayd = paramR;
    }
    
    protected R zzc(Status paramStatus)
    {
      return zzayd;
    }
  }
  
  private static final class zzc<R extends Result>
    extends zzzx<R>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected R zzc(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}
