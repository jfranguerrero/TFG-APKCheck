package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzr;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final zza<?, O> zzaxu;
  private final zzh<?, O> zzaxv;
  private final zzf<?> zzaxw;
  private final zzi<?> zzaxx;
  
  public <C extends zze> Api(String paramString, zza<C, O> paramZza, zzf<C> paramZzf)
  {
    zzac.zzb(paramZza, "Cannot construct an Api with a null ClientBuilder");
    zzac.zzb(paramZzf, "Cannot construct an Api with a null ClientKey");
    mName = paramString;
    zzaxu = paramZza;
    zzaxv = null;
    zzaxw = paramZzf;
    zzaxx = null;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public zzd<?, O> zzuF()
  {
    return zzaxu;
  }
  
  public zza<?, O> zzuG()
  {
    if (zzaxu != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return zzaxu;
    }
  }
  
  public zzc<?> zzuH()
  {
    if (zzaxw != null) {
      return zzaxw;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {
      private NoOptions() {}
    }
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class zza<T extends Api.zze, O>
    extends Api.zzd<T, O>
  {
    public zza() {}
    
    public abstract T zza(Context paramContext, Looper paramLooper, zzg paramZzg, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  }
  
  public static abstract interface zzb {}
  
  public static class zzc<C extends Api.zzb>
  {
    public zzc() {}
  }
  
  public static abstract class zzd<T extends Api.zzb, O>
  {
    public zzd() {}
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
    
    public List<Scope> zzp(O paramO)
    {
      return Collections.emptyList();
    }
  }
  
  public static abstract interface zze
    extends Api.zzb
  {
    public abstract void disconnect();
    
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
    
    public abstract boolean isConnected();
    
    public abstract boolean isConnecting();
    
    public abstract void zza(zzf.zzf paramZzf);
    
    public abstract void zza(zzr paramZzr, Set<Scope> paramSet);
    
    public abstract boolean zzqD();
    
    public abstract boolean zzqS();
    
    public abstract Intent zzqT();
    
    public abstract boolean zzuI();
    
    @Nullable
    public abstract IBinder zzuJ();
  }
  
  public static final class zzf<C extends Api.zze>
    extends Api.zzc<C>
  {
    public zzf() {}
  }
  
  public static abstract interface zzg<T extends IInterface>
    extends Api.zzb
  {
    public abstract String zzeu();
    
    public abstract String zzev();
    
    public abstract T zzh(IBinder paramIBinder);
  }
  
  public static abstract class zzh<T extends Api.zzg, O>
    extends Api.zzd<T, O>
  {}
  
  public static final class zzi<C extends Api.zzg>
    extends Api.zzc<C>
  {}
}
