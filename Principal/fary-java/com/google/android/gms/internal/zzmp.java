package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzmp
  implements Parcelable.Creator<zzmo>
{
  public zzmp() {}
  
  static void zza(zzmo paramZzmo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzSk);
    zzc.zza(paramParcel, 3, zzSl);
    zzc.zza(paramParcel, 4, zzSm);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzmo[] zzW(int paramInt)
  {
    return new zzmo[paramInt];
  }
  
  public zzmo zzp(Parcel paramParcel)
  {
    boolean bool3 = false;
    int j = zzb.zzaU(paramParcel);
    boolean bool2 = false;
    boolean bool1 = false;
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
        bool1 = zzb.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 4: 
        bool3 = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzmo(i, bool1, bool2, bool3);
  }
}
