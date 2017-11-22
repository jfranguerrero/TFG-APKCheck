package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzmb
public class zzlh
  implements InAppPurchase
{
  private final zzky zzPa;
  
  public zzlh(zzky paramZzky)
  {
    zzPa = paramZzky;
  }
  
  public String getProductId()
  {
    try
    {
      String str = zzPa.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward getProductId to InAppPurchase", localRemoteException);
    }
    return null;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      zzPa.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
    }
  }
  
  public void recordResolution(int paramInt)
  {
    try
    {
      zzPa.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward recordResolution to InAppPurchase", localRemoteException);
    }
  }
}
