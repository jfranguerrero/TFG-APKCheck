package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzmb
public class zzjq
  implements zzjh
{
  private final Context mContext;
  private final zzmh zzKG;
  private final long zzKH;
  private final long zzKI;
  private boolean zzKK = false;
  private List<zzjn> zzKM = new ArrayList();
  private zzjm zzKQ;
  private final zzjj zzKq;
  private final boolean zzKs;
  private final Object zzrN = new Object();
  private final zzjs zzsD;
  private final zzgf zzsr;
  private final boolean zzvW;
  
  public zzjq(Context paramContext, zzmh paramZzmh, zzjs paramZzjs, zzjj paramZzjj, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, zzgf paramZzgf)
  {
    mContext = paramContext;
    zzKG = paramZzmh;
    zzsD = paramZzjs;
    zzKq = paramZzjj;
    zzvW = paramBoolean1;
    zzKs = paramBoolean2;
    zzKH = paramLong1;
    zzKI = paramLong2;
    zzsr = paramZzgf;
  }
  
  public void cancel()
  {
    synchronized (zzrN)
    {
      zzKK = true;
      if (zzKQ != null) {
        zzKQ.cancel();
      }
      return;
    }
  }
  
  public zzjn zzd(List<zzji> arg1)
  {
    zzpe.zzbc("Starting mediation.");
    Object localObject = new ArrayList();
    zzgd localZzgd1 = zzsr.zzfw();
    Iterator localIterator1 = ???.iterator();
    label403:
    while (localIterator1.hasNext())
    {
      zzji localZzji = (zzji)localIterator1.next();
      ??? = String.valueOf(zzJH);
      Iterator localIterator2;
      if (???.length() != 0)
      {
        ??? = "Trying mediation network: ".concat(???);
        zzpe.zzbd(???);
        localIterator2 = zzJI.iterator();
      }
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label403;
        }
        String str = (String)localIterator2.next();
        zzgd localZzgd2 = zzsr.zzfw();
        synchronized (zzrN)
        {
          if (zzKK)
          {
            localObject = new zzjn(-1);
            return localObject;
            ??? = new String("Trying mediation network: ");
            break;
          }
          zzKQ = new zzjm(mContext, str, zzsD, zzKq, localZzji, zzKG.zzRd, zzKG.zzvj, zzKG.zzvf, zzvW, zzKs, zzKG.zzvx, zzKG.zzvB);
          ??? = zzKQ.zza(zzKH, zzKI);
          zzKM.add(???);
          if (zzKz == 0)
          {
            zzpe.zzbc("Adapter succeeded.");
            zzsr.zzg("mediation_network_succeed", str);
            if (!((List)localObject).isEmpty()) {
              zzsr.zzg("mediation_networks_fail", TextUtils.join(",", (Iterable)localObject));
            }
            zzsr.zza(localZzgd2, new String[] { "mls" });
            zzsr.zza(localZzgd1, new String[] { "ttm" });
            return ???;
          }
        }
        localIterable.add(str);
        zzsr.zza(localZzgd2, new String[] { "mlf" });
        if (zzKB != null) {
          zzpi.zzWR.post(new Runnable()
          {
            public void run()
            {
              try
              {
                paramListzzKB.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                zzpe.zzc("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    if (!localIterable.isEmpty()) {
      zzsr.zzg("mediation_networks_fail", TextUtils.join(",", localIterable));
    }
    return new zzjn(1);
  }
  
  public List<zzjn> zzgB()
  {
    return zzKM;
  }
}
