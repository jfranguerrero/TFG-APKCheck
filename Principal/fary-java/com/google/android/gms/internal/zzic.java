package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzic
  implements zzhx
{
  final HashMap<String, zzqc<JSONObject>> zzHM = new HashMap();
  
  public zzic() {}
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    zzh((String)paramMap.get("request_id"), (String)paramMap.get("fetched_ad"));
  }
  
  public Future<JSONObject> zzab(String paramString)
  {
    zzqc localZzqc = new zzqc();
    zzHM.put(paramString, localZzqc);
    return localZzqc;
  }
  
  public void zzac(String paramString)
  {
    zzqc localZzqc = (zzqc)zzHM.get(paramString);
    if (localZzqc == null)
    {
      zzpe.e("Could not find the ad request for the corresponding ad response.");
      return;
    }
    if (!localZzqc.isDone()) {
      localZzqc.cancel(true);
    }
    zzHM.remove(paramString);
  }
  
  public void zzh(String paramString1, String paramString2)
  {
    zzpe.zzbc("Received ad from the cache.");
    zzqc localZzqc = (zzqc)zzHM.get(paramString1);
    if (localZzqc == null)
    {
      zzpe.e("Could not find the ad request for the corresponding ad response.");
      return;
    }
    try
    {
      localZzqc.zzh(new JSONObject(paramString2));
      return;
    }
    catch (JSONException paramString2)
    {
      zzpe.zzb("Failed constructing JSON object from value passed from javascript", paramString2);
      localZzqc.zzh(null);
      return;
    }
    finally
    {
      zzHM.remove(paramString1);
    }
  }
}
