package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlx
  implements zzlu.zza<zzgq>
{
  private final boolean zzQH;
  private final boolean zzQI;
  
  public zzlx(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzQH = paramBoolean1;
    zzQI = paramBoolean2;
  }
  
  public zzgq zzc(zzlu paramZzlu, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Object localObject = paramZzlu.zza(paramJSONObject, "images", true, zzQH, zzQI);
    zzqf localZzqf = paramZzlu.zza(paramJSONObject, "secondary_image", false, zzQH);
    paramZzlu = paramZzlu.zze(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((zzgo)((zzqf)((Iterator)localObject).next()).get());
    }
    return new zzgq(paramJSONObject.getString("headline"), localArrayList, paramJSONObject.getString("body"), (zzgz)localZzqf.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.getString("advertiser"), (zzgm)paramZzlu.get(), new Bundle());
  }
}
