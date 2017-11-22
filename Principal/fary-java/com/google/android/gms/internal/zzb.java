package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public abstract interface zzb
{
  public abstract void initialize();
  
  public abstract zza zza(String paramString);
  
  public abstract void zza(String paramString, zza paramZza);
  
  public static class zza
  {
    public byte[] data;
    public String zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf = Collections.emptyMap();
    
    public zza() {}
    
    public boolean zza()
    {
      return zzd < System.currentTimeMillis();
    }
    
    public boolean zzb()
    {
      return zze < System.currentTimeMillis();
    }
  }
}
