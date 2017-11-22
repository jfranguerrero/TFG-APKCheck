package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzkb
  extends zzjw.zza
{
  private final NativeAppInstallAdMapper zzKY;
  
  public zzkb(NativeAppInstallAdMapper paramNativeAppInstallAdMapper)
  {
    zzKY = paramNativeAppInstallAdMapper;
  }
  
  public String getBody()
  {
    return zzKY.getBody();
  }
  
  public String getCallToAction()
  {
    return zzKY.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return zzKY.getExtras();
  }
  
  public String getHeadline()
  {
    return zzKY.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = zzKY.getImages();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)((Iterator)localObject).next();
        localArrayList.add(new zzgo(localImage.getDrawable(), localImage.getUri(), localImage.getScale()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public boolean getOverrideClickHandling()
  {
    return zzKY.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return zzKY.getOverrideImpressionRecording();
  }
  
  public String getPrice()
  {
    return zzKY.getPrice();
  }
  
  public double getStarRating()
  {
    return zzKY.getStarRating();
  }
  
  public String getStore()
  {
    return zzKY.getStore();
  }
  
  public void recordImpression()
  {
    zzKY.recordImpression();
  }
  
  public zzew zzbG()
  {
    if (zzKY.getVideoController() != null) {
      return zzKY.getVideoController().zzbt();
    }
    return null;
  }
  
  public zzgz zzfL()
  {
    NativeAd.Image localImage = zzKY.getIcon();
    if (localImage != null) {
      return new zzgo(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
  
  public void zzk(zzd paramZzd)
  {
    zzKY.handleClick((View)zze.zzE(paramZzd));
  }
  
  public void zzl(zzd paramZzd)
  {
    zzKY.trackView((View)zze.zzE(paramZzd));
  }
  
  public void zzm(zzd paramZzd)
  {
    zzKY.untrackView((View)zze.zzE(paramZzd));
  }
}
