package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@zzmb
@TargetApi(11)
public class zzqx
  extends zzqz
{
  public zzqx(zzqp paramZzqp, boolean paramBoolean)
  {
    super(paramZzqp, paramBoolean);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return zza(paramWebView, paramString, null);
  }
}
