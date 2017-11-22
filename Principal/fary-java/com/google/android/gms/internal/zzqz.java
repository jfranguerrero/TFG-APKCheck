package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzv;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzmb
@TargetApi(11)
public class zzqz
  extends zzqq
{
  public zzqz(zzqp paramZzqp, boolean paramBoolean)
  {
    super(paramZzqp, paramBoolean);
  }
  
  protected WebResourceResponse zza(WebView paramWebView, String paramString, @Nullable Map<String, String> paramMap)
  {
    if (!(paramWebView instanceof zzqp))
    {
      zzpe.zzbe("Tried to intercept request from a WebView that wasn't an AdWebView.");
      return null;
    }
    paramMap = (zzqp)paramWebView;
    if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName())) {
      return super.shouldInterceptRequest(paramWebView, paramString);
    }
    if (paramMap.zzkV() != null) {
      paramMap.zzkV().zzhl();
    }
    if (zzbDzzzl) {
      paramWebView = (String)zzfx.zzBJ.get();
    }
    for (;;)
    {
      try
      {
        paramWebView = zzf(paramMap.getContext(), zzkYzzaZ, paramWebView);
        return paramWebView;
      }
      catch (InterruptedException paramWebView)
      {
        paramWebView = String.valueOf(paramWebView.getMessage());
        if (paramWebView.length() == 0) {
          continue;
        }
        paramWebView = "Could not fetch MRAID JS. ".concat(paramWebView);
        zzpe.zzbe(paramWebView);
        return null;
        paramWebView = new String("Could not fetch MRAID JS. ");
        continue;
      }
      catch (ExecutionException paramWebView)
      {
        continue;
      }
      catch (IOException paramWebView)
      {
        continue;
      }
      catch (TimeoutException paramWebView)
      {
        continue;
      }
      if (paramMap.zzkZ()) {
        paramWebView = (String)zzfx.zzBI.get();
      } else {
        paramWebView = (String)zzfx.zzBH.get();
      }
    }
  }
  
  protected WebResourceResponse zzf(Context paramContext, String paramString1, String paramString2)
    throws IOException, ExecutionException, InterruptedException, TimeoutException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", zzv.zzcJ().zzh(paramContext, paramString1));
    localHashMap.put("Cache-Control", "max-stale=3600");
    paramContext = (String)new zzpp(paramContext).zzc(paramString2, localHashMap).get(60L, TimeUnit.SECONDS);
    if (paramContext == null) {
      return null;
    }
    return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(paramContext.getBytes("UTF-8")));
  }
}
