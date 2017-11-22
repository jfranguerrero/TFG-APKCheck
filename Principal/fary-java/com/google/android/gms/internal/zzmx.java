package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@zzmb
public class zzmx
{
  @Nullable
  public String zzRf;
  @Nullable
  public Bundle zzRk;
  @Nullable
  public List<String> zzRs = new ArrayList();
  @Nullable
  public Bundle zzSC;
  @Nullable
  public zznj.zza zzSD;
  @Nullable
  public String zzSE;
  public zzmh zzSF;
  public zznf zzSG;
  public JSONObject zzSH = new JSONObject();
  @Nullable
  public Location zzyN;
  
  public zzmx() {}
  
  public zzmx zza(zznf paramZznf)
  {
    zzSG = paramZznf;
    return this;
  }
  
  public zzmx zza(zznj.zza paramZza)
  {
    zzSD = paramZza;
    return this;
  }
  
  public zzmx zzaJ(String paramString)
  {
    zzRf = paramString;
    return this;
  }
  
  public zzmx zzaK(String paramString)
  {
    zzSE = paramString;
    return this;
  }
  
  public zzmx zzc(Location paramLocation)
  {
    zzyN = paramLocation;
    return this;
  }
  
  public zzmx zze(Bundle paramBundle)
  {
    zzSC = paramBundle;
    return this;
  }
  
  public zzmx zzf(Bundle paramBundle)
  {
    zzRk = paramBundle;
    return this;
  }
  
  public zzmx zzf(zzmh paramZzmh)
  {
    zzSF = paramZzmh;
    return this;
  }
  
  public zzmx zzh(JSONObject paramJSONObject)
  {
    zzSH = paramJSONObject;
    return this;
  }
  
  public zzmx zzk(List<String> paramList)
  {
    if (paramList == null) {
      zzRs.clear();
    }
    zzRs = paramList;
    return this;
  }
}
