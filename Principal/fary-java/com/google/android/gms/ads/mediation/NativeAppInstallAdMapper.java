package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper
  extends NativeAdMapper
{
  private String zzFS;
  private List<NativeAd.Image> zzFT;
  private String zzFU;
  private String zzFW;
  private double zzFX;
  private String zzFY;
  private String zzFZ;
  private NativeAd.Image zzZO;
  private VideoController zzzW;
  
  public NativeAppInstallAdMapper() {}
  
  public final String getBody()
  {
    return zzFU;
  }
  
  public final String getCallToAction()
  {
    return zzFW;
  }
  
  public final String getHeadline()
  {
    return zzFS;
  }
  
  public final NativeAd.Image getIcon()
  {
    return zzZO;
  }
  
  public final List<NativeAd.Image> getImages()
  {
    return zzFT;
  }
  
  public final String getPrice()
  {
    return zzFZ;
  }
  
  public final double getStarRating()
  {
    return zzFX;
  }
  
  public final String getStore()
  {
    return zzFY;
  }
  
  public final VideoController getVideoController()
  {
    return zzzW;
  }
  
  public final void setBody(String paramString)
  {
    zzFU = paramString;
  }
  
  public final void setCallToAction(String paramString)
  {
    zzFW = paramString;
  }
  
  public final void setHeadline(String paramString)
  {
    zzFS = paramString;
  }
  
  public final void setIcon(NativeAd.Image paramImage)
  {
    zzZO = paramImage;
  }
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    zzFT = paramList;
  }
  
  public final void setPrice(String paramString)
  {
    zzFZ = paramString;
  }
  
  public final void setStarRating(double paramDouble)
  {
    zzFX = paramDouble;
  }
  
  public final void setStore(String paramString)
  {
    zzFY = paramString;
  }
  
  public final void zza(VideoController paramVideoController)
  {
    zzzW = paramVideoController;
  }
}
