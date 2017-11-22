package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.google.android.gms.internal.zzmb;

@zzmb
@TargetApi(14)
public class zzab
  implements AudioManager.OnAudioFocusChangeListener
{
  private final AudioManager mAudioManager;
  private boolean zzNq;
  private final zza zzOB;
  private boolean zzOC;
  private boolean zzOD;
  private float zzOE = 1.0F;
  
  public zzab(Context paramContext, zza paramZza)
  {
    mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    zzOB = paramZza;
  }
  
  private void zzif()
  {
    int i;
    if ((zzNq) && (!zzOD) && (zzOE > 0.0F))
    {
      i = 1;
      if ((i == 0) || (zzOC)) {
        break label55;
      }
      zzig();
      zzOB.zzhh();
    }
    label55:
    while ((i != 0) || (!zzOC))
    {
      return;
      i = 0;
      break;
    }
    zzih();
    zzOB.zzhh();
  }
  
  private void zzig()
  {
    boolean bool = true;
    if ((mAudioManager == null) || (zzOC)) {
      return;
    }
    if (mAudioManager.requestAudioFocus(this, 3, 2) == 1) {}
    for (;;)
    {
      zzOC = bool;
      return;
      bool = false;
    }
  }
  
  private void zzih()
  {
    if ((mAudioManager == null) || (!zzOC)) {
      return;
    }
    if (mAudioManager.abandonAudioFocus(this) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzOC = bool;
      return;
    }
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzOC = bool;
      zzOB.zzhh();
      return;
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    zzOD = paramBoolean;
    zzif();
  }
  
  public void zzb(float paramFloat)
  {
    zzOE = paramFloat;
    zzif();
  }
  
  public void zzib()
  {
    zzNq = true;
    zzif();
  }
  
  public void zzic()
  {
    zzNq = false;
    zzif();
  }
  
  public float zzie()
  {
    if (zzOD) {}
    for (float f = 0.0F; zzOC; f = zzOE) {
      return f;
    }
    return 0.0F;
  }
  
  static abstract interface zza
  {
    public abstract void zzhh();
  }
}
