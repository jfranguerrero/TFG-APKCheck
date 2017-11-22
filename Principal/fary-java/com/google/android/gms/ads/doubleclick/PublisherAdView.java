package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzpy;

public final class PublisherAdView
  extends ViewGroup
{
  private final zzez zzrJ;
  
  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    zzrJ = new zzez(this);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    zzrJ = new zzez(this, paramAttributeSet, true);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zzrJ = new zzez(this, paramAttributeSet, true);
  }
  
  public void destroy()
  {
    zzrJ.destroy();
  }
  
  public AdListener getAdListener()
  {
    return zzrJ.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return zzrJ.getAdSize();
  }
  
  public AdSize[] getAdSizes()
  {
    return zzrJ.getAdSizes();
  }
  
  public String getAdUnitId()
  {
    return zzrJ.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return zzrJ.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zzrJ.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zzrJ.getOnCustomRenderedAdLoadedListener();
  }
  
  public boolean isLoading()
  {
    return zzrJ.isLoading();
  }
  
  @RequiresPermission("android.permission.INTERNET")
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zzrJ.zza(paramPublisherAdRequest.zzbq());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1 - i) / 2;
      paramInt2 = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject1 = getChildAt(0);
    int j;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8))
    {
      measureChild((View)localObject1, paramInt1, paramInt2);
      j = ((View)localObject1).getMeasuredWidth();
      i = ((View)localObject1).getMeasuredHeight();
    }
    for (;;)
    {
      j = Math.max(j, getSuggestedMinimumWidth());
      i = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
      return;
      try
      {
        localObject1 = getAdSize();
        if (localObject1 != null)
        {
          Context localContext = getContext();
          j = ((AdSize)localObject1).getWidthInPixels(localContext);
          i = ((AdSize)localObject1).getHeightInPixels(localContext);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          zzpy.zzb("Unable to retrieve ad size.", localNullPointerException);
          Object localObject2 = null;
        }
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    zzrJ.pause();
  }
  
  public void recordManualImpression()
  {
    zzrJ.recordManualImpression();
  }
  
  public void resume()
  {
    zzrJ.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzrJ.setAdListener(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }
    zzrJ.zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    zzrJ.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    zzrJ.setAppEventListener(paramAppEventListener);
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    zzrJ.setCorrelator(paramCorrelator);
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzrJ.setManualImpressionsEnabled(paramBoolean);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zzrJ.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
}
