package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzaag
  implements Releasable, Result
{
  protected final Status zzahq;
  protected final DataHolder zzazI;
  
  protected zzaag(DataHolder paramDataHolder, Status paramStatus)
  {
    zzahq = paramStatus;
    zzazI = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return zzahq;
  }
  
  public void release()
  {
    if (zzazI != null) {
      zzazI.close();
    }
  }
}
