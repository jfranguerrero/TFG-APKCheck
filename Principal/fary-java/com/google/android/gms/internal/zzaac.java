package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzaac
  implements zzaau
{
  private final zzaap zzaxK;
  private ConnectionResult zzazA;
  private final Lock zzazn;
  private final zzg zzazs;
  private final Map<Api.zzc<?>, com.google.android.gms.common.api.zzc<?>> zzazt = new HashMap();
  private final Map<Api<?>, Integer> zzazu;
  private final zzaal zzazv;
  private final com.google.android.gms.common.zzc zzazw;
  private final Condition zzazx;
  private boolean zzazy;
  private Map<zzzs<?>, ConnectionResult> zzazz;
  private final Looper zzrx;
  
  public zzaac(Context paramContext, Lock paramLock, Looper paramLooper, com.google.android.gms.common.zzc paramZzc, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramZzg, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzaxn, zzaxo> paramZza, ArrayList<zzzy> paramArrayList, zzaal paramZzaal)
  {
    zzazn = paramLock;
    zzrx = paramLooper;
    zzazx = paramLock.newCondition();
    zzazw = paramZzc;
    zzazv = paramZzaal;
    zzazu = paramMap1;
    zzazs = paramZzg;
    paramLock = new HashMap();
    paramZzc = paramMap1.keySet().iterator();
    while (paramZzc.hasNext())
    {
      paramMap1 = (Api)paramZzc.next();
      paramLock.put(paramMap1.zzuH(), paramMap1);
    }
    paramZzc = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (zzzy)paramMap1.next();
      paramZzc.put(zzawb, paramArrayList);
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramArrayList = (Api)paramLock.get(paramMap1.getKey());
      paramZzaal = (Api.zze)paramMap1.getValue();
      zzzy localZzzy = (zzzy)paramZzc.get(paramArrayList);
      zzazt.put((Api.zzc)paramMap1.getKey(), new zzaab(paramContext, paramArrayList, paramLooper, paramZzaal, localZzzy, paramZzg, paramZza));
    }
    zzaxK = zzaap.zzvS();
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        zzazx.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzawX;
    }
    if (zzazA != null) {
      return zzazA;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = zzazx.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzawX;
    }
    if (zzazA != null) {
      return zzazA;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    zzazn.lock();
    try
    {
      boolean bool = zzazy;
      if (bool) {
        return;
      }
      zzazy = true;
      zzazz = null;
      zzazA = null;
      zza localZza = new zza(null);
      zzact localZzact = new zzact(zzrx);
      zzaxK.zza(zzazt.values()).addOnSuccessListener(localZzact, localZza).addOnFailureListener(localZzact, localZza);
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public void disconnect()
  {
    zzazn.lock();
    try
    {
      zzazy = false;
      zzazz = null;
      zzazA = null;
      zzazx.signalAll();
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    zzazn.lock();
    try
    {
      if (((zzaab)zzazt.get(paramApi.zzuH())).zzvr().isConnected())
      {
        paramApi = ConnectionResult.zzawX;
        return paramApi;
      }
      if (zzazz != null)
      {
        paramApi = (ConnectionResult)zzazz.get(((com.google.android.gms.common.api.zzc)zzazt.get(paramApi.zzuH())).getApiKey());
        return paramApi;
      }
      return null;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/google/android/gms/internal/zzaac:zzazn	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 217 1 0
    //   9: aload_0
    //   10: getfield 148	com/google/android/gms/internal/zzaac:zzazz	Ljava/util/Map;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 145	com/google/android/gms/internal/zzaac:zzazA	Lcom/google/android/gms/common/ConnectionResult;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 48	com/google/android/gms/internal/zzaac:zzazn	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 220 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 48	com/google/android/gms/internal/zzaac:zzazn	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 220 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzaac
    //   26	14	1	bool	boolean
    //   20	2	2	localConnectionResult	ConnectionResult
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/google/android/gms/internal/zzaac:zzazn	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 217 1 0
    //   9: aload_0
    //   10: getfield 148	com/google/android/gms/internal/zzaac:zzazz	Ljava/util/Map;
    //   13: ifnonnull +25 -> 38
    //   16: aload_0
    //   17: getfield 152	com/google/android/gms/internal/zzaac:zzazy	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 48	com/google/android/gms/internal/zzaac:zzazn	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 220 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 48	com/google/android/gms/internal/zzaac:zzazn	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 220 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzaac
    //   20	20	1	bool	boolean
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(@NonNull T paramT)
  {
    zzazv.zzaAx.zzb(paramT);
    return ((com.google.android.gms.common.api.zzc)zzazt.get(paramT.zzuH())).doRead(paramT);
  }
  
  public boolean zza(zzabi paramZzabi)
  {
    return false;
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    zzazv.zzaAx.zzb(paramT);
    return ((com.google.android.gms.common.api.zzc)zzazt.get(paramT.zzuH())).doWrite(paramT);
  }
  
  public void zzuN() {}
  
  public void zzvj() {}
  
  private class zza
    implements OnFailureListener, OnSuccessListener<Void>
  {
    private zza() {}
    
    @Nullable
    private ConnectionResult zzvs()
    {
      Object localObject1 = null;
      int i = 0;
      Iterator localIterator = zzaac.zzg(zzaac.this).keySet().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (Api)localIterator.next();
          ConnectionResult localConnectionResult = (ConnectionResult)zzaac.zzc(zzaac.this).get(((com.google.android.gms.common.api.zzc)zzaac.zzb(zzaac.this).get(((Api)localObject2).zzuH())).getApiKey());
          if (!localConnectionResult.isSuccess())
          {
            j = ((Integer)zzaac.zzg(zzaac.this).get(localObject2)).intValue();
            if ((j != 2) && ((j != 1) || (localConnectionResult.hasResolution()) || (zzaac.zzh(zzaac.this).isUserResolvableError(localConnectionResult.getErrorCode()))))
            {
              int k = ((Api)localObject2).zzuF().getPriority();
              j = k;
              localObject2 = localConnectionResult;
              if (localObject1 != null)
              {
                if (i <= k) {
                  break label194;
                }
                localObject2 = localConnectionResult;
                j = k;
              }
            }
          }
        }
      }
      for (;;)
      {
        i = j;
        localObject1 = localObject2;
        break;
        return localObject1;
        label194:
        j = i;
        localObject2 = localObject1;
      }
    }
    
    private void zzvt()
    {
      if (zzaac.zzi(zzaac.this) == null)
      {
        zzdzzaAs = Collections.emptySet();
        return;
      }
      HashSet localHashSet = new HashSet(zzaac.zzi(zzaac.this).zzxe());
      Map localMap = zzaac.zzi(zzaac.this).zzxg();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api localApi = (Api)localIterator.next();
        ConnectionResult localConnectionResult = (ConnectionResult)zzaac.zzc(zzaac.this).get(((com.google.android.gms.common.api.zzc)zzaac.zzb(zzaac.this).get(localApi.zzuH())).getApiKey());
        if ((localConnectionResult != null) && (localConnectionResult.isSuccess())) {
          localHashSet.addAll(getzzajm);
        }
      }
      zzdzzaAs = localHashSet;
    }
    
    /* Error */
    public void onFailure(@NonNull Exception paramException)
    {
      // Byte code:
      //   0: aload_1
      //   1: checkcast 161	com/google/android/gms/common/api/zzb
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   9: invokestatic 164	com/google/android/gms/internal/zzaac:zza	(Lcom/google/android/gms/internal/zzaac;)Ljava/util/concurrent/locks/Lock;
      //   12: invokeinterface 169 1 0
      //   17: aload_0
      //   18: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   21: aload_1
      //   22: invokevirtual 173	com/google/android/gms/common/api/zzb:zzuK	()Landroid/support/v4/util/ArrayMap;
      //   25: invokestatic 176	com/google/android/gms/internal/zzaac:zza	(Lcom/google/android/gms/internal/zzaac;Ljava/util/Map;)Ljava/util/Map;
      //   28: pop
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   33: aload_0
      //   34: invokespecial 178	com/google/android/gms/internal/zzaac$zza:zzvs	()Lcom/google/android/gms/common/ConnectionResult;
      //   37: invokestatic 181	com/google/android/gms/internal/zzaac:zza	(Lcom/google/android/gms/internal/zzaac;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;
      //   40: pop
      //   41: aload_0
      //   42: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   45: invokestatic 185	com/google/android/gms/internal/zzaac:zzf	(Lcom/google/android/gms/internal/zzaac;)Lcom/google/android/gms/common/ConnectionResult;
      //   48: ifnonnull +43 -> 91
      //   51: aload_0
      //   52: invokespecial 187	com/google/android/gms/internal/zzaac$zza:zzvt	()V
      //   55: aload_0
      //   56: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   59: invokestatic 122	com/google/android/gms/internal/zzaac:zzd	(Lcom/google/android/gms/internal/zzaac;)Lcom/google/android/gms/internal/zzaal;
      //   62: aconst_null
      //   63: invokevirtual 191	com/google/android/gms/internal/zzaal:zzo	(Landroid/os/Bundle;)V
      //   66: aload_0
      //   67: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   70: invokestatic 195	com/google/android/gms/internal/zzaac:zze	(Lcom/google/android/gms/internal/zzaac;)Ljava/util/concurrent/locks/Condition;
      //   73: invokeinterface 200 1 0
      //   78: aload_0
      //   79: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   82: invokestatic 164	com/google/android/gms/internal/zzaac:zza	(Lcom/google/android/gms/internal/zzaac;)Ljava/util/concurrent/locks/Lock;
      //   85: invokeinterface 203 1 0
      //   90: return
      //   91: aload_0
      //   92: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   95: iconst_0
      //   96: invokestatic 206	com/google/android/gms/internal/zzaac:zza	(Lcom/google/android/gms/internal/zzaac;Z)Z
      //   99: pop
      //   100: aload_0
      //   101: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   104: invokestatic 122	com/google/android/gms/internal/zzaac:zzd	(Lcom/google/android/gms/internal/zzaac;)Lcom/google/android/gms/internal/zzaal;
      //   107: aload_0
      //   108: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   111: invokestatic 185	com/google/android/gms/internal/zzaac:zzf	(Lcom/google/android/gms/internal/zzaac;)Lcom/google/android/gms/common/ConnectionResult;
      //   114: invokevirtual 209	com/google/android/gms/internal/zzaal:zzc	(Lcom/google/android/gms/common/ConnectionResult;)V
      //   117: goto -51 -> 66
      //   120: astore_1
      //   121: aload_0
      //   122: getfield 18	com/google/android/gms/internal/zzaac$zza:zzazB	Lcom/google/android/gms/internal/zzaac;
      //   125: invokestatic 164	com/google/android/gms/internal/zzaac:zza	(Lcom/google/android/gms/internal/zzaac;)Ljava/util/concurrent/locks/Lock;
      //   128: invokeinterface 203 1 0
      //   133: aload_1
      //   134: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	135	0	this	zza
      //   0	135	1	paramException	Exception
      // Exception table:
      //   from	to	target	type
      //   17	66	120	finally
      //   66	78	120	finally
      //   91	117	120	finally
    }
    
    public void zza(Void paramVoid)
    {
      zzaac.zza(zzaac.this).lock();
      try
      {
        zzaac.zza(zzaac.this, new ArrayMap(zzaac.zzb(zzaac.this).size()));
        paramVoid = zzaac.zzb(zzaac.this).keySet().iterator();
        while (paramVoid.hasNext())
        {
          Api.zzc localZzc = (Api.zzc)paramVoid.next();
          zzaac.zzc(zzaac.this).put(((com.google.android.gms.common.api.zzc)zzaac.zzb(zzaac.this).get(localZzc)).getApiKey(), ConnectionResult.zzawX);
        }
        zzvt();
      }
      finally
      {
        zzaac.zza(zzaac.this).unlock();
      }
      zzaac.zzd(zzaac.this).zzo(null);
      zzaac.zze(zzaac.this).signalAll();
      zzaac.zza(zzaac.this).unlock();
    }
  }
}
