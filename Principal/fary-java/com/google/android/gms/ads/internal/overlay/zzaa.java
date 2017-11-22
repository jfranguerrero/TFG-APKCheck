package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;

@zzmb
class zzaa
  implements Runnable
{
  private boolean mCancelled = false;
  private zzl zzOA;
  
  zzaa(zzl paramZzl)
  {
    zzOA = paramZzl;
  }
  
  public void cancel()
  {
    mCancelled = true;
    zzpi.zzWR.removeCallbacks(this);
  }
  
  public void run()
  {
    if (!mCancelled)
    {
      zzOA.zzhH();
      zzid();
    }
  }
  
  public void zzid()
  {
    zzpi.zzWR.postDelayed(this, 250L);
  }
}
