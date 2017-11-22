package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzdm
  implements Parcelable.Creator<zzdl>
{
  public zzdm() {}
  
  static void zza(zzdl paramZzdl, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, version);
    zzc.zza(paramParcel, 2, paramZzdl.zzet(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzdl zzc(Parcel paramParcel)
  {
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)zzb.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzdl(i, localParcelFileDescriptor);
  }
  
  public zzdl[] zzt(int paramInt)
  {
    return new zzdl[paramInt];
  }
}
