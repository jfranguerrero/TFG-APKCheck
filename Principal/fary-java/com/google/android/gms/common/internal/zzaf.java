package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaf
  extends zza
{
  public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
  final int mVersionCode;
  IBinder zzaDx;
  private ConnectionResult zzaFh;
  private boolean zzaFi;
  private boolean zzazX;
  
  zzaf(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzaDx = paramIBinder;
    zzaFh = paramConnectionResult;
    zzazX = paramBoolean1;
    zzaFi = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzaf)) {
        return false;
      }
      paramObject = (zzaf)paramObject;
    } while ((zzaFh.equals(zzaFh)) && (zzxz().equals(paramObject.zzxz())));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
  
  public ConnectionResult zzxA()
  {
    return zzaFh;
  }
  
  public boolean zzxB()
  {
    return zzazX;
  }
  
  public boolean zzxC()
  {
    return zzaFi;
  }
  
  public zzr zzxz()
  {
    return zzr.zza.zzbr(zzaDx);
  }
}
