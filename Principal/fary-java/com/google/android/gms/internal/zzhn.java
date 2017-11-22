package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzmb
public class zzhn
  extends zzg<zzhc>
{
  public zzhn()
  {
    super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
  }
  
  protected zzhc zzL(IBinder paramIBinder)
  {
    return zzhc.zza.zzD(paramIBinder);
  }
  
  public zzhb zzb(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    try
    {
      zzd localZzd = zze.zzA(paramContext);
      paramFrameLayout1 = zze.zzA(paramFrameLayout1);
      paramFrameLayout2 = zze.zzA(paramFrameLayout2);
      paramContext = zzhb.zza.zzC(((zzhc)zzaT(paramContext)).zza(localZzd, paramFrameLayout1, paramFrameLayout2, 10084000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzpy.zzc("Could not create remote NativeAdViewDelegate.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;) {}
    }
  }
}
