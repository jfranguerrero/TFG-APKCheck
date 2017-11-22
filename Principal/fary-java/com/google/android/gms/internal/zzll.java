package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

@zzmb
public class zzll
  extends zzlj
{
  private zzlk zzPD;
  
  zzll(Context paramContext, zzov.zza paramZza, zzqp paramZzqp, zzln.zza paramZza1)
  {
    super(paramContext, paramZza, paramZzqp, paramZza1);
  }
  
  protected void zziu()
  {
    Object localObject = zzGt.zzbD();
    int j;
    if (zzzl)
    {
      localObject = mContext.getResources().getDisplayMetrics();
      j = widthPixels;
    }
    for (int i = heightPixels;; i = heightPixels)
    {
      zzPD = new zzlk(this, zzGt, j, i);
      zzGt.zzkV().zza(this);
      zzPD.zza(zzPp);
      return;
      j = widthPixels;
    }
  }
  
  protected int zziv()
  {
    if (zzPD.zziz())
    {
      zzpe.zzbc("Ad-Network indicated no fill with passback URL.");
      return 3;
    }
    if (!zzPD.zziA()) {
      return 2;
    }
    return -2;
  }
}
