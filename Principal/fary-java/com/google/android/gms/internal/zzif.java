package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzif
  implements zzhx
{
  private final Map<String, zza> zzHR = new HashMap();
  private final Object zzrN = new Object();
  
  public zzif() {}
  
  public void zza(zzqp paramZzqp, Map<String, String> arg2)
  {
    paramZzqp = (String)???.get("id");
    String str1 = (String)???.get("fail");
    ???.get("fail_reason");
    String str2 = (String)???.get("result");
    synchronized (zzrN)
    {
      if ((zza)zzHR.remove(paramZzqp) == null)
      {
        paramZzqp = String.valueOf(paramZzqp);
        if (paramZzqp.length() != 0)
        {
          paramZzqp = "Received result for unexpected method invocation: ".concat(paramZzqp);
          zzpe.zzbe(paramZzqp);
          return;
        }
        paramZzqp = new String("Received result for unexpected method invocation: ");
      }
    }
    if (!TextUtils.isEmpty(str1)) {
      return;
    }
    if (str2 == null) {
      return;
    }
    try
    {
      new JSONObject(str2);
      return;
    }
    catch (JSONException paramZzqp)
    {
      for (;;)
      {
        paramZzqp.getMessage();
      }
    }
  }
  
  public static abstract interface zza {}
}
