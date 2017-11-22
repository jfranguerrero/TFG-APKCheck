package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.List;

@zzmb
public class zzgq
  extends zzhf.zza
  implements zzgu.zza
{
  private Bundle mExtras;
  private String zzFS;
  private List<zzgo> zzFT;
  private String zzFU;
  private String zzFW;
  @Nullable
  private zzgm zzGa;
  private zzgu zzGd;
  private zzgz zzGe;
  private String zzGf;
  private Object zzrN = new Object();
  
  public zzgq(String paramString1, List paramList, String paramString2, zzgz paramZzgz, String paramString3, String paramString4, @Nullable zzgm paramZzgm, Bundle paramBundle)
  {
    zzFS = paramString1;
    zzFT = paramList;
    zzFU = paramString2;
    zzGe = paramZzgz;
    zzFW = paramString3;
    zzGf = paramString4;
    zzGa = paramZzgm;
    mExtras = paramBundle;
  }
  
  public void destroy()
  {
    zzFS = null;
    zzFT = null;
    zzFU = null;
    zzGe = null;
    zzFW = null;
    zzGf = null;
    zzGa = null;
    mExtras = null;
    zzrN = null;
    zzGd = null;
  }
  
  public String getAdvertiser()
  {
    return zzGf;
  }
  
  public String getBody()
  {
    return zzFU;
  }
  
  public String getCallToAction()
  {
    return zzFW;
  }
  
  public String getCustomTemplateId()
  {
    return "";
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public String getHeadline()
  {
    return zzFS;
  }
  
  public List getImages()
  {
    return zzFT;
  }
  
  public void zzb(zzgu paramZzgu)
  {
    synchronized (zzrN)
    {
      zzGd = paramZzgu;
      return;
    }
  }
  
  public zzd zzfM()
  {
    return zze.zzA(zzGd);
  }
  
  public String zzfN()
  {
    return "1";
  }
  
  public zzgm zzfO()
  {
    return zzGa;
  }
  
  public zzgz zzfQ()
  {
    return zzGe;
  }
}
