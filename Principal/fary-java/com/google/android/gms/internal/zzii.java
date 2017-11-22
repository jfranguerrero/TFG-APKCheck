package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
class zzii
  implements zzhx
{
  zzii() {}
  
  private int zzh(Map<String, String> paramMap)
    throws NullPointerException, NumberFormatException
  {
    int j = Integer.parseInt((String)paramMap.get("playbackState"));
    int i;
    if (j >= 0)
    {
      i = j;
      if (3 >= j) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    if (!((Boolean)zzfx.zzCY.get()).booleanValue()) {
      return;
    }
    zzqu localZzqu = paramZzqp.zzlg();
    if (localZzqu == null) {}
    for (;;)
    {
      try
      {
        localZzqu = new zzqu(paramZzqp, Float.parseFloat((String)paramMap.get("duration")));
        paramZzqp.zza(localZzqu);
        paramZzqp = localZzqu;
        bool = "1".equals(paramMap.get("muted"));
        f2 = Float.parseFloat((String)paramMap.get("currentTime"));
        i = zzh(paramMap);
        paramMap = (String)paramMap.get("aspectRatio");
        if (!TextUtils.isEmpty(paramMap)) {
          continue;
        }
        f1 = 0.0F;
      }
      catch (NullPointerException paramZzqp)
      {
        boolean bool;
        float f2;
        int i;
        zzpe.zzb("Unable to parse videoMeta message.", paramZzqp);
        zzv.zzcN().zza(paramZzqp, "VideoMetaGmsgHandler.onGmsg");
        return;
        float f1 = Float.parseFloat(paramMap);
        continue;
      }
      catch (NumberFormatException paramZzqp)
      {
        continue;
      }
      if (zzpe.zzai(3)) {
        zzpe.zzbc(String.valueOf(paramMap).length() + 79 + "Video Meta GMSG: isMuted : " + bool + " , playbackState : " + i + " , aspectRatio : " + paramMap);
      }
      paramZzqp.zza(f2, i, bool, f1);
      return;
      paramZzqp = localZzqu;
    }
  }
}
