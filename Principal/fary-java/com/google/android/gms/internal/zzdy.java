package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.List;

@zzmb
public final class zzdy
  extends zza
{
  public static final Parcelable.Creator<zzdy> CREATOR = new zzea();
  public final Bundle extras;
  public final int versionCode;
  public final long zzyF;
  public final int zzyG;
  public final List<String> zzyH;
  public final boolean zzyI;
  public final int zzyJ;
  public final boolean zzyK;
  public final String zzyL;
  public final zzfj zzyM;
  public final Location zzyN;
  public final String zzyO;
  public final Bundle zzyP;
  public final Bundle zzyQ;
  public final List<String> zzyR;
  public final String zzyS;
  public final String zzyT;
  public final boolean zzyU;
  
  public zzdy(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, zzfj paramZzfj, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    versionCode = paramInt1;
    zzyF = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    extras = localBundle;
    zzyG = paramInt2;
    zzyH = paramList1;
    zzyI = paramBoolean1;
    zzyJ = paramInt3;
    zzyK = paramBoolean2;
    zzyL = paramString1;
    zzyM = paramZzfj;
    zzyN = paramLocation;
    zzyO = paramString2;
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    zzyP = paramBundle1;
    zzyQ = paramBundle3;
    zzyR = paramList2;
    zzyS = paramString3;
    zzyT = paramString4;
    zzyU = paramBoolean3;
  }
  
  public static void zzj(zzdy paramZzdy)
  {
    zzyP.putBundle("com.google.ads.mediation.admob.AdMobAdapter", extras);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzdy)) {}
    do
    {
      return false;
      paramObject = (zzdy)paramObject;
    } while ((versionCode != versionCode) || (zzyF != zzyF) || (!zzaa.equal(extras, extras)) || (zzyG != zzyG) || (!zzaa.equal(zzyH, zzyH)) || (zzyI != zzyI) || (zzyJ != zzyJ) || (zzyK != zzyK) || (!zzaa.equal(zzyL, zzyL)) || (!zzaa.equal(zzyM, zzyM)) || (!zzaa.equal(zzyN, zzyN)) || (!zzaa.equal(zzyO, zzyO)) || (!zzaa.equal(zzyP, zzyP)) || (!zzaa.equal(zzyQ, zzyQ)) || (!zzaa.equal(zzyR, zzyR)) || (!zzaa.equal(zzyS, zzyS)) || (!zzaa.equal(zzyT, zzyT)) || (zzyU != zzyU));
    return true;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(versionCode), Long.valueOf(zzyF), extras, Integer.valueOf(zzyG), zzyH, Boolean.valueOf(zzyI), Integer.valueOf(zzyJ), Boolean.valueOf(zzyK), zzyL, zzyM, zzyN, zzyO, zzyP, zzyQ, zzyR, zzyS, zzyT, Boolean.valueOf(zzyU) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzea.zza(this, paramParcel, paramInt);
  }
}
