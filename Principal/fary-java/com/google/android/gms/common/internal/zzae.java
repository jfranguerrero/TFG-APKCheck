package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzae
  implements Parcelable.Creator<zzad>
{
  public zzae() {}
  
  static void zza(zzad paramZzad, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, mVersionCode);
    zzc.zza(paramParcel, 2, paramZzad.getAccount(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramZzad.getSessionId());
    zzc.zza(paramParcel, 4, paramZzad.zzxy(), paramInt, false);
    zzc.zzJ(paramParcel, i);
  }
  
  public zzad zzaP(Parcel paramParcel)
  {
    GoogleSignInAccount localGoogleSignInAccount = null;
    int j = 0;
    int m = zzb.zzaU(paramParcel);
    Account localAccount = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = zzb.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        localAccount = (Account)zzb.zza(paramParcel, k, Account.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        k = zzb.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localGoogleSignInAccount = (GoogleSignInAccount)zzb.zza(paramParcel, k, GoogleSignInAccount.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzad(i, localAccount, j, localGoogleSignInAccount);
  }
  
  public zzad[] zzcS(int paramInt)
  {
    return new zzad[paramInt];
  }
}
