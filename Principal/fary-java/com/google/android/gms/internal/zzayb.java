package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaf;

public class zzayb
  extends zza
{
  public static final Parcelable.Creator<zzayb> CREATOR = new zzayc();
  final int mVersionCode;
  private final ConnectionResult zzaFh;
  private final zzaf zzbCs;
  
  public zzayb(int paramInt)
  {
    this(new ConnectionResult(paramInt, null), null);
  }
  
  zzayb(int paramInt, ConnectionResult paramConnectionResult, zzaf paramZzaf)
  {
    mVersionCode = paramInt;
    zzaFh = paramConnectionResult;
    zzbCs = paramZzaf;
  }
  
  public zzayb(ConnectionResult paramConnectionResult, zzaf paramZzaf)
  {
    this(1, paramConnectionResult, paramZzaf);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzayc.zza(this, paramParcel, paramInt);
  }
  
  public zzaf zzOp()
  {
    return zzbCs;
  }
  
  public ConnectionResult zzxA()
  {
    return zzaFh;
  }
}
