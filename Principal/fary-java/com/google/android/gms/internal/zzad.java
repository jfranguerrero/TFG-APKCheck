package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzad
{
  public static final class zza
    extends zzbut
  {
    public zzad.zzb zzaJ;
    public zzad.zzc zzaK;
    
    public zza()
    {
      zzu();
    }
    
    public static zza zzc(byte[] paramArrayOfByte)
      throws zzbus
    {
      return (zza)zzbut.zza(new zza(), paramArrayOfByte);
    }
    
    public zza zza(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (zzbuw.zzb(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          if (zzaJ == null) {
            zzaJ = new zzad.zzb();
          }
          paramZzbul.zza(zzaJ);
          break;
        case 18: 
          if (zzaK == null) {
            zzaK = new zzad.zzc();
          }
          paramZzbul.zza(zzaK);
        }
      }
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (zzaJ != null) {
        paramZzbum.zza(1, zzaJ);
      }
      if (zzaK != null) {
        paramZzbum.zza(2, zzaK);
      }
      super.zza(paramZzbum);
    }
    
    public zza zzu()
    {
      zzaJ = null;
      zzaK = null;
      zzcsg = -1;
      return this;
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzaJ != null) {
        i = j + zzbum.zzc(1, zzaJ);
      }
      j = i;
      if (zzaK != null) {
        j = i + zzbum.zzc(2, zzaK);
      }
      return j;
    }
  }
  
  public static final class zzb
    extends zzbut
  {
    public Integer zzaL;
    
    public zzb()
    {
      zzw();
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (zzaL != null) {
        paramZzbum.zzF(27, zzaL.intValue());
      }
      super.zza(paramZzbum);
    }
    
    public zzb zzc(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (zzbuw.zzb(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 216: 
          i = paramZzbul.zzacy();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            zzaL = Integer.valueOf(i);
          }
          break;
        }
      }
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzaL != null) {
        i = j + zzbum.zzH(27, zzaL.intValue());
      }
      return i;
    }
    
    public zzb zzw()
    {
      zzcsg = -1;
      return this;
    }
  }
  
  public static final class zzc
    extends zzbut
  {
    public String zzaM;
    public String zzaN;
    public String zzaO;
    public String zzaP;
    public String zzaQ;
    
    public zzc()
    {
      zzx();
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (zzaM != null) {
        paramZzbum.zzq(1, zzaM);
      }
      if (zzaN != null) {
        paramZzbum.zzq(2, zzaN);
      }
      if (zzaO != null) {
        paramZzbum.zzq(3, zzaO);
      }
      if (zzaP != null) {
        paramZzbum.zzq(4, zzaP);
      }
      if (zzaQ != null) {
        paramZzbum.zzq(5, zzaQ);
      }
      super.zza(paramZzbum);
    }
    
    public zzc zzd(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (zzbuw.zzb(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          zzaM = paramZzbul.readString();
          break;
        case 18: 
          zzaN = paramZzbul.readString();
          break;
        case 26: 
          zzaO = paramZzbul.readString();
          break;
        case 34: 
          zzaP = paramZzbul.readString();
          break;
        case 42: 
          zzaQ = paramZzbul.readString();
        }
      }
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzaM != null) {
        i = j + zzbum.zzr(1, zzaM);
      }
      j = i;
      if (zzaN != null) {
        j = i + zzbum.zzr(2, zzaN);
      }
      i = j;
      if (zzaO != null) {
        i = j + zzbum.zzr(3, zzaO);
      }
      j = i;
      if (zzaP != null) {
        j = i + zzbum.zzr(4, zzaP);
      }
      i = j;
      if (zzaQ != null) {
        i = j + zzbum.zzr(5, zzaQ);
      }
      return i;
    }
    
    public zzc zzx()
    {
      zzaM = null;
      zzaN = null;
      zzaO = null;
      zzaP = null;
      zzaQ = null;
      zzcsg = -1;
      return this;
    }
  }
}
