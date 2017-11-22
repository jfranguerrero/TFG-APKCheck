package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzaps;
import java.util.concurrent.Callable;

public class zzb
{
  private static SharedPreferences zzaWS = null;
  
  public static SharedPreferences zzm(Context paramContext)
  {
    try
    {
      if (zzaWS == null) {
        zzaWS = (SharedPreferences)zzaps.zzb(new Callable()
        {
          public SharedPreferences zzCU()
          {
            return getSharedPreferences("google_sdk_flags", 1);
          }
        });
      }
      paramContext = zzaWS;
      return paramContext;
    }
    finally {}
  }
}
