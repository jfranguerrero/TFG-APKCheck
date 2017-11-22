package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzij
  extends zzpd
{
  final zzqp zzGt;
  final zzil zzHU;
  private final String zzHV;
  
  zzij(zzqp paramZzqp, zzil paramZzil, String paramString)
  {
    zzGt = paramZzqp;
    zzHU = paramZzil;
    zzHV = paramString;
    zzv.zzdg().zza(this);
  }
  
  public void onStop()
  {
    zzHU.abort();
  }
  
  public void zzcm()
  {
    try
    {
      zzHU.zzad(zzHV);
      return;
    }
    finally
    {
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          zzv.zzdg().zzb(zzij.this);
        }
      });
    }
  }
}
