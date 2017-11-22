package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzo
  extends zzn
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zza, zzb> zzaEF = new HashMap();
  private final zza zzaEG;
  private final long zzaEH;
  private final Context zzvZ;
  
  zzo(Context paramContext)
  {
    zzvZ = paramContext.getApplicationContext();
    mHandler = new Handler(paramContext.getMainLooper(), this);
    zzaEG = zza.zzyc();
    zzaEH = 5000L;
  }
  
  private boolean zza(zza paramZza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzac.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzb localZzb;
      synchronized (zzaEF)
      {
        localZzb = (zzb)zzaEF.get(paramZza);
        if (localZzb == null)
        {
          localZzb = new zzb(paramZza);
          localZzb.zza(paramServiceConnection, paramString);
          localZzb.zzdr(paramString);
          zzaEF.put(paramZza, localZzb);
          paramZza = localZzb;
          boolean bool = paramZza.isBound();
          return bool;
        }
        mHandler.removeMessages(0, paramZza);
        if (localZzb.zza(paramServiceConnection))
        {
          paramZza = String.valueOf(paramZza);
          throw new IllegalStateException(String.valueOf(paramZza).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramZza);
        }
      }
      localZzb.zza(paramServiceConnection, paramString);
      switch (localZzb.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localZzb.getComponentName(), localZzb.getBinder());
        paramZza = localZzb;
        break;
      case 2: 
        localZzb.zzdr(paramString);
        paramZza = localZzb;
        break;
      default: 
        paramZza = localZzb;
      }
    }
  }
  
  private void zzb(zza paramZza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzac.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localZzb;
    synchronized (zzaEF)
    {
      localZzb = (zzb)zzaEF.get(paramZza);
      if (localZzb == null)
      {
        paramZza = String.valueOf(paramZza);
        throw new IllegalStateException(String.valueOf(paramZza).length() + 50 + "Nonexistent connection status for service config: " + paramZza);
      }
    }
    if (!localZzb.zza(paramServiceConnection))
    {
      paramZza = String.valueOf(paramZza);
      throw new IllegalStateException(String.valueOf(paramZza).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramZza);
    }
    localZzb.zzb(paramServiceConnection, paramString);
    if (localZzb.zzxt())
    {
      paramZza = mHandler.obtainMessage(0, paramZza);
      mHandler.sendMessageDelayed(paramZza, zzaEH);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (what)
    {
    default: 
      return false;
    }
    zza localZza = (zza)obj;
    synchronized (zzaEF)
    {
      zzb localZzb = (zzb)zzaEF.get(localZza);
      if ((localZzb != null) && (localZzb.zzxt()))
      {
        if (localZzb.isBound()) {
          localZzb.zzds("GmsClientSupervisor");
        }
        zzaEF.remove(localZza);
      }
      return true;
    }
  }
  
  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return zza(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    zzb(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  private static final class zza
  {
    private final String zzaEI;
    private final ComponentName zzaEJ;
    private final String zzaca;
    
    public zza(ComponentName paramComponentName)
    {
      zzaca = null;
      zzaEI = null;
      zzaEJ = ((ComponentName)zzac.zzw(paramComponentName));
    }
    
    public zza(String paramString1, String paramString2)
    {
      zzaca = zzac.zzdv(paramString1);
      zzaEI = zzac.zzdv(paramString2);
      zzaEJ = null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
      } while ((zzaa.equal(zzaca, zzaca)) && (zzaa.equal(zzaEJ, zzaEJ)));
      return false;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { zzaca, zzaEJ });
    }
    
    public String toString()
    {
      if (zzaca == null) {
        return zzaEJ.flattenToString();
      }
      return zzaca;
    }
    
    public Intent zzxs()
    {
      if (zzaca != null) {
        return new Intent(zzaca).setPackage(zzaEI);
      }
      return new Intent().setComponent(zzaEJ);
    }
  }
  
  private final class zzb
  {
    private int mState;
    private ComponentName zzaEJ;
    private final zza zzaEK;
    private final Set<ServiceConnection> zzaEL;
    private boolean zzaEM;
    private final zzo.zza zzaEN;
    private IBinder zzaEa;
    
    public zzb(zzo.zza paramZza)
    {
      zzaEN = paramZza;
      zzaEK = new zza();
      zzaEL = new HashSet();
      mState = 2;
    }
    
    public IBinder getBinder()
    {
      return zzaEa;
    }
    
    public ComponentName getComponentName()
    {
      return zzaEJ;
    }
    
    public int getState()
    {
      return mState;
    }
    
    public boolean isBound()
    {
      return zzaEM;
    }
    
    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzo.zzc(zzo.this).zza(zzo.zzb(zzo.this), paramServiceConnection, paramString, zzaEN.zzxs());
      zzaEL.add(paramServiceConnection);
    }
    
    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return zzaEL.contains(paramServiceConnection);
    }
    
    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzo.zzc(zzo.this).zzb(zzo.zzb(zzo.this), paramServiceConnection);
      zzaEL.remove(paramServiceConnection);
    }
    
    @TargetApi(14)
    public void zzdr(String paramString)
    {
      mState = 3;
      zzaEM = zzo.zzc(zzo.this).zza(zzo.zzb(zzo.this), paramString, zzaEN.zzxs(), zzaEK, 129);
      if (!zzaEM) {
        mState = 2;
      }
      try
      {
        zzo.zzc(zzo.this).zza(zzo.zzb(zzo.this), zzaEK);
        return;
      }
      catch (IllegalArgumentException paramString) {}
    }
    
    public void zzds(String paramString)
    {
      zzo.zzc(zzo.this).zza(zzo.zzb(zzo.this), zzaEK);
      zzaEM = false;
      mState = 2;
    }
    
    public boolean zzxt()
    {
      return zzaEL.isEmpty();
    }
    
    public class zza
      implements ServiceConnection
    {
      public zza() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzo.zza(zzo.this))
        {
          zzo.zzb.zza(zzo.zzb.this, paramIBinder);
          zzo.zzb.zza(zzo.zzb.this, paramComponentName);
          Iterator localIterator = zzo.zzb.zza(zzo.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        zzo.zzb.zza(zzo.zzb.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (zzo.zza(zzo.this))
        {
          zzo.zzb.zza(zzo.zzb.this, null);
          zzo.zzb.zza(zzo.zzb.this, paramComponentName);
          Iterator localIterator = zzo.zzb.zza(zzo.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        zzo.zzb.zza(zzo.zzb.this, 2);
      }
    }
  }
}
