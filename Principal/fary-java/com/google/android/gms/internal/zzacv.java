package com.google.android.gms.internal;

import android.os.Process;

class zzacv
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzv;
  
  public zzacv(Runnable paramRunnable, int paramInt)
  {
    zzv = paramRunnable;
    mPriority = paramInt;
  }
  
  public void run()
  {
    Process.setThreadPriority(mPriority);
    zzv.run();
  }
}
