package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzji
{
  public final String zzJG;
  public final String zzJH;
  public final List<String> zzJI;
  public final String zzJJ;
  public final String zzJK;
  public final List<String> zzJL;
  public final List<String> zzJM;
  public final List<String> zzJN;
  public final String zzJO;
  public final List<String> zzJP;
  public final List<String> zzJQ;
  @Nullable
  public final String zzJR;
  @Nullable
  public final String zzJS;
  public final String zzJT;
  @Nullable
  public final List<String> zzJU;
  public final String zzJV;
  
  public zzji(String paramString1, String paramString2, List<String> paramList1, String paramString3, String paramString4, List<String> paramList2, List<String> paramList3, String paramString5, String paramString6, List<String> paramList4, List<String> paramList5, String paramString7, String paramString8, String paramString9, List<String> paramList6, String paramString10, List<String> paramList7)
  {
    zzJG = paramString1;
    zzJH = paramString2;
    zzJI = paramList1;
    zzJJ = paramString3;
    zzJK = paramString4;
    zzJL = paramList2;
    zzJM = paramList3;
    zzJO = paramString5;
    zzJP = paramList4;
    zzJQ = paramList5;
    zzJR = paramString7;
    zzJS = paramString8;
    zzJT = paramString9;
    zzJU = paramList6;
    zzJV = paramString10;
    zzJN = paramList7;
  }
  
  public zzji(JSONObject paramJSONObject)
    throws JSONException
  {
    zzJH = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    Object localObject3 = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      ((List)localObject3).add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    zzJI = Collections.unmodifiableList((List)localObject3);
    zzJJ = paramJSONObject.optString("allocation_id", null);
    zzJL = zzv.zzdc().zza(paramJSONObject, "clickurl");
    zzJM = zzv.zzdc().zza(paramJSONObject, "imp_urls");
    zzJN = zzv.zzdc().zza(paramJSONObject, "fill_urls");
    zzJP = zzv.zzdc().zza(paramJSONObject, "video_start_urls");
    zzJQ = zzv.zzdc().zza(paramJSONObject, "video_complete_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).toString();
      zzJG = ((String)localObject1);
      localObject3 = paramJSONObject.optJSONObject("data");
      if (localObject3 == null) {
        break label301;
      }
      localObject1 = ((JSONObject)localObject3).toString();
      label192:
      zzJO = ((String)localObject1);
      if (localObject3 == null) {
        break label306;
      }
      localObject1 = ((JSONObject)localObject3).optString("class_name");
      label210:
      zzJK = ((String)localObject1);
      zzJR = paramJSONObject.optString("html_template", null);
      zzJS = paramJSONObject.optString("ad_base_url", null);
      localObject1 = paramJSONObject.optJSONObject("assets");
      if (localObject1 == null) {
        break label311;
      }
    }
    label301:
    label306:
    label311:
    for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
    {
      zzJT = ((String)localObject1);
      zzJU = zzv.zzdc().zza(paramJSONObject, "template_ids");
      localObject1 = paramJSONObject.optJSONObject("ad_loader_options");
      paramJSONObject = localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).toString();
      }
      zzJV = paramJSONObject;
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label192;
      localObject1 = null;
      break label210;
    }
  }
}
