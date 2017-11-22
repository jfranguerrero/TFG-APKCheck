package com.google.android.gms.internal;

public abstract interface zzqi<T>
{
  public abstract void zza(zzc<T> paramZzc, zza paramZza);
  
  public abstract void zzg(T paramT);
  
  public static abstract interface zza
  {
    public abstract void run();
  }
  
  public static class zzb
    implements zzqi.zza
  {
    public zzb() {}
    
    public void run() {}
  }
  
  public static abstract interface zzc<T>
  {
    public abstract void zzd(T paramT);
  }
}
