package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzmz
  extends zzmq.zza
{
  private static zzmz zzSS;
  private static final Object zztU = new Object();
  private final Context mContext;
  private final zzmy zzST;
  private final zzfq zzSU;
  private final zzja zzSV;
  
  zzmz(Context paramContext, zzfq paramZzfq, zzmy paramZzmy)
  {
    mContext = paramContext;
    zzST = paramZzmy;
    zzSU = paramZzfq;
    if (paramContext.getApplicationContext() != null) {
      paramContext = paramContext.getApplicationContext();
    }
    for (;;)
    {
      zzSV = new zzja(paramContext, zzqa.zzkK(), paramZzfq.zzfl(), new zzpn()new zzja.zzb
      {
        public void zza(zzix paramAnonymousZzix)
        {
          paramAnonymousZzix.zza("/log", zzhw.zzHl);
        }
      }, new zzja.zzb());
      return;
    }
  }
  
  private static zzmk zza(final Context paramContext, zzja paramZzja, final zzfq paramZzfq, zzmy paramZzmy, final zzmh paramZzmh)
  {
    zzpe.zzbc("Starting ad request from service using: AFMA_getAd");
    zzfx.initialize(paramContext);
    zzqf localZzqf = zzSQ.zzii();
    final zzgf localZzgf = new zzgf(((Boolean)zzfx.zzBK.get()).booleanValue(), "load_ad", zzvj.zzzk);
    if ((versionCode > 10) && (zzRu != -1L)) {
      localZzgf.zza(localZzgf.zzc(zzRu), new String[] { "cts" });
    }
    zzgd localZzgd = localZzgf.zzfw();
    if ((versionCode >= 4) && (zzRk != null)) {}
    label1022:
    Object localObject3;
    for (Object localObject1 = zzRk;; localObject3 = null)
    {
      if ((((Boolean)zzfx.zzCb.get()).booleanValue()) && (zzSI != null))
      {
        paramZzfq = (zzfq)localObject1;
        if (localObject1 == null)
        {
          paramZzfq = (zzfq)localObject1;
          if (((Boolean)zzfx.zzCc.get()).booleanValue())
          {
            zzpe.v("contentInfo is not present, but we'll still launch the app index task");
            paramZzfq = new Bundle();
          }
        }
        if (paramZzfq != null) {
          localObject1 = zzph.zza(new Callable()
          {
            public Void zzbl()
              throws Exception
            {
              String str = paramZzmhzzRe.packageName;
              return null;
            }
          });
        }
      }
      for (;;)
      {
        Object localObject4 = new zzqd(null);
        Object localObject5 = zzRd.extras;
        int i;
        if ((localObject5 != null) && (((Bundle)localObject5).getString("_ad") != null))
        {
          i = 1;
          if ((!zzRB) || (i != 0)) {
            break label1022;
          }
          localObject4 = zzSN.zza(applicationInfo);
        }
        for (;;)
        {
          zznf localZznf = zzv.zzcS().zzv(paramContext);
          if (zzUm == -1)
          {
            zzpe.zzbc("Device is offline.");
            return new zzmk(2);
            i = 0;
            break;
          }
          if (versionCode >= 7) {}
          final zznb localZznb;
          for (localObject5 = zzRr;; localObject5 = UUID.randomUUID().toString())
          {
            localZznb = new zznb((String)localObject5, applicationInfo.packageName);
            if (zzRd.extras == null) {
              break;
            }
            localObject6 = zzRd.extras.getString("_ad");
            if (localObject6 == null) {
              break;
            }
            return zzna.zza(paramContext, paramZzmh, (String)localObject6);
          }
          Object localObject6 = zzSL.zza(paramZzmh);
          String str = zzSR.zzg(paramZzmh);
          if (localObject1 != null) {}
          try
          {
            zzpe.v("Waiting for app index fetching task.");
            ((Future)localObject1).get(((Long)zzfx.zzCd.get()).longValue(), TimeUnit.MILLISECONDS);
            zzpe.v("App index fetching task completed.");
            localObject1 = zzRe.packageName;
            zzd(localZzqf);
            paramZzfq = zzna.zza(paramContext, new zzmx().zzf(paramZzmh).zza(localZznf).zza(null).zzc(zzc((zzqf)localObject4)).zze(zzd(localZzqf)).zzaJ(str).zzk((List)localObject6).zzf(paramZzfq).zzaK(null).zzh(zzSJ.zzi(paramContext)));
            if (paramZzfq == null) {
              return new zzmk(0);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              zzpe.zzc("Failed to fetch app index signal", localInterruptedException);
            }
          }
          catch (TimeoutException localTimeoutException)
          {
            for (;;)
            {
              zzpe.zzbc("Timed out waiting for app index fetching task");
            }
            if (versionCode < 7) {}
            try
            {
              paramZzfq.put("request_id", localObject5);
              try
              {
                paramZzfq.put("prefetch_mode", "url");
                paramZzfq = paramZzfq.toString();
                localZzgf.zza(localZzgd, new String[] { "arc" });
                localObject2 = localZzgf.zzfw();
                zzpi.zzWR.post(new Runnable()
                {
                  public void run()
                  {
                    zzja.zzc localZzc = zzgv();
                    localZznb.zzb(localZzc);
                    localZzgf.zza(zzTa, new String[] { "rwc" });
                    localZzc.zza(new zzqi.zzc()new zzqi.zza
                    {
                      public void zzb(zzjb paramAnonymous2Zzjb)
                      {
                        zzsK.zza(zzTc, new String[] { "jsf" });
                        zzsK.zzfx();
                        paramAnonymous2Zzjb.zza("/invalidRequest", zzSZ.zzTk);
                        paramAnonymous2Zzjb.zza("/loadAdURL", zzSZ.zzTl);
                        paramAnonymous2Zzjb.zza("/loadAd", zzSZ.zzTm);
                        try
                        {
                          paramAnonymous2Zzjb.zzi("AFMA_getAd", zzTb);
                          return;
                        }
                        catch (Exception paramAnonymous2Zzjb)
                        {
                          zzpe.zzb("Error requesting an ad url", paramAnonymous2Zzjb);
                        }
                      }
                    }, new zzqi.zza()
                    {
                      public void run() {}
                    });
                  }
                });
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  try
                  {
                    Object localObject2 = (zzne)localZznb.zzjh().get(10L, TimeUnit.SECONDS);
                    if (localObject2 != null) {
                      continue;
                    }
                    paramZzja = new zzmk(0);
                    return paramZzja;
                  }
                  catch (Exception paramZzja)
                  {
                    paramZzja = new zzmk(0);
                    return paramZzja;
                    if (localJSONException1.getErrorCode() == -2) {
                      continue;
                    }
                    paramZzja = new zzmk(localJSONException1.getErrorCode());
                    return paramZzja;
                    if (localZzgf.zzfA() == null) {
                      continue;
                    }
                    localZzgf.zza(localZzgf.zzfA(), new String[] { "rur" });
                    paramZzfq = null;
                    if (TextUtils.isEmpty(localJSONException1.zzjm())) {
                      continue;
                    }
                    paramZzfq = zzna.zza(paramContext, paramZzmh, localJSONException1.zzjm());
                    paramZzja = paramZzfq;
                    if (paramZzfq != null) {
                      continue;
                    }
                    paramZzja = paramZzfq;
                    if (TextUtils.isEmpty(localJSONException1.getUrl())) {
                      continue;
                    }
                    paramZzja = zza(paramZzmh, paramContext, zzvf.zzaZ, localJSONException1.getUrl(), null, localJSONException1, localZzgf, paramZzmy);
                    paramZzfq = paramZzja;
                    if (paramZzja != null) {
                      continue;
                    }
                    paramZzfq = new zzmk(0);
                    localZzgf.zza(localZzgd, new String[] { "tts" });
                    zzRX = localZzgf.zzfy();
                    return paramZzfq;
                  }
                  finally
                  {
                    zzpi.zzWR.post(new Runnable()
                    {
                      public void run()
                      {
                        zzSM.zza(paramContext, localZznb, paramZzmhzzvf);
                      }
                    });
                  }
                  localJSONException1 = localJSONException1;
                  zzpe.zzc("Failed putting prefetch parameters to ad request.", localJSONException1);
                }
              }
            }
            catch (JSONException localJSONException2)
            {
              for (;;) {}
            }
          }
          catch (ExecutionException localExecutionException)
          {
            for (;;) {}
          }
        }
        localObject3 = null;
        continue;
        paramZzfq = localObject3;
        localObject3 = null;
      }
    }
  }
  
  /* Error */
  public static zzmk zza(zzmh paramZzmh, Context paramContext, String paramString1, String paramString2, String paramString3, zzne paramZzne, zzgf paramZzgf, zzmy paramZzmy)
  {
    // Byte code:
    //   0: aload 6
    //   2: ifnull +608 -> 610
    //   5: aload 6
    //   7: invokevirtual 178	com/google/android/gms/internal/zzgf:zzfw	()Lcom/google/android/gms/internal/zzgd;
    //   10: astore 12
    //   12: new 499	com/google/android/gms/internal/zznc
    //   15: dup
    //   16: aload_0
    //   17: aload 5
    //   19: invokevirtual 502	com/google/android/gms/internal/zzne:zzjj	()Ljava/lang/String;
    //   22: invokespecial 505	com/google/android/gms/internal/zznc:<init>	(Lcom/google/android/gms/internal/zzmh;Ljava/lang/String;)V
    //   25: astore 15
    //   27: aload_3
    //   28: invokestatic 509	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: astore 13
    //   33: aload 13
    //   35: invokevirtual 512	java/lang/String:length	()I
    //   38: ifeq +298 -> 336
    //   41: ldc_w 514
    //   44: aload 13
    //   46: invokevirtual 517	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 100	com/google/android/gms/internal/zzpe:zzbc	(Ljava/lang/String;)V
    //   56: new 519	java/net/URL
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 521	java/net/URL:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: invokestatic 525	com/google/android/gms/ads/internal/zzv:zzcP	()Lcom/google/android/gms/common/util/zze;
    //   68: invokeinterface 530 1 0
    //   73: lstore 10
    //   75: iconst_0
    //   76: istore 8
    //   78: aload_3
    //   79: invokevirtual 534	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   82: checkcast 536	java/net/HttpURLConnection
    //   85: astore 14
    //   87: invokestatic 540	com/google/android/gms/ads/internal/zzv:zzcJ	()Lcom/google/android/gms/internal/zzpi;
    //   90: aload_1
    //   91: aload_2
    //   92: iconst_0
    //   93: aload 14
    //   95: invokevirtual 543	com/google/android/gms/internal/zzpi:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   98: aload 4
    //   100: invokestatic 474	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +21 -> 124
    //   106: aload 5
    //   108: invokevirtual 546	com/google/android/gms/internal/zzne:zzjl	()Z
    //   111: ifeq +13 -> 124
    //   114: aload 14
    //   116: ldc_w 548
    //   119: aload 4
    //   121: invokevirtual 551	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 554	com/google/android/gms/internal/zzmh:zzRC	Ljava/lang/String;
    //   128: astore 13
    //   130: aload 13
    //   132: invokestatic 474	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +19 -> 154
    //   138: ldc_w 556
    //   141: invokestatic 100	com/google/android/gms/internal/zzpe:zzbc	(Ljava/lang/String;)V
    //   144: aload 14
    //   146: ldc_w 558
    //   149: aload 13
    //   151: invokevirtual 551	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 5
    //   156: ifnull +64 -> 220
    //   159: aload 5
    //   161: invokevirtual 561	com/google/android/gms/internal/zzne:zzjk	()Ljava/lang/String;
    //   164: invokestatic 474	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +53 -> 220
    //   170: aload 14
    //   172: iconst_1
    //   173: invokevirtual 565	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   176: aload 5
    //   178: invokevirtual 561	com/google/android/gms/internal/zzne:zzjk	()Ljava/lang/String;
    //   181: invokevirtual 569	java/lang/String:getBytes	()[B
    //   184: astore 16
    //   186: aload 14
    //   188: aload 16
    //   190: arraylength
    //   191: invokevirtual 572	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   194: new 574	java/io/BufferedOutputStream
    //   197: dup
    //   198: aload 14
    //   200: invokevirtual 578	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   203: invokespecial 581	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore 13
    //   208: aload 13
    //   210: aload 16
    //   212: invokevirtual 585	java/io/BufferedOutputStream:write	([B)V
    //   215: aload 13
    //   217: invokestatic 591	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   220: aload 14
    //   222: invokevirtual 594	java/net/HttpURLConnection:getResponseCode	()I
    //   225: istore 9
    //   227: aload 14
    //   229: invokevirtual 598	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   232: astore 13
    //   234: iload 9
    //   236: sipush 200
    //   239: if_icmplt +175 -> 414
    //   242: iload 9
    //   244: sipush 300
    //   247: if_icmpge +167 -> 414
    //   250: aload_3
    //   251: invokevirtual 599	java/net/URL:toString	()Ljava/lang/String;
    //   254: astore_0
    //   255: new 601	java/io/InputStreamReader
    //   258: dup
    //   259: aload 14
    //   261: invokevirtual 605	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   264: invokespecial 608	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   267: astore_1
    //   268: invokestatic 540	com/google/android/gms/ads/internal/zzv:zzcJ	()Lcom/google/android/gms/internal/zzpi;
    //   271: aload_1
    //   272: invokevirtual 611	com/google/android/gms/internal/zzpi:zza	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   275: astore_2
    //   276: aload_1
    //   277: invokestatic 591	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   280: aload_0
    //   281: aload 13
    //   283: aload_2
    //   284: iload 9
    //   286: invokestatic 614	com/google/android/gms/internal/zzmz:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   289: aload 15
    //   291: aload_0
    //   292: aload 13
    //   294: aload_2
    //   295: invokevirtual 617	com/google/android/gms/internal/zznc:zzb	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
    //   298: aload 6
    //   300: ifnull +21 -> 321
    //   303: aload 6
    //   305: aload 12
    //   307: iconst_1
    //   308: anewarray 169	java/lang/String
    //   311: dup
    //   312: iconst_0
    //   313: ldc_w 619
    //   316: aastore
    //   317: invokevirtual 174	com/google/android/gms/internal/zzgf:zza	(Lcom/google/android/gms/internal/zzgd;[Ljava/lang/String;)Z
    //   320: pop
    //   321: aload 15
    //   323: lload 10
    //   325: invokevirtual 623	com/google/android/gms/internal/zznc:zzj	(J)Lcom/google/android/gms/internal/zzmk;
    //   328: astore_0
    //   329: aload 14
    //   331: invokevirtual 626	java/net/HttpURLConnection:disconnect	()V
    //   334: aload_0
    //   335: areturn
    //   336: new 169	java/lang/String
    //   339: dup
    //   340: ldc_w 514
    //   343: invokespecial 627	java/lang/String:<init>	(Ljava/lang/String;)V
    //   346: astore 13
    //   348: goto -297 -> 51
    //   351: astore_0
    //   352: aload_0
    //   353: invokevirtual 630	java/io/IOException:getMessage	()Ljava/lang/String;
    //   356: invokestatic 509	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 512	java/lang/String:length	()I
    //   364: ifeq +221 -> 585
    //   367: ldc_w 632
    //   370: aload_0
    //   371: invokevirtual 517	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore_0
    //   375: aload_0
    //   376: invokestatic 635	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   379: new 266	com/google/android/gms/internal/zzmk
    //   382: dup
    //   383: iconst_2
    //   384: invokespecial 269	com/google/android/gms/internal/zzmk:<init>	(I)V
    //   387: areturn
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: aload_1
    //   392: invokestatic 591	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   395: aload_0
    //   396: athrow
    //   397: astore_0
    //   398: aload 14
    //   400: invokevirtual 626	java/net/HttpURLConnection:disconnect	()V
    //   403: aload_0
    //   404: athrow
    //   405: astore_0
    //   406: aconst_null
    //   407: astore_1
    //   408: aload_1
    //   409: invokestatic 591	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   412: aload_0
    //   413: athrow
    //   414: aload_3
    //   415: invokevirtual 599	java/net/URL:toString	()Ljava/lang/String;
    //   418: aload 13
    //   420: aconst_null
    //   421: iload 9
    //   423: invokestatic 614	com/google/android/gms/internal/zzmz:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   426: iload 9
    //   428: sipush 300
    //   431: if_icmplt +92 -> 523
    //   434: iload 9
    //   436: sipush 400
    //   439: if_icmpge +84 -> 523
    //   442: aload 14
    //   444: ldc_w 637
    //   447: invokevirtual 640	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   450: astore_3
    //   451: aload_3
    //   452: invokestatic 474	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: ifeq +25 -> 480
    //   458: ldc_w 642
    //   461: invokestatic 635	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   464: new 266	com/google/android/gms/internal/zzmk
    //   467: dup
    //   468: iconst_0
    //   469: invokespecial 269	com/google/android/gms/internal/zzmk:<init>	(I)V
    //   472: astore_0
    //   473: aload 14
    //   475: invokevirtual 626	java/net/HttpURLConnection:disconnect	()V
    //   478: aload_0
    //   479: areturn
    //   480: new 519	java/net/URL
    //   483: dup
    //   484: aload_3
    //   485: invokespecial 521	java/net/URL:<init>	(Ljava/lang/String;)V
    //   488: astore_3
    //   489: iload 8
    //   491: iconst_1
    //   492: iadd
    //   493: istore 8
    //   495: iload 8
    //   497: iconst_5
    //   498: if_icmple +67 -> 565
    //   501: ldc_w 644
    //   504: invokestatic 635	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   507: new 266	com/google/android/gms/internal/zzmk
    //   510: dup
    //   511: iconst_0
    //   512: invokespecial 269	com/google/android/gms/internal/zzmk:<init>	(I)V
    //   515: astore_0
    //   516: aload 14
    //   518: invokevirtual 626	java/net/HttpURLConnection:disconnect	()V
    //   521: aload_0
    //   522: areturn
    //   523: new 646	java/lang/StringBuilder
    //   526: dup
    //   527: bipush 46
    //   529: invokespecial 647	java/lang/StringBuilder:<init>	(I)V
    //   532: ldc_w 649
    //   535: invokevirtual 653	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: iload 9
    //   540: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: invokevirtual 657	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 635	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   549: new 266	com/google/android/gms/internal/zzmk
    //   552: dup
    //   553: iconst_0
    //   554: invokespecial 269	com/google/android/gms/internal/zzmk:<init>	(I)V
    //   557: astore_0
    //   558: aload 14
    //   560: invokevirtual 626	java/net/HttpURLConnection:disconnect	()V
    //   563: aload_0
    //   564: areturn
    //   565: aload 15
    //   567: aload 13
    //   569: invokevirtual 660	com/google/android/gms/internal/zznc:zzk	(Ljava/util/Map;)V
    //   572: aload 14
    //   574: invokevirtual 626	java/net/HttpURLConnection:disconnect	()V
    //   577: aload 7
    //   579: ifnull +3 -> 582
    //   582: goto -504 -> 78
    //   585: new 169	java/lang/String
    //   588: dup
    //   589: ldc_w 632
    //   592: invokespecial 627	java/lang/String:<init>	(Ljava/lang/String;)V
    //   595: astore_0
    //   596: goto -221 -> 375
    //   599: astore_0
    //   600: goto -192 -> 408
    //   603: astore_0
    //   604: aload 13
    //   606: astore_1
    //   607: goto -216 -> 391
    //   610: aconst_null
    //   611: astore 12
    //   613: goto -601 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	paramZzmh	zzmh
    //   0	616	1	paramContext	Context
    //   0	616	2	paramString1	String
    //   0	616	3	paramString2	String
    //   0	616	4	paramString3	String
    //   0	616	5	paramZzne	zzne
    //   0	616	6	paramZzgf	zzgf
    //   0	616	7	paramZzmy	zzmy
    //   76	423	8	i	int
    //   225	314	9	j	int
    //   73	251	10	l	long
    //   10	602	12	localZzgd	zzgd
    //   31	574	13	localObject	Object
    //   85	488	14	localHttpURLConnection	java.net.HttpURLConnection
    //   25	541	15	localZznc	zznc
    //   184	27	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	51	351	java/io/IOException
    //   51	75	351	java/io/IOException
    //   78	87	351	java/io/IOException
    //   329	334	351	java/io/IOException
    //   336	348	351	java/io/IOException
    //   398	405	351	java/io/IOException
    //   473	478	351	java/io/IOException
    //   516	521	351	java/io/IOException
    //   558	563	351	java/io/IOException
    //   572	577	351	java/io/IOException
    //   194	208	388	finally
    //   87	124	397	finally
    //   124	154	397	finally
    //   159	194	397	finally
    //   215	220	397	finally
    //   220	234	397	finally
    //   250	255	397	finally
    //   276	298	397	finally
    //   303	321	397	finally
    //   321	329	397	finally
    //   391	397	397	finally
    //   408	414	397	finally
    //   414	426	397	finally
    //   442	473	397	finally
    //   480	489	397	finally
    //   501	516	397	finally
    //   523	558	397	finally
    //   565	572	397	finally
    //   255	268	405	finally
    //   268	276	599	finally
    //   208	215	603	finally
  }
  
  public static zzmz zza(Context paramContext, zzfq paramZzfq, zzmy paramZzmy)
  {
    synchronized (zztU)
    {
      if (zzSS == null)
      {
        Context localContext = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localContext = paramContext.getApplicationContext();
        }
        zzSS = new zzmz(localContext, paramZzfq, paramZzmy);
      }
      paramContext = zzSS;
      return paramContext;
    }
  }
  
  private static void zza(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (zzpe.zzai(2))
    {
      zzpe.v(String.valueOf(paramString1).length() + 39 + "Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          paramString1 = (String)localIterator1.next();
          zzpe.v(String.valueOf(paramString1).length() + 5 + "    " + paramString1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(paramString1)).iterator();
          label139:
          if (localIterator2.hasNext())
          {
            paramString1 = String.valueOf((String)localIterator2.next());
            if (paramString1.length() == 0) {
              break label185;
            }
          }
          label185:
          for (paramString1 = "      ".concat(paramString1);; paramString1 = new String("      "))
          {
            zzpe.v(paramString1);
            break label139;
            break;
          }
        }
      }
      zzpe.v("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          zzpe.v(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      zzpe.v("    null");
      zzpe.v(34 + "  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  private static Location zzc(zzqf<Location> paramZzqf)
  {
    try
    {
      paramZzqf = (Location)paramZzqf.get(((Long)zzfx.zzEl.get()).longValue(), TimeUnit.MILLISECONDS);
      return paramZzqf;
    }
    catch (Exception paramZzqf)
    {
      zzpe.zzc("Exception caught while getting location", paramZzqf);
    }
    return null;
  }
  
  private static Bundle zzd(zzqf<Bundle> paramZzqf)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramZzqf = (Bundle)paramZzqf.get(((Long)zzfx.zzED.get()).longValue(), TimeUnit.MILLISECONDS);
      return paramZzqf;
    }
    catch (Exception paramZzqf)
    {
      zzpe.zzc("Exception caught while getting parental controls.", paramZzqf);
    }
    return localBundle;
  }
  
  public void zza(final zzmh paramZzmh, final zzmr paramZzmr)
  {
    zzv.zzcN().zzc(mContext, zzvf);
    zzph.zza(new Runnable()
    {
      public void run()
      {
        try
        {
          zzmk localZzmk1 = zzd(paramZzmh);
          localZzmk2 = localZzmk1;
          if (localZzmk1 == null) {
            localZzmk2 = new zzmk(0);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              zzmk localZzmk2;
              paramZzmr.zzb(localZzmk2);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Object localObject;
              zzpe.zzc("Fail to forward ad response.", localRemoteException);
            }
            localException = localException;
            zzv.zzcN().zza(localException, "AdRequestServiceImpl.loadAdAsync");
            zzpe.zzc("Could not fetch ad response due to an Exception.", localException);
            localObject = null;
          }
        }
      }
    });
  }
  
  public zzmk zzd(zzmh paramZzmh)
  {
    return zza(mContext, zzSV, zzSU, zzST, paramZzmh);
  }
}
