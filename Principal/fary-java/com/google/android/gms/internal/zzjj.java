package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzjj
{
  public final List<zzji> zzJW;
  public final long zzJX;
  public final List<String> zzJY;
  public final List<String> zzJZ;
  public final List<String> zzKa;
  public final List<String> zzKb;
  public final boolean zzKc;
  public final String zzKd;
  public final long zzKe;
  public final String zzKf;
  public final int zzKg;
  public final int zzKh;
  public final long zzKi;
  public final boolean zzKj;
  public int zzKk;
  public int zzKl;
  
  public zzjj(String paramString)
    throws JSONException
  {
    Object localObject = new JSONObject(paramString);
    if (zzpe.zzai(2))
    {
      paramString = String.valueOf(((JSONObject)localObject).toString(2));
      if (paramString.length() == 0) {
        break label138;
      }
    }
    ArrayList localArrayList;
    int j;
    label138:
    for (paramString = "Mediation Response JSON: ".concat(paramString);; paramString = new String("Mediation Response JSON: "))
    {
      zzpe.v(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("ad_networks");
      localArrayList = new ArrayList(paramString.length());
      int i = 0;
      int k;
      for (j = -1; i < paramString.length(); j = k)
      {
        zzji localZzji = new zzji(paramString.getJSONObject(i));
        localArrayList.add(localZzji);
        k = j;
        if (j < 0)
        {
          k = j;
          if (zza(localZzji)) {
            k = i;
          }
        }
        i += 1;
      }
    }
    zzKk = j;
    zzKl = paramString.length();
    zzJW = Collections.unmodifiableList(localArrayList);
    zzKd = ((JSONObject)localObject).getString("qdata");
    zzKh = ((JSONObject)localObject).optInt("fs_model_type", -1);
    zzKi = ((JSONObject)localObject).optLong("timeout_ms", -1L);
    paramString = ((JSONObject)localObject).optJSONObject("settings");
    if (paramString != null)
    {
      zzJX = paramString.optLong("ad_network_timeout_millis", -1L);
      zzJY = zzv.zzdc().zza(paramString, "click_urls");
      zzJZ = zzv.zzdc().zza(paramString, "imp_urls");
      zzKa = zzv.zzdc().zza(paramString, "nofill_urls");
      zzKb = zzv.zzdc().zza(paramString, "remote_ping_urls");
      zzKc = paramString.optBoolean("render_in_browser", false);
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L)
      {
        l *= 1000L;
        zzKe = l;
        localObject = zzok.zza(paramString.optJSONArray("rewards"));
        if (localObject != null) {
          break label376;
        }
        zzKf = null;
      }
      for (zzKg = 0;; zzKg = zzVj)
      {
        zzKj = paramString.optBoolean("use_displayed_impression", false);
        return;
        l = -1L;
        break;
        label376:
        zzKf = type;
      }
    }
    zzJX = -1L;
    zzJY = null;
    zzJZ = null;
    zzKa = null;
    zzKb = null;
    zzKe = -1L;
    zzKf = null;
    zzKg = 0;
    zzKj = false;
    zzKc = false;
  }
  
  public zzjj(List<zzji> paramList, long paramLong1, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, boolean paramBoolean1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2)
  {
    zzJW = paramList;
    zzJX = paramLong1;
    zzJY = paramList1;
    zzJZ = paramList2;
    zzKa = paramList3;
    zzKb = paramList4;
    zzKc = paramBoolean1;
    zzKd = paramString1;
    zzKe = paramLong2;
    zzKk = paramInt1;
    zzKl = paramInt2;
    zzKf = paramString2;
    zzKg = paramInt3;
    zzKh = paramInt4;
    zzKi = paramLong3;
    zzKj = paramBoolean2;
  }
  
  private boolean zza(zzji paramZzji)
  {
    paramZzji = zzJI.iterator();
    while (paramZzji.hasNext()) {
      if (((String)paramZzji.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}
