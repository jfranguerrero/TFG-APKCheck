package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class zzzw
  extends zzaaw
  implements DialogInterface.OnCancelListener
{
  protected boolean mStarted;
  protected final GoogleApiAvailability zzaxX;
  protected boolean zzayG;
  private ConnectionResult zzayH;
  private int zzayI = -1;
  private final Handler zzayJ = new Handler(Looper.getMainLooper());
  
  protected zzzw(zzaax paramZzaax)
  {
    this(paramZzaax, GoogleApiAvailability.getInstance());
  }
  
  zzzw(zzaax paramZzaax, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramZzaax);
    zzaxX = paramGoogleApiAvailability;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramInt1 != 0)
      {
        zzva();
        return;
      }
      break;
    case 2: 
      label30:
      j = zzaxX.isGooglePlayServicesAvailable(getActivity());
      if (j != 0) {}
      break;
    }
    for (paramInt2 = i;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (zzayH.getErrorCode() != 18) {
        break label30;
      }
      paramInt1 = paramInt2;
      if (j != 18) {
        break label30;
      }
      return;
      paramInt1 = j;
      if (paramInt2 == -1) {
        break label30;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (paramIntent != null) {}
      for (paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);; paramInt1 = 13)
      {
        zzayH = new ConnectionResult(paramInt1, null);
        break;
        zza(zzayH, zzayI);
        return;
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(new ConnectionResult(13, null), zzayI);
    zzva();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      zzayG = paramBundle.getBoolean("resolving_error", false);
      if (zzayG)
      {
        zzayI = paramBundle.getInt("failed_client_id", -1);
        zzayH = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", zzayG);
    if (zzayG)
    {
      paramBundle.putInt("failed_client_id", zzayI);
      paramBundle.putInt("failed_status", zzayH.getErrorCode());
      paramBundle.putParcelable("failed_resolution", zzayH.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    mStarted = true;
  }
  
  public void onStop()
  {
    super.onStop();
    mStarted = false;
  }
  
  protected abstract void zza(ConnectionResult paramConnectionResult, int paramInt);
  
  public void zzb(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zzayG)
    {
      zzayG = true;
      zzayI = paramInt;
      zzayH = paramConnectionResult;
      zzayJ.post(new zza(null));
    }
  }
  
  protected abstract void zzuW();
  
  protected void zzva()
  {
    zzayI = -1;
    zzayG = false;
    zzayH = null;
    zzuW();
  }
  
  private class zza
    implements Runnable
  {
    private zza() {}
    
    @MainThread
    public void run()
    {
      if (!mStarted) {
        return;
      }
      if (zzzw.zza(zzzw.this).hasResolution())
      {
        zzaBs.startActivityForResult(GoogleApiActivity.zzb(getActivity(), zzzw.zza(zzzw.this).getResolution(), zzzw.zzb(zzzw.this), false), 1);
        return;
      }
      if (zzaxX.isUserResolvableError(zzzw.zza(zzzw.this).getErrorCode()))
      {
        zzaxX.zza(getActivity(), zzaBs, zzzw.zza(zzzw.this).getErrorCode(), 2, zzzw.this);
        return;
      }
      if (zzzw.zza(zzzw.this).getErrorCode() == 18)
      {
        final Dialog localDialog = zzaxX.zza(getActivity(), zzzw.this);
        zzaxX.zza(getActivity().getApplicationContext(), new zzaar.zza()
        {
          public void zzvb()
          {
            zzva();
            if (localDialog.isShowing()) {
              localDialog.dismiss();
            }
          }
        });
        return;
      }
      zza(zzzw.zza(zzzw.this), zzzw.zzb(zzzw.this));
    }
  }
}
