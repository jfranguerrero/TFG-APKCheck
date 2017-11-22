package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacg
  implements Parcelable.Creator<zzacf>
{
  public zzacg() {}
  
  static void zza(zzacf paramZzacf, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zza(paramParcel, 2, paramZzacf.zzxH(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzacf zzaX(Parcel paramParcel)
  {
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    zzach localZzach = null;
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
        localZzach = (zzach)zzb.zza(paramParcel, k, zzach.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzacf(i, localZzach);
  }
  
  public zzacf[] zzcZ(int paramInt)
  {
    return new zzacf[paramInt];
  }
}
