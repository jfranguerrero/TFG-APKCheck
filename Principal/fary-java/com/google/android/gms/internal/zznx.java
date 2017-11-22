package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public final class zznx
  extends zza
{
  public static final Parcelable.Creator<zznx> CREATOR = new zzny();
  public final int versionCode;
  public final zzdy zzRd;
  public final String zzvd;
  
  public zznx(int paramInt, zzdy paramZzdy, String paramString)
  {
    versionCode = paramInt;
    zzRd = paramZzdy;
    zzvd = paramString;
  }
  
  public zznx(zzdy paramZzdy, String paramString)
  {
    this(1, paramZzdy, paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzny.zza(this, paramParcel, paramInt);
  }
}
