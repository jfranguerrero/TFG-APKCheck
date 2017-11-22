package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public class zznv
  extends zzg<zzns>
{
  public zznv()
  {
    super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
  }
  
  protected zzns zzak(IBinder paramIBinder)
  {
    return zzns.zza.zzai(paramIBinder);
  }
  
  public zznr zzb(Context paramContext, zzjs paramZzjs)
  {
    try
    {
      zzd localZzd = zze.zzA(paramContext);
      paramContext = zznr.zza.zzah(((zzns)zzaT(paramContext)).zza(localZzd, paramZzjs, 10084000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzpy.zzc("Could not get remote RewardedVideoAd.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;) {}
    }
  }
}
