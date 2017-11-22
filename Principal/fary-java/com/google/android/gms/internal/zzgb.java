package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzmb
public class zzgb
{
  @Nullable
  public static zzgd zza(@Nullable zzgf paramZzgf, long paramLong)
  {
    if (paramZzgf == null) {
      return null;
    }
    return paramZzgf.zzc(paramLong);
  }
  
  public static boolean zza(@Nullable zzgf paramZzgf, @Nullable zzgd paramZzgd, long paramLong, String... paramVarArgs)
  {
    if ((paramZzgf == null) || (paramZzgd == null)) {
      return false;
    }
    return paramZzgf.zza(paramZzgd, paramLong, paramVarArgs);
  }
  
  public static boolean zza(@Nullable zzgf paramZzgf, @Nullable zzgd paramZzgd, String... paramVarArgs)
  {
    if ((paramZzgf == null) || (paramZzgd == null)) {
      return false;
    }
    return paramZzgf.zza(paramZzgd, paramVarArgs);
  }
  
  @Nullable
  public static zzgd zzb(@Nullable zzgf paramZzgf)
  {
    if (paramZzgf == null) {
      return null;
    }
    return paramZzgf.zzfw();
  }
}
