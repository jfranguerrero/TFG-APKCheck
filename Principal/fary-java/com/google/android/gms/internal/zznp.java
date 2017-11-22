package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zznp
  extends zzb
  implements zzod
{
  private static final zzjr zzUF = new zzjr();
  private final Map<String, zzoh> zzUG = new HashMap();
  private boolean zzUH;
  
  public zznp(Context paramContext, zzd paramZzd, zzec paramZzec, zzjs paramZzjs, zzqa paramZzqa)
  {
    super(paramContext, paramZzec, null, paramZzjs, paramZzqa, paramZzd);
  }
  
  private zzov.zza zzd(zzov.zza paramZza)
  {
    zzpe.v("Creating mediation ad response for non-mediated rewarded ad.");
    try
    {
      Object localObject1 = zzna.zzc(zzVB).toString();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pubid", zzSF.zzvd);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = new zzjj(Arrays.asList(new zzji[] { new zzji((String)localObject1, null, Arrays.asList(new String[] { "com.google.ads.mediation.admob.AdMobAdapter" }), null, null, Collections.emptyList(), Collections.emptyList(), (String)localObject2, null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList()) }), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false);
      return new zzov.zza(zzSF, zzVB, (zzjj)localObject1, zzvj, errorCode, zzVv, zzVw, zzVp);
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzb("Unable to generate ad state for non-mediated rewarded video.", localJSONException);
    }
    return zze(paramZza);
  }
  
  private zzov.zza zze(zzov.zza paramZza)
  {
    return new zzov.zza(zzSF, zzVB, null, zzvj, 0, zzVv, zzVw, zzVp);
  }
  
  public void destroy()
  {
    zzac.zzdn("destroy must be called on the main UI thread.");
    Iterator localIterator = zzUG.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          zzoh localZzoh = (zzoh)zzUG.get(str);
          if ((localZzoh != null) && (localZzoh.zzjw() != null)) {
            localZzoh.zzjw().destroy();
          }
        }
        catch (RemoteException localRemoteException)
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "Fail to destroy adapter: ".concat(str);; str = new String("Fail to destroy adapter: "))
          {
            zzpe.zzbe(str);
            break;
          }
        }
      }
    }
  }
  
  public boolean isLoaded()
  {
    zzac.zzdn("isLoaded must be called on the main UI thread.");
    return (zzsw.zzvh == null) && (zzsw.zzvi == null) && (zzsw.zzvk != null) && (!zzUH);
  }
  
  public void onContextChanged(@NonNull Context paramContext)
  {
    Iterator localIterator = zzUG.values().iterator();
    while (localIterator.hasNext())
    {
      zzoh localZzoh = (zzoh)localIterator.next();
      try
      {
        localZzoh.zzjw().zzj(zze.zzA(paramContext));
      }
      catch (RemoteException localRemoteException)
      {
        zzpe.zzb("Unable to call Adapter.onContextChanged.", localRemoteException);
      }
    }
  }
  
  public void onRewardedVideoAdClosed()
  {
    zzbH();
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    zzbI();
  }
  
  public void onRewardedVideoAdOpened()
  {
    zza(zzsw.zzvk, false);
    zzbJ();
  }
  
  public void onRewardedVideoStarted()
  {
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzKA != null)) {
      zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk, zzsw.zzvd, false, zzsw.zzvk.zzKA.zzJP);
    }
    zzbL();
  }
  
  public void pause()
  {
    zzac.zzdn("pause must be called on the main UI thread.");
    Iterator localIterator = zzUG.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          zzoh localZzoh = (zzoh)zzUG.get(str);
          if ((localZzoh != null) && (localZzoh.zzjw() != null)) {
            localZzoh.zzjw().pause();
          }
        }
        catch (RemoteException localRemoteException)
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "Fail to pause adapter: ".concat(str);; str = new String("Fail to pause adapter: "))
          {
            zzpe.zzbe(str);
            break;
          }
        }
      }
    }
  }
  
  public void resume()
  {
    zzac.zzdn("resume must be called on the main UI thread.");
    Iterator localIterator = zzUG.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          zzoh localZzoh = (zzoh)zzUG.get(str);
          if ((localZzoh != null) && (localZzoh.zzjw() != null)) {
            localZzoh.zzjw().resume();
          }
        }
        catch (RemoteException localRemoteException)
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "Fail to resume adapter: ".concat(str);; str = new String("Fail to resume adapter: "))
          {
            zzpe.zzbe(str);
            break;
          }
        }
      }
    }
  }
  
  public void zza(zznx paramZznx)
  {
    zzac.zzdn("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(zzvd))
    {
      zzpe.zzbe("Invalid ad unit id. Aborting.");
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          zznp.zza(zznp.this, 1);
        }
      });
      return;
    }
    zzUH = false;
    zzsw.zzvd = zzvd;
    super.zzb(zzRd);
  }
  
  public void zza(final zzov.zza paramZza, zzgf paramZzgf)
  {
    if (errorCode != -2)
    {
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          zzb(new zzov(paramZza, null, null, null, null, null, null, null));
        }
      });
      return;
    }
    zzsw.zzvl = paramZza;
    if (zzVr == null) {
      zzsw.zzvl = zzd(paramZza);
    }
    zzsw.zzvF = 0;
    zzsw.zzvi = zzv.zzcI().zza(zzsw.zzqr, zzsw.zzvl, this);
  }
  
  protected boolean zza(zzdy paramZzdy, zzov paramZzov, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean zza(zzov paramZzov1, zzov paramZzov2)
  {
    return true;
  }
  
  @Nullable
  public zzoh zzaM(String paramString)
  {
    Object localObject1 = (zzoh)zzUG.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = zzsD;
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString))
      {
        localObject2 = zzUF;
        localObject2 = new zzoh(((zzjs)localObject2).zzar(paramString), this);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          zzUG.put(paramString, localObject2);
          return localObject2;
        }
        catch (Exception localException2)
        {
          localObject1 = localException1;
          Object localObject3 = localException2;
          continue;
        }
        localException1 = localException1;
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "Fail to instantiate adapter ".concat(paramString);
          zzpe.zzc(paramString, localException1);
          return localObject1;
        }
        paramString = new String("Fail to instantiate adapter ");
      }
    }
  }
  
  public void zzc(@Nullable zzok paramZzok)
  {
    if ((zzsw.zzvk != null) && (zzsw.zzvk.zzKA != null)) {
      zzv.zzdc().zza(zzsw.zzqr, zzsw.zzvf.zzaZ, zzsw.zzvk, zzsw.zzvd, false, zzsw.zzvk.zzKA.zzJQ);
    }
    zzok localZzok = paramZzok;
    if (zzsw.zzvk != null)
    {
      localZzok = paramZzok;
      if (zzsw.zzvk.zzVr != null)
      {
        localZzok = paramZzok;
        if (!TextUtils.isEmpty(zzsw.zzvk.zzVr.zzKf)) {
          localZzok = new zzok(zzsw.zzvk.zzVr.zzKf, zzsw.zzvk.zzVr.zzKg);
        }
      }
    }
    zza(localZzok);
  }
  
  public void zzjo()
  {
    zzac.zzdn("showAd must be called on the main UI thread.");
    if (!isLoaded()) {
      zzpe.zzbe("The reward video has not loaded.");
    }
    zzoh localZzoh;
    do
    {
      return;
      zzUH = true;
      localZzoh = zzaM(zzsw.zzvk.zzKC);
    } while ((localZzoh == null) || (localZzoh.zzjw() == null));
    try
    {
      localZzoh.zzjw().showVideo();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzc("Could not call showVideo.", localRemoteException);
    }
  }
  
  public void zzjp()
  {
    onAdClicked();
  }
}
