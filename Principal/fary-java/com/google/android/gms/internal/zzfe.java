package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;

public class zzfe
  extends zzen.zza
{
  private zzel zzti;
  
  public zzfe() {}
  
  public void zza(zzgw paramZzgw)
    throws RemoteException
  {}
  
  public void zza(zzhj paramZzhj)
    throws RemoteException
  {}
  
  public void zza(zzhk paramZzhk)
    throws RemoteException
  {}
  
  public void zza(String paramString, zzhm paramZzhm, zzhl paramZzhl)
    throws RemoteException
  {}
  
  public void zzb(zzel paramZzel)
    throws RemoteException
  {
    zzti = paramZzel;
  }
  
  public void zzb(zzet paramZzet)
    throws RemoteException
  {}
  
  public zzem zzci()
    throws RemoteException
  {
    return new zza(null);
  }
  
  private class zza
    extends zzem.zza
  {
    private zza() {}
    
    public String getMediationAdapterClassName()
      throws RemoteException
    {
      return null;
    }
    
    public boolean isLoading()
      throws RemoteException
    {
      return false;
    }
    
    public void zzf(zzdy paramZzdy)
      throws RemoteException
    {
      zzpy.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          if (zzfe.zza(zzfe.this) != null) {}
          try
          {
            zzfe.zza(zzfe.this).onAdFailedToLoad(1);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not notify onAdFailedToLoad event.", localRemoteException);
          }
        }
      });
    }
  }
}
