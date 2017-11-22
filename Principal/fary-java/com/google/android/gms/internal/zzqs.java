package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import java.util.Map;
import org.json.JSONObject;

@zzmb
class zzqs
  extends FrameLayout
  implements zzqp
{
  private static final int zzMx = Color.argb(0, 0, 0, 0);
  private final zzqp zzYV;
  private final zzqo zzYW;
  
  public zzqs(zzqp paramZzqp)
  {
    super(paramZzqp.getContext());
    zzYV = paramZzqp;
    zzYW = new zzqo(paramZzqp.zzkS(), this, this);
    paramZzqp = zzYV.zzkV();
    if (paramZzqp != null) {
      paramZzqp.zzo(this);
    }
    addView(zzYV.getView());
  }
  
  public void destroy()
  {
    zzYV.destroy();
  }
  
  public String getRequestId()
  {
    return zzYV.getRequestId();
  }
  
  public int getRequestedOrientation()
  {
    return zzYV.getRequestedOrientation();
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return zzYV.getWebView();
  }
  
  public boolean isDestroyed()
  {
    return zzYV.isDestroyed();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    zzYV.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    zzYV.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    zzYV.loadUrl(paramString);
  }
  
  public void onPause()
  {
    zzYW.onPause();
    zzYV.onPause();
  }
  
  public void onResume()
  {
    zzYV.onResume();
  }
  
  public void setContext(Context paramContext)
  {
    zzYV.setContext(paramContext);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzYV.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    zzYV.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    zzYV.setRequestedOrientation(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    zzYV.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    zzYV.setWebViewClient(paramWebViewClient);
  }
  
  public void stopLoading()
  {
    zzYV.stopLoading();
  }
  
  public void zzJ(boolean paramBoolean)
  {
    zzYV.zzJ(paramBoolean);
  }
  
  public void zzK(int paramInt)
  {
    zzYV.zzK(paramInt);
  }
  
  public void zzK(boolean paramBoolean)
  {
    zzYV.zzK(paramBoolean);
  }
  
  public void zzL(boolean paramBoolean)
  {
    zzYV.zzL(paramBoolean);
  }
  
  public void zzM(boolean paramBoolean)
  {
    zzYV.zzM(paramBoolean);
  }
  
  public void zza(Context paramContext, zzec paramZzec, zzgf paramZzgf)
  {
    zzYW.onDestroy();
    zzYV.zza(paramContext, paramZzec, paramZzgf);
  }
  
  public void zza(zzcv.zza paramZza)
  {
    zzYV.zza(paramZza);
  }
  
  public void zza(zzec paramZzec)
  {
    zzYV.zza(paramZzec);
  }
  
  public void zza(zzqu paramZzqu)
  {
    zzYV.zza(paramZzqu);
  }
  
  public void zza(String paramString, zzhx paramZzhx)
  {
    zzYV.zza(paramString, paramZzhx);
  }
  
  public void zza(String paramString, Map<String, ?> paramMap)
  {
    zzYV.zza(paramString, paramMap);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    zzYV.zza(paramString, paramJSONObject);
  }
  
  public void zzb(zze paramZze)
  {
    zzYV.zzb(paramZze);
  }
  
  public void zzb(@Nullable zzgs paramZzgs)
  {
    zzYV.zzb(paramZzgs);
  }
  
  public void zzb(String paramString, zzhx paramZzhx)
  {
    zzYV.zzb(paramString, paramZzhx);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzYV.zzb(paramString, paramJSONObject);
  }
  
  public zzec zzbD()
  {
    return zzYV.zzbD();
  }
  
  public void zzbV()
  {
    zzYV.zzbV();
  }
  
  public void zzbW()
  {
    zzYV.zzbW();
  }
  
  public void zzbf(String paramString)
  {
    zzYV.zzbf(paramString);
  }
  
  public void zzbg(String paramString)
  {
    zzYV.zzbg(paramString);
  }
  
  public zzd zzbz()
  {
    return zzYV.zzbz();
  }
  
  public void zzc(zze paramZze)
  {
    zzYV.zzc(paramZze);
  }
  
  public void zzhp()
  {
    zzYV.zzhp();
  }
  
  public void zzi(String paramString1, String paramString2)
  {
    zzYV.zzi(paramString1, paramString2);
  }
  
  public void zzkP()
  {
    zzYV.zzkP();
  }
  
  public void zzkQ()
  {
    zzYV.zzkQ();
  }
  
  public Activity zzkR()
  {
    return zzYV.zzkR();
  }
  
  public Context zzkS()
  {
    return zzYV.zzkS();
  }
  
  public zze zzkT()
  {
    return zzYV.zzkT();
  }
  
  public zze zzkU()
  {
    return zzYV.zzkU();
  }
  
  public zzqq zzkV()
  {
    return zzYV.zzkV();
  }
  
  public boolean zzkW()
  {
    return zzYV.zzkW();
  }
  
  public zzav zzkX()
  {
    return zzYV.zzkX();
  }
  
  public zzqa zzkY()
  {
    return zzYV.zzkY();
  }
  
  public boolean zzkZ()
  {
    return zzYV.zzkZ();
  }
  
  public void zzla()
  {
    zzYW.onDestroy();
    zzYV.zzla();
  }
  
  public boolean zzlb()
  {
    return zzYV.zzlb();
  }
  
  public boolean zzlc()
  {
    return zzYV.zzlc();
  }
  
  public zzqo zzld()
  {
    return zzYW;
  }
  
  public zzgd zzle()
  {
    return zzYV.zzle();
  }
  
  public zzge zzlf()
  {
    return zzYV.zzlf();
  }
  
  public zzqu zzlg()
  {
    return zzYV.zzlg();
  }
  
  public boolean zzlh()
  {
    return zzYV.zzlh();
  }
  
  public void zzli()
  {
    zzYV.zzli();
  }
  
  public void zzlj()
  {
    zzYV.zzlj();
  }
  
  public View.OnClickListener zzlk()
  {
    return zzYV.zzlk();
  }
  
  @Nullable
  public zzgs zzll()
  {
    return zzYV.zzll();
  }
  
  public void zzlm()
  {
    setBackgroundColor(zzMx);
    zzYV.setBackgroundColor(zzMx);
  }
}
