package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbv
  extends zzby
{
  public zzbv(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzra.zzbJ = Integer.valueOf(2);
    boolean bool = ((Boolean)zzrj.invoke(null, new Object[] { zzpC.getApplicationContext() })).booleanValue();
    localZza = zzra;
    if (bool == true) {}
    for (;;)
    {
      try
      {
        zzra.zzbJ = Integer.valueOf(1);
        return;
      }
      finally {}
      zzra.zzbJ = Integer.valueOf(0);
    }
  }
}
