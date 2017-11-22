package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzmb
public final class zzgg
  extends zzgi.zza
{
  private final zzh zzFw;
  @Nullable
  private final String zzFx;
  private final String zzFy;
  
  public zzgg(zzh paramZzh, @Nullable String paramString1, String paramString2)
  {
    zzFw = paramZzh;
    zzFx = paramString1;
    zzFy = paramString2;
  }
  
  public String getContent()
  {
    return zzFy;
  }
  
  public void recordClick()
  {
    zzFw.zzbX();
  }
  
  public void recordImpression()
  {
    zzFw.zzbY();
  }
  
  public String zzfB()
  {
    return zzFx;
  }
  
  public void zzi(@Nullable zzd paramZzd)
  {
    if (paramZzd == null) {
      return;
    }
    zzFw.zzc((View)zze.zzE(paramZzd));
  }
}
