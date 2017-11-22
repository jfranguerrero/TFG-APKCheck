package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.List;

@zzmb
public class zzgp
  extends zzhd.zza
  implements zzgu.zza
{
  private Bundle mExtras;
  private String zzFS;
  private List<zzgo> zzFT;
  private String zzFU;
  private zzgz zzFV;
  private String zzFW;
  private double zzFX;
  private String zzFY;
  private String zzFZ;
  @Nullable
  private zzgm zzGa;
  @Nullable
  private zzew zzGb;
  @Nullable
  private View zzGc;
  private zzgu zzGd;
  private Object zzrN = new Object();
  
  public zzgp(String paramString1, List paramList, String paramString2, zzgz paramZzgz, String paramString3, double paramDouble, String paramString4, String paramString5, @Nullable zzgm paramZzgm, Bundle paramBundle, zzew paramZzew, View paramView)
  {
    zzFS = paramString1;
    zzFT = paramList;
    zzFU = paramString2;
    zzFV = paramZzgz;
    zzFW = paramString3;
    zzFX = paramDouble;
    zzFY = paramString4;
    zzFZ = paramString5;
    zzGa = paramZzgm;
    mExtras = paramBundle;
    zzGb = paramZzew;
    zzGc = paramView;
  }
  
  public void destroy()
  {
    zzFS = null;
    zzFT = null;
    zzFU = null;
    zzFV = null;
    zzFW = null;
    zzFX = 0.0D;
    zzFY = null;
    zzFZ = null;
    zzGa = null;
    mExtras = null;
    zzrN = null;
    zzGd = null;
    zzGb = null;
    zzGc = null;
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
  
  public String getPrice()
  {
    return zzFZ;
  }
  
  public double getStarRating()
  {
    return zzFX;
  }
  
  public String getStore()
  {
    return zzFY;
  }
  
  public void zzb(zzgu paramZzgu)
  {
    synchronized (zzrN)
    {
      zzGd = paramZzgu;
      return;
    }
  }
  
  public zzew zzbG()
  {
    return zzGb;
  }
  
  public zzgz zzfL()
  {
    return zzFV;
  }
  
  public zzd zzfM()
  {
    return zze.zzA(zzGd);
  }
  
  public String zzfN()
  {
    return "2";
  }
  
  public zzgm zzfO()
  {
    return zzGa;
  }
  
  public View zzfP()
  {
    return zzGc;
  }
}
