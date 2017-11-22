package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzmb;

@zzmb
public final class zzm
  extends zza
{
  public static final Parcelable.Creator<zzm> CREATOR = new zzn();
  public final int versionCode;
  public final boolean zztH;
  public final boolean zztI;
  public final String zztJ;
  public final boolean zztK;
  public final float zztL;
  public final int zztM;
  
  zzm(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat, int paramInt2)
  {
    versionCode = paramInt1;
    zztH = paramBoolean1;
    zztI = paramBoolean2;
    zztJ = paramString;
    zztK = paramBoolean3;
    zztL = paramFloat;
    zztM = paramInt2;
  }
  
  public zzm(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat, int paramInt)
  {
    this(3, paramBoolean1, paramBoolean2, null, paramBoolean3, paramFloat, paramInt);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}
