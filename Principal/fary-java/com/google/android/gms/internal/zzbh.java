package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbh
  extends zzby
{
  private static volatile String zzqV = null;
  private static final Object zzqW = new Object();
  
  public zzbh(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzra.zzbv = "E";
    if (zzqV == null) {
      synchronized (zzqW)
      {
        if (zzqV == null) {
          zzqV = (String)zzrj.invoke(null, new Object[] { zzpC.getContext() });
        }
      }
    }
    synchronized (zzra)
    {
      zzra.zzbv = zzal.zza(zzqV.getBytes(), true);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}
