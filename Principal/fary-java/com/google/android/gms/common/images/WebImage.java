package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  extends zza
{
  public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
  final int mVersionCode;
  private final Uri zzarW;
  private final int zzrG;
  private final int zzrH;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzarW = paramUri;
    zzrG = paramInt2;
    zzrH = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null) {
      throw new IllegalArgumentException("url cannot be null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("width and height must not be negative");
    }
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(zzs(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri zzs(JSONObject paramJSONObject)
  {
    Uri localUri = null;
    if (paramJSONObject.has("url")) {}
    try
    {
      localUri = Uri.parse(paramJSONObject.getString("url"));
      return localUri;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      paramObject = (WebImage)paramObject;
    } while ((zzaa.equal(zzarW, zzarW)) && (zzrG == zzrG) && (zzrH == zzrH));
    return false;
  }
  
  public int getHeight()
  {
    return zzrH;
  }
  
  public Uri getUrl()
  {
    return zzarW;
  }
  
  public int getWidth()
  {
    return zzrG;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { zzarW, Integer.valueOf(zzrG), Integer.valueOf(zzrH) });
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", zzarW.toString());
      localJSONObject.put("width", zzrG);
      localJSONObject.put("height", zzrH);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(zzrG), Integer.valueOf(zzrH), zzarW.toString() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}
