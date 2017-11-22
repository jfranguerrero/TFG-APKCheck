package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzs;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzpi
{
  public static final Handler zzWR = new zzpf(Looper.getMainLooper());
  private String zzHY;
  private zzja zzSV;
  private boolean zzWS = true;
  private boolean zzWT = false;
  private final Object zzrN = new Object();
  
  public zzpi() {}
  
  private JSONArray zza(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza(localJSONArray, paramCollection.next());
    }
    return localJSONArray;
  }
  
  private void zza(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(zzi((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(zzP((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(zza((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONArray.put(zza((Object[])paramObject));
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private void zza(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, zzi((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, zzP((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null) {}
      for (;;)
      {
        paramJSONObject.put(paramString, zza((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, zza(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }
  
  private boolean zza(KeyguardManager paramKeyguardManager)
  {
    if (paramKeyguardManager == null) {
      return false;
    }
    return paramKeyguardManager.inKeyguardRestrictedInputMode();
  }
  
  private boolean zza(PowerManager paramPowerManager)
  {
    return (paramPowerManager == null) || (paramPowerManager.isScreenOn());
  }
  
  public static void zzb(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzph.zza(paramRunnable);
  }
  
  private boolean zzh(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext == null) {
      return false;
    }
    return paramContext.isScreenOn();
  }
  
  private JSONObject zzi(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  private Bitmap zzq(@NonNull View paramView)
  {
    try
    {
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      if ((i == 0) || (j == 0))
      {
        zzpe.zzbe("Width or height of view is zero");
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
      Canvas localCanvas = new Canvas(localBitmap);
      paramView.layout(0, 0, i, j);
      paramView.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException paramView)
    {
      zzpe.zzb("Fail to capture the webview", paramView);
    }
    return null;
  }
  
  /* Error */
  private Bitmap zzr(@NonNull View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 235	android/view/View:isDrawingCacheEnabled	()Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 239	android/view/View:setDrawingCacheEnabled	(Z)V
    //   10: aload_1
    //   11: invokevirtual 243	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +30 -> 46
    //   19: aload_3
    //   20: invokestatic 246	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   23: astore_3
    //   24: aload_1
    //   25: iload_2
    //   26: invokevirtual 239	android/view/View:setDrawingCacheEnabled	(Z)V
    //   29: aload_3
    //   30: areturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_3
    //   34: ldc -8
    //   36: aload_1
    //   37: invokestatic 230	com/google/android/gms/internal/zzpe:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: aload_3
    //   41: areturn
    //   42: astore_1
    //   43: goto -9 -> 34
    //   46: aconst_null
    //   47: astore_3
    //   48: goto -24 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	zzpi
    //   0	51	1	paramView	View
    //   4	22	2	bool	boolean
    //   14	34	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	15	31	java/lang/RuntimeException
    //   19	24	31	java/lang/RuntimeException
    //   24	29	42	java/lang/RuntimeException
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzWR.post(paramRunnable);
  }
  
  protected String zzA(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public AlertDialog.Builder zzB(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }
  
  public zzfp zzC(Context paramContext)
  {
    return new zzfp(paramContext);
  }
  
  public String zzD(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = (ActivityManager.RunningTaskInfo)paramContext.get(0);
        if ((paramContext != null) && (topActivity != null))
        {
          paramContext = topActivity.getClassName();
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public boolean zzE(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      if ((localObject != null) && (localKeyguardManager != null))
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject == null) {
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (Process.myPid() == pid) {
            if ((importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzh(paramContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    return false;
  }
  
  public Bitmap zzF(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return null;
    }
    try
    {
      if (((Boolean)zzfx.zzDK.get()).booleanValue())
      {
        paramContext = ((Activity)paramContext).getWindow();
        if (paramContext != null) {
          return zzr(paramContext.getDecorView().getRootView());
        }
      }
      else
      {
        paramContext = zzq(((Activity)paramContext).getWindow().getDecorView());
      }
    }
    catch (RuntimeException paramContext)
    {
      zzpe.zzb("Fail to capture screen shot", paramContext);
      paramContext = null;
    }
    return paramContext;
  }
  
  public AudioManager zzG(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  public float zzH(Context paramContext)
  {
    paramContext = zzG(paramContext);
    if (paramContext == null) {}
    int i;
    int j;
    do
    {
      return 0.0F;
      i = paramContext.getStreamMaxVolume(3);
      j = paramContext.getStreamVolume(3);
    } while (i == 0);
    return j / i;
  }
  
  public int zzI(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return 0;
    }
    return targetSdkVersion;
  }
  
  public boolean zzJ(Context paramContext)
  {
    try
    {
      paramContext.getClassLoader().loadClass(ClientApi.class.getName());
      return false;
    }
    catch (ClassNotFoundException paramContext) {}
    return true;
  }
  
  public Bundle zzK(Context paramContext)
  {
    paramContext = zzv.zzcN().zzw(paramContext);
    if (paramContext == null) {
      return null;
    }
    return zza(paramContext);
  }
  
  public JSONObject zzP(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zza(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException paramMap)
    {
      paramMap = String.valueOf(paramMap.getMessage());
      if (paramMap.length() != 0) {}
      for (paramMap = "Could not convert map to JSON: ".concat(paramMap);; paramMap = new String("Could not convert map to JSON: ")) {
        throw new JSONException(paramMap);
      }
    }
  }
  
  public Bundle zza(zzdb paramZzdb)
  {
    if (paramZzdb == null) {}
    while (((!((Boolean)zzfx.zzBU.get()).booleanValue()) && (!((Boolean)zzfx.zzBW.get()).booleanValue())) || ((zzv.zzcN().zzjJ()) && (zzv.zzcN().zzjK()))) {
      return null;
    }
    if (paramZzdb.zzei()) {
      paramZzdb.wakeup();
    }
    paramZzdb = paramZzdb.zzeg();
    String str2;
    String str1;
    if (paramZzdb != null)
    {
      str2 = paramZzdb.zzdV();
      str1 = paramZzdb.zzdW();
      paramZzdb = paramZzdb.zzdX();
      if (str2 != null) {
        zzv.zzcN().zzaS(str2);
      }
      if (paramZzdb == null) {
        break label244;
      }
      zzv.zzcN().zzaT(paramZzdb);
    }
    label244:
    for (;;)
    {
      Bundle localBundle = new Bundle(1);
      if ((paramZzdb != null) && (((Boolean)zzfx.zzBW.get()).booleanValue()) && (!zzv.zzcN().zzjK())) {
        localBundle.putString("v_fp_vertical", paramZzdb);
      }
      if ((str2 != null) && (((Boolean)zzfx.zzBU.get()).booleanValue()) && (!zzv.zzcN().zzjJ()))
      {
        localBundle.putString("fingerprint", str2);
        if (!str2.equals(str1)) {
          localBundle.putString("v_fp", str1);
        }
      }
      if (localBundle.isEmpty()) {
        break;
      }
      return localBundle;
      str2 = zzv.zzcN().zzjR();
      paramZzdb = zzv.zzcN().zzjS();
      str1 = null;
    }
  }
  
  public DisplayMetrics zza(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public PopupWindow zza(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public String zza(Context paramContext, View paramView, zzec paramZzec)
  {
    if (!((Boolean)zzfx.zzCl.get()).booleanValue()) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("width", width);
      localJSONObject2.put("height", height);
      localJSONObject1.put("size", localJSONObject2);
      localJSONObject1.put("activity", zzD(paramContext));
      if (!zzzl)
      {
        paramZzec = new JSONArray();
        if (paramView != null)
        {
          paramContext = paramView.getParent();
          if (paramContext != null)
          {
            int i = -1;
            if ((paramContext instanceof ViewGroup)) {
              i = ((ViewGroup)paramContext).indexOfChild(paramView);
            }
            paramView = new JSONObject();
            paramView.put("type", paramContext.getClass().getName());
            paramView.put("index_of_child", i);
            paramZzec.put(paramView);
          }
          if ((paramContext == null) || (!(paramContext instanceof View))) {
            break label232;
          }
          paramContext = (View)paramContext;
          break label227;
        }
        if (paramZzec.length() > 0) {
          localJSONObject1.put("parents", paramZzec);
        }
      }
      paramContext = localJSONObject1.toString();
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      zzpe.zzc("Fail to get view hierarchy json", paramContext);
      return null;
    }
    for (;;)
    {
      label227:
      paramView = paramContext;
      break;
      label232:
      paramContext = null;
    }
  }
  
  public String zza(Context paramContext, zzav paramZzav, String paramString, View paramView)
  {
    if (paramZzav == null) {
      return paramString;
    }
    try
    {
      Uri localUri2 = Uri.parse(paramString);
      Uri localUri1 = localUri2;
      if (paramZzav.zzd(localUri2)) {
        localUri1 = paramZzav.zza(localUri2, paramContext, paramView);
      }
      paramContext = localUri1.toString();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return paramString;
  }
  
  public String zza(zzqp paramZzqp, String paramString)
  {
    return zza(paramZzqp.getContext(), paramZzqp.zzkX(), paramString, paramZzqp.getView());
  }
  
  public String zza(InputStreamReader paramInputStreamReader)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char['ࠀ'];
    for (;;)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  public Map<String, Integer> zza(View paramView, WindowManager paramWindowManager)
  {
    paramWindowManager = zza(paramWindowManager);
    int i = widthPixels;
    int j = heightPixels;
    paramWindowManager = new int[2];
    HashMap localHashMap = new HashMap();
    paramView.getLocationInWindow(paramWindowManager);
    localHashMap.put("xInPixels", Integer.valueOf(paramWindowManager[0]));
    localHashMap.put("yInPixels", Integer.valueOf(paramWindowManager[1]));
    localHashMap.put("windowWidthInPixels", Integer.valueOf(i));
    localHashMap.put("windowHeightInPixels", Integer.valueOf(j));
    return localHashMap;
  }
  
  JSONArray zza(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      zza(localJSONArray, paramArrayOfObject[i]);
      i += 1;
    }
    return localJSONArray;
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  @TargetApi(18)
  public void zza(Context paramContext, Uri paramUri)
  {
    try
    {
      Bundle localBundle = new Bundle();
      if ((((Boolean)zzfx.zzEP.get()).booleanValue()) && (zzs.zzyE())) {
        localBundle.putBinder("android.support.customtabs.extra.SESSION", null);
      }
      localBundle.putString("com.android.browser.application_id", paramContext.getPackageName());
      paramContext.startActivity(new Intent("android.intent.action.VIEW", paramUri).putExtras(localBundle));
      paramContext = String.valueOf(paramUri.toString());
      zzpe.zzbc(String.valueOf(paramContext).length() + 26 + "Opening " + paramContext + " in a new browser.");
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      zzpe.zzb("No browser is found.", paramContext);
    }
  }
  
  public void zza(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(zzh(paramContext, paramString));
  }
  
  public void zza(final Context paramContext, @Nullable final String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBundle.putString("device", zzv.zzcJ().zzkm());
      paramBundle.putString("eids", TextUtils.join(",", zzfx.zzfn()));
    }
    zzeh.zzeO().zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean, new zzpx.zza()
    {
      public void zzu(String paramAnonymousString)
      {
        zzv.zzcJ().zzc(paramContext, paramString1, paramAnonymousString);
      }
    });
  }
  
  public void zza(Context paramContext, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new zzps(paramContext, paramString, (String)paramList.next()).zziw();
    }
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    zza(paramContext, paramString, paramBoolean, paramHttpURLConnection, false);
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean1, HttpURLConnection paramHttpURLConnection, boolean paramBoolean2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean1);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", zzh(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(paramBoolean2);
  }
  
  public void zza(final Context paramContext, final List<String> paramList)
  {
    if (!(paramContext instanceof Activity)) {}
    while (TextUtils.isEmpty(zzbuz.zzcf((Activity)paramContext))) {
      return;
    }
    if (paramList == null)
    {
      zzpe.v("Cannot ping urls: empty list.");
      return;
    }
    if (!zzgl.zzn(paramContext))
    {
      zzpe.v("Cannot ping url because custom tabs is not supported");
      return;
    }
    final zzgl localZzgl = new zzgl();
    localZzgl.zza(new zzgl.zza()
    {
      public void zzfE()
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = String.valueOf(str);
          if (((String)localObject).length() != 0) {}
          for (localObject = "Pinging url: ".concat((String)localObject);; localObject = new String("Pinging url: "))
          {
            zzpe.zzbd((String)localObject);
            localObject = Uri.parse(str);
            localZzgl.mayLaunchUrl((Uri)localObject, null, null);
            break;
          }
        }
        localZzgl.zzd((Activity)paramContext);
      }
      
      public void zzfF() {}
    });
    localZzgl.zze((Activity)paramContext);
  }
  
  public void zza(List<String> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new zzps((String)paramList.next(), paramString).zziw();
    }
  }
  
  @TargetApi(24)
  public boolean zza(Activity paramActivity, Configuration paramConfiguration)
  {
    boolean bool2 = false;
    zzpx localZzpx = zzeh.zzeO();
    int j = localZzpx.zzb(paramActivity, screenHeightDp);
    int k = localZzpx.zzb(paramActivity, screenWidthDp);
    paramConfiguration = zza((WindowManager)paramActivity.getApplicationContext().getSystemService("window"));
    int m = heightPixels;
    int n = widthPixels;
    int i = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {}
    for (i = paramActivity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      int i1 = (int)Math.round(getResourcesgetDisplayMetricsdensity + 0.5D);
      i1 = ((Integer)zzfx.zzEX.get()).intValue() * i1;
      boolean bool1 = bool2;
      if (zzb(m, i + j, i1))
      {
        bool1 = bool2;
        if (zzb(n, k, i1)) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public boolean zza(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }
  
  public boolean zza(View paramView, Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = paramContext.getApplicationContext();
    if (localObject1 != null) {}
    for (localObject1 = (PowerManager)((Context)localObject1).getSystemService("power");; localObject1 = null)
    {
      Object localObject3 = paramContext.getSystemService("keyguard");
      paramContext = localObject2;
      if (localObject3 != null)
      {
        paramContext = localObject2;
        if ((localObject3 instanceof KeyguardManager)) {
          paramContext = (KeyguardManager)localObject3;
        }
      }
      return zza(paramView, (PowerManager)localObject1, paramContext);
    }
  }
  
  public boolean zza(View paramView, PowerManager paramPowerManager, KeyguardManager paramKeyguardManager)
  {
    if ((zzv.zzcJ().zzki()) || (!zza(paramKeyguardManager))) {}
    for (int i = 1; (paramView.getVisibility() == 0) && (paramView.isShown()) && (zza(paramPowerManager)) && (i != 0) && ((!((Boolean)zzfx.zzCM.get()).booleanValue()) || (paramView.getLocalVisibleRect(new Rect())) || (paramView.getGlobalVisibleRect(new Rect()))); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean zza(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable paramClassLoader) {}
    return false;
  }
  
  public String zzaV(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  public int zzaW(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString = String.valueOf(paramString);
      zzpe.zzbe(String.valueOf(paramString).length() + 22 + "Could not parse value:" + paramString);
    }
    return 0;
  }
  
  public boolean zzaX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }
  
  public String zzb(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramString.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { str }), String.format("$1%s$2", new Object[] { Uri.encode((String)paramMap.get(str)) }));
    }
    return paramString.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { "[^@]+" }), String.format("$1%s$2", new Object[] { "" })).replaceAll("@@", "@");
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zzb(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public void zzb(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (((Boolean)zzfx.zzCR.get()).booleanValue()) {
      zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
    }
  }
  
  boolean zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.abs(paramInt1 - paramInt2) <= paramInt3;
  }
  
  public void zzc(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    zza(paramContext, paramString1, localArrayList);
  }
  
  public float zzco()
  {
    zzp localZzp = zzv.zzdd().zzcn();
    if ((localZzp != null) && (localZzp.zzcp())) {
      return localZzp.zzco();
    }
    return 1.0F;
  }
  
  public boolean zzcq()
  {
    zzp localZzp = zzv.zzdd().zzcn();
    if (localZzp != null) {
      return localZzp.zzcq();
    }
    return false;
  }
  
  public zzja zzd(Context paramContext, zzqa paramZzqa)
  {
    synchronized (zzrN)
    {
      if (zzSV == null)
      {
        Context localContext = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localContext = paramContext.getApplicationContext();
        }
        zzSV = new zzja(localContext, paramZzqa, (String)zzfx.zzAR.get());
      }
      paramContext = zzSV;
      return paramContext;
    }
  }
  
  public void zzd(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.openFileOutput(paramString1, 0);
      paramContext.write(paramString2.getBytes("UTF-8"));
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      zzpe.zzb("Error writing to file in internal storage.", paramContext);
    }
  }
  
  public Map<String, String> zzg(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzv.zzcL().zzh(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramUri.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public String zzh(final Context paramContext, String paramString)
  {
    synchronized (zzrN)
    {
      if (zzHY != null)
      {
        paramContext = zzHY;
        return paramContext;
      }
      if (paramString == null)
      {
        paramContext = zzkj();
        return paramContext;
      }
    }
    try
    {
      zzHY = zzv.zzcL().getDefaultUserAgent(paramContext);
      if (TextUtils.isEmpty(zzHY)) {
        if (!zzeh.zzeO().zzkJ())
        {
          zzHY = null;
          zzWR.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzpi.zza(zzpi.this))
              {
                zzpi.zza(zzpi.this, zzA(paramContext));
                zzpi.zza(zzpi.this).notifyAll();
                return;
              }
            }
          });
          for (;;)
          {
            paramContext = zzHY;
            if (paramContext != null) {
              break label173;
            }
            try
            {
              zzrN.wait();
            }
            catch (InterruptedException paramContext)
            {
              zzHY = zzkj();
              paramContext = String.valueOf(zzHY);
              if (paramContext.length() == 0) {}
            }
          }
          for (paramContext = "Interrupted, use default user agent: ".concat(paramContext);; paramContext = new String("Interrupted, use default user agent: "))
          {
            zzpe.zzbe(paramContext);
            break;
          }
        }
      }
      try
      {
        zzHY = zzA(paramContext);
        label173:
        paramContext = String.valueOf(zzHY);
        zzHY = (String.valueOf(paramContext).length() + 11 + String.valueOf(paramString).length() + paramContext + " (Mobile; " + paramString + ")");
        paramContext = zzHY;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          zzHY = zzkj();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int[] zzh(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getWidth(), paramActivity.getHeight() };
      }
    }
    return zzkn();
  }
  
  public String zzi(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new String(zzo.zza(paramContext.openFileInput(paramString), true), "UTF-8");
      return paramContext;
    }
    catch (IOException paramContext)
    {
      zzpe.zzb("Error reading from internal storage.", paramContext);
    }
    return "";
  }
  
  public int[] zzi(Activity paramActivity)
  {
    int[] arrayOfInt = zzh(paramActivity);
    return new int[] { zzeh.zzeO().zzc(paramActivity, arrayOfInt[0]), zzeh.zzeO().zzc(paramActivity, arrayOfInt[1]) };
  }
  
  public int[] zzj(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getTop(), paramActivity.getBottom() };
      }
    }
    return zzkn();
  }
  
  public int[] zzk(Activity paramActivity)
  {
    int[] arrayOfInt = zzj(paramActivity);
    return new int[] { zzeh.zzeO().zzc(paramActivity, arrayOfInt[0]), zzeh.zzeO().zzc(paramActivity, arrayOfInt[1]) };
  }
  
  public boolean zzki()
  {
    return zzWS;
  }
  
  String zzkj()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null) {
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    }
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null) {
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
      }
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }
  
  public String zzkk()
  {
    return UUID.randomUUID().toString();
  }
  
  public String zzkl()
  {
    Object localObject1 = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(((UUID)localObject1).getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(((UUID)localObject1).getMostSignificantBits()).toByteArray();
    localObject1 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2)
    {
      try
      {
        Object localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(arrayOfByte1);
        ((MessageDigest)localObject2).update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(((MessageDigest)localObject2).digest(), 0, arrayOfByte3, 0, 8);
        localObject2 = new BigInteger(1, arrayOfByte3).toString();
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return localObject1;
  }
  
  public String zzkm()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return str2;
    }
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + " " + str2;
  }
  
  protected int[] zzkn()
  {
    return new int[] { 0, 0 };
  }
  
  public Bundle zzko()
  {
    Bundle localBundle = new Bundle();
    try
    {
      Object localObject;
      if (((Boolean)zzfx.zzBw.get()).booleanValue())
      {
        localObject = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
        localBundle.putParcelable("debug_memory_info", (Parcelable)localObject);
      }
      if (((Boolean)zzfx.zzBx.get()).booleanValue())
      {
        localObject = Runtime.getRuntime();
        localBundle.putLong("runtime_free_memory", ((Runtime)localObject).freeMemory());
        localBundle.putLong("runtime_max_memory", ((Runtime)localObject).maxMemory());
        localBundle.putLong("runtime_total_memory", ((Runtime)localObject).totalMemory());
      }
      return localBundle;
    }
    catch (Exception localException)
    {
      zzpe.zzc("Unable to gather memory stats", localException);
    }
    return localBundle;
  }
  
  public Bitmap zzp(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public int zzs(@Nullable View paramView)
  {
    if (paramView == null) {
      return -1;
    }
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (!(localViewParent instanceof AdapterView)); localViewParent = localViewParent.getParent()) {}
    if (localViewParent == null) {
      return -1;
    }
    return ((AdapterView)localViewParent).getPositionForView(paramView);
  }
  
  public boolean zzy(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((paramContext == null) || (activityInfo == null))
    {
      zzpe.zzbe("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((activityInfo.configChanges & 0x10) == 0) {
      zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    }
    for (boolean bool = false;; bool = true)
    {
      if ((activityInfo.configChanges & 0x20) == 0)
      {
        zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x80) == 0)
      {
        zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x100) == 0)
      {
        zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x200) == 0)
      {
        zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x400) == 0)
      {
        zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x800) == 0)
      {
        zzpe.zzbe(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
  }
  
  public boolean zzz(Context paramContext)
  {
    if (zzWT) {
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new zza(null), localIntentFilter);
    zzWT = true;
    return true;
  }
  
  private final class zza
    extends BroadcastReceiver
  {
    private zza() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        zzpi.zza(zzpi.this, true);
      }
      while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
        return;
      }
      zzpi.zza(zzpi.this, false);
    }
  }
}
