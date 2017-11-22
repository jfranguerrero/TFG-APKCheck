package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzpy;

class BaseAdView
  extends ViewGroup
{
  protected final zzez zzrJ;
  
  public BaseAdView(Context paramContext, int paramInt)
  {
    super(paramContext);
    zzrJ = new zzez(this, paramInt);
  }
  
  public BaseAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    zzrJ = new zzez(this, paramAttributeSet, false, paramInt);
  }
  
  public BaseAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    zzrJ = new zzez(this, paramAttributeSet, false, paramInt2);
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
  
  public String getAdUnitId()
  {
    return zzrJ.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zzrJ.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zzrJ.getMediationAdapterClassName();
  }
  
  public boolean isLoading()
  {
    return zzrJ.isLoading();
  }
  
  @RequiresPermission("android.permission.INTERNET")
  public void loadAd(AdRequest paramAdRequest)
  {
    zzrJ.zza(paramAdRequest.zzbq());
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
  
  public void resume()
  {
    zzrJ.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzrJ.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zzdt))) {
      zzrJ.zza((zzdt)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zzrJ.zza(null);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    zzrJ.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public void setAdUnitId(String paramString)
  {
    zzrJ.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zzrJ.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    zzrJ.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
}
