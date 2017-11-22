package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class zzc
  extends Thread
{
  private static final boolean DEBUG = zzs.DEBUG;
  private final BlockingQueue<zzk<?>> zzg;
  private final BlockingQueue<zzk<?>> zzh;
  private final zzb zzi;
  private final zzn zzj;
  private volatile boolean zzk = false;
  
  public zzc(BlockingQueue<zzk<?>> paramBlockingQueue1, BlockingQueue<zzk<?>> paramBlockingQueue2, zzb paramZzb, zzn paramZzn)
  {
    super("VolleyCacheDispatcher");
    zzg = paramBlockingQueue1;
    zzh = paramBlockingQueue2;
    zzi = paramZzb;
    zzj = paramZzn;
  }
  
  public void quit()
  {
    zzk = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      zzs.zza("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    zzi.initialize();
    for (;;)
    {
      zzb.zza localZza;
      try
      {
        zzk localZzk = (zzk)zzg.take();
        localZzk.zzc("cache-queue-take");
        localZza = zzi.zza(localZzk.zzg());
        if (localZza != null) {
          break label94;
        }
        localZzk.zzc("cache-miss");
        zzh.put(localZzk);
        continue;
        if (!zzk) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label94:
      if (localZza.zza())
      {
        localInterruptedException.zzc("cache-hit-expired");
        localInterruptedException.zza(localZza);
        zzh.put(localInterruptedException);
      }
      else
      {
        localInterruptedException.zzc("cache-hit");
        zzm localZzm = localInterruptedException.zza(new zzi(data, zzf));
        localInterruptedException.zzc("cache-hit-parsed");
        if (!localZza.zzb())
        {
          zzj.zza(localInterruptedException, localZzm);
        }
        else
        {
          localInterruptedException.zzc("cache-hit-refresh-needed");
          localInterruptedException.zza(localZza);
          zzag = true;
          zzj.zza(localInterruptedException, localZzm, new Runnable()
          {
            public void run()
            {
              try
              {
                zzc.zza(zzc.this).put(localInterruptedException);
                return;
              }
              catch (InterruptedException localInterruptedException) {}
            }
          });
        }
      }
    }
  }
}
