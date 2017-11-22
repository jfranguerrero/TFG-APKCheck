package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@zzmb
public class zzgl
  implements zzbvb
{
  @Nullable
  private CustomTabsSession zzFA;
  @Nullable
  private CustomTabsClient zzFB;
  @Nullable
  private CustomTabsServiceConnection zzFC;
  @Nullable
  private zza zzFD;
  
  public zzgl() {}
  
  public static boolean zzn(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    if (localObject1 == null) {}
    for (;;)
    {
      return false;
      Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
      ResolveInfo localResolveInfo = ((PackageManager)localObject1).resolveActivity((Intent)localObject2, 0);
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 65536);
      if ((localObject1 != null) && (localResolveInfo != null))
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (ResolveInfo)((List)localObject1).get(i);
          if (activityInfo.name.equals(activityInfo.name)) {
            return activityInfo.packageName.equals(zzbuz.zzcf(paramContext));
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean mayLaunchUrl(Uri paramUri, Bundle paramBundle, List<Bundle> paramList)
  {
    if (zzFB == null) {}
    CustomTabsSession localCustomTabsSession;
    do
    {
      return false;
      localCustomTabsSession = zzfC();
    } while (localCustomTabsSession == null);
    return localCustomTabsSession.mayLaunchUrl(paramUri, paramBundle, paramList);
  }
  
  public void zza(CustomTabsClient paramCustomTabsClient)
  {
    zzFB = paramCustomTabsClient;
    zzFB.warmup(0L);
    if (zzFD != null) {
      zzFD.zzfE();
    }
  }
  
  public void zza(zza paramZza)
  {
    zzFD = paramZza;
  }
  
  public void zzd(Activity paramActivity)
  {
    if (zzFC == null) {
      return;
    }
    paramActivity.unbindService(zzFC);
    zzFB = null;
    zzFA = null;
    zzFC = null;
  }
  
  public void zze(Activity paramActivity)
  {
    if (zzFB != null) {}
    String str;
    do
    {
      return;
      str = zzbuz.zzcf(paramActivity);
    } while (str == null);
    zzFC = new zzbva(this);
    CustomTabsClient.bindCustomTabsService(paramActivity, str, zzFC);
  }
  
  @Nullable
  public CustomTabsSession zzfC()
  {
    if (zzFB == null) {
      zzFA = null;
    }
    for (;;)
    {
      return zzFA;
      if (zzFA == null) {
        zzFA = zzFB.newSession(null);
      }
    }
  }
  
  public void zzfD()
  {
    zzFB = null;
    zzFA = null;
    if (zzFD != null) {
      zzFD.zzfF();
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzfE();
    
    public abstract void zzfF();
  }
}
