package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzkm
{
  private final boolean zzLJ;
  private final boolean zzLK;
  private final boolean zzLL;
  private final boolean zzLM;
  private final boolean zzLN;
  
  private zzkm(zza paramZza)
  {
    zzLJ = zza.zza(paramZza);
    zzLK = zza.zzb(paramZza);
    zzLL = zza.zzc(paramZza);
    zzLM = zza.zzd(paramZza);
    zzLN = zza.zze(paramZza);
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", zzLJ).put("tel", zzLK).put("calendar", zzLL).put("storePicture", zzLM).put("inlineVideo", zzLN);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzpe.zzb("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
  
  public static final class zza
  {
    private boolean zzLJ;
    private boolean zzLK;
    private boolean zzLL;
    private boolean zzLM;
    private boolean zzLN;
    
    public zza() {}
    
    public zzkm zzgT()
    {
      return new zzkm(this, null);
    }
    
    public zza zzt(boolean paramBoolean)
    {
      zzLJ = paramBoolean;
      return this;
    }
    
    public zza zzu(boolean paramBoolean)
    {
      zzLK = paramBoolean;
      return this;
    }
    
    public zza zzv(boolean paramBoolean)
    {
      zzLL = paramBoolean;
      return this;
    }
    
    public zza zzw(boolean paramBoolean)
    {
      zzLM = paramBoolean;
      return this;
    }
    
    public zza zzx(boolean paramBoolean)
    {
      zzLN = paramBoolean;
      return this;
    }
  }
}
