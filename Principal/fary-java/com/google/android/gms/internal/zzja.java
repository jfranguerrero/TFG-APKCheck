package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.Map;

@zzmb
public class zzja
{
  private final Context mContext;
  private final String zzJd;
  private zzpn<zzix> zzJe;
  private zzpn<zzix> zzJf;
  @Nullable
  private zzd zzJg;
  private int zzJh = 1;
  private final Object zzrN = new Object();
  private final zzqa zztr;
  
  public zzja(Context paramContext, zzqa paramZzqa, String paramString)
  {
    zzJd = paramString;
    mContext = paramContext.getApplicationContext();
    zztr = paramZzqa;
    zzJe = new zzb();
    zzJf = new zzb();
  }
  
  public zzja(Context paramContext, zzqa paramZzqa, String paramString, zzpn<zzix> paramZzpn1, zzpn<zzix> paramZzpn2)
  {
    this(paramContext, paramZzqa, paramString);
    zzJe = paramZzpn1;
    zzJf = paramZzpn2;
  }
  
  private zzd zza(@Nullable final zzav paramZzav)
  {
    final zzd localZzd = new zzd(zzJf);
    zzv.zzcJ().runOnUiThread(new Runnable()
    {
      public void run()
      {
        final zzix localZzix = zza(zzja.zza(zzja.this), zzja.zzb(zzja.this), paramZzav);
        localZzix.zza(new zzix.zza()
        {
          public void zzgu()
          {
            zzpi.zzWR.postDelayed(new Runnable()
            {
              public void run()
              {
                synchronized (zzja.zzc(zzja.this))
                {
                  if ((zzJj.getStatus() == -1) || (zzJj.getStatus() == 1)) {
                    return;
                  }
                  zzJj.reject();
                  zzv.zzcJ().runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      zzJl.destroy();
                    }
                  });
                  zzpe.v("Could not receive loaded message in a timely manner. Rejecting.");
                  return;
                }
              }
            }, zzja.zza.zzJt);
          }
        });
        localZzix.zza("/jsLoaded", new zzhx()
        {
          public void zza(zzqp arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzja.zzc(zzja.this))
            {
              if ((zzJj.getStatus() == -1) || (zzJj.getStatus() == 1)) {
                return;
              }
              zzja.zza(zzja.this, 0);
              zzja.zzd(zzja.this).zzd(localZzix);
              zzJj.zzg(localZzix);
              zzja.zza(zzja.this, zzJj);
              zzpe.v("Successfully loaded JS Engine.");
              return;
            }
          }
        });
        final zzpu localZzpu = new zzpu();
        zzhx local3 = new zzhx()
        {
          public void zza(zzqp arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzja.zzc(zzja.this))
            {
              zzpe.zzbd("JS Engine is requesting an update");
              if (zzja.zze(zzja.this) == 0)
              {
                zzpe.zzbd("Starting reload.");
                zzja.zza(zzja.this, 2);
                zzb(zzJi);
              }
              localZzix.zzb("/requestReload", (zzhx)localZzpu.get());
              return;
            }
          }
        };
        localZzpu.set(local3);
        localZzix.zza("/requestReload", local3);
        if (zzja.zzf(zzja.this).endsWith(".js")) {
          localZzix.zzal(zzja.zzf(zzja.this));
        }
        for (;;)
        {
          zzpi.zzWR.postDelayed(new Runnable()
          {
            public void run()
            {
              synchronized (zzja.zzc(zzja.this))
              {
                if ((zzJj.getStatus() == -1) || (zzJj.getStatus() == 1)) {
                  return;
                }
                zzJj.reject();
                zzv.zzcJ().runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    zzJl.destroy();
                  }
                });
                zzpe.v("Could not receive loaded message in a timely manner. Rejecting.");
                return;
              }
            }
          }, zzja.zza.zzJs);
          return;
          if (zzja.zzf(zzja.this).startsWith("<html>")) {
            localZzix.zzan(zzja.zzf(zzja.this));
          } else {
            localZzix.zzam(zzja.zzf(zzja.this));
          }
        }
      }
    });
    return localZzd;
  }
  
  protected zzix zza(Context paramContext, zzqa paramZzqa, @Nullable zzav paramZzav)
  {
    return new zziz(paramContext, paramZzqa, paramZzav, null);
  }
  
  protected zzd zzb(@Nullable final zzav paramZzav)
  {
    paramZzav = zza(paramZzav);
    paramZzav.zza(new zzqi.zzc()new zzqi.zza
    {
      public void zza(zzix arg1)
      {
        synchronized (zzja.zzc(zzja.this))
        {
          zzja.zza(zzja.this, 0);
          if ((zzja.zzg(zzja.this) != null) && (paramZzav != zzja.zzg(zzja.this)))
          {
            zzpe.v("New JS engine is loaded, marking previous one as destroyable.");
            zzja.zzg(zzja.this).zzgy();
          }
          zzja.zza(zzja.this, paramZzav);
          return;
        }
      }
    }, new zzqi.zza()
    {
      public void run()
      {
        synchronized (zzja.zzc(zzja.this))
        {
          zzja.zza(zzja.this, 1);
          zzpe.v("Failed loading new engine. Marking new engine destroyable.");
          paramZzav.zzgy();
          return;
        }
      }
    });
    return paramZzav;
  }
  
  public zzc zzc(@Nullable zzav paramZzav)
  {
    synchronized (zzrN)
    {
      if ((zzJg == null) || (zzJg.getStatus() == -1))
      {
        zzJh = 2;
        zzJg = zzb(paramZzav);
        paramZzav = zzJg.zzgw();
        return paramZzav;
      }
      if (zzJh == 0)
      {
        paramZzav = zzJg.zzgw();
        return paramZzav;
      }
    }
    if (zzJh == 1)
    {
      zzJh = 2;
      zzb(paramZzav);
      paramZzav = zzJg.zzgw();
      return paramZzav;
    }
    if (zzJh == 2)
    {
      paramZzav = zzJg.zzgw();
      return paramZzav;
    }
    paramZzav = zzJg.zzgw();
    return paramZzav;
  }
  
  public zzc zzgv()
  {
    return zzc(null);
  }
  
  static class zza
  {
    static int zzJs = 60000;
    static int zzJt = 10000;
  }
  
  public static class zzb<T>
    implements zzpn<T>
  {
    public zzb() {}
    
    public void zzd(T paramT) {}
  }
  
  public static class zzc
    extends zzqj<zzjb>
  {
    private final zzja.zzd zzJu;
    private boolean zzJv;
    private final Object zzrN = new Object();
    
    public zzc(zzja.zzd paramZzd)
    {
      zzJu = paramZzd;
    }
    
    public void release()
    {
      synchronized (zzrN)
      {
        if (zzJv) {
          return;
        }
        zzJv = true;
        zza(new zzqi.zzc()new zzqi.zzb
        {
          public void zzb(zzjb paramAnonymousZzjb)
          {
            zzpe.v("Ending javascript session.");
            ((zzjc)paramAnonymousZzjb).zzgA();
          }
        }, new zzqi.zzb());
        zza(new zzqi.zzc()new zzqi.zza
        {
          public void zzb(zzjb paramAnonymousZzjb)
          {
            zzpe.v("Releasing engine reference.");
            zzja.zzc.zza(zzja.zzc.this).zzgx();
          }
        }, new zzqi.zza()
        {
          public void run()
          {
            zzja.zzc.zza(zzja.zzc.this).zzgx();
          }
        });
        return;
      }
    }
  }
  
  public static class zzd
    extends zzqj<zzix>
  {
    private zzpn<zzix> zzJf;
    private boolean zzJx;
    private int zzJy;
    private final Object zzrN = new Object();
    
    public zzd(zzpn<zzix> paramZzpn)
    {
      zzJf = paramZzpn;
      zzJx = false;
      zzJy = 0;
    }
    
    public zzja.zzc zzgw()
    {
      final zzja.zzc localZzc = new zzja.zzc(this);
      for (;;)
      {
        synchronized (zzrN)
        {
          zza(new zzqi.zzc()new zzqi.zza
          {
            public void zza(zzix paramAnonymousZzix)
            {
              zzpe.v("Getting a new session for JS Engine.");
              localZzc.zzg(paramAnonymousZzix.zzgt());
            }
          }, new zzqi.zza()
          {
            public void run()
            {
              zzpe.v("Rejecting reference for JS Engine.");
              localZzc.reject();
            }
          });
          if (zzJy >= 0)
          {
            bool = true;
            zzac.zzar(bool);
            zzJy += 1;
            return localZzc;
          }
        }
        boolean bool = false;
      }
    }
    
    protected void zzgx()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (zzrN)
        {
          if (zzJy >= 1)
          {
            zzac.zzar(bool);
            zzpe.v("Releasing 1 reference for JS Engine");
            zzJy -= 1;
            zzgz();
            return;
          }
        }
      }
    }
    
    public void zzgy()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (zzrN)
        {
          if (zzJy >= 0)
          {
            zzac.zzar(bool);
            zzpe.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            zzJx = true;
            zzgz();
            return;
          }
        }
      }
    }
    
    protected void zzgz()
    {
      for (;;)
      {
        synchronized (zzrN)
        {
          if (zzJy >= 0)
          {
            bool = true;
            zzac.zzar(bool);
            if ((zzJx) && (zzJy == 0))
            {
              zzpe.v("No reference is left (including root). Cleaning up engine.");
              zza(new zzqi.zzc()new zzqi.zzb
              {
                public void zza(final zzix paramAnonymousZzix)
                {
                  zzv.zzcJ().runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      zzja.zzd.zza(zzja.zzd.this).zzd(paramAnonymousZzix);
                      paramAnonymousZzix.destroy();
                    }
                  });
                }
              }, new zzqi.zzb());
              return;
            }
            zzpe.v("There are still references to the engine. Not destroying.");
          }
        }
        boolean bool = false;
      }
    }
  }
  
  public static class zze
    extends zzqj<zzjb>
  {
    private zzja.zzc zzJD;
    
    public zze(zzja.zzc paramZzc)
    {
      zzJD = paramZzc;
    }
    
    public void finalize()
    {
      zzJD.release();
      zzJD = null;
    }
    
    public int getStatus()
    {
      return zzJD.getStatus();
    }
    
    public void reject()
    {
      zzJD.reject();
    }
    
    public void zza(zzqi.zzc<zzjb> paramZzc, zzqi.zza paramZza)
    {
      zzJD.zza(paramZzc, paramZza);
    }
    
    public void zzf(zzjb paramZzjb)
    {
      zzJD.zzg(paramZzjb);
    }
  }
}
