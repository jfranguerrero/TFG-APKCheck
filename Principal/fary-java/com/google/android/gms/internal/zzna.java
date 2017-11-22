package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzna
{
  private static final SimpleDateFormat zzTg = new SimpleDateFormat("yyyyMMdd", Locale.US);
  
  private static Integer zzB(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String zzZ(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  /* Error */
  public static zzmk zza(Context paramContext, zzmh paramZzmh, String paramString)
  {
    // Byte code:
    //   0: new 51	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 29
    //   10: aload 29
    //   12: ldc 56
    //   14: aconst_null
    //   15: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 25
    //   20: aload 29
    //   22: ldc 62
    //   24: aconst_null
    //   25: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 26
    //   30: aload 29
    //   32: ldc 64
    //   34: aconst_null
    //   35: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 30
    //   40: aload 29
    //   42: ldc 66
    //   44: aload 30
    //   46: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 31
    //   51: aload_1
    //   52: ifnull +799 -> 851
    //   55: aload_1
    //   56: getfield 72	com/google/android/gms/internal/zzmh:zzRj	I
    //   59: ifeq +792 -> 851
    //   62: iconst_1
    //   63: istore 5
    //   65: aload 29
    //   67: ldc 74
    //   69: aconst_null
    //   70: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: astore 24
    //   77: aload_2
    //   78: ifnonnull +13 -> 91
    //   81: aload 29
    //   83: ldc 76
    //   85: aconst_null
    //   86: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 24
    //   91: aload 24
    //   93: astore_2
    //   94: aload 24
    //   96: ifnonnull +12 -> 108
    //   99: aload 29
    //   101: ldc 78
    //   103: aconst_null
    //   104: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_2
    //   108: ldc2_w 79
    //   111: lstore 18
    //   113: aload 29
    //   115: ldc 82
    //   117: aconst_null
    //   118: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 32
    //   123: aload 29
    //   125: ldc 84
    //   127: aconst_null
    //   128: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 33
    //   133: aload 29
    //   135: ldc 86
    //   137: invokevirtual 90	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +717 -> 857
    //   143: aload 29
    //   145: ldc 86
    //   147: invokevirtual 94	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   150: ldc2_w 95
    //   153: dmul
    //   154: d2l
    //   155: lstore 16
    //   157: aload 29
    //   159: ldc 98
    //   161: aconst_null
    //   162: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 24
    //   167: iconst_m1
    //   168: istore_3
    //   169: ldc 100
    //   171: aload 24
    //   173: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +82 -> 258
    //   179: invokestatic 110	com/google/android/gms/ads/internal/zzv:zzcL	()Lcom/google/android/gms/internal/zzpj;
    //   182: invokevirtual 116	com/google/android/gms/internal/zzpj:zzkq	()I
    //   185: istore_3
    //   186: aconst_null
    //   187: astore 27
    //   189: aload_2
    //   190: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifeq +649 -> 842
    //   196: aload 26
    //   198: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +641 -> 842
    //   204: aload_1
    //   205: aload_0
    //   206: aload_1
    //   207: getfield 126	com/google/android/gms/internal/zzmh:zzvf	Lcom/google/android/gms/internal/zzqa;
    //   210: getfield 132	com/google/android/gms/internal/zzqa:zzaZ	Ljava/lang/String;
    //   213: aload 26
    //   215: aconst_null
    //   216: aconst_null
    //   217: aconst_null
    //   218: aconst_null
    //   219: invokestatic 137	com/google/android/gms/internal/zzmz:zza	(Lcom/google/android/gms/internal/zzmh;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzne;Lcom/google/android/gms/internal/zzgf;Lcom/google/android/gms/internal/zzmy;)Lcom/google/android/gms/internal/zzmk;
    //   222: astore 27
    //   224: aload 27
    //   226: getfield 142	com/google/android/gms/internal/zzmk:zzNb	Ljava/lang/String;
    //   229: astore_2
    //   230: aload 27
    //   232: getfield 144	com/google/android/gms/internal/zzmk:body	Ljava/lang/String;
    //   235: astore 24
    //   237: aload 27
    //   239: getfield 148	com/google/android/gms/internal/zzmk:zzRO	J
    //   242: lstore 18
    //   244: aload 24
    //   246: ifnonnull +32 -> 278
    //   249: new 139	com/google/android/gms/internal/zzmk
    //   252: dup
    //   253: iconst_0
    //   254: invokespecial 151	com/google/android/gms/internal/zzmk:<init>	(I)V
    //   257: areturn
    //   258: ldc -103
    //   260: aload 24
    //   262: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   265: ifeq -79 -> 186
    //   268: invokestatic 110	com/google/android/gms/ads/internal/zzv:zzcL	()Lcom/google/android/gms/internal/zzpj;
    //   271: invokevirtual 156	com/google/android/gms/internal/zzpj:zzkp	()I
    //   274: istore_3
    //   275: goto -89 -> 186
    //   278: aload 29
    //   280: ldc -98
    //   282: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   285: astore 26
    //   287: aload 27
    //   289: ifnonnull +506 -> 795
    //   292: aconst_null
    //   293: astore_0
    //   294: aload_0
    //   295: astore 25
    //   297: aload 26
    //   299: ifnull +11 -> 310
    //   302: aload 26
    //   304: aload_0
    //   305: invokestatic 165	com/google/android/gms/internal/zzna:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   308: astore 25
    //   310: aload 29
    //   312: ldc -89
    //   314: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 28
    //   319: aload 27
    //   321: ifnonnull +483 -> 804
    //   324: aconst_null
    //   325: astore_0
    //   326: aload_0
    //   327: astore 26
    //   329: aload 28
    //   331: ifnull +11 -> 342
    //   334: aload 28
    //   336: aload_0
    //   337: invokestatic 165	com/google/android/gms/internal/zzna:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   340: astore 26
    //   342: aload 29
    //   344: ldc -87
    //   346: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   349: astore 34
    //   351: aload 27
    //   353: ifnonnull +460 -> 813
    //   356: aconst_null
    //   357: astore_0
    //   358: aload_0
    //   359: astore 28
    //   361: aload 34
    //   363: ifnull +11 -> 374
    //   366: aload 34
    //   368: aload_0
    //   369: invokestatic 165	com/google/android/gms/internal/zzna:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   372: astore 28
    //   374: iload_3
    //   375: istore 4
    //   377: aload 27
    //   379: ifnull +457 -> 836
    //   382: aload 27
    //   384: getfield 171	com/google/android/gms/internal/zzmk:orientation	I
    //   387: iconst_m1
    //   388: if_icmpeq +9 -> 397
    //   391: aload 27
    //   393: getfield 171	com/google/android/gms/internal/zzmk:orientation	I
    //   396: istore_3
    //   397: iload_3
    //   398: istore 4
    //   400: aload 27
    //   402: getfield 174	com/google/android/gms/internal/zzmk:zzRJ	J
    //   405: lconst_0
    //   406: lcmp
    //   407: ifle +429 -> 836
    //   410: aload 27
    //   412: getfield 174	com/google/android/gms/internal/zzmk:zzRJ	J
    //   415: lstore 16
    //   417: aload 29
    //   419: ldc -80
    //   421: invokevirtual 179	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   424: astore 27
    //   426: aconst_null
    //   427: astore_0
    //   428: aload 29
    //   430: ldc -75
    //   432: iconst_0
    //   433: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   436: istore 6
    //   438: iload 6
    //   440: ifeq +12 -> 452
    //   443: aload 29
    //   445: ldc -69
    //   447: aconst_null
    //   448: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   451: astore_0
    //   452: aload 29
    //   454: ldc -67
    //   456: iconst_0
    //   457: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   460: istore 7
    //   462: aload 29
    //   464: ldc -65
    //   466: iconst_0
    //   467: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   470: istore 8
    //   472: aload 29
    //   474: ldc -63
    //   476: iconst_1
    //   477: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   480: istore 9
    //   482: aload 29
    //   484: ldc -61
    //   486: iconst_1
    //   487: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   490: istore 10
    //   492: aload 29
    //   494: ldc -59
    //   496: iconst_0
    //   497: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   500: istore 11
    //   502: aload 29
    //   504: ldc -57
    //   506: ldc2_w 79
    //   509: invokevirtual 203	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   512: lstore 20
    //   514: aload 29
    //   516: ldc -51
    //   518: ldc2_w 79
    //   521: invokevirtual 203	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   524: lstore 22
    //   526: aload 29
    //   528: ldc -49
    //   530: ldc -47
    //   532: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   535: astore 34
    //   537: ldc -45
    //   539: aload 29
    //   541: ldc -43
    //   543: ldc -47
    //   545: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   548: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   551: istore 12
    //   553: aload 29
    //   555: ldc -41
    //   557: iconst_0
    //   558: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   561: istore 13
    //   563: aload 29
    //   565: ldc -39
    //   567: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   570: aconst_null
    //   571: invokestatic 165	com/google/android/gms/internal/zzna:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   574: astore 35
    //   576: aload 29
    //   578: ldc -37
    //   580: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   583: aconst_null
    //   584: invokestatic 165	com/google/android/gms/internal/zzna:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   587: astore 36
    //   589: aload 29
    //   591: ldc -35
    //   593: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   596: invokestatic 226	com/google/android/gms/internal/zzok:zza	(Lorg/json/JSONArray;)Lcom/google/android/gms/internal/zzok;
    //   599: astore 37
    //   601: aload 29
    //   603: ldc -28
    //   605: iconst_0
    //   606: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   609: istore 14
    //   611: aload 29
    //   613: ldc -26
    //   615: invokevirtual 234	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   618: invokestatic 240	com/google/android/gms/internal/zzmm:zzg	(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzmm;
    //   621: astore 38
    //   623: aload 29
    //   625: ldc -14
    //   627: ldc -47
    //   629: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   632: astore 39
    //   634: aload 29
    //   636: ldc -12
    //   638: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   641: aconst_null
    //   642: invokestatic 165	com/google/android/gms/internal/zzna:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   645: astore 40
    //   647: aload 29
    //   649: ldc -10
    //   651: invokevirtual 234	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   654: invokestatic 252	com/google/android/gms/internal/zzon:zzi	(Lorg/json/JSONObject;)Lcom/google/android/gms/internal/zzon;
    //   657: astore 41
    //   659: aload 29
    //   661: ldc -2
    //   663: aload_1
    //   664: getfield 258	com/google/android/gms/internal/zzmh:zzKc	Z
    //   667: invokevirtual 185	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   670: istore 15
    //   672: new 139	com/google/android/gms/internal/zzmk
    //   675: dup
    //   676: aload_1
    //   677: aload_2
    //   678: aload 24
    //   680: aload 25
    //   682: aload 26
    //   684: lload 16
    //   686: iload 7
    //   688: lload 22
    //   690: aload 28
    //   692: lload 20
    //   694: iload_3
    //   695: aload 30
    //   697: lload 18
    //   699: aload 32
    //   701: iload 6
    //   703: aload_0
    //   704: aload 27
    //   706: iload 8
    //   708: iload 5
    //   710: aload_1
    //   711: getfield 261	com/google/android/gms/internal/zzmh:zzRl	Z
    //   714: iload 9
    //   716: iload 11
    //   718: aload 34
    //   720: iload 12
    //   722: iload 13
    //   724: aload 37
    //   726: aload 35
    //   728: aload 36
    //   730: iload 14
    //   732: aload 38
    //   734: aload_1
    //   735: getfield 264	com/google/android/gms/internal/zzmh:zzRB	Z
    //   738: aload 39
    //   740: aload 40
    //   742: iload 15
    //   744: aload 31
    //   746: aload 41
    //   748: aload 33
    //   750: iload 10
    //   752: invokespecial 267	com/google/android/gms/internal/zzmk:<init>	(Lcom/google/android/gms/internal/zzmh;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JZJLjava/util/List;JILjava/lang/String;JLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZZZZLjava/lang/String;ZZLcom/google/android/gms/internal/zzok;Ljava/util/List;Ljava/util/List;ZLcom/google/android/gms/internal/zzmm;ZLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Lcom/google/android/gms/internal/zzon;Ljava/lang/String;Z)V
    //   755: astore_0
    //   756: aload_0
    //   757: areturn
    //   758: astore_0
    //   759: aload_0
    //   760: invokevirtual 271	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   763: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   766: astore_0
    //   767: aload_0
    //   768: invokevirtual 277	java/lang/String:length	()I
    //   771: ifeq +51 -> 822
    //   774: ldc_w 279
    //   777: aload_0
    //   778: invokevirtual 282	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   781: astore_0
    //   782: aload_0
    //   783: invokestatic 287	com/google/android/gms/internal/zzpe:zzbe	(Ljava/lang/String;)V
    //   786: new 139	com/google/android/gms/internal/zzmk
    //   789: dup
    //   790: iconst_0
    //   791: invokespecial 151	com/google/android/gms/internal/zzmk:<init>	(I)V
    //   794: areturn
    //   795: aload 27
    //   797: getfield 291	com/google/android/gms/internal/zzmk:zzJY	Ljava/util/List;
    //   800: astore_0
    //   801: goto -507 -> 294
    //   804: aload 27
    //   806: getfield 294	com/google/android/gms/internal/zzmk:zzJZ	Ljava/util/List;
    //   809: astore_0
    //   810: goto -484 -> 326
    //   813: aload 27
    //   815: getfield 297	com/google/android/gms/internal/zzmk:zzRM	Ljava/util/List;
    //   818: astore_0
    //   819: goto -461 -> 358
    //   822: new 41	java/lang/String
    //   825: dup
    //   826: ldc_w 279
    //   829: invokespecial 298	java/lang/String:<init>	(Ljava/lang/String;)V
    //   832: astore_0
    //   833: goto -51 -> 782
    //   836: iload 4
    //   838: istore_3
    //   839: goto -422 -> 417
    //   842: aload_2
    //   843: astore 24
    //   845: aload 25
    //   847: astore_2
    //   848: goto -604 -> 244
    //   851: iconst_0
    //   852: istore 5
    //   854: goto -789 -> 65
    //   857: ldc2_w 79
    //   860: lstore 16
    //   862: goto -705 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	paramContext	Context
    //   0	865	1	paramZzmh	zzmh
    //   0	865	2	paramString	String
    //   168	671	3	i	int
    //   375	462	4	j	int
    //   63	790	5	bool1	boolean
    //   436	266	6	bool2	boolean
    //   460	227	7	bool3	boolean
    //   470	237	8	bool4	boolean
    //   480	235	9	bool5	boolean
    //   490	261	10	bool6	boolean
    //   500	217	11	bool7	boolean
    //   551	170	12	bool8	boolean
    //   561	162	13	bool9	boolean
    //   609	122	14	bool10	boolean
    //   670	73	15	bool11	boolean
    //   155	706	16	l1	long
    //   111	587	18	l2	long
    //   512	181	20	l3	long
    //   524	165	22	l4	long
    //   75	769	24	str1	String
    //   18	828	25	localObject1	Object
    //   28	655	26	localObject2	Object
    //   187	627	27	localObject3	Object
    //   317	374	28	localObject4	Object
    //   8	652	29	localJSONObject	JSONObject
    //   38	658	30	str2	String
    //   49	696	31	str3	String
    //   121	579	32	str4	String
    //   131	618	33	str5	String
    //   349	370	34	localObject5	Object
    //   574	153	35	localList1	List
    //   587	142	36	localList2	List
    //   599	126	37	localZzok	zzok
    //   621	112	38	localZzmm	zzmm
    //   632	107	39	str6	String
    //   645	96	40	localList3	List
    //   657	90	41	localZzon	zzon
    // Exception table:
    //   from	to	target	type
    //   0	51	758	org/json/JSONException
    //   55	62	758	org/json/JSONException
    //   65	74	758	org/json/JSONException
    //   81	91	758	org/json/JSONException
    //   99	108	758	org/json/JSONException
    //   113	157	758	org/json/JSONException
    //   157	167	758	org/json/JSONException
    //   169	186	758	org/json/JSONException
    //   189	244	758	org/json/JSONException
    //   249	258	758	org/json/JSONException
    //   258	275	758	org/json/JSONException
    //   278	287	758	org/json/JSONException
    //   302	310	758	org/json/JSONException
    //   310	319	758	org/json/JSONException
    //   334	342	758	org/json/JSONException
    //   342	351	758	org/json/JSONException
    //   366	374	758	org/json/JSONException
    //   382	397	758	org/json/JSONException
    //   400	417	758	org/json/JSONException
    //   417	426	758	org/json/JSONException
    //   428	438	758	org/json/JSONException
    //   443	452	758	org/json/JSONException
    //   452	756	758	org/json/JSONException
    //   795	801	758	org/json/JSONException
    //   804	810	758	org/json/JSONException
    //   813	819	758	org/json/JSONException
  }
  
  @Nullable
  private static List<String> zza(@Nullable JSONArray paramJSONArray, @Nullable List<String> paramList)
    throws JSONException
  {
    if (paramJSONArray == null)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new LinkedList();
    }
    int i = 0;
    for (;;)
    {
      paramList = (List<String>)localObject;
      if (i >= paramJSONArray.length()) {
        break;
      }
      ((List)localObject).add(paramJSONArray.getString(i));
      i += 1;
    }
  }
  
  @Nullable
  public static JSONObject zza(Context paramContext, zzmx paramZzmx)
  {
    paramContext = zzSF;
    Location localLocation = zzyN;
    zznf localZznf = zzSG;
    Bundle localBundle = zzRk;
    JSONObject localJSONObject = zzSH;
    for (;;)
    {
      HashMap localHashMap;
      Object localObject;
      int m;
      int i;
      int j;
      zzec localZzec;
      int k;
      try
      {
        localHashMap = new HashMap();
        localHashMap.put("extra_caps", zzfx.zzDN.get());
        if (zzRs.size() > 0) {
          localHashMap.put("eid", TextUtils.join(",", zzRs));
        }
        if (zzRc != null) {
          localHashMap.put("ad_pos", zzRc);
        }
        zza(localHashMap, zzRd);
        zzec[] arrayOfZzec;
        if (zzvj.zzzm == null)
        {
          localHashMap.put("format", zzvj.zzzk);
          if (zzvj.zzzo) {
            localHashMap.put("fluid", "height");
          }
          if (zzvj.width == -1) {
            localHashMap.put("smart_w", "full");
          }
          if (zzvj.height == -2) {
            localHashMap.put("smart_h", "auto");
          }
          if (zzvj.zzzm == null) {
            break label560;
          }
          localObject = new StringBuilder();
          arrayOfZzec = zzvj.zzzm;
          m = arrayOfZzec.length;
          i = 0;
          j = 0;
          if (i >= m) {
            break label517;
          }
          localZzec = arrayOfZzec[i];
          if (zzzo)
          {
            j = 1;
            break label1562;
          }
        }
        else
        {
          localObject = zzvj.zzzm;
          int n = localObject.length;
          j = 0;
          m = 0;
          i = 0;
          if (i >= n) {
            continue;
          }
          arrayOfZzec = localObject[i];
          k = m;
          if (!zzzo)
          {
            k = m;
            if (m == 0)
            {
              localHashMap.put("format", zzzk);
              k = 1;
            }
          }
          m = j;
          if (!zzzo) {
            break label1569;
          }
          m = j;
          if (j != 0) {
            break label1569;
          }
          localHashMap.put("fluid", "height");
          m = 1;
          break label1569;
        }
        if (((StringBuilder)localObject).length() != 0) {
          ((StringBuilder)localObject).append("|");
        }
        if (width == -1)
        {
          k = (int)(widthPixels / zzxa);
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append("x");
          if (height != -2) {
            break label507;
          }
          k = (int)(heightPixels / zzxa);
          label456:
          ((StringBuilder)localObject).append(k);
        }
      }
      catch (JSONException paramContext)
      {
        paramContext = String.valueOf(paramContext.getMessage());
        if (paramContext.length() == 0) {}
      }
      for (paramContext = "Problem serializing ad request to JSON: ".concat(paramContext);; paramContext = new String("Problem serializing ad request to JSON: "))
      {
        zzpe.zzbe(paramContext);
        return null;
        k = width;
        break;
        label507:
        k = height;
        break label456;
        label517:
        if (j != 0)
        {
          if (((StringBuilder)localObject).length() != 0) {
            ((StringBuilder)localObject).insert(0, "|");
          }
          ((StringBuilder)localObject).insert(0, "320x50");
        }
        localHashMap.put("sz", localObject);
        label560:
        if (zzRj != 0)
        {
          localHashMap.put("native_version", Integer.valueOf(zzRj));
          localHashMap.put("native_templates", zzvB);
          localHashMap.put("native_image_orientation", zzc(zzvx));
          if (!zzRt.isEmpty()) {
            localHashMap.put("native_custom_templates", zzRt);
          }
        }
        if (zzvj.zzzp) {
          localHashMap.put("ene", Boolean.valueOf(true));
        }
        localHashMap.put("slotname", zzvd);
        localHashMap.put("pn", applicationInfo.packageName);
        if (zzRe != null) {
          localHashMap.put("vc", Integer.valueOf(zzRe.versionCode));
        }
        localHashMap.put("ms", zzRf);
        localHashMap.put("seq_num", zzRg);
        localHashMap.put("session_id", zzRh);
        localHashMap.put("js", zzvf.zzaZ);
        zza(localHashMap, localZznf, zzSD, zzRG, zzSC);
        zza(localHashMap, zzSE);
        localHashMap.put("platform", Build.MANUFACTURER);
        localHashMap.put("submodel", Build.MODEL);
        if (localLocation != null) {
          zza(localHashMap, localLocation);
        }
        for (;;)
        {
          if (versionCode >= 2) {
            localHashMap.put("quality_signals", zzRi);
          }
          if ((versionCode >= 4) && (zzRl)) {
            localHashMap.put("forceHttps", Boolean.valueOf(zzRl));
          }
          if (localBundle != null) {
            localHashMap.put("content_info", localBundle);
          }
          label958:
          boolean bool;
          if (versionCode >= 5)
          {
            localHashMap.put("u_sd", Float.valueOf(zzxa));
            localHashMap.put("sh", Integer.valueOf(zzRo));
            localHashMap.put("sw", Integer.valueOf(zzRn));
            if (versionCode >= 6)
            {
              bool = TextUtils.isEmpty(zzRp);
              if (bool) {}
            }
          }
          try
          {
            localHashMap.put("view_hierarchy", new JSONObject(zzRp));
            localHashMap.put("correlation_id", Long.valueOf(zzRq));
            if (versionCode >= 7) {
              localHashMap.put("request_id", zzRr);
            }
            if ((versionCode >= 11) && (zzRv != null)) {
              localHashMap.put("capability", zzRv.toBundle());
            }
            if ((versionCode >= 12) && (!TextUtils.isEmpty(zzRw))) {
              localHashMap.put("anchor", zzRw);
            }
            if (versionCode >= 13) {
              localHashMap.put("android_app_volume", Float.valueOf(zzRx));
            }
            if (versionCode >= 18) {
              localHashMap.put("android_app_muted", Boolean.valueOf(zzRD));
            }
            if ((versionCode >= 14) && (zzRy > 0)) {
              localHashMap.put("target_api", Integer.valueOf(zzRy));
            }
            if (versionCode >= 15)
            {
              if (zzRz == -1)
              {
                i = -1;
                localHashMap.put("scroll_index", Integer.valueOf(i));
              }
            }
            else
            {
              if (versionCode >= 16) {
                localHashMap.put("_activity_context", Boolean.valueOf(zzRA));
              }
              if (versionCode >= 18)
              {
                bool = TextUtils.isEmpty(zzRE);
                if (bool) {}
              }
            }
          }
          catch (JSONException paramZzmx)
          {
            try
            {
              for (;;)
              {
                localHashMap.put("app_settings", new JSONObject(zzRE));
                localHashMap.put("render_in_browser", Boolean.valueOf(zzKc));
                if (versionCode >= 18) {
                  localHashMap.put("android_num_video_cache_tasks", Integer.valueOf(zzRF));
                }
                zza(localHashMap);
                localHashMap.put("cache_state", localJSONObject);
                if (versionCode >= 19) {
                  localHashMap.put("gct", zzRH);
                }
                if (zzpe.zzai(2))
                {
                  paramContext = String.valueOf(zzv.zzcJ().zzP(localHashMap).toString(2));
                  if (paramContext.length() == 0) {
                    break label1534;
                  }
                  paramContext = "Ad Request JSON: ".concat(paramContext);
                  zzpe.v(paramContext);
                }
                return zzv.zzcJ().zzP(localHashMap);
                if ((zzRd.versionCode < 2) || (zzRd.zzyN == null)) {
                  break;
                }
                zza(localHashMap, zzRd.zzyN);
                break;
                localHashMap.put("u_sd", Float.valueOf(zzxa));
                localHashMap.put("sh", Integer.valueOf(zzRo));
                localHashMap.put("sw", Integer.valueOf(zzRn));
                break label958;
                paramZzmx = paramZzmx;
                zzpe.zzc("Problem serializing view hierarchy to JSON", paramZzmx);
              }
              i = zzRz;
            }
            catch (JSONException paramZzmx)
            {
              for (;;)
              {
                zzpe.zzc("Problem creating json from app settings", paramZzmx);
                continue;
                label1534:
                paramContext = new String("Ad Request JSON: ");
              }
            }
          }
        }
      }
      label1562:
      i += 1;
      continue;
      label1569:
      if ((k == 0) || (m == 0))
      {
        i += 1;
        j = m;
        m = k;
      }
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap)
  {
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cl", "139965458");
    localBundle2.putString("rapid_rc", "dev");
    localBundle2.putString("rapid_rollup", "HEAD");
    localBundle1.putBundle("build_meta", localBundle2);
    localBundle1.putString("mf", Boolean.toString(((Boolean)zzfx.zzDP.get()).booleanValue()));
    paramHashMap.put("sdk_env", localBundle1);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    float f = paramLocation.getAccuracy();
    long l1 = paramLocation.getTime();
    long l2 = (paramLocation.getLatitude() * 1.0E7D);
    long l3 = (paramLocation.getLongitude() * 1.0E7D);
    localHashMap.put("radius", Float.valueOf(f * 1000.0F));
    localHashMap.put("lat", Long.valueOf(l2));
    localHashMap.put("long", Long.valueOf(l3));
    localHashMap.put("time", Long.valueOf(l1 * 1000L));
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zzdy paramZzdy)
  {
    String str = zzpc.zzke();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (zzyF != -1L) {
      paramHashMap.put("cust_age", zzTg.format(new Date(zzyF)));
    }
    if (extras != null) {
      paramHashMap.put("extras", extras);
    }
    if (zzyG != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(zzyG));
    }
    if (zzyH != null) {
      paramHashMap.put("kw", zzyH);
    }
    if (zzyJ != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzyJ));
    }
    if (zzyI) {
      paramHashMap.put("adtest", "on");
    }
    if (versionCode >= 2)
    {
      if (zzyK) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(zzyL)) {
        paramHashMap.put("ppid", zzyL);
      }
      if (zzyM != null) {
        zza(paramHashMap, zzyM);
      }
    }
    if ((versionCode >= 3) && (zzyO != null)) {
      paramHashMap.put("url", zzyO);
    }
    if (versionCode >= 5)
    {
      if (zzyQ != null) {
        paramHashMap.put("custom_targeting", zzyQ);
      }
      if (zzyR != null) {
        paramHashMap.put("category_exclusions", zzyR);
      }
      if (zzyS != null) {
        paramHashMap.put("request_agent", zzyS);
      }
    }
    if ((versionCode >= 6) && (zzyT != null)) {
      paramHashMap.put("request_pkg", zzyT);
    }
    if (versionCode >= 7) {
      paramHashMap.put("is_designed_for_families", Boolean.valueOf(zzyU));
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zzfj paramZzfj)
  {
    Object localObject2 = null;
    if (Color.alpha(zzAr) != 0) {
      paramHashMap.put("acolor", zzZ(zzAr));
    }
    if (Color.alpha(backgroundColor) != 0) {
      paramHashMap.put("bgcolor", zzZ(backgroundColor));
    }
    if ((Color.alpha(zzAs) != 0) && (Color.alpha(zzAt) != 0))
    {
      paramHashMap.put("gradientto", zzZ(zzAs));
      paramHashMap.put("gradientfrom", zzZ(zzAt));
    }
    if (Color.alpha(zzAu) != 0) {
      paramHashMap.put("bcolor", zzZ(zzAu));
    }
    paramHashMap.put("bthick", Integer.toString(zzAv));
    Object localObject1;
    switch (zzAw)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (zzAx)
      {
      default: 
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramHashMap.put("callbuttoncolor", localObject1);
      }
      if (zzAy != null) {
        paramHashMap.put("channel", zzAy);
      }
      if (Color.alpha(zzAz) != 0) {
        paramHashMap.put("dcolor", zzZ(zzAz));
      }
      if (zzAA != null) {
        paramHashMap.put("font", zzAA);
      }
      if (Color.alpha(zzAB) != 0) {
        paramHashMap.put("hcolor", zzZ(zzAB));
      }
      paramHashMap.put("headersize", Integer.toString(zzAC));
      if (zzAD != null) {
        paramHashMap.put("q", zzAD);
      }
      return;
      localObject1 = "none";
      break;
      localObject1 = "dashed";
      break;
      localObject1 = "dotted";
      break;
      localObject1 = "solid";
      break;
      localObject1 = "dark";
      continue;
      localObject1 = "light";
      continue;
      localObject1 = "medium";
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zznf paramZznf, zznj.zza paramZza, Bundle paramBundle1, Bundle paramBundle2)
  {
    paramHashMap.put("am", Integer.valueOf(zzUa));
    paramHashMap.put("cog", zzB(zzUb));
    paramHashMap.put("coh", zzB(zzUc));
    if (!TextUtils.isEmpty(zzUd)) {
      paramHashMap.put("carrier", zzUd);
    }
    paramHashMap.put("gl", zzUe);
    if (zzUf) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    if (zzUg) {
      paramHashMap.put("is_sidewinder", Integer.valueOf(1));
    }
    paramHashMap.put("ma", zzB(zzUh));
    paramHashMap.put("sp", zzB(zzUi));
    paramHashMap.put("hl", zzUj);
    if (!TextUtils.isEmpty(zzUk)) {
      paramHashMap.put("mv", zzUk);
    }
    paramHashMap.put("muv", Integer.valueOf(zzUl));
    if (zzUm != -2) {
      paramHashMap.put("cnt", Integer.valueOf(zzUm));
    }
    paramHashMap.put("gnt", Integer.valueOf(zzUn));
    paramHashMap.put("pt", Integer.valueOf(zzUo));
    paramHashMap.put("rm", Integer.valueOf(zzUp));
    paramHashMap.put("riv", Integer.valueOf(zzUq));
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("build", zzUv);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", zzUs);
    localBundle2.putDouble("battery_level", zzUr);
    localBundle1.putBundle("battery", localBundle2);
    localBundle2 = new Bundle();
    localBundle2.putInt("active_network_state", zzUu);
    localBundle2.putBoolean("active_network_metered", zzUt);
    if (paramZza != null)
    {
      Bundle localBundle3 = new Bundle();
      localBundle3.putInt("predicted_latency_micros", zzUA);
      localBundle3.putLong("predicted_down_throughput_bps", zzUB);
      localBundle3.putLong("predicted_up_throughput_bps", zzUC);
      localBundle2.putBundle("predictions", localBundle3);
    }
    localBundle1.putBundle("network", localBundle2);
    paramZza = new Bundle();
    paramZza.putBoolean("is_browser_custom_tabs_capable", zzUw);
    localBundle1.putBundle("browser", paramZza);
    if (paramBundle1 != null) {
      localBundle1.putBundle("android_mem_info", zzg(paramBundle1));
    }
    paramZznf = new Bundle();
    paramZznf.putBundle("parental_controls", paramBundle2);
    localBundle1.putBundle("play_store", paramZznf);
    paramHashMap.put("device", localBundle1);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("doritos", paramString);
    paramHashMap.put("pii", localBundle);
  }
  
  private static String zzc(zzgw paramZzgw)
  {
    if (paramZzgw != null) {}
    for (int i = zzGE;; i = 0) {
      switch (i)
      {
      default: 
        return "any";
      }
    }
    return "portrait";
    return "landscape";
  }
  
  public static JSONObject zzc(zzmk paramZzmk)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (zzNb != null) {
      localJSONObject.put("ad_base_url", zzNb);
    }
    if (zzRN != null) {
      localJSONObject.put("ad_size", zzRN);
    }
    localJSONObject.put("native", zzzn);
    if (zzzn)
    {
      localJSONObject.put("ad_json", body);
      if (zzRP != null) {
        localJSONObject.put("debug_dialog", zzRP);
      }
      if (zzSg != null) {
        localJSONObject.put("debug_signals", zzSg);
      }
      if (zzRJ != -1L) {
        localJSONObject.put("interstitial_timeout", zzRJ / 1000.0D);
      }
      if (orientation != zzv.zzcL().zzkq()) {
        break label530;
      }
      localJSONObject.put("orientation", "portrait");
      label159:
      if (zzJY != null) {
        localJSONObject.put("click_urls", zzl(zzJY));
      }
      if (zzJZ != null) {
        localJSONObject.put("impression_urls", zzl(zzJZ));
      }
      if (zzRM != null) {
        localJSONObject.put("manual_impression_urls", zzl(zzRM));
      }
      if (zzRS != null) {
        localJSONObject.put("active_view", zzRS);
      }
      localJSONObject.put("ad_is_javascript", zzRQ);
      if (zzRR != null) {
        localJSONObject.put("ad_passback_url", zzRR);
      }
      localJSONObject.put("mediation", zzRK);
      localJSONObject.put("custom_render_allowed", zzRT);
      localJSONObject.put("content_url_opted_out", zzRU);
      localJSONObject.put("content_vertical_opted_out", zzSh);
      localJSONObject.put("prefetch", zzRV);
      if (zzKe != -1L) {
        localJSONObject.put("refresh_interval_milliseconds", zzKe);
      }
      if (zzRL != -1L) {
        localJSONObject.put("mediation_config_cache_time_milliseconds", zzRL);
      }
      if (!TextUtils.isEmpty(zzRY)) {
        localJSONObject.put("gws_query_id", zzRY);
      }
      if (!zzzo) {
        break label555;
      }
    }
    label530:
    label555:
    for (String str = "height";; str = "")
    {
      localJSONObject.put("fluid", str);
      localJSONObject.put("native_express", zzzp);
      if (zzSa != null) {
        localJSONObject.put("video_start_urls", zzl(zzSa));
      }
      if (zzSb != null) {
        localJSONObject.put("video_complete_urls", zzl(zzSb));
      }
      if (zzRZ != null) {
        localJSONObject.put("rewards", zzRZ.zzjy());
      }
      localJSONObject.put("use_displayed_impression", zzSc);
      localJSONObject.put("auto_protection_configuration", zzSd);
      localJSONObject.put("render_in_browser", zzKc);
      return localJSONObject;
      localJSONObject.put("ad_html", body);
      break;
      if (orientation != zzv.zzcL().zzkp()) {
        break label159;
      }
      localJSONObject.put("orientation", "landscape");
      break label159;
    }
  }
  
  private static Bundle zzg(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("runtime_free", Long.toString(paramBundle.getLong("runtime_free_memory", -1L)));
    localBundle.putString("runtime_max", Long.toString(paramBundle.getLong("runtime_max_memory", -1L)));
    localBundle.putString("runtime_total", Long.toString(paramBundle.getLong("runtime_total_memory", -1L)));
    paramBundle = (Debug.MemoryInfo)paramBundle.getParcelable("debug_memory_info");
    if (paramBundle != null)
    {
      localBundle.putString("debug_info_dalvik_private_dirty", Integer.toString(dalvikPrivateDirty));
      localBundle.putString("debug_info_dalvik_pss", Integer.toString(dalvikPss));
      localBundle.putString("debug_info_dalvik_shared_dirty", Integer.toString(dalvikSharedDirty));
      localBundle.putString("debug_info_native_private_dirty", Integer.toString(nativePrivateDirty));
      localBundle.putString("debug_info_native_pss", Integer.toString(nativePss));
      localBundle.putString("debug_info_native_shared_dirty", Integer.toString(nativeSharedDirty));
      localBundle.putString("debug_info_other_private_dirty", Integer.toString(otherPrivateDirty));
      localBundle.putString("debug_info_other_pss", Integer.toString(otherPss));
      localBundle.putString("debug_info_other_shared_dirty", Integer.toString(otherSharedDirty));
    }
    return localBundle;
  }
  
  @Nullable
  static JSONArray zzl(List<String> paramList)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    return localJSONArray;
  }
}
