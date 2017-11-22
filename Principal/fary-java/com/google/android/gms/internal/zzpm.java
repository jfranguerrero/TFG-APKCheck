package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzo;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzmb
public class zzpm
{
  private String zzXi = "";
  private String zzXj = "";
  private boolean zzXk = false;
  private final Object zzrN = new Object();
  
  public zzpm() {}
  
  private Uri zze(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = Uri.parse(paramString1).buildUpon();
    paramString1.appendQueryParameter("linkedDeviceId", zzM(paramContext));
    paramString1.appendQueryParameter("adSlotPath", paramString2);
    return paramString1.build();
  }
  
  private void zzo(Context paramContext, String paramString)
  {
    zzv.zzcJ().zza(paramContext, zze(paramContext, (String)zzfx.zzES.get(), paramString));
  }
  
  public void zzI(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzXk = paramBoolean;
      return;
    }
  }
  
  public String zzM(Context paramContext)
  {
    synchronized (zzrN)
    {
      if (TextUtils.isEmpty(zzXi))
      {
        zzXi = zzv.zzcJ().zzi(paramContext, "debug_signals_id.txt");
        if (TextUtils.isEmpty(zzXi))
        {
          zzXi = zzv.zzcJ().zzkk();
          zzv.zzcJ().zzd(paramContext, "debug_signals_id.txt", zzXi);
        }
      }
      paramContext = zzXi;
      return paramContext;
    }
  }
  
  public void zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString3 = zze(paramContext, (String)zzfx.zzEV.get(), paramString3).buildUpon();
    paramString3.appendQueryParameter("debugData", paramString2);
    zzv.zzcJ().zzc(paramContext, paramString1, paramString3.build().toString());
  }
  
  public void zzba(String paramString)
  {
    synchronized (zzrN)
    {
      zzXj = paramString;
      return;
    }
  }
  
  public void zzj(Context paramContext, String paramString)
  {
    if (zzl(paramContext, paramString))
    {
      zzpe.zzbc("Device is linked for in app preview.");
      return;
    }
    zzo(paramContext, paramString);
  }
  
  public void zzk(Context paramContext, String paramString)
  {
    if (zzm(paramContext, paramString))
    {
      zzpe.zzbc("Device is linked for debug signals.");
      return;
    }
    zzo(paramContext, paramString);
  }
  
  public String zzky()
  {
    synchronized (zzrN)
    {
      String str = zzXj;
      return str;
    }
  }
  
  public boolean zzkz()
  {
    synchronized (zzrN)
    {
      boolean bool = zzXk;
      return bool;
    }
  }
  
  boolean zzl(Context paramContext, String paramString)
  {
    paramContext = zzn(paramContext, zze(paramContext, (String)zzfx.zzET.get(), paramString).toString());
    if (TextUtils.isEmpty(paramContext))
    {
      zzpe.zzbc("Not linked for in app preview.");
      return false;
    }
    zzba(paramContext.trim());
    return true;
  }
  
  boolean zzm(Context paramContext, String paramString)
  {
    paramContext = zzn(paramContext, zze(paramContext, (String)zzfx.zzEU.get(), paramString).toString());
    if (TextUtils.isEmpty(paramContext))
    {
      zzpe.zzbc("Not linked for debug signals.");
      return false;
    }
    boolean bool = Boolean.parseBoolean(paramContext.trim());
    zzI(bool);
    return bool;
  }
  
  protected String zzn(Context paramContext, final String paramString)
  {
    zzqf localZzqf = new zzpp(paramContext).zza(paramString, new zzpp.zza()
    {
      public String zzi(InputStream paramAnonymousInputStream)
      {
        try
        {
          paramAnonymousInputStream = new String(zzo.zza(paramAnonymousInputStream, true), "UTF-8");
          String str = paramString;
          zzpe.zzbc(String.valueOf(str).length() + 49 + String.valueOf(paramAnonymousInputStream).length() + "Response received from server. \nURL: " + str + "\n Response: " + paramAnonymousInputStream);
          return paramAnonymousInputStream;
        }
        catch (IOException localIOException)
        {
          paramAnonymousInputStream = String.valueOf(paramString);
          if (paramAnonymousInputStream.length() == 0) {}
        }
        for (paramAnonymousInputStream = "Error connecting to url: ".concat(paramAnonymousInputStream);; paramAnonymousInputStream = new String("Error connecting to url: "))
        {
          zzpe.zzc(paramAnonymousInputStream, localIOException);
          return null;
        }
      }
      
      public String zzkA()
      {
        String str = String.valueOf(paramString);
        if (str.length() != 0) {}
        for (str = "Error getting a response from: ".concat(str);; str = new String("Error getting a response from: "))
        {
          zzpe.zzbe(str);
          return null;
        }
      }
    });
    try
    {
      paramContext = (String)localZzqf.get(((Integer)zzfx.zzEW.get()).intValue(), TimeUnit.MILLISECONDS);
      return paramContext;
    }
    catch (TimeoutException localTimeoutException)
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() != 0) {}
      for (paramContext = "Timeout while retriving a response from: ".concat(paramContext);; paramContext = new String("Timeout while retriving a response from: "))
      {
        zzpe.zzb(paramContext, localTimeoutException);
        localZzqf.cancel(true);
        return null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() != 0) {}
      for (paramContext = "Interrupted while retriving a response from: ".concat(paramContext);; paramContext = new String("Interrupted while retriving a response from: "))
      {
        zzpe.zzb(paramContext, localInterruptedException);
        localZzqf.cancel(true);
        break;
      }
    }
    catch (Exception localException)
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Error retriving a response from: ".concat(paramContext);; paramContext = new String("Error retriving a response from: "))
    {
      zzpe.zzb(paramContext, localException);
      break;
    }
  }
}
