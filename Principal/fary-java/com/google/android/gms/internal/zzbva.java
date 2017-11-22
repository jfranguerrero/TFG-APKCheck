package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public class zzbva
  extends CustomTabsServiceConnection
{
  private WeakReference<zzbvb> zzcsV;
  
  public zzbva(zzbvb paramZzbvb)
  {
    zzcsV = new WeakReference(paramZzbvb);
  }
  
  public void onCustomTabsServiceConnected(ComponentName paramComponentName, CustomTabsClient paramCustomTabsClient)
  {
    paramComponentName = (zzbvb)zzcsV.get();
    if (paramComponentName != null) {
      paramComponentName.zza(paramCustomTabsClient);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = (zzbvb)zzcsV.get();
    if (paramComponentName != null) {
      paramComponentName.zzfD();
    }
  }
}
