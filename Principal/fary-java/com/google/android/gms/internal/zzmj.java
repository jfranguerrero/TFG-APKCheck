package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

@zzmb
public final class zzmj
  extends zzmr.zza
{
  private final WeakReference<zzme.zza> zzRI;
  
  public zzmj(zzme.zza paramZza)
  {
    zzRI = new WeakReference(paramZza);
  }
  
  public void zzb(zzmk paramZzmk)
  {
    zzme.zza localZza = (zzme.zza)zzRI.get();
    if (localZza != null) {
      localZza.zzb(paramZzmk);
    }
  }
}
