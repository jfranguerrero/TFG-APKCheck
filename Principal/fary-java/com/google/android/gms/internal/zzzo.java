package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class zzzo
  implements zzzf.zzb
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  static Boolean zzawQ = null;
  final zza zzawR;
  
  public zzzo()
  {
    this(new zza(null));
  }
  
  public zzzo(Context paramContext)
  {
    this(new zza(paramContext));
  }
  
  zzzo(zza paramZza)
  {
    zzawR = ((zza)zzac.zzw(paramZza));
  }
  
  static long zzI(long paramLong)
  {
    return zzzl.zzn(ByteBuffer.allocate(8).putLong(paramLong).array());
  }
  
  static boolean zza(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong2 < 0L) || (paramLong3 < 0L)) {
      throw new IllegalArgumentException(72 + "negative values not supported: " + paramLong2 + "/" + paramLong3);
    }
    return (paramLong3 > 0L) && (zzzp.zzd(paramLong1, paramLong3) < paramLong2);
  }
  
  static zzb zzcZ(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    String str = "";
    int j = paramString.indexOf(',');
    if (j >= 0)
    {
      str = paramString.substring(0, j);
      i = j + 1;
    }
    j = paramString.indexOf('/', i);
    if (j <= 0)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to parse the rule: ".concat(paramString);; paramString = new String("Failed to parse the rule: "))
      {
        Log.e("LogSamplerImpl", paramString);
        return null;
      }
    }
    try
    {
      l1 = Long.parseLong(paramString.substring(i, j));
      l2 = Long.parseLong(paramString.substring(j + 1));
      if ((l1 < 0L) || (l2 < 0L))
      {
        Log.e("LogSamplerImpl", 72 + "negative values not supported: " + l1 + "/" + l2);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      long l2;
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "parseLong() failed while parsing: ".concat(paramString);; paramString = new String("parseLong() failed while parsing: "))
      {
        Log.e("LogSamplerImpl", paramString, localNumberFormatException);
        return null;
      }
      return new zzb(localNumberFormatException, l1, l2);
    }
  }
  
  static long zzd(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return zzI(paramLong);
    }
    paramString = paramString.getBytes(UTF_8);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length + 8);
    localByteBuffer.put(paramString);
    localByteBuffer.putLong(paramLong);
    return zzzl.zzn(localByteBuffer.array());
  }
  
  public boolean zzh(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {}
    for (;;)
    {
      if (paramString == null) {}
      long l;
      do
      {
        return true;
        if (paramInt < 0) {
          break label73;
        }
        paramString = String.valueOf(paramInt);
        break;
        l = zzawR.zzux();
        paramString = zzcZ(zzawR.zzda(paramString));
      } while (paramString == null);
      return zza(zzd(zzawS, l), zzawT, zzawU);
      label73:
      paramString = null;
    }
  }
  
  static class zza
  {
    final ContentResolver mContentResolver;
    
    zza(Context paramContext)
    {
      if ((paramContext == null) || (!zzaj(paramContext)))
      {
        mContentResolver = null;
        return;
      }
      mContentResolver = paramContext.getContentResolver();
      zzbii.zzb(mContentResolver, new String[] { "gms:playlog:service:sampling_" });
    }
    
    private static boolean zzaj(Context paramContext)
    {
      if (zzzo.zzawQ == null) {
        if (paramContext.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
          break label31;
        }
      }
      label31:
      for (boolean bool = true;; bool = false)
      {
        zzzo.zzawQ = Boolean.valueOf(bool);
        return zzzo.zzawQ.booleanValue();
      }
    }
    
    String zzda(String paramString)
    {
      if (mContentResolver == null) {
        return null;
      }
      ContentResolver localContentResolver = mContentResolver;
      String str = String.valueOf("gms:playlog:service:sampling_");
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = str.concat(paramString);; paramString = new String(str)) {
        return zzbii.zza(localContentResolver, paramString, null);
      }
    }
    
    long zzux()
    {
      if (mContentResolver == null) {
        return 0L;
      }
      return zzbii.getLong(mContentResolver, "android_id", 0L);
    }
  }
  
  static class zzb
  {
    public final String zzawS;
    public final long zzawT;
    public final long zzawU;
    
    public zzb(String paramString, long paramLong1, long paramLong2)
    {
      zzawS = paramString;
      zzawT = paramLong1;
      zzawU = paramLong2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
      } while ((zzaa.equal(zzawS, zzawS)) && (zzaa.equal(Long.valueOf(zzawT), Long.valueOf(zzawT))) && (zzaa.equal(Long.valueOf(zzawU), Long.valueOf(zzawU))));
      return false;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { zzawS, Long.valueOf(zzawT), Long.valueOf(zzawU) });
    }
  }
}
