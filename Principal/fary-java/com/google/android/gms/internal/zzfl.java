package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzc;

@zzmb
public class zzfl
  extends zzec
{
  public zzfl(zzec paramZzec)
  {
    super(versionCode, zzzk, height, heightPixels, zzzl, width, widthPixels, zzzm, zzzn, zzzo, zzzp);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzzk, false);
    zzc.zzc(paramParcel, 3, height);
    zzc.zzc(paramParcel, 6, width);
    zzc.zzJ(paramParcel, paramInt);
  }
}
