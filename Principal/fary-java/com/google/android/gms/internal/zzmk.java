package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

@zzmb
public final class zzmk
  extends zza
{
  public static final Parcelable.Creator<zzmk> CREATOR = new zzml();
  public String body;
  public final int errorCode;
  public final int orientation;
  public final int versionCode;
  public final List<String> zzJY;
  public final List<String> zzJZ;
  private zzmh zzKG;
  public final List<String> zzKb;
  public final boolean zzKc;
  public final long zzKe;
  public final String zzNb;
  public final boolean zzRB;
  @Nullable
  public String zzRC;
  public final long zzRJ;
  public final boolean zzRK;
  public final long zzRL;
  public final List<String> zzRM;
  public final String zzRN;
  public final long zzRO;
  public final String zzRP;
  public final boolean zzRQ;
  public final String zzRR;
  public final String zzRS;
  public final boolean zzRT;
  public final boolean zzRU;
  public final boolean zzRV;
  public zzms zzRW;
  public String zzRX;
  public final String zzRY;
  @Nullable
  public final zzok zzRZ;
  public final boolean zzRl;
  @Nullable
  public final List<String> zzSa;
  @Nullable
  public final List<String> zzSb;
  public final boolean zzSc;
  @Nullable
  public final zzmm zzSd;
  @Nullable
  public final String zzSe;
  @Nullable
  public final zzon zzSf;
  @Nullable
  public final String zzSg;
  public final boolean zzSh;
  public final boolean zzzn;
  public final boolean zzzo;
  public final boolean zzzp;
  
  public zzmk(int paramInt)
  {
    this(18, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true);
  }
  
  public zzmk(int paramInt, long paramLong)
  {
    this(18, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true);
  }
  
  zzmk(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, zzms paramZzms, String paramString7, String paramString8, boolean paramBoolean8, boolean paramBoolean9, zzok paramZzok, List<String> paramList4, List<String> paramList5, boolean paramBoolean10, zzmm paramZzmm, boolean paramBoolean11, String paramString9, List<String> paramList6, boolean paramBoolean12, String paramString10, zzon paramZzon, String paramString11, boolean paramBoolean13)
  {
    versionCode = paramInt1;
    zzNb = paramString1;
    body = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      zzJY = paramString1;
      errorCode = paramInt2;
      if (paramList2 == null) {
        break label333;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      zzJZ = paramString1;
      zzRJ = paramLong1;
      zzRK = paramBoolean1;
      zzRL = paramLong2;
      if (paramList3 == null) {
        break label338;
      }
    }
    label333:
    label338:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      zzRM = paramString1;
      zzKe = paramLong3;
      orientation = paramInt3;
      zzRN = paramString3;
      zzRO = paramLong4;
      zzRP = paramString4;
      zzRQ = paramBoolean2;
      zzRR = paramString5;
      zzRS = paramString6;
      zzRT = paramBoolean3;
      zzzn = paramBoolean4;
      zzRl = paramBoolean5;
      zzRU = paramBoolean6;
      zzSh = paramBoolean13;
      zzRV = paramBoolean7;
      zzRW = paramZzms;
      zzRX = paramString7;
      zzRY = paramString8;
      if ((body == null) && (zzRW != null))
      {
        paramString1 = (zzmv)zzRW.zza(zzmv.CREATOR);
        if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.zzje()))) {
          body = paramString1.zzje();
        }
      }
      zzzo = paramBoolean8;
      zzzp = paramBoolean9;
      zzRZ = paramZzok;
      zzSa = paramList4;
      zzSb = paramList5;
      zzSc = paramBoolean10;
      zzSd = paramZzmm;
      zzRB = paramBoolean11;
      zzRC = paramString9;
      zzKb = paramList6;
      zzKc = paramBoolean12;
      zzSe = paramString10;
      zzSf = paramZzon;
      zzSg = paramString11;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public zzmk(zzmh paramZzmh, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString6, boolean paramBoolean7, boolean paramBoolean8, zzok paramZzok, List<String> paramList4, List<String> paramList5, boolean paramBoolean9, zzmm paramZzmm, boolean paramBoolean10, String paramString7, List<String> paramList6, boolean paramBoolean11, String paramString8, zzon paramZzon, String paramString9, boolean paramBoolean12)
  {
    this(18, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, null, null, paramString6, paramBoolean7, paramBoolean8, paramZzok, paramList4, paramList5, paramBoolean9, paramZzmm, paramBoolean10, paramString7, paramList6, paramBoolean11, paramString8, paramZzon, paramString9, paramBoolean12);
    zzKG = paramZzmh;
  }
  
  public zzmk(zzmh paramZzmh, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString7, boolean paramBoolean8, boolean paramBoolean9, zzok paramZzok, List<String> paramList4, List<String> paramList5, boolean paramBoolean10, zzmm paramZzmm, boolean paramBoolean11, String paramString8, List<String> paramList6, boolean paramBoolean12, String paramString9, zzon paramZzon, String paramString10, boolean paramBoolean13)
  {
    this(18, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, null, null, paramString7, paramBoolean8, paramBoolean9, paramZzok, paramList4, paramList5, paramBoolean10, paramZzmm, paramBoolean11, paramString8, paramList6, paramBoolean12, paramString9, paramZzon, paramString10, paramBoolean13);
    zzKG = paramZzmh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((zzKG != null) && (zzKG.versionCode >= 9) && (!TextUtils.isEmpty(body)))
    {
      zzRW = new zzms(new zzmv(body));
      body = null;
    }
    zzml.zza(this, paramParcel, paramInt);
  }
}
