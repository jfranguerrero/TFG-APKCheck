package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzmb
public final class zzie
  implements zzhx
{
  private final zze zzHN;
  private final zzkj zzHO;
  private final zzhz zzHQ;
  
  public zzie(zzhz paramZzhz, zze paramZze, zzkj paramZzkj)
  {
    zzHQ = paramZzhz;
    zzHN = paramZze;
    zzHO = paramZzkj;
  }
  
  private static boolean zzd(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int zze(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null)
    {
      if ("p".equalsIgnoreCase(paramMap)) {
        return zzv.zzcL().zzkq();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return zzv.zzcL().zzkp();
      }
      if ("c".equalsIgnoreCase(paramMap)) {
        return zzv.zzcL().zzkr();
      }
    }
    return -1;
  }
  
  private static void zzf(zzqp paramZzqp, Map<String, String> paramMap)
  {
    Context localContext = paramZzqp.getContext();
    if (TextUtils.isEmpty((String)paramMap.get("u")))
    {
      zzpe.zzbe("Destination url cannot be empty.");
      return;
    }
    zzqq localZzqq = paramZzqp.zzkV();
    paramZzqp = new zza(paramZzqp).zza(localContext, paramMap);
    try
    {
      localZzqq.zza(new zzc(paramZzqp));
      return;
    }
    catch (ActivityNotFoundException paramZzqp)
    {
      zzpe.zzbe(paramZzqp.getMessage());
    }
  }
  
  private void zzr(boolean paramBoolean)
  {
    if (zzHO != null) {
      zzHO.zzs(paramBoolean);
    }
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null) {
      zzpe.zzbe("Action missing from an open GMSG.");
    }
    zzqq localZzqq;
    do
    {
      return;
      if ((zzHN != null) && (!zzHN.zzcb()))
      {
        zzHN.zzx((String)paramMap.get("u"));
        return;
      }
      localZzqq = paramZzqp.zzkV();
      if ("expand".equalsIgnoreCase(str))
      {
        if (paramZzqp.zzkZ())
        {
          zzpe.zzbe("Cannot expand WebView that is already expanded.");
          return;
        }
        zzr(false);
        localZzqq.zza(zzd(paramMap), zze(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str))
      {
        paramZzqp = (String)paramMap.get("u");
        zzr(false);
        if (paramZzqp != null)
        {
          localZzqq.zza(zzd(paramMap), zze(paramMap), paramZzqp);
          return;
        }
        localZzqq.zza(zzd(paramMap), zze(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str)) {
        break;
      }
      paramZzqp = (String)paramMap.get("product_id");
      paramMap = (String)paramMap.get("report_urls");
    } while (zzHQ == null);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.split(" ");
      zzHQ.zza(paramZzqp, new ArrayList(Arrays.asList(paramMap)));
      return;
    }
    zzHQ.zza(paramZzqp, new ArrayList());
    return;
    if (("app".equalsIgnoreCase(str)) && ("true".equalsIgnoreCase((String)paramMap.get("system_browser"))))
    {
      zzr(true);
      zzf(paramZzqp, paramMap);
      return;
    }
    zzr(true);
    str = (String)paramMap.get("u");
    if (!TextUtils.isEmpty(str)) {}
    for (paramZzqp = zzv.zzcJ().zza(paramZzqp, str);; paramZzqp = str)
    {
      localZzqq.zza(new zzc((String)paramMap.get("i"), paramZzqp, (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
      return;
    }
  }
  
  public static class zza
  {
    private final zzqp zzGt;
    
    public zza(zzqp paramZzqp)
    {
      zzGt = paramZzqp;
    }
    
    public Intent zza(Context paramContext, Map<String, String> paramMap)
    {
      Object localObject1 = null;
      Object localObject3 = (ActivityManager)paramContext.getSystemService("activity");
      Object localObject2 = (String)paramMap.get("u");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMap = (Map<String, String>)localObject1;
        return paramMap;
      }
      localObject1 = localObject2;
      if (zzGt != null) {
        localObject1 = zzv.zzcJ().zza(zzGt, (String)localObject2);
      }
      localObject1 = Uri.parse((String)localObject1);
      boolean bool1 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
      boolean bool2 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
      if ("http".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
        paramMap = ((Uri)localObject1).buildUpon().scheme("https").build();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        Intent localIntent = zzf((Uri)localObject1);
        paramMap = zzf(paramMap);
        localObject1 = zza(paramContext, localIntent, (ArrayList)localObject2);
        if (localObject1 != null)
        {
          return zza(localIntent, (ResolveInfo)localObject1);
          if ("https".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
            paramMap = ((Uri)localObject1).buildUpon().scheme("http").build();
          }
        }
        else
        {
          if (paramMap != null)
          {
            paramMap = zza(paramContext, paramMap);
            if (paramMap != null)
            {
              localObject1 = zza(localIntent, paramMap);
              paramMap = (Map<String, String>)localObject1;
              if (zza(paramContext, (Intent)localObject1) != null) {
                break;
              }
            }
          }
          if (((ArrayList)localObject2).size() == 0) {
            return localIntent;
          }
          if ((bool2) && (localObject3 != null))
          {
            paramContext = ((ActivityManager)localObject3).getRunningAppProcesses();
            if (paramContext != null)
            {
              do
              {
                paramMap = ((ArrayList)localObject2).iterator();
                while (!((Iterator)localObject3).hasNext())
                {
                  if (!paramMap.hasNext()) {
                    break;
                  }
                  localObject1 = (ResolveInfo)paramMap.next();
                  localObject3 = paramContext.iterator();
                }
              } while (!nextprocessName.equals(activityInfo.packageName));
              return zza(localIntent, (ResolveInfo)localObject1);
            }
          }
          if (bool1) {
            return zza(localIntent, (ResolveInfo)((ArrayList)localObject2).get(0));
          }
          return localIntent;
        }
        paramMap = null;
      }
    }
    
    public Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setClassName(activityInfo.packageName, activityInfo.name);
      return paramIntent;
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent)
    {
      return zza(paramContext, paramIntent, new ArrayList());
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      List localList = paramContext.queryIntentActivities(paramIntent, 65536);
      paramContext = paramContext.resolveActivity(paramIntent, 65536);
      int i;
      if ((localList != null) && (paramContext != null))
      {
        i = 0;
        if (i < localList.size())
        {
          paramIntent = (ResolveInfo)localList.get(i);
          if ((paramContext == null) || (!activityInfo.name.equals(activityInfo.name))) {}
        }
      }
      for (;;)
      {
        paramArrayList.addAll(localList);
        return paramContext;
        i += 1;
        break;
        paramContext = null;
      }
    }
    
    public Intent zzf(Uri paramUri)
    {
      if (paramUri == null) {
        return null;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(paramUri);
      localIntent.setAction("android.intent.action.VIEW");
      return localIntent;
    }
  }
}
