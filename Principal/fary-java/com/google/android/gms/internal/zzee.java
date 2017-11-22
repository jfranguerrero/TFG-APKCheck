package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzmb
public final class zzee
  extends zzer.zza
{
  private final AppEventListener zzzq;
  
  public zzee(AppEventListener paramAppEventListener)
  {
    zzzq = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    zzzq.onAppEvent(paramString1, paramString2);
  }
}
