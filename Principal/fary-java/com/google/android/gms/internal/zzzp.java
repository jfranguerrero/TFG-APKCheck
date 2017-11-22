package com.google.android.gms.internal;

public class zzzp
{
  public static long zzd(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L) {
      return paramLong1 % paramLong2;
    }
    return (Long.MAX_VALUE % paramLong2 + 1L + (paramLong1 & 0x7FFFFFFFFFFFFFFF) % paramLong2) % paramLong2;
  }
}
