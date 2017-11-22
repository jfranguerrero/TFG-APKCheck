package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzr;
import java.util.HashSet;
import java.util.Set;

public class zzabj
  extends zzaxr
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static Api.zza<? extends zzaxn, zzaxo> zzaBH = zzaxm.zzahd;
  private final Context mContext;
  private final Handler mHandler;
  private final boolean zzaBI;
  private zza zzaBJ;
  private Set<Scope> zzajm;
  private final Api.zza<? extends zzaxn, zzaxo> zzaxu;
  private zzaxn zzazS;
  private zzg zzazs;
  
  @WorkerThread
  public zzabj(Context paramContext, Handler paramHandler)
  {
    mContext = paramContext;
    mHandler = paramHandler;
    paramContext = zzl.zzaa(mContext).zzrd();
    if (paramContext == null) {}
    for (paramContext = new HashSet();; paramContext = new HashSet(paramContext.zzqJ()))
    {
      zzajm = paramContext;
      zzazs = new zzg(null, zzajm, null, 0, null, null, null, zzaxo.zzbCg);
      zzaxu = zzaBH;
      zzaBI = true;
      return;
    }
  }
  
  @WorkerThread
  public zzabj(Context paramContext, Handler paramHandler, zzg paramZzg, Api.zza<? extends zzaxn, zzaxo> paramZza)
  {
    mContext = paramContext;
    mHandler = paramHandler;
    zzazs = paramZzg;
    zzajm = paramZzg.zzxe();
    zzaxu = paramZza;
    zzaBI = false;
  }
  
  @WorkerThread
  private void zzc(zzayb paramZzayb)
  {
    Object localObject = paramZzayb.zzxA();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramZzayb.zzOp();
      paramZzayb = ((zzaf)localObject).zzxA();
      if (!paramZzayb.isSuccess())
      {
        localObject = String.valueOf(paramZzayb);
        Log.wtf("SignInCoordinator", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        zzaBJ.zzi(paramZzayb);
        zzazS.disconnect();
        return;
      }
      zzaBJ.zzb(((zzaf)localObject).zzxz(), zzajm);
    }
    for (;;)
    {
      zzazS.disconnect();
      return;
      zzaBJ.zzi((ConnectionResult)localObject);
    }
  }
  
  @WorkerThread
  public void onConnected(@Nullable Bundle paramBundle)
  {
    zzazS.zza(this);
  }
  
  @WorkerThread
  public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    zzaBJ.zzi(paramConnectionResult);
  }
  
  @WorkerThread
  public void onConnectionSuspended(int paramInt)
  {
    zzazS.disconnect();
  }
  
  @WorkerThread
  public void zza(zza paramZza)
  {
    if (zzazS != null) {
      zzazS.disconnect();
    }
    if (zzaBI)
    {
      localObject = zzl.zzaa(mContext).zzrd();
      if (localObject != null) {
        break label128;
      }
    }
    label128:
    for (Object localObject = new HashSet();; localObject = new HashSet(((GoogleSignInOptions)localObject).zzqJ()))
    {
      zzajm = ((Set)localObject);
      zzazs = new zzg(null, zzajm, null, 0, null, null, null, zzaxo.zzbCg);
      zzazS = ((zzaxn)zzaxu.zza(mContext, mHandler.getLooper(), zzazs, zzazs.zzxk(), this, this));
      zzaBJ = paramZza;
      zzazS.connect();
      return;
    }
  }
  
  @BinderThread
  public void zzb(final zzayb paramZzayb)
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        zzabj.zza(zzabj.this, paramZzayb);
      }
    });
  }
  
  public void zzwr()
  {
    zzazS.disconnect();
  }
  
  @WorkerThread
  public static abstract interface zza
  {
    public abstract void zzb(zzr paramZzr, Set<Scope> paramSet);
    
    public abstract void zzi(ConnectionResult paramConnectionResult);
  }
}
