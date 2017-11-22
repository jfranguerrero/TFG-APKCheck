package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzaxo;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzg
{
  private final Set<Scope> zzaEb;
  private final Map<Api<?>, zza> zzaEc;
  private final zzaxo zzaEd;
  private Integer zzaEe;
  private final Account zzagg;
  private final String zzahp;
  private final Set<Scope> zzaxN;
  private final int zzaxP;
  private final View zzaxQ;
  private final String zzaxR;
  
  public zzg(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzaxo paramZzaxo)
  {
    zzagg = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      zzaxN = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      zzaEc = paramAccount;
      zzaxQ = paramView;
      zzaxP = paramInt;
      zzahp = paramString1;
      zzaxR = paramString2;
      zzaEd = paramZzaxo;
      paramAccount = new HashSet(zzaxN);
      paramSet = zzaEc.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(nextzzajm);
      }
    }
    zzaEb = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzg zzaA(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zzuP();
  }
  
  public Account getAccount()
  {
    return zzagg;
  }
  
  @Deprecated
  public String getAccountName()
  {
    if (zzagg != null) {
      return zzagg.name;
    }
    return null;
  }
  
  public Set<Scope> zzc(Api<?> paramApi)
  {
    paramApi = (zza)zzaEc.get(paramApi);
    if ((paramApi == null) || (zzajm.isEmpty())) {
      return zzaxN;
    }
    HashSet localHashSet = new HashSet(zzaxN);
    localHashSet.addAll(zzajm);
    return localHashSet;
  }
  
  public void zzc(Integer paramInteger)
  {
    zzaEe = paramInteger;
  }
  
  public Account zzwU()
  {
    if (zzagg != null) {
      return zzagg;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public int zzxd()
  {
    return zzaxP;
  }
  
  public Set<Scope> zzxe()
  {
    return zzaxN;
  }
  
  public Set<Scope> zzxf()
  {
    return zzaEb;
  }
  
  public Map<Api<?>, zza> zzxg()
  {
    return zzaEc;
  }
  
  public String zzxh()
  {
    return zzahp;
  }
  
  public String zzxi()
  {
    return zzaxR;
  }
  
  public View zzxj()
  {
    return zzaxQ;
  }
  
  public zzaxo zzxk()
  {
    return zzaEd;
  }
  
  public Integer zzxl()
  {
    return zzaEe;
  }
  
  public static final class zza
  {
    public final boolean zzaEf;
    public final Set<Scope> zzajm;
    
    public zza(Set<Scope> paramSet, boolean paramBoolean)
    {
      zzac.zzw(paramSet);
      zzajm = Collections.unmodifiableSet(paramSet);
      zzaEf = paramBoolean;
    }
  }
}
