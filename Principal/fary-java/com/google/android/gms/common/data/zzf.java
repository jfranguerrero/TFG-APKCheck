package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean zzaCD = false;
  private ArrayList<Integer> zzaCE;
  
  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzwH()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (zzaCD) {
          break label204;
        }
        int j = zzazI.getCount();
        zzaCE = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        zzaCE.add(Integer.valueOf(0));
        String str3 = zzwG();
        i = zzazI.zzcC(0);
        String str1 = zzazI.zzd(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = zzazI.zzcC(i);
        str2 = zzazI.zzd(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        zzaCE.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        zzaCD = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzwH();
    return zzn(zzcG(paramInt), zzcH(paramInt));
  }
  
  public int getCount()
  {
    zzwH();
    return zzaCE.size();
  }
  
  int zzcG(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= zzaCE.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)zzaCE.get(paramInt)).intValue();
  }
  
  protected int zzcH(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == zzaCE.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == zzaCE.size() - 1) {}
    for (int i = zzazI.getCount() - ((Integer)zzaCE.get(paramInt)).intValue();; i = ((Integer)zzaCE.get(paramInt + 1)).intValue() - ((Integer)zzaCE.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzcG(paramInt);
      int k = zzazI.zzcC(paramInt);
      String str = zzwI();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (zzazI.zzd(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T zzn(int paramInt1, int paramInt2);
  
  protected abstract String zzwG();
  
  protected String zzwI()
  {
    return null;
  }
}
