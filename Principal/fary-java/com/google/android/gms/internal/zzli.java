package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@zzmb
public final class zzli
  extends zzld.zza
{
  private final PlayStorePurchaseListener zzAc;
  
  public zzli(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    zzAc = paramPlayStorePurchaseListener;
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return zzAc.isValidPurchase(paramString);
  }
  
  public void zza(zzlc paramZzlc)
  {
    zzAc.onInAppPurchaseFinished(new zzlg(paramZzlc));
  }
}
