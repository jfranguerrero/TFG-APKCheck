package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedHashMap;
import java.util.Map;

@zzmb
public class zzfy
{
  private Context mContext = null;
  private boolean zzFa;
  private String zzFb;
  private Map<String, String> zzFc;
  private String zzvU = null;
  
  public zzfy(Context paramContext, String paramString)
  {
    mContext = paramContext;
    zzvU = paramString;
    zzFa = ((Boolean)zzfx.zzBK.get()).booleanValue();
    zzFb = ((String)zzfx.zzBL.get());
    zzFc = new LinkedHashMap();
    zzFc.put("s", "gmob_sdk");
    zzFc.put("v", "3");
    zzFc.put("os", Build.VERSION.RELEASE);
    zzFc.put("sdk", Build.VERSION.SDK);
    zzFc.put("device", zzv.zzcJ().zzkm());
    Map localMap = zzFc;
    if (paramContext.getApplicationContext() != null)
    {
      paramString = paramContext.getApplicationContext().getPackageName();
      localMap.put("app", paramString);
      paramString = zzFc;
      if (!zzv.zzcJ().zzJ(paramContext)) {
        break label256;
      }
    }
    label256:
    for (paramContext = "1";; paramContext = "0")
    {
      paramString.put("is_lite_sdk", paramContext);
      paramContext = zzv.zzcS().zzv(mContext);
      zzFc.put("network_coarse", Integer.toString(zzUm));
      zzFc.put("network_fine", Integer.toString(zzUn));
      return;
      paramString = paramContext.getPackageName();
      break;
    }
  }
  
  Context getContext()
  {
    return mContext;
  }
  
  String zzdw()
  {
    return zzvU;
  }
  
  boolean zzfp()
  {
    return zzFa;
  }
  
  String zzfq()
  {
    return zzFb;
  }
  
  Map<String, String> zzfr()
  {
    return zzFc;
  }
}
