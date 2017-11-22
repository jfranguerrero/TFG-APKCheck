package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;
import android.view.View;

public class zzav
{
  private static final String[] zzqf = { "/aclk", "/pcs/click" };
  private String zzqb = "googleads.g.doubleclick.net";
  private String zzqc = "/pagead/ads";
  private String zzqd = "ad.doubleclick.net";
  private String[] zzqe = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private zzaq zzqg;
  
  public zzav(zzaq paramZzaq)
  {
    zzqg = paramZzaq;
  }
  
  private Uri zza(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean, View paramView)
    throws zzaw
  {
    boolean bool;
    try
    {
      bool = zzb(paramUri);
      if (bool)
      {
        if (!paramUri.toString().contains("dc_ms=")) {
          break label64;
        }
        throw new zzaw("Parameter already exists: dc_ms");
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new zzaw("Provided Uri is not in a valid state");
    }
    if (paramUri.getQueryParameter("ms") != null) {
      throw new zzaw("Query parameter already exists: ms");
    }
    label64:
    if (paramBoolean) {}
    for (paramContext = zzqg.zza(paramContext, paramString, paramView); bool; paramContext = zzqg.zzb(paramContext)) {
      return zzb(paramUri, "dc_ms", paramContext);
    }
    paramUri = zza(paramUri, "ms", paramContext);
    return paramUri;
  }
  
  private Uri zza(Uri paramUri, String paramString1, String paramString2)
    throws UnsupportedOperationException
  {
    String str = paramUri.toString();
    int j = str.indexOf("&adurl");
    int i = j;
    if (j == -1) {
      i = str.indexOf("?adurl");
    }
    if (i != -1) {
      return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + "&" + str.substring(i + 1));
    }
    return paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
  }
  
  private Uri zzb(Uri paramUri, String paramString1, String paramString2)
  {
    String str = paramUri.toString();
    int i = str.indexOf(";adurl");
    if (i != -1) {
      return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + ";" + str.substring(i + 1));
    }
    paramUri = paramUri.getEncodedPath();
    i = str.indexOf(paramUri);
    return Uri.parse(str.substring(0, paramUri.length() + i) + ";" + paramString1 + "=" + paramString2 + ";" + str.substring(paramUri.length() + i));
  }
  
  public zzaq zzW()
  {
    return zzqg;
  }
  
  public Uri zza(Uri paramUri, Context paramContext)
    throws zzaw
  {
    return zza(paramUri, paramContext, null, false, null);
  }
  
  public Uri zza(Uri paramUri, Context paramContext, View paramView)
    throws zzaw
  {
    try
    {
      paramUri = zza(paramUri, paramContext, paramUri.getQueryParameter("ai"), true, paramView);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new zzaw("Provided Uri is not in a valid state");
    }
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    zzqg.zza(paramMotionEvent);
  }
  
  public boolean zza(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    boolean bool1 = bool2;
    try
    {
      if (paramUri.getHost().equals(zzqb))
      {
        boolean bool3 = paramUri.getPath().equals(zzqc);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NullPointerException paramUri) {}
    return false;
  }
  
  @Deprecated
  public Uri zzb(Uri paramUri, Context paramContext)
    throws zzaw
  {
    return zza(paramUri, paramContext, null);
  }
  
  public void zzb(String paramString1, String paramString2)
  {
    zzqb = paramString1;
    zzqc = paramString2;
  }
  
  public boolean zzb(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      boolean bool = paramUri.getHost().equals(zzqd);
      return bool;
    }
    catch (NullPointerException paramUri) {}
    return false;
  }
  
  public boolean zzc(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      paramUri = paramUri.getHost();
      String[] arrayOfString = zzqe;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          bool1 = paramUri.endsWith(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (NullPointerException paramUri) {}
  }
  
  public boolean zzd(Uri paramUri)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (zzc(paramUri))
    {
      arrayOfString = zzqf;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (paramUri.getPath().endsWith(str)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void zzm(String paramString)
  {
    zzqe = paramString.split(",");
  }
}
