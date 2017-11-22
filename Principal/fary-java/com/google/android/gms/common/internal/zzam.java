package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R.string;

public class zzam
{
  private final Resources zzaFn;
  private final String zzaFo;
  
  public zzam(Context paramContext)
  {
    zzac.zzw(paramContext);
    zzaFn = paramContext.getResources();
    zzaFo = zzaFn.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  public String getString(String paramString)
  {
    int i = zzaFn.getIdentifier(paramString, "string", zzaFo);
    if (i == 0) {
      return null;
    }
    return zzaFn.getString(i);
  }
}
