package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzcq
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  protected final Object zzrN = new Object();
  private boolean zzui = false;
  private zzpt zzvK;
  private final Context zzvZ;
  private final WeakReference<zzov> zzwb;
  private WeakReference<ViewTreeObserver> zzwc;
  private final zzcx zzwd;
  protected final zzco zzwe;
  private final WindowManager zzwf;
  private final PowerManager zzwg;
  private final KeyguardManager zzwh;
  @Nullable
  private zzcr zzwi;
  private boolean zzwj;
  private boolean zzwk = false;
  private boolean zzwl;
  private boolean zzwm;
  private boolean zzwn;
  @Nullable
  BroadcastReceiver zzwo;
  private final HashSet<Object> zzwp = new HashSet();
  private final HashSet<zzcu> zzwq = new HashSet();
  
  public zzcq(Context paramContext, zzec paramZzec, zzov paramZzov, zzqa paramZzqa, zzcx paramZzcx)
  {
    zzwb = new WeakReference(paramZzov);
    zzwd = paramZzcx;
    zzwc = new WeakReference(null);
    zzwl = true;
    zzwn = false;
    zzvK = new zzpt(200L);
    zzwe = new zzco(UUID.randomUUID().toString(), paramZzqa, zzzk, zzVp, paramZzov.zzdz(), zzzn);
    zzwf = ((WindowManager)paramContext.getSystemService("window"));
    zzwg = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
    zzwh = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    zzvZ = paramContext;
  }
  
  protected void destroy()
  {
    synchronized (zzrN)
    {
      zzdH();
      zzdC();
      zzwl = false;
      zzdE();
      zzdJ();
      return;
    }
  }
  
  boolean isScreenOn()
  {
    return zzwg.isScreenOn();
  }
  
  public void onGlobalLayout()
  {
    zzk(2);
  }
  
  public void onScrollChanged()
  {
    zzk(1);
  }
  
  public void pause()
  {
    synchronized (zzrN)
    {
      zzui = true;
      zzk(3);
      return;
    }
  }
  
  public void resume()
  {
    synchronized (zzrN)
    {
      zzui = false;
      zzk(3);
      return;
    }
  }
  
  public void stop()
  {
    synchronized (zzrN)
    {
      zzwk = true;
      zzk(3);
      return;
    }
  }
  
  protected int zza(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = density;
    return (int)(paramInt / f);
  }
  
  JSONObject zza(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONArray.put(paramJSONObject);
    localJSONObject.put("units", localJSONArray);
    return localJSONObject;
  }
  
  protected void zza(View paramView, Map<String, String> paramMap)
  {
    zzk(3);
  }
  
  public void zza(zzcr paramZzcr)
  {
    synchronized (zzrN)
    {
      zzwi = paramZzcr;
      return;
    }
  }
  
  public void zza(zzcu paramZzcu)
  {
    if (zzwq.isEmpty())
    {
      zzdB();
      zzk(3);
    }
    zzwq.add(paramZzcu);
    try
    {
      paramZzcu.zzc(zza(zzd(zzwd.zzdO())), false);
      return;
    }
    catch (JSONException paramZzcu)
    {
      zzpe.zzb("Skipping measurement update for new client.", paramZzcu);
    }
  }
  
  void zza(zzcu paramZzcu, Map<String, String> paramMap)
  {
    paramMap = String.valueOf(zzwe.zzdy());
    if (paramMap.length() != 0) {}
    for (paramMap = "Received request to untrack: ".concat(paramMap);; paramMap = new String("Received request to untrack: "))
    {
      zzpe.zzbc(paramMap);
      zzb(paramZzcu);
      return;
    }
  }
  
  protected void zza(JSONObject paramJSONObject, boolean paramBoolean)
  {
    try
    {
      zzb(zza(paramJSONObject), paramBoolean);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      zzpe.zzb("Skipping active view message.", paramJSONObject);
    }
  }
  
  public void zzb(zzcu paramZzcu)
  {
    zzwq.remove(paramZzcu);
    paramZzcu.zzdS();
    if (zzwq.isEmpty()) {
      destroy();
    }
  }
  
  void zzb(zzqp paramZzqp, Map<String, String> paramMap)
  {
    zza(paramZzqp.getView(), paramMap);
  }
  
  protected void zzb(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Iterator localIterator = new ArrayList(zzwq).iterator();
    while (localIterator.hasNext()) {
      ((zzcu)localIterator.next()).zzc(paramJSONObject, paramBoolean);
    }
  }
  
  boolean zzb(@Nullable Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    paramMap = (String)paramMap.get("hashCode");
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(zzwe.zzdy()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void zzc(Map<String, String> paramMap)
  {
    if (!paramMap.containsKey("isVisible")) {
      return;
    }
    if (("1".equals(paramMap.get("isVisible"))) || ("true".equals(paramMap.get("isVisible")))) {}
    for (boolean bool = true;; bool = false)
    {
      zzj(bool);
      return;
    }
  }
  
  protected JSONObject zzd(@Nullable View paramView)
    throws JSONException
  {
    if (paramView == null) {
      return zzdL();
    }
    boolean bool1 = zzv.zzcL().isAttachedToWindow(paramView);
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    try
    {
      paramView.getLocationOnScreen((int[])localObject2);
      paramView.getLocationInWindow((int[])localObject1);
      localObject1 = paramView.getContext().getResources().getDisplayMetrics();
      Rect localRect1 = new Rect();
      left = localObject2[0];
      top = localObject2[1];
      right = (left + paramView.getWidth());
      bottom = (top + paramView.getHeight());
      localObject2 = new Rect();
      right = zzwf.getDefaultDisplay().getWidth();
      bottom = zzwf.getDefaultDisplay().getHeight();
      Rect localRect2 = new Rect();
      boolean bool2 = paramView.getGlobalVisibleRect(localRect2, null);
      Rect localRect3 = new Rect();
      boolean bool3 = paramView.getLocalVisibleRect(localRect3);
      Rect localRect4 = new Rect();
      paramView.getHitRect(localRect4);
      JSONObject localJSONObject = zzdI();
      localJSONObject.put("windowVisibility", paramView.getWindowVisibility()).put("isAttachedToWindow", bool1).put("viewBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("adBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("globalVisibleBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("globalVisibleBoxVisible", bool2).put("localVisibleBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("localVisibleBoxVisible", bool3).put("hitBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("screenDensity", density).put("isVisible", zzv.zzcJ().zza(paramView, zzwg, zzwh));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzpe.zzb("Failure getting view location.", localException);
      }
    }
  }
  
  protected void zzdB()
  {
    synchronized (zzrN)
    {
      if (zzwo != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      zzwo = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          zzk(3);
        }
      };
      zzvZ.registerReceiver(zzwo, localIntentFilter);
      return;
    }
  }
  
  protected void zzdC()
  {
    synchronized (zzrN)
    {
      BroadcastReceiver localBroadcastReceiver = zzwo;
      if (localBroadcastReceiver == null) {}
    }
    try
    {
      zzvZ.unregisterReceiver(zzwo);
      zzwo = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zzpe.zzb("Failed trying to unregister the receiver", localIllegalStateException);
      }
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzv.zzcN().zza(localException, "ActiveViewUnit.stopScreenStatusMonitoring");
      }
    }
  }
  
  public void zzdD()
  {
    synchronized (zzrN)
    {
      if (zzwl) {
        zzwm = true;
      }
    }
    try
    {
      zza(zzdM(), true);
      String str1 = String.valueOf(zzwe.zzdy());
      if (str1.length() != 0)
      {
        str1 = "Untracking ad unit: ".concat(str1);
        zzpe.zzbc(str1);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zzpe.zzb("JSON failure while processing active view data.", localJSONException);
      }
      localObject1 = finally;
      throw localObject1;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        zzpe.zzb("Failure while processing active view data.", localRuntimeException);
        continue;
        String str2 = new String("Untracking ad unit: ");
      }
    }
  }
  
  protected void zzdE()
  {
    if (zzwi != null) {
      zzwi.zza(this);
    }
  }
  
  public boolean zzdF()
  {
    synchronized (zzrN)
    {
      boolean bool = zzwl;
      return bool;
    }
  }
  
  protected void zzdG()
  {
    Object localObject = zzwd.zzdQ().zzdO();
    if (localObject == null) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = (ViewTreeObserver)zzwc.get();
      localObject = ((View)localObject).getViewTreeObserver();
    } while (localObject == localViewTreeObserver);
    zzdH();
    if ((!zzwj) || ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())))
    {
      zzwj = true;
      ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
    }
    zzwc = new WeakReference(localObject);
  }
  
  protected void zzdH()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)zzwc.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
      return;
    }
    localViewTreeObserver.removeOnScrollChangedListener(this);
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
  
  protected JSONObject zzdI()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", zzwe.zzdw()).put("activeViewJSON", zzwe.zzdx()).put("timestamp", zzv.zzcP().elapsedRealtime()).put("adFormat", zzwe.zzdv()).put("hashCode", zzwe.zzdy()).put("isMraid", zzwe.zzdz()).put("isStopped", zzwk).put("isPaused", zzui).put("isScreenOn", isScreenOn()).put("isNative", zzwe.zzdA()).put("appMuted", zzv.zzcJ().zzcq()).put("appVolume", zzv.zzcJ().zzco()).put("deviceVolume", zzv.zzcJ().zzH(zzvZ));
    return localJSONObject;
  }
  
  protected void zzdJ()
  {
    Iterator localIterator = new ArrayList(zzwq).iterator();
    while (localIterator.hasNext()) {
      zzb((zzcu)localIterator.next());
    }
  }
  
  protected boolean zzdK()
  {
    Iterator localIterator = zzwq.iterator();
    while (localIterator.hasNext()) {
      if (((zzcu)localIterator.next()).zzdR()) {
        return true;
      }
    }
    return false;
  }
  
  protected JSONObject zzdL()
    throws JSONException
  {
    return zzdI().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
  }
  
  protected JSONObject zzdM()
    throws JSONException
  {
    JSONObject localJSONObject = zzdI();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  public zzco zzdN()
  {
    return zzwe;
  }
  
  protected void zzj(boolean paramBoolean)
  {
    Iterator localIterator = zzwp.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  protected void zzk(int paramInt)
  {
    int i = 0;
    boolean bool;
    for (;;)
    {
      synchronized (zzrN)
      {
        if ((!zzdK()) || (!zzwl)) {
          return;
        }
        View localView1 = zzwd.zzdO();
        if ((localView1 != null) && (zzv.zzcJ().zza(localView1, zzwg, zzwh)) && (localView1.getGlobalVisibleRect(new Rect(), null)))
        {
          bool = true;
          if (!zzwd.zzdP()) {
            break;
          }
          zzdD();
          return;
        }
      }
      bool = false;
    }
    if (paramInt == 1) {
      i = 1;
    }
    if ((i != 0) && (!zzvK.tryAcquire()) && (bool == zzwn)) {
      return;
    }
    if ((!bool) && (!zzwn) && (paramInt == 1)) {
      return;
    }
    for (;;)
    {
      try
      {
        zza(zzd(localView2), false);
        zzwn = bool;
        zzdG();
        zzdE();
        return;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      zzpe.zza("Active view update failed.", localView2);
    }
  }
  
  public static class zza
    implements zzcx
  {
    private WeakReference<zzgu> zzws;
    
    public zza(zzgu paramZzgu)
    {
      zzws = new WeakReference(paramZzgu);
    }
    
    @Nullable
    public View zzdO()
    {
      zzgu localZzgu = (zzgu)zzws.get();
      if (localZzgu != null) {
        return localZzgu.zzfV();
      }
      return null;
    }
    
    public boolean zzdP()
    {
      return zzws.get() == null;
    }
    
    public zzcx zzdQ()
    {
      return new zzcq.zzb((zzgu)zzws.get());
    }
  }
  
  public static class zzb
    implements zzcx
  {
    private zzgu zzwt;
    
    public zzb(zzgu paramZzgu)
    {
      zzwt = paramZzgu;
    }
    
    public View zzdO()
    {
      if (zzwt != null) {
        return zzwt.zzfV();
      }
      return null;
    }
    
    public boolean zzdP()
    {
      return zzwt == null;
    }
    
    public zzcx zzdQ()
    {
      return this;
    }
  }
  
  public static class zzc
    implements zzcx
  {
    @Nullable
    private final View mView;
    @Nullable
    private final zzov zzwu;
    
    public zzc(View paramView, zzov paramZzov)
    {
      mView = paramView;
      zzwu = paramZzov;
    }
    
    public View zzdO()
    {
      return mView;
    }
    
    public boolean zzdP()
    {
      return (zzwu == null) || (mView == null);
    }
    
    public zzcx zzdQ()
    {
      return this;
    }
  }
  
  public static class zzd
    implements zzcx
  {
    private final WeakReference<View> zzwv;
    private final WeakReference<zzov> zzww;
    
    public zzd(View paramView, zzov paramZzov)
    {
      zzwv = new WeakReference(paramView);
      zzww = new WeakReference(paramZzov);
    }
    
    public View zzdO()
    {
      return (View)zzwv.get();
    }
    
    public boolean zzdP()
    {
      return (zzwv.get() == null) || (zzww.get() == null);
    }
    
    public zzcx zzdQ()
    {
      return new zzcq.zzc((View)zzwv.get(), (zzov)zzww.get());
    }
  }
}
