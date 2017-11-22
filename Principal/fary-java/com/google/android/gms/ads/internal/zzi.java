package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzaq;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzmb
class zzi
  implements zzaq, Runnable
{
  private zzw zzsw;
  private final List<Object[]> zztf = new Vector();
  private final AtomicReference<zzaq> zztg = new AtomicReference();
  CountDownLatch zzth = new CountDownLatch(1);
  
  public zzi(zzw paramZzw)
  {
    zzsw = paramZzw;
    if (zzeh.zzeO().zzkJ())
    {
      zzph.zza(this);
      return;
    }
    run();
  }
  
  private void zzcf()
  {
    if (zztf.isEmpty()) {
      return;
    }
    Iterator localIterator = zztf.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject.length == 1) {
        ((zzaq)zztg.get()).zza((MotionEvent)arrayOfObject[0]);
      } else if (arrayOfObject.length == 3) {
        ((zzaq)zztg.get()).zza(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
      }
    }
    zztf.clear();
  }
  
  private Context zzg(Context paramContext)
  {
    if (!((Boolean)zzfx.zzBd.get()).booleanValue()) {}
    Context localContext;
    do
    {
      return paramContext;
      localContext = paramContext.getApplicationContext();
    } while (localContext == null);
    return localContext;
  }
  
  public void run()
  {
    label94:
    for (;;)
    {
      try
      {
        if (((Boolean)zzfx.zzBz.get()).booleanValue()) {
          if (zzsw.zzvf.zzYd)
          {
            break label94;
            zza(zzd(zzsw.zzvf.zzaZ, zzg(zzsw.zzqr), bool));
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally
      {
        zzth.countDown();
        zzsw = null;
      }
    }
  }
  
  public String zza(Context paramContext, String paramString, View paramView)
  {
    if (zzce())
    {
      zzaq localZzaq = (zzaq)zztg.get();
      if (localZzaq != null)
      {
        zzcf();
        return localZzaq.zza(zzg(paramContext), paramString, paramView);
      }
    }
    return "";
  }
  
  public String zza(Context paramContext, byte[] paramArrayOfByte)
  {
    if (zzce())
    {
      paramArrayOfByte = (zzaq)zztg.get();
      if (paramArrayOfByte != null)
      {
        zzcf();
        return paramArrayOfByte.zzb(zzg(paramContext));
      }
    }
    return "";
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    zzaq localZzaq = (zzaq)zztg.get();
    if (localZzaq != null)
    {
      zzcf();
      localZzaq.zza(paramInt1, paramInt2, paramInt3);
      return;
    }
    zztf.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    zzaq localZzaq = (zzaq)zztg.get();
    if (localZzaq != null)
    {
      zzcf();
      localZzaq.zza(paramMotionEvent);
      return;
    }
    zztf.add(new Object[] { paramMotionEvent });
  }
  
  protected void zza(zzaq paramZzaq)
  {
    zztg.set(paramZzaq);
  }
  
  public String zzb(Context paramContext)
  {
    return zza(paramContext, null);
  }
  
  protected boolean zzce()
  {
    try
    {
      zzth.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzpe.zzc("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }
  
  protected zzaq zzd(String paramString, Context paramContext, boolean paramBoolean)
  {
    return zzau.zza(paramString, paramContext, paramBoolean);
  }
}
