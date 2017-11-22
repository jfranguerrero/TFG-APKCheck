package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@zzmb
public final class zznb
{
  private String zzOn;
  private String zzTh;
  private zzqc<zzne> zzTi = new zzqc();
  zzja.zzc zzTj;
  public final zzhx zzTk = new zzhx()
  {
    public void zza(zzqp arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (zznb.zza(zznb.this))
      {
        if (zznb.zzb(zznb.this).isDone()) {
          return;
        }
        if (!zznb.zzc(zznb.this).equals(paramAnonymousMap.get("request_id"))) {
          return;
        }
      }
      paramAnonymousMap = new zzne(1, paramAnonymousMap);
      String str1 = String.valueOf(paramAnonymousMap.getType());
      String str2 = String.valueOf(paramAnonymousMap.zzji());
      zzpe.zzbe(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + "Invalid " + str1 + " request error: " + str2);
      zznb.zzb(zznb.this).zzh(paramAnonymousMap);
    }
  };
  public final zzhx zzTl = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      zzne localZzne;
      synchronized (zznb.zza(zznb.this))
      {
        if (zznb.zzb(zznb.this).isDone()) {
          return;
        }
        localZzne = new zzne(-2, paramAnonymousMap);
        if (!zznb.zzc(zznb.this).equals(localZzne.getRequestId())) {
          return;
        }
      }
      String str = localZzne.getUrl();
      if (str == null)
      {
        zzpe.zzbe("URL missing in loadAdUrl GMSG.");
        return;
      }
      if (str.contains("%40mediation_adapters%40"))
      {
        paramAnonymousZzqp = str.replaceAll("%40mediation_adapters%40", zzpc.zza(paramAnonymousZzqp.getContext(), (String)paramAnonymousMap.get("check_adapters"), zznb.zzd(zznb.this)));
        localZzne.setUrl(paramAnonymousZzqp);
        paramAnonymousZzqp = String.valueOf(paramAnonymousZzqp);
        if (paramAnonymousZzqp.length() == 0) {
          break label173;
        }
      }
      label173:
      for (paramAnonymousZzqp = "Ad request URL modified to ".concat(paramAnonymousZzqp);; paramAnonymousZzqp = new String("Ad request URL modified to "))
      {
        zzpe.v(paramAnonymousZzqp);
        zznb.zzb(zznb.this).zzh(localZzne);
        return;
      }
    }
  };
  public final zzhx zzTm = new zzhx()
  {
    public void zza(zzqp arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (zznb.zza(zznb.this))
      {
        if (zznb.zzb(zznb.this).isDone()) {
          return;
        }
        paramAnonymousMap = new zzne(-2, paramAnonymousMap);
        if (!zznb.zzc(zznb.this).equals(paramAnonymousMap.getRequestId())) {
          return;
        }
      }
      zznb.zzb(zznb.this).zzh(paramAnonymousMap);
    }
  };
  private final Object zzrN = new Object();
  
  public zznb(String paramString1, String paramString2)
  {
    zzTh = paramString2;
    zzOn = paramString1;
  }
  
  public void zzb(zzja.zzc paramZzc)
  {
    zzTj = paramZzc;
  }
  
  public zzja.zzc zzjg()
  {
    return zzTj;
  }
  
  public Future<zzne> zzjh()
  {
    return zzTi;
  }
}
