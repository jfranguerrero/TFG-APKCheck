package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzhe
  extends NativeAppInstallAd
{
  private final zzhd zzGS;
  private final List<NativeAd.Image> zzGT = new ArrayList();
  private final zzha zzGU;
  private VideoController zzzW = new VideoController();
  
  public zzhe(zzhd paramZzhd)
  {
    zzGS = paramZzhd;
    try
    {
      paramZzhd = zzGS.getImages();
      if (paramZzhd != null)
      {
        paramZzhd = paramZzhd.iterator();
        while (paramZzhd.hasNext())
        {
          zzgz localZzgz = zze(paramZzhd.next());
          if (localZzgz != null) {
            zzGT.add(new zzha(localZzgz));
          }
        }
      }
      try
      {
        paramZzhd = zzGS.zzfL();
        if (paramZzhd == null) {
          break label140;
        }
        paramZzhd = new zzha(paramZzhd);
      }
      catch (RemoteException paramZzhd)
      {
        for (;;)
        {
          zzpy.zzb("Failed to get icon.", paramZzhd);
          paramZzhd = null;
        }
      }
    }
    catch (RemoteException paramZzhd)
    {
      zzpy.zzb("Failed to get image.", paramZzhd);
    }
    zzGU = paramZzhd;
  }
  
  public void destroy()
  {
    try
    {
      zzGS.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to destroy", localRemoteException);
    }
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = zzGS.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get body.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getCallToAction()
  {
    try
    {
      String str = zzGS.getCallToAction();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get call to action.", localRemoteException);
    }
    return null;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = zzGS.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = zzGS.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getIcon()
  {
    return zzGU;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return zzGT;
  }
  
  public CharSequence getPrice()
  {
    try
    {
      String str = zzGS.getPrice();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get price.", localRemoteException);
    }
    return null;
  }
  
  public Double getStarRating()
  {
    try
    {
      double d = zzGS.getStarRating();
      if (d == -1.0D) {
        return null;
      }
      return Double.valueOf(d);
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get star rating.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getStore()
  {
    try
    {
      String str = zzGS.getStore();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get store", localRemoteException);
    }
    return null;
  }
  
  public VideoController getVideoController()
  {
    try
    {
      if (zzGS.zzbG() != null) {
        zzzW.zza(zzGS.zzbG());
      }
      return zzzW;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzb("Exception occurred while getting video controller", localRemoteException);
      }
    }
  }
  
  zzgz zze(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzgz.zza.zzB((IBinder)paramObject);
    }
    return null;
  }
  
  protected zzd zzfM()
  {
    try
    {
      zzd localZzd = zzGS.zzfM();
      return localZzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}
