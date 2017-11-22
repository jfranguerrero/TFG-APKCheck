package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class zzat
  extends zzar
{
  private static final String TAG;
  private static long startTime = 0L;
  protected static volatile zzbc zzpC;
  protected static final Object zzpV = new Object();
  static boolean zzpW;
  protected boolean zzpX = false;
  protected String zzpY;
  protected boolean zzpZ = false;
  protected boolean zzqa = false;
  
  static
  {
    TAG = zzat.class.getSimpleName();
    zzpC = null;
    zzpW = false;
  }
  
  protected zzat(Context paramContext, String paramString)
  {
    super(paramContext);
    zzpY = paramString;
    zzpX = false;
  }
  
  protected zzat(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext);
    zzpY = paramString;
    zzpX = paramBoolean;
  }
  
  static zzbd zza(zzbc paramZzbc, MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws zzaz
  {
    paramZzbc = paramZzbc.zzc(zzay.zzaD(), zzay.zzaE());
    if ((paramZzbc == null) || (paramMotionEvent == null)) {
      throw new zzaz();
    }
    try
    {
      paramZzbc = new zzbd((String)paramZzbc.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics }));
      return paramZzbc;
    }
    catch (IllegalAccessException paramZzbc)
    {
      throw new zzaz(paramZzbc);
    }
    catch (InvocationTargetException paramZzbc)
    {
      for (;;) {}
    }
  }
  
  protected static void zza(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (!zzpW)
      {
        startTime = zzbe.zzbc().longValue() / 1000L;
        zzpC = zzb(paramContext, paramBoolean);
        zzpW = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void zza(zzbc paramZzbc)
  {
    List localList = Collections.singletonList(Context.class);
    paramZzbc.zza(zzay.zzaj(), zzay.zzak(), localList);
    paramZzbc.zza(zzay.zzat(), zzay.zzau(), localList);
    paramZzbc.zza(zzay.zzar(), zzay.zzas(), localList);
    paramZzbc.zza(zzay.zzad(), zzay.zzae(), localList);
    paramZzbc.zza(zzay.zzan(), zzay.zzao(), localList);
    paramZzbc.zza(zzay.zzZ(), zzay.zzaa(), localList);
    paramZzbc.zza(zzay.zzaF(), zzay.zzaG(), localList);
    localList = Arrays.asList(new Class[] { MotionEvent.class, DisplayMetrics.class });
    paramZzbc.zza(zzay.zzaD(), zzay.zzaE(), localList);
    paramZzbc.zza(zzay.zzaB(), zzay.zzaC(), localList);
    paramZzbc.zza(zzay.zzah(), zzay.zzai(), Collections.emptyList());
    paramZzbc.zza(zzay.zzaz(), zzay.zzaA(), Collections.emptyList());
    paramZzbc.zza(zzay.zzap(), zzay.zzaq(), Collections.emptyList());
    paramZzbc.zza(zzay.zzaf(), zzay.zzag(), Collections.emptyList());
    paramZzbc.zza(zzay.zzal(), zzay.zzam(), Collections.emptyList());
    paramZzbc.zza(zzay.zzax(), zzay.zzay(), Collections.emptyList());
    localList = Arrays.asList(new Class[] { Context.class, Boolean.TYPE, Boolean.TYPE });
    paramZzbc.zza(zzay.zzab(), zzay.zzac(), localList);
    localList = Arrays.asList(new Class[] { [Ljava.lang.StackTraceElement.class });
    paramZzbc.zza(zzay.zzav(), zzay.zzaw(), localList);
    localList = Arrays.asList(new Class[] { View.class });
    paramZzbc.zza(zzay.zzaH(), zzay.zzaI(), localList);
  }
  
  private void zza(zzbc paramZzbc, zzaf.zza paramZza)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        localObject = zza(paramZzbc, zzpI, zzpT);
        zzbm = zzqM;
        zzbn = zzqN;
        zzbo = zzqO;
        if (zzpS)
        {
          zzbA = zzce;
          zzbB = zzcc;
        }
        if ((((Boolean)zzfx.zzDq.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue()))
        {
          localZza = new zzaf.zza.zza();
          zzbd localZzbd = zzb(zzpI);
          zzbm = zzqM;
          zzbn = zzqN;
          zzch = zzqO;
          if (zzpS)
          {
            zzcc = zzcc;
            zzce = zzce;
            if (zzqP.longValue() == 0L) {
              continue;
            }
            i = 1;
            zzcg = Integer.valueOf(i);
            if (zzpL > 0L)
            {
              if (zzpT == null) {
                continue;
              }
              localObject = Long.valueOf(Math.round(zzpQ / zzpL));
              zzcd = ((Long)localObject);
              zzcf = Long.valueOf(Math.round(zzpP / zzpL));
            }
            zzcj = zzcj;
            zzci = zzci;
            if (zzqS.longValue() == 0L) {
              continue;
            }
            i = 1;
            zzck = Integer.valueOf(i);
            if (zzpO > 0L) {
              zzcl = Long.valueOf(zzpO);
            }
          }
          zzbR = localZza;
        }
      }
      catch (zzaz localZzaz)
      {
        Object localObject;
        zzaf.zza.zza localZza;
        int i;
        continue;
      }
      if (zzpK > 0L) {
        zzbF = Long.valueOf(zzpK);
      }
      if (zzpL > 0L) {
        zzbE = Long.valueOf(zzpL);
      }
      if (zzpM > 0L) {
        zzbD = Long.valueOf(zzpM);
      }
      if (zzpN > 0L) {
        zzbG = Long.valueOf(zzpN);
      }
      try
      {
        int k = zzpJ.size() - 1;
        if (k <= 0) {
          continue;
        }
        zzbS = new zzaf.zza.zza[k];
        i = j;
        if (i >= k) {
          continue;
        }
        localObject = zza(paramZzbc, (MotionEvent)zzpJ.get(i), zzpT);
        localZza = new zzaf.zza.zza();
        zzbm = zzqM;
        zzbn = zzqN;
        zzbS[i] = localZza;
        i += 1;
        continue;
        i = 0;
      }
      catch (zzaz paramZzbc)
      {
        zzbS = null;
      }
      localObject = null;
      continue;
      i = 0;
    }
  }
  
  protected static zzbc zzb(Context paramContext, boolean paramBoolean)
  {
    if (zzpC == null) {}
    synchronized (zzpV)
    {
      if (zzpC == null)
      {
        paramContext = zzbc.zza(paramContext, zzay.getKey(), zzay.zzY(), paramBoolean);
        zza(paramContext);
        zzpC = paramContext;
      }
      return zzpC;
    }
  }
  
  protected long zza(StackTraceElement[] paramArrayOfStackTraceElement)
    throws zzaz
  {
    Method localMethod = zzpC.zzc(zzay.zzav(), zzay.zzaw());
    if ((localMethod == null) || (paramArrayOfStackTraceElement == null)) {
      throw new zzaz();
    }
    try
    {
      long l = zzbainvokezzqm.longValue();
      return l;
    }
    catch (IllegalAccessException paramArrayOfStackTraceElement)
    {
      throw new zzaz(paramArrayOfStackTraceElement);
    }
    catch (InvocationTargetException paramArrayOfStackTraceElement)
    {
      for (;;) {}
    }
  }
  
  protected zzaf.zza zza(Context paramContext, View paramView)
  {
    zzaf.zza localZza = new zzaf.zza();
    if (!TextUtils.isEmpty(zzpY)) {
      zzaZ = zzpY;
    }
    paramContext = zzb(paramContext, zzpX);
    paramContext.zzba();
    zzb(paramContext, localZza, paramView);
    paramContext.zzbb();
    return localZza;
  }
  
  protected zzaf.zza zza(Context paramContext, zzad.zza paramZza)
  {
    zzaf.zza localZza = new zzaf.zza();
    if (!TextUtils.isEmpty(zzpY)) {
      zzaZ = zzpY;
    }
    paramContext = zzb(paramContext, zzpX);
    paramContext.zzba();
    zza(paramContext, localZza, paramZza);
    paramContext.zzbb();
    return localZza;
  }
  
  protected List<Callable<Void>> zza(zzbc paramZzbc, zzaf.zza paramZza, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramZzbc.zzaJ() == null) {
      return localArrayList;
    }
    int i = paramZzbc.zzT();
    localArrayList.add(new zzbn(paramZzbc, paramZza));
    localArrayList.add(new zzbq(paramZzbc, zzay.zzap(), zzay.zzaq(), paramZza, i, 1));
    localArrayList.add(new zzbl(paramZzbc, zzay.zzah(), zzay.zzai(), paramZza, startTime, i, 25));
    localArrayList.add(new zzbk(paramZzbc, zzay.zzaf(), zzay.zzag(), paramZza, i, 44));
    localArrayList.add(new zzbg(paramZzbc, zzay.zzZ(), zzay.zzaa(), paramZza, i, 3));
    localArrayList.add(new zzbo(paramZzbc, zzay.zzal(), zzay.zzam(), paramZza, i, 22));
    if ((((Boolean)zzfx.zzDw.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
      localArrayList.add(new zzbj(paramZzbc, zzay.zzad(), zzay.zzae(), paramZza, i, 5));
    }
    if ((((Boolean)zzfx.zzDp.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
      localArrayList.add(new zzbv(paramZzbc, zzay.zzaF(), zzay.zzaG(), paramZza, i, 48));
    }
    if ((((Boolean)zzfx.zzDu.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
      localArrayList.add(new zzbt(paramZzbc, zzay.zzax(), zzay.zzay(), paramZza, i, 51));
    }
    if ((((Boolean)zzfx.zzDz.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
      localArrayList.add(new zzbs(paramZzbc, zzay.zzav(), zzay.zzaw(), paramZza, i, 45, new Throwable().getStackTrace()));
    }
    if (((Boolean)zzfx.zzDA.get()).booleanValue()) {
      localArrayList.add(new zzbw(paramZzbc, zzay.zzaH(), zzay.zzaI(), paramZza, i, 57, paramView));
    }
    return localArrayList;
  }
  
  protected void zza(zzbc paramZzbc, zzaf.zza paramZza, zzad.zza paramZza1)
  {
    if (paramZzbc.zzaJ() == null) {
      return;
    }
    zza(zzb(paramZzbc, paramZza, paramZza1));
  }
  
  protected void zza(List<Callable<Void>> paramList)
  {
    if (zzpC == null) {}
    ExecutorService localExecutorService;
    do
    {
      return;
      localExecutorService = zzpC.zzaJ();
    } while ((localExecutorService == null) || (paramList.isEmpty()));
    try
    {
      localExecutorService.invokeAll(paramList, ((Long)zzfx.zzDg.get()).longValue(), TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramList)
    {
      Log.d(TAG, String.format("class methods got exception: %s", new Object[] { zzbe.zza(paramList) }));
    }
  }
  
  protected zzbd zzb(MotionEvent paramMotionEvent)
    throws zzaz
  {
    Method localMethod = zzpC.zzc(zzay.zzaB(), zzay.zzaC());
    if ((localMethod == null) || (paramMotionEvent == null)) {
      throw new zzaz();
    }
    try
    {
      paramMotionEvent = new zzbd((String)localMethod.invoke(null, new Object[] { paramMotionEvent, zzpT }));
      return paramMotionEvent;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      throw new zzaz(paramMotionEvent);
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      for (;;) {}
    }
  }
  
  protected List<Callable<Void>> zzb(zzbc paramZzbc, zzaf.zza paramZza, zzad.zza paramZza1)
  {
    int i = paramZzbc.zzT();
    ArrayList localArrayList = new ArrayList();
    String str1 = zzay.zzab();
    String str2 = zzay.zzac();
    if ((((Boolean)zzfx.zzDk.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      localArrayList.add(new zzbi(paramZzbc, str1, str2, paramZza, i, 27, bool, paramZza1));
      localArrayList.add(new zzbl(paramZzbc, zzay.zzah(), zzay.zzai(), paramZza, startTime, i, 25));
      localArrayList.add(new zzbq(paramZzbc, zzay.zzap(), zzay.zzaq(), paramZza, i, 1));
      localArrayList.add(new zzbr(paramZzbc, zzay.zzar(), zzay.zzas(), paramZza, i, 31));
      localArrayList.add(new zzbu(paramZzbc, zzay.zzaz(), zzay.zzaA(), paramZza, i, 33));
      localArrayList.add(new zzbh(paramZzbc, zzay.zzat(), zzay.zzau(), paramZza, i, 29));
      localArrayList.add(new zzbj(paramZzbc, zzay.zzad(), zzay.zzae(), paramZza, i, 5));
      localArrayList.add(new zzbp(paramZzbc, zzay.zzan(), zzay.zzao(), paramZza, i, 12));
      localArrayList.add(new zzbg(paramZzbc, zzay.zzZ(), zzay.zzaa(), paramZza, i, 3));
      localArrayList.add(new zzbk(paramZzbc, zzay.zzaf(), zzay.zzag(), paramZza, i, 44));
      localArrayList.add(new zzbo(paramZzbc, zzay.zzal(), zzay.zzam(), paramZza, i, 22));
      if ((((Boolean)zzfx.zzDn.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
        localArrayList.add(new zzbv(paramZzbc, zzay.zzaF(), zzay.zzaG(), paramZza, i, 48));
      }
      if ((((Boolean)zzfx.zzDs.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
        localArrayList.add(new zzbt(paramZzbc, zzay.zzax(), zzay.zzay(), paramZza, i, 51));
      }
      return localArrayList;
    }
  }
  
  protected void zzb(zzbc paramZzbc, zzaf.zza paramZza, View paramView)
  {
    zza(paramZzbc, paramZza);
    zza(zza(paramZzbc, paramZza, paramView));
  }
}
