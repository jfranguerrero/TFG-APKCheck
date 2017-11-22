package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public final class zzlf
  extends zzg<zzlb>
{
  public zzlf()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  protected zzlb zzac(IBinder paramIBinder)
  {
    return zzlb.zza.zzZ(paramIBinder);
  }
  
  public zzla zzg(Activity paramActivity)
  {
    try
    {
      zzd localZzd = zze.zzA(paramActivity);
      paramActivity = zzla.zza.zzY(((zzlb)zzaT(paramActivity)).zzp(localZzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzpy.zzc("Could not create remote InAppPurchaseManager.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzpy.zzc("Could not create remote InAppPurchaseManager.", paramActivity);
    }
    return null;
  }
}
