package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzacx;

public class zzz
{
  private static boolean zzPT;
  private static String zzaEW;
  private static int zzaEX;
  private static Object zztU = new Object();
  
  public static String zzaD(Context paramContext)
  {
    zzaF(paramContext);
    return zzaEW;
  }
  
  public static int zzaE(Context paramContext)
  {
    zzaF(paramContext);
    return zzaEX;
  }
  
  private static void zzaF(Context paramContext)
  {
    String str;
    synchronized (zztU)
    {
      if (zzPT) {
        return;
      }
      zzPT = true;
      str = paramContext.getPackageName();
      paramContext = zzacx.zzaQ(paramContext);
    }
    try
    {
      paramContext = getApplicationInfo128metaData;
      if (paramContext == null)
      {
        return;
        paramContext = finally;
        throw paramContext;
      }
      zzaEW = paramContext.getString("com.google.app.id");
      zzaEX = paramContext.getInt("com.google.android.gms.version");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
      }
    }
  }
}
