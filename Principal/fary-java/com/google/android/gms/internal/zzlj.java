package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.atomic.AtomicBoolean;

@zzmb
public abstract class zzlj
  implements zzpk<Void>, zzqq.zza
{
  protected final Context mContext;
  protected final zzqp zzGt;
  protected final zzln.zza zzPn;
  protected final zzov.zza zzPo;
  protected zzmk zzPp;
  private Runnable zzPq;
  protected final Object zzPr = new Object();
  private AtomicBoolean zzPs = new AtomicBoolean(true);
  
  protected zzlj(Context paramContext, zzov.zza paramZza, zzqp paramZzqp, zzln.zza paramZza1)
  {
    mContext = paramContext;
    zzPo = paramZza;
    zzPp = zzPo.zzVB;
    zzGt = paramZzqp;
    zzPn = paramZza1;
  }
  
  private zzov zzP(int paramInt)
  {
    zzmh localZzmh = zzPo.zzSF;
    return new zzov(zzRd, zzGt, zzPp.zzJY, paramInt, zzPp.zzJZ, zzPp.zzRM, zzPp.orientation, zzPp.zzKe, zzRg, zzPp.zzRK, null, null, null, null, null, zzPp.zzRL, zzPo.zzvj, zzPp.zzRJ, zzPo.zzVv, zzPp.zzRO, zzPp.zzRP, zzPo.zzVp, null, zzPp.zzRZ, zzPp.zzSa, zzPp.zzSb, zzPp.zzSc, zzPp.zzSd, null, zzPp.zzKb, zzPp.zzSg);
  }
  
  public void cancel()
  {
    if (!zzPs.getAndSet(false)) {
      return;
    }
    zzGt.stopLoading();
    zzv.zzcL().zzl(zzGt);
    zzO(-1);
    zzpi.zzWR.removeCallbacks(zzPq);
  }
  
  protected void zzO(int paramInt)
  {
    if (paramInt != -2) {
      zzPp = new zzmk(paramInt, zzPp.zzKe);
    }
    zzGt.zzkQ();
    zzPn.zzb(zzP(paramInt));
  }
  
  public void zza(zzqp paramZzqp, boolean paramBoolean)
  {
    int i = 0;
    zzpe.zzbc("WebView finished loading.");
    if (!zzPs.getAndSet(false)) {
      return;
    }
    if (paramBoolean) {
      i = zziv();
    }
    zzO(i);
    zzpi.zzWR.removeCallbacks(zzPq);
  }
  
  public final Void zzit()
  {
    zzac.zzdn("Webview render task needs to be called on UI thread.");
    zzPq = new Runnable()
    {
      public void run()
      {
        if (!zzlj.zza(zzlj.this).get()) {
          return;
        }
        zzpe.e("Timed out waiting for WebView to finish loading.");
        cancel();
      }
    };
    zzpi.zzWR.postDelayed(zzPq, ((Long)zzfx.zzDe.get()).longValue());
    zziu();
    return null;
  }
  
  protected abstract void zziu();
  
  protected int zziv()
  {
    return -2;
  }
}
