package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzmb
public class zzdg
  extends zzdd
{
  private MessageDigest zzyi;
  
  public zzdg() {}
  
  public byte[] zzF(String arg1)
  {
    int i = 4;
    byte[] arrayOfByte1 = zza(???.split(" "));
    zzyi = zzeo();
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzyi == null) {
          return new byte[0];
        }
        zzyi.reset();
        zzyi.update(arrayOfByte1);
        arrayOfByte1 = zzyi.digest();
        if (arrayOfByte1.length > 4)
        {
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          return arrayOfByte2;
        }
      }
      i = localObject.length;
    }
  }
  
  byte[] zza(String[] paramArrayOfString)
  {
    int i = 0;
    Object localObject;
    if (paramArrayOfString.length == 1)
    {
      localObject = zzdf.zzp(zzdf.zzH(paramArrayOfString[0]));
      return localObject;
    }
    if (paramArrayOfString.length < 5)
    {
      localObject = new byte[paramArrayOfString.length * 2];
      i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfByte = zzs(zzdf.zzH(paramArrayOfString[i]));
        localObject[(i * 2)] = arrayOfByte[0];
        localObject[(i * 2 + 1)] = arrayOfByte[1];
        i += 1;
      }
      return localObject;
    }
    byte[] arrayOfByte = new byte[paramArrayOfString.length];
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= paramArrayOfString.length) {
        break;
      }
      arrayOfByte[i] = zzr(zzdf.zzH(paramArrayOfString[i]));
      i += 1;
    }
  }
  
  byte zzr(int paramInt)
  {
    return (byte)(paramInt & 0xFF ^ (0xFF00 & paramInt) >> 8 ^ (0xFF0000 & paramInt) >> 16 ^ (0xFF000000 & paramInt) >> 24);
  }
  
  byte[] zzs(int paramInt)
  {
    paramInt = 0xFFFF & paramInt ^ (0xFFFF0000 & paramInt) >> 16;
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8) };
  }
}
