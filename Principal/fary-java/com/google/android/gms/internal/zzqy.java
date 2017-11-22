package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

@zzmb
@TargetApi(14)
public final class zzqy
  extends zzqw
{
  public zzqy(zzqp paramZzqp)
  {
    super(paramZzqp);
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zza(paramView, paramInt, paramCustomViewCallback);
  }
}
