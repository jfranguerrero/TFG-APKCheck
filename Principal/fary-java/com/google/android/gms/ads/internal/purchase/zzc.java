package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@zzmb
public class zzc
  extends zzpd
  implements ServiceConnection
{
  private Context mContext;
  private zzld zzIO;
  private boolean zzOQ = false;
  private zzb zzOR;
  private zzh zzOS;
  private List<zzf> zzOT = null;
  private zzk zzOU;
  private final Object zzrN = new Object();
  
  public zzc(Context paramContext, zzld paramZzld, zzk paramZzk)
  {
    this(paramContext, paramZzld, paramZzk, new zzb(paramContext), zzh.zzq(paramContext.getApplicationContext()));
  }
  
  zzc(Context paramContext, zzld paramZzld, zzk paramZzk, zzb paramZzb, zzh paramZzh)
  {
    mContext = paramContext;
    zzIO = paramZzld;
    zzOU = paramZzk;
    zzOR = paramZzb;
    zzOS = paramZzh;
    zzOT = zzOS.zzg(10L);
  }
  
  private void zze(long paramLong)
  {
    do
    {
      if (!zzf(paramLong)) {
        zzpe.v("Timeout waiting for pending transaction to be processed.");
      }
    } while (!zzOQ);
  }
  
  private boolean zzf(long paramLong)
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      zzrN.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        zzpe.zzbe("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (zzrN)
    {
      zzOR.zzV(paramIBinder);
      zzio();
      zzOQ = true;
      zzrN.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzpe.zzbd("In-app billing service disconnected.");
    zzOR.destroy();
  }
  
  public void onStop()
  {
    synchronized (zzrN)
    {
      zza.zzyc().zza(mContext, this);
      zzOR.destroy();
      return;
    }
  }
  
  protected void zza(final zzf paramZzf, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    zzv.zzcX();
    localIntent.putExtra("RESPONSE_CODE", 0);
    zzv.zzcX();
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    zzv.zzcX();
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzc.zza(zzc.this).zza(paramZzfzzPf, -1, localIntent))
          {
            zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramZzfzzPg, true, -1, localIntent, paramZzf));
            return;
          }
          zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramZzfzzPg, false, -1, localIntent, paramZzf));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzpe.zzbe("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  public void zzcm()
  {
    synchronized (zzrN)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      zza.zzyc().zza(mContext, localIntent, this, 1);
      zze(SystemClock.elapsedRealtime());
      zza.zzyc().zza(mContext, this);
      zzOR.destroy();
      return;
    }
  }
  
  protected void zzio()
  {
    if (zzOT.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = zzOT.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzf)((Iterator)localObject1).next();
      localHashMap.put(zzPg, localObject2);
    }
    localObject1 = null;
    for (;;)
    {
      localObject1 = zzOR.zzm(mContext.getPackageName(), (String)localObject1);
      if (localObject1 == null) {}
      do
      {
        do
        {
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            zzOS.zza((zzf)localHashMap.get(localObject2));
          }
          break;
        } while (zzv.zzcX().zzd((Bundle)localObject1) != 0);
        localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
        int i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          if (localHashMap.containsKey(((ArrayList)localObject2).get(i)))
          {
            String str1 = (String)((ArrayList)localObject2).get(i);
            String str2 = (String)localArrayList1.get(i);
            String str3 = (String)localArrayList2.get(i);
            zzf localZzf = (zzf)localHashMap.get(str1);
            String str4 = zzv.zzcX().zzaD(str2);
            if (zzPf.equals(str4))
            {
              zza(localZzf, str2, str3);
              localHashMap.remove(str1);
            }
          }
          i += 1;
        }
      } while ((localObject1 == null) || (localHashMap.isEmpty()));
    }
  }
}
