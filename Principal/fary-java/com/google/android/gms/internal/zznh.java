package com.google.android.gms.internal;

import android.content.Context;

@zzmb
public abstract class zznh
{
  public zznh() {}
  
  public abstract void zza(Context paramContext, zznb paramZznb, zzqa paramZzqa);
  
  protected void zze(zznb paramZznb)
  {
    if (paramZznb.zzjg() != null) {
      paramZznb.zzjg().release();
    }
  }
}
