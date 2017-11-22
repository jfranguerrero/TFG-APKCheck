package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzox
{
  private final long zzVN;
  private final List<String> zzVO = new ArrayList();
  private final Map<String, zzb> zzVP = new HashMap();
  private String zzVQ;
  private String zzVR;
  private boolean zzVS = false;
  
  public zzox(String paramString, long paramLong)
  {
    zzVR = paramString;
    zzVN = paramLong;
    zzaR(paramString);
  }
  
  private void zzaR(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("status", -1) != 1)
        {
          zzVS = false;
          zzpe.zzbe("App settings could not be fetched successfully.");
          return;
        }
      }
      catch (JSONException paramString)
      {
        zzpe.zzc("Exception occurred while processing app setting json", paramString);
        zzv.zzcN().zza(paramString, "AppSettings.parseAppSettingsJson");
        return;
      }
      zzVS = true;
      zzVQ = paramString.optString("app_id");
      paramString = paramString.optJSONArray("ad_unit_id_settings");
      if (paramString != null) {
        while (i < paramString.length())
        {
          zzj(paramString.getJSONObject(i));
          i += 1;
        }
      }
    }
  }
  
  private void zzj(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject1 = paramJSONObject.optString("format");
    String str1 = paramJSONObject.optString("ad_unit_id");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {}
    int i;
    label92:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ("interstitial".equalsIgnoreCase((String)localObject1))
              {
                zzVO.add(str1);
                return;
              }
            } while (!"rewarded".equalsIgnoreCase((String)localObject1));
            paramJSONObject = paramJSONObject.optJSONObject("mediation_config");
          } while (paramJSONObject == null);
          localObject1 = paramJSONObject.optJSONArray("ad_networks");
        } while (localObject1 == null);
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        localObject3 = ((JSONObject)localObject2).optJSONArray("adapters");
      } while (localObject3 == null);
      paramJSONObject = new ArrayList();
      int j = 0;
      while (j < ((JSONArray)localObject3).length())
      {
        paramJSONObject.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      localObject2 = ((JSONObject)localObject2).optJSONObject("data");
    } while (localObject2 == null);
    Object localObject3 = new Bundle();
    Iterator localIterator = ((JSONObject)localObject2).keys();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      ((Bundle)localObject3).putString(str2, ((JSONObject)localObject2).getString(str2));
    }
    Object localObject2 = new zza(paramJSONObject, (Bundle)localObject3);
    if (zzVP.containsKey(str1)) {}
    for (paramJSONObject = (zzb)zzVP.get(str1);; paramJSONObject = new zzb())
    {
      paramJSONObject.zza((zza)localObject2);
      zzVP.put(str1, paramJSONObject);
      i += 1;
      break label92;
      break;
    }
  }
  
  public long zzjF()
  {
    return zzVN;
  }
  
  public boolean zzjG()
  {
    return zzVS;
  }
  
  public String zzjH()
  {
    return zzVR;
  }
  
  public String zzjI()
  {
    return zzVQ;
  }
  
  class zza
  {
    private final List<String> zzVT;
    private final Bundle zzVU;
    
    public zza(Bundle paramBundle)
    {
      zzVT = paramBundle;
      Object localObject;
      zzVU = localObject;
    }
  }
  
  class zzb
  {
    final List<zzox.zza> zzVV = new ArrayList();
    
    zzb() {}
    
    public void zza(zzox.zza paramZza)
    {
      zzVV.add(paramZza);
    }
  }
}
