package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@zzmb
@TargetApi(14)
public class zzcv
  implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long zzwH = ((Long)zzfx.zzCO.get()).longValue();
  private zzpt zzvK = new zzpt(zzwH);
  private final Context zzvZ;
  private Application zzwI;
  private WeakReference<ViewTreeObserver> zzwJ;
  WeakReference<View> zzwK;
  private zzcw zzwL;
  private int zzwM = -1;
  private HashSet<zzb> zzwN = new HashSet();
  private DisplayMetrics zzwO;
  private final WindowManager zzwf;
  private final PowerManager zzwg;
  private final KeyguardManager zzwh;
  private boolean zzwn = false;
  @Nullable
  BroadcastReceiver zzwo;
  
  public zzcv(Context paramContext, View paramView)
  {
    zzvZ = paramContext.getApplicationContext();
    zzwf = ((WindowManager)paramContext.getSystemService("window"));
    zzwg = ((PowerManager)zzvZ.getSystemService("power"));
    zzwh = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    if ((zzvZ instanceof Application))
    {
      zzwI = ((Application)zzvZ);
      zzwL = new zzcw((Application)zzvZ, this);
    }
    zzwO = paramContext.getResources().getDisplayMetrics();
    zze(paramView);
  }
  
  private void zza(Activity paramActivity, int paramInt)
  {
    if (zzwK == null) {}
    View localView;
    do
    {
      do
      {
        return;
        paramActivity = paramActivity.getWindow();
      } while (paramActivity == null);
      paramActivity = paramActivity.peekDecorView();
      localView = (View)zzwK.get();
    } while ((localView == null) || (paramActivity == null) || (localView.getRootView() != paramActivity.getRootView()));
    zzwM = paramInt;
  }
  
  private void zzdB()
  {
    if (zzwo != null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    zzwo = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        zzcv.zza(zzcv.this, 3);
      }
    };
    zzvZ.registerReceiver(zzwo, localIntentFilter);
  }
  
  private void zzdC()
  {
    if (zzwo != null) {}
    try
    {
      zzvZ.unregisterReceiver(zzwo);
      zzwo = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zzpe.zzb("Failed trying to unregister the receiver", localIllegalStateException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzv.zzcN().zza(localException, "ActiveViewUnit.stopScreenStatusMonitoring");
      }
    }
  }
  
  private void zzdT()
  {
    zzv.zzcJ();
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        zzcv.zza(zzcv.this, 3);
      }
    });
  }
  
  private void zzf(View paramView)
  {
    paramView = paramView.getViewTreeObserver();
    if (paramView.isAlive())
    {
      zzwJ = new WeakReference(paramView);
      paramView.addOnScrollChangedListener(this);
      paramView.addOnGlobalLayoutListener(this);
    }
    zzdB();
    if (zzwI != null) {}
    try
    {
      zzwI.registerActivityLifecycleCallbacks(zzwL);
      return;
    }
    catch (Exception paramView)
    {
      zzpe.zzb("Error registering activity lifecycle callbacks.", paramView);
    }
  }
  
  private void zzg(View paramView)
  {
    try
    {
      if (zzwJ != null)
      {
        ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)zzwJ.get();
        if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()))
        {
          localViewTreeObserver.removeOnScrollChangedListener(this);
          localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
        zzwJ = null;
      }
      return;
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramView = paramView.getViewTreeObserver();
          if (paramView.isAlive())
          {
            paramView.removeOnScrollChangedListener(this);
            paramView.removeGlobalOnLayoutListener(this);
          }
          zzdC();
          if (zzwI != null) {}
          try
          {
            zzwI.unregisterActivityLifecycleCallbacks(zzwL);
            return;
          }
          catch (Exception paramView)
          {
            zzpe.zzb("Error registering activity lifecycle callbacks.", paramView);
          }
          localException = localException;
          zzpe.zzb("Error while unregistering listeners from the last ViewTreeObserver.", localException);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          zzpe.zzb("Error while unregistering listeners from the ViewTreeObserver.", paramView);
        }
      }
    }
  }
  
  private void zzl(int paramInt)
  {
    if (zzwN.size() == 0) {}
    for (;;)
    {
      return;
      if (zzwK != null)
      {
        Object localObject1 = (View)zzwK.get();
        int j;
        int k;
        Object localObject2;
        Rect localRect1;
        boolean bool1;
        Rect localRect2;
        boolean bool2;
        Rect localRect3;
        Rect localRect4;
        int[] arrayOfInt1;
        int[] arrayOfInt2;
        if (paramInt == 1)
        {
          j = 1;
          if (localObject1 != null) {
            break label487;
          }
          k = 1;
          localObject2 = new Rect();
          localRect1 = new Rect();
          bool1 = false;
          localRect2 = new Rect();
          bool2 = false;
          localRect3 = new Rect();
          localRect4 = new Rect();
          right = zzwf.getDefaultDisplay().getWidth();
          bottom = zzwf.getDefaultDisplay().getHeight();
          arrayOfInt1 = new int[2];
          arrayOfInt2 = new int[2];
          if (localObject1 != null)
          {
            bool1 = ((View)localObject1).getGlobalVisibleRect(localRect1);
            bool2 = ((View)localObject1).getLocalVisibleRect(localRect2);
            ((View)localObject1).getHitRect(localRect3);
          }
        }
        try
        {
          ((View)localObject1).getLocationOnScreen(arrayOfInt1);
          ((View)localObject1).getLocationInWindow(arrayOfInt2);
          left = arrayOfInt1[0];
          top = arrayOfInt1[1];
          right = (left + ((View)localObject1).getWidth());
          bottom = (top + ((View)localObject1).getHeight());
          if (localObject1 != null)
          {
            i = ((View)localObject1).getWindowVisibility();
            if (zzwM != -1) {
              i = zzwM;
            }
            if ((k != 0) || (!zzv.zzcJ().zza((View)localObject1, zzwg, zzwh)) || (!bool1) || (!bool2) || (i != 0)) {
              break label512;
            }
            bool3 = true;
            if (((j != 0) && (!zzvK.tryAcquire()) && (bool3 == zzwn)) || ((!bool3) && (!zzwn) && (paramInt == 1))) {
              continue;
            }
            long l = zzv.zzcP().elapsedRealtime();
            boolean bool5 = zzwg.isScreenOn();
            if (localObject1 == null) {
              break label518;
            }
            bool4 = zzv.zzcL().isAttachedToWindow((View)localObject1);
            if (localObject1 == null) {
              break label524;
            }
            paramInt = ((View)localObject1).getWindowVisibility();
            localObject1 = new zza(l, bool5, bool4, paramInt, zza(localRect4), zza((Rect)localObject2), zza(localRect1), bool1, zza(localRect2), bool2, zza(localRect3), zzwO.density, bool3);
            localObject2 = zzwN.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                ((zzb)((Iterator)localObject2).next()).zza((zza)localObject1);
                continue;
                j = 0;
                break;
                label487:
                k = 0;
              }
            }
          }
        }
        catch (Exception localException)
        {
          boolean bool3;
          for (;;)
          {
            zzpe.zzb("Failure getting view location.", localException);
            continue;
            int i = 8;
            continue;
            label512:
            bool3 = false;
            continue;
            label518:
            boolean bool4 = false;
            continue;
            label524:
            paramInt = 8;
          }
          zzwn = bool3;
        }
      }
    }
  }
  
  private int zzm(int paramInt)
  {
    float f = zzwO.density;
    return (int)(paramInt / f);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zza(paramActivity, 0);
    zzl(3);
    zzdT();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    zzl(3);
    zzdT();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    zza(paramActivity, 4);
    zzl(3);
    zzdT();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    zza(paramActivity, 0);
    zzl(3);
    zzdT();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zzl(3);
    zzdT();
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    zza(paramActivity, 0);
    zzl(3);
    zzdT();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    zzl(3);
    zzdT();
  }
  
  public void onGlobalLayout()
  {
    zzl(2);
  }
  
  public void onScrollChanged()
  {
    zzl(1);
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    zzwM = -1;
    zzf(paramView);
    zzl(3);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    zzwM = -1;
    zzl(3);
    zzg(paramView);
  }
  
  Rect zza(Rect paramRect)
  {
    return new Rect(zzm(left), zzm(top), zzm(right), zzm(bottom));
  }
  
  public void zza(zzb paramZzb)
  {
    zzwN.add(paramZzb);
    zzl(3);
  }
  
  public void zze(View paramView)
  {
    if (zzwK != null) {}
    for (View localView = (View)zzwK.get();; localView = null)
    {
      if (localView != null)
      {
        localView.removeOnAttachStateChangeListener(this);
        zzg(localView);
      }
      zzwK = new WeakReference(paramView);
      if (paramView != null)
      {
        if (zzv.zzcL().isAttachedToWindow(paramView)) {
          zzf(paramView);
        }
        paramView.addOnAttachStateChangeListener(this);
      }
      return;
    }
  }
  
  public static class zza
  {
    public final long timestamp;
    public final boolean zzwQ;
    public final boolean zzwR;
    public final int zzwS;
    public final Rect zzwT;
    public final Rect zzwU;
    public final Rect zzwV;
    public final boolean zzwW;
    public final Rect zzwX;
    public final boolean zzwY;
    public final Rect zzwZ;
    public final float zzxa;
    public final boolean zzxb;
    
    public zza(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3, boolean paramBoolean3, Rect paramRect4, boolean paramBoolean4, Rect paramRect5, float paramFloat, boolean paramBoolean5)
    {
      timestamp = paramLong;
      zzwQ = paramBoolean1;
      zzwR = paramBoolean2;
      zzwS = paramInt;
      zzwT = paramRect1;
      zzwU = paramRect2;
      zzwV = paramRect3;
      zzwW = paramBoolean3;
      zzwX = paramRect4;
      zzwY = paramBoolean4;
      zzwZ = paramRect5;
      zzxa = paramFloat;
      zzxb = paramBoolean5;
    }
  }
  
  public static abstract interface zzb
  {
    public abstract void zza(zzcv.zza paramZza);
  }
}
