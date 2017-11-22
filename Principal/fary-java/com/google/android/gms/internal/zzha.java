package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.dynamic.zze;

@zzmb
public class zzha
  extends NativeAd.Image
{
  private final Drawable mDrawable;
  private final Uri mUri;
  private final double zzFR;
  private final zzgz zzGR;
  
  public zzha(zzgz paramZzgz)
  {
    zzGR = paramZzgz;
    try
    {
      paramZzgz = zzGR.zzfK();
      if (paramZzgz == null) {
        break label83;
      }
      paramZzgz = (Drawable)zze.zzE(paramZzgz);
    }
    catch (RemoteException paramZzgz)
    {
      try
      {
        paramZzgz = zzGR.getUri();
        mUri = paramZzgz;
        double d1 = 1.0D;
        try
        {
          double d2 = zzGR.getScale();
          d1 = d2;
        }
        catch (RemoteException paramZzgz)
        {
          for (;;)
          {
            zzpy.zzb("Failed to get scale.", paramZzgz);
          }
        }
        zzFR = d1;
        return;
        paramZzgz = paramZzgz;
        zzpy.zzb("Failed to get drawable.", paramZzgz);
        paramZzgz = null;
      }
      catch (RemoteException paramZzgz)
      {
        for (;;)
        {
          zzpy.zzb("Failed to get uri.", paramZzgz);
          paramZzgz = localObject;
        }
      }
    }
    mDrawable = paramZzgz;
  }
  
  public Drawable getDrawable()
  {
    return mDrawable;
  }
  
  public double getScale()
  {
    return zzFR;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
}
