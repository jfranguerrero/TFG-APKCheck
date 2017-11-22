package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public class zzpr
{
  Map<Integer, Bitmap> zzXI = new ConcurrentHashMap();
  private AtomicInteger zzXJ = new AtomicInteger(0);
  
  public zzpr() {}
  
  public Bitmap zza(Integer paramInteger)
  {
    return (Bitmap)zzXI.get(paramInteger);
  }
  
  public int zzb(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      zzpe.zzbc("Bitmap is null. Skipping putting into the Memory Map.");
      return -1;
    }
    zzXI.put(Integer.valueOf(zzXJ.get()), paramBitmap);
    return zzXJ.getAndIncrement();
  }
  
  public void zzb(Integer paramInteger)
  {
    zzXI.remove(paramInteger);
  }
}
