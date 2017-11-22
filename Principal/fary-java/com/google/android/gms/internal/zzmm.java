package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzmm
  extends zza
{
  public static final Parcelable.Creator<zzmm> CREATOR = new zzmn();
  public final int versionCode;
  public final boolean zzSi;
  @Nullable
  public final List<String> zzSj;
  
  public zzmm()
  {
    this(1, false, Collections.emptyList());
  }
  
  public zzmm(int paramInt, boolean paramBoolean, List<String> paramList)
  {
    versionCode = paramInt;
    zzSi = paramBoolean;
    zzSj = paramList;
  }
  
  public zzmm(boolean paramBoolean)
  {
    this(1, paramBoolean, Collections.emptyList());
  }
  
  public zzmm(boolean paramBoolean, List<String> paramList)
  {
    this(1, paramBoolean, paramList);
  }
  
  @Nullable
  public static zzmm zzg(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new zzmm();
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("reporting_urls");
    ArrayList localArrayList = new ArrayList();
    if (localJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < localJSONArray.length()) {
          try
          {
            localArrayList.add(localJSONArray.getString(i));
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              zzpe.zzc("Error grabbing url from json.", localJSONException);
            }
          }
        }
      }
    }
    return new zzmm(paramJSONObject.optBoolean("enable_protection"), localArrayList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzmn.zza(this, paramParcel, paramInt);
  }
}
