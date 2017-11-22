package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzapx
  extends zza
{
  public static final Parcelable.Creator<zzapx> CREATOR = new zzapy();
  public final int versionCode;
  private zzaf.zza zzbfG;
  private byte[] zzbfH;
  
  zzapx(int paramInt, byte[] paramArrayOfByte)
  {
    versionCode = paramInt;
    zzbfG = null;
    zzbfH = paramArrayOfByte;
    zzzg();
  }
  
  private void zzze()
  {
    if (!zzzf()) {}
    try
    {
      zzbfG = zzaf.zza.zzd(zzbfH);
      zzbfH = null;
      zzzg();
      return;
    }
    catch (zzbus localZzbus)
    {
      throw new IllegalStateException(localZzbus);
    }
  }
  
  private boolean zzzf()
  {
    return zzbfG != null;
  }
  
  private void zzzg()
  {
    if ((zzbfG == null) && (zzbfH != null)) {}
    while ((zzbfG != null) && (zzbfH == null)) {
      return;
    }
    if ((zzbfG != null) && (zzbfH != null)) {
      throw new IllegalStateException("Invalid internal representation - full");
    }
    if ((zzbfG == null) && (zzbfH == null)) {
      throw new IllegalStateException("Invalid internal representation - empty");
    }
    throw new IllegalStateException("Impossible");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzapy.zza(this, paramParcel, paramInt);
  }
  
  public byte[] zzFY()
  {
    if (zzbfH != null) {
      return zzbfH;
    }
    return zzbut.zzf(zzbfG);
  }
  
  public zzaf.zza zzFZ()
  {
    zzze();
    return zzbfG;
  }
}
