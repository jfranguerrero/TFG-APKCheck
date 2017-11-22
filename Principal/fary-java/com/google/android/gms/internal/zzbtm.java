package com.google.android.gms.internal;

public class zzbtm
{
  private final byte[] zzcqh = new byte['Ā'];
  private int zzcqi;
  private int zzcqj;
  
  public zzbtm(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      zzcqh[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + zzcqh[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = zzcqh[j];
      zzcqh[j] = zzcqh[k];
      zzcqh[k] = i;
      j += 1;
    }
    zzcqi = 0;
    zzcqj = 0;
  }
  
  public void zzY(byte[] paramArrayOfByte)
  {
    int m = zzcqi;
    int k = zzcqj;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + zzcqh[m] & 0xFF;
      int i = zzcqh[m];
      zzcqh[m] = zzcqh[k];
      zzcqh[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ zzcqh[(zzcqh[m] + zzcqh[k] & 0xFF)]));
      j += 1;
    }
    zzcqi = m;
    zzcqj = k;
  }
}
