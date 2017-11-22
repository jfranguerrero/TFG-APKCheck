package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzmb
public class zzfz
{
  final Context mContext;
  String zzFb;
  BlockingQueue<zzgf> zzFd;
  ExecutorService zzFe;
  LinkedHashMap<String, String> zzFf = new LinkedHashMap();
  Map<String, zzgc> zzFg = new HashMap();
  private AtomicBoolean zzFh;
  private File zzFi;
  final String zzvU;
  
  public zzfz(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    mContext = paramContext;
    zzvU = paramString1;
    zzFb = paramString2;
    zzFh = new AtomicBoolean(false);
    zzFh.set(((Boolean)zzfx.zzBM.get()).booleanValue());
    if (zzFh.get())
    {
      paramContext = Environment.getExternalStorageDirectory();
      if (paramContext != null) {
        zzFi = new File(paramContext, "sdk_csi_data.txt");
      }
    }
    paramContext = paramMap.entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramString1 = (Map.Entry)paramContext.next();
      zzFf.put((String)paramString1.getKey(), (String)paramString1.getValue());
    }
    zzFd = new ArrayBlockingQueue(30);
    zzFe = Executors.newSingleThreadExecutor();
    zzFe.execute(new Runnable()
    {
      public void run()
      {
        zzfz.zza(zzfz.this);
      }
    });
    zzFg.put("action", zzgc.zzFl);
    zzFg.put("ad_format", zzgc.zzFl);
    zzFg.put("e", zzgc.zzFm);
  }
  
  private void zzb(Map<String, String> paramMap, String paramString)
  {
    paramMap = zza(zzFb, paramMap, paramString);
    if (zzFh.get())
    {
      zzc(zzFi, paramMap);
      return;
    }
    zzv.zzcJ().zzc(mContext, zzvU, paramMap);
  }
  
  /* Error */
  private void zzc(@Nullable File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +97 -> 98
    //   4: new 199	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: iconst_1
    //   10: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_1
    //   16: aload_3
    //   17: aload_2
    //   18: invokevirtual 206	java/lang/String:getBytes	()[B
    //   21: invokevirtual 210	java/io/FileOutputStream:write	([B)V
    //   24: aload_3
    //   25: astore_1
    //   26: aload_3
    //   27: bipush 10
    //   29: invokevirtual 212	java/io/FileOutputStream:write	(I)V
    //   32: aload_3
    //   33: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   36: return
    //   37: astore_1
    //   38: ldc -39
    //   40: aload_1
    //   41: invokestatic 222	com/google/android/gms/internal/zzpe:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: return
    //   45: astore 4
    //   47: aconst_null
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: ldc -32
    //   53: aload 4
    //   55: invokestatic 222	com/google/android/gms/internal/zzpe:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_2
    //   59: ifnull -23 -> 36
    //   62: aload_2
    //   63: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   66: return
    //   67: astore_1
    //   68: ldc -39
    //   70: aload_1
    //   71: invokestatic 222	com/google/android/gms/internal/zzpe:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: return
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   86: aload_2
    //   87: athrow
    //   88: astore_1
    //   89: ldc -39
    //   91: aload_1
    //   92: invokestatic 222	com/google/android/gms/internal/zzpe:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: goto -9 -> 86
    //   98: ldc -30
    //   100: invokestatic 230	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   103: return
    //   104: astore_2
    //   105: goto -27 -> 78
    //   108: astore 4
    //   110: aload_3
    //   111: astore_2
    //   112: goto -63 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	zzfz
    //   0	115	1	paramFile	File
    //   0	115	2	paramString	String
    //   13	98	3	localFileOutputStream	java.io.FileOutputStream
    //   45	9	4	localIOException1	java.io.IOException
    //   108	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	36	37	java/io/IOException
    //   4	14	45	java/io/IOException
    //   62	66	67	java/io/IOException
    //   4	14	75	finally
    //   82	86	88	java/io/IOException
    //   16	24	104	finally
    //   26	32	104	finally
    //   51	58	104	finally
    //   16	24	108	java/io/IOException
    //   26	32	108	java/io/IOException
  }
  
  private void zzfs()
  {
    try
    {
      for (;;)
      {
        zzgf localZzgf = (zzgf)zzFd.take();
        String str = localZzgf.zzfy();
        if (!TextUtils.isEmpty(str)) {
          zzb(zza(zzFf, localZzgf.zzfz()), str);
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzpe.zzc("CsiReporter:reporter interrupted", localInterruptedException);
    }
  }
  
  public zzgc zzV(String paramString)
  {
    paramString = (zzgc)zzFg.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return zzgc.zzFk;
  }
  
  String zza(String paramString1, Map<String, String> paramMap, @NonNull String paramString2)
  {
    paramString1 = Uri.parse(paramString1).buildUpon();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString1.appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramString1 = new StringBuilder(paramString1.build().toString());
    paramString1.append("&").append("it").append("=").append(paramString2);
    return paramString1.toString();
  }
  
  Map<String, String> zza(Map<String, String> paramMap1, @Nullable Map<String, String> paramMap2)
  {
    paramMap1 = new LinkedHashMap(paramMap1);
    if (paramMap2 == null) {
      return paramMap1;
    }
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Object localObject = (Map.Entry)paramMap2.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      String str2 = (String)paramMap1.get(str1);
      paramMap1.put(str1, zzV(str1).zzf(str2, (String)localObject));
    }
    return paramMap1;
  }
  
  public boolean zza(zzgf paramZzgf)
  {
    return zzFd.offer(paramZzgf);
  }
  
  public void zzc(@Nullable List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      zzFf.put("e", TextUtils.join(",", paramList));
    }
  }
}
