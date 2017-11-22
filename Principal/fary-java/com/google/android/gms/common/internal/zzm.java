package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzm
  implements Handler.Callback
{
  private final Handler mHandler;
  private volatile boolean zzaEA = false;
  private final AtomicInteger zzaEB = new AtomicInteger(0);
  private boolean zzaEC = false;
  private final zza zzaEw;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaEx = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaEy = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaEz = new ArrayList();
  private final Object zzrN = new Object();
  
  public zzm(Looper paramLooper, zza paramZza)
  {
    zzaEw = paramZza;
    mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)obj;
      synchronized (zzrN)
      {
        if ((zzaEA) && (zzaEw.isConnected()) && (zzaEx.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(zzaEw.zzud());
        }
        return true;
      }
    }
    int i = what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzw(paramConnectionCallbacks);
    synchronized (zzrN)
    {
      boolean bool = zzaEx.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzw(paramOnConnectionFailedListener);
    synchronized (zzrN)
    {
      boolean bool = zzaEz.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzw(paramConnectionCallbacks);
    synchronized (zzrN)
    {
      if (zzaEx.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(str).length() + 62 + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (zzaEw.isConnected()) {
          mHandler.sendMessage(mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      zzaEx.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzw(paramOnConnectionFailedListener);
    synchronized (zzrN)
    {
      if (zzaEz.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 67 + "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      zzaEz.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzw(paramConnectionCallbacks);
    synchronized (zzrN)
    {
      if (!zzaEx.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(paramConnectionCallbacks).length() + 52 + "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      while (!zzaEC) {
        return;
      }
      zzaEy.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzw(paramOnConnectionFailedListener);
    synchronized (zzrN)
    {
      if (!zzaEz.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 57 + "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public void zzcP(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == mHandler.getLooper()) {
      bool = true;
    }
    zzac.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    mHandler.removeMessages(1);
    synchronized (zzrN)
    {
      zzaEC = true;
      Object localObject2 = new ArrayList(zzaEx);
      int i = zzaEB.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((zzaEA) && (zzaEB.get() == i)) {}
        }
        else
        {
          zzaEy.clear();
          zzaEC = false;
          return;
        }
      } while (!zzaEx.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void zzo(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      mHandler.removeMessages(1);
      synchronized (zzrN)
      {
        Object localObject2 = new ArrayList(zzaEz);
        int i = zzaEB.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!zzaEA) || (zzaEB.get() != i)) {
            return;
          }
          if (zzaEz.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public void zzq(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == mHandler.getLooper())
    {
      bool1 = true;
      zzac.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzaEC) {
          break label206;
        }
        bool1 = true;
        zzac.zzar(bool1);
        mHandler.removeMessages(1);
        zzaEC = true;
        if (zzaEy.size() != 0) {
          break label211;
        }
        bool1 = bool2;
        zzac.zzar(bool1);
        Object localObject2 = new ArrayList(zzaEx);
        int i = zzaEB.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((zzaEA) && (zzaEw.isConnected()) && (zzaEB.get() == i)) {}
        }
        else
        {
          zzaEy.clear();
          zzaEC = false;
          return;
        }
        if (zzaEy.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label206:
      bool1 = false;
      continue;
      label211:
      bool1 = false;
    }
  }
  
  public void zzxq()
  {
    zzaEA = false;
    zzaEB.incrementAndGet();
  }
  
  public void zzxr()
  {
    zzaEA = true;
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zzud();
  }
}
