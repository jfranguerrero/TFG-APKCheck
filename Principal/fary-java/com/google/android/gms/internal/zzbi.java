package com.google.android.gms.internal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class zzbi
  extends zzby
{
  private static final Object zzqW = new Object();
  private static volatile zzam zzqX = null;
  private boolean zzqY = false;
  private zzad.zza zzqZ = null;
  
  public zzbi(zzbc paramZzbc, String paramString1, String paramString2, zzaf.zza paramZza, int paramInt1, int paramInt2, boolean paramBoolean, zzad.zza paramZza1)
  {
    super(paramZzbc, paramString1, paramString2, paramZza, paramInt1, paramInt2);
    zzqY = paramBoolean;
    zzqZ = paramZza1;
  }
  
  public static Boolean zza(zzad.zza paramZza)
  {
    boolean bool2 = false;
    if (!zzbe.zzs(zzb(paramZza))) {
      return Boolean.valueOf(false);
    }
    boolean bool1 = bool2;
    if (paramZza != null)
    {
      bool1 = bool2;
      if (zzaJ != null)
      {
        bool1 = bool2;
        if (zzaJ.zzaL.intValue() == 3) {
          bool1 = true;
        }
      }
    }
    return Boolean.valueOf(bool1);
  }
  
  public static String zzb(zzad.zza paramZza)
  {
    if ((paramZza != null) && (zzaK != null) && (!zzbe.zzs(zzaK.zzaM))) {
      return zzaK.zzaM;
    }
    return null;
  }
  
  private boolean zzbf()
  {
    return (zzqX == null) || (zzbe.zzs(zzqXzzaM)) || (zzqXzzaM.equals("E"));
  }
  
  private int zzbg()
  {
    if (!zzbe.zzs(zzb(zzqZ))) {
      return 4;
    }
    if ((zza(zzqZ).booleanValue()) && (zzbh())) {
      return 3;
    }
    return 2;
  }
  
  private boolean zzbh()
  {
    return (zzpC.zzaR()) && (((Boolean)zzfx.zzDF.get()).booleanValue()) && (((Boolean)zzfx.zzDG.get()).booleanValue()) && (((Boolean)zzfx.zzDD.get()).booleanValue());
  }
  
  private String zzbi()
  {
    try
    {
      if (zzpC.zzaT() != null) {
        zzpC.zzaT().get();
      }
      Object localObject = zzpC.zzaS();
      if ((localObject != null) && (zzaM != null))
      {
        localObject = zzaM;
        return localObject;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
  }
  
  private void zze(int paramInt)
    throws IllegalAccessException, InvocationTargetException
  {
    boolean bool1 = true;
    Object localObject = zzrj;
    Context localContext = zzpC.getContext();
    boolean bool2 = zzqY;
    if (paramInt == 2)
    {
      zzqX = new zzam((String)((Method)localObject).invoke(null, new Object[] { localContext, Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      if ((zzbe.zzs(zzqXzzaM)) || (zzqXzzaM.equals("E"))) {
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      zzqXzzaM = zzqZ.zzaK.zzaM;
      return;
      localObject = zzbi();
    } while (zzbe.zzs((String)localObject));
    zzqXzzaM = ((String)localObject);
  }
  
  protected void zzbe()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzbf()) {
      synchronized (zzqW)
      {
        int i = zzbg();
        if (i == 3) {
          zzpC.zzaW();
        }
        zze(i);
      }
    }
    synchronized (zzra)
    {
      if (zzqX != null)
      {
        zzra.zzaM = zzqXzzaM;
        zzra.zzbz = Long.valueOf(zzqXzzlH);
        zzra.zzaO = zzqXzzaO;
        if (zzqY)
        {
          zzra.zzaP = zzqXzzaP;
          zzra.zzaQ = zzqXzzaQ;
        }
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}
