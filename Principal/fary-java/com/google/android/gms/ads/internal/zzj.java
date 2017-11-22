package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzem.zza;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzqa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzj
  extends zzem.zza
{
  private final Context mContext;
  private final Object zzrN = new Object();
  private final zzjs zzsD;
  private final zzd zzsz;
  private final zzel zzti;
  @Nullable
  private final zzhj zztj;
  @Nullable
  private final zzhk zztk;
  private final SimpleArrayMap<String, zzhm> zztl;
  private final SimpleArrayMap<String, zzhl> zztm;
  private final zzgw zztn;
  private final List<String> zzto;
  private final zzet zztp;
  private final String zztq;
  private final zzqa zztr;
  @Nullable
  private WeakReference<zzr> zzts;
  
  zzj(Context paramContext, String paramString, zzjs paramZzjs, zzqa paramZzqa, zzel paramZzel, zzhj paramZzhj, zzhk paramZzhk, SimpleArrayMap<String, zzhm> paramSimpleArrayMap, SimpleArrayMap<String, zzhl> paramSimpleArrayMap1, zzgw paramZzgw, zzet paramZzet, zzd paramZzd)
  {
    mContext = paramContext;
    zztq = paramString;
    zzsD = paramZzjs;
    zztr = paramZzqa;
    zzti = paramZzel;
    zztk = paramZzhk;
    zztj = paramZzhj;
    zztl = paramSimpleArrayMap;
    zztm = paramSimpleArrayMap1;
    zztn = paramZzgw;
    zzto = zzcg();
    zztp = paramZzet;
    zzsz = paramZzd;
  }
  
  private List<String> zzcg()
  {
    ArrayList localArrayList = new ArrayList();
    if (zztk != null) {
      localArrayList.add("1");
    }
    if (zztj != null) {
      localArrayList.add("2");
    }
    if (zztl.size() > 0) {
      localArrayList.add("3");
    }
    return localArrayList;
  }
  
  @Nullable
  public String getMediationAdapterClassName()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzts != null)
        {
          Object localObject1 = (zzr)zzts.get();
          if (localObject1 != null)
          {
            localObject1 = ((zzr)localObject1).getMediationAdapterClassName();
            return localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public boolean isLoading()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzts != null)
        {
          zzr localZzr = (zzr)zzts.get();
          if (localZzr != null)
          {
            bool = localZzr.isLoading();
            return bool;
          }
        }
        else
        {
          return false;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void runOnUiThread(Runnable paramRunnable)
  {
    zzpi.zzWR.post(paramRunnable);
  }
  
  protected zzr zzch()
  {
    return new zzr(mContext, zzsz, zzec.zzj(mContext), zztq, zzsD, zztr);
  }
  
  public void zzf(final zzdy paramZzdy)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        synchronized (zzj.zza(zzj.this))
        {
          zzr localZzr = zzch();
          zzj.zza(zzj.this, new WeakReference(localZzr));
          localZzr.zzb(zzj.zzb(zzj.this));
          localZzr.zzb(zzj.zzc(zzj.this));
          localZzr.zza(zzj.zzd(zzj.this));
          localZzr.zza(zzj.zze(zzj.this));
          localZzr.zzb(zzj.zzf(zzj.this));
          localZzr.zzb(zzj.zzg(zzj.this));
          localZzr.zzb(zzj.zzh(zzj.this));
          localZzr.zza(zzj.zzi(zzj.this));
          localZzr.zzb(paramZzdy);
          return;
        }
      }
    });
  }
}
