package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@zzmb
public class zzcp
  implements zzcr
{
  private final Object zzrN = new Object();
  private final zzqa zztr;
  private final WeakHashMap<zzov, zzcq> zzvX = new WeakHashMap();
  private final ArrayList<zzcq> zzvY = new ArrayList();
  private final Context zzvZ;
  private final zzja zzwa;
  
  public zzcp(Context paramContext, zzqa paramZzqa, zzja paramZzja)
  {
    zzvZ = paramContext.getApplicationContext();
    zztr = paramZzqa;
    zzwa = paramZzja;
  }
  
  public void zza(zzcq paramZzcq)
  {
    synchronized (zzrN)
    {
      if (!paramZzcq.zzdF())
      {
        zzvY.remove(paramZzcq);
        Iterator localIterator = zzvX.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Map.Entry)localIterator.next()).getValue() == paramZzcq) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public void zza(zzec paramZzec, zzov paramZzov)
  {
    zza(paramZzec, paramZzov, zzMZ.getView());
  }
  
  public void zza(zzec paramZzec, zzov paramZzov, View paramView)
  {
    zza(paramZzec, paramZzov, new zzcq.zzd(paramView, paramZzov), null);
  }
  
  public void zza(zzec paramZzec, zzov paramZzov, View paramView, zzjb paramZzjb)
  {
    zza(paramZzec, paramZzov, new zzcq.zzd(paramView, paramZzov), paramZzjb);
  }
  
  public void zza(zzec paramZzec, zzov paramZzov, zzcx paramZzcx, @Nullable zzjb paramZzjb)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzi(paramZzov))
        {
          paramZzec = (zzcq)zzvX.get(paramZzov);
          if (paramZzjb != null) {
            paramZzec.zza(new zzcs(paramZzec, paramZzjb));
          }
        }
        else
        {
          paramZzec = new zzcq(zzvZ, paramZzec, paramZzov, zztr, paramZzcx);
          paramZzec.zza(this);
          zzvX.put(paramZzov, paramZzec);
          zzvY.add(paramZzec);
        }
      }
      paramZzec.zza(new zzct(paramZzec, zzwa));
    }
  }
  
  public void zza(zzec paramZzec, zzov paramZzov, zzgu paramZzgu)
  {
    zza(paramZzec, paramZzov, new zzcq.zza(paramZzgu), null);
  }
  
  public boolean zzi(zzov paramZzov)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        paramZzov = (zzcq)zzvX.get(paramZzov);
        if ((paramZzov != null) && (paramZzov.zzdF()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zzj(zzov paramZzov)
  {
    synchronized (zzrN)
    {
      paramZzov = (zzcq)zzvX.get(paramZzov);
      if (paramZzov != null) {
        paramZzov.zzdD();
      }
      return;
    }
  }
  
  public void zzk(zzov paramZzov)
  {
    synchronized (zzrN)
    {
      paramZzov = (zzcq)zzvX.get(paramZzov);
      if (paramZzov != null) {
        paramZzov.stop();
      }
      return;
    }
  }
  
  public void zzl(zzov paramZzov)
  {
    synchronized (zzrN)
    {
      paramZzov = (zzcq)zzvX.get(paramZzov);
      if (paramZzov != null) {
        paramZzov.pause();
      }
      return;
    }
  }
  
  public void zzm(zzov paramZzov)
  {
    synchronized (zzrN)
    {
      paramZzov = (zzcq)zzvX.get(paramZzov);
      if (paramZzov != null) {
        paramZzov.resume();
      }
      return;
    }
  }
}
