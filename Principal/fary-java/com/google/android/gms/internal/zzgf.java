package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzmb
public class zzgf
{
  boolean zzFa;
  private final List<zzgd> zzFr = new LinkedList();
  private final Map<String, String> zzFs = new LinkedHashMap();
  private String zzFt;
  private zzgd zzFu;
  @Nullable
  private zzgf zzFv;
  private final Object zzrN = new Object();
  
  public zzgf(boolean paramBoolean, String paramString1, String paramString2)
  {
    zzFa = paramBoolean;
    zzFs.put("action", paramString1);
    zzFs.put("ad_format", paramString2);
  }
  
  public void zzX(String paramString)
  {
    if (!zzFa) {
      return;
    }
    synchronized (zzrN)
    {
      zzFt = paramString;
      return;
    }
  }
  
  public boolean zza(zzgd paramZzgd, long paramLong, String... paramVarArgs)
  {
    synchronized (zzrN)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        zzgd localZzgd = new zzgd(paramLong, paramVarArgs[i], paramZzgd);
        zzFr.add(localZzgd);
        i += 1;
      }
      return true;
    }
  }
  
  public boolean zza(@Nullable zzgd paramZzgd, String... paramVarArgs)
  {
    if ((!zzFa) || (paramZzgd == null)) {
      return false;
    }
    return zza(paramZzgd, zzv.zzcP().elapsedRealtime(), paramVarArgs);
  }
  
  @Nullable
  public zzgd zzc(long paramLong)
  {
    if (!zzFa) {
      return null;
    }
    return new zzgd(paramLong, null, null);
  }
  
  public void zzc(@Nullable zzgf paramZzgf)
  {
    synchronized (zzrN)
    {
      zzFv = paramZzgf;
      return;
    }
  }
  
  public zzgd zzfA()
  {
    synchronized (zzrN)
    {
      zzgd localZzgd = zzFu;
      return localZzgd;
    }
  }
  
  public zzgd zzfw()
  {
    return zzc(zzv.zzcP().elapsedRealtime());
  }
  
  public void zzfx()
  {
    synchronized (zzrN)
    {
      zzFu = zzfw();
      return;
    }
  }
  
  public String zzfy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (zzrN)
    {
      Iterator localIterator = zzFr.iterator();
      while (localIterator.hasNext())
      {
        zzgd localZzgd = (zzgd)localIterator.next();
        long l1 = localZzgd.getTime();
        String str2 = localZzgd.zzft();
        localZzgd = localZzgd.zzfu();
        if ((localZzgd != null) && (l1 > 0L))
        {
          long l2 = localZzgd.getTime();
          localStringBuilder.append(str2).append('.').append(l1 - l2).append(',');
        }
      }
    }
    zzFr.clear();
    if (!TextUtils.isEmpty(zzFt)) {
      localObject2.append(zzFt);
    }
    for (;;)
    {
      String str1 = localObject2.toString();
      return str1;
      if (str1.length() > 0) {
        str1.setLength(str1.length() - 1);
      }
    }
  }
  
  Map<String, String> zzfz()
  {
    synchronized (zzrN)
    {
      Object localObject2 = zzv.zzcN().zzjN();
      if ((localObject2 == null) || (zzFv == null))
      {
        localObject2 = zzFs;
        return localObject2;
      }
      localObject2 = ((zzfz)localObject2).zza(zzFs, zzFv.zzfz());
      return localObject2;
    }
  }
  
  public void zzg(String paramString1, String paramString2)
  {
    if ((!zzFa) || (TextUtils.isEmpty(paramString2))) {}
    zzfz localZzfz;
    do
    {
      return;
      localZzfz = zzv.zzcN().zzjN();
    } while (localZzfz == null);
    synchronized (zzrN)
    {
      localZzfz.zzV(paramString1).zza(zzFs, paramString1, paramString2);
      return;
    }
  }
}
