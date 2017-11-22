package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public abstract class NativeAd
{
  public NativeAd() {}
  
  protected abstract Object zzbv();
  
  public static abstract class Image
  {
    public Image() {}
    
    public abstract Drawable getDrawable();
    
    public abstract double getScale();
    
    public abstract Uri getUri();
  }
}
