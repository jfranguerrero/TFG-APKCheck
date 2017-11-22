package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzacr
  extends zzacl
{
  public static final Parcelable.Creator<zzacr> CREATOR = new zzacs();
  private final String mClassName;
  private final int mVersionCode;
  private final zzaco zzaFI;
  private final Parcel zzaFP;
  private final int zzaFQ;
  private int zzaFR;
  private int zzaFS;
  
  zzacr(int paramInt, Parcel paramParcel, zzaco paramZzaco)
  {
    mVersionCode = paramInt;
    zzaFP = ((Parcel)zzac.zzw(paramParcel));
    zzaFQ = 2;
    zzaFI = paramZzaco;
    if (zzaFI == null) {}
    for (mClassName = null;; mClassName = zzaFI.zzxY())
    {
      zzaFR = 2;
      return;
    }
  }
  
  private static SparseArray<Map.Entry<String, zzack.zza<?, ?>>> zzX(Map<String, zzack.zza<?, ?>> paramMap)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localSparseArray.put(((zzack.zza)localEntry.getValue()).zzxQ(), localEntry);
    }
    return localSparseArray;
  }
  
  private void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(26 + "Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(zzp.zzdC(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzq((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzr((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      zzq.zza(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, zzack.zza<?, ?> paramZza, Parcel paramParcel, int paramInt)
  {
    switch (paramZza.zzxN())
    {
    default: 
      paramInt = paramZza.zzxN();
      throw new IllegalArgumentException(36 + "Unknown field out type = " + paramInt);
    case 0: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, paramInt))));
      return;
    case 1: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, com.google.android.gms.common.internal.safeparcel.zzb.zzk(paramParcel, paramInt)));
      return;
    case 2: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, paramInt))));
      return;
    case 3: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzl(paramParcel, paramInt))));
      return;
    case 4: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzn(paramParcel, paramInt))));
      return;
    case 5: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, com.google.android.gms.common.internal.safeparcel.zzb.zzp(paramParcel, paramInt)));
      return;
    case 6: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, paramInt))));
      return;
    case 7: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt)));
      return;
    case 10: 
      zzb(paramStringBuilder, paramZza, zza(paramZza, zzr(com.google.android.gms.common.internal.safeparcel.zzb.zzs(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, zzack.zza<?, ?> paramZza, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (paramZza.zzxT())
    {
      zza(paramStringBuilder, paramZza, paramParcel, paramInt);
      return;
    }
    zzb(paramStringBuilder, paramZza, paramParcel, paramInt);
  }
  
  private void zza(StringBuilder paramStringBuilder, Map<String, zzack.zza<?, ?>> paramMap, Parcel paramParcel)
  {
    paramMap = zzX(paramMap);
    paramStringBuilder.append('{');
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramMap.get(com.google.android.gms.common.internal.safeparcel.zzb.zzcW(k));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        zza(paramStringBuilder, (String)localEntry.getKey(), (zzack.zza)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private void zzb(StringBuilder paramStringBuilder, zzack.zza<?, ?> paramZza, Parcel paramParcel, int paramInt)
  {
    if (paramZza.zzxO())
    {
      paramStringBuilder.append("[");
      switch (paramZza.zzxN())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzw(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzy(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzx(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzz(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzA(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzB(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzv(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzC(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          zza(paramStringBuilder, paramZza.zzxV(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (paramZza.zzxN())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzk(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzl(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzn(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzp(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, paramInt));
      return;
    case 7: 
      paramZza = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(zzp.zzdC(paramZza)).append("\"");
      return;
    case 8: 
      paramZza = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzq(paramZza)).append("\"");
      return;
    case 9: 
      paramZza = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzr(paramZza));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      paramZza = com.google.android.gms.common.internal.safeparcel.zzb.zzs(paramParcel, paramInt);
      paramParcel = paramZza.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        String str = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(zzp.zzdC(paramZza.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = com.google.android.gms.common.internal.safeparcel.zzb.zzF(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    zza(paramStringBuilder, paramZza.zzxV(), paramParcel);
  }
  
  private void zzb(StringBuilder paramStringBuilder, zzack.zza<?, ?> paramZza, Object paramObject)
  {
    if (paramZza.zzxM())
    {
      zzb(paramStringBuilder, paramZza, (ArrayList)paramObject);
      return;
    }
    zza(paramStringBuilder, paramZza.zzxL(), paramObject);
  }
  
  private void zzb(StringBuilder paramStringBuilder, zzack.zza<?, ?> paramZza, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      zza(paramStringBuilder, paramZza.zzxL(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> zzr(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public String toString()
  {
    zzac.zzb(zzaFI, "Cannot convert to JSON on client side.");
    Parcel localParcel = zzya();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, zzaFI.zzdA(mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacs.zza(this, paramParcel, paramInt);
  }
  
  public Object zzdw(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public boolean zzdx(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public Map<String, zzack.zza<?, ?>> zzxK()
  {
    if (zzaFI == null) {
      return null;
    }
    return zzaFI.zzdA(mClassName);
  }
  
  public Parcel zzya()
  {
    switch (zzaFR)
    {
    }
    for (;;)
    {
      return zzaFP;
      zzaFS = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(zzaFP);
      com.google.android.gms.common.internal.safeparcel.zzc.zzJ(zzaFP, zzaFS);
      zzaFR = 2;
      continue;
      com.google.android.gms.common.internal.safeparcel.zzc.zzJ(zzaFP, zzaFS);
      zzaFR = 2;
    }
  }
  
  zzaco zzyb()
  {
    switch (zzaFQ)
    {
    default: 
      int i = zzaFQ;
      throw new IllegalStateException(34 + "Invalid creation type: " + i);
    case 0: 
      return null;
    case 1: 
      return zzaFI;
    }
    return zzaFI;
  }
}
