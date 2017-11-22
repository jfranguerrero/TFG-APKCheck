package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzmb
public final class zzey
{
  public static final String DEVICE_ID_EMULATOR = zzeh.zzeO().zzbb("emulator");
  private final Date zzcQ;
  private final Set<String> zzcS;
  private final Location zzcU;
  private final boolean zzsS;
  private final int zzyW;
  private final int zzyZ;
  private final Bundle zzzL;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzzM;
  private final SearchAdRequest zzzN;
  private final Set<String> zzzO;
  private final Set<String> zzzP;
  private final String zzza;
  private final String zzzc;
  private final Bundle zzze;
  private final String zzzg;
  private final boolean zzzi;
  
  public zzey(zza paramZza)
  {
    this(paramZza, null);
  }
  
  public zzey(zza paramZza, SearchAdRequest paramSearchAdRequest)
  {
    zzcQ = zza.zza(paramZza);
    zzzc = zza.zzb(paramZza);
    zzyW = zza.zzc(paramZza);
    zzcS = Collections.unmodifiableSet(zza.zzd(paramZza));
    zzcU = zza.zze(paramZza);
    zzsS = zza.zzf(paramZza);
    zzzL = zza.zzg(paramZza);
    zzzM = Collections.unmodifiableMap(zza.zzh(paramZza));
    zzza = zza.zzi(paramZza);
    zzzg = zza.zzj(paramZza);
    zzzN = paramSearchAdRequest;
    zzyZ = zza.zzk(paramZza);
    zzzO = Collections.unmodifiableSet(zza.zzl(paramZza));
    zzze = zza.zzm(paramZza);
    zzzP = Collections.unmodifiableSet(zza.zzn(paramZza));
    zzzi = zza.zzo(paramZza);
  }
  
  public Date getBirthday()
  {
    return zzcQ;
  }
  
  public String getContentUrl()
  {
    return zzzc;
  }
  
  public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = zzzL.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null) {
      return localBundle.getBundle(paramClass.getName());
    }
    return null;
  }
  
  public Bundle getCustomTargeting()
  {
    return zzze;
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
  
  public boolean getManualImpressionsEnabled()
  {
    return zzsS;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)zzzM.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return zzzL.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return zzza;
  }
  
  public boolean isDesignedForFamilies()
  {
    return zzzi;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zzzO.contains(zzeh.zzeO().zzO(paramContext));
  }
  
  public String zzeW()
  {
    return zzzg;
  }
  
  public SearchAdRequest zzeX()
  {
    return zzzN;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> zzeY()
  {
    return zzzM;
  }
  
  public Bundle zzeZ()
  {
    return zzzL;
  }
  
  public int zzfa()
  {
    return zzyZ;
  }
  
  public Set<String> zzfb()
  {
    return zzzP;
  }
  
  public static final class zza
  {
    private Date zzcQ;
    private Location zzcU;
    private boolean zzsS = false;
    private int zzyW = -1;
    private int zzyZ = -1;
    private final Bundle zzzL = new Bundle();
    private final HashSet<String> zzzQ = new HashSet();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzzR = new HashMap();
    private final HashSet<String> zzzS = new HashSet();
    private final HashSet<String> zzzT = new HashSet();
    private String zzza;
    private String zzzc;
    private final Bundle zzze = new Bundle();
    private String zzzg;
    private boolean zzzi;
    
    public zza() {}
    
    public void setManualImpressionsEnabled(boolean paramBoolean)
    {
      zzsS = paramBoolean;
    }
    
    public void zzL(String paramString)
    {
      zzzQ.add(paramString);
    }
    
    public void zzM(String paramString)
    {
      zzzS.add(paramString);
    }
    
    public void zzN(String paramString)
    {
      zzzS.remove(paramString);
    }
    
    public void zzO(String paramString)
    {
      zzzc = paramString;
    }
    
    public void zzP(String paramString)
    {
      zzza = paramString;
    }
    
    public void zzQ(String paramString)
    {
      zzzg = paramString;
    }
    
    public void zzR(String paramString)
    {
      zzzT.add(paramString);
    }
    
    @Deprecated
    public void zza(NetworkExtras paramNetworkExtras)
    {
      if ((paramNetworkExtras instanceof AdMobExtras))
      {
        zza(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
        return;
      }
      zzzR.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void zza(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      zzzL.putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zza(Date paramDate)
    {
      zzcQ = paramDate;
    }
    
    public void zzb(Location paramLocation)
    {
      zzcU = paramLocation;
    }
    
    public void zzb(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      if (zzzL.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
        zzzL.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
      }
      zzzL.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zze(String paramString1, String paramString2)
    {
      zzze.putString(paramString1, paramString2);
    }
    
    public void zzo(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        zzyZ = i;
        return;
      }
    }
    
    public void zzp(boolean paramBoolean)
    {
      zzzi = paramBoolean;
    }
    
    public void zzx(int paramInt)
    {
      zzyW = paramInt;
    }
  }
}
