package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzkc
  extends zzjx.zza
{
  private final NativeContentAdMapper zzKZ;
  
  public zzkc(NativeContentAdMapper paramNativeContentAdMapper)
  {
    zzKZ = paramNativeContentAdMapper;
  }
  
  public String getAdvertiser()
  {
    return zzKZ.getAdvertiser();
  }
  
  public String getBody()
  {
    return zzKZ.getBody();
  }
  
  public String getCallToAction()
  {
    return zzKZ.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return zzKZ.getExtras();
  }
  
  public String getHeadline()
  {
    return zzKZ.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = zzKZ.getImages();
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
    return zzKZ.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return zzKZ.getOverrideImpressionRecording();
  }
  
  public void recordImpression()
  {
    zzKZ.recordImpression();
  }
  
  public zzgz zzfQ()
  {
    NativeAd.Image localImage = zzKZ.getLogo();
    if (localImage != null) {
      return new zzgo(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
  
  public void zzk(zzd paramZzd)
  {
    zzKZ.handleClick((View)zze.zzE(paramZzd));
  }
  
  public void zzl(zzd paramZzd)
  {
    zzKZ.trackView((View)zze.zzE(paramZzd));
  }
  
  public void zzm(zzd paramZzd)
  {
    zzKZ.untrackView((View)zze.zzE(paramZzd));
  }
}
