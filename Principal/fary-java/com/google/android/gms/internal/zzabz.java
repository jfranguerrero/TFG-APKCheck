package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzabz
  implements zzaby
{
  public zzabz() {}
  
  public PendingResult<Status> zzg(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzaca.zza(paramGoogleApiClient)
    {
      protected void zza(zzacb paramAnonymousZzacb)
        throws RemoteException
      {
        ((zzacd)paramAnonymousZzacb.zzwW()).zza(new zzabz.zza(this));
      }
    });
  }
  
  private static class zza
    extends zzabw
  {
    private final zzzv.zzb<Status> zzaFq;
    
    public zza(zzzv.zzb<Status> paramZzb)
    {
      zzaFq = paramZzb;
    }
    
    public void zzcX(int paramInt)
      throws RemoteException
    {
      zzaFq.setResult(new Status(paramInt));
    }
  }
}
