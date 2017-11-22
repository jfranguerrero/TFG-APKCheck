package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzae
{
  public static final class zza
    extends zzbun<zza>
  {
    public String stackTrace = null;
    public String zzaR = null;
    public Long zzaS = null;
    public String zzaT = null;
    public String zzaU = null;
    public Long zzaV = null;
    public Long zzaW = null;
    public String zzaX = null;
    public Long zzaY = null;
    public String zzaZ = null;
    
    public zza()
    {
      zzcsg = -1;
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (zzaR != null) {
        paramZzbum.zzq(1, zzaR);
      }
      if (zzaS != null) {
        paramZzbum.zzb(2, zzaS.longValue());
      }
      if (stackTrace != null) {
        paramZzbum.zzq(3, stackTrace);
      }
      if (zzaT != null) {
        paramZzbum.zzq(4, zzaT);
      }
      if (zzaU != null) {
        paramZzbum.zzq(5, zzaU);
      }
      if (zzaV != null) {
        paramZzbum.zzb(6, zzaV.longValue());
      }
      if (zzaW != null) {
        paramZzbum.zzb(7, zzaW.longValue());
      }
      if (zzaX != null) {
        paramZzbum.zzq(8, zzaX);
      }
      if (zzaY != null) {
        paramZzbum.zzb(9, zzaY.longValue());
      }
      if (zzaZ != null) {
        paramZzbum.zzq(10, zzaZ);
      }
      super.zza(paramZzbum);
    }
    
    public zza zze(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (super.zza(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          zzaR = paramZzbul.readString();
          break;
        case 16: 
          zzaS = Long.valueOf(paramZzbul.zzacx());
          break;
        case 26: 
          stackTrace = paramZzbul.readString();
          break;
        case 34: 
          zzaT = paramZzbul.readString();
          break;
        case 42: 
          zzaU = paramZzbul.readString();
          break;
        case 48: 
          zzaV = Long.valueOf(paramZzbul.zzacx());
          break;
        case 56: 
          zzaW = Long.valueOf(paramZzbul.zzacx());
          break;
        case 66: 
          zzaX = paramZzbul.readString();
          break;
        case 72: 
          zzaY = Long.valueOf(paramZzbul.zzacx());
          break;
        case 82: 
          zzaZ = paramZzbul.readString();
        }
      }
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzaR != null) {
        i = j + zzbum.zzr(1, zzaR);
      }
      j = i;
      if (zzaS != null) {
        j = i + zzbum.zzf(2, zzaS.longValue());
      }
      i = j;
      if (stackTrace != null) {
        i = j + zzbum.zzr(3, stackTrace);
      }
      j = i;
      if (zzaT != null) {
        j = i + zzbum.zzr(4, zzaT);
      }
      i = j;
      if (zzaU != null) {
        i = j + zzbum.zzr(5, zzaU);
      }
      j = i;
      if (zzaV != null) {
        j = i + zzbum.zzf(6, zzaV.longValue());
      }
      i = j;
      if (zzaW != null) {
        i = j + zzbum.zzf(7, zzaW.longValue());
      }
      j = i;
      if (zzaX != null) {
        j = i + zzbum.zzr(8, zzaX);
      }
      i = j;
      if (zzaY != null) {
        i = j + zzbum.zzf(9, zzaY.longValue());
      }
      j = i;
      if (zzaZ != null) {
        j = i + zzbum.zzr(10, zzaZ);
      }
      return j;
    }
  }
}
