package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class zzbn
  implements Callable
{
  private final zzbc zzpC;
  private final zzaf.zza zzra;
  
  public zzbn(zzbc paramZzbc, zzaf.zza paramZza)
  {
    zzpC = paramZzbc;
    zzra = paramZza;
  }
  
  public Void zzbl()
    throws Exception
  {
    if (zzpC.zzaT() != null) {
      zzpC.zzaT().get();
    }
    zzaf.zza localZza2 = zzpC.zzaS();
    if (localZza2 != null) {
      try
      {
        synchronized (zzra)
        {
          zzbut.zza(zzra, zzbut.zzf(localZza2));
        }
        return null;
      }
      catch (zzbus localZzbus) {}
    }
  }
}
