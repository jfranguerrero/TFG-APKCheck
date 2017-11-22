package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzc;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzaaj
  implements zzaam
{
  private final Context mContext;
  private final Api.zza<? extends zzaxn, zzaxo> zzaxY;
  private ConnectionResult zzazA;
  private final zzaan zzazK;
  private int zzazN;
  private int zzazO = 0;
  private int zzazP;
  private final Bundle zzazQ = new Bundle();
  private final Set<Api.zzc> zzazR = new HashSet();
  private zzaxn zzazS;
  private int zzazT;
  private boolean zzazU;
  private boolean zzazV;
  private zzr zzazW;
  private boolean zzazX;
  private boolean zzazY;
  private ArrayList<Future<?>> zzazZ = new ArrayList();
  private final Lock zzazn;
  private final zzg zzazs;
  private final Map<Api<?>, Integer> zzazu;
  private final zzc zzazw;
  
  public zzaaj(zzaan paramZzaan, zzg paramZzg, Map<Api<?>, Integer> paramMap, zzc paramZzc, Api.zza<? extends zzaxn, zzaxo> paramZza, Lock paramLock, Context paramContext)
  {
    zzazK = paramZzaan;
    zzazs = paramZzg;
    zzazu = paramMap;
    zzazw = paramZzc;
    zzaxY = paramZza;
    zzazn = paramLock;
    mContext = paramContext;
  }
  
  private void zza(zzayb paramZzayb)
  {
    if (!zzcv(0)) {
      return;
    }
    Object localObject = paramZzayb.zzxA();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramZzayb.zzOp();
      paramZzayb = ((zzaf)localObject).zzxA();
      if (!paramZzayb.isSuccess())
      {
        localObject = String.valueOf(paramZzayb);
        Log.wtf("GoogleApiClientConnecting", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        zzf(paramZzayb);
        return;
      }
      zzazV = true;
      zzazW = ((zzaf)localObject).zzxz();
      zzazX = ((zzaf)localObject).zzxB();
      zzazY = ((zzaf)localObject).zzxC();
      zzvC();
      return;
    }
    if (zze((ConnectionResult)localObject))
    {
      zzvF();
      zzvC();
      return;
    }
    zzf((ConnectionResult)localObject);
  }
  
  private boolean zza(int paramInt1, int paramInt2, ConnectionResult paramConnectionResult)
  {
    if ((paramInt2 == 1) && (!zzd(paramConnectionResult))) {}
    while ((zzazA != null) && (paramInt1 >= zzazN)) {
      return false;
    }
    return true;
  }
  
  private void zzaq(boolean paramBoolean)
  {
    if (zzazS != null)
    {
      if ((zzazS.isConnected()) && (paramBoolean)) {
        zzazS.zzOe();
      }
      zzazS.disconnect();
      zzazW = null;
    }
  }
  
  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (paramInt != 2)
    {
      int i = paramApi.zzuF().getPriority();
      if (zza(i, paramInt, paramConnectionResult))
      {
        zzazA = paramConnectionResult;
        zzazN = i;
      }
    }
    zzazK.zzaAG.put(paramApi.zzuH(), paramConnectionResult);
  }
  
  private boolean zzcv(int paramInt)
  {
    if (zzazO != paramInt)
    {
      Log.w("GoogleApiClientConnecting", zzazK.zzazd.zzvN());
      String str1 = String.valueOf(this);
      Log.w("GoogleApiClientConnecting", String.valueOf(str1).length() + 23 + "Unexpected callback in " + str1);
      int i = zzazP;
      Log.w("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      str1 = String.valueOf(zzcw(zzazO));
      String str2 = String.valueOf(zzcw(paramInt));
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private String zzcw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  private boolean zzd(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {}
    while (zzazw.zzcr(paramConnectionResult.getErrorCode()) != null) {
      return true;
    }
    return false;
  }
  
  private boolean zze(ConnectionResult paramConnectionResult)
  {
    return (zzazT == 2) || ((zzazT == 1) && (!paramConnectionResult.hasResolution()));
  }
  
  private void zzf(ConnectionResult paramConnectionResult)
  {
    zzvG();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zzaq(bool);
      zzazK.zzh(paramConnectionResult);
      zzazK.zzaAK.zzc(paramConnectionResult);
      return;
    }
  }
  
  private boolean zzvB()
  {
    zzazP -= 1;
    if (zzazP > 0) {
      return false;
    }
    if (zzazP < 0)
    {
      Log.w("GoogleApiClientConnecting", zzazK.zzazd.zzvN());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    if (zzazA != null)
    {
      zzazK.zzaAJ = zzazN;
      zzf(zzazA);
      return false;
    }
    return true;
  }
  
  private void zzvC()
  {
    if (zzazP != 0) {}
    while ((zzazU) && (!zzazV)) {
      return;
    }
    zzvD();
  }
  
  private void zzvD()
  {
    ArrayList localArrayList = new ArrayList();
    zzazO = 1;
    zzazP = zzazK.zzaAr.size();
    Iterator localIterator = zzazK.zzaAr.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localZzc = (Api.zzc)localIterator.next();
      if (zzazK.zzaAG.containsKey(localZzc))
      {
        if (zzvB()) {
          zzvE();
        }
      }
      else {
        localArrayList.add((Api.zze)zzazK.zzaAr.get(localZzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      zzazZ.add(zzaao.zzvR().submit(new zzc(localArrayList)));
    }
  }
  
  private void zzvE()
  {
    zzazK.zzvP();
    zzaao.zzvR().execute(new Runnable()
    {
      public void run()
      {
        zzaaj.zzb(zzaaj.this).zzan(zzaaj.zza(zzaaj.this));
      }
    });
    if (zzazS != null)
    {
      if (zzazX) {
        zzazS.zza(zzazW, zzazY);
      }
      zzaq(false);
    }
    Object localObject = zzazK.zzaAG.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.zzc localZzc = (Api.zzc)((Iterator)localObject).next();
      ((Api.zze)zzazK.zzaAr.get(localZzc)).disconnect();
    }
    if (zzazQ.isEmpty()) {}
    for (localObject = null;; localObject = zzazQ)
    {
      zzazK.zzaAK.zzo((Bundle)localObject);
      return;
    }
  }
  
  private void zzvF()
  {
    zzazU = false;
    zzazK.zzazd.zzaAs = Collections.emptySet();
    Iterator localIterator = zzazR.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localZzc = (Api.zzc)localIterator.next();
      if (!zzazK.zzaAG.containsKey(localZzc)) {
        zzazK.zzaAG.put(localZzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private void zzvG()
  {
    Iterator localIterator = zzazZ.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    zzazZ.clear();
  }
  
  private Set<Scope> zzvH()
  {
    if (zzazs == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet(zzazs.zzxe());
    Map localMap = zzazs.zzxg();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!zzazK.zzaAG.containsKey(localApi.zzuH())) {
        localHashSet.addAll(getzzajm);
      }
    }
    return localHashSet;
  }
  
  public void begin()
  {
    zzazK.zzaAG.clear();
    zzazU = false;
    zzazA = null;
    zzazO = 0;
    zzazT = 2;
    zzazV = false;
    zzazX = false;
    HashMap localHashMap = new HashMap();
    Object localObject = zzazu.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zze localZze = (Api.zze)zzazK.zzaAr.get(localApi.zzuH());
      int k = ((Integer)zzazu.get(localApi)).intValue();
      if (localApi.zzuF().getPriority() == 1) {}
      for (int j = 1;; j = 0)
      {
        if (localZze.zzqD())
        {
          zzazU = true;
          if (k < zzazT) {
            zzazT = k;
          }
          if (k != 0) {
            zzazR.add(localApi.zzuH());
          }
        }
        localHashMap.put(localZze, new zza(this, localApi, k));
        i = j | i;
        break;
      }
    }
    if (i != 0) {
      zzazU = false;
    }
    if (zzazU)
    {
      zzazs.zzc(Integer.valueOf(zzazK.zzazd.getSessionId()));
      localObject = new zze(null);
      zzazS = ((zzaxn)zzaxY.zza(mContext, zzazK.zzazd.getLooper(), zzazs, zzazs.zzxk(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    zzazP = zzazK.zzaAr.size();
    zzazZ.add(zzaao.zzvR().submit(new zzb(localHashMap)));
  }
  
  public void connect() {}
  
  public boolean disconnect()
  {
    zzvG();
    zzaq(true);
    zzazK.zzh(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (!zzcv(1)) {}
    do
    {
      return;
      if (paramBundle != null) {
        zzazQ.putAll(paramBundle);
      }
    } while (!zzvB());
    zzvE();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzf(new ConnectionResult(8, null));
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(T paramT)
  {
    zzazK.zzazd.zzaAl.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzcv(1)) {}
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    } while (!zzvB());
    zzvE();
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  private static class zza
    implements zzf.zzf
  {
    private final WeakReference<zzaaj> zzaAb;
    private final Api<?> zzawb;
    private final int zzazb;
    
    public zza(zzaaj paramZzaaj, Api<?> paramApi, int paramInt)
    {
      zzaAb = new WeakReference(paramZzaaj);
      zzawb = paramApi;
      zzazb = paramInt;
    }
    
    public void zzg(@NonNull ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzaaj localZzaaj = (zzaaj)zzaAb.get();
      if (localZzaaj == null) {
        return;
      }
      if (Looper.myLooper() == zzdzzazd.getLooper()) {
        bool = true;
      }
      zzac.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzaaj.zzc(localZzaaj).lock();
      try
      {
        bool = zzaaj.zza(localZzaaj, 0);
        if (!bool) {
          return;
        }
        if (!paramConnectionResult.isSuccess()) {
          zzaaj.zza(localZzaaj, paramConnectionResult, zzawb, zzazb);
        }
        if (zzaaj.zzk(localZzaaj)) {
          zzaaj.zzj(localZzaaj);
        }
        return;
      }
      finally
      {
        zzaaj.zzc(localZzaaj).unlock();
      }
    }
  }
  
  private class zzb
    extends zzaaj.zzf
  {
    private final Map<Api.zze, zzaaj.zza> zzaAc;
    
    public zzb()
    {
      super(null);
      Object localObject;
      zzaAc = localObject;
    }
    
    @WorkerThread
    public void zzvA()
    {
      int n = 1;
      int m = 0;
      Object localObject = zzaAc.keySet().iterator();
      int j = 1;
      int i = 0;
      Api.zze localZze;
      int k;
      if (((Iterator)localObject).hasNext())
      {
        localZze = (Api.zze)((Iterator)localObject).next();
        if (localZze.zzuI())
        {
          if (zzaaj.zza.zza((zzaaj.zza)zzaAc.get(localZze)) != 0) {
            break label301;
          }
          i = 1;
          k = n;
        }
      }
      for (;;)
      {
        if (k != 0) {
          m = zzaaj.zzb(zzaaj.this).isGooglePlayServicesAvailable(zzaaj.zza(zzaaj.this));
        }
        if ((m != 0) && ((i != 0) || (j != 0)))
        {
          localObject = new ConnectionResult(m, null);
          zzaaj.zzd(zzaaj.this).zza(new zzaan.zza(zzaaj.this)
          {
            public void zzvA()
            {
              zzaaj.zza(zzaaj.this, zzaAd);
            }
          });
          label155:
          return;
          k = 0;
          j = i;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (zzaaj.zze(zzaaj.this)) {
            zzaaj.zzf(zzaaj.this).connect();
          }
          localObject = zzaAc.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localZze = (Api.zze)((Iterator)localObject).next();
            final zzf.zzf localZzf = (zzf.zzf)zzaAc.get(localZze);
            if ((localZze.zzuI()) && (m != 0)) {
              zzaaj.zzd(zzaaj.this).zza(new zzaan.zza(zzaaj.this)
              {
                public void zzvA()
                {
                  localZzf.zzg(new ConnectionResult(16, null));
                }
              });
            } else {
              localZze.zza(localZzf);
            }
          }
          break label155;
          label301:
          i = j;
          j = 1;
        }
        k = i;
        i = 0;
      }
    }
  }
  
  private class zzc
    extends zzaaj.zzf
  {
    private final ArrayList<Api.zze> zzaAg;
    
    public zzc()
    {
      super(null);
      Object localObject;
      zzaAg = localObject;
    }
    
    @WorkerThread
    public void zzvA()
    {
      zzdzzazd.zzaAs = zzaaj.zzg(zzaaj.this);
      Iterator localIterator = zzaAg.iterator();
      while (localIterator.hasNext()) {
        ((Api.zze)localIterator.next()).zza(zzaaj.zzh(zzaaj.this), zzdzzazd.zzaAs);
      }
    }
  }
  
  private static class zzd
    extends zzaxr
  {
    private final WeakReference<zzaaj> zzaAb;
    
    zzd(zzaaj paramZzaaj)
    {
      zzaAb = new WeakReference(paramZzaaj);
    }
    
    @BinderThread
    public void zzb(final zzayb paramZzayb)
    {
      final zzaaj localZzaaj = (zzaaj)zzaAb.get();
      if (localZzaaj == null) {
        return;
      }
      zzaaj.zzd(localZzaaj).zza(new zzaan.zza(localZzaaj)
      {
        public void zzvA()
        {
          zzaaj.zza(localZzaaj, paramZzayb);
        }
      });
    }
  }
  
  private class zze
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zze() {}
    
    public void onConnected(Bundle paramBundle)
    {
      zzaaj.zzf(zzaaj.this).zza(new zzaaj.zzd(zzaaj.this));
    }
    
    /* Error */
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   4: invokestatic 46	com/google/android/gms/internal/zzaaj:zzc	(Lcom/google/android/gms/internal/zzaaj;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 51 1 0
      //   12: aload_0
      //   13: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   16: aload_1
      //   17: invokestatic 55	com/google/android/gms/internal/zzaaj:zzb	(Lcom/google/android/gms/internal/zzaaj;Lcom/google/android/gms/common/ConnectionResult;)Z
      //   20: ifeq +30 -> 50
      //   23: aload_0
      //   24: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   27: invokestatic 58	com/google/android/gms/internal/zzaaj:zzi	(Lcom/google/android/gms/internal/zzaaj;)V
      //   30: aload_0
      //   31: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   34: invokestatic 61	com/google/android/gms/internal/zzaaj:zzj	(Lcom/google/android/gms/internal/zzaaj;)V
      //   37: aload_0
      //   38: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   41: invokestatic 46	com/google/android/gms/internal/zzaaj:zzc	(Lcom/google/android/gms/internal/zzaaj;)Ljava/util/concurrent/locks/Lock;
      //   44: invokeinterface 64 1 0
      //   49: return
      //   50: aload_0
      //   51: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   54: aload_1
      //   55: invokestatic 67	com/google/android/gms/internal/zzaaj:zza	(Lcom/google/android/gms/internal/zzaaj;Lcom/google/android/gms/common/ConnectionResult;)V
      //   58: goto -21 -> 37
      //   61: astore_1
      //   62: aload_0
      //   63: getfield 17	com/google/android/gms/internal/zzaaj$zze:zzaAa	Lcom/google/android/gms/internal/zzaaj;
      //   66: invokestatic 46	com/google/android/gms/internal/zzaaj:zzc	(Lcom/google/android/gms/internal/zzaaj;)Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 64 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zze
      //   0	76	1	paramConnectionResult	ConnectionResult
      // Exception table:
      //   from	to	target	type
      //   12	37	61	finally
      //   50	58	61	finally
    }
    
    public void onConnectionSuspended(int paramInt) {}
  }
  
  private abstract class zzf
    implements Runnable
  {
    private zzf() {}
    
    @WorkerThread
    public void run()
    {
      zzaaj.zzc(zzaaj.this).lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool) {
          return;
        }
        zzvA();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzaaj.zzd(zzaaj.this).zza(localRuntimeException);
        return;
      }
      finally
      {
        zzaaj.zzc(zzaaj.this).unlock();
      }
    }
    
    @WorkerThread
    protected abstract void zzvA();
  }
}
