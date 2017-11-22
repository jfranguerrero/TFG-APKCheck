package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa
  extends ByteArrayOutputStream
{
  private final zzu zzap;
  
  public zzaa(zzu paramZzu, int paramInt)
  {
    zzap = paramZzu;
    buf = zzap.zzb(Math.max(paramInt, 256));
  }
  
  private void zzd(int paramInt)
  {
    if (count + paramInt <= buf.length) {
      return;
    }
    byte[] arrayOfByte = zzap.zzb((count + paramInt) * 2);
    System.arraycopy(buf, 0, arrayOfByte, 0, count);
    zzap.zza(buf);
    buf = arrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    zzap.zza(buf);
    buf = null;
    super.close();
  }
  
  public void finalize()
  {
    zzap.zza(buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      zzd(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      zzd(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}
