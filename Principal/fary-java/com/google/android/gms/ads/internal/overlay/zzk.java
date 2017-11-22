package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzqp;

@zzmb
public abstract class zzk
{
  public zzk() {}
  
  @Nullable
  public abstract zzj zza(Context paramContext, zzqp paramZzqp, int paramInt, boolean paramBoolean, zzgf paramZzgf);
  
  protected boolean zzh(zzqp paramZzqp)
  {
    return zzbDzzzl;
  }
  
  protected boolean zzp(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    return (zzs.zzyA()) && ((paramContext == null) || (targetSdkVersion >= 11));
  }
}
