package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzoo
  implements Parcelable.Creator<zzon>
{
  public zzoo() {}
  
  static void zza(zzon paramZzon, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzVk, false);
    zzc.zza(paramParcel, 3, zzVl, false);
    zzc.zza(paramParcel, 4, zzVm);
    zzc.zza(paramParcel, 5, zzVn);
    zzc.zzb(paramParcel, 6, zzVo, false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public zzon[] zzae(int paramInt)
  {
    return new zzon[paramInt];
  }
  
  public zzon zzu(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    boolean bool1 = false;
    int j = zzb.zzaU(paramParcel);
    boolean bool2 = false;
    String str1 = null;
    String str2 = null;
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
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 4: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, k);
        break;
      case 6: 
        localArrayList = zzb.zzE(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzon(i, str2, str1, bool2, bool1, localArrayList);
  }
}
