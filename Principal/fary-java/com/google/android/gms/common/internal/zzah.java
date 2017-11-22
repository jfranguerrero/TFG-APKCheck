package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzah
  extends zza
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzai();
  final int mVersionCode;
  @Deprecated
  private final Scope[] zzaDy;
  private final int zzaFj;
  private final int zzaFk;
  
  zzah(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    mVersionCode = paramInt1;
    zzaFj = paramInt2;
    zzaFk = paramInt3;
    zzaDy = paramArrayOfScope;
  }
  
  public zzah(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzai.zza(this, paramParcel, paramInt);
  }
  
  public int zzxD()
  {
    return zzaFj;
  }
  
  public int zzxE()
  {
    return zzaFk;
  }
  
  @Deprecated
  public Scope[] zzxF()
  {
    return zzaDy;
  }
}
