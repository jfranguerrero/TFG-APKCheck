package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class zzawe
  extends zza
{
  public static final Parcelable.Creator<zzawe> CREATOR = new zzawf();
  public final String packageName;
  public final int versionCode;
  public final String zzbzA;
  public final String zzbzB;
  public final boolean zzbzC;
  public final String zzbzD;
  public final boolean zzbzE;
  public final int zzbzF;
  public final int zzbzy;
  public final int zzbzz;
  
  public zzawe(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    versionCode = paramInt1;
    packageName = paramString1;
    zzbzy = paramInt2;
    zzbzz = paramInt3;
    zzbzA = paramString2;
    zzbzB = paramString3;
    zzbzC = paramBoolean1;
    zzbzD = paramString4;
    zzbzE = paramBoolean2;
    zzbzF = paramInt4;
  }
  
  public zzawe(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    versionCode = 1;
    packageName = ((String)zzac.zzw(paramString1));
    zzbzy = paramInt1;
    zzbzz = paramInt2;
    zzbzD = paramString2;
    zzbzA = paramString3;
    zzbzB = paramString4;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      zzbzC = bool;
      zzbzE = paramBoolean;
      zzbzF = paramInt3;
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzawe)) {
        break;
      }
      paramObject = (zzawe)paramObject;
    } while ((versionCode == versionCode) && (packageName.equals(packageName)) && (zzbzy == zzbzy) && (zzbzz == zzbzz) && (zzaa.equal(zzbzD, zzbzD)) && (zzaa.equal(zzbzA, zzbzA)) && (zzaa.equal(zzbzB, zzbzB)) && (zzbzC == zzbzC) && (zzbzE == zzbzE) && (zzbzF == zzbzF));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(versionCode), packageName, Integer.valueOf(zzbzy), Integer.valueOf(zzbzz), zzbzD, zzbzA, zzbzB, Boolean.valueOf(zzbzC), Boolean.valueOf(zzbzE), Integer.valueOf(zzbzF) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(versionCode).append(',');
    localStringBuilder.append("package=").append(packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(zzbzy).append(',');
    localStringBuilder.append("logSource=").append(zzbzz).append(',');
    localStringBuilder.append("logSourceName=").append(zzbzD).append(',');
    localStringBuilder.append("uploadAccount=").append(zzbzA).append(',');
    localStringBuilder.append("loggingId=").append(zzbzB).append(',');
    localStringBuilder.append("logAndroidId=").append(zzbzC).append(',');
    localStringBuilder.append("isAnonymous=").append(zzbzE).append(',');
    localStringBuilder.append("qosTier=").append(zzbzF);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzawf.zza(this, paramParcel, paramInt);
  }
}
