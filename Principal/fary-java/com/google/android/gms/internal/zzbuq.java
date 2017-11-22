package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzbuq
  implements Cloneable
{
  private Object value;
  private zzbuo<?, ?> zzcsd;
  private List<zzbuv> zzcse = new ArrayList();
  
  zzbuq() {}
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzv()];
    zza(zzbum.zzae(arrayOfByte));
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzbuq));
      paramObject = (zzbuq)paramObject;
      if ((value == null) || (value == null)) {
        break;
      }
      bool1 = bool2;
    } while (zzcsd != zzcsd);
    if (!zzcsd.zzciF.isArray()) {
      return value.equals(value);
    }
    if ((value instanceof byte[])) {
      return Arrays.equals((byte[])value, (byte[])value);
    }
    if ((value instanceof int[])) {
      return Arrays.equals((int[])value, (int[])value);
    }
    if ((value instanceof long[])) {
      return Arrays.equals((long[])value, (long[])value);
    }
    if ((value instanceof float[])) {
      return Arrays.equals((float[])value, (float[])value);
    }
    if ((value instanceof double[])) {
      return Arrays.equals((double[])value, (double[])value);
    }
    if ((value instanceof boolean[])) {
      return Arrays.equals((boolean[])value, (boolean[])value);
    }
    return Arrays.deepEquals((Object[])value, (Object[])value);
    if ((zzcse != null) && (zzcse != null)) {
      return zzcse.equals(zzcse);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  void zza(zzbum paramZzbum)
    throws IOException
  {
    if (value != null) {
      zzcsd.zza(value, paramZzbum);
    }
    for (;;)
    {
      return;
      Iterator localIterator = zzcse.iterator();
      while (localIterator.hasNext()) {
        ((zzbuv)localIterator.next()).zza(paramZzbum);
      }
    }
  }
  
  void zza(zzbuv paramZzbuv)
  {
    zzcse.add(paramZzbuv);
  }
  
  public final zzbuq zzacQ()
  {
    zzbuq localZzbuq = new zzbuq();
    try
    {
      zzcsd = zzcsd;
      if (zzcse == null) {
        zzcse = null;
      }
      while (value == null)
      {
        return localZzbuq;
        zzcse.addAll(zzcse);
      }
      if (!(value instanceof zzbut)) {
        break label93;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    value = ((zzbut)((zzbut)value).clone());
    return localCloneNotSupportedException;
    label93:
    if ((value instanceof byte[]))
    {
      value = ((byte[])value).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((value instanceof byte[][]))
    {
      localObject1 = (byte[][])value;
      localObject2 = new byte[localObject1.length][];
      value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((value instanceof boolean[]))
    {
      value = ((boolean[])value).clone();
      return localCloneNotSupportedException;
    }
    if ((value instanceof int[]))
    {
      value = ((int[])value).clone();
      return localCloneNotSupportedException;
    }
    if ((value instanceof long[]))
    {
      value = ((long[])value).clone();
      return localCloneNotSupportedException;
    }
    if ((value instanceof float[]))
    {
      value = ((float[])value).clone();
      return localCloneNotSupportedException;
    }
    if ((value instanceof double[]))
    {
      value = ((double[])value).clone();
      return localCloneNotSupportedException;
    }
    if ((value instanceof zzbut[]))
    {
      localObject1 = (zzbut[])value;
      localObject2 = new zzbut[localObject1.length];
      value = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((zzbut)localObject1[i].clone());
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  <T> T zzb(zzbuo<?, T> paramZzbuo)
  {
    if (value != null)
    {
      if (!zzcsd.equals(paramZzbuo)) {
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
      }
    }
    else
    {
      zzcsd = paramZzbuo;
      value = paramZzbuo.zzZ(zzcse);
      zzcse = null;
    }
    return value;
  }
  
  int zzv()
  {
    int j;
    if (value != null)
    {
      j = zzcsd.zzaR(value);
      return j;
    }
    Iterator localIterator = zzcse.iterator();
    for (int i = 0;; i = ((zzbuv)localIterator.next()).zzv() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
}
