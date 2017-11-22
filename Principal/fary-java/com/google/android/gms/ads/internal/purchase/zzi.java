package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzi
{
  public zzi() {}
  
  public void zza(Context paramContext, boolean paramBoolean, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    GInAppPurchaseManagerInfoParcel.zza(localIntent, paramGInAppPurchaseManagerInfoParcel);
    zzv.zzcJ().zzb(paramContext, localIntent);
  }
  
  public String zzaD(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("developerPayload");
      return paramString;
    }
    catch (JSONException paramString)
    {
      zzpe.zzbe("Fail to parse purchase data");
    }
    return null;
  }
  
  public String zzaE(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("purchaseToken");
      return paramString;
    }
    catch (JSONException paramString)
    {
      zzpe.zzbe("Fail to parse purchase data");
    }
    return null;
  }
  
  public int zzd(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 5;
    }
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      zzpe.zzbe("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    paramIntent = String.valueOf(paramIntent.getClass().getName());
    if (paramIntent.length() != 0) {}
    for (paramIntent = "Unexpected type for intent response code. ".concat(paramIntent);; paramIntent = new String("Unexpected type for intent response code. "))
    {
      zzpe.zzbe(paramIntent);
      return 5;
    }
  }
  
  public int zzd(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      zzpe.zzbe("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    paramBundle = String.valueOf(paramBundle.getClass().getName());
    if (paramBundle.length() != 0) {}
    for (paramBundle = "Unexpected type for intent response code. ".concat(paramBundle);; paramBundle = new String("Unexpected type for intent response code. "))
    {
      zzpe.zzbe(paramBundle);
      return 5;
    }
  }
  
  public String zze(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
  }
  
  public String zzf(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
  }
  
  public void zzr(final Context paramContext)
  {
    ServiceConnection local1 = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        boolean bool = false;
        paramAnonymousComponentName = new zzb(paramContext.getApplicationContext(), false);
        paramAnonymousComponentName.zzV(paramAnonymousIBinder);
        int i = paramAnonymousComponentName.zzb(3, paramContext.getPackageName(), "inapp");
        paramAnonymousIBinder = zzv.zzcN();
        if (i == 0) {
          bool = true;
        }
        paramAnonymousIBinder.zzH(bool);
        zza.zzyc().zza(paramContext, this);
        paramAnonymousComponentName.destroy();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    zza.zzyc().zza(paramContext, localIntent, local1, 1);
  }
}
