package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public class zzff
  extends zzep.zza
{
  private zzel zzti;
  
  public zzff() {}
  
  public void destroy() {}
  
  public String getMediationAdapterClassName()
  {
    return null;
  }
  
  public boolean isLoading()
  {
    return false;
  }
  
  public boolean isReady()
  {
    return false;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void setManualImpressionsEnabled(boolean paramBoolean) {}
  
  public void setUserId(String paramString) {}
  
  public void showInterstitial() {}
  
  public void stopLoading() {}
  
  public void zza(zzec paramZzec) {}
  
  public void zza(zzek paramZzek) {}
  
  public void zza(zzel paramZzel)
  {
    zzti = paramZzel;
  }
  
  public void zza(zzer paramZzer) {}
  
  public void zza(zzet paramZzet) {}
  
  public void zza(zzfn paramZzfn) {}
  
  public void zza(zzgj paramZzgj) {}
  
  public void zza(zzkz paramZzkz) {}
  
  public void zza(zzld paramZzld, String paramString) {}
  
  public void zza(zznt paramZznt) {}
  
  public boolean zzb(zzdy paramZzdy)
  {
    zzpy.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
    zzpx.zzXU.post(new Runnable()
    {
      public void run()
      {
        if (zzff.zza(zzff.this) != null) {}
        try
        {
          zzff.zza(zzff.this).onAdFailedToLoad(1);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzpy.zzc("Could not notify onAdFailedToLoad event.", localRemoteException);
        }
      }
    });
    return false;
  }
  
  public zzd zzbC()
  {
    return null;
  }
  
  public zzec zzbD()
  {
    return null;
  }
  
  public void zzbF() {}
  
  public zzew zzbG()
  {
    return null;
  }
}
