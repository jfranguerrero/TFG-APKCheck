package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzhg
  extends NativeContentAd
{
  private final List<NativeAd.Image> zzGT = new ArrayList();
  private final zzhf zzGV;
  private final zzha zzGW;
  
  public zzhg(zzhf paramZzhf)
  {
    zzGV = paramZzhf;
    try
    {
      paramZzhf = zzGV.getImages();
      if (paramZzhf != null)
      {
        paramZzhf = paramZzhf.iterator();
        while (paramZzhf.hasNext())
        {
          zzgz localZzgz = zze(paramZzhf.next());
          if (localZzgz != null) {
            zzGT.add(new zzha(localZzgz));
          }
        }
      }
      try
      {
        paramZzhf = zzGV.zzfQ();
        if (paramZzhf == null) {
          break label129;
        }
        paramZzhf = new zzha(paramZzhf);
      }
      catch (RemoteException paramZzhf)
      {
        for (;;)
        {
          zzpy.zzb("Failed to get icon.", paramZzhf);
          paramZzhf = null;
        }
      }
    }
    catch (RemoteException paramZzhf)
    {
      zzpy.zzb("Failed to get image.", paramZzhf);
    }
    zzGW = paramZzhf;
  }
  
  public void destroy()
  {
    try
    {
      zzGV.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to destroy", localRemoteException);
    }
  }
  
  public CharSequence getAdvertiser()
  {
    try
    {
      String str = zzGV.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get attribution.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = zzGV.getBody();
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
      String str = zzGV.getCallToAction();
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
      Bundle localBundle = zzGV.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = zzGV.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return zzGT;
  }
  
  public NativeAd.Image getLogo()
  {
    return zzGW;
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
      zzd localZzd = zzGV.zzfM();
      return localZzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}
