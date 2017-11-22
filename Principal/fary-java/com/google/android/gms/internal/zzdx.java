package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public class zzdx
  extends zzg<zzeq>
{
  public zzdx()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public zzep zza(Context paramContext, zzec paramZzec, String paramString, zzjs paramZzjs, int paramInt)
  {
    try
    {
      zzd localZzd = zze.zzA(paramContext);
      paramContext = zzep.zza.zzq(((zzeq)zzaT(paramContext)).zza(localZzd, paramZzec, paramString, paramZzjs, 10084000, paramInt));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzpy.zza("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;) {}
    }
  }
  
  protected zzeq zzk(IBinder paramIBinder)
  {
    return zzeq.zza.zzr(paramIBinder);
  }
}
