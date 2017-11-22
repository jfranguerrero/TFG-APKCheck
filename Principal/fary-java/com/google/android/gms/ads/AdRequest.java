package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzey.zza;
import java.util.Date;
import java.util.Set;

public final class AdRequest
{
  public static final String DEVICE_ID_EMULATOR = zzey.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  public static final int MAX_CONTENT_URL_LENGTH = 512;
  private final zzey zzrE;
  
  private AdRequest(Builder paramBuilder)
  {
    zzrE = new zzey(Builder.zza(paramBuilder));
  }
  
  public Date getBirthday()
  {
    return zzrE.getBirthday();
  }
  
  public String getContentUrl()
  {
    return zzrE.getContentUrl();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return zzrE.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getGender()
  {
    return zzrE.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return zzrE.getKeywords();
  }
  
  public Location getLocation()
  {
    return zzrE.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return zzrE.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return zzrE.getNetworkExtrasBundle(paramClass);
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zzrE.isTestDevice(paramContext);
  }
  
  public zzey zzbq()
  {
    return zzrE;
  }
  
  public static final class Builder
  {
    private final zzey.zza zzrF = new zzey.zza();
    
    public Builder()
    {
      zzrF.zzM(AdRequest.DEVICE_ID_EMULATOR);
    }
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      zzrF.zzb(paramClass, paramBundle);
      return this;
    }
    
    public Builder addKeyword(String paramString)
    {
      zzrF.zzL(paramString);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      zzrF.zza(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      zzrF.zza(paramClass, paramBundle);
      if ((paramClass.equals(AdMobAdapter.class)) && (paramBundle.getBoolean("_emulatorLiveAds"))) {
        zzrF.zzN(AdRequest.DEVICE_ID_EMULATOR);
      }
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      zzrF.zzM(paramString);
      return this;
    }
    
    public AdRequest build()
    {
      return new AdRequest(this, null);
    }
    
    public Builder setBirthday(Date paramDate)
    {
      zzrF.zza(paramDate);
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      zzac.zzb(paramString, "Content URL must be non-null.");
      zzac.zzh(paramString, "Content URL must be non-empty.");
      if (paramString.length() <= 512) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] { Integer.valueOf(512), Integer.valueOf(paramString.length()) });
        zzrF.zzO(paramString);
        return this;
      }
    }
    
    public Builder setGender(int paramInt)
    {
      zzrF.zzx(paramInt);
      return this;
    }
    
    public Builder setIsDesignedForFamilies(boolean paramBoolean)
    {
      zzrF.zzp(paramBoolean);
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      zzrF.zzb(paramLocation);
      return this;
    }
    
    public Builder setRequestAgent(String paramString)
    {
      zzrF.zzQ(paramString);
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      zzrF.zzo(paramBoolean);
      return this;
    }
  }
}
