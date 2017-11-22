package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.zzaa;
import java.net.URI;
import java.net.URISyntaxException;

@zzmb
public class zzra
  extends WebViewClient
{
  private final zzqp zzGt;
  private final zzlk zzPD;
  private final String zzZL = zzbm(paramString);
  private boolean zzZM = false;
  
  public zzra(zzlk paramZzlk, zzqp paramZzqp, String paramString)
  {
    zzGt = paramZzqp;
    zzPD = paramZzlk;
  }
  
  private String zzbm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, paramString.length() - 1);
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        zzpe.e(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "JavascriptAdWebViewClient::onLoadResource: ".concat(paramWebView);; paramWebView = new String("JavascriptAdWebViewClient::onLoadResource: "))
    {
      zzpe.zzbc(paramWebView);
      if (!zzbl(paramString)) {
        zzGt.zzkV().onLoadResource(zzGt.getWebView(), paramString);
      }
      return;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "JavascriptAdWebViewClient::onPageFinished: ".concat(paramWebView);; paramWebView = new String("JavascriptAdWebViewClient::onPageFinished: "))
    {
      zzpe.zzbc(paramWebView);
      if (!zzZM)
      {
        zzPD.zzix();
        zzZM = true;
      }
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ".concat(paramWebView);; paramWebView = new String("JavascriptAdWebViewClient::shouldOverrideUrlLoading: "))
    {
      zzpe.zzbc(paramWebView);
      if (!zzbl(paramString)) {
        break;
      }
      zzpe.zzbc("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return zzGt.zzkV().shouldOverrideUrlLoading(zzGt.getWebView(), paramString);
  }
  
  protected boolean zzbl(String paramString)
  {
    paramString = zzbm(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new URI(paramString);
        if ("passback".equals(((URI)localObject1).getScheme()))
        {
          zzpe.zzbc("Passback received");
          zzPD.zziy();
          return true;
        }
        if (!TextUtils.isEmpty(zzZL))
        {
          Object localObject2 = new URI(zzZL);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((zzaa.equal(paramString, str)) && (zzaa.equal(localObject2, localObject1)))
          {
            zzpe.zzbc("Passback received");
            zzPD.zziy();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        zzpe.e(paramString.getMessage());
      }
    }
    return false;
  }
}
