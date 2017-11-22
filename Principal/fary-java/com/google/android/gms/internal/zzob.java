package com.google.android.gms.internal;

@zzmb
public class zzob
{
  public final int errorCode;
  public final String zzJJ;
  public final long zzKF;
  public final String zzUV;
  
  private zzob(zza paramZza)
  {
    zzUV = zza.zza(paramZza);
    zzJJ = zza.zzb(paramZza);
    errorCode = zza.zzc(paramZza);
    zzKF = zza.zzd(paramZza);
  }
  
  public static final class zza
  {
    private String zzKo;
    private int zzPF;
    private String zzUW;
    private long zzUX;
    
    public zza() {}
    
    public zza zzaO(String paramString)
    {
      zzKo = paramString;
      return this;
    }
    
    public zza zzaP(String paramString)
    {
      zzUW = paramString;
      return this;
    }
    
    public zza zzac(int paramInt)
    {
      zzPF = paramInt;
      return this;
    }
    
    public zzob zzjt()
    {
      return new zzob(this, null);
    }
    
    public zza zzl(long paramLong)
    {
      zzUX = paramLong;
      return this;
    }
  }
}
