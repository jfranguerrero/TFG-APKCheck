package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzzf
{
  @Deprecated
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ClearcutLogger.API", zzahd, zzahc);
  public static final Api.zzf<zzzk> zzahc = new Api.zzf();
  public static final Api.zza<zzzk, Api.ApiOptions.NoOptions> zzahd = new Api.zza()
  {
    public zzzk zze(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymousZzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzzk(paramAnonymousContext, paramAnonymousLooper, paramAnonymousZzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private final String zzQL;
  private final int zzawl;
  private String zzawm;
  private int zzawn = -1;
  private String zzawo;
  private String zzawp;
  private final boolean zzawq;
  private int zzawr = 0;
  private final zzzg zzaws;
  private zzd zzawt;
  private final zzb zzawu;
  private final zze zzuI;
  
  public zzzf(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzzg paramZzzg, zze paramZze, zzd paramZzd, zzb paramZzb)
  {
    zzQL = paramContext.getPackageName();
    zzawl = zzah(paramContext);
    zzawn = paramInt;
    zzawm = paramString1;
    zzawo = paramString2;
    zzawp = paramString3;
    zzawq = paramBoolean;
    zzaws = paramZzzg;
    zzuI = paramZze;
    if (paramZzd != null) {}
    for (;;)
    {
      zzawt = paramZzd;
      zzawr = 0;
      zzawu = paramZzb;
      if (zzawq)
      {
        paramBoolean = bool;
        if (zzawo == null) {
          paramBoolean = true;
        }
        zzac.zzb(paramBoolean, "can't be anonymous with an upload account");
      }
      return;
      paramZzd = new zzd();
    }
  }
  
  public zzzf(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, -1, paramString1, paramString2, null, false, zzzj.zzai(paramContext), zzh.zzyv(), null, new zzzo(paramContext));
  }
  
  private int zzah(Context paramContext)
  {
    try
    {
      int i = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("ClearcutLogger", "This can't happen.");
    }
    return 0;
  }
  
  private static int[] zzb(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayList.size()];
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramArrayList.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static String[] zzc(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    return (String[])paramArrayList.toArray(new String[0]);
  }
  
  private static byte[][] zzd(ArrayList<byte[]> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    return (byte[][])paramArrayList.toArray(new byte[0][]);
  }
  
  public zza zzm(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, null);
  }
  
  public class zza
  {
    private boolean zzawA = true;
    private final zzbuy.zzc zzawB = new zzbuy.zzc();
    private boolean zzawC = false;
    private String zzawm = zzzf.zzb(zzzf.this);
    private int zzawn = zzzf.zza(zzzf.this);
    private String zzawo = zzzf.zzc(zzzf.this);
    private String zzawp = zzzf.zzd(zzzf.this);
    private int zzawr = zzzf.zze(zzzf.this);
    private final zzzf.zzc zzawv;
    private ArrayList<Integer> zzaww = null;
    private ArrayList<String> zzawx = null;
    private ArrayList<Integer> zzawy = null;
    private ArrayList<byte[]> zzawz = null;
    
    private zza(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, null);
    }
    
    private zza(byte[] paramArrayOfByte, zzzf.zzc paramZzc)
    {
      zzawB.zzcsy = zzzf.zzf(zzzf.this).currentTimeMillis();
      zzawB.zzcsz = zzzf.zzf(zzzf.this).elapsedRealtime();
      zzawB.zzcsJ = zzzf.zzg(zzzf.this).zzG(zzawB.zzcsy);
      if (paramArrayOfByte != null) {
        zzawB.zzcsF = paramArrayOfByte;
      }
      zzawv = paramZzc;
    }
    
    public zza zzcn(int paramInt)
    {
      zzawB.zzcsB = paramInt;
      return this;
    }
    
    public zza zzco(int paramInt)
    {
      zzawB.zzrn = paramInt;
      return this;
    }
    
    @Deprecated
    public PendingResult<Status> zze(GoogleApiClient paramGoogleApiClient)
    {
      return zzuv();
    }
    
    public zzzh zzuu()
    {
      return new zzzh(new zzawe(zzzf.zzi(zzzf.this), zzzf.zzj(zzzf.this), zzawn, zzawm, zzawo, zzawp, zzzf.zzh(zzzf.this), zzawr), zzawB, zzawv, null, zzzf.zze(null), zzzf.zzf(null), zzzf.zze(null), zzzf.zzg(null), zzawA);
    }
    
    @Deprecated
    public PendingResult<Status> zzuv()
    {
      if (zzawC) {
        throw new IllegalStateException("do not reuse LogEventBuilder");
      }
      zzawC = true;
      zzzh localZzzh = zzuu();
      zzawe localZzawe = zzawE;
      if (zzzf.zzk(zzzf.this).zzh(zzbzD, zzbzz)) {
        return zzzf.zzl(zzzf.this).zza(localZzzh);
      }
      return PendingResults.immediatePendingResult(Status.zzayh);
    }
  }
  
  public static abstract interface zzb
  {
    public abstract boolean zzh(String paramString, int paramInt);
  }
  
  public static abstract interface zzc
  {
    public abstract byte[] zzuw();
  }
  
  public static class zzd
  {
    public zzd() {}
    
    public long zzG(long paramLong)
    {
      return TimeZone.getDefault().getOffset(paramLong) / 1000;
    }
  }
}
