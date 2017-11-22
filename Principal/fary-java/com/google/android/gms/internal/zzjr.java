package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

@zzmb
public final class zzjr
  extends zzjs.zza
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> zzKS;
  
  public zzjr() {}
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzjt zzat(String paramString)
    throws RemoteException
  {
    try
    {
      Object localObject = Class.forName(paramString, false, zzjr.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject))
      {
        localObject = (com.google.ads.mediation.MediationAdapter)((Class)localObject).newInstance();
        return new zzke((com.google.ads.mediation.MediationAdapter)localObject, (com.google.ads.mediation.NetworkExtras)zzKS.get(((com.google.ads.mediation.MediationAdapter)localObject).getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject)) {
        return new zzjz((com.google.android.gms.ads.mediation.MediationAdapter)((Class)localObject).newInstance());
      }
      zzpy.zzbe(String.valueOf(paramString).length() + 64 + "Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable) {}
    return zzau(paramString);
  }
  
  private zzjt zzau(String paramString)
    throws RemoteException
  {
    do
    {
      try
      {
        zzpy.zzbc("Reflection failed, retrying using direct instantiation");
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString)) {
          return new zzjz(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(paramString))
        {
          zzjz localZzjz = new zzjz(new AdUrlAdapter());
          return localZzjz;
        }
      }
      catch (Throwable localThrowable)
      {
        zzpy.zzc(String.valueOf(paramString).length() + 43 + "Could not instantiate mediation adapter: " + paramString + ". ", localThrowable);
        throw new RemoteException();
      }
      if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) {
        return new zzjz(new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter());
      }
    } while (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString));
    Object localObject = new com.google.ads.mediation.customevent.CustomEventAdapter();
    localObject = new zzke((com.google.ads.mediation.MediationAdapter)localObject, (CustomEventExtras)zzKS.get(((com.google.ads.mediation.customevent.CustomEventAdapter)localObject).getAdditionalParametersType()));
    return localObject;
  }
  
  public zzjt zzar(String paramString)
    throws RemoteException
  {
    return zzat(paramString);
  }
  
  public boolean zzas(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, zzjr.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzpy.zzbe(String.valueOf(paramString).length() + 80 + "Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
  
  public void zzi(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    zzKS = paramMap;
  }
}
