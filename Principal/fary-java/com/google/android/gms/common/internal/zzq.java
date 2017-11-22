package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzq
{
  public static final int zzaES = 23 - " PII_LOG".length();
  private static final String zzaET = null;
  private final String zzaEU;
  private final String zzaEV;
  
  public zzq(String paramString)
  {
    this(paramString, null);
  }
  
  public zzq(String paramString1, String paramString2)
  {
    zzac.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      zzaEU = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        break;
      }
      zzaEV = null;
      return;
    }
    zzaEV = paramString2;
  }
  
  private String zzdu(String paramString)
  {
    if (zzaEV == null) {
      return paramString;
    }
    return zzaEV.concat(paramString);
  }
  
  public void zzD(String paramString1, String paramString2)
  {
    if (zzcQ(3)) {
      Log.d(paramString1, zzdu(paramString2));
    }
  }
  
  public void zzE(String paramString1, String paramString2)
  {
    if (zzcQ(5)) {
      Log.w(paramString1, zzdu(paramString2));
    }
  }
  
  public void zzF(String paramString1, String paramString2)
  {
    if (zzcQ(6)) {
      Log.e(paramString1, zzdu(paramString2));
    }
  }
  
  public void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcQ(4)) {
      Log.i(paramString1, zzdu(paramString2), paramThrowable);
    }
  }
  
  public void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcQ(5)) {
      Log.w(paramString1, zzdu(paramString2), paramThrowable);
    }
  }
  
  public boolean zzcQ(int paramInt)
  {
    return Log.isLoggable(zzaEU, paramInt);
  }
  
  public void zzd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcQ(6)) {
      Log.e(paramString1, zzdu(paramString2), paramThrowable);
    }
  }
  
  public void zze(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzcQ(7))
    {
      Log.e(paramString1, zzdu(paramString2), paramThrowable);
      Log.wtf(paramString1, zzdu(paramString2), paramThrowable);
    }
  }
}
