package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public class zzmo
  extends zza
{
  public static final Parcelable.Creator<zzmo> CREATOR = new zzmp();
  public final int versionCode;
  public final boolean zzSk;
  public final boolean zzSl;
  public final boolean zzSm;
  
  zzmo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    versionCode = paramInt;
    zzSk = paramBoolean1;
    zzSl = paramBoolean2;
    zzSm = paramBoolean3;
  }
  
  public zzmo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("iap_supported", zzSk);
    localBundle.putBoolean("default_iap_supported", zzSl);
    localBundle.putBoolean("app_streaming_supported", zzSm);
    return localBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzmp.zza(this, paramParcel, paramInt);
  }
}
