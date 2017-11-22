package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzmb
public final class zzjy
  implements MediationAdRequest
{
  private final int zzKT;
  private final Date zzcQ;
  private final Set<String> zzcS;
  private final boolean zzcT;
  private final Location zzcU;
  private final int zzyW;
  private final boolean zzzi;
  
  public zzjy(@Nullable Date paramDate, int paramInt1, @Nullable Set<String> paramSet, @Nullable Location paramLocation, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    zzcQ = paramDate;
    zzyW = paramInt1;
    zzcS = paramSet;
    zzcU = paramLocation;
    zzcT = paramBoolean1;
    zzKT = paramInt2;
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
