package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzko
{
  private final zzqp zzGt;
  private final String zzLX;
  
  public zzko(zzqp paramZzqp)
  {
    this(paramZzqp, "");
  }
  
  public zzko(zzqp paramZzqp, String paramString)
  {
    zzGt = paramZzqp;
    zzLX = paramString;
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      zzGt.zzb("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzb("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void zzaA(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("state", paramString);
      zzGt.zzb("onStateChanged", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzpe.zzb("Error occured while dispatching state change.", paramString);
    }
  }
  
  public void zzay(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("message", paramString).put("action", zzLX);
      zzGt.zzb("onError", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzpe.zzb("Error occurred while dispatching error event.", paramString);
    }
  }
  
  public void zzaz(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("js", paramString);
      zzGt.zzb("onReadyEventReceived", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzpe.zzb("Error occured while dispatching ready Event.", paramString);
    }
  }
  
  public void zzb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      zzGt.zzb("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzb("Error occured while dispatching size change.", localJSONException);
    }
  }
  
  public void zzc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      zzGt.zzb("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzb("Error occured while dispatching default position.", localJSONException);
    }
  }
}
