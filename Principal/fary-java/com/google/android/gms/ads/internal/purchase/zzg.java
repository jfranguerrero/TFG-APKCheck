package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.internal.zzlc.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;

@zzmb
public final class zzg
  extends zzlc.zza
  implements ServiceConnection
{
  private Context mContext;
  private int mResultCode;
  zzb zzOR;
  private String zzOX;
  private zzf zzPb;
  private boolean zzPh = false;
  private Intent zzPi;
  
  public zzg(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, zzf paramZzf)
  {
    zzOX = paramString;
    mResultCode = paramInt;
    zzPi = paramIntent;
    zzPh = paramBoolean;
    mContext = paramContext;
    zzPb = paramZzf;
  }
  
  public void finishPurchase()
  {
    int i = zzv.zzcX().zzd(zzPi);
    if ((mResultCode != -1) || (i != 0)) {
      return;
    }
    zzOR = new zzb(mContext);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    zza.zzyc().zza(mContext, localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return zzOX;
  }
  
  public Intent getPurchaseData()
  {
    return zzPi;
  }
  
  public int getResultCode()
  {
    return mResultCode;
  }
  
  public boolean isVerified()
  {
    return zzPh;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zzpe.zzbd("In-app billing service connected.");
    zzOR.zzV(paramIBinder);
    paramComponentName = zzv.zzcX().zze(zzPi);
    paramComponentName = zzv.zzcX().zzaE(paramComponentName);
    if (paramComponentName == null) {
      return;
    }
    if (zzOR.zzl(mContext.getPackageName(), paramComponentName) == 0) {
      zzh.zzq(mContext).zza(zzPb);
    }
    zza.zzyc().zza(mContext, this);
    zzOR.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzpe.zzbd("In-app billing service disconnected.");
    zzOR.destroy();
  }
}
