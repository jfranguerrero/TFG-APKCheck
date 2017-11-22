package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzmb
public final class zzpg
{
  public static Future zza(Context paramContext, final int paramInt)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putInt("request_in_session_count", paramInt);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zza(Context paramContext, final long paramLong)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putLong("app_last_background_time_ms", paramLong);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zza(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("use_https", localSharedPreferences.getBoolean("use_https", true));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zza(Context paramContext, final String paramString, final long paramLong)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putString("app_settings_json", paramString);
        localEditor.putLong("app_settings_last_update_ms", paramLong);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zzb(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_cache_version", localSharedPreferences.getInt("webview_cache_version", 0));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zzc(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("content_url_opted_out", localSharedPreferences.getBoolean("content_url_opted_out", true));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zzc(Context paramContext, final boolean paramBoolean)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putBoolean("use_https", paramBoolean);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zzd(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("content_url_hashes", localSharedPreferences.getString("content_url_hashes", ""));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zze(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("auto_collect_location", localSharedPreferences.getBoolean("auto_collect_location", false));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zze(Context paramContext, final boolean paramBoolean)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putBoolean("content_url_opted_out", paramBoolean);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zzf(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("app_settings_json", localSharedPreferences.getString("app_settings_json", ""));
        localBundle.putLong("app_settings_last_update_ms", localSharedPreferences.getLong("app_settings_last_update_ms", 0L));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zzf(Context paramContext, final String paramString)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putString("content_url_hashes", paramString);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zzf(Context paramContext, final boolean paramBoolean)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putBoolean("auto_collect_location", paramBoolean);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static Future zzg(Context paramContext, final zzb paramZzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences localSharedPreferences = zzpg.zzm(zzpg.this);
        Bundle localBundle = new Bundle();
        localBundle.putLong("app_last_background_time_ms", localSharedPreferences.getLong("app_last_background_time_ms", 0L));
        if (paramZzb != null) {
          paramZzb.zzh(localBundle);
        }
      }
    }.zziw();
  }
  
  public static Future zzg(Context paramContext, final String paramString)
  {
    (Future)new zza(paramContext)
    {
      public void zzcm()
      {
        SharedPreferences.Editor localEditor = zzpg.zzm(zzpg.this).edit();
        localEditor.putString("content_vertical_hashes", paramString);
        localEditor.apply();
      }
    }.zziw();
  }
  
  public static SharedPreferences zzm(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }
  
  private static abstract class zza
    extends zzpd
  {
    private zza() {}
    
    public void onStop() {}
  }
  
  public static abstract interface zzb
  {
    public abstract void zzh(Bundle paramBundle);
  }
}
