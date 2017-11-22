package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzep.zza;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzmb
public class zzu
  extends zzep.zza
{
  private final Context mContext;
  @Nullable
  private zzel zzti;
  private final zzqa zztr;
  private final zzec zzum;
  private final Future<zzch> zzun;
  private final zzb zzuo;
  @Nullable
  private WebView zzup;
  @Nullable
  private zzch zzuq;
  private AsyncTask<Void, Void, String> zzur;
  
  public zzu(Context paramContext, zzec paramZzec, String paramString, zzqa paramZzqa)
  {
    mContext = paramContext;
    zztr = paramZzqa;
    zzum = paramZzec;
    zzup = new WebView(mContext);
    zzun = zzcz();
    zzuo = new zzb(paramString);
    zzcw();
  }
  
  private String zzB(String paramString)
  {
    if (zzuq == null) {
      return paramString;
    }
    paramString = Uri.parse(paramString);
    try
    {
      Uri localUri = zzuq.zzd(paramString, mContext);
      paramString = localUri;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpe.zzc("Unable to process ad data", localRemoteException);
      }
    }
    catch (zzci localZzci)
    {
      for (;;)
      {
        zzpe.zzc("Unable to parse ad click url", localZzci);
      }
    }
    return paramString.toString();
  }
  
  private void zzC(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    mContext.startActivity(localIntent);
  }
  
  private void zzcw()
  {
    zzj(0);
    zzup.setVerticalScrollBarEnabled(false);
    zzup.getSettings().setJavaScriptEnabled(true);
    zzup.setWebViewClient(new WebViewClient()
    {
      public void onReceivedError(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        if (zzu.zza(zzu.this) != null) {}
        try
        {
          zzu.zza(zzu.this).onAdFailedToLoad(0);
          return;
        }
        catch (RemoteException paramAnonymousWebView)
        {
          zzpe.zzc("Could not call AdListener.onAdFailedToLoad().", paramAnonymousWebView);
        }
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith(zzcy())) {
          return false;
        }
        if (paramAnonymousString.startsWith((String)zzfx.zzEu.get()))
        {
          if (zzu.zza(zzu.this) != null) {}
          try
          {
            zzu.zza(zzu.this).onAdFailedToLoad(3);
            zzj(0);
            return true;
          }
          catch (RemoteException paramAnonymousWebView)
          {
            for (;;)
            {
              zzpe.zzc("Could not call AdListener.onAdFailedToLoad().", paramAnonymousWebView);
            }
          }
        }
        if (paramAnonymousString.startsWith((String)zzfx.zzEv.get()))
        {
          if (zzu.zza(zzu.this) != null) {}
          try
          {
            zzu.zza(zzu.this).onAdFailedToLoad(0);
            zzj(0);
            return true;
          }
          catch (RemoteException paramAnonymousWebView)
          {
            for (;;)
            {
              zzpe.zzc("Could not call AdListener.onAdFailedToLoad().", paramAnonymousWebView);
            }
          }
        }
        if (paramAnonymousString.startsWith((String)zzfx.zzEw.get()))
        {
          if (zzu.zza(zzu.this) != null) {}
          try
          {
            zzu.zza(zzu.this).onAdLoaded();
            int i = zzA(paramAnonymousString);
            zzj(i);
            return true;
          }
          catch (RemoteException paramAnonymousWebView)
          {
            for (;;)
            {
              zzpe.zzc("Could not call AdListener.onAdLoaded().", paramAnonymousWebView);
            }
          }
        }
        if (paramAnonymousString.startsWith("gmsg://")) {
          return true;
        }
        if (zzu.zza(zzu.this) != null) {}
        try
        {
          zzu.zza(zzu.this).onAdLeftApplication();
          paramAnonymousWebView = zzu.zza(zzu.this, paramAnonymousString);
          zzu.zzb(zzu.this, paramAnonymousWebView);
          return true;
        }
        catch (RemoteException paramAnonymousWebView)
        {
          for (;;)
          {
            zzpe.zzc("Could not call AdListener.onAdLeftApplication().", paramAnonymousWebView);
          }
        }
      }
    });
    zzup.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (zzu.zzb(zzu.this) != null) {}
        try
        {
          zzu.zzb(zzu.this).zza(paramAnonymousMotionEvent);
          return false;
        }
        catch (RemoteException paramAnonymousView)
        {
          for (;;)
          {
            zzpe.zzc("Unable to process ad data", paramAnonymousView);
          }
        }
      }
    });
  }
  
  private Future<zzch> zzcz()
  {
    zzph.zza(new Callable()
    {
      public zzch zzcA()
        throws Exception
      {
        return new zzch(zzczzaZ, zzu.zzd(zzu.this), false);
      }
    });
  }
  
  public void destroy()
    throws RemoteException
  {
    zzac.zzdn("destroy must be called on the main UI thread.");
    zzur.cancel(true);
    zzun.cancel(true);
    zzup.destroy();
    zzup = null;
  }
  
  @Nullable
  public String getMediationAdapterClassName()
    throws RemoteException
  {
    return null;
  }
  
  public boolean isLoading()
    throws RemoteException
  {
    return false;
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return false;
  }
  
  public void pause()
    throws RemoteException
  {
    zzac.zzdn("pause must be called on the main UI thread.");
  }
  
  public void resume()
    throws RemoteException
  {
    zzac.zzdn("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {}
  
  public void setUserId(String paramString)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void stopLoading()
    throws RemoteException
  {}
  
  int zzA(String paramString)
  {
    paramString = Uri.parse(paramString).getQueryParameter("height");
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = zzeh.zzeO().zzb(mContext, Integer.parseInt(paramString));
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public void zza(zzec paramZzec)
    throws RemoteException
  {
    throw new IllegalStateException("AdSize must be set before initialization");
  }
  
  public void zza(zzek paramZzek)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzel paramZzel)
    throws RemoteException
  {
    zzti = paramZzel;
  }
  
  public void zza(zzer paramZzer)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzet paramZzet)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzfn paramZzfn)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzgj paramZzgj)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzkz paramZzkz)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zzld paramZzld, String paramString)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public void zza(zznt paramZznt)
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  public boolean zzb(zzdy paramZzdy)
    throws RemoteException
  {
    zzac.zzb(zzup, "This Search Ad has already been torn down");
    zzuo.zzi(paramZzdy);
    zzur = new zza(null).execute(new Void[0]);
    return true;
  }
  
  public zzd zzbC()
    throws RemoteException
  {
    zzac.zzdn("getAdFrame must be called on the main UI thread.");
    return zze.zzA(zzup);
  }
  
  public zzec zzbD()
    throws RemoteException
  {
    return zzum;
  }
  
  public void zzbF()
    throws RemoteException
  {
    throw new IllegalStateException("Unused method");
  }
  
  @Nullable
  public zzew zzbG()
  {
    return null;
  }
  
  String zzcx()
  {
    Object localObject1 = new Uri.Builder();
    ((Uri.Builder)localObject1).scheme("https://").appendEncodedPath((String)zzfx.zzEx.get());
    ((Uri.Builder)localObject1).appendQueryParameter("query", zzuo.getQuery());
    ((Uri.Builder)localObject1).appendQueryParameter("pubId", zzuo.zzcC());
    Object localObject3 = zzuo.zzcD();
    Iterator localIterator = ((Map)localObject3).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Uri.Builder)localObject1).appendQueryParameter(str, (String)((Map)localObject3).get(str));
    }
    localObject3 = ((Uri.Builder)localObject1).build();
    if (zzuq != null) {}
    try
    {
      localObject1 = zzuq.zzc((Uri)localObject3, mContext);
      localObject3 = String.valueOf(zzcy());
      localObject1 = String.valueOf(((Uri)localObject1).getEncodedQuery());
      return String.valueOf(localObject3).length() + 1 + String.valueOf(localObject1).length() + (String)localObject3 + "#" + (String)localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpe.zzc("Unable to process ad data", localRemoteException);
        Object localObject2 = localObject3;
      }
    }
    catch (zzci localZzci)
    {
      for (;;) {}
    }
  }
  
  String zzcy()
  {
    String str1 = zzuo.zzcB();
    if (TextUtils.isEmpty(str1)) {
      str1 = "www.google.com";
    }
    for (;;)
    {
      String str2 = String.valueOf("https://");
      String str3 = (String)zzfx.zzEx.get();
      return String.valueOf(str2).length() + 0 + String.valueOf(str1).length() + String.valueOf(str3).length() + str2 + str1 + str3;
    }
  }
  
  void zzj(int paramInt)
  {
    if (zzup == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, paramInt);
    zzup.setLayoutParams(localLayoutParams);
  }
  
  private class zza
    extends AsyncTask<Void, Void, String>
  {
    private zza() {}
    
    protected void zzD(String paramString)
    {
      if ((zzu.zzf(zzu.this) != null) && (paramString != null)) {
        zzu.zzf(zzu.this).loadUrl(paramString);
      }
    }
    
    protected String zza(Void... paramVarArgs)
    {
      try
      {
        zzu.zza(zzu.this, (zzch)zzu.zze(zzu.this).get(((Long)zzfx.zzEz.get()).longValue(), TimeUnit.MILLISECONDS));
        return zzcx();
      }
      catch (InterruptedException paramVarArgs)
      {
        for (;;)
        {
          zzpe.zzc("Failed to load ad data", paramVarArgs);
        }
      }
      catch (TimeoutException paramVarArgs)
      {
        for (;;)
        {
          zzpe.zzbe("Timed out waiting for ad data");
        }
      }
      catch (ExecutionException paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
  
  private static class zzb
  {
    private final String zzut;
    private final Map<String, String> zzuu;
    private String zzuv;
    private String zzuw;
    
    public zzb(String paramString)
    {
      zzut = paramString;
      zzuu = new TreeMap();
    }
    
    public String getQuery()
    {
      return zzuv;
    }
    
    public String zzcB()
    {
      return zzuw;
    }
    
    public String zzcC()
    {
      return zzut;
    }
    
    public Map<String, String> zzcD()
    {
      return zzuu;
    }
    
    public void zzi(zzdy paramZzdy)
    {
      zzuv = zzyM.zzAD;
      if (zzyP != null) {}
      for (paramZzdy = zzyP.getBundle(AdMobAdapter.class.getName());; paramZzdy = null)
      {
        if (paramZzdy == null) {}
        for (;;)
        {
          return;
          String str1 = (String)zzfx.zzEy.get();
          Iterator localIterator = paramZzdy.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if (str1.equals(str2)) {
              zzuw = paramZzdy.getString(str2);
            } else if (str2.startsWith("csa_")) {
              zzuu.put(str2.substring("csa_".length()), paramZzdy.getString(str2));
            }
          }
        }
      }
    }
  }
}
