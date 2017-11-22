package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzny
  implements Parcelable.Creator<zznx>
{
  public zzny() {}
  
  static void zza(zznx paramZznx, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzRd, paramInt, false);
    zzc.zza(paramParcel, 3, zzvd, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zznx[] zzaa(int paramInt)
  {
    return new zznx[paramInt];
  }
  
  public zznx zzs(Parcel paramParcel)
  {
    String str = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    zzdy localZzdy = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zzb.zzg(paramParcel, k);
        continue;
        localZzdy = (zzdy)zzb.zza(paramParcel, k, zzdy.CREATOR);
        continue;
        str = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zznx(i, localZzdy, str);
  }
}
