package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class zzbr
  extends zzby
{
  private List<Long> zzrd = null;
  
  public zzbr(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    zzra.zzbw = Long.valueOf(-1L);
    zzra.zzbx = Long.valueOf(-1L);
    if (zzrd == null) {
      zzrd = ((List)zzrj.invoke(null, new Object[] { zzpC.getContext() }));
    }
    if ((zzrd != null) && (zzrd.size() == 2)) {
      synchronized (zzra)
      {
        zzra.zzbw = Long.valueOf(((Long)zzrd.get(0)).longValue());
        zzra.zzbx = Long.valueOf(((Long)zzrd.get(1)).longValue());
        return;
      }
    }
  }
}
