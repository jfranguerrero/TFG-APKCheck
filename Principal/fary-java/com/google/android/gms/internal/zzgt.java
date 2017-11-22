package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzgt
  extends zzgv
{
  @Nullable
  private zzjw zzGj;
  @Nullable
  private zzjx zzGk;
  private final zzr zzGl;
  @Nullable
  private zzgu zzGm;
  private boolean zzGn = false;
  private Object zzrN = new Object();
  
  private zzgt(Context paramContext, zzr paramZzr, zzav paramZzav, zzgu.zza paramZza)
  {
    super(paramContext, paramZzr, null, paramZzav, null, paramZza, null, null);
    zzGl = paramZzr;
  }
  
  public zzgt(Context paramContext, zzr paramZzr, zzav paramZzav, zzjw paramZzjw, zzgu.zza paramZza)
  {
    this(paramContext, paramZzr, paramZzav, paramZza);
    zzGj = paramZzjw;
  }
  
  public zzgt(Context paramContext, zzr paramZzr, zzav paramZzav, zzjx paramZzjx, zzgu.zza paramZza)
  {
    this(paramContext, paramZzr, paramZzav, paramZza);
    zzGk = paramZzjx;
  }
  
  @Nullable
  public zzgn zza(View.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> arg2, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    synchronized (zzrN)
    {
      zzGn = true;
      try
      {
        if (zzGj != null) {
          zzGj.zzl(zze.zzA(paramView));
        }
        for (;;)
        {
          zzGn = false;
          return;
          if (zzGk != null) {
            zzGk.zzl(zze.zzA(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          zzpe.zzc("Failed to call prepareAd", paramView);
        }
      }
    }
  }
  
  public void zza(View paramView1, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject, View paramView2)
  {
    zzac.zzdn("performClick must be called on the main UI thread.");
    synchronized (zzrN)
    {
      if (zzGm != null)
      {
        zzGm.zza(paramView1, paramMap, paramJSONObject, paramView2);
        zzGl.onAdClicked();
      }
      for (;;)
      {
        return;
        try
        {
          if ((zzGj != null) && (!zzGj.getOverrideClickHandling()))
          {
            zzGj.zzk(zze.zzA(paramView1));
            zzGl.onAdClicked();
          }
          if ((zzGk == null) || (zzGk.getOverrideClickHandling())) {
            continue;
          }
          zzGk.zzk(zze.zzA(paramView1));
          zzGl.onAdClicked();
        }
        catch (RemoteException paramView1)
        {
          zzpe.zzc("Failed to call performClick", paramView1);
        }
      }
    }
  }
  
  public void zzb(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    zzac.zzdn("recordImpression must be called on the main UI thread.");
    for (;;)
    {
      synchronized (zzrN)
      {
        zzq(true);
        if (zzGm != null)
        {
          zzGm.zzb(paramView, paramMap);
          zzGl.recordImpression();
          return;
        }
        try
        {
          if ((zzGj != null) && (!zzGj.getOverrideImpressionRecording()))
          {
            zzGj.recordImpression();
            zzGl.recordImpression();
          }
        }
        catch (RemoteException paramView)
        {
          zzpe.zzc("Failed to call recordImpression", paramView);
        }
      }
      if ((zzGk != null) && (!zzGk.getOverrideImpressionRecording()))
      {
        zzGk.recordImpression();
        zzGl.recordImpression();
      }
    }
  }
  
  public void zzc(View paramView, Map<String, WeakReference<View>> arg2)
  {
    synchronized (zzrN)
    {
      try
      {
        if (zzGj != null) {
          zzGj.zzm(zze.zzA(paramView));
        }
        for (;;)
        {
          return;
          if (zzGk != null) {
            zzGk.zzm(zze.zzA(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          zzpe.zzc("Failed to call untrackView", paramView);
        }
      }
    }
  }
  
  public void zzc(@Nullable zzgu paramZzgu)
  {
    synchronized (zzrN)
    {
      zzGm = paramZzgu;
      return;
    }
  }
  
  public boolean zzfS()
  {
    synchronized (zzrN)
    {
      boolean bool = zzGn;
      return bool;
    }
  }
  
  public zzgu zzfT()
  {
    synchronized (zzrN)
    {
      zzgu localZzgu = zzGm;
      return localZzgu;
    }
  }
  
  @Nullable
  public zzqp zzfU()
  {
    return null;
  }
}
