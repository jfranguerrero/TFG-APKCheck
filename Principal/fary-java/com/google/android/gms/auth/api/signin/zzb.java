package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GoogleSignInOptions>
{
  public zzb() {}
  
  static void zza(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zzc(paramParcel, 2, paramGoogleSignInOptions.zzqJ(), false);
    zzc.zza(paramParcel, 3, paramGoogleSignInOptions.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 4, paramGoogleSignInOptions.zzqK());
    zzc.zza(paramParcel, 5, paramGoogleSignInOptions.zzqL());
    zzc.zza(paramParcel, 6, paramGoogleSignInOptions.zzqM());
    zzc.zza(paramParcel, 7, paramGoogleSignInOptions.zzqN(), false);
    zzc.zza(paramParcel, 8, paramGoogleSignInOptions.zzqO(), false);
    zzc.zzJ(paramParcel, i);
  }
  
  public GoogleSignInOptions zzW(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool1 = false;
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(paramParcel);
    String str2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    ArrayList localArrayList = null;
    int i = 0;
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
        localArrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 3: 
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4: 
        bool3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 6: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 7: 
        str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 8: 
        str1 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInOptions(i, localArrayList, localAccount, bool3, bool2, bool1, str2, str1);
  }
  
  public GoogleSignInOptions[] zzbk(int paramInt)
  {
    return new GoogleSignInOptions[paramInt];
  }
}
