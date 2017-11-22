package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzmb;

@zzmb
public final class NativeExpressAdView
  extends BaseAdView
{
  public NativeExpressAdView(Context paramContext)
  {
    super(paramContext, 1);
  }
  
  public NativeExpressAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 1);
  }
  
  public NativeExpressAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 1);
  }
  
  public VideoController getVideoController()
  {
    return zzrJ.getVideoController();
  }
  
  public VideoOptions getVideoOptions()
  {
    return zzrJ.getVideoOptions();
  }
  
  public void setVideoOptions(VideoOptions paramVideoOptions)
  {
    zzrJ.setVideoOptions(paramVideoOptions);
  }
}
