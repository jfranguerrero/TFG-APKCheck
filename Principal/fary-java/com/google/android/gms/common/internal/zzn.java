package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzn
{
  private static final Object zzaED = new Object();
  private static zzn zzaEE;
  
  public zzn() {}
  
  public static zzn zzaC(Context paramContext)
  {
    synchronized (zzaED)
    {
      if (zzaEE == null) {
        zzaEE = new zzo(paramContext.getApplicationContext());
      }
      return zzaEE;
    }
  }
  
  public abstract boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
  
  public abstract void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
}
