package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<DataHolder>
{
  public zze() {}
  
  static void zza(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zza(paramParcel, 1, paramDataHolder.zzwE(), false);
    zzc.zza(paramParcel, 2, paramDataHolder.zzwF(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramDataHolder.getStatusCode());
    zzc.zza(paramParcel, 4, paramDataHolder.zzwy(), false);
    zzc.zzc(paramParcel, 1000, mVersionCode);
    zzc.zzJ(paramParcel, i);
  }
  
  public DataHolder zzaK(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = zzb.zzaU(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        arrayOfString = zzb.zzC(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])zzb.zzb(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 4: 
        localBundle = zzb.zzs(paramParcel, m);
        break;
      case 1000: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.zzwD();
    return paramParcel;
  }
  
  public DataHolder[] zzcF(int paramInt)
  {
    return new DataHolder[paramInt];
  }
}
