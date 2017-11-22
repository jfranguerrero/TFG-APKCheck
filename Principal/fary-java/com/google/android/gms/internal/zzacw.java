package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.zzs;

public class zzacw
{
  protected final Context mContext;
  
  public zzacw(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return mContext.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return mContext.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return mContext.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    return mContext.getPackageManager().getPackagesForUid(paramInt);
  }
  
  public CharSequence zzdE(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return mContext.getPackageManager().getApplicationLabel(mContext.getPackageManager().getApplicationInfo(paramString, 0));
  }
  
  @TargetApi(19)
  public boolean zzg(int paramInt, String paramString)
  {
    boolean bool2 = false;
    if (zzs.zzyF()) {}
    for (;;)
    {
      try
      {
        ((AppOpsManager)mContext.getSystemService("appops")).checkPackage(paramInt, paramString);
        bool1 = true;
        return bool1;
      }
      catch (SecurityException paramString) {}
      String[] arrayOfString = mContext.getPackageManager().getPackagesForUid(paramInt);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (arrayOfString != null)
        {
          paramInt = 0;
          for (;;)
          {
            bool1 = bool2;
            if (paramInt >= arrayOfString.length) {
              break;
            }
            if (paramString.equals(arrayOfString[paramInt])) {
              return true;
            }
            paramInt += 1;
          }
        }
      }
    }
    return false;
  }
}
