package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status zzahq;
  private final PendingResult<?>[] zzaxC;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    zzahq = paramStatus;
    zzaxC = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return zzahq;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (mId < zzaxC.length) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "The result token does not belong to this batch");
      return zzaxC[mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}
