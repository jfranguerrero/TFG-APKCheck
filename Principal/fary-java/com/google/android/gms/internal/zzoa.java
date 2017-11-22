package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzoa
  extends zzpd
  implements zzoc, zzof
{
  private final Context mContext;
  private final String zzKo;
  private int zzPF = 3;
  private final zzov.zza zzPo;
  private final zzoh zzUL;
  private final zzof zzUM;
  private final String zzUN;
  private final zzji zzUO;
  private final long zzUP;
  private int zzUQ = 0;
  private zzob zzUR;
  private final Object zzrN;
  
  public zzoa(Context paramContext, String paramString1, String paramString2, zzji paramZzji, zzov.zza paramZza, zzoh paramZzoh, zzof paramZzof, long paramLong)
  {
    mContext = paramContext;
    zzKo = paramString1;
    zzUN = paramString2;
    zzUO = paramZzji;
    zzPo = paramZza;
    zzUL = paramZzoh;
    zzrN = new Object();
    zzUM = paramZzof;
    zzUP = paramLong;
  }
  
  private void zza(zzdy paramZzdy, zzjt paramZzjt)
  {
    zzUL.zzjx().zza(this);
    try
    {
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(zzKo))
      {
        paramZzjt.zza(paramZzdy, zzUN, zzUO.zzJG);
        return;
      }
      paramZzjt.zzc(paramZzdy, zzUN);
      return;
    }
    catch (RemoteException paramZzdy)
    {
      zzpe.zzc("Fail to load ad from adapter.", paramZzdy);
      zza(zzKo, 0);
    }
  }
  
  private void zzk(long paramLong)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzUQ != 0)
        {
          zzob.zza localZza = new zzob.zza().zzl(zzv.zzcP().elapsedRealtime() - paramLong);
          if (1 == zzUQ)
          {
            i = 6;
            zzUR = localZza.zzac(i).zzaO(zzKo).zzaP(zzUO.zzJJ).zzjt();
            return;
          }
          int i = zzPF;
          continue;
        }
        if (!zzf(paramLong))
        {
          zzUR = new zzob.zza().zzac(zzPF).zzl(zzv.zzcP().elapsedRealtime() - paramLong).zzaO(zzKo).zzaP(zzUO.zzJJ).zzjt();
          return;
        }
      }
    }
  }
  
  public void onStop() {}
  
  public void zza(String arg1, int paramInt)
  {
    synchronized (zzrN)
    {
      zzUQ = 2;
      zzPF = paramInt;
      zzrN.notify();
      return;
    }
  }
  
  public void zzaN(String arg1)
  {
    synchronized (zzrN)
    {
      zzUQ = 1;
      zzrN.notify();
      return;
    }
  }
  
  public void zzab(int paramInt)
  {
    zza(zzKo, 0);
  }
  
  public void zzcm()
  {
    if ((zzUL == null) || (zzUL.zzjx() == null) || (zzUL.zzjw() == null)) {
      return;
    }
    final zzoe localZzoe = zzUL.zzjx();
    localZzoe.zza(null);
    localZzoe.zza(this);
    final zzdy localZzdy = zzPo.zzSF.zzRd;
    final zzjt localZzjt = zzUL.zzjw();
    try
    {
      if (localZzjt.isInitialized()) {
        zzpx.zzXU.post(new Runnable()
        {
          public void run()
          {
            zzoa.zza(zzoa.this, localZzdy, localZzjt);
          }
        });
      }
      for (;;)
      {
        zzk(zzv.zzcP().elapsedRealtime());
        localZzoe.zza(null);
        localZzoe.zza(null);
        if (zzUQ != 1) {
          break;
        }
        zzUM.zzaN(zzKo);
        return;
        zzpx.zzXU.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localZzjt.zza(com.google.android.gms.dynamic.zze.zzA(zzoa.zza(zzoa.this)), localZzdy, null, localZzoe, zzoa.zzb(zzoa.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              str = String.valueOf(zzoa.zzc(zzoa.this));
              if (str.length() == 0) {}
            }
            for (String str = "Fail to initialize adapter ".concat(str);; str = new String("Fail to initialize adapter "))
            {
              zzpe.zzc(str, localRemoteException);
              zza(zzoa.zzc(zzoa.this), 0);
              return;
            }
          }
        });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzpe.zzc("Fail to check if adapter is initialized.", localRemoteException);
        zza(zzKo, 0);
      }
      zzUM.zza(zzKo, zzPF);
    }
  }
  
  protected boolean zzf(long paramLong)
  {
    paramLong = zzUP - (zzv.zzcP().elapsedRealtime() - paramLong);
    if (paramLong <= 0L)
    {
      zzPF = 4;
      return false;
    }
    try
    {
      zzrN.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      zzPF = 5;
    }
    return false;
  }
  
  public zzob zzjq()
  {
    synchronized (zzrN)
    {
      zzob localZzob = zzUR;
      return localZzob;
    }
  }
  
  public zzji zzjr()
  {
    return zzUO;
  }
  
  public void zzjs()
  {
    zza(zzPo.zzSF.zzRd, zzUL.zzjw());
  }
}
