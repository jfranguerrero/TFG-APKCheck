package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;

public class zzzy
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> zzawb;
  private final int zzazb;
  private zzzz zzazc;
  
  public zzzy(Api<?> paramApi, int paramInt)
  {
    zzawb = paramApi;
    zzazb = paramInt;
  }
  
  private void zzvi()
  {
    zzac.zzb(zzazc, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }
  
  public void onConnected(@Nullable Bundle paramBundle)
  {
    zzvi();
    zzazc.onConnected(paramBundle);
  }
  
  public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    zzvi();
    zzazc.zza(paramConnectionResult, zzawb, zzazb);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzvi();
    zzazc.onConnectionSuspended(paramInt);
  }
  
  public void zza(zzzz paramZzzz)
  {
    zzazc = paramZzzz;
  }
}
