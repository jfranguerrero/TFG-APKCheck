package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzmb
class zziw
{
  final int zzIE;
  final String zztq;
  final zzdy zzug;
  
  zziw(zzdy paramZzdy, String paramString, int paramInt)
  {
    zzug = paramZzdy;
    zztq = paramString;
    zzIE = paramInt;
  }
  
  zziw(zziu paramZziu)
  {
    this(paramZziu.zzgl(), paramZziu.getAdUnitId(), paramZziu.getNetworkType());
  }
  
  static zziw zzak(String paramString)
    throws IOException
  {
    Object localObject3 = paramString.split("\000");
    if (localObject3.length != 3) {
      throw new IOException("Incorrect field count for QueueSeed.");
    }
    paramString = Parcel.obtain();
    try
    {
      Object localObject1 = new String(Base64.decode(localObject3[0], 0), "UTF-8");
      int i = Integer.parseInt(localObject3[1]);
      localObject3 = Base64.decode(localObject3[2], 0);
      paramString.unmarshall((byte[])localObject3, 0, localObject3.length);
      paramString.setDataPosition(0);
      localObject1 = new zziw((zzdy)zzdy.CREATOR.createFromParcel(paramString), (String)localObject1, i);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      throw new IOException("Malformed QueueSeed encoding.", localThrowable);
    }
    finally
    {
      paramString.recycle();
    }
  }
  
  String zzgs()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      String str1 = Base64.encodeToString(zztq.getBytes("UTF-8"), 0);
      String str2 = Integer.toString(zzIE);
      zzug.writeToParcel(localParcel, 0);
      String str3 = Base64.encodeToString(localParcel.marshall(), 0);
      str1 = String.valueOf(str1).length() + 2 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + "\000" + str2 + "\000" + str3;
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      zzpe.e("QueueSeed encode failed because UTF-8 is not available.");
      return "";
    }
    finally
    {
      localParcel.recycle();
    }
  }
}
