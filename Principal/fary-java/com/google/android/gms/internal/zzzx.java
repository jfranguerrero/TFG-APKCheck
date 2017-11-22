package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzzx<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zzayN = new ThreadLocal()
  {
    protected Boolean zzvg()
    {
      return Boolean.valueOf(false);
    }
  };
  private boolean zzJ;
  private final Object zzayO = new Object();
  protected final zza<R> zzayP;
  protected final WeakReference<GoogleApiClient> zzayQ;
  private final ArrayList<PendingResult.zza> zzayR = new ArrayList();
  private ResultCallback<? super R> zzayS;
  private final AtomicReference<zzabq.zzb> zzayT = new AtomicReference();
  private zzb zzayU;
  private volatile boolean zzayV;
  private boolean zzayW;
  private zzs zzayX;
  private volatile zzabp<R> zzayY;
  private boolean zzayZ = false;
  private R zzayd;
  private final CountDownLatch zzth = new CountDownLatch(1);
  
  @Deprecated
  zzzx()
  {
    zzayP = new zza(Looper.getMainLooper());
    zzayQ = new WeakReference(null);
  }
  
  @Deprecated
  protected zzzx(Looper paramLooper)
  {
    zzayP = new zza(paramLooper);
    zzayQ = new WeakReference(null);
  }
  
  protected zzzx(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (Looper localLooper = paramGoogleApiClient.getLooper();; localLooper = Looper.getMainLooper())
    {
      zzayP = new zza(localLooper);
      zzayQ = new WeakReference(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (zzayO)
    {
      if (!zzayV)
      {
        zzac.zza(bool, "Result has already been consumed.");
        zzac.zza(isReady(), "Result is not ready.");
        Result localResult = zzayd;
        zzayd = null;
        zzayS = null;
        zzayV = true;
        zzvd();
        return localResult;
      }
      bool = false;
    }
  }
  
  private void zzc(R paramR)
  {
    zzayd = paramR;
    zzayX = null;
    zzth.countDown();
    paramR = zzayd.getStatus();
    if (zzJ) {
      zzayS = null;
    }
    for (;;)
    {
      Iterator localIterator = zzayR.iterator();
      while (localIterator.hasNext()) {
        ((PendingResult.zza)localIterator.next()).zzx(paramR);
      }
      if (zzayS == null)
      {
        if ((zzayd instanceof Releasable)) {
          zzayU = new zzb(null);
        }
      }
      else
      {
        zzayP.zzvh();
        zzayP.zza(zzayS, get());
      }
    }
    zzayR.clear();
  }
  
  public static void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramResult = String.valueOf(paramResult);
      Log.w("BasePendingResult", String.valueOf(paramResult).length() + 18 + "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  private void zzvd()
  {
    zzabq.zzb localZzb = (zzabq.zzb)zzayT.getAndSet(null);
    if (localZzb != null) {
      localZzb.zzc(this);
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "await must not be called on the UI thread");
      if (!zzayV)
      {
        bool1 = true;
        label28:
        zzac.zza(bool1, "Result has already been consumed");
        if (zzayY != null) {
          break label80;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        zzth.await();
        zzac.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label28;
        label80:
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzB(Status.zzayi);
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!zzayV)
      {
        bool1 = true;
        label39:
        zzac.zza(bool1, "Result has already been consumed.");
        if (zzayY != null) {
          break label109;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!zzth.await(paramLong, paramTimeUnit)) {
          zzB(Status.zzayk);
        }
        zzac.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label39;
        label109:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzB(Status.zzayi);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (zzayO)
    {
      if ((zzJ) || (zzayV)) {
        return;
      }
      zzs localZzs = zzayX;
      if (localZzs == null) {}
    }
    try
    {
      zzayX.cancel();
      zzd(zzayd);
      zzJ = true;
      zzc(zzc(Status.zzayl));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (zzayO)
    {
      boolean bool = zzJ;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return zzth.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    Object localObject = zzayO;
    if (paramResultCallback == null) {}
    try
    {
      zzayS = null;
      return;
    }
    finally {}
    if (!zzayV)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (zzayY != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (isReady()) {
      zzayP.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      zzayS = paramResultCallback;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    Object localObject = zzayO;
    if (paramResultCallback == null) {}
    try
    {
      zzayS = null;
      return;
    }
    finally {}
    if (!zzayV)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (zzayY != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label90;
      }
      return;
      bool1 = false;
      break;
    }
    label90:
    if (isReady()) {
      zzayP.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      zzayS = paramResultCallback;
      zzayP.zza(this, paramTimeUnit.toMillis(paramLong));
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!zzayV)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (zzayO)
      {
        if (zzayY != null) {
          break label136;
        }
        bool1 = true;
        zzac.zza(bool1, "Cannot call then() twice.");
        if (zzayS != null) {
          break label141;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot call then() if callbacks are set.");
        zzayZ = true;
        zzayY = new zzabp(zzayQ);
        paramResultTransform = zzayY.then(paramResultTransform);
        if (isReady())
        {
          zzayP.zza(zzayY, get());
          return paramResultTransform;
        }
        zzayS = zzayY;
      }
      bool1 = false;
      break;
      label136:
      bool1 = false;
      continue;
      label141:
      bool1 = false;
    }
  }
  
  public final void zzB(Status paramStatus)
  {
    synchronized (zzayO)
    {
      if (!isReady())
      {
        zzb(zzc(paramStatus));
        zzayW = true;
      }
      return;
    }
  }
  
  public final void zza(PendingResult.zza paramZza)
  {
    boolean bool2 = true;
    if (!zzayV)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (paramZza == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zzb(bool1, "Callback cannot be null.");
      synchronized (zzayO)
      {
        if (isReady())
        {
          paramZza.zzx(zzayd.getStatus());
          return;
        }
        zzayR.add(paramZza);
      }
      bool1 = false;
      break;
    }
  }
  
  protected final void zza(zzs paramZzs)
  {
    synchronized (zzayO)
    {
      zzayX = paramZzs;
      return;
    }
  }
  
  public void zza(zzabq.zzb paramZzb)
  {
    zzayT.set(paramZzb);
  }
  
  public final void zzb(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (zzayO)
      {
        if ((!zzayW) && (!zzJ))
        {
          if ((!isReady()) || (!isReady()))
          {
            bool1 = true;
            zzac.zza(bool1, "Results have already been set");
            if (zzayV) {
              break label91;
            }
            bool1 = bool2;
            zzac.zza(bool1, "Result has already been consumed");
            zzc(paramR);
          }
        }
        else
        {
          zzd(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label91:
      bool1 = false;
    }
  }
  
  @NonNull
  protected abstract R zzc(Status paramStatus);
  
  public Integer zzuR()
  {
    return null;
  }
  
  public boolean zzvc()
  {
    synchronized (zzayO)
    {
      if (((GoogleApiClient)zzayQ.get() == null) || (!zzayZ)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public void zzve()
  {
    setResultCallback(null);
  }
  
  public void zzvf()
  {
    if ((zzayZ) || (((Boolean)zzayN.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      zzayZ = bool;
      return;
    }
  }
  
  public static class zza<R extends Result>
    extends Handler
  {
    public zza()
    {
      this(Looper.getMainLooper());
    }
    
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        int i = what;
        Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
        return;
      case 1: 
        paramMessage = (Pair)obj;
        zzb((ResultCallback)first, (Result)second);
        return;
      }
      ((zzzx)obj).zzB(Status.zzayk);
    }
    
    public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void zza(zzzx<R> paramZzzx, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramZzzx), paramLong);
    }
    
    protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        zzzx.zzd(paramR);
        throw paramResultCallback;
      }
    }
    
    public void zzvh()
    {
      removeMessages(2);
    }
  }
  
  private final class zzb
  {
    private zzb() {}
    
    protected void finalize()
      throws Throwable
    {
      zzzx.zzd(zzzx.zza(zzzx.this));
      super.finalize();
    }
  }
}
