package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final zzc zzbCa = ;
  private static Method zzbCb = null;
  private static final Object zztU = new Object();
  
  public ProviderInstaller() {}
  
  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zzac.zzb(paramContext, "Context must not be null");
    zzbCa.zzam(paramContext);
    paramContext = zze.getRemoteContext(paramContext);
    if (paramContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    for (;;)
    {
      synchronized (zztU)
      {
        try
        {
          if (zzbCb == null) {
            zzbz(paramContext);
          }
          zzbCb.invoke(null, new Object[] { paramContext });
          return;
        }
        catch (Exception paramContext)
        {
          paramContext = String.valueOf(paramContext.getMessage());
          if (paramContext.length() == 0) {
            break label121;
          }
        }
        paramContext = "Failed to install provider: ".concat(paramContext);
        Log.e("ProviderInstaller", paramContext);
        throw new GooglePlayServicesNotAvailableException(8);
      }
      label121:
      paramContext = new String("Failed to install provider: ");
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, final ProviderInstallListener paramProviderInstallListener)
  {
    zzac.zzb(paramContext, "Context must not be null");
    zzac.zzb(paramProviderInstallListener, "Listener must not be null");
    zzac.zzdn("Must be called on the UI thread");
    new AsyncTask()
    {
      protected Integer zzc(Void... paramAnonymousVarArgs)
      {
        try
        {
          ProviderInstaller.installIfNeeded(ProviderInstaller.this);
          return Integer.valueOf(0);
        }
        catch (GooglePlayServicesRepairableException paramAnonymousVarArgs)
        {
          return Integer.valueOf(paramAnonymousVarArgs.getConnectionStatusCode());
        }
        catch (GooglePlayServicesNotAvailableException paramAnonymousVarArgs) {}
        return Integer.valueOf(errorCode);
      }
      
      protected void zzg(Integer paramAnonymousInteger)
      {
        if (paramAnonymousInteger.intValue() == 0)
        {
          paramProviderInstallListener.onProviderInstalled();
          return;
        }
        Intent localIntent = ProviderInstaller.zzOc().zzb(ProviderInstaller.this, paramAnonymousInteger.intValue(), "pi");
        paramProviderInstallListener.onProviderInstallFailed(paramAnonymousInteger.intValue(), localIntent);
      }
    }.execute(new Void[0]);
  }
  
  private static void zzbz(Context paramContext)
    throws ClassNotFoundException, NoSuchMethodException
  {
    zzbCb = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}
