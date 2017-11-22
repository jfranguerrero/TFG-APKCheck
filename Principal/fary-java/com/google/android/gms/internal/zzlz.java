package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;

@zzmb
public class zzlz
  implements zzma
{
  private static zzma zzQJ = null;
  private static final Object zztU = new Object();
  private final Object zzQK = new Object();
  private final String zzQL;
  private final WeakHashMap<Thread, Boolean> zzQM = new WeakHashMap();
  private final zzqa zztZ;
  
  zzlz(String paramString, zzqa paramZzqa)
  {
    zzQL = paramString;
    zztZ = paramZzqa;
    zziW();
    zziV();
  }
  
  public static zzma zzb(Context paramContext, zzqa paramZzqa)
  {
    for (;;)
    {
      synchronized (zztU)
      {
        String str;
        if (zzQJ == null)
        {
          if (((Boolean)zzfx.zzAW.get()).booleanValue()) {
            str = "unknown";
          }
        }
        else {
          try
          {
            paramContext = paramContext.getApplicationContext().getPackageName();
            zzQJ = new zzlz(paramContext, paramZzqa);
            return zzQJ;
          }
          catch (Throwable paramContext)
          {
            zzpe.zzbe("Cannot obtain package name, proceeding.");
            paramContext = str;
            continue;
          }
        }
      }
      zzQJ = new zzma.zza();
    }
  }
  
  private Throwable zzd(Throwable paramThrowable)
  {
    if (((Boolean)zzfx.zzAX.get()).booleanValue()) {
      return paramThrowable;
    }
    LinkedList localLinkedList = new LinkedList();
    while (paramThrowable != null)
    {
      localLinkedList.push(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    }
    paramThrowable = null;
    Throwable localThrowable;
    if (!localLinkedList.isEmpty())
    {
      localThrowable = (Throwable)localLinkedList.pop();
      StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new StackTraceElement(localThrowable.getClass().getName(), "<filtered>", "<filtered>", 1));
      int k = arrayOfStackTraceElement.length;
      int i = 0;
      int j = 0;
      if (i < k)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if (zzaH(localStackTraceElement.getClassName()))
        {
          localArrayList.add(localStackTraceElement);
          j = 1;
        }
        for (;;)
        {
          i += 1;
          break;
          if (zzaI(localStackTraceElement.getClassName())) {
            localArrayList.add(localStackTraceElement);
          } else {
            localArrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
          }
        }
      }
      if (j == 0) {
        break label261;
      }
      if (paramThrowable == null)
      {
        paramThrowable = new Throwable(localThrowable.getMessage());
        label223:
        paramThrowable.setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[0]));
      }
    }
    label261:
    for (;;)
    {
      break;
      paramThrowable = new Throwable(localThrowable.getMessage(), paramThrowable);
      break label223;
      return paramThrowable;
    }
  }
  
  private void zziV()
  {
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        try
        {
          zza(paramAnonymousThread, paramAnonymousThrowable);
          return;
        }
        catch (Throwable localThrowable)
        {
          zzpe.e("AdMob exception reporter failed reporting the exception.");
          return;
        }
        finally
        {
          if (zzQN != null) {
            zzQN.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        }
      }
    });
  }
  
  private void zziW()
  {
    zza(Looper.getMainLooper().getThread());
  }
  
  String zza(Class paramClass, Throwable paramThrowable, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", zzv.zzcJ().zzkm()).appendQueryParameter("js", zztZ.zzaZ).appendQueryParameter("appid", zzQL).appendQueryParameter("exceptiontype", paramClass.getName()).appendQueryParameter("stacktrace", localStringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzfx.zzfn())).appendQueryParameter("exceptionkey", paramString).appendQueryParameter("cl", "139965458").appendQueryParameter("rc", "dev").toString();
  }
  
  public void zza(Thread paramThread)
  {
    if (paramThread == null) {
      return;
    }
    synchronized (zzQK)
    {
      zzQM.put(paramThread, Boolean.valueOf(true));
      paramThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          try
          {
            zza(paramAnonymousThread, paramAnonymousThrowable);
            return;
          }
          catch (Throwable localThrowable)
          {
            zzpe.e("AdMob exception reporter failed reporting the exception.");
            return;
          }
          finally
          {
            if (zzQP != null) {
              zzQP.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
            }
          }
        }
      });
      return;
    }
  }
  
  protected void zza(Thread paramThread, Throwable paramThrowable)
  {
    if (zzb(paramThrowable)) {
      zzc(paramThrowable);
    }
  }
  
  public void zza(Throwable paramThrowable, String paramString)
  {
    Throwable localThrowable = zzd(paramThrowable);
    if (localThrowable == null) {
      return;
    }
    paramThrowable = paramThrowable.getClass();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(zza(paramThrowable, localThrowable, paramString));
    zzv.zzcJ().zza(localArrayList, zzv.zzcN().zzjQ());
  }
  
  protected boolean zzaH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.startsWith((String)zzfx.zzAY.get())) {
      return true;
    }
    try
    {
      boolean bool = Class.forName(paramString).isAnnotationPresent(zzmb.class);
      return bool;
    }
    catch (Exception localException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {}
    }
    for (paramString = "Fail to check class type for class ".concat(paramString);; paramString = new String("Fail to check class type for class "))
    {
      zzpe.zza(paramString, localException);
      return false;
    }
  }
  
  protected boolean zzaI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("android.")) && (!paramString.startsWith("java."))) {
      return false;
    }
    return true;
  }
  
  protected boolean zzb(Throwable paramThrowable)
  {
    boolean bool = true;
    if (paramThrowable == null) {
      return false;
    }
    int j = 0;
    int k = 0;
    while (paramThrowable != null)
    {
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      int m = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < m)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if (zzaH(localStackTraceElement.getClassName())) {
          k = 1;
        }
        if (getClass().getName().equals(localStackTraceElement.getClassName())) {
          j = 1;
        }
        i += 1;
      }
      paramThrowable = paramThrowable.getCause();
    }
    if ((k != 0) && (j == 0)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void zzc(Throwable paramThrowable)
  {
    zza(paramThrowable, "");
  }
}
