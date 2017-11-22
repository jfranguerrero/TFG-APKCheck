package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zze
{
  private final Context mContext;
  private final zzmm zzsQ;
  private boolean zzsR;
  
  public zze(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public zze(Context paramContext, @Nullable zzov.zza paramZza)
  {
    mContext = paramContext;
    if ((paramZza != null) && (zzVB.zzSd != null))
    {
      zzsQ = zzVB.zzSd;
      return;
    }
    zzsQ = new zzmm();
  }
  
  public zze(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext;
    zzsQ = new zzmm(paramBoolean);
  }
  
  public void recordClick()
  {
    zzsR = true;
  }
  
  public boolean zzcb()
  {
    return (!zzsQ.zzSi) || (zzsR);
  }
  
  public void zzx(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      zzpe.zzbd("Action was blocked because no touch was detected.");
      if ((!zzsQ.zzSi) || (zzsQ.zzSj == null)) {
        break;
      }
      Iterator localIterator = zzsQ.zzSj.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
        {
          str = str.replace("{NAVIGATION_URL}", Uri.encode(paramString));
          zzv.zzcJ().zzc(mContext, "", str);
        }
      }
      paramString = "";
    }
  }
}
