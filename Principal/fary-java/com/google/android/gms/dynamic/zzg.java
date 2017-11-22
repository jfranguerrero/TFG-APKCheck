package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zze;

public abstract class zzg<T>
{
  private final String zzaQo;
  private T zzaQp;
  
  protected zzg(String paramString)
  {
    zzaQo = paramString;
  }
  
  protected final T zzaT(Context paramContext)
    throws zzg.zza
  {
    if (zzaQp == null)
    {
      zzac.zzw(paramContext);
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      zzaQp = zzc((IBinder)paramContext.loadClass(zzaQo).newInstance());
      return zzaQp;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  protected abstract T zzc(IBinder paramIBinder);
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}
