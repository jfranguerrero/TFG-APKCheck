package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzmb
public class zznu
  implements RewardItem
{
  private final zznq zzUJ;
  
  public zznu(zznq paramZznq)
  {
    zzUJ = paramZznq;
  }
  
  public int getAmount()
  {
    if (zzUJ == null) {
      return 0;
    }
    try
    {
      int i = zzUJ.getAmount();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
  
  public String getType()
  {
    if (zzUJ == null) {
      return null;
    }
    try
    {
      String str = zzUJ.getType();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
}
