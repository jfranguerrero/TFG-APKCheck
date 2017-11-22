package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.VideoController;
import java.util.List;

public abstract class NativeAppInstallAd
  extends NativeAd
{
  public NativeAppInstallAd() {}
  
  public abstract void destroy();
  
  public abstract CharSequence getBody();
  
  public abstract CharSequence getCallToAction();
  
  public abstract Bundle getExtras();
  
  public abstract CharSequence getHeadline();
  
  public abstract NativeAd.Image getIcon();
  
  public abstract List<NativeAd.Image> getImages();
  
  public abstract CharSequence getPrice();
  
  public abstract Double getStarRating();
  
  public abstract CharSequence getStore();
  
  public abstract VideoController getVideoController();
  
  public static abstract interface OnAppInstallAdLoadedListener
  {
    public abstract void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd);
  }
}
