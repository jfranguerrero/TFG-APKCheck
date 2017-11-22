package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzlv
{
  private final Context mContext;
  private final zzr zzGl;
  private final zzav zzGr;
  private final zzov.zza zzPo;
  private ViewTreeObserver.OnGlobalLayoutListener zzQA;
  private ViewTreeObserver.OnScrollChangedListener zzQB;
  private final Object zzrN = new Object();
  private final zzgf zzsr;
  private int zzvI = -1;
  private int zzvJ = -1;
  private zzpt zzvK;
  
  public zzlv(Context paramContext, zzav paramZzav, zzov.zza paramZza, zzgf paramZzgf, zzr paramZzr)
  {
    mContext = paramContext;
    zzGr = paramZzav;
    zzPo = paramZza;
    zzsr = paramZzgf;
    zzGl = paramZzr;
    zzvK = new zzpt(200L);
  }
  
  private ViewTreeObserver.OnGlobalLayoutListener zza(final WeakReference<zzqp> paramWeakReference)
  {
    if (zzQA == null) {
      zzQA = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          zzlv.zza(zzlv.this, paramWeakReference, false);
        }
      };
    }
    return zzQA;
  }
  
  private void zza(WeakReference<zzqp> paramWeakReference, boolean paramBoolean)
  {
    if (paramWeakReference == null) {}
    do
    {
      return;
      paramWeakReference = (zzqp)paramWeakReference.get();
    } while ((paramWeakReference == null) || (paramWeakReference.getView() == null) || ((paramBoolean) && (!zzvK.tryAcquire())));
    ??? = paramWeakReference.getView();
    int[] arrayOfInt = new int[2];
    ((View)???).getLocationOnScreen(arrayOfInt);
    int i = zzeh.zzeO().zzc(mContext, arrayOfInt[0]);
    int j = zzeh.zzeO().zzc(mContext, arrayOfInt[1]);
    for (;;)
    {
      synchronized (zzrN)
      {
        if ((zzvI != i) || (zzvJ != j))
        {
          zzvI = i;
          zzvJ = j;
          paramWeakReference = paramWeakReference.zzkV();
          i = zzvI;
          j = zzvJ;
          if (!paramBoolean)
          {
            paramBoolean = true;
            paramWeakReference.zza(i, j, paramBoolean);
          }
        }
        else
        {
          return;
        }
      }
      paramBoolean = false;
    }
  }
  
  private ViewTreeObserver.OnScrollChangedListener zzb(final WeakReference<zzqp> paramWeakReference)
  {
    if (zzQB == null) {
      zzQB = new ViewTreeObserver.OnScrollChangedListener()
      {
        public void onScrollChanged()
        {
          zzlv.zza(zzlv.this, paramWeakReference, true);
        }
      };
    }
    return zzQB;
  }
  
  private void zzj(zzqp paramZzqp)
  {
    paramZzqp = paramZzqp.zzkV();
    paramZzqp.zza("/video", zzhw.zzHq);
    paramZzqp.zza("/videoMeta", zzhw.zzHr);
    paramZzqp.zza("/precache", zzhw.zzHs);
    paramZzqp.zza("/delayPageLoaded", zzhw.zzHv);
    paramZzqp.zza("/instrument", zzhw.zzHt);
    paramZzqp.zza("/log", zzhw.zzHl);
    paramZzqp.zza("/videoClicked", zzhw.zzHm);
    paramZzqp.zza("/trackActiveViewUnit", new zzhx()
    {
      public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
      {
        zzlv.zza(zzlv.this).zzcr();
      }
    });
  }
  
  public zzqf<zzqp> zzf(final JSONObject paramJSONObject)
  {
    final zzqc localZzqc = new zzqc();
    zzv.zzcJ().runOnUiThread(new Runnable()
    {
      public void run()
      {
        try
        {
          final zzqp localZzqp = zziU();
          zzlv.zza(zzlv.this).zzc(localZzqp);
          WeakReference localWeakReference = new WeakReference(localZzqp);
          localZzqp.zzkV().zza(zzlv.zza(zzlv.this, localWeakReference), zzlv.zzb(zzlv.this, localWeakReference));
          zzlv.zza(zzlv.this, localZzqp);
          localZzqp.zzkV().zza(new zzqq.zzb()
          {
            public void zzk(zzqp paramAnonymous2Zzqp)
            {
              localZzqp.zza("google.afma.nativeAds.renderVideo", zzQC);
            }
          });
          localZzqp.zzkV().zza(new zzqq.zza()
          {
            public void zza(zzqp paramAnonymous2Zzqp, boolean paramAnonymous2Boolean)
            {
              zzlv.zza(zzlv.this).zzcu();
              zzQD.zzh(paramAnonymous2Zzqp);
            }
          });
          localZzqp.loadUrl(zzlt.zza(zzlv.zzb(zzlv.this), (String)zzfx.zzDS.get()));
          return;
        }
        catch (Exception localException)
        {
          zzpe.zzc("Exception occurred while getting video view", localException);
          localZzqc.zzh(null);
        }
      }
    });
    return localZzqc;
  }
  
  zzqp zziU()
  {
    return zzv.zzcK().zza(mContext, zzec.zzj(mContext), false, false, zzGr, zzPo.zzSF.zzvf, zzsr, null, zzGl.zzbz());
  }
}
