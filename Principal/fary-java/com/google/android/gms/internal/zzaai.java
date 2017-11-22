package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzaai
  implements zzaam
{
  private final zzaan zzazK;
  private boolean zzazL = false;
  
  public zzaai(zzaan paramZzaan)
  {
    zzazK = paramZzaan;
  }
  
  private <A extends Api.zzb> void zzd(zzzv.zza<? extends Result, A> paramZza)
    throws DeadObjectException
  {
    zzazK.zzazd.zzaAx.zzb(paramZza);
    Api.zze localZze = zzazK.zzazd.zzb(paramZza.zzuH());
    if ((!localZze.isConnected()) && (zzazK.zzaAG.containsKey(paramZza.zzuH())))
    {
      paramZza.zzA(new Status(17));
      return;
    }
    Object localObject = localZze;
    if ((localZze instanceof zzal)) {
      localObject = ((zzal)localZze).zzxG();
    }
    paramZza.zzb((Api.zzb)localObject);
  }
  
  public void begin() {}
  
  public void connect()
  {
    if (zzazL)
    {
      zzazL = false;
      zzazK.zza(new zzaan.zza(this)
      {
        public void zzvA()
        {
          zzazzaAK.zzo(null);
        }
      });
    }
  }
  
  public boolean disconnect()
  {
    if (zzazL) {
      return false;
    }
    if (zzazK.zzazd.zzvM())
    {
      zzazL = true;
      Iterator localIterator = zzazK.zzazd.zzaAw.iterator();
      while (localIterator.hasNext()) {
        ((zzabp)localIterator.next()).zzwu();
      }
      return false;
    }
    zzazK.zzh(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    zzazK.zzh(null);
    zzazK.zzaAK.zzc(paramInt, zzazL);
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzzv.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzzv.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zzd(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      zzazK.zza(new zzaan.zza(this)
      {
        public void zzvA()
        {
          onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
  
  void zzvz()
  {
    if (zzazL)
    {
      zzazL = false;
      zzazK.zzazd.zzaAx.release();
      disconnect();
    }
  }
}
