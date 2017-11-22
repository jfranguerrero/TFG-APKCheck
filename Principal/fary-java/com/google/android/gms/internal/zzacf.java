package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzacf
  extends zza
{
  public static final Parcelable.Creator<zzacf> CREATOR = new zzacg();
  final int mVersionCode;
  private final zzach zzaFu;
  
  zzacf(int paramInt, zzach paramZzach)
  {
    mVersionCode = paramInt;
    zzaFu = paramZzach;
  }
  
  private zzacf(zzach paramZzach)
  {
    mVersionCode = 1;
    zzaFu = paramZzach;
  }
  
  public static zzacf zza(zzack.zzb<?, ?> paramZzb)
  {
    if ((paramZzb instanceof zzach)) {
      return new zzacf((zzach)paramZzb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacg.zza(this, paramParcel, paramInt);
  }
  
  zzach zzxH()
  {
    return zzaFu;
  }
  
  public zzack.zzb<?, ?> zzxI()
  {
    if (zzaFu != null) {
      return zzaFu;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}
