package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzon
  extends zza
{
  public static final Parcelable.Creator<zzon> CREATOR = new zzoo();
  public final int versionCode;
  public final String zzVk;
  public final String zzVl;
  public final boolean zzVm;
  public final boolean zzVn;
  public final List<String> zzVo;
  
  public zzon(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
  {
    versionCode = paramInt;
    zzVk = paramString1;
    zzVl = paramString2;
    zzVm = paramBoolean1;
    zzVn = paramBoolean2;
    zzVo = paramList;
  }
  
  @Nullable
  public static zzon zzi(JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    String str1 = paramJSONObject.optString("click_string", "");
    String str2 = paramJSONObject.optString("report_url", "");
    boolean bool1 = paramJSONObject.optBoolean("rendered_ad_enabled", false);
    boolean bool2 = paramJSONObject.optBoolean("non_malicious_reporting_enabled", false);
    Object localObject = paramJSONObject.optJSONArray("allowed_headers");
    paramJSONObject = (JSONObject)localObject;
    if (localObject == null) {
      paramJSONObject = new JSONArray();
    }
    localObject = new ArrayList();
    while (i < paramJSONObject.length())
    {
      String str3 = paramJSONObject.optString(i);
      if (!TextUtils.isEmpty(str3)) {
        ((ArrayList)localObject).add(str3.toLowerCase(Locale.ENGLISH));
      }
      i += 1;
    }
    return new zzon(2, str1, str2, bool1, bool2, (List)localObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzoo.zza(this, paramParcel, paramInt);
  }
}
