package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzb
  extends Exception
{
  private final ArrayMap<zzzs<?>, ConnectionResult> zzaxy;
  
  public zzb(ArrayMap<zzzs<?>, ConnectionResult> paramArrayMap)
  {
    zzaxy = paramArrayMap;
  }
  
  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = zzaxy.keySet().iterator();
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (zzzs)((Iterator)localObject1).next();
      Object localObject2 = (ConnectionResult)zzaxy.get(localObject3);
      if (((ConnectionResult)localObject2).isSuccess()) {
        i = 0;
      }
      localObject3 = String.valueOf(((zzzs)localObject3).zzuV());
      localObject2 = String.valueOf(localObject2);
      localArrayList.add(String.valueOf(localObject3).length() + 2 + String.valueOf(localObject2).length() + (String)localObject3 + ": " + (String)localObject2);
    }
    localObject1 = new StringBuilder();
    if (i != 0) {
      ((StringBuilder)localObject1).append("None of the queried APIs are available. ");
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(TextUtils.join("; ", localArrayList));
      return ((StringBuilder)localObject1).toString();
      ((StringBuilder)localObject1).append("Some of the queried APIs are unavailable. ");
    }
  }
  
  public ArrayMap<zzzs<?>, ConnectionResult> zzuK()
  {
    return zzaxy;
  }
}
