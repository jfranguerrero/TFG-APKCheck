package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzapw
  implements Parcelable.Creator<zzapv>
{
  public zzapw() {}
  
  static void zza(zzapv paramZzapv, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, packageName, false);
    zzc.zza(paramParcel, 3, zzbfF, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzapv zzgf(Parcel paramParcel)
  {
    String str2 = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        str2 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzapv(i, str1, str2);
  }
  
  public zzapv[] zzjp(int paramInt)
  {
    return new zzapv[paramInt];
  }
}
