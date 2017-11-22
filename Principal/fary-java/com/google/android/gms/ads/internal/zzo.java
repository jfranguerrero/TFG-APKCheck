package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzgz.zza;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqq.zza;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzo
{
  private static zzgp zza(zzjw paramZzjw)
    throws RemoteException
  {
    return new zzgp(paramZzjw.getHeadline(), paramZzjw.getImages(), paramZzjw.getBody(), paramZzjw.zzfL(), paramZzjw.getCallToAction(), paramZzjw.getStarRating(), paramZzjw.getStore(), paramZzjw.getPrice(), null, paramZzjw.getExtras(), null, null);
  }
  
  private static zzgq zza(zzjx paramZzjx)
    throws RemoteException
  {
    return new zzgq(paramZzjx.getHeadline(), paramZzjx.getImages(), paramZzjx.getBody(), paramZzjx.zzfQ(), paramZzjx.getCallToAction(), paramZzjx.getAdvertiser(), null, paramZzjx.getExtras());
  }
  
  static zzhx zza(@Nullable zzjw paramZzjw, @Nullable final zzjx paramZzjx, final zzf.zza paramZza)
  {
    new zzhx()
    {
      public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousZzqp.getView();
        if (paramAnonymousMap == null) {}
        do
        {
          return;
          try
          {
            if (zzo.this == null) {
              continue;
            }
            if (!getOverrideClickHandling())
            {
              zzk(zze.zzA(paramAnonymousMap));
              paramZza.onClick();
              return;
            }
          }
          catch (RemoteException paramAnonymousZzqp)
          {
            zzpe.zzc("Unable to call handleClick on mapper", paramAnonymousZzqp);
            return;
          }
          zzo.zzb(paramAnonymousZzqp);
          return;
        } while (paramZzjx == null);
        if (!paramZzjx.getOverrideClickHandling())
        {
          paramZzjx.zzk(zze.zzA(paramAnonymousMap));
          paramZza.onClick();
          return;
        }
        zzo.zzb(paramAnonymousZzqp);
      }
    };
  }
  
  static zzhx zza(CountDownLatch paramCountDownLatch)
  {
    new zzhx()
    {
      public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
      {
        countDown();
        paramAnonymousZzqp.getView().setVisibility(0);
      }
    };
  }
  
  private static String zza(@Nullable Bitmap paramBitmap)
  {
    Object localObject = new ByteArrayOutputStream();
    if (paramBitmap == null)
    {
      zzpe.zzbe("Bitmap is null. Returning empty string");
      return "";
    }
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
    localObject = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
    paramBitmap = String.valueOf("data:image/png;base64,");
    localObject = String.valueOf(localObject);
    if (((String)localObject).length() != 0) {
      return paramBitmap.concat((String)localObject);
    }
    return new String(paramBitmap);
  }
  
  static String zza(@Nullable zzgz paramZzgz)
  {
    if (paramZzgz == null)
    {
      zzpe.zzbe("Image is null. Returning empty string");
      return "";
    }
    try
    {
      Object localObject = paramZzgz.getUri();
      if (localObject != null)
      {
        localObject = ((Uri)localObject).toString();
        return localObject;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzbe("Unable to get image uri. Trying data uri next");
    }
    return zzb(paramZzgz);
  }
  
  private static JSONObject zza(@Nullable Bundle paramBundle, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle == null) || (TextUtils.isEmpty(paramString))) {
      return localJSONObject;
    }
    paramString = new JSONObject(paramString);
    Iterator localIterator = paramString.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramBundle.containsKey(str)) {
        if ("image".equals(paramString.getString(str)))
        {
          Object localObject = paramBundle.get(str);
          if ((localObject instanceof Bitmap)) {
            localJSONObject.put(str, zza((Bitmap)localObject));
          } else {
            zzpe.zzbe("Invalid type. An image type extra should return a bitmap");
          }
        }
        else if ((paramBundle.get(str) instanceof Bitmap))
        {
          zzpe.zzbe("Invalid asset type. Bitmap should be returned only for image type");
        }
        else
        {
          localJSONObject.put(str, String.valueOf(paramBundle.get(str)));
        }
      }
    }
    return localJSONObject;
  }
  
  public static void zza(@Nullable zzov paramZzov, zzf.zza paramZza)
  {
    zzjx localZzjx = null;
    zzqp localZzqp;
    if ((paramZzov != null) && (zzh(paramZzov)))
    {
      localZzqp = zzMZ;
      if (localZzqp == null) {
        break label43;
      }
    }
    label43:
    for (View localView = localZzqp.getView(); localView == null; localView = null)
    {
      zzpe.zzbe("AdWebView is null");
      return;
    }
    List localList;
    for (;;)
    {
      try
      {
        if (zzKA != null)
        {
          localList = zzKA.zzJU;
          if ((localList != null) && (!localList.isEmpty())) {
            break;
          }
          zzpe.zzbe("No template ids present in mediation response");
          return;
        }
      }
      catch (RemoteException paramZzov)
      {
        zzpe.zzc("Error occurred while recording impression and registering for clicks", paramZzov);
        return;
      }
      localList = null;
    }
    if (zzKB != null) {}
    for (zzjw localZzjw = zzKB.zzgJ();; localZzjw = null)
    {
      if (zzKB != null) {
        localZzjx = zzKB.zzgK();
      }
      if ((localList.contains("2")) && (localZzjw != null))
      {
        localZzjw.zzl(zze.zzA(localView));
        if (!localZzjw.getOverrideImpressionRecording()) {
          localZzjw.recordImpression();
        }
        localZzqp.zzkV().zza("/nativeExpressViewClicked", zza(localZzjw, null, paramZza));
        return;
      }
      if ((localList.contains("1")) && (localZzjx != null))
      {
        localZzjx.zzl(zze.zzA(localView));
        if (!localZzjx.getOverrideImpressionRecording()) {
          localZzjx.recordImpression();
        }
        localZzqp.zzkV().zza("/nativeExpressViewClicked", zza(null, localZzjx, paramZza));
        return;
      }
      zzpe.zzbe("No matching template id and mapper");
      return;
    }
  }
  
  private static void zza(zzqp paramZzqp)
  {
    View.OnClickListener localOnClickListener = paramZzqp.zzlk();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramZzqp.getView());
    }
  }
  
  private static void zza(final zzqp paramZzqp, zzgp paramZzgp, final String paramString)
  {
    paramZzqp.zzkV().zza(new zzqq.zza()
    {
      public void zza(zzqp paramAnonymousZzqp, boolean paramAnonymousBoolean)
      {
        try
        {
          paramAnonymousZzqp = new JSONObject();
          paramAnonymousZzqp.put("headline", getHeadline());
          paramAnonymousZzqp.put("body", getBody());
          paramAnonymousZzqp.put("call_to_action", getCallToAction());
          paramAnonymousZzqp.put("price", getPrice());
          paramAnonymousZzqp.put("star_rating", String.valueOf(getStarRating()));
          paramAnonymousZzqp.put("store", getStore());
          paramAnonymousZzqp.put("icon", zzo.zza(zzfL()));
          localObject1 = new JSONArray();
          Object localObject2 = getImages();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((JSONArray)localObject1).put(zzo.zza(zzo.zzf(((Iterator)localObject2).next())));
            }
          }
          paramAnonymousZzqp.put("images", localObject1);
        }
        catch (JSONException paramAnonymousZzqp)
        {
          zzpe.zzc("Exception occurred when loading assets", paramAnonymousZzqp);
          return;
        }
        paramAnonymousZzqp.put("extras", zzo.zzb(getExtras(), paramString));
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("assets", paramAnonymousZzqp);
        ((JSONObject)localObject1).put("template_id", "2");
        paramZzqp.zza("google.afma.nativeExpressAds.loadAssets", (JSONObject)localObject1);
      }
    });
  }
  
  private static void zza(final zzqp paramZzqp, zzgq paramZzgq, final String paramString)
  {
    paramZzqp.zzkV().zza(new zzqq.zza()
    {
      public void zza(zzqp paramAnonymousZzqp, boolean paramAnonymousBoolean)
      {
        try
        {
          paramAnonymousZzqp = new JSONObject();
          paramAnonymousZzqp.put("headline", getHeadline());
          paramAnonymousZzqp.put("body", getBody());
          paramAnonymousZzqp.put("call_to_action", getCallToAction());
          paramAnonymousZzqp.put("advertiser", getAdvertiser());
          paramAnonymousZzqp.put("logo", zzo.zza(zzfQ()));
          localObject1 = new JSONArray();
          Object localObject2 = getImages();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((JSONArray)localObject1).put(zzo.zza(zzo.zzf(((Iterator)localObject2).next())));
            }
          }
          paramAnonymousZzqp.put("images", localObject1);
        }
        catch (JSONException paramAnonymousZzqp)
        {
          zzpe.zzc("Exception occurred when loading assets", paramAnonymousZzqp);
          return;
        }
        paramAnonymousZzqp.put("extras", zzo.zzb(getExtras(), paramString));
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("assets", paramAnonymousZzqp);
        ((JSONObject)localObject1).put("template_id", "1");
        paramZzqp.zza("google.afma.nativeExpressAds.loadAssets", (JSONObject)localObject1);
      }
    });
  }
  
  private static void zza(zzqp paramZzqp, CountDownLatch paramCountDownLatch)
  {
    paramZzqp.zzkV().zza("/nativeExpressAssetsLoaded", zza(paramCountDownLatch));
    paramZzqp.zzkV().zza("/nativeExpressAssetsLoadingFailed", zzb(paramCountDownLatch));
  }
  
  public static boolean zza(zzqp paramZzqp, zzjn paramZzjn, CountDownLatch paramCountDownLatch)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = zzb(paramZzqp, paramZzjn, paramCountDownLatch);
      bool1 = bool2;
    }
    catch (RemoteException paramZzqp)
    {
      for (;;)
      {
        zzpe.zzc("Unable to invoke load assets", paramZzqp);
      }
    }
    catch (RuntimeException paramZzqp)
    {
      paramCountDownLatch.countDown();
      throw paramZzqp;
    }
    if (!bool1) {
      paramCountDownLatch.countDown();
    }
    return bool1;
  }
  
  static zzhx zzb(CountDownLatch paramCountDownLatch)
  {
    new zzhx()
    {
      public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
      {
        zzpe.zzbe("Adapter returned an ad, but assets substitution failed");
        countDown();
        paramAnonymousZzqp.destroy();
      }
    };
  }
  
  private static String zzb(zzgz paramZzgz)
  {
    try
    {
      paramZzgz = paramZzgz.zzfK();
      if (paramZzgz == null)
      {
        zzpe.zzbe("Drawable is null. Returning empty string");
        return "";
      }
      paramZzgz = (Drawable)zze.zzE(paramZzgz);
      if (!(paramZzgz instanceof BitmapDrawable))
      {
        zzpe.zzbe("Drawable is not an instance of BitmapDrawable. Returning empty string");
        return "";
      }
    }
    catch (RemoteException paramZzgz)
    {
      zzpe.zzbe("Unable to get drawable. Returning empty string");
      return "";
    }
    return zza(((BitmapDrawable)paramZzgz).getBitmap());
  }
  
  private static boolean zzb(zzqp paramZzqp, zzjn paramZzjn, CountDownLatch paramCountDownLatch)
    throws RemoteException
  {
    Object localObject = paramZzqp.getView();
    if (localObject == null)
    {
      zzpe.zzbe("AdWebView is null");
      return false;
    }
    ((View)localObject).setVisibility(4);
    localObject = zzKA.zzJU;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      zzpe.zzbe("No template ids present in mediation response");
      return false;
    }
    zza(paramZzqp, paramCountDownLatch);
    paramCountDownLatch = zzKB.zzgJ();
    zzjx localZzjx = zzKB.zzgK();
    if ((((List)localObject).contains("2")) && (paramCountDownLatch != null))
    {
      zza(paramZzqp, zza(paramCountDownLatch), zzKA.zzJT);
      paramCountDownLatch = zzKA.zzJR;
      paramZzjn = zzKA.zzJS;
      if (paramZzjn == null) {
        break label190;
      }
      paramZzqp.loadDataWithBaseURL(paramZzjn, paramCountDownLatch, "text/html", "UTF-8", null);
    }
    for (;;)
    {
      return true;
      if ((((List)localObject).contains("1")) && (localZzjx != null))
      {
        zza(paramZzqp, zza(localZzjx), zzKA.zzJT);
        break;
      }
      zzpe.zzbe("No matching template id and mapper");
      return false;
      label190:
      paramZzqp.loadData(paramCountDownLatch, "text/html", "UTF-8");
    }
  }
  
  @Nullable
  private static zzgz zze(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzgz.zza.zzB((IBinder)paramObject);
    }
    return null;
  }
  
  @Nullable
  public static View zzg(@Nullable zzov paramZzov)
  {
    if (paramZzov == null)
    {
      zzpe.e("AdState is null");
      return null;
    }
    if ((zzh(paramZzov)) && (zzMZ != null)) {
      return zzMZ.getView();
    }
    for (;;)
    {
      try
      {
        if (zzKB != null)
        {
          paramZzov = zzKB.getView();
          if (paramZzov == null)
          {
            zzpe.zzbe("View in mediation adapter is null.");
            return null;
          }
          paramZzov = (View)zze.zzE(paramZzov);
          return paramZzov;
        }
      }
      catch (RemoteException paramZzov)
      {
        zzpe.zzc("Could not get View from mediation adapter.", paramZzov);
        return null;
      }
      paramZzov = null;
    }
  }
  
  public static boolean zzh(@Nullable zzov paramZzov)
  {
    return (paramZzov != null) && (zzRK) && (zzKA != null) && (zzKA.zzJR != null);
  }
}
