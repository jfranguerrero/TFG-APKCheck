package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;

public class MobileAds
{
  private MobileAds() {}
  
  public static RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    return zzfb.zzff().getRewardedVideoAdInstance(paramContext);
  }
  
  public static void initialize(Context paramContext)
  {
    initialize(paramContext, null, null);
  }
  
  @RequiresPermission("android.permission.INTERNET")
  public static void initialize(Context paramContext, String paramString)
  {
    initialize(paramContext, paramString, null);
  }
  
  @Deprecated
  @RequiresPermission("android.permission.INTERNET")
  public static void initialize(Context paramContext, String paramString, Settings paramSettings)
  {
    zzfb localZzfb = zzfb.zzff();
    if (paramSettings == null) {}
    for (paramSettings = null;; paramSettings = paramSettings.zzbs())
    {
      localZzfb.zza(paramContext, paramString, paramSettings);
      return;
    }
  }
  
  public static void openDebugMenu(Context paramContext, String paramString)
  {
    zzfb.zzff().openDebugMenu(paramContext, paramString);
  }
  
  public static void setAppMuted(boolean paramBoolean)
  {
    zzfb.zzff().setAppMuted(paramBoolean);
  }
  
  public static void setAppVolume(float paramFloat)
  {
    zzfb.zzff().setAppVolume(paramFloat);
  }
  
  public static final class Settings
  {
    private final zzfc zzrM = new zzfc();
    
    public Settings() {}
    
    @Deprecated
    public String getTrackingId()
    {
      return null;
    }
    
    @Deprecated
    public boolean isGoogleAnalyticsEnabled()
    {
      return false;
    }
    
    @Deprecated
    public Settings setGoogleAnalyticsEnabled(boolean paramBoolean)
    {
      return this;
    }
    
    @Deprecated
    public Settings setTrackingId(String paramString)
    {
      return this;
    }
    
    zzfc zzbs()
    {
      return zzrM;
    }
  }
}
