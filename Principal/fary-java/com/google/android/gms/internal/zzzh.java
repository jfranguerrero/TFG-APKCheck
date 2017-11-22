package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;

public class zzzh
  extends zza
{
  public static final Parcelable.Creator<zzzh> CREATOR = new zzzi();
  public final int versionCode;
  public zzawe zzawE;
  public byte[] zzawF;
  public int[] zzawG;
  public String[] zzawH;
  public int[] zzawI;
  public byte[][] zzawJ;
  public boolean zzawK;
  public final zzbuy.zzc zzawL;
  public final zzzf.zzc zzawM;
  public final zzzf.zzc zzawN;
  
  zzzh(int paramInt, zzawe paramZzawe, byte[] paramArrayOfByte, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte1, boolean paramBoolean)
  {
    versionCode = paramInt;
    zzawE = paramZzawe;
    zzawF = paramArrayOfByte;
    zzawG = paramArrayOfInt1;
    zzawH = paramArrayOfString;
    zzawL = null;
    zzawM = null;
    zzawN = null;
    zzawI = paramArrayOfInt2;
    zzawJ = paramArrayOfByte1;
    zzawK = paramBoolean;
  }
  
  public zzzh(zzawe paramZzawe, zzbuy.zzc paramZzc, zzzf.zzc paramZzc1, zzzf.zzc paramZzc2, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    versionCode = 1;
    zzawE = paramZzawe;
    zzawL = paramZzc;
    zzawM = paramZzc1;
    zzawN = paramZzc2;
    zzawG = paramArrayOfInt1;
    zzawH = paramArrayOfString;
    zzawI = paramArrayOfInt2;
    zzawJ = paramArrayOfByte;
    zzawK = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzzh)) {
        break;
      }
      paramObject = (zzzh)paramObject;
    } while ((versionCode == versionCode) && (zzaa.equal(zzawE, zzawE)) && (Arrays.equals(zzawF, zzawF)) && (Arrays.equals(zzawG, zzawG)) && (Arrays.equals(zzawH, zzawH)) && (zzaa.equal(zzawL, zzawL)) && (zzaa.equal(zzawM, zzawM)) && (zzaa.equal(zzawN, zzawN)) && (Arrays.equals(zzawI, zzawI)) && (Arrays.deepEquals(zzawJ, zzawJ)) && (zzawK == zzawK));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(versionCode), zzawE, zzawF, zzawG, zzawH, zzawL, zzawM, zzawN, zzawI, zzawJ, Boolean.valueOf(zzawK) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[").append(versionCode).append(", ").append(zzawE).append(", ").append("LogEventBytes: ");
    if (zzawF == null) {}
    for (String str = null;; str = new String(zzawF)) {
      return str + ", " + "TestCodes: " + Arrays.toString(zzawG) + ", " + "MendelPackages: " + Arrays.toString(zzawH) + ", " + "LogEvent: " + zzawL + ", " + "ExtensionProducer: " + zzawM + ", " + "VeProducer: " + zzawN + ", " + "ExperimentIDs: " + Arrays.toString(zzawI) + ", " + "ExperimentTokens: " + Arrays.toString(zzawJ) + ", " + "AddPhenotypeExperimentTokens: " + zzawK + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzzi.zza(this, paramParcel, paramInt);
  }
}
