package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzgx
  implements Parcelable.Creator<zzgw>
{
  public zzgx() {}
  
  static void zza(zzgw paramZzgw, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzGD);
    zzc.zzc(paramParcel, 3, zzGE);
    zzc.zza(paramParcel, 4, zzGF);
    zzc.zzc(paramParcel, 5, zzGG);
    zzc.zza(paramParcel, 6, zzGH, paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzgw[] zzC(int paramInt)
  {
    return new zzgw[paramInt];
  }
  
  public zzgw zzi(Parcel paramParcel)
  {
    int i = 0;
    int m = zzb.zzaU(paramParcel);
    zzfn localZzfn = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
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
        bool2 = zzb.zzc(paramParcel, n);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        bool1 = zzb.zzc(paramParcel, n);
        break;
      case 5: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 6: 
        localZzfn = (zzfn)zzb.zza(paramParcel, n, zzfn.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzgw(k, bool2, j, bool1, i, localZzfn);
  }
}
