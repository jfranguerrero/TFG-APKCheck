package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.internal.zzabs;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zza
{
  private static final Object zzaED = new Object();
  private static zza zzaFT;
  private static Integer zzaFZ;
  private final List<String> zzaFU;
  private final List<String> zzaFV;
  private final List<String> zzaFW;
  private final List<String> zzaFX;
  private zzd zzaFY;
  private zzd zzaGa;
  
  private zza()
  {
    if (zzyd())
    {
      zzaFU = Collections.EMPTY_LIST;
      zzaFV = Collections.EMPTY_LIST;
      zzaFW = Collections.EMPTY_LIST;
      zzaFX = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzb.zza.zzaGe.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      zzaFU = ((List)localObject);
      localObject = (String)zzb.zza.zzaGf.get();
      if (localObject != null) {
        break label198;
      }
      localObject = Collections.EMPTY_LIST;
      label81:
      zzaFV = ((List)localObject);
      localObject = (String)zzb.zza.zzaGg.get();
      if (localObject != null) {
        break label211;
      }
      localObject = Collections.EMPTY_LIST;
      label104:
      zzaFW = ((List)localObject);
      localObject = (String)zzb.zza.zzaGh.get();
      if (localObject != null) {
        break label224;
      }
    }
    label198:
    label211:
    label224:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      zzaFX = ((List)localObject);
      zzaFY = new zzd(1024, ((Long)zzb.zza.zzaGi.get()).longValue());
      zzaGa = new zzd(1024, ((Long)zzb.zza.zzaGi.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label81;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label104;
    }
  }
  
  private static int getLogLevel()
  {
    if (zzaFZ == null) {}
    try
    {
      zzaFZ = Integer.valueOf(zzc.LOG_LEVEL_OFF);
      return zzaFZ.intValue();
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        zzaFZ = Integer.valueOf(zzc.LOG_LEVEL_OFF);
      }
    }
  }
  
  private boolean zzc(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if (paramIntent == null) {
      return false;
    }
    return com.google.android.gms.common.util.zzd.zzx(paramContext, paramIntent.getPackageName());
  }
  
  public static zza zzyc()
  {
    synchronized (zzaED)
    {
      if (zzaFT == null) {
        zzaFT = new zza();
      }
      return zzaFT;
    }
  }
  
  private boolean zzyd()
  {
    return getLogLevel() == zzc.LOG_LEVEL_OFF;
  }
  
  @SuppressLint({"UntrackedBindService"})
  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent) {}
  
  public boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  @SuppressLint({"UntrackedBindService"})
  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zzc(paramContext, paramIntent))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public void zzb(Context paramContext, ServiceConnection paramServiceConnection) {}
}
