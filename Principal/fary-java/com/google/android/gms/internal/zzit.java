package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@zzmb
class zzit
{
  private final Object[] mParams;
  
  zzit(zzdy paramZzdy, String paramString, int paramInt)
  {
    mParams = zza(paramZzdy, paramString, paramInt);
  }
  
  private static Object[] zza(zzdy paramZzdy, String paramString, int paramInt)
  {
    HashSet localHashSet = new HashSet(Arrays.asList(((String)zzfx.zzCC.get()).split(",")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    if (localHashSet.contains("networkType")) {
      localArrayList.add(Integer.valueOf(paramInt));
    }
    if (localHashSet.contains("birthday")) {
      localArrayList.add(Long.valueOf(zzyF));
    }
    if (localHashSet.contains("extras")) {
      localArrayList.add(zzc(extras));
    }
    if (localHashSet.contains("gender")) {
      localArrayList.add(Integer.valueOf(zzyG));
    }
    if (localHashSet.contains("keywords"))
    {
      if (zzyH != null) {
        localArrayList.add(zzyH.toString());
      }
    }
    else
    {
      if (localHashSet.contains("isTestDevice")) {
        localArrayList.add(Boolean.valueOf(zzyI));
      }
      if (localHashSet.contains("tagForChildDirectedTreatment")) {
        localArrayList.add(Integer.valueOf(zzyJ));
      }
      if (localHashSet.contains("manualImpressionsEnabled")) {
        localArrayList.add(Boolean.valueOf(zzyK));
      }
      if (localHashSet.contains("publisherProvidedId")) {
        localArrayList.add(zzyL);
      }
      if (localHashSet.contains("location"))
      {
        if (zzyN == null) {
          break label447;
        }
        localArrayList.add(zzyN.toString());
      }
      label289:
      if (localHashSet.contains("contentUrl")) {
        localArrayList.add(zzyO);
      }
      if (localHashSet.contains("networkExtras")) {
        localArrayList.add(zzc(zzyP));
      }
      if (localHashSet.contains("customTargeting")) {
        localArrayList.add(zzc(zzyQ));
      }
      if (localHashSet.contains("categoryExclusions"))
      {
        if (zzyR == null) {
          break label457;
        }
        localArrayList.add(zzyR.toString());
      }
    }
    for (;;)
    {
      if (localHashSet.contains("requestAgent")) {
        localArrayList.add(zzyS);
      }
      if (localHashSet.contains("requestPackage")) {
        localArrayList.add(zzyT);
      }
      return localArrayList.toArray();
      localArrayList.add(null);
      break;
      label447:
      localArrayList.add(null);
      break label289;
      label457:
      localArrayList.add(null);
    }
  }
  
  private static String zzc(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = new TreeSet(paramBundle.keySet()).iterator();
    if (localIterator.hasNext())
    {
      Object localObject = paramBundle.get((String)localIterator.next());
      if (localObject == null) {
        localObject = "null";
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        break;
        if ((localObject instanceof Bundle)) {
          localObject = zzc((Bundle)localObject);
        } else {
          localObject = localObject.toString();
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzit)) {
      return false;
    }
    paramObject = (zzit)paramObject;
    return Arrays.equals(mParams, mParams);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(mParams);
  }
  
  public String toString()
  {
    String str = String.valueOf(Arrays.toString(mParams));
    return String.valueOf(str).length() + 24 + "[InterstitialAdPoolKey " + str + "]";
  }
}
