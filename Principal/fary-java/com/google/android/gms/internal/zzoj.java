package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzoj
  implements MediationRewardedVideoAdListener
{
  private final zzoi zzVi;
  
  public zzoj(zzoi paramZzoi)
  {
    zzVi = paramZzoi;
  }
  
  public void onAdClicked(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onAdClicked must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClicked.");
    try
    {
      zzVi.zzv(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onAdClicked.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdClosed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onAdClosed must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdClosed.");
    try
    {
      zzVi.zzu(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onAdClosed.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    zzac.zzdn("onAdFailedToLoad must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdFailedToLoad.");
    try
    {
      zzVi.zzc(zze.zzA(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onAdFailedToLoad.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onAdLeftApplication must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLeftApplication.");
    try
    {
      zzVi.zzw(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onAdLeftApplication.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdLoaded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onAdLoaded must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdLoaded.");
    try
    {
      zzVi.zzr(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onAdLoaded.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdOpened(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onAdOpened must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onAdOpened.");
    try
    {
      zzVi.zzs(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onAdOpened.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onInitializationFailed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    zzac.zzdn("onInitializationFailed must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onInitializationFailed.");
    try
    {
      zzVi.zzb(zze.zzA(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onInitializationFailed.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onInitializationSucceeded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onInitializationSucceeded must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onInitializationSucceeded.");
    try
    {
      zzVi.zzq(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onInitializationSucceeded.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onRewarded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, RewardItem paramRewardItem)
  {
    zzac.zzdn("onRewarded must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onRewarded.");
    if (paramRewardItem != null) {}
    try
    {
      zzVi.zza(zze.zzA(paramMediationRewardedVideoAdAdapter), new zzok(paramRewardItem));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onRewarded.", paramMediationRewardedVideoAdAdapter);
    }
    zzVi.zza(zze.zzA(paramMediationRewardedVideoAdAdapter), new zzok(paramMediationRewardedVideoAdAdapter.getClass().getName(), 1));
    return;
  }
  
  public void onVideoStarted(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzac.zzdn("onVideoStarted must be called on the main UI thread.");
    zzpy.zzbc("Adapter called onVideoStarted.");
    try
    {
      zzVi.zzt(zze.zzA(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      zzpy.zzc("Could not call onVideoStarted.", paramMediationRewardedVideoAdAdapter);
    }
  }
}
