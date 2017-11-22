package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaxw
  extends zza
{
  public static final Parcelable.Creator<zzaxw> CREATOR = new zzaxx();
  final int mVersionCode;
  private final Account zzagg;
  private final String zzajk;
  private final Scope[] zzbCp;
  
  zzaxw(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    mVersionCode = paramInt;
    zzagg = paramAccount;
    zzbCp = paramArrayOfScope;
    zzajk = paramString;
  }
  
  public Account getAccount()
  {
    return zzagg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaxx.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzOm()
  {
    return zzbCp;
  }
  
  public String zzqN()
  {
    return zzajk;
  }
}
