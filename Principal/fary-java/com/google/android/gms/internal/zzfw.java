package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.zze;
import java.util.concurrent.Callable;

@zzmb
public class zzfw
{
  private final ConditionVariable zzAM = new ConditionVariable();
  @Nullable
  private SharedPreferences zzAN = null;
  private final Object zzrN = new Object();
  private volatile boolean zztW = false;
  
  public zzfw() {}
  
  public void initialize(Context paramContext)
  {
    if (zztW) {
      return;
    }
    synchronized (zzrN)
    {
      if (zztW) {
        return;
      }
    }
    try
    {
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null)
      {
        zzAM.open();
        return;
      }
      zzAN = zzv.zzcT().zzm(paramContext);
      zztW = true;
      zzAM.open();
      return;
    }
    finally
    {
      zzAM.open();
    }
  }
  
  public <T> T zzd(final zzft<T> paramZzft)
  {
    if (!zzAM.block(5000L)) {
      throw new IllegalStateException("Flags.initialize() was not called!");
    }
    if (!zztW) {}
    synchronized (zzrN)
    {
      if (!zztW)
      {
        paramZzft = paramZzft.zzfm();
        return paramZzft;
      }
      zzpv.zzb(new Callable()
      {
        public T call()
        {
          return paramZzft.zza(zzfw.zza(zzfw.this));
        }
      });
    }
  }
}
