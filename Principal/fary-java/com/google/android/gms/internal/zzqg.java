package com.google.android.gms.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
class zzqg
{
  private final Object zzYp = new Object();
  private final List<Runnable> zzYq = new ArrayList();
  private final List<Runnable> zzYr = new ArrayList();
  private boolean zzYs = false;
  
  public zzqg() {}
  
  private void zze(Runnable paramRunnable)
  {
    zzph.zza(paramRunnable);
  }
  
  private void zzf(Runnable paramRunnable)
  {
    zzpx.zzXU.post(paramRunnable);
  }
  
  public void zzc(Runnable paramRunnable)
  {
    synchronized (zzYp)
    {
      if (zzYs)
      {
        zze(paramRunnable);
        return;
      }
      zzYq.add(paramRunnable);
    }
  }
  
  public void zzd(Runnable paramRunnable)
  {
    synchronized (zzYp)
    {
      if (zzYs)
      {
        zzf(paramRunnable);
        return;
      }
      zzYr.add(paramRunnable);
    }
  }
  
  public void zzkM()
  {
    synchronized (zzYp)
    {
      if (zzYs) {
        return;
      }
      Iterator localIterator1 = zzYq.iterator();
      if (localIterator1.hasNext()) {
        zze((Runnable)localIterator1.next());
      }
    }
    Iterator localIterator2 = zzYr.iterator();
    while (localIterator2.hasNext()) {
      zzf((Runnable)localIterator2.next());
    }
    zzYq.clear();
    zzYr.clear();
    zzYs = true;
  }
}
