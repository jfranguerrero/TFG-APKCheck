package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzdp
  implements Parcelable.Creator<zzdo>
{
  public zzdp() {}
  
  static void zza(zzdo paramZzdo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, version);
    zzc.zza(paramParcel, 2, url, false);
    zzc.zza(paramParcel, 3, zzyx);
    zzc.zza(paramParcel, 4, zzyy, false);
    zzc.zza(paramParcel, 5, zzyz, false);
    zzc.zza(paramParcel, 6, zzyA, false);
    zzc.zza(paramParcel, 7, zzyB, false);
    zzc.zza(paramParcel, 8, zzyC);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzdo zzd(Parcel paramParcel)
  {
    boolean bool = false;
    Bundle localBundle = null;
    int j = zzb.zzaU(paramParcel);
    long l = 0L;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        l = zzb.zzi(paramParcel, k);
        break;
      case 4: 
        str3 = zzb.zzq(paramParcel, k);
        break;
      case 5: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 6: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 7: 
        localBundle = zzb.zzs(paramParcel, k);
        break;
      case 8: 
        bool = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzdo(i, str4, l, str3, str2, str1, localBundle, bool);
  }
  
  public zzdo[] zzu(int paramInt)
  {
    return new zzdo[paramInt];
  }
}
