package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzbuv
{
  final int tag;
  final byte[] zzcsh;
  
  zzbuv(int paramInt, byte[] paramArrayOfByte)
  {
    tag = paramInt;
    zzcsh = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbuv)) {
        return false;
      }
      paramObject = (zzbuv)paramObject;
    } while ((tag == tag) && (Arrays.equals(zzcsh, zzcsh)));
    return false;
  }
  
  public int hashCode()
  {
    return (tag + 527) * 31 + Arrays.hashCode(zzcsh);
  }
  
  void zza(zzbum paramZzbum)
    throws IOException
  {
    paramZzbum.zzqt(tag);
    paramZzbum.zzah(zzcsh);
  }
  
  int zzv()
  {
    return zzbum.zzqu(tag) + 0 + zzcsh.length;
  }
}
