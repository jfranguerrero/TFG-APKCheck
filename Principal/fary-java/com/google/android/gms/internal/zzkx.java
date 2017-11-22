package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzmb
public class zzkx
  implements zzkv
{
  private final Context mContext;
  final Set<WebView> zzOG = Collections.synchronizedSet(new HashSet());
  
  public zzkx(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public void zza(String paramString1, final String paramString2, final String paramString3)
  {
    zzpe.zzbc("Fetching assets for the given html");
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        final WebView localWebView = zzij();
        localWebView.setWebViewClient(new WebViewClient()
        {
          public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            zzpe.zzbc("Loading assets have finished");
            zzOG.remove(localWebView);
          }
          
          public void onReceivedError(WebView paramAnonymous2WebView, int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            zzpe.zzbe("Loading assets have failed.");
            zzOG.remove(localWebView);
          }
        });
        zzOG.add(localWebView);
        localWebView.loadDataWithBaseURL(paramString2, paramString3, "text/html", "UTF-8", null);
        zzpe.zzbc("Fetching assets finished.");
      }
    });
  }
  
  public WebView zzij()
  {
    WebView localWebView = new WebView(mContext);
    localWebView.getSettings().setJavaScriptEnabled(true);
    return localWebView;
  }
}
