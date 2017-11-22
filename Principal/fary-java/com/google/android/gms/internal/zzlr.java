package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.zzo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzmb
public class zzlr
  extends zzlm
{
  private final zzqp zzGt;
  private zzjj zzKq;
  zzjh zzPL;
  protected zzjn zzPM;
  private boolean zzPN;
  private zzjs zzsD;
  private final zzgf zzsr;
  
  zzlr(Context paramContext, zzov.zza paramZza, zzjs paramZzjs, zzln.zza paramZza1, zzgf paramZzgf, zzqp paramZzqp)
  {
    super(paramContext, paramZza, paramZza1);
    zzsD = paramZzjs;
    zzKq = zzVr;
    zzsr = paramZzgf;
    zzGt = paramZzqp;
  }
  
  private static int zzR(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 6;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    case -1: 
      return 4;
    }
    return 5;
  }
  
  private static String zza(zzjn paramZzjn)
  {
    String str = zzKA.zzJJ;
    int i = zzR(zzKz);
    long l = zzKF;
    return String.valueOf(str).length() + 33 + str + "." + i + "." + l;
  }
  
  private static String zzg(List<zzjn> paramList)
  {
    if (paramList == null) {
      return "".toString();
    }
    Iterator localIterator = paramList.iterator();
    label20:
    Object localObject;
    for (paramList = ""; localIterator.hasNext(); paramList = String.valueOf(paramList).length() + 1 + String.valueOf(localObject).length() + paramList + (String)localObject + "_")
    {
      localObject = (zzjn)localIterator.next();
      if ((localObject == null) || (zzKA == null) || (TextUtils.isEmpty(zzKA.zzJJ))) {
        break label20;
      }
      paramList = String.valueOf(paramList);
      localObject = String.valueOf(zza((zzjn)localObject));
    }
    return paramList.substring(0, Math.max(0, paramList.length() - 1));
  }
  
  private void zziD()
    throws zzlm.zza
  {
    ??? = new CountDownLatch(1);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        synchronized (zzPr)
        {
          zzlr.zza(zzlr.this, zzo.zza(zzlr.zza(zzlr.this), zzPM, zzsA));
          return;
        }
      }
    });
    String str;
    try
    {
      ((CountDownLatch)???).await(10L, TimeUnit.SECONDS);
      synchronized (zzPr)
      {
        if (!zzPN) {
          throw new zzlm.zza("View could not be prepared", 0);
        }
      }
      if (!zzGt.isDestroyed()) {
        break label133;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      str = String.valueOf(localInterruptedException);
      throw new zzlm.zza(String.valueOf(str).length() + 38 + "Interrupted while waiting for latch : " + str, 0);
    }
    throw new zzlm.zza("Assets not loaded, web view is destroyed", 0);
    label133:
  }
  
  public void onStop()
  {
    synchronized (zzPr)
    {
      super.onStop();
      if (zzPL != null) {
        zzPL.cancel();
      }
      return;
    }
  }
  
  protected zzov zzP(int paramInt)
  {
    Object localObject = zzPo.zzSF;
    zzdy localZzdy = zzRd;
    zzqp localZzqp = zzGt;
    List localList1 = zzPp.zzJY;
    List localList2 = zzPp.zzJZ;
    List localList3 = zzPp.zzRM;
    int i = zzPp.orientation;
    long l1 = zzPp.zzKe;
    String str3 = zzRg;
    boolean bool2 = zzPp.zzRK;
    zzjt localZzjt;
    label113:
    String str1;
    label129:
    zzjj localZzjj;
    zzjl localZzjl;
    label151:
    long l2;
    zzec localZzec;
    long l3;
    long l4;
    long l5;
    String str4;
    JSONObject localJSONObject;
    zzok localZzok;
    List localList4;
    List localList5;
    boolean bool1;
    label257:
    zzmm localZzmm;
    if (zzPM != null)
    {
      localObject = zzPM.zzKA;
      if (zzPM == null) {
        break label369;
      }
      localZzjt = zzPM.zzKB;
      if (zzPM == null) {
        break label375;
      }
      str1 = zzPM.zzKC;
      localZzjj = zzKq;
      if (zzPM == null) {
        break label386;
      }
      localZzjl = zzPM.zzKD;
      l2 = zzPp.zzRL;
      localZzec = zzPo.zzvj;
      l3 = zzPp.zzRJ;
      l4 = zzPo.zzVv;
      l5 = zzPp.zzRO;
      str4 = zzPp.zzRP;
      localJSONObject = zzPo.zzVp;
      localZzok = zzPp.zzRZ;
      localList4 = zzPp.zzSa;
      localList5 = zzPp.zzSb;
      if (zzKq == null) {
        break label392;
      }
      bool1 = zzKq.zzKj;
      localZzmm = zzPp.zzSd;
      if (zzPL == null) {
        break label398;
      }
    }
    label369:
    label375:
    label386:
    label392:
    label398:
    for (String str2 = zzg(zzPL.zzgB());; str2 = null)
    {
      return new zzov(localZzdy, localZzqp, localList1, paramInt, localList2, localList3, i, l1, str3, bool2, (zzji)localObject, localZzjt, str1, localZzjj, localZzjl, l2, localZzec, l3, l4, l5, str4, localJSONObject, null, localZzok, localList4, localList5, bool1, localZzmm, str2, zzPp.zzKb, zzPp.zzSg);
      localObject = null;
      break;
      localZzjt = null;
      break label113;
      str1 = AdMobAdapter.class.getName();
      break label129;
      localZzjl = null;
      break label151;
      bool1 = false;
      break label257;
    }
  }
  
  protected void zzh(long paramLong)
    throws zzlm.zza
  {
    for (;;)
    {
      synchronized (zzPr)
      {
        zzPL = zzi(paramLong);
        ??? = new ArrayList(zzKq.zzJW);
        Object localObject2 = zzPo.zzSF.zzRd.zzyP;
        if (localObject2 == null) {
          break label271;
        }
        localObject2 = ((Bundle)localObject2).getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (localObject2 == null) {
          break label271;
        }
        bool = ((Bundle)localObject2).getBoolean("_skipMediation");
        if (bool)
        {
          localObject2 = ((List)???).listIterator();
          if (((ListIterator)localObject2).hasNext())
          {
            if (nextzzJI.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
              continue;
            }
            ((ListIterator)localObject2).remove();
          }
        }
      }
      zzPM = zzPL.zzd((List)???);
      switch (zzPM.zzKz)
      {
      default: 
        int i = zzPM.zzKz;
        throw new zzlm.zza(40 + "Unexpected mediation result: " + i, 0);
      case 1: 
        throw new zzlm.zza("No fill from any mediation ad networks.", 3);
      }
      if ((zzPM.zzKA != null) && (zzPM.zzKA.zzJR != null)) {
        zziD();
      }
      return;
      label271:
      boolean bool = false;
    }
  }
  
  zzjh zzi(long paramLong)
  {
    if (zzKq.zzKh != -1) {
      return new zzjp(mContext, zzPo.zzSF, zzsD, zzKq, zzPp.zzzn, zzPp.zzzp, paramLong, ((Long)zzfx.zzDe.get()).longValue(), 2);
    }
    return new zzjq(mContext, zzPo.zzSF, zzsD, zzKq, zzPp.zzzn, zzPp.zzzp, paramLong, ((Long)zzfx.zzDe.get()).longValue(), zzsr);
  }
}
