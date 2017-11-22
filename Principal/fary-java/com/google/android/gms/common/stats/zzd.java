package com.google.android.gms.common.stats;

import android.support.v4.util.SimpleArrayMap;

public class zzd
{
  private final long zzaGr;
  private final int zzaGs;
  private final SimpleArrayMap<String, Long> zzaGt;
  
  public zzd()
  {
    zzaGr = 60000L;
    zzaGs = 10;
    zzaGt = new SimpleArrayMap(10);
  }
  
  public zzd(int paramInt, long paramLong)
  {
    zzaGr = paramLong;
    zzaGs = paramInt;
    zzaGt = new SimpleArrayMap();
  }
}
