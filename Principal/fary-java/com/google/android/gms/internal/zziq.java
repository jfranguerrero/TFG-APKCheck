package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzmb
class zziq
{
  private final List<zza> zztf = new LinkedList();
  
  zziq() {}
  
  void zza(final zzir paramZzir)
  {
    Handler localHandler = zzpi.zzWR;
    Iterator localIterator = zztf.iterator();
    while (localIterator.hasNext()) {
      localHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            zzIr.zzb(paramZzir);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzpe.zzc("Could not propagate interstitial ad event.", localRemoteException);
          }
        }
      });
    }
    zztf.clear();
  }
  
  void zzc(zzl paramZzl)
  {
    paramZzl.zza(new zzel.zza()
    {
      public void onAdClosed()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzti != null) {
              zzti.onAdClosed();
            }
            zzv.zzcY().zzgj();
          }
        });
      }
      
      public void onAdFailedToLoad(final int paramAnonymousInt)
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzti != null) {
              zzti.onAdFailedToLoad(paramAnonymousInt);
            }
          }
        });
        zzpe.v("Pooled interstitial failed to load.");
      }
      
      public void onAdLeftApplication()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzti != null) {
              zzti.onAdLeftApplication();
            }
          }
        });
      }
      
      public void onAdLoaded()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzti != null) {
              zzti.onAdLoaded();
            }
          }
        });
        zzpe.v("Pooled interstitial loaded.");
      }
      
      public void onAdOpened()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzti != null) {
              zzti.onAdOpened();
            }
          }
        });
      }
    });
    paramZzl.zza(new zzer.zza()
    {
      public void onAppEvent(final String paramAnonymousString1, final String paramAnonymousString2)
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIt != null) {
              zzIt.onAppEvent(paramAnonymousString1, paramAnonymousString2);
            }
          }
        });
      }
    });
    paramZzl.zza(new zzkz.zza()
    {
      public void zza(final zzky paramAnonymousZzky)
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIu != null) {
              zzIu.zza(paramAnonymousZzky);
            }
          }
        });
      }
    });
    paramZzl.zza(new zzgj.zza()
    {
      public void zza(final zzgi paramAnonymousZzgi)
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIv != null) {
              zzIv.zza(paramAnonymousZzgi);
            }
          }
        });
      }
    });
    paramZzl.zza(new zzek.zza()
    {
      public void onAdClicked()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIw != null) {
              zzIw.onAdClicked();
            }
          }
        });
      }
    });
    paramZzl.zza(new zznt.zza()
    {
      public void onRewardedVideoAdClosed()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.onRewardedVideoAdClosed();
            }
          }
        });
      }
      
      public void onRewardedVideoAdFailedToLoad(final int paramAnonymousInt)
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.onRewardedVideoAdFailedToLoad(paramAnonymousInt);
            }
          }
        });
      }
      
      public void onRewardedVideoAdLeftApplication()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.onRewardedVideoAdLeftApplication();
            }
          }
        });
      }
      
      public void onRewardedVideoAdLoaded()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.onRewardedVideoAdLoaded();
            }
          }
        });
      }
      
      public void onRewardedVideoAdOpened()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.onRewardedVideoAdOpened();
            }
          }
        });
      }
      
      public void onRewardedVideoStarted()
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.onRewardedVideoStarted();
            }
          }
        });
      }
      
      public void zza(final zznq paramAnonymousZznq)
        throws RemoteException
      {
        zziq.zza(zziq.this).add(new zziq.zza()
        {
          public void zzb(zzir paramAnonymous2Zzir)
            throws RemoteException
          {
            if (zzIx != null) {
              zzIx.zza(paramAnonymousZznq);
            }
          }
        });
      }
    });
  }
  
  static abstract interface zza
  {
    public abstract void zzb(zzir paramZzir)
      throws RemoteException;
  }
}
