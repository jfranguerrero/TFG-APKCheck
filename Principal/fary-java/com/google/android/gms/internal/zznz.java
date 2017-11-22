package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zznz
  implements RewardedVideoAd
{
  private final Context mContext;
  private final zznr zzUK;
  private RewardedVideoAdListener zzcI;
  private final Object zzrN = new Object();
  
  public zznz(Context paramContext, zznr paramZznr)
  {
    zzUK = paramZznr;
    mContext = paramContext;
  }
  
  public void destroy()
  {
    destroy(null);
  }
  
  public void destroy(Context paramContext)
  {
    synchronized (zzrN)
    {
      if (zzUK == null) {
        return;
      }
    }
    try
    {
      zzUK.zzh(zze.zzA(paramContext));
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (RemoteException paramContext)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward destroy to RewardedVideoAd", paramContext);
      }
    }
  }
  
  public RewardedVideoAdListener getRewardedVideoAdListener()
  {
    synchronized (zzrN)
    {
      RewardedVideoAdListener localRewardedVideoAdListener = zzcI;
      return localRewardedVideoAdListener;
    }
  }
  
  public String getUserId()
  {
    zzpy.zzbe("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
    return null;
  }
  
  public boolean isLoaded()
  {
    boolean bool;
    synchronized (zzrN)
    {
      if (zzUK == null) {
        return false;
      }
    }
    return false;
  }
  
  public void loadAd(String paramString, AdRequest paramAdRequest)
  {
    synchronized (zzrN)
    {
      if (zzUK == null) {
        return;
      }
    }
    try
    {
      zzUK.zza(zzeb.zzey().zza(mContext, paramAdRequest.zzbq(), paramString));
      return;
      paramString = finally;
      throw paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward loadAd to RewardedVideoAd", paramString);
      }
    }
  }
  
  public void pause()
  {
    pause(null);
  }
  
  public void pause(Context paramContext)
  {
    synchronized (zzrN)
    {
      if (zzUK == null) {
        return;
      }
    }
    try
    {
      zzUK.zzf(zze.zzA(paramContext));
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (RemoteException paramContext)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward pause to RewardedVideoAd", paramContext);
      }
    }
  }
  
  public void resume()
  {
    resume(null);
  }
  
  public void resume(Context paramContext)
  {
    synchronized (zzrN)
    {
      if (zzUK == null) {
        return;
      }
    }
    try
    {
      zzUK.zzg(zze.zzA(paramContext));
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (RemoteException paramContext)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward resume to RewardedVideoAd", paramContext);
      }
    }
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    synchronized (zzrN)
    {
      zzcI = paramRewardedVideoAdListener;
      zznr localZznr = zzUK;
      if (localZznr != null) {}
      try
      {
        zzUK.zza(new zznw(paramRewardedVideoAdListener));
        return;
      }
      catch (RemoteException paramRewardedVideoAdListener)
      {
        for (;;)
        {
          zzpy.zzc("Could not forward setRewardedVideoAdListener to RewardedVideoAd", paramRewardedVideoAdListener);
        }
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    zzpy.zzbe("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
  }
  
  public void show()
  {
    synchronized (zzrN)
    {
      if (zzUK == null) {
        return;
      }
    }
    try
    {
      zzUK.show();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward show to RewardedVideoAd", localRemoteException);
      }
    }
  }
}
