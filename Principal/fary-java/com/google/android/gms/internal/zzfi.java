package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public class zzfi
  extends zznr.zza
{
  private zznt zzAp;
  
  public zzfi() {}
  
  public void destroy()
    throws RemoteException
  {}
  
  public boolean isLoaded()
    throws RemoteException
  {
    return false;
  }
  
  public void pause()
    throws RemoteException
  {}
  
  public void resume()
    throws RemoteException
  {}
  
  public void setUserId(String paramString)
    throws RemoteException
  {}
  
  public void show()
    throws RemoteException
  {}
  
  public void zza(zznt paramZznt)
    throws RemoteException
  {
    zzAp = paramZznt;
  }
  
  public void zza(zznx paramZznx)
    throws RemoteException
  {
    zzpy.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
    zzpx.zzXU.post(new Runnable()
    {
      public void run()
      {
        if (zzfi.zza(zzfi.this) != null) {}
        try
        {
          zzfi.zza(zzfi.this).onRewardedVideoAdFailedToLoad(1);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzpy.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", localRemoteException);
        }
      }
    });
  }
  
  public void zzf(zzd paramZzd)
    throws RemoteException
  {}
  
  public void zzg(zzd paramZzd)
    throws RemoteException
  {}
  
  public void zzh(zzd paramZzd)
    throws RemoteException
  {}
}
