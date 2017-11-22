package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.internal.zzaal;
import com.google.android.gms.internal.zzaav;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzabi;
import com.google.android.gms.internal.zzabp;
import com.google.android.gms.internal.zzaxm;
import com.google.android.gms.internal.zzaxn;
import com.google.android.gms.internal.zzaxo;
import com.google.android.gms.internal.zzzt;
import com.google.android.gms.internal.zzzv.zza;
import com.google.android.gms.internal.zzzy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<GoogleApiClient> zzaxM = Collections.newSetFromMap(new WeakHashMap());
  
  public GoogleApiClient() {}
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (zzaxM)
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zzaxM.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
  }
  
  public static Set<GoogleApiClient> zzuM()
  {
    synchronized (zzaxM)
    {
      Set localSet2 = zzaxM;
      return localSet2;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @NonNull
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(@NonNull Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @NonNull
  public <C extends Api.zze> C zza(@NonNull Api.zzc<C> paramZzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(zzabp paramZzabp)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(@NonNull Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(zzabi paramZzabi)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(zzabp paramZzabp)
  {
    throw new UnsupportedOperationException();
  }
  
  public <L> zzaaz<L> zzr(@NonNull L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzuN()
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder
  {
    private final Context mContext;
    private Account zzagg;
    private String zzahp;
    private final Set<Scope> zzaxN = new HashSet();
    private final Set<Scope> zzaxO = new HashSet();
    private int zzaxP;
    private View zzaxQ;
    private String zzaxR;
    private final Map<Api<?>, zzg.zza> zzaxS = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> zzaxT = new ArrayMap();
    private zzaav zzaxU;
    private int zzaxV = -1;
    private GoogleApiClient.OnConnectionFailedListener zzaxW;
    private GoogleApiAvailability zzaxX = GoogleApiAvailability.getInstance();
    private Api.zza<? extends zzaxn, zzaxo> zzaxY = zzaxm.zzahd;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaxZ = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaya = new ArrayList();
    private boolean zzayb = false;
    private Looper zzrx;
    
    public Builder(@NonNull Context paramContext)
    {
      mContext = paramContext;
      zzrx = paramContext.getMainLooper();
      zzahp = paramContext.getPackageName();
      zzaxR = paramContext.getClass().getName();
    }
    
    public Builder(@NonNull Context paramContext, @NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      zzac.zzb(paramConnectionCallbacks, "Must provide a connected listener");
      zzaxZ.add(paramConnectionCallbacks);
      zzac.zzb(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      zzaya.add(paramOnConnectionFailedListener);
    }
    
    private static <C extends Api.zze, O> C zza(Api.zza<C, O> paramZza, Object paramObject, Context paramContext, Looper paramLooper, zzg paramZzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return paramZza.zza(paramContext, paramLooper, paramZzg, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
    
    private Builder zza(@NonNull zzaav paramZzaav, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "clientId must be non-negative");
        zzaxV = paramInt;
        zzaxW = paramOnConnectionFailedListener;
        zzaxU = paramZzaav;
        return this;
      }
    }
    
    private <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, int paramInt, Scope... paramVarArgs)
    {
      boolean bool = true;
      int i = 0;
      if (paramInt == 1) {}
      for (;;)
      {
        paramO = new HashSet(paramApi.zzuF().zzp(paramO));
        int j = paramVarArgs.length;
        paramInt = i;
        while (paramInt < j)
        {
          paramO.add(paramVarArgs[paramInt]);
          paramInt += 1;
        }
        if (paramInt != 2) {
          break;
        }
        bool = false;
      }
      throw new IllegalArgumentException(90 + "Invalid resolution mode: '" + paramInt + "', use a constant from GoogleApiClient.ResolutionMode");
      zzaxS.put(paramApi, new zzg.zza(paramO, bool));
    }
    
    private void zzf(GoogleApiClient paramGoogleApiClient)
    {
      zzzt.zza(zzaxU).zza(zzaxV, paramGoogleApiClient, zzaxW);
    }
    
    private GoogleApiClient zzuQ()
    {
      zzg localZzg = zzuP();
      Object localObject1 = null;
      Map localMap = localZzg.zzxg();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = zzaxT.keySet().iterator();
      Object localObject2 = null;
      Api localApi;
      Object localObject3;
      int i;
      label130:
      zzzy localZzzy;
      Api.zza localZza;
      if (localIterator.hasNext())
      {
        localApi = (Api)localIterator.next();
        localObject3 = zzaxT.get(localApi);
        i = 0;
        if (localMap.get(localApi) != null)
        {
          if (getzzaEf) {
            i = 1;
          }
        }
        else
        {
          localArrayMap1.put(localApi, Integer.valueOf(i));
          localZzzy = new zzzy(localApi, i);
          localArrayList.add(localZzzy);
          localZza = localApi.zzuG();
          if (localZza.getPriority() != 1) {
            break label530;
          }
          localObject2 = localApi;
        }
      }
      label318:
      label525:
      label530:
      for (;;)
      {
        localObject3 = zza(localZza, localObject3, mContext, zzrx, localZzg, localZzzy, localZzzy);
        localArrayMap2.put(localApi.zzuH(), localObject3);
        if (((Api.zze)localObject3).zzqS())
        {
          localObject3 = localApi;
          if (localObject1 == null) {
            break label318;
          }
          localObject2 = String.valueOf(localApi.getName());
          localObject1 = String.valueOf(((Api)localObject1).getName());
          throw new IllegalStateException(String.valueOf(localObject2).length() + 21 + String.valueOf(localObject1).length() + (String)localObject2 + " cannot be used with " + (String)localObject1);
          i = 2;
          break label130;
        }
        localObject3 = localObject1;
        localObject1 = localObject3;
        break;
        if (localObject1 != null)
        {
          if (localObject2 != null)
          {
            localObject1 = String.valueOf(((Api)localObject1).getName());
            localObject2 = String.valueOf(((Api)localObject2).getName());
            throw new IllegalStateException(String.valueOf(localObject1).length() + 21 + String.valueOf(localObject2).length() + (String)localObject1 + " cannot be used with " + (String)localObject2);
          }
          if (zzagg != null) {
            break label525;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          zzac.zza(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)localObject1).getName() });
          zzac.zza(zzaxN.equals(zzaxO), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)localObject1).getName() });
          i = zzaal.zza(localArrayMap2.values(), true);
          return new zzaal(mContext, new ReentrantLock(), zzrx, localZzg, zzaxX, zzaxY, localArrayMap1, zzaxZ, zzaya, localArrayMap2, zzaxV, i, localArrayList, false);
        }
      }
    }
    
    public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      zzac.zzb(paramApi, "Api must not be null");
      zzaxT.put(paramApi, null);
      paramApi = paramApi.zzuF().zzp(null);
      zzaxO.addAll(paramApi);
      zzaxN.addAll(paramApi);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> paramApi, @NonNull O paramO)
    {
      zzac.zzb(paramApi, "Api must not be null");
      zzac.zzb(paramO, "Null options are not permitted for this Api");
      zzaxT.put(paramApi, paramO);
      paramApi = paramApi.zzuF().zzp(paramO);
      zzaxO.addAll(paramApi);
      zzaxN.addAll(paramApi);
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> paramApi, @NonNull O paramO, Scope... paramVarArgs)
    {
      zzac.zzb(paramApi, "Api must not be null");
      zzac.zzb(paramO, "Null options are not permitted for this Api");
      zzaxT.put(paramApi, paramO);
      zza(paramApi, paramO, 1, paramVarArgs);
      return this;
    }
    
    public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      zzac.zzb(paramApi, "Api must not be null");
      zzaxT.put(paramApi, null);
      zza(paramApi, null, 1, paramVarArgs);
      return this;
    }
    
    public Builder addConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzac.zzb(paramConnectionCallbacks, "Listener must not be null");
      zzaxZ.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzac.zzb(paramOnConnectionFailedListener, "Listener must not be null");
      zzaya.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public Builder addScope(@NonNull Scope paramScope)
    {
      zzac.zzb(paramScope, "Scope must not be null");
      zzaxN.add(paramScope);
      return this;
    }
    
    public GoogleApiClient build()
    {
      boolean bool;
      if (!zzaxT.isEmpty()) {
        bool = true;
      }
      for (;;)
      {
        zzac.zzb(bool, "must call addApi() to add at least one API");
        GoogleApiClient localGoogleApiClient = zzuQ();
        synchronized (GoogleApiClient.zzuO())
        {
          GoogleApiClient.zzuO().add(localGoogleApiClient);
          if (zzaxV >= 0) {
            zzf(localGoogleApiClient);
          }
          return localGoogleApiClient;
          bool = false;
        }
      }
    }
    
    public Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return zza(new zzaav(paramFragmentActivity), paramInt, paramOnConnectionFailedListener);
    }
    
    public Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }
    
    public Builder setAccountName(String paramString)
    {
      if (paramString == null) {}
      for (paramString = null;; paramString = new Account(paramString, "com.google"))
      {
        zzagg = paramString;
        return this;
      }
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      zzaxP = paramInt;
      return this;
    }
    
    public Builder setHandler(@NonNull Handler paramHandler)
    {
      zzac.zzb(paramHandler, "Handler must not be null");
      zzrx = paramHandler.getLooper();
      return this;
    }
    
    public Builder setViewForPopups(@NonNull View paramView)
    {
      zzac.zzb(paramView, "View must not be null");
      zzaxQ = paramView;
      return this;
    }
    
    public Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
    
    public zzg zzuP()
    {
      zzaxo localZzaxo = zzaxo.zzbCg;
      if (zzaxT.containsKey(zzaxm.API)) {
        localZzaxo = (zzaxo)zzaxT.get(zzaxm.API);
      }
      return new zzg(zzagg, zzaxN, zzaxS, zzaxP, zzaxQ, zzahp, zzaxR, localZzaxo);
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(@Nullable Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
}
