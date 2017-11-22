package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzbut
{
  protected volatile int zzcsg = -1;
  
  public zzbut() {}
  
  public static final <T extends zzbut> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzbus
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void zza(zzbut paramZzbut, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzbum.zzc(paramArrayOfByte, paramInt1, paramInt2);
      paramZzbut.zza(paramArrayOfByte);
      paramArrayOfByte.zzacM();
      return;
    }
    catch (IOException paramZzbut)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramZzbut);
    }
  }
  
  public static final <T extends zzbut> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzbus
  {
    try
    {
      paramArrayOfByte = zzbul.zzb(paramArrayOfByte, paramInt1, paramInt2);
      paramT.zzb(paramArrayOfByte);
      paramArrayOfByte.zzqg(0);
      return paramT;
    }
    catch (zzbus paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] zzf(zzbut paramZzbut)
  {
    byte[] arrayOfByte = new byte[paramZzbut.zzacZ()];
    zza(paramZzbut, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return zzbuu.zzg(this);
  }
  
  public void zza(zzbum paramZzbum)
    throws IOException
  {}
  
  public zzbut zzacO()
    throws CloneNotSupportedException
  {
    return (zzbut)super.clone();
  }
  
  public int zzacY()
  {
    if (zzcsg < 0) {
      zzacZ();
    }
    return zzcsg;
  }
  
  public int zzacZ()
  {
    int i = zzv();
    zzcsg = i;
    return i;
  }
  
  public abstract zzbut zzb(zzbul paramZzbul)
    throws IOException;
  
  protected int zzv()
  {
    return 0;
  }
}
