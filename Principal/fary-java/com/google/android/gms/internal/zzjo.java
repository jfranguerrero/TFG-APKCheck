package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzjo
{
  public zzjo() {}
  
  public List<String> zza(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new ArrayList(paramJSONObject.length());
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramString.add(paramJSONObject.getString(i));
        i += 1;
      }
      return Collections.unmodifiableList(paramString);
    }
    return null;
  }
  
  public void zza(Context paramContext, String paramString1, zzov paramZzov, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str).replaceAll("@gw_qdata@", zzVr.zzKd).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", zzv.zzcN().getSessionId()).replaceAll("@gw_seqnum@", zzRg);
        paramList = (List<String>)localObject;
        if (!TextUtils.isEmpty(zzVs)) {
          paramList = ((String)localObject).replaceAll("@gw_adnetstatus@", zzVs);
        }
        localObject = paramList;
        if (zzKA != null) {
          localObject = paramList.replaceAll("@gw_adnetid@", zzKA.zzJH).replaceAll("@gw_allocid@", zzKA.zzJJ);
        }
        new zzps(paramContext, paramString1, (String)localObject).zziw();
      }
      break;
    }
  }
}
