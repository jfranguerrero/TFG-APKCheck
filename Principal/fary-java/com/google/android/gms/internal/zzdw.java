package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public final class zzdw
  extends zzg<zzeo>
{
  public zzdw()
  {
    super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
  }
  
  public zzen zza(Context paramContext, String paramString, zzjs paramZzjs)
  {
    try
    {
      zzd localZzd = zze.zzA(paramContext);
      paramContext = zzen.zza.zzo(((zzeo)zzaT(paramContext)).zza(localZzd, paramString, paramZzjs, 10084000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzpy.zzc("Could not create remote builder for AdLoader.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;)
      {
        zzpy.zzc("Could not create remote builder for AdLoader.", paramContext);
      }
    }
  }
  
  protected zzeo zzj(IBinder paramIBinder)
  {
    return zzeo.zza.zzp(paramIBinder);
  }
}
