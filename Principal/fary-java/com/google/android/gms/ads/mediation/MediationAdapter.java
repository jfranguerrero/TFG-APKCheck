package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public abstract interface MediationAdapter
{
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public static class zza
  {
    private int zzZN;
    
    public zza() {}
    
    public zza zzak(int paramInt)
    {
      zzZN = paramInt;
      return this;
    }
    
    public Bundle zzlL()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("capabilities", zzZN);
      return localBundle;
    }
  }
}
