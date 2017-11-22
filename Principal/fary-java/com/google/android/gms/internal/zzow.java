package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzmb
public class zzow
{
  private boolean zzTw = false;
  private final LinkedList<zza> zzVC;
  private final String zzVD;
  private final String zzVE;
  private long zzVF = -1L;
  private long zzVG = -1L;
  private long zzVH = -1L;
  private long zzVI = 0L;
  private long zzVJ = -1L;
  private long zzVK = -1L;
  private final Object zzrN = new Object();
  private final zzoy zzuG;
  
  public zzow(zzoy paramZzoy, String paramString1, String paramString2)
  {
    zzuG = paramZzoy;
    zzVD = paramString1;
    zzVE = paramString2;
    zzVC = new LinkedList();
  }
  
  public zzow(String paramString1, String paramString2)
  {
    this(zzv.zzcN(), paramString1, paramString2);
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (zzrN)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seq_num", zzVD);
      localBundle1.putString("slotid", zzVE);
      localBundle1.putBoolean("ismediation", zzTw);
      localBundle1.putLong("treq", zzVJ);
      localBundle1.putLong("tresponse", zzVK);
      localBundle1.putLong("timp", zzVG);
      localBundle1.putLong("tload", zzVH);
      localBundle1.putLong("pcc", zzVI);
      localBundle1.putLong("tfetch", zzVF);
      localArrayList = new ArrayList();
      Iterator localIterator = zzVC.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((zza)localIterator.next()).toBundle());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
  
  public void zzC(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (zzVK != -1L)
      {
        zzVH = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          zzVG = zzVH;
          zzuG.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzD(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (zzVK != -1L)
      {
        zzTw = paramBoolean;
        zzuG.zza(this);
      }
      return;
    }
  }
  
  public void zzjA()
  {
    synchronized (zzrN)
    {
      if (zzVK != -1L)
      {
        zza localZza = new zza();
        localZza.zzjE();
        zzVC.add(localZza);
        zzVI += 1L;
        zzuG.zzjM().zzjA();
        zzuG.zza(this);
      }
      return;
    }
  }
  
  public void zzjB()
  {
    synchronized (zzrN)
    {
      if ((zzVK != -1L) && (!zzVC.isEmpty()))
      {
        zza localZza = (zza)zzVC.getLast();
        if (localZza.zzjC() == -1L)
        {
          localZza.zzjD();
          zzuG.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzjz()
  {
    synchronized (zzrN)
    {
      if ((zzVK != -1L) && (zzVG == -1L))
      {
        zzVG = SystemClock.elapsedRealtime();
        zzuG.zza(this);
      }
      zzuG.zzjM().zzjz();
      return;
    }
  }
  
  public void zzm(long paramLong)
  {
    synchronized (zzrN)
    {
      zzVK = paramLong;
      if (zzVK != -1L) {
        zzuG.zza(this);
      }
      return;
    }
  }
  
  public void zzn(long paramLong)
  {
    synchronized (zzrN)
    {
      if (zzVK != -1L)
      {
        zzVF = paramLong;
        zzuG.zza(this);
      }
      return;
    }
  }
  
  public void zzt(zzdy paramZzdy)
  {
    synchronized (zzrN)
    {
      zzVJ = SystemClock.elapsedRealtime();
      zzuG.zzjM().zzb(paramZzdy, zzVJ);
      return;
    }
  }
  
  @zzmb
  private static final class zza
  {
    private long zzVL = -1L;
    private long zzVM = -1L;
    
    public zza() {}
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", zzVL);
      localBundle.putLong("tclose", zzVM);
      return localBundle;
    }
    
    public long zzjC()
    {
      return zzVM;
    }
    
    public void zzjD()
    {
      zzVM = SystemClock.elapsedRealtime();
    }
    
    public void zzjE()
    {
      zzVL = SystemClock.elapsedRealtime();
    }
  }
}
