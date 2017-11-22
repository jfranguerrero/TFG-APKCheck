package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest
{
  private final Date zzcQ;
  private final AdRequest.Gender zzcR;
  private final Set<String> zzcS;
  private final boolean zzcT;
  private final Location zzcU;
  
  public MediationAdRequest(Date paramDate, AdRequest.Gender paramGender, Set<String> paramSet, boolean paramBoolean, Location paramLocation)
  {
    zzcQ = paramDate;
    zzcR = paramGender;
    zzcS = paramSet;
    zzcT = paramBoolean;
    zzcU = paramLocation;
  }
  
  public Integer getAgeInYears()
  {
    if (zzcQ != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar1.setTime(zzcQ);
      Integer localInteger2 = Integer.valueOf(localCalendar2.get(1) - localCalendar1.get(1));
      Integer localInteger1;
      if (localCalendar2.get(2) >= localCalendar1.get(2))
      {
        localInteger1 = localInteger2;
        if (localCalendar2.get(2) == localCalendar1.get(2))
        {
          localInteger1 = localInteger2;
          if (localCalendar2.get(5) >= localCalendar1.get(5)) {}
        }
      }
      else
      {
        localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
      }
      return localInteger1;
    }
    return null;
  }
  
  public Date getBirthday()
  {
    return zzcQ;
  }
  
  public AdRequest.Gender getGender()
  {
    return zzcR;
  }
  
  public Set<String> getKeywords()
  {
    return zzcS;
  }
  
  public Location getLocation()
  {
    return zzcU;
  }
  
  public boolean isTesting()
  {
    return zzcT;
  }
}
