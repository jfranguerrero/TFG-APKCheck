package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzan
  extends zza
{
  public static final Parcelable.Creator<zzan> CREATOR = new zzao();
  final int mVersionCode;
  
  zzan(int paramInt)
  {
    mVersionCode = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt);
  }
}
