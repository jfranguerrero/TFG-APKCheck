package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzmb
public class zzik
  implements Iterable<zzij>
{
  private final List<zzij> zzHX = new LinkedList();
  
  public zzik() {}
  
  private zzij zzg(zzqp paramZzqp)
  {
    Iterator localIterator = zzv.zzdg().iterator();
    while (localIterator.hasNext())
    {
      zzij localZzij = (zzij)localIterator.next();
      if (zzGt == paramZzqp) {
        return localZzij;
      }
    }
    return null;
  }
  
  public Iterator<zzij> iterator()
  {
    return zzHX.iterator();
  }
  
  public void zza(zzij paramZzij)
  {
    zzHX.add(paramZzij);
  }
  
  public void zzb(zzij paramZzij)
  {
    zzHX.remove(paramZzij);
  }
  
  public boolean zze(zzqp paramZzqp)
  {
    paramZzqp = zzg(paramZzqp);
    if (paramZzqp != null)
    {
      zzHU.abort();
      return true;
    }
    return false;
  }
  
  public boolean zzf(zzqp paramZzqp)
  {
    return zzg(paramZzqp) != null;
  }
  
  public int zzgf()
  {
    return zzHX.size();
  }
}
