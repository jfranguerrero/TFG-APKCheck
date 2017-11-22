package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzmb
public final class zzkf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final zzju zzKW;
  
  public zzkf(zzju paramZzju)
  {
    zzKW = paramZzju;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzpy.zzbc("Adapter called onClick.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onClick must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdClicked();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdClicked.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzpy.zzbc("Adapter called onDismissScreen.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzpy.zzbc("Adapter called onDismissScreen.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdClosed();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdClosed.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    paramMediationBannerAdapter = String.valueOf(paramErrorCode);
    zzpy.zzbc(String.valueOf(paramMediationBannerAdapter).length() + 47 + "Adapter called onFailedToReceiveAd with error. " + paramMediationBannerAdapter);
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdFailedToLoad(zzkg.zza(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdFailedToLoad(zzkg.zza(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    paramMediationInterstitialAdapter = String.valueOf(paramErrorCode);
    zzpy.zzbc(String.valueOf(paramMediationInterstitialAdapter).length() + 47 + "Adapter called onFailedToReceiveAd with error " + paramMediationInterstitialAdapter + ".");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdFailedToLoad(zzkg.zza(paramErrorCode));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdFailedToLoad.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdFailedToLoad(zzkg.zza(paramErrorCode));
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzpy.zzbc("Adapter called onLeaveApplication.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzpy.zzbc("Adapter called onLeaveApplication.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdLeftApplication();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdLeftApplication.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzpy.zzbc("Adapter called onPresentScreen.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzpy.zzbc("Adapter called onPresentScreen.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdOpened();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdOpened.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    zzpy.zzbc("Adapter called onReceivedAd.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzpy.zzc("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    zzpy.zzbc("Adapter called onReceivedAd.");
    if (!zzeh.zzeO().zzkJ())
    {
      zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzkf.zza(zzkf.this).onAdLoaded();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpy.zzc("Could not call onAdLoaded.", localRemoteException);
          }
        }
      });
      return;
    }
    try
    {
      zzKW.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzpy.zzc("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
}
