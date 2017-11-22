package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import java.util.Arrays;
import java.util.List;

@zzmb
public class zzgr
  extends zzhh.zza
  implements zzgu.zza
{
  private final zzgm zzGa;
  private zzgu zzGd;
  private final String zzGg;
  private final SimpleArrayMap<String, zzgo> zzGh;
  private final SimpleArrayMap<String, String> zzGi;
  private final Object zzrN = new Object();
  
  public zzgr(String paramString, SimpleArrayMap<String, zzgo> paramSimpleArrayMap, SimpleArrayMap<String, String> paramSimpleArrayMap1, zzgm paramZzgm)
  {
    zzGg = paramString;
    zzGh = paramSimpleArrayMap;
    zzGi = paramSimpleArrayMap1;
    zzGa = paramZzgm;
  }
  
  public List<String> getAvailableAssetNames()
  {
    int n = 0;
    String[] arrayOfString = new String[zzGh.size() + zzGi.size()];
    int j = 0;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= zzGh.size()) {
        break;
      }
      arrayOfString[i] = ((String)zzGh.keyAt(j));
      i += 1;
      j += 1;
    }
    while (k < zzGi.size())
    {
      arrayOfString[m] = ((String)zzGi.keyAt(k));
      k += 1;
      m += 1;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public String getCustomTemplateId()
  {
    return zzGg;
  }
  
  public void performClick(String paramString)
  {
    synchronized (zzrN)
    {
      if (zzGd == null)
      {
        zzpy.e("Attempt to call performClick before ad initialized.");
        return;
      }
      zzGd.zza(null, paramString, null, null, null);
      return;
    }
  }
  
  public void recordImpression()
  {
    synchronized (zzrN)
    {
      if (zzGd == null)
      {
        zzpy.e("Attempt to perform recordImpression before ad initialized.");
        return;
      }
      zzGd.zzb(null, null);
      return;
    }
  }
  
  public String zzY(String paramString)
  {
    return (String)zzGi.get(paramString);
  }
  
  public zzgz zzZ(String paramString)
  {
    return (zzgz)zzGh.get(paramString);
  }
  
  public void zzb(zzgu paramZzgu)
  {
    synchronized (zzrN)
    {
      zzGd = paramZzgu;
      return;
    }
  }
  
  public String zzfN()
  {
    return "3";
  }
  
  public zzgm zzfO()
  {
    return zzGa;
  }
}
