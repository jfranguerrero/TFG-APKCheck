package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@zzmb
@TargetApi(21)
public class zzrb
  extends zzqz
{
  public zzrb(zzqp paramZzqp, boolean paramBoolean)
  {
    super(paramZzqp, paramBoolean);
  }
  
  @Nullable
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null)) {
      return null;
    }
    return zza(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.getRequestHeaders());
  }
}
