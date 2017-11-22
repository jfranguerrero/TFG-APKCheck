package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzmb
public final class zzkg
{
  public static AdRequest.Gender zzG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.UNKNOWN;
    case 2: 
      return AdRequest.Gender.FEMALE;
    }
    return AdRequest.Gender.MALE;
  }
  
  public static int zza(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.zzLf[paramErrorCode.ordinal()])
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static AdSize zzc(zzec paramZzec)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < 6)
    {
      if ((arrayOfAdSize[i].getWidth() == width) && (arrayOfAdSize[i].getHeight() == height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(zza.zza(width, height, zzzk));
  }
  
  public static MediationAdRequest zzs(zzdy paramZzdy)
  {
    if (zzyH != null) {}
    for (HashSet localHashSet = new HashSet(zzyH);; localHashSet = null) {
      return new MediationAdRequest(new Date(zzyF), zzG(zzyG), localHashSet, zzyI, zzyN);
    }
  }
}
