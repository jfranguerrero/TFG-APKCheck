package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zzaap
  implements Handler.Callback
{
  public static final Status zzaAO = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status zzaAP = new Status(4, "The user must be signed in to make this API call.");
  private static zzaap zzaAR;
  private static final Object zztU = new Object();
  private final Context mContext;
  private final Handler mHandler;
  private long zzaAQ = 10000L;
  private int zzaAS = -1;
  private final AtomicInteger zzaAT = new AtomicInteger(1);
  private final AtomicInteger zzaAU = new AtomicInteger(0);
  private zzaae zzaAV = null;
  private final Set<zzzs<?>> zzaAW = new zza();
  private final Set<zzzs<?>> zzaAX = new zza();
  private long zzaAn = 120000L;
  private long zzaAo = 5000L;
  private final GoogleApiAvailability zzaxX;
  private final Map<zzzs<?>, zza<?>> zzazt = new ConcurrentHashMap(5, 0.75F, 1);
  
  private zzaap(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    mContext = paramContext;
    mHandler = new Handler(paramLooper, this);
    zzaxX = paramGoogleApiAvailability;
  }
  
  @WorkerThread
  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Object localObject = zzazt.values().iterator();
    zza localZza;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localZza = (zza)((Iterator)localObject).next();
    } while (localZza.getInstanceId() != paramInt);
    for (;;)
    {
      if (localZza != null)
      {
        localObject = String.valueOf(zzaxX.getErrorString(paramConnectionResult.getErrorCode()));
        paramConnectionResult = String.valueOf(paramConnectionResult.getErrorMessage());
        localZza.zzC(new Status(17, String.valueOf(localObject).length() + 69 + String.valueOf(paramConnectionResult).length() + "Error resolution was canceled by the user, original error message: " + (String)localObject + ": " + paramConnectionResult));
        return;
      }
      Log.wtf("GoogleApiManager", 76 + "Could not find API instance " + paramInt + " while trying to fail enqueued calls.", new Exception());
      return;
      localZza = null;
    }
  }
  
  @WorkerThread
  private void zza(zzabd paramZzabd)
  {
    zza localZza2 = (zza)zzazt.get(zzaBF.getApiKey());
    zza localZza1 = localZza2;
    if (localZza2 == null)
    {
      zzb(zzaBF);
      localZza1 = (zza)zzazt.get(zzaBF.getApiKey());
    }
    if ((localZza1.zzqD()) && (zzaAU.get() != zzaBE))
    {
      zzaBD.zzy(zzaAO);
      localZza1.signOut();
      return;
    }
    localZza1.zza(zzaBD);
  }
  
  @WorkerThread
  private void zza(zzzu paramZzzu)
  {
    Iterator localIterator = paramZzzu.zzuY().iterator();
    for (;;)
    {
      zzzs localZzzs;
      zza localZza;
      if (localIterator.hasNext())
      {
        localZzzs = (zzzs)localIterator.next();
        localZza = (zza)zzazt.get(localZzzs);
        if (localZza == null) {
          paramZzzu.zza(localZzzs, new ConnectionResult(13));
        }
      }
      else
      {
        return;
      }
      if (localZza.isConnected()) {
        paramZzzu.zza(localZzzs, ConnectionResult.zzawX);
      } else if (localZza.zzwe() != null) {
        paramZzzu.zza(localZzzs, localZza.zzwe());
      } else {
        localZza.zzb(paramZzzu);
      }
    }
  }
  
  public static zzaap zzax(Context paramContext)
  {
    synchronized (zztU)
    {
      if (zzaAR == null)
      {
        Looper localLooper = zzvT();
        zzaAR = new zzaap(paramContext.getApplicationContext(), localLooper, GoogleApiAvailability.getInstance());
      }
      paramContext = zzaAR;
      return paramContext;
    }
  }
  
  @WorkerThread
  private void zzb(zzc<?> paramZzc)
  {
    zzzs localZzzs = paramZzc.getApiKey();
    if (!zzazt.containsKey(localZzzs)) {
      zzazt.put(localZzzs, new zza(paramZzc));
    }
    paramZzc = (zza)zzazt.get(localZzzs);
    if (paramZzc.zzqD()) {
      zzaAX.add(localZzzs);
    }
    paramZzc.connect();
  }
  
  public static zzaap zzvS()
  {
    synchronized (zztU)
    {
      zzac.zzb(zzaAR, "Must guarantee manager is non-null before using getInstance");
      zzaap localZzaap = zzaAR;
      return localZzaap;
    }
  }
  
  private static Looper zzvT()
  {
    HandlerThread localHandlerThread = new HandlerThread("GoogleApiHandler", 9);
    localHandlerThread.start();
    return localHandlerThread.getLooper();
  }
  
  @WorkerThread
  private void zzvV()
  {
    Iterator localIterator = zzazt.values().iterator();
    while (localIterator.hasNext())
    {
      zza localZza = (zza)localIterator.next();
      localZza.zzwd();
      localZza.connect();
    }
  }
  
  @WorkerThread
  private void zzvW()
  {
    Iterator localIterator = zzaAX.iterator();
    while (localIterator.hasNext())
    {
      zzzs localZzzs = (zzzs)localIterator.next();
      ((zza)zzazt.remove(localZzzs)).signOut();
    }
    zzaAX.clear();
  }
  
  @WorkerThread
  public boolean handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      int i = what;
      Log.w("GoogleApiManager", 31 + "Unknown message id: " + i);
      return false;
    case 1: 
      zza((zzzu)obj);
    }
    for (;;)
    {
      return true;
      zzb((zzc)obj);
      continue;
      zzvV();
      continue;
      zza((zzabd)obj);
      continue;
      zza(arg1, (ConnectionResult)obj);
      continue;
      if (zzazt.containsKey(obj))
      {
        ((zza)zzazt.get(obj)).resume();
        continue;
        zzvW();
        continue;
        if (zzazt.containsKey(obj))
        {
          ((zza)zzazt.get(obj)).zzvJ();
          continue;
          if (zzazt.containsKey(obj)) {
            ((zza)zzazt.get(obj)).zzwh();
          }
        }
      }
    }
  }
  
  public <O extends Api.ApiOptions> Task<Void> zza(@NonNull zzc<O> paramZzc, @NonNull zzaaz.zzb<?> paramZzb)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramZzb = new zzzq.zze(paramZzb, localTaskCompletionSource);
    mHandler.sendMessage(mHandler.obtainMessage(11, new zzabd(paramZzb, zzaAU.get(), paramZzc)));
    return localTaskCompletionSource.getTask();
  }
  
  public <O extends Api.ApiOptions> Task<Void> zza(@NonNull zzc<O> paramZzc, @NonNull zzabe<Api.zzb, ?> paramZzabe, @NonNull zzabr<Api.zzb, ?> paramZzabr)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramZzabe = new zzzq.zzc(new zzabf(paramZzabe, paramZzabr), localTaskCompletionSource);
    mHandler.sendMessage(mHandler.obtainMessage(6, new zzabd(paramZzabe, zzaAU.get(), paramZzc)));
    return localTaskCompletionSource.getTask();
  }
  
  public Task<Void> zza(Iterable<zzc<?>> paramIterable)
  {
    zzzu localZzzu = new zzzu(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (zzc)paramIterable.next();
      localObject = (zza)zzazt.get(((zzc)localObject).getApiKey());
      if ((localObject == null) || (!((zza)localObject).isConnected()))
      {
        mHandler.sendMessage(mHandler.obtainMessage(1, localZzzu));
        return localZzzu.getTask();
      }
    }
    localZzzu.zzuZ();
    return localZzzu.getTask();
  }
  
  public void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zzc(paramConnectionResult, paramInt)) {
      mHandler.sendMessage(mHandler.obtainMessage(4, paramInt, 0, paramConnectionResult));
    }
  }
  
  public void zza(zzc<?> paramZzc)
  {
    mHandler.sendMessage(mHandler.obtainMessage(5, paramZzc));
  }
  
  public <O extends Api.ApiOptions, TResult> void zza(zzc<O> paramZzc, int paramInt, zzabn<Api.zzb, TResult> paramZzabn, TaskCompletionSource<TResult> paramTaskCompletionSource, zzabk paramZzabk)
  {
    paramZzabn = new zzzq.zzd(paramInt, paramZzabn, paramTaskCompletionSource, paramZzabk);
    mHandler.sendMessage(mHandler.obtainMessage(3, new zzabd(paramZzabn, zzaAU.get(), paramZzc)));
  }
  
  public <O extends Api.ApiOptions> void zza(zzc<O> paramZzc, int paramInt, zzzv.zza<? extends Result, Api.zzb> paramZza)
  {
    paramZza = new zzzq.zzb(paramInt, paramZza);
    mHandler.sendMessage(mHandler.obtainMessage(3, new zzabd(paramZza, zzaAU.get(), paramZzc)));
  }
  
  public void zza(@NonNull zzaae paramZzaae)
  {
    synchronized (zztU)
    {
      if (zzaAV != paramZzaae)
      {
        zzaAV = paramZzaae;
        zzaAW.clear();
        zzaAW.addAll(paramZzaae.zzvx());
      }
      return;
    }
  }
  
  void zzb(@NonNull zzaae paramZzaae)
  {
    synchronized (zztU)
    {
      if (zzaAV == paramZzaae)
      {
        zzaAV = null;
        zzaAW.clear();
      }
      return;
    }
  }
  
  boolean zzc(ConnectionResult paramConnectionResult, int paramInt)
  {
    if ((paramConnectionResult.hasResolution()) || (zzaxX.isUserResolvableError(paramConnectionResult.getErrorCode())))
    {
      zzaxX.zza(mContext, paramConnectionResult, paramInt);
      return true;
    }
    return false;
  }
  
  public void zzuW()
  {
    mHandler.sendMessage(mHandler.obtainMessage(2));
  }
  
  public int zzvU()
  {
    return zzaAT.getAndIncrement();
  }
  
  public class zza<O extends Api.ApiOptions>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzzz
  {
    private final Queue<zzzq> zzaAY = new LinkedList();
    private final Api.zzb zzaAZ;
    private boolean zzaAm;
    private final zzaad zzaBa;
    private final Set<zzzu> zzaBb = new HashSet();
    private final Map<zzaaz.zzb<?>, zzabf> zzaBc = new HashMap();
    private final int zzaBd;
    private final zzabj zzaBe;
    private ConnectionResult zzaBf = null;
    private final zzzs<O> zzaxH;
    private final Api.zze zzazq;
    
    @WorkerThread
    public zza()
    {
      Object localObject;
      zzazq = localObject.buildApiClient(zzaap.zza(zzaap.this).getLooper(), this);
      if ((zzazq instanceof zzal)) {}
      for (zzaAZ = ((zzal)zzazq).zzxG();; zzaAZ = zzazq)
      {
        zzaxH = localObject.getApiKey();
        zzaBa = new zzaad();
        zzaBd = localObject.getInstanceId();
        if (!zzazq.zzqD()) {
          break;
        }
        zzaBe = localObject.createSignInCoordinator(zzaap.zzb(zzaap.this), zzaap.zza(zzaap.this));
        return;
      }
      zzaBe = null;
    }
    
    @WorkerThread
    private void zzb(zzzq paramZzzq)
    {
      paramZzzq.zza(zzaBa, zzqD());
      try
      {
        paramZzzq.zza(this);
        return;
      }
      catch (DeadObjectException paramZzzq)
      {
        onConnectionSuspended(1);
        zzazq.disconnect();
      }
    }
    
    @WorkerThread
    private void zzj(ConnectionResult paramConnectionResult)
    {
      Iterator localIterator = zzaBb.iterator();
      while (localIterator.hasNext()) {
        ((zzzu)localIterator.next()).zza(zzaxH, paramConnectionResult);
      }
      zzaBb.clear();
    }
    
    @WorkerThread
    private void zzvZ()
    {
      zzwd();
      zzj(ConnectionResult.zzawX);
      zzwf();
      Iterator localIterator = zzaBc.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          localIterator.next();
        }
        try
        {
          new TaskCompletionSource();
        }
        catch (DeadObjectException localDeadObjectException)
        {
          onConnectionSuspended(1);
          zzazq.disconnect();
          zzwb();
          zzwg();
          return;
        }
        catch (RemoteException localRemoteException) {}
      }
    }
    
    @WorkerThread
    private void zzwa()
    {
      zzwd();
      zzaAm = true;
      zzaBa.zzvw();
      zzaap.zza(zzaap.this).sendMessageDelayed(Message.obtain(zzaap.zza(zzaap.this), 7, zzaxH), zzaap.zzc(zzaap.this));
      zzaap.zza(zzaap.this).sendMessageDelayed(Message.obtain(zzaap.zza(zzaap.this), 9, zzaxH), zzaap.zzd(zzaap.this));
      zzaap.zza(zzaap.this, -1);
    }
    
    @WorkerThread
    private void zzwb()
    {
      while ((zzazq.isConnected()) && (!zzaAY.isEmpty())) {
        zzb((zzzq)zzaAY.remove());
      }
    }
    
    @WorkerThread
    private void zzwf()
    {
      if (zzaAm)
      {
        zzaap.zza(zzaap.this).removeMessages(9, zzaxH);
        zzaap.zza(zzaap.this).removeMessages(7, zzaxH);
        zzaAm = false;
      }
    }
    
    private void zzwg()
    {
      zzaap.zza(zzaap.this).removeMessages(10, zzaxH);
      zzaap.zza(zzaap.this).sendMessageDelayed(zzaap.zza(zzaap.this).obtainMessage(10, zzaxH), zzaap.zzh(zzaap.this));
    }
    
    @WorkerThread
    public void connect()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      if ((zzazq.isConnected()) || (zzazq.isConnecting())) {
        return;
      }
      if ((zzazq.zzuI()) && (zzaap.zzi(zzaap.this) != 0))
      {
        zzaap.zza(zzaap.this, zzaap.zzg(zzaap.this).isGooglePlayServicesAvailable(zzaap.zzb(zzaap.this)));
        if (zzaap.zzi(zzaap.this) != 0)
        {
          onConnectionFailed(new ConnectionResult(zzaap.zzi(zzaap.this), null));
          return;
        }
      }
      zzaap.zzb localZzb = new zzaap.zzb(zzaap.this, zzazq, zzaxH);
      if (zzazq.zzqD()) {
        zzaBe.zza(localZzb);
      }
      zzazq.zza(localZzb);
    }
    
    public int getInstanceId()
    {
      return zzaBd;
    }
    
    boolean isConnected()
    {
      return zzazq.isConnected();
    }
    
    public void onConnected(@Nullable Bundle paramBundle)
    {
      if (Looper.myLooper() == zzaap.zza(zzaap.this).getLooper())
      {
        zzvZ();
        return;
      }
      zzaap.zza(zzaap.this).post(new Runnable()
      {
        public void run()
        {
          zzaap.zza.zzc(zzaap.zza.this);
        }
      });
    }
    
    @WorkerThread
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      zzac.zza(zzaap.zza(zzaap.this));
      if (zzaBe != null) {
        zzaBe.zzwr();
      }
      zzwd();
      zzaap.zza(zzaap.this, -1);
      zzj(paramConnectionResult);
      if (paramConnectionResult.getErrorCode() == 4) {
        zzC(zzaap.zzvX());
      }
      do
      {
        return;
        if (zzaAY.isEmpty())
        {
          zzaBf = paramConnectionResult;
          return;
        }
        synchronized (zzaap.zzvY())
        {
          if ((zzaap.zze(zzaap.this) != null) && (zzaap.zzf(zzaap.this).contains(zzaxH)))
          {
            zzaap.zze(zzaap.this).zzb(paramConnectionResult, zzaBd);
            return;
          }
        }
      } while (zzc(paramConnectionResult, zzaBd));
      if (paramConnectionResult.getErrorCode() == 18) {
        zzaAm = true;
      }
      if (zzaAm)
      {
        zzaap.zza(zzaap.this).sendMessageDelayed(Message.obtain(zzaap.zza(zzaap.this), 7, zzaxH), zzaap.zzc(zzaap.this));
        return;
      }
      paramConnectionResult = String.valueOf(zzaxH.zzuV());
      zzC(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      if (Looper.myLooper() == zzaap.zza(zzaap.this).getLooper())
      {
        zzwa();
        return;
      }
      zzaap.zza(zzaap.this).post(new Runnable()
      {
        public void run()
        {
          zzaap.zza.zzd(zzaap.zza.this);
        }
      });
    }
    
    @WorkerThread
    public void resume()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      if (zzaAm) {
        connect();
      }
    }
    
    @WorkerThread
    public void signOut()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      zzC(zzaap.zzaAO);
      zzaBa.zzvv();
      Iterator localIterator = zzaBc.keySet().iterator();
      while (localIterator.hasNext()) {
        zza(new zzzq.zze((zzaaz.zzb)localIterator.next(), new TaskCompletionSource()));
      }
      zzazq.disconnect();
    }
    
    @WorkerThread
    public void zzC(Status paramStatus)
    {
      zzac.zza(zzaap.zza(zzaap.this));
      Iterator localIterator = zzaAY.iterator();
      while (localIterator.hasNext()) {
        ((zzzq)localIterator.next()).zzy(paramStatus);
      }
      zzaAY.clear();
    }
    
    public void zza(final ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
    {
      if (Looper.myLooper() == zzaap.zza(zzaap.this).getLooper())
      {
        onConnectionFailed(paramConnectionResult);
        return;
      }
      zzaap.zza(zzaap.this).post(new Runnable()
      {
        public void run()
        {
          onConnectionFailed(paramConnectionResult);
        }
      });
    }
    
    @WorkerThread
    public void zza(zzzq paramZzzq)
    {
      zzac.zza(zzaap.zza(zzaap.this));
      if (zzazq.isConnected())
      {
        zzb(paramZzzq);
        zzwg();
        return;
      }
      zzaAY.add(paramZzzq);
      if ((zzaBf != null) && (zzaBf.hasResolution()))
      {
        onConnectionFailed(zzaBf);
        return;
      }
      connect();
    }
    
    @WorkerThread
    public void zzb(zzzu paramZzzu)
    {
      zzac.zza(zzaap.zza(zzaap.this));
      zzaBb.add(paramZzzu);
    }
    
    @WorkerThread
    public void zzi(@NonNull ConnectionResult paramConnectionResult)
    {
      zzac.zza(zzaap.zza(zzaap.this));
      zzazq.disconnect();
      onConnectionFailed(paramConnectionResult);
    }
    
    public boolean zzqD()
    {
      return zzazq.zzqD();
    }
    
    @WorkerThread
    public void zzvJ()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      if (zzaAm)
      {
        zzwf();
        if (zzaap.zzg(zzaap.this).isGooglePlayServicesAvailable(zzaap.zzb(zzaap.this)) != 18) {
          break label71;
        }
      }
      label71:
      for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
      {
        zzC(localStatus);
        zzazq.disconnect();
        return;
      }
    }
    
    public Api.zze zzvr()
    {
      return zzazq;
    }
    
    public Map<zzaaz.zzb<?>, zzabf> zzwc()
    {
      return zzaBc;
    }
    
    @WorkerThread
    public void zzwd()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      zzaBf = null;
    }
    
    @WorkerThread
    public ConnectionResult zzwe()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      return zzaBf;
    }
    
    @WorkerThread
    public void zzwh()
    {
      zzac.zza(zzaap.zza(zzaap.this));
      if ((zzazq.isConnected()) && (zzaBc.size() == 0))
      {
        if (zzaBa.zzvu()) {
          zzwg();
        }
      }
      else {
        return;
      }
      zzazq.disconnect();
    }
  }
  
  private class zzb
    implements zzf.zzf, zzabj.zza
  {
    private boolean zzaBj = false;
    private Set<Scope> zzajm = null;
    private final zzzs<?> zzaxH;
    private zzr zzazW = null;
    private final Api.zze zzazq;
    
    public zzb(zzzs<?> paramZzzs)
    {
      zzazq = paramZzzs;
      Object localObject;
      zzaxH = localObject;
    }
    
    @WorkerThread
    private void zzwi()
    {
      if ((zzaBj) && (zzazW != null)) {
        zzazq.zza(zzazW, zzajm);
      }
    }
    
    @WorkerThread
    public void zzb(zzr paramZzr, Set<Scope> paramSet)
    {
      if ((paramZzr == null) || (paramSet == null))
      {
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zzi(new ConnectionResult(4));
        return;
      }
      zzazW = paramZzr;
      zzajm = paramSet;
      zzwi();
    }
    
    public void zzg(@NonNull final ConnectionResult paramConnectionResult)
    {
      zzaap.zza(zzaap.this).post(new Runnable()
      {
        public void run()
        {
          if (paramConnectionResult.isSuccess())
          {
            zzaap.zzb.zza(zzaap.zzb.this, true);
            if (zzaap.zzb.zza(zzaap.zzb.this).zzqD())
            {
              zzaap.zzb.zzb(zzaap.zzb.this);
              return;
            }
            zzaap.zzb.zza(zzaap.zzb.this).zza(null, Collections.emptySet());
            return;
          }
          ((zzaap.zza)zzaap.zzj(zzaap.this).get(zzaap.zzb.zzc(zzaap.zzb.this))).onConnectionFailed(paramConnectionResult);
        }
      });
    }
    
    @WorkerThread
    public void zzi(ConnectionResult paramConnectionResult)
    {
      ((zzaap.zza)zzaap.zzj(zzaap.this).get(zzaxH)).zzi(paramConnectionResult);
    }
  }
}
