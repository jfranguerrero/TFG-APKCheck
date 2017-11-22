package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbb
  extends zzak<Integer, Long>
{
  public Long zzqp;
  public Long zzqq;
  
  public zzbb() {}
  
  public zzbb(String paramString)
  {
    zzk(paramString);
  }
  
  protected HashMap<Integer, Long> zzQ()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), zzqp);
    localHashMap.put(Integer.valueOf(1), zzqq);
    return localHashMap;
  }
  
  protected void zzk(String paramString)
  {
    paramString = zzl(paramString);
    if (paramString != null)
    {
      zzqp = ((Long)paramString.get(Integer.valueOf(0)));
      zzqq = ((Long)paramString.get(Integer.valueOf(1)));
    }
  }
}
