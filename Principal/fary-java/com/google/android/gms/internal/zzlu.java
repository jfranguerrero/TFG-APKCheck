package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.dynamic.zze;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlu
  implements Callable<zzov>
{
  static long zzPS = TimeUnit.SECONDS.toMillis(60L);
  private final Context mContext;
  private final zzlt zzGp;
  private final zzav zzGr;
  private int zzPF;
  private final zzov.zza zzPo;
  private final zzpp zzQb;
  private final zzr zzQc;
  private boolean zzQd;
  private List<String> zzQe;
  private JSONObject zzQf;
  private final Object zzrN = new Object();
  private final zzgf zzsr;
  
  public zzlu(Context paramContext, zzr paramZzr, zzpp paramZzpp, zzav paramZzav, zzov.zza paramZza, zzgf paramZzgf)
  {
    mContext = paramContext;
    zzQc = paramZzr;
    zzQb = paramZzpp;
    zzPo = paramZza;
    zzGr = paramZzav;
    zzsr = paramZzgf;
    zzGp = zza(paramContext, paramZza, paramZzr, paramZzav);
    zzGp.zziE();
    zzQd = false;
    zzPF = -2;
    zzQe = null;
  }
  
  private zzgu.zza zza(zza paramZza, JSONObject paramJSONObject, String paramString)
    throws ExecutionException, InterruptedException, JSONException
  {
    if ((zziQ()) || (paramZza == null) || (paramJSONObject == null)) {
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("tracking_urls_and_actions");
    Object localObject = zzd(localJSONObject, "impression_tracking_urls");
    if (localObject == null) {}
    for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
    {
      zzQe = ((List)localObject);
      zzQf = localJSONObject.optJSONObject("active_view");
      paramZza = paramZza.zza(this, paramJSONObject);
      if (paramZza != null) {
        break;
      }
      zzpe.e("Failed to retrieve ad assets.");
      return null;
    }
    paramZza.zzb(new zzgv(mContext, zzQc, zzGp, zzGr, paramJSONObject, paramZza, zzPo.zzSF.zzvf, paramString));
    return paramZza;
  }
  
  private zzqf<zzgo> zza(JSONObject paramJSONObject, final boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    final double d;
    boolean bool;
    for (final String str = paramJSONObject.getString("url");; str = paramJSONObject.optString("url"))
    {
      d = paramJSONObject.optDouble("scale", 1.0D);
      bool = paramJSONObject.optBoolean("is_transparent", true);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      zza(0, paramBoolean1);
      return new zzqd(null);
    }
    if (paramBoolean2) {
      return new zzqd(new zzgo(null, Uri.parse(str), d));
    }
    zzQb.zza(str, new zzpp.zza()
    {
      @TargetApi(19)
      public zzgo zzg(InputStream paramAnonymousInputStream)
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        inDensity = ((int)(160.0D * d));
        if (!str) {
          inPreferredConfig = Bitmap.Config.RGB_565;
        }
        try
        {
          paramAnonymousInputStream = BitmapFactory.decodeStream(paramAnonymousInputStream, null, localOptions);
          if (paramAnonymousInputStream == null)
          {
            zza(2, paramBoolean1);
            return null;
          }
        }
        catch (Exception paramAnonymousInputStream)
        {
          for (;;)
          {
            zzpe.zzb("Error grabbing image.", paramAnonymousInputStream);
            paramAnonymousInputStream = null;
          }
          if (zzs.zzyF())
          {
            int i = paramAnonymousInputStream.getWidth();
            int j = paramAnonymousInputStream.getHeight();
            int k = paramAnonymousInputStream.getAllocationByteCount();
            zzpe.v(61 + "Decoded image w: " + i + " h:" + j + " bytes: " + k);
          }
        }
        return new zzgo(new BitmapDrawable(Resources.getSystem(), paramAnonymousInputStream), Uri.parse(zzLG), d);
      }
      
      public zzgo zziS()
      {
        zza(2, paramBoolean1);
        return null;
      }
    });
  }
  
  private void zza(zzgu.zza paramZza)
  {
    if (!(paramZza instanceof zzgr)) {
      return;
    }
    Object localObject = (zzgr)paramZza;
    paramZza = new zzb();
    localObject = new zzhx()
    {
      public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
      {
        paramAnonymousZzqp = (String)paramAnonymousMap.get("asset");
        zzlu.zza(zzlu.this, zzQn, paramAnonymousZzqp);
      }
    };
    zzQz = ((zzhx)localObject);
    zzGp.zza(new zzlt.zza()
    {
      public void zze(zzjb paramAnonymousZzjb)
      {
        paramAnonymousZzjb.zza("/nativeAdCustomClick", zzQo);
      }
    });
  }
  
  private JSONObject zzaG(final String paramString)
    throws ExecutionException, InterruptedException, TimeoutException, JSONException
  {
    if (zziQ()) {
      return null;
    }
    final zzqc localZzqc = new zzqc();
    paramString = new zzlt.zza()
    {
      public void zze(final zzjb paramAnonymousZzjb)
      {
        Object localObject = new zzhx()
        {
          public void zza(zzqp paramAnonymous2Zzqp, Map<String, String> paramAnonymous2Map)
          {
            try
            {
              paramAnonymous2Zzqp = (String)paramAnonymous2Map.get("success");
              if (TextUtils.isEmpty(paramAnonymous2Zzqp)) {
                return;
              }
              paramAnonymous2Map = new JSONObject(paramAnonymous2Zzqp);
              if (zzQg.equals(paramAnonymous2Map.optString("ads_id", "")))
              {
                paramAnonymousZzjb.zzb("/nativeAdPreProcess", zzQh.zzQz);
                zzQi.zzh(new JSONObject(paramAnonymous2Zzqp).getJSONArray("ads").getJSONObject(0));
                return;
              }
            }
            catch (JSONException paramAnonymous2Zzqp)
            {
              zzpe.zzb("Malformed native JSON response.", paramAnonymous2Zzqp);
              zzS(0);
              zzac.zza(zziQ(), "Unable to set the ad state error!");
              zzQi.zzh(null);
            }
          }
        };
        zzQh.zzQz = ((zzhx)localObject);
        paramAnonymousZzjb.zza("/nativeAdPreProcess", (zzhx)localObject);
        try
        {
          localObject = new JSONObject(zzazzVB.body);
          ((JSONObject)localObject).put("ads_id", paramString);
          paramAnonymousZzjb.zza("google.afma.nativeAds.preProcessJsonGmsg", (JSONObject)localObject);
          return;
        }
        catch (JSONException paramAnonymousZzjb)
        {
          zzpe.zzc("Exception occurred while invoking javascript", paramAnonymousZzjb);
          localZzqc.zzh(null);
        }
      }
      
      public void zziO()
      {
        localZzqc.zzh(null);
      }
    };
    zzGp.zza(paramString);
    return (JSONObject)localZzqc.get(zzPS, TimeUnit.MILLISECONDS);
  }
  
  private zzov zzb(zzgu.zza paramZza)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        int j = zzPF;
        int i = j;
        if (paramZza == null)
        {
          i = j;
          if (zzPF == -2) {
            i = 0;
          }
        }
        if (i != -2)
        {
          paramZza = null;
          return new zzov(zzPo.zzSF.zzRd, null, zzPo.zzVB.zzJY, i, zzPo.zzVB.zzJZ, zzQe, zzPo.zzVB.orientation, zzPo.zzVB.zzKe, zzPo.zzSF.zzRg, false, null, null, null, null, null, 0L, zzPo.zzvj, zzPo.zzVB.zzRJ, zzPo.zzVv, zzPo.zzVw, zzPo.zzVB.zzRP, zzQf, paramZza, null, null, null, zzPo.zzVB.zzSc, zzPo.zzVB.zzSd, null, zzPo.zzVB.zzKb, zzPo.zzVB.zzSg);
        }
      }
    }
  }
  
  private Integer zzb(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      int i = Color.rgb(paramJSONObject.getInt("r"), paramJSONObject.getInt("g"), paramJSONObject.getInt("b"));
      return Integer.valueOf(i);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private void zzb(zzhh paramZzhh, String paramString)
  {
    try
    {
      zzhl localZzhl = zzQc.zzz(paramZzhh.getCustomTemplateId());
      if (localZzhl != null) {
        localZzhl.zza(paramZzhh, paramString);
      }
      return;
    }
    catch (RemoteException paramZzhh)
    {
      zzpe.zzc(String.valueOf(paramString).length() + 40 + "Failed to call onCustomClick for asset " + paramString + ".", paramZzhh);
    }
  }
  
  private String[] zzd(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    paramString = new String[paramJSONObject.length()];
    int i = 0;
    while (i < paramJSONObject.length())
    {
      paramString[i] = paramJSONObject.getString(i);
      i += 1;
    }
    return paramString;
  }
  
  private static List<Drawable> zzh(List<zzgo> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((Drawable)zze.zzE(((zzgo)paramList.next()).zzfK()));
    }
    return localArrayList;
  }
  
  public void zzS(int paramInt)
  {
    synchronized (zzrN)
    {
      zzQd = true;
      zzPF = paramInt;
      return;
    }
  }
  
  zzlt zza(Context paramContext, zzov.zza paramZza, zzr paramZzr, zzav paramZzav)
  {
    return new zzlt(paramContext, paramZza, paramZzr, paramZzav);
  }
  
  zzlv zza(Context paramContext, zzav paramZzav, zzov.zza paramZza, zzgf paramZzgf, zzr paramZzr)
  {
    return new zzlv(paramContext, paramZzav, paramZza, paramZzgf, paramZzr);
  }
  
  public zzqf<zzgo> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    for (paramJSONObject = paramJSONObject.getJSONObject(paramString);; paramJSONObject = paramJSONObject.optJSONObject(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return zza(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public List<zzqf<zzgo>> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws JSONException
  {
    if (paramBoolean1) {}
    ArrayList localArrayList;
    for (paramJSONObject = paramJSONObject.getJSONArray(paramString);; paramJSONObject = paramJSONObject.optJSONArray(paramString))
    {
      localArrayList = new ArrayList();
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
        break;
      }
      zza(0, paramBoolean1);
      return localArrayList;
    }
    if (paramBoolean3) {}
    for (int i = paramJSONObject.length();; i = 1)
    {
      int j = 0;
      while (j < i)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
        paramString = localJSONObject;
        if (localJSONObject == null) {
          paramString = new JSONObject();
        }
        localArrayList.add(zza(paramString, paramBoolean1, paramBoolean2));
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public Future<zzgo> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    throws JSONException
  {
    paramString = paramJSONObject.getJSONObject(paramString);
    boolean bool = paramString.optBoolean("require", true);
    paramJSONObject = paramString;
    if (paramString == null) {
      paramJSONObject = new JSONObject();
    }
    return zza(paramJSONObject, bool, paramBoolean);
  }
  
  public void zza(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      zzS(paramInt);
    }
  }
  
  public zzqf<zzqp> zzc(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    if (paramJSONObject == null) {
      return new zzqd(null);
    }
    if (TextUtils.isEmpty(paramJSONObject.optString("vast_xml")))
    {
      zzpe.zzbe("Required field 'vast_xml' is missing");
      return new zzqd(null);
    }
    return zza(mContext, zzGr, zzPo, zzsr, zzQc).zzf(paramJSONObject);
  }
  
  protected zza zzd(JSONObject paramJSONObject)
    throws ExecutionException, InterruptedException, JSONException, TimeoutException
  {
    if ((zziQ()) || (paramJSONObject == null)) {
      return null;
    }
    final String str = paramJSONObject.getString("template_id");
    boolean bool1;
    if (zzPo.zzSF.zzvx != null)
    {
      bool1 = zzPo.zzSF.zzvx.zzGD;
      if (zzPo.zzSF.zzvx == null) {
        break label102;
      }
    }
    label102:
    for (boolean bool2 = zzPo.zzSF.zzvx.zzGF;; bool2 = false)
    {
      if (!"2".equals(str)) {
        break label107;
      }
      return new zzlw(bool1, bool2);
      bool1 = false;
      break;
    }
    label107:
    if ("1".equals(str)) {
      return new zzlx(bool1, bool2);
    }
    if ("3".equals(str))
    {
      str = paramJSONObject.getString("custom_template_id");
      final zzqc localZzqc = new zzqc();
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          localZzqc.zzh((zzhm)zzlu.zzb(zzlu.this).zzcs().get(str));
        }
      });
      if (localZzqc.get(zzPS, TimeUnit.MILLISECONDS) != null) {
        return new zzly(bool1);
      }
      paramJSONObject = String.valueOf(paramJSONObject.getString("custom_template_id"));
      if (paramJSONObject.length() != 0)
      {
        paramJSONObject = "No handler for custom template: ".concat(paramJSONObject);
        zzpe.e(paramJSONObject);
      }
    }
    for (;;)
    {
      return null;
      paramJSONObject = new String("No handler for custom template: ");
      break;
      zzS(0);
    }
  }
  
  public zzqf<zzgm> zze(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attribution");
    if (localJSONObject == null) {
      return new zzqd(null);
    }
    final String str = localJSONObject.optString("text");
    final int j = localJSONObject.optInt("text_size", -1);
    final Integer localInteger1 = zzb(localJSONObject, "text_color");
    final Integer localInteger2 = zzb(localJSONObject, "bg_color");
    final int k = localJSONObject.optInt("animation_ms", 1000);
    final int m = localJSONObject.optInt("presentation_ms", 4000);
    final int i;
    if ((zzPo.zzSF.zzvx != null) && (zzPo.zzSF.zzvx.versionCode >= 2))
    {
      i = zzPo.zzSF.zzvx.zzGG;
      paramJSONObject = new ArrayList();
      if (localJSONObject.optJSONArray("images") == null) {
        break label200;
      }
      paramJSONObject = zza(localJSONObject, "images", false, false, true);
    }
    for (;;)
    {
      zzqe.zza(zzqe.zzo(paramJSONObject), new zzqe.zza()
      {
        public zzgm zzj(List<zzgo> paramAnonymousList)
        {
          if (paramAnonymousList != null) {
            for (;;)
            {
              try
              {
                if (paramAnonymousList.isEmpty()) {
                  break;
                }
                String str = str;
                List localList = zzlu.zzi(paramAnonymousList);
                Integer localInteger1 = localInteger2;
                Integer localInteger2 = localInteger1;
                if (j > 0)
                {
                  paramAnonymousList = Integer.valueOf(j);
                  paramAnonymousList = new zzgm(str, localList, localInteger1, localInteger2, paramAnonymousList, m + k, i);
                }
              }
              catch (RemoteException paramAnonymousList)
              {
                zzpe.zzb("Could not get attribution icon", paramAnonymousList);
                return null;
              }
              paramAnonymousList = null;
            }
          }
          paramAnonymousList = null;
          return paramAnonymousList;
        }
      });
      i = 1;
      break;
      label200:
      paramJSONObject.add(zza(localJSONObject, "image", false, false));
    }
  }
  
  public zzov zziP()
  {
    try
    {
      zzGp.zziF();
      Object localObject = zziR();
      JSONObject localJSONObject = zzaG((String)localObject);
      localObject = zza(zzd(localJSONObject), localJSONObject, (String)localObject);
      zza((zzgu.zza)localObject);
      localObject = zzb((zzgu.zza)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzc("Malformed native JSON response.", localJSONException);
      if (!zzQd) {
        zzS(0);
      }
      return zzb(null);
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzpe.zzc("Timeout when loading native ad.", localTimeoutException);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
  
  public boolean zziQ()
  {
    synchronized (zzrN)
    {
      boolean bool = zzQd;
      return bool;
    }
  }
  
  String zziR()
  {
    return UUID.randomUUID().toString();
  }
  
  public static abstract interface zza<T extends zzgu.zza>
  {
    public abstract T zza(zzlu paramZzlu, JSONObject paramJSONObject)
      throws JSONException, InterruptedException, ExecutionException;
  }
  
  class zzb
  {
    public zzhx zzQz;
    
    zzb() {}
  }
}
