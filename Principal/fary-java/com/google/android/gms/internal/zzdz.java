package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@zzmb
public final class zzdz
{
  private Bundle mExtras;
  private Location zzcU;
  private boolean zzsS;
  private long zzyV;
  private int zzyW;
  private List<String> zzyX;
  private boolean zzyY;
  private int zzyZ;
  private String zzza;
  private zzfj zzzb;
  private String zzzc;
  private Bundle zzzd;
  private Bundle zzze;
  private List<String> zzzf;
  private String zzzg;
  private String zzzh;
  private boolean zzzi;
  
  public zzdz()
  {
    zzyV = -1L;
    mExtras = new Bundle();
    zzyW = -1;
    zzyX = new ArrayList();
    zzyY = false;
    zzyZ = -1;
    zzsS = false;
    zzza = null;
    zzzb = null;
    zzcU = null;
    zzzc = null;
    zzzd = new Bundle();
    zzze = new Bundle();
    zzzf = new ArrayList();
    zzzg = null;
    zzzh = null;
    zzzi = false;
  }
  
  public zzdz(zzdy paramZzdy)
  {
    zzyV = zzyF;
    mExtras = extras;
    zzyW = zzyG;
    zzyX = zzyH;
    zzyY = zzyI;
    zzyZ = zzyJ;
    zzsS = zzyK;
    zzza = zzyL;
    zzzb = zzyM;
    zzcU = zzyN;
    zzzc = zzyO;
    zzzd = zzyP;
    zzze = zzyQ;
    zzzf = zzyR;
    zzzg = zzyS;
    zzzh = zzyT;
  }
  
  public zzdz zza(@Nullable Location paramLocation)
  {
    zzcU = paramLocation;
    return this;
  }
  
  public zzdy zzex()
  {
    return new zzdy(7, zzyV, mExtras, zzyW, zzyX, zzyY, zzyZ, zzsS, zzza, zzzb, zzcU, zzzc, zzzd, zzze, zzzf, zzzg, zzzh, false);
  }
}
