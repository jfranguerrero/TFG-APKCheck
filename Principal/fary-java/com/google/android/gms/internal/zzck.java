package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzck
  extends zzg<zzcm>
{
  private static final zzck zzrW = new zzck();
  
  private zzck()
  {
    super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
  }
  
  public static zzcl zzb(String paramString, Context paramContext, boolean paramBoolean)
  {
    Object localObject;
    if (zzc.zzuz().isGooglePlayServicesAvailable(paramContext) == 0)
    {
      zzcl localZzcl = zzrW.zzc(paramString, paramContext, paramBoolean);
      localObject = localZzcl;
      if (localZzcl != null) {}
    }
    else
    {
      localObject = new zzcj(paramString, paramContext, paramBoolean);
    }
    return localObject;
  }
  
  private zzcl zzc(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzd localZzd = zze.zzA(paramContext);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramString = ((zzcm)zzaT(paramContext)).zza(paramString, localZzd);
        return zzcl.zza.zzd(paramString);
      }
      catch (RemoteException paramString)
      {
        return null;
      }
      catch (zzg.zza paramString)
      {
        continue;
      }
      paramString = ((zzcm)zzaT(paramContext)).zzb(paramString, localZzd);
    }
  }
  
  protected zzcm zzb(IBinder paramIBinder)
  {
    return zzcm.zza.zze(paramIBinder);
  }
}
