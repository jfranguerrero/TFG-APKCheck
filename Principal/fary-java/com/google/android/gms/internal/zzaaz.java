package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;

public final class zzaaz<L>
{
  private volatile L mListener;
  private final zza zzaBy;
  private final zzb<L> zzaBz;
  
  zzaaz(@NonNull Looper paramLooper, @NonNull L paramL, @NonNull String paramString)
  {
    zzaBy = new zza(paramLooper);
    mListener = zzac.zzb(paramL, "Listener must not be null");
    zzaBz = new zzb(paramL, zzac.zzdv(paramString));
  }
  
  public void clear()
  {
    mListener = null;
  }
  
  public void zza(zzc<? super L> paramZzc)
  {
    zzac.zzb(paramZzc, "Notifier must not be null");
    paramZzc = zzaBy.obtainMessage(1, paramZzc);
    zzaBy.sendMessage(paramZzc);
  }
  
  void zzb(zzc<? super L> paramZzc)
  {
    Object localObject = mListener;
    if (localObject == null)
    {
      paramZzc.zzvy();
      return;
    }
    try
    {
      paramZzc.zzs(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramZzc.zzvy();
      throw localRuntimeException;
    }
  }
  
  @NonNull
  public zzb<L> zzwp()
  {
    return zzaBz;
  }
  
  private final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (what == 1) {}
      for (;;)
      {
        zzac.zzas(bool);
        zzb((zzaaz.zzc)obj);
        return;
        bool = false;
      }
    }
  }
  
  public static final class zzb<L>
  {
    private final L mListener;
    private final String zzaBB;
    
    zzb(L paramL, String paramString)
    {
      mListener = paramL;
      zzaBB = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
      } while ((mListener == mListener) && (zzaBB.equals(zzaBB)));
      return false;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(mListener) * 31 + zzaBB.hashCode();
    }
  }
  
  public static abstract interface zzc<L>
  {
    public abstract void zzs(L paramL);
    
    public abstract void zzvy();
  }
}
