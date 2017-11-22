package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;

@zzmb
public class zzdk
{
  @Nullable
  private Context mContext;
  private final Object zzrN = new Object();
  private final Runnable zzys = new Runnable()
  {
    public void run()
    {
      zzdk.zza(zzdk.this);
    }
  };
  @Nullable
  private zzdn zzyt;
  @Nullable
  private zzdr zzyu;
  
  public zzdk() {}
  
  private void connect()
  {
    synchronized (zzrN)
    {
      if ((mContext == null) || (zzyt != null)) {
        return;
      }
      zzyt = zza(new zzf.zzb()new zzf.zzc
      {
        public void onConnected(@Nullable Bundle arg1)
        {
          synchronized (zzdk.zzc(zzdk.this))
          {
            try
            {
              zzdk.zza(zzdk.this, zzdk.zzd(zzdk.this).zzew());
              zzdk.zzc(zzdk.this).notifyAll();
              return;
            }
            catch (DeadObjectException localDeadObjectException)
            {
              for (;;)
              {
                zzpe.zzb("Unable to obtain a cache service instance.", localDeadObjectException);
                zzdk.zza(zzdk.this);
              }
            }
          }
        }
        
        public void onConnectionSuspended(int paramAnonymousInt)
        {
          synchronized (zzdk.zzc(zzdk.this))
          {
            zzdk.zza(zzdk.this, null);
            zzdk.zza(zzdk.this, null);
            zzdk.zzc(zzdk.this).notifyAll();
            zzv.zzcZ().zzkD();
            return;
          }
        }
      }, new zzf.zzc()
      {
        public void onConnectionFailed(@NonNull ConnectionResult arg1)
        {
          synchronized (zzdk.zzc(zzdk.this))
          {
            zzdk.zza(zzdk.this, null);
            zzdk.zza(zzdk.this, null);
            zzdk.zzc(zzdk.this).notifyAll();
            zzv.zzcZ().zzkD();
            return;
          }
        }
      });
      zzyt.zzwT();
      return;
    }
  }
  
  private void disconnect()
  {
    synchronized (zzrN)
    {
      if (zzyt == null) {
        return;
      }
      if ((zzyt.isConnected()) || (zzyt.isConnecting())) {
        zzyt.disconnect();
      }
      zzyt = null;
      zzyu = null;
      Binder.flushPendingCommands();
      zzv.zzcZ().zzkD();
      return;
    }
  }
  
  public void initialize(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    synchronized (zzrN)
    {
      if (mContext != null) {
        return;
      }
    }
    mContext = paramContext.getApplicationContext();
    if (((Boolean)zzfx.zzEL.get()).booleanValue()) {
      connect();
    }
    for (;;)
    {
      return;
      if (((Boolean)zzfx.zzEK.get()).booleanValue()) {
        zza(new zzda.zzb()
        {
          public void zzk(boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              zzdk.zzb(zzdk.this);
              return;
            }
            zzdk.zza(zzdk.this);
          }
        });
      }
    }
  }
  
  public zzdl zza(zzdo paramZzdo)
  {
    synchronized (zzrN)
    {
      if (zzyu == null)
      {
        paramZzdo = new zzdl();
        return paramZzdo;
      }
    }
    return paramZzdo;
  }
  
  protected zzdn zza(zzf.zzb paramZzb, zzf.zzc paramZzc)
  {
    return new zzdn(mContext, zzv.zzcZ().zzkC(), paramZzb, paramZzc);
  }
  
  protected void zza(zzda.zzb paramZzb)
  {
    zzv.zzcM().zza(paramZzb);
  }
  
  public void zzeq()
  {
    if (((Boolean)zzfx.zzEM.get()).booleanValue()) {
      synchronized (zzrN)
      {
        connect();
        zzv.zzcJ();
        zzpi.zzWR.removeCallbacks(zzys);
        zzv.zzcJ();
        zzpi.zzWR.postDelayed(zzys, ((Long)zzfx.zzEN.get()).longValue());
        return;
      }
    }
  }
}
