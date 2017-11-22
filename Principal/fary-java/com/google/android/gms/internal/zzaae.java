package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zza;

public class zzaae
  extends zzzw
{
  private zzaap zzaxK;
  private final zza<zzzs<?>> zzazH = new zza();
  
  private zzaae(zzaax paramZzaax)
  {
    super(paramZzaax);
    zzaBs.zza("ConnectionlessLifecycleHelper", this);
  }
  
  public static void zza(Activity paramActivity, zzaap paramZzaap, zzzs<?> paramZzzs)
  {
    zzaax localZzaax = zzs(paramActivity);
    zzaae localZzaae = (zzaae)localZzaax.zza("ConnectionlessLifecycleHelper", zzaae.class);
    paramActivity = localZzaae;
    if (localZzaae == null) {
      paramActivity = new zzaae(localZzaax);
    }
    zzaxK = paramZzaap;
    paramActivity.zza(paramZzzs);
    paramZzaap.zza(paramActivity);
  }
  
  private void zza(zzzs<?> paramZzzs)
  {
    zzac.zzb(paramZzzs, "ApiKey cannot be null");
    zzazH.add(paramZzzs);
  }
  
  public void onStart()
  {
    super.onStart();
    if (!zzazH.isEmpty()) {
      zzaxK.zza(this);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    zzaxK.zzb(this);
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    zzaxK.zza(paramConnectionResult, paramInt);
  }
  
  protected void zzuW()
  {
    zzaxK.zzuW();
  }
  
  zza<zzzs<?>> zzvx()
  {
    return zzazH;
  }
}
