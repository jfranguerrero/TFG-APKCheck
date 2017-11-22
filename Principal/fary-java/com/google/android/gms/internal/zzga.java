package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;

@zzmb
public class zzga
{
  public zzga() {}
  
  @Nullable
  public zzfz zza(@Nullable zzfy paramZzfy)
  {
    if (paramZzfy == null) {
      throw new IllegalArgumentException("CSI configuration can't be null. ");
    }
    if (!paramZzfy.zzfp())
    {
      zzpe.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
      return null;
    }
    if (paramZzfy.getContext() == null) {
      throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    }
    if (TextUtils.isEmpty(paramZzfy.zzdw())) {
      throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
    }
    return new zzfz(paramZzfy.getContext(), paramZzfy.zzdw(), paramZzfy.zzfq(), paramZzfy.zzfr());
  }
}
