package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacn
  implements Parcelable.Creator<zzaco.zzb>
{
  public zzacn() {}
  
  static void zza(zzaco.zzb paramZzb, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzaA, false);
    zzc.zza(paramParcel, 3, zzaFO, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzaco.zzb zzbb(Parcel paramParcel)
  {
    zzack.zza localZza = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    String str = null;
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
        str = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        localZza = (zzack.zza)zzb.zza(paramParcel, k, zzack.zza.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzaco.zzb(i, str, localZza);
  }
  
  public zzaco.zzb[] zzdd(int paramInt)
  {
    return new zzaco.zzb[paramInt];
  }
}
