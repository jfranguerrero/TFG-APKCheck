package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzmb;

@zzmb
public final class GInAppPurchaseManagerInfoParcel
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GInAppPurchaseManagerInfoParcel> CREATOR = new zza();
  public final int versionCode;
  public final zzky zzOL;
  public final Context zzOM;
  public final zzj zzON;
  public final zzk zzvC;
  
  GInAppPurchaseManagerInfoParcel(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    versionCode = paramInt;
    zzvC = ((zzk)zze.zzE(zzd.zza.zzcd(paramIBinder1)));
    zzOL = ((zzky)zze.zzE(zzd.zza.zzcd(paramIBinder2)));
    zzOM = ((Context)zze.zzE(zzd.zza.zzcd(paramIBinder3)));
    zzON = ((zzj)zze.zzE(zzd.zza.zzcd(paramIBinder4)));
  }
  
  public GInAppPurchaseManagerInfoParcel(Context paramContext, zzk paramZzk, zzky paramZzky, zzj paramZzj)
  {
    versionCode = 2;
    zzOM = paramContext;
    zzvC = paramZzk;
    zzOL = paramZzky;
    zzON = paramZzj;
  }
  
  public static void zza(Intent paramIntent, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramGInAppPurchaseManagerInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static GInAppPurchaseManagerInfoParcel zzc(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      paramIntent.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
      paramIntent = (GInAppPurchaseManagerInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzik()
  {
    return zze.zzA(zzON).asBinder();
  }
  
  IBinder zzil()
  {
    return zze.zzA(zzvC).asBinder();
  }
  
  IBinder zzim()
  {
    return zze.zzA(zzOL).asBinder();
  }
  
  IBinder zzin()
  {
    return zze.zzA(zzOM).asBinder();
  }
}
