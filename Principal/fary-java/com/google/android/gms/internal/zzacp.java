package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzacp
  implements Parcelable.Creator<zzaco>
{
  public zzacp() {}
  
  static void zza(zzaco paramZzaco, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zzc(paramParcel, 2, paramZzaco.zzxX(), false);
    zzc.zza(paramParcel, 3, paramZzaco.zzxY(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzaco zzbc(Parcel paramParcel)
  {
    String str = null;
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
        localArrayList = zzb.zzc(paramParcel, k, zzaco.zza.CREATOR);
        break;
      case 3: 
        str = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzaco(i, localArrayList, str);
  }
  
  public zzaco[] zzde(int paramInt)
  {
    return new zzaco[paramInt];
  }
}
