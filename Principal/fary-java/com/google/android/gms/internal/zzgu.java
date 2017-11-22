package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public abstract interface zzgu
{
  public abstract Context getContext();
  
  public abstract void zza(View paramView1, String paramString, JSONObject paramJSONObject, Map<String, WeakReference<View>> paramMap, View paramView2);
  
  public abstract void zza(View paramView1, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject, View paramView2);
  
  public abstract void zzb(View paramView, Map<String, WeakReference<View>> paramMap);
  
  public abstract void zzc(View paramView, Map<String, WeakReference<View>> paramMap);
  
  public abstract void zzd(MotionEvent paramMotionEvent);
  
  public abstract void zzd(View paramView, Map<String, WeakReference<View>> paramMap);
  
  public abstract View zzfV();
  
  public abstract void zzj(View paramView);
  
  public static abstract interface zza
  {
    public abstract String getCustomTemplateId();
    
    public abstract void zzb(zzgu paramZzgu);
    
    public abstract String zzfN();
    
    public abstract zzgm zzfO();
  }
}
