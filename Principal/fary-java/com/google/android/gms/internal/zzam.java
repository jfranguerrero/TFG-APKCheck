package com.google.android.gms.internal;

import java.util.HashMap;

public class zzam
  extends zzak<Integer, Object>
{
  public String zzaM = "E";
  public String zzaO = "E";
  public String zzaP = "E";
  public String zzaQ = "E";
  public long zzlH = -1L;
  
  public zzam() {}
  
  public zzam(String paramString)
  {
    this();
    zzk(paramString);
  }
  
  protected HashMap<Integer, Object> zzQ()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), zzaM);
    localHashMap.put(Integer.valueOf(4), zzaQ);
    localHashMap.put(Integer.valueOf(3), zzaP);
    localHashMap.put(Integer.valueOf(2), zzaO);
    localHashMap.put(Integer.valueOf(1), Long.valueOf(zzlH));
    return localHashMap;
  }
  
  protected void zzk(String paramString)
  {
    HashMap localHashMap = zzl(paramString);
    long l;
    if (localHashMap != null)
    {
      if (localHashMap.get(Integer.valueOf(0)) != null) {
        break label113;
      }
      paramString = "E";
      zzaM = paramString;
      if (localHashMap.get(Integer.valueOf(1)) != null) {
        break label129;
      }
      l = -1L;
      label47:
      zzlH = l;
      if (localHashMap.get(Integer.valueOf(2)) != null) {
        break label148;
      }
      paramString = "E";
      label67:
      zzaO = paramString;
      if (localHashMap.get(Integer.valueOf(3)) != null) {
        break label164;
      }
      paramString = "E";
      label87:
      zzaP = paramString;
      if (localHashMap.get(Integer.valueOf(4)) != null) {
        break label180;
      }
    }
    label113:
    label129:
    label148:
    label164:
    label180:
    for (paramString = "E";; paramString = (String)localHashMap.get(Integer.valueOf(4)))
    {
      zzaQ = paramString;
      return;
      paramString = (String)localHashMap.get(Integer.valueOf(0));
      break;
      l = ((Long)localHashMap.get(Integer.valueOf(1))).longValue();
      break label47;
      paramString = (String)localHashMap.get(Integer.valueOf(2));
      break label67;
      paramString = (String)localHashMap.get(Integer.valueOf(3));
      break label87;
    }
  }
}
