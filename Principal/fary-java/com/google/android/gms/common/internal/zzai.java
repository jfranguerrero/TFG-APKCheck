package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzai
  implements Parcelable.Creator<zzah>
{
  public zzai() {}
  
  static void zza(zzah paramZzah, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zzc(paramParcel, 2, paramZzah.zzxD());
    zzc.zzc(paramParcel, 3, paramZzah.zzxE());
    zzc.zza(paramParcel, 4, paramZzah.zzxF(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzah zzaR(Parcel paramParcel)
  {
    int k = 0;
    int m = zzb.zzaU(paramParcel);
    Scope[] arrayOfScope = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 3: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, n, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzah(i, j, k, arrayOfScope);
  }
  
  public zzah[] zzcU(int paramInt)
  {
    return new zzah[paramInt];
  }
}
