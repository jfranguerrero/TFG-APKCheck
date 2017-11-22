package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzs;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
@TargetApi(14)
public class zzdb
  extends Thread
{
  private boolean mStarted = false;
  private boolean zzak = false;
  private final Object zzrN;
  private boolean zzxD = false;
  private final zzcz zzxE;
  private final zzma zzxF;
  private final int zzxG;
  private final int zzxH;
  private final int zzxI;
  private final int zzxJ;
  private final int zzxK;
  private final int zzxL;
  private final String zzxM;
  private final int zzxe;
  private final int zzxg;
  
  public zzdb(zzcz paramZzcz, zzma paramZzma)
  {
    zzxE = paramZzcz;
    zzxF = paramZzma;
    zzrN = new Object();
    zzxe = ((Integer)zzfx.zzBP.get()).intValue();
    zzxH = ((Integer)zzfx.zzBQ.get()).intValue();
    zzxg = ((Integer)zzfx.zzBR.get()).intValue();
    zzxI = ((Integer)zzfx.zzBS.get()).intValue();
    zzxJ = ((Integer)zzfx.zzBV.get()).intValue();
    zzxK = ((Integer)zzfx.zzBX.get()).intValue();
    zzxL = ((Integer)zzfx.zzBY.get()).intValue();
    zzxG = ((Integer)zzfx.zzBT.get()).intValue();
    zzxM = ((String)zzfx.zzCa.get());
    setName("ContentFetchTask");
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 136	com/google/android/gms/internal/zzdb:zzef	()Z
    //   4: ifeq +88 -> 92
    //   7: invokestatic 142	com/google/android/gms/ads/internal/zzv:zzcM	()Lcom/google/android/gms/internal/zzda;
    //   10: invokevirtual 148	com/google/android/gms/internal/zzda:getActivity	()Landroid/app/Activity;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +59 -> 74
    //   18: ldc -106
    //   20: invokestatic 155	com/google/android/gms/internal/zzpe:zzbc	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokevirtual 158	com/google/android/gms/internal/zzdb:zzeh	()V
    //   27: aload_0
    //   28: getfield 113	com/google/android/gms/internal/zzdb:zzxG	I
    //   31: sipush 1000
    //   34: imul
    //   35: i2l
    //   36: invokestatic 162	java/lang/Thread:sleep	(J)V
    //   39: aload_0
    //   40: getfield 58	com/google/android/gms/internal/zzdb:zzrN	Ljava/lang/Object;
    //   43: astore_2
    //   44: aload_2
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 47	com/google/android/gms/internal/zzdb:zzxD	Z
    //   50: istore_1
    //   51: iload_1
    //   52: ifeq +74 -> 126
    //   55: ldc -92
    //   57: invokestatic 155	com/google/android/gms/internal/zzpe:zzbc	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 58	com/google/android/gms/internal/zzdb:zzrN	Ljava/lang/Object;
    //   64: invokevirtual 167	java/lang/Object:wait	()V
    //   67: goto -21 -> 46
    //   70: astore_3
    //   71: goto -25 -> 46
    //   74: aload_0
    //   75: aload_2
    //   76: invokevirtual 170	com/google/android/gms/internal/zzdb:zza	(Landroid/app/Activity;)V
    //   79: goto -52 -> 27
    //   82: astore_2
    //   83: ldc -84
    //   85: aload_2
    //   86: invokestatic 176	com/google/android/gms/internal/zzpe:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: goto -50 -> 39
    //   92: ldc -78
    //   94: invokestatic 155	com/google/android/gms/internal/zzpe:zzbc	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: invokevirtual 158	com/google/android/gms/internal/zzdb:zzeh	()V
    //   101: goto -74 -> 27
    //   104: astore_2
    //   105: ldc -84
    //   107: aload_2
    //   108: invokestatic 176	com/google/android/gms/internal/zzpe:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: getfield 53	com/google/android/gms/internal/zzdb:zzxF	Lcom/google/android/gms/internal/zzma;
    //   115: aload_2
    //   116: ldc -76
    //   118: invokeinterface 185 3 0
    //   123: goto -84 -> 39
    //   126: aload_2
    //   127: monitorexit
    //   128: goto -128 -> 0
    //   131: astore_3
    //   132: aload_2
    //   133: monitorexit
    //   134: aload_3
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	zzdb
    //   50	2	1	bool	boolean
    //   82	4	2	localInterruptedException1	InterruptedException
    //   104	29	2	localThrowable	Throwable
    //   70	1	3	localInterruptedException2	InterruptedException
    //   131	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	67	70	java/lang/InterruptedException
    //   0	14	82	java/lang/InterruptedException
    //   18	27	82	java/lang/InterruptedException
    //   27	39	82	java/lang/InterruptedException
    //   74	79	82	java/lang/InterruptedException
    //   92	101	82	java/lang/InterruptedException
    //   0	14	104	java/lang/Throwable
    //   18	27	104	java/lang/Throwable
    //   27	39	104	java/lang/Throwable
    //   74	79	104	java/lang/Throwable
    //   92	101	104	java/lang/Throwable
    //   46	51	131	finally
    //   55	67	131	finally
    //   126	128	131	finally
    //   132	134	131	finally
  }
  
  public void wakeup()
  {
    synchronized (zzrN)
    {
      zzxD = false;
      zzrN.notifyAll();
      zzpe.zzbc("ContentFetchThread: wakeup");
      return;
    }
  }
  
  zza zza(@Nullable View paramView, zzcy paramZzcy)
  {
    int i = 0;
    if (paramView == null) {
      return new zza(0, 0);
    }
    Object localObject = zzv.zzcM().getContext();
    if (localObject != null)
    {
      localObject = (String)paramView.getTag(((Context)localObject).getResources().getIdentifier((String)zzfx.zzBZ.get(), "id", ((Context)localObject).getPackageName()));
      if ((!TextUtils.isEmpty(zzxM)) && (localObject != null) && (((String)localObject).equals(zzxM))) {
        return new zza(0, 0);
      }
    }
    boolean bool = paramView.getGlobalVisibleRect(new Rect());
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      localObject = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramZzcy.zzb(((CharSequence)localObject).toString(), bool, paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
        return new zza(1, 0);
      }
      return new zza(0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof zzqp)))
    {
      paramZzcy.zzea();
      if (zza((WebView)paramView, paramZzcy, bool)) {
        return new zza(0, 1);
      }
      return new zza(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (j < paramView.getChildCount())
      {
        localObject = zza(paramView.getChildAt(j), paramZzcy);
        k += zzxU;
        i += zzxV;
        j += 1;
      }
      return new zza(k, i);
    }
    return new zza(0, 0);
  }
  
  void zza(@Nullable Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        if (paramActivity.getWindow() != null)
        {
          localObject1 = localObject2;
          if (paramActivity.getWindow().getDecorView() != null) {
            localObject1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
          }
        }
      }
      catch (Throwable paramActivity)
      {
        for (;;)
        {
          zzpe.zzbc("Failed getting root view of activity. Content not extracted.");
          localObject1 = localObject2;
        }
      }
    } while (localObject1 == null);
    zzh((View)localObject1);
  }
  
  void zza(zzcy paramZzcy, WebView paramWebView, String paramString, boolean paramBoolean)
  {
    paramZzcy.zzdZ();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle())) {
          break label129;
        }
        String str = String.valueOf(paramWebView.getTitle());
        paramZzcy.zza(String.valueOf(str).length() + 1 + String.valueOf(paramString).length() + str + "\n" + paramString, paramBoolean, paramWebView.getX(), paramWebView.getY(), paramWebView.getWidth(), paramWebView.getHeight());
      }
      while (paramZzcy.zzdU())
      {
        zzxE.zzb(paramZzcy);
        return;
        label129:
        paramZzcy.zza(paramString, paramBoolean, paramWebView.getX(), paramWebView.getY(), paramWebView.getWidth(), paramWebView.getHeight());
      }
      return;
    }
    catch (JSONException paramZzcy)
    {
      zzpe.zzbc("Json string may be malformed.");
      return;
    }
    catch (Throwable paramZzcy)
    {
      zzpe.zza("Failed to get webview content.", paramZzcy);
      zzxF.zza(paramZzcy, "ContentFetchTask.processWebViewContent");
    }
  }
  
  boolean zza(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    return importance == 100;
  }
  
  @TargetApi(19)
  boolean zza(final WebView paramWebView, final zzcy paramZzcy, final boolean paramBoolean)
  {
    if (!zzs.zzyF()) {
      return false;
    }
    paramZzcy.zzea();
    paramWebView.post(new Runnable()
    {
      ValueCallback<String> zzxP = new ValueCallback()
      {
        public void zzE(String paramAnonymous2String)
        {
          zza(zzxQ, zzxR, paramAnonymous2String, zzxS);
        }
      };
      
      public void run()
      {
        if (paramWebView.getSettings().getJavaScriptEnabled()) {}
        try
        {
          paramWebView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzxP);
          return;
        }
        catch (Throwable localThrowable)
        {
          zzxP.onReceiveValue("");
        }
      }
    });
    return true;
  }
  
  public void zzee()
  {
    synchronized (zzrN)
    {
      if (mStarted)
      {
        zzpe.zzbc("Content hash thread already started, quiting...");
        return;
      }
      mStarted = true;
      start();
      return;
    }
  }
  
  boolean zzef()
  {
    try
    {
      Context localContext = zzv.zzcM().getContext();
      if (localContext == null) {
        return false;
      }
      Object localObject = (ActivityManager)localContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
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
            if ((zza(localRunningAppProcessInfo)) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzh(localContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  public zzcy zzeg()
  {
    return zzxE.zzed();
  }
  
  public void zzeh()
  {
    synchronized (zzrN)
    {
      zzxD = true;
      boolean bool = zzxD;
      zzpe.zzbc(42 + "ContentFetchThread: paused, mPause = " + bool);
      return;
    }
  }
  
  public boolean zzei()
  {
    return zzxD;
  }
  
  boolean zzh(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext == null) {
      return false;
    }
    return paramContext.isScreenOn();
  }
  
  boolean zzh(@Nullable final View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView.post(new Runnable()
    {
      public void run()
      {
        zzi(paramView);
      }
    });
    return true;
  }
  
  void zzi(View paramView)
  {
    try
    {
      zzcy localZzcy = new zzcy(zzxe, zzxH, zzxg, zzxI, zzxJ, zzxK, zzxL);
      paramView = zza(paramView, localZzcy);
      localZzcy.zzeb();
      if ((zzxU == 0) && (zzxV == 0)) {
        return;
      }
      if (((zzxV != 0) || (localZzcy.zzec() != 0)) && ((zzxV != 0) || (!zzxE.zza(localZzcy))))
      {
        zzxE.zzc(localZzcy);
        return;
      }
    }
    catch (Exception paramView)
    {
      zzpe.zzb("Exception in fetchContentOnUIThread", paramView);
      zzxF.zza(paramView, "ContentFetchTask.fetchContent");
    }
  }
  
  @zzmb
  class zza
  {
    final int zzxU;
    final int zzxV;
    
    zza(int paramInt1, int paramInt2)
    {
      zzxU = paramInt1;
      zzxV = paramInt2;
    }
  }
}
