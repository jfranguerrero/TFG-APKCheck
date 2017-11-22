package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzmb
public class zzde
{
  private final int zzyc;
  private final int zzyd;
  private final int zzye;
  private final zzdd zzyf = new zzdg();
  
  public zzde(int paramInt)
  {
    zzyd = paramInt;
    zzyc = 6;
    zzye = 0;
  }
  
  String zzG(String paramString)
  {
    Object localObject1 = paramString.split("\n");
    if (localObject1.length == 0) {
      return "";
    }
    paramString = zzep();
    Object localObject2 = new PriorityQueue(zzyd, new Comparator()
    {
      public int zza(zzdh.zza paramAnonymousZza1, zzdh.zza paramAnonymousZza2)
      {
        int i = zzyk - zzyk;
        if (i != 0) {
          return i;
        }
        return (int)(value - value);
      }
    });
    int i = 0;
    if (i < localObject1.length)
    {
      String[] arrayOfString = zzdf.zzI(localObject1[i]);
      if (arrayOfString.length == 0) {}
      for (;;)
      {
        i += 1;
        break;
        zzdh.zza(arrayOfString, zzyd, zzyc, (PriorityQueue)localObject2);
      }
    }
    localObject1 = ((PriorityQueue)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzdh.zza)((Iterator)localObject1).next();
        try
        {
          paramString.write(zzyf.zzF(zzyj));
        }
        catch (IOException localIOException)
        {
          zzpe.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  public String zza(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuffer.append(((String)paramArrayList.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    return zzG(localStringBuffer.toString());
  }
  
  zza zzep()
  {
    return new zza();
  }
  
  static class zza
  {
    ByteArrayOutputStream zzyg = new ByteArrayOutputStream(4096);
    Base64OutputStream zzyh = new Base64OutputStream(zzyg, 10);
    
    public zza() {}
    
    public String toString()
    {
      try
      {
        zzyh.close();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            zzyg.close();
            String str = zzyg.toString();
            return str;
          }
          catch (IOException localIOException2)
          {
            zzpe.zzb("HashManager: Unable to convert to Base64.", localIOException2);
            return "";
          }
          finally
          {
            zzyg = null;
            zzyh = null;
          }
          localIOException1 = localIOException1;
          zzpe.zzb("HashManager: Unable to convert to Base64.", localIOException1);
        }
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      zzyh.write(paramArrayOfByte);
    }
  }
}
