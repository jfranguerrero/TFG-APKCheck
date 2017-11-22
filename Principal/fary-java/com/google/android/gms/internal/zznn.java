package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;

@zzmb
public class zznn
  extends zznq.zza
{
  private final String zzTW;
  private final int zzUD;
  
  public zznn(String paramString, int paramInt)
  {
    zzTW = paramString;
    zzUD = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zznn))) {}
    do
    {
      return false;
      paramObject = (zznn)paramObject;
    } while ((!zzaa.equal(getType(), paramObject.getType())) || (!zzaa.equal(Integer.valueOf(getAmount()), Integer.valueOf(paramObject.getAmount()))));
    return true;
  }
  
  public int getAmount()
  {
    return zzUD;
  }
  
  public String getType()
  {
    return zzTW;
  }
}
