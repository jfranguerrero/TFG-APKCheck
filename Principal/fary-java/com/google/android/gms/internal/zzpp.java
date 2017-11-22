package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzmb
public class zzpp
{
  private static zzl zzXw;
  private static final Object zzXx = new Object();
  public static final zza<Void> zzXy = new zza() {};
  
  public zzpp(Context paramContext)
  {
    zzN(paramContext);
  }
  
  private static zzl zzN(Context paramContext)
  {
    synchronized (zzXx)
    {
      if (zzXw == null) {
        zzXw = zzac.zza(paramContext.getApplicationContext());
      }
      paramContext = zzXw;
      return paramContext;
    }
  }
  
  public zzqf<String> zza(int paramInt, final String paramString, @Nullable final Map<String, String> paramMap, @Nullable final byte[] paramArrayOfByte)
  {
    final zzc localZzc = new zzc(null);
    paramString = new zzab(paramInt, paramString, localZzc, new zzm.zza()
    {
      public void zze(zzr paramAnonymousZzr)
      {
        String str = paramString;
        paramAnonymousZzr = String.valueOf(paramAnonymousZzr.toString());
        zzpe.zzbe(String.valueOf(str).length() + 21 + String.valueOf(paramAnonymousZzr).length() + "Failed to load URL: " + str + "\n" + paramAnonymousZzr);
        localZzc.zzb(null);
      }
    })
    {
      public Map<String, String> getHeaders()
        throws zza
      {
        if (paramMap == null) {
          return super.getHeaders();
        }
        return paramMap;
      }
      
      public byte[] zzm()
        throws zza
      {
        if (paramArrayOfByte == null) {
          return super.zzm();
        }
        return paramArrayOfByte;
      }
    };
    zzXw.zze(paramString);
    return localZzc;
  }
  
  public <T> zzqf<T> zza(String paramString, zza<T> paramZza)
  {
    zzc localZzc = new zzc(null);
    zzXw.zze(new zzb(paramString, paramZza, localZzc));
    return localZzc;
  }
  
  public zzqf<String> zzc(String paramString, Map<String, String> paramMap)
  {
    return zza(0, paramString, paramMap, null);
  }
  
  public static abstract interface zza<T>
  {
    public abstract T zzh(InputStream paramInputStream);
    
    public abstract T zziT();
  }
  
  private static class zzb<T>
    extends zzk<InputStream>
  {
    private final zzpp.zza<T> zzXC;
    private final zzm.zzb<T> zzaF;
    
    public zzb(String paramString, final zzpp.zza<T> paramZza, zzm.zzb<T> paramZzb)
    {
      super(paramString, new zzm.zza()
      {
        public void zze(zzr paramAnonymousZzr)
        {
          zzb(paramZza.zziT());
        }
      });
      zzXC = paramZza;
      zzaF = paramZzb;
    }
    
    protected zzm<InputStream> zza(zzi paramZzi)
    {
      return zzm.zza(new ByteArrayInputStream(data), zzx.zzb(paramZzi));
    }
    
    protected void zzj(InputStream paramInputStream)
    {
      zzaF.zzb(zzXC.zzh(paramInputStream));
    }
  }
  
  private class zzc<T>
    extends zzqc<T>
    implements zzm.zzb<T>
  {
    private zzc() {}
    
    public void zzb(@Nullable T paramT)
    {
      super.zzh(paramT);
    }
  }
}
