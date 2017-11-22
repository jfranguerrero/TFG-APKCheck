package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzd;
import java.util.concurrent.Future;

@zzmb
public class zziy
{
  public zziy() {}
  
  private zzix zza(Context paramContext, zzqa paramZzqa, final zza<zzix> paramZza, zzav paramZzav, zzd paramZzd)
  {
    paramContext = new zziz(paramContext, paramZzqa, paramZzav, paramZzd);
    zzIW = paramContext;
    paramContext.zza(new zzix.zza()
    {
      public void zzgu()
      {
        paramZza.zzh((zzix)paramZzazzIW);
      }
    });
    return paramContext;
  }
  
  public Future<zzix> zza(final Context paramContext, final zzqa paramZzqa, final String paramString, final zzav paramZzav, final zzd paramZzd)
  {
    final zza localZza = new zza(null);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        zziy.zza(zziy.this, paramContext, paramZzqa, localZza, paramZzav, paramZzd).zzam(paramString);
      }
    });
    return localZza;
  }
  
  private static class zza<JavascriptEngine>
    extends zzqc<JavascriptEngine>
  {
    JavascriptEngine zzIW;
    
    private zza() {}
  }
}
