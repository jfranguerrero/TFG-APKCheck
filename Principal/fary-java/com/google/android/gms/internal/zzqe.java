package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public class zzqe
{
  public static <A, B> zzqf<B> zza(final zzqf<A> paramZzqf, final zza<A, B> paramZza)
  {
    zzqc localZzqc = new zzqc();
    paramZzqf.zzc(new Runnable()
    {
      public void run()
      {
        try
        {
          zzh(paramZza.apply(paramZzqf.get()));
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          cancel(true);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        catch (CancellationException localCancellationException)
        {
          for (;;) {}
        }
      }
    });
    return localZzqc;
  }
  
  public static <V> zzqf<List<V>> zzo(final List<zzqf<V>> paramList)
  {
    final zzqc localZzqc = new zzqc();
    final int i = paramList.size();
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((zzqf)localIterator.next()).zzc(new Runnable()
      {
        public void run()
        {
          if (incrementAndGet() >= i) {}
          try
          {
            localZzqc.zzh(zzqe.zzq(paramList));
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            zzpe.zzc("Unable to convert list of futures to a future of list", localInterruptedException);
            return;
          }
          catch (ExecutionException localExecutionException)
          {
            for (;;) {}
          }
        }
      });
    }
    return localZzqc;
  }
  
  private static <V> List<V> zzp(List<zzqf<V>> paramList)
    throws ExecutionException, InterruptedException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = ((zzqf)paramList.next()).get();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public static abstract interface zza<D, R>
  {
    public abstract R apply(D paramD);
  }
}
