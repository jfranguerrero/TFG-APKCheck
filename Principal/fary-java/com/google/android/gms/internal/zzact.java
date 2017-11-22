package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class zzact
  implements Executor
{
  private final Handler mHandler;
  
  public zzact(Looper paramLooper)
  {
    mHandler = new Handler(paramLooper);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    mHandler.post(paramRunnable);
  }
}
