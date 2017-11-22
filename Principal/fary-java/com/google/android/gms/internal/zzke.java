package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public final class zzke<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends zzjt.zza
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzLa;
  private final NETWORK_EXTRAS zzLb;
  
  public zzke(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    zzLa = paramMediationAdapter;
    zzLb = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS zzb(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    if (paramString1 != null) {
      try
      {
        localObject = new JSONObject(paramString1);
        paramString2 = new HashMap(((JSONObject)localObject).length());
        Iterator localIterator = ((JSONObject)localObject).keys();
        for (;;)
        {
          paramString1 = paramString2;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString1 = (String)localIterator.next();
          paramString2.put(paramString1, ((JSONObject)localObject).getString(paramString1));
        }
        paramString1 = new HashMap(0);
      }
      catch (Throwable paramString1)
      {
        zzpy.zzc("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    Object localObject = zzLa.getServerParametersType();
    paramString2 = null;
    if (localObject != null)
    {
      paramString2 = (MediationServerParameters)((Class)localObject).newInstance();
      paramString2.load(paramString1);
    }
    return paramString2;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      zzLa.destroy();
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
    return new Bundle();
  }
  
  public zzd getView()
    throws RemoteException
  {
    Object localObject;
    if (!(zzLa instanceof MediationBannerAdapter))
    {
      localObject = String.valueOf(zzLa.getClass().getCanonicalName());
      if (((String)localObject).length() != 0) {}
      for (localObject = "MediationAdapter is not a MediationBannerAdapter: ".concat((String)localObject);; localObject = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        zzpy.zzbe((String)localObject);
        throw new RemoteException();
      }
    }
    try
    {
      localObject = zze.zzA(((MediationBannerAdapter)zzLa).getBannerView());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(zzLa instanceof MediationInterstitialAdapter))
    {
      String str = String.valueOf(zzLa.getClass().getCanonicalName());
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
      ((MediationInterstitialAdapter)zzLa).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzc("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo() {}
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString, zzju paramZzju)
    throws RemoteException
  {
    zza(paramZzd, paramZzdy, paramString, null, paramZzju);
  }
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString1, zzoi paramZzoi, String paramString2)
    throws RemoteException
  {}
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString1, String paramString2, zzju paramZzju)
    throws RemoteException
  {
    if (!(zzLa instanceof MediationInterstitialAdapter))
    {
      paramZzd = String.valueOf(zzLa.getClass().getCanonicalName());
      if (paramZzd.length() != 0) {}
      for (paramZzd = "MediationAdapter is not a MediationInterstitialAdapter: ".concat(paramZzd);; paramZzd = new String("MediationAdapter is not a MediationInterstitialAdapter: "))
      {
        zzpy.zzbe(paramZzd);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)zzLa).requestInterstitialAd(new zzkf(paramZzju), (Activity)zze.zzE(paramZzd), zzb(paramString1, zzyJ, paramString2), zzkg.zzs(paramZzdy), zzLb);
      return;
    }
    catch (Throwable paramZzd)
    {
      zzpy.zzc("Could not request interstitial ad from adapter.", paramZzd);
      throw new RemoteException();
    }
  }
  
  public void zza(zzd paramZzd, zzdy paramZzdy, String paramString1, String paramString2, zzju paramZzju, zzgw paramZzgw, List<String> paramList) {}
  
  public void zza(zzd paramZzd, zzec paramZzec, zzdy paramZzdy, String paramString, zzju paramZzju)
    throws RemoteException
  {
    zza(paramZzd, paramZzec, paramZzdy, paramString, null, paramZzju);
  }
  
  public void zza(zzd paramZzd, zzec paramZzec, zzdy paramZzdy, String paramString1, String paramString2, zzju paramZzju)
    throws RemoteException
  {
    if (!(zzLa instanceof MediationBannerAdapter))
    {
      paramZzd = String.valueOf(zzLa.getClass().getCanonicalName());
      if (paramZzd.length() != 0) {}
      for (paramZzd = "MediationAdapter is not a MediationBannerAdapter: ".concat(paramZzd);; paramZzd = new String("MediationAdapter is not a MediationBannerAdapter: "))
      {
        zzpy.zzbe(paramZzd);
        throw new RemoteException();
      }
    }
    zzpy.zzbc("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)zzLa).requestBannerAd(new zzkf(paramZzju), (Activity)zze.zzE(paramZzd), zzb(paramString1, zzyJ, paramString2), zzkg.zzc(paramZzec), zzkg.zzs(paramZzdy), zzLb);
      return;
    }
    catch (Throwable paramZzd)
    {
      zzpy.zzc("Could not request banner ad from adapter.", paramZzd);
      throw new RemoteException();
    }
  }
  
  public void zza(zzdy paramZzdy, String paramString1, String paramString2) {}
  
  public void zzc(zzdy paramZzdy, String paramString) {}
  
  public zzjw zzgJ()
  {
    return null;
  }
  
  public zzjx zzgK()
  {
    return null;
  }
  
  public Bundle zzgL()
  {
    return new Bundle();
  }
  
  public Bundle zzgM()
  {
    return new Bundle();
  }
  
  public void zzj(zzd paramZzd)
    throws RemoteException
  {}
}
