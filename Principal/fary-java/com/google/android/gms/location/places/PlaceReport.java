package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzac;

public class PlaceReport
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzl();
  private final String mTag;
  final int mVersionCode;
  private final String zzabN;
  private final String zzblg;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    zzblg = paramString1;
    mTag = paramString2;
    zzabN = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzj(paramString1, paramString2, "unknown");
  }
  
  private static boolean zzeY(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static PlaceReport zzj(String paramString1, String paramString2, String paramString3)
  {
    zzac.zzw(paramString1);
    zzac.zzdv(paramString2);
    zzac.zzdv(paramString3);
    zzac.zzb(zzeY(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!zzaa.equal(zzblg, zzblg)) || (!zzaa.equal(mTag, mTag)) || (!zzaa.equal(zzabN, zzabN)));
    return true;
  }
  
  public String getPlaceId()
  {
    return zzblg;
  }
  
  public String getSource()
  {
    return zzabN;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { zzblg, mTag, zzabN });
  }
  
  public String toString()
  {
    zzaa.zza localZza = zzaa.zzv(this);
    localZza.zzg("placeId", zzblg);
    localZza.zzg("tag", mTag);
    if (!"unknown".equals(zzabN)) {
      localZza.zzg("source", zzabN);
    }
    return localZza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}
