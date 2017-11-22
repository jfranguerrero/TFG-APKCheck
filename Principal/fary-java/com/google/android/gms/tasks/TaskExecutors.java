package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD = new zza();
  static final Executor zzbLG = new Executor()
  {
    public void execute(@NonNull Runnable paramAnonymousRunnable)
    {
      paramAnonymousRunnable.run();
    }
  };
  
  private TaskExecutors() {}
  
  private static final class zza
    implements Executor
  {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public zza() {}
    
    public void execute(@NonNull Runnable paramRunnable)
    {
      mHandler.post(paramRunnable);
    }
  }
}
