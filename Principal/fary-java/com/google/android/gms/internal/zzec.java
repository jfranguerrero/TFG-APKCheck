package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;

@zzmb
public class zzec
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<zzec> CREATOR = new zzed();
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  public final String zzzk;
  public final boolean zzzl;
  public final zzec[] zzzm;
  public final boolean zzzn;
  public final boolean zzzo;
  public boolean zzzp;
  
  public zzec()
  {
    this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  zzec(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, zzec[] paramArrayOfZzec, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    versionCode = paramInt1;
    zzzk = paramString;
    height = paramInt2;
    heightPixels = paramInt3;
    zzzl = paramBoolean1;
    width = paramInt4;
    widthPixels = paramInt5;
    zzzm = paramArrayOfZzec;
    zzzn = paramBoolean2;
    zzzo = paramBoolean3;
    zzzp = paramBoolean4;
  }
  
  public zzec(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public zzec(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    versionCode = 5;
    zzzl = false;
    zzzo = localAdSize.isFluid();
    int j;
    label66:
    int k;
    label78:
    DisplayMetrics localDisplayMetrics;
    label129:
    int m;
    int i;
    if (zzzo)
    {
      width = AdSize.BANNER.getWidth();
      height = AdSize.BANNER.getHeight();
      if (width != -1) {
        break label314;
      }
      j = 1;
      if (height != -2) {
        break label320;
      }
      k = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (j == 0) {
        break label338;
      }
      if ((!zzeh.zzeO().zzQ(paramContext)) || (!zzeh.zzeO().zzR(paramContext))) {
        break label326;
      }
      widthPixels = (zza(localDisplayMetrics) - zzeh.zzeO().zzS(paramContext));
      double d = widthPixels / density;
      m = (int)d;
      i = m;
      if (d - (int)d >= 0.01D) {
        i = m + 1;
      }
      label168:
      if (k == 0) {
        break label363;
      }
      m = zzc(localDisplayMetrics);
      label180:
      heightPixels = zzeh.zzeO().zza(localDisplayMetrics, m);
      if ((j == 0) && (k == 0)) {
        break label372;
      }
      zzzk = (26 + i + "x" + m + "_as");
    }
    for (;;)
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label400;
      }
      zzzm = new zzec[paramArrayOfAdSize.length];
      i = 0;
      while (i < paramArrayOfAdSize.length)
      {
        zzzm[i] = new zzec(paramContext, paramArrayOfAdSize[i]);
        i += 1;
      }
      width = localAdSize.getWidth();
      height = localAdSize.getHeight();
      break;
      label314:
      j = 0;
      break label66;
      label320:
      k = 0;
      break label78;
      label326:
      widthPixels = zza(localDisplayMetrics);
      break label129;
      label338:
      i = width;
      widthPixels = zzeh.zzeO().zza(localDisplayMetrics, width);
      break label168;
      label363:
      m = height;
      break label180;
      label372:
      if (zzzo) {
        zzzk = "320x50_mb";
      } else {
        zzzk = localAdSize.toString();
      }
    }
    label400:
    zzzm = null;
    zzzn = false;
    zzzp = false;
  }
  
  public zzec(zzec paramZzec, zzec[] paramArrayOfZzec)
  {
    this(5, zzzk, height, heightPixels, zzzl, width, widthPixels, paramArrayOfZzec, zzzn, zzzo, zzzp);
  }
  
  public static int zza(DisplayMetrics paramDisplayMetrics)
  {
    return widthPixels;
  }
  
  public static int zzb(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(zzc(paramDisplayMetrics) * density);
  }
  
  private static int zzc(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(heightPixels / density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public static zzec zzez()
  {
    return new zzec(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  public static zzec zzj(Context paramContext)
  {
    return new zzec(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzed.zza(this, paramParcel, paramInt);
  }
  
  public AdSize zzeA()
  {
    return com.google.android.gms.ads.zza.zza(width, height, zzzk);
  }
  
  public void zzl(boolean paramBoolean)
  {
    zzzp = paramBoolean;
  }
}
