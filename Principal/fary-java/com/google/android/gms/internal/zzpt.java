package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;

@zzmb
public class zzpt
{
  private long zzXL;
  private long zzXM = Long.MIN_VALUE;
  private Object zzrN = new Object();
  
  public zzpt(long paramLong)
  {
    zzXL = paramLong;
  }
  
  public boolean tryAcquire()
  {
    synchronized (zzrN)
    {
      long l = zzv.zzcP().elapsedRealtime();
      if (zzXM + zzXL > l) {
        return false;
      }
      zzXM = l;
      return true;
    }
  }
}
