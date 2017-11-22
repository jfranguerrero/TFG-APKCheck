package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public final class zzqa
  extends zza
{
  public static final Parcelable.Creator<zzqa> CREATOR = new zzqb();
  public final int versionCode;
  public int zzYb;
  public int zzYc;
  public boolean zzYd;
  public String zzaZ;
  
  public zzqa(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramBoolean, false);
  }
  
  public zzqa(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  zzqa(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    versionCode = paramInt1;
    zzaZ = paramString;
    zzYb = paramInt2;
    zzYc = paramInt3;
    zzYd = paramBoolean;
  }
  
  public static zzqa zzkK()
  {
    return new zzqa(10084208, 10084208, true);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzqb.zza(this, paramParcel, paramInt);
  }
}
