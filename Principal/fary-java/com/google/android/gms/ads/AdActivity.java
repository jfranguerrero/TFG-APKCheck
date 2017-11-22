package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzpy;

public class AdActivity
  extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
  public static final String SIMPLE_CLASS_NAME = "AdActivity";
  private zzkr zzrA;
  
  public AdActivity() {}
  
  private void zzbp()
  {
    if (zzrA != null) {}
    try
    {
      zzrA.zzbp();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward setContentViewSet to ad overlay:", localRemoteException);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      zzrA.onActivityResult(paramInt1, paramInt2, paramIntent);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onActivityResult to ad overlay:", localException);
      }
    }
  }
  
  public void onBackPressed()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    try
    {
      if (zzrA != null) {
        bool1 = zzrA.zzhk();
      }
      if (bool1) {
        super.onBackPressed();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onBackPressed to ad overlay:", localRemoteException);
        bool1 = bool2;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      zzrA.zzn(zze.zzA(paramConfiguration));
      return;
    }
    catch (RemoteException paramConfiguration)
    {
      zzpy.zzc("Failed to wrap configuration.", paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzrA = zzeh.zzeP().zzc(this);
    if (zzrA == null)
    {
      zzpy.zzbe("Could not create ad overlay.");
      finish();
      return;
    }
    try
    {
      zzrA.onCreate(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      zzpy.zzc("Could not forward onCreate to ad overlay:", paramBundle);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (zzrA != null) {
        zzrA.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onDestroy to ad overlay:", localRemoteException);
      }
    }
  }
  
  protected void onPause()
  {
    try
    {
      if (zzrA != null) {
        zzrA.onPause();
      }
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onPause to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (zzrA != null) {
        zzrA.onRestart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward onRestart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if (zzrA != null) {
        zzrA.onResume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward onResume to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (zzrA != null) {
        zzrA.onSaveInstanceState(paramBundle);
      }
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    try
    {
      if (zzrA != null) {
        zzrA.onStart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzc("Could not forward onStart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onStop()
  {
    try
    {
      if (zzrA != null) {
        zzrA.onStop();
      }
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpy.zzc("Could not forward onStop to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    zzbp();
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    zzbp();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    zzbp();
  }
}
