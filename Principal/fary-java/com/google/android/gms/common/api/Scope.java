package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class Scope
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzg();
  final int mVersionCode;
  private final String zzayg;
  
  Scope(int paramInt, String paramString)
  {
    zzac.zzh(paramString, "scopeUri must not be null or empty");
    mVersionCode = paramInt;
    zzayg = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return zzayg.equals(zzayg);
  }
  
  public int hashCode()
  {
    return zzayg.hashCode();
  }
  
  public String toString()
  {
    return zzayg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzuS()
  {
    return zzayg;
  }
}
