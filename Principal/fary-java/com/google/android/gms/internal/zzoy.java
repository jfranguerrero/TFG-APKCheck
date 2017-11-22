package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.zza;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

@zzmb
public class zzoy
  implements zzda.zzb, zzpg.zzb
{
  private Context mContext;
  private String zzHY;
  private boolean zzTB = true;
  private boolean zzTC = true;
  private boolean zzTD = true;
  private boolean zzTL = false;
  private final String zzVW;
  private final zzoz zzVX;
  private BigInteger zzVY = BigInteger.ONE;
  private final HashSet<zzow> zzVZ = new HashSet();
  private final HashMap<String, zzpb> zzWa = new HashMap();
  private boolean zzWb = false;
  private int zzWc = 0;
  private zzfz zzWd = null;
  private zzdb zzWe = null;
  private String zzWf;
  private String zzWg;
  private Boolean zzWh = null;
  private boolean zzWi = false;
  private boolean zzWj = false;
  private boolean zzWk = false;
  private String zzWl = "";
  private long zzWm = 0L;
  private long zzWn = 0L;
  private int zzWo = -1;
  private final Object zzrN = new Object();
  private zzcp zzsy;
  private boolean zztW = false;
  private zzqa zztr;
  private zzcz zzxE = null;
  
  public zzoy(zzpi paramZzpi)
  {
    zzVW = paramZzpi.zzkl();
    zzVX = new zzoz(zzVW);
  }
  
  public Resources getResources()
  {
    Resources localResources = null;
    if (zztr.zzYd) {
      localResources = mContext.getResources();
    }
    for (;;)
    {
      return localResources;
      try
      {
        DynamiteModule localDynamiteModule = DynamiteModule.zza(mContext, DynamiteModule.zzaQw, "com.google.android.gms.ads.dynamite");
        if (localDynamiteModule != null)
        {
          localResources = localDynamiteModule.zzBd().getResources();
          return localResources;
        }
      }
      catch (DynamiteModule.zza localZza)
      {
        zzpe.zzc("Cannot load resource from dynamite apk or local jar", localZza);
      }
    }
    return null;
  }
  
  public String getSessionId()
  {
    return zzVW;
  }
  
  public void zzE(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (zzTC != paramBoolean) {
        zzpg.zze(mContext, paramBoolean);
      }
      zzTC = paramBoolean;
      zzdb localZzdb = zzw(mContext);
      if ((localZzdb != null) && (!localZzdb.isAlive()))
      {
        zzpe.zzbd("start fetching content...");
        localZzdb.zzee();
      }
      return;
    }
  }
  
  public void zzF(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (zzTD != paramBoolean) {
        zzpg.zze(mContext, paramBoolean);
      }
      zzpg.zze(mContext, paramBoolean);
      zzTD = paramBoolean;
      zzdb localZzdb = zzw(mContext);
      if ((localZzdb != null) && (!localZzdb.isAlive()))
      {
        zzpe.zzbd("start fetching content...");
        localZzdb.zzee();
      }
      return;
    }
  }
  
  public void zzG(boolean paramBoolean)
  {
    zzWk = paramBoolean;
  }
  
  public void zzH(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzWi = paramBoolean;
      return;
    }
  }
  
  public Bundle zza(Context paramContext, zzpa paramZzpa, String paramString)
  {
    Bundle localBundle;
    synchronized (zzrN)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", zzVX.zze(paramContext, paramString));
      paramContext = new Bundle();
      paramString = zzWa.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((zzpb)zzWa.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = zzVZ.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((zzow)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramZzpa.zza(zzVZ);
    zzVZ.clear();
    return localBundle;
  }
  
  public void zza(zzow paramZzow)
  {
    synchronized (zzrN)
    {
      zzVZ.add(paramZzow);
      return;
    }
  }
  
  public void zza(String paramString, zzpb paramZzpb)
  {
    synchronized (zzrN)
    {
      zzWa.put(paramString, paramZzpb);
      return;
    }
  }
  
  public void zza(Throwable paramThrowable, String paramString)
  {
    zzlz.zzb(mContext, zztr).zza(paramThrowable, paramString);
  }
  
  public Future zzaS(String paramString)
  {
    Object localObject = zzrN;
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(zzWf))
      {
        zzWf = paramString;
        paramString = zzpg.zzf(mContext, paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public Future zzaT(String paramString)
  {
    Object localObject = zzrN;
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(zzWg))
      {
        zzWg = paramString;
        paramString = zzpg.zzg(mContext, paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public Future zzaf(int paramInt)
  {
    synchronized (zzrN)
    {
      zzWo = paramInt;
      Future localFuture = zzpg.zza(mContext, paramInt);
      return localFuture;
    }
  }
  
  public void zzb(Boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzWh = paramBoolean;
      return;
    }
  }
  
  public void zzb(HashSet<zzow> paramHashSet)
  {
    synchronized (zzrN)
    {
      zzVZ.addAll(paramHashSet);
      return;
    }
  }
  
  public Future zzc(Context paramContext, boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (paramBoolean != zzTB)
      {
        zzTB = paramBoolean;
        paramContext = zzpg.zzc(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  @TargetApi(23)
  public void zzc(Context paramContext, zzqa paramZzqa)
  {
    synchronized (zzrN)
    {
      if (!zztW)
      {
        mContext = paramContext.getApplicationContext();
        zztr = paramZzqa;
        zzv.zzcM().zza(this);
        zzpg.zza(paramContext, this);
        zzpg.zzb(paramContext, this);
        zzpg.zzc(paramContext, this);
        zzpg.zzd(paramContext, this);
        zzpg.zze(paramContext, this);
        zzpg.zzf(paramContext, this);
        zzpg.zzg(paramContext, this);
        zzka();
        zzHY = zzv.zzcJ().zzh(paramContext, zzaZ);
        if ((zzs.zzyJ()) && (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
          zzWj = true;
        }
        zzsy = new zzcp(paramContext.getApplicationContext(), zztr, zzv.zzcJ().zzd(paramContext, paramZzqa));
        zzkc();
        zzv.zzcX().zzr(mContext);
        zztW = true;
      }
      return;
    }
  }
  
  public Future zzd(Context paramContext, String paramString)
  {
    zzWm = zzv.zzcP().currentTimeMillis();
    Object localObject = zzrN;
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(zzWl))
      {
        zzWl = paramString;
        paramContext = zzpg.zza(paramContext, paramString, zzWm);
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public Future zzd(Context paramContext, boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (paramBoolean != zzTL)
      {
        zzTL = paramBoolean;
        paramContext = zzpg.zzf(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  public void zzh(Bundle paramBundle)
  {
    synchronized (zzrN)
    {
      zzTB = paramBundle.getBoolean("use_https", zzTB);
      zzWc = paramBundle.getInt("webview_cache_version", zzWc);
      if (paramBundle.containsKey("content_url_opted_out")) {
        zzE(paramBundle.getBoolean("content_url_opted_out"));
      }
      if (paramBundle.containsKey("content_url_hashes")) {
        zzWf = paramBundle.getString("content_url_hashes");
      }
      zzTL = paramBundle.getBoolean("auto_collect_location", zzTL);
      if (paramBundle.containsKey("content_vertical_opted_out")) {
        zzF(paramBundle.getBoolean("content_vertical_opted_out"));
      }
      if (paramBundle.containsKey("content_vertical_hashes")) {
        zzWg = paramBundle.getString("content_vertical_hashes");
      }
      if (paramBundle.containsKey("app_settings_json"))
      {
        str = paramBundle.getString("app_settings_json");
        zzWl = str;
        zzWm = paramBundle.getLong("app_settings_last_update_ms", zzWm);
        zzWn = paramBundle.getLong("app_last_background_time_ms", zzWn);
        zzWo = paramBundle.getInt("request_in_session_count", zzWo);
        return;
      }
      String str = zzWl;
    }
  }
  
  public boolean zzjJ()
  {
    synchronized (zzrN)
    {
      boolean bool = zzTC;
      return bool;
    }
  }
  
  public boolean zzjK()
  {
    synchronized (zzrN)
    {
      boolean bool = zzTD;
      return bool;
    }
  }
  
  public String zzjL()
  {
    synchronized (zzrN)
    {
      String str = zzVY.toString();
      zzVY = zzVY.add(BigInteger.ONE);
      return str;
    }
  }
  
  public zzoz zzjM()
  {
    synchronized (zzrN)
    {
      zzoz localZzoz = zzVX;
      return localZzoz;
    }
  }
  
  public zzfz zzjN()
  {
    synchronized (zzrN)
    {
      zzfz localZzfz = zzWd;
      return localZzfz;
    }
  }
  
  public boolean zzjO()
  {
    synchronized (zzrN)
    {
      boolean bool = zzWb;
      zzWb = true;
      return bool;
    }
  }
  
  public boolean zzjP()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (!zzTB)
        {
          if (!zzWj) {
            break label38;
          }
          break label33;
          return bool;
        }
      }
      label33:
      boolean bool = true;
      continue;
      label38:
      bool = false;
    }
  }
  
  public String zzjQ()
  {
    synchronized (zzrN)
    {
      String str = zzHY;
      return str;
    }
  }
  
  public String zzjR()
  {
    synchronized (zzrN)
    {
      String str = zzWf;
      return str;
    }
  }
  
  public String zzjS()
  {
    synchronized (zzrN)
    {
      String str = zzWg;
      return str;
    }
  }
  
  public Boolean zzjT()
  {
    synchronized (zzrN)
    {
      Boolean localBoolean = zzWh;
      return localBoolean;
    }
  }
  
  public boolean zzjU()
  {
    synchronized (zzrN)
    {
      boolean bool = zzTL;
      return bool;
    }
  }
  
  public long zzjV()
  {
    synchronized (zzrN)
    {
      long l = zzWn;
      return l;
    }
  }
  
  public int zzjW()
  {
    synchronized (zzrN)
    {
      int i = zzWo;
      return i;
    }
  }
  
  public boolean zzjX()
  {
    return zzWk;
  }
  
  public zzox zzjY()
  {
    synchronized (zzrN)
    {
      zzox localZzox = new zzox(zzWl, zzWm);
      return localZzox;
    }
  }
  
  public zzcp zzjZ()
  {
    return zzsy;
  }
  
  public void zzk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (zzv.zzcP().currentTimeMillis() - zzWn > ((Long)zzfx.zzCv.get()).longValue())
      {
        zzVX.zzag(-1);
        return;
      }
      zzVX.zzag(zzWo);
      return;
    }
    zzo(zzv.zzcP().currentTimeMillis());
    zzaf(zzVX.zzjW());
  }
  
  public void zzka()
  {
    zzlz.zzb(mContext, zztr);
  }
  
  public boolean zzkb()
  {
    synchronized (zzrN)
    {
      boolean bool = zzWi;
      return bool;
    }
  }
  
  void zzkc()
  {
    zzfy localZzfy = new zzfy(mContext, zztr.zzaZ);
    try
    {
      zzWd = zzv.zzcQ().zza(localZzfy);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzpe.zzc("Cannot initialize CSI reporter.", localIllegalArgumentException);
    }
  }
  
  public Future zzo(long paramLong)
  {
    synchronized (zzrN)
    {
      if (zzWn < paramLong)
      {
        zzWn = paramLong;
        Future localFuture = zzpg.zza(mContext, paramLong);
        return localFuture;
      }
      return null;
    }
  }
  
  public zzdb zzw(Context paramContext)
  {
    if (!((Boolean)zzfx.zzBO.get()).booleanValue()) {
      return null;
    }
    if (!zzs.zzyA()) {
      return null;
    }
    if ((!((Boolean)zzfx.zzBW.get()).booleanValue()) && (!((Boolean)zzfx.zzBU.get()).booleanValue())) {
      return null;
    }
    if ((zzjJ()) && (zzjK())) {
      return null;
    }
    synchronized (zzrN)
    {
      if ((Looper.getMainLooper() == null) || (paramContext == null)) {
        return null;
      }
      if (zzxE == null) {
        zzxE = new zzcz();
      }
      if (zzWe == null) {
        zzWe = new zzdb(zzxE, zzlz.zzb(mContext, zztr));
      }
      zzWe.zzee();
      paramContext = zzWe;
      return paramContext;
    }
  }
}
