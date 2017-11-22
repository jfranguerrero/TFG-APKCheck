package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public final class zzabx
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Common.API", zzahd, zzahc);
  public static final zzaby zzaFp = new zzabz();
  public static final Api.zzf<zzacb> zzahc = new Api.zzf();
  private static final Api.zza<zzacb, Api.ApiOptions.NoOptions> zzahd = new Api.zza()
  {
    public zzacb zzf(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymousZzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzacb(paramAnonymousContext, paramAnonymousLooper, paramAnonymousZzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
}
