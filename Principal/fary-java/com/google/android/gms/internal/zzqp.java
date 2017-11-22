package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public abstract interface zzqp
  extends zzt, zzcv.zzb, zzjb
{
  public abstract void destroy();
  
  public abstract Context getContext();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract void getLocationOnScreen(int[] paramArrayOfInt);
  
  public abstract int getMeasuredHeight();
  
  public abstract int getMeasuredWidth();
  
  public abstract ViewParent getParent();
  
  public abstract String getRequestId();
  
  public abstract int getRequestedOrientation();
  
  public abstract View getView();
  
  public abstract WebView getWebView();
  
  public abstract boolean isDestroyed();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, @Nullable String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);
  
  public abstract void setWebViewClient(WebViewClient paramWebViewClient);
  
  public abstract void stopLoading();
  
  public abstract void zzJ(boolean paramBoolean);
  
  public abstract void zzK(int paramInt);
  
  public abstract void zzK(boolean paramBoolean);
  
  public abstract void zzL(boolean paramBoolean);
  
  public abstract void zzM(boolean paramBoolean);
  
  public abstract void zza(Context paramContext, zzec paramZzec, zzgf paramZzgf);
  
  public abstract void zza(zzec paramZzec);
  
  public abstract void zza(zzqu paramZzqu);
  
  public abstract void zza(String paramString, Map<String, ?> paramMap);
  
  public abstract void zza(String paramString, JSONObject paramJSONObject);
  
  public abstract void zzb(zze paramZze);
  
  public abstract void zzb(zzgs paramZzgs);
  
  public abstract zzec zzbD();
  
  public abstract void zzbf(String paramString);
  
  public abstract void zzbg(String paramString);
  
  public abstract zzd zzbz();
  
  public abstract void zzc(zze paramZze);
  
  public abstract void zzhp();
  
  public abstract void zzi(String paramString1, String paramString2);
  
  public abstract void zzkP();
  
  public abstract void zzkQ();
  
  public abstract Activity zzkR();
  
  public abstract Context zzkS();
  
  public abstract zze zzkT();
  
  public abstract zze zzkU();
  
  @Nullable
  public abstract zzqq zzkV();
  
  public abstract boolean zzkW();
  
  public abstract zzav zzkX();
  
  public abstract zzqa zzkY();
  
  public abstract boolean zzkZ();
  
  public abstract void zzla();
  
  public abstract boolean zzlb();
  
  public abstract boolean zzlc();
  
  @Nullable
  public abstract zzqo zzld();
  
  @Nullable
  public abstract zzgd zzle();
  
  public abstract zzge zzlf();
  
  @Nullable
  public abstract zzqu zzlg();
  
  public abstract boolean zzlh();
  
  public abstract void zzli();
  
  public abstract void zzlj();
  
  @Nullable
  public abstract View.OnClickListener zzlk();
  
  public abstract zzgs zzll();
  
  public abstract void zzlm();
}
