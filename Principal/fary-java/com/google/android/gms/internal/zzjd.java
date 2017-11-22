package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzmb
public class zzjd
  implements zzjc
{
  private final zzjb zzJE;
  private final HashSet<AbstractMap.SimpleEntry<String, zzhx>> zzJF;
  
  public zzjd(zzjb paramZzjb)
  {
    zzJE = paramZzjb;
    zzJF = new HashSet();
  }
  
  public void zza(String paramString, zzhx paramZzhx)
  {
    zzJE.zza(paramString, paramZzhx);
    zzJF.add(new AbstractMap.SimpleEntry(paramString, paramZzhx));
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    zzJE.zza(paramString, paramJSONObject);
  }
  
  public void zzb(String paramString, zzhx paramZzhx)
  {
    zzJE.zzb(paramString, paramZzhx);
    zzJF.remove(new AbstractMap.SimpleEntry(paramString, paramZzhx));
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzJE.zzb(paramString, paramJSONObject);
  }
  
  public void zzgA()
  {
    Iterator localIterator = zzJF.iterator();
    if (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      String str = String.valueOf(((zzhx)localSimpleEntry.getValue()).toString());
      if (str.length() != 0) {}
      for (str = "Unregistering eventhandler: ".concat(str);; str = new String("Unregistering eventhandler: "))
      {
        zzpe.v(str);
        zzJE.zzb((String)localSimpleEntry.getKey(), (zzhx)localSimpleEntry.getValue());
        break;
      }
    }
    zzJF.clear();
  }
  
  public void zzi(String paramString1, String paramString2)
  {
    zzJE.zzi(paramString1, paramString2);
  }
}
