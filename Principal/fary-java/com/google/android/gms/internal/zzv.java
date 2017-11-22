package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzv
  implements zzb
{
  private final Map<String, zza> zzav = new LinkedHashMap(16, 0.75F, true);
  private long zzaw = 0L;
  private final File zzax;
  private final int zzay;
  
  public zzv(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public zzv(File paramFile, int paramInt)
  {
    zzax = paramFile;
    zzay = paramInt;
  }
  
  private void removeEntry(String paramString)
  {
    zza localZza = (zza)zzav.get(paramString);
    if (localZza != null)
    {
      zzaw -= zzaz;
      zzav.remove(paramString);
    }
  }
  
  private static int zza(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  static void zza(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void zza(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void zza(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    zza(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void zza(String paramString, zza paramZza)
  {
    if (!zzav.containsKey(paramString)) {}
    zza localZza;
    long l;
    for (zzaw += zzaz;; zzaw = (zzaz - zzaz + l))
    {
      zzav.put(paramString, paramZza);
      return;
      localZza = (zza)zzav.get(paramString);
      l = zzaw;
    }
  }
  
  static void zza(Map<String, String> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramMap != null)
    {
      zza(paramOutputStream, paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        zza(paramOutputStream, (String)localEntry.getKey());
        zza(paramOutputStream, (String)localEntry.getValue());
      }
    }
    zza(paramOutputStream, 0);
  }
  
  private static byte[] zza(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new IOException(50 + "Expected " + paramInt + " bytes, read " + i + " bytes");
    }
    return arrayOfByte;
  }
  
  static int zzb(InputStream paramInputStream)
    throws IOException
  {
    return zza(paramInputStream) << 0 | 0x0 | zza(paramInputStream) << 8 | zza(paramInputStream) << 16 | zza(paramInputStream) << 24;
  }
  
  static long zzc(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (zza(paramInputStream) & 0xFF) << 0 | (zza(paramInputStream) & 0xFF) << 8 | (zza(paramInputStream) & 0xFF) << 16 | (zza(paramInputStream) & 0xFF) << 24 | (zza(paramInputStream) & 0xFF) << 32 | (zza(paramInputStream) & 0xFF) << 40 | (zza(paramInputStream) & 0xFF) << 48 | (zza(paramInputStream) & 0xFF) << 56;
  }
  
  private void zzc(int paramInt)
  {
    if (zzaw + paramInt < zzay) {}
    label119:
    label229:
    label233:
    for (;;)
    {
      return;
      if (zzs.DEBUG) {
        zzs.zza("Pruning old cache entries.", new Object[0]);
      }
      long l1 = zzaw;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = zzav.entrySet().iterator();
      int i = 0;
      zza localZza;
      if (localIterator.hasNext())
      {
        localZza = (zza)((Map.Entry)localIterator.next()).getValue();
        if (zzf(zzaA).delete())
        {
          zzaw -= zzaz;
          localIterator.remove();
          i += 1;
          if ((float)(zzaw + paramInt) >= zzay * 0.9F) {
            break label229;
          }
        }
      }
      for (;;)
      {
        if (!zzs.DEBUG) {
          break label233;
        }
        zzs.zza("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(zzaw - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        return;
        zzs.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { zzaA, zze(zzaA) });
        break label119;
        break;
      }
    }
  }
  
  static String zzd(InputStream paramInputStream)
    throws IOException
  {
    return new String(zza(paramInputStream, (int)zzc(paramInputStream)), "UTF-8");
  }
  
  private String zze(String paramString)
  {
    int i = paramString.length() / 2;
    String str = String.valueOf(String.valueOf(paramString.substring(0, i).hashCode()));
    paramString = String.valueOf(String.valueOf(paramString.substring(i).hashCode()));
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  static Map<String, String> zze(InputStream paramInputStream)
    throws IOException
  {
    int j = zzb(paramInputStream);
    if (j == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(j))
    {
      int i = 0;
      while (i < j)
      {
        ((Map)localObject).put(zzd(paramInputStream).intern(), zzd(paramInputStream).intern());
        i += 1;
      }
    }
    return localObject;
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/google/android/gms/internal/zzv:zzax	Ljava/io/File;
    //   6: invokevirtual 283	java/io/File:exists	()Z
    //   9: ifne +36 -> 45
    //   12: aload_0
    //   13: getfield 45	com/google/android/gms/internal/zzv:zzax	Ljava/io/File;
    //   16: invokevirtual 286	java/io/File:mkdirs	()Z
    //   19: ifne +23 -> 42
    //   22: ldc_w 288
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 45	com/google/android/gms/internal/zzv:zzax	Ljava/io/File;
    //   35: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: invokestatic 293	com/google/android/gms/internal/zzs:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 45	com/google/android/gms/internal/zzv:zzax	Ljava/io/File;
    //   49: invokevirtual 297	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull -14 -> 42
    //   59: aload 5
    //   61: arraylength
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -25 -> 42
    //   70: aload 5
    //   72: iload_1
    //   73: aaload
    //   74: astore 6
    //   76: aconst_null
    //   77: astore_3
    //   78: new 299	java/io/BufferedInputStream
    //   81: dup
    //   82: new 301	java/io/FileInputStream
    //   85: dup
    //   86: aload 6
    //   88: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 306	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: invokestatic 309	com/google/android/gms/internal/zzv$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzv$zza;
    //   104: astore 7
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: aload 6
    //   113: invokevirtual 311	java/io/File:length	()J
    //   116: putfield 58	com/google/android/gms/internal/zzv$zza:zzaz	J
    //   119: aload 4
    //   121: astore_3
    //   122: aload_0
    //   123: aload 7
    //   125: getfield 197	com/google/android/gms/internal/zzv$zza:zzaA	Ljava/lang/String;
    //   128: aload 7
    //   130: invokespecial 313	com/google/android/gms/internal/zzv:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzv$zza;)V
    //   133: aload 4
    //   135: invokevirtual 316	java/io/BufferedInputStream:close	()V
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore_1
    //   142: goto -77 -> 65
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload 6
    //   151: ifnull +12 -> 163
    //   154: aload 4
    //   156: astore_3
    //   157: aload 6
    //   159: invokevirtual 206	java/io/File:delete	()Z
    //   162: pop
    //   163: aload 4
    //   165: ifnull -27 -> 138
    //   168: aload 4
    //   170: invokevirtual 316	java/io/BufferedInputStream:close	()V
    //   173: goto -35 -> 138
    //   176: astore_3
    //   177: goto -39 -> 138
    //   180: astore 5
    //   182: aload_3
    //   183: astore 4
    //   185: aload 5
    //   187: astore_3
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 316	java/io/BufferedInputStream:close	()V
    //   198: aload_3
    //   199: athrow
    //   200: astore_3
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_3
    //   204: athrow
    //   205: astore_3
    //   206: goto -68 -> 138
    //   209: astore 4
    //   211: goto -13 -> 198
    //   214: astore 5
    //   216: aload_3
    //   217: astore 4
    //   219: aload 5
    //   221: astore_3
    //   222: goto -34 -> 188
    //   225: astore_3
    //   226: goto -77 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	zzv
    //   64	78	1	i	int
    //   62	6	2	j	int
    //   77	45	3	localObject1	Object
    //   145	1	3	localIOException1	IOException
    //   156	1	3	localObject2	Object
    //   176	7	3	localIOException2	IOException
    //   187	12	3	localObject3	Object
    //   200	4	3	localObject4	Object
    //   205	12	3	localIOException3	IOException
    //   221	1	3	localObject5	Object
    //   225	1	3	localIOException4	IOException
    //   94	100	4	localObject6	Object
    //   209	1	4	localIOException5	IOException
    //   217	1	4	localIOException6	IOException
    //   52	19	5	arrayOfFile	File[]
    //   180	6	5	localObject7	Object
    //   214	6	5	localObject8	Object
    //   74	84	6	localFile	File
    //   104	25	7	localZza	zza
    // Exception table:
    //   from	to	target	type
    //   78	96	145	java/io/IOException
    //   168	173	176	java/io/IOException
    //   78	96	180	finally
    //   2	42	200	finally
    //   45	54	200	finally
    //   59	63	200	finally
    //   133	138	200	finally
    //   168	173	200	finally
    //   193	198	200	finally
    //   198	200	200	finally
    //   133	138	205	java/io/IOException
    //   193	198	209	java/io/IOException
    //   99	106	214	finally
    //   109	119	214	finally
    //   122	133	214	finally
    //   157	163	214	finally
    //   99	106	225	java/io/IOException
    //   109	119	225	java/io/IOException
    //   122	133	225	java/io/IOException
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = zzf(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        zzs.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, zze(paramString) });
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public zzb.zza zza(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/google/android/gms/internal/zzv:zzav	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 55 2 0
    //   12: checkcast 10	com/google/android/gms/internal/zzv$zza
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 201	com/google/android/gms/internal/zzv:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 5
    //   35: new 13	com/google/android/gms/internal/zzv$zzb
    //   38: dup
    //   39: new 301	java/io/FileInputStream
    //   42: dup
    //   43: aload 5
    //   45: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: aconst_null
    //   49: invokespecial 322	com/google/android/gms/internal/zzv$zzb:<init>	(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzv$1;)V
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: invokestatic 309	com/google/android/gms/internal/zzv$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzv$zza;
    //   59: pop
    //   60: aload_3
    //   61: astore_2
    //   62: aload 4
    //   64: aload_3
    //   65: aload 5
    //   67: invokevirtual 311	java/io/File:length	()J
    //   70: aload_3
    //   71: invokestatic 325	com/google/android/gms/internal/zzv$zzb:zza	(Lcom/google/android/gms/internal/zzv$zzb;)I
    //   74: i2l
    //   75: lsub
    //   76: l2i
    //   77: invokestatic 236	com/google/android/gms/internal/zzv:zza	(Ljava/io/InputStream;I)[B
    //   80: invokevirtual 328	com/google/android/gms/internal/zzv$zza:zzb	([B)Lcom/google/android/gms/internal/zzb$zza;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual 329	com/google/android/gms/internal/zzv$zzb:close	()V
    //   92: goto -68 -> 24
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_1
    //   98: goto -74 -> 24
    //   101: astore 4
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_3
    //   106: astore_2
    //   107: ldc_w 331
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload 5
    //   118: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload 4
    //   126: invokevirtual 332	java/io/IOException:toString	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 230	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload_3
    //   134: astore_2
    //   135: aload_0
    //   136: aload_1
    //   137: invokevirtual 334	com/google/android/gms/internal/zzv:remove	(Ljava/lang/String;)V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 329	com/google/android/gms/internal/zzv$zzb:close	()V
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -126 -> 24
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -132 -> 24
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 329	com/google/android/gms/internal/zzv$zzb:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -156 -> 24
    //   183: astore_1
    //   184: goto -22 -> 162
    //   187: astore 4
    //   189: goto -84 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	zzv
    //   0	192	1	paramString	String
    //   54	113	2	localZzb1	zzb
    //   52	93	3	localZzb2	zzb
    //   15	71	4	localObject	Object
    //   101	24	4	localIOException1	IOException
    //   187	1	4	localIOException2	IOException
    //   33	84	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   88	92	95	java/io/IOException
    //   35	53	101	java/io/IOException
    //   144	148	153	java/io/IOException
    //   35	53	159	finally
    //   2	17	172	finally
    //   28	35	172	finally
    //   88	92	172	finally
    //   144	148	172	finally
    //   166	170	172	finally
    //   170	172	172	finally
    //   166	170	177	java/io/IOException
    //   55	60	183	finally
    //   62	85	183	finally
    //   107	133	183	finally
    //   135	140	183	finally
    //   55	60	187	java/io/IOException
    //   62	85	187	java/io/IOException
  }
  
  /* Error */
  public void zza(String paramString, zzb.zza paramZza)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 341	com/google/android/gms/internal/zzb$zza:data	[B
    //   7: arraylength
    //   8: invokespecial 343	com/google/android/gms/internal/zzv:zzc	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 201	com/google/android/gms/internal/zzv:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: new 345	java/io/FileOutputStream
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 346	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: new 10	com/google/android/gms/internal/zzv$zza
    //   30: dup
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 348	com/google/android/gms/internal/zzv$zza:<init>	(Ljava/lang/String;Lcom/google/android/gms/internal/zzb$zza;)V
    //   36: astore 5
    //   38: aload 5
    //   40: aload 4
    //   42: invokevirtual 351	com/google/android/gms/internal/zzv$zza:zza	(Ljava/io/OutputStream;)Z
    //   45: ifne +61 -> 106
    //   48: aload 4
    //   50: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   53: ldc_w 354
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_3
    //   63: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 230	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: new 64	java/io/IOException
    //   73: dup
    //   74: invokespecial 355	java/io/IOException:<init>	()V
    //   77: athrow
    //   78: astore_1
    //   79: aload_3
    //   80: invokevirtual 206	java/io/File:delete	()Z
    //   83: ifne +20 -> 103
    //   86: ldc_w 357
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_3
    //   96: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: aastore
    //   100: invokestatic 230	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: aload 4
    //   108: aload_2
    //   109: getfield 341	com/google/android/gms/internal/zzb$zza:data	[B
    //   112: invokevirtual 360	java/io/FileOutputStream:write	([B)V
    //   115: aload 4
    //   117: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   120: aload_0
    //   121: aload_1
    //   122: aload 5
    //   124: invokespecial 313	com/google/android/gms/internal/zzv:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzv$zza;)V
    //   127: goto -24 -> 103
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	zzv
    //   0	135	1	paramString	String
    //   0	135	2	paramZza	zzb.zza
    //   16	80	3	localFile	File
    //   25	91	4	localFileOutputStream	java.io.FileOutputStream
    //   36	87	5	localZza	zza
    // Exception table:
    //   from	to	target	type
    //   17	78	78	java/io/IOException
    //   106	127	78	java/io/IOException
    //   2	17	130	finally
    //   17	78	130	finally
    //   79	103	130	finally
    //   106	127	130	finally
  }
  
  public File zzf(String paramString)
  {
    return new File(zzax, zze(paramString));
  }
  
  static class zza
  {
    public String zza;
    public String zzaA;
    public long zzaz;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf;
    
    private zza() {}
    
    public zza(String paramString, zzb.zza paramZza)
    {
      zzaA = paramString;
      zzaz = data.length;
      zza = zza;
      zzb = zzb;
      zzc = zzc;
      zzd = zzd;
      zze = zze;
      zzf = zzf;
    }
    
    public static zza zzf(InputStream paramInputStream)
      throws IOException
    {
      zza localZza = new zza();
      if (zzv.zzb(paramInputStream) != 538247942) {
        throw new IOException();
      }
      zzaA = zzv.zzd(paramInputStream);
      zza = zzv.zzd(paramInputStream);
      if (zza.equals("")) {
        zza = null;
      }
      zzb = zzv.zzc(paramInputStream);
      zzc = zzv.zzc(paramInputStream);
      zzd = zzv.zzc(paramInputStream);
      zze = zzv.zzc(paramInputStream);
      zzf = zzv.zze(paramInputStream);
      return localZza;
    }
    
    public boolean zza(OutputStream paramOutputStream)
    {
      try
      {
        zzv.zza(paramOutputStream, 538247942);
        zzv.zza(paramOutputStream, zzaA);
        if (zza == null) {}
        for (String str = "";; str = zza)
        {
          zzv.zza(paramOutputStream, str);
          zzv.zza(paramOutputStream, zzb);
          zzv.zza(paramOutputStream, zzc);
          zzv.zza(paramOutputStream, zzd);
          zzv.zza(paramOutputStream, zze);
          zzv.zza(zzf, paramOutputStream);
          paramOutputStream.flush();
          return true;
        }
        return false;
      }
      catch (IOException paramOutputStream)
      {
        zzs.zzb("%s", new Object[] { paramOutputStream.toString() });
      }
    }
    
    public zzb.zza zzb(byte[] paramArrayOfByte)
    {
      zzb.zza localZza = new zzb.zza();
      data = paramArrayOfByte;
      zza = zza;
      zzb = zzb;
      zzc = zzc;
      zzd = zzd;
      zze = zze;
      zzf = zzf;
      return localZza;
    }
  }
  
  private static class zzb
    extends FilterInputStream
  {
    private int zzaB = 0;
    
    private zzb(InputStream paramInputStream)
    {
      super();
    }
    
    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        zzaB += 1;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        zzaB += paramInt1;
      }
      return paramInt1;
    }
  }
}
