package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions.Builder;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzmb
public final class zzkd
  implements NativeMediationAdRequest
{
  private final int zzKT;
  private final Date zzcQ;
  private final Set<String> zzcS;
  private final boolean zzcT;
  private final Location zzcU;
  private final zzgw zztn;
  private final List<String> zzto;
  private final int zzyW;
  private final boolean zzzi;
  
  public zzkd(@Nullable Date paramDate, int paramInt1, @Nullable Set<String> paramSet, @Nullable Location paramLocation, boolean paramBoolean1, int paramInt2, zzgw paramZzgw, List<String> paramList, boolean paramBoolean2)
  {
    zzcQ = paramDate;
    zzyW = paramInt1;
    zzcS = paramSet;
    zzcU = paramLocation;
    zzcT = paramBoolean1;
    zzKT = paramInt2;
    zztn = paramZzgw;
    zzto = paramList;
    zzzi = paramBoolean2;
  }
  
  public Date getBirthday()
  {
    return zzcQ;
  }
  
  public int getGender()
  {
    return zzyW;
  }
  
  public Set<String> getKeywords()
  {
    return zzcS;
  }
  
  public Location getLocation()
  {
    return zzcU;
  }
  
  public NativeAdOptions getNativeAdOptions()
  {
    if (zztn == null) {
      return null;
    }
    NativeAdOptions.Builder localBuilder = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(zztn.zzGD).setImageOrientation(zztn.zzGE).setRequestMultipleImages(zztn.zzGF);
    if (zztn.versionCode >= 2) {
      localBuilder.setAdChoicesPlacement(zztn.zzGG);
    }
    if ((zztn.versionCode >= 3) && (zztn.zzGH != null)) {
      localBuilder.setVideoOptions(new VideoOptions.Builder().setStartMuted(zztn.zzGH.zzAE).build());
    }
    return localBuilder.build();
  }
  
  public boolean isAppInstallAdRequested()
  {
    return (zzto != null) && (zzto.contains("2"));
  }
  
  public boolean isContentAdRequested()
  {
    return (zzto != null) && (zzto.contains("1"));
  }
  
  public boolean isDesignedForFamilies()
  {
    return zzzi;
  }
  
  public boolean isTesting()
  {
    return zzcT;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return zzKT;
  }
}
