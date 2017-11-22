package com.google.android.gms.internal;

import android.os.Looper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public final class zzbe
{
  private static final char[] zzqT = "0123456789abcdef".toCharArray();
  
  public static String zza(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static Long zzbc()
  {
    return Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime().getTime());
  }
  
  public static boolean zzbd()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static String zzr(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$"))
      {
        paramString = UUID.fromString(paramString);
        localObject = new byte[16];
        ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject);
        localByteBuffer.putLong(paramString.getMostSignificantBits());
        localByteBuffer.putLong(paramString.getLeastSignificantBits());
        localObject = zzal.zza((byte[])localObject, true);
      }
    }
    return localObject;
  }
  
  public static boolean zzs(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
}
