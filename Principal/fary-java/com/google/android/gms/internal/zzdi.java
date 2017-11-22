package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.security.MessageDigest;

@zzmb
public class zzdi
  extends zzdd
{
  private MessageDigest zzyi;
  private final int zzyl;
  private final int zzym;
  
  public zzdi(int paramInt)
  {
    int j = paramInt / 8;
    int i = j;
    if (paramInt % 8 > 0) {
      i = j + 1;
    }
    zzyl = i;
    zzym = paramInt;
  }
  
  public byte[] zzF(String paramString)
  {
    int j = 0;
    for (;;)
    {
      int i;
      byte[] arrayOfByte;
      long l2;
      synchronized (zzrN)
      {
        zzyi = zzeo();
        if (zzyi == null) {
          return new byte[0];
        }
        zzyi.reset();
        zzyi.update(paramString.getBytes(Charset.forName("UTF-8")));
        paramString = zzyi.digest();
        if (paramString.length > zzyl)
        {
          i = zzyl;
          arrayOfByte = new byte[i];
          System.arraycopy(paramString, 0, arrayOfByte, 0, arrayOfByte.length);
          if (zzym % 8 <= 0) {
            continue;
          }
          l1 = 0L;
          i = j;
          if (i < arrayOfByte.length)
          {
            l2 = l1;
            if (i <= 0) {
              break label177;
            }
            l2 = l1 << 8;
            break label177;
          }
        }
        else
        {
          i = paramString.length;
          continue;
        }
        l1 >>>= 8 - zzym % 8;
        i = zzyl - 1;
        break label198;
        return arrayOfByte;
      }
      label177:
      long l1 = l2 + (arrayOfByte[i] & 0xFF);
      i += 1;
      continue;
      label198:
      while (i >= 0)
      {
        arrayOfByte[i] = ((byte)(int)(0xFF & l1));
        l1 >>>= 8;
        i -= 1;
      }
    }
  }
}
