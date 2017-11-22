package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public final class zzfj
  extends zza
{
  public static final Parcelable.Creator<zzfj> CREATOR = new zzfk();
  public final int backgroundColor;
  public final int versionCode;
  public final String zzAA;
  public final int zzAB;
  public final int zzAC;
  public final String zzAD;
  public final int zzAr;
  public final int zzAs;
  public final int zzAt;
  public final int zzAu;
  public final int zzAv;
  public final int zzAw;
  public final int zzAx;
  public final String zzAy;
  public final int zzAz;
  
  zzfj(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    versionCode = paramInt1;
    zzAr = paramInt2;
    backgroundColor = paramInt3;
    zzAs = paramInt4;
    zzAt = paramInt5;
    zzAu = paramInt6;
    zzAv = paramInt7;
    zzAw = paramInt8;
    zzAx = paramInt9;
    zzAy = paramString1;
    zzAz = paramInt10;
    zzAA = paramString2;
    zzAB = paramInt11;
    zzAC = paramInt12;
    zzAD = paramString3;
  }
  
  public zzfj(SearchAdRequest paramSearchAdRequest)
  {
    versionCode = 1;
    zzAr = paramSearchAdRequest.getAnchorTextColor();
    backgroundColor = paramSearchAdRequest.getBackgroundColor();
    zzAs = paramSearchAdRequest.getBackgroundGradientBottom();
    zzAt = paramSearchAdRequest.getBackgroundGradientTop();
    zzAu = paramSearchAdRequest.getBorderColor();
    zzAv = paramSearchAdRequest.getBorderThickness();
    zzAw = paramSearchAdRequest.getBorderType();
    zzAx = paramSearchAdRequest.getCallButtonColor();
    zzAy = paramSearchAdRequest.getCustomChannels();
    zzAz = paramSearchAdRequest.getDescriptionTextColor();
    zzAA = paramSearchAdRequest.getFontFace();
    zzAB = paramSearchAdRequest.getHeaderTextColor();
    zzAC = paramSearchAdRequest.getHeaderTextSize();
    zzAD = paramSearchAdRequest.getQuery();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzfk.zza(this, paramParcel, paramInt);
  }
}
