package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzgh
  implements CustomRenderedAd
{
  private final zzgi zzFz;
  
  public zzgh(zzgi paramZzgi)
  {
    zzFz = paramZzgi;
  }
  
  public String getBaseUrl()
  {
    try
    {
      String str = zzFz.zzfB();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not delegate getBaseURL to CustomRenderedAd", localRemoteException);
    }
    return null;
  }
  
  public String getContent()
  {
    try
    {
      String str = zzFz.getContent();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not delegate getContent to CustomRenderedAd", localRemoteException);
    }
    return null;
  }
  
  public void onAdRendered(View paramView)
  {
    try
    {
      zzgi localZzgi = zzFz;
      if (paramView != null) {}
      for (paramView = zze.zzA(paramView);; paramView = null)
      {
        localZzgi.zzi(paramView);
        return;
      }
      return;
    }
    catch (RemoteException paramView)
    {
      zzpy.zzc("Could not delegate onAdRendered to CustomRenderedAd", paramView);
    }
  }
  
  public void recordClick()
  {
    try
    {
      zzFz.recordClick();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not delegate recordClick to CustomRenderedAd", localRemoteException);
    }
  }
  
  public void recordImpression()
  {
    try
    {
      zzFz.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not delegate recordImpression to CustomRenderedAd", localRemoteException);
    }
  }
}
