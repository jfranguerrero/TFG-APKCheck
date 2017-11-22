package com.google.android.gms.internal;

import android.util.Log;

@zzmb
public class zzpy
{
  public static void e(String paramString)
  {
    if (zzai(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void zza(String paramString, Throwable paramThrowable)
  {
    if (zzai(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean zzai(int paramInt)
  {
    return (paramInt >= 5) || (Log.isLoggable("Ads", paramInt));
  }
  
  public static void zzb(String paramString, Throwable paramThrowable)
  {
    if (zzai(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzbc(String paramString)
  {
    if (zzai(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void zzbd(String paramString)
  {
    if (zzai(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void zzbe(String paramString)
  {
    if (zzai(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void zzc(String paramString, Throwable paramThrowable)
  {
    if (zzai(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
}
