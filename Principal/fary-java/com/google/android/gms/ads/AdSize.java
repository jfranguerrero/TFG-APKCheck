package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzpx;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
  public static final AdSize SMART_BANNER;
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final int zzrG;
  private final int zzrH;
  private final String zzrI;
  
  static
  {
    SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  }
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1) && (paramInt1 != -3)) {
      throw new IllegalArgumentException(37 + "Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2) && (paramInt2 != -4)) {
      throw new IllegalArgumentException(38 + "Invalid height for AdSize: " + paramInt2);
    }
    zzrG = paramInt1;
    zzrH = paramInt2;
    zzrI = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AdSize)) {
        return false;
      }
      paramObject = (AdSize)paramObject;
    } while ((zzrG == zzrG) && (zzrH == zzrH) && (zzrI.equals(zzrI)));
    return false;
  }
  
  public int getHeight()
  {
    return zzrH;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    switch (zzrH)
    {
    default: 
      return zzeh.zzeO().zzb(paramContext, zzrH);
    case -2: 
      return zzec.zzb(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public int getWidth()
  {
    return zzrG;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    switch (zzrG)
    {
    case -2: 
    default: 
      return zzeh.zzeO().zzb(paramContext, zzrG);
    case -1: 
      return zzec.zza(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public int hashCode()
  {
    return zzrI.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return zzrH == -2;
  }
  
  public boolean isFluid()
  {
    return (zzrG == -3) && (zzrH == -4);
  }
  
  public boolean isFullWidth()
  {
    return zzrG == -1;
  }
  
  public String toString()
  {
    return zzrI;
  }
}
