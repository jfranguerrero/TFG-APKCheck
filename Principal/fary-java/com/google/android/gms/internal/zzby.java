package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzby
  implements Callable
{
  protected final String TAG = getClass().getSimpleName();
  protected final String className;
  protected final zzbc zzpC;
  protected final zzaf.zza zzra;
  protected final String zzrh;
  protected Method zzrj;
  protected final int zzrn;
  protected final int zzro;
  
  public zzby(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    zzpC = paramZzbc;
    className = paramString1;
    zzrh = paramString2;
    zzra = paramZza;
    zzrn = paramInt1;
    zzro = paramInt2;
  }
  
  protected abstract void zzbe()
    throws IllegalAccessException, InvocationTargetException;
  
  public Void zzbl()
    throws Exception
  {
    try
    {
      long l = System.nanoTime();
      zzrj = zzpC.zzc(className, zzrh);
      if (zzrj == null) {
        return null;
      }
      zzbe();
      zzap localZzap = zzpC.zzaQ();
      if ((localZzap != null) && (zzrn != Integer.MIN_VALUE))
      {
        localZzap.zza(zzro, zzrn, (System.nanoTime() - l) / 1000L);
        return null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException) {}
    return null;
  }
}
