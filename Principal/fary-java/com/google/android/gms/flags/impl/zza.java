package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzaps;
import java.util.concurrent.Callable;

public abstract class zza<T>
{
  public static class zza
    extends zza<Boolean>
  {
    public static Boolean zza(SharedPreferences paramSharedPreferences, final String paramString, final Boolean paramBoolean)
    {
      (Boolean)zzaps.zzb(new Callable()
      {
        public Boolean zzkt()
        {
          return Boolean.valueOf(getBoolean(paramString, paramBoolean.booleanValue()));
        }
      });
    }
  }
  
  public static class zzb
    extends zza<Integer>
  {
    public static Integer zza(SharedPreferences paramSharedPreferences, final String paramString, final Integer paramInteger)
    {
      (Integer)zzaps.zzb(new Callable()
      {
        public Integer zzCS()
        {
          return Integer.valueOf(getInt(paramString, paramInteger.intValue()));
        }
      });
    }
  }
  
  public static class zzc
    extends zza<Long>
  {
    public static Long zza(SharedPreferences paramSharedPreferences, final String paramString, final Long paramLong)
    {
      (Long)zzaps.zzb(new Callable()
      {
        public Long zzCT()
        {
          return Long.valueOf(getLong(paramString, paramLong.longValue()));
        }
      });
    }
  }
  
  public static class zzd
    extends zza<String>
  {
    public static String zza(SharedPreferences paramSharedPreferences, final String paramString1, final String paramString2)
    {
      (String)zzaps.zzb(new Callable()
      {
        public String zzou()
        {
          return getString(paramString1, paramString2);
        }
      });
    }
  }
}
