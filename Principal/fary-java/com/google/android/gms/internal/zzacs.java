package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacs
  implements Parcelable.Creator<zzacr>
{
  public zzacs() {}
  
  static void zza(zzacr paramZzacr, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, paramZzacr.getVersionCode());
    zzc.zza(paramParcel, 2, paramZzacr.zzya(), false);
    zzc.zza(paramParcel, 3, paramZzacr.zzyb(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzacr zzbe(Parcel paramParcel)
  {
    zzaco localZzaco = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    Parcel localParcel = null;
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
        localParcel = zzb.zzF(paramParcel, k);
        break;
      case 3: 
        localZzaco = (zzaco)zzb.zza(paramParcel, k, zzaco.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzacr(i, localParcel, localZzaco);
  }
  
  public zzacr[] zzdg(int paramInt)
  {
    return new zzacr[paramInt];
  }
}
