package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzmb
public class zzkw
  extends Handler
{
  private final zzkv zzOF;
  
  public zzkw(Context paramContext)
  {
    this(new zzkx(localContext));
  }
  
  public zzkw(zzkv paramZzkv)
  {
    zzOF = paramZzkv;
  }
  
  private void zzc(JSONObject paramJSONObject)
  {
    try
    {
      zzOF.zza(paramJSONObject.getString("request_id"), paramJSONObject.getString("base_url"), paramJSONObject.getString("html"));
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        return;
      }
      paramMessage = new JSONObject(paramMessage.getString("data"));
      if ("fetch_html".equals(paramMessage.getString("message_name")))
      {
        zzc(paramMessage);
        return;
      }
    }
    catch (Exception paramMessage) {}
  }
}
