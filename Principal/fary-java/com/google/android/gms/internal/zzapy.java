package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzapy
  implements Parcelable.Creator<zzapx>
{
  public zzapy() {}
  
  static void zza(zzapx paramZzapx, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, paramZzapx.zzFY(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzapx zzgg(Parcel paramParcel)
  {
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        arrayOfByte = zzb.zzt(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzapx(i, arrayOfByte);
  }
  
  public zzapx[] zzjq(int paramInt)
  {
    return new zzapx[paramInt];
  }
}
