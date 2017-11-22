package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzaf;

public class zzayc
  implements Parcelable.Creator<zzayb>
{
  public zzayc() {}
  
  static void zza(zzayb paramZzayb, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zza(paramParcel, 2, paramZzayb.zzxA(), paramInt, false);
    zzc.zza(paramParcel, 3, paramZzayb.zzOp(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzayb zziS(Parcel paramParcel)
  {
    zzaf localZzaf = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    ConnectionResult localConnectionResult = null;
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
        localConnectionResult = (ConnectionResult)zzb.zza(paramParcel, k, ConnectionResult.CREATOR);
        continue;
        localZzaf = (zzaf)zzb.zza(paramParcel, k, zzaf.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzayb(i, localConnectionResult, localZzaf);
  }
  
  public zzayb[] zzmN(int paramInt)
  {
    return new zzayb[paramInt];
  }
}
