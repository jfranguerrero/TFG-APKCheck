package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzacq
  implements Parcelable.Creator<zzaco.zza>
{
  public zzacq() {}
  
  static void zza(zzaco.zza paramZza, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, className, false);
    zzc.zzc(paramParcel, 3, zzaFN, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzaco.zza zzbd(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
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
        localArrayList = zzb.zzc(paramParcel, k, zzaco.zzb.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzaco.zza(i, str, localArrayList);
  }
  
  public zzaco.zza[] zzdf(int paramInt)
  {
    return new zzaco.zza[paramInt];
  }
}
