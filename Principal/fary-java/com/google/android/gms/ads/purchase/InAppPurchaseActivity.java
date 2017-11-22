package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzpy;

public class InAppPurchaseActivity
  extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
  public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
  private zzla zzZW;
  
  public InAppPurchaseActivity() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      if (zzZW != null) {
        zzZW.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onActivityResult to in-app purchase manager:", localRemoteException);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzZW = zzeh.zzeP().zzb(this);
    if (zzZW == null)
    {
      zzpy.zzbe("Could not create in-app purchase manager.");
      finish();
      return;
    }
    try
    {
      zzZW.onCreate();
      return;
    }
    catch (RemoteException paramBundle)
    {
      zzpy.zzc("Could not forward onCreate to in-app purchase manager:", paramBundle);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (zzZW != null) {
        zzZW.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onDestroy to in-app purchase manager:", localRemoteException);
      }
    }
  }
}
