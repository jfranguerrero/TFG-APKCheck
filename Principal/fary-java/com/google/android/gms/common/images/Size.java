package com.google.android.gms.common.images;

public final class Size
{
  private final int zzrG;
  private final int zzrH;
  
  public Size(int paramInt1, int paramInt2)
  {
    zzrG = paramInt1;
    zzrH = paramInt2;
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string must not be null");
    }
    int j = paramString.indexOf('*');
    int i = j;
    if (j < 0) {
      i = paramString.indexOf('x');
    }
    if (i < 0) {
      throw zzdm(paramString);
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw zzdm(paramString);
    }
  }
  
  private static NumberFormatException zzdm(String paramString)
  {
    throw new NumberFormatException(String.valueOf(paramString).length() + 16 + "Invalid Size: \"" + paramString + "\"");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof Size));
    paramObject = (Size)paramObject;
    if ((zzrG == zzrG) && (zzrH == zzrH)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getHeight()
  {
    return zzrH;
  }
  
  public int getWidth()
  {
    return zzrG;
  }
  
  public int hashCode()
  {
    return zzrH ^ (zzrG << 16 | zzrG >>> 16);
  }
  
  public String toString()
  {
    int i = zzrG;
    int j = zzrH;
    return 23 + i + "x" + j;
  }
}
