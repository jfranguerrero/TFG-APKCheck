package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends zza
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  private static Comparator<Scope> zzajc = new Comparator()
  {
    public int zza(Scope paramAnonymousScope1, Scope paramAnonymousScope2)
    {
      return paramAnonymousScope1.zzuS().compareTo(paramAnonymousScope2.zzuS());
    }
  };
  public static final Scope zzajd = new Scope("profile");
  public static final Scope zzaje = new Scope("email");
  public static final Scope zzajf = new Scope("openid");
  final int versionCode;
  private Account zzagg;
  private final ArrayList<Scope> zzajg;
  private boolean zzajh;
  private final boolean zzaji;
  private final boolean zzajj;
  private String zzajk;
  private String zzajl;
  
  static
  {
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    versionCode = paramInt;
    zzajg = paramArrayList;
    zzagg = paramAccount;
    zzajh = paramBoolean1;
    zzaji = paramBoolean2;
    zzajj = paramBoolean3;
    zzajk = paramString1;
    zzajl = paramString2;
  }
  
  private GoogleSignInOptions(Set<Scope> paramSet, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this(2, new ArrayList(paramSet), paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2);
  }
  
  @Nullable
  public static GoogleSignInOptions zzcw(@Nullable String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null) {
      return new GoogleSignInOptions(localHashSet, paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null));
    }
  }
  
  private JSONObject zzqI()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(zzajg, zzajc);
      Iterator localIterator = zzajg.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzuS());
      }
      localJSONException.put("scopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    if (zzagg != null) {
      localJSONException.put("accountName", zzagg.name);
    }
    localJSONException.put("idTokenRequested", zzajh);
    localJSONException.put("forceCodeForRefreshToken", zzajj);
    localJSONException.put("serverAuthRequested", zzaji);
    if (!TextUtils.isEmpty(zzajk)) {
      localJSONException.put("serverClientId", zzajk);
    }
    if (!TextUtils.isEmpty(zzajl)) {
      localJSONException.put("hostedDomain", zzajl);
    }
    return localJSONException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        if ((zzajg.size() != paramObject.zzqJ().size()) || (!zzajg.containsAll(paramObject.zzqJ()))) {
          continue;
        }
        if (zzagg == null)
        {
          if (paramObject.getAccount() != null) {
            continue;
          }
          label56:
          if (!TextUtils.isEmpty(zzajk)) {
            break label128;
          }
          if (!TextUtils.isEmpty(paramObject.zzqN())) {
            continue;
          }
        }
        while ((zzajj == paramObject.zzqM()) && (zzajh == paramObject.zzqK()) && (zzaji == paramObject.zzqL()))
        {
          return true;
          if (!zzagg.equals(paramObject.getAccount())) {
            break;
          }
          break label56;
          label128:
          boolean bool = zzajk.equals(paramObject.zzqN());
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public Account getAccount()
  {
    return zzagg;
  }
  
  public Scope[] getScopeArray()
  {
    return (Scope[])zzajg.toArray(new Scope[zzajg.size()]);
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzajg.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).zzuS());
    }
    Collections.sort(localArrayList);
    return new zzf().zzq(localArrayList).zzq(zzagg).zzq(zzajk).zzad(zzajj).zzad(zzajh).zzad(zzaji).zzqV();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzqG()
  {
    return zzqI().toString();
  }
  
  public ArrayList<Scope> zzqJ()
  {
    return new ArrayList(zzajg);
  }
  
  public boolean zzqK()
  {
    return zzajh;
  }
  
  public boolean zzqL()
  {
    return zzaji;
  }
  
  public boolean zzqM()
  {
    return zzajj;
  }
  
  public String zzqN()
  {
    return zzajk;
  }
  
  public String zzqO()
  {
    return zzajl;
  }
  
  public static final class Builder
  {
    private Account zzagg;
    private boolean zzajh;
    private boolean zzaji;
    private boolean zzajj;
    private String zzajk;
    private String zzajl;
    private Set<Scope> zzajm = new HashSet();
    
    public Builder() {}
    
    public Builder(@NonNull GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzac.zzw(paramGoogleSignInOptions);
      zzajm = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
      zzaji = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      zzajj = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      zzajh = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      zzajk = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      zzagg = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
      zzajl = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
    }
    
    private String zzcx(String paramString)
    {
      zzac.zzdv(paramString);
      if ((zzajk == null) || (zzajk.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }
    
    public GoogleSignInOptions build()
    {
      if ((zzajh) && ((zzagg == null) || (!zzajm.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(zzajm, zzagg, zzajh, zzaji, zzajj, zzajk, zzajl, null);
    }
    
    public Builder requestEmail()
    {
      zzajm.add(GoogleSignInOptions.zzaje);
      return this;
    }
    
    public Builder requestId()
    {
      zzajm.add(GoogleSignInOptions.zzajf);
      return this;
    }
    
    public Builder requestIdToken(String paramString)
    {
      zzajh = true;
      zzajk = zzcx(paramString);
      return this;
    }
    
    public Builder requestProfile()
    {
      zzajm.add(GoogleSignInOptions.zzajd);
      return this;
    }
    
    public Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      zzajm.add(paramScope);
      zzajm.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }
    
    public Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      zzaji = true;
      zzajk = zzcx(paramString);
      zzajj = paramBoolean;
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      zzagg = new Account(zzac.zzdv(paramString), "com.google");
      return this;
    }
    
    public Builder setHostedDomain(String paramString)
    {
      zzajl = zzac.zzdv(paramString);
      return this;
    }
  }
}
