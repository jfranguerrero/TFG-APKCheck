package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
public class zzkn
  extends zzko
  implements zzhx
{
  private final Context mContext;
  private final zzqp zzGt;
  private final zzfp zzLO;
  private float zzLP;
  int zzLQ = -1;
  int zzLR = -1;
  private int zzLS;
  int zzLT = -1;
  int zzLU = -1;
  int zzLV = -1;
  int zzLW = -1;
  DisplayMetrics zzwO;
  private final WindowManager zzwf;
  
  public zzkn(zzqp paramZzqp, Context paramContext, zzfp paramZzfp)
  {
    super(paramZzqp);
    zzGt = paramZzqp;
    mContext = paramContext;
    zzLO = paramZzfp;
    zzwf = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  private void zzgU()
  {
    zzwO = new DisplayMetrics();
    Display localDisplay = zzwf.getDefaultDisplay();
    localDisplay.getMetrics(zzwO);
    zzLP = zzwO.density;
    zzLS = localDisplay.getRotation();
  }
  
  private void zzgZ()
  {
    int[] arrayOfInt = new int[2];
    zzGt.getLocationOnScreen(arrayOfInt);
    zze(zzeh.zzeO().zzc(mContext, arrayOfInt[0]), zzeh.zzeO().zzc(mContext, arrayOfInt[1]));
  }
  
  private zzkm zzhc()
  {
    return new zzkm.zza().zzu(zzLO.zzfg()).zzt(zzLO.zzfh()).zzv(zzLO.zzfk()).zzw(zzLO.zzfi()).zzx(true).zzgT();
  }
  
  public void zza(zzqp paramZzqp, Map<String, String> paramMap)
  {
    zzgX();
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    if ((mContext instanceof Activity)) {}
    for (int i = zzv.zzcJ().zzk((Activity)mContext)[0];; i = 0)
    {
      if ((zzGt.zzbD() == null) || (!zzGt.zzbD().zzzl))
      {
        zzLV = zzeh.zzeO().zzc(mContext, zzGt.getMeasuredWidth());
        zzLW = zzeh.zzeO().zzc(mContext, zzGt.getMeasuredHeight());
      }
      zzc(paramInt1, paramInt2 - i, zzLV, zzLW);
      zzGt.zzkV().zzd(paramInt1, paramInt2);
      return;
    }
  }
  
  void zzgV()
  {
    zzLQ = zzeh.zzeO().zzb(zzwO, zzwO.widthPixels);
    zzLR = zzeh.zzeO().zzb(zzwO, zzwO.heightPixels);
    Object localObject = zzGt.zzkR();
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      zzLT = zzLQ;
      zzLU = zzLR;
      return;
    }
    localObject = zzv.zzcJ().zzh((Activity)localObject);
    zzLT = zzeh.zzeO().zzb(zzwO, localObject[0]);
    zzLU = zzeh.zzeO().zzb(zzwO, localObject[1]);
  }
  
  void zzgW()
  {
    if (zzGt.zzbD().zzzl)
    {
      zzLV = zzLQ;
      zzLW = zzLR;
      return;
    }
    zzGt.measure(0, 0);
  }
  
  public void zzgX()
  {
    zzgU();
    zzgV();
    zzgW();
    zzha();
    zzhb();
    zzgZ();
    zzgY();
  }
  
  void zzgY()
  {
    if (zzpe.zzai(2)) {
      zzpe.zzbd("Dispatching Ready Event.");
    }
    zzaz(zzGt.zzkY().zzaZ);
  }
  
  void zzha()
  {
    zza(zzLQ, zzLR, zzLT, zzLU, zzLP, zzLS);
  }
  
  void zzhb()
  {
    zzkm localZzkm = zzhc();
    zzGt.zzb("onDeviceFeaturesReceived", localZzkm.toJson());
  }
}
