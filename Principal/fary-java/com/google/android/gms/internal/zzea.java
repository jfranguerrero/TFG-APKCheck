package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzea
  implements Parcelable.Creator<zzdy>
{
  public zzea() {}
  
  static void zza(zzdy paramZzdy, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 2, zzyF);
    zzc.zza(paramParcel, 3, extras, false);
    zzc.zzc(paramParcel, 4, zzyG);
    zzc.zzb(paramParcel, 5, zzyH, false);
    zzc.zza(paramParcel, 6, zzyI);
    zzc.zzc(paramParcel, 7, zzyJ);
    zzc.zza(paramParcel, 8, zzyK);
    zzc.zza(paramParcel, 9, zzyL, false);
    zzc.zza(paramParcel, 10, zzyM, paramInt, false);
    zzc.zza(paramParcel, 11, zzyN, paramInt, false);
    zzc.zza(paramParcel, 12, zzyO, false);
    zzc.zza(paramParcel, 13, zzyP, false);
    zzc.zza(paramParcel, 14, zzyQ, false);
    zzc.zzb(paramParcel, 15, zzyR, false);
    zzc.zza(paramParcel, 16, zzyS, false);
    zzc.zza(paramParcel, 17, zzyT, false);
    zzc.zza(paramParcel, 18, zzyU);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzdy zze(Parcel paramParcel)
  {
    int m = zzb.zzaU(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    boolean bool3 = false;
    int i = 0;
    boolean bool2 = false;
    String str4 = null;
    zzfj localZzfj = null;
    Location localLocation = null;
    String str3 = null;
    Bundle localBundle2 = null;
    Bundle localBundle1 = null;
    ArrayList localArrayList1 = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
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
        l = zzb.zzi(paramParcel, n);
        break;
      case 3: 
        localBundle3 = zzb.zzs(paramParcel, n);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 5: 
        localArrayList2 = zzb.zzE(paramParcel, n);
        break;
      case 6: 
        bool3 = zzb.zzc(paramParcel, n);
        break;
      case 7: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 8: 
        bool2 = zzb.zzc(paramParcel, n);
        break;
      case 9: 
        str4 = zzb.zzq(paramParcel, n);
        break;
      case 10: 
        localZzfj = (zzfj)zzb.zza(paramParcel, n, zzfj.CREATOR);
        break;
      case 11: 
        localLocation = (Location)zzb.zza(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str3 = zzb.zzq(paramParcel, n);
        break;
      case 13: 
        localBundle2 = zzb.zzs(paramParcel, n);
        break;
      case 14: 
        localBundle1 = zzb.zzs(paramParcel, n);
        break;
      case 15: 
        localArrayList1 = zzb.zzE(paramParcel, n);
        break;
      case 16: 
        str2 = zzb.zzq(paramParcel, n);
        break;
      case 17: 
        str1 = zzb.zzq(paramParcel, n);
        break;
      case 18: 
        bool1 = zzb.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzdy(k, l, localBundle3, j, localArrayList2, bool3, i, bool2, str4, localZzfj, localLocation, str3, localBundle2, localBundle1, localArrayList1, str2, str1, bool1);
  }
  
  public zzdy[] zzv(int paramInt)
  {
    return new zzdy[paramInt];
  }
}
