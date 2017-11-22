package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzqb
  implements Parcelable.Creator<zzqa>
{
  public zzqb() {}
  
  static void zza(zzqa paramZzqa, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzaZ, false);
    zzc.zzc(paramParcel, 3, zzYb);
    zzc.zzc(paramParcel, 4, zzYc);
    zzc.zza(paramParcel, 5, zzYd);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzqa[] zzaj(int paramInt)
  {
    return new zzqa[paramInt];
  }
  
  public zzqa zzv(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zzb.zzaU(paramParcel);
    String str = null;
    int i = 0;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, n);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 5: 
        bool = zzb.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzqa(k, str, j, i, bool);
  }
}
