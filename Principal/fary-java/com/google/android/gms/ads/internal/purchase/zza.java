package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zza
  implements Parcelable.Creator<GInAppPurchaseManagerInfoParcel>
{
  public zza() {}
  
  static void zza(GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzaV(paramParcel);
    zzc.zzc(paramParcel, 1, versionCode);
    zzc.zza(paramParcel, 3, paramGInAppPurchaseManagerInfoParcel.zzil(), false);
    zzc.zza(paramParcel, 4, paramGInAppPurchaseManagerInfoParcel.zzim(), false);
    zzc.zza(paramParcel, 5, paramGInAppPurchaseManagerInfoParcel.zzin(), false);
    zzc.zza(paramParcel, 6, paramGInAppPurchaseManagerInfoParcel.zzik(), false);
    zzc.zzJ(paramParcel, paramInt);
  }
  
  public GInAppPurchaseManagerInfoParcel[] zzM(int paramInt)
  {
    return new GInAppPurchaseManagerInfoParcel[paramInt];
  }
  
  public GInAppPurchaseManagerInfoParcel zzl(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zzb.zzaU(paramParcel);
    int i = 0;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzaT(paramParcel);
      switch (zzb.zzcW(k))
      {
      case 2: 
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 3: 
        localIBinder4 = zzb.zzr(paramParcel, k);
        break;
      case 4: 
        localIBinder3 = zzb.zzr(paramParcel, k);
        break;
      case 5: 
        localIBinder2 = zzb.zzr(paramParcel, k);
        break;
      case 6: 
        localIBinder1 = zzb.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GInAppPurchaseManagerInfoParcel(i, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
  }
}
