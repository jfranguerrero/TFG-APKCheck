package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzmd
  extends zzpd
  implements zzme.zza
{
  private final Context mContext;
  private final zzav zzGr;
  private zzmh zzKG;
  zzjj zzKq;
  zzmk zzPp;
  private Runnable zzPq;
  private final Object zzPr = new Object();
  private final zzmc.zza zzQQ;
  private final zzmh.zza zzQR;
  zzpk zzQS;
  
  public zzmd(Context paramContext, zzmh.zza paramZza, zzav paramZzav, zzmc.zza paramZza1)
  {
    zzQQ = paramZza1;
    mContext = paramContext;
    zzQR = paramZza;
    zzGr = paramZzav;
  }
  
  private void zzd(int paramInt, String paramString)
  {
    if ((paramInt == 3) || (paramInt == -1))
    {
      zzpe.zzbd(paramString);
      if (zzPp != null) {
        break label93;
      }
      zzPp = new zzmk(paramInt);
      label33:
      if (zzKG == null) {
        break label115;
      }
    }
    label93:
    label115:
    for (paramString = zzKG;; paramString = new zzmh(zzQR, null, -1L))
    {
      paramString = new zzov.zza(paramString, zzPp, zzKq, null, paramInt, -1L, zzPp.zzRO, null);
      zzQQ.zza(paramString);
      return;
      zzpe.zzbe(paramString);
      break;
      zzPp = new zzmk(paramInt, zzPp.zzKe);
      break label33;
    }
  }
  
  public void onStop()
  {
    synchronized (zzPr)
    {
      if (zzQS != null) {
        zzQS.cancel();
      }
      return;
    }
  }
  
  zzpk zza(zzqa paramZzqa, zzqi<zzmh> paramZzqi)
  {
    return zzme.zza(mContext, paramZzqa, paramZzqi, this);
  }
  
  protected zzec zzb(zzmh paramZzmh)
    throws zzmd.zza
  {
    int j;
    int i;
    zzec localZzec;
    if (zzPp.zzzo)
    {
      localObject = zzvj.zzzm;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localZzec = localObject[i];
        if (zzzo) {
          return new zzec(localZzec, zzvj.zzzm);
        }
        i += 1;
      }
    }
    if (zzPp.zzRN == null) {
      throw new zza("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = zzPp.zzRN.split("x");
    if (localObject.length != 2)
    {
      paramZzmh = String.valueOf(zzPp.zzRN);
      if (paramZzmh.length() != 0) {}
      for (paramZzmh = "Invalid ad size format from the ad response: ".concat(paramZzmh);; paramZzmh = new String("Invalid ad size format from the ad response: ")) {
        throw new zza(paramZzmh, 0);
      }
    }
    try
    {
      m = Integer.parseInt(localObject[0]);
      n = Integer.parseInt(localObject[1]);
      localObject = zzvj.zzzm;
      i1 = localObject.length;
      i = 0;
    }
    catch (NumberFormatException paramZzmh)
    {
      for (;;)
      {
        int m;
        int n;
        int i1;
        float f;
        paramZzmh = String.valueOf(zzPp.zzRN);
        if (paramZzmh.length() != 0) {}
        for (paramZzmh = "Invalid ad size number from the ad response: ".concat(paramZzmh);; paramZzmh = new String("Invalid ad size number from the ad response: ")) {
          throw new zza(paramZzmh, 0);
        }
        j = width;
        continue;
        label359:
        int k = height;
        continue;
        label369:
        i += 1;
      }
      paramZzmh = String.valueOf(zzPp.zzRN);
      if (paramZzmh.length() == 0) {
        break label411;
      }
    }
    if (i < i1)
    {
      localZzec = localObject[i];
      f = mContext.getResources().getDisplayMetrics().density;
      if (width == -1)
      {
        j = (int)(widthPixels / f);
        if (height != -2) {
          break label359;
        }
        k = (int)(heightPixels / f);
        if ((m != j) || (n != k) || (zzzo)) {
          break label369;
        }
        return new zzec(localZzec, zzvj.zzzm);
      }
    }
    label411:
    for (paramZzmh = "The ad size from the ad response was not one of the requested sizes: ".concat(paramZzmh);; paramZzmh = new String("The ad size from the ad response was not one of the requested sizes: ")) {
      throw new zza(paramZzmh, 0);
    }
  }
  
  public void zzb(@NonNull zzmk arg1)
  {
    zzpe.zzbc("Received ad response.");
    zzPp = ???;
    long l = zzv.zzcP().elapsedRealtime();
    synchronized (zzPr)
    {
      zzQS = null;
      zzv.zzcN().zzd(mContext, zzPp.zzRB);
      try
      {
        if ((zzPp.errorCode != -2) && (zzPp.errorCode != -3))
        {
          int i = zzPp.errorCode;
          throw new zza(66 + "There was a problem getting an ad response. ErrorCode: " + i, zzPp.errorCode);
        }
      }
      catch (zza ???)
      {
        zzd(???.getErrorCode(), ???.getMessage());
        zzpi.zzWR.removeCallbacks(zzPq);
        return;
      }
    }
    zziX();
    if (zzKG.zzvj.zzzm != null) {}
    for (??? = zzb(zzKG);; ??? = null)
    {
      zzv.zzcN().zzE(zzPp.zzRU);
      zzv.zzcN().zzF(zzPp.zzSh);
      if (!TextUtils.isEmpty(zzPp.zzRS)) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(zzPp.zzRS);
          ??? = new zzov.zza(zzKG, zzPp, zzKq, ???, -2, l, zzPp.zzRO, localJSONObject);
          zzQQ.zza(???);
          zzpi.zzWR.removeCallbacks(zzPq);
          return;
        }
        catch (Exception localException)
        {
          zzpe.zzb("Error parsing the JSON for Active View.", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void zzcm()
  {
    zzpe.zzbc("AdLoaderBackgroundTask started.");
    zzPq = new Runnable()
    {
      public void run()
      {
        synchronized (zzmd.zza(zzmd.this))
        {
          if (zzQS == null) {
            return;
          }
          onStop();
          zzmd.zza(zzmd.this, 2, "Timed out waiting for ad response.");
          return;
        }
      }
    };
    zzpi.zzWR.postDelayed(zzPq, ((Long)zzfx.zzDd.get()).longValue());
    final zzqj localZzqj = new zzqj();
    long l = zzv.zzcP().elapsedRealtime();
    zzph.zza(new Runnable()
    {
      public void run()
      {
        synchronized (zzmd.zza(zzmd.this))
        {
          zzQS = zza(zzbzzvf, localZzqj);
          if (zzQS == null)
          {
            zzmd.zza(zzmd.this, 0, "Could not start the ad request service.");
            zzpi.zzWR.removeCallbacks(zzmd.zzc(zzmd.this));
          }
          return;
        }
      }
    });
    String str = zzGr.zzW().zzb(mContext);
    zzKG = new zzmh(zzQR, str, l);
    localZzqj.zzg(zzKG);
  }
  
  protected void zziX()
    throws zzmd.zza
  {
    if (zzPp.errorCode == -3) {
      return;
    }
    if (TextUtils.isEmpty(zzPp.body)) {
      throw new zza("No fill from ad server.", 3);
    }
    zzv.zzcN().zzc(mContext, zzPp.zzRl);
    if (zzPp.zzRK) {}
    for (;;)
    {
      try
      {
        zzKq = new zzjj(zzPp.body);
        zzv.zzcN().zzG(zzKq.zzKc);
        if ((TextUtils.isEmpty(zzPp.zzRC)) || (!((Boolean)zzfx.zzEH.get()).booleanValue())) {
          break;
        }
        zzpe.zzbc("Received cookie from server. Setting webview cookie in CookieManager.");
        CookieManager localCookieManager = zzv.zzcL().zzL(mContext);
        if (localCookieManager == null) {
          break;
        }
        localCookieManager.setCookie("googleads.g.doubleclick.net", zzPp.zzRC);
        return;
      }
      catch (JSONException localJSONException)
      {
        zzpe.zzb("Could not parse mediation config.", localJSONException);
        str = String.valueOf(zzPp.body);
        if (str.length() == 0) {}
      }
      for (String str = "Could not parse mediation config: ".concat(str);; str = new String("Could not parse mediation config: ")) {
        throw new zza(str, 0);
      }
      zzv.zzcN().zzG(zzPp.zzKc);
    }
  }
  
  @zzmb
  static final class zza
    extends Exception
  {
    private final int zzPF;
    
    public zza(String paramString, int paramInt)
    {
      super();
      zzPF = paramInt;
    }
    
    public int getErrorCode()
    {
      return zzPF;
    }
  }
}
