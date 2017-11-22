package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzas
  extends zzat
{
  private static final String TAG = zzas.class.getSimpleName();
  private AdvertisingIdClient.Info zzpU;
  
  protected zzas(Context paramContext)
  {
    super(paramContext, "");
  }
  
  public static zzas zzc(Context paramContext)
  {
    zza(paramContext, true);
    return new zzas(paramContext);
  }
  
  protected zzaf.zza zza(Context paramContext, View paramView)
  {
    return null;
  }
  
  public String zza(String paramString1, String paramString2)
  {
    return zzan.zza(paramString1, paramString2, true);
  }
  
  public void zza(AdvertisingIdClient.Info paramInfo)
  {
    zzpU = paramInfo;
  }
  
  protected void zza(zzbc paramZzbc, zzaf.zza paramZza, zzad.zza paramZza1)
  {
    if (paramZzbc.zzaO())
    {
      if (zzpU != null)
      {
        paramZzbc = zzpU.getId();
        if (!TextUtils.isEmpty(paramZzbc))
        {
          zzbV = zzbe.zzr(paramZzbc);
          zzbW = Integer.valueOf(5);
          zzbX = Boolean.valueOf(zzpU.isLimitAdTrackingEnabled());
        }
        zzpU = null;
      }
      return;
    }
    zza(zzb(paramZzbc, paramZza, paramZza1));
  }
  
  protected List<Callable<Void>> zzb(zzbc paramZzbc, zzaf.zza paramZza, zzad.zza paramZza1)
  {
    paramZza1 = new ArrayList();
    if (paramZzbc.zzaJ() == null) {
      return paramZza1;
    }
    int i = paramZzbc.zzT();
    paramZza1.add(new zzbm(paramZzbc, zzay.zzaj(), zzay.zzak(), paramZza, i, 24));
    return paramZza1;
  }
}
