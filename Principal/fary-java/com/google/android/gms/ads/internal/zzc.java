package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmh;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import java.util.Map;

@zzmb
public abstract class zzc
  extends zzb
  implements zzh, zzkp
{
  public zzc(Context paramContext, zzec paramZzec, String paramString, zzjs paramZzjs, zzqa paramZzqa, zzd paramZzd)
  {
    super(paramContext, paramZzec, paramString, paramZzjs, paramZzqa, paramZzd);
  }
  
  protected zzqp zza(zzov.zza paramZza, @Nullable zze paramZze, @Nullable zzop paramZzop)
  {
    zzqp localZzqp1 = null;
    View localView = zzsw.zzvg.getNextView();
    if ((localView instanceof zzqp))
    {
      localZzqp1 = (zzqp)localView;
      if (!((Boolean)zzfx.zzCn.get()).booleanValue()) {
        break label223;
      }
      zzpe.zzbc("Reusing webview...");
      localZzqp1.zza(zzsw.zzqr, zzsw.zzvj, zzsr);
    }
    for (;;)
    {
      zzqp localZzqp2 = localZzqp1;
      if (localZzqp1 == null)
      {
        if (localView != null) {
          zzsw.zzvg.removeView(localView);
        }
        localZzqp1 = zzv.zzcK().zza(zzsw.zzqr, zzsw.zzvj, false, false, zzsw.zzve, zzsw.zzvf, zzsr, this, zzsz);
        localZzqp2 = localZzqp1;
        if (zzsw.zzvj.zzzm == null)
        {
          zzb(localZzqp1.getView());
          localZzqp2 = localZzqp1;
        }
      }
      localZzqp2.zzkV().zza(this, this, this, this, false, this, null, paramZze, this, paramZzop);
      zza(localZzqp2);
      localZzqp2.zzbg(zzSF.zzRr);
      return localZzqp2;
      label223:
      localZzqp1.destroy();
      localZzqp1 = null;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzbJ();
  }
  
  public void zza(zzgj paramZzgj)
  {
    zzac.zzdn("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    zzsw.zzvz = paramZzgj;
  }
  
  protected void zza(zzjb paramZzjb)
  {
    paramZzjb.zza("/trackActiveViewUnit", new zzhx()
    {
      public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
      {
        if (zzsw.zzvk != null)
        {
          zzsy.zza(zzsw.zzvj, zzsw.zzvk, paramAnonymousZzqp.getView(), paramAnonymousZzqp);
          return;
        }
        zzpe.zzbe("Request to enable ActiveView before adState is available.");
      }
    });
  }
  
  protected void zza(final zzov.zza paramZza, final zzgf paramZzgf)
  {
    if (errorCode != -2)
    {
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          zzb(new zzov(paramZza, null, null, null, null, null, null, null));
        }
      });
      return;
    }
    if (zzvj != null) {
      zzsw.zzvj = zzvj;
    }
    if ((zzVB.zzRK) && (!zzVB.zzzp))
    {
      zzsw.zzvF = 0;
      zzsw.zzvi = zzv.zzcI().zza(zzsw.zzqr, this, paramZza, zzsw.zzve, null, zzsD, this, paramZzgf);
      return;
    }
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        if ((paramZzazzVB.zzRT) && (zzsw.zzvz != null))
        {
          Object localObject = null;
          if (paramZzazzVB.zzNb != null) {
            localObject = zzv.zzcJ().zzaV(paramZzazzVB.zzNb);
          }
          localObject = new zzgg(zzc.this, (String)localObject, paramZzazzVB.body);
          zzsw.zzvF = 1;
          try
          {
            zzsu = false;
            zzsw.zzvz.zza((zzgi)localObject);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpe.zzc("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
            zzsu = true;
          }
        }
        final zze localZze = new zze(zzsw.zzqr, paramZza);
        zzqp localZzqp = zza(paramZza, localZze, zzsJ);
        localZzqp.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            localZze.recordClick();
            return false;
          }
        });
        localZzqp.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localZze.recordClick();
          }
        });
        zzsw.zzvF = 0;
        zzsw.zzvi = zzv.zzcI().zza(zzsw.zzqr, zzc.this, paramZza, zzsw.zzve, localZzqp, zzsD, zzc.this, paramZzgf);
      }
    });
  }
  
  protected boolean zza(@Nullable zzov paramZzov1, zzov paramZzov2)
  {
    if ((zzsw.zzdm()) && (zzsw.zzvg != null)) {
      zzsw.zzvg.zzds().zzaY(zzRP);
    }
    return super.zza(paramZzov1, paramZzov2);
  }
  
  public void zzbX()
  {
    onAdClicked();
  }
  
  public void zzbY()
  {
    recordImpression();
    zzbF();
  }
  
  public void zzbZ()
  {
    zzbH();
  }
  
  public void zzc(View paramView)
  {
    zzsw.zzvE = paramView;
    zzb(new zzov(zzsw.zzvl, null, null, null, null, null, null, null));
  }
}
