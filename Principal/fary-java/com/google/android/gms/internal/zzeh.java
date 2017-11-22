package com.google.android.gms.internal;

@zzmb
public class zzeh
{
  private static final Object zztU = new Object();
  private static zzeh zzzF;
  private final zzpx zzzG = new zzpx();
  private final zzeg zzzH = new zzeg(new zzdx(), new zzdw(), new zzfd(), new zzhn(), new zznv(), new zzlf(), new zzkq());
  
  static
  {
    zza(new zzeh());
  }
  
  protected zzeh() {}
  
  protected static void zza(zzeh paramZzeh)
  {
    synchronized (zztU)
    {
      zzzF = paramZzeh;
      return;
    }
  }
  
  private static zzeh zzeN()
  {
    synchronized (zztU)
    {
      zzeh localZzeh = zzzF;
      return localZzeh;
    }
  }
  
  public static zzpx zzeO()
  {
    return zzeNzzzG;
  }
  
  public static zzeg zzeP()
  {
    return zzeNzzzH;
  }
}
