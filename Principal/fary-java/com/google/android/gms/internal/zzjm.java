package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzjm
  implements zzjn.zza
{
  private final Context mContext;
  private final String zzKo;
  private final long zzKp;
  private final zzjj zzKq;
  private final zzji zzKr;
  private final boolean zzKs;
  private zzjt zzKt;
  private int zzKu = -2;
  private zzjv zzKv;
  private final Object zzrN = new Object();
  private final zzjs zzsD;
  private final zzgw zztn;
  private final List<String> zzto;
  private final zzqa zztr;
  private zzdy zzug;
  private final zzec zzum;
  private final boolean zzvW;
  
  public zzjm(Context paramContext, String paramString, zzjs paramZzjs, zzjj paramZzjj, zzji paramZzji, zzdy paramZzdy, zzec paramZzec, zzqa paramZzqa, boolean paramBoolean1, boolean paramBoolean2, zzgw paramZzgw, List<String> paramList)
  {
    mContext = paramContext;
    zzsD = paramZzjs;
    zzKr = paramZzji;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      zzKo = zzgC();
      zzKq = paramZzjj;
      if (zzJX == -1L) {
        break label136;
      }
    }
    label136:
    for (long l = zzJX;; l = 10000L)
    {
      zzKp = l;
      zzug = paramZzdy;
      zzum = paramZzec;
      zztr = paramZzqa;
      zzvW = paramBoolean1;
      zzKs = paramBoolean2;
      zztn = paramZzgw;
      zzto = paramList;
      return;
      zzKo = paramString;
      break;
    }
  }
  
  private boolean zzE(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Bundle localBundle;
        if (zzvW)
        {
          localBundle = zzKt.zzgM();
          if (localBundle != null)
          {
            if ((localBundle.getInt("capabilities", 0) & paramInt) == paramInt) {
              bool = true;
            }
          }
          else {
            return bool;
          }
        }
        else
        {
          if (zzum.zzzl)
          {
            localBundle = zzKt.getInterstitialAdapterInfo();
            continue;
          }
          localBundle = zzKt.zzgL();
          continue;
        }
        bool = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzpe.zzbe("Could not get adapter info. Returning false");
        return false;
      }
    }
  }
  
  private static zzjv zzF(int paramInt)
  {
    new zzjv.zza()
    {
      public int zzgH()
        throws RemoteException
      {
        return zzKy;
      }
    };
  }
  
  private long zza(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (zzKu != -2) {
        return zzv.zzcP().elapsedRealtime() - paramLong1;
      }
      zzb(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void zza(zzjl paramZzjl)
  {
    String str = zzao(zzKr.zzJO);
    try
    {
      if (zztr.zzYc < 4100000)
      {
        if (zzum.zzzl)
        {
          zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzug, str, paramZzjl);
          return;
        }
        zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzum, zzug, str, paramZzjl);
        return;
      }
    }
    catch (RemoteException paramZzjl)
    {
      zzpe.zzc("Could not request ad from mediation adapter.", paramZzjl);
      zzD(5);
      return;
    }
    if (zzvW)
    {
      zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzug, str, zzKr.zzJG, paramZzjl, zztn, zzto);
      return;
    }
    if (zzum.zzzl)
    {
      zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzug, str, zzKr.zzJG, paramZzjl);
      return;
    }
    if (zzKs)
    {
      if (zzKr.zzJR != null)
      {
        zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzug, str, zzKr.zzJG, paramZzjl, new zzgw(zzap(zzKr.zzJV)), zzKr.zzJU);
        return;
      }
      zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzum, zzug, str, zzKr.zzJG, paramZzjl);
      return;
    }
    zzKt.zza(com.google.android.gms.dynamic.zze.zzA(mContext), zzum, zzug, str, zzKr.zzJG, paramZzjl);
  }
  
  private String zzao(String paramString)
  {
    if ((paramString == null) || (!zzgF()) || (zzE(2))) {
      return paramString;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).remove("cpm_floor_cents");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzbe("Could not remove field. Returning the original value");
    }
    return paramString;
  }
  
  private static NativeAdOptions zzap(String paramString)
  {
    NativeAdOptions.Builder localBuilder = new NativeAdOptions.Builder();
    if (paramString == null) {
      return localBuilder.build();
    }
    try
    {
      paramString = new JSONObject(paramString);
      localBuilder.setRequestMultipleImages(paramString.optBoolean("multiple_images", false));
      localBuilder.setReturnUrlsForImageAssets(paramString.optBoolean("only_urls", false));
      localBuilder.setImageOrientation(zzaq(paramString.optString("native_image_orientation", "any")));
      return localBuilder.build();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        zzpe.zzc("Exception occurred when creating native ad options", paramString);
      }
    }
  }
  
  private static int zzaq(String paramString)
  {
    if ("landscape".equals(paramString)) {
      return 2;
    }
    if ("portrait".equals(paramString)) {
      return 1;
    }
    return 0;
  }
  
  private void zzb(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      zzpe.zzbd("Timed out waiting for adapter.");
      zzKu = 3;
      return;
    }
    try
    {
      zzrN.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzKu = -1;
    }
  }
  
  private String zzgC()
  {
    try
    {
      if (!TextUtils.isEmpty(zzKr.zzJK))
      {
        if (zzsD.zzas(zzKr.zzJK)) {
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzbe("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private zzjv zzgD()
  {
    if ((zzKu != 0) || (!zzgF())) {
      return null;
    }
    try
    {
      if ((zzE(4)) && (zzKv != null) && (zzKv.zzgH() != 0))
      {
        zzjv localZzjv = zzKv;
        return localZzjv;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzbe("Could not get cpm value from MediationResponseMetadata");
    }
    return zzF(zzgG());
  }
  
  private zzjt zzgE()
  {
    Object localObject = String.valueOf(zzKo);
    if (((String)localObject).length() != 0) {}
    for (localObject = "Instantiating mediation adapter: ".concat((String)localObject);; localObject = new String("Instantiating mediation adapter: "))
    {
      zzpe.zzbd((String)localObject);
      if (zzvW) {
        break label156;
      }
      if ((!((Boolean)zzfx.zzDb.get()).booleanValue()) || (!"com.google.ads.mediation.admob.AdMobAdapter".equals(zzKo))) {
        break;
      }
      return zza(new AdMobAdapter());
    }
    if ((((Boolean)zzfx.zzDc.get()).booleanValue()) && ("com.google.ads.mediation.AdUrlAdapter".equals(zzKo))) {
      return zza(new AdUrlAdapter());
    }
    if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(zzKo)) {
      return new zzjz(new zzkh());
    }
    try
    {
      label156:
      localObject = zzsD.zzar(zzKo);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      localObject = String.valueOf(zzKo);
      if (((String)localObject).length() == 0) {}
    }
    for (localObject = "Could not instantiate mediation adapter: ".concat((String)localObject);; localObject = new String("Could not instantiate mediation adapter: "))
    {
      zzpe.zza((String)localObject, localRemoteException);
      return null;
    }
  }
  
  private boolean zzgF()
  {
    return zzKq.zzKh != -1;
  }
  
  private int zzgG()
  {
    int j;
    if (zzKr.zzJO == null)
    {
      j = 0;
      return j;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(zzKr.zzJO);
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(zzKo)) {
        return localJSONObject.optInt("cpm_cents", 0);
      }
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzbe("Could not convert to json. Returning 0");
      return 0;
    }
    if (zzE(2)) {}
    for (int i = localJSONException.optInt("cpm_floor_cents", 0);; i = 0)
    {
      j = i;
      if (i != 0) {
        break;
      }
      return localJSONException.optInt("penalized_average_cpm_cents", 0);
    }
  }
  
  public void cancel()
  {
    synchronized (zzrN)
    {
      try
      {
        if (zzKt != null) {
          zzKt.destroy();
        }
        zzKu = -1;
        zzrN.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          zzpe.zzc("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void zzD(int paramInt)
  {
    synchronized (zzrN)
    {
      zzKu = paramInt;
      zzrN.notify();
      return;
    }
  }
  
  public zzjn zza(long paramLong1, long paramLong2)
  {
    synchronized (zzrN)
    {
      long l = SystemClock.elapsedRealtime();
      Object localObject2 = new zzjl();
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          synchronized (zzjm.zza(zzjm.this))
          {
            if (zzjm.zzb(zzjm.this) != -2) {
              return;
            }
            zzjm.zza(zzjm.this, zzjm.zzc(zzjm.this));
            if (zzjm.zzd(zzjm.this) == null)
            {
              zzD(4);
              return;
            }
          }
          if ((zzjm.zze(zzjm.this)) && (!zzjm.zza(zzjm.this, 1)))
          {
            String str = zzjm.zzf(zzjm.this);
            zzpe.zzbe(String.valueOf(str).length() + 56 + "Ignoring adapter " + str + " as delayed impression is not supported");
            zzD(2);
            return;
          }
          zzKw.zza(zzjm.this);
          zzjm.zza(zzjm.this, zzKw);
        }
      });
      paramLong1 = zza(l, zzKp, paramLong1, paramLong2);
      localObject2 = new zzjn(zzKr, zzKt, zzKo, (zzjl)localObject2, zzKu, zzgD(), paramLong1);
      return localObject2;
    }
  }
  
  protected zzjt zza(MediationAdapter paramMediationAdapter)
  {
    return new zzjz(paramMediationAdapter);
  }
  
  public void zza(int paramInt, zzjv paramZzjv)
  {
    synchronized (zzrN)
    {
      zzKu = paramInt;
      zzKv = paramZzjv;
      zzrN.notify();
      return;
    }
  }
}
