package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbs
  extends zzby
{
  private final StackTraceElement[] zzre;
  
  public zzbs(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
    zzre = paramArrayOfStackTraceElement;
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzba localZzba;
    if (zzre != null) {
      localZzba = new zzba((String)zzrj.invoke(null, new Object[] { zzre }));
    }
    for (;;)
    {
      synchronized (zzra)
      {
        zzra.zzbI = zzqm;
        if (zzqn.booleanValue())
        {
          zzaf.zza localZza2 = zzra;
          if (!zzqo.booleanValue()) {
            break label101;
          }
          i = 0;
          zzbQ = Integer.valueOf(i);
        }
        return;
      }
      return;
      label101:
      int i = 1;
    }
  }
}
