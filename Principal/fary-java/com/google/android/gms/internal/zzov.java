package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzmb
public class zzov
{
  public final int errorCode;
  public final int orientation;
  public final List<String> zzJY;
  public final List<String> zzJZ;
  @Nullable
  public final zzji zzKA;
  @Nullable
  public final zzjt zzKB;
  @Nullable
  public final String zzKC;
  @Nullable
  public final zzjl zzKD;
  @Nullable
  public final List<String> zzKb;
  public final long zzKe;
  @Nullable
  public final zzqp zzMZ;
  public final long zzRJ;
  public final boolean zzRK;
  public final long zzRL;
  public final List<String> zzRM;
  public final String zzRP;
  @Nullable
  public final zzok zzRZ;
  public final zzdy zzRd;
  public final String zzRg;
  @Nullable
  public final List<String> zzSb;
  public final boolean zzSc;
  public final zzmm zzSd;
  public final String zzSg;
  public boolean zzVA = false;
  public final JSONObject zzVp;
  public boolean zzVq;
  public final zzjj zzVr;
  @Nullable
  public final String zzVs;
  public final zzec zzVt;
  @Nullable
  public final List<String> zzVu;
  public final long zzVv;
  public final long zzVw;
  @Nullable
  public final zzgu.zza zzVx;
  public boolean zzVy = false;
  public boolean zzVz = false;
  
  public zzov(zzdy paramZzdy, @Nullable zzqp paramZzqp, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean1, @Nullable zzji paramZzji, @Nullable zzjt paramZzjt, @Nullable String paramString2, zzjj paramZzjj, @Nullable zzjl paramZzjl, long paramLong2, zzec paramZzec, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, @Nullable zzgu.zza paramZza, zzok paramZzok, List<String> paramList4, List<String> paramList5, boolean paramBoolean2, zzmm paramZzmm, @Nullable String paramString4, List<String> paramList6, String paramString5)
  {
    zzRd = paramZzdy;
    zzMZ = paramZzqp;
    zzJY = zzm(paramList1);
    errorCode = paramInt1;
    zzJZ = zzm(paramList2);
    zzRM = zzm(paramList3);
    orientation = paramInt2;
    zzKe = paramLong1;
    zzRg = paramString1;
    zzRK = paramBoolean1;
    zzKA = paramZzji;
    zzKB = paramZzjt;
    zzKC = paramString2;
    zzVr = paramZzjj;
    zzKD = paramZzjl;
    zzRL = paramLong2;
    zzVt = paramZzec;
    zzRJ = paramLong3;
    zzVv = paramLong4;
    zzVw = paramLong5;
    zzRP = paramString3;
    zzVp = paramJSONObject;
    zzVx = paramZza;
    zzRZ = paramZzok;
    zzVu = zzm(paramList4);
    zzSb = zzm(paramList5);
    zzSc = paramBoolean2;
    zzSd = paramZzmm;
    zzVs = paramString4;
    zzKb = zzm(paramList6);
    zzSg = paramString5;
  }
  
  public zzov(zza paramZza, @Nullable zzqp paramZzqp, @Nullable zzji paramZzji, @Nullable zzjt paramZzjt, @Nullable String paramString1, @Nullable zzjl paramZzjl, @Nullable zzgu.zza paramZza1, @Nullable String paramString2)
  {
    this(zzSF.zzRd, paramZzqp, zzVB.zzJY, errorCode, zzVB.zzJZ, zzVB.zzRM, zzVB.orientation, zzVB.zzKe, zzSF.zzRg, zzVB.zzRK, paramZzji, paramZzjt, paramString1, zzVr, paramZzjl, zzVB.zzRL, zzvj, zzVB.zzRJ, zzVv, zzVw, zzVB.zzRP, zzVp, paramZza1, zzVB.zzRZ, zzVB.zzSa, zzVB.zzSa, zzVB.zzSc, zzVB.zzSd, paramString2, zzVB.zzKb, zzVB.zzSg);
  }
  
  @Nullable
  private static <T> List<T> zzm(@Nullable List<T> paramList)
  {
    if (paramList == null) {
      return null;
    }
    return Collections.unmodifiableList(paramList);
  }
  
  public boolean zzdz()
  {
    if ((zzMZ == null) || (zzMZ.zzkV() == null)) {
      return false;
    }
    return zzMZ.zzkV().zzdz();
  }
  
  @zzmb
  public static final class zza
  {
    public final int errorCode;
    public final zzmh zzSF;
    public final zzmk zzVB;
    @Nullable
    public final JSONObject zzVp;
    public final zzjj zzVr;
    public final long zzVv;
    public final long zzVw;
    @Nullable
    public final zzec zzvj;
    
    public zza(zzmh paramZzmh, zzmk paramZzmk, zzjj paramZzjj, zzec paramZzec, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
    {
      zzSF = paramZzmh;
      zzVB = paramZzmk;
      zzVr = paramZzjj;
      zzvj = paramZzec;
      errorCode = paramInt;
      zzVv = paramLong1;
      zzVw = paramLong2;
      zzVp = paramJSONObject;
    }
  }
}
