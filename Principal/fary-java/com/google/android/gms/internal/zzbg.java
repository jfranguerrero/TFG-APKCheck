package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbg
  extends zzby
{
  public zzbg(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    synchronized (zzra)
    {
      zzra.zzbb = Long.valueOf(-1L);
      zzra.zzbb = ((Long)zzrj.invoke(null, new Object[] { zzpC.getContext() }));
      return;
    }
  }
}
