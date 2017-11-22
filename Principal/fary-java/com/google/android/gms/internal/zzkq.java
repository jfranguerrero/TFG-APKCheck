package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public final class zzkq
  extends zzg<zzks>
{
  public zzkq()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  protected zzks zzS(IBinder paramIBinder)
  {
    return zzks.zza.zzU(paramIBinder);
  }
  
  public zzkr zzf(Activity paramActivity)
  {
    try
    {
      zzd localZzd = zze.zzA(paramActivity);
      paramActivity = zzkr.zza.zzT(((zzks)zzaT(paramActivity)).zzo(localZzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzpy.zzc("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzpy.zzc("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
}
