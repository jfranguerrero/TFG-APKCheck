package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzf;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzabq
{
  public static final Status zzaBV = new Status(8, "The connection to Google Play services was lost");
  private static final zzzx<?>[] zzaBW = new zzzx[0];
  private final Map<Api.zzc<?>, Api.zze> zzaAr;
  final Set<zzzx<?>> zzaBX = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zzb zzaBY = new zzb()
  {
    public void zzc(zzzx<?> paramAnonymousZzzx)
    {
      zzaBX.remove(paramAnonymousZzzx);
      if (paramAnonymousZzzx.zzuR() != null) {
        zzabq.zza(zzabq.this);
      }
    }
  };
  
  public zzabq(Map<Api.zzc<?>, Api.zze> paramMap)
  {
    zzaAr = paramMap;
  }
  
  private static void zza(zzzx<?> paramZzzx, zzf paramZzf, IBinder paramIBinder)
  {
    if (paramZzzx.isReady())
    {
      paramZzzx.zza(new zza(paramZzzx, paramZzf, paramIBinder, null));
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()))
    {
      zza localZza = new zza(paramZzzx, paramZzf, paramIBinder, null);
      paramZzzx.zza(localZza);
      try
      {
        paramIBinder.linkToDeath(localZza, 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        paramZzzx.cancel();
        paramZzf.remove(paramZzzx.zzuR().intValue());
        return;
      }
    }
    paramZzzx.zza(null);
    paramZzzx.cancel();
    paramZzf.remove(paramZzzx.zzuR().intValue());
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(zzaBX.size());
  }
  
  public void release()
  {
    zzzx[] arrayOfZzzx = (zzzx[])zzaBX.toArray(zzaBW);
    int j = arrayOfZzzx.length;
    int i = 0;
    if (i < j)
    {
      zzzx localZzzx = arrayOfZzzx[i];
      localZzzx.zza(null);
      if (localZzzx.zzuR() == null) {
        if (localZzzx.zzvc()) {
          zzaBX.remove(localZzzx);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localZzzx.zzve();
        zza(localZzzx, null, ((Api.zze)zzaAr.get(((zzzv.zza)localZzzx).zzuH())).zzuJ());
        zzaBX.remove(localZzzx);
      }
    }
  }
  
  void zzb(zzzx<? extends Result> paramZzzx)
  {
    zzaBX.add(paramZzzx);
    paramZzzx.zza(zzaBY);
  }
  
  public void zzww()
  {
    zzzx[] arrayOfZzzx = (zzzx[])zzaBX.toArray(zzaBW);
    int j = arrayOfZzzx.length;
    int i = 0;
    while (i < j)
    {
      arrayOfZzzx[i].zzB(zzaBV);
      i += 1;
    }
  }
  
  private static class zza
    implements IBinder.DeathRecipient, zzabq.zzb
  {
    private final WeakReference<zzzx<?>> zzaCa;
    private final WeakReference<zzf> zzaCb;
    private final WeakReference<IBinder> zzaCc;
    
    private zza(zzzx<?> paramZzzx, zzf paramZzf, IBinder paramIBinder)
    {
      zzaCb = new WeakReference(paramZzf);
      zzaCa = new WeakReference(paramZzzx);
      zzaCc = new WeakReference(paramIBinder);
    }
    
    private void zzwx()
    {
      Object localObject = (zzzx)zzaCa.get();
      zzf localZzf = (zzf)zzaCb.get();
      if ((localZzf != null) && (localObject != null)) {
        localZzf.remove(((zzzx)localObject).zzuR().intValue());
      }
      localObject = (IBinder)zzaCc.get();
      if (localObject != null) {
        ((IBinder)localObject).unlinkToDeath(this, 0);
      }
    }
    
    public void binderDied()
    {
      zzwx();
    }
    
    public void zzc(zzzx<?> paramZzzx)
    {
      zzwx();
    }
  }
  
  static abstract interface zzb
  {
    public abstract void zzc(zzzx<?> paramZzzx);
  }
}
