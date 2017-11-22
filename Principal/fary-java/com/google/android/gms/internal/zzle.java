package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

@zzmb
public final class zzle
  extends zzkz.zza
{
  private final InAppPurchaseListener zzAa;
  
  public zzle(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zzAa = paramInAppPurchaseListener;
  }
  
  public void zza(zzky paramZzky)
  {
    zzAa.onInAppPurchaseRequested(new zzlh(paramZzky));
  }
}
