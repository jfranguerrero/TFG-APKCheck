package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzey.zza;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = zzey.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final int mBackgroundColor;
  private final int zzaaa;
  private final int zzaab;
  private final int zzaac;
  private final int zzaad;
  private final int zzaae;
  private final int zzaaf;
  private final int zzaag;
  private final String zzaah;
  private final int zzaai;
  private final String zzaaj;
  private final int zzaak;
  private final int zzaal;
  private final zzey zzrE;
  private final String zzuv;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    zzaaa = Builder.zza(paramBuilder);
    mBackgroundColor = Builder.zzb(paramBuilder);
    zzaab = Builder.zzc(paramBuilder);
    zzaac = Builder.zzd(paramBuilder);
    zzaad = Builder.zze(paramBuilder);
    zzaae = Builder.zzf(paramBuilder);
    zzaaf = Builder.zzg(paramBuilder);
    zzaag = Builder.zzh(paramBuilder);
    zzaah = Builder.zzi(paramBuilder);
    zzaai = Builder.zzj(paramBuilder);
    zzaaj = Builder.zzk(paramBuilder);
    zzaak = Builder.zzl(paramBuilder);
    zzaal = Builder.zzm(paramBuilder);
    zzuv = Builder.zzn(paramBuilder);
    zzrE = new zzey(Builder.zzo(paramBuilder), this);
  }
  
  public int getAnchorTextColor()
  {
    return zzaaa;
  }
  
  public int getBackgroundColor()
  {
    return mBackgroundColor;
  }
  
  public int getBackgroundGradientBottom()
  {
    return zzaab;
  }
  
  public int getBackgroundGradientTop()
  {
    return zzaac;
  }
  
  public int getBorderColor()
  {
    return zzaad;
  }
  
  public int getBorderThickness()
  {
    return zzaae;
  }
  
  public int getBorderType()
  {
    return zzaaf;
  }
  
  public int getCallButtonColor()
  {
    return zzaag;
  }
  
  public String getCustomChannels()
  {
    return zzaah;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return zzrE.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return zzaai;
  }
  
  public String getFontFace()
  {
    return zzaaj;
  }
  
  public int getHeaderTextColor()
  {
    return zzaak;
  }
  
  public int getHeaderTextSize()
  {
    return zzaal;
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
  
  public String getQuery()
  {
    return zzuv;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zzrE.isTestDevice(paramContext);
  }
  
  zzey zzbq()
  {
    return zzrE;
  }
  
  public static final class Builder
  {
    private int mBackgroundColor;
    private int zzaaa;
    private int zzaab;
    private int zzaac;
    private int zzaad;
    private int zzaae;
    private int zzaaf = 0;
    private int zzaag;
    private String zzaah;
    private int zzaai;
    private String zzaaj;
    private int zzaak;
    private int zzaal;
    private final zzey.zza zzrF = new zzey.zza();
    private String zzuv;
    
    public Builder() {}
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      zzrF.zzb(paramClass, paramBundle);
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
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      zzrF.zzM(paramString);
      return this;
    }
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      zzaaa = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      mBackgroundColor = paramInt;
      zzaab = Color.argb(0, 0, 0, 0);
      zzaac = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      mBackgroundColor = Color.argb(0, 0, 0, 0);
      zzaab = paramInt2;
      zzaac = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      zzaad = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      zzaae = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      zzaaf = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      zzaag = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      zzaah = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      zzaai = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      zzaaj = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      zzaak = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      zzaal = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      zzrF.zzb(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      zzuv = paramString;
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
