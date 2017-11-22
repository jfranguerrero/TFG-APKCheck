package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;

public class BooleanResult
  implements Result
{
  private final Status zzahq;
  private final boolean zzaxF;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    zzahq = ((Status)zzac.zzb(paramStatus, "Status must not be null"));
    zzaxF = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((zzahq.equals(zzahq)) && (zzaxF == zzaxF));
    return false;
  }
  
  public Status getStatus()
  {
    return zzahq;
  }
  
  public boolean getValue()
  {
    return zzaxF;
  }
  
  public final int hashCode()
  {
    int j = zzahq.hashCode();
    if (zzaxF) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}
