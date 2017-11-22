package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzz;

@Deprecated
public final class zzaas
{
  private static zzaas zzaBn;
  private static final Object zztU = new Object();
  private final String zzVQ;
  private final Status zzaBo;
  private final boolean zzaBp;
  private final boolean zzaBq;
  
  zzaas(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    if (i != 0) {
      if (((Resources)localObject).getInteger(i) != 0)
      {
        bool1 = true;
        if (bool1) {
          break label127;
        }
      }
    }
    label52:
    for (zzaBq = bool2;; zzaBq = false)
    {
      zzaBp = bool1;
      String str = zzz.zzaD(paramContext);
      localObject = str;
      if (str == null) {
        localObject = new zzam(paramContext).getString("google_app_id");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label141;
      }
      zzaBo = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      zzVQ = null;
      return;
      bool1 = false;
      break;
      label127:
      bool2 = false;
      break label52;
    }
    label141:
    zzVQ = ((String)localObject);
    zzaBo = Status.zzayh;
  }
  
  public static Status zzay(Context paramContext)
  {
    zzac.zzb(paramContext, "Context must not be null.");
    synchronized (zztU)
    {
      if (zzaBn == null) {
        zzaBn = new zzaas(paramContext);
      }
      paramContext = zzaBnzzaBo;
      return paramContext;
    }
  }
  
  private static zzaas zzdc(String paramString)
  {
    synchronized (zztU)
    {
      if (zzaBn == null) {
        throw new IllegalStateException(String.valueOf(paramString).length() + 34 + "Initialize must be called before " + paramString + ".");
      }
    }
    paramString = zzaBn;
    return paramString;
  }
  
  public static String zzwj()
  {
    return zzdc"getGoogleAppId"zzVQ;
  }
  
  public static boolean zzwk()
  {
    return zzdc"isMeasurementExplicitlyDisabled"zzaBq;
  }
}
