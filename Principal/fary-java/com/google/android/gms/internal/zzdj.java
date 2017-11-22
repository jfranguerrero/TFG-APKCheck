package com.google.android.gms.internal;

import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@zzmb
public class zzdj
{
  private final int zzyd;
  private final zzdd zzyf;
  private String zzyn;
  private String zzyo;
  private final boolean zzyp;
  private final int zzyq;
  private final int zzyr;
  
  public zzdj(int paramInt1, int paramInt2, int paramInt3)
  {
    zzyd = paramInt1;
    zzyp = false;
    if ((paramInt2 > 64) || (paramInt2 < 0))
    {
      zzyq = 64;
      if (paramInt3 >= 1) {
        break label64;
      }
    }
    label64:
    for (zzyr = 1;; zzyr = paramInt3)
    {
      zzyf = new zzdi(zzyq);
      return;
      zzyq = paramInt2;
      break;
    }
  }
  
  String zza(String paramString, char paramChar)
  {
    paramString = new StringBuilder(paramString);
    int j = 0;
    int i = 1;
    if (i + 2 <= paramString.length())
    {
      int k = i;
      if (paramString.charAt(i) == '\'')
      {
        if ((paramString.charAt(i - 1) == paramChar) || ((paramString.charAt(i + 1) != 's') && (paramString.charAt(i + 1) != 'S')) || ((i + 2 != paramString.length()) && (paramString.charAt(i + 2) != paramChar))) {
          break label118;
        }
        paramString.insert(i, paramChar);
        i += 2;
      }
      for (;;)
      {
        j = 1;
        k = i;
        i = k + 1;
        break;
        label118:
        paramString.setCharAt(i, paramChar);
      }
    }
    if (j != 0) {
      return paramString.toString();
    }
    return null;
  }
  
  public String zza(ArrayList<String> paramArrayList, ArrayList<zzdc> paramArrayList1)
  {
    Collections.sort(paramArrayList1, new zza());
    Object localObject = new HashSet();
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayList1.size()) || (!zza(Normalizer.normalize((CharSequence)paramArrayList.get(((zzdc)paramArrayList1.get(i)).zzen()), Normalizer.Form.NFKC).toLowerCase(Locale.US), (HashSet)localObject)))
      {
        paramArrayList = new zzde.zza();
        zzyn = "";
        paramArrayList1 = ((HashSet)localObject).iterator();
        for (;;)
        {
          if (paramArrayList1.hasNext())
          {
            localObject = (String)paramArrayList1.next();
            try
            {
              paramArrayList.write(zzyf.zzF((String)localObject));
            }
            catch (IOException paramArrayList1)
            {
              zzpe.zzb("Error while writing hash to byteStream", paramArrayList1);
            }
          }
        }
        return paramArrayList.toString();
      }
      i += 1;
    }
  }
  
  boolean zza(String paramString, HashSet<String> paramHashSet)
  {
    boolean bool2 = false;
    String[] arrayOfString1 = paramString.split("\n");
    boolean bool1;
    if (arrayOfString1.length == 0)
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    label25:
    String str;
    if (i < arrayOfString1.length)
    {
      paramString = arrayOfString1[i];
      if (paramString.indexOf("'") == -1) {
        break label264;
      }
      str = zza(paramString, ' ');
      if (str == null) {
        break label264;
      }
      zzyo = str;
      paramString = str;
    }
    label87:
    label97:
    label152:
    label258:
    label264:
    for (;;)
    {
      String[] arrayOfString2 = zzdf.zzd(paramString, true);
      if (arrayOfString2.length < zzyr)
      {
        i += 1;
        break label25;
      }
      int j = 0;
      if (j < arrayOfString2.length)
      {
        paramString = "";
        k = 0;
        if (k >= zzyr) {
          break label258;
        }
        if (j + k < arrayOfString2.length) {
          break label152;
        }
      }
      for (int k = 0;; k = 1)
      {
        if (k == 0)
        {
          if (paramHashSet.size() < zzyd) {
            break label87;
          }
          return false;
          str = paramString;
          if (k > 0) {
            str = String.valueOf(paramString).concat(" ");
          }
          paramString = String.valueOf(str);
          str = String.valueOf(arrayOfString2[(j + k)]);
          if (str.length() != 0) {}
          for (paramString = paramString.concat(str);; paramString = new String(paramString))
          {
            k += 1;
            break;
          }
        }
        paramHashSet.add(paramString);
        bool1 = bool2;
        if (paramHashSet.size() >= zzyd) {
          break;
        }
        j += 1;
        break label97;
        return true;
      }
    }
  }
  
  public class zza
    implements Comparator<zzdc>
  {
    public zza() {}
    
    public int zza(zzdc paramZzdc1, zzdc paramZzdc2)
    {
      if (paramZzdc1.zzek() < paramZzdc2.zzek()) {}
      float f1;
      float f2;
      do
      {
        do
        {
          return -1;
          if (paramZzdc1.zzek() > paramZzdc2.zzek()) {
            return 1;
          }
        } while (paramZzdc1.zzej() < paramZzdc2.zzej());
        if (paramZzdc1.zzej() > paramZzdc2.zzej()) {
          return 1;
        }
        f1 = (paramZzdc1.zzem() - paramZzdc1.zzek()) * (paramZzdc1.zzel() - paramZzdc1.zzej());
        f2 = (paramZzdc2.zzem() - paramZzdc2.zzek()) * (paramZzdc2.zzel() - paramZzdc2.zzej());
      } while (f1 > f2);
      if (f1 < f2) {
        return 1;
      }
      return 0;
    }
  }
}
