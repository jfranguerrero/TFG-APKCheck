package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public final class zzps
  extends zzpd
{
  private final String zzD;
  private final zzpz zzXK;
  
  public zzps(Context paramContext, String paramString1, String paramString2)
  {
    this(paramString2, zzv.zzcJ().zzh(paramContext, paramString1));
  }
  
  public zzps(String paramString1, String paramString2)
  {
    zzXK = new zzpz(paramString2);
    zzD = paramString1;
  }
  
  public void onStop() {}
  
  public void zzcm()
  {
    zzXK.zzu(zzD);
  }
}
