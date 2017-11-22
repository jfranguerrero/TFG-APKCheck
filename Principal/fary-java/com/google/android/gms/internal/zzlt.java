package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzmb
public class zzlt
{
  private static final long zzPS = TimeUnit.SECONDS.toMillis(60L);
  private static boolean zzPT = false;
  private static zzja zzPU = null;
  private static final Object zztU = new Object();
  private final Context mContext;
  private final zzr zzGl;
  private final zzav zzGr;
  private zziy zzPV;
  private zzja.zze zzPW;
  private zzix zzPX;
  private boolean zzPY = false;
  private final zzov.zza zzPo;
  
  public zzlt(Context paramContext, zzov.zza paramZza, zzr paramZzr, zzav paramZzav)
  {
    mContext = paramContext;
    zzPo = paramZza;
    zzGl = paramZzr;
    zzGr = paramZzav;
    zzPY = ((Boolean)zzfx.zzDT.get()).booleanValue();
  }
  
  public static String zza(zzov.zza paramZza, String paramString)
  {
    if (zzVB.zzNb.indexOf("https") == 0) {}
    for (paramZza = "https:";; paramZza = "http:")
    {
      paramZza = String.valueOf(paramZza);
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break;
      }
      return paramZza.concat(paramString);
    }
    return new String(paramZza);
  }
  
  private void zziG()
  {
    synchronized (zztU)
    {
      if (!zzPT)
      {
        if (mContext.getApplicationContext() != null)
        {
          localContext = mContext.getApplicationContext();
          zzPU = new zzja(localContext, zzPo.zzSF.zzvf, zza(zzPo, (String)zzfx.zzDR.get()), new zzpn()new zzja.zzb
          {
            public void zza(zzix paramAnonymousZzix)
            {
              paramAnonymousZzix.zza(zzlt.zza(zzlt.this), zzlt.zza(zzlt.this), zzlt.zza(zzlt.this), zzlt.zza(zzlt.this), false, null, null, null, null);
            }
          }, new zzja.zzb());
          zzPT = true;
        }
      }
      else {
        return;
      }
      Context localContext = mContext;
    }
  }
  
  private void zziH()
  {
    zzPW = new zzja.zze(zziM().zzc(zzGr));
  }
  
  private void zziI()
  {
    zzPV = new zziy();
  }
  
  private void zziJ()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    zzPX = ((zzix)zziK().zza(mContext, zzPo.zzSF.zzvf, zza(zzPo, (String)zzfx.zzDR.get()), zzGr, zzGl.zzbz()).get(zzPS, TimeUnit.MILLISECONDS));
    zzPX.zza(zzGl, zzGl, zzGl, zzGl, false, null, null, null, null);
  }
  
  public void zza(final zza paramZza)
  {
    if (zzPY)
    {
      localObject = zziN();
      if (localObject == null)
      {
        zzpe.zzbe("SharedJavascriptEngine not initialized");
        return;
      }
      ((zzja.zze)localObject).zza(new zzqi.zzc()new zzqi.zza
      {
        public void zzb(zzjb paramAnonymousZzjb)
        {
          paramZza.zze(paramAnonymousZzjb);
        }
      }, new zzqi.zza()
      {
        public void run()
        {
          paramZza.zziO();
        }
      });
      return;
    }
    Object localObject = zziL();
    if (localObject == null)
    {
      zzpe.zzbe("JavascriptEngine not initialized");
      return;
    }
    paramZza.zze((zzjb)localObject);
  }
  
  public void zziE()
  {
    if (zzPY)
    {
      zziG();
      return;
    }
    zziI();
  }
  
  public void zziF()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    if (zzPY)
    {
      zziH();
      return;
    }
    zziJ();
  }
  
  protected zziy zziK()
  {
    return zzPV;
  }
  
  protected zzix zziL()
  {
    return zzPX;
  }
  
  protected zzja zziM()
  {
    return zzPU;
  }
  
  protected zzja.zze zziN()
  {
    return zzPW;
  }
  
  public static abstract class zza
  {
    public zza() {}
    
    public abstract void zze(zzjb paramZzjb);
    
    public void zziO() {}
  }
}
