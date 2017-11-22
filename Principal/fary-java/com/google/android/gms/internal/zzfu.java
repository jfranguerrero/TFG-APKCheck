package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzfu
{
  private final Collection<zzft> zzAJ = new ArrayList();
  private final Collection<zzft<String>> zzAK = new ArrayList();
  private final Collection<zzft<String>> zzAL = new ArrayList();
  
  public zzfu() {}
  
  public void zza(zzft paramZzft)
  {
    zzAJ.add(paramZzft);
  }
  
  public void zzb(zzft<String> paramZzft)
  {
    zzAK.add(paramZzft);
  }
  
  public void zzc(zzft<String> paramZzft)
  {
    zzAL.add(paramZzft);
  }
  
  public List<String> zzfn()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzAK.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((zzft)localIterator.next()).get();
      if (str != null) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public List<String> zzfo()
  {
    List localList = zzfn();
    Iterator localIterator = zzAL.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((zzft)localIterator.next()).get();
      if (str != null) {
        localList.add(str);
      }
    }
    return localList;
  }
}
