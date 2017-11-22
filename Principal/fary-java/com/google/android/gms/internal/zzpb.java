package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzpb
{
  private final String zzVE;
  private int zzWu;
  private int zzWv;
  private final Object zzrN = new Object();
  private final zzoy zzuG;
  
  zzpb(zzoy paramZzoy, String paramString)
  {
    zzuG = paramZzoy;
    zzVE = paramString;
  }
  
  public zzpb(String paramString)
  {
    this(zzv.zzcN(), paramString);
  }
  
  public Bundle toBundle()
  {
    synchronized (zzrN)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", zzWu);
      localBundle.putInt("pmnll", zzWv);
      return localBundle;
    }
  }
  
  public void zzj(int paramInt1, int paramInt2)
  {
    synchronized (zzrN)
    {
      zzWu = paramInt1;
      zzWv = paramInt2;
      zzuG.zza(zzVE, this);
      return;
    }
  }
}
