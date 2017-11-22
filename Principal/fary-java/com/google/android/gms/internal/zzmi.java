package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzmi
  implements Parcelable.Creator<zzmh>
{
  public zzmi() {}
  
  static void zza(zzmh paramZzmh, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzRc, false);
    zzc.zza(paramParcel, 3, zzRd, paramInt, false);
    zzc.zza(paramParcel, 4, zzvj, paramInt, false);
    zzc.zza(paramParcel, 5, zzvd, false);
    zzc.zza(paramParcel, 6, applicationInfo, paramInt, false);
    zzc.zza(paramParcel, 7, zzRe, paramInt, false);
    zzc.zza(paramParcel, 8, zzRf, false);
    zzc.zza(paramParcel, 9, zzRg, false);
    zzc.zza(paramParcel, 10, zzRh, false);
    zzc.zza(paramParcel, 11, zzvf, paramInt, false);
    zzc.zza(paramParcel, 12, zzRi, false);
    zzc.zzc(paramParcel, 13, zzRj);
    zzc.zzb(paramParcel, 14, zzvB, false);
    zzc.zza(paramParcel, 15, zzRk, false);
    zzc.zza(paramParcel, 16, zzRl);
    zzc.zza(paramParcel, 17, zzRm, paramInt, false);
    zzc.zzc(paramParcel, 18, zzRn);
    zzc.zzc(paramParcel, 19, zzRo);
    zzc.zza(paramParcel, 20, zzxa);
    zzc.zza(paramParcel, 21, zzRp, false);
    zzc.zza(paramParcel, 25, zzRq);
    zzc.zza(paramParcel, 26, zzRr, false);
    zzc.zzb(paramParcel, 27, zzRs, false);
    zzc.zza(paramParcel, 28, zzvc, false);
    zzc.zza(paramParcel, 29, zzvx, paramInt, false);
    zzc.zzb(paramParcel, 30, zzRt, false);
    zzc.zza(paramParcel, 31, zzRu);
    zzc.zza(paramParcel, 32, zzRv, paramInt, false);
    zzc.zza(paramParcel, 33, zzRw, false);
    zzc.zza(paramParcel, 34, zzRx);
    zzc.zzc(paramParcel, 35, zzRy);
    zzc.zzc(paramParcel, 36, zzRz);
    zzc.zza(paramParcel, 37, zzRA);
    zzc.zza(paramParcel, 38, zzRB);
    zzc.zza(paramParcel, 39, zzRC, false);
    zzc.zza(paramParcel, 40, zzRD);
    zzc.zza(paramParcel, 41, zzRE, false);
    zzc.zza(paramParcel, 42, zzKc);
    zzc.zzc(paramParcel, 43, zzRF);
    zzc.zza(paramParcel, 44, zzRG, false);
    zzc.zza(paramParcel, 45, zzRH, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzmh[] zzT(int paramInt)
  {
    return new zzmh[paramInt];
  }
  
  public zzmh zzm(Parcel paramParcel)
  {
    int i3 = zzb.zzaU(paramParcel);
    int i2 = 0;
    Bundle localBundle4 = null;
    zzdy localZzdy = null;
    zzec localZzec = null;
    String str11 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    zzqa localZzqa = null;
    Bundle localBundle3 = null;
    int i1 = 0;
    ArrayList localArrayList3 = null;
    Bundle localBundle2 = null;
    boolean bool5 = false;
    Messenger localMessenger = null;
    int n = 0;
    int m = 0;
    float f2 = 0.0F;
    String str7 = null;
    long l2 = 0L;
    String str6 = null;
    ArrayList localArrayList2 = null;
    String str5 = null;
    zzgw localZzgw = null;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    zzmo localZzmo = null;
    String str4 = null;
    float f1 = 0.0F;
    boolean bool4 = false;
    int k = 0;
    int j = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    String str3 = null;
    String str2 = null;
    boolean bool1 = false;
    int i = 0;
    Bundle localBundle1 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < i3)
    {
      int i4 = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(i4))
      {
      case 22: 
      case 23: 
      case 24: 
      default: 
        zzb.zzb(paramParcel, i4);
        break;
      case 1: 
        i2 = zzb.zzg(paramParcel, i4);
        break;
      case 2: 
        localBundle4 = zzb.zzs(paramParcel, i4);
        break;
      case 3: 
        localZzdy = (zzdy)zzb.zza(paramParcel, i4, zzdy.CREATOR);
        break;
      case 4: 
        localZzec = (zzec)zzb.zza(paramParcel, i4, zzec.CREATOR);
        break;
      case 5: 
        str11 = zzb.zzq(paramParcel, i4);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)zzb.zza(paramParcel, i4, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)zzb.zza(paramParcel, i4, PackageInfo.CREATOR);
        break;
      case 8: 
        str10 = zzb.zzq(paramParcel, i4);
        break;
      case 9: 
        str9 = zzb.zzq(paramParcel, i4);
        break;
      case 10: 
        str8 = zzb.zzq(paramParcel, i4);
        break;
      case 11: 
        localZzqa = (zzqa)zzb.zza(paramParcel, i4, zzqa.CREATOR);
        break;
      case 12: 
        localBundle3 = zzb.zzs(paramParcel, i4);
        break;
      case 13: 
        i1 = zzb.zzg(paramParcel, i4);
        break;
      case 14: 
        localArrayList3 = zzb.zzE(paramParcel, i4);
        break;
      case 15: 
        localBundle2 = zzb.zzs(paramParcel, i4);
        break;
      case 16: 
        bool5 = zzb.zzc(paramParcel, i4);
        break;
      case 17: 
        localMessenger = (Messenger)zzb.zza(paramParcel, i4, Messenger.CREATOR);
        break;
      case 18: 
        n = zzb.zzg(paramParcel, i4);
        break;
      case 19: 
        m = zzb.zzg(paramParcel, i4);
        break;
      case 20: 
        f2 = zzb.zzl(paramParcel, i4);
        break;
      case 21: 
        str7 = zzb.zzq(paramParcel, i4);
        break;
      case 25: 
        l2 = zzb.zzi(paramParcel, i4);
        break;
      case 26: 
        str6 = zzb.zzq(paramParcel, i4);
        break;
      case 27: 
        localArrayList2 = zzb.zzE(paramParcel, i4);
        break;
      case 28: 
        str5 = zzb.zzq(paramParcel, i4);
        break;
      case 29: 
        localZzgw = (zzgw)zzb.zza(paramParcel, i4, zzgw.CREATOR);
        break;
      case 30: 
        localArrayList1 = zzb.zzE(paramParcel, i4);
        break;
      case 31: 
        l1 = zzb.zzi(paramParcel, i4);
        break;
      case 32: 
        localZzmo = (zzmo)zzb.zza(paramParcel, i4, zzmo.CREATOR);
        break;
      case 33: 
        str4 = zzb.zzq(paramParcel, i4);
        break;
      case 34: 
        f1 = zzb.zzl(paramParcel, i4);
        break;
      case 35: 
        k = zzb.zzg(paramParcel, i4);
        break;
      case 36: 
        j = zzb.zzg(paramParcel, i4);
        break;
      case 37: 
        bool3 = zzb.zzc(paramParcel, i4);
        break;
      case 38: 
        bool2 = zzb.zzc(paramParcel, i4);
        break;
      case 39: 
        str3 = zzb.zzq(paramParcel, i4);
        break;
      case 40: 
        bool4 = zzb.zzc(paramParcel, i4);
        break;
      case 41: 
        str2 = zzb.zzq(paramParcel, i4);
        break;
      case 42: 
        bool1 = zzb.zzc(paramParcel, i4);
        break;
      case 43: 
        i = zzb.zzg(paramParcel, i4);
        break;
      case 44: 
        localBundle1 = zzb.zzs(paramParcel, i4);
        break;
      case 45: 
        str1 = zzb.zzq(paramParcel, i4);
      }
    }
    if (paramParcel.dataPosition() != i3) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i3, paramParcel);
    }
    return new zzmh(i2, localBundle4, localZzdy, localZzec, str11, localApplicationInfo, localPackageInfo, str10, str9, str8, localZzqa, localBundle3, i1, localArrayList3, localBundle2, bool5, localMessenger, n, m, f2, str7, l2, str6, localArrayList2, str5, localZzgw, localArrayList1, l1, localZzmo, str4, f1, bool4, k, j, bool3, bool2, str3, str2, bool1, i, localBundle1, str1);
  }
}
