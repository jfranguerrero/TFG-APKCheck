package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class zzapt
{
  public static zzaf.zza zzi(Context paramContext, String paramString1, String paramString2)
  {
    return new zza(paramContext, paramString1, paramString2).zzaS();
  }
  
  static class zza
    implements zzf.zzb, zzf.zzc
  {
    private final String packageName;
    protected zzapu zzbfB;
    private final String zzbfC;
    private final LinkedBlockingQueue<zzaf.zza> zzbfD;
    private final HandlerThread zzbfE;
    
    public zza(Context paramContext, String paramString1, String paramString2)
    {
      packageName = paramString1;
      zzbfC = paramString2;
      zzbfE = new HandlerThread("GassClient");
      zzbfE.start();
      zzbfB = new zzapu(paramContext, zzbfE.getLooper(), this, this);
      zzbfD = new LinkedBlockingQueue();
      connect();
    }
    
    protected void connect()
    {
      zzbfB.zzwT();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      paramBundle = zzFW();
      if (paramBundle != null) {}
      try
      {
        paramBundle = paramBundle.zza(new zzapv(packageName, zzbfC)).zzFZ();
        zzbfD.put(paramBundle);
        zziY();
        zzbfE.quit();
        return;
      }
      catch (Throwable paramBundle)
      {
        paramBundle = paramBundle;
        zziY();
        zzbfE.quit();
        return;
      }
      finally
      {
        paramBundle = finally;
        zziY();
        zzbfE.quit();
        throw paramBundle;
      }
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      try
      {
        zzbfD.put(new zzaf.zza());
        return;
      }
      catch (InterruptedException paramConnectionResult) {}
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      try
      {
        zzbfD.put(new zzaf.zza());
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    
    protected zzapz zzFW()
    {
      try
      {
        zzapz localZzapz = zzbfB.zzFX();
        return localZzapz;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        return null;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;) {}
      }
    }
    
    public zzaf.zza zzaS()
    {
      return zzjo(2000);
    }
    
    public void zziY()
    {
      if ((zzbfB != null) && ((zzbfB.isConnected()) || (zzbfB.isConnecting()))) {
        zzbfB.disconnect();
      }
    }
    
    public zzaf.zza zzjo(int paramInt)
    {
      try
      {
        zzaf.zza localZza1 = (zzaf.zza)zzbfD.poll(paramInt, TimeUnit.MILLISECONDS);
        zzaf.zza localZza2 = localZza1;
        if (localZza1 == null) {
          localZza2 = new zzaf.zza();
        }
        return localZza2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
}
