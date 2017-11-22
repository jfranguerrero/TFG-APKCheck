package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api.zzg;

public class zzal<T extends IInterface>
  extends zzl<T>
{
  private final Api.zzg<T> zzaFm;
  
  protected String zzeu()
  {
    return zzaFm.zzeu();
  }
  
  protected String zzev()
  {
    return zzaFm.zzev();
  }
  
  protected T zzh(IBinder paramIBinder)
  {
    return zzaFm.zzh(paramIBinder);
  }
  
  public Api.zzg<T> zzxG()
  {
    return zzaFm;
  }
}
