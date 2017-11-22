package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzapv
  extends zza
{
  public static final Parcelable.Creator<zzapv> CREATOR = new zzapw();
  public final String packageName;
  public final int versionCode;
  public final String zzbfF;
  
  zzapv(int paramInt, String paramString1, String paramString2)
  {
    versionCode = paramInt;
    packageName = paramString1;
    zzbfF = paramString2;
  }
  
  public zzapv(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzapw.zza(this, paramParcel, paramInt);
  }
}
