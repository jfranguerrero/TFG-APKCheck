package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzi;
import java.util.Locale;

@zzmb
public final class zznf
{
  public final int zzRn;
  public final int zzRo;
  public final int zzUa;
  public final boolean zzUb;
  public final boolean zzUc;
  public final String zzUd;
  public final String zzUe;
  public final boolean zzUf;
  public final boolean zzUg;
  public final boolean zzUh;
  public final boolean zzUi;
  public final String zzUj;
  public final String zzUk;
  public final int zzUl;
  public final int zzUm;
  public final int zzUn;
  public final int zzUo;
  public final int zzUp;
  public final int zzUq;
  public final double zzUr;
  public final boolean zzUs;
  public final boolean zzUt;
  public final int zzUu;
  public final String zzUv;
  public final boolean zzUw;
  public final float zzxa;
  
  zznf(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat, int paramInt8, int paramInt9, double paramDouble, boolean paramBoolean7, boolean paramBoolean8, int paramInt10, String paramString5, boolean paramBoolean9)
  {
    zzUa = paramInt1;
    zzUb = paramBoolean1;
    zzUc = paramBoolean2;
    zzUd = paramString1;
    zzUe = paramString2;
    zzUf = paramBoolean3;
    zzUg = paramBoolean4;
    zzUh = paramBoolean5;
    zzUi = paramBoolean6;
    zzUj = paramString3;
    zzUk = paramString4;
    zzUl = paramInt2;
    zzUm = paramInt3;
    zzUn = paramInt4;
    zzUo = paramInt5;
    zzUp = paramInt6;
    zzUq = paramInt7;
    zzxa = paramFloat;
    zzRn = paramInt8;
    zzRo = paramInt9;
    zzUr = paramDouble;
    zzUs = paramBoolean7;
    zzUt = paramBoolean8;
    zzUu = paramInt10;
    zzUv = paramString5;
    zzUw = paramBoolean9;
  }
  
  public static final class zza
  {
    private int zzRn;
    private int zzRo;
    private int zzUa;
    private boolean zzUb;
    private boolean zzUc;
    private String zzUd;
    private String zzUe;
    private boolean zzUf;
    private boolean zzUg;
    private boolean zzUh;
    private boolean zzUi;
    private String zzUj;
    private String zzUk;
    private int zzUl;
    private int zzUm;
    private int zzUn;
    private int zzUo;
    private int zzUp;
    private int zzUq;
    private double zzUr;
    private boolean zzUs;
    private boolean zzUt;
    private int zzUu;
    private String zzUv;
    private boolean zzUw;
    private float zzxa;
    
    public zza(Context paramContext)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      zzs(paramContext);
      zza(paramContext, localPackageManager);
      zzt(paramContext);
      Locale localLocale = Locale.getDefault();
      boolean bool1;
      if (zza(localPackageManager, "geo:0,0?q=donuts") != null)
      {
        bool1 = true;
        zzUb = bool1;
        if (zza(localPackageManager, "http://www.google.com") == null) {
          break label128;
        }
        bool1 = bool2;
        label63:
        zzUc = bool1;
        zzUe = localLocale.getCountry();
        zzUf = zzeh.zzeO().zzkI();
        zzUg = zzi.zzaK(paramContext);
        zzUj = localLocale.getLanguage();
        zzUk = zza(localPackageManager);
        paramContext = paramContext.getResources();
        if (paramContext != null) {
          break label133;
        }
      }
      label128:
      label133:
      do
      {
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label63;
        paramContext = paramContext.getDisplayMetrics();
      } while (paramContext == null);
      zzxa = density;
      zzRn = widthPixels;
      zzRo = heightPixels;
    }
    
    public zza(Context paramContext, zznf paramZznf)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      zzs(paramContext);
      zza(paramContext, localPackageManager);
      zzt(paramContext);
      zzu(paramContext);
      zzUb = zzUb;
      zzUc = zzUc;
      zzUe = zzUe;
      zzUf = zzUf;
      zzUg = zzUg;
      zzUj = zzUj;
      zzUk = zzUk;
      zzxa = zzxa;
      zzRn = zzRn;
      zzRo = zzRo;
    }
    
    private static ResolveInfo zza(PackageManager paramPackageManager, String paramString)
    {
      return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
    }
    
    private static String zza(PackageManager paramPackageManager)
    {
      Object localObject = zza(paramPackageManager, "market://details?id=com.google.android.gms.ads");
      if (localObject == null) {}
      for (;;)
      {
        return null;
        localObject = activityInfo;
        if (localObject != null) {
          try
          {
            paramPackageManager = paramPackageManager.getPackageInfo(packageName, 0);
            if (paramPackageManager != null)
            {
              int i = versionCode;
              paramPackageManager = String.valueOf(packageName);
              paramPackageManager = String.valueOf(paramPackageManager).length() + 12 + i + "." + paramPackageManager;
              return paramPackageManager;
            }
          }
          catch (PackageManager.NameNotFoundException paramPackageManager) {}
        }
      }
      return null;
    }
    
    @TargetApi(16)
    private void zza(Context paramContext, PackageManager paramPackageManager)
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      zzUd = localTelephonyManager.getNetworkOperator();
      zzUn = localTelephonyManager.getNetworkType();
      zzUo = localTelephonyManager.getPhoneType();
      zzUm = -2;
      zzUt = false;
      zzUu = -1;
      if (zzv.zzcJ().zza(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if (paramContext == null) {
          break label126;
        }
        zzUm = paramContext.getType();
        zzUu = paramContext.getDetailedState().ordinal();
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          zzUt = localConnectivityManager.isActiveNetworkMetered();
        }
        return;
        label126:
        zzUm = -1;
      }
    }
    
    private void zzs(Context paramContext)
    {
      paramContext = zzv.zzcJ().zzG(paramContext);
      if (paramContext != null) {
        try
        {
          zzUa = paramContext.getMode();
          zzUh = paramContext.isMusicActive();
          zzUi = paramContext.isSpeakerphoneOn();
          zzUl = paramContext.getStreamVolume(3);
          zzUp = paramContext.getRingerMode();
          zzUq = paramContext.getStreamVolume(2);
          return;
        }
        catch (Throwable paramContext)
        {
          zzv.zzcN().zza(paramContext, "DeviceInfo.gatherAudioInfo");
        }
      }
      zzUa = -2;
      zzUh = false;
      zzUi = false;
      zzUl = 0;
      zzUp = 0;
      zzUq = 0;
    }
    
    private void zzt(Context paramContext)
    {
      boolean bool = false;
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext != null)
      {
        int i = paramContext.getIntExtra("status", -1);
        int j = paramContext.getIntExtra("level", -1);
        int k = paramContext.getIntExtra("scale", -1);
        zzUr = (j / k);
        if ((i == 2) || (i == 5)) {
          bool = true;
        }
        zzUs = bool;
        return;
      }
      zzUr = -1.0D;
      zzUs = false;
    }
    
    private void zzu(Context paramContext)
    {
      zzUv = Build.FINGERPRINT;
      zzUw = zzgl.zzn(paramContext);
    }
    
    public zznf zzjn()
    {
      return new zznf(zzUa, zzUb, zzUc, zzUd, zzUe, zzUf, zzUg, zzUh, zzUi, zzUj, zzUk, zzUl, zzUm, zzUn, zzUo, zzUp, zzUq, zzxa, zzRn, zzRo, zzUr, zzUs, zzUt, zzUu, zzUv, zzUw);
    }
  }
}
