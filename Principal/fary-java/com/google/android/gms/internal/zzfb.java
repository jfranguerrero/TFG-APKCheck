package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzfb
{
  private static zzfb zzAj;
  private static final Object zztU = new Object();
  private zzeu zzAk;
  private RewardedVideoAd zzAl;
  
  private zzfb() {}
  
  public static zzfb zzff()
  {
    synchronized (zztU)
    {
      if (zzAj == null) {
        zzAj = new zzfb();
      }
      zzfb localZzfb = zzAj;
      return localZzfb;
    }
  }
  
  public RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    synchronized (zztU)
    {
      if (zzAl != null)
      {
        paramContext = zzAl;
        return paramContext;
      }
      zzjr localZzjr = new zzjr();
      zzAl = new zznz(paramContext, zzeh.zzeP().zza(paramContext, localZzjr));
      paramContext = zzAl;
      return paramContext;
    }
  }
  
  public void openDebugMenu(Context paramContext, String paramString)
  {
    if (zzAk != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "MobileAds.initialize() must be called prior to opening debug menu.");
      try
      {
        zzAk.zzb(zze.zzA(paramContext), paramString);
        return;
      }
      catch (RemoteException paramContext)
      {
        zzpy.zzb("Unable to open debug menu.", paramContext);
      }
    }
  }
  
  public void setAppMuted(boolean paramBoolean)
  {
    if (zzAk != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "MobileAds.initialize() must be called prior to setting the app volume.");
      try
      {
        zzAk.setAppMuted(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzpy.zzb("Unable to set app mute state.", localRemoteException);
      }
    }
  }
  
  public void setAppVolume(float paramFloat)
  {
    boolean bool2 = true;
    if ((0.0F <= paramFloat) && (paramFloat <= 1.0F))
    {
      bool1 = true;
      zzac.zzb(bool1, "The app volume must be a value between 0 and 1 inclusive.");
      if (zzAk == null) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "MobileAds.initialize() must be called prior to setting the app volume.");
      try
      {
        zzAk.setAppVolume(paramFloat);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzpy.zzb("Unable to set app volume.", localRemoteException);
      }
      bool1 = false;
      break;
    }
  }
  
  public void zza(Context paramContext, String paramString, zzfc arg3)
  {
    synchronized (zztU)
    {
      if (zzAk != null) {
        return;
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("Context cannot be null.");
      }
    }
    try
    {
      zzAk = zzeh.zzeP().zzk(paramContext);
      zzAk.initialize();
      if (paramString != null) {
        zzAk.zzy(paramString);
      }
    }
    catch (RemoteException paramContext)
    {
      for (;;)
      {
        zzpy.zzc("Fail to initialize or set applicationCode on mobile ads setting manager", paramContext);
      }
    }
  }
}
