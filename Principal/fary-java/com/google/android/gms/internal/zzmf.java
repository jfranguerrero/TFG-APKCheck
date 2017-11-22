package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;

@zzmb
public abstract class zzmf
  implements zzme.zza, zzpk<Void>
{
  private final zzqi<zzmh> zzQV;
  private final zzme.zza zzQW;
  private final Object zzrN = new Object();
  
  public zzmf(zzqi<zzmh> paramZzqi, zzme.zza paramZza)
  {
    zzQV = paramZzqi;
    zzQW = paramZza;
  }
  
  public void cancel()
  {
    zziY();
  }
  
  boolean zza(zzmq paramZzmq, zzmh paramZzmh)
  {
    try
    {
      paramZzmq.zza(paramZzmh, new zzmj(this));
      return true;
    }
    catch (RemoteException paramZzmq)
    {
      zzpe.zzc("Could not fetch ad response from ad request service.", paramZzmq);
      zzv.zzcN().zza(paramZzmq, "AdRequestClientTask.getAdResponseFromService");
      zzQW.zzb(new zzmk(0));
      return false;
    }
    catch (NullPointerException paramZzmq)
    {
      for (;;)
      {
        zzpe.zzc("Could not fetch ad response from ad request service due to an Exception.", paramZzmq);
        zzv.zzcN().zza(paramZzmq, "AdRequestClientTask.getAdResponseFromService");
      }
    }
    catch (SecurityException paramZzmq)
    {
      for (;;)
      {
        zzpe.zzc("Could not fetch ad response from ad request service due to an Exception.", paramZzmq);
        zzv.zzcN().zza(paramZzmq, "AdRequestClientTask.getAdResponseFromService");
      }
    }
    catch (Throwable paramZzmq)
    {
      for (;;)
      {
        zzpe.zzc("Could not fetch ad response from ad request service due to an Exception.", paramZzmq);
        zzv.zzcN().zza(paramZzmq, "AdRequestClientTask.getAdResponseFromService");
      }
    }
  }
  
  public void zzb(zzmk paramZzmk)
  {
    synchronized (zzrN)
    {
      zzQW.zzb(paramZzmk);
      zziY();
      return;
    }
  }
  
  public abstract void zziY();
  
  public abstract zzmq zziZ();
  
  public Void zzit()
  {
    final zzmq localZzmq = zziZ();
    if (localZzmq == null)
    {
      zzQW.zzb(new zzmk(0));
      zziY();
      return null;
    }
    zzQV.zza(new zzqi.zzc()new zzqi.zza
    {
      public void zzc(zzmh paramAnonymousZzmh)
      {
        if (!zza(localZzmq, paramAnonymousZzmh)) {
          zziY();
        }
      }
    }, new zzqi.zza()
    {
      public void run()
      {
        zziY();
      }
    });
    return null;
  }
  
  @zzmb
  public static final class zza
    extends zzmf
  {
    private final Context mContext;
    
    public zza(Context paramContext, zzqi<zzmh> paramZzqi, zzme.zza paramZza)
    {
      super(paramZza);
      mContext = paramContext;
    }
    
    public void zziY() {}
    
    public zzmq zziZ()
    {
      zzfq localZzfq = new zzfq((String)zzfx.zzAR.get());
      return zzmz.zza(mContext, localZzfq, zzmy.zzjf());
    }
  }
  
  @zzmb
  public static class zzb
    extends zzmf
    implements zzf.zzb, zzf.zzc
  {
    private Context mContext;
    private zzqi<zzmh> zzQV;
    private final zzme.zza zzQW;
    protected zzmg zzQZ;
    private boolean zzRa;
    private final Object zzrN = new Object();
    private zzqa zztr;
    
    public zzb(Context paramContext, zzqa paramZzqa, zzqi<zzmh> paramZzqi, zzme.zza paramZza)
    {
      super(paramZza);
      mContext = paramContext;
      zztr = paramZzqa;
      zzQV = paramZzqi;
      zzQW = paramZza;
      if (((Boolean)zzfx.zzBE.get()).booleanValue()) {
        zzRa = true;
      }
      for (paramZzqa = zzv.zzcZ().zzkC();; paramZzqa = paramContext.getMainLooper())
      {
        zzQZ = new zzmg(paramContext, paramZzqa, this, this, zztr.zzYc);
        connect();
        return;
      }
    }
    
    protected void connect()
    {
      zzQZ.zzwT();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      zziw();
    }
    
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      zzpe.zzbc("Cannot connect to remote service, fallback to local instance.");
      zzja().zziw();
      paramConnectionResult = new Bundle();
      paramConnectionResult.putString("action", "gms_connection_failed_fallback_to_local");
      zzv.zzcJ().zzb(mContext, zztr.zzaZ, "gmob-apps", paramConnectionResult, true);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzpe.zzbc("Disconnected from remote ad request service.");
    }
    
    public void zziY()
    {
      synchronized (zzrN)
      {
        if ((zzQZ.isConnected()) || (zzQZ.isConnecting())) {
          zzQZ.disconnect();
        }
        Binder.flushPendingCommands();
        if (zzRa)
        {
          zzv.zzcZ().zzkD();
          zzRa = false;
        }
        return;
      }
    }
    
    /* Error */
    public zzmq zziZ()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	com/google/android/gms/internal/zzmf$zzb:zzrN	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 90	com/google/android/gms/internal/zzmf$zzb:zzQZ	Lcom/google/android/gms/internal/zzmg;
      //   11: invokevirtual 185	com/google/android/gms/internal/zzmg:zzjb	()Lcom/google/android/gms/internal/zzmq;
      //   14: astore_2
      //   15: aload_1
      //   16: monitorexit
      //   17: aload_2
      //   18: areturn
      //   19: aload_1
      //   20: monitorexit
      //   21: aconst_null
      //   22: areturn
      //   23: astore_2
      //   24: aload_1
      //   25: monitorexit
      //   26: aload_2
      //   27: athrow
      //   28: astore_2
      //   29: goto -10 -> 19
      //   32: astore_2
      //   33: goto -14 -> 19
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	zzb
      //   14	4	2	localZzmq	zzmq
      //   23	4	2	localObject2	Object
      //   28	1	2	localDeadObjectException	android.os.DeadObjectException
      //   32	1	2	localIllegalStateException	IllegalStateException
      // Exception table:
      //   from	to	target	type
      //   7	15	23	finally
      //   15	17	23	finally
      //   19	21	23	finally
      //   24	26	23	finally
      //   7	15	28	android/os/DeadObjectException
      //   7	15	32	java/lang/IllegalStateException
    }
    
    zzpk zzja()
    {
      return new zzmf.zza(mContext, zzQV, zzQW);
    }
  }
}
