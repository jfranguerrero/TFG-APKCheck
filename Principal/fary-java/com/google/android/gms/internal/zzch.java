package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.gms.dynamic.zze;

@zzmb
public final class zzch
{
  private final zzcl zzrR;
  
  public zzch(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzrR = zzck.zzb(paramString, paramContext, paramBoolean);
  }
  
  public void zza(MotionEvent paramMotionEvent)
    throws RemoteException
  {
    zzrR.zzd(zze.zzA(paramMotionEvent));
  }
  
  public Uri zzc(Uri paramUri, Context paramContext)
    throws zzci, RemoteException
  {
    paramUri = zze.zzA(paramUri);
    paramContext = zze.zzA(paramContext);
    paramUri = zzrR.zza(paramUri, paramContext);
    if (paramUri == null) {
      throw new zzci();
    }
    return (Uri)zze.zzE(paramUri);
  }
  
  public Uri zzd(Uri paramUri, Context paramContext)
    throws zzci, RemoteException
  {
    paramUri = zze.zzA(paramUri);
    paramContext = zze.zzA(paramContext);
    paramUri = zzrR.zzb(paramUri, paramContext);
    if (paramUri == null) {
      throw new zzci();
    }
    return (Uri)zze.zzE(paramUri);
  }
}
