package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzed
  implements Parcelable.Creator<zzec>
{
  public zzed() {}
  
  static void zza(zzec paramZzec, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzzk, false);
    zzc.zzc(paramParcel, 3, height);
    zzc.zzc(paramParcel, 4, heightPixels);
    zzc.zza(paramParcel, 5, zzzl);
    zzc.zzc(paramParcel, 6, width);
    zzc.zzc(paramParcel, 7, widthPixels);
    zzc.zza(paramParcel, 8, zzzm, paramInt, false);
    zzc.zza(paramParcel, 9, zzzn);
    zzc.zza(paramParcel, 10, zzzo);
    zzc.zza(paramParcel, 11, zzzp);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzec zzf(Parcel paramParcel)
  {
    zzec[] arrayOfZzec = null;
    boolean bool1 = false;
    int i1 = zzb.zzaU(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    int j = 0;
    boolean bool4 = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(i2))
      {
      default: 
        zzb.zzb(paramParcel, i2);
        break;
      case 1: 
        n = zzb.zzg(paramParcel, i2);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, i2);
        break;
      case 3: 
        m = zzb.zzg(paramParcel, i2);
        break;
      case 4: 
        k = zzb.zzg(paramParcel, i2);
        break;
      case 5: 
        bool4 = zzb.zzc(paramParcel, i2);
        break;
      case 6: 
        j = zzb.zzg(paramParcel, i2);
        break;
      case 7: 
        i = zzb.zzg(paramParcel, i2);
        break;
      case 8: 
        arrayOfZzec = (zzec[])zzb.zzb(paramParcel, i2, zzec.CREATOR);
        break;
      case 9: 
        bool3 = zzb.zzc(paramParcel, i2);
        break;
      case 10: 
        bool2 = zzb.zzc(paramParcel, i2);
        break;
      case 11: 
        bool1 = zzb.zzc(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i1, paramParcel);
    }
    return new zzec(n, str, m, k, bool4, j, i, arrayOfZzec, bool3, bool2, bool1);
  }
  
  public zzec[] zzw(int paramInt)
  {
    return new zzec[paramInt];
  }
}
