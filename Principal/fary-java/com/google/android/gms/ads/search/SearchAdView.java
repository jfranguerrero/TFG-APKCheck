package com.google.android.gms.ads.search;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpy;

@zzmb
public final class SearchAdView
  extends ViewGroup
{
  private final zzez zzrJ;
  
  public SearchAdView(Context paramContext)
  {
    super(paramContext);
    zzrJ = new zzez(this);
  }
  
  public SearchAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    zzrJ = new zzez(this, paramAttributeSet, false);
  }
  
  public SearchAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zzrJ = new zzez(this, paramAttributeSet, false);
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
  
  @RequiresPermission("android.permission.INTERNET")
  public void loadAd(DynamicHeightSearchAdRequest paramDynamicHeightSearchAdRequest)
  {
    if (!AdSize.SEARCH.equals(getAdSize())) {
      throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }
    zzrJ.zza(paramDynamicHeightSearchAdRequest.zzbq());
  }
  
  @RequiresPermission("android.permission.INTERNET")
  public void loadAd(SearchAdRequest paramSearchAdRequest)
  {
    zzrJ.zza(paramSearchAdRequest.zzbq());
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
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    zzrJ.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public void setAdUnitId(String paramString)
  {
    zzrJ.setAdUnitId(paramString);
  }
}
