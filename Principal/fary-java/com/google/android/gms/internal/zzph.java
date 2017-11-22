package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public final class zzph
{
  private static final ThreadPoolExecutor zzWJ = new ThreadPoolExecutor(10, 10, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Default"));
  private static final ThreadPoolExecutor zzWK = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Loader"));
  
  static
  {
    zzWJ.allowCoreThreadTimeOut(true);
    zzWK.allowCoreThreadTimeOut(true);
  }
  
  public static zzqf<Void> zza(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1) {
      zza(zzWK, new Callable()
      {
        public Void zzbl()
        {
          run();
          return null;
        }
      });
    }
    zza(zzWJ, new Callable()
    {
      public Void zzbl()
      {
        run();
        return null;
      }
    });
  }
  
  public static zzqf<Void> zza(Runnable paramRunnable)
  {
    return zza(0, paramRunnable);
  }
  
  public static <T> zzqf<T> zza(Callable<T> paramCallable)
  {
    return zza(zzWJ, paramCallable);
  }
  
  public static <T> zzqf<T> zza(ExecutorService paramExecutorService, final Callable<T> paramCallable)
  {
    zzqc localZzqc = new zzqc();
    try
    {
      localZzqc.zzd(new Runnable()
      {
        public void run()
        {
          try
          {
            Process.setThreadPriority(10);
            zzh(paramCallable.call());
            return;
          }
          catch (Exception localException)
          {
            zzv.zzcN().zza(localException, "AdThreadPool.submit");
            zze(localException);
          }
        }
      }
      {
        public void run()
        {
          if (isCancelled()) {
            zzWO.cancel(true);
          }
        }
      });
      return localZzqc;
    }
    catch (RejectedExecutionException paramExecutorService)
    {
      zzpe.zzc("Thread execution is rejected.", paramExecutorService);
      localZzqc.cancel(true);
    }
    return localZzqc;
  }
  
  private static ThreadFactory zzaU(String paramString)
  {
    new ThreadFactory()
    {
      private final AtomicInteger zzWP = new AtomicInteger(1);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        String str = zzph.this;
        int i = zzWP.getAndIncrement();
        return new Thread(paramAnonymousRunnable, String.valueOf(str).length() + 23 + "AdWorker(" + str + ") #" + i);
      }
    };
  }
}
