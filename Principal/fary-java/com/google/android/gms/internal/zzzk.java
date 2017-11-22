package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzzk
  extends zzl<zzzn>
{
  public zzzk(Context paramContext, Looper paramLooper, zzg paramZzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 40, paramZzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void zza(zzzm paramZzzm, zzzh paramZzzh)
    throws RemoteException
  {
    ((zzzn)zzwW()).zza(paramZzzm, paramZzzh);
  }
  
  protected zzzn zzbm(IBinder paramIBinder)
  {
    return zzzn.zza.zzbo(paramIBinder);
  }
  
  protected String zzeu()
  {
    return "com.google.android.gms.clearcut.service.START";
  }
  
  protected String zzev()
  {
    return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
  }
}
