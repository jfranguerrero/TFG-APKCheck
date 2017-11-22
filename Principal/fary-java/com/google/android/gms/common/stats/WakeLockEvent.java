package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzf();
  private final long mTimeout;
  final int mVersionCode;
  private final List<String> zzaGA;
  private final String zzaGB;
  private final long zzaGC;
  private int zzaGD;
  private final String zzaGE;
  private final float zzaGF;
  private long zzaGG;
  private final long zzaGu;
  private int zzaGv;
  private final String zzaGw;
  private final String zzaGx;
  private final String zzaGy;
  private final int zzaGz;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    mVersionCode = paramInt1;
    zzaGu = paramLong1;
    zzaGv = paramInt2;
    zzaGw = paramString1;
    zzaGx = paramString3;
    zzaGy = paramString5;
    zzaGz = paramInt3;
    zzaGG = -1L;
    zzaGA = paramList;
    zzaGB = paramString2;
    zzaGC = paramLong2;
    zzaGD = paramInt4;
    zzaGE = paramString4;
    zzaGF = paramFloat;
    mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
  }
  
  public int getEventType()
  {
    return zzaGv;
  }
  
  public long getTimeMillis()
  {
    return zzaGu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public long zzye()
  {
    return zzaGG;
  }
  
  public String zzyf()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(zzyg());
    String str7 = String.valueOf("\t");
    int i = zzyj();
    String str8 = String.valueOf("\t");
    String str1;
    String str9;
    int j;
    String str10;
    String str2;
    label76:
    String str11;
    String str3;
    label94:
    String str12;
    float f;
    String str13;
    if (zzyk() == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = zzyn();
      str10 = String.valueOf("\t");
      if (zzyh() != null) {
        break label345;
      }
      str2 = "";
      str11 = String.valueOf("\t");
      if (zzyo() != null) {
        break label354;
      }
      str3 = "";
      str12 = String.valueOf("\t");
      f = zzyp();
      str13 = String.valueOf("\t");
      if (zzyi() != null) {
        break label363;
      }
    }
    label345:
    label354:
    label363:
    for (String str4 = "";; str4 = zzyi())
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", zzyk());
      break;
      str2 = zzyh();
      break label76;
      str3 = zzyo();
      break label94;
    }
  }
  
  public String zzyg()
  {
    return zzaGw;
  }
  
  public String zzyh()
  {
    return zzaGx;
  }
  
  public String zzyi()
  {
    return zzaGy;
  }
  
  public int zzyj()
  {
    return zzaGz;
  }
  
  public List<String> zzyk()
  {
    return zzaGA;
  }
  
  public String zzyl()
  {
    return zzaGB;
  }
  
  public long zzym()
  {
    return zzaGC;
  }
  
  public int zzyn()
  {
    return zzaGD;
  }
  
  public String zzyo()
  {
    return zzaGE;
  }
  
  public float zzyp()
  {
    return zzaGF;
  }
  
  public long zzyq()
  {
    return mTimeout;
  }
}
