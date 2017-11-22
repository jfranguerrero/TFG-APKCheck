package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzaan
  implements zzaau, zzzz
{
  private final Context mContext;
  private final Condition zzaAE;
  private final zzb zzaAF;
  final Map<Api.zzc<?>, ConnectionResult> zzaAG = new HashMap();
  private volatile zzaam zzaAH;
  private ConnectionResult zzaAI = null;
  int zzaAJ;
  final zzaau.zza zzaAK;
  final Map<Api.zzc<?>, Api.zze> zzaAr;
  final Api.zza<? extends zzaxn, zzaxo> zzaxY;
  final zzaal zzazd;
  private final Lock zzazn;
  final zzg zzazs;
  final Map<Api<?>, Integer> zzazu;
  private final zzc zzazw;
  
  public zzaan(Context paramContext, zzaal paramZzaal, Lock paramLock, Looper paramLooper, zzc paramZzc, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramZzg, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzaxn, zzaxo> paramZza, ArrayList<zzzy> paramArrayList, zzaau.zza paramZza1)
  {
    mContext = paramContext;
    zzazn = paramLock;
    zzazw = paramZzc;
    zzaAr = paramMap;
    zzazs = paramZzg;
    zzazu = paramMap1;
    zzaxY = paramZza;
    zzazd = paramZzaal;
    zzaAK = paramZza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((zzzy)paramContext.next()).zza(this);
    }
    zzaAF = new zzb(paramLooper);
    zzaAE = paramLock.newCondition();
    zzaAH = new zzaak(this);
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        zzaAE.await();
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
    if (zzaAI != null) {
      return zzaAI;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = zzaAE.awaitNanos(paramLong))
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
    if (zzaAI != null) {
      return zzaAI;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    zzaAH.connect();
  }
  
  public void disconnect()
  {
    if (zzaAH.disconnect()) {
      zzaAG.clear();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(zzaAH);
    Iterator localIterator = zzazu.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zze)zzaAr.get(localApi.zzuH())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    paramApi = paramApi.zzuH();
    if (zzaAr.containsKey(paramApi))
    {
      if (((Api.zze)zzaAr.get(paramApi)).isConnected()) {
        return ConnectionResult.zzawX;
      }
      if (zzaAG.containsKey(paramApi)) {
        return (ConnectionResult)zzaAG.get(paramApi);
      }
    }
    return null;
  }
  
  public boolean isConnected()
  {
    return zzaAH instanceof zzaai;
  }
  
  public boolean isConnecting()
  {
    return zzaAH instanceof zzaaj;
  }
  
  public void onConnected(@Nullable Bundle paramBundle)
  {
    zzazn.lock();
    try
    {
      zzaAH.onConnected(paramBundle);
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzazn.lock();
    try
    {
      zzaAH.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(@NonNull T paramT)
  {
    paramT.zzvf();
    return zzaAH.zza(paramT);
  }
  
  public void zza(@NonNull ConnectionResult paramConnectionResult, @NonNull Api<?> paramApi, int paramInt)
  {
    zzazn.lock();
    try
    {
      zzaAH.zza(paramConnectionResult, paramApi, paramInt);
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  void zza(zza paramZza)
  {
    paramZza = zzaAF.obtainMessage(1, paramZza);
    zzaAF.sendMessage(paramZza);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = zzaAF.obtainMessage(2, paramRuntimeException);
    zzaAF.sendMessage(paramRuntimeException);
  }
  
  public boolean zza(zzabi paramZzabi)
  {
    return false;
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    paramT.zzvf();
    return zzaAH.zzb(paramT);
  }
  
  void zzh(ConnectionResult paramConnectionResult)
  {
    zzazn.lock();
    try
    {
      zzaAI = paramConnectionResult;
      zzaAH = new zzaak(this);
      zzaAH.begin();
      zzaAE.signalAll();
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public void zzuN() {}
  
  void zzvO()
  {
    zzazn.lock();
    try
    {
      zzaAH = new zzaaj(this, zzazs, zzazu, zzazw, zzaxY, zzazn, mContext);
      zzaAH.begin();
      zzaAE.signalAll();
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  void zzvP()
  {
    zzazn.lock();
    try
    {
      zzazd.zzvL();
      zzaAH = new zzaai(this);
      zzaAH.begin();
      zzaAE.signalAll();
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  void zzvQ()
  {
    Iterator localIterator = zzaAr.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).disconnect();
    }
  }
  
  public void zzvj()
  {
    if (isConnected()) {
      ((zzaai)zzaAH).zzvz();
    }
  }
  
  static abstract class zza
  {
    private final zzaam zzaAL;
    
    protected zza(zzaam paramZzaam)
    {
      zzaAL = paramZzaam;
    }
    
    public final void zzc(zzaan paramZzaan)
    {
      zzaan.zza(paramZzaan).lock();
      try
      {
        zzaam localZzaam1 = zzaan.zzb(paramZzaan);
        zzaam localZzaam2 = zzaAL;
        if (localZzaam1 != localZzaam2) {
          return;
        }
        zzvA();
        return;
      }
      finally
      {
        zzaan.zza(paramZzaan).unlock();
      }
    }
    
    protected abstract void zzvA();
  }
  
  final class zzb
    extends Handler
  {
    zzb(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        int i = what;
        Log.w("GACStateManager", 31 + "Unknown message id: " + i);
        return;
      case 1: 
        ((zzaan.zza)obj).zzc(zzaan.this);
        return;
      }
      throw ((RuntimeException)obj);
    }
  }
}
