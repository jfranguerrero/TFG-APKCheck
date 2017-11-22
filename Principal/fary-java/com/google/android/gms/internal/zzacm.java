package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacm
  implements Parcelable.Creator<zzack.zza>
{
  public zzacm() {}
  
  static void zza(zzack.zza paramZza, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, paramZza.getVersionCode());
    zzc.zzc(paramParcel, 2, paramZza.zzxL());
    zzc.zza(paramParcel, 3, paramZza.zzxM());
    zzc.zzc(paramParcel, 4, paramZza.zzxN());
    zzc.zza(paramParcel, 5, paramZza.zzxO());
    zzc.zza(paramParcel, 6, paramZza.zzxP(), false);
    zzc.zzc(paramParcel, 7, paramZza.zzxQ());
    zzc.zza(paramParcel, 8, paramZza.zzxS(), false);
    zzc.zza(paramParcel, 9, paramZza.zzxU(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzack.zza zzba(Parcel paramParcel)
  {
    zzacf localZzacf = null;
    int i = 0;
    int n = zzb.zzaU(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(i1))
      {
      default: 
        zzb.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zzb.zzg(paramParcel, i1);
        break;
      case 2: 
        k = zzb.zzg(paramParcel, i1);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, i1);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, i1);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, i1);
        break;
      case 6: 
        str2 = zzb.zzq(paramParcel, i1);
        break;
      case 7: 
        i = zzb.zzg(paramParcel, i1);
        break;
      case 8: 
        str1 = zzb.zzq(paramParcel, i1);
        break;
      case 9: 
        localZzacf = (zzacf)zzb.zza(paramParcel, i1, zzacf.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zzb.zza(37 + "Overread allowed size end=" + n, paramParcel);
    }
    return new zzack.zza(m, k, bool2, j, bool1, str2, i, str1, localZzacf);
  }
  
  public zzack.zza[] zzdc(int paramInt)
  {
    return new zzack.zza[paramInt];
  }
}
