package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import java.util.Iterator;
import java.util.LinkedList;

@zzmb
class zziu
{
  private final LinkedList<zza> zzIC;
  private zzdy zzID;
  private final int zzIE;
  private boolean zzIF;
  private final String zztq;
  
  zziu(zzdy paramZzdy, String paramString, int paramInt)
  {
    zzac.zzw(paramZzdy);
    zzac.zzw(paramString);
    zzIC = new LinkedList();
    zzID = paramZzdy;
    zztq = paramString;
    zzIE = paramInt;
  }
  
  String getAdUnitId()
  {
    return zztq;
  }
  
  int getNetworkType()
  {
    return zzIE;
  }
  
  int size()
  {
    return zzIC.size();
  }
  
  void zza(zzip paramZzip, zzdy paramZzdy)
  {
    paramZzip = new zza(paramZzip, paramZzdy);
    zzIC.add(paramZzip);
  }
  
  void zzb(zzip paramZzip)
  {
    paramZzip = new zza(paramZzip);
    zzIC.add(paramZzip);
    paramZzip.zzgq();
  }
  
  zzdy zzgl()
  {
    return zzID;
  }
  
  int zzgm()
  {
    Iterator localIterator = zzIC.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!nextzzIK) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  void zzgn()
  {
    Iterator localIterator = zzIC.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzgq();
    }
  }
  
  void zzgo()
  {
    zzIF = true;
  }
  
  boolean zzgp()
  {
    return zzIF;
  }
  
  zza zzp(@Nullable zzdy paramZzdy)
  {
    if (paramZzdy != null) {
      zzID = paramZzdy;
    }
    return (zza)zzIC.remove();
  }
  
  class zza
  {
    zzl zzIG;
    @Nullable
    zzdy zzIH;
    zziq zzII;
    long zzIJ;
    boolean zzIK;
    boolean zzIL;
    
    zza(zzip paramZzip)
    {
      zzIG = paramZzip.zzah(zziu.zza(zziu.this));
      zzII = new zziq();
      zzII.zzc(zzIG);
    }
    
    zza(zzip paramZzip, zzdy paramZzdy)
    {
      this(paramZzip);
      zzIH = paramZzdy;
    }
    
    void zzgq()
    {
      if (zzIK) {
        return;
      }
      if (zzIH != null) {}
      for (zzdy localZzdy = zzIH;; localZzdy = zziu.zzb(zziu.this))
      {
        localZzdy = zzis.zzl(localZzdy);
        zzIL = zzIG.zzb(localZzdy);
        zzIK = true;
        zzIJ = zzv.zzcP().currentTimeMillis();
        return;
      }
    }
  }
}
