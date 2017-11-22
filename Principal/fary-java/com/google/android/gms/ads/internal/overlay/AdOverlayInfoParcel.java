package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;

@zzmb
public final class AdOverlayInfoParcel
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzg();
  public final int orientation;
  public final String url;
  public final int versionCode;
  public final zzc zzMW;
  public final zzdt zzMX;
  public final zzh zzMY;
  public final zzqp zzMZ;
  public final zzht zzNa;
  public final String zzNb;
  public final boolean zzNc;
  public final String zzNd;
  public final zzq zzNe;
  public final int zzNf;
  public final zzhz zzNg;
  public final String zzNh;
  public final zzm zzNi;
  public final zzqa zzvf;
  
  AdOverlayInfoParcel(int paramInt1, zzc paramZzc, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, zzqa paramZzqa, IBinder paramIBinder6, String paramString4, zzm paramZzm)
  {
    versionCode = paramInt1;
    zzMW = paramZzc;
    zzMX = ((zzdt)zze.zzE(zzd.zza.zzcd(paramIBinder1)));
    zzMY = ((zzh)zze.zzE(zzd.zza.zzcd(paramIBinder2)));
    zzMZ = ((zzqp)zze.zzE(zzd.zza.zzcd(paramIBinder3)));
    zzNa = ((zzht)zze.zzE(zzd.zza.zzcd(paramIBinder4)));
    zzNb = paramString1;
    zzNc = paramBoolean;
    zzNd = paramString2;
    zzNe = ((zzq)zze.zzE(zzd.zza.zzcd(paramIBinder5)));
    orientation = paramInt2;
    zzNf = paramInt3;
    url = paramString3;
    zzvf = paramZzqa;
    zzNg = ((zzhz)zze.zzE(zzd.zza.zzcd(paramIBinder6)));
    zzNh = paramString4;
    zzNi = paramZzm;
  }
  
  public AdOverlayInfoParcel(zzc paramZzc, zzdt paramZzdt, zzh paramZzh, zzq paramZzq, zzqa paramZzqa)
  {
    versionCode = 4;
    zzMW = paramZzc;
    zzMX = paramZzdt;
    zzMY = paramZzh;
    zzMZ = null;
    zzNa = null;
    zzNb = null;
    zzNc = false;
    zzNd = null;
    zzNe = paramZzq;
    orientation = -1;
    zzNf = 4;
    url = null;
    zzvf = paramZzqa;
    zzNg = null;
    zzNh = null;
    zzNi = null;
  }
  
  public AdOverlayInfoParcel(zzdt paramZzdt, zzh paramZzh, zzq paramZzq, zzqp paramZzqp, int paramInt, zzqa paramZzqa, String paramString, zzm paramZzm)
  {
    versionCode = 4;
    zzMW = null;
    zzMX = paramZzdt;
    zzMY = paramZzh;
    zzMZ = paramZzqp;
    zzNa = null;
    zzNb = null;
    zzNc = false;
    zzNd = null;
    zzNe = paramZzq;
    orientation = paramInt;
    zzNf = 1;
    url = null;
    zzvf = paramZzqa;
    zzNg = null;
    zzNh = paramString;
    zzNi = paramZzm;
  }
  
  public AdOverlayInfoParcel(zzdt paramZzdt, zzh paramZzh, zzq paramZzq, zzqp paramZzqp, boolean paramBoolean, int paramInt, zzqa paramZzqa)
  {
    versionCode = 4;
    zzMW = null;
    zzMX = paramZzdt;
    zzMY = paramZzh;
    zzMZ = paramZzqp;
    zzNa = null;
    zzNb = null;
    zzNc = paramBoolean;
    zzNd = null;
    zzNe = paramZzq;
    orientation = paramInt;
    zzNf = 2;
    url = null;
    zzvf = paramZzqa;
    zzNg = null;
    zzNh = null;
    zzNi = null;
  }
  
  public AdOverlayInfoParcel(zzdt paramZzdt, zzh paramZzh, zzht paramZzht, zzq paramZzq, zzqp paramZzqp, boolean paramBoolean, int paramInt, String paramString, zzqa paramZzqa, zzhz paramZzhz)
  {
    versionCode = 4;
    zzMW = null;
    zzMX = paramZzdt;
    zzMY = paramZzh;
    zzMZ = paramZzqp;
    zzNa = paramZzht;
    zzNb = null;
    zzNc = paramBoolean;
    zzNd = null;
    zzNe = paramZzq;
    orientation = paramInt;
    zzNf = 3;
    url = paramString;
    zzvf = paramZzqa;
    zzNg = paramZzhz;
    zzNh = null;
    zzNi = null;
  }
  
  public AdOverlayInfoParcel(zzdt paramZzdt, zzh paramZzh, zzht paramZzht, zzq paramZzq, zzqp paramZzqp, boolean paramBoolean, int paramInt, String paramString1, String paramString2, zzqa paramZzqa, zzhz paramZzhz)
  {
    versionCode = 4;
    zzMW = null;
    zzMX = paramZzdt;
    zzMY = paramZzh;
    zzMZ = paramZzqp;
    zzNa = paramZzht;
    zzNb = paramString2;
    zzNc = paramBoolean;
    zzNd = paramString1;
    zzNe = paramZzq;
    orientation = paramInt;
    zzNf = 3;
    url = null;
    zzvf = paramZzqa;
    zzNg = paramZzhz;
    zzNh = null;
    zzNi = null;
  }
  
  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static AdOverlayInfoParcel zzb(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzhs()
  {
    return zze.zzA(zzMX).asBinder();
  }
  
  IBinder zzht()
  {
    return zze.zzA(zzMY).asBinder();
  }
  
  IBinder zzhu()
  {
    return zze.zzA(zzMZ).asBinder();
  }
  
  IBinder zzhv()
  {
    return zze.zzA(zzNa).asBinder();
  }
  
  IBinder zzhw()
  {
    return zze.zzA(zzNg).asBinder();
  }
  
  IBinder zzhx()
  {
    return zze.zzA(zzNe).asBinder();
  }
}
