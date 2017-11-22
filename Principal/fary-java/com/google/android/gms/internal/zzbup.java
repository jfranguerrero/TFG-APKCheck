package com.google.android.gms.internal;

public final class zzbup
  implements Cloneable
{
  private static final zzbuq zzcrZ = new zzbuq();
  private int mSize;
  private boolean zzcsa = false;
  private int[] zzcsb;
  private zzbuq[] zzcsc;
  
  zzbup()
  {
    this(10);
  }
  
  zzbup(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    zzcsb = new int[paramInt];
    zzcsc = new zzbuq[paramInt];
    mSize = 0;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzbuq[] paramArrayOfZzbuq1, zzbuq[] paramArrayOfZzbuq2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfZzbuq1[i].equals(paramArrayOfZzbuq2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int zzqz(int paramInt)
  {
    int i = 0;
    int j = mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = zzcsb[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbup)) {
        return false;
      }
      paramObject = (zzbup)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
    } while ((zza(zzcsb, zzcsb, mSize)) && (zza(zzcsc, zzcsc, mSize)));
    return false;
  }
  
  public int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + zzcsb[i]) * 31 + zzcsc[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  int size()
  {
    return mSize;
  }
  
  void zza(int paramInt, zzbuq paramZzbuq)
  {
    int i = zzqz(paramInt);
    if (i >= 0)
    {
      zzcsc[i] = paramZzbuq;
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < mSize) && (zzcsc[i] == zzcrZ))
    {
      zzcsb[i] = paramInt;
      zzcsc[i] = paramZzbuq;
      return;
    }
    if (mSize >= zzcsb.length)
    {
      int j = idealIntArraySize(mSize + 1);
      int[] arrayOfInt = new int[j];
      zzbuq[] arrayOfZzbuq = new zzbuq[j];
      System.arraycopy(zzcsb, 0, arrayOfInt, 0, zzcsb.length);
      System.arraycopy(zzcsc, 0, arrayOfZzbuq, 0, zzcsc.length);
      zzcsb = arrayOfInt;
      zzcsc = arrayOfZzbuq;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(zzcsb, i, zzcsb, i + 1, mSize - i);
      System.arraycopy(zzcsc, i, zzcsc, i + 1, mSize - i);
    }
    zzcsb[i] = paramInt;
    zzcsc[i] = paramZzbuq;
    mSize += 1;
  }
  
  public final zzbup zzacP()
  {
    int j = size();
    zzbup localZzbup = new zzbup(j);
    System.arraycopy(zzcsb, 0, zzcsb, 0, j);
    int i = 0;
    while (i < j)
    {
      if (zzcsc[i] != null) {
        zzcsc[i] = ((zzbuq)zzcsc[i].clone());
      }
      i += 1;
    }
    mSize = j;
    return localZzbup;
  }
  
  zzbuq zzqx(int paramInt)
  {
    paramInt = zzqz(paramInt);
    if ((paramInt < 0) || (zzcsc[paramInt] == zzcrZ)) {
      return null;
    }
    return zzcsc[paramInt];
  }
  
  zzbuq zzqy(int paramInt)
  {
    return zzcsc[paramInt];
  }
}
