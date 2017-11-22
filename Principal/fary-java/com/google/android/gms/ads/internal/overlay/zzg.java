package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.internal.zzqa;

public class zzg
  implements Parcelable.Creator<AdOverlayInfoParcel>
{
  public zzg() {}
  
  static void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, zzMW, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 3, paramAdOverlayInfoParcel.zzhs(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramAdOverlayInfoParcel.zzht(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramAdOverlayInfoParcel.zzhu(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 6, paramAdOverlayInfoParcel.zzhv(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, zzNb, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, zzNc);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 9, zzNd, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 10, paramAdOverlayInfoParcel.zzhx(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 11, orientation);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 12, zzNf);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 13, url, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 14, zzvf, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 15, paramAdOverlayInfoParcel.zzhw(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 16, zzNh, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 17, zzNi, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzJ(paramParcel, i);
  }
  
  public AdOverlayInfoParcel[] zzL(int paramInt)
  {
    return new AdOverlayInfoParcel[paramInt];
  }
  
  public AdOverlayInfoParcel zzk(Parcel paramParcel)
  {
    int m = zzb.zzaU(paramParcel);
    int k = 0;
    zzc localZzc = null;
    IBinder localIBinder6 = null;
    IBinder localIBinder5 = null;
    IBinder localIBinder4 = null;
    IBinder localIBinder3 = null;
    String str4 = null;
    boolean bool = false;
    String str3 = null;
    IBinder localIBinder2 = null;
    int j = 0;
    int i = 0;
    String str2 = null;
    zzqa localZzqa = null;
    IBinder localIBinder1 = null;
    String str1 = null;
    zzm localZzm = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        localZzc = (zzc)zzb.zza(paramParcel, n, zzc.CREATOR);
        break;
      case 3: 
        localIBinder6 = zzb.zzr(paramParcel, n);
        break;
      case 4: 
        localIBinder5 = zzb.zzr(paramParcel, n);
        break;
      case 5: 
        localIBinder4 = zzb.zzr(paramParcel, n);
        break;
      case 6: 
        localIBinder3 = zzb.zzr(paramParcel, n);
        break;
      case 7: 
        str4 = zzb.zzq(paramParcel, n);
        break;
      case 8: 
        bool = zzb.zzc(paramParcel, n);
        break;
      case 9: 
        str3 = zzb.zzq(paramParcel, n);
        break;
      case 10: 
        localIBinder2 = zzb.zzr(paramParcel, n);
        break;
      case 11: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 12: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 13: 
        str2 = zzb.zzq(paramParcel, n);
        break;
      case 14: 
        localZzqa = (zzqa)zzb.zza(paramParcel, n, zzqa.CREATOR);
        break;
      case 15: 
        localIBinder1 = zzb.zzr(paramParcel, n);
        break;
      case 16: 
        str1 = zzb.zzq(paramParcel, n);
        break;
      case 17: 
        localZzm = (zzm)zzb.zza(paramParcel, n, zzm.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new AdOverlayInfoParcel(k, localZzc, localIBinder6, localIBinder5, localIBinder4, localIBinder3, str4, bool, str3, localIBinder2, j, i, str2, localZzqa, localIBinder1, str1, localZzm);
  }
}
