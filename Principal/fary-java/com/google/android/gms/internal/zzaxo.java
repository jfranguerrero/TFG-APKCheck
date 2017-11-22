package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class zzaxo
  implements Api.ApiOptions.Optional
{
  public static final zzaxo zzbCg = new zza().zzOj();
  private final boolean zzajh;
  private final boolean zzajj;
  private final String zzajk;
  private final String zzajl;
  private final boolean zzbCh;
  private final boolean zzbCi;
  private final Long zzbCj;
  private final Long zzbCk;
  
  private zzaxo(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, boolean paramBoolean4, Long paramLong1, Long paramLong2)
  {
    zzbCh = paramBoolean1;
    zzajh = paramBoolean2;
    zzajk = paramString1;
    zzajj = paramBoolean3;
    zzbCi = paramBoolean4;
    zzajl = paramString2;
    zzbCj = paramLong1;
    zzbCk = paramLong2;
  }
  
  public boolean zzOf()
  {
    return zzbCh;
  }
  
  public boolean zzOg()
  {
    return zzbCi;
  }
  
  @Nullable
  public Long zzOh()
  {
    return zzbCj;
  }
  
  @Nullable
  public Long zzOi()
  {
    return zzbCk;
  }
  
  public boolean zzqK()
  {
    return zzajh;
  }
  
  public boolean zzqM()
  {
    return zzajj;
  }
  
  public String zzqN()
  {
    return zzajk;
  }
  
  @Nullable
  public String zzqO()
  {
    return zzajl;
  }
  
  public static final class zza
  {
    public zza() {}
    
    public zzaxo zzOj()
    {
      return new zzaxo(false, false, null, false, null, false, null, null, null);
    }
  }
}
