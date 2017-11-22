package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzad
  extends zza
{
  public static final Parcelable.Creator<zzad> CREATOR = new zzae();
  final int mVersionCode;
  private final int zzaFf;
  private final GoogleSignInAccount zzaFg;
  private final Account zzagg;
  
  zzad(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    mVersionCode = paramInt1;
    zzagg = paramAccount;
    zzaFf = paramInt2;
    zzaFg = paramGoogleSignInAccount;
  }
  
  public zzad(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public Account getAccount()
  {
    return zzagg;
  }
  
  public int getSessionId()
  {
    return zzaFf;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
  
  @Nullable
  public GoogleSignInAccount zzxy()
  {
    return zzaFg;
  }
}
