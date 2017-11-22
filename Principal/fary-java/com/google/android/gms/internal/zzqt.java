package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
class zzqt
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzqp
{
  @Nullable
  private final zzav zzGr;
  private int zzLQ = -1;
  private int zzLR = -1;
  private int zzLT = -1;
  private int zzLU = -1;
  private String zzOn = "";
  private zzgd zzOo;
  private Boolean zzWh;
  private final zza zzYX;
  private final zzt zzYY;
  private zzqq zzYZ;
  private zze zzZa;
  private boolean zzZb;
  private boolean zzZc;
  private boolean zzZd;
  private boolean zzZe;
  private int zzZf;
  private boolean zzZg = true;
  boolean zzZh = false;
  private zzqu zzZi;
  private boolean zzZj;
  private boolean zzZk;
  private zzgs zzZl;
  private int zzZm;
  private int zzZn;
  private zzgd zzZo;
  private zzgd zzZp;
  private zzge zzZq;
  private WeakReference<View.OnClickListener> zzZr;
  private zze zzZs;
  private Map<String, zzil> zzZt;
  private final Object zzrN = new Object();
  private final zzd zzsz;
  private final zzqa zztr;
  private zzec zzum;
  private zzpw zzvP;
  private final WindowManager zzwf;
  
  protected zzqt(zza paramZza, zzec paramZzec, boolean paramBoolean1, boolean paramBoolean2, @Nullable zzav paramZzav, zzqa paramZzqa, zzgf paramZzgf, zzt paramZzt, zzd paramZzd)
  {
    super(paramZza);
    zzYX = paramZza;
    zzum = paramZzec;
    zzZd = paramBoolean1;
    zzZf = -1;
    zzGr = paramZzav;
    zztr = paramZzqa;
    zzYY = paramZzt;
    zzsz = paramZzd;
    zzwf = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramZzec = getSettings();
    paramZzec.setAllowFileAccess(false);
    paramZzec.setJavaScriptEnabled(true);
    paramZzec.setSavePassword(false);
    paramZzec.setSupportMultipleWindows(true);
    paramZzec.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramZzec.setMixedContentMode(2);
    }
    zzv.zzcJ().zza(paramZza, zzaZ, paramZzec);
    zzv.zzcL().zza(getContext(), paramZzec);
    setDownloadListener(this);
    zzlF();
    if (zzs.zzyD()) {
      addJavascriptInterface(new zzqv(this), "googleAdsJsInterface");
    }
    if (zzs.zzyx())
    {
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    zzvP = new zzpw(zzYX.zzkR(), this, this, null);
    zzd(paramZzgf);
  }
  
  private void zzO(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isVisible", str);
      zza("onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  static zzqt zzb(Context paramContext, zzec paramZzec, boolean paramBoolean1, boolean paramBoolean2, @Nullable zzav paramZzav, zzqa paramZzqa, zzgf paramZzgf, zzt paramZzt, zzd paramZzd)
  {
    return new zzqt(new zza(paramContext), paramZzec, paramBoolean1, paramBoolean2, paramZzav, paramZzqa, paramZzgf, paramZzt, paramZzd);
  }
  
  private void zzd(zzgf paramZzgf)
  {
    zzlJ();
    zzZq = new zzge(new zzgf(true, "make_wv", zzum.zzzk));
    zzZq.zzfv().zzc(paramZzgf);
    zzOo = zzgb.zzb(zzZq.zzfv());
    zzZq.zza("native:view_create", zzOo);
    zzZp = null;
    zzZo = null;
  }
  
  private void zzlB()
  {
    synchronized (zzrN)
    {
      zzWh = zzv.zzcN().zzjT();
      Boolean localBoolean = zzWh;
      if (localBoolean == null) {}
      try
      {
        evaluateJavascript("(function(){})()", null);
        zzb(Boolean.valueOf(true));
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          zzb(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void zzlC()
  {
    zzgb.zza(zzZq.zzfv(), zzOo, new String[] { "aeh2" });
  }
  
  private void zzlD()
  {
    zzgb.zza(zzZq.zzfv(), zzOo, new String[] { "aebb2" });
  }
  
  private void zzlF()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if ((zzZd) || (zzum.zzzl))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            zzpe.zzbc("Disabling hardware acceleration on an overlay.");
            zzlG();
            return;
          }
          zzpe.zzbc("Enabling hardware acceleration on an overlay.");
          zzlH();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        zzpe.zzbc("Disabling hardware acceleration on an AdView.");
        zzlG();
      }
      else
      {
        zzpe.zzbc("Enabling hardware acceleration on an AdView.");
        zzlH();
      }
    }
  }
  
  private void zzlG()
  {
    synchronized (zzrN)
    {
      if (!zzZe) {
        zzv.zzcL().zzu(this);
      }
      zzZe = true;
      return;
    }
  }
  
  private void zzlH()
  {
    synchronized (zzrN)
    {
      if (zzZe) {
        zzv.zzcL().zzt(this);
      }
      zzZe = false;
      return;
    }
  }
  
  private void zzlI()
  {
    synchronized (zzrN)
    {
      zzZt = null;
      return;
    }
  }
  
  private void zzlJ()
  {
    if (zzZq == null) {}
    zzgf localZzgf;
    do
    {
      return;
      localZzgf = zzZq.zzfv();
    } while ((localZzgf == null) || (zzv.zzcN().zzjN() == null));
    zzv.zzcN().zzjN().zza(localZzgf);
  }
  
  public void destroy()
  {
    synchronized (zzrN)
    {
      zzlJ();
      zzvP.zzkF();
      if (zzZa != null)
      {
        zzZa.close();
        zzZa.onDestroy();
        zzZa = null;
      }
      zzYZ.reset();
      if (zzZc) {
        return;
      }
      zzv.zzdg().zze(this);
      zzlI();
      zzZc = true;
      zzpe.v("Initiating WebView self destruct sequence in 3...");
      zzYZ.zzls();
      return;
    }
  }
  
  @TargetApi(19)
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzrN)
    {
      if (isDestroyed())
      {
        zzpe.zzbe("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    synchronized (zzrN)
    {
      if (!zzZc)
      {
        zzYZ.reset();
        zzv.zzdg().zze(this);
        zzlI();
      }
      super.finalize();
      return;
    }
  }
  
  public String getRequestId()
  {
    synchronized (zzrN)
    {
      String str = zzOn;
      return str;
    }
  }
  
  public int getRequestedOrientation()
  {
    synchronized (zzrN)
    {
      int i = zzZf;
      return i;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this;
  }
  
  public boolean isDestroyed()
  {
    synchronized (zzrN)
    {
      boolean bool = zzZc;
      return bool;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    synchronized (zzrN)
    {
      if (!isDestroyed())
      {
        super.loadData(paramString1, paramString2, paramString3);
        return;
      }
      zzpe.zzbe("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (zzrN)
    {
      if (!isDestroyed())
      {
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      zzpe.zzbe("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadUrl(String paramString)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        boolean bool = isDestroyed();
        if (!bool) {
          try
          {
            super.loadUrl(paramString);
            return;
          }
          catch (Throwable paramString)
          {
            paramString = String.valueOf(paramString);
            zzpe.zzbe(String.valueOf(paramString).length() + 24 + "Could not call loadUrl. " + paramString);
            continue;
          }
        }
      }
      zzpe.zzbe("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (zzrN)
      {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
          zzvP.onAttachedToWindow();
        }
        boolean bool1 = zzZj;
        if ((zzkV() != null) && (zzkV().zzlo()))
        {
          bool1 = bool2;
          if (!zzZk)
          {
            Object localObject2 = zzkV().zzlp();
            if (localObject2 != null) {
              zzv.zzdh().zza(getView(), (ViewTreeObserver.OnGlobalLayoutListener)localObject2);
            }
            localObject2 = zzkV().zzlq();
            if (localObject2 != null) {
              zzv.zzdh().zza(getView(), (ViewTreeObserver.OnScrollChangedListener)localObject2);
            }
            zzZk = true;
            bool1 = bool2;
          }
          zzO(bool1);
          return;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    synchronized (zzrN)
    {
      if (!isDestroyed()) {
        zzvP.onDetachedFromWindow();
      }
      super.onDetachedFromWindow();
      if ((zzZk) && (zzkV() != null) && (zzkV().zzlo()) && (getViewTreeObserver() != null) && (getViewTreeObserver().isAlive()))
      {
        Object localObject2 = zzkV().zzlp();
        if (localObject2 != null) {
          zzv.zzcL().zza(getViewTreeObserver(), (ViewTreeObserver.OnGlobalLayoutListener)localObject2);
        }
        localObject2 = zzkV().zzlq();
        if (localObject2 != null) {
          getViewTreeObserver().removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)localObject2);
        }
        zzZk = false;
      }
      zzO(false);
      return;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      zzv.zzcJ().zzb(getContext(), paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      zzpe.zzbc(String.valueOf(paramString1).length() + 51 + String.valueOf(paramString4).length() + "Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  @TargetApi(21)
  protected void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return;
      } while ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow()));
      super.onDraw(paramCanvas);
    } while ((zzkV() == null) || (zzkV().zzlz() == null));
    zzkV().zzlz().zzcc();
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((Boolean)zzfx.zzCp.get()).booleanValue())
    {
      float f1 = paramMotionEvent.getAxisValue(9);
      float f2 = paramMotionEvent.getAxisValue(10);
      if (paramMotionEvent.getActionMasked() == 8) {}
      for (int i = 1; (i != 0) && (((f1 > 0.0F) && (!canScrollVertically(-1))) || ((f1 < 0.0F) && (!canScrollVertically(1))) || ((f2 > 0.0F) && (!canScrollHorizontally(-1))) || ((f2 < 0.0F) && (!canScrollHorizontally(1)))); i = 0) {
        return false;
      }
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public void onGlobalLayout()
  {
    boolean bool = zzlA();
    zze localZze = zzkT();
    if ((localZze != null) && (bool)) {
      localZze.zzho();
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = Integer.MAX_VALUE;
    synchronized (zzrN)
    {
      if (isDestroyed())
      {
        setMeasuredDimension(0, 0);
        return;
      }
      if ((isInEditMode()) || (zzZd) || (zzum.zzzn))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    float f;
    int i;
    if (zzum.zzzo)
    {
      if ((((Boolean)zzfx.zzEe.get()).booleanValue()) || (!zzs.zzyD()))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      zza("/contentHeight", zzlE());
      zzbj("(function() {  var height = -1;  if (document.body) { height = document.body.offsetHeight;}  else if (document.documentElement) {      height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  window.googleAdsJsInterface.notify(url);  })();");
      f = zzYX.getResources().getDisplayMetrics().density;
      i = View.MeasureSpec.getSize(paramInt1);
    }
    int m;
    int j;
    switch (zzZn)
    {
    case -1: 
      for (paramInt1 = (int)(f * zzZn);; paramInt1 = View.MeasureSpec.getSize(paramInt2))
      {
        setMeasuredDimension(i, paramInt1);
        return;
      }
      if (zzum.zzzl)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        zzwf.getDefaultDisplay().getMetrics(localDisplayMetrics);
        setMeasuredDimension(widthPixels, heightPixels);
        return;
      }
      int n = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.getSize(paramInt1);
      m = View.MeasureSpec.getMode(paramInt2);
      j = View.MeasureSpec.getSize(paramInt2);
      if (n != Integer.MIN_VALUE) {
        if (n != 1073741824) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if ((zzum.widthPixels > paramInt1) || (zzum.heightPixels > paramInt2))
      {
        f = zzYX.getResources().getDisplayMetrics().density;
        paramInt1 = (int)(zzum.widthPixels / f);
        paramInt2 = (int)(zzum.heightPixels / f);
        i = (int)(i / f);
        j = (int)(j / f);
        zzpe.zzbe(103 + "Not enough space to show ad. Needs " + paramInt1 + "x" + paramInt2 + " dp, but only has " + i + "x" + j + " dp.");
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
      }
      for (;;)
      {
        return;
        if (getVisibility() != 8) {
          setVisibility(0);
        }
        setMeasuredDimension(zzum.widthPixels, zzum.heightPixels);
      }
      paramInt1 = Integer.MAX_VALUE;
      break label509;
      break;
      paramInt1 = i;
      label509:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = k;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = j;
      }
    }
  }
  
  public void onPause()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzs.zzyx())
        {
          super.onPause();
          return;
        }
      }
      catch (Exception localException)
      {
        zzpe.zzb("Could not pause webview.", localException);
      }
    }
  }
  
  public void onResume()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzs.zzyx())
        {
          super.onResume();
          return;
        }
      }
      catch (Exception localException)
      {
        zzpe.zzb("Could not resume webview.", localException);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (zzkV().zzlo()) {}
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzZl != null) {
          zzZl.zzc(paramMotionEvent);
        }
        if (!isDestroyed()) {
          break;
        }
        return false;
      }
      if (zzGr != null) {
        zzGr.zza(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    zzYX.setBaseContext(paramContext);
    zzvP.zzl(zzYX.zzkR());
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzZr = new WeakReference(paramOnClickListener);
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    synchronized (zzrN)
    {
      zzZf = paramInt;
      if (zzZa != null) {
        zzZa.setRequestedOrientation(zzZf);
      }
      return;
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof zzqq)) {
      zzYZ = ((zzqq)paramWebViewClient);
    }
  }
  
  public void stopLoading()
  {
    if (isDestroyed()) {
      return;
    }
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzpe.zzb("Could not stop loading webview.", localException);
    }
  }
  
  public void zzJ(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzZd = paramBoolean;
      zzlF();
      return;
    }
  }
  
  public void zzK(int paramInt)
  {
    if (paramInt == 0) {
      zzlD();
    }
    zzlC();
    if (zzZq.zzfv() != null) {
      zzZq.zzfv().zzg("close_type", String.valueOf(paramInt));
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", zztr.zzaZ);
    zza("onhide", localHashMap);
  }
  
  public void zzK(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (zzZa != null)
      {
        zzZa.zza(zzYZ.zzdz(), paramBoolean);
        return;
      }
      zzZb = paramBoolean;
    }
  }
  
  public void zzL(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzZg = paramBoolean;
      return;
    }
  }
  
  public void zzM(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        int j = zzZm;
        if (paramBoolean)
        {
          i = 1;
          zzZm = (i + j);
          if ((zzZm <= 0) && (zzZa != null)) {
            zzZa.zzhr();
          }
          return;
        }
      }
      int i = -1;
    }
  }
  
  public void zza(Context paramContext, zzec paramZzec, zzgf paramZzgf)
  {
    synchronized (zzrN)
    {
      zzvP.zzkF();
      setContext(paramContext);
      zzZa = null;
      zzum = paramZzec;
      zzZd = false;
      zzZb = false;
      zzOn = "";
      zzZf = -1;
      zzv.zzcL().zzm(this);
      loadUrl("about:blank");
      zzYZ.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      zzZg = true;
      zzZh = false;
      zzZi = null;
      zzd(paramZzgf);
      zzZj = false;
      zzZm = 0;
      zzv.zzdg().zze(this);
      zzlI();
      return;
    }
  }
  
  public void zza(zzcv.zza paramZza)
  {
    synchronized (zzrN)
    {
      zzZj = zzxb;
      zzO(zzxb);
      return;
    }
  }
  
  public void zza(zzec paramZzec)
  {
    synchronized (zzrN)
    {
      zzum = paramZzec;
      requestLayout();
      return;
    }
  }
  
  public void zza(zzqu paramZzqu)
  {
    synchronized (zzrN)
    {
      if (zzZi != null)
      {
        zzpe.e("Attempt to create multiple AdWebViewVideoControllers.");
        return;
      }
      zzZi = paramZzqu;
      return;
    }
  }
  
  @TargetApi(19)
  protected void zza(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzrN)
    {
      if (!isDestroyed()) {
        evaluateJavascript(paramString, paramValueCallback);
      }
      do
      {
        return;
        zzpe.zzbe("The webview is destroyed. Ignoring action.");
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue(null);
    }
  }
  
  public void zza(String paramString, zzhx paramZzhx)
  {
    if (zzYZ != null) {
      zzYZ.zza(paramString, paramZzhx);
    }
  }
  
  public void zza(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = zzv.zzcJ().zzP(paramMap);
      zzb(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      zzpe.zzbe("Could not convert parameters to JSON.");
    }
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    zzi(paramString, localJSONObject.toString());
  }
  
  public void zzb(zze paramZze)
  {
    synchronized (zzrN)
    {
      zzZa = paramZze;
      return;
    }
  }
  
  public void zzb(zzgs paramZzgs)
  {
    synchronized (zzrN)
    {
      zzZl = paramZzgs;
      return;
    }
  }
  
  void zzb(Boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzWh = paramBoolean;
      zzv.zzcN().zzb(paramBoolean);
      return;
    }
  }
  
  public void zzb(String paramString, zzhx paramZzhx)
  {
    if (zzYZ != null) {
      zzYZ.zzb(paramString, paramZzhx);
    }
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    localObject = ((JSONObject)localObject).toString();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("(window.AFMA_ReceiveMessage || function() {})('");
    paramJSONObject.append(paramString);
    paramJSONObject.append("'");
    paramJSONObject.append(",");
    paramJSONObject.append((String)localObject);
    paramJSONObject.append(");");
    paramString = String.valueOf(paramJSONObject.toString());
    if (paramString.length() != 0) {}
    for (paramString = "Dispatching AFMA event: ".concat(paramString);; paramString = new String("Dispatching AFMA event: "))
    {
      zzpe.zzbc(paramString);
      zzbj(paramJSONObject.toString());
      return;
    }
  }
  
  public zzec zzbD()
  {
    synchronized (zzrN)
    {
      zzec localZzec = zzum;
      return localZzec;
    }
  }
  
  public void zzbV()
  {
    synchronized (zzrN)
    {
      zzZh = true;
      if (zzYY != null) {
        zzYY.zzbV();
      }
      return;
    }
  }
  
  public void zzbW()
  {
    synchronized (zzrN)
    {
      zzZh = false;
      if (zzYY != null) {
        zzYY.zzbW();
      }
      return;
    }
  }
  
  public void zzbf(String paramString)
  {
    synchronized (zzrN)
    {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString = String.valueOf(paramString);
          zzpe.zzbe(String.valueOf(paramString).length() + 24 + "Could not call loadUrl. " + paramString);
        }
      }
    }
  }
  
  public void zzbg(String paramString)
  {
    Object localObject = zzrN;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      zzOn = str;
      return;
    }
    finally {}
  }
  
  protected void zzbi(String paramString)
  {
    synchronized (zzrN)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      zzpe.zzbe("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void zzbj(String paramString)
  {
    if (zzs.zzyF())
    {
      if (zzjT() == null) {
        zzlB();
      }
      if (zzjT().booleanValue())
      {
        zza(paramString, null);
        return;
      }
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "javascript:".concat(paramString);; paramString = new String("javascript:"))
      {
        zzbi(paramString);
        return;
      }
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "javascript:".concat(paramString);; paramString = new String("javascript:"))
    {
      zzbi(paramString);
      return;
    }
  }
  
  public zzd zzbz()
  {
    return zzsz;
  }
  
  public void zzc(zze paramZze)
  {
    synchronized (zzrN)
    {
      zzZs = paramZze;
      return;
    }
  }
  
  public void zzhp()
  {
    if (zzZo == null)
    {
      zzgb.zza(zzZq.zzfv(), zzOo, new String[] { "aes2" });
      zzZo = zzgb.zzb(zzZq.zzfv());
      zzZq.zza("native:view_show", zzZo);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zztr.zzaZ);
    zza("onshow", localHashMap);
  }
  
  public void zzi(String paramString1, String paramString2)
  {
    zzbj(String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + "(" + paramString2 + ");");
  }
  
  Boolean zzjT()
  {
    synchronized (zzrN)
    {
      Boolean localBoolean = zzWh;
      return localBoolean;
    }
  }
  
  public void zzkP()
  {
    zzlC();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zztr.zzaZ);
    zza("onhide", localHashMap);
  }
  
  public void zzkQ()
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("app_muted", String.valueOf(zzv.zzcJ().zzcq()));
    localHashMap.put("app_volume", String.valueOf(zzv.zzcJ().zzco()));
    localHashMap.put("device_volume", String.valueOf(zzv.zzcJ().zzH(getContext())));
    zza("volume", localHashMap);
  }
  
  public Activity zzkR()
  {
    return zzYX.zzkR();
  }
  
  public Context zzkS()
  {
    return zzYX.zzkS();
  }
  
  public zze zzkT()
  {
    synchronized (zzrN)
    {
      zze localZze = zzZa;
      return localZze;
    }
  }
  
  public zze zzkU()
  {
    synchronized (zzrN)
    {
      zze localZze = zzZs;
      return localZze;
    }
  }
  
  public zzqq zzkV()
  {
    return zzYZ;
  }
  
  public boolean zzkW()
  {
    synchronized (zzrN)
    {
      boolean bool = zzZb;
      return bool;
    }
  }
  
  public zzav zzkX()
  {
    return zzGr;
  }
  
  public zzqa zzkY()
  {
    return zztr;
  }
  
  public boolean zzkZ()
  {
    synchronized (zzrN)
    {
      boolean bool = zzZd;
      return bool;
    }
  }
  
  public boolean zzlA()
  {
    if ((!zzkV().zzdz()) && (!zzkV().zzlo())) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = zzv.zzcJ().zza(zzwf);
    int k = zzeh.zzeO().zzb(localDisplayMetrics, widthPixels);
    int m = zzeh.zzeO().zzb(localDisplayMetrics, heightPixels);
    Object localObject = zzkR();
    int j;
    int i;
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      j = m;
      i = k;
      label87:
      if ((zzLQ == k) && (zzLR == m) && (zzLT == i) && (zzLU == j)) {
        break label234;
      }
      if ((zzLQ == k) && (zzLR == m)) {
        break label236;
      }
    }
    label234:
    label236:
    for (boolean bool = true;; bool = false)
    {
      zzLQ = k;
      zzLR = m;
      zzLT = i;
      zzLU = j;
      new zzko(this).zza(k, m, i, j, density, zzwf.getDefaultDisplay().getRotation());
      return bool;
      localObject = zzv.zzcJ().zzh((Activity)localObject);
      i = zzeh.zzeO().zzb(localDisplayMetrics, localObject[0]);
      j = zzeh.zzeO().zzb(localDisplayMetrics, localObject[1]);
      break label87;
      break;
    }
  }
  
  zzhx zzlE()
  {
    new zzhx()
    {
      public void zza(zzqp arg1, Map<String, String> paramAnonymousMap)
      {
        if (paramAnonymousMap != null)
        {
          ??? = (String)paramAnonymousMap.get("height");
          if (!TextUtils.isEmpty(???)) {
            try
            {
              int i = Integer.parseInt(???);
              synchronized (zzqt.zza(zzqt.this))
              {
                if (zzqt.zzb(zzqt.this) != i)
                {
                  zzqt.zza(zzqt.this, i);
                  requestLayout();
                }
                return;
              }
              return;
            }
            catch (Exception ???)
            {
              zzpe.zzc("Exception occurred while getting webview content height", ???);
            }
          }
        }
      }
    };
  }
  
  public void zzla()
  {
    synchronized (zzrN)
    {
      zzpe.v("Destroying WebView!");
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          zzqt.zzc(zzqt.this);
        }
      });
      return;
    }
  }
  
  public boolean zzlb()
  {
    synchronized (zzrN)
    {
      boolean bool = zzZg;
      return bool;
    }
  }
  
  public boolean zzlc()
  {
    synchronized (zzrN)
    {
      boolean bool = zzZh;
      return bool;
    }
  }
  
  public zzqo zzld()
  {
    return null;
  }
  
  public zzgd zzle()
  {
    return zzOo;
  }
  
  public zzge zzlf()
  {
    return zzZq;
  }
  
  public zzqu zzlg()
  {
    synchronized (zzrN)
    {
      zzqu localZzqu = zzZi;
      return localZzqu;
    }
  }
  
  public boolean zzlh()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzZm > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zzli()
  {
    zzvP.zzkE();
  }
  
  public void zzlj()
  {
    if (zzZp == null)
    {
      zzZp = zzgb.zzb(zzZq.zzfv());
      zzZq.zza("native:view_load", zzZp);
    }
  }
  
  public View.OnClickListener zzlk()
  {
    return (View.OnClickListener)zzZr.get();
  }
  
  public zzgs zzll()
  {
    synchronized (zzrN)
    {
      zzgs localZzgs = zzZl;
      return localZzgs;
    }
  }
  
  public void zzlm()
  {
    setBackgroundColor(0);
  }
  
  @zzmb
  public static class zza
    extends MutableContextWrapper
  {
    private Activity zzXO;
    private Context zzZv;
    private Context zzvZ;
    
    public zza(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Object getSystemService(String paramString)
    {
      return zzZv.getSystemService(paramString);
    }
    
    public void setBaseContext(Context paramContext)
    {
      zzvZ = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        zzXO = localActivity;
        zzZv = paramContext;
        super.setBaseContext(zzvZ);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (zzXO != null)
      {
        zzXO.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      zzvZ.startActivity(paramIntent);
    }
    
    public Activity zzkR()
    {
      return zzXO;
    }
    
    public Context zzkS()
    {
      return zzZv;
    }
  }
}
