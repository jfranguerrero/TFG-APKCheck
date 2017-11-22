package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzeu.zza;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.internal.zzqa;

@zzmb
public class zzp
  extends zzeu.zza
{
  private static final Object zztU = new Object();
  @Nullable
  private static zzp zztV;
  private final Context mContext;
  private final Object zzrN = new Object();
  private boolean zztW;
  private boolean zztX;
  private float zztY = -1.0F;
  private zzqa zztZ;
  
  zzp(Context paramContext, zzqa paramZzqa)
  {
    mContext = paramContext;
    zztZ = paramZzqa;
    zztW = false;
  }
  
  public static zzp zza(Context paramContext, zzqa paramZzqa)
  {
    synchronized (zztU)
    {
      if (zztV == null) {
        zztV = new zzp(paramContext.getApplicationContext(), paramZzqa);
      }
      paramContext = zztV;
      return paramContext;
    }
  }
  
  @Nullable
  public static zzp zzcn()
  {
    synchronized (zztU)
    {
      zzp localZzp = zztV;
      return localZzp;
    }
  }
  
  public void initialize()
  {
    synchronized (zztU)
    {
      if (zztW)
      {
        zzpe.zzbe("Mobile ads is initialized already.");
        return;
      }
      zztW = true;
      zzfx.initialize(mContext);
      zzv.zzcN().zzc(mContext, zztZ);
      zzv.zzcO().initialize(mContext);
      return;
    }
  }
  
  public void setAppMuted(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zztX = paramBoolean;
      return;
    }
  }
  
  public void setAppVolume(float paramFloat)
  {
    synchronized (zzrN)
    {
      zztY = paramFloat;
      return;
    }
  }
  
  public void zzb(zzd paramZzd, String paramString)
  {
    paramZzd = zzc(paramZzd, paramString);
    if (paramZzd == null)
    {
      zzpe.e("Context is null. Failed to open debug menu.");
      return;
    }
    paramZzd.showDialog();
  }
  
  @Nullable
  protected zzpl zzc(zzd paramZzd, String paramString)
  {
    if (paramZzd == null) {
      return null;
    }
    paramZzd = (Context)zze.zzE(paramZzd);
    if (paramZzd == null) {
      return null;
    }
    paramZzd = new zzpl(paramZzd);
    paramZzd.setAdUnitId(paramString);
    return paramZzd;
  }
  
  public float zzco()
  {
    synchronized (zzrN)
    {
      float f = zztY;
      return f;
    }
  }
  
  public boolean zzcp()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zztY >= 0.0F)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean zzcq()
  {
    synchronized (zzrN)
    {
      boolean bool = zztX;
      return bool;
    }
  }
  
  public void zzy(String paramString)
  {
    zzfx.initialize(mContext);
    if ((!TextUtils.isEmpty(paramString)) && (((Boolean)zzfx.zzEp.get()).booleanValue())) {
      zzv.zzdf().zza(mContext, zztZ, true, null, paramString, null);
    }
  }
}
