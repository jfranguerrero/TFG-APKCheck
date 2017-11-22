package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

@zzmb
public class zzis
{
  private final LinkedList<zzit> zzIA = new LinkedList();
  @Nullable
  private zzip zzIB;
  private final Map<zzit, zziu> zzIz = new HashMap();
  
  public zzis() {}
  
  private static void zza(String paramString, zzit paramZzit)
  {
    if (zzpe.zzai(2)) {
      zzpe.v(String.format(paramString, new Object[] { paramZzit }));
    }
  }
  
  private String[] zzai(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\000");
      int i = 0;
      for (;;)
      {
        paramString = arrayOfString;
        if (i >= arrayOfString.length) {
          break;
        }
        arrayOfString[i] = new String(Base64.decode(arrayOfString[i], 0), "UTF-8");
        i += 1;
      }
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new String[0];
    }
  }
  
  private boolean zzaj(String paramString)
  {
    try
    {
      boolean bool = Pattern.matches((String)zzfx.zzCH.get(), paramString);
      return bool;
    }
    catch (RuntimeException paramString)
    {
      zzv.zzcN().zza(paramString, "InterstitialAdPool.isExcludedAdUnit");
    }
    return false;
  }
  
  private static void zzc(Bundle paramBundle, String paramString)
  {
    paramString = paramString.split("/", 2);
    if (paramString.length == 0) {}
    do
    {
      return;
      String str = paramString[0];
      if (paramString.length == 1)
      {
        paramBundle.remove(str);
        return;
      }
      paramBundle = paramBundle.getBundle(str);
    } while (paramBundle == null);
    zzc(paramBundle, paramString[1]);
  }
  
  private String zzgk()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = zzIA.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(Base64.encodeToString(((zzit)localIterator.next()).toString().getBytes("UTF-8"), 0));
        if (localIterator.hasNext()) {
          localStringBuilder.append("\000");
        }
      }
      str = localUnsupportedEncodingException.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return "";
    }
    String str;
    return str;
  }
  
  @Nullable
  static Bundle zzk(zzdy paramZzdy)
  {
    paramZzdy = zzyP;
    if (paramZzdy == null) {
      return null;
    }
    return paramZzdy.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
  }
  
  static zzdy zzl(zzdy paramZzdy)
  {
    zzdy localZzdy = zzo(paramZzdy);
    Bundle localBundle = zzk(localZzdy);
    paramZzdy = localBundle;
    if (localBundle == null)
    {
      paramZzdy = new Bundle();
      zzyP.putBundle("com.google.ads.mediation.admob.AdMobAdapter", paramZzdy);
    }
    paramZzdy.putBoolean("_skipMediation", true);
    return localZzdy;
  }
  
  static boolean zzm(zzdy paramZzdy)
  {
    paramZzdy = zzyP;
    if (paramZzdy == null) {}
    do
    {
      return false;
      paramZzdy = paramZzdy.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    } while ((paramZzdy == null) || (!paramZzdy.containsKey("_skipMediation")));
    return true;
  }
  
  private static zzdy zzn(zzdy paramZzdy)
  {
    paramZzdy = zzo(paramZzdy);
    String[] arrayOfString = ((String)zzfx.zzCD.get()).split(",");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      zzc(zzyP, str);
      i += 1;
    }
    return paramZzdy;
  }
  
  static zzdy zzo(zzdy paramZzdy)
  {
    Parcel localParcel = Parcel.obtain();
    paramZzdy.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramZzdy = (zzdy)zzdy.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    zzdy.zzj(paramZzdy);
    return paramZzdy;
  }
  
  void flush()
  {
    while (zzIA.size() > 0)
    {
      zzit localZzit = (zzit)zzIA.remove();
      zziu localZziu = (zziu)zzIz.get(localZzit);
      zza("Flushing interstitial queue for %s.", localZzit);
      while (localZziu.size() > 0) {
        zzpzzIG.zzck();
      }
      zzIz.remove(localZzit);
    }
  }
  
  void restore()
  {
    if (zzIB == null) {}
    for (;;)
    {
      return;
      Object localObject1 = zzIB.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
      flush();
      Object localObject2;
      try
      {
        HashMap localHashMap = new HashMap();
        localObject2 = ((SharedPreferences)localObject1).getAll().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (!((String)((Map.Entry)localObject3).getKey()).equals("PoolKeys"))
          {
            Object localObject4 = zziw.zzak((String)((Map.Entry)localObject3).getValue());
            localObject3 = new zzit(zzug, zztq, zzIE);
            if (!zzIz.containsKey(localObject3))
            {
              localObject4 = new zziu(zzug, zztq, zzIE);
              zzIz.put(localObject3, localObject4);
              localHashMap.put(((zzit)localObject3).toString(), localObject3);
              zza("Restored interstitial queue for %s.", (zzit)localObject3);
            }
          }
        }
        localObject1 = zzai(((SharedPreferences)localObject1).getString("PoolKeys", ""));
      }
      catch (Throwable localThrowable)
      {
        zzv.zzcN().zza(localThrowable, "InterstitialAdPool.restore");
        zzpe.zzc("Malformed preferences value for InterstitialAdPool.", localThrowable);
        zzIz.clear();
        zzIA.clear();
        return;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = (zzit)localThrowable.get(localObject1[i]);
        if (zzIz.containsKey(localObject2)) {
          zzIA.add(localObject2);
        }
        i += 1;
      }
    }
  }
  
  void save()
  {
    if (zzIB == null) {
      return;
    }
    SharedPreferences.Editor localEditor = zzIB.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
    localEditor.clear();
    Iterator localIterator = zzIz.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzit localZzit = (zzit)((Map.Entry)localObject).getKey();
      localObject = (zziu)((Map.Entry)localObject).getValue();
      if (((zziu)localObject).zzgp())
      {
        localObject = new zziw((zziu)localObject).zzgs();
        localEditor.putString(localZzit.toString(), (String)localObject);
        zza("Saved interstitial queue for %s.", localZzit);
      }
    }
    localEditor.putString("PoolKeys", zzgk());
    localEditor.apply();
  }
  
  @Nullable
  zziu.zza zza(zzdy paramZzdy, String paramString)
  {
    if (zzaj(paramString)) {
      return null;
    }
    int i = zznf.zzazzIB.getApplicationContext()).zzjn().zzUm;
    zzdy localZzdy = zzn(paramZzdy);
    zzit localZzit = new zzit(localZzdy, paramString, i);
    paramZzdy = (zziu)zzIz.get(localZzit);
    if (paramZzdy == null)
    {
      zza("Interstitial pool created at %s.", localZzit);
      paramZzdy = new zziu(localZzdy, paramString, i);
      zzIz.put(localZzit, paramZzdy);
    }
    for (;;)
    {
      zzIA.remove(localZzit);
      zzIA.add(localZzit);
      paramZzdy.zzgo();
      while (zzIA.size() > ((Integer)zzfx.zzCE.get()).intValue())
      {
        paramString = (zzit)zzIA.remove();
        zziu localZziu = (zziu)zzIz.get(paramString);
        zza("Evicting interstitial queue for %s.", paramString);
        while (localZziu.size() > 0) {
          zzpzzIG.zzck();
        }
        zzIz.remove(paramString);
      }
      while (paramZzdy.size() > 0)
      {
        paramString = paramZzdy.zzp(localZzdy);
        if ((zzIK) && (zzv.zzcP().currentTimeMillis() - zzIJ > 1000L * ((Integer)zzfx.zzCG.get()).intValue()))
        {
          zza("Expired interstitial at %s.", localZzit);
        }
        else
        {
          if (zzIH != null) {}
          for (paramZzdy = " (inline) ";; paramZzdy = " ")
          {
            zza(String.valueOf(paramZzdy).length() + 34 + "Pooled interstitial" + paramZzdy + "returned at %s.", localZzit);
            return paramString;
          }
        }
      }
      return null;
    }
  }
  
  void zza(zzip paramZzip)
  {
    if (zzIB == null)
    {
      zzIB = paramZzip.zzgi();
      restore();
    }
  }
  
  void zzb(zzdy paramZzdy, String paramString)
  {
    if (zzIB == null) {
      return;
    }
    int i = zznf.zzazzIB.getApplicationContext()).zzjn().zzUm;
    zzdy localZzdy = zzn(paramZzdy);
    zzit localZzit = new zzit(localZzdy, paramString, i);
    zziu localZziu2 = (zziu)zzIz.get(localZzit);
    zziu localZziu1 = localZziu2;
    if (localZziu2 == null)
    {
      zza("Interstitial pool created at %s.", localZzit);
      localZziu1 = new zziu(localZzdy, paramString, i);
      zzIz.put(localZzit, localZziu1);
    }
    localZziu1.zza(zzIB, paramZzdy);
    localZziu1.zzgo();
    zza("Inline entry added to the queue at %s.", localZzit);
  }
  
  void zzgj()
  {
    if (zzIB == null) {
      return;
    }
    Iterator localIterator = zzIz.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzit localZzit = (zzit)((Map.Entry)localObject).getKey();
      localObject = (zziu)((Map.Entry)localObject).getValue();
      if (zzpe.zzai(2))
      {
        int i = ((zziu)localObject).size();
        int j = ((zziu)localObject).zzgm();
        if (j < i) {
          zzpe.v(String.format("Loading %s/%s pooled interstitials for %s.", new Object[] { Integer.valueOf(i - j), Integer.valueOf(i), localZzit }));
        }
      }
      ((zziu)localObject).zzgn();
      while (((zziu)localObject).size() < ((Integer)zzfx.zzCF.get()).intValue())
      {
        zza("Pooling and loading one new interstitial for %s.", localZzit);
        ((zziu)localObject).zzb(zzIB);
      }
    }
    save();
  }
}
