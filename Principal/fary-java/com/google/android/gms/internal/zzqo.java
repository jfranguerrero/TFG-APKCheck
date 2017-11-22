package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.common.internal.zzac;

@zzmb
public class zzqo
{
  private final Context mContext;
  private final zzqp zzGt;
  private zzl zzOA;
  private final ViewGroup zzYz;
  
  public zzqo(Context paramContext, ViewGroup paramViewGroup, zzqp paramZzqp)
  {
    this(paramContext, paramViewGroup, paramZzqp, null);
  }
  
  zzqo(Context paramContext, ViewGroup paramViewGroup, zzqp paramZzqp, zzl paramZzl)
  {
    mContext = paramContext;
    zzYz = paramViewGroup;
    zzGt = paramZzqp;
    zzOA = paramZzl;
  }
  
  public void onDestroy()
  {
    zzac.zzdn("onDestroy must be called from the UI thread.");
    if (zzOA != null)
    {
      zzOA.destroy();
      zzYz.removeView(zzOA);
      zzOA = null;
    }
  }
  
  public void onPause()
  {
    zzac.zzdn("onPause must be called from the UI thread.");
    if (zzOA != null) {
      zzOA.pause();
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (zzOA != null) {
      return;
    }
    zzgb.zza(zzGt.zzlf().zzfv(), zzGt.zzle(), new String[] { "vpr2" });
    zzOA = new zzl(mContext, zzGt, paramInt5, paramBoolean, zzGt.zzlf().zzfv());
    zzYz.addView(zzOA, 0, new ViewGroup.LayoutParams(-1, -1));
    zzOA.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    zzGt.zzkV().zzN(false);
  }
  
  public void zze(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzac.zzdn("The underlay may only be modified from the UI thread.");
    if (zzOA != null) {
      zzOA.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public zzl zzkO()
  {
    zzac.zzdn("getAdVideoUnderlay must be called from the UI thread.");
    return zzOA;
  }
}
