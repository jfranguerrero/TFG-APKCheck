package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public final class zzih
  implements zzhx
{
  private boolean zzHT;
  
  public zzih() {}
  
  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = zzeh.zzeO().zzb(paramContext, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      zzpe.zzbe(String.valueOf(paramString).length() + 34 + String.valueOf(paramMap).length() + "Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    Object localObject2 = (String)paramMap.get("action");
    if (localObject2 == null)
    {
      zzpe.zzbe("Action missing from video GMSG.");
      return;
    }
    if (zzpe.zzai(3))
    {
      localObject1 = new JSONObject(paramMap);
      ((JSONObject)localObject1).remove("google.afma.Notify_dt");
      localObject1 = String.valueOf(((JSONObject)localObject1).toString());
      zzpe.zzbc(String.valueOf(localObject2).length() + 13 + String.valueOf(localObject1).length() + "Video GMSG: " + (String)localObject2 + " " + (String)localObject1);
    }
    if ("background".equals(localObject2))
    {
      paramMap = (String)paramMap.get("color");
      if (TextUtils.isEmpty(paramMap))
      {
        zzpe.zzbe("Color parameter missing from color video GMSG.");
        return;
      }
      try
      {
        paramZzqp.setBackgroundColor(Color.parseColor(paramMap));
        return;
      }
      catch (IllegalArgumentException paramZzqp)
      {
        zzpe.zzbe("Invalid color parameter in video GMSG.");
        return;
      }
    }
    Object localObject1 = paramZzqp.zzld();
    if (localObject1 == null)
    {
      zzpe.zzbe("Could not get underlay container for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equals(localObject2);
    boolean bool2 = "position".equals(localObject2);
    int m;
    int n;
    int i;
    int j;
    if ((bool1) || (bool2))
    {
      localObject2 = paramZzqp.getContext();
      m = zza((Context)localObject2, paramMap, "x", 0);
      n = zza((Context)localObject2, paramMap, "y", 0);
      i = zza((Context)localObject2, paramMap, "w", -1);
      j = zza((Context)localObject2, paramMap, "h", -1);
      if (!((Boolean)zzfx.zzEb.get()).booleanValue()) {
        break label931;
      }
      i = Math.min(i, paramZzqp.getMeasuredWidth() - m);
      j = Math.min(j, paramZzqp.getMeasuredHeight() - n);
    }
    label931:
    for (;;)
    {
      try
      {
        k = Integer.parseInt((String)paramMap.get("player"));
        bool2 = Boolean.parseBoolean((String)paramMap.get("spherical"));
        if ((bool1) && (((zzqo)localObject1).zzkO() == null))
        {
          ((zzqo)localObject1).zza(m, n, i, j, k, bool2);
          return;
        }
      }
      catch (NumberFormatException paramZzqp)
      {
        int k = 0;
        continue;
        ((zzqo)localObject1).zze(m, n, i, j);
        return;
      }
      localObject1 = ((zzqo)localObject1).zzkO();
      if (localObject1 == null)
      {
        zzl.zzi(paramZzqp);
        return;
      }
      if ("click".equals(localObject2))
      {
        paramZzqp = paramZzqp.getContext();
        i = zza(paramZzqp, paramMap, "x", 0);
        j = zza(paramZzqp, paramMap, "y", 0);
        long l = SystemClock.uptimeMillis();
        paramZzqp = MotionEvent.obtain(l, l, 0, i, j, 0);
        ((zzl)localObject1).zzf(paramZzqp);
        paramZzqp.recycle();
        return;
      }
      if ("currentTime".equals(localObject2))
      {
        paramZzqp = (String)paramMap.get("time");
        if (paramZzqp == null)
        {
          zzpe.zzbe("Time parameter missing from currentTime video GMSG.");
          return;
        }
        try
        {
          ((zzl)localObject1).seekTo((int)(Float.parseFloat(paramZzqp) * 1000.0F));
          return;
        }
        catch (NumberFormatException paramMap)
        {
          paramZzqp = String.valueOf(paramZzqp);
          if (paramZzqp.length() == 0) {}
        }
        for (paramZzqp = "Could not parse time parameter from currentTime video GMSG: ".concat(paramZzqp);; paramZzqp = new String("Could not parse time parameter from currentTime video GMSG: "))
        {
          zzpe.zzbe(paramZzqp);
          return;
        }
      }
      if ("hide".equals(localObject2))
      {
        ((zzl)localObject1).setVisibility(4);
        return;
      }
      if ("load".equals(localObject2))
      {
        ((zzl)localObject1).zzgq();
        return;
      }
      if ("muted".equals(localObject2))
      {
        if (Boolean.parseBoolean((String)paramMap.get("muted")))
        {
          ((zzl)localObject1).zzhE();
          return;
        }
        ((zzl)localObject1).zzhF();
        return;
      }
      if ("pause".equals(localObject2))
      {
        ((zzl)localObject1).pause();
        return;
      }
      if ("play".equals(localObject2))
      {
        ((zzl)localObject1).play();
        return;
      }
      if ("show".equals(localObject2))
      {
        ((zzl)localObject1).setVisibility(0);
        return;
      }
      if ("src".equals(localObject2))
      {
        ((zzl)localObject1).zzaB((String)paramMap.get("src"));
        return;
      }
      if ("touchMove".equals(localObject2))
      {
        localObject2 = paramZzqp.getContext();
        i = zza((Context)localObject2, paramMap, "dx", 0);
        j = zza((Context)localObject2, paramMap, "dy", 0);
        ((zzl)localObject1).zza(i, j);
        if (zzHT) {
          break;
        }
        paramZzqp.zzkT().zzhq();
        zzHT = true;
        return;
      }
      if ("volume".equals(localObject2))
      {
        paramZzqp = (String)paramMap.get("volume");
        if (paramZzqp == null)
        {
          zzpe.zzbe("Level parameter missing from volume video GMSG.");
          return;
        }
        try
        {
          ((zzl)localObject1).zzb(Float.parseFloat(paramZzqp));
          return;
        }
        catch (NumberFormatException paramMap)
        {
          paramZzqp = String.valueOf(paramZzqp);
          if (paramZzqp.length() == 0) {}
        }
        for (paramZzqp = "Could not parse volume parameter from volume video GMSG: ".concat(paramZzqp);; paramZzqp = new String("Could not parse volume parameter from volume video GMSG: "))
        {
          zzpe.zzbe(paramZzqp);
          return;
        }
      }
      if ("watermark".equals(localObject2))
      {
        ((zzl)localObject1).zzhG();
        return;
      }
      paramZzqp = String.valueOf(localObject2);
      if (paramZzqp.length() != 0) {}
      for (paramZzqp = "Unknown video action: ".concat(paramZzqp);; paramZzqp = new String("Unknown video action: "))
      {
        zzpe.zzbe(paramZzqp);
        return;
      }
    }
  }
}
