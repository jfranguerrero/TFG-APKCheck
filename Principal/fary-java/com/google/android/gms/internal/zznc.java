package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zznc
{
  private int mOrientation = -1;
  private String zzFU;
  private final zzmh zzKG;
  private boolean zzKs = false;
  private List<String> zzQe;
  private boolean zzTA = false;
  private boolean zzTB = false;
  private boolean zzTC = true;
  private boolean zzTD = true;
  private String zzTE = "";
  private boolean zzTF = false;
  private zzok zzTG;
  private List<String> zzTH;
  private List<String> zzTI;
  private boolean zzTJ = false;
  private zzmm zzTK;
  private boolean zzTL = false;
  private String zzTM;
  private List<String> zzTN;
  private boolean zzTO;
  private String zzTP;
  private zzon zzTQ;
  private String zzTo;
  private String zzTp;
  private List<String> zzTq;
  private String zzTr;
  private String zzTs;
  private String zzTt;
  private List<String> zzTu;
  private long zzTv = -1L;
  private boolean zzTw = false;
  private final long zzTx = -1L;
  private long zzTy = -1L;
  private boolean zzTz = false;
  
  public zznc(zzmh paramZzmh, String paramString)
  {
    zzTp = paramString;
    zzKG = paramZzmh;
  }
  
  private void zzA(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Use-HTTPS");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzTB = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzB(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Content-Url-Opted-Out");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzTC = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzC(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Content-Vertical-Opted-Out");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzTD = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzD(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Gws-Query-Id");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzTE = ((String)paramMap.get(0));
    }
  }
  
  private void zzE(Map<String, List<String>> paramMap)
  {
    paramMap = zzc(paramMap, "X-Afma-Fluid");
    if ((paramMap != null) && (paramMap.equals("height"))) {
      zzTF = true;
    }
  }
  
  private void zzF(Map<String, List<String>> paramMap)
  {
    zzKs = "native_express".equals(zzc(paramMap, "X-Afma-Ad-Format"));
  }
  
  private void zzG(Map<String, List<String>> paramMap)
  {
    zzTG = zzok.zzaQ(zzc(paramMap, "X-Afma-Rewards"));
  }
  
  private void zzH(Map<String, List<String>> paramMap)
  {
    if (zzTH != null) {
      return;
    }
    zzTH = zze(paramMap, "X-Afma-Reward-Video-Start-Urls");
  }
  
  private void zzI(Map<String, List<String>> paramMap)
  {
    if (zzTI != null) {
      return;
    }
    zzTI = zze(paramMap, "X-Afma-Reward-Video-Complete-Urls");
  }
  
  private void zzJ(Map<String, List<String>> paramMap)
  {
    zzTJ |= zzf(paramMap, "X-Afma-Use-Displayed-Impression");
  }
  
  private void zzK(Map<String, List<String>> paramMap)
  {
    zzTL |= zzf(paramMap, "X-Afma-Auto-Collect-Location");
  }
  
  private void zzL(Map<String, List<String>> paramMap)
  {
    paramMap = zze(paramMap, "X-Afma-Remote-Ping-Urls");
    if (paramMap != null) {
      zzTN = paramMap;
    }
  }
  
  private void zzM(Map<String, List<String>> paramMap)
  {
    paramMap = zzc(paramMap, "X-Afma-Auto-Protection-Configuration");
    if ((paramMap == null) || (TextUtils.isEmpty(paramMap)))
    {
      paramMap = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
      paramMap.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(zzTs)) {
        paramMap.appendQueryParameter("debugDialog", zzTs);
      }
      boolean bool = ((Boolean)zzfx.zzAZ.get()).booleanValue();
      paramMap = String.valueOf(paramMap.toString());
      String str = String.valueOf("navigationURL");
      zzTK = new zzmm(bool, Arrays.asList(new String[] { String.valueOf(paramMap).length() + 18 + String.valueOf(str).length() + paramMap + "&" + str + "={NAVIGATION_URL}" }));
      return;
    }
    try
    {
      zzTK = zzmm.zzg(new JSONObject(paramMap));
      return;
    }
    catch (JSONException paramMap)
    {
      zzpe.zzc("Error parsing configuration JSON", paramMap);
      zzTK = new zzmm();
    }
  }
  
  private void zzN(Map<String, List<String>> paramMap)
  {
    zzTM = zzc(paramMap, "Set-Cookie");
  }
  
  private void zzO(Map<String, List<String>> paramMap)
  {
    paramMap = zzc(paramMap, "X-Afma-Safe-Browsing");
    if (TextUtils.isEmpty(paramMap)) {
      return;
    }
    try
    {
      zzTQ = zzon.zzi(new JSONObject(paramMap));
      return;
    }
    catch (JSONException paramMap)
    {
      zzpe.zzc("Error parsing safe browsing header", paramMap);
    }
  }
  
  static String zzc(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  static long zzd(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f = Float.parseFloat(paramMap);
        return (f * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        zzpe.zzbe(String.valueOf(paramString).length() + 36 + String.valueOf(paramMap).length() + "Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  static List<String> zze(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (paramMap != null) {
        return Arrays.asList(paramMap.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private boolean zzf(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    return (paramMap != null) && (!paramMap.isEmpty()) && (Boolean.valueOf((String)paramMap.get(0)).booleanValue());
  }
  
  private void zzl(Map<String, List<String>> paramMap)
  {
    zzTo = zzc(paramMap, "X-Afma-Ad-Size");
  }
  
  private void zzm(Map<String, List<String>> paramMap)
  {
    zzTP = zzc(paramMap, "X-Afma-Ad-Slot-Size");
  }
  
  private void zzn(Map<String, List<String>> paramMap)
  {
    paramMap = zze(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      zzTq = paramMap;
    }
  }
  
  private void zzo(Map<String, List<String>> paramMap)
  {
    zzTr = zzc(paramMap, "X-Afma-Debug-Signals");
  }
  
  private void zzp(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      zzTs = ((String)paramMap.get(0));
    }
  }
  
  private void zzq(Map<String, List<String>> paramMap)
  {
    paramMap = zze(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      zzTu = paramMap;
    }
  }
  
  private void zzr(Map<String, List<String>> paramMap)
  {
    long l = zzd(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      zzTv = l;
    }
  }
  
  private void zzs(Map<String, List<String>> paramMap)
  {
    zzTt = zzc(paramMap, "X-Afma-ActiveView");
  }
  
  private void zzt(Map<String, List<String>> paramMap)
  {
    zzTA = "native".equals(zzc(paramMap, "X-Afma-Ad-Format"));
  }
  
  private void zzu(Map<String, List<String>> paramMap)
  {
    zzTz |= zzf(paramMap, "X-Afma-Custom-Rendering-Allowed");
  }
  
  private void zzv(Map<String, List<String>> paramMap)
  {
    zzTw |= zzf(paramMap, "X-Afma-Mediation");
  }
  
  private void zzw(Map<String, List<String>> paramMap)
  {
    zzTO |= zzf(paramMap, "X-Afma-Render-In-Browser");
  }
  
  private void zzx(Map<String, List<String>> paramMap)
  {
    paramMap = zze(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      zzQe = paramMap;
    }
  }
  
  private void zzy(Map<String, List<String>> paramMap)
  {
    long l = zzd(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      zzTy = l;
    }
  }
  
  private void zzz(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label58;
      }
      mOrientation = zzv.zzcL().zzkq();
    }
    label58:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    mOrientation = zzv.zzcL().zzkp();
  }
  
  public void zzb(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    zzFU = paramString2;
    zzk(paramMap);
  }
  
  public zzmk zzj(long paramLong)
  {
    return new zzmk(zzKG, zzTp, zzFU, zzTq, zzTu, zzTv, zzTw, -1L, zzQe, zzTy, mOrientation, zzTo, paramLong, zzTs, zzTt, zzTz, zzTA, zzTB, zzTC, false, zzTE, zzTF, zzKs, zzTG, zzTH, zzTI, zzTJ, zzTK, zzTL, zzTM, zzTN, zzTO, zzTP, zzTQ, zzTr, zzTD);
  }
  
  public void zzk(Map<String, List<String>> paramMap)
  {
    zzl(paramMap);
    zzm(paramMap);
    zzn(paramMap);
    zzo(paramMap);
    zzp(paramMap);
    zzq(paramMap);
    zzr(paramMap);
    zzv(paramMap);
    zzx(paramMap);
    zzy(paramMap);
    zzz(paramMap);
    zzs(paramMap);
    zzA(paramMap);
    zzu(paramMap);
    zzt(paramMap);
    zzB(paramMap);
    zzC(paramMap);
    zzD(paramMap);
    zzE(paramMap);
    zzF(paramMap);
    zzG(paramMap);
    zzH(paramMap);
    zzI(paramMap);
    zzJ(paramMap);
    zzK(paramMap);
    zzN(paramMap);
    zzM(paramMap);
    zzL(paramMap);
    zzO(paramMap);
    zzw(paramMap);
  }
}
