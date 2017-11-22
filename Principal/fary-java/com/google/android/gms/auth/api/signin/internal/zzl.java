package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzl
{
  private static final Lock zzajI = new ReentrantLock();
  private static zzl zzajJ;
  private final Lock zzajK = new ReentrantLock();
  private final SharedPreferences zzajL;
  
  zzl(Context paramContext)
  {
    zzajL = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static zzl zzaa(Context paramContext)
  {
    zzac.zzw(paramContext);
    zzajI.lock();
    try
    {
      if (zzajJ == null) {
        zzajJ = new zzl(paramContext.getApplicationContext());
      }
      paramContext = zzajJ;
      return paramContext;
    }
    finally
    {
      zzajI.unlock();
    }
  }
  
  private String zzx(String paramString1, String paramString2)
  {
    String str = String.valueOf(":");
    return String.valueOf(paramString1).length() + 0 + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2;
  }
  
  void zza(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzw(paramGoogleSignInAccount);
    zzac.zzw(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zzqF();
    zzw(zzx("googleSignInAccount", str), paramGoogleSignInAccount.zzqH());
    zzw(zzx("googleSignInOptions", str), paramGoogleSignInOptions.zzqG());
  }
  
  public void zzb(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzw(paramGoogleSignInAccount);
    zzac.zzw(paramGoogleSignInOptions);
    zzw("defaultGoogleSignInAccount", paramGoogleSignInAccount.zzqF());
    zza(paramGoogleSignInAccount, paramGoogleSignInOptions);
  }
  
  protected String zzcA(String paramString)
  {
    zzajK.lock();
    try
    {
      paramString = zzajL.getString(paramString, null);
      return paramString;
    }
    finally
    {
      zzajK.unlock();
    }
  }
  
  void zzcB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    zzcC(zzx("googleSignInAccount", paramString));
    zzcC(zzx("googleSignInOptions", paramString));
  }
  
  protected void zzcC(String paramString)
  {
    zzajK.lock();
    try
    {
      zzajL.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      zzajK.unlock();
    }
  }
  
  GoogleSignInAccount zzcy(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzcA(zzx("googleSignInAccount", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInAccount.zzcu(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  GoogleSignInOptions zzcz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzcA(zzx("googleSignInOptions", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInOptions.zzcw(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public GoogleSignInAccount zzrc()
  {
    return zzcy(zzcA("defaultGoogleSignInAccount"));
  }
  
  public GoogleSignInOptions zzrd()
  {
    return zzcz(zzcA("defaultGoogleSignInAccount"));
  }
  
  public void zzre()
  {
    String str = zzcA("defaultGoogleSignInAccount");
    zzcC("defaultGoogleSignInAccount");
    zzcB(str);
  }
  
  protected void zzw(String paramString1, String paramString2)
  {
    zzajK.lock();
    try
    {
      zzajL.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      zzajK.unlock();
    }
  }
}
