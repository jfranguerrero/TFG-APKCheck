package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbj
  extends zzby
{
  public zzbj(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzra.zzbd = Long.valueOf(-1L);
    zzra.zzbe = Long.valueOf(-1L);
    int[] arrayOfInt = (int[])zzrj.invoke(null, new Object[] { zzpC.getContext() });
    synchronized (zzra)
    {
      zzra.zzbd = Long.valueOf(arrayOfInt[0]);
      zzra.zzbe = Long.valueOf(arrayOfInt[1]);
      return;
    }
  }
}
