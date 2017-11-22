package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzaci
  implements Parcelable.Creator<zzach>
{
  public zzaci() {}
  
  static void zza(zzach paramZzach, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zzc(paramParcel, 2, paramZzach.zzxJ(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzach zzaY(Parcel paramParcel)
  {
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zzb.zzc(paramParcel, k, zzach.zza.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzach(i, localArrayList);
  }
  
  public zzach[] zzda(int paramInt)
  {
    return new zzach[paramInt];
  }
}
