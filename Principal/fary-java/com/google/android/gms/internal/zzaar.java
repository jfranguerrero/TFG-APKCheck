package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzaar
  extends BroadcastReceiver
{
  protected Context mContext;
  private final zza zzaBm;
  
  public zzaar(zza paramZza)
  {
    zzaBm = paramZza;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      zzaBm.zzvb();
      unregister();
    }
  }
  
  public void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public void unregister()
  {
    try
    {
      if (mContext != null) {
        mContext.unregisterReceiver(this);
      }
      mContext = null;
      return;
    }
    finally {}
  }
  
  public static abstract class zza
  {
    public zza() {}
    
    public abstract void zzvb();
  }
}
