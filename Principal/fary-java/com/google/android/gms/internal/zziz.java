package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import org.json.JSONObject;

@zzmb
public class zziz
  implements zzix
{
  private final zzqp zzGt;
  
  public zziz(Context paramContext, zzqa paramZzqa, @Nullable zzav paramZzav, zzd paramZzd)
  {
    zzGt = zzv.zzcK().zza(paramContext, new zzec(), false, false, paramZzav, paramZzqa, null, null, paramZzd);
    zzGt.getWebView().setWillNotDraw(true);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    if (zzeh.zzeO().zzkJ())
    {
      paramRunnable.run();
      return;
    }
    zzpi.zzWR.post(paramRunnable);
  }
  
  public void destroy()
  {
    zzGt.destroy();
  }
  
  public void zza(zzdt paramZzdt, zzh paramZzh, zzht paramZzht, zzq paramZzq, boolean paramBoolean, zzhz paramZzhz, zzib paramZzib, zze paramZze, zzkp paramZzkp)
  {
    zzGt.zzkV().zza(paramZzdt, paramZzh, paramZzht, paramZzq, paramBoolean, paramZzhz, paramZzib, new zze(zzGt.getContext(), false), paramZzkp, null);
  }
  
  public void zza(final zzix.zza paramZza)
  {
    zzGt.zzkV().zza(new zzqq.zza()
    {
      public void zza(zzqp paramAnonymousZzqp, boolean paramAnonymousBoolean)
      {
        paramZza.zzgu();
      }
    });
  }
  
  public void zza(String paramString, zzhx paramZzhx)
  {
    zzGt.zzkV().zza(paramString, paramZzhx);
  }
  
  public void zza(final String paramString, final JSONObject paramJSONObject)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zziz.zza(zziz.this).zza(paramString, paramJSONObject);
      }
    });
  }
  
  public void zzal(String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zziz.zza(zziz.this).loadData(zzJb, "text/html", "UTF-8");
      }
    });
  }
  
  public void zzam(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zziz.zza(zziz.this).loadUrl(paramString);
      }
    });
  }
  
  public void zzan(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zziz.zza(zziz.this).loadData(paramString, "text/html", "UTF-8");
      }
    });
  }
  
  public void zzb(String paramString, zzhx paramZzhx)
  {
    zzGt.zzkV().zzb(paramString, paramZzhx);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzGt.zzb(paramString, paramJSONObject);
  }
  
  public zzjc zzgt()
  {
    return new zzjd(this);
  }
  
  public void zzi(final String paramString1, final String paramString2)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zziz.zza(zziz.this).zzi(paramString1, paramString2);
      }
    });
  }
}
