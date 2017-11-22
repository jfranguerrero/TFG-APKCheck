package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class zzawa
  extends zza
  implements Comparable<zzawa>
{
  public static final Parcelable.Creator<zzawa> CREATOR = new zzawb();
  final int mVersionCode;
  public final int zzbzp;
  public final zzawc[] zzbzq;
  public final String[] zzbzr;
  public final Map<String, zzawc> zzbzs;
  
  zzawa(int paramInt1, int paramInt2, zzawc[] paramArrayOfZzawc, String[] paramArrayOfString)
  {
    mVersionCode = paramInt1;
    zzbzp = paramInt2;
    zzbzq = paramArrayOfZzawc;
    zzbzs = new TreeMap();
    paramInt2 = paramArrayOfZzawc.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      zzawc localZzawc = paramArrayOfZzawc[paramInt1];
      zzbzs.put(name, localZzawc);
      paramInt1 += 1;
    }
    zzbzr = paramArrayOfString;
    if (zzbzr != null) {
      Arrays.sort(zzbzr);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof zzawa))
      {
        paramObject = (zzawa)paramObject;
        bool1 = bool2;
        if (mVersionCode == mVersionCode)
        {
          bool1 = bool2;
          if (zzbzp == zzbzp)
          {
            bool1 = bool2;
            if (zzaa.equal(zzbzs, zzbzs))
            {
              bool1 = bool2;
              if (Arrays.equals(zzbzr, zzbzr)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Configuration(");
    localStringBuilder.append(mVersionCode);
    localStringBuilder.append(", ");
    localStringBuilder.append(zzbzp);
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    Object localObject = zzbzs.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((zzawc)((Iterator)localObject).next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append(")");
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    if (zzbzr != null)
    {
      localObject = zzbzr;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append(", ");
        i += 1;
      }
    }
    localStringBuilder.append("null");
    localStringBuilder.append(")");
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzawb.zza(this, paramParcel, paramInt);
  }
  
  public int zza(zzawa paramZzawa)
  {
    return zzbzp - zzbzp;
  }
}
