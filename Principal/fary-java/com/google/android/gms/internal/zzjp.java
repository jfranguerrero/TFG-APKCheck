package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzmb
public class zzjp
  implements zzjh
{
  private final Context mContext;
  private final zzmh zzKG;
  private final long zzKH;
  private final long zzKI;
  private final int zzKJ;
  private boolean zzKK = false;
  private final Map<zzqf<zzjn>, zzjm> zzKL = new HashMap();
  private List<zzjn> zzKM = new ArrayList();
  private final zzjj zzKq;
  private final boolean zzKs;
  private final Object zzrN = new Object();
  private final zzjs zzsD;
  private final boolean zzvW;
  
  public zzjp(Context paramContext, zzmh paramZzmh, zzjs paramZzjs, zzjj paramZzjj, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt)
  {
    mContext = paramContext;
    zzKG = paramZzmh;
    zzsD = paramZzjs;
    zzKq = paramZzjj;
    zzvW = paramBoolean1;
    zzKs = paramBoolean2;
    zzKH = paramLong1;
    zzKI = paramLong2;
    zzKJ = paramInt;
  }
  
  private void zza(final zzqf<zzjn> paramZzqf)
  {
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = zzjp.zze(zzjp.this).keySet().iterator();
        while (localIterator.hasNext())
        {
          zzqf localZzqf = (zzqf)localIterator.next();
          if (localZzqf != paramZzqf) {
            ((zzjm)zzjp.zze(zzjp.this).get(localZzqf)).cancel();
          }
        }
      }
    });
  }
  
  private zzjn zze(List<zzqf<zzjn>> paramList)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzKK)
        {
          paramList = new zzjn(-1);
          return paramList;
        }
        ??? = paramList.iterator();
        if (((Iterator)???).hasNext()) {
          paramList = (zzqf)((Iterator)???).next();
        }
      }
      try
      {
        zzjn localZzjn = (zzjn)paramList.get();
        zzKM.add(localZzjn);
        if ((localZzjn == null) || (zzKz != 0)) {
          continue;
        }
        zza(paramList);
        return localZzjn;
      }
      catch (InterruptedException paramList)
      {
        zzpe.zzc("Exception while processing an adapter; continuing with other adapters", paramList);
        continue;
        paramList = finally;
        throw paramList;
        zza(null);
        return new zzjn(1);
      }
      catch (ExecutionException paramList)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  private zzjn zzf(List<zzqf<zzjn>> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/google/android/gms/internal/zzjp:zzrN	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 45	com/google/android/gms/internal/zzjp:zzKK	Z
    //   13: ifeq +17 -> 30
    //   16: new 107	com/google/android/gms/internal/zzjn
    //   19: dup
    //   20: iconst_m1
    //   21: invokespecial 110	com/google/android/gms/internal/zzjn:<init>	(I)V
    //   24: astore_1
    //   25: aload 8
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload 8
    //   32: monitorexit
    //   33: iconst_m1
    //   34: istore_2
    //   35: aconst_null
    //   36: astore 8
    //   38: aconst_null
    //   39: astore 9
    //   41: aload_0
    //   42: getfield 63	com/google/android/gms/internal/zzjp:zzKq	Lcom/google/android/gms/internal/zzjj;
    //   45: getfield 159	com/google/android/gms/internal/zzjj:zzKi	J
    //   48: ldc2_w 160
    //   51: lcmp
    //   52: ifeq +170 -> 222
    //   55: aload_0
    //   56: getfield 63	com/google/android/gms/internal/zzjp:zzKq	Lcom/google/android/gms/internal/zzjj;
    //   59: getfield 159	com/google/android/gms/internal/zzjj:zzKi	J
    //   62: lstore 4
    //   64: aload_1
    //   65: invokeinterface 116 1 0
    //   70: astore 11
    //   72: aload 11
    //   74: invokeinterface 122 1 0
    //   79: ifeq +225 -> 304
    //   82: aload 11
    //   84: invokeinterface 126 1 0
    //   89: checkcast 128	com/google/android/gms/internal/zzqf
    //   92: astore 10
    //   94: invokestatic 167	com/google/android/gms/ads/internal/zzv:zzcP	()Lcom/google/android/gms/common/util/zze;
    //   97: invokeinterface 173 1 0
    //   102: lstore 6
    //   104: lload 4
    //   106: lconst_0
    //   107: lcmp
    //   108: ifne +122 -> 230
    //   111: aload 10
    //   113: invokeinterface 176 1 0
    //   118: ifeq +112 -> 230
    //   121: aload 10
    //   123: invokeinterface 131 1 0
    //   128: checkcast 107	com/google/android/gms/internal/zzjn
    //   131: astore_1
    //   132: aload_0
    //   133: getfield 55	com/google/android/gms/internal/zzjp:zzKM	Ljava/util/List;
    //   136: aload_1
    //   137: invokeinterface 135 2 0
    //   142: pop
    //   143: aload_1
    //   144: ifnull +192 -> 336
    //   147: aload_1
    //   148: getfield 138	com/google/android/gms/internal/zzjn:zzKz	I
    //   151: ifne +185 -> 336
    //   154: aload_1
    //   155: getfield 180	com/google/android/gms/internal/zzjn:zzKE	Lcom/google/android/gms/internal/zzjv;
    //   158: astore 12
    //   160: aload 12
    //   162: ifnull +174 -> 336
    //   165: aload 12
    //   167: invokeinterface 186 1 0
    //   172: iload_2
    //   173: if_icmple +163 -> 336
    //   176: aload 12
    //   178: invokeinterface 186 1 0
    //   183: istore_3
    //   184: iload_3
    //   185: istore_2
    //   186: aload 10
    //   188: astore 8
    //   190: lload 4
    //   192: invokestatic 167	com/google/android/gms/ads/internal/zzv:zzcP	()Lcom/google/android/gms/common/util/zze;
    //   195: invokeinterface 173 1 0
    //   200: lload 6
    //   202: lsub
    //   203: lsub
    //   204: lconst_0
    //   205: invokestatic 192	java/lang/Math:max	(JJ)J
    //   208: lstore 4
    //   210: aload_1
    //   211: astore 9
    //   213: goto -141 -> 72
    //   216: astore_1
    //   217: aload 8
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: ldc2_w 193
    //   225: lstore 4
    //   227: goto -163 -> 64
    //   230: aload 10
    //   232: lload 4
    //   234: getstatic 200	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   237: invokeinterface 203 4 0
    //   242: checkcast 107	com/google/android/gms/internal/zzjn
    //   245: astore_1
    //   246: goto -114 -> 132
    //   249: astore_1
    //   250: ldc -114
    //   252: aload_1
    //   253: invokestatic 147	com/google/android/gms/internal/zzpe:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: lload 4
    //   258: invokestatic 167	com/google/android/gms/ads/internal/zzv:zzcP	()Lcom/google/android/gms/common/util/zze;
    //   261: invokeinterface 173 1 0
    //   266: lload 6
    //   268: lsub
    //   269: lsub
    //   270: lconst_0
    //   271: invokestatic 192	java/lang/Math:max	(JJ)J
    //   274: lstore 4
    //   276: aload 9
    //   278: astore_1
    //   279: goto -69 -> 210
    //   282: astore_1
    //   283: lload 4
    //   285: invokestatic 167	com/google/android/gms/ads/internal/zzv:zzcP	()Lcom/google/android/gms/common/util/zze;
    //   288: invokeinterface 173 1 0
    //   293: lload 6
    //   295: lsub
    //   296: lsub
    //   297: lconst_0
    //   298: invokestatic 192	java/lang/Math:max	(JJ)J
    //   301: pop2
    //   302: aload_1
    //   303: athrow
    //   304: aload_0
    //   305: aload 8
    //   307: invokespecial 140	com/google/android/gms/internal/zzjp:zza	(Lcom/google/android/gms/internal/zzqf;)V
    //   310: aload 9
    //   312: ifnonnull +30 -> 342
    //   315: new 107	com/google/android/gms/internal/zzjn
    //   318: dup
    //   319: iconst_1
    //   320: invokespecial 110	com/google/android/gms/internal/zzjn:<init>	(I)V
    //   323: areturn
    //   324: astore_1
    //   325: goto -75 -> 250
    //   328: astore_1
    //   329: goto -79 -> 250
    //   332: astore_1
    //   333: goto -83 -> 250
    //   336: aload 9
    //   338: astore_1
    //   339: goto -149 -> 190
    //   342: aload 9
    //   344: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	zzjp
    //   0	345	1	paramList	List<zzqf<zzjn>>
    //   34	152	2	i	int
    //   183	2	3	j	int
    //   62	222	4	l1	long
    //   102	192	6	l2	long
    //   4	302	8	localObject	Object
    //   39	304	9	localList	List<zzqf<zzjn>>
    //   92	139	10	localZzqf	zzqf
    //   70	13	11	localIterator	Iterator
    //   158	19	12	localZzjv	zzjv
    // Exception table:
    //   from	to	target	type
    //   9	28	216	finally
    //   30	33	216	finally
    //   217	220	216	finally
    //   111	132	249	android/os/RemoteException
    //   132	143	249	android/os/RemoteException
    //   147	160	249	android/os/RemoteException
    //   165	184	249	android/os/RemoteException
    //   230	246	249	android/os/RemoteException
    //   111	132	282	finally
    //   132	143	282	finally
    //   147	160	282	finally
    //   165	184	282	finally
    //   230	246	282	finally
    //   250	256	282	finally
    //   111	132	324	java/lang/InterruptedException
    //   132	143	324	java/lang/InterruptedException
    //   147	160	324	java/lang/InterruptedException
    //   165	184	324	java/lang/InterruptedException
    //   230	246	324	java/lang/InterruptedException
    //   111	132	328	java/util/concurrent/ExecutionException
    //   132	143	328	java/util/concurrent/ExecutionException
    //   147	160	328	java/util/concurrent/ExecutionException
    //   165	184	328	java/util/concurrent/ExecutionException
    //   230	246	328	java/util/concurrent/ExecutionException
    //   111	132	332	java/util/concurrent/TimeoutException
    //   132	143	332	java/util/concurrent/TimeoutException
    //   147	160	332	java/util/concurrent/TimeoutException
    //   165	184	332	java/util/concurrent/TimeoutException
    //   230	246	332	java/util/concurrent/TimeoutException
  }
  
  public void cancel()
  {
    synchronized (zzrN)
    {
      zzKK = true;
      Iterator localIterator = zzKL.values().iterator();
      if (localIterator.hasNext()) {
        ((zzjm)localIterator.next()).cancel();
      }
    }
  }
  
  public zzjn zzd(List<zzji> paramList)
  {
    zzpe.zzbc("Starting mediation.");
    ExecutorService localExecutorService = Executors.newCachedThreadPool();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      zzji localZzji = (zzji)localIterator.next();
      paramList = String.valueOf(zzJH);
      if (paramList.length() != 0) {}
      for (paramList = "Trying mediation network: ".concat(paramList);; paramList = new String("Trying mediation network: "))
      {
        zzpe.zzbd(paramList);
        paramList = zzJI.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (String)paramList.next();
          localObject = new zzjm(mContext, (String)localObject, zzsD, zzKq, localZzji, zzKG.zzRd, zzKG.zzvj, zzKG.zzvf, zzvW, zzKs, zzKG.zzvx, zzKG.zzvB);
          zzqf localZzqf = zzph.zza(localExecutorService, new Callable()
          {
            public zzjn zzgI()
              throws Exception
            {
              synchronized (zzjp.zza(zzjp.this))
              {
                if (zzjp.zzb(zzjp.this)) {
                  return null;
                }
                return zzKN.zza(zzjp.zzc(zzjp.this), zzjp.zzd(zzjp.this));
              }
            }
          });
          zzKL.put(localZzqf, localObject);
          localArrayList.add(localZzqf);
        }
        break;
      }
    }
    switch (zzKJ)
    {
    default: 
      return zze(localArrayList);
    }
    return zzf(localArrayList);
  }
  
  public List<zzjn> zzgB()
  {
    return zzKM;
  }
}
