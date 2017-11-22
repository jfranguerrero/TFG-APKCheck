package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<ConnectionResult>
{
  public zzb() {}
  
  static void zza(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zzc(paramParcel, 2, paramConnectionResult.getErrorCode());
    zzc.zza(paramParcel, 3, paramConnectionResult.getResolution(), paramInt, false);
    zzc.zza(paramParcel, 4, paramConnectionResult.getErrorMessage(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public ConnectionResult zzaG(Parcel paramParcel)
  {
    String str = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(paramParcel);
    PendingIntent localPendingIntent = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localPendingIntent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, k, PendingIntent.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new ConnectionResult(i, j, localPendingIntent, str);
  }
  
  public ConnectionResult[] zzcq(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}
