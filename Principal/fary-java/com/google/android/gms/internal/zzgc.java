package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zzmb
public abstract class zzgc
{
  @zzmb
  public static final zzgc zzFk = new zzgc()
  {
    public String zzf(@Nullable String paramAnonymousString1, String paramAnonymousString2)
    {
      return paramAnonymousString2;
    }
  };
  @zzmb
  public static final zzgc zzFl = new zzgc()
  {
    public String zzf(@Nullable String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1 != null) {
        return paramAnonymousString1;
      }
      return paramAnonymousString2;
    }
  };
  @zzmb
  public static final zzgc zzFm = new zzgc()
  {
    @Nullable
    private String zzW(@Nullable String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {}
      int i;
      int j;
      do
      {
        return paramAnonymousString;
        i = 0;
        int k = paramAnonymousString.length();
        for (;;)
        {
          j = k;
          if (i >= paramAnonymousString.length()) {
            break;
          }
          j = k;
          if (paramAnonymousString.charAt(i) != ',') {
            break;
          }
          i += 1;
        }
        while ((j > 0) && (paramAnonymousString.charAt(j - 1) == ',')) {
          j -= 1;
        }
      } while ((i == 0) && (j == paramAnonymousString.length()));
      return paramAnonymousString.substring(i, j);
    }
    
    public String zzf(@Nullable String paramAnonymousString1, String paramAnonymousString2)
    {
      paramAnonymousString1 = zzW(paramAnonymousString1);
      paramAnonymousString2 = zzW(paramAnonymousString2);
      if (TextUtils.isEmpty(paramAnonymousString1)) {
        return paramAnonymousString2;
      }
      if (TextUtils.isEmpty(paramAnonymousString2)) {
        return paramAnonymousString1;
      }
      return String.valueOf(paramAnonymousString1).length() + 1 + String.valueOf(paramAnonymousString2).length() + paramAnonymousString1 + "," + paramAnonymousString2;
    }
  };
  
  public zzgc() {}
  
  public final void zza(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap.put(paramString1, zzf((String)paramMap.get(paramString1), paramString2));
  }
  
  public abstract String zzf(@Nullable String paramString1, String paramString2);
}
