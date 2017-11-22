package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzad;

public class zzaya
  implements Parcelable.Creator<zzaxz>
{
  public zzaya() {}
  
  static void zza(zzaxz paramZzaxz, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zza(paramParcel, 2, paramZzaxz.zzOo(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzaxz zziR(Parcel paramParcel)
  {
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    zzad localZzad = null;
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
        localZzad = (zzad)zzb.zza(paramParcel, k, zzad.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzaxz(i, localZzad);
  }
  
  public zzaxz[] zzmM(int paramInt)
  {
    return new zzaxz[paramInt];
  }
}
