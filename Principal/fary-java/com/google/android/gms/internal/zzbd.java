package com.google.android.gms.internal;

import java.util.HashMap;

public class zzbd
  extends zzak<Integer, Long>
{
  public Long zzcc;
  public Long zzce;
  public Long zzci;
  public Long zzcj;
  public Long zzqM;
  public Long zzqN;
  public Long zzqO;
  public Long zzqP;
  public Long zzqQ;
  public Long zzqR;
  public Long zzqS;
  
  public zzbd() {}
  
  public zzbd(String paramString)
  {
    zzk(paramString);
  }
  
  protected HashMap<Integer, Long> zzQ()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), zzqM);
    localHashMap.put(Integer.valueOf(1), zzqN);
    localHashMap.put(Integer.valueOf(2), zzqO);
    localHashMap.put(Integer.valueOf(3), zzce);
    localHashMap.put(Integer.valueOf(4), zzcc);
    localHashMap.put(Integer.valueOf(5), zzqP);
    localHashMap.put(Integer.valueOf(6), zzqQ);
    localHashMap.put(Integer.valueOf(7), zzqR);
    localHashMap.put(Integer.valueOf(8), zzcj);
    localHashMap.put(Integer.valueOf(9), zzci);
    localHashMap.put(Integer.valueOf(10), zzqS);
    return localHashMap;
  }
  
  protected void zzk(String paramString)
  {
    paramString = zzl(paramString);
    if (paramString != null)
    {
      zzqM = ((Long)paramString.get(Integer.valueOf(0)));
      zzqN = ((Long)paramString.get(Integer.valueOf(1)));
      zzqO = ((Long)paramString.get(Integer.valueOf(2)));
      zzce = ((Long)paramString.get(Integer.valueOf(3)));
      zzcc = ((Long)paramString.get(Integer.valueOf(4)));
      zzqP = ((Long)paramString.get(Integer.valueOf(5)));
      zzqQ = ((Long)paramString.get(Integer.valueOf(6)));
      zzqR = ((Long)paramString.get(Integer.valueOf(7)));
      zzcj = ((Long)paramString.get(Integer.valueOf(8)));
      zzci = ((Long)paramString.get(Integer.valueOf(9)));
      zzqS = ((Long)paramString.get(Integer.valueOf(10)));
    }
  }
}
