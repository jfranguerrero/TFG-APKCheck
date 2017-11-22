package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;

@zzmb
public class zza
{
  public zza() {}
  
  public boolean zza(Context paramContext, Intent paramIntent, zzq paramZzq)
  {
    try
    {
      String str = String.valueOf(paramIntent.toURI());
      if (str.length() != 0) {}
      for (str = "Launching an intent: ".concat(str);; str = new String("Launching an intent: "))
      {
        zzpe.v(str);
        zzv.zzcJ().zzb(paramContext, paramIntent);
        if (paramZzq == null) {
          break;
        }
        paramZzq.zzbE();
        break;
      }
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      zzpe.zzbe(paramContext.getMessage());
      return false;
    }
  }
  
  public boolean zza(Context paramContext, zzc paramZzc, zzq paramZzq)
  {
    if (paramZzc == null)
    {
      zzpe.zzbe("No intent data for launcher overlay.");
      return false;
    }
    if (intent != null) {
      return zza(paramContext, intent, paramZzq);
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(url))
    {
      zzpe.zzbe("Open GMSG did not contain a URL.");
      return false;
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(mimeType))
    {
      localIntent.setDataAndType(Uri.parse(url), mimeType);
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(packageName)) {
        localIntent.setPackage(packageName);
      }
      if (TextUtils.isEmpty(zzLZ)) {
        break label210;
      }
      arrayOfString = zzLZ.split("/", 2);
      if (arrayOfString.length >= 2) {
        break label196;
      }
      paramContext = String.valueOf(zzLZ);
      if (paramContext.length() == 0) {
        break label183;
      }
    }
    label183:
    for (paramContext = "Could not parse component name from open GMSG: ".concat(paramContext);; paramContext = new String("Could not parse component name from open GMSG: "))
    {
      zzpe.zzbe(paramContext);
      return false;
      localIntent.setData(Uri.parse(url));
      break;
    }
    label196:
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    label210:
    paramZzc = zzMa;
    if (!TextUtils.isEmpty(paramZzc)) {}
    try
    {
      i = Integer.parseInt(paramZzc);
      localIntent.addFlags(i);
      return zza(paramContext, localIntent, paramZzq);
    }
    catch (NumberFormatException paramZzc)
    {
      for (;;)
      {
        zzpe.zzbe("Could not parse intent flags.");
        int i = 0;
      }
    }
  }
}
