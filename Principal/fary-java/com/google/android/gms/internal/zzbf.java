package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbf
  extends zzak<Integer, Long>
{
  public Long zzqU;
  
  public zzbf() {}
  
  public zzbf(String paramString)
  {
    zzk(paramString);
  }
  
  protected HashMap<Integer, Long> zzQ()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), zzqU);
    return localHashMap;
  }
  
  protected void zzk(String paramString)
  {
    paramString = zzl(paramString);
    if (paramString != null) {
      zzqU = ((Long)paramString.get(Integer.valueOf(0)));
    }
  }
}
