package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzoz
{
  final String zzVW;
  int zzWo = -1;
  long zzWp = -1L;
  long zzWq = -1L;
  int zzWr = -1;
  int zzWs = 0;
  int zzWt = 0;
  private final Object zzrN = new Object();
  
  public zzoz(String paramString)
  {
    zzVW = paramString;
  }
  
  public static boolean zzx(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      zzpe.zzbd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == getPackageManagergetActivityInfo0theme) {
        return true;
      }
      zzpe.zzbd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzpe.zzbe("Fail to fetch AdActivity theme");
      zzpe.zzbd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public void zzag(int paramInt)
  {
    zzWo = paramInt;
  }
  
  public void zzb(zzdy paramZzdy, long paramLong)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzWq == -1L)
        {
          if (paramLong - zzv.zzcN().zzjV() > ((Long)zzfx.zzCv.get()).longValue())
          {
            zzag(-1);
            zzWq = paramLong;
            zzWp = zzWq;
            if ((extras == null) || (extras.getInt("gw", 2) != 1)) {
              break;
            }
            return;
          }
          zzag(zzv.zzcN().zzjW());
        }
      }
      zzWp = paramLong;
    }
    zzWr += 1;
    zzWo += 1;
  }
  
  public Bundle zze(Context paramContext, String paramString)
  {
    synchronized (zzrN)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", zzVW);
      localBundle.putLong("basets", zzWq);
      localBundle.putLong("currts", zzWp);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", zzWr);
      localBundle.putInt("preqs_in_session", zzWo);
      localBundle.putInt("pclick", zzWs);
      localBundle.putInt("pimp", zzWt);
      localBundle.putBoolean("support_transparent_background", zzx(paramContext));
      return localBundle;
    }
  }
  
  public void zzjA()
  {
    synchronized (zzrN)
    {
      zzWs += 1;
      return;
    }
  }
  
  public int zzjW()
  {
    return zzWo;
  }
  
  public void zzjz()
  {
    synchronized (zzrN)
    {
      zzWt += 1;
      return;
    }
  }
  
  public long zzkd()
  {
    return zzWq;
  }
}
