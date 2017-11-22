package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzmb
public class zzcz
{
  private final Object zzrN = new Object();
  private int zzxt;
  private List<zzcy> zzxu = new LinkedList();
  
  public zzcz() {}
  
  public boolean zza(zzcy paramZzcy)
  {
    synchronized (zzrN)
    {
      return zzxu.contains(paramZzcy);
    }
  }
  
  public boolean zzb(zzcy paramZzcy)
  {
    synchronized (zzrN)
    {
      Iterator localIterator = zzxu.iterator();
      while (localIterator.hasNext())
      {
        zzcy localZzcy = (zzcy)localIterator.next();
        if ((((Boolean)zzfx.zzBU.get()).booleanValue()) && (!zzv.zzcN().zzjJ()))
        {
          if ((paramZzcy != localZzcy) && (localZzcy.zzdV().equals(paramZzcy.zzdV())))
          {
            localIterator.remove();
            return true;
          }
        }
        else if ((((Boolean)zzfx.zzBW.get()).booleanValue()) && (!zzv.zzcN().zzjK()) && (paramZzcy != localZzcy) && (localZzcy.zzdX().equals(paramZzcy.zzdX())))
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void zzc(zzcy paramZzcy)
  {
    synchronized (zzrN)
    {
      if (zzxu.size() >= 10)
      {
        i = zzxu.size();
        zzpe.zzbc(41 + "Queue is full, current size = " + i);
        zzxu.remove(0);
      }
      int i = zzxt;
      zzxt = (i + 1);
      paramZzcy.zzn(i);
      zzxu.add(paramZzcy);
      return;
    }
  }
  
  @Nullable
  public zzcy zzed()
  {
    Object localObject1 = null;
    int k = 0;
    for (;;)
    {
      int i;
      synchronized (zzrN)
      {
        if (zzxu.size() == 0)
        {
          zzpe.zzbc("Queue empty");
          return null;
        }
        if (zzxu.size() >= 2)
        {
          j = Integer.MIN_VALUE;
          Iterator localIterator = zzxu.iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            zzcy localZzcy2 = (zzcy)localIterator.next();
            m = localZzcy2.getScore();
            if (m <= j) {
              break label163;
            }
            k = m;
            localObject1 = localZzcy2;
            j = i;
            break label174;
          }
          zzxu.remove(k);
          return localObject1;
        }
      }
      zzcy localZzcy1 = (zzcy)zzxu.get(0);
      localZzcy1.zzdY();
      return localZzcy1;
      label163:
      int m = j;
      int j = k;
      k = m;
      label174:
      i += 1;
      m = k;
      k = j;
      j = m;
    }
  }
}
