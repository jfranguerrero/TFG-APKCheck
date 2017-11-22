package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzmn
  implements Parcelable.Creator<zzmm>
{
  public zzmn() {}
  
  static void zza(zzmm paramZzmm, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzSi);
    zzc.zzb(paramParcel, 3, zzSj, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzmm[] zzV(int paramInt)
  {
    return new zzmm[paramInt];
  }
  
  public zzmm zzo(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zzb.zzaU(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
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
        bool = zzb.zzc(paramParcel, k);
        break;
      case 3: 
        localArrayList = zzb.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzmm(i, bool, localArrayList);
  }
}
