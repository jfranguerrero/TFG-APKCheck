package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.zzc;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzbc
{
  private static final String TAG = zzbc.class.getSimpleName();
  protected static final Object zzqC = new Object();
  protected static final Object zzqG = new Object();
  private static zzc zzqI = null;
  private volatile boolean zzpX = false;
  private Future zzqA = null;
  private volatile boolean zzqB = false;
  private zzap zzqD;
  private GoogleApiClient zzqE = null;
  protected boolean zzqF = false;
  protected boolean zzqH = false;
  protected boolean zzqJ = false;
  private Map<Pair<String, String>, zzbx> zzqK;
  protected Context zzqr;
  protected Context zzqs;
  private ExecutorService zzqt;
  private DexClassLoader zzqu;
  private zzax zzqv;
  private byte[] zzqw;
  private volatile AdvertisingIdClient zzqx = null;
  private Future zzqy = null;
  private volatile zzaf.zza zzqz = null;
  
  private zzbc(Context paramContext)
  {
    zzqr = paramContext;
    zzqs = paramContext.getApplicationContext();
    zzqK = new HashMap();
  }
  
  public static zzbc zza(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = new zzbc(paramContext);
    try
    {
      paramContext.zzc(paramString1, paramString2, paramBoolean);
      return paramContext;
    }
    catch (zzaz paramContext) {}
    return null;
  }
  
  @NonNull
  private File zza(String paramString1, File paramFile, String paramString2)
    throws zzax.zza, IOException
  {
    paramFile = new File(String.format("%s/%s.jar", new Object[] { paramFile, paramString2 }));
    if (!paramFile.exists())
    {
      paramString1 = zzqv.zzc(zzqw, paramString1);
      paramFile.createNewFile();
      paramString2 = new FileOutputStream(paramFile);
      paramString2.write(paramString1, 0, paramString1.length);
      paramString2.close();
    }
    return paramFile;
  }
  
  private void zza(File paramFile)
  {
    if (!paramFile.exists())
    {
      Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[] { paramFile.getAbsolutePath() }));
      return;
    }
    paramFile.delete();
  }
  
  /* Error */
  private void zza(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: new 122	java/io/File
    //   9: dup
    //   10: ldc -74
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_2
    //   23: aastore
    //   24: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 9
    //   32: aload 9
    //   34: invokevirtual 137	java/io/File:exists	()Z
    //   37: ifeq +4 -> 41
    //   40: return
    //   41: new 122	java/io/File
    //   44: dup
    //   45: ldc -72
    //   47: iconst_2
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_2
    //   58: aastore
    //   59: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 8
    //   67: aload 8
    //   69: invokevirtual 137	java/io/File:exists	()Z
    //   72: ifeq -32 -> 40
    //   75: aload 8
    //   77: invokevirtual 188	java/io/File:length	()J
    //   80: lstore 4
    //   82: lload 4
    //   84: lconst_0
    //   85: lcmp
    //   86: ifle -46 -> 40
    //   89: lload 4
    //   91: l2i
    //   92: newarray byte
    //   94: astore 10
    //   96: new 190	java/io/FileInputStream
    //   99: dup
    //   100: aload 8
    //   102: invokespecial 191	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore_1
    //   106: aload_1
    //   107: aload 10
    //   109: invokevirtual 195	java/io/FileInputStream:read	([B)I
    //   112: istore_3
    //   113: iload_3
    //   114: ifgt +14 -> 128
    //   117: aload_1
    //   118: invokevirtual 196	java/io/FileInputStream:close	()V
    //   121: aload_0
    //   122: aload 8
    //   124: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   127: return
    //   128: new 200	com/google/android/gms/internal/zzaf$zzd
    //   131: dup
    //   132: invokespecial 201	com/google/android/gms/internal/zzaf$zzd:<init>	()V
    //   135: astore 7
    //   137: aload 7
    //   139: getstatic 206	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   142: invokevirtual 210	java/lang/String:getBytes	()[B
    //   145: putfield 213	com/google/android/gms/internal/zzaf$zzd:zzcw	[B
    //   148: aload 7
    //   150: aload_2
    //   151: invokevirtual 210	java/lang/String:getBytes	()[B
    //   154: putfield 216	com/google/android/gms/internal/zzaf$zzd:zzcv	[B
    //   157: aload_0
    //   158: getfield 139	com/google/android/gms/internal/zzbc:zzqv	Lcom/google/android/gms/internal/zzax;
    //   161: aload_0
    //   162: getfield 141	com/google/android/gms/internal/zzbc:zzqw	[B
    //   165: aload 10
    //   167: invokevirtual 220	com/google/android/gms/internal/zzax:zzd	([B[B)Ljava/lang/String;
    //   170: invokevirtual 210	java/lang/String:getBytes	()[B
    //   173: astore_2
    //   174: aload 7
    //   176: aload_2
    //   177: putfield 223	com/google/android/gms/internal/zzaf$zzd:data	[B
    //   180: aload 7
    //   182: aload_2
    //   183: invokestatic 229	com/google/android/gms/internal/zzan:zzh	([B)[B
    //   186: putfield 232	com/google/android/gms/internal/zzaf$zzd:zzcu	[B
    //   189: aload 9
    //   191: invokevirtual 149	java/io/File:createNewFile	()Z
    //   194: pop
    //   195: new 151	java/io/FileOutputStream
    //   198: dup
    //   199: aload 9
    //   201: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   204: astore_2
    //   205: aload 7
    //   207: invokestatic 238	com/google/android/gms/internal/zzbut:zzf	(Lcom/google/android/gms/internal/zzbut;)[B
    //   210: astore 6
    //   212: aload_2
    //   213: aload 6
    //   215: iconst_0
    //   216: aload 6
    //   218: arraylength
    //   219: invokevirtual 158	java/io/FileOutputStream:write	([BII)V
    //   222: aload_2
    //   223: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   226: aload_1
    //   227: invokevirtual 196	java/io/FileInputStream:close	()V
    //   230: aload_2
    //   231: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   234: aload_0
    //   235: aload 8
    //   237: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   240: return
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_1
    //   244: aload 7
    //   246: astore_2
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 196	java/io/FileInputStream:close	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   263: aload_0
    //   264: aload 8
    //   266: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   269: return
    //   270: astore_2
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +7 -> 281
    //   277: aload_1
    //   278: invokevirtual 196	java/io/FileInputStream:close	()V
    //   281: aload 6
    //   283: ifnull +8 -> 291
    //   286: aload 6
    //   288: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   291: aload_0
    //   292: aload 8
    //   294: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   297: aload_2
    //   298: athrow
    //   299: astore_1
    //   300: goto -179 -> 121
    //   303: astore_1
    //   304: goto -74 -> 230
    //   307: astore_1
    //   308: goto -74 -> 234
    //   311: astore_2
    //   312: goto -57 -> 255
    //   315: astore_1
    //   316: goto -53 -> 263
    //   319: astore_1
    //   320: goto -39 -> 281
    //   323: astore_1
    //   324: goto -33 -> 291
    //   327: astore_2
    //   328: goto -55 -> 273
    //   331: astore 7
    //   333: aload_2
    //   334: astore 6
    //   336: aload 7
    //   338: astore_2
    //   339: goto -66 -> 273
    //   342: astore_2
    //   343: aconst_null
    //   344: astore 6
    //   346: aload_1
    //   347: astore_2
    //   348: aload 6
    //   350: astore_1
    //   351: goto -104 -> 247
    //   354: astore 6
    //   356: aload_1
    //   357: astore 6
    //   359: aload_2
    //   360: astore_1
    //   361: aload 6
    //   363: astore_2
    //   364: goto -117 -> 247
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_1
    //   370: aload 7
    //   372: astore_2
    //   373: goto -126 -> 247
    //   376: astore_2
    //   377: aconst_null
    //   378: astore 6
    //   380: aload_1
    //   381: astore_2
    //   382: aload 6
    //   384: astore_1
    //   385: goto -138 -> 247
    //   388: astore 6
    //   390: aload_1
    //   391: astore 6
    //   393: aload_2
    //   394: astore_1
    //   395: aload 6
    //   397: astore_2
    //   398: goto -151 -> 247
    //   401: astore_1
    //   402: aconst_null
    //   403: astore_1
    //   404: aload 7
    //   406: astore_2
    //   407: goto -160 -> 247
    //   410: astore_2
    //   411: aconst_null
    //   412: astore 6
    //   414: aload_1
    //   415: astore_2
    //   416: aload 6
    //   418: astore_1
    //   419: goto -172 -> 247
    //   422: astore 6
    //   424: aload_1
    //   425: astore 6
    //   427: aload_2
    //   428: astore_1
    //   429: aload 6
    //   431: astore_2
    //   432: goto -185 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	zzbc
    //   0	435	1	paramFile	File
    //   0	435	2	paramString	String
    //   112	2	3	i	int
    //   80	10	4	l	long
    //   1	348	6	localObject1	Object
    //   354	1	6	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   357	26	6	localFile1	File
    //   388	1	6	localZza	zzax.zza
    //   391	26	6	localFile2	File
    //   422	1	6	localIOException	IOException
    //   425	5	6	localFile3	File
    //   4	241	7	localZzd	zzaf.zzd
    //   331	74	7	localObject2	Object
    //   65	228	8	localFile4	File
    //   30	170	9	localFile5	File
    //   94	72	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   96	106	241	java/security/NoSuchAlgorithmException
    //   96	106	270	finally
    //   117	121	299	java/io/IOException
    //   226	230	303	java/io/IOException
    //   230	234	307	java/io/IOException
    //   251	255	311	java/io/IOException
    //   259	263	315	java/io/IOException
    //   277	281	319	java/io/IOException
    //   286	291	323	java/io/IOException
    //   106	113	327	finally
    //   128	205	327	finally
    //   205	226	331	finally
    //   106	113	342	java/security/NoSuchAlgorithmException
    //   128	205	342	java/security/NoSuchAlgorithmException
    //   205	226	354	java/security/NoSuchAlgorithmException
    //   96	106	367	com/google/android/gms/internal/zzax$zza
    //   106	113	376	com/google/android/gms/internal/zzax$zza
    //   128	205	376	com/google/android/gms/internal/zzax$zza
    //   205	226	388	com/google/android/gms/internal/zzax$zza
    //   96	106	401	java/io/IOException
    //   106	113	410	java/io/IOException
    //   128	205	410	java/io/IOException
    //   205	226	422	java/io/IOException
  }
  
  private void zzaU()
  {
    try
    {
      if ((zzqx == null) && (zzqs != null))
      {
        AdvertisingIdClient localAdvertisingIdClient = new AdvertisingIdClient(zzqs);
        localAdvertisingIdClient.start();
        zzqx = localAdvertisingIdClient;
      }
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      zzqx = null;
      return;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;) {}
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  private void zzaV()
  {
    if (!((Boolean)zzfx.zzDD.get()).booleanValue()) {
      return;
    }
    zzaW();
  }
  
  private void zzaX()
  {
    if (zzqH) {}
    try
    {
      PackageInfo localPackageInfo = zzqr.getPackageManager().getPackageInfo(zzqr.getPackageName(), 0);
      zzqz = zzapt.zzi(zzqr, zzqr.getPackageName(), Integer.toString(versionCode));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  private void zzaY()
  {
    boolean bool2 = true;
    zzqt.execute(new Runnable()
    {
      public void run()
      {
        zzfx.initialize(zzqr);
      }
    });
    zzqI = zzc.zzuz();
    if (zzqI.zzak(zzqr) > 0)
    {
      bool1 = true;
      zzqF = bool1;
      if (zzqI.isGooglePlayServicesAvailable(zzqr) != 0) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzqH = bool1;
      if (zzqr.getApplicationContext() != null) {
        zzqE = new GoogleApiClient.Builder(zzqr).addApi(zzzf.API).build();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  /* Error */
  private boolean zzb(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 122	java/io/File
    //   9: dup
    //   10: ldc -74
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_2
    //   23: aastore
    //   24: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 7
    //   32: aload 7
    //   34: invokevirtual 137	java/io/File:exists	()Z
    //   37: ifne +5 -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: new 122	java/io/File
    //   45: dup
    //   46: ldc -72
    //   48: iconst_2
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_2
    //   59: aastore
    //   60: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   63: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 8
    //   68: aload 8
    //   70: invokevirtual 137	java/io/File:exists	()Z
    //   73: ifeq +5 -> 78
    //   76: iconst_0
    //   77: ireturn
    //   78: aload 7
    //   80: invokevirtual 188	java/io/File:length	()J
    //   83: lstore_3
    //   84: lload_3
    //   85: lconst_0
    //   86: lcmp
    //   87: ifgt +11 -> 98
    //   90: aload_0
    //   91: aload 7
    //   93: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   96: iconst_0
    //   97: ireturn
    //   98: lload_3
    //   99: l2i
    //   100: newarray byte
    //   102: astore 9
    //   104: new 190	java/io/FileInputStream
    //   107: dup
    //   108: aload 7
    //   110: invokespecial 191	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: astore_1
    //   114: aload_1
    //   115: aload 9
    //   117: invokevirtual 195	java/io/FileInputStream:read	([B)I
    //   120: ifgt +25 -> 145
    //   123: getstatic 58	com/google/android/gms/internal/zzbc:TAG	Ljava/lang/String;
    //   126: ldc_w 353
    //   129: invokestatic 174	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload_0
    //   134: aload 7
    //   136: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   139: aload_1
    //   140: invokevirtual 196	java/io/FileInputStream:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: aload 9
    //   147: invokestatic 357	com/google/android/gms/internal/zzaf$zzd:zze	([B)Lcom/google/android/gms/internal/zzaf$zzd;
    //   150: astore 6
    //   152: aload_2
    //   153: new 126	java/lang/String
    //   156: dup
    //   157: aload 6
    //   159: getfield 216	com/google/android/gms/internal/zzaf$zzd:zzcv	[B
    //   162: invokespecial 360	java/lang/String:<init>	([B)V
    //   165: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +39 -> 207
    //   171: aload 6
    //   173: getfield 232	com/google/android/gms/internal/zzaf$zzd:zzcu	[B
    //   176: aload 6
    //   178: getfield 223	com/google/android/gms/internal/zzaf$zzd:data	[B
    //   181: invokestatic 229	com/google/android/gms/internal/zzan:zzh	([B)[B
    //   184: invokestatic 369	java/util/Arrays:equals	([B[B)Z
    //   187: ifeq +20 -> 207
    //   190: aload 6
    //   192: getfield 213	com/google/android/gms/internal/zzaf$zzd:zzcw	[B
    //   195: getstatic 206	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   198: invokevirtual 210	java/lang/String:getBytes	()[B
    //   201: invokestatic 369	java/util/Arrays:equals	([B[B)Z
    //   204: ifne +15 -> 219
    //   207: aload_0
    //   208: aload 7
    //   210: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   213: aload_1
    //   214: invokevirtual 196	java/io/FileInputStream:close	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: aload_0
    //   220: getfield 139	com/google/android/gms/internal/zzbc:zzqv	Lcom/google/android/gms/internal/zzax;
    //   223: aload_0
    //   224: getfield 141	com/google/android/gms/internal/zzbc:zzqw	[B
    //   227: new 126	java/lang/String
    //   230: dup
    //   231: aload 6
    //   233: getfield 223	com/google/android/gms/internal/zzaf$zzd:data	[B
    //   236: invokespecial 360	java/lang/String:<init>	([B)V
    //   239: invokevirtual 146	com/google/android/gms/internal/zzax:zzc	([BLjava/lang/String;)[B
    //   242: astore 6
    //   244: aload 8
    //   246: invokevirtual 149	java/io/File:createNewFile	()Z
    //   249: pop
    //   250: new 151	java/io/FileOutputStream
    //   253: dup
    //   254: aload 8
    //   256: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   259: astore_2
    //   260: aload_2
    //   261: aload 6
    //   263: iconst_0
    //   264: aload 6
    //   266: arraylength
    //   267: invokevirtual 158	java/io/FileOutputStream:write	([BII)V
    //   270: aload_1
    //   271: invokevirtual 196	java/io/FileInputStream:close	()V
    //   274: aload_2
    //   275: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   278: iconst_1
    //   279: ireturn
    //   280: astore_1
    //   281: iconst_1
    //   282: ireturn
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_1
    //   286: aload 6
    //   288: astore_2
    //   289: aload_2
    //   290: ifnull +7 -> 297
    //   293: aload_2
    //   294: invokevirtual 196	java/io/FileInputStream:close	()V
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   305: iconst_0
    //   306: ireturn
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 196	java/io/FileInputStream:close	()V
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   328: aload_2
    //   329: athrow
    //   330: astore_1
    //   331: goto -188 -> 143
    //   334: astore_1
    //   335: goto -118 -> 217
    //   338: astore_1
    //   339: goto -65 -> 274
    //   342: astore_2
    //   343: goto -46 -> 297
    //   346: astore_1
    //   347: goto -42 -> 305
    //   350: astore_1
    //   351: goto -33 -> 318
    //   354: astore_1
    //   355: goto -27 -> 328
    //   358: astore_2
    //   359: goto -49 -> 310
    //   362: astore 6
    //   364: aload_2
    //   365: astore 5
    //   367: aload 6
    //   369: astore_2
    //   370: goto -60 -> 310
    //   373: astore_2
    //   374: aconst_null
    //   375: astore 5
    //   377: aload_1
    //   378: astore_2
    //   379: aload 5
    //   381: astore_1
    //   382: goto -93 -> 289
    //   385: astore 5
    //   387: aload_1
    //   388: astore 5
    //   390: aload_2
    //   391: astore_1
    //   392: aload 5
    //   394: astore_2
    //   395: goto -106 -> 289
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_1
    //   401: aload 6
    //   403: astore_2
    //   404: goto -115 -> 289
    //   407: astore_2
    //   408: aconst_null
    //   409: astore 5
    //   411: aload_1
    //   412: astore_2
    //   413: aload 5
    //   415: astore_1
    //   416: goto -127 -> 289
    //   419: astore 5
    //   421: aload_1
    //   422: astore 5
    //   424: aload_2
    //   425: astore_1
    //   426: aload 5
    //   428: astore_2
    //   429: goto -140 -> 289
    //   432: astore_1
    //   433: aconst_null
    //   434: astore_1
    //   435: aload 6
    //   437: astore_2
    //   438: goto -149 -> 289
    //   441: astore_2
    //   442: aconst_null
    //   443: astore 5
    //   445: aload_1
    //   446: astore_2
    //   447: aload 5
    //   449: astore_1
    //   450: goto -161 -> 289
    //   453: astore 5
    //   455: aload_1
    //   456: astore 5
    //   458: aload_2
    //   459: astore_1
    //   460: aload 5
    //   462: astore_2
    //   463: goto -174 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	zzbc
    //   0	466	1	paramFile	File
    //   0	466	2	paramString	String
    //   83	16	3	l	long
    //   1	379	5	str	String
    //   385	1	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   388	26	5	localFile1	File
    //   419	1	5	localZza	zzax.zza
    //   422	26	5	localFile2	File
    //   453	1	5	localIOException	IOException
    //   456	5	5	localFile3	File
    //   4	283	6	localObject1	Object
    //   362	74	6	localObject2	Object
    //   30	179	7	localFile4	File
    //   66	189	8	localFile5	File
    //   102	44	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   274	278	280	java/io/IOException
    //   78	84	283	java/security/NoSuchAlgorithmException
    //   90	96	283	java/security/NoSuchAlgorithmException
    //   98	114	283	java/security/NoSuchAlgorithmException
    //   78	84	307	finally
    //   90	96	307	finally
    //   98	114	307	finally
    //   139	143	330	java/io/IOException
    //   213	217	334	java/io/IOException
    //   270	274	338	java/io/IOException
    //   293	297	342	java/io/IOException
    //   301	305	346	java/io/IOException
    //   314	318	350	java/io/IOException
    //   323	328	354	java/io/IOException
    //   114	139	358	finally
    //   145	207	358	finally
    //   207	213	358	finally
    //   219	260	358	finally
    //   260	270	362	finally
    //   114	139	373	java/security/NoSuchAlgorithmException
    //   145	207	373	java/security/NoSuchAlgorithmException
    //   207	213	373	java/security/NoSuchAlgorithmException
    //   219	260	373	java/security/NoSuchAlgorithmException
    //   260	270	385	java/security/NoSuchAlgorithmException
    //   78	84	398	com/google/android/gms/internal/zzax$zza
    //   90	96	398	com/google/android/gms/internal/zzax$zza
    //   98	114	398	com/google/android/gms/internal/zzax$zza
    //   114	139	407	com/google/android/gms/internal/zzax$zza
    //   145	207	407	com/google/android/gms/internal/zzax$zza
    //   207	213	407	com/google/android/gms/internal/zzax$zza
    //   219	260	407	com/google/android/gms/internal/zzax$zza
    //   260	270	419	com/google/android/gms/internal/zzax$zza
    //   78	84	432	java/io/IOException
    //   90	96	432	java/io/IOException
    //   98	114	432	java/io/IOException
    //   114	139	441	java/io/IOException
    //   145	207	441	java/io/IOException
    //   207	213	441	java/io/IOException
    //   219	260	441	java/io/IOException
    //   260	270	453	java/io/IOException
  }
  
  private void zzc(boolean paramBoolean)
  {
    zzpX = paramBoolean;
    if (!paramBoolean) {
      return;
    }
    zzqy = zzqt.submit(new Runnable()
    {
      public void run()
      {
        zzbc.zzb(zzbc.this);
      }
    });
  }
  
  private boolean zzc(String paramString1, String paramString2, boolean paramBoolean)
    throws zzaz
  {
    zzqt = Executors.newCachedThreadPool();
    zzc(paramBoolean);
    zzaY();
    zzaV();
    if ((zzbe.zzbd()) && (((Boolean)zzfx.zzDB.get()).booleanValue())) {
      throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
    }
    zzo(paramString1);
    zzp(paramString2);
    zzqD = new zzap(this);
    return true;
  }
  
  private void zzo(String paramString)
    throws zzaz
  {
    zzqv = new zzax(null);
    try
    {
      zzqw = zzqv.zzn(paramString);
      return;
    }
    catch (zzax.zza paramString)
    {
      throw new zzaz(paramString);
    }
  }
  
  /* Error */
  private boolean zzp(String paramString)
    throws zzaz
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/google/android/gms/internal/zzbc:zzqr	Landroid/content/Context;
    //   4: invokevirtual 432	android/content/Context:getCacheDir	()Ljava/io/File;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ifnonnull +39 -> 50
    //   14: aload_0
    //   15: getfield 91	com/google/android/gms/internal/zzbc:zzqr	Landroid/content/Context;
    //   18: ldc_w 434
    //   21: iconst_0
    //   22: invokevirtual 438	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: ifnonnull +21 -> 50
    //   32: new 108	com/google/android/gms/internal/zzaz
    //   35: dup
    //   36: invokespecial 439	com/google/android/gms/internal/zzaz:<init>	()V
    //   39: athrow
    //   40: astore_1
    //   41: new 108	com/google/android/gms/internal/zzaz
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 424	com/google/android/gms/internal/zzaz:<init>	(Ljava/lang/Throwable;)V
    //   49: athrow
    //   50: invokestatic 444	com/google/android/gms/internal/zzay:zzX	()Ljava/lang/String;
    //   53: astore_3
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: aload_3
    //   58: invokespecial 446	com/google/android/gms/internal/zzbc:zza	(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   61: astore_1
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: invokespecial 448	com/google/android/gms/internal/zzbc:zzb	(Ljava/io/File;Ljava/lang/String;)Z
    //   68: pop
    //   69: aload_0
    //   70: new 450	dalvik/system/DexClassLoader
    //   73: dup
    //   74: aload_1
    //   75: invokevirtual 168	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: aload_2
    //   79: invokevirtual 168	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: aconst_null
    //   83: aload_0
    //   84: getfield 91	com/google/android/gms/internal/zzbc:zzqr	Landroid/content/Context;
    //   87: invokevirtual 454	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   90: invokespecial 457	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   93: putfield 459	com/google/android/gms/internal/zzbc:zzqu	Ldalvik/system/DexClassLoader;
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   101: aload_0
    //   102: aload_2
    //   103: aload_3
    //   104: invokespecial 461	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;Ljava/lang/String;)V
    //   107: aload_0
    //   108: ldc -72
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_3
    //   121: aastore
    //   122: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokespecial 464	com/google/android/gms/internal/zzbc:zzq	(Ljava/lang/String;)V
    //   128: iconst_1
    //   129: ireturn
    //   130: astore 4
    //   132: aload_0
    //   133: aload_1
    //   134: invokespecial 198	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;)V
    //   137: aload_0
    //   138: aload_2
    //   139: aload_3
    //   140: invokespecial 461	com/google/android/gms/internal/zzbc:zza	(Ljava/io/File;Ljava/lang/String;)V
    //   143: aload_0
    //   144: ldc -72
    //   146: iconst_2
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_2
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload_3
    //   157: aastore
    //   158: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokespecial 464	com/google/android/gms/internal/zzbc:zzq	(Ljava/lang/String;)V
    //   164: aload 4
    //   166: athrow
    //   167: astore_1
    //   168: new 108	com/google/android/gms/internal/zzaz
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 424	com/google/android/gms/internal/zzaz:<init>	(Ljava/lang/Throwable;)V
    //   176: athrow
    //   177: astore_1
    //   178: new 108	com/google/android/gms/internal/zzaz
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 424	com/google/android/gms/internal/zzaz:<init>	(Ljava/lang/Throwable;)V
    //   186: athrow
    //   187: astore_1
    //   188: new 108	com/google/android/gms/internal/zzaz
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 424	com/google/android/gms/internal/zzaz:<init>	(Ljava/lang/Throwable;)V
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	zzbc
    //   0	197	1	paramString	String
    //   9	144	2	localObject1	Object
    //   7	150	3	localObject2	Object
    //   130	35	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	40	java/io/FileNotFoundException
    //   14	26	40	java/io/FileNotFoundException
    //   32	40	40	java/io/FileNotFoundException
    //   50	69	40	java/io/FileNotFoundException
    //   96	128	40	java/io/FileNotFoundException
    //   132	167	40	java/io/FileNotFoundException
    //   69	96	130	finally
    //   0	8	167	java/io/IOException
    //   14	26	167	java/io/IOException
    //   32	40	167	java/io/IOException
    //   50	69	167	java/io/IOException
    //   96	128	167	java/io/IOException
    //   132	167	167	java/io/IOException
    //   0	8	177	com/google/android/gms/internal/zzax$zza
    //   14	26	177	com/google/android/gms/internal/zzax$zza
    //   32	40	177	com/google/android/gms/internal/zzax$zza
    //   50	69	177	com/google/android/gms/internal/zzax$zza
    //   96	128	177	com/google/android/gms/internal/zzax$zza
    //   132	167	177	com/google/android/gms/internal/zzax$zza
    //   0	8	187	java/lang/NullPointerException
    //   14	26	187	java/lang/NullPointerException
    //   32	40	187	java/lang/NullPointerException
    //   50	69	187	java/lang/NullPointerException
    //   96	128	187	java/lang/NullPointerException
    //   132	167	187	java/lang/NullPointerException
  }
  
  private void zzq(String paramString)
  {
    zza(new File(paramString));
  }
  
  public Context getApplicationContext()
  {
    return zzqs;
  }
  
  public Context getContext()
  {
    return zzqr;
  }
  
  public int zzT()
  {
    int i = Integer.MIN_VALUE;
    zzap localZzap = zzaQ();
    if (localZzap != null) {
      i = localZzap.zzT();
    }
    return i;
  }
  
  public boolean zza(String paramString1, String paramString2, List<Class> paramList)
  {
    if (!zzqK.containsKey(new Pair(paramString1, paramString2)))
    {
      zzqK.put(new Pair(paramString1, paramString2), new zzbx(this, paramString1, paramString2, paramList));
      return true;
    }
    return false;
  }
  
  public ExecutorService zzaJ()
  {
    return zzqt;
  }
  
  public DexClassLoader zzaK()
  {
    return zzqu;
  }
  
  public zzax zzaL()
  {
    return zzqv;
  }
  
  public byte[] zzaM()
  {
    return zzqw;
  }
  
  public GoogleApiClient zzaN()
  {
    return zzqE;
  }
  
  public boolean zzaO()
  {
    return zzqF;
  }
  
  public boolean zzaP()
  {
    return zzqJ;
  }
  
  public zzap zzaQ()
  {
    return zzqD;
  }
  
  public boolean zzaR()
  {
    return zzqH;
  }
  
  public zzaf.zza zzaS()
  {
    return zzqz;
  }
  
  public Future zzaT()
  {
    return zzqA;
  }
  
  public void zzaW()
  {
    synchronized (zzqC)
    {
      if (!zzqB)
      {
        zzqA = zzqt.submit(new Runnable()
        {
          public void run()
          {
            zzbc.zzc(zzbc.this);
            synchronized (zzbc.zzqC)
            {
              zzbc.zza(zzbc.this, false);
              return;
            }
          }
        });
        zzqB = true;
      }
      return;
    }
  }
  
  public AdvertisingIdClient zzaZ()
  {
    if (!zzpX) {
      return null;
    }
    if (zzqx != null) {
      return zzqx;
    }
    if (zzqy != null) {}
    try
    {
      zzqy.get(2000L, TimeUnit.MILLISECONDS);
      zzqy = null;
      return zzqx;
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzqy.cancel(true);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void zzba()
  {
    for (;;)
    {
      synchronized (zzqG)
      {
        if (zzqJ) {
          return;
        }
        if ((zzqH) && (zzqE != null))
        {
          zzqE.connect();
          zzqJ = true;
          return;
        }
      }
      zzqJ = false;
    }
  }
  
  public void zzbb()
  {
    synchronized (zzqG)
    {
      if ((zzqJ) && (zzqE != null))
      {
        zzqE.disconnect();
        zzqJ = false;
      }
      return;
    }
  }
  
  public Method zzc(String paramString1, String paramString2)
  {
    paramString1 = (zzbx)zzqK.get(new Pair(paramString1, paramString2));
    if (paramString1 == null) {
      return null;
    }
    return paramString1.zzbn();
  }
}
