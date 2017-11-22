package com.google.android.gms.internal;

import android.os.Handler;

@zzmb
public class zzlp
  extends zzpd
{
  private final zzln.zza zzPn;
  private final zzov.zza zzPo;
  private final zzmk zzPp;
  
  public zzlp(zzov.zza paramZza, zzln.zza paramZza1)
  {
    zzPo = paramZza;
    zzPp = zzPo.zzVB;
    zzPn = paramZza1;
  }
  
  private zzov zzQ(int paramInt)
  {
    return new zzov(zzPo.zzSF.zzRd, null, null, paramInt, null, null, zzPp.orientation, zzPp.zzKe, zzPo.zzSF.zzRg, false, null, null, null, null, null, zzPp.zzRL, zzPo.zzvj, zzPp.zzRJ, zzPo.zzVv, zzPp.zzRO, zzPp.zzRP, zzPo.zzVp, null, null, null, null, zzPo.zzVB.zzSc, zzPo.zzVB.zzSd, null, null, null);
  }
  
  public void onStop() {}
  
  public void zzcm()
  {
    final zzov localZzov = zzQ(0);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        zzlp.zza(zzlp.this).zzb(localZzov);
      }
    });
  }
}
