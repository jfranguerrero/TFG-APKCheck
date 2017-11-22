package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;

@zzmb
class zzx
  implements SensorEventListener
{
  private final SensorManager zzNG;
  private final Object zzNH;
  private final Display zzNI;
  private final float[] zzNJ;
  private final float[] zzNK;
  private float[] zzNL;
  private Handler zzNM;
  private zza zzNN;
  
  zzx(Context paramContext)
  {
    zzNG = ((SensorManager)paramContext.getSystemService("sensor"));
    zzNI = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    zzNJ = new float[9];
    zzNK = new float[9];
    zzNH = new Object();
  }
  
  private void zzh(int paramInt1, int paramInt2)
  {
    float f = zzNK[paramInt1];
    zzNK[paramInt1] = zzNK[paramInt2];
    zzNK[paramInt2] = f;
  }
  
  int getRotation()
  {
    return zzNI.getRotation();
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    zza(values);
  }
  
  void start()
  {
    if (zzNM != null) {}
    Sensor localSensor;
    do
    {
      return;
      localSensor = zzNG.getDefaultSensor(11);
      if (localSensor == null)
      {
        zzpe.e("No Sensor of TYPE_ROTATION_VECTOR");
        return;
      }
      HandlerThread localHandlerThread = new HandlerThread("OrientationMonitor");
      localHandlerThread.start();
      zzNM = new Handler(localHandlerThread.getLooper());
    } while (zzNG.registerListener(this, localSensor, 0, zzNM));
    zzpe.e("SensorManager.registerListener failed.");
    stop();
  }
  
  void stop()
  {
    if (zzNM == null) {
      return;
    }
    zzNG.unregisterListener(this);
    zzNM.post(new Runnable()
    {
      public void run()
      {
        Looper.myLooper().quit();
      }
    });
    zzNM = null;
  }
  
  void zza(zza paramZza)
  {
    zzNN = paramZza;
  }
  
  void zza(float[] arg1)
  {
    if ((???[0] == 0.0F) && (???[1] == 0.0F) && (???[2] == 0.0F)) {}
    for (;;)
    {
      return;
      synchronized (zzNH)
      {
        if (zzNL == null) {
          zzNL = new float[9];
        }
        SensorManager.getRotationMatrixFromVector(zzNJ, ???);
        switch (getRotation())
        {
        default: 
          System.arraycopy(zzNJ, 0, zzNK, 0, 9);
          label103:
          zzh(1, 3);
          zzh(2, 6);
          zzh(5, 7);
        }
      }
      synchronized (zzNH)
      {
        System.arraycopy(zzNK, 0, zzNL, 0, 9);
        if (zzNN == null) {
          continue;
        }
        zzNN.zzho();
        return;
        ??? = finally;
        throw ???;
        SensorManager.remapCoordinateSystem(zzNJ, 2, 129, zzNK);
        break label103;
        SensorManager.remapCoordinateSystem(zzNJ, 129, 130, zzNK);
        break label103;
        SensorManager.remapCoordinateSystem(zzNJ, 130, 1, zzNK);
      }
    }
  }
  
  boolean zzb(float[] paramArrayOfFloat)
  {
    synchronized (zzNH)
    {
      if (zzNL == null) {
        return false;
      }
      System.arraycopy(zzNL, 0, paramArrayOfFloat, 0, zzNL.length);
      return true;
    }
  }
  
  static abstract interface zza
  {
    public abstract void zzho();
  }
}
