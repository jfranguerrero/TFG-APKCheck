package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzcs
  implements zzcu
{
  private final zzhx zzwA = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      zzcs.zza(zzcs.this).zza(zzcs.this, paramAnonymousMap);
    }
  };
  private final zzhx zzwB = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      zzcs.zza(zzcs.this).zzc(paramAnonymousMap);
    }
  };
  private final zzcq zzwx;
  private final zzjb zzwy;
  private final zzhx zzwz = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      zzcs.zza(zzcs.this).zzb(paramAnonymousZzqp, paramAnonymousMap);
    }
  };
  
  public zzcs(zzcq paramZzcq, zzjb paramZzjb)
  {
    zzwx = paramZzcq;
    zzwy = paramZzjb;
    zzc(zzwy);
    paramZzcq = String.valueOf(zzwx.zzdN().zzdy());
    if (paramZzcq.length() != 0) {}
    for (paramZzcq = "Custom JS tracking ad unit: ".concat(paramZzcq);; paramZzcq = new String("Custom JS tracking ad unit: "))
    {
      zzpe.zzbc(paramZzcq);
      return;
    }
  }
  
  void zzc(zzjb paramZzjb)
  {
    paramZzjb.zza("/updateActiveView", zzwz);
    paramZzjb.zza("/untrackActiveViewUnit", zzwA);
    paramZzjb.zza("/visibilityChanged", zzwB);
  }
  
  public void zzc(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      zzwy.zza("AFMA_updateActiveView", paramJSONObject);
      return;
    }
    zzwx.zzb(this);
  }
  
  void zzd(zzjb paramZzjb)
  {
    paramZzjb.zzb("/visibilityChanged", zzwB);
    paramZzjb.zzb("/untrackActiveViewUnit", zzwA);
    paramZzjb.zzb("/updateActiveView", zzwz);
  }
  
  public boolean zzdR()
  {
    return true;
  }
  
  public void zzdS()
  {
    zzd(zzwy);
  }
}
