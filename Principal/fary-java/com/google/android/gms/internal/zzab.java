package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzab
  extends zzk<String>
{
  private final zzm.zzb<String> zzaF;
  
  public zzab(int paramInt, String paramString, zzm.zzb<String> paramZzb, zzm.zza paramZza)
  {
    super(paramInt, paramString, paramZza);
    zzaF = paramZzb;
  }
  
  protected zzm<String> zza(zzi paramZzi)
  {
    try
    {
      String str1 = new String(data, zzx.zza(zzy));
      return zzm.zza(str1, zzx.zzb(paramZzi));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(data);
      }
    }
  }
  
  protected void zzi(String paramString)
  {
    zzaF.zzb(paramString);
  }
}
