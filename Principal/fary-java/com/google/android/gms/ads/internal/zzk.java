package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen.zza;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzqa;

@zzmb
public class zzk
  extends zzen.zza
{
  private final Context mContext;
  private final zzjs zzsD;
  private final zzd zzsz;
  private zzel zzti;
  private zzgw zztn;
  private zzet zztp;
  private final String zztq;
  private final zzqa zztr;
  private zzhj zztv;
  private zzhk zztw;
  private SimpleArrayMap<String, zzhl> zztx;
  private SimpleArrayMap<String, zzhm> zzty;
  
  public zzk(Context paramContext, String paramString, zzjs paramZzjs, zzqa paramZzqa, zzd paramZzd)
  {
    mContext = paramContext;
    zztq = paramString;
    zzsD = paramZzjs;
    zztr = paramZzqa;
    zzty = new SimpleArrayMap();
    zztx = new SimpleArrayMap();
    zzsz = paramZzd;
  }
  
  public void zza(zzgw paramZzgw)
  {
    zztn = paramZzgw;
  }
  
  public void zza(zzhj paramZzhj)
  {
    zztv = paramZzhj;
  }
  
  public void zza(zzhk paramZzhk)
  {
    zztw = paramZzhk;
  }
  
  public void zza(String paramString, zzhm paramZzhm, zzhl paramZzhl)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }
    zzty.put(paramString, paramZzhm);
    zztx.put(paramString, paramZzhl);
  }
  
  public void zzb(zzel paramZzel)
  {
    zzti = paramZzel;
  }
  
  public void zzb(zzet paramZzet)
  {
    zztp = paramZzet;
  }
  
  public zzem zzci()
  {
    return new zzj(mContext, zztq, zzsD, zztr, zzti, zztv, zztw, zzty, zztx, zztn, zztp, zzsz);
  }
}
