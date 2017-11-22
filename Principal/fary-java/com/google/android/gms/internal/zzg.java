package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class zzg
  extends Thread
{
  private final zzb zzi;
  private final zzn zzj;
  private volatile boolean zzk = false;
  private final BlockingQueue<zzk<?>> zzw;
  private final zzf zzx;
  
  public zzg(BlockingQueue<zzk<?>> paramBlockingQueue, zzf paramZzf, zzb paramZzb, zzn paramZzn)
  {
    super("VolleyNetworkDispatcher");
    zzw = paramBlockingQueue;
    zzx = paramZzf;
    zzi = paramZzb;
    zzj = paramZzn;
  }
  
  @TargetApi(14)
  private void zzb(zzk<?> paramZzk)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramZzk.zzf());
    }
  }
  
  private void zzb(zzk<?> paramZzk, zzr paramZzr)
  {
    paramZzr = paramZzk.zzb(paramZzr);
    zzj.zza(paramZzk, paramZzr);
  }
  
  public void quit()
  {
    zzk = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 87	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 93	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 26	com/google/android/gms/internal/zzg:zzw	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 99 1 0
    //   18: checkcast 48	com/google/android/gms/internal/zzk
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 101
    //   25: invokevirtual 104	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: aload_3
    //   30: invokespecial 106	com/google/android/gms/internal/zzg:zzb	(Lcom/google/android/gms/internal/zzk;)V
    //   33: aload_0
    //   34: getfield 28	com/google/android/gms/internal/zzg:zzx	Lcom/google/android/gms/internal/zzf;
    //   37: aload_3
    //   38: invokeinterface 111 2 0
    //   43: astore 4
    //   45: aload_3
    //   46: ldc 113
    //   48: invokevirtual 104	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   51: aload 4
    //   53: getfield 118	com/google/android/gms/internal/zzi:zzz	Z
    //   56: ifeq +50 -> 106
    //   59: aload_3
    //   60: invokevirtual 122	com/google/android/gms/internal/zzk:zzs	()Z
    //   63: ifeq +43 -> 106
    //   66: aload_3
    //   67: ldc 124
    //   69: invokevirtual 127	com/google/android/gms/internal/zzk:zzd	(Ljava/lang/String;)V
    //   72: goto -67 -> 5
    //   75: astore 4
    //   77: aload 4
    //   79: invokestatic 93	android/os/SystemClock:elapsedRealtime	()J
    //   82: lload_1
    //   83: lsub
    //   84: invokevirtual 130	com/google/android/gms/internal/zzr:zza	(J)V
    //   87: aload_0
    //   88: aload_3
    //   89: aload 4
    //   91: invokespecial 132	com/google/android/gms/internal/zzg:zzb	(Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   94: goto -89 -> 5
    //   97: astore_3
    //   98: aload_0
    //   99: getfield 24	com/google/android/gms/internal/zzg:zzk	Z
    //   102: ifeq -97 -> 5
    //   105: return
    //   106: aload_3
    //   107: aload 4
    //   109: invokevirtual 135	com/google/android/gms/internal/zzk:zza	(Lcom/google/android/gms/internal/zzi;)Lcom/google/android/gms/internal/zzm;
    //   112: astore 4
    //   114: aload_3
    //   115: ldc -119
    //   117: invokevirtual 104	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   120: aload_3
    //   121: invokevirtual 140	com/google/android/gms/internal/zzk:zzn	()Z
    //   124: ifeq +35 -> 159
    //   127: aload 4
    //   129: getfield 146	com/google/android/gms/internal/zzm:zzae	Lcom/google/android/gms/internal/zzb$zza;
    //   132: ifnull +27 -> 159
    //   135: aload_0
    //   136: getfield 30	com/google/android/gms/internal/zzg:zzi	Lcom/google/android/gms/internal/zzb;
    //   139: aload_3
    //   140: invokevirtual 150	com/google/android/gms/internal/zzk:zzg	()Ljava/lang/String;
    //   143: aload 4
    //   145: getfield 146	com/google/android/gms/internal/zzm:zzae	Lcom/google/android/gms/internal/zzb$zza;
    //   148: invokeinterface 155 3 0
    //   153: aload_3
    //   154: ldc -99
    //   156: invokevirtual 104	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   159: aload_3
    //   160: invokevirtual 160	com/google/android/gms/internal/zzk:zzr	()V
    //   163: aload_0
    //   164: getfield 32	com/google/android/gms/internal/zzg:zzj	Lcom/google/android/gms/internal/zzn;
    //   167: aload_3
    //   168: aload 4
    //   170: invokeinterface 163 3 0
    //   175: goto -170 -> 5
    //   178: astore 4
    //   180: aload 4
    //   182: ldc -91
    //   184: iconst_1
    //   185: anewarray 167	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload 4
    //   192: invokevirtual 170	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 175	com/google/android/gms/internal/zzs:zza	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: new 80	com/google/android/gms/internal/zzr
    //   202: dup
    //   203: aload 4
    //   205: invokespecial 178	com/google/android/gms/internal/zzr:<init>	(Ljava/lang/Throwable;)V
    //   208: astore 4
    //   210: aload 4
    //   212: invokestatic 93	android/os/SystemClock:elapsedRealtime	()J
    //   215: lload_1
    //   216: lsub
    //   217: invokevirtual 130	com/google/android/gms/internal/zzr:zza	(J)V
    //   220: aload_0
    //   221: getfield 32	com/google/android/gms/internal/zzg:zzj	Lcom/google/android/gms/internal/zzn;
    //   224: aload_3
    //   225: aload 4
    //   227: invokeinterface 69 3 0
    //   232: goto -227 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	zzg
    //   8	208	1	l	long
    //   21	68	3	localZzk	zzk
    //   97	128	3	localInterruptedException	InterruptedException
    //   43	9	4	localZzi	zzi
    //   75	33	4	localZzr1	zzr
    //   112	57	4	localZzm	zzm
    //   178	26	4	localException	Exception
    //   208	18	4	localZzr2	zzr
    // Exception table:
    //   from	to	target	type
    //   22	72	75	com/google/android/gms/internal/zzr
    //   106	159	75	com/google/android/gms/internal/zzr
    //   159	175	75	com/google/android/gms/internal/zzr
    //   9	22	97	java/lang/InterruptedException
    //   22	72	178	java/lang/Exception
    //   106	159	178	java/lang/Exception
    //   159	175	178	java/lang/Exception
  }
}
