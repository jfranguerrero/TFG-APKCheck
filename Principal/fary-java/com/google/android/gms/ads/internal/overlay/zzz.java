package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpo.zza;
import com.google.android.gms.internal.zzpo.zzb;
import com.google.android.gms.internal.zzqa;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@zzmb
public class zzz
{
  private final Context mContext;
  @Nullable
  private final zzgf zzNm;
  private boolean zzNq;
  private final String zzOn;
  @Nullable
  private final zzgd zzOo;
  private final zzpo zzOp = new zzpo.zzb().zza("min_1", Double.MIN_VALUE, 1.0D).zza("1_5", 1.0D, 5.0D).zza("5_10", 5.0D, 10.0D).zza("10_20", 10.0D, 20.0D).zza("20_30", 20.0D, 30.0D).zza("30_max", 30.0D, Double.MAX_VALUE).zzkB();
  private final long[] zzOq;
  private final String[] zzOr;
  private boolean zzOs = false;
  private boolean zzOt = false;
  private boolean zzOu = false;
  private boolean zzOv = false;
  private zzj zzOw;
  private boolean zzOx;
  private boolean zzOy;
  private long zzOz = -1L;
  private final zzqa zztZ;
  
  public zzz(Context paramContext, zzqa paramZzqa, String paramString, @Nullable zzgf paramZzgf, @Nullable zzgd paramZzgd)
  {
    mContext = paramContext;
    zztZ = paramZzqa;
    zzOn = paramString;
    zzNm = paramZzgf;
    zzOo = paramZzgd;
    paramContext = (String)zzfx.zzBp.get();
    if (paramContext == null)
    {
      zzOr = new String[0];
      zzOq = new long[0];
      return;
    }
    paramContext = TextUtils.split(paramContext, ",");
    zzOr = new String[paramContext.length];
    zzOq = new long[paramContext.length];
    int i = 0;
    while (i < paramContext.length) {
      try
      {
        zzOq[i] = Long.parseLong(paramContext[i]);
        i += 1;
      }
      catch (NumberFormatException paramZzqa)
      {
        for (;;)
        {
          zzpe.zzc("Unable to parse frame hash target time number.", paramZzqa);
          zzOq[i] = -1L;
        }
      }
    }
  }
  
  private void zzc(zzj paramZzj)
  {
    long l1 = ((Long)zzfx.zzBq.get()).longValue();
    long l2 = paramZzj.getCurrentPosition();
    int i = 0;
    if (i < zzOr.length)
    {
      if (zzOr[i] != null) {}
      while (l1 <= Math.abs(l2 - zzOq[i]))
      {
        i += 1;
        break;
      }
      zzOr[i] = zza(paramZzj);
    }
  }
  
  private void zzia()
  {
    if ((zzOu) && (!zzOv))
    {
      zzgb.zza(zzNm, zzOo, new String[] { "vff2" });
      zzOv = true;
    }
    long l = zzv.zzcP().nanoTime();
    if ((zzNq) && (zzOy) && (zzOz != -1L))
    {
      double d = TimeUnit.SECONDS.toNanos(1L) / (l - zzOz);
      zzOp.zza(d);
    }
    zzOy = zzNq;
    zzOz = l;
  }
  
  public void onStop()
  {
    if ((((Boolean)zzfx.zzBo.get()).booleanValue()) && (!zzOx))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("type", "native-player-metrics");
      localBundle.putString("request", zzOn);
      localBundle.putString("player", zzOw.zzhd());
      Object localObject1 = zzOp.getBuckets().iterator();
      Object localObject2;
      String str1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzpo.zza)((Iterator)localObject1).next();
        str1 = String.valueOf("fps_c_");
        String str2 = String.valueOf(name);
        if (str2.length() != 0)
        {
          str1 = str1.concat(str2);
          label129:
          localBundle.putString(str1, Integer.toString(count));
          str1 = String.valueOf("fps_p_");
          str2 = String.valueOf(name);
          if (str2.length() == 0) {
            break label202;
          }
        }
        label202:
        for (str1 = str1.concat(str2);; str1 = new String(str1))
        {
          localBundle.putString(str1, Double.toString(zzXs));
          break;
          str1 = new String(str1);
          break label129;
        }
      }
      int i = 0;
      if (i < zzOq.length)
      {
        str1 = zzOr[i];
        if (str1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject1 = String.valueOf("fh_");
          localObject2 = String.valueOf(Long.valueOf(zzOq[i]));
          localBundle.putString(String.valueOf(localObject1).length() + 0 + String.valueOf(localObject2).length() + (String)localObject1 + (String)localObject2, str1);
        }
      }
      zzv.zzcJ().zza(mContext, zztZ.zzaZ, "gmob-apps", localBundle, true);
      zzOx = true;
    }
  }
  
  @TargetApi(14)
  String zza(TextureView paramTextureView)
  {
    paramTextureView = paramTextureView.getBitmap(8, 8);
    long l2 = 0L;
    long l1 = 63L;
    int i = 0;
    while (i < 8)
    {
      long l3 = l1;
      int j = 0;
      l1 = l2;
      l2 = l3;
      if (j < 8)
      {
        int k = paramTextureView.getPixel(j, i);
        int m = Color.blue(k);
        int n = Color.red(k);
        if (Color.green(k) + (m + n) > 128) {}
        for (l3 = 1L;; l3 = 0L)
        {
          l1 |= l3 << (int)l2;
          l2 -= 1L;
          j += 1;
          break;
        }
      }
      i += 1;
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
    return String.format("%016X", new Object[] { Long.valueOf(l2) });
  }
  
  public void zza(zzj paramZzj)
  {
    zzgb.zza(zzNm, zzOo, new String[] { "vpc2" });
    zzOs = true;
    if (zzNm != null) {
      zzNm.zzg("vpn", paramZzj.zzhd());
    }
    zzOw = paramZzj;
  }
  
  public void zzb(zzj paramZzj)
  {
    zzia();
    zzc(paramZzj);
  }
  
  public void zzhz()
  {
    if ((!zzOs) || (zzOt)) {
      return;
    }
    zzgb.zza(zzNm, zzOo, new String[] { "vfr2" });
    zzOt = true;
  }
  
  public void zzib()
  {
    zzNq = true;
    if ((zzOt) && (!zzOu))
    {
      zzgb.zza(zzNm, zzOo, new String[] { "vfp2" });
      zzOu = true;
    }
  }
  
  public void zzic()
  {
    zzNq = false;
  }
}
