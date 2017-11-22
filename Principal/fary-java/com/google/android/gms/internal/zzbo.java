package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbo
  extends zzby
{
  private static final Object zzqW = new Object();
  private static volatile Long zzrb = null;
  
  public zzbo(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzrb == null) {
      synchronized (zzqW)
      {
        if (zzrb == null) {
          zzrb = (Long)zzrj.invoke(null, new Object[0]);
        }
      }
    }
    synchronized (zzra)
    {
      zzra.zzbt = zzrb;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}
