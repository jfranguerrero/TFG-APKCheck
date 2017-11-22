package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzfk
  implements Parcelable.Creator<zzfj>
{
  public zzfk() {}
  
  static void zza(zzfj paramZzfj, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zzc(paramParcel, 2, zzAr);
    zzc.zzc(paramParcel, 3, backgroundColor);
    zzc.zzc(paramParcel, 4, zzAs);
    zzc.zzc(paramParcel, 5, zzAt);
    zzc.zzc(paramParcel, 6, zzAu);
    zzc.zzc(paramParcel, 7, zzAv);
    zzc.zzc(paramParcel, 8, zzAw);
    zzc.zzc(paramParcel, 9, zzAx);
    zzc.zza(paramParcel, 10, zzAy, false);
    zzc.zzc(paramParcel, 11, zzAz);
    zzc.zza(paramParcel, 12, zzAA, false);
    zzc.zzc(paramParcel, 13, zzAB);
    zzc.zzc(paramParcel, 14, zzAC);
    zzc.zza(paramParcel, 15, zzAD, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzfj zzg(Parcel paramParcel)
  {
    int i8 = zzb.zzaU(paramParcel);
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    String str3 = null;
    int k = 0;
    String str2 = null;
    int j = 0;
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < i8)
    {
      int i9 = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(i9))
      {
      default: 
        zzb.zzb(paramParcel, i9);
        break;
      case 1: 
        i7 = zzb.zzg(paramParcel, i9);
        break;
      case 2: 
        i6 = zzb.zzg(paramParcel, i9);
        break;
      case 3: 
        i5 = zzb.zzg(paramParcel, i9);
        break;
      case 4: 
        i4 = zzb.zzg(paramParcel, i9);
        break;
      case 5: 
        i3 = zzb.zzg(paramParcel, i9);
        break;
      case 6: 
        i2 = zzb.zzg(paramParcel, i9);
        break;
      case 7: 
        i1 = zzb.zzg(paramParcel, i9);
        break;
      case 8: 
        n = zzb.zzg(paramParcel, i9);
        break;
      case 9: 
        m = zzb.zzg(paramParcel, i9);
        break;
      case 10: 
        str3 = zzb.zzq(paramParcel, i9);
        break;
      case 11: 
        k = zzb.zzg(paramParcel, i9);
        break;
      case 12: 
        str2 = zzb.zzq(paramParcel, i9);
        break;
      case 13: 
        j = zzb.zzg(paramParcel, i9);
        break;
      case 14: 
        i = zzb.zzg(paramParcel, i9);
        break;
      case 15: 
        str1 = zzb.zzq(paramParcel, i9);
      }
    }
    if (paramParcel.dataPosition() != i8) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i8, paramParcel);
    }
    return new zzfj(i7, i6, i5, i4, i3, i2, i1, n, m, str3, k, str2, j, i, str1);
  }
  
  public zzfj[] zzz(int paramInt)
  {
    return new zzfj[paramInt];
  }
}
