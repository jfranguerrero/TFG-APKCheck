package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzabk;

public class zza
  implements zzabk
{
  public zza() {}
  
  public Exception zzz(Status paramStatus)
  {
    if (paramStatus.getStatusCode() == 8) {
      return new FirebaseException(paramStatus.zzuU());
    }
    return new FirebaseApiNotAvailableException(paramStatus.zzuU());
  }
}
