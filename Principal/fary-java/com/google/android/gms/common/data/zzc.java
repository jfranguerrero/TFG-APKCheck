package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public abstract class zzc
{
  protected int zzaCm;
  private int zzaCn;
  protected final DataHolder zzazI;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    zzazI = ((DataHolder)zzac.zzw(paramDataHolder));
    zzcA(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzaa.equal(Integer.valueOf(zzaCm), Integer.valueOf(zzaCm)))
      {
        bool1 = bool2;
        if (zzaa.equal(Integer.valueOf(zzaCn), Integer.valueOf(zzaCn)))
        {
          bool1 = bool2;
          if (zzazI == zzazI) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return zzazI.zze(paramString, zzaCm, zzaCn);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return zzazI.zzg(paramString, zzaCm, zzaCn);
  }
  
  protected float getFloat(String paramString)
  {
    return zzazI.zzf(paramString, zzaCm, zzaCn);
  }
  
  protected int getInteger(String paramString)
  {
    return zzazI.zzc(paramString, zzaCm, zzaCn);
  }
  
  protected long getLong(String paramString)
  {
    return zzazI.zzb(paramString, zzaCm, zzaCn);
  }
  
  protected String getString(String paramString)
  {
    return zzazI.zzd(paramString, zzaCm, zzaCn);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(zzaCm), Integer.valueOf(zzaCn), zzazI });
  }
  
  public boolean isDataValid()
  {
    return !zzazI.isClosed();
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    zzazI.zza(paramString, zzaCm, zzaCn, paramCharArrayBuffer);
  }
  
  protected void zzcA(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < zzazI.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzar(bool);
      zzaCm = paramInt;
      zzaCn = zzazI.zzcC(zzaCm);
      return;
    }
  }
  
  public boolean zzdj(String paramString)
  {
    return zzazI.zzdj(paramString);
  }
  
  protected Uri zzdk(String paramString)
  {
    return zzazI.zzh(paramString, zzaCm, zzaCn);
  }
  
  protected boolean zzdl(String paramString)
  {
    return zzazI.zzi(paramString, zzaCm, zzaCn);
  }
  
  protected int zzwB()
  {
    return zzaCm;
  }
}
