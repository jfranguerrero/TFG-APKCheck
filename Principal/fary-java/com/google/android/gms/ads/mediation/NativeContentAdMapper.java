package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper
  extends NativeAdMapper
{
  private String zzFS;
  private List<NativeAd.Image> zzFT;
  private String zzFU;
  private String zzFW;
  private String zzGf;
  private NativeAd.Image zzZP;
  
  public NativeContentAdMapper() {}
  
  public final String getAdvertiser()
  {
    return zzGf;
  }
  
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
  
  public final List<NativeAd.Image> getImages()
  {
    return zzFT;
  }
  
  public final NativeAd.Image getLogo()
  {
    return zzZP;
  }
  
  public final void setAdvertiser(String paramString)
  {
    zzGf = paramString;
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
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    zzFT = paramList;
  }
  
  public final void setLogo(NativeAd.Image paramImage)
  {
    zzZP = paramImage;
  }
}
