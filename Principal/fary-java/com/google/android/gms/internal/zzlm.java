package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;

@zzmb
public abstract class zzlm
  extends zzpd
{
  protected final Context mContext;
  protected final zzln.zza zzPn;
  protected final zzov.zza zzPo;
  protected zzmk zzPp;
  protected final Object zzPr = new Object();
  protected final Object zzrN = new Object();
  
  protected zzlm(Context paramContext, zzov.zza paramZza, zzln.zza paramZza1)
  {
    super(true);
    mContext = paramContext;
    zzPo = paramZza;
    zzPp = zzVB;
    zzPn = paramZza1;
  }
  
  public void onStop() {}
  
  protected abstract zzov zzP(int paramInt);
  
  public void zzcm()
  {
    for (;;)
    {
      int i;
      synchronized (zzrN)
      {
        zzpe.zzbc("AdRendererBackgroundTask started.");
        i = zzPo.errorCode;
        try
        {
          zzh(SystemClock.elapsedRealtime());
          final zzov localZzov = zzP(i);
          zzpi.zzWR.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzrN)
              {
                zzn(localZzov);
                return;
              }
            }
          });
          return;
        }
        catch (zza localZza)
        {
          i = localZza.getErrorCode();
          if (i == 3) {
            continue;
          }
        }
        if (i == -1)
        {
          zzpe.zzbd(localZza.getMessage());
          if (zzPp == null)
          {
            zzPp = new zzmk(i);
            zzpi.zzWR.post(new Runnable()
            {
              public void run()
              {
                onStop();
              }
            });
          }
        }
        else
        {
          zzpe.zzbe(localZza.getMessage());
        }
      }
      zzPp = new zzmk(i, zzPp.zzKe);
    }
  }
  
  protected abstract void zzh(long paramLong)
    throws zzlm.zza;
  
  protected void zzn(zzov paramZzov)
  {
    zzPn.zzb(paramZzov);
  }
  
  protected static final class zza
    extends Exception
  {
    private final int zzPF;
    
    public zza(String paramString, int paramInt)
    {
      super();
      zzPF = paramInt;
    }
    
    public int getErrorCode()
    {
      return zzPF;
    }
  }
}
