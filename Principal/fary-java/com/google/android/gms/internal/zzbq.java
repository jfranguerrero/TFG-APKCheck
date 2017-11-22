package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbq
  extends zzby
{
  private static volatile String zzba = null;
  private static final Object zzqW = new Object();
  
  public zzbq(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzra.zzba = "E";
    if (zzba == null) {
      synchronized (zzqW)
      {
        if (zzba == null) {
          zzba = (String)zzrj.invoke(null, new Object[0]);
        }
      }
    }
    synchronized (zzra)
    {
      zzra.zzba = zzba;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}
