package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras
  implements NetworkExtras
{
  private final HashMap<String, Object> zzZV = new HashMap();
  
  public CustomEventExtras() {}
  
  public Object getExtra(String paramString)
  {
    return zzZV.get(paramString);
  }
  
  public void setExtra(String paramString, Object paramObject)
  {
    zzZV.put(paramString, paramObject);
  }
}
