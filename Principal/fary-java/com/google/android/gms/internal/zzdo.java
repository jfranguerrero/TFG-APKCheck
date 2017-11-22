package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@zzmb
public class zzdo
  extends zza
{
  public static final Parcelable.Creator<zzdo> CREATOR = new zzdp();
  @Nullable
  public final String url;
  public final int version;
  public final String zzyA;
  public final Bundle zzyB;
  public final boolean zzyC;
  public final long zzyx;
  public final String zzyy;
  public final String zzyz;
  
  zzdo(int paramInt, @Nullable String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, Bundle paramBundle, boolean paramBoolean)
  {
    version = paramInt;
    url = paramString1;
    zzyx = paramLong;
    if (paramString2 != null)
    {
      zzyy = paramString2;
      if (paramString3 == null) {
        break label77;
      }
      label35:
      zzyz = paramString3;
      if (paramString4 == null) {
        break label84;
      }
      label46:
      zzyA = paramString4;
      if (paramBundle == null) {
        break label91;
      }
    }
    for (;;)
    {
      zzyB = paramBundle;
      zzyC = paramBoolean;
      return;
      paramString2 = "";
      break;
      label77:
      paramString3 = "";
      break label35;
      label84:
      paramString4 = "";
      break label46;
      label91:
      paramBundle = new Bundle();
    }
  }
  
  @Nullable
  public static zzdo zzJ(String paramString)
  {
    return zze(Uri.parse(paramString));
  }
  
  @Nullable
  public static zzdo zze(Uri paramUri)
  {
    try
    {
      if (!"gcache".equals(paramUri.getScheme())) {
        return null;
      }
      localObject1 = paramUri.getPathSegments();
      if (((List)localObject1).size() != 2)
      {
        int i = ((List)localObject1).size();
        zzpe.zzbe(62 + "Expected 2 path parts for namespace and id, found :" + i);
        return null;
      }
      str1 = (String)((List)localObject1).get(0);
      localObject1 = (String)((List)localObject1).get(1);
      str2 = paramUri.getHost();
      str3 = paramUri.getQueryParameter("url");
      bool = "1".equals(paramUri.getQueryParameter("read_only"));
      localObject2 = paramUri.getQueryParameter("expiration");
      if (localObject2 != null) {
        break label220;
      }
      l = 0L;
    }
    catch (NullPointerException paramUri)
    {
      Object localObject1;
      String str1;
      String str2;
      String str3;
      boolean bool;
      Object localObject2;
      long l;
      for (;;)
      {
        Iterator localIterator;
        zzpe.zzc("Unable to parse Uri into cache offering.", paramUri);
        return null;
        l = Long.parseLong((String)localObject2);
      }
      paramUri = new zzdo(1, str3, l, str2, str1, (String)localObject1, (Bundle)localObject2, bool);
      return paramUri;
    }
    catch (NumberFormatException paramUri)
    {
      label220:
      for (;;) {}
    }
    localObject2 = new Bundle();
    localIterator = zzv.zzcL().zzh(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str4 = (String)localIterator.next();
      if (str4.startsWith("tag.")) {
        ((Bundle)localObject2).putString(str4.substring("tag.".length()), paramUri.getQueryParameter(str4));
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzdp.zza(this, paramParcel, paramInt);
  }
}
