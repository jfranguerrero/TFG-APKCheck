package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzaxq
  implements Parcelable.Creator<zzaxp>
{
  public zzaxq() {}
  
  static void zza(zzaxp paramZzaxp, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zzc(paramParcel, 2, paramZzaxp.zzOk());
    zzc.zza(paramParcel, 3, paramZzaxp.zzOl(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzaxp zziO(Parcel paramParcel)
  {
    int j = 0;
    int k = zzb.zzaU(paramParcel);
    Intent localIntent = null;
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
        j = zzb.zzg(paramParcel, m);
        break;
      case 3: 
        localIntent = (Intent)zzb.zza(paramParcel, m, Intent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzaxp(i, j, localIntent);
  }
  
  public zzaxp[] zzmI(int paramInt)
  {
    return new zzaxp[paramInt];
  }
}
