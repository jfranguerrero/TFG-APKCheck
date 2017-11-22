package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzgo
  extends zzgz.zza
{
  private final Uri mUri;
  private final Drawable zzFQ;
  private final double zzFR;
  
  public zzgo(Drawable paramDrawable, Uri paramUri, double paramDouble)
  {
    zzFQ = paramDrawable;
    mUri = paramUri;
    zzFR = paramDouble;
  }
  
  public double getScale()
  {
    return zzFR;
  }
  
  public Uri getUri()
    throws RemoteException
  {
    return mUri;
  }
  
  public zzd zzfK()
    throws RemoteException
  {
    return zze.zzA(zzFQ);
  }
}
