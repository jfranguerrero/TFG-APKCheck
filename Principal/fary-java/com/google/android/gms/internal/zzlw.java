package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlw
  implements zzlu.zza<zzgp>
{
  private final boolean zzQH;
  private final boolean zzQI;
  
  public zzlw(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzQH = paramBoolean1;
    zzQI = paramBoolean2;
  }
  
  private zzqp zzb(zzqf<zzqp> paramZzqf)
  {
    try
    {
      paramZzqf = (zzqp)paramZzqf.get(((Integer)zzfx.zzDY.get()).intValue(), TimeUnit.SECONDS);
      return paramZzqf;
    }
    catch (InterruptedException paramZzqf)
    {
      zzpe.zzc("InterruptedException occurred while waiting for video to load", paramZzqf);
      Thread.currentThread().interrupt();
      return null;
    }
    catch (ExecutionException paramZzqf)
    {
      for (;;)
      {
        zzpe.zzc("Exception occurred while waiting for video to load", paramZzqf);
      }
    }
    catch (CancellationException paramZzqf)
    {
      for (;;) {}
    }
    catch (TimeoutException paramZzqf)
    {
      for (;;) {}
    }
  }
  
  public zzgp zzb(zzlu paramZzlu, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Object localObject2 = paramZzlu.zza(paramJSONObject, "images", true, zzQH, zzQI);
    Object localObject3 = paramZzlu.zza(paramJSONObject, "app_icon", true, zzQH);
    Object localObject1 = paramZzlu.zzc(paramJSONObject, "video");
    paramZzlu = paramZzlu.zze(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add((zzgo)((zzqf)((Iterator)localObject2).next()).get());
    }
    zzqp localZzqp = zzb((zzqf)localObject1);
    localObject1 = paramJSONObject.getString("headline");
    localObject2 = paramJSONObject.getString("body");
    localObject3 = (zzgz)((Future)localObject3).get();
    String str1 = paramJSONObject.getString("call_to_action");
    double d = paramJSONObject.optDouble("rating", -1.0D);
    String str2 = paramJSONObject.optString("store");
    String str3 = paramJSONObject.optString("price");
    zzgm localZzgm = (zzgm)paramZzlu.get();
    Bundle localBundle = new Bundle();
    if (localZzqp != null)
    {
      paramZzlu = localZzqp.zzlg();
      if (localZzqp == null) {
        break label254;
      }
    }
    label254:
    for (paramJSONObject = localZzqp.getView();; paramJSONObject = null)
    {
      return new zzgp((String)localObject1, localArrayList, (String)localObject2, (zzgz)localObject3, str1, d, str2, str3, localZzgm, localBundle, paramZzlu, paramJSONObject);
      paramZzlu = null;
      break;
    }
  }
}
