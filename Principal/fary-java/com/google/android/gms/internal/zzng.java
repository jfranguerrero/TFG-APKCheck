package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import java.util.WeakHashMap;

@zzmb
public final class zzng
{
  private WeakHashMap<Context, zza> zzUx = new WeakHashMap();
  
  public zzng() {}
  
  public zznf zzv(Context paramContext)
  {
    Object localObject = (zza)zzUx.get(paramContext);
    if ((localObject != null) && (!((zza)localObject).hasExpired()) && (((Boolean)zzfx.zzCP.get()).booleanValue())) {}
    for (localObject = new zznf.zza(paramContext, zzUz).zzjn();; localObject = new zznf.zza(paramContext).zzjn())
    {
      zzUx.put(paramContext, new zza((zznf)localObject));
      return localObject;
    }
  }
  
  private class zza
  {
    public final long zzUy = zzv.zzcP().currentTimeMillis();
    public final zznf zzUz;
    
    public zza(zznf paramZznf)
    {
      zzUz = paramZznf;
    }
    
    public boolean hasExpired()
    {
      long l = zzUy;
      return ((Long)zzfx.zzCQ.get()).longValue() + l < zzv.zzcP().currentTimeMillis();
    }
  }
}
