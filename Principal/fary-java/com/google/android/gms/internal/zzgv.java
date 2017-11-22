package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzgv
  implements zzgu
{
  private final Context mContext;
  private final zzr zzGl;
  @Nullable
  private final JSONObject zzGo;
  @Nullable
  private final zzlt zzGp;
  @Nullable
  private final zzgu.zza zzGq;
  private final zzav zzGr;
  boolean zzGs;
  private zzqp zzGt;
  private String zzGu;
  @Nullable
  private String zzGv;
  private WeakReference<View> zzGw = null;
  private final Object zzrN = new Object();
  @Nullable
  private final zzqa zztr;
  
  public zzgv(Context paramContext, zzr paramZzr, @Nullable zzlt paramZzlt, zzav paramZzav, @Nullable JSONObject paramJSONObject, @Nullable zzgu.zza paramZza, @Nullable zzqa paramZzqa, @Nullable String paramString)
  {
    mContext = paramContext;
    zzGl = paramZzr;
    zzGp = paramZzlt;
    zzGr = paramZzav;
    zzGo = paramJSONObject;
    zzGq = paramZza;
    zztr = paramZzqa;
    zzGv = paramString;
  }
  
  private JSONObject zza(Map<String, WeakReference<View>> paramMap, View paramView)
  {
    localJSONObject1 = new JSONObject();
    if ((paramMap == null) || (paramView == null)) {
      return localJSONObject1;
    }
    try
    {
      paramView = zzk(paramView);
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        View localView = (View)((WeakReference)localEntry.getValue()).get();
        if (localView != null)
        {
          int[] arrayOfInt = zzk(localView);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("width", zzB(zzl(localView)));
          localJSONObject2.put("height", zzB(zzm(localView)));
          localJSONObject2.put("x", zzB(arrayOfInt[0] - paramView[0]));
          localJSONObject2.put("y", zzB(arrayOfInt[1] - paramView[1]));
          localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
        }
      }
      return localJSONObject1;
    }
    catch (JSONException paramMap)
    {
      zzpe.zzbe("Unable to get all view rectangles");
    }
  }
  
  private JSONObject zzb(Rect paramRect)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("x", zzB(left));
    localJSONObject.put("y", zzB(top));
    localJSONObject.put("width", zzB(right - left));
    localJSONObject.put("height", zzB(bottom - top));
    localJSONObject.put("relative_to", "self");
    return localJSONObject;
  }
  
  private JSONObject zzb(Map<String, WeakReference<View>> paramMap, View paramView)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if ((paramMap == null) || (paramView == null)) {
      return localJSONObject1;
    }
    paramView = zzk(paramView);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      View localView = (View)((WeakReference)localEntry.getValue()).get();
      if (localView != null)
      {
        int[] arrayOfInt = zzk(localView);
        JSONObject localJSONObject2 = new JSONObject();
        paramMap = new JSONObject();
        for (;;)
        {
          try
          {
            paramMap.put("width", zzB(zzl(localView)));
            paramMap.put("height", zzB(zzm(localView)));
            paramMap.put("x", zzB(arrayOfInt[0] - paramView[0]));
            paramMap.put("y", zzB(arrayOfInt[1] - paramView[1]));
            paramMap.put("relative_to", "ad_view");
            localJSONObject2.put("frame", paramMap);
            paramMap = new Rect();
            if (!localView.getLocalVisibleRect(paramMap)) {
              break label309;
            }
            paramMap = zzb(paramMap);
            localJSONObject2.put("visible_bounds", paramMap);
            if ((localView instanceof TextView))
            {
              paramMap = (TextView)localView;
              localJSONObject2.put("text_color", paramMap.getCurrentTextColor());
              localJSONObject2.put("font_size", paramMap.getTextSize());
              localJSONObject2.put("text", paramMap.getText());
            }
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException paramMap)
          {
            zzpe.zzbe("Unable to get asset views information");
          }
          break;
          label309:
          paramMap = new JSONObject();
          paramMap.put("x", zzB(arrayOfInt[0] - paramView[0]));
          paramMap.put("y", zzB(arrayOfInt[1] - paramView[1]));
          paramMap.put("width", 0);
          paramMap.put("height", 0);
          paramMap.put("relative_to", "ad_view");
        }
      }
    }
    return localJSONObject1;
  }
  
  private JSONObject zzn(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramView == null) {
      return localJSONObject;
    }
    try
    {
      localJSONObject.put("width", zzB(zzl(paramView)));
      localJSONObject.put("height", zzB(zzm(paramView)));
      return localJSONObject;
    }
    catch (Exception paramView)
    {
      zzpe.zzbe("Unable to get native ad view bounding box");
    }
    return localJSONObject;
  }
  
  private JSONObject zzo(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramView == null) {
      return localJSONObject;
    }
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        arrayOfInt = zzk(paramView);
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("width", zzB(zzl(paramView)));
        ((JSONObject)localObject).put("height", zzB(zzm(paramView)));
        ((JSONObject)localObject).put("x", zzB(arrayOfInt[0]));
        ((JSONObject)localObject).put("y", zzB(arrayOfInt[1]));
        ((JSONObject)localObject).put("relative_to", "window");
        localJSONObject.put("frame", localObject);
        localObject = new Rect();
        if (paramView.getGlobalVisibleRect((Rect)localObject))
        {
          paramView = zzb((Rect)localObject);
          localJSONObject.put("visible_bounds", paramView);
          return localJSONObject;
        }
      }
      catch (Exception paramView)
      {
        zzpe.zzbe("Unable to get native ad view bounding box");
        return localJSONObject;
      }
      paramView = new JSONObject();
      paramView.put("x", zzB(arrayOfInt[0]));
      paramView.put("y", zzB(arrayOfInt[1]));
      paramView.put("width", 0);
      paramView.put("height", 0);
      paramView.put("relative_to", "window");
    }
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  int zzB(int paramInt)
  {
    return zzeh.zzeO().zzc(mContext, paramInt);
  }
  
  public zzgn zza(View.OnClickListener paramOnClickListener)
  {
    Object localObject = zzGq.zzfO();
    if (localObject == null) {
      return null;
    }
    localObject = new zzgn(mContext, (zzgm)localObject);
    ((zzgn)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((zzgn)localObject).zzfJ().setOnClickListener(paramOnClickListener);
    ((zzgn)localObject).zzfJ().setContentDescription((CharSequence)zzfx.zzEa.get());
    return localObject;
  }
  
  public void zza(View paramView, zzgs paramZzgs)
  {
    if (!(zzGq instanceof zzgp)) {}
    for (;;)
    {
      return;
      Object localObject = (zzgp)zzGq;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      if (((zzgp)localObject).zzfP() != null)
      {
        ((FrameLayout)paramView).addView(((zzgp)localObject).zzfP(), localLayoutParams);
        zzGl.zza(paramZzgs);
        return;
      }
      if ((((zzgp)localObject).getImages() != null) && (((zzgp)localObject).getImages().size() > 0))
      {
        paramZzgs = zze(((zzgp)localObject).getImages().get(0));
        if (paramZzgs != null) {
          try
          {
            paramZzgs = paramZzgs.zzfK();
            if (paramZzgs != null)
            {
              paramZzgs = (Drawable)zze.zzE(paramZzgs);
              localObject = zzfY();
              ((ImageView)localObject).setImageDrawable(paramZzgs);
              ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
              ((FrameLayout)paramView).addView((View)localObject, localLayoutParams);
              return;
            }
          }
          catch (RemoteException paramView)
          {
            zzpe.zzbe("Could not get drawable from image");
          }
        }
      }
    }
  }
  
  public void zza(View paramView1, String paramString, @Nullable JSONObject paramJSONObject, Map<String, WeakReference<View>> paramMap, View paramView2)
  {
    zzac.zzdn("performClick must be called on the main UI thread.");
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("asset", paramString);
        localJSONObject1.put("template", zzGq.zzfN());
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("ad", zzGo);
        localJSONObject2.put("click", localJSONObject1);
        if (zzGl.zzz(zzGq.getCustomTemplateId()) == null) {
          break label331;
        }
        bool = true;
        localJSONObject2.put("has_custom_click_handler", bool);
        if (((Boolean)zzfx.zzEc.get()).booleanValue())
        {
          if (((Boolean)zzfx.zzEd.get()).booleanValue())
          {
            localJSONObject2.put("asset_view_signal", zzb(paramMap, paramView2));
            localJSONObject2.put("ad_view_signal", zzo(paramView2));
          }
        }
        else if (paramJSONObject != null) {
          localJSONObject2.put("click_point", paramJSONObject);
        }
      }
      catch (JSONException paramView1)
      {
        JSONObject localJSONObject1;
        final JSONObject localJSONObject2;
        zzpe.zzb("Unable to create click JSON.", paramView1);
        return;
      }
      try
      {
        paramJSONObject = zzGo.optJSONObject("tracking_urls_and_actions");
        paramString = paramJSONObject;
        if (paramJSONObject == null) {
          paramString = new JSONObject();
        }
        paramString = paramString.optString("click_string");
        localJSONObject1.put("click_signals", zzGr.zzW().zza(mContext, paramString, paramView1));
      }
      catch (Exception paramView1)
      {
        zzpe.zzb("Exception obtaining click signals", paramView1);
        continue;
      }
      localJSONObject2.put("ads_id", zzGv);
      zzGp.zza(new zzlt.zza()
      {
        public void zze(zzjb paramAnonymousZzjb)
        {
          paramAnonymousZzjb.zza("google.afma.nativeAds.handleClickGmsg", localJSONObject2);
        }
      });
      return;
      localJSONObject2.put("view_rectangles", zza(paramMap, paramView2));
      localJSONObject2.put("native_view_rectangle", zzn(paramView2));
      continue;
      label331:
      boolean bool = false;
    }
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    if (!((Boolean)zzfx.zzDX.get()).booleanValue()) {}
    for (;;)
    {
      return;
      paramView.setOnTouchListener(paramOnTouchListener);
      paramView.setClickable(true);
      paramView.setOnClickListener(paramOnClickListener);
      if (paramMap != null)
      {
        paramView = paramMap.entrySet().iterator();
        while (paramView.hasNext())
        {
          paramMap = (View)((WeakReference)((Map.Entry)paramView.next()).getValue()).get();
          if (paramMap != null)
          {
            paramMap.setOnTouchListener(paramOnTouchListener);
            paramMap.setClickable(true);
            paramMap.setOnClickListener(paramOnClickListener);
          }
        }
      }
    }
  }
  
  public void zza(View paramView1, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject, View paramView2)
  {
    zzac.zzdn("performClick must be called on the main UI thread.");
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramView1.equals((View)((WeakReference)localEntry.getValue()).get())) {
          zza(paramView1, (String)localEntry.getKey(), paramJSONObject, paramMap, paramView2);
        }
      }
    }
    do
    {
      return;
      if ("2".equals(zzGq.zzfN()))
      {
        zza(paramView1, "2099", paramJSONObject, paramMap, paramView2);
        return;
      }
    } while (!"1".equals(zzGq.zzfN()));
    zza(paramView1, "1099", paramJSONObject, paramMap, paramView2);
  }
  
  public void zzb(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    zzac.zzdn("recordImpression must be called on the main UI thread.");
    zzq(true);
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("ad", zzGo);
        localJSONObject.put("ads_id", zzGv);
        if (((Boolean)zzfx.zzEc.get()).booleanValue())
        {
          if (!((Boolean)zzfx.zzEd.get()).booleanValue()) {
            continue;
          }
          localJSONObject.put("asset_view_signal", zzb(paramMap, paramView));
          localJSONObject.put("ad_view_signal", zzo(paramView));
        }
        zzGp.zza(new zzlt.zza()
        {
          public void zze(zzjb paramAnonymousZzjb)
          {
            paramAnonymousZzjb.zza("google.afma.nativeAds.handleImpressionPing", localJSONObject);
          }
        });
      }
      catch (JSONException paramView)
      {
        final JSONObject localJSONObject;
        zzpe.zzb("Unable to create impression JSON.", paramView);
        continue;
      }
      zzGl.zza(this);
      return;
      localJSONObject.put("view_rectangles", zza(paramMap, paramView));
      localJSONObject.put("native_view_rectangle", zzn(paramView));
    }
  }
  
  public void zzc(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    if (((Boolean)zzfx.zzDW.get()).booleanValue()) {}
    for (;;)
    {
      return;
      paramView.setOnTouchListener(null);
      paramView.setClickable(false);
      paramView.setOnClickListener(null);
      if (paramMap != null)
      {
        paramView = paramMap.entrySet().iterator();
        while (paramView.hasNext())
        {
          paramMap = (View)((WeakReference)((Map.Entry)paramView.next()).getValue()).get();
          if (paramMap != null)
          {
            paramMap.setOnTouchListener(null);
            paramMap.setClickable(false);
            paramMap.setOnClickListener(null);
          }
        }
      }
    }
  }
  
  public void zzd(MotionEvent paramMotionEvent)
  {
    zzGr.zza(paramMotionEvent);
  }
  
  public void zzd(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    synchronized (zzrN)
    {
      if (zzGs) {
        return;
      }
      if (!paramView.isShown()) {
        return;
      }
    }
    if (!paramView.getGlobalVisibleRect(new Rect(), null)) {
      return;
    }
    zzb(paramView, paramMap);
  }
  
  @Nullable
  zzgz zze(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzgz.zza.zzB((IBinder)paramObject);
    }
    return null;
  }
  
  public zzqp zzfU()
  {
    zzGt = zzfX();
    zzGt.getView().setVisibility(8);
    zzlt.zza local3 = new zzlt.zza()
    {
      public void zze(final zzjb paramAnonymousZzjb)
      {
        paramAnonymousZzjb.zza("/loadHtml", new zzhx()
        {
          public void zza(zzqp paramAnonymous2Zzqp, final Map<String, String> paramAnonymous2Map)
          {
            zzgv.zzb(zzgv.this).zzkV().zza(new zzqq.zza()
            {
              public void zza(zzqp paramAnonymous3Zzqp, boolean paramAnonymous3Boolean)
              {
                zzgv.zza(zzgv.this, (String)paramAnonymous2Map.get("id"));
                paramAnonymous3Zzqp = new JSONObject();
                try
                {
                  paramAnonymous3Zzqp.put("messageType", "htmlLoaded");
                  paramAnonymous3Zzqp.put("id", zzgv.zza(zzgv.this));
                  zzGz.zzb("sendMessageToNativeJs", paramAnonymous3Zzqp);
                  return;
                }
                catch (JSONException paramAnonymous3Zzqp)
                {
                  zzpe.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymous3Zzqp);
                }
              }
            });
            paramAnonymous2Zzqp = (String)paramAnonymous2Map.get("overlayHtml");
            paramAnonymous2Map = (String)paramAnonymous2Map.get("baseUrl");
            if (TextUtils.isEmpty(paramAnonymous2Map))
            {
              zzgv.zzb(zzgv.this).loadData(paramAnonymous2Zzqp, "text/html", "UTF-8");
              return;
            }
            zzgv.zzb(zzgv.this).loadDataWithBaseURL(paramAnonymous2Map, paramAnonymous2Zzqp, "text/html", "UTF-8", null);
          }
        });
        paramAnonymousZzjb.zza("/showOverlay", new zzhx()
        {
          public void zza(zzqp paramAnonymous2Zzqp, Map<String, String> paramAnonymous2Map)
          {
            zzgv.zzb(zzgv.this).getView().setVisibility(0);
          }
        });
        paramAnonymousZzjb.zza("/hideOverlay", new zzhx()
        {
          public void zza(zzqp paramAnonymous2Zzqp, Map<String, String> paramAnonymous2Map)
          {
            zzgv.zzb(zzgv.this).getView().setVisibility(8);
          }
        });
        zzgv.zzb(zzgv.this).zzkV().zza("/hideOverlay", new zzhx()
        {
          public void zza(zzqp paramAnonymous2Zzqp, Map<String, String> paramAnonymous2Map)
          {
            zzgv.zzb(zzgv.this).getView().setVisibility(8);
          }
        });
        zzgv.zzb(zzgv.this).zzkV().zza("/sendMessageToSdk", new zzhx()
        {
          public void zza(zzqp paramAnonymous2Zzqp, Map<String, String> paramAnonymous2Map)
          {
            paramAnonymous2Zzqp = new JSONObject();
            try
            {
              Iterator localIterator = paramAnonymous2Map.keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                paramAnonymous2Zzqp.put(str, paramAnonymous2Map.get(str));
              }
              paramAnonymous2Zzqp.put("id", zzgv.zza(zzgv.this));
            }
            catch (JSONException paramAnonymous2Zzqp)
            {
              zzpe.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymous2Zzqp);
              return;
            }
            paramAnonymousZzjb.zzb("sendMessageToNativeJs", paramAnonymous2Zzqp);
          }
        });
      }
    };
    zzGp.zza(local3);
    return zzGt;
  }
  
  public View zzfV()
  {
    if (zzGw != null) {
      return (View)zzGw.get();
    }
    return null;
  }
  
  public void zzfW()
  {
    if (!(zzGq instanceof zzgp)) {
      return;
    }
    zzGl.zzct();
  }
  
  zzqp zzfX()
  {
    return zzv.zzcK().zza(mContext, zzec.zzj(mContext), false, false, zzGr, zztr);
  }
  
  ImageView zzfY()
  {
    return new ImageView(mContext);
  }
  
  public void zzj(View paramView)
  {
    zzGw = new WeakReference(paramView);
  }
  
  int[] zzk(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt;
  }
  
  int zzl(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  int zzm(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected void zzq(boolean paramBoolean)
  {
    zzGs = paramBoolean;
  }
}
