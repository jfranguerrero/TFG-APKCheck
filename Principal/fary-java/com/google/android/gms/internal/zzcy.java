package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;

@zzmb
public class zzcy
{
  private final Object zzrN = new Object();
  private final int zzxe;
  private final int zzxf;
  private final int zzxg;
  private final zzde zzxh;
  private final zzdj zzxi;
  private ArrayList<String> zzxj = new ArrayList();
  private ArrayList<String> zzxk = new ArrayList();
  private ArrayList<zzdc> zzxl = new ArrayList();
  private int zzxm = 0;
  private int zzxn = 0;
  private int zzxo = 0;
  private int zzxp;
  private String zzxq = "";
  private String zzxr = "";
  private String zzxs = "";
  
  public zzcy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    zzxe = paramInt1;
    zzxf = paramInt2;
    zzxg = paramInt3;
    zzxh = new zzde(paramInt4);
    zzxi = new zzdj(paramInt5, paramInt6, paramInt7);
  }
  
  private String zza(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ((StringBuffer)localObject).append((String)paramArrayList.next());
        ((StringBuffer)localObject).append(' ');
      } while (((StringBuffer)localObject).length() <= paramInt);
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<String>)localObject;
    } while (((String)localObject).length() < paramInt);
    return ((String)localObject).substring(0, paramInt);
  }
  
  private void zzc(@Nullable String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramString == null) || (paramString.length() < zzxg)) {
      return;
    }
    synchronized (zzrN)
    {
      zzxj.add(paramString);
      zzxm += paramString.length();
      if (paramBoolean)
      {
        zzxk.add(paramString);
        zzxl.add(new zzdc(paramFloat1, paramFloat2, paramFloat3, paramFloat4, zzxk.size() - 1));
      }
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzcy)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (zzcy)paramObject;
    } while ((paramObject.zzdV() == null) || (!paramObject.zzdV().equals(zzdV())));
    return true;
  }
  
  public int getScore()
  {
    return zzxp;
  }
  
  public int hashCode()
  {
    return zzdV().hashCode();
  }
  
  public String toString()
  {
    int i = zzxn;
    int j = zzxp;
    int k = zzxm;
    String str1 = String.valueOf(zza(zzxj, 100));
    String str2 = String.valueOf(zza(zzxk, 100));
    String str3 = zzxq;
    String str4 = zzxr;
    String str5 = zzxs;
    return String.valueOf(str1).length() + 165 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + "ActivityContent fetchId: " + i + " score:" + j + " total_length:" + k + "\n text: " + str1 + "\n viewableText" + str2 + "\n signture: " + str3 + "\n viewableSignture: " + str4 + "\n viewableSignatureForVertical: " + str5;
  }
  
  int zza(int paramInt1, int paramInt2)
  {
    return zzxe * paramInt1 + zzxf * paramInt2;
  }
  
  public void zza(String arg1, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    zzc(???, paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    synchronized (zzrN)
    {
      if (zzxo < 0) {
        zzpe.zzbc("ActivityContent: negative number of WebViews.");
      }
      zzeb();
      return;
    }
  }
  
  public void zzb(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    zzc(paramString, paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean zzdU()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzxo == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String zzdV()
  {
    return zzxq;
  }
  
  public String zzdW()
  {
    return zzxr;
  }
  
  public String zzdX()
  {
    return zzxs;
  }
  
  public void zzdY()
  {
    synchronized (zzrN)
    {
      zzxp -= 100;
      return;
    }
  }
  
  public void zzdZ()
  {
    synchronized (zzrN)
    {
      zzxo -= 1;
      return;
    }
  }
  
  public void zzea()
  {
    synchronized (zzrN)
    {
      zzxo += 1;
      return;
    }
  }
  
  public void zzeb()
  {
    synchronized (zzrN)
    {
      int i = zza(zzxm, zzxn);
      if (i > zzxp)
      {
        zzxp = i;
        if ((((Boolean)zzfx.zzBU.get()).booleanValue()) && (!zzv.zzcN().zzjJ()))
        {
          zzxq = zzxh.zza(zzxj);
          zzxr = zzxh.zza(zzxk);
        }
        if ((((Boolean)zzfx.zzBW.get()).booleanValue()) && (!zzv.zzcN().zzjK())) {
          zzxs = zzxi.zza(zzxk, zzxl);
        }
      }
      return;
    }
  }
  
  int zzec()
  {
    return zzxm;
  }
  
  public void zzn(int paramInt)
  {
    zzxn = paramInt;
  }
}
