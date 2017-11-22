package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzacx;

public final class zzx
{
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzacx.zzaQ(paramContext).zzg(paramInt, paramString);
  }
  
  public static boolean zzf(Context paramContext, int paramInt)
  {
    if (!zzc(paramContext, paramInt, "com.google.android.gms")) {}
    do
    {
      return false;
      Object localObject = paramContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
        return zzf.zzav(paramContext).zzb(paramContext.getPackageManager(), (PackageInfo)localObject);
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    } while (!Log.isLoggable("UidVerifier", 3));
    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
    return false;
  }
}
