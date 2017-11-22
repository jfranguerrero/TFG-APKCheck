package com.google.android.gms.ads;

import com.google.android.gms.internal.zzmb;

@zzmb
public final class VideoOptions
{
  private final boolean zzrQ;
  
  private VideoOptions(Builder paramBuilder)
  {
    zzrQ = Builder.zza(paramBuilder);
  }
  
  public boolean getStartMuted()
  {
    return zzrQ;
  }
  
  public static final class Builder
  {
    private boolean zzrQ = false;
    
    public Builder() {}
    
    public VideoOptions build()
    {
      return new VideoOptions(this, null);
    }
    
    public Builder setStartMuted(boolean paramBoolean)
    {
      zzrQ = paramBoolean;
      return this;
    }
  }
}
