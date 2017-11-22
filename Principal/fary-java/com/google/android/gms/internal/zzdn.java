package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;

@zzmb
public class zzdn
  extends zzf<zzdr>
{
  zzdn(Context paramContext, Looper paramLooper, zzf.zzb paramZzb, zzf.zzc paramZzc)
  {
    super(paramContext, paramLooper, 123, paramZzb, paramZzc, null);
  }
  
  protected String zzeu()
  {
    return "com.google.android.gms.ads.service.CACHE";
  }
  
  protected String zzev()
  {
    return "com.google.android.gms.ads.internal.cache.ICacheService";
  }
  
  public zzdr zzew()
    throws DeadObjectException
  {
    return (zzdr)super.zzwW();
  }
  
  protected zzdr zzg(IBinder paramIBinder)
  {
    return zzdr.zza.zzi(paramIBinder);
  }
}
