package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzbuo<M extends zzbun<M>, T>
{
  public final int tag;
  protected final int type;
  protected final Class<T> zzciF;
  protected final boolean zzcrY;
  
  private zzbuo(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    type = paramInt1;
    zzciF = paramClass;
    tag = paramInt2;
    zzcrY = paramBoolean;
  }
  
  public static <M extends zzbun<M>, T extends zzbut> zzbuo<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zzbuo(paramInt, paramClass, (int)paramLong, false);
  }
  
  private T zzaa(List<zzbuv> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (zzbuv)paramList.get(i);
      if (zzcsh.length != 0) {
        zza((zzbuv)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = zzciF.cast(Array.newInstance(zzciF.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<zzbuv>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  private T zzab(List<zzbuv> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (zzbuv)paramList.get(paramList.size() - 1);
    return zzciF.cast(zzaM(zzbul.zzad(zzcsh)));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbuo)) {
        return false;
      }
      paramObject = (zzbuo)paramObject;
    } while ((type == type) && (zzciF == zzciF) && (tag == tag) && (zzcrY == zzcrY));
    return false;
  }
  
  public int hashCode()
  {
    int j = type;
    int k = zzciF.hashCode();
    int m = tag;
    if (zzcrY) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  final T zzZ(List<zzbuv> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (zzcrY) {
      return zzaa(paramList);
    }
    return zzab(paramList);
  }
  
  protected void zza(zzbuv paramZzbuv, List<Object> paramList)
  {
    paramList.add(zzaM(zzbul.zzad(zzcsh)));
  }
  
  void zza(Object paramObject, zzbum paramZzbum)
    throws IOException
  {
    if (zzcrY)
    {
      zzc(paramObject, paramZzbum);
      return;
    }
    zzb(paramObject, paramZzbum);
  }
  
  protected Object zzaM(zzbul paramZzbul)
  {
    Object localObject;
    if (zzcrY) {
      localObject = zzciF.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (type)
        {
        case 10: 
          int i = type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (InstantiationException paramZzbul)
      {
        localObject = String.valueOf(localObject);
        throw new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramZzbul);
        localObject = zzciF;
        continue;
        zzbut localZzbut = (zzbut)((Class)localObject).newInstance();
        paramZzbul.zza(localZzbut, zzbuw.zzqB(tag));
        return localZzbut;
        localZzbut = (zzbut)((Class)localObject).newInstance();
        paramZzbul.zza(localZzbut);
        return localZzbut;
      }
      catch (IllegalAccessException paramZzbul)
      {
        localObject = String.valueOf(localObject);
        throw new IllegalArgumentException(String.valueOf(localObject).length() + 33 + "Error creating instance of class " + (String)localObject, paramZzbul);
      }
      catch (IOException paramZzbul)
      {
        throw new IllegalArgumentException("Error reading extension field", paramZzbul);
      }
    }
  }
  
  int zzaR(Object paramObject)
  {
    if (zzcrY) {
      return zzaS(paramObject);
    }
    return zzaT(paramObject);
  }
  
  protected int zzaS(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + zzaT(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int zzaT(Object paramObject)
  {
    int i = zzbuw.zzqB(tag);
    switch (type)
    {
    default: 
      i = type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return zzbum.zzb(i, (zzbut)paramObject);
    }
    return zzbum.zzc(i, (zzbut)paramObject);
  }
  
  protected void zzb(Object paramObject, zzbum paramZzbum)
  {
    for (;;)
    {
      try
      {
        paramZzbum.zzqt(tag);
        switch (type)
        {
        case 10: 
          i = type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException(paramObject);
      }
      paramObject = (zzbut)paramObject;
      int i = zzbuw.zzqB(tag);
      paramZzbum.zzb(paramObject);
      paramZzbum.zzJ(i, 4);
      return;
      paramZzbum.zzc((zzbut)paramObject);
      return;
    }
  }
  
  protected void zzc(Object paramObject, zzbum paramZzbum)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramZzbum);
      }
      i += 1;
    }
  }
}
