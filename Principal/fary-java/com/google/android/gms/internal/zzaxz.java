package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzad;

public class zzaxz
  extends zza
{
  public static final Parcelable.Creator<zzaxz> CREATOR = new zzaya();
  final int mVersionCode;
  final zzad zzbCr;
  
  zzaxz(int paramInt, zzad paramZzad)
  {
    mVersionCode = paramInt;
    zzbCr = paramZzad;
  }
  
  public zzaxz(zzad paramZzad)
  {
    this(1, paramZzad);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaya.zza(this, paramParcel, paramInt);
  }
  
  public zzad zzOo()
  {
    return zzbCr;
  }
}
