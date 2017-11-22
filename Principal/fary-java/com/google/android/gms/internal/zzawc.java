package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class zzawc
  extends zza
  implements Comparable<zzawc>
{
  public static final Parcelable.Creator<zzawc> CREATOR = new zzawd();
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final zza zzbzx = new zza();
  final int mVersionCode;
  public final String name;
  final String zzaFy;
  final boolean zzbgG;
  final double zzbgI;
  final long zzbzt;
  final byte[] zzbzu;
  public final int zzbzv;
  public final int zzbzw;
  
  zzawc(int paramInt1, String paramString1, long paramLong, boolean paramBoolean, double paramDouble, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    name = paramString1;
    zzbzt = paramLong;
    zzbgG = paramBoolean;
    zzbgI = paramDouble;
    zzaFy = paramString2;
    zzbzu = paramArrayOfByte;
    zzbzv = paramInt2;
    zzbzw = paramInt3;
  }
  
  private static int compare(byte paramByte1, byte paramByte2)
  {
    return paramByte1 - paramByte2;
  }
  
  private static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  private static int compare(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  private static int compare(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return 0;
    }
    if (paramString1 == null) {
      return -1;
    }
    if (paramString2 == null) {
      return 1;
    }
    return paramString1.compareTo(paramString2);
  }
  
  private static int compare(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return 0;
    }
    if (paramBoolean1) {
      return 1;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject != null) && ((paramObject instanceof zzawc)))
    {
      paramObject = (zzawc)paramObject;
      if ((mVersionCode != mVersionCode) || (!zzaa.equal(name, name)) || (zzbzv != zzbzv) || (zzbzw != zzbzw)) {
        bool = false;
      }
      do
      {
        do
        {
          do
          {
            return bool;
            switch (zzbzv)
            {
            default: 
              int i = zzbzv;
              throw new AssertionError(31 + "Invalid enum value: " + i);
            }
          } while (zzbzt == zzbzt);
          return false;
        } while (zzbgG == zzbgG);
        return false;
      } while (zzbgI == zzbgI);
      return false;
      return zzaa.equal(zzaFy, zzaFy);
      return Arrays.equals(zzbzu, zzbzu);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    zza(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzawd.zza(this, paramParcel, paramInt);
  }
  
  public int zza(zzawc paramZzawc)
  {
    int j = 0;
    int i = 0;
    int k = name.compareTo(name);
    if (k != 0) {
      i = k;
    }
    do
    {
      return i;
      k = compare(zzbzv, zzbzv);
      if (k != 0) {
        return k;
      }
      switch (zzbzv)
      {
      default: 
        i = zzbzv;
        throw new AssertionError(31 + "Invalid enum value: " + i);
      case 1: 
        return compare(zzbzt, zzbzt);
      case 2: 
        return compare(zzbgG, zzbgG);
      case 3: 
        return Double.compare(zzbgI, zzbgI);
      case 4: 
        return compare(zzaFy, zzaFy);
      }
    } while (zzbzu == zzbzu);
    if (zzbzu == null) {
      return -1;
    }
    i = j;
    if (zzbzu == null) {
      return 1;
    }
    do
    {
      i += 1;
      if (i >= Math.min(zzbzu.length, zzbzu.length)) {
        break;
      }
      j = compare(zzbzu[i], zzbzu[i]);
    } while (j == 0);
    return j;
    return compare(zzbzu.length, zzbzu.length);
  }
  
  public String zza(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("Flag(");
    paramStringBuilder.append(mVersionCode);
    paramStringBuilder.append(", ");
    paramStringBuilder.append(name);
    paramStringBuilder.append(", ");
    switch (zzbzv)
    {
    default: 
      paramStringBuilder = name;
      int i = zzbzv;
      throw new AssertionError(String.valueOf(paramStringBuilder).length() + 27 + "Invalid type: " + paramStringBuilder + ", " + i);
    case 1: 
      paramStringBuilder.append(zzbzt);
    }
    for (;;)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(zzbzv);
      paramStringBuilder.append(", ");
      paramStringBuilder.append(zzbzw);
      paramStringBuilder.append(")");
      return paramStringBuilder.toString();
      paramStringBuilder.append(zzbgG);
      continue;
      paramStringBuilder.append(zzbgI);
      continue;
      paramStringBuilder.append("'");
      paramStringBuilder.append(zzaFy);
      paramStringBuilder.append("'");
      continue;
      if (zzbzu == null)
      {
        paramStringBuilder.append("null");
      }
      else
      {
        paramStringBuilder.append("'");
        paramStringBuilder.append(new String(zzbzu, UTF_8));
        paramStringBuilder.append("'");
      }
    }
  }
  
  public static class zza
    implements Comparator<zzawc>
  {
    public zza() {}
    
    public int zza(zzawc paramZzawc1, zzawc paramZzawc2)
    {
      if (zzbzw == zzbzw) {
        return name.compareTo(name);
      }
      return zzbzw - zzbzw;
    }
  }
}
