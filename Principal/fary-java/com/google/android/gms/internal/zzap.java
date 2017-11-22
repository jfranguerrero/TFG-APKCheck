package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class zzap
{
  private static final ConditionVariable zzpD = new ConditionVariable();
  protected static volatile zzzf zzpE = null;
  private static volatile Random zzpG = null;
  private zzbc zzpC;
  protected Boolean zzpF;
  
  public zzap(zzbc paramZzbc)
  {
    zzpC = paramZzbc;
    zza(paramZzbc.zzaJ());
  }
  
  private static Random zzU()
  {
    if (zzpG == null) {}
    try
    {
      if (zzpG == null) {
        zzpG = new Random();
      }
      return zzpG;
    }
    finally {}
  }
  
  private void zza(Executor paramExecutor)
  {
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        if (zzpF != null) {
          return;
        }
        synchronized (zzap.zzV())
        {
          if (zzpF != null) {
            return;
          }
        }
        boolean bool = ((Boolean)zzfx.zzDf.get()).booleanValue();
        if (bool) {
          zzap.zzpE = new zzzf(zzap.zza(zzap.this).getContext(), "ADSHIELD", null);
        }
        zzpF = Boolean.valueOf(bool);
        zzap.zzV().open();
      }
    });
  }
  
  public int zzT()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return ThreadLocalRandom.current().nextInt();
      }
      int i = zzU().nextInt();
      return i;
    }
    catch (RuntimeException localRuntimeException) {}
    return zzU().nextInt();
  }
  
  public void zza(int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    try
    {
      zzpD.block();
      if ((zzpF.booleanValue()) && (zzpE != null) && (zzpC.zzaP()))
      {
        Object localObject = new zzae.zza();
        zzaR = zzpC.getContext().getPackageName();
        zzaS = Long.valueOf(paramLong);
        localObject = zzpE.zzm(zzbut.zzf((zzbut)localObject));
        ((zzzf.zza)localObject).zzco(paramInt2);
        ((zzzf.zza)localObject).zzcn(paramInt1);
        ((zzzf.zza)localObject).zze(zzpC.zzaN());
      }
      return;
    }
    catch (Exception localException) {}
  }
}
