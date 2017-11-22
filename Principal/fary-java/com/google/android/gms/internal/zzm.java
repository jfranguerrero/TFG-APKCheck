package com.google.android.gms.internal;

public class zzm<T>
{
  public final T result;
  public final zzb.zza zzae;
  public final zzr zzaf;
  public boolean zzag = false;
  
  private zzm(zzr paramZzr)
  {
    result = null;
    zzae = null;
    zzaf = paramZzr;
  }
  
  private zzm(T paramT, zzb.zza paramZza)
  {
    result = paramT;
    zzae = paramZza;
    zzaf = null;
  }
  
  public static <T> zzm<T> zza(T paramT, zzb.zza paramZza)
  {
    return new zzm(paramT, paramZza);
  }
  
  public static <T> zzm<T> zzd(zzr paramZzr)
  {
    return new zzm(paramZzr);
  }
  
  public boolean isSuccess()
  {
    return zzaf == null;
  }
  
  public static abstract interface zza
  {
    public abstract void zze(zzr paramZzr);
  }
  
  public static abstract interface zzb<T>
  {
    public abstract void zzb(T paramT);
  }
}
