package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaxp
  extends zza
  implements Result
{
  public static final Parcelable.Creator<zzaxp> CREATOR = new zzaxq();
  final int mVersionCode;
  private int zzbCl;
  private Intent zzbCm;
  
  public zzaxp()
  {
    this(0, null);
  }
  
  zzaxp(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mVersionCode = paramInt1;
    zzbCl = paramInt2;
    zzbCm = paramIntent;
  }
  
  public zzaxp(int paramInt, Intent paramIntent)
  {
    this(2, paramInt, paramIntent);
  }
  
  public Status getStatus()
  {
    if (zzbCl == 0) {
      return Status.zzayh;
    }
    return Status.zzayl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaxq.zza(this, paramParcel, paramInt);
  }
  
  public int zzOk()
  {
    return zzbCl;
  }
  
  public Intent zzOl()
  {
    return zzbCm;
  }
}
