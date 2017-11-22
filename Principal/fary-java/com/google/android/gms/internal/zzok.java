package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzok
  extends zza
{
  public static final Parcelable.Creator<zzok> CREATOR = new zzol();
  public final String type;
  public final int versionCode;
  public final int zzVj;
  
  public zzok(int paramInt1, String paramString, int paramInt2)
  {
    versionCode = paramInt1;
    type = paramString;
    zzVj = paramInt2;
  }
  
  public zzok(RewardItem paramRewardItem)
  {
    this(1, paramRewardItem.getType(), paramRewardItem.getAmount());
  }
  
  public zzok(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  @Nullable
  public static zzok zza(JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    return new zzok(paramJSONArray.getJSONObject(0).optString("rb_type"), paramJSONArray.getJSONObject(0).optInt("rb_amount"));
  }
  
  @Nullable
  public static zzok zzaQ(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = zza(new JSONArray(paramString));
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzok))) {}
    do
    {
      return false;
      paramObject = (zzok)paramObject;
    } while ((!zzaa.equal(type, type)) || (!zzaa.equal(Integer.valueOf(zzVj), Integer.valueOf(zzVj))));
    return true;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { type, Integer.valueOf(zzVj) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzol.zza(this, paramParcel, paramInt);
  }
  
  public JSONArray zzjy()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("rb_type", type);
    localJSONObject.put("rb_amount", zzVj);
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(localJSONObject);
    return localJSONArray;
  }
}
