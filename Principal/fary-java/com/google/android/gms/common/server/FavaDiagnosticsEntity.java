package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class FavaDiagnosticsEntity
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zza();
  final int mVersionCode;
  public final String zzaFs;
  public final int zzaFt;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaFs = paramString;
    zzaFt = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}
