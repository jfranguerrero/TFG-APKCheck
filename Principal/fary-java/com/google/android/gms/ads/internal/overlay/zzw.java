package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;
import java.util.concurrent.TimeUnit;

@zzmb
@TargetApi(14)
public class zzw
{
  private final long zzNC = TimeUnit.MILLISECONDS.toNanos(((Long)zzfx.zzBs.get()).longValue());
  private long zzND;
  private boolean zzNE = true;
  
  zzw() {}
  
  public void zza(SurfaceTexture paramSurfaceTexture, final zzi paramZzi)
  {
    if (paramZzi == null) {}
    long l;
    do
    {
      return;
      l = paramSurfaceTexture.getTimestamp();
    } while ((!zzNE) && (Math.abs(l - zzND) < zzNC));
    zzNE = false;
    zzND = l;
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        paramZzi.zzhD();
      }
    });
  }
  
  public void zzhA()
  {
    zzNE = true;
  }
}
