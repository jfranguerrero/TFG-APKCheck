package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

@zzmb
public final class zzmh
  extends zza
{
  public static final Parcelable.Creator<zzmh> CREATOR = new zzmi();
  public final ApplicationInfo applicationInfo;
  public final int versionCode;
  public final boolean zzKc;
  public final boolean zzRA;
  public final boolean zzRB;
  public final String zzRC;
  public final boolean zzRD;
  public final String zzRE;
  public final int zzRF;
  public final Bundle zzRG;
  public final String zzRH;
  @Nullable
  public final Bundle zzRc;
  public final zzdy zzRd;
  @Nullable
  public final PackageInfo zzRe;
  public final String zzRf;
  public final String zzRg;
  public final String zzRh;
  public final Bundle zzRi;
  public final int zzRj;
  public final Bundle zzRk;
  public final boolean zzRl;
  public final Messenger zzRm;
  public final int zzRn;
  public final int zzRo;
  public final String zzRp;
  public final long zzRq;
  public final String zzRr;
  @Nullable
  public final List<String> zzRs;
  public final List<String> zzRt;
  public final long zzRu;
  public final zzmo zzRv;
  public final String zzRw;
  public final float zzRx;
  public final int zzRy;
  public final int zzRz;
  public final List<String> zzvB;
  public final String zzvc;
  public final String zzvd;
  public final zzqa zzvf;
  public final zzec zzvj;
  public final zzgw zzvx;
  public final float zzxa;
  
  zzmh(int paramInt1, Bundle paramBundle1, zzdy paramZzdy, zzec paramZzec, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, zzqa paramZzqa, Bundle paramBundle2, int paramInt2, List<String> paramList1, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt3, int paramInt4, float paramFloat1, String paramString5, long paramLong1, String paramString6, List<String> paramList2, String paramString7, zzgw paramZzgw, List<String> paramList3, long paramLong2, zzmo paramZzmo, String paramString8, float paramFloat2, boolean paramBoolean2, int paramInt5, int paramInt6, boolean paramBoolean3, boolean paramBoolean4, String paramString9, String paramString10, boolean paramBoolean5, int paramInt7, Bundle paramBundle4, String paramString11)
  {
    versionCode = paramInt1;
    zzRc = paramBundle1;
    zzRd = paramZzdy;
    zzvj = paramZzec;
    zzvd = paramString1;
    applicationInfo = paramApplicationInfo;
    zzRe = paramPackageInfo;
    zzRf = paramString2;
    zzRg = paramString3;
    zzRh = paramString4;
    zzvf = paramZzqa;
    zzRi = paramBundle2;
    zzRj = paramInt2;
    zzvB = paramList1;
    if (paramList3 == null)
    {
      paramBundle1 = Collections.emptyList();
      zzRt = paramBundle1;
      zzRk = paramBundle3;
      zzRl = paramBoolean1;
      zzRm = paramMessenger;
      zzRn = paramInt3;
      zzRo = paramInt4;
      zzxa = paramFloat1;
      zzRp = paramString5;
      zzRq = paramLong1;
      zzRr = paramString6;
      if (paramList2 != null) {
        break label279;
      }
    }
    label279:
    for (paramBundle1 = Collections.emptyList();; paramBundle1 = Collections.unmodifiableList(paramList2))
    {
      zzRs = paramBundle1;
      zzvc = paramString7;
      zzvx = paramZzgw;
      zzRu = paramLong2;
      zzRv = paramZzmo;
      zzRw = paramString8;
      zzRx = paramFloat2;
      zzRD = paramBoolean2;
      zzRy = paramInt5;
      zzRz = paramInt6;
      zzRA = paramBoolean3;
      zzRB = paramBoolean4;
      zzRC = paramString9;
      zzRE = paramString10;
      zzKc = paramBoolean5;
      zzRF = paramInt7;
      zzRG = paramBundle4;
      zzRH = paramString11;
      return;
      paramBundle1 = Collections.unmodifiableList(paramList3);
      break;
    }
  }
  
  public zzmh(@Nullable Bundle paramBundle1, zzdy paramZzdy, zzec paramZzec, String paramString1, ApplicationInfo paramApplicationInfo, @Nullable PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, zzqa paramZzqa, Bundle paramBundle2, int paramInt1, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt2, int paramInt3, float paramFloat1, String paramString5, long paramLong1, String paramString6, @Nullable List<String> paramList3, String paramString7, zzgw paramZzgw, long paramLong2, zzmo paramZzmo, String paramString8, float paramFloat2, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, boolean paramBoolean4, String paramString9, String paramString10, boolean paramBoolean5, int paramInt6, Bundle paramBundle4, String paramString11)
  {
    this(19, paramBundle1, paramZzdy, paramZzec, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramZzqa, paramBundle2, paramInt1, paramList1, paramBundle3, paramBoolean1, paramMessenger, paramInt2, paramInt3, paramFloat1, paramString5, paramLong1, paramString6, paramList3, paramString7, paramZzgw, paramList2, paramLong2, paramZzmo, paramString8, paramFloat2, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramBoolean4, paramString9, paramString10, paramBoolean5, paramInt6, paramBundle4, paramString11);
  }
  
  public zzmh(zza paramZza, String paramString, long paramLong)
  {
    this(zzRc, zzRd, zzvj, zzvd, applicationInfo, zzRe, paramString, zzRg, zzRh, zzvf, zzRi, zzRj, zzvB, zzRt, zzRk, zzRl, zzRm, zzRn, zzRo, zzxa, zzRp, zzRq, zzRr, zzRs, zzvc, zzvx, paramLong, zzRv, zzRw, zzRx, zzRD, zzRy, zzRz, zzRA, zzRB, zzRC, zzRE, zzKc, zzRF, zzRG, zzRH);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzmi.zza(this, paramParcel, paramInt);
  }
  
  @zzmb
  public static final class zza
  {
    public final ApplicationInfo applicationInfo;
    public final boolean zzKc;
    public final boolean zzRA;
    public final boolean zzRB;
    public final String zzRC;
    public final boolean zzRD;
    public final String zzRE;
    public final int zzRF;
    public final Bundle zzRG;
    public final String zzRH;
    @Nullable
    public final Bundle zzRc;
    public final zzdy zzRd;
    @Nullable
    public final PackageInfo zzRe;
    public final String zzRg;
    public final String zzRh;
    public final Bundle zzRi;
    public final int zzRj;
    public final Bundle zzRk;
    public final boolean zzRl;
    public final Messenger zzRm;
    public final int zzRn;
    public final int zzRo;
    public final String zzRp;
    public final long zzRq;
    public final String zzRr;
    @Nullable
    public final List<String> zzRs;
    public final List<String> zzRt;
    public final zzmo zzRv;
    public final String zzRw;
    public final float zzRx;
    public final int zzRy;
    public final int zzRz;
    public final List<String> zzvB;
    public final String zzvc;
    public final String zzvd;
    public final zzqa zzvf;
    public final zzec zzvj;
    public final zzgw zzvx;
    public final float zzxa;
    
    public zza(@Nullable Bundle paramBundle1, zzdy paramZzdy, zzec paramZzec, String paramString1, ApplicationInfo paramApplicationInfo, @Nullable PackageInfo paramPackageInfo, String paramString2, String paramString3, zzqa paramZzqa, Bundle paramBundle2, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean1, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat1, String paramString4, long paramLong, String paramString5, @Nullable List<String> paramList3, String paramString6, zzgw paramZzgw, zzmo paramZzmo, String paramString7, float paramFloat2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, boolean paramBoolean5, int paramInt5, Bundle paramBundle4, String paramString10)
    {
      zzRc = paramBundle1;
      zzRd = paramZzdy;
      zzvj = paramZzec;
      zzvd = paramString1;
      applicationInfo = paramApplicationInfo;
      zzRe = paramPackageInfo;
      zzRg = paramString2;
      zzRh = paramString3;
      zzvf = paramZzqa;
      zzRi = paramBundle2;
      zzRl = paramBoolean1;
      zzRm = paramMessenger;
      zzRn = paramInt1;
      zzRo = paramInt2;
      zzxa = paramFloat1;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        zzRj = 3;
        zzvB = paramList1;
      }
      for (zzRt = paramList2;; zzRt = null)
      {
        zzRk = paramBundle3;
        zzRp = paramString4;
        zzRq = paramLong;
        zzRr = paramString5;
        zzRs = paramList3;
        zzvc = paramString6;
        zzvx = paramZzgw;
        zzRv = paramZzmo;
        zzRw = paramString7;
        zzRx = paramFloat2;
        zzRD = paramBoolean2;
        zzRy = paramInt3;
        zzRz = paramInt4;
        zzRA = paramBoolean3;
        zzRB = paramBoolean4;
        zzRC = paramString8;
        zzRE = paramString9;
        zzKc = paramBoolean5;
        zzRF = paramInt5;
        zzRG = paramBundle4;
        zzRH = paramString10;
        return;
        zzRj = 0;
        zzvB = null;
      }
    }
  }
}
