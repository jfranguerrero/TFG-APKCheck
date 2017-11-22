package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbl
  extends zzby
{
  private long startTime;
  
  public zzbl(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, long paramLong, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
    startTime = paramLong;
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    long l = ((Long)zzrj.invoke(null, new Object[0])).longValue();
    synchronized (zzra)
    {
      zzra.zzbZ = Long.valueOf(l);
      if (startTime != 0L)
      {
        zzra.zzbp = Long.valueOf(l - startTime);
        zzra.zzbu = Long.valueOf(startTime);
      }
      return;
    }
  }
}
