package com.google.android.gms.internal;

import android.content.Context;

@zzmb
public class zzlo
  extends zzlj
  implements zzqq.zza
{
  zzlo(Context paramContext, zzov.zza paramZza, zzqp paramZzqp, zzln.zza paramZza1)
  {
    super(paramContext, paramZza, paramZzqp, paramZza1);
  }
  
  protected void zziB() {}
  
  protected void zziu()
  {
    if (zzPp.errorCode != -2) {
      return;
    }
    zzGt.zzkV().zza(this);
    zziB();
    zzpe.zzbc("Loading HTML in WebView.");
    zzGt.loadDataWithBaseURL(zzPp.zzNb, zzPp.body, "text/html", "UTF-8", null);
  }
}
