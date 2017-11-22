package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.stats.zze;
import com.google.android.gms.common.stats.zzg;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzv;
import com.google.android.gms.common.util.zzy;

public class zzayd
{
  private static boolean DEBUG = false;
  private static String TAG = "WakeLock";
  private static String zzbCt = "*gcore*:";
  private final Context mContext;
  private final String zzaGw;
  private final String zzaGy;
  private final PowerManager.WakeLock zzbCu;
  private final int zzbCv;
  private final String zzbCw;
  private boolean zzbCx = true;
  private int zzbCy;
  private int zzbCz;
  private WorkSource zzbiJ;
  
  public zzayd(Context paramContext, int paramInt, String paramString) {}
  
  @SuppressLint({"UnwrappedWakeLock"})
  public zzayd(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  @SuppressLint({"UnwrappedWakeLock"})
  public zzayd(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    zzac.zzh(paramString1, "Wake lock name can NOT be empty");
    zzbCv = paramInt;
    zzbCw = paramString2;
    zzaGy = paramString4;
    mContext = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      paramString2 = String.valueOf(zzbCt);
      paramString4 = String.valueOf(paramString1);
      if (paramString4.length() != 0) {
        paramString2 = paramString2.concat(paramString4);
      }
    }
    for (zzaGw = paramString2;; zzaGw = paramString1)
    {
      zzbCu = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
      if (zzy.zzaO(mContext))
      {
        paramString1 = paramString3;
        if (zzv.zzdD(paramString3)) {
          paramString1 = paramContext.getPackageName();
        }
        zzbiJ = zzy.zzy(paramContext, paramString1);
        zzc(zzbiJ);
      }
      return;
      paramString2 = new String(paramString2);
      break;
    }
  }
  
  private void zzd(WorkSource paramWorkSource)
  {
    try
    {
      zzbCu.setWorkSource(paramWorkSource);
      return;
    }
    catch (IllegalArgumentException paramWorkSource)
    {
      Log.wtf(TAG, paramWorkSource.toString());
    }
  }
  
  private void zzgP(String paramString)
  {
    boolean bool = zzgQ(paramString);
    paramString = zzo(paramString, bool);
    try
    {
      if (zzbCx)
      {
        int i = zzbCy - 1;
        zzbCy = i;
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((zzbCx) || (zzbCz != 1)) {
          break label107;
        }
      }
      zzg.zzyr().zza(mContext, zze.zza(zzbCu, paramString), 8, zzaGw, paramString, zzaGy, zzbCv, zzy.zzb(zzbiJ));
      zzbCz -= 1;
      label107:
      return;
    }
    finally {}
  }
  
  private boolean zzgQ(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.equals(zzbCw));
  }
  
  private void zzm(String paramString, long paramLong)
  {
    boolean bool = zzgQ(paramString);
    paramString = zzo(paramString, bool);
    try
    {
      if (zzbCx)
      {
        int i = zzbCy;
        zzbCy = (i + 1);
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((zzbCx) || (zzbCz != 0)) {
          break label113;
        }
      }
      zzg.zzyr().zza(mContext, zze.zza(zzbCu, paramString), 7, zzaGw, paramString, zzaGy, zzbCv, zzy.zzb(zzbiJ), paramLong);
      zzbCz += 1;
      label113:
      return;
    }
    finally {}
  }
  
  private String zzo(String paramString, boolean paramBoolean)
  {
    if (zzbCx)
    {
      if (paramBoolean) {
        return paramString;
      }
      return zzbCw;
    }
    return zzbCw;
  }
  
  public void acquire(long paramLong)
  {
    String str2;
    if ((!zzs.zzyA()) && (zzbCx))
    {
      str2 = TAG;
      str1 = String.valueOf(zzaGw);
      if (str1.length() == 0) {
        break label62;
      }
    }
    label62:
    for (String str1 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(str1);; str1 = new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "))
    {
      Log.wtf(str2, str1);
      zzm(null, paramLong);
      zzbCu.acquire(paramLong);
      return;
    }
  }
  
  public boolean isHeld()
  {
    return zzbCu.isHeld();
  }
  
  public void release()
  {
    zzgP(null);
    zzbCu.release();
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    zzbCu.setReferenceCounted(paramBoolean);
    zzbCx = paramBoolean;
  }
  
  public void zzc(WorkSource paramWorkSource)
  {
    if ((paramWorkSource != null) && (zzy.zzaO(mContext)))
    {
      if (zzbiJ == null) {
        break label39;
      }
      zzbiJ.add(paramWorkSource);
    }
    for (;;)
    {
      zzd(zzbiJ);
      return;
      label39:
      zzbiJ = paramWorkSource;
    }
  }
}
