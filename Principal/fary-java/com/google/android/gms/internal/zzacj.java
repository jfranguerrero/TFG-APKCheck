package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacj
  implements Parcelable.Creator<zzach.zza>
{
  public zzacj() {}
  
  static void zza(zzach.zza paramZza, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzaFy, false);
    zzc.zzc(paramParcel, 3, zzaFz);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzach.zza zzaZ(Parcel paramParcel)
  {
    int j = 0;
    int k = zzb.zzaU(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, m);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzach.zza(i, str, j);
  }
  
  public zzach.zza[] zzdb(int paramInt)
  {
    return new zzach.zza[paramInt];
  }
}
