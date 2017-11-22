package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzmb;

@zzmb
public final class zzc
  extends zza
{
  public static final Parcelable.Creator<zzc> CREATOR = new zzb();
  public final Intent intent;
  public final String mimeType;
  public final String packageName;
  public final String url;
  public final int versionCode;
  public final String zzLY;
  public final String zzLZ;
  public final String zzMa;
  public final String zzMb;
  
  public zzc(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Intent paramIntent)
  {
    versionCode = paramInt;
    zzLY = paramString1;
    url = paramString2;
    mimeType = paramString3;
    packageName = paramString4;
    zzLZ = paramString5;
    zzMa = paramString6;
    zzMb = paramString7;
    intent = paramIntent;
  }
  
  public zzc(Intent paramIntent)
  {
    this(2, null, null, null, null, null, null, null, paramIntent);
  }
  
  public zzc(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
