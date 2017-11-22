package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.internal.zzmb;

@zzmb
@TargetApi(14)
public abstract class zzj
  extends TextureView
  implements zzab.zza
{
  protected final zzw zzNj = new zzw();
  protected final zzab zzNk = new zzab(paramContext, this);
  
  public zzj(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract void stop();
  
  public abstract void zza(float paramFloat1, float paramFloat2);
  
  public abstract void zza(zzi paramZzi);
  
  public void zzb(float paramFloat)
  {
    zzNk.zzb(paramFloat);
    zzhh();
  }
  
  public void zzhE()
  {
    zzNk.setMuted(true);
    zzhh();
  }
  
  public void zzhF()
  {
    zzNk.setMuted(false);
    zzhh();
  }
  
  public abstract String zzhd();
  
  public abstract void zzhh();
}
