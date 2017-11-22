package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;

@zzmb
class zzir
{
  @Nullable
  zzer zzIt;
  @Nullable
  zzkz zzIu;
  @Nullable
  zzgj zzIv;
  @Nullable
  zzek zzIw;
  @Nullable
  zznt zzIx;
  @Nullable
  zzel zzti;
  
  zzir() {}
  
  void zzc(zzl paramZzl)
  {
    if (zzti != null) {
      paramZzl.zza(new zza(zzti));
    }
    if (zzIt != null) {
      paramZzl.zza(zzIt);
    }
    if (zzIu != null) {
      paramZzl.zza(zzIu);
    }
    if (zzIv != null) {
      paramZzl.zza(zzIv);
    }
    if (zzIw != null) {
      paramZzl.zza(zzIw);
    }
    if (zzIx != null) {
      paramZzl.zza(zzIx);
    }
  }
  
  private static class zza
    extends zzel.zza
  {
    private final zzel zzIy;
    
    zza(zzel paramZzel)
    {
      zzIy = paramZzel;
    }
    
    public void onAdClosed()
      throws RemoteException
    {
      zzIy.onAdClosed();
      zzv.zzcY().zzgj();
    }
    
    public void onAdFailedToLoad(int paramInt)
      throws RemoteException
    {
      zzIy.onAdFailedToLoad(paramInt);
    }
    
    public void onAdLeftApplication()
      throws RemoteException
    {
      zzIy.onAdLeftApplication();
    }
    
    public void onAdLoaded()
      throws RemoteException
    {
      zzIy.onAdLoaded();
    }
    
    public void onAdOpened()
      throws RemoteException
    {
      zzIy.onAdOpened();
    }
  }
}
