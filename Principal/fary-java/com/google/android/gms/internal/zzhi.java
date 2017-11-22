package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

@zzmb
public class zzhi
  implements NativeCustomTemplateAd
{
  private final zzhh zzGX;
  
  public zzhi(zzhh paramZzhh)
  {
    zzGX = paramZzhh;
  }
  
  public List<String> getAvailableAssetNames()
  {
    try
    {
      List localList = zzGX.getAvailableAssetNames();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get available asset names.", localRemoteException);
    }
    return null;
  }
  
  public String getCustomTemplateId()
  {
    try
    {
      String str = zzGX.getCustomTemplateId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to get custom template id.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getImage(String paramString)
  {
    try
    {
      paramString = zzGX.zzZ(paramString);
      if (paramString != null)
      {
        paramString = new zzha(paramString);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      zzpy.zzb("Failed to get image.", paramString);
    }
    return null;
  }
  
  public CharSequence getText(String paramString)
  {
    try
    {
      paramString = zzGX.zzY(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzpy.zzb("Failed to get string.", paramString);
    }
    return null;
  }
  
  public void performClick(String paramString)
  {
    try
    {
      zzGX.performClick(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      zzpy.zzb("Failed to perform click.", paramString);
    }
  }
  
  public void recordImpression()
  {
    try
    {
      zzGX.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Failed to record impression.", localRemoteException);
    }
  }
}
