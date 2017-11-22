package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzpy;

@KeepName
public final class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters>
{
  private View zzcV;
  CustomEventBanner zzcW;
  CustomEventInterstitial zzcX;
  
  public CustomEventAdapter() {}
  
  private void zza(View paramView)
  {
    zzcV = paramView;
  }
  
  private static <T> T zzj(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = String.valueOf(localThrowable.getMessage());
      zzpy.zzbe(String.valueOf(paramString).length() + 46 + String.valueOf(str).length() + "Could not instantiate custom event adapter: " + paramString + ". " + str);
    }
    return null;
  }
  
  public void destroy()
  {
    if (zzcW != null) {
      zzcW.destroy();
    }
    if (zzcX != null) {
      zzcX.destroy();
    }
  }
  
  public Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }
  
  public View getBannerView()
  {
    return zzcV;
  }
  
  public Class<CustomEventServerParameters> getServerParametersType()
  {
    return CustomEventServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    zzcW = ((CustomEventBanner)zzj(className));
    if (zzcW == null)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(label))
    {
      zzcW.requestBannerAd(new zza(this, paramMediationBannerListener), paramActivity, label, parameter, paramAdSize, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    zzcX = ((CustomEventInterstitial)zzj(className));
    if (zzcX == null)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(label))
    {
      zzcX.requestInterstitialAd(zza(paramMediationInterstitialListener), paramActivity, label, parameter, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void showInterstitial()
  {
    zzcX.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzcY;
    private final MediationBannerListener zzcZ;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      zzcY = paramCustomEventAdapter;
      zzcZ = paramMediationBannerListener;
    }
    
    public void onClick()
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzcZ.onClick(zzcY);
    }
    
    public void onDismissScreen()
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzcZ.onDismissScreen(zzcY);
    }
    
    public void onFailedToReceiveAd()
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzcZ.onFailedToReceiveAd(zzcY, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzcZ.onLeaveApplication(zzcY);
    }
    
    public void onPresentScreen()
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzcZ.onPresentScreen(zzcY);
    }
    
    public void onReceivedAd(View paramView)
    {
      zzpy.zzbc("Custom event adapter called onReceivedAd.");
      CustomEventAdapter.zza(zzcY, paramView);
      zzcZ.onReceivedAd(zzcY);
    }
  }
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzcY;
    private final MediationInterstitialListener zzda;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      zzcY = paramCustomEventAdapter;
      zzda = paramMediationInterstitialListener;
    }
    
    public void onDismissScreen()
    {
      zzpy.zzbc("Custom event adapter called onDismissScreen.");
      zzda.onDismissScreen(zzcY);
    }
    
    public void onFailedToReceiveAd()
    {
      zzpy.zzbc("Custom event adapter called onFailedToReceiveAd.");
      zzda.onFailedToReceiveAd(zzcY, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      zzpy.zzbc("Custom event adapter called onLeaveApplication.");
      zzda.onLeaveApplication(zzcY);
    }
    
    public void onPresentScreen()
    {
      zzpy.zzbc("Custom event adapter called onPresentScreen.");
      zzda.onPresentScreen(zzcY);
    }
    
    public void onReceivedAd()
    {
      zzpy.zzbc("Custom event adapter called onReceivedAd.");
      zzda.onReceivedAd(CustomEventAdapter.this);
    }
  }
}
