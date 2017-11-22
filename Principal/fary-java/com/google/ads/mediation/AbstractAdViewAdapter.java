package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzrd;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@zzmb
public abstract class AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzrd
{
  public static final String AD_UNIT_ID_PARAMETER = "pubid";
  protected AdView zzcC;
  protected InterstitialAd zzcD;
  private AdLoader zzcE;
  private Context zzcF;
  private InterstitialAd zzcG;
  private MediationRewardedVideoAdListener zzcH;
  final RewardedVideoAdListener zzcI = new RewardedVideoAdListener()
  {
    public void onRewarded(RewardItem paramAnonymousRewardItem)
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onRewarded(AbstractAdViewAdapter.this, paramAnonymousRewardItem);
    }
    
    public void onRewardedVideoAdClosed()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdClosed(AbstractAdViewAdapter.this);
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this, null);
    }
    
    public void onRewardedVideoAdFailedToLoad(int paramAnonymousInt)
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdFailedToLoad(AbstractAdViewAdapter.this, paramAnonymousInt);
    }
    
    public void onRewardedVideoAdLeftApplication()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdLeftApplication(AbstractAdViewAdapter.this);
    }
    
    public void onRewardedVideoAdLoaded()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdLoaded(AbstractAdViewAdapter.this);
    }
    
    public void onRewardedVideoAdOpened()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onAdOpened(AbstractAdViewAdapter.this);
    }
    
    public void onRewardedVideoStarted()
    {
      AbstractAdViewAdapter.zza(AbstractAdViewAdapter.this).onVideoStarted(AbstractAdViewAdapter.this);
    }
  };
  
  public AbstractAdViewAdapter() {}
  
  public String getAdUnitId(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }
  
  public View getBannerView()
  {
    return zzcC;
  }
  
  public Bundle getInterstitialAdapterInfo()
  {
    return new MediationAdapter.zza().zzak(1).zzlL();
  }
  
  public void initialize(Context paramContext, MediationAdRequest paramMediationAdRequest, String paramString, MediationRewardedVideoAdListener paramMediationRewardedVideoAdListener, Bundle paramBundle1, Bundle paramBundle2)
  {
    zzcF = paramContext.getApplicationContext();
    zzcH = paramMediationRewardedVideoAdListener;
    zzcH.onInitializationSucceeded(this);
  }
  
  public boolean isInitialized()
  {
    return zzcH != null;
  }
  
  public void loadAd(MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((zzcF == null) || (zzcH == null))
    {
      zzpy.e("AdMobAdapter.loadAd called before initialize.");
      return;
    }
    zzcG = new InterstitialAd(zzcF);
    zzcG.zzd(true);
    zzcG.setAdUnitId(getAdUnitId(paramBundle1));
    zzcG.setRewardedVideoAdListener(zzcI);
    zzcG.loadAd(zza(zzcF, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void onDestroy()
  {
    if (zzcC != null)
    {
      zzcC.destroy();
      zzcC = null;
    }
    if (zzcD != null) {
      zzcD = null;
    }
    if (zzcE != null) {
      zzcE = null;
    }
    if (zzcG != null) {
      zzcG = null;
    }
  }
  
  public void onPause()
  {
    if (zzcC != null) {
      zzcC.pause();
    }
  }
  
  public void onResume()
  {
    if (zzcC != null) {
      zzcC.resume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzcC = new AdView(paramContext);
    zzcC.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    zzcC.setAdUnitId(getAdUnitId(paramBundle1));
    zzcC.setAdListener(new zzc(this, paramMediationBannerListener));
    zzcC.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzcD = new InterstitialAd(paramContext);
    zzcD.setAdUnitId(getAdUnitId(paramBundle1));
    zzcD.setAdListener(new zzd(this, paramMediationInterstitialListener));
    zzcD.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    paramMediationNativeListener = new zze(this, paramMediationNativeListener);
    AdLoader.Builder localBuilder = zza(paramContext, paramBundle1.getString("pubid")).withAdListener(paramMediationNativeListener);
    NativeAdOptions localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
    if (localNativeAdOptions != null) {
      localBuilder.withNativeAdOptions(localNativeAdOptions);
    }
    if (paramNativeMediationAdRequest.isAppInstallAdRequested()) {
      localBuilder.forAppInstallAd(paramMediationNativeListener);
    }
    if (paramNativeMediationAdRequest.isContentAdRequested()) {
      localBuilder.forContentAd(paramMediationNativeListener);
    }
    zzcE = localBuilder.build();
    zzcE.loadAd(zza(paramContext, paramNativeMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void showInterstitial()
  {
    zzcD.show();
  }
  
  public void showVideo()
  {
    zzcG.show();
  }
  
  protected abstract Bundle zza(Bundle paramBundle1, Bundle paramBundle2);
  
  AdLoader.Builder zza(Context paramContext, String paramString)
  {
    return new AdLoader.Builder(paramContext, paramString);
  }
  
  AdRequest zza(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Object localObject = paramMediationAdRequest.getBirthday();
    if (localObject != null) {
      localBuilder.setBirthday((Date)localObject);
    }
    int i = paramMediationAdRequest.getGender();
    if (i != 0) {
      localBuilder.setGender(i);
    }
    localObject = paramMediationAdRequest.getKeywords();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addKeyword((String)((Iterator)localObject).next());
      }
    }
    localObject = paramMediationAdRequest.getLocation();
    if (localObject != null) {
      localBuilder.setLocation((Location)localObject);
    }
    if (paramMediationAdRequest.isTesting()) {
      localBuilder.addTestDevice(zzeh.zzeO().zzO(paramContext));
    }
    if (paramMediationAdRequest.taggedForChildDirectedTreatment() != -1) {
      if (paramMediationAdRequest.taggedForChildDirectedTreatment() != 1) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      localBuilder.tagForChildDirectedTreatment(bool);
      localBuilder.setIsDesignedForFamilies(paramMediationAdRequest.isDesignedForFamilies());
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, zza(paramBundle1, paramBundle2));
      return localBuilder.build();
    }
  }
  
  static class zza
    extends NativeAppInstallAdMapper
  {
    private final NativeAppInstallAd zzcK;
    
    public zza(NativeAppInstallAd paramNativeAppInstallAd)
    {
      zzcK = paramNativeAppInstallAd;
      setHeadline(paramNativeAppInstallAd.getHeadline().toString());
      setImages(paramNativeAppInstallAd.getImages());
      setBody(paramNativeAppInstallAd.getBody().toString());
      setIcon(paramNativeAppInstallAd.getIcon());
      setCallToAction(paramNativeAppInstallAd.getCallToAction().toString());
      if (paramNativeAppInstallAd.getStarRating() != null) {
        setStarRating(paramNativeAppInstallAd.getStarRating().doubleValue());
      }
      if (paramNativeAppInstallAd.getStore() != null) {
        setStore(paramNativeAppInstallAd.getStore().toString());
      }
      if (paramNativeAppInstallAd.getPrice() != null) {
        setPrice(paramNativeAppInstallAd.getPrice().toString());
      }
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
      zza(paramNativeAppInstallAd.getVideoController());
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(zzcK);
      }
    }
  }
  
  static class zzb
    extends NativeContentAdMapper
  {
    private final NativeContentAd zzcL;
    
    public zzb(NativeContentAd paramNativeContentAd)
    {
      zzcL = paramNativeContentAd;
      setHeadline(paramNativeContentAd.getHeadline().toString());
      setImages(paramNativeContentAd.getImages());
      setBody(paramNativeContentAd.getBody().toString());
      if (paramNativeContentAd.getLogo() != null) {
        setLogo(paramNativeContentAd.getLogo());
      }
      setCallToAction(paramNativeContentAd.getCallToAction().toString());
      setAdvertiser(paramNativeContentAd.getAdvertiser().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(zzcL);
      }
    }
  }
  
  static final class zzc
    extends AdListener
    implements zzdt
  {
    final AbstractAdViewAdapter zzcM;
    final MediationBannerListener zzcN;
    
    public zzc(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
    {
      zzcM = paramAbstractAdViewAdapter;
      zzcN = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      zzcN.onAdClicked(zzcM);
    }
    
    public void onAdClosed()
    {
      zzcN.onAdClosed(zzcM);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzcN.onAdFailedToLoad(zzcM, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzcN.onAdLeftApplication(zzcM);
    }
    
    public void onAdLoaded()
    {
      zzcN.onAdLoaded(zzcM);
    }
    
    public void onAdOpened()
    {
      zzcN.onAdOpened(zzcM);
    }
  }
  
  static final class zzd
    extends AdListener
    implements zzdt
  {
    final AbstractAdViewAdapter zzcM;
    final MediationInterstitialListener zzcO;
    
    public zzd(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      zzcM = paramAbstractAdViewAdapter;
      zzcO = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      zzcO.onAdClicked(zzcM);
    }
    
    public void onAdClosed()
    {
      zzcO.onAdClosed(zzcM);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzcO.onAdFailedToLoad(zzcM, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzcO.onAdLeftApplication(zzcM);
    }
    
    public void onAdLoaded()
    {
      zzcO.onAdLoaded(zzcM);
    }
    
    public void onAdOpened()
    {
      zzcO.onAdOpened(zzcM);
    }
  }
  
  static final class zze
    extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, zzdt
  {
    final AbstractAdViewAdapter zzcM;
    final MediationNativeListener zzcP;
    
    public zze(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
    {
      zzcM = paramAbstractAdViewAdapter;
      zzcP = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      zzcP.onAdClicked(zzcM);
    }
    
    public void onAdClosed()
    {
      zzcP.onAdClosed(zzcM);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzcP.onAdFailedToLoad(zzcM, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzcP.onAdLeftApplication(zzcM);
    }
    
    public void onAdLoaded() {}
    
    public void onAdOpened()
    {
      zzcP.onAdOpened(zzcM);
    }
    
    public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      zzcP.onAdLoaded(zzcM, new AbstractAdViewAdapter.zza(paramNativeAppInstallAd));
    }
    
    public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      zzcP.onAdLoaded(zzcM, new AbstractAdViewAdapter.zzb(paramNativeContentAd));
    }
  }
}
