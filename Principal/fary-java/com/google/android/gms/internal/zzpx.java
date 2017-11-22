package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.zzc;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

@zzmb
public class zzpx
{
  public static final Handler zzXU = new Handler(Looper.getMainLooper());
  private static final String zzXV = AdView.class.getName();
  private static final String zzXW = InterstitialAd.class.getName();
  private static final String zzXX = PublisherAdView.class.getName();
  private static final String zzXY = PublisherInterstitialAd.class.getName();
  private static final String zzXZ = SearchAdView.class.getName();
  private static final String zzYa = AdLoader.class.getName();
  
  public zzpx() {}
  
  private void zza(ViewGroup paramViewGroup, zzec paramZzec, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup.getChildCount() != 0) {
      return;
    }
    Context localContext = paramViewGroup.getContext();
    TextView localTextView = new TextView(localContext);
    localTextView.setGravity(17);
    localTextView.setText(paramString);
    localTextView.setTextColor(paramInt1);
    localTextView.setBackgroundColor(paramInt2);
    paramString = new FrameLayout(localContext);
    paramString.setBackgroundColor(paramInt1);
    paramInt1 = zzb(localContext, 3);
    paramString.addView(localTextView, new FrameLayout.LayoutParams(widthPixels - paramInt1, heightPixels - paramInt1, 17));
    paramViewGroup.addView(paramString, widthPixels, heightPixels);
  }
  
  public String zzO(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = Settings.Secure.getString(paramContext, "android_id"))
    {
      if ((paramContext == null) || (zzkI())) {
        paramContext = "emulator";
      }
      return zzbb(paramContext);
    }
  }
  
  public boolean zzP(Context paramContext)
  {
    return zzc.zzuz().isGooglePlayServicesAvailable(paramContext) == 0;
  }
  
  public boolean zzQ(Context paramContext)
  {
    if (getResourcesgetConfigurationorientation != 2) {}
    do
    {
      return false;
      paramContext = paramContext.getResources().getDisplayMetrics();
    } while ((int)(heightPixels / density) >= 600);
    return true;
  }
  
  @TargetApi(17)
  public boolean zzR(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j;
    int i;
    if (zzs.zzyD())
    {
      paramContext.getRealMetrics(localDisplayMetrics);
      j = heightPixels;
      i = widthPixels;
      paramContext.getMetrics(localDisplayMetrics);
      int k = heightPixels;
      int m = widthPixels;
      if ((k != j) || (m != i)) {
        break label141;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      label141:
      try
      {
        j = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        i = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public int zzS(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public int zza(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  @Nullable
  public String zza(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    int i = 0;
    if (i + 1 < paramArrayOfStackTraceElement.length)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      String str = localStackTraceElement.getClassName();
      if ((!"loadAd".equalsIgnoreCase(localStackTraceElement.getMethodName())) || ((!zzXV.equalsIgnoreCase(str)) && (!zzXW.equalsIgnoreCase(str)) && (!zzXX.equalsIgnoreCase(str)) && (!zzXY.equalsIgnoreCase(str)) && (!zzXZ.equalsIgnoreCase(str)) && (!zzYa.equalsIgnoreCase(str)))) {}
    }
    for (paramArrayOfStackTraceElement = paramArrayOfStackTraceElement[(i + 1)].getClassName();; paramArrayOfStackTraceElement = null)
    {
      if (paramString != null)
      {
        paramString = zzb(paramString, ".", 3);
        if ((paramArrayOfStackTraceElement != null) && (!paramArrayOfStackTraceElement.contains(paramString)))
        {
          return paramArrayOfStackTraceElement;
          i += 1;
          break;
        }
      }
      return null;
    }
  }
  
  public void zza(Context paramContext, @Nullable String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean, new zza()
    {
      public void zzu(final String paramAnonymousString)
      {
        new Thread()
        {
          public void run()
          {
            new zzpz().zzu(paramAnonymousString);
          }
        }.start();
      }
    });
  }
  
  public void zza(Context paramContext, @Nullable String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean, zza paramZza)
  {
    if (paramBoolean)
    {
      Context localContext = paramContext.getApplicationContext();
      Object localObject = localContext;
      if (localContext == null) {
        localObject = paramContext;
      }
      paramBundle.putString("os", Build.VERSION.RELEASE);
      paramBundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
      paramBundle.putString("appid", ((Context)localObject).getPackageName());
      localObject = paramString1;
      if (paramString1 == null)
      {
        int i = zzc.zzuz().zzak(paramContext);
        localObject = 23 + i + "." + 10084000;
      }
      paramBundle.putString("js", (String)localObject);
    }
    paramContext = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", paramString2);
    paramString1 = paramBundle.keySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramContext.appendQueryParameter(paramString2, paramBundle.getString(paramString2));
    }
    paramZza.zzu(paramContext.toString());
  }
  
  public void zza(ViewGroup paramViewGroup, zzec paramZzec, String paramString)
  {
    zza(paramViewGroup, paramZzec, paramString, -16777216, -1);
  }
  
  public void zza(ViewGroup paramViewGroup, zzec paramZzec, String paramString1, String paramString2)
  {
    zzpy.zzbe(paramString2);
    zza(paramViewGroup, paramZzec, paramString1, -65536, -16777216);
  }
  
  public void zza(boolean paramBoolean, HttpURLConnection paramHttpURLConnection, @Nullable String paramString)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    if (paramString != null) {
      paramHttpURLConnection.setRequestProperty("User-Agent", paramString);
    }
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public int zzb(Context paramContext, int paramInt)
  {
    return zza(paramContext.getResources().getDisplayMetrics(), paramInt);
  }
  
  public int zzb(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return Math.round(paramInt / density);
  }
  
  String zzb(String paramString1, String paramString2, int paramInt)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt - 1;
    paramString2 = paramString1;
    if (paramInt > 0)
    {
      paramString2 = paramString1;
      if (localStringTokenizer.hasMoreElements())
      {
        localStringBuilder.append(localStringTokenizer.nextToken());
        paramInt = i;
        while ((paramInt > 0) && (localStringTokenizer.hasMoreElements()))
        {
          localStringBuilder.append(".").append(localStringTokenizer.nextToken());
          paramInt -= 1;
        }
        paramString2 = localStringBuilder.toString();
      }
    }
    return paramString2;
  }
  
  public String zzbb(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
        return localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  public int zzc(Context paramContext, int paramInt)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    return zzb(localDisplayMetrics, paramInt);
  }
  
  public boolean zzkI()
  {
    return Build.DEVICE.startsWith("generic");
  }
  
  public boolean zzkJ()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static abstract interface zza
  {
    public abstract void zzu(String paramString);
  }
}
