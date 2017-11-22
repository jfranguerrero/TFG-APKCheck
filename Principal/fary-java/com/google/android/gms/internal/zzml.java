package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzml
  implements Parcelable.Creator<zzmk>
{
  public zzml() {}
  
  static void zza(zzmk paramZzmk, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzNb, false);
    zzc.zza(paramParcel, 3, body, false);
    zzc.zzb(paramParcel, 4, zzJY, false);
    zzc.zzc(paramParcel, 5, errorCode);
    zzc.zzb(paramParcel, 6, zzJZ, false);
    zzc.zza(paramParcel, 7, zzRJ);
    zzc.zza(paramParcel, 8, zzRK);
    zzc.zza(paramParcel, 9, zzRL);
    zzc.zzb(paramParcel, 10, zzRM, false);
    zzc.zza(paramParcel, 11, zzKe);
    zzc.zzc(paramParcel, 12, orientation);
    zzc.zza(paramParcel, 13, zzRN, false);
    zzc.zza(paramParcel, 14, zzRO);
    zzc.zza(paramParcel, 15, zzRP, false);
    zzc.zza(paramParcel, 18, zzRQ);
    zzc.zza(paramParcel, 19, zzRR, false);
    zzc.zza(paramParcel, 21, zzRS, false);
    zzc.zza(paramParcel, 22, zzRT);
    zzc.zza(paramParcel, 23, zzzn);
    zzc.zza(paramParcel, 24, zzRl);
    zzc.zza(paramParcel, 25, zzRU);
    zzc.zza(paramParcel, 26, zzRV);
    zzc.zza(paramParcel, 28, zzRW, paramInt, false);
    zzc.zza(paramParcel, 29, zzRX, false);
    zzc.zza(paramParcel, 30, zzRY, false);
    zzc.zza(paramParcel, 31, zzzo);
    zzc.zza(paramParcel, 32, zzzp);
    zzc.zza(paramParcel, 33, zzRZ, paramInt, false);
    zzc.zzb(paramParcel, 34, zzSa, false);
    zzc.zzb(paramParcel, 35, zzSb, false);
    zzc.zza(paramParcel, 36, zzSc);
    zzc.zza(paramParcel, 37, zzSd, paramInt, false);
    zzc.zza(paramParcel, 38, zzRB);
    zzc.zza(paramParcel, 39, zzRC, false);
    zzc.zzb(paramParcel, 40, zzKb, false);
    zzc.zza(paramParcel, 42, zzKc);
    zzc.zza(paramParcel, 43, zzSe, false);
    zzc.zza(paramParcel, 44, zzSf, paramInt, false);
    zzc.zza(paramParcel, 45, zzSg, false);
    zzc.zza(paramParcel, 46, zzSh);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzmk[] zzU(int paramInt)
  {
    return new zzmk[paramInt];
  }
  
  public zzmk zzn(Parcel paramParcel)
  {
    int m = zzb.zzaU(paramParcel);
    int k = 0;
    String str11 = null;
    String str10 = null;
    ArrayList localArrayList6 = null;
    int j = 0;
    ArrayList localArrayList5 = null;
    long l4 = 0L;
    boolean bool13 = false;
    long l3 = 0L;
    ArrayList localArrayList4 = null;
    long l2 = 0L;
    int i = 0;
    String str9 = null;
    long l1 = 0L;
    String str8 = null;
    boolean bool12 = false;
    String str7 = null;
    String str6 = null;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    zzms localZzms = null;
    String str5 = null;
    String str4 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    zzok localZzok = null;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    boolean bool4 = false;
    zzmm localZzmm = null;
    boolean bool3 = false;
    String str3 = null;
    ArrayList localArrayList1 = null;
    boolean bool2 = false;
    String str2 = null;
    zzon localZzon = null;
    String str1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(n))
      {
      case 16: 
      case 17: 
      case 20: 
      case 27: 
      case 41: 
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        str11 = zzb.zzq(paramParcel, n);
        break;
      case 3: 
        str10 = zzb.zzq(paramParcel, n);
        break;
      case 4: 
        localArrayList6 = zzb.zzE(paramParcel, n);
        break;
      case 5: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 6: 
        localArrayList5 = zzb.zzE(paramParcel, n);
        break;
      case 7: 
        l4 = zzb.zzi(paramParcel, n);
        break;
      case 8: 
        bool13 = zzb.zzc(paramParcel, n);
        break;
      case 9: 
        l3 = zzb.zzi(paramParcel, n);
        break;
      case 10: 
        localArrayList4 = zzb.zzE(paramParcel, n);
        break;
      case 11: 
        l2 = zzb.zzi(paramParcel, n);
        break;
      case 12: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 13: 
        str9 = zzb.zzq(paramParcel, n);
        break;
      case 14: 
        l1 = zzb.zzi(paramParcel, n);
        break;
      case 15: 
        str8 = zzb.zzq(paramParcel, n);
        break;
      case 18: 
        bool12 = zzb.zzc(paramParcel, n);
        break;
      case 19: 
        str7 = zzb.zzq(paramParcel, n);
        break;
      case 21: 
        str6 = zzb.zzq(paramParcel, n);
        break;
      case 22: 
        bool11 = zzb.zzc(paramParcel, n);
        break;
      case 23: 
        bool10 = zzb.zzc(paramParcel, n);
        break;
      case 24: 
        bool9 = zzb.zzc(paramParcel, n);
        break;
      case 25: 
        bool8 = zzb.zzc(paramParcel, n);
        break;
      case 26: 
        bool7 = zzb.zzc(paramParcel, n);
        break;
      case 28: 
        localZzms = (zzms)zzb.zza(paramParcel, n, zzms.CREATOR);
        break;
      case 29: 
        str5 = zzb.zzq(paramParcel, n);
        break;
      case 30: 
        str4 = zzb.zzq(paramParcel, n);
        break;
      case 31: 
        bool6 = zzb.zzc(paramParcel, n);
        break;
      case 32: 
        bool5 = zzb.zzc(paramParcel, n);
        break;
      case 33: 
        localZzok = (zzok)zzb.zza(paramParcel, n, zzok.CREATOR);
        break;
      case 34: 
        localArrayList3 = zzb.zzE(paramParcel, n);
        break;
      case 35: 
        localArrayList2 = zzb.zzE(paramParcel, n);
        break;
      case 36: 
        bool4 = zzb.zzc(paramParcel, n);
        break;
      case 37: 
        localZzmm = (zzmm)zzb.zza(paramParcel, n, zzmm.CREATOR);
        break;
      case 38: 
        bool3 = zzb.zzc(paramParcel, n);
        break;
      case 39: 
        str3 = zzb.zzq(paramParcel, n);
        break;
      case 40: 
        localArrayList1 = zzb.zzE(paramParcel, n);
        break;
      case 42: 
        bool2 = zzb.zzc(paramParcel, n);
        break;
      case 43: 
        str2 = zzb.zzq(paramParcel, n);
        break;
      case 44: 
        localZzon = (zzon)zzb.zza(paramParcel, n, zzon.CREATOR);
        break;
      case 45: 
        str1 = zzb.zzq(paramParcel, n);
        break;
      case 46: 
        bool1 = zzb.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzmk(k, str11, str10, localArrayList6, j, localArrayList5, l4, bool13, l3, localArrayList4, l2, i, str9, l1, str8, bool12, str7, str6, bool11, bool10, bool9, bool8, bool7, localZzms, str5, str4, bool6, bool5, localZzok, localArrayList3, localArrayList2, bool4, localZzmm, bool3, str3, localArrayList1, bool2, str2, localZzon, str1, bool1);
  }
}
