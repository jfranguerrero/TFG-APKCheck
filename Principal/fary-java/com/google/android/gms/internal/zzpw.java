package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public final class zzpw
{
  private final View mView;
  private Activity zzXO;
  private boolean zzXP;
  private boolean zzXQ;
  private boolean zzXR;
  private ViewTreeObserver.OnGlobalLayoutListener zzXS;
  private ViewTreeObserver.OnScrollChangedListener zzXT;
  
  public zzpw(Activity paramActivity, View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    zzXO = paramActivity;
    mView = paramView;
    zzXS = paramOnGlobalLayoutListener;
    zzXT = paramOnScrollChangedListener;
  }
  
  private void zzkG()
  {
    if (!zzXP)
    {
      if (zzXS != null)
      {
        if (zzXO != null) {
          zzv.zzcJ().zza(zzXO, zzXS);
        }
        zzv.zzdh().zza(mView, zzXS);
      }
      if (zzXT != null)
      {
        if (zzXO != null) {
          zzv.zzcJ().zza(zzXO, zzXT);
        }
        zzv.zzdh().zza(mView, zzXT);
      }
      zzXP = true;
    }
  }
  
  private void zzkH()
  {
    if (zzXO == null) {}
    while (!zzXP) {
      return;
    }
    if ((zzXS != null) && (zzXO != null)) {
      zzv.zzcL().zzb(zzXO, zzXS);
    }
    if ((zzXT != null) && (zzXO != null)) {
      zzv.zzcJ().zzb(zzXO, zzXT);
    }
    zzXP = false;
  }
  
  public void onAttachedToWindow()
  {
    zzXQ = true;
    if (zzXR) {
      zzkG();
    }
  }
  
  public void onDetachedFromWindow()
  {
    zzXQ = false;
    zzkH();
  }
  
  public void zzkE()
  {
    zzXR = true;
    if (zzXQ) {
      zzkG();
    }
  }
  
  public void zzkF()
  {
    zzXR = false;
    zzkH();
  }
  
  public void zzl(Activity paramActivity)
  {
    zzXO = paramActivity;
  }
}
