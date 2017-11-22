package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd
  extends zza
{
  public static final Parcelable.Creator<zzd> CREATOR = new zze();
  final int mVersionCode;
  Integer zzaDA;
  final IBinder zzaDx;
  final Scope[] zzaDy;
  Integer zzaDz;
  
  zzd(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2)
  {
    mVersionCode = paramInt;
    zzaDx = paramIBinder;
    zzaDy = paramArrayOfScope;
    zzaDz = paramInteger1;
    zzaDA = paramInteger2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}
