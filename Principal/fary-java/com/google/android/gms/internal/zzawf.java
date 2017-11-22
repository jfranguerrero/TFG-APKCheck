package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzawf
  implements Parcelable.Creator<zzawe>
{
  public zzawf() {}
  
  static void zza(zzawe paramZzawe, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, packageName, false);
    zzc.zzc(paramParcel, 3, zzbzy);
    zzc.zzc(paramParcel, 4, zzbzz);
    zzc.zza(paramParcel, 5, zzbzA, false);
    zzc.zza(paramParcel, 6, zzbzB, false);
    zzc.zza(paramParcel, 7, zzbzC);
    zzc.zza(paramParcel, 8, zzbzD, false);
    zzc.zza(paramParcel, 9, zzbzE);
    zzc.zzc(paramParcel, 10, zzbzF);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzawe zziv(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int n = zzb.zzaU(paramParcel);
    boolean bool2 = true;
    boolean bool1 = false;
    String str2 = null;
    String str3 = null;
    int j = 0;
    int k = 0;
    String str4 = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(i1))
      {
      default: 
        zzb.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zzb.zzg(paramParcel, i1);
        break;
      case 2: 
        str4 = zzb.zzq(paramParcel, i1);
        break;
      case 3: 
        k = zzb.zzg(paramParcel, i1);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, i1);
        break;
      case 5: 
        str3 = zzb.zzq(paramParcel, i1);
        break;
      case 6: 
        str2 = zzb.zzq(paramParcel, i1);
        break;
      case 7: 
        bool2 = zzb.zzc(paramParcel, i1);
        break;
      case 8: 
        str1 = zzb.zzq(paramParcel, i1);
        break;
      case 9: 
        bool1 = zzb.zzc(paramParcel, i1);
        break;
      case 10: 
        i = zzb.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zzb.zza(37 + "Overread allowed size end=" + n, paramParcel);
    }
    return new zzawe(m, str4, k, j, str3, str2, bool2, str1, bool1, i);
  }
  
  public zzawe[] zzmn(int paramInt)
  {
    return new zzawe[paramInt];
  }
}
