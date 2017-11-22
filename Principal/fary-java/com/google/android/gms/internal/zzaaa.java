package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzaaa
  implements zzaau
{
  private final Context mContext;
  private final zzaal zzazd;
  private final zzaan zzaze;
  private final zzaan zzazf;
  private final Map<Api.zzc<?>, zzaan> zzazg;
  private final Set<zzabi> zzazh = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zze zzazi;
  private Bundle zzazj;
  private ConnectionResult zzazk = null;
  private ConnectionResult zzazl = null;
  private boolean zzazm = false;
  private final Lock zzazn;
  private int zzazo = 0;
  private final Looper zzrx;
  
  private zzaaa(Context paramContext, zzaal paramZzaal, Lock paramLock, Looper paramLooper, zzc paramZzc, Map<Api.zzc<?>, Api.zze> paramMap1, Map<Api.zzc<?>, Api.zze> paramMap2, zzg paramZzg, Api.zza<? extends zzaxn, zzaxo> paramZza, Api.zze paramZze, ArrayList<zzzy> paramArrayList1, ArrayList<zzzy> paramArrayList2, Map<Api<?>, Integer> paramMap3, Map<Api<?>, Integer> paramMap4)
  {
    mContext = paramContext;
    zzazd = paramZzaal;
    zzazn = paramLock;
    zzrx = paramLooper;
    zzazi = paramZze;
    zzaze = new zzaan(paramContext, zzazd, paramLock, paramLooper, paramZzc, paramMap2, null, paramMap4, null, paramArrayList2, new zza(null));
    zzazf = new zzaan(paramContext, zzazd, paramLock, paramLooper, paramZzc, paramMap1, paramZzg, paramMap3, paramZza, paramArrayList1, new zzb(null));
    paramContext = new ArrayMap();
    paramZzaal = paramMap2.keySet().iterator();
    while (paramZzaal.hasNext()) {
      paramContext.put((Api.zzc)paramZzaal.next(), zzaze);
    }
    paramZzaal = paramMap1.keySet().iterator();
    while (paramZzaal.hasNext()) {
      paramContext.put((Api.zzc)paramZzaal.next(), zzazf);
    }
    zzazg = Collections.unmodifiableMap(paramContext);
  }
  
  public static zzaaa zza(Context paramContext, zzaal paramZzaal, Lock paramLock, Looper paramLooper, zzc paramZzc, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramZzg, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzaxn, zzaxo> paramZza, ArrayList<zzzy> paramArrayList)
  {
    Object localObject1 = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap.entrySet().iterator();
    paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.zze)((Map.Entry)localObject3).getValue();
      if (((Api.zze)localObject1).zzqS()) {
        paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
      }
      if (((Api.zze)localObject1).zzqD()) {
        localArrayMap1.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        localArrayMap2.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    boolean bool;
    if (!localArrayMap1.isEmpty())
    {
      bool = true;
      zzac.zza(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localObject1 = new ArrayMap();
      localObject2 = new ArrayMap();
      localObject3 = paramMap1.keySet().iterator();
    }
    Object localObject4;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Api)((Iterator)localObject3).next();
        Api.zzc localZzc = ((Api)localObject4).zzuH();
        if (localArrayMap1.containsKey(localZzc))
        {
          ((Map)localObject1).put(localObject4, (Integer)paramMap1.get(localObject4));
          continue;
          bool = false;
          break;
        }
        if (localArrayMap2.containsKey(localZzc)) {
          ((Map)localObject2).put(localObject4, (Integer)paramMap1.get(localObject4));
        } else {
          throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
        }
      }
    }
    paramMap1 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject4 = (zzzy)paramArrayList.next();
      if (((Map)localObject1).containsKey(zzawb)) {
        paramMap1.add(localObject4);
      } else if (((Map)localObject2).containsKey(zzawb)) {
        ((ArrayList)localObject3).add(localObject4);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
      }
    }
    return new zzaaa(paramContext, paramZzaal, paramLock, paramLooper, paramZzc, localArrayMap1, localArrayMap2, paramZzg, paramZza, paramMap, paramMap1, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }
  
  private void zza(ConnectionResult paramConnectionResult)
  {
    switch (zzazo)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      zzazo = 0;
      return;
      zzazd.zzc(paramConnectionResult);
      zzvo();
    }
  }
  
  private void zzb(int paramInt, boolean paramBoolean)
  {
    zzazd.zzc(paramInt, paramBoolean);
    zzazl = null;
    zzazk = null;
  }
  
  private static boolean zzb(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private boolean zzc(zzzv.zza<? extends Result, ? extends Api.zzb> paramZza)
  {
    paramZza = paramZza.zzuH();
    zzac.zzb(zzazg.containsKey(paramZza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzaan)zzazg.get(paramZza)).equals(zzazf);
  }
  
  private void zzn(Bundle paramBundle)
  {
    if (zzazj == null) {
      zzazj = paramBundle;
    }
    while (paramBundle == null) {
      return;
    }
    zzazj.putAll(paramBundle);
  }
  
  private void zzvl()
  {
    zzazl = null;
    zzazk = null;
    zzaze.connect();
    zzazf.connect();
  }
  
  private void zzvm()
  {
    if (zzb(zzazk)) {
      if ((zzb(zzazl)) || (zzvp())) {
        zzvn();
      }
    }
    do
    {
      do
      {
        return;
      } while (zzazl == null);
      if (zzazo == 1)
      {
        zzvo();
        return;
      }
      zza(zzazl);
      zzaze.disconnect();
      return;
      if ((zzazk != null) && (zzb(zzazl)))
      {
        zzazf.disconnect();
        zza(zzazk);
        return;
      }
    } while ((zzazk == null) || (zzazl == null));
    ConnectionResult localConnectionResult = zzazk;
    if (zzazf.zzaAJ < zzaze.zzaAJ) {
      localConnectionResult = zzazl;
    }
    zza(localConnectionResult);
  }
  
  private void zzvn()
  {
    switch (zzazo)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
    }
    for (;;)
    {
      zzazo = 0;
      return;
      zzazd.zzo(zzazj);
      zzvo();
    }
  }
  
  private void zzvo()
  {
    Iterator localIterator = zzazh.iterator();
    while (localIterator.hasNext()) {
      ((zzabi)localIterator.next()).zzqR();
    }
    zzazh.clear();
  }
  
  private boolean zzvp()
  {
    return (zzazl != null) && (zzazl.getErrorCode() == 4);
  }
  
  @Nullable
  private PendingIntent zzvq()
  {
    if (zzazi == null) {
      return null;
    }
    return PendingIntent.getActivity(mContext, zzazd.getSessionId(), zzazi.zzqT(), 134217728);
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void connect()
  {
    zzazo = 2;
    zzazm = false;
    zzvl();
  }
  
  public void disconnect()
  {
    zzazl = null;
    zzazk = null;
    zzazo = 0;
    zzaze.disconnect();
    zzazf.disconnect();
    zzvo();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    zzazf.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    zzaze.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    if (((zzaan)zzazg.get(paramApi.zzuH())).equals(zzazf))
    {
      if (zzvp()) {
        return new ConnectionResult(4, zzvq());
      }
      return zzazf.getConnectionResult(paramApi);
    }
    return zzaze.getConnectionResult(paramApi);
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 387 1 0
    //   11: aload_0
    //   12: getfield 86	com/google/android/gms/internal/zzaaa:zzaze	Lcom/google/android/gms/internal/zzaan;
    //   15: invokevirtual 389	com/google/android/gms/internal/zzaan:isConnected	()Z
    //   18: ifeq +44 -> 62
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual 392	com/google/android/gms/internal/zzaaa:zzvk	()Z
    //   27: ifne +24 -> 51
    //   30: iload_3
    //   31: istore_2
    //   32: aload_0
    //   33: invokespecial 281	com/google/android/gms/internal/zzaaa:zzvp	()Z
    //   36: ifne +15 -> 51
    //   39: aload_0
    //   40: getfield 66	com/google/android/gms/internal/zzaaa:zzazo	I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne +16 -> 62
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 395 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -13 -> 51
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 395 1 0
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzaaa
    //   43	4	1	i	int
    //   22	42	2	bool1	boolean
    //   1	49	3	bool2	boolean
    //   67	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	67	finally
    //   23	30	67	finally
    //   32	44	67	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 387 1 0
    //   9: aload_0
    //   10: getfield 66	com/google/android/gms/internal/zzaaa:zzazo	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 395 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 395 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	zzaaa
    //   13	4	1	i	int
    //   20	14	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(@NonNull T paramT)
  {
    if (zzc(paramT))
    {
      if (zzvp())
      {
        paramT.zzA(new Status(4, null, zzvq()));
        return paramT;
      }
      return zzazf.zza(paramT);
    }
    return zzaze.zza(paramT);
  }
  
  public boolean zza(zzabi paramZzabi)
  {
    zzazn.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!zzvk()))
      {
        zzazh.add(paramZzabi);
        if (zzazo == 0) {
          zzazo = 1;
        }
        zzazl = null;
        zzazf.connect();
        return true;
      }
      return false;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    if (zzc(paramT))
    {
      if (zzvp())
      {
        paramT.zzA(new Status(4, null, zzvq()));
        return paramT;
      }
      return zzazf.zzb(paramT);
    }
    return zzaze.zzb(paramT);
  }
  
  /* Error */
  public void zzuN()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 387 1 0
    //   9: aload_0
    //   10: invokevirtual 414	com/google/android/gms/internal/zzaaa:isConnecting	()Z
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 89	com/google/android/gms/internal/zzaaa:zzazf	Lcom/google/android/gms/internal/zzaan;
    //   18: invokevirtual 289	com/google/android/gms/internal/zzaan:disconnect	()V
    //   21: aload_0
    //   22: new 244	com/google/android/gms/common/ConnectionResult
    //   25: dup
    //   26: iconst_4
    //   27: invokespecial 423	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   30: putfield 62	com/google/android/gms/internal/zzaaa:zzazl	Lcom/google/android/gms/common/ConnectionResult;
    //   33: iload_1
    //   34: ifeq +36 -> 70
    //   37: new 425	android/os/Handler
    //   40: dup
    //   41: aload_0
    //   42: getfield 74	com/google/android/gms/internal/zzaaa:zzrx	Landroid/os/Looper;
    //   45: invokespecial 428	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   48: new 8	com/google/android/gms/internal/zzaaa$1
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 430	com/google/android/gms/internal/zzaaa$1:<init>	(Lcom/google/android/gms/internal/zzaaa;)V
    //   56: invokevirtual 434	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 395 1 0
    //   69: return
    //   70: aload_0
    //   71: invokespecial 225	com/google/android/gms/internal/zzaaa:zzvo	()V
    //   74: goto -14 -> 60
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 72	com/google/android/gms/internal/zzaaa:zzazn	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 395 1 0
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzaaa
    //   13	21	1	bool	boolean
    //   77	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	33	77	finally
    //   37	60	77	finally
    //   70	74	77	finally
  }
  
  public void zzvj()
  {
    zzaze.zzvj();
    zzazf.zzvj();
  }
  
  public boolean zzvk()
  {
    return zzazf.isConnected();
  }
  
  private class zza
    implements zzaau.zza
  {
    private zza() {}
    
    public void zzc(int paramInt, boolean paramBoolean)
    {
      zzaaa.zza(zzaaa.this).lock();
      try
      {
        if ((zzaaa.zzc(zzaaa.this)) || (zzaaa.zzd(zzaaa.this) == null) || (!zzaaa.zzd(zzaaa.this).isSuccess()))
        {
          zzaaa.zza(zzaaa.this, false);
          zzaaa.zza(zzaaa.this, paramInt, paramBoolean);
          return;
        }
        zzaaa.zza(zzaaa.this, true);
        zzaaa.zze(zzaaa.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzaaa.zza(zzaaa.this).unlock();
      }
    }
    
    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzaaa.zza(zzaaa.this).lock();
      try
      {
        zzaaa.zza(zzaaa.this, paramConnectionResult);
        zzaaa.zzb(zzaaa.this);
        return;
      }
      finally
      {
        zzaaa.zza(zzaaa.this).unlock();
      }
    }
    
    public void zzo(@Nullable Bundle paramBundle)
    {
      zzaaa.zza(zzaaa.this).lock();
      try
      {
        zzaaa.zza(zzaaa.this, paramBundle);
        zzaaa.zza(zzaaa.this, ConnectionResult.zzawX);
        zzaaa.zzb(zzaaa.this);
        return;
      }
      finally
      {
        zzaaa.zza(zzaaa.this).unlock();
      }
    }
  }
  
  private class zzb
    implements zzaau.zza
  {
    private zzb() {}
    
    public void zzc(int paramInt, boolean paramBoolean)
    {
      zzaaa.zza(zzaaa.this).lock();
      try
      {
        if (zzaaa.zzc(zzaaa.this))
        {
          zzaaa.zza(zzaaa.this, false);
          zzaaa.zza(zzaaa.this, paramInt, paramBoolean);
          return;
        }
        zzaaa.zza(zzaaa.this, true);
        zzaaa.zzf(zzaaa.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzaaa.zza(zzaaa.this).unlock();
      }
    }
    
    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzaaa.zza(zzaaa.this).lock();
      try
      {
        zzaaa.zzb(zzaaa.this, paramConnectionResult);
        zzaaa.zzb(zzaaa.this);
        return;
      }
      finally
      {
        zzaaa.zza(zzaaa.this).unlock();
      }
    }
    
    public void zzo(@Nullable Bundle paramBundle)
    {
      zzaaa.zza(zzaaa.this).lock();
      try
      {
        zzaaa.zzb(zzaaa.this, ConnectionResult.zzawX);
        zzaaa.zzb(zzaaa.this);
        return;
      }
      finally
      {
        zzaaa.zza(zzaaa.this).unlock();
      }
    }
  }
}
