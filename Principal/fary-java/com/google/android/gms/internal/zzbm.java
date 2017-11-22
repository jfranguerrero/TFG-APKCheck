package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbm
  extends zzby
{
  public zzbm(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
  }
  
  private void zzbj()
    throws IllegalAccessException, InvocationTargetException
  {
    synchronized (zzra)
    {
      zzra.zzbV = ((String)zzrj.invoke(null, new Object[] { zzpC.getApplicationContext() }));
      return;
    }
  }
  
  private void zzbk()
  {
    ??? = zzpC.zzaZ();
    if (??? == null) {}
    for (;;)
    {
      return;
      try
      {
        AdvertisingIdClient.Info localInfo = ((AdvertisingIdClient)???).getInfo();
        String str = zzbe.zzr(localInfo.getId());
        if (str == null) {
          continue;
        }
        synchronized (zzra)
        {
          zzra.zzbV = str;
          zzra.zzbX = Boolean.valueOf(localInfo.isLimitAdTrackingEnabled());
          zzra.zzbW = Integer.valueOf(5);
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzpC.zzaO())
    {
      zzbk();
      return;
    }
    zzbj();
  }
}
