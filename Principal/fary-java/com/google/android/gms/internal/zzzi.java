package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzzi
  implements Parcelable.Creator<zzzh>
{
  public zzzi() {}
  
  static void zza(zzzh paramZzzh, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzawE, paramInt, false);
    zzc.zza(paramParcel, 3, zzawF, false);
    zzc.zza(paramParcel, 4, zzawG, false);
    zzc.zza(paramParcel, 5, zzawH, false);
    zzc.zza(paramParcel, 6, zzawI, false);
    zzc.zza(paramParcel, 7, zzawJ, false);
    zzc.zza(paramParcel, 8, zzawK);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzzh zzaF(Parcel paramParcel)
  {
    byte[][] arrayOfByte = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    boolean bool = true;
    int[] arrayOfInt1 = null;
    String[] arrayOfString = null;
    int[] arrayOfInt2 = null;
    byte[] arrayOfByte1 = null;
    zzawe localZzawe = null;
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
        localZzawe = (zzawe)zzb.zza(paramParcel, k, zzawe.CREATOR);
        break;
      case 3: 
        arrayOfByte1 = zzb.zzt(paramParcel, k);
        break;
      case 4: 
        arrayOfInt2 = zzb.zzw(paramParcel, k);
        break;
      case 5: 
        arrayOfString = zzb.zzC(paramParcel, k);
        break;
      case 6: 
        arrayOfInt1 = zzb.zzw(paramParcel, k);
        break;
      case 7: 
        arrayOfByte = zzb.zzu(paramParcel, k);
        break;
      case 8: 
        bool = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzzh(i, localZzawe, arrayOfByte1, arrayOfInt2, arrayOfString, arrayOfInt1, arrayOfByte, bool);
  }
  
  public zzzh[] zzcp(int paramInt)
  {
    return new zzzh[paramInt];
  }
}
