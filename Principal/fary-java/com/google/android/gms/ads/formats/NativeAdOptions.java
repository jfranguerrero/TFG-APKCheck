package com.google.android.gms.ads.formats;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzmb;
import java.lang.annotation.Annotation;

@zzmb
public final class NativeAdOptions
{
  public static final int ADCHOICES_BOTTOM_LEFT = 3;
  public static final int ADCHOICES_BOTTOM_RIGHT = 2;
  public static final int ADCHOICES_TOP_LEFT = 0;
  public static final int ADCHOICES_TOP_RIGHT = 1;
  public static final int ORIENTATION_ANY = 0;
  public static final int ORIENTATION_LANDSCAPE = 2;
  public static final int ORIENTATION_PORTRAIT = 1;
  private final boolean zzrX;
  private final int zzrY;
  private final boolean zzrZ;
  private final int zzsa;
  private final VideoOptions zzsb;
  
  private NativeAdOptions(Builder paramBuilder)
  {
    zzrX = Builder.zza(paramBuilder);
    zzrY = Builder.zzb(paramBuilder);
    zzrZ = Builder.zzc(paramBuilder);
    zzsa = Builder.zzd(paramBuilder);
    zzsb = Builder.zze(paramBuilder);
  }
  
  public int getAdChoicesPlacement()
  {
    return zzsa;
  }
  
  public int getImageOrientation()
  {
    return zzrY;
  }
  
  @Nullable
  public VideoOptions getVideoOptions()
  {
    return zzsb;
  }
  
  public boolean shouldRequestMultipleImages()
  {
    return zzrZ;
  }
  
  public boolean shouldReturnUrlsForImageAssets()
  {
    return zzrX;
  }
  
  public static @interface AdChoicesPlacement {}
  
  public static final class Builder
  {
    private boolean zzrX = false;
    private int zzrY = 0;
    private boolean zzrZ = false;
    private int zzsa = 1;
    private VideoOptions zzsb;
    
    public Builder() {}
    
    public NativeAdOptions build()
    {
      return new NativeAdOptions(this, null);
    }
    
    public Builder setAdChoicesPlacement(@NativeAdOptions.AdChoicesPlacement int paramInt)
    {
      zzsa = paramInt;
      return this;
    }
    
    public Builder setImageOrientation(int paramInt)
    {
      zzrY = paramInt;
      return this;
    }
    
    public Builder setRequestMultipleImages(boolean paramBoolean)
    {
      zzrZ = paramBoolean;
      return this;
    }
    
    public Builder setReturnUrlsForImageAssets(boolean paramBoolean)
    {
      zzrX = paramBoolean;
      return this;
    }
    
    public Builder setVideoOptions(VideoOptions paramVideoOptions)
    {
      zzsb = paramVideoOptions;
      return this;
    }
  }
}
