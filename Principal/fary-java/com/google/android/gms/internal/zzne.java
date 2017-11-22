package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzmb
class zzne
{
  private String zzD;
  private final String zzOn;
  private int zzPF;
  private final List<String> zzTR;
  private final List<String> zzTS;
  private final String zzTT;
  private final String zzTU;
  private final String zzTV;
  private final String zzTW;
  private final boolean zzTX;
  private final boolean zzTY;
  private final String zzTZ;
  
  public zzne(int paramInt, Map<String, String> paramMap)
  {
    zzD = ((String)paramMap.get("url"));
    zzTU = ((String)paramMap.get("base_uri"));
    zzTV = ((String)paramMap.get("post_parameters"));
    zzTX = parseBoolean((String)paramMap.get("drt_include"));
    zzTY = parseBoolean((String)paramMap.get("pan_include"));
    zzTT = ((String)paramMap.get("activation_overlay_url"));
    zzTS = zzaL((String)paramMap.get("check_packages"));
    zzOn = ((String)paramMap.get("request_id"));
    zzTW = ((String)paramMap.get("type"));
    zzTR = zzaL((String)paramMap.get("errors"));
    zzPF = paramInt;
    zzTZ = ((String)paramMap.get("fetched_ad"));
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private List<String> zzaL(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public int getErrorCode()
  {
    return zzPF;
  }
  
  public String getRequestId()
  {
    return zzOn;
  }
  
  public String getType()
  {
    return zzTW;
  }
  
  public String getUrl()
  {
    return zzD;
  }
  
  public void setUrl(String paramString)
  {
    zzD = paramString;
  }
  
  public List<String> zzji()
  {
    return zzTR;
  }
  
  public String zzjj()
  {
    return zzTU;
  }
  
  public String zzjk()
  {
    return zzTV;
  }
  
  public boolean zzjl()
  {
    return zzTX;
  }
  
  public String zzjm()
  {
    return zzTZ;
  }
}
