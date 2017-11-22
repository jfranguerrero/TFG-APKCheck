package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzk<T>
  implements Comparable<zzk<T>>
{
  private final zzs.zza zzB;
  private final int zzC;
  private final String zzD;
  private final int zzE;
  private final zzm.zza zzF;
  private Integer zzG;
  private zzl zzH;
  private boolean zzI;
  private boolean zzJ;
  private boolean zzK;
  private long zzL;
  private zzo zzM;
  private zzb.zza zzN;
  
  public zzk(int paramInt, String paramString, zzm.zza paramZza)
  {
    if (zzs.zza.zzai) {}
    for (zzs.zza localZza = new zzs.zza();; localZza = null)
    {
      zzB = localZza;
      zzI = true;
      zzJ = false;
      zzK = false;
      zzL = 0L;
      zzN = null;
      zzC = paramInt;
      zzD = paramString;
      zzF = paramZza;
      zza(new zzd());
      zzE = zzb(paramString);
      return;
    }
  }
  
  private static int zzb(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public Map<String, String> getHeaders()
    throws zza
  {
    return Collections.emptyMap();
  }
  
  public int getMethod()
  {
    return zzC;
  }
  
  public String getUrl()
  {
    return zzD;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(Integer.toHexString(zzf()));
    if (str1.length() != 0) {}
    for (str1 = "0x".concat(str1);; str1 = new String("0x"))
    {
      String str2 = String.valueOf(getUrl());
      String str3 = String.valueOf(zzo());
      String str4 = String.valueOf(zzG);
      return String.valueOf("[ ] ").length() + 3 + String.valueOf(str2).length() + String.valueOf(str1).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + "[ ] " + str2 + " " + str1 + " " + str3 + " " + str4;
    }
  }
  
  public final zzk<?> zza(int paramInt)
  {
    zzG = Integer.valueOf(paramInt);
    return this;
  }
  
  public zzk<?> zza(zzb.zza paramZza)
  {
    zzN = paramZza;
    return this;
  }
  
  public zzk<?> zza(zzl paramZzl)
  {
    zzH = paramZzl;
    return this;
  }
  
  public zzk<?> zza(zzo paramZzo)
  {
    zzM = paramZzo;
    return this;
  }
  
  protected abstract zzm<T> zza(zzi paramZzi);
  
  protected abstract void zza(T paramT);
  
  protected zzr zzb(zzr paramZzr)
  {
    return paramZzr;
  }
  
  public int zzc(zzk<T> paramZzk)
  {
    zza localZza1 = zzo();
    zza localZza2 = paramZzk.zzo();
    if (localZza1 == localZza2) {
      return zzG.intValue() - zzG.intValue();
    }
    return localZza2.ordinal() - localZza1.ordinal();
  }
  
  public void zzc(zzr paramZzr)
  {
    if (zzF != null) {
      zzF.zze(paramZzr);
    }
  }
  
  public void zzc(String paramString)
  {
    if (zzs.zza.zzai) {
      zzB.zza(paramString, Thread.currentThread().getId());
    }
    while (zzL != 0L) {
      return;
    }
    zzL = SystemClock.elapsedRealtime();
  }
  
  void zzd(final String paramString)
  {
    if (zzH != null) {
      zzH.zzf(this);
    }
    final long l;
    if (zzs.zza.zzai)
    {
      l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            zzk.zzd(zzk.this).zza(paramString, l);
            zzk.zzd(zzk.this).zzd(toString());
          }
        });
      }
    }
    do
    {
      return;
      zzB.zza(paramString, l);
      zzB.zzd(toString());
      return;
      l = SystemClock.elapsedRealtime() - zzL;
    } while (l < 3000L);
    zzs.zzb("%d ms: %s", new Object[] { Long.valueOf(l), toString() });
  }
  
  public int zzf()
  {
    return zzE;
  }
  
  public String zzg()
  {
    return getUrl();
  }
  
  public zzb.zza zzh()
  {
    return zzN;
  }
  
  @Deprecated
  public String zzi()
  {
    return zzl();
  }
  
  @Deprecated
  public byte[] zzj()
    throws zza
  {
    return null;
  }
  
  protected String zzk()
  {
    return "UTF-8";
  }
  
  public String zzl()
  {
    String str = String.valueOf(zzk());
    if (str.length() != 0) {
      return "application/x-www-form-urlencoded; charset=".concat(str);
    }
    return new String("application/x-www-form-urlencoded; charset=");
  }
  
  public byte[] zzm()
    throws zza
  {
    return null;
  }
  
  public final boolean zzn()
  {
    return zzI;
  }
  
  public zza zzo()
  {
    return zza.zzS;
  }
  
  public final int zzp()
  {
    return zzM.zzc();
  }
  
  public zzo zzq()
  {
    return zzM;
  }
  
  public void zzr()
  {
    zzK = true;
  }
  
  public boolean zzs()
  {
    return zzK;
  }
  
  public static enum zza
  {
    private zza() {}
  }
}
