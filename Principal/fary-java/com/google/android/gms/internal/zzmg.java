package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;

@zzmb
public class zzmg
  extends zzf<zzmq>
{
  final int zzRb;
  
  public zzmg(Context paramContext, Looper paramLooper, zzf.zzb paramZzb, zzf.zzc paramZzc, int paramInt)
  {
    super(paramContext, paramLooper, 8, paramZzb, paramZzc, null);
    zzRb = paramInt;
  }
  
  protected zzmq zzad(IBinder paramIBinder)
  {
    return zzmq.zza.zzae(paramIBinder);
  }
  
  protected String zzeu()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String zzev()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public zzmq zzjb()
    throws DeadObjectException
  {
    return (zzmq)super.zzwW();
  }
}
