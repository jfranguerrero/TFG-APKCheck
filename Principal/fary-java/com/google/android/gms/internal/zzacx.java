package com.google.android.gms.internal;

import android.content.Context;

public class zzacx
{
  private static zzacx zzaHl = new zzacx();
  private zzacw zzaHk = null;
  
  public zzacx() {}
  
  public static zzacw zzaQ(Context paramContext)
  {
    return zzaHl.zzaP(paramContext);
  }
  
  /* Error */
  public zzacw zzaP(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/google/android/gms/internal/zzacx:zzaHk	Lcom/google/android/gms/internal/zzacw;
    //   6: ifnonnull +22 -> 28
    //   9: aload_1
    //   10: invokevirtual 30	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: ifnonnull +24 -> 37
    //   16: aload_0
    //   17: new 32	com/google/android/gms/internal/zzacw
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 35	com/google/android/gms/internal/zzacw:<init>	(Landroid/content/Context;)V
    //   25: putfield 19	com/google/android/gms/internal/zzacx:zzaHk	Lcom/google/android/gms/internal/zzacw;
    //   28: aload_0
    //   29: getfield 19	com/google/android/gms/internal/zzacx:zzaHk	Lcom/google/android/gms/internal/zzacw;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_1
    //   38: invokevirtual 30	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   41: astore_1
    //   42: goto -26 -> 16
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	zzacx
    //   0	50	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   16	28	45	finally
    //   28	33	45	finally
    //   37	42	45	finally
  }
}
