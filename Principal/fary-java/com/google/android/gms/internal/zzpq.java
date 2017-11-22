package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

@zzmb
public class zzpq
{
  private Handler mHandler = null;
  private HandlerThread zzXF = null;
  private int zzXG = 0;
  private final Object zzrN = new Object();
  
  public zzpq() {}
  
  public Looper zzkC()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzXG == 0)
        {
          if (zzXF == null)
          {
            zzpe.v("Starting the looper thread.");
            zzXF = new HandlerThread("LooperProvider");
            zzXF.start();
            mHandler = new Handler(zzXF.getLooper());
            zzpe.v("Looper thread started.");
            zzXG += 1;
            Looper localLooper = zzXF.getLooper();
            return localLooper;
          }
          zzpe.v("Resuming the looper thread");
          zzrN.notifyAll();
        }
      }
      zzac.zzb(zzXF, "Invalid state: mHandlerThread should already been initialized.");
    }
  }
  
  public void zzkD()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzXG > 0)
        {
          bool = true;
          zzac.zzb(bool, "Invalid state: release() called more times than expected.");
          int i = zzXG - 1;
          zzXG = i;
          if (i == 0) {
            mHandler.post(new Runnable()
            {
              public void run()
              {
                synchronized (zzpq.zza(zzpq.this))
                {
                  zzpe.v("Suspending the looper thread");
                  for (;;)
                  {
                    int i = zzpq.zzb(zzpq.this);
                    if (i == 0) {
                      try
                      {
                        zzpq.zza(zzpq.this).wait();
                        zzpe.v("Looper thread resumed");
                      }
                      catch (InterruptedException localInterruptedException)
                      {
                        zzpe.v("Looper thread interrupted.");
                      }
                    }
                  }
                }
              }
            });
          }
          return;
        }
      }
      boolean bool = false;
    }
  }
}
