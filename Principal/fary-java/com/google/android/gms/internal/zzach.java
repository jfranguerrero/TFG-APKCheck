package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class zzach
  extends zza
  implements zzack.zzb<String, Integer>
{
  public static final Parcelable.Creator<zzach> CREATOR = new zzaci();
  final int mVersionCode;
  private final HashMap<String, Integer> zzaFv;
  private final SparseArray<String> zzaFw;
  private final ArrayList<zza> zzaFx;
  
  public zzach()
  {
    mVersionCode = 1;
    zzaFv = new HashMap();
    zzaFw = new SparseArray();
    zzaFx = null;
  }
  
  zzach(int paramInt, ArrayList<zza> paramArrayList)
  {
    mVersionCode = paramInt;
    zzaFv = new HashMap();
    zzaFw = new SparseArray();
    zzaFx = null;
    zzh(paramArrayList);
  }
  
  private void zzh(ArrayList<zza> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zza localZza = (zza)paramArrayList.next();
      zzj(zzaFy, zzaFz);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaci.zza(this, paramParcel, paramInt);
  }
  
  public String zzd(Integer paramInteger)
  {
    String str = (String)zzaFw.get(paramInteger.intValue());
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (zzaFv.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public zzach zzj(String paramString, int paramInt)
  {
    zzaFv.put(paramString, Integer.valueOf(paramInt));
    zzaFw.put(paramInt, paramString);
    return this;
  }
  
  ArrayList<zza> zzxJ()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzaFv.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zza(str, ((Integer)zzaFv.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public static final class zza
    extends zza
  {
    public static final Parcelable.Creator<zza> CREATOR = new zzacj();
    final int versionCode;
    final String zzaFy;
    final int zzaFz;
    
    zza(int paramInt1, String paramString, int paramInt2)
    {
      versionCode = paramInt1;
      zzaFy = paramString;
      zzaFz = paramInt2;
    }
    
    zza(String paramString, int paramInt)
    {
      versionCode = 1;
      zzaFy = paramString;
      zzaFz = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzacj.zza(this, paramParcel, paramInt);
    }
  }
}
