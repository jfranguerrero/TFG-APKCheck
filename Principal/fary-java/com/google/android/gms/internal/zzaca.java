package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzaca<R extends Result>
  extends zzzv.zza<R, zzacb>
{
  public zzaca(GoogleApiClient paramGoogleApiClient)
  {
    super(zzabx.API, paramGoogleApiClient);
  }
  
  static abstract class zza
    extends zzaca<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}
