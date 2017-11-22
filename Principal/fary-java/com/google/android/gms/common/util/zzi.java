package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.zze;

public final class zzi
{
  private static Boolean zzaGL;
  private static Boolean zzaGM;
  private static Boolean zzaGN;
  private static Boolean zzaGO;
  private static Boolean zzaGP;
  
  @TargetApi(20)
  public static boolean zzaI(Context paramContext)
  {
    if (zzaGN == null) {
      if ((!zzs.zzyG()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      zzaGN = Boolean.valueOf(bool);
      return zzaGN.booleanValue();
    }
  }
  
  @TargetApi(24)
  public static boolean zzaJ(Context paramContext)
  {
    return (!zzs.isAtLeastN()) && (zzaI(paramContext));
  }
  
  @TargetApi(21)
  public static boolean zzaK(Context paramContext)
  {
    if (zzaGO == null) {
      if ((!zzs.zzyI()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      zzaGO = Boolean.valueOf(bool);
      return zzaGO.booleanValue();
    }
  }
  
  public static boolean zzaL(Context paramContext)
  {
    if (zzaGP == null) {
      zzaGP = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
    }
    return zzaGP.booleanValue();
  }
  
  public static boolean zzb(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null) {
      return false;
    }
    if (zzaGL == null) {
      if ((getConfigurationscreenLayout & 0xF) <= 3) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (((zzs.zzyx()) && (i != 0)) || (zzc(paramResources))) {
        bool = true;
      }
      zzaGL = Boolean.valueOf(bool);
      return zzaGL.booleanValue();
    }
  }
  
  @TargetApi(13)
  private static boolean zzc(Resources paramResources)
  {
    if (zzaGM == null)
    {
      paramResources = paramResources.getConfiguration();
      if ((!zzs.zzyz()) || ((screenLayout & 0xF) > 3) || (smallestScreenWidthDp < 600)) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      zzaGM = Boolean.valueOf(bool);
      return zzaGM.booleanValue();
    }
  }
  
  public static boolean zzyw()
  {
    boolean bool = zze.zzaxl;
    return "user".equals(Build.TYPE);
  }
}
