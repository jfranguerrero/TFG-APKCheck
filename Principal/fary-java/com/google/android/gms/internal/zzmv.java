package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public class zzmv
  extends zza
{
  public static final Parcelable.Creator<zzmv> CREATOR = new zzmw();
  final int mVersionCode;
  String zzFy;
  
  zzmv(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzFy = paramString;
  }
  
  public zzmv(String paramString)
  {
    mVersionCode = 1;
    zzFy = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzmw.zza(this, paramParcel, paramInt);
  }
  
  public String zzje()
  {
    return zzFy;
  }
}
