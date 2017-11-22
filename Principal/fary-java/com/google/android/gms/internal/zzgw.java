package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public class zzgw
  extends zza
{
  public static final Parcelable.Creator<zzgw> CREATOR = new zzgx();
  public final int versionCode;
  public final boolean zzGD;
  public final int zzGE;
  public final boolean zzGF;
  public final int zzGG;
  @Nullable
  public final zzfn zzGH;
  
  public zzgw(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, zzfn paramZzfn)
  {
    versionCode = paramInt1;
    zzGD = paramBoolean1;
    zzGE = paramInt2;
    zzGF = paramBoolean2;
    zzGG = paramInt3;
    zzGH = paramZzfn;
  }
  
  public zzgw(NativeAdOptions paramNativeAdOptions) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzgx.zza(this, paramParcel, paramInt);
  }
}
