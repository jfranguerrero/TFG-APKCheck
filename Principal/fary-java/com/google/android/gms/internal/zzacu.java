package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzacu
  implements ThreadFactory
{
  private final int mPriority;
  private final String zzaHh;
  private final AtomicInteger zzaHi = new AtomicInteger();
  private final ThreadFactory zzaHj = Executors.defaultThreadFactory();
  
  public zzacu(String paramString)
  {
    this(paramString, 0);
  }
  
  public zzacu(String paramString, int paramInt)
  {
    zzaHh = ((String)zzac.zzb(paramString, "Name must not be null"));
    mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = zzaHj.newThread(new zzacv(paramRunnable, mPriority));
    String str = zzaHh;
    int i = zzaHi.getAndIncrement();
    paramRunnable.setName(String.valueOf(str).length() + 13 + str + "[" + i + "]");
    return paramRunnable;
  }
}
