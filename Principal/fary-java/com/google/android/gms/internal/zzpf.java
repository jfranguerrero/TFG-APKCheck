package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzpf
  extends Handler
{
  public zzpf(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      zzv.zzcN().zza(paramMessage, "AdMobHandler.handleMessage");
    }
  }
}
