package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzaax;

public abstract class zzi
  implements DialogInterface.OnClickListener
{
  public zzi() {}
  
  public static zzi zza(final Activity paramActivity, Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzxm()
      {
        if (zzi.this != null) {
          paramActivity.startActivityForResult(zzi.this, paramInt);
        }
      }
    };
  }
  
  public static zzi zza(@NonNull final Fragment paramFragment, Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzxm()
      {
        if (zzi.this != null) {
          paramFragment.startActivityForResult(zzi.this, paramInt);
        }
      }
    };
  }
  
  public static zzi zza(@NonNull final zzaax paramZzaax, Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      @TargetApi(11)
      public void zzxm()
      {
        if (zzi.this != null) {
          paramZzaax.startActivityForResult(zzi.this, paramInt);
        }
      }
    };
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      zzxm();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("DialogRedirect", "Failed to start resolution intent", localActivityNotFoundException);
      return;
    }
    finally
    {
      paramDialogInterface.dismiss();
    }
  }
  
  protected abstract void zzxm();
}
