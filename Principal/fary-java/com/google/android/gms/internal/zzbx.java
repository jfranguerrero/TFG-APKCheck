package com.google.android.gms.internal;

import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class zzbx
{
  protected static final String TAG = zzbx.class.getSimpleName();
  private final String className;
  private final zzbc zzpC;
  private final String zzrh;
  private final int zzri = 2;
  private volatile Method zzrj = null;
  private List<Class> zzrk;
  private CountDownLatch zzrl = new CountDownLatch(1);
  
  public zzbx(zzbc paramZzbc, String paramString1, String paramString2, List<Class> paramList)
  {
    zzpC = paramZzbc;
    className = paramString1;
    zzrh = paramString2;
    zzrk = new ArrayList(paramList);
    zzpC.zzaJ().submit(new Runnable()
    {
      public void run()
      {
        zzbx.zza(zzbx.this);
      }
    });
  }
  
  private void zzbm()
  {
    try
    {
      Object localObject1 = zzpC.zzaK().loadClass(zzd(zzpC.zzaM(), className));
      if (localObject1 == null) {
        return;
      }
      zzrj = ((Class)localObject1).getMethod(zzd(zzpC.zzaM(), zzrh), (Class[])zzrk.toArray(new Class[zzrk.size()]));
      localObject1 = zzrj;
      if (localObject1 == null) {
        return;
      }
      return;
    }
    catch (zzax.zza localZza) {}catch (UnsupportedEncodingException localUnsupportedEncodingException) {}catch (ClassNotFoundException localClassNotFoundException) {}catch (NoSuchMethodException localNoSuchMethodException) {}catch (NullPointerException localNullPointerException) {}finally
    {
      zzrl.countDown();
    }
  }
  
  private String zzd(byte[] paramArrayOfByte, String paramString)
    throws zzax.zza, UnsupportedEncodingException
  {
    return new String(zzpC.zzaL().zzc(paramArrayOfByte, paramString), "UTF-8");
  }
  
  public Method zzbn()
  {
    Method localMethod = null;
    if (zzrj != null) {
      localMethod = zzrj;
    }
    for (;;)
    {
      return localMethod;
      try
      {
        if (zzrl.await(2L, TimeUnit.SECONDS))
        {
          localMethod = zzrj;
          return localMethod;
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
    return null;
  }
}
