package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzq;

public class zzace
{
  private final String mTag;
  private final String zzaEV;
  private final zzq zzaFr;
  private final int zzaeb;
  
  private zzace(String paramString1, String paramString2)
  {
    zzaEV = paramString2;
    mTag = paramString1;
    zzaFr = new zzq(paramString1);
    zzaeb = getLogLevel();
  }
  
  public zzace(String paramString, String... paramVarArgs)
  {
    this(paramString, zzd(paramVarArgs));
  }
  
  private int getLogLevel()
  {
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(mTag, i))) {
      i += 1;
    }
    return i;
  }
  
  private static String zzd(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    localStringBuilder.append(']').append(' ');
    return localStringBuilder.toString();
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return zzaEV.concat(str);
  }
  
  public void zza(String paramString, Object... paramVarArgs)
  {
    if (zzai(2)) {
      Log.v(mTag, format(paramString, paramVarArgs));
    }
  }
  
  public boolean zzai(int paramInt)
  {
    return zzaeb <= paramInt;
  }
  
  public void zzb(String paramString, Object... paramVarArgs)
  {
    if (zzai(3)) {
      Log.d(mTag, format(paramString, paramVarArgs));
    }
  }
  
  public void zze(String paramString, Object... paramVarArgs)
  {
    Log.i(mTag, format(paramString, paramVarArgs));
  }
  
  public void zzf(String paramString, Object... paramVarArgs)
  {
    Log.w(mTag, format(paramString, paramVarArgs));
  }
}
