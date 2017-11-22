package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzly
  implements zzlu.zza<zzgr>
{
  private final boolean zzQH;
  
  public zzly(boolean paramBoolean)
  {
    zzQH = paramBoolean;
  }
  
  private void zza(zzlu paramZzlu, JSONObject paramJSONObject, SimpleArrayMap<String, Future<zzgo>> paramSimpleArrayMap)
    throws JSONException
  {
    paramSimpleArrayMap.put(paramJSONObject.getString("name"), paramZzlu.zza(paramJSONObject, "image_value", zzQH));
  }
  
  private void zza(JSONObject paramJSONObject, SimpleArrayMap<String, String> paramSimpleArrayMap)
    throws JSONException
  {
    paramSimpleArrayMap.put(paramJSONObject.getString("name"), paramJSONObject.getString("string_value"));
  }
  
  private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> paramSimpleArrayMap)
    throws InterruptedException, ExecutionException
  {
    SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
    int i = 0;
    while (i < paramSimpleArrayMap.size())
    {
      localSimpleArrayMap.put(paramSimpleArrayMap.keyAt(i), ((Future)paramSimpleArrayMap.valueAt(i)).get());
      i += 1;
    }
    return localSimpleArrayMap;
  }
  
  public zzgr zzd(zzlu paramZzlu, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    SimpleArrayMap localSimpleArrayMap1 = new SimpleArrayMap();
    SimpleArrayMap localSimpleArrayMap2 = new SimpleArrayMap();
    zzqf localZzqf = paramZzlu.zze(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.getJSONArray("custom_assets");
    int i = 0;
    if (i < localJSONArray.length())
    {
      Object localObject = localJSONArray.getJSONObject(i);
      String str = ((JSONObject)localObject).getString("type");
      if ("string".equals(str)) {
        zza((JSONObject)localObject, localSimpleArrayMap2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!"image".equals(str)) {
          break label108;
        }
        zza(paramZzlu, (JSONObject)localObject, localSimpleArrayMap1);
      }
      label108:
      localObject = String.valueOf(str);
      if (((String)localObject).length() != 0) {}
      for (localObject = "Unknown custom asset type: ".concat((String)localObject);; localObject = new String("Unknown custom asset type: "))
      {
        zzpe.zzbe((String)localObject);
        break;
      }
    }
    return new zzgr(paramJSONObject.getString("custom_template_id"), zzc(localSimpleArrayMap1), localSimpleArrayMap2, (zzgm)localZzqf.get());
  }
}
