package com.google.ads.mediation.admob;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;

@Keep
public final class AdMobAdapter
  extends AbstractAdViewAdapter
{
  public AdMobAdapter() {}
  
  protected Bundle zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null) {}
    for (;;)
    {
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson"))) {
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      }
      paramBundle1.putBoolean("_noRefresh", true);
      return paramBundle1;
      paramBundle1 = new Bundle();
    }
  }
}
