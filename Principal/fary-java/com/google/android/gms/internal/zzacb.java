package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzacb
  extends zzl<zzacd>
{
  public zzacb(Context paramContext, Looper paramLooper, zzg paramZzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramZzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzacd zzbz(IBinder paramIBinder)
  {
    return zzacd.zza.zzbB(paramIBinder);
  }
  
  public String zzeu()
  {
    return "com.google.android.gms.common.service.START";
  }
  
  protected String zzev()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
}
