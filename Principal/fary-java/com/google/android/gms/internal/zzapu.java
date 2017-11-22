package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;

public class zzapu
  extends zzf<zzapz>
{
  public zzapu(Context paramContext, Looper paramLooper, zzf.zzb paramZzb, zzf.zzc paramZzc)
  {
    super(paramContext, paramLooper, 116, paramZzb, paramZzc, null);
  }
  
  public zzapz zzFX()
    throws DeadObjectException
  {
    return (zzapz)super.zzwW();
  }
  
  protected zzapz zzcT(IBinder paramIBinder)
  {
    return zzapz.zza.zzcU(paramIBinder);
  }
  
  protected String zzeu()
  {
    return "com.google.android.gms.gass.START";
  }
  
  protected String zzev()
  {
    return "com.google.android.gms.gass.internal.IGassService";
  }
}
