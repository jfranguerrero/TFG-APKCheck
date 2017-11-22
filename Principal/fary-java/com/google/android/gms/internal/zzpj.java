package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzv;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@zzmb
@TargetApi(8)
public class zzpj
{
  private zzpj() {}
  
  public static zzpj zzah(int paramInt)
  {
    if (paramInt >= 21) {
      return new zzh();
    }
    if (paramInt >= 19) {
      return new zzg();
    }
    if (paramInt >= 18) {
      return new zze();
    }
    if (paramInt >= 17) {
      return new zzd();
    }
    if (paramInt >= 16) {
      return new zzf();
    }
    if (paramInt >= 14) {
      return new zzc();
    }
    if (paramInt >= 11) {
      return new zzb();
    }
    if (paramInt >= 9) {
      return new zza();
    }
    return new zzpj();
  }
  
  public String getDefaultUserAgent(Context paramContext)
  {
    return "";
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return (paramView.getWindowToken() != null) || (paramView.getWindowVisibility() != 8);
  }
  
  public CookieManager zzL(Context paramContext)
  {
    try
    {
      CookieSyncManager.createInstance(paramContext);
      paramContext = CookieManager.getInstance();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      zzpe.zzb("Failed to obtain CookieManager.", paramContext);
      zzv.zzcN().zza(paramContext, "ApiLevelUtil.getCookieManager");
    }
    return null;
  }
  
  public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }
  
  public String zza(SslError paramSslError)
  {
    return "";
  }
  
  public void zza(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public boolean zza(DownloadManager.Request paramRequest)
  {
    return false;
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    return false;
  }
  
  public boolean zza(Window paramWindow)
  {
    return false;
  }
  
  public zzqq zzb(zzqp paramZzqp, boolean paramBoolean)
  {
    return new zzqq(paramZzqp, paramBoolean);
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      zza(paramActivity.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
    }
  }
  
  public Set<String> zzh(Uri paramUri)
  {
    if (paramUri.isOpaque()) {
      return Collections.emptySet();
    }
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int j = 0;
    int i;
    do
    {
      int k = paramUri.indexOf('&', j);
      i = k;
      if (k == -1) {
        i = paramUri.length();
      }
      int m = paramUri.indexOf('=', j);
      if (m <= i)
      {
        k = m;
        if (m != -1) {}
      }
      else
      {
        k = i;
      }
      localLinkedHashSet.add(Uri.decode(paramUri.substring(j, k)));
      i += 1;
      j = i;
    } while (i < paramUri.length());
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public int zzkp()
  {
    return 0;
  }
  
  public int zzkq()
  {
    return 1;
  }
  
  public int zzkr()
  {
    return 5;
  }
  
  public ViewGroup.LayoutParams zzks()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  public boolean zzl(zzqp paramZzqp)
  {
    if (paramZzqp == null) {
      return false;
    }
    paramZzqp.onPause();
    return true;
  }
  
  public boolean zzm(zzqp paramZzqp)
  {
    if (paramZzqp == null) {
      return false;
    }
    paramZzqp.onResume();
    return true;
  }
  
  public WebChromeClient zzn(zzqp paramZzqp)
  {
    return null;
  }
  
  public boolean zzt(View paramView)
  {
    return false;
  }
  
  public boolean zzu(View paramView)
  {
    return false;
  }
  
  @TargetApi(9)
  public static class zza
    extends zzpj
  {
    public zza()
    {
      super();
    }
    
    public boolean zza(DownloadManager.Request paramRequest)
    {
      paramRequest.setShowRunningNotification(true);
      return true;
    }
    
    public int zzkp()
    {
      return 6;
    }
    
    public int zzkq()
    {
      return 7;
    }
  }
  
  @TargetApi(11)
  public static class zzb
    extends zzpj.zza
  {
    public zzb() {}
    
    public boolean zza(DownloadManager.Request paramRequest)
    {
      paramRequest.allowScanningByMediaScanner();
      paramRequest.setNotificationVisibility(1);
      return true;
    }
    
    public boolean zza(final Context paramContext, final WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      ((Boolean)zzpv.zzb(new Callable()
      {
        public Boolean zzkt()
        {
          if (paramContext.getCacheDir() != null)
          {
            paramWebSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
            paramWebSettings.setAppCacheMaxSize(0L);
            paramWebSettings.setAppCacheEnabled(true);
          }
          paramWebSettings.setDatabasePath(paramContext.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
          paramWebSettings.setDatabaseEnabled(true);
          paramWebSettings.setDomStorageEnabled(true);
          paramWebSettings.setDisplayZoomControls(false);
          paramWebSettings.setBuiltInZoomControls(true);
          paramWebSettings.setSupportZoom(true);
          paramWebSettings.setAllowContentAccess(false);
          return Boolean.valueOf(true);
        }
      })).booleanValue();
    }
    
    public boolean zza(Window paramWindow)
    {
      paramWindow.setFlags(16777216, 16777216);
      return true;
    }
    
    public zzqq zzb(zzqp paramZzqp, boolean paramBoolean)
    {
      return new zzqx(paramZzqp, paramBoolean);
    }
    
    public Set<String> zzh(Uri paramUri)
    {
      return paramUri.getQueryParameterNames();
    }
    
    public WebChromeClient zzn(zzqp paramZzqp)
    {
      return new zzqw(paramZzqp);
    }
    
    public boolean zzt(View paramView)
    {
      paramView.setLayerType(0, null);
      return true;
    }
    
    public boolean zzu(View paramView)
    {
      paramView.setLayerType(1, null);
      return true;
    }
  }
  
  @TargetApi(14)
  public static class zzc
    extends zzpj.zzb
  {
    public zzc() {}
    
    public String zza(SslError paramSslError)
    {
      return paramSslError.getUrl();
    }
    
    public WebChromeClient zzn(zzqp paramZzqp)
    {
      return new zzqy(paramZzqp);
    }
  }
  
  @TargetApi(17)
  public static class zzd
    extends zzpj.zzf
  {
    public zzd() {}
    
    public String getDefaultUserAgent(Context paramContext)
    {
      return WebSettings.getDefaultUserAgent(paramContext);
    }
    
    public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
    {
      if ((!paramBoolean) || (paramFloat <= 0.0F) || (paramFloat > 25.0F)) {
        return new BitmapDrawable(paramContext.getResources(), paramBitmap);
      }
      try
      {
        Object localObject3 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
        Object localObject1 = Bitmap.createBitmap((Bitmap)localObject3);
        Object localObject2 = RenderScript.create(paramContext);
        ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
        localObject3 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject3);
        localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
        localScriptIntrinsicBlur.setRadius(paramFloat);
        localScriptIntrinsicBlur.setInput((Allocation)localObject3);
        localScriptIntrinsicBlur.forEach((Allocation)localObject2);
        ((Allocation)localObject2).copyTo((Bitmap)localObject1);
        localObject1 = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject1);
        return localObject1;
      }
      catch (RuntimeException localRuntimeException) {}
      return new BitmapDrawable(paramContext.getResources(), paramBitmap);
    }
    
    public boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
      return true;
    }
  }
  
  @TargetApi(18)
  public static class zze
    extends zzpj.zzd
  {
    public zze() {}
    
    public boolean isAttachedToWindow(View paramView)
    {
      return (super.isAttachedToWindow(paramView)) || (paramView.getWindowId() != null);
    }
    
    public int zzkr()
    {
      return 14;
    }
  }
  
  @TargetApi(16)
  public static class zzf
    extends zzpj.zzc
  {
    public zzf() {}
    
    public void zza(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
    
    public boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setAllowFileAccessFromFileURLs(false);
      paramWebSettings.setAllowUniversalAccessFromFileURLs(false);
      return true;
    }
    
    public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramActivity = paramActivity.getWindow();
      if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
        zza(paramActivity.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
      }
    }
  }
  
  @TargetApi(19)
  public static class zzg
    extends zzpj.zze
  {
    public zzg() {}
    
    public boolean isAttachedToWindow(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public ViewGroup.LayoutParams zzks()
    {
      return new ViewGroup.LayoutParams(-1, -1);
    }
  }
  
  @TargetApi(21)
  public static class zzh
    extends zzpj.zzg
  {
    public zzh() {}
    
    public CookieManager zzL(Context paramContext)
    {
      return CookieManager.getInstance();
    }
    
    public zzqq zzb(zzqp paramZzqp, boolean paramBoolean)
    {
      return new zzrb(paramZzqp, paramBoolean);
    }
  }
}
