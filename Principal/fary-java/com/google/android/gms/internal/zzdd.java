package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzmb
public abstract class zzdd
{
  @Nullable
  private static MessageDigest zzyb = null;
  protected Object zzrN = new Object();
  
  public zzdd() {}
  
  abstract byte[] zzF(String paramString);
  
  @Nullable
  protected MessageDigest zzeo()
  {
    for (;;)
    {
      MessageDigest localMessageDigest;
      int i;
      synchronized (zzrN)
      {
        if (zzyb != null)
        {
          localMessageDigest = zzyb;
          return localMessageDigest;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        zzyb = MessageDigest.getInstance("MD5");
        i += 1;
        continue;
        localMessageDigest = zzyb;
        return localMessageDigest;
        localObject2 = finally;
        throw localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
}
