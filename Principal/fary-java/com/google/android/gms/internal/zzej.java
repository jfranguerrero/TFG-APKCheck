package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@zzmb
public class zzej
  extends AdListener
{
  private final Object lock = new Object();
  private AdListener zzzK;
  
  public zzej() {}
  
  public void onAdClosed()
  {
    synchronized (lock)
    {
      if (zzzK != null) {
        zzzK.onAdClosed();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    synchronized (lock)
    {
      if (zzzK != null) {
        zzzK.onAdFailedToLoad(paramInt);
      }
      return;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (lock)
    {
      if (zzzK != null) {
        zzzK.onAdLeftApplication();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (lock)
    {
      if (zzzK != null) {
        zzzK.onAdLoaded();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (lock)
    {
      if (zzzK != null) {
        zzzK.onAdOpened();
      }
      return;
    }
  }
  
  public void zza(AdListener paramAdListener)
  {
    synchronized (lock)
    {
      zzzK = paramAdListener;
      return;
    }
  }
}
