package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl
{
  private AtomicInteger zzW = new AtomicInteger();
  private final Map<String, Queue<zzk<?>>> zzX = new HashMap();
  private final Set<zzk<?>> zzY = new HashSet();
  private final PriorityBlockingQueue<zzk<?>> zzZ = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<zzk<?>> zzaa = new PriorityBlockingQueue();
  private zzg[] zzab;
  private zzc zzac;
  private List<Object> zzad = new ArrayList();
  private final zzb zzi;
  private final zzn zzj;
  private final zzf zzx;
  
  public zzl(zzb paramZzb, zzf paramZzf)
  {
    this(paramZzb, paramZzf, 4);
  }
  
  public zzl(zzb paramZzb, zzf paramZzf, int paramInt)
  {
    this(paramZzb, paramZzf, paramInt, new zze(new Handler(Looper.getMainLooper())));
  }
  
  public zzl(zzb paramZzb, zzf paramZzf, int paramInt, zzn paramZzn)
  {
    zzi = paramZzb;
    zzx = paramZzf;
    zzab = new zzg[paramInt];
    zzj = paramZzn;
  }
  
  public int getSequenceNumber()
  {
    return zzW.incrementAndGet();
  }
  
  public void start()
  {
    stop();
    zzac = new zzc(zzZ, zzaa, zzi, zzj);
    zzac.start();
    int i = 0;
    while (i < zzab.length)
    {
      zzg localZzg = new zzg(zzaa, zzx, zzi, zzj);
      zzab[i] = localZzg;
      localZzg.start();
      i += 1;
    }
  }
  
  public void stop()
  {
    if (zzac != null) {
      zzac.quit();
    }
    int i = 0;
    while (i < zzab.length)
    {
      if (zzab[i] != null) {
        zzab[i].quit();
      }
      i += 1;
    }
  }
  
  public <T> zzk<T> zze(zzk<T> paramZzk)
  {
    paramZzk.zza(this);
    synchronized (zzY)
    {
      zzY.add(paramZzk);
      paramZzk.zza(getSequenceNumber());
      paramZzk.zzc("add-to-queue");
      if (!paramZzk.zzn())
      {
        zzaa.add(paramZzk);
        return paramZzk;
      }
    }
    for (;;)
    {
      String str;
      synchronized (zzX)
      {
        str = paramZzk.zzg();
        if (zzX.containsKey(str))
        {
          Queue localQueue = (Queue)zzX.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paramZzk);
          zzX.put(str, ???);
          if (zzs.DEBUG) {
            zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramZzk;
        }
      }
      zzX.put(str, null);
      zzZ.add(paramZzk);
    }
  }
  
  <T> void zzf(zzk<T> paramZzk)
  {
    Object localObject2;
    synchronized (zzY)
    {
      zzY.remove(paramZzk);
      synchronized (zzad)
      {
        localObject2 = zzad.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((Iterator)localObject2).next();
        }
      }
    }
    if (paramZzk.zzn()) {
      synchronized (zzX)
      {
        paramZzk = paramZzk.zzg();
        localObject2 = (Queue)zzX.remove(paramZzk);
        if (localObject2 != null)
        {
          if (zzs.DEBUG) {
            zzs.zza("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((Queue)localObject2).size()), paramZzk });
          }
          zzZ.addAll((Collection)localObject2);
        }
        return;
      }
    }
  }
}
