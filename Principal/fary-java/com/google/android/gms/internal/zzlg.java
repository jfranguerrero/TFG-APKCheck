package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzmb
public class zzlg
  implements InAppPurchaseResult
{
  private final zzlc zzPm;
  
  public zzlg(zzlc paramZzlc)
  {
    zzPm = paramZzlc;
  }
  
  public void finishPurchase()
  {
    try
    {
      zzPm.finishPurchase();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward finishPurchase to InAppPurchaseResult", localRemoteException);
    }
  }
  
  public String getProductId()
  {
    try
    {
      String str = zzPm.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward getProductId to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public Intent getPurchaseData()
  {
    try
    {
      Intent localIntent = zzPm.getPurchaseData();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public int getResultCode()
  {
    try
    {
      int i = zzPm.getResultCode();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return 0;
  }
  
  public boolean isVerified()
  {
    try
    {
      boolean bool = zzPm.isVerified();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward isVerified to InAppPurchaseResult", localRemoteException);
    }
    return false;
  }
}
