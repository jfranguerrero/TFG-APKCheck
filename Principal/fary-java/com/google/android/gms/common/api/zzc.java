package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzaae;
import com.google.android.gms.internal.zzaap;
import com.google.android.gms.internal.zzaap.zza;
import com.google.android.gms.internal.zzaaq;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzaaz.zzb;
import com.google.android.gms.internal.zzaba;
import com.google.android.gms.internal.zzabe;
import com.google.android.gms.internal.zzabj;
import com.google.android.gms.internal.zzabk;
import com.google.android.gms.internal.zzabn;
import com.google.android.gms.internal.zzabr;
import com.google.android.gms.internal.zzzr;
import com.google.android.gms.internal.zzzs;
import com.google.android.gms.internal.zzzv.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzc<O extends Api.ApiOptions>
{
  private final Context mContext;
  private final int mId;
  private final Api<O> zzawb;
  private final O zzaxG;
  private final zzzs<O> zzaxH;
  private final GoogleApiClient zzaxI;
  private final zzabk zzaxJ;
  protected final zzaap zzaxK;
  private final Looper zzrx;
  
  @MainThread
  public zzc(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, Looper paramLooper, zzabk paramZzabk)
  {
    zzac.zzb(paramActivity, "Null activity is not permitted.");
    zzac.zzb(paramApi, "Api must not be null.");
    zzac.zzb(paramLooper, "Looper must not be null.");
    mContext = paramActivity.getApplicationContext();
    zzawb = paramApi;
    zzaxG = paramO;
    zzrx = paramLooper;
    zzaxH = zzzs.zza(zzawb, zzaxG);
    zzaxI = new zzaaq(this);
    zzaxK = zzaap.zzax(mContext);
    mId = zzaxK.zzvU();
    zzaxJ = paramZzabk;
    zzaae.zza(paramActivity, zzaxK, zzaxH);
    zzaxK.zza(this);
  }
  
  public zzc(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, zzabk paramZzabk)
  {
    this(paramActivity, paramApi, paramO, paramActivity.getMainLooper(), paramZzabk);
  }
  
  protected zzc(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper)
  {
    zzac.zzb(paramContext, "Null context is not permitted.");
    zzac.zzb(paramApi, "Api must not be null.");
    zzac.zzb(paramLooper, "Looper must not be null.");
    mContext = paramContext.getApplicationContext();
    zzawb = paramApi;
    zzaxG = null;
    zzrx = paramLooper;
    zzaxH = zzzs.zzb(paramApi);
    zzaxI = new zzaaq(this);
    zzaxK = zzaap.zzax(mContext);
    mId = zzaxK.zzvU();
    zzaxJ = new zzzr();
  }
  
  public zzc(@NonNull Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, zzabk paramZzabk)
  {
    zzac.zzb(paramContext, "Null context is not permitted.");
    zzac.zzb(paramApi, "Api must not be null.");
    zzac.zzb(paramLooper, "Looper must not be null.");
    mContext = paramContext.getApplicationContext();
    zzawb = paramApi;
    zzaxG = paramO;
    zzrx = paramLooper;
    zzaxH = zzzs.zza(zzawb, zzaxG);
    zzaxI = new zzaaq(this);
    zzaxK = zzaap.zzax(mContext);
    mId = zzaxK.zzvU();
    zzaxJ = paramZzabk;
    zzaxK.zza(this);
  }
  
  public zzc(@NonNull Context paramContext, Api<O> paramApi, O paramO, zzabk paramZzabk) {}
  
  private <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zza(int paramInt, @NonNull T paramT)
  {
    paramT.zzvf();
    zzaxK.zza(this, paramInt, paramT);
    return paramT;
  }
  
  private <TResult, A extends Api.zzb> Task<TResult> zza(int paramInt, @NonNull zzabn<A, TResult> paramZzabn)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    zzaxK.zza(this, paramInt, paramZzabn, localTaskCompletionSource, zzaxJ);
    return localTaskCompletionSource.getTask();
  }
  
  public GoogleApiClient asGoogleApiClient()
  {
    return zzaxI;
  }
  
  @WorkerThread
  public Api.zze buildApiClient(Looper paramLooper, zzaap.zza<O> paramZza)
  {
    return zzawb.zzuG().zza(mContext, paramLooper, zzg.zzaA(mContext), zzaxG, paramZza, paramZza);
  }
  
  public zzabj createSignInCoordinator(Context paramContext, Handler paramHandler)
  {
    return new zzabj(paramContext, paramHandler);
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T doBestEffortWrite(@NonNull T paramT)
  {
    return zza(2, paramT);
  }
  
  public <TResult, A extends Api.zzb> Task<TResult> doBestEffortWrite(zzabn<A, TResult> paramZzabn)
  {
    return zza(2, paramZzabn);
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T doRead(@NonNull T paramT)
  {
    return zza(0, paramT);
  }
  
  public <TResult, A extends Api.zzb> Task<TResult> doRead(zzabn<A, TResult> paramZzabn)
  {
    return zza(0, paramZzabn);
  }
  
  public <A extends Api.zzb, T extends zzabe<A, ?>, U extends zzabr<A, ?>> Task<Void> doRegisterEventListener(@NonNull T paramT, U paramU)
  {
    zzac.zzw(paramT);
    zzac.zzw(paramU);
    zzac.zzb(paramT.zzwp(), "Listener has already been released.");
    zzac.zzb(paramU.zzwp(), "Listener has already been released.");
    zzac.zzb(paramT.zzwp().equals(paramU.zzwp()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return zzaxK.zza(this, paramT, paramU);
  }
  
  public Task<Void> doUnregisterEventListener(@NonNull zzaaz.zzb<?> paramZzb)
  {
    zzac.zzb(paramZzb, "Listener key cannot be null.");
    return zzaxK.zza(this, paramZzb);
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T doWrite(@NonNull T paramT)
  {
    return zza(1, paramT);
  }
  
  public <TResult, A extends Api.zzb> Task<TResult> doWrite(zzabn<A, TResult> paramZzabn)
  {
    return zza(1, paramZzabn);
  }
  
  public Api<O> getApi()
  {
    return zzawb;
  }
  
  public zzzs<O> getApiKey()
  {
    return zzaxH;
  }
  
  public O getApiOptions()
  {
    return zzaxG;
  }
  
  public Context getApplicationContext()
  {
    return mContext;
  }
  
  public int getInstanceId()
  {
    return mId;
  }
  
  public Looper getLooper()
  {
    return zzrx;
  }
  
  public <L> zzaaz<L> registerListener(@NonNull L paramL, String paramString)
  {
    return zzaba.zzb(paramL, zzrx, paramString);
  }
}
