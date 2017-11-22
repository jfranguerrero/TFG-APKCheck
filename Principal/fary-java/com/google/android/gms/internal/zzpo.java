package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzpo
{
  private final String[] zzXl;
  private final double[] zzXm;
  private final double[] zzXn;
  private final int[] zzXo;
  private int zzXp;
  
  private zzpo(zzb paramZzb)
  {
    int i = zzb.zza(paramZzb).size();
    zzXl = ((String[])zzb.zzb(paramZzb).toArray(new String[i]));
    zzXm = zzn(zzb.zza(paramZzb));
    zzXn = zzn(zzb.zzc(paramZzb));
    zzXo = new int[i];
    zzXp = 0;
  }
  
  private double[] zzn(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public List<zza> getBuckets()
  {
    ArrayList localArrayList = new ArrayList(zzXl.length);
    int i = 0;
    while (i < zzXl.length)
    {
      localArrayList.add(new zza(zzXl[i], zzXn[i], zzXm[i], zzXo[i] / zzXp, zzXo[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public void zza(double paramDouble)
  {
    zzXp += 1;
    int i = 0;
    for (;;)
    {
      if (i < zzXn.length)
      {
        if ((zzXn[i] <= paramDouble) && (paramDouble < zzXm[i]))
        {
          int[] arrayOfInt = zzXo;
          arrayOfInt[i] += 1;
        }
        if (paramDouble >= zzXn[i]) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static class zza
  {
    public final int count;
    public final String name;
    public final double zzXq;
    public final double zzXr;
    public final double zzXs;
    
    public zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
    {
      name = paramString;
      zzXr = paramDouble1;
      zzXq = paramDouble2;
      zzXs = paramDouble3;
      count = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {}
      do
      {
        return false;
        paramObject = (zza)paramObject;
      } while ((!zzaa.equal(name, name)) || (zzXq != zzXq) || (zzXr != zzXr) || (count != count) || (Double.compare(zzXs, zzXs) != 0));
      return true;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { name, Double.valueOf(zzXq), Double.valueOf(zzXr), Double.valueOf(zzXs), Integer.valueOf(count) });
    }
    
    public String toString()
    {
      return zzaa.zzv(this).zzg("name", name).zzg("minBound", Double.valueOf(zzXr)).zzg("maxBound", Double.valueOf(zzXq)).zzg("percent", Double.valueOf(zzXs)).zzg("count", Integer.valueOf(count)).toString();
    }
  }
  
  public static class zzb
  {
    private final List<String> zzXt = new ArrayList();
    private final List<Double> zzXu = new ArrayList();
    private final List<Double> zzXv = new ArrayList();
    
    public zzb() {}
    
    public zzb zza(String paramString, double paramDouble1, double paramDouble2)
    {
      int i = 0;
      for (;;)
      {
        double d1;
        double d2;
        if (i < zzXt.size())
        {
          d1 = ((Double)zzXv.get(i)).doubleValue();
          d2 = ((Double)zzXu.get(i)).doubleValue();
          if (paramDouble1 >= d1) {
            break label107;
          }
        }
        label107:
        while ((d1 == paramDouble1) && (paramDouble2 < d2))
        {
          zzXt.add(i, paramString);
          zzXv.add(i, Double.valueOf(paramDouble1));
          zzXu.add(i, Double.valueOf(paramDouble2));
          return this;
        }
        i += 1;
      }
    }
    
    public zzpo zzkB()
    {
      return new zzpo(this, null);
    }
  }
}
