package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzb
  implements Parcelable.Creator<zzc>
{
  public zzb() {}
  
  static void zza(zzc paramZzc, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, zzLY, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 3, url, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, mimeType, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, packageName, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 6, zzLZ, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, zzMa, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, zzMb, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 9, intent, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, i);
  }
  
  public zzc[] zzH(int paramInt)
  {
    return new zzc[paramInt];
  }
  
  public zzc zzj(Parcel paramParcel)
  {
    Intent localIntent = null;
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        break;
      case 2: 
        str7 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 3: 
        str6 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 4: 
        str5 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 5: 
        str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 6: 
        str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 7: 
        str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 8: 
        str1 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 9: 
        localIntent = (Intent)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, k, Intent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzc(i, str7, str6, str5, str4, str3, str2, str1, localIntent);
  }
}
