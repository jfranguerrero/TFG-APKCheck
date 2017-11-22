package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzlk
  implements Runnable
{
  protected final zzqp zzGt;
  private final Handler zzPu;
  private final long zzPv;
  private long zzPw;
  private zzqq.zza zzPx;
  protected boolean zzPy;
  protected boolean zzPz;
  private final int zzrG;
  private final int zzrH;
  
  public zzlk(zzqq.zza paramZza, zzqp paramZzqp, int paramInt1, int paramInt2)
  {
    this(paramZza, paramZzqp, paramInt1, paramInt2, 200L, 50L);
  }
  
  public zzlk(zzqq.zza paramZza, zzqp paramZzqp, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    zzPv = paramLong1;
    zzPw = paramLong2;
    zzPu = new Handler(Looper.getMainLooper());
    zzGt = paramZzqp;
    zzPx = paramZza;
    zzPy = false;
    zzPz = false;
    zzrH = paramInt2;
    zzrG = paramInt1;
  }
  
  public void run()
  {
    if ((zzGt == null) || (zziz()))
    {
      zzPx.zza(zzGt, true);
      return;
    }
    new zza(zzGt.getWebView()).execute(new Void[0]);
  }
  
  public void zza(zzmk paramZzmk)
  {
    zza(paramZzmk, new zzra(this, zzGt, zzRR));
  }
  
  public void zza(zzmk paramZzmk, zzra paramZzra)
  {
    zzGt.setWebViewClient(paramZzra);
    zzqp localZzqp = zzGt;
    if (TextUtils.isEmpty(zzNb)) {}
    for (paramZzra = null;; paramZzra = zzv.zzcJ().zzaV(zzNb))
    {
      localZzqp.loadDataWithBaseURL(paramZzra, body, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public boolean zziA()
  {
    return zzPz;
  }
  
  public void zzix()
  {
    zzPu.postDelayed(this, zzPv);
  }
  
  public void zziy()
  {
    try
    {
      zzPy = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean zziz()
  {
    try
    {
      boolean bool = zzPy;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final class zza
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView zzPA;
    private Bitmap zzPB;
    
    public zza(WebView paramWebView)
    {
      zzPA = paramWebView;
    }
    
    protected void onPreExecute()
    {
      try
      {
        zzPB = Bitmap.createBitmap(zzlk.zza(zzlk.this), zzlk.zzb(zzlk.this), Bitmap.Config.ARGB_8888);
        zzPA.setVisibility(0);
        zzPA.measure(View.MeasureSpec.makeMeasureSpec(zzlk.zza(zzlk.this), 0), View.MeasureSpec.makeMeasureSpec(zzlk.zzb(zzlk.this), 0));
        zzPA.layout(0, 0, zzlk.zza(zzlk.this), zzlk.zzb(zzlk.this));
        Canvas localCanvas = new Canvas(zzPB);
        zzPA.draw(localCanvas);
        zzPA.invalidate();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    protected void zza(Boolean paramBoolean)
    {
      zzlk.zzc(zzlk.this);
      if ((paramBoolean.booleanValue()) || (zziz()) || (zzlk.zzd(zzlk.this) <= 0L))
      {
        zzPz = paramBoolean.booleanValue();
        zzlk.zze(zzlk.this).zza(zzGt, true);
      }
      while (zzlk.zzd(zzlk.this) <= 0L) {
        return;
      }
      if (zzpe.zzai(2)) {
        zzpe.zzbc("Ad not detected, scheduling another run.");
      }
      zzlk.zzg(zzlk.this).postDelayed(zzlk.this, zzlk.zzf(zzlk.this));
    }
    
    protected Boolean zzb(Void... paramVarArgs)
    {
      for (;;)
      {
        int i;
        int m;
        try
        {
          int n = zzPB.getWidth();
          int i1 = zzPB.getHeight();
          if ((n == 0) || (i1 == 0))
          {
            paramVarArgs = Boolean.valueOf(false);
            return paramVarArgs;
          }
          i = 0;
          j = 0;
          int k;
          if (i < n)
          {
            k = 0;
            if (k >= i1) {
              break label139;
            }
            m = j;
            if (zzPB.getPixel(i, k) != 0) {
              m = j + 1;
            }
          }
          else
          {
            if (j / (n * i1 / 100.0D) > 0.1D)
            {
              bool = true;
              paramVarArgs = Boolean.valueOf(bool);
              continue;
            }
            boolean bool = false;
            continue;
          }
          k += 10;
        }
        finally {}
        int j = m;
        continue;
        label139:
        i += 10;
      }
    }
  }
}
