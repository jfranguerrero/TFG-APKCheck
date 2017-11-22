package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class zzj
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<zzj> CREATOR = new zzk();
  final int version;
  final int zzaEm;
  int zzaEn;
  String zzaEo;
  IBinder zzaEp;
  Scope[] zzaEq;
  Bundle zzaEr;
  Account zzaEs;
  long zzaEt;
  
  public zzj(int paramInt)
  {
    version = 3;
    zzaEn = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    zzaEm = paramInt;
  }
  
  zzj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, long paramLong)
  {
    version = paramInt1;
    zzaEm = paramInt2;
    zzaEn = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      zzaEo = "com.google.android.gms";
      if (paramInt1 >= 2) {
        break label78;
      }
    }
    for (zzaEs = zzbq(paramIBinder);; zzaEs = paramAccount)
    {
      zzaEq = paramArrayOfScope;
      zzaEr = paramBundle;
      zzaEt = paramLong;
      return;
      zzaEo = paramString;
      break;
      label78:
      zzaEp = paramIBinder;
    }
  }
  
  private Account zzbq(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = zza.zza(zzr.zza.zzbr(paramIBinder));
    }
    return localAccount;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public zzj zzb(zzr paramZzr)
  {
    if (paramZzr != null) {
      zzaEp = paramZzr.asBinder();
    }
    return this;
  }
  
  public zzj zzdq(String paramString)
  {
    zzaEo = paramString;
    return this;
  }
  
  public zzj zze(Account paramAccount)
  {
    zzaEs = paramAccount;
    return this;
  }
  
  public zzj zzf(Collection<Scope> paramCollection)
  {
    zzaEq = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }
  
  public zzj zzp(Bundle paramBundle)
  {
    zzaEr = paramBundle;
    return this;
  }
}
