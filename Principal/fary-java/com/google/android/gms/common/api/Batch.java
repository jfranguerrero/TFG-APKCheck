package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzzx;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzzx<BatchResult>
{
  private boolean zzaxA;
  private boolean zzaxB;
  private final PendingResult<?>[] zzaxC;
  private int zzaxz;
  private final Object zzrN = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    zzaxz = paramList.size();
    zzaxC = new PendingResult[zzaxz];
    if (paramList.isEmpty()) {
      zzb(new BatchResult(Status.zzayh, zzaxC));
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramGoogleApiClient = (PendingResult)paramList.get(i);
        zzaxC[i] = paramGoogleApiClient;
        paramGoogleApiClient.zza(new PendingResult.zza()
        {
          public void zzx(Status paramAnonymousStatus)
          {
            for (;;)
            {
              synchronized (Batch.zza(Batch.this))
              {
                if (isCanceled()) {
                  return;
                }
                if (paramAnonymousStatus.isCanceled())
                {
                  Batch.zza(Batch.this, true);
                  Batch.zzb(Batch.this);
                  if (Batch.zzc(Batch.this) == 0)
                  {
                    if (!Batch.zzd(Batch.this)) {
                      break;
                    }
                    Batch.zze(Batch.this);
                  }
                  return;
                }
              }
              if (!paramAnonymousStatus.isSuccess()) {
                Batch.zzb(Batch.this, true);
              }
            }
            if (Batch.zzf(Batch.this)) {}
            for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.zzayh)
            {
              zzb(new BatchResult(paramAnonymousStatus, Batch.zzg(Batch.this)));
              break;
            }
          }
        });
        i += 1;
      }
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = zzaxC;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, zzaxC);
  }
  
  public static final class Builder
  {
    private GoogleApiClient zzamy;
    private List<PendingResult<?>> zzaxE = new ArrayList();
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      zzamy = paramGoogleApiClient;
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(zzaxE.size());
      zzaxE.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(zzaxE, zzamy, null);
    }
  }
}
