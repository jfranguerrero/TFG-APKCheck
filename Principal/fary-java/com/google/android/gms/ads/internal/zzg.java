package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zzc;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqi.zzb;
import com.google.android.gms.internal.zzqi.zzc;
import com.google.android.gms.internal.zzqp;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzg
{
  private Context mContext;
  private final Object zzrN = new Object();
  public final zzhx zzsX = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousZzqp.zzb("/appSettingsFetched", this);
      paramAnonymousZzqp = zzg.zza(zzg.this);
      if (paramAnonymousMap != null) {}
      try
      {
        if ("true".equalsIgnoreCase((String)paramAnonymousMap.get("isSuccessful")))
        {
          paramAnonymousMap = (String)paramAnonymousMap.get("appSettingsJson");
          zzv.zzcN().zzd(zzg.zzb(zzg.this), paramAnonymousMap);
        }
        return;
      }
      finally {}
    }
  };
  
  public zzg() {}
  
  private static boolean zza(@Nullable zzox paramZzox)
  {
    if (paramZzox == null) {
      return true;
    }
    long l = paramZzox.zzjF();
    int i;
    if (zzv.zzcP().currentTimeMillis() - l > ((Long)zzfx.zzEr.get()).longValue())
    {
      i = 1;
      if ((i == 0) && (paramZzox.zzjG())) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i = 0;
      break;
    }
  }
  
  public void zza(final Context paramContext, final zzqa paramZzqa, final boolean paramBoolean, @Nullable zzox paramZzox, final String paramString1, @Nullable final String paramString2)
  {
    if (!zza(paramZzox)) {
      return;
    }
    if (paramContext == null)
    {
      zzpe.zzbe("Context not provided to fetch application settings");
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      zzpe.zzbe("App settings could not be fetched. Required parameters missing");
      return;
    }
    mContext = paramContext;
    paramZzqa = zzv.zzcJ().zzd(paramContext, paramZzqa);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        paramZzqa.zzgv().zza(new zzqi.zzc()new zzqi.zzb
        {
          public void zzb(zzjb paramAnonymous2Zzjb)
          {
            paramAnonymous2Zzjb.zza("/appSettingsFetched", zzsX);
            try
            {
              JSONObject localJSONObject = new JSONObject();
              if (!TextUtils.isEmpty(zzta)) {
                localJSONObject.put("app_id", zzta);
              }
              for (;;)
              {
                localJSONObject.put("is_init", zztc);
                localJSONObject.put("pn", zztd.getPackageName());
                paramAnonymous2Zzjb.zza("AFMA_fetchAppSettings", localJSONObject);
                return;
                if (!TextUtils.isEmpty(zztb)) {
                  localJSONObject.put("ad_unit_id", zztb);
                }
              }
              return;
            }
            catch (Exception localException)
            {
              paramAnonymous2Zzjb.zzb("/appSettingsFetched", zzsX);
              zzpe.zzb("Error requesting application settings", localException);
            }
          }
        }, new zzqi.zzb());
      }
    });
  }
}
