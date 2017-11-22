package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzmb
public class zzeb
{
  public static final zzeb zzzj = new zzeb();
  
  protected zzeb() {}
  
  public static zzeb zzey()
  {
    return zzzj;
  }
  
  public zzdy zza(Context paramContext, zzey paramZzey)
  {
    Object localObject1 = paramZzey.getBirthday();
    long l;
    String str1;
    int i;
    label59:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      l = ((Date)localObject1).getTime();
      str1 = paramZzey.getContentUrl();
      i = paramZzey.getGender();
      localObject1 = paramZzey.getKeywords();
      if (((Set)localObject1).isEmpty()) {
        break label231;
      }
      localObject1 = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
      bool1 = paramZzey.isTestDevice(paramContext);
      j = paramZzey.zzfa();
      localLocation = paramZzey.getLocation();
      localBundle = paramZzey.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramZzey.getManualImpressionsEnabled();
      str2 = paramZzey.getPublisherProvidedId();
      localObject2 = paramZzey.zzeX();
      if (localObject2 == null) {
        break label237;
      }
    }
    label231:
    label237:
    for (Object localObject2 = new zzfj((SearchAdRequest)localObject2);; localObject2 = null)
    {
      Object localObject3 = null;
      Context localContext = paramContext.getApplicationContext();
      paramContext = localObject3;
      if (localContext != null)
      {
        paramContext = localContext.getPackageName();
        paramContext = zzeh.zzeO().zza(Thread.currentThread().getStackTrace(), paramContext);
      }
      boolean bool3 = paramZzey.isDesignedForFamilies();
      return new zzdy(7, l, localBundle, i, (List)localObject1, bool1, j, bool2, str2, (zzfj)localObject2, localLocation, str1, paramZzey.zzeZ(), paramZzey.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(paramZzey.zzfb())), paramZzey.zzeW(), paramContext, bool3);
      l = -1L;
      break;
      localObject1 = null;
      break label59;
    }
  }
  
  public zznx zza(Context paramContext, zzey paramZzey, String paramString)
  {
    return new zznx(zza(paramContext, paramZzey), paramString);
  }
}
