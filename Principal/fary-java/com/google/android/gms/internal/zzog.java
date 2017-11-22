package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@zzmb
public class zzog
  extends zzpd
  implements zzof
{
  private final Context mContext;
  private final zzov.zza zzPo;
  private final long zzUP;
  private final ArrayList<Future> zzVa = new ArrayList();
  private final ArrayList<String> zzVb = new ArrayList();
  private final HashMap<String, zzoa> zzVc = new HashMap();
  private final List<zzob> zzVd = new ArrayList();
  private final HashSet<String> zzVe = new HashSet();
  private final zznp zzVf;
  private final Object zzrN = new Object();
  
  public zzog(Context paramContext, zzov.zza paramZza, zznp paramZznp)
  {
    this(paramContext, paramZza, paramZznp, ((Long)zzfx.zzCs.get()).longValue());
  }
  
  zzog(Context paramContext, zzov.zza paramZza, zznp paramZznp, long paramLong)
  {
    mContext = paramContext;
    zzPo = paramZza;
    zzVf = paramZznp;
    zzUP = paramLong;
  }
  
  private static int zzR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 6;
    case 6: 
      return 0;
    case 3: 
      return 1;
    case 4: 
      return 2;
    case 7: 
      return 3;
    }
    return 4;
  }
  
  private zzov zza(int paramInt, @Nullable String paramString, @Nullable zzji paramZzji)
  {
    return new zzov(zzPo.zzSF.zzRd, null, zzPo.zzVB.zzJY, paramInt, zzPo.zzVB.zzJZ, zzPo.zzVB.zzRM, zzPo.zzVB.orientation, zzPo.zzVB.zzKe, zzPo.zzSF.zzRg, zzPo.zzVB.zzRK, paramZzji, null, paramString, zzPo.zzVr, null, zzPo.zzVB.zzRL, zzPo.zzvj, zzPo.zzVB.zzRJ, zzPo.zzVv, zzPo.zzVB.zzRO, zzPo.zzVB.zzRP, zzPo.zzVp, null, zzPo.zzVB.zzRZ, zzPo.zzVB.zzSa, zzPo.zzVB.zzSb, zzPo.zzVB.zzSc, zzPo.zzVB.zzSd, zzjv(), zzPo.zzVB.zzKb, zzPo.zzVB.zzSg);
  }
  
  private zzov zza(String paramString, zzji paramZzji)
  {
    return zza(-2, paramString, paramZzji);
  }
  
  private static String zza(zzob paramZzob)
  {
    String str = zzJJ;
    int i = zzR(errorCode);
    long l = zzKF;
    return String.valueOf(str).length() + 33 + str + "." + i + "." + l;
  }
  
  private void zza(String paramString1, String paramString2, zzji paramZzji)
  {
    synchronized (zzrN)
    {
      zzoh localZzoh = zzVf.zzaM(paramString1);
      if ((localZzoh == null) || (localZzoh.zzjx() == null) || (localZzoh.zzjw() == null))
      {
        zzVd.add(new zzob.zza().zzaP(zzJJ).zzaO(paramString1).zzl(0L).zzac(7).zzjt());
        return;
      }
      paramString2 = zza(paramString1, paramString2, paramZzji, localZzoh);
      zzVa.add((Future)paramString2.zziw());
      zzVb.add(paramString1);
      zzVc.put(paramString1, paramString2);
      return;
    }
  }
  
  private zzov zzju()
  {
    return zza(3, null, null);
  }
  
  private String zzjv()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (zzVd == null) {
      return localStringBuilder.toString();
    }
    Iterator localIterator = zzVd.iterator();
    while (localIterator.hasNext())
    {
      zzob localZzob = (zzob)localIterator.next();
      if ((localZzob != null) && (!TextUtils.isEmpty(zzJJ))) {
        localStringBuilder.append(String.valueOf(zza(localZzob)).concat("_"));
      }
    }
    return localStringBuilder.substring(0, Math.max(0, localStringBuilder.length() - 1));
  }
  
  public void onStop() {}
  
  protected zzoa zza(String paramString1, String paramString2, zzji paramZzji, zzoh paramZzoh)
  {
    return new zzoa(mContext, paramString1, paramString2, paramZzji, zzPo, paramZzoh, this, zzUP);
  }
  
  public void zza(String paramString, int paramInt) {}
  
  public void zzaN(String paramString)
  {
    synchronized (zzrN)
    {
      zzVe.add(paramString);
      return;
    }
  }
  
  /* Error */
  public void zzcm()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/google/android/gms/internal/zzog:zzPo	Lcom/google/android/gms/internal/zzov$zza;
    //   4: getfield 148	com/google/android/gms/internal/zzov$zza:zzVr	Lcom/google/android/gms/internal/zzjj;
    //   7: getfield 376	com/google/android/gms/internal/zzjj:zzJW	Ljava/util/List;
    //   10: invokeinterface 321 1 0
    //   15: astore 4
    //   17: aload 4
    //   19: invokeinterface 327 1 0
    //   24: ifeq +116 -> 140
    //   27: aload 4
    //   29: invokeinterface 330 1 0
    //   34: checkcast 271	com/google/android/gms/internal/zzji
    //   37: astore 5
    //   39: aload 5
    //   41: getfield 379	com/google/android/gms/internal/zzji:zzJO	Ljava/lang/String;
    //   44: astore 6
    //   46: aload 5
    //   48: getfield 382	com/google/android/gms/internal/zzji:zzJI	Ljava/util/List;
    //   51: invokeinterface 321 1 0
    //   56: astore 7
    //   58: aload 7
    //   60: invokeinterface 327 1 0
    //   65: ifeq -48 -> 17
    //   68: aload 7
    //   70: invokeinterface 330 1 0
    //   75: checkcast 223	java/lang/String
    //   78: astore_3
    //   79: ldc_w 384
    //   82: aload_3
    //   83: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne +15 -> 101
    //   89: aload_3
    //   90: astore_2
    //   91: ldc_w 389
    //   94: aload_3
    //   95: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   98: ifeq +19 -> 117
    //   101: new 391	org/json/JSONObject
    //   104: dup
    //   105: aload 6
    //   107: invokespecial 392	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: ldc_w 394
    //   113: invokevirtual 397	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_2
    //   117: aload_0
    //   118: aload_2
    //   119: aload 6
    //   121: aload 5
    //   123: invokespecial 399	com/google/android/gms/internal/zzog:zza	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzji;)V
    //   126: goto -68 -> 58
    //   129: astore_2
    //   130: ldc_w 401
    //   133: aload_2
    //   134: invokestatic 407	com/google/android/gms/internal/zzpe:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -79 -> 58
    //   140: iconst_0
    //   141: istore_1
    //   142: iload_1
    //   143: aload_0
    //   144: getfield 67	com/google/android/gms/internal/zzog:zzVa	Ljava/util/ArrayList;
    //   147: invokevirtual 410	java/util/ArrayList:size	()I
    //   150: if_icmpge +241 -> 391
    //   153: aload_0
    //   154: getfield 67	com/google/android/gms/internal/zzog:zzVa	Ljava/util/ArrayList;
    //   157: iload_1
    //   158: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   161: checkcast 305	java/util/concurrent/Future
    //   164: invokeinterface 414 1 0
    //   169: pop
    //   170: aload_0
    //   171: getfield 86	com/google/android/gms/internal/zzog:zzrN	Ljava/lang/Object;
    //   174: astore_2
    //   175: aload_2
    //   176: monitorenter
    //   177: aload_0
    //   178: getfield 69	com/google/android/gms/internal/zzog:zzVb	Ljava/util/ArrayList;
    //   181: iload_1
    //   182: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   185: checkcast 223	java/lang/String
    //   188: astore_3
    //   189: aload_3
    //   190: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifne +33 -> 226
    //   196: aload_0
    //   197: getfield 74	com/google/android/gms/internal/zzog:zzVc	Ljava/util/HashMap;
    //   200: aload_3
    //   201: invokevirtual 417	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   204: checkcast 358	com/google/android/gms/internal/zzoa
    //   207: astore_3
    //   208: aload_3
    //   209: ifnull +17 -> 226
    //   212: aload_0
    //   213: getfield 76	com/google/android/gms/internal/zzog:zzVd	Ljava/util/List;
    //   216: aload_3
    //   217: invokevirtual 420	com/google/android/gms/internal/zzoa:zzjq	()Lcom/google/android/gms/internal/zzob;
    //   220: invokeinterface 297 2 0
    //   225: pop
    //   226: aload_2
    //   227: monitorexit
    //   228: aload_0
    //   229: getfield 86	com/google/android/gms/internal/zzog:zzrN	Ljava/lang/Object;
    //   232: astore_3
    //   233: aload_3
    //   234: monitorenter
    //   235: aload_0
    //   236: getfield 81	com/google/android/gms/internal/zzog:zzVe	Ljava/util/HashSet;
    //   239: aload_0
    //   240: getfield 69	com/google/android/gms/internal/zzog:zzVb	Ljava/util/ArrayList;
    //   243: iload_1
    //   244: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   247: invokevirtual 423	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   250: ifeq +319 -> 569
    //   253: aload_0
    //   254: getfield 69	com/google/android/gms/internal/zzog:zzVb	Ljava/util/ArrayList;
    //   257: iload_1
    //   258: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   261: checkcast 223	java/lang/String
    //   264: astore 4
    //   266: aload_0
    //   267: getfield 74	com/google/android/gms/internal/zzog:zzVc	Ljava/util/HashMap;
    //   270: aload 4
    //   272: invokevirtual 417	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: ifnull +289 -> 564
    //   278: aload_0
    //   279: getfield 74	com/google/android/gms/internal/zzog:zzVc	Ljava/util/HashMap;
    //   282: aload 4
    //   284: invokevirtual 417	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   287: checkcast 358	com/google/android/gms/internal/zzoa
    //   290: invokevirtual 427	com/google/android/gms/internal/zzoa:zzjr	()Lcom/google/android/gms/internal/zzji;
    //   293: astore_2
    //   294: aload_0
    //   295: aload 4
    //   297: aload_2
    //   298: invokespecial 429	com/google/android/gms/internal/zzog:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzji;)Lcom/google/android/gms/internal/zzov;
    //   301: astore_2
    //   302: getstatic 435	com/google/android/gms/internal/zzpx:zzXU	Landroid/os/Handler;
    //   305: new 8	com/google/android/gms/internal/zzog$1
    //   308: dup
    //   309: aload_0
    //   310: aload_2
    //   311: invokespecial 438	com/google/android/gms/internal/zzog$1:<init>	(Lcom/google/android/gms/internal/zzog;Lcom/google/android/gms/internal/zzov;)V
    //   314: invokevirtual 444	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   317: pop
    //   318: aload_3
    //   319: monitorexit
    //   320: return
    //   321: astore_3
    //   322: aload_2
    //   323: monitorexit
    //   324: aload_3
    //   325: athrow
    //   326: astore_2
    //   327: invokestatic 450	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   330: invokevirtual 453	java/lang/Thread:interrupt	()V
    //   333: aload_0
    //   334: getfield 86	com/google/android/gms/internal/zzog:zzrN	Ljava/lang/Object;
    //   337: astore_2
    //   338: aload_2
    //   339: monitorenter
    //   340: aload_0
    //   341: getfield 69	com/google/android/gms/internal/zzog:zzVb	Ljava/util/ArrayList;
    //   344: iload_1
    //   345: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   348: checkcast 223	java/lang/String
    //   351: astore_3
    //   352: aload_3
    //   353: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +33 -> 389
    //   359: aload_0
    //   360: getfield 74	com/google/android/gms/internal/zzog:zzVc	Ljava/util/HashMap;
    //   363: aload_3
    //   364: invokevirtual 417	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 358	com/google/android/gms/internal/zzoa
    //   370: astore_3
    //   371: aload_3
    //   372: ifnull +17 -> 389
    //   375: aload_0
    //   376: getfield 76	com/google/android/gms/internal/zzog:zzVd	Ljava/util/List;
    //   379: aload_3
    //   380: invokevirtual 420	com/google/android/gms/internal/zzoa:zzjq	()Lcom/google/android/gms/internal/zzob;
    //   383: invokeinterface 297 2 0
    //   388: pop
    //   389: aload_2
    //   390: monitorexit
    //   391: aload_0
    //   392: invokespecial 455	com/google/android/gms/internal/zzog:zzju	()Lcom/google/android/gms/internal/zzov;
    //   395: astore_2
    //   396: getstatic 435	com/google/android/gms/internal/zzpx:zzXU	Landroid/os/Handler;
    //   399: new 10	com/google/android/gms/internal/zzog$2
    //   402: dup
    //   403: aload_0
    //   404: aload_2
    //   405: invokespecial 456	com/google/android/gms/internal/zzog$2:<init>	(Lcom/google/android/gms/internal/zzog;Lcom/google/android/gms/internal/zzov;)V
    //   408: invokevirtual 444	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   411: pop
    //   412: return
    //   413: astore_3
    //   414: aload_2
    //   415: monitorexit
    //   416: aload_3
    //   417: athrow
    //   418: astore_2
    //   419: ldc_w 458
    //   422: aload_2
    //   423: invokestatic 461	com/google/android/gms/internal/zzpe:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   426: aload_0
    //   427: getfield 86	com/google/android/gms/internal/zzog:zzrN	Ljava/lang/Object;
    //   430: astore_2
    //   431: aload_2
    //   432: monitorenter
    //   433: aload_0
    //   434: getfield 69	com/google/android/gms/internal/zzog:zzVb	Ljava/util/ArrayList;
    //   437: iload_1
    //   438: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   441: checkcast 223	java/lang/String
    //   444: astore_3
    //   445: aload_3
    //   446: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +33 -> 482
    //   452: aload_0
    //   453: getfield 74	com/google/android/gms/internal/zzog:zzVc	Ljava/util/HashMap;
    //   456: aload_3
    //   457: invokevirtual 417	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   460: checkcast 358	com/google/android/gms/internal/zzoa
    //   463: astore_3
    //   464: aload_3
    //   465: ifnull +17 -> 482
    //   468: aload_0
    //   469: getfield 76	com/google/android/gms/internal/zzog:zzVd	Ljava/util/List;
    //   472: aload_3
    //   473: invokevirtual 420	com/google/android/gms/internal/zzoa:zzjq	()Lcom/google/android/gms/internal/zzob;
    //   476: invokeinterface 297 2 0
    //   481: pop
    //   482: aload_2
    //   483: monitorexit
    //   484: goto +95 -> 579
    //   487: astore_3
    //   488: aload_2
    //   489: monitorexit
    //   490: aload_3
    //   491: athrow
    //   492: astore_3
    //   493: aload_0
    //   494: getfield 86	com/google/android/gms/internal/zzog:zzrN	Ljava/lang/Object;
    //   497: astore_2
    //   498: aload_2
    //   499: monitorenter
    //   500: aload_0
    //   501: getfield 69	com/google/android/gms/internal/zzog:zzVb	Ljava/util/ArrayList;
    //   504: iload_1
    //   505: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   508: checkcast 223	java/lang/String
    //   511: astore 4
    //   513: aload 4
    //   515: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   518: ifne +37 -> 555
    //   521: aload_0
    //   522: getfield 74	com/google/android/gms/internal/zzog:zzVc	Ljava/util/HashMap;
    //   525: aload 4
    //   527: invokevirtual 417	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   530: checkcast 358	com/google/android/gms/internal/zzoa
    //   533: astore 4
    //   535: aload 4
    //   537: ifnull +18 -> 555
    //   540: aload_0
    //   541: getfield 76	com/google/android/gms/internal/zzog:zzVd	Ljava/util/List;
    //   544: aload 4
    //   546: invokevirtual 420	com/google/android/gms/internal/zzoa:zzjq	()Lcom/google/android/gms/internal/zzob;
    //   549: invokeinterface 297 2 0
    //   554: pop
    //   555: aload_2
    //   556: monitorexit
    //   557: aload_3
    //   558: athrow
    //   559: astore_3
    //   560: aload_2
    //   561: monitorexit
    //   562: aload_3
    //   563: athrow
    //   564: aconst_null
    //   565: astore_2
    //   566: goto -272 -> 294
    //   569: aload_3
    //   570: monitorexit
    //   571: goto +8 -> 579
    //   574: astore_2
    //   575: aload_3
    //   576: monitorexit
    //   577: aload_2
    //   578: athrow
    //   579: iload_1
    //   580: iconst_1
    //   581: iadd
    //   582: istore_1
    //   583: goto -441 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	zzog
    //   141	442	1	i	int
    //   90	29	2	localObject1	Object
    //   129	5	2	localJSONException	org.json.JSONException
    //   326	1	2	localInterruptedException	InterruptedException
    //   418	5	2	localException	Exception
    //   574	4	2	localObject5	Object
    //   321	4	3	localObject7	Object
    //   351	29	3	localObject8	Object
    //   413	4	3	localObject9	Object
    //   444	29	3	localObject10	Object
    //   487	4	3	localObject11	Object
    //   492	66	3	localObject12	Object
    //   559	17	3	localObject13	Object
    //   15	530	4	localObject14	Object
    //   37	85	5	localZzji	zzji
    //   44	76	6	str	String
    //   56	13	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   101	117	129	org/json/JSONException
    //   177	208	321	finally
    //   212	226	321	finally
    //   226	228	321	finally
    //   322	324	321	finally
    //   153	170	326	java/lang/InterruptedException
    //   340	371	413	finally
    //   375	389	413	finally
    //   389	391	413	finally
    //   414	416	413	finally
    //   153	170	418	java/lang/Exception
    //   433	464	487	finally
    //   468	482	487	finally
    //   482	484	487	finally
    //   488	490	487	finally
    //   153	170	492	finally
    //   327	333	492	finally
    //   419	426	492	finally
    //   500	535	559	finally
    //   540	555	559	finally
    //   555	557	559	finally
    //   560	562	559	finally
    //   235	294	574	finally
    //   294	320	574	finally
    //   569	571	574	finally
    //   575	577	574	finally
  }
}
