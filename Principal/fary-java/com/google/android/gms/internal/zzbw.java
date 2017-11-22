package com.google.android.gms.internal;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class zzbw
  extends zzby
{
  private final View zzrg;
  
  public zzbw(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2, View paramView)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
    zzrg = paramView;
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzrg != null)
    {
      zzbf localZzbf = new zzbf((String)zzrj.invoke(null, new Object[] { zzrg }));
      synchronized (zzra)
      {
        zzra.zzbT = new zzaf.zza.zzb();
        zzra.zzbT.zzcm = zzqU;
        return;
      }
    }
  }
}
