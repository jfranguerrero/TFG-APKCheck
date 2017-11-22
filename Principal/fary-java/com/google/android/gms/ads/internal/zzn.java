package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzn
  implements Parcelable.Creator<zzm>
{
  public zzn() {}
  
  static void zza(zzm paramZzm, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zztH);
    zzc.zza(paramParcel, 3, zztI);
    zzc.zza(paramParcel, 4, zztJ, false);
    zzc.zza(paramParcel, 5, zztK);
    zzc.zza(paramParcel, 6, zztL);
    zzc.zzc(paramParcel, 7, zztM);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzm zzb(Parcel paramParcel)
  {
    int i = 0;
    int k = zzb.zzaU(paramParcel);
    String str = null;
    float f = 0.0F;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
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
        j = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        bool3 = zzb.zzc(paramParcel, m);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, m);
        break;
      case 4: 
        str = zzb.zzq(paramParcel, m);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, m);
        break;
      case 6: 
        f = zzb.zzl(paramParcel, m);
        break;
      case 7: 
        i = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzm(j, bool3, bool2, str, bool1, f, i);
  }
  
  public zzm[] zzi(int paramInt)
  {
    return new zzm[paramInt];
  }
}
