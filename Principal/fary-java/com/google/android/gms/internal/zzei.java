package com.google.android.gms.internal;

import java.util.Random;

@zzmb
public class zzei
  extends zzet.zza
{
  private Object zzrN = new Object();
  private final Random zzzI = new Random();
  private long zzzJ;
  
  public zzei()
  {
    zzeQ();
  }
  
  public long getValue()
  {
    return zzzJ;
  }
  
  public void zzeQ()
  {
    Object localObject1 = zzrN;
    int i = 3;
    long l1 = 0L;
    for (;;)
    {
      int j = i - 1;
      if (j > 0) {}
      try
      {
        long l2 = zzzI.nextInt() + 2147483648L;
        l1 = l2;
        i = j;
        if (l2 == zzzJ) {
          continue;
        }
        l1 = l2;
        i = j;
        if (l2 == 0L) {
          continue;
        }
        l1 = l2;
        zzzJ = l1;
        return;
      }
      finally {}
    }
  }
}
