package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzf;
import java.util.HashMap;
import java.util.Map;

@zzmb
public class zzqu
  extends zzew.zza
{
  private final zzqp zzGt;
  private boolean zzZA;
  private float zzZB;
  private float zzZC;
  private final float zzZw;
  private int zzZx;
  private zzex zzZy;
  private boolean zzZz;
  private final Object zzrN = new Object();
  private boolean zzrQ = true;
  
  public zzqu(zzqp paramZzqp, float paramFloat)
  {
    zzGt = paramZzqp;
    zzZw = paramFloat;
  }
  
  private void zzbk(String paramString)
  {
    zzd(paramString, null);
  }
  
  private void zzd(String paramString, @Nullable final Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (paramMap = new HashMap();; paramMap = new HashMap(paramMap))
    {
      paramMap.put("action", paramString);
      zzv.zzcJ().runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzqu.zzb(zzqu.this).zza("pubVideoCmd", paramMap);
        }
      });
      return;
    }
  }
  
  private void zzk(final int paramInt1, final int paramInt2)
  {
    zzv.zzcJ().runOnUiThread(new Runnable()
    {
      public void run()
      {
        label48:
        label62:
        label77:
        label141:
        label146:
        label151:
        label157:
        label162:
        label287:
        for (boolean bool = false;; bool = true)
        {
          int j;
          int k;
          int m;
          synchronized (zzqu.zzc(zzqu.this))
          {
            int i;
            if (paramInt1 != paramInt2)
            {
              j = 1;
              if ((zzqu.zzd(zzqu.this)) || (paramInt2 != 1)) {
                break label141;
              }
              i = 1;
              if ((j == 0) || (paramInt2 != 1)) {
                break label146;
              }
              k = 1;
              if ((j == 0) || (paramInt2 != 2)) {
                break label151;
              }
              m = 1;
              if ((j == 0) || (paramInt2 != 3)) {
                break label157;
              }
            }
            for (j = 1;; j = 0)
            {
              zzqu localZzqu = zzqu.this;
              if ((zzqu.zzd(zzqu.this)) || (i != 0)) {
                break label287;
              }
              zzqu.zza(localZzqu, bool);
              if (zzqu.zze(zzqu.this) != null) {
                break label162;
              }
              return;
              j = 0;
              break;
              i = 0;
              break label48;
              k = 0;
              break label62;
              m = 0;
              break label77;
            }
            if (i == 0) {}
          }
          try
          {
            zzqu.zze(zzqu.this).zzeT();
            if (k == 0) {}
          }
          catch (RemoteException localRemoteException3)
          {
            try
            {
              zzqu.zze(zzqu.this).zzeU();
              if (m == 0) {}
            }
            catch (RemoteException localRemoteException3)
            {
              try
              {
                zzqu.zze(zzqu.this).zzeV();
                if (j == 0) {}
              }
              catch (RemoteException localRemoteException3)
              {
                try
                {
                  for (;;)
                  {
                    zzqu.zze(zzqu.this).onVideoEnd();
                    return;
                    localObject2 = finally;
                    throw localObject2;
                    localRemoteException1 = localRemoteException1;
                    zzpe.zzc("Unable to call onVideoStart()", localRemoteException1);
                    continue;
                    localRemoteException2 = localRemoteException2;
                    zzpe.zzc("Unable to call onVideoPlay()", localRemoteException2);
                  }
                  localRemoteException3 = localRemoteException3;
                  zzpe.zzc("Unable to call onVideoPause()", localRemoteException3);
                }
                catch (RemoteException localRemoteException4)
                {
                  for (;;)
                  {
                    zzpe.zzc("Unable to call onVideoEnd()", localRemoteException4);
                  }
                }
              }
            }
          }
        }
      }
    });
  }
  
  public float getAspectRatio()
  {
    synchronized (zzrN)
    {
      float f = zzZC;
      return f;
    }
  }
  
  public int getPlaybackState()
  {
    synchronized (zzrN)
    {
      int i = zzZx;
      return i;
    }
  }
  
  public boolean isMuted()
  {
    synchronized (zzrN)
    {
      boolean bool = zzZA;
      return bool;
    }
  }
  
  public void pause()
  {
    zzbk("pause");
  }
  
  public void play()
  {
    zzbk("play");
  }
  
  public void zzP(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        zzrQ = paramBoolean;
        if (paramBoolean)
        {
          ??? = "1";
          zzd("initialState", zzf.zze("muteStart", ???));
          return;
        }
      }
      ??? = "0";
    }
  }
  
  public void zza(float paramFloat1, int paramInt, boolean paramBoolean, float paramFloat2)
  {
    synchronized (zzrN)
    {
      zzZB = paramFloat1;
      zzZA = paramBoolean;
      int i = zzZx;
      zzZx = paramInt;
      zzZC = paramFloat2;
      zzk(i, paramInt);
      return;
    }
  }
  
  public void zza(zzex paramZzex)
  {
    synchronized (zzrN)
    {
      zzZy = paramZzex;
      return;
    }
  }
  
  public float zzeR()
  {
    return zzZw;
  }
  
  public float zzeS()
  {
    synchronized (zzrN)
    {
      float f = zzZB;
      return f;
    }
  }
  
  public void zzn(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "mute";; str = "unmute")
    {
      zzbk(str);
      return;
    }
  }
}
