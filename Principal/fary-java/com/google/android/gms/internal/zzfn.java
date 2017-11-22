package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public class zzfn
  extends zza
{
  public static final Parcelable.Creator<zzfn> CREATOR = new zzfo();
  public final int versionCode;
  public final boolean zzAE;
  
  public zzfn(int paramInt, boolean paramBoolean)
  {
    versionCode = paramInt;
    zzAE = paramBoolean;
  }
  
  public zzfn(VideoOptions paramVideoOptions)
  {
    this(1, paramVideoOptions.getStartMuted());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzfo.zza(this, paramParcel, paramInt);
  }
}
