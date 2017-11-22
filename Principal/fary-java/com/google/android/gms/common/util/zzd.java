package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzacx;

public class zzd
{
  public static int zza(PackageInfo paramPackageInfo)
  {
    if ((paramPackageInfo == null) || (applicationInfo == null)) {}
    do
    {
      return -1;
      paramPackageInfo = applicationInfo.metaData;
    } while (paramPackageInfo == null);
    return paramPackageInfo.getInt("com.google.android.gms.version", -1);
  }
  
  public static int zzv(Context paramContext, String paramString)
  {
    return zza(zzw(paramContext, paramString));
  }
  
  @Nullable
  public static PackageInfo zzw(Context paramContext, String paramString)
  {
    try
    {
      paramContext = zzacx.zzaQ(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  @TargetApi(12)
  public static boolean zzx(Context paramContext, String paramString)
  {
    if (!zzs.zzyy()) {}
    for (;;)
    {
      return false;
      "com.google.android.gms".equals(paramString);
      try
      {
        int i = zzaQgetApplicationInfo0flags;
        if ((i & 0x200000) != 0) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return false;
  }
}
