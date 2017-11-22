package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;

@zzmb
public class zzip
{
  private final Context mContext;
  private final zzjs zzsD;
  private final zzd zzsz;
  private final zzqa zztr;
  
  zzip(Context paramContext, zzjs paramZzjs, zzqa paramZzqa, zzd paramZzd)
  {
    mContext = paramContext;
    zzsD = paramZzjs;
    zztr = paramZzqa;
    zzsz = paramZzd;
  }
  
  public Context getApplicationContext()
  {
    return mContext.getApplicationContext();
  }
  
  public zzl zzag(String paramString)
  {
    return new zzl(mContext, new zzec(), paramString, zzsD, zztr, zzsz);
  }
  
  public zzl zzah(String paramString)
  {
    return new zzl(mContext.getApplicationContext(), new zzec(), paramString, zzsD, zztr, zzsz);
  }
  
  public zzip zzgi()
  {
    return new zzip(getApplicationContext(), zzsD, zztr, zzsz);
  }
}
