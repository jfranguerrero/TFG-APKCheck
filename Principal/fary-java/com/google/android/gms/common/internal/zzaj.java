package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzaj
  extends zzg<zzy>
{
  private static final zzaj zzaFl = new zzaj();
  
  private zzaj()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View zzd(Context paramContext, int paramInt1, int paramInt2)
    throws zzg.zza
  {
    return zzaFl.zze(paramContext, paramInt1, paramInt2);
  }
  
  private View zze(Context paramContext, int paramInt1, int paramInt2)
    throws zzg.zza
  {
    try
    {
      zzah localZzah = new zzah(paramInt1, paramInt2, null);
      zzd localZzd = zze.zzA(paramContext);
      paramContext = (View)zze.zzE(((zzy)zzaT(paramContext)).zza(localZzd, localZzah));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new zzg.zza(64 + "Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public zzy zzby(IBinder paramIBinder)
  {
    return zzy.zza.zzbx(paramIBinder);
  }
}
