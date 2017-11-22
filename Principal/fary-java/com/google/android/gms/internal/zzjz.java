package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@zzmb
public final class zzjz
  extends zzjt.zza
{
  private final MediationAdapter zzKU;
  private zzka zzKV;
  
  public zzjz(MediationAdapter paramMediationAdapter)
  {
    zzKU = paramMediationAdapter;
  }
  
  private Bundle zza(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    Object localObject = String.valueOf(paramString1);
    if (((String)localObject).length() != 0) {
      localObject = "Server parameters: ".concat((String)localObject);
    }
    for (;;)
    {
      zzpy.zzbe((String)localObject);
      try
      {
        localObject = new Bundle();
        if (paramString1 == null) {
          break;
        }
        paramString1 = new JSONObject(paramString1);
        localObject = new Bundle();
        Iterator localIterator = paramString1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((Bundle)localObject).putString(str, paramString1.getString(str));
        }
        localObject = new String("Server parameters: ");
      }
      catch (Throwable paramString1)
      {
        zzpy.zzc("Could not get Server Parameters Bundle.", paramString1);
        throw new RemoteException();
      }
    }
    if ((zzKU instanceof AdMobAdapter))
    {
      ((Bundle)localObject).putString("adJson", paramString2);
      ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramInt);
    }
    return localObject;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      zzKU.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    if (!(zzKU instanceof zzrd))
    {
      String str = String.valueOf(zzKU.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(str);; str = new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "))
      {
        zzpy.zzbe(str);
        return new Bundle();
      }
    }
    return ((zzrd)zzKU).getInterstitialAdapterInfo();
  }
  
  public zzd getView()
    throws RemoteException
  {
    Object localObject;
    if (!(zzKU instanceof MediationBannerAdapter))
    {
      localObject = String.valueOf(zzKU.getClass().getCanonicalName());
      if (((String)localObject).length() != 0) {}
      for (localObject = "MediationAdapter is not a MediationBannerAdapter: ".concat((String)localObject);; localObject = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        zzpy.zzbe((String)localObject);
        throw new RemoteException();
      }
    }
    try
    {
      localObject = zze.zzA(((MediationBannerAdapter)zzKU).getBannerView());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
    throws RemoteException
  {
    if (!(zzKU instanceof MediationRewardedVideoAdAdapter))
    {
      String str = String.valueOf(zzKU.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        zzpy.zzbe(str);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Check if adapter is initialized.");
    try
    {
      boolean bool = ((MediationRewardedVideoAdAdapter)zzKU).isInitialized();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not check if adapter is initialized.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      zzKU.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      zzKU.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(zzKU instanceof MediationInterstitialAdapter))
    {
      String str = String.valueOf(zzKU.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        zzpy.zzbe(str);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)zzKU).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo()
    throws RemoteException
  {
    if (!(zzKU instanceof MediationRewardedVideoAdAdapter))
    {
      String str = String.valueOf(zzKU.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(str);; str = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        zzpy.zzbe(str);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Show rewarded video ad from adapter.");
    try
    {
      ((MediationRewardedVideoAdAdapter)zzKU).showVideo();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not show rewarded video ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString, zzju paramZzju)
    throws RemoteException
  {
    zza(paramZzd, paramZzdy, paramString, null, paramZzju);
  }
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString1, zzoi paramZzoi, String paramString2)
    throws RemoteException
  {
    if (!(zzKU instanceof MediationRewardedVideoAdAdapter))
    {
      paramZzd = String.valueOf(zzKU.getClass().getCanonicalName());
      if (paramZzd.length() != 0) {}
      for (paramZzd = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(paramZzd);; paramZzd = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        zzpy.zzbe(paramZzd);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Initialize rewarded video adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)zzKU;
        if (zzyH == null) {
          break label246;
        }
        localObject1 = new HashSet(zzyH);
        Object localObject2;
        if (zzyF == -1L)
        {
          localObject2 = null;
          localObject2 = new zzjy((Date)localObject2, zzyG, (Set)localObject1, zzyN, zzyI, zzyJ, zzyU);
          if (zzyP != null)
          {
            localObject1 = zzyP.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.initialize((Context)zze.zzE(paramZzd), (MediationAdRequest)localObject2, paramString1, new zzoj(paramZzoi), zza(paramString2, zzyJ, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzyF);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramZzd)
      {
        zzpy.zzc("Could not initialize rewarded video adapter.", paramZzd);
        throw new RemoteException();
      }
      continue;
      label246:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString1, String paramString2, zzju paramZzju)
    throws RemoteException
  {
    if (!(zzKU instanceof MediationInterstitialAdapter))
    {
      paramZzd = String.valueOf(zzKU.getClass().getCanonicalName());
      if (paramZzd.length() != 0) {}
      for (paramZzd = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(paramZzd);; paramZzd = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        zzpy.zzbe(paramZzd);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Requesting interstitial ad from adapter.");
    for (;;)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)zzKU;
        if (zzyH == null) {
          break label246;
        }
        localObject1 = new HashSet(zzyH);
        Object localObject2;
        if (zzyF == -1L)
        {
          localObject2 = null;
          localObject2 = new zzjy((Date)localObject2, zzyG, (Set)localObject1, zzyN, zzyI, zzyJ, zzyU);
          if (zzyP != null)
          {
            localObject1 = zzyP.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)zze.zzE(paramZzd), new zzka(paramZzju), zza(paramString1, zzyJ, paramString2), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzyF);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramZzd)
      {
        zzpy.zzc("Could not request interstitial ad from adapter.", paramZzd);
        throw new RemoteException();
      }
      continue;
      label246:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString1, String paramString2, zzju paramZzju, zzgw paramZzgw, List<String> paramList)
    throws RemoteException
  {
    if (!(zzKU instanceof MediationNativeAdapter))
    {
      paramZzd = String.valueOf(zzKU.getClass().getCanonicalName());
      if (paramZzd.length() != 0) {}
      for (paramZzd = "MediationAdapter is not a MediationNativeAdapter: ".concat(paramZzd);; paramZzd = new String("MediationAdapter is not a MediationNativeAdapter: "))
      {
        zzpy.zzbe(paramZzd);
        throw new RemoteException();
      }
    }
    for (;;)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)zzKU;
        if (zzyH == null) {
          break label254;
        }
        localHashSet = new HashSet(zzyH);
        Date localDate;
        if (zzyF == -1L)
        {
          localDate = null;
          paramList = new zzkd(localDate, zzyG, localHashSet, zzyN, zzyI, zzyJ, paramZzgw, paramList, zzyU);
          if (zzyP != null)
          {
            paramZzgw = zzyP.getBundle(localMediationNativeAdapter.getClass().getName());
            zzKV = new zzka(paramZzju);
            localMediationNativeAdapter.requestNativeAd((Context)zze.zzE(paramZzd), zzKV, zza(paramString1, zzyJ, paramString2), paramList, paramZzgw);
          }
        }
        else
        {
          localDate = new Date(zzyF);
          continue;
        }
        paramZzgw = null;
      }
      catch (Throwable paramZzd)
      {
        zzpy.zzc("Could not request native ad from adapter.", paramZzd);
        throw new RemoteException();
      }
      continue;
      label254:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramZzd, zzec paramZzec, zzdy paramZzdy, String paramString, zzju paramZzju)
    throws RemoteException
  {
    zza(paramZzd, paramZzec, paramZzdy, paramString, null, paramZzju);
  }
  
  public void zza(zzd paramZzd, zzec paramZzec, zzdy paramZzdy, String paramString1, String paramString2, zzju paramZzju)
    throws RemoteException
  {
    if (!(zzKU instanceof MediationBannerAdapter))
    {
      paramZzd = String.valueOf(zzKU.getClass().getCanonicalName());
      if (paramZzd.length() != 0) {}
      for (paramZzd = "MediationAdapter is not a MediationBannerAdapter: ".concat(paramZzd);; paramZzd = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        zzpy.zzbe(paramZzd);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Requesting banner ad from adapter.");
    for (;;)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)zzKU;
        if (zzyH == null) {
          break label262;
        }
        localObject1 = new HashSet(zzyH);
        Object localObject2;
        if (zzyF == -1L)
        {
          localObject2 = null;
          localObject2 = new zzjy((Date)localObject2, zzyG, (Set)localObject1, zzyN, zzyI, zzyJ, zzyU);
          if (zzyP != null)
          {
            localObject1 = zzyP.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)zze.zzE(paramZzd), new zzka(paramZzju), zza(paramString1, zzyJ, paramString2), zza.zza(width, height, zzzk), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzyF);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramZzd)
      {
        zzpy.zzc("Could not request banner ad from adapter.", paramZzd);
        throw new RemoteException();
      }
      continue;
      label262:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzdy paramZzdy, String paramString1, String paramString2)
    throws RemoteException
  {
    if (!(zzKU instanceof MediationRewardedVideoAdAdapter))
    {
      paramZzdy = String.valueOf(zzKU.getClass().getCanonicalName());
      if (paramZzdy.length() != 0) {}
      for (paramZzdy = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(paramZzdy);; paramZzdy = new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "))
      {
        zzpy.zzbe(paramZzdy);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Requesting rewarded video ad from adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)zzKU;
        if (zzyH == null) {
          break label229;
        }
        localObject1 = new HashSet(zzyH);
        Object localObject2;
        if (zzyF == -1L)
        {
          localObject2 = null;
          localObject2 = new zzjy((Date)localObject2, zzyG, (Set)localObject1, zzyN, zzyI, zzyJ, zzyU);
          if (zzyP != null)
          {
            localObject1 = zzyP.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd((MediationAdRequest)localObject2, zza(paramString1, zzyJ, paramString2), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzyF);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramZzdy)
      {
        zzpy.zzc("Could not load rewarded video ad from adapter.", paramZzdy);
        throw new RemoteException();
      }
      continue;
      label229:
      Object localObject1 = null;
    }
  }
  
  public void zzc(zzdy paramZzdy, String paramString)
    throws RemoteException
  {
    zza(paramZzdy, paramString, null);
  }
  
  public zzjw zzgJ()
  {
    NativeAdMapper localNativeAdMapper = zzKV.zzgN();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper)) {
      return new zzkb((NativeAppInstallAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public zzjx zzgK()
  {
    NativeAdMapper localNativeAdMapper = zzKV.zzgN();
    if ((localNativeAdMapper instanceof NativeContentAdMapper)) {
      return new zzkc((NativeContentAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public Bundle zzgL()
  {
    if (!(zzKU instanceof zzrc))
    {
      String str = String.valueOf(zzKU.getClass().getCanonicalName());
      if (str.length() != 0) {}
      for (str = "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(str);; str = new String("MediationAdapter is not a v2 MediationBannerAdapter: "))
      {
        zzpy.zzbe(str);
        return new Bundle();
      }
    }
    return ((zzrc)zzKU).zzgL();
  }
  
  public Bundle zzgM()
  {
    return new Bundle();
  }
  
  public void zzj(zzd paramZzd)
    throws RemoteException
  {
    try
    {
      paramZzd = (Context)zze.zzE(paramZzd);
      ((OnContextChangedListener)zzKU).onContextChanged(paramZzd);
      return;
    }
    catch (Throwable paramZzd)
    {
      zzpy.zza("Could not inform adapter of changed context", paramZzd);
    }
  }
}
