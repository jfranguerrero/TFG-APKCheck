package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public class zzfd
  extends zzg<zzev>
{
  public zzfd()
  {
    super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
  }
  
  public zzeu zzl(Context paramContext)
  {
    try
    {
      zzd localZzd = zze.zzA(paramContext);
      paramContext = zzeu.zza.zzu(((zzev)zzaT(paramContext)).zza(localZzd, 10084000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzpy.zzc("Could not get remote MobileAdsSettingManager.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      zzpy.zzc("Could not get remote MobileAdsSettingManager.", paramContext);
    }
    return null;
  }
  
  protected zzev zzy(IBinder paramIBinder)
  {
    return zzev.zza.zzv(paramIBinder);
  }
}
