package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzct
  implements zzcu
{
  private final zzhx zzwA = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      if (!zzct.zza(zzct.this).zzb(paramAnonymousMap)) {
        return;
      }
      zzct.zza(zzct.this).zza(zzct.this, paramAnonymousMap);
    }
  };
  private final zzhx zzwB = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      if (!zzct.zza(zzct.this).zzb(paramAnonymousMap)) {
        return;
      }
      zzct.zza(zzct.this).zzc(paramAnonymousMap);
    }
  };
  private zzja.zzc zzwD;
  private boolean zzwE;
  private final zzcq zzwx;
  private final zzhx zzwz = new zzhx()
  {
    public void zza(zzqp paramAnonymousZzqp, Map<String, String> paramAnonymousMap)
    {
      if (!zzct.zza(zzct.this).zzb(paramAnonymousMap)) {
        return;
      }
      zzct.zza(zzct.this).zzb(paramAnonymousZzqp, paramAnonymousMap);
    }
  };
  
  public zzct(zzcq paramZzcq, zzja paramZzja)
  {
    zzwx = paramZzcq;
    zzwD = paramZzja.zzgv();
    zzwD.zza(new zzqi.zzc()new zzqi.zza
    {
      public void zzb(zzjb paramAnonymousZzjb)
      {
        zzct.zza(zzct.this, true);
        zzc(paramAnonymousZzjb);
      }
    }, new zzqi.zza()
    {
      public void run()
      {
        zzct.zza(zzct.this).zzb(zzct.this);
      }
    });
    paramZzcq = String.valueOf(zzwx.zzdN().zzdy());
    if (paramZzcq.length() != 0) {}
    for (paramZzcq = "Core JS tracking ad unit: ".concat(paramZzcq);; paramZzcq = new String("Core JS tracking ad unit: "))
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
  
  public void zzc(final JSONObject paramJSONObject, boolean paramBoolean)
  {
    zzwD.zza(new zzqi.zzc()new zzqi.zzb
    {
      public void zzb(zzjb paramAnonymousZzjb)
      {
        paramAnonymousZzjb.zza("AFMA_updateActiveView", paramJSONObject);
      }
    }, new zzqi.zzb());
  }
  
  void zzd(zzjb paramZzjb)
  {
    paramZzjb.zzb("/visibilityChanged", zzwB);
    paramZzjb.zzb("/untrackActiveViewUnit", zzwA);
    paramZzjb.zzb("/updateActiveView", zzwz);
  }
  
  public boolean zzdR()
  {
    return zzwE;
  }
  
  public void zzdS()
  {
    zzwD.zza(new zzqi.zzc()new zzqi.zzb
    {
      public void zzb(zzjb paramAnonymousZzjb)
      {
        zzd(paramAnonymousZzjb);
      }
    }, new zzqi.zzb());
    zzwD.release();
  }
}
