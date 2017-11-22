package com.google.android.gms.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfm;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpy;

@zzmb
public final class VideoController
{
  private final Object zzrN = new Object();
  @Nullable
  private zzew zzrO;
  @Nullable
  private VideoLifecycleCallbacks zzrP;
  
  public VideoController() {}
  
  public float getAspectRatio()
  {
    float f;
    synchronized (zzrN)
    {
      if (zzrO == null) {
        return 0.0F;
      }
    }
    return 0.0F;
  }
  
  @Nullable
  public VideoLifecycleCallbacks getVideoLifecycleCallbacks()
  {
    synchronized (zzrN)
    {
      VideoLifecycleCallbacks localVideoLifecycleCallbacks = zzrP;
      return localVideoLifecycleCallbacks;
    }
  }
  
  public boolean hasVideoContent()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzrO != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks paramVideoLifecycleCallbacks)
  {
    zzac.zzb(paramVideoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
    synchronized (zzrN)
    {
      zzrP = paramVideoLifecycleCallbacks;
      if (zzrO == null) {
        return;
      }
    }
    try
    {
      zzrO.zza(new zzfm(paramVideoLifecycleCallbacks));
      return;
      paramVideoLifecycleCallbacks = finally;
      throw paramVideoLifecycleCallbacks;
    }
    catch (RemoteException paramVideoLifecycleCallbacks)
    {
      for (;;)
      {
        zzpy.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", paramVideoLifecycleCallbacks);
      }
    }
  }
  
  public void zza(zzew paramZzew)
  {
    synchronized (zzrN)
    {
      zzrO = paramZzew;
      if (zzrP != null) {
        setVideoLifecycleCallbacks(zzrP);
      }
      return;
    }
  }
  
  public zzew zzbt()
  {
    synchronized (zzrN)
    {
      zzew localZzew = zzrO;
      return localZzew;
    }
  }
  
  public static abstract class VideoLifecycleCallbacks
  {
    public VideoLifecycleCallbacks() {}
    
    public void onVideoEnd() {}
  }
}
