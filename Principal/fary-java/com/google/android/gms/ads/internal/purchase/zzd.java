package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzky.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoz;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@zzmb
public class zzd
  extends zzky.zza
{
  private Context mContext;
  private String zzOX;
  private ArrayList<String> zzOY;
  private String zzvU;
  
  public zzd(String paramString1, ArrayList<String> paramArrayList, Context paramContext, String paramString2)
  {
    zzOX = paramString1;
    zzOY = paramArrayList;
    zzvU = paramString2;
    mContext = paramContext;
  }
  
  public String getProductId()
  {
    return zzOX;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    if (paramInt == 0) {
      zziq();
    }
    Map localMap = zzip();
    localMap.put("google_play_status", String.valueOf(paramInt));
    localMap.put("sku", zzOX);
    localMap.put("status", String.valueOf(zzN(paramInt)));
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = zzOY.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(zzv.zzcJ().zzb(str, localMap));
    }
    zzv.zzcJ().zza(mContext, zzvU, localLinkedList);
  }
  
  public void recordResolution(int paramInt)
  {
    if (paramInt == 1) {
      zziq();
    }
    Map localMap = zzip();
    localMap.put("status", String.valueOf(paramInt));
    localMap.put("sku", zzOX);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = zzOY.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(zzv.zzcJ().zzb(str, localMap));
    }
    zzv.zzcJ().zza(mContext, zzvU, localLinkedList);
  }
  
  protected int zzN(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 4) {
      return 3;
    }
    return 0;
  }
  
  Map<String, String> zzip()
  {
    String str = mContext.getPackageName();
    Object localObject1 = "";
    try
    {
      localObject2 = mContext.getPackageManager().getPackageInfo(str, 0).versionName;
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2;
        long l1;
        long l2;
        zzpe.zzc("Error to retrieve app version", localNameNotFoundException);
      }
    }
    l1 = zzv.zzcN().zzjM().zzkd();
    l2 = SystemClock.elapsedRealtime();
    localObject2 = new HashMap();
    ((Map)localObject2).put("sessionid", zzv.zzcN().getSessionId());
    ((Map)localObject2).put("appid", str);
    ((Map)localObject2).put("osversion", String.valueOf(Build.VERSION.SDK_INT));
    ((Map)localObject2).put("sdkversion", zzvU);
    ((Map)localObject2).put("appversion", localObject1);
    ((Map)localObject2).put("timestamp", String.valueOf(l2 - l1));
    return localObject2;
  }
  
  void zziq()
  {
    try
    {
      mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[] { Context.class, String.class, String.class, Boolean.TYPE }).invoke(null, new Object[] { mContext, zzOX, "", Boolean.valueOf(true) });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzpe.zzbe("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      zzpe.zzbe("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (Exception localException)
    {
      zzpe.zzc("Fail to report a conversion.", localException);
    }
  }
}
