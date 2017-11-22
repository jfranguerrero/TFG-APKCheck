package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzpy;

public abstract class NativeAdView
  extends FrameLayout
{
  private final FrameLayout zzsc = zzd(paramContext);
  private final zzhb zzsd = zzbw();
  
  public NativeAdView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private zzhb zzbw()
  {
    zzac.zzb(zzsc, "createDelegate must be called after mOverlayFrame has been created");
    return zzeh.zzeP().zza(zzsc.getContext(), this, zzsc);
  }
  
  private FrameLayout zzd(Context paramContext)
  {
    paramContext = zze(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramContext);
    return paramContext;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(zzsc);
  }
  
  public void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (zzsc != paramView) {
      super.bringChildToFront(zzsc);
    }
  }
  
  public void destroy()
  {
    try
    {
      zzsd.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpy.zzb("Unable to destroy native ad view", localRemoteException);
    }
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    super.addView(zzsc);
  }
  
  public void removeView(View paramView)
  {
    if (zzsc == paramView) {
      return;
    }
    super.removeView(paramView);
  }
  
  public void setNativeAd(NativeAd paramNativeAd)
  {
    try
    {
      zzsd.zze((zzd)paramNativeAd.zzbv());
      return;
    }
    catch (RemoteException paramNativeAd)
    {
      zzpy.zzb("Unable to call setNativeAd on delegate", paramNativeAd);
    }
  }
  
  protected void zza(String paramString, View paramView)
  {
    try
    {
      zzsd.zzc(paramString, zze.zzA(paramView));
      return;
    }
    catch (RemoteException paramString)
    {
      zzpy.zzb("Unable to call setAssetView on delegate", paramString);
    }
  }
  
  FrameLayout zze(Context paramContext)
  {
    return new FrameLayout(paramContext);
  }
  
  protected View zzt(String paramString)
  {
    try
    {
      paramString = zzsd.zzU(paramString);
      if (paramString != null)
      {
        paramString = (View)zze.zzE(paramString);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      zzpy.zzb("Unable to call getAssetView on delegate", paramString);
    }
    return null;
  }
}
