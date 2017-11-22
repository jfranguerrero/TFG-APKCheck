package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzm.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzaal
  extends GoogleApiClient
  implements zzaau.zza
{
  private final Context mContext;
  private final zzm zzaAj;
  private zzaau zzaAk = null;
  final Queue<zzzv.zza<?, ?>> zzaAl = new LinkedList();
  private volatile boolean zzaAm;
  private long zzaAn = 120000L;
  private long zzaAo = 5000L;
  private final zza zzaAp;
  zzaar zzaAq;
  final Map<Api.zzc<?>, Api.zze> zzaAr;
  Set<Scope> zzaAs = new HashSet();
  private final zzaba zzaAt = new zzaba();
  private final ArrayList<zzzy> zzaAu;
  private Integer zzaAv = null;
  Set<zzabp> zzaAw = null;
  final zzabq zzaAx;
  private final zzm.zza zzaAy = new zzm.zza()
  {
    public boolean isConnected()
    {
      return zzaal.this.isConnected();
    }
    
    public Bundle zzud()
    {
      return null;
    }
  };
  private final int zzaxV;
  private final GoogleApiAvailability zzaxX;
  final Api.zza<? extends zzaxn, zzaxo> zzaxY;
  private boolean zzayb;
  private final Lock zzazn;
  final zzg zzazs;
  final Map<Api<?>, Integer> zzazu;
  private final Looper zzrx;
  
  public zzaal(Context paramContext, Lock paramLock, Looper paramLooper, zzg paramZzg, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzaxn, zzaxo> paramZza, Map<Api<?>, Integer> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.zzc<?>, Api.zze> paramMap1, int paramInt1, int paramInt2, ArrayList<zzzy> paramArrayList, boolean paramBoolean)
  {
    mContext = paramContext;
    zzazn = paramLock;
    zzayb = paramBoolean;
    zzaAj = new zzm(paramLooper, zzaAy);
    zzrx = paramLooper;
    zzaAp = new zza(paramLooper);
    zzaxX = paramGoogleApiAvailability;
    zzaxV = paramInt1;
    if (zzaxV >= 0) {
      zzaAv = Integer.valueOf(paramInt2);
    }
    zzazu = paramMap;
    zzaAr = paramMap1;
    zzaAu = paramArrayList;
    zzaAx = new zzabq(zzaAr);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      zzaAj.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      zzaAj.registerConnectionFailedListener(paramLock);
    }
    zzazs = paramZzg;
    zzaxY = paramZza;
  }
  
  private void resume()
  {
    zzazn.lock();
    try
    {
      if (isResuming()) {
        zzvI();
      }
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public static int zza(Iterable<Api.zze> paramIterable, boolean paramBoolean)
  {
    int k = 1;
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = 0;
    if (paramIterable.hasNext())
    {
      Api.zze localZze = (Api.zze)paramIterable.next();
      if (localZze.zzqD()) {
        j = 1;
      }
      if (!localZze.zzqS()) {
        break label85;
      }
      i = 1;
    }
    label85:
    for (;;)
    {
      break;
      if (j != 0)
      {
        j = k;
        if (i != 0)
        {
          j = k;
          if (paramBoolean) {
            j = 2;
          }
        }
        return j;
      }
      return 3;
    }
  }
  
  private void zza(final GoogleApiClient paramGoogleApiClient, final zzabl paramZzabl, final boolean paramBoolean)
  {
    zzabx.zzaFp.zzg(paramGoogleApiClient).setResultCallback(new ResultCallback()
    {
      public void zzp(@NonNull Status paramAnonymousStatus)
      {
        zzl.zzaa(zzaal.zzc(zzaal.this)).zzre();
        if ((paramAnonymousStatus.isSuccess()) && (isConnected())) {
          reconnect();
        }
        paramZzabl.zzb(paramAnonymousStatus);
        if (paramBoolean) {
          paramGoogleApiClient.disconnect();
        }
      }
    });
  }
  
  private void zzb(@NonNull zzaav paramZzaav)
  {
    if (zzaxV >= 0)
    {
      zzzt.zza(paramZzaav).zzcu(zzaxV);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  private void zzcx(int paramInt)
  {
    if (zzaAv == null) {
      zzaAv = Integer.valueOf(paramInt);
    }
    Object localObject2;
    while (zzaAk != null)
    {
      return;
      if (zzaAv.intValue() != paramInt)
      {
        localObject1 = String.valueOf(zzcy(paramInt));
        localObject2 = String.valueOf(zzcy(zzaAv.intValue()));
        throw new IllegalStateException(String.valueOf(localObject1).length() + 51 + String.valueOf(localObject2).length() + "Cannot use sign-in mode: " + (String)localObject1 + ". Mode was already set to " + (String)localObject2);
      }
    }
    Object localObject1 = zzaAr.values().iterator();
    paramInt = 0;
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api.zze)((Iterator)localObject1).next();
      if (((Api.zze)localObject2).zzqD()) {
        i = 1;
      }
      if (!((Api.zze)localObject2).zzqS()) {
        break label405;
      }
      paramInt = 1;
    }
    label405:
    for (;;)
    {
      break;
      switch (zzaAv.intValue())
      {
      }
      while ((zzayb) && (paramInt == 0))
      {
        zzaAk = new zzaac(mContext, zzazn, zzrx, zzaxX, zzaAr, zzazs, zzazu, zzaxY, zzaAu, this);
        return;
        if (i == 0) {
          throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        }
        if (paramInt != 0)
        {
          throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
          if (i != 0)
          {
            zzaAk = zzaaa.zza(mContext, this, zzazn, zzrx, zzaxX, zzaAr, zzazs, zzazu, zzaxY, zzaAu);
            return;
          }
        }
      }
      zzaAk = new zzaan(mContext, this, zzazn, zzrx, zzaxX, zzaAr, zzazs, zzazu, zzaxY, zzaAu, this);
      return;
    }
  }
  
  static String zzcy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 3: 
      return "SIGN_IN_MODE_NONE";
    case 1: 
      return "SIGN_IN_MODE_REQUIRED";
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }
  
  private void zzvI()
  {
    zzaAj.zzxr();
    zzaAk.connect();
  }
  
  private void zzvJ()
  {
    zzazn.lock();
    try
    {
      if (zzvL()) {
        zzvI();
      }
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "blockingConnect must not be called on the UI thread");
      zzazn.lock();
      try
      {
        if (zzaxV >= 0) {
          if (zzaAv != null)
          {
            bool1 = bool2;
            label45:
            zzac.zza(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
          }
        }
        do
        {
          for (;;)
          {
            zzcx(zzaAv.intValue());
            zzaAj.zzxr();
            ConnectionResult localConnectionResult = zzaAk.blockingConnect();
            return localConnectionResult;
            bool1 = false;
            break;
            bool1 = false;
            break label45;
            if (zzaAv != null) {
              break label143;
            }
            zzaAv = Integer.valueOf(zza(zzaAr.values(), false));
          }
        } while (zzaAv.intValue() != 2);
      }
      finally
      {
        zzazn.unlock();
      }
    }
    label143:
    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    boolean bool = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    zzac.zza(bool, "blockingConnect must not be called on the UI thread");
    zzac.zzb(paramTimeUnit, "TimeUnit must not be null");
    zzazn.lock();
    try
    {
      if (zzaAv == null) {
        zzaAv = Integer.valueOf(zza(zzaAr.values(), false));
      }
      while (zzaAv.intValue() != 2)
      {
        zzcx(zzaAv.intValue());
        zzaAj.zzxr();
        paramTimeUnit = zzaAk.blockingConnect(paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    zzac.zza(isConnected(), "GoogleApiClient is not connected yet.");
    if (zzaAv.intValue() != 2) {}
    final zzabl localZzabl;
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localZzabl = new zzabl(this);
      if (!zzaAr.containsKey(zzabx.zzahc)) {
        break;
      }
      zza(this, localZzabl, false);
      return localZzabl;
    }
    final AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        zzaal.zza(zzaal.this, (GoogleApiClient)localAtomicReference.get(), localZzabl, true);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt) {}
    };
    GoogleApiClient.OnConnectionFailedListener local3 = new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(@NonNull ConnectionResult paramAnonymousConnectionResult)
      {
        localZzabl.zzb(new Status(8));
      }
    };
    localObject = new GoogleApiClient.Builder(mContext).addApi(zzabx.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(local3).setHandler(zzaAp).build();
    localAtomicReference.set(localObject);
    ((GoogleApiClient)localObject).connect();
    return localZzabl;
  }
  
  public void connect()
  {
    boolean bool = false;
    zzazn.lock();
    try
    {
      if (zzaxV >= 0)
      {
        if (zzaAv != null) {
          bool = true;
        }
        zzac.zza(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      do
      {
        for (;;)
        {
          connect(zzaAv.intValue());
          return;
          if (zzaAv != null) {
            break;
          }
          zzaAv = Integer.valueOf(zza(zzaAr.values(), false));
        }
      } while (zzaAv.intValue() != 2);
    }
    finally
    {
      zzazn.unlock();
    }
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public void connect(int paramInt)
  {
    boolean bool2 = true;
    zzazn.lock();
    boolean bool1 = bool2;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramInt != 1) {
        if (paramInt != 2) {
          break label77;
        }
      }
    }
    for (bool1 = bool2;; bool1 = false) {
      try
      {
        zzac.zzb(bool1, 33 + "Illegal sign-in mode: " + paramInt);
        zzcx(paramInt);
        zzvI();
        return;
      }
      finally
      {
        label77:
        zzazn.unlock();
      }
    }
  }
  
  public void disconnect()
  {
    zzazn.lock();
    try
    {
      zzaAx.release();
      if (zzaAk != null) {
        zzaAk.disconnect();
      }
      zzaAt.release();
      Iterator localIterator = zzaAl.iterator();
      while (localIterator.hasNext())
      {
        zzzv.zza localZza = (zzzv.zza)localIterator.next();
        localZza.zza(null);
        localZza.cancel();
      }
      zzaAl.clear();
    }
    finally
    {
      zzazn.unlock();
    }
    zzaau localZzaau = zzaAk;
    if (localZzaau == null)
    {
      zzazn.unlock();
      return;
    }
    zzvL();
    zzaAj.zzxq();
    zzazn.unlock();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(zzaAm);
    paramPrintWriter.append(" mWorkQueue.size()=").print(zzaAl.size());
    zzaAx.dump(paramPrintWriter);
    if (zzaAk != null) {
      zzaAk.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @NonNull
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    zzazn.lock();
    try
    {
      if ((!isConnected()) && (!isResuming())) {
        throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
      }
    }
    finally
    {
      zzazn.unlock();
    }
    if (zzaAr.containsKey(paramApi.zzuH()))
    {
      ConnectionResult localConnectionResult = zzaAk.getConnectionResult(paramApi);
      if (localConnectionResult == null)
      {
        if (isResuming())
        {
          paramApi = ConnectionResult.zzawX;
          zzazn.unlock();
          return paramApi;
        }
        Log.w("GoogleApiClientImpl", zzvN());
        Log.wtf("GoogleApiClientImpl", String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
        paramApi = new ConnectionResult(8, null);
        zzazn.unlock();
        return paramApi;
      }
      zzazn.unlock();
      return localConnectionResult;
    }
    throw new IllegalArgumentException(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public Looper getLooper()
  {
    return zzrx;
  }
  
  public int getSessionId()
  {
    return System.identityHashCode(this);
  }
  
  public boolean hasConnectedApi(@NonNull Api<?> paramApi)
  {
    if (!isConnected()) {
      return false;
    }
    paramApi = (Api.zze)zzaAr.get(paramApi.zzuH());
    if ((paramApi != null) && (paramApi.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isConnected()
  {
    return (zzaAk != null) && (zzaAk.isConnected());
  }
  
  public boolean isConnecting()
  {
    return (zzaAk != null) && (zzaAk.isConnecting());
  }
  
  public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return zzaAj.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return zzaAj.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  boolean isResuming()
  {
    return zzaAm;
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaAj.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaAj.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity)
  {
    zzb(new zzaav(paramFragmentActivity));
  }
  
  public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaAj.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaAj.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @NonNull
  public <C extends Api.zze> C zza(@NonNull Api.zzc<C> paramZzc)
  {
    paramZzc = (Api.zze)zzaAr.get(paramZzc);
    zzac.zzb(paramZzc, "Appropriate Api was not requested.");
    return paramZzc;
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(@NonNull T paramT)
  {
    boolean bool;
    if (paramT.zzuH() != null) {
      bool = true;
    }
    for (;;)
    {
      zzac.zzb(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      bool = zzaAr.containsKey(paramT.zzuH());
      String str;
      if (paramT.getApi() != null)
      {
        str = paramT.getApi().getName();
        label45:
        zzac.zzb(bool, String.valueOf(str).length() + 65 + "GoogleApiClient is not configured to use " + str + " required for this call.");
        zzazn.lock();
      }
      try
      {
        if (zzaAk == null)
        {
          zzaAl.add(paramT);
          return paramT;
          bool = false;
          continue;
          str = "the API";
          break label45;
        }
        paramT = zzaAk.zza(paramT);
        return paramT;
      }
      finally
      {
        zzazn.unlock();
      }
    }
  }
  
  public void zza(zzabp paramZzabp)
  {
    zzazn.lock();
    try
    {
      if (zzaAw == null) {
        zzaAw = new HashSet();
      }
      zzaAw.add(paramZzabp);
      return;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public boolean zza(@NonNull Api<?> paramApi)
  {
    return zzaAr.containsKey(paramApi.zzuH());
  }
  
  public boolean zza(zzabi paramZzabi)
  {
    return (zzaAk != null) && (zzaAk.zza(paramZzabi));
  }
  
  <C extends Api.zze> C zzb(Api.zzc<?> paramZzc)
  {
    paramZzc = (Api.zze)zzaAr.get(paramZzc);
    zzac.zzb(paramZzc, "Appropriate Api was not requested.");
    return paramZzc;
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    boolean bool;
    if (paramT.zzuH() != null)
    {
      bool = true;
      zzac.zzb(bool, "This task can not be executed (it's probably a Batch or malformed)");
      bool = zzaAr.containsKey(paramT.zzuH());
      if (paramT.getApi() == null) {
        break label129;
      }
    }
    label129:
    for (Object localObject = paramT.getApi().getName();; localObject = "the API")
    {
      zzac.zzb(bool, String.valueOf(localObject).length() + 65 + "GoogleApiClient is not configured to use " + (String)localObject + " required for this call.");
      zzazn.lock();
      try
      {
        if (zzaAk != null) {
          break label136;
        }
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        zzazn.unlock();
      }
      bool = false;
      break;
    }
    label136:
    if (isResuming())
    {
      zzaAl.add(paramT);
      while (!zzaAl.isEmpty())
      {
        localObject = (zzzv.zza)zzaAl.remove();
        zzaAx.zzb((zzzx)localObject);
        ((zzzv.zza)localObject).zzA(Status.zzayj);
      }
      zzazn.unlock();
      return paramT;
    }
    paramT = zzaAk.zzb(paramT);
    zzazn.unlock();
    return paramT;
  }
  
  public void zzb(zzabp paramZzabp)
  {
    zzazn.lock();
    for (;;)
    {
      try
      {
        if (zzaAw == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!zzaAw.remove(paramZzabp))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
        if (zzvM()) {
          continue;
        }
      }
      finally
      {
        zzazn.unlock();
      }
      zzaAk.zzvj();
    }
  }
  
  public void zzc(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean)) {
      zzvK();
    }
    zzaAx.zzww();
    zzaAj.zzcP(paramInt);
    zzaAj.zzxq();
    if (paramInt == 2) {
      zzvI();
    }
  }
  
  public void zzc(ConnectionResult paramConnectionResult)
  {
    if (!zzaxX.zzd(mContext, paramConnectionResult.getErrorCode())) {
      zzvL();
    }
    if (!isResuming())
    {
      zzaAj.zzo(paramConnectionResult);
      zzaAj.zzxq();
    }
  }
  
  public void zzo(Bundle paramBundle)
  {
    while (!zzaAl.isEmpty()) {
      zzb((zzzv.zza)zzaAl.remove());
    }
    zzaAj.zzq(paramBundle);
  }
  
  public <L> zzaaz<L> zzr(@NonNull L paramL)
  {
    zzazn.lock();
    try
    {
      paramL = zzaAt.zzb(paramL, zzrx);
      return paramL;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  public void zzuN()
  {
    if (zzaAk != null) {
      zzaAk.zzuN();
    }
  }
  
  void zzvK()
  {
    if (isResuming()) {
      return;
    }
    zzaAm = true;
    if (zzaAq == null) {
      zzaAq = zzaxX.zza(mContext.getApplicationContext(), new zzb(this));
    }
    zzaAp.sendMessageDelayed(zzaAp.obtainMessage(1), zzaAn);
    zzaAp.sendMessageDelayed(zzaAp.obtainMessage(2), zzaAo);
  }
  
  boolean zzvL()
  {
    if (!isResuming()) {
      return false;
    }
    zzaAm = false;
    zzaAp.removeMessages(2);
    zzaAp.removeMessages(1);
    if (zzaAq != null)
    {
      zzaAq.unregister();
      zzaAq = null;
    }
    return true;
  }
  
  boolean zzvM()
  {
    boolean bool1 = false;
    zzazn.lock();
    try
    {
      Set localSet = zzaAw;
      if (localSet == null) {
        return false;
      }
      boolean bool2 = zzaAw.isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      zzazn.unlock();
    }
  }
  
  String zzvN()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  final class zza
    extends Handler
  {
    zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        int i = what;
        Log.w("GoogleApiClientImpl", 31 + "Unknown message id: " + i);
        return;
      case 1: 
        zzaal.zzb(zzaal.this);
        return;
      }
      zzaal.zza(zzaal.this);
    }
  }
  
  static class zzb
    extends zzaar.zza
  {
    private WeakReference<zzaal> zzaAD;
    
    zzb(zzaal paramZzaal)
    {
      zzaAD = new WeakReference(paramZzaal);
    }
    
    public void zzvb()
    {
      zzaal localZzaal = (zzaal)zzaAD.get();
      if (localZzaal == null) {
        return;
      }
      zzaal.zza(localZzaal);
    }
  }
}
