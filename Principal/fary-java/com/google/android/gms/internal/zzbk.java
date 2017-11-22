package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbk
  extends zzby
{
  private static volatile Long zzbH = null;
  private static final Object zzqW = new Object();
  
  public zzbk(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzbH == null) {
      synchronized (zzqW)
      {
        if (zzbH == null) {
          zzbH = (Long)zzrj.invoke(null, new Object[0]);
        }
      }
    }
    synchronized (zzra)
    {
      zzra.zzbH = zzbH;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}
