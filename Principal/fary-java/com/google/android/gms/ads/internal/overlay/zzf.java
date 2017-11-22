package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzqa;

@zzmb
public class zzf
{
  public zzf() {}
  
  public void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    zza(paramContext, paramAdOverlayInfoParcel, true);
  }
  
  public void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel, boolean paramBoolean)
  {
    if ((zzNf == 4) && (zzMY == null))
    {
      if (zzMX != null) {
        zzMX.onAdClicked();
      }
      zzv.zzcG().zza(paramContext, zzMW, zzNe);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", zzvf.zzYd);
    localIntent.putExtra("shouldCallOnOverlayOpened", paramBoolean);
    AdOverlayInfoParcel.zza(localIntent, paramAdOverlayInfoParcel);
    if (!zzs.zzyH()) {
      localIntent.addFlags(524288);
    }
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    zzv.zzcJ().zzb(paramContext, localIntent);
  }
}
