package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;

public class zzaav
{
  private final Object zzaBr;
  
  public zzaav(Activity paramActivity)
  {
    zzac.zzb(paramActivity, "Activity must not be null");
    if ((zzs.zzyx()) || ((paramActivity instanceof FragmentActivity))) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
      zzaBr = paramActivity;
      return;
    }
  }
  
  public boolean zzwl()
  {
    return zzaBr instanceof FragmentActivity;
  }
  
  public Activity zzwm()
  {
    return (Activity)zzaBr;
  }
  
  public FragmentActivity zzwn()
  {
    return (FragmentActivity)zzaBr;
  }
}
