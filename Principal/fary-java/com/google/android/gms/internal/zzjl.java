package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzmb
public final class zzjl
  extends zzju.zza
{
  private zzjn.zza zzKm;
  private zzjk zzKn;
  private final Object zzrN = new Object();
  
  public zzjl() {}
  
  public void onAdClicked()
  {
    synchronized (zzrN)
    {
      if (zzKn != null) {
        zzKn.zzbP();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (zzrN)
    {
      if (zzKn != null) {
        zzKn.zzbQ();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzKm != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            zzKm.zzD(paramInt);
            zzKm = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public void onAdImpression()
  {
    synchronized (zzrN)
    {
      if (zzKn != null) {
        zzKn.zzbU();
      }
      return;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (zzrN)
    {
      if (zzKn != null) {
        zzKn.zzbR();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (zzrN)
    {
      if (zzKm != null)
      {
        zzKm.zzD(0);
        zzKm = null;
        return;
      }
      if (zzKn != null) {
        zzKn.zzbT();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (zzrN)
    {
      if (zzKn != null) {
        zzKn.zzbS();
      }
      return;
    }
  }
  
  public void zza(@Nullable zzjk paramZzjk)
  {
    synchronized (zzrN)
    {
      zzKn = paramZzjk;
      return;
    }
  }
  
  public void zza(zzjn.zza paramZza)
  {
    synchronized (zzrN)
    {
      zzKm = paramZza;
      return;
    }
  }
  
  public void zza(zzjv paramZzjv)
  {
    synchronized (zzrN)
    {
      if (zzKm != null)
      {
        zzKm.zza(0, paramZzjv);
        zzKm = null;
        return;
      }
      if (zzKn != null) {
        zzKn.zzbT();
      }
      return;
    }
  }
}
