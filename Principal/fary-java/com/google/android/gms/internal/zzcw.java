package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

class zzcw
  implements Application.ActivityLifecycleCallbacks
{
  private final Application zzwI;
  private final WeakReference<Application.ActivityLifecycleCallbacks> zzxc;
  
  public zzcw(Application paramApplication, Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    zzxc = new WeakReference(paramActivityLifecycleCallbacks);
    zzwI = paramApplication;
  }
  
  public void onActivityCreated(final Activity paramActivity, final Bundle paramBundle)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivityCreated(paramActivity, paramBundle);
      }
    });
  }
  
  public void onActivityDestroyed(final Activity paramActivity)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivityDestroyed(paramActivity);
      }
    });
  }
  
  public void onActivityPaused(final Activity paramActivity)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivityPaused(paramActivity);
      }
    });
  }
  
  public void onActivityResumed(final Activity paramActivity)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivityResumed(paramActivity);
      }
    });
  }
  
  public void onActivitySaveInstanceState(final Activity paramActivity, final Bundle paramBundle)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivitySaveInstanceState(paramActivity, paramBundle);
      }
    });
  }
  
  public void onActivityStarted(final Activity paramActivity)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivityStarted(paramActivity);
      }
    });
  }
  
  public void onActivityStopped(final Activity paramActivity)
  {
    zza(new zza()
    {
      public void zza(Application.ActivityLifecycleCallbacks paramAnonymousActivityLifecycleCallbacks)
      {
        paramAnonymousActivityLifecycleCallbacks.onActivityStopped(paramActivity);
      }
    });
  }
  
  protected void zza(zza paramZza)
  {
    try
    {
      Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)zzxc.get();
      if (localActivityLifecycleCallbacks != null)
      {
        paramZza.zza(localActivityLifecycleCallbacks);
        return;
      }
      zzwI.unregisterActivityLifecycleCallbacks(this);
      return;
    }
    catch (Exception paramZza)
    {
      zzpe.zzb("Error while dispatching lifecycle callback.", paramZza);
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks);
  }
}
