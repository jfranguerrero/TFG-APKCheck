package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzda
{
  private final Object zzxv = new Object();
  private zza zzxw = null;
  private boolean zzxx = false;
  
  public zzda() {}
  
  @Nullable
  public Activity getActivity()
  {
    synchronized (zzxv)
    {
      if (!zzs.zzyA()) {
        return null;
      }
      if (zzxw != null)
      {
        Activity localActivity = zzxw.getActivity();
        return localActivity;
      }
    }
    return null;
  }
  
  @Nullable
  public Context getContext()
  {
    synchronized (zzxv)
    {
      if (!zzs.zzyA()) {
        return null;
      }
      if (zzxw != null)
      {
        Context localContext = zzxw.getContext();
        return localContext;
      }
    }
    return null;
  }
  
  public void initialize(Context paramContext)
  {
    synchronized (zzxv)
    {
      if (zzxx) {
        break label121;
      }
      if (!zzs.zzyA()) {
        return;
      }
      if (!((Boolean)zzfx.zzCt.get()).booleanValue()) {
        return;
      }
    }
    Context localContext = paramContext.getApplicationContext();
    Object localObject1 = localContext;
    if (localContext == null) {
      localObject1 = paramContext;
    }
    if ((localObject1 instanceof Application)) {}
    for (localObject1 = (Application)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        zzpe.zzbe("Can not cast Context to Application");
        return;
      }
      if (zzxw == null) {
        zzxw = new zza();
      }
      zzxw.zza((Application)localObject1, paramContext);
      zzxx = true;
      label121:
      return;
    }
  }
  
  public void zza(zzb paramZzb)
  {
    synchronized (zzxv)
    {
      if (!zzs.zzyA()) {
        return;
      }
      if (!((Boolean)zzfx.zzCt.get()).booleanValue()) {
        return;
      }
    }
    if (zzxw == null) {
      zzxw = new zza();
    }
    zzxw.zza(paramZzb);
  }
  
  @TargetApi(14)
  static class zza
    implements Application.ActivityLifecycleCallbacks
  {
    @Nullable
    private Activity mActivity;
    private Context mContext;
    private List<zzda.zzb> mListeners = new ArrayList();
    private final Object zzrN = new Object();
    private boolean zztW = false;
    private Runnable zzxA;
    private long zzxB;
    private boolean zzxy = true;
    private boolean zzxz = false;
    
    zza() {}
    
    private void setActivity(Activity paramActivity)
    {
      synchronized (zzrN)
      {
        if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads")) {
          mActivity = paramActivity;
        }
        return;
      }
    }
    
    @Nullable
    public Activity getActivity()
    {
      return mActivity;
    }
    
    @Nullable
    public Context getContext()
    {
      return mContext;
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      synchronized (zzrN)
      {
        if (mActivity == null) {
          return;
        }
        if (mActivity.equals(paramActivity)) {
          mActivity = null;
        }
        return;
      }
    }
    
    public void onActivityPaused(Activity paramActivity)
    {
      setActivity(paramActivity);
      zzxz = true;
      if (zzxA != null) {
        zzpi.zzWR.removeCallbacks(zzxA);
      }
      paramActivity = zzpi.zzWR;
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          synchronized (zzda.zza.zza(zzda.zza.this))
          {
            if ((zzda.zza.zzb(zzda.zza.this)) && (zzda.zza.zzc(zzda.zza.this)))
            {
              zzda.zza.zza(zzda.zza.this, false);
              zzpe.zzbc("App went background");
              Iterator localIterator = zzda.zza.zzd(zzda.zza.this).iterator();
              for (;;)
              {
                if (!localIterator.hasNext()) {
                  break label106;
                }
                zzda.zzb localZzb = (zzda.zzb)localIterator.next();
                try
                {
                  localZzb.zzk(false);
                }
                catch (Exception localException)
                {
                  zzpe.zzb("OnForegroundStateChangedListener threw exception.", localException);
                }
              }
            }
          }
          zzpe.zzbc("App is still foreground");
          label106:
        }
      };
      zzxA = local1;
      paramActivity.postDelayed(local1, zzxB);
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      int i = 0;
      setActivity(paramActivity);
      zzxz = false;
      if (!zzxy) {
        i = 1;
      }
      zzxy = true;
      if (zzxA != null) {
        zzpi.zzWR.removeCallbacks(zzxA);
      }
      paramActivity = zzrN;
      if (i != 0) {
        try
        {
          Iterator localIterator = mListeners.iterator();
          while (localIterator.hasNext())
          {
            zzda.zzb localZzb = (zzda.zzb)localIterator.next();
            try
            {
              localZzb.zzk(true);
            }
            catch (Exception localException)
            {
              zzpe.zzb("OnForegroundStateChangedListener threw exception.", localException);
            }
            continue;
            zzpe.zzbc("App is still foreground.");
          }
        }
        finally {}
      }
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      setActivity(paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity) {}
    
    public void zza(Application paramApplication, Context paramContext)
    {
      if (!zztW)
      {
        paramApplication.registerActivityLifecycleCallbacks(this);
        if ((paramContext instanceof Activity)) {
          setActivity((Activity)paramContext);
        }
        mContext = paramContext;
        zzxB = ((Long)zzfx.zzCu.get()).longValue();
        zztW = true;
      }
    }
    
    public void zza(zzda.zzb paramZzb)
    {
      mListeners.add(paramZzb);
    }
  }
  
  public static abstract interface zzb
  {
    public abstract void zzk(boolean paramBoolean);
  }
}
