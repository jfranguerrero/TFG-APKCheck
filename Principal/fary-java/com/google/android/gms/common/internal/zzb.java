package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzd;

public class zzb
{
  @NonNull
  public static zza zzF(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      return new zzd(paramStatus);
    }
    return new zza(paramStatus);
  }
  
  @NonNull
  public static zza zzl(@NonNull ConnectionResult paramConnectionResult)
  {
    return zzF(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution()));
  }
}
