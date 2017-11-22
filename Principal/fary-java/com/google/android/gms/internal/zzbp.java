package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbp
  extends zzby
{
  private long zzrc = -1L;
  
  public zzbp(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzra.zzbk = Long.valueOf(-1L);
    if (zzrc == -1L) {
      zzrc = ((Integer)zzrj.invoke(null, new Object[] { zzpC.getContext() })).intValue();
    }
    synchronized (zzra)
    {
      zzra.zzbk = Long.valueOf(zzrc);
      return;
    }
  }
}
