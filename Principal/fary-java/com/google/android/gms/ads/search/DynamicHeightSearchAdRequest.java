package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzey;

public final class DynamicHeightSearchAdRequest
{
  private final SearchAdRequest zzZX;
  
  private DynamicHeightSearchAdRequest(Builder paramBuilder)
  {
    zzZX = Builder.zza(paramBuilder).build();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return zzZX.getCustomEventExtrasBundle(paramClass);
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return zzZX.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return zzZX.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return zzZX.getQuery();
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zzZX.isTestDevice(paramContext);
  }
  
  zzey zzbq()
  {
    return zzZX.zzbq();
  }
  
  public static final class Builder
  {
    private final SearchAdRequest.Builder zzZY = new SearchAdRequest.Builder();
    private final Bundle zzZZ = new Bundle();
    
    public Builder() {}
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      zzZY.addCustomEventExtrasBundle(paramClass, paramBundle);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      zzZY.addNetworkExtras(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      zzZY.addNetworkExtrasBundle(paramClass, paramBundle);
      return this;
    }
    
    public DynamicHeightSearchAdRequest build()
    {
      zzZY.addNetworkExtrasBundle(AdMobAdapter.class, zzZZ);
      return new DynamicHeightSearchAdRequest(this, null);
    }
    
    public Builder setAdBorderSelectors(String paramString)
    {
      zzZZ.putString("csa_adBorderSelectors", paramString);
      return this;
    }
    
    public Builder setAdTest(boolean paramBoolean)
    {
      Bundle localBundle = zzZZ;
      if (paramBoolean) {}
      for (String str = "on";; str = "off")
      {
        localBundle.putString("csa_adtest", str);
        return this;
      }
    }
    
    public Builder setAdjustableLineHeight(int paramInt)
    {
      zzZZ.putString("csa_adjustableLineHeight", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setAdvancedOptionValue(String paramString1, String paramString2)
    {
      zzZZ.putString(paramString1, paramString2);
      return this;
    }
    
    public Builder setAttributionSpacingBelow(int paramInt)
    {
      zzZZ.putString("csa_attributionSpacingBelow", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setBorderSelections(String paramString)
    {
      zzZZ.putString("csa_borderSelections", paramString);
      return this;
    }
    
    public Builder setChannel(String paramString)
    {
      zzZZ.putString("csa_channel", paramString);
      return this;
    }
    
    public Builder setColorAdBorder(String paramString)
    {
      zzZZ.putString("csa_colorAdBorder", paramString);
      return this;
    }
    
    public Builder setColorAdSeparator(String paramString)
    {
      zzZZ.putString("csa_colorAdSeparator", paramString);
      return this;
    }
    
    public Builder setColorAnnotation(String paramString)
    {
      zzZZ.putString("csa_colorAnnotation", paramString);
      return this;
    }
    
    public Builder setColorAttribution(String paramString)
    {
      zzZZ.putString("csa_colorAttribution", paramString);
      return this;
    }
    
    public Builder setColorBackground(String paramString)
    {
      zzZZ.putString("csa_colorBackground", paramString);
      return this;
    }
    
    public Builder setColorBorder(String paramString)
    {
      zzZZ.putString("csa_colorBorder", paramString);
      return this;
    }
    
    public Builder setColorDomainLink(String paramString)
    {
      zzZZ.putString("csa_colorDomainLink", paramString);
      return this;
    }
    
    public Builder setColorText(String paramString)
    {
      zzZZ.putString("csa_colorText", paramString);
      return this;
    }
    
    public Builder setColorTitleLink(String paramString)
    {
      zzZZ.putString("csa_colorTitleLink", paramString);
      return this;
    }
    
    public Builder setCssWidth(int paramInt)
    {
      zzZZ.putString("csa_width", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setDetailedAttribution(boolean paramBoolean)
    {
      zzZZ.putString("csa_detailedAttribution", Boolean.toString(paramBoolean));
      return this;
    }
    
    @Deprecated
    public Builder setFontFamily(int paramInt)
    {
      return setFontFamily(Integer.toString(paramInt));
    }
    
    public Builder setFontFamily(String paramString)
    {
      zzZZ.putString("csa_fontFamily", paramString);
      return this;
    }
    
    public Builder setFontFamilyAttribution(String paramString)
    {
      zzZZ.putString("csa_fontFamilyAttribution", paramString);
      return this;
    }
    
    public Builder setFontSizeAnnotation(int paramInt)
    {
      zzZZ.putString("csa_fontSizeAnnotation", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setFontSizeAttribution(int paramInt)
    {
      zzZZ.putString("csa_fontSizeAttribution", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setFontSizeDescription(int paramInt)
    {
      zzZZ.putString("csa_fontSizeDescription", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setFontSizeDomainLink(int paramInt)
    {
      zzZZ.putString("csa_fontSizeDomainLink", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setFontSizeTitle(int paramInt)
    {
      zzZZ.putString("csa_fontSizeTitle", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setHostLanguage(String paramString)
    {
      zzZZ.putString("csa_hl", paramString);
      return this;
    }
    
    public Builder setIsClickToCallEnabled(boolean paramBoolean)
    {
      zzZZ.putString("csa_clickToCall", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setIsLocationEnabled(boolean paramBoolean)
    {
      zzZZ.putString("csa_location", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setIsPlusOnesEnabled(boolean paramBoolean)
    {
      zzZZ.putString("csa_plusOnes", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setIsSellerRatingsEnabled(boolean paramBoolean)
    {
      zzZZ.putString("csa_sellerRatings", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setIsSiteLinksEnabled(boolean paramBoolean)
    {
      zzZZ.putString("csa_siteLinks", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setIsTitleBold(boolean paramBoolean)
    {
      zzZZ.putString("csa_titleBold", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setIsTitleUnderlined(boolean paramBoolean)
    {
      Bundle localBundle = zzZZ;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localBundle.putString("csa_noTitleUnderline", Boolean.toString(paramBoolean));
        return this;
      }
    }
    
    public Builder setLocationColor(String paramString)
    {
      zzZZ.putString("csa_colorLocation", paramString);
      return this;
    }
    
    public Builder setLocationFontSize(int paramInt)
    {
      zzZZ.putString("csa_fontSizeLocation", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setLongerHeadlines(boolean paramBoolean)
    {
      zzZZ.putString("csa_longerHeadlines", Boolean.toString(paramBoolean));
      return this;
    }
    
    public Builder setNumber(int paramInt)
    {
      zzZZ.putString("csa_number", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setPage(int paramInt)
    {
      zzZZ.putString("csa_adPage", Integer.toString(paramInt));
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      zzZY.setQuery(paramString);
      return this;
    }
    
    public Builder setVerticalSpacing(int paramInt)
    {
      zzZZ.putString("csa_verticalSpacing", Integer.toString(paramInt));
      return this;
    }
  }
}
