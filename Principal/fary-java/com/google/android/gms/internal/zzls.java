package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Future;

@zzmb
public class zzls
  extends zzpd
{
  private final zzlu zzPP;
  private Future<zzov> zzPQ;
  private final zzln.zza zzPn;
  private final zzov.zza zzPo;
  private final zzmk zzPp;
  private final Object zzrN = new Object();
  
  public zzls(Context paramContext, zzr paramZzr, zzov.zza paramZza, zzav paramZzav, zzln.zza paramZza1, zzgf paramZzgf)
  {
    this(paramZza, paramZza1, new zzlu(paramContext, paramZzr, new zzpp(paramContext), paramZzav, paramZza, paramZzgf));
  }
  
  zzls(zzov.zza paramZza, zzln.zza paramZza1, zzlu paramZzlu)
  {
    zzPo = paramZza;
    zzPp = zzVB;
    zzPn = paramZza1;
    zzPP = paramZzlu;
  }
  
  private zzov zzQ(int paramInt)
  {
    return new zzov(zzPo.zzSF.zzRd, null, null, paramInt, null, null, zzPp.orientation, zzPp.zzKe, zzPo.zzSF.zzRg, false, null, null, null, null, null, zzPp.zzRL, zzPo.zzvj, zzPp.zzRJ, zzPo.zzVv, zzPp.zzRO, zzPp.zzRP, zzPo.zzVp, null, null, null, null, zzPo.zzVB.zzSc, zzPo.zzVB.zzSd, null, null, zzPp.zzSg);
  }
  
  public void onStop()
  {
    synchronized (zzrN)
    {
      if (zzPQ != null) {
        zzPQ.cancel(true);
      }
      return;
    }
  }
  
  /* Error */
  public void zzcm()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/google/android/gms/internal/zzls:zzrN	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 57	com/google/android/gms/internal/zzls:zzPP	Lcom/google/android/gms/internal/zzlu;
    //   12: invokestatic 147	com/google/android/gms/internal/zzph:zza	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/internal/zzqf;
    //   15: putfield 127	com/google/android/gms/internal/zzls:zzPQ	Ljava/util/concurrent/Future;
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: getfield 127	com/google/android/gms/internal/zzls:zzPQ	Ljava/util/concurrent/Future;
    //   24: ldc2_w 148
    //   27: getstatic 155	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   30: invokeinterface 159 4 0
    //   35: checkcast 61	com/google/android/gms/internal/zzov
    //   38: astore_2
    //   39: bipush -2
    //   41: istore_1
    //   42: aload_2
    //   43: ifnull +73 -> 116
    //   46: getstatic 165	com/google/android/gms/internal/zzpi:zzWR	Landroid/os/Handler;
    //   49: new 6	com/google/android/gms/internal/zzls$1
    //   52: dup
    //   53: aload_0
    //   54: aload_2
    //   55: invokespecial 168	com/google/android/gms/internal/zzls$1:<init>	(Lcom/google/android/gms/internal/zzls;Lcom/google/android/gms/internal/zzov;)V
    //   58: invokevirtual 174	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   61: pop
    //   62: return
    //   63: astore_3
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    //   68: astore_2
    //   69: ldc -80
    //   71: invokestatic 182	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 127	com/google/android/gms/internal/zzls:zzPQ	Ljava/util/concurrent/Future;
    //   78: iconst_1
    //   79: invokeinterface 133 2 0
    //   84: pop
    //   85: iconst_2
    //   86: istore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: goto -47 -> 42
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_2
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -55 -> 42
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_2
    //   103: iconst_0
    //   104: istore_1
    //   105: goto -63 -> 42
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_2
    //   111: iconst_0
    //   112: istore_1
    //   113: goto -71 -> 42
    //   116: aload_0
    //   117: iload_1
    //   118: invokespecial 184	com/google/android/gms/internal/zzls:zzQ	(I)Lcom/google/android/gms/internal/zzov;
    //   121: astore_2
    //   122: goto -76 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	zzls
    //   41	77	1	i	int
    //   68	1	2	localTimeoutException	java.util.concurrent.TimeoutException
    //   88	1	2	localObject2	Object
    //   92	1	2	localExecutionException	java.util.concurrent.ExecutionException
    //   94	1	2	localObject3	Object
    //   100	1	2	localInterruptedException	InterruptedException
    //   102	1	2	localObject4	Object
    //   108	1	2	localCancellationException	java.util.concurrent.CancellationException
    //   110	12	2	localZzov	zzov
    //   63	4	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	63	finally
    //   64	66	63	finally
    //   0	7	68	java/util/concurrent/TimeoutException
    //   20	39	68	java/util/concurrent/TimeoutException
    //   66	68	68	java/util/concurrent/TimeoutException
    //   0	7	92	java/util/concurrent/ExecutionException
    //   20	39	92	java/util/concurrent/ExecutionException
    //   66	68	92	java/util/concurrent/ExecutionException
    //   0	7	100	java/lang/InterruptedException
    //   20	39	100	java/lang/InterruptedException
    //   66	68	100	java/lang/InterruptedException
    //   0	7	108	java/util/concurrent/CancellationException
    //   20	39	108	java/util/concurrent/CancellationException
    //   66	68	108	java/util/concurrent/CancellationException
  }
}
