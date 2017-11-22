package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.zze;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzmu
  extends zzpd
{
  private static zzja zzPU = null;
  static final long zzSs = TimeUnit.SECONDS.toMillis(10L);
  static boolean zzSt;
  private static zzhy zzSu = null;
  private static zzic zzSv = null;
  private static zzhx zzSw = null;
  private static final Object zztU = new Object();
  private final Context mContext;
  private final Object zzPr = new Object();
  private final zzmc.zza zzQQ;
  private final zzmh.zza zzQR;
  private zzja.zzc zzSx;
  
  static
  {
    zzSt = false;
  }
  
  public zzmu(Context paramContext, zzmh.zza paramZza, zzmc.zza arg3)
  {
    super(true);
    zzQQ = ???;
    mContext = paramContext;
    zzQR = paramZza;
    synchronized (zztU)
    {
      if (!zzSt)
      {
        zzSv = new zzic();
        zzSu = new zzhy(paramContext.getApplicationContext(), zzvf);
        zzSw = new zzc();
        zzPU = new zzja(mContext.getApplicationContext(), zzQR.zzvf, (String)zzfx.zzAR.get(), new zzb(), new zza());
        zzSt = true;
      }
      return;
    }
  }
  
  private JSONObject zza(zzmh paramZzmh, String paramString)
  {
    Bundle localBundle = zzRd.extras.getBundle("sdk_less_server_data");
    if (localBundle == null) {}
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = zzna.zza(mContext, new zzmx().zzf(paramZzmh).zza(zzv.zzcS().zzv(mContext)));
    } while (localJSONObject == null);
    try
    {
      paramZzmh = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
      localHashMap = new HashMap();
      localHashMap.put("request_id", paramString);
      localHashMap.put("request_param", localJSONObject);
      localHashMap.put("data", localBundle);
      if (paramZzmh != null)
      {
        localHashMap.put("adid", paramZzmh.getId());
        if (!paramZzmh.isLimitAdTrackingEnabled()) {
          break label165;
        }
        i = 1;
        localHashMap.put("lat", Integer.valueOf(i));
      }
    }
    catch (GooglePlayServicesRepairableException paramZzmh)
    {
      for (;;)
      {
        try
        {
          HashMap localHashMap;
          paramZzmh = zzv.zzcJ().zzP(localHashMap);
          return paramZzmh;
        }
        catch (JSONException paramZzmh)
        {
          int i;
          return null;
        }
        paramZzmh = paramZzmh;
        zzpe.zzc("Cannot get advertising id info", paramZzmh);
        paramZzmh = null;
        continue;
        i = 0;
      }
    }
    catch (IllegalStateException paramZzmh)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesNotAvailableException paramZzmh)
    {
      for (;;) {}
    }
    catch (IOException paramZzmh)
    {
      label165:
      for (;;) {}
    }
  }
  
  protected static void zzb(zzix paramZzix)
  {
    paramZzix.zza("/loadAd", zzSv);
    paramZzix.zza("/fetchHttpRequest", zzSu);
    paramZzix.zza("/invalidRequest", zzSw);
  }
  
  protected static void zzc(zzix paramZzix)
  {
    paramZzix.zzb("/loadAd", zzSv);
    paramZzix.zzb("/fetchHttpRequest", zzSu);
    paramZzix.zzb("/invalidRequest", zzSw);
  }
  
  private zzmk zze(zzmh paramZzmh)
  {
    Object localObject = zzv.zzcJ().zzkk();
    final JSONObject localJSONObject = zza(paramZzmh, (String)localObject);
    if (localJSONObject == null) {
      paramZzmh = new zzmk(0);
    }
    for (;;)
    {
      return paramZzmh;
      long l1 = zzv.zzcP().elapsedRealtime();
      Future localFuture = zzSv.zzab((String)localObject);
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          zzmu.zza(zzmu.this, zzmu.zzjd().zzgv());
          zzmu.zzb(zzmu.this).zza(new zzqi.zzc()new zzqi.zza
          {
            public void zzb(zzjb paramAnonymous2Zzjb)
            {
              try
              {
                paramAnonymous2Zzjb.zza("AFMA_getAdapterLessMediationAd", zzSz);
                return;
              }
              catch (Exception paramAnonymous2Zzjb)
              {
                zzpe.zzb("Error requesting an ad url", paramAnonymous2Zzjb);
                zzmu.zzjc().zzac(zzSA);
              }
            }
          }, new zzqi.zza()
          {
            public void run()
            {
              zzmu.zzjc().zzac(zzSA);
            }
          });
        }
      });
      long l2 = zzSs;
      long l3 = zzv.zzcP().elapsedRealtime();
      try
      {
        localObject = (JSONObject)localFuture.get(l2 - (l3 - l1), TimeUnit.MILLISECONDS);
        if (localObject == null) {
          return new zzmk(-1);
        }
      }
      catch (InterruptedException paramZzmh)
      {
        return new zzmk(-1);
      }
      catch (TimeoutException paramZzmh)
      {
        return new zzmk(2);
      }
      catch (ExecutionException paramZzmh)
      {
        return new zzmk(0);
        localObject = zzna.zza(mContext, paramZzmh, ((JSONObject)localObject).toString());
        paramZzmh = (zzmh)localObject;
        if (errorCode == -3) {
          continue;
        }
        paramZzmh = (zzmh)localObject;
        if (!TextUtils.isEmpty(body)) {
          continue;
        }
        return new zzmk(3);
      }
      catch (CancellationException paramZzmh)
      {
        for (;;) {}
      }
    }
  }
  
  public void onStop()
  {
    synchronized (zzPr)
    {
      zzpx.zzXU.post(new Runnable()
      {
        public void run()
        {
          if (zzmu.zzb(zzmu.this) != null)
          {
            zzmu.zzb(zzmu.this).release();
            zzmu.zza(zzmu.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzcm()
  {
    zzpe.zzbc("SdkLessAdLoaderBackgroundTask started.");
    Object localObject = new zzmh(zzQR, null, -1L);
    zzmk localZzmk = zze((zzmh)localObject);
    long l = zzv.zzcP().elapsedRealtime();
    localObject = new zzov.zza((zzmh)localObject, localZzmk, null, null, errorCode, l, zzRO, null);
    zzpx.zzXU.post(new Runnable()
    {
      public void run()
      {
        zzmu.zza(zzmu.this).zza(zzsI);
        if (zzmu.zzb(zzmu.this) != null)
        {
          zzmu.zzb(zzmu.this).release();
          zzmu.zza(zzmu.this, null);
        }
      }
    });
  }
  
  public static class zza
    implements zzpn<zzix>
  {
    public zza() {}
    
    public void zza(zzix paramZzix)
    {
      zzmu.zzc(paramZzix);
    }
  }
  
  public static class zzb
    implements zzpn<zzix>
  {
    public zzb() {}
    
    public void zza(zzix paramZzix)
    {
      zzmu.zzb(paramZzix);
    }
  }
  
  public static class zzc
    implements zzhx
  {
    public zzc() {}
    
    public void zza(zzqp paramZzqp, Map<String, String> paramMap)
    {
      String str = (String)paramMap.get("request_id");
      paramZzqp = String.valueOf((String)paramMap.get("errors"));
      if (paramZzqp.length() != 0) {}
      for (paramZzqp = "Invalid request: ".concat(paramZzqp);; paramZzqp = new String("Invalid request: "))
      {
        zzpe.zzbe(paramZzqp);
        zzmu.zzjc().zzac(str);
        return;
      }
    }
  }
}
