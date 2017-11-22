package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzan
{
  static boolean zzlI = false;
  private static MessageDigest zzlJ = null;
  private static final Object zzlK = new Object();
  private static final Object zzlL = new Object();
  static CountDownLatch zzlM = new CountDownLatch(1);
  
  static void zzR()
  {
    synchronized (zzlL)
    {
      if (!zzlI)
      {
        zzlI = true;
        new Thread(new zza(null)).start();
      }
      return;
    }
  }
  
  static MessageDigest zzS()
  {
    zzR();
    int i = 0;
    try
    {
      boolean bool = zzlM.await(2L, TimeUnit.SECONDS);
      i = bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    if (i == 0) {}
    while (zzlJ == null) {
      return null;
    }
    return zzlJ;
  }
  
  private static int zza(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 239;
    }
    return 255;
  }
  
  static String zza(zzaf.zza paramZza, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    return zza(zzbut.zzf(paramZza), paramString, paramBoolean);
  }
  
  static String zza(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = zzb(paramString1, paramString2, paramBoolean);
    if (paramString1 != null) {
      return zzal.zza(paramString1, true);
    }
    return Integer.toString(7);
  }
  
  static String zza(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    if (paramBoolean) {}
    for (paramArrayOfByte = zzb(paramArrayOfByte, paramString);; paramArrayOfByte = zza(paramArrayOfByte, paramString)) {
      return zzal.zza(paramArrayOfByte, true);
    }
  }
  
  static Vector<byte[]> zza(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int k = (paramArrayOfByte.length + paramInt - 1) / paramInt;
    Vector localVector = new Vector();
    int i = 0;
    for (;;)
    {
      int m;
      if (i < k) {
        m = i * paramInt;
      }
      try
      {
        if (paramArrayOfByte.length - m > paramInt) {}
        for (int j = m + paramInt;; j = paramArrayOfByte.length)
        {
          localVector.add(Arrays.copyOfRange(paramArrayOfByte, m, j));
          i += 1;
          break;
        }
        return localVector;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte) {}
    }
    return null;
  }
  
  static void zza(String paramString, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString.length() > 32) {
      str = paramString.substring(0, 32);
    }
    new zzbtm(str.getBytes("UTF-8")).zzY(paramArrayOfByte);
  }
  
  static byte[] zza(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    Object localObject = zza(paramArrayOfByte, 255);
    if ((localObject == null) || (((Vector)localObject).size() == 0)) {
      return zzb(zzbut.zzf(zzb(4096L)), paramString);
    }
    zzaf.zzf localZzf = new zzaf.zzf();
    zzcz = new byte[((Vector)localObject).size()][];
    localObject = ((Vector)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte = zzb((byte[])((Iterator)localObject).next(), paramString, false);
      zzcz[i] = arrayOfByte;
      i += 1;
    }
    zzcu = zzh(paramArrayOfByte);
    return zzbut.zzf(localZzf);
  }
  
  static zzaf.zza zzb(long paramLong)
  {
    zzaf.zza localZza = new zzaf.zza();
    zzbs = Long.valueOf(paramLong);
    return localZza;
  }
  
  /* Error */
  static byte[] zzb(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 208	com/google/android/gms/internal/zzaf$zzc
    //   3: dup
    //   4: invokespecial 209	com/google/android/gms/internal/zzaf$zzc:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 132	java/lang/String:length	()I
    //   12: iconst_3
    //   13: if_icmpge +44 -> 57
    //   16: aload_0
    //   17: ldc -45
    //   19: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   22: astore_0
    //   23: aload_3
    //   24: aload_0
    //   25: putfield 214	com/google/android/gms/internal/zzaf$zzc:zzcs	[B
    //   28: iload_2
    //   29: ifeq +46 -> 75
    //   32: aload_1
    //   33: invokevirtual 132	java/lang/String:length	()I
    //   36: iconst_3
    //   37: if_icmpge +29 -> 66
    //   40: aload_1
    //   41: ldc -45
    //   43: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   46: astore_0
    //   47: aload_3
    //   48: aload_0
    //   49: putfield 217	com/google/android/gms/internal/zzaf$zzc:zzct	[B
    //   52: aload_3
    //   53: invokestatic 81	com/google/android/gms/internal/zzbut:zzf	(Lcom/google/android/gms/internal/zzbut;)[B
    //   56: areturn
    //   57: aload_0
    //   58: iconst_1
    //   59: invokestatic 220	com/google/android/gms/internal/zzal:zza	(Ljava/lang/String;Z)[B
    //   62: astore_0
    //   63: goto -40 -> 23
    //   66: aload_1
    //   67: iconst_1
    //   68: invokestatic 220	com/google/android/gms/internal/zzal:zza	(Ljava/lang/String;Z)[B
    //   71: astore_0
    //   72: goto -25 -> 47
    //   75: aload_1
    //   76: ifnull +10 -> 86
    //   79: aload_1
    //   80: invokevirtual 132	java/lang/String:length	()I
    //   83: ifne +16 -> 99
    //   86: iconst_5
    //   87: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   90: ldc -45
    //   92: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   95: astore_0
    //   96: goto -49 -> 47
    //   99: aload_1
    //   100: ldc -45
    //   102: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   105: aconst_null
    //   106: getstatic 226	com/google/android/gms/internal/zzfx:zzDi	Lcom/google/android/gms/internal/zzft;
    //   109: invokevirtual 231	com/google/android/gms/internal/zzft:get	()Ljava/lang/Object;
    //   112: checkcast 233	java/lang/Boolean
    //   115: invokevirtual 236	java/lang/Boolean:booleanValue	()Z
    //   118: invokestatic 84	com/google/android/gms/internal/zzan:zza	([BLjava/lang/String;Z)Ljava/lang/String;
    //   121: iconst_1
    //   122: invokestatic 220	com/google/android/gms/internal/zzal:zza	(Ljava/lang/String;Z)[B
    //   125: astore_0
    //   126: goto -79 -> 47
    //   129: astore_0
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: goto -3 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString1	String
    //   0	136	1	paramString2	String
    //   0	136	2	paramBoolean	boolean
    //   7	46	3	localZzc	zzaf.zzc
    // Exception table:
    //   from	to	target	type
    //   8	23	129	java/security/NoSuchAlgorithmException
    //   23	28	129	java/security/NoSuchAlgorithmException
    //   32	47	129	java/security/NoSuchAlgorithmException
    //   47	57	129	java/security/NoSuchAlgorithmException
    //   57	63	129	java/security/NoSuchAlgorithmException
    //   66	72	129	java/security/NoSuchAlgorithmException
    //   79	86	129	java/security/NoSuchAlgorithmException
    //   86	96	129	java/security/NoSuchAlgorithmException
    //   99	126	129	java/security/NoSuchAlgorithmException
    //   8	23	132	java/io/UnsupportedEncodingException
    //   23	28	132	java/io/UnsupportedEncodingException
    //   32	47	132	java/io/UnsupportedEncodingException
    //   47	57	132	java/io/UnsupportedEncodingException
    //   57	63	132	java/io/UnsupportedEncodingException
    //   66	72	132	java/io/UnsupportedEncodingException
    //   79	86	132	java/io/UnsupportedEncodingException
    //   86	96	132	java/io/UnsupportedEncodingException
    //   99	126	132	java/io/UnsupportedEncodingException
  }
  
  static byte[] zzb(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    return zzb(paramArrayOfByte, paramString, true);
  }
  
  private static byte[] zzb(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    int i = zza(paramBoolean);
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > i) {
      arrayOfByte = zzbut.zzf(zzb(4096L));
    }
    if (arrayOfByte.length < i)
    {
      paramArrayOfByte = new byte[i - arrayOfByte.length];
      new SecureRandom().nextBytes(paramArrayOfByte);
    }
    for (paramArrayOfByte = ByteBuffer.allocate(i + 1).put((byte)arrayOfByte.length).put(arrayOfByte).put(paramArrayOfByte).array();; paramArrayOfByte = ByteBuffer.allocate(i + 1).put((byte)arrayOfByte.length).put(arrayOfByte).array())
    {
      arrayOfByte = paramArrayOfByte;
      if (paramBoolean)
      {
        arrayOfByte = zzh(paramArrayOfByte);
        arrayOfByte = ByteBuffer.allocate(256).put(arrayOfByte).put(paramArrayOfByte).array();
      }
      paramArrayOfByte = new byte['Ā'];
      new zzao().zzb(arrayOfByte, paramArrayOfByte);
      if ((paramString != null) && (paramString.length() > 0)) {
        zza(paramString, paramArrayOfByte);
      }
      return paramArrayOfByte;
    }
  }
  
  public static byte[] zzh(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest;
    synchronized (zzlK)
    {
      localMessageDigest = zzS();
      if (localMessageDigest == null) {
        throw new NoSuchAlgorithmException("Cannot compute hash");
      }
    }
    localMessageDigest.reset();
    localMessageDigest.update(paramArrayOfByte);
    paramArrayOfByte = zzlJ.digest();
    return paramArrayOfByte;
  }
  
  private static final class zza
    implements Runnable
  {
    private zza() {}
    
    public void run()
    {
      try
      {
        zzan.zza(MessageDigest.getInstance("MD5"));
        zzan.zzlM.countDown();
        return;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        localNoSuchAlgorithmException = localNoSuchAlgorithmException;
        zzan.zzlM.countDown();
        return;
      }
      finally
      {
        localObject = finally;
        zzan.zzlM.countDown();
        throw localObject;
      }
    }
  }
}
