package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzv;

@zzmb
@TargetApi(11)
public class zzqw
  extends WebChromeClient
{
  private final zzqp zzGt;
  
  public zzqw(zzqp paramZzqp)
  {
    zzGt = paramZzqp;
  }
  
  private final Context zza(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzqp)) {
      paramWebView = paramWebView.getContext();
    }
    zzqp localZzqp;
    Activity localActivity;
    do
    {
      return paramWebView;
      localZzqp = (zzqp)paramWebView;
      localActivity = localZzqp.zzkR();
      paramWebView = localActivity;
    } while (localActivity != null);
    return localZzqp.getContext();
  }
  
  private static void zza(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
  {
    paramBuilder.setMessage(paramString).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        confirm();
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        cancel();
      }
    }).create().show();
  }
  
  private static void zza(final Context paramContext, AlertDialog.Builder paramBuilder, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString1);
    paramContext = new EditText(paramContext);
    paramContext.setText(paramString2);
    localLinearLayout.addView(localTextView);
    localLinearLayout.addView(paramContext);
    paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        confirm(paramContext.getText().toString());
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        cancel();
      }
    }).create().show();
  }
  
  private final boolean zzlK()
  {
    return (zzv.zzcJ().zza(zzGt.getContext().getPackageManager(), zzGt.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) || (zzv.zzcJ().zza(zzGt.getContext().getPackageManager(), zzGt.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION"));
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzqp))
    {
      zzpe.zzbe("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    paramWebView = ((zzqp)paramWebView).zzkT();
    if (paramWebView == null)
    {
      zzpe.zzbe("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    paramWebView.close();
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str1 = String.valueOf(paramConsoleMessage.message());
    String str2 = String.valueOf(paramConsoleMessage.sourceId());
    int i = paramConsoleMessage.lineNumber();
    str1 = String.valueOf(str1).length() + 19 + String.valueOf(str2).length() + "JS: " + str1 + " (" + str2 + ":" + i + ")";
    if (str1.contains("Application Cache")) {
      return super.onConsoleMessage(paramConsoleMessage);
    }
    switch (7.zzZK[paramConsoleMessage.messageLevel().ordinal()])
    {
    default: 
      zzpe.zzbd(str1);
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      zzpe.e(str1);
      continue;
      zzpe.zzbe(str1);
      continue;
      zzpe.zzbd(str1);
      continue;
      zzpe.zzbc(str1);
    }
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)obj;
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(zzGt.zzkV());
    localWebViewTransport.setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L) {
      if ((paramLong2 > l) || (paramLong2 > 1048576L)) {}
    }
    for (;;)
    {
      paramQuotaUpdater.updateQuota(paramLong2);
      return;
      paramLong2 = 0L;
      continue;
      if (paramLong2 == 0L)
      {
        paramLong2 = Math.min(Math.min(131072L, l) + paramLong1, 1048576L);
      }
      else
      {
        paramLong3 = paramLong1;
        if (paramLong2 <= Math.min(1048576L - paramLong1, l)) {
          paramLong3 = paramLong1 + paramLong2;
        }
        paramLong2 = paramLong3;
      }
    }
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    if (paramCallback != null) {
      paramCallback.invoke(paramString, zzlK(), true);
    }
  }
  
  public final void onHideCustomView()
  {
    zze localZze = zzGt.zzkT();
    if (localZze == null)
    {
      zzpe.zzbe("Could not get ad overlay when hiding custom view.");
      return;
    }
    localZze.zzhi();
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramLong1 = 131072L + paramLong1;
    if (5242880L - paramLong2 < paramLong1)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zza(paramView, -1, paramCustomViewCallback);
  }
  
  protected final void zza(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zze localZze = zzGt.zzkT();
    if (localZze == null)
    {
      zzpe.zzbe("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    localZze.zza(paramView, paramCustomViewCallback);
    localZze.setRequestedOrientation(paramInt);
  }
  
  protected boolean zza(Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle(paramString1);
      if (paramBoolean) {
        zza(paramContext, localBuilder, paramString2, paramString3, paramJsPromptResult);
      } else {
        zza(localBuilder, paramString2, paramJsResult);
      }
    }
    catch (WindowManager.BadTokenException paramContext)
    {
      zzpe.zzc("Fail to display Dialog.", paramContext);
    }
    return true;
  }
}
