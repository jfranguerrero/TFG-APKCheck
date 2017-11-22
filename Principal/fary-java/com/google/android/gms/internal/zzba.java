package com.google.android.gms.internal;

import java.util.HashMap;

public class zzba
  extends zzak<Integer, Object>
{
  public Long zzqm;
  public Boolean zzqn;
  public Boolean zzqo;
  
  public zzba() {}
  
  public zzba(String paramString)
  {
    zzk(paramString);
  }
  
  protected HashMap<Integer, Object> zzQ()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), zzqm);
    localHashMap.put(Integer.valueOf(1), zzqn);
    localHashMap.put(Integer.valueOf(2), zzqo);
    return localHashMap;
  }
  
  protected void zzk(String paramString)
  {
    paramString = zzl(paramString);
    if (paramString != null)
    {
      zzqm = ((Long)paramString.get(Integer.valueOf(0)));
      zzqn = ((Boolean)paramString.get(Integer.valueOf(1)));
      zzqo = ((Boolean)paramString.get(Integer.valueOf(2)));
    }
  }
}
