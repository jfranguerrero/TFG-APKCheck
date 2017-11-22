package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@zzmb
public class zzqq
  extends WebViewClient
{
  private static final String[] zzYA = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzYB = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  protected zzqp zzGt;
  private zzib zzHL;
  private com.google.android.gms.ads.internal.zze zzHN;
  private zzkj zzHO;
  private zzhz zzHQ;
  private zzht zzHc;
  private zzkp zzLz;
  private zza zzPx;
  private final HashMap<String, List<zzhx>> zzYC = new HashMap();
  private zzh zzYD;
  private zzb zzYE;
  private zzc zzYF;
  private boolean zzYG = false;
  private boolean zzYH;
  private ViewTreeObserver.OnGlobalLayoutListener zzYI;
  private ViewTreeObserver.OnScrollChangedListener zzYJ;
  private boolean zzYK;
  private zzq zzYL;
  private final zzkn zzYM;
  private zze zzYN;
  @Nullable
  protected zzop zzYO;
  private boolean zzYP;
  private boolean zzYQ;
  private boolean zzYR;
  private int zzYS;
  private final Object zzrN = new Object();
  private boolean zzvV;
  private zzdt zzyD;
  
  public zzqq(zzqp paramZzqp, boolean paramBoolean)
  {
    this(paramZzqp, paramBoolean, new zzkn(paramZzqp, paramZzqp.zzkS(), new zzfp(paramZzqp.getContext())), null);
  }
  
  zzqq(zzqp paramZzqp, boolean paramBoolean, zzkn paramZzkn, zzkj paramZzkj)
  {
    zzGt = paramZzqp;
    zzvV = paramBoolean;
    zzYM = paramZzkn;
    zzHO = paramZzkj;
  }
  
  private void zzb(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!((Boolean)zzfx.zzCS.get()).booleanValue()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("err", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("host", zzbh(paramString3));
    zzv.zzcJ().zza(paramContext, zzGt.zzkY().zzaZ, "gmob-apps", localBundle, true);
  }
  
  private String zzbh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    if (paramString.getHost() != null) {
      return paramString.getHost();
    }
    return "";
  }
  
  private static boolean zzi(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void zzlx()
  {
    if (zzYE != null)
    {
      zzYE.zzk(zzGt);
      zzYE = null;
    }
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "Loading resource: ".concat(paramWebView);; paramWebView = new String("Loading resource: "))
    {
      zzpe.v(paramWebView);
      paramWebView = Uri.parse(paramString);
      if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
        zzj(paramWebView);
      }
      return;
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (zzrN)
    {
      if (zzYP)
      {
        zzpe.v("Blank page loaded, 1...");
        zzGt.zzla();
        return;
      }
      zzYQ = true;
      zzlx();
      zzly();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 < zzYA.length)) {}
    for (String str = zzYA[(-paramInt - 1)];; str = String.valueOf(paramInt))
    {
      zzb(zzGt.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzYB.length)) {
        break label65;
      }
    }
    label65:
    for (String str = zzYB[i];; str = String.valueOf(i))
    {
      zzb(zzGt.getContext(), "ssl_err", str, zzv.zzcL().zza(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public final void reset()
  {
    if (zzYO != null) {
      zzYO = null;
    }
    synchronized (zzrN)
    {
      zzYC.clear();
      zzyD = null;
      zzYD = null;
      zzPx = null;
      zzYE = null;
      zzHc = null;
      zzYG = false;
      zzvV = false;
      zzYH = false;
      zzYK = false;
      zzHQ = null;
      zzYL = null;
      zzYF = null;
      if (zzHO != null)
      {
        zzHO.zzs(true);
        zzHO = null;
      }
      return;
    }
  }
  
  @TargetApi(11)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    try
    {
      paramWebView = zzdo.zzJ(paramString);
      if (paramWebView == null) {
        return null;
      }
      paramWebView = zzv.zzcO().zza(paramWebView);
      if ((paramWebView != null) && (paramWebView.zzer()))
      {
        paramWebView = new WebResourceResponse("", "", paramWebView.zzes());
        return paramWebView;
      }
    }
    catch (Throwable paramWebView) {}
    return null;
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = String.valueOf(paramString);
    if (((String)localObject).length() != 0)
    {
      localObject = "AdWebView shouldOverrideUrlLoading: ".concat((String)localObject);
      zzpe.v((String)localObject);
      localObject = Uri.parse(paramString);
      if ((!"gmsg".equalsIgnoreCase(((Uri)localObject).getScheme())) || (!"mobileads.google.com".equalsIgnoreCase(((Uri)localObject).getHost()))) {
        break label76;
      }
      zzj((Uri)localObject);
    }
    label76:
    label288:
    for (;;)
    {
      return true;
      localObject = new String("AdWebView shouldOverrideUrlLoading: ");
      break;
      if ((zzYG) && (paramWebView == zzGt.getWebView()) && (zzi((Uri)localObject)))
      {
        if ((zzyD != null) && (((Boolean)zzfx.zzCi.get()).booleanValue()))
        {
          zzyD.onAdClicked();
          zzyD = null;
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (zzGt.getWebView().willNotDraw()) {
        break label313;
      }
      try
      {
        zzav localZzav = zzGt.zzkX();
        paramWebView = (WebView)localObject;
        if (localZzav != null)
        {
          paramWebView = (WebView)localObject;
          if (localZzav.zzc((Uri)localObject)) {
            paramWebView = localZzav.zza((Uri)localObject, zzGt.getContext(), zzGt.getView());
          }
        }
      }
      catch (zzaw paramWebView)
      {
        paramWebView = String.valueOf(paramString);
        if (paramWebView.length() == 0) {
          break label288;
        }
        for (paramWebView = "Unable to append parameter to URL: ".concat(paramWebView);; paramWebView = new String("Unable to append parameter to URL: "))
        {
          zzpe.zzbe(paramWebView);
          paramWebView = (WebView)localObject;
          break;
        }
        zzHN.zzx(paramString);
      }
      if ((zzHN == null) || (zzHN.zzcb())) {
        zza(new zzc("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
      }
    }
    label313:
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "AdWebView unable to handle URL: ".concat(paramWebView);; paramWebView = new String("AdWebView unable to handle URL: "))
    {
      zzpe.zzbe(paramWebView);
      break;
    }
  }
  
  public void zzN(boolean paramBoolean)
  {
    zzYG = paramBoolean;
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    zzYM.zze(paramInt1, paramInt2);
    if (zzHO != null) {
      zzHO.zza(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void zza(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    synchronized (zzrN)
    {
      zzYH = true;
      zzGt.zzli();
      zzYI = paramOnGlobalLayoutListener;
      zzYJ = paramOnScrollChangedListener;
      return;
    }
  }
  
  public void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    boolean bool2 = false;
    if (zzHO != null) {}
    for (boolean bool1 = zzHO.zzgR();; bool1 = false)
    {
      zzf localZzf = zzv.zzcH();
      Context localContext = zzGt.getContext();
      if (!bool1) {
        bool2 = true;
      }
      localZzf.zza(localContext, paramAdOverlayInfoParcel, bool2);
      if ((zzYO != null) && (url == null) && (zzMW != null)) {
        paramAdOverlayInfoParcel = zzMW.url;
      }
      return;
    }
  }
  
  public final void zza(zzc paramZzc)
  {
    zzh localZzh = null;
    boolean bool = zzGt.zzkZ();
    zzdt localZzdt;
    if ((bool) && (!zzGt.zzbD().zzzl))
    {
      localZzdt = null;
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(paramZzc, localZzdt, localZzh, zzYL, zzGt.zzkY()));
      return;
      localZzdt = zzyD;
      break;
      label75:
      localZzh = zzYD;
    }
  }
  
  public void zza(zzdt paramZzdt, zzh paramZzh, zzht paramZzht, zzq paramZzq, boolean paramBoolean, zzhz paramZzhz, @Nullable zzib paramZzib, com.google.android.gms.ads.internal.zze paramZze, zzkp paramZzkp, @Nullable zzop paramZzop)
  {
    com.google.android.gms.ads.internal.zze localZze = paramZze;
    if (paramZze == null) {
      localZze = new com.google.android.gms.ads.internal.zze(zzGt.getContext());
    }
    zzHO = new zzkj(zzGt, paramZzkp);
    zzYO = paramZzop;
    zza("/appEvent", new zzhs(paramZzht));
    zza("/backButton", zzhw.zzHo);
    zza("/refresh", zzhw.zzHp);
    zza("/canOpenURLs", zzhw.zzHe);
    zza("/canOpenIntents", zzhw.zzHf);
    zza("/click", zzhw.zzHg);
    zza("/close", zzhw.zzHh);
    zza("/customClose", zzhw.zzHj);
    zza("/instrument", zzhw.zzHt);
    zza("/delayPageLoaded", zzhw.zzHv);
    zza("/delayPageClosed", zzhw.zzHw);
    zza("/getLocationInfo", zzhw.zzHx);
    zza("/httpTrack", zzhw.zzHk);
    zza("/log", zzhw.zzHl);
    zza("/mraid", new zzid(localZze, zzHO));
    zza("/mraidLoaded", zzYM);
    zza("/open", new zzie(paramZzhz, localZze, zzHO));
    zza("/precache", zzhw.zzHs);
    zza("/touch", zzhw.zzHn);
    zza("/video", zzhw.zzHq);
    zza("/videoMeta", zzhw.zzHr);
    zza("/appStreaming", zzhw.zzHi);
    if (paramZzib != null) {
      zza("/setInterstitialProperties", new zzia(paramZzib));
    }
    zzyD = paramZzdt;
    zzYD = paramZzh;
    zzHc = paramZzht;
    zzHQ = paramZzhz;
    zzYL = paramZzq;
    zzHN = localZze;
    zzLz = paramZzkp;
    zzHL = paramZzib;
    zzN(paramBoolean);
  }
  
  public void zza(zza paramZza)
  {
    zzPx = paramZza;
  }
  
  public void zza(zzb paramZzb)
  {
    zzYE = paramZzb;
  }
  
  public void zza(zzc paramZzc)
  {
    zzYF = paramZzc;
  }
  
  public void zza(zze paramZze)
  {
    zzYN = paramZze;
  }
  
  public void zza(String paramString, zzhx paramZzhx)
  {
    synchronized (zzrN)
    {
      List localList = (List)zzYC.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        zzYC.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramZzhx);
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt)
  {
    if ((zzGt.zzkZ()) && (!zzGt.zzbD().zzzl)) {}
    for (zzdt localZzdt = null;; localZzdt = zzyD)
    {
      zza(new AdOverlayInfoParcel(localZzdt, zzYD, zzYL, zzGt, paramBoolean, paramInt, zzGt.zzkY()));
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = zzGt.zzkZ();
    zzdt localZzdt;
    if ((bool) && (!zzGt.zzbD().zzzl))
    {
      localZzdt = null;
      if (!bool) {
        break label95;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(localZzdt, (zzh)localObject, zzHc, zzYL, zzGt, paramBoolean, paramInt, paramString, zzGt.zzkY(), zzHQ));
      return;
      localZzdt = zzyD;
      break;
      label95:
      localObject = new zzd(zzGt, zzYD);
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = zzGt.zzkZ();
    zzdt localZzdt;
    if ((bool) && (!zzGt.zzbD().zzzl))
    {
      localZzdt = null;
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = new zzd(zzGt, zzYD))
    {
      zza(new AdOverlayInfoParcel(localZzdt, (zzh)localObject, zzHc, zzYL, zzGt, paramBoolean, paramInt, paramString1, paramString2, zzGt.zzkY(), zzHQ));
      return;
      localZzdt = zzyD;
      break;
    }
  }
  
  public void zzb(String paramString, zzhx paramZzhx)
  {
    synchronized (zzrN)
    {
      paramString = (List)zzYC.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.remove(paramZzhx);
      return;
    }
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    if (zzHO != null) {
      zzHO.zzd(paramInt1, paramInt2);
    }
  }
  
  public boolean zzdz()
  {
    synchronized (zzrN)
    {
      boolean bool = zzvV;
      return bool;
    }
  }
  
  public final void zzhl()
  {
    synchronized (zzrN)
    {
      zzYG = false;
      zzvV = true;
      zzv.zzcJ().runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzGt.zzli();
          com.google.android.gms.ads.internal.overlay.zze localZze = zzGt.zzkT();
          if (localZze != null) {
            localZze.zzhl();
          }
          if (zzqq.zza(zzqq.this) != null)
          {
            zzqq.zza(zzqq.this).zzcd();
            zzqq.zza(zzqq.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzj(Uri paramUri)
  {
    String str1 = paramUri.getPath();
    List localList = (List)zzYC.get(str1);
    if (localList != null)
    {
      Map localMap = zzv.zzcJ().zzg(paramUri);
      if (zzpe.zzai(2))
      {
        paramUri = String.valueOf(str1);
        if (paramUri.length() != 0) {}
        for (paramUri = "Received GMSG: ".concat(paramUri);; paramUri = new String("Received GMSG: "))
        {
          zzpe.v(paramUri);
          paramUri = localMap.keySet().iterator();
          while (paramUri.hasNext())
          {
            str1 = (String)paramUri.next();
            String str2 = (String)localMap.get(str1);
            zzpe.v(String.valueOf(str1).length() + 4 + String.valueOf(str2).length() + "  " + str1 + ": " + str2);
          }
        }
      }
      paramUri = localList.iterator();
      while (paramUri.hasNext()) {
        ((zzhx)paramUri.next()).zza(zzGt, localMap);
      }
    }
    paramUri = String.valueOf(paramUri);
    zzpe.v(String.valueOf(paramUri).length() + 32 + "No GMSG handler found for GMSG: " + paramUri);
  }
  
  public com.google.android.gms.ads.internal.zze zzln()
  {
    return zzHN;
  }
  
  public boolean zzlo()
  {
    synchronized (zzrN)
    {
      boolean bool = zzYH;
      return bool;
    }
  }
  
  public ViewTreeObserver.OnGlobalLayoutListener zzlp()
  {
    synchronized (zzrN)
    {
      ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = zzYI;
      return localOnGlobalLayoutListener;
    }
  }
  
  public ViewTreeObserver.OnScrollChangedListener zzlq()
  {
    synchronized (zzrN)
    {
      ViewTreeObserver.OnScrollChangedListener localOnScrollChangedListener = zzYJ;
      return localOnScrollChangedListener;
    }
  }
  
  public boolean zzlr()
  {
    synchronized (zzrN)
    {
      boolean bool = zzYK;
      return bool;
    }
  }
  
  public void zzls()
  {
    synchronized (zzrN)
    {
      zzpe.v("Loading blank page in WebView, 2...");
      zzYP = true;
      zzGt.zzbf("about:blank");
      return;
    }
  }
  
  public void zzlt()
  {
    if (zzYO != null) {
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          if (zzYO != null)
          {
            Object localObject = zzYO;
            localObject = zzGt;
          }
        }
      });
    }
  }
  
  public void zzlu()
  {
    synchronized (zzrN)
    {
      zzYK = true;
      zzYS += 1;
      zzly();
      return;
    }
  }
  
  public void zzlv()
  {
    zzYS -= 1;
    zzly();
  }
  
  public void zzlw()
  {
    zzYR = true;
    zzly();
  }
  
  public final void zzly()
  {
    zza localZza;
    zzqp localZzqp;
    if ((zzPx != null) && (((zzYQ) && (zzYS <= 0)) || (zzYR)))
    {
      localZza = zzPx;
      localZzqp = zzGt;
      if (zzYR) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localZza.zza(localZzqp, bool);
      zzPx = null;
      zzGt.zzlj();
      return;
    }
  }
  
  public zze zzlz()
  {
    return zzYN;
  }
  
  public void zzo(zzqp paramZzqp)
  {
    zzGt = paramZzqp;
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzqp paramZzqp, boolean paramBoolean);
  }
  
  public static abstract interface zzb
  {
    public abstract void zzk(zzqp paramZzqp);
  }
  
  public static abstract interface zzc
  {
    public abstract void zzcd();
  }
  
  private static class zzd
    implements zzh
  {
    private zzh zzYD;
    private zzqp zzYU;
    
    public zzd(zzqp paramZzqp, zzh paramZzh)
    {
      zzYU = paramZzqp;
      zzYD = paramZzh;
    }
    
    public void onPause() {}
    
    public void onResume() {}
    
    public void zzbN()
    {
      zzYD.zzbN();
      zzYU.zzkP();
    }
    
    public void zzbO()
    {
      zzYD.zzbO();
      zzYU.zzhp();
    }
  }
  
  public static abstract interface zze
  {
    public abstract void zzcc();
  }
}
