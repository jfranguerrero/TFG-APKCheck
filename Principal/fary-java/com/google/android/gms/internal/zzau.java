package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzau
  extends zzat
{
  private static final String TAG = zzau.class.getSimpleName();
  
  protected zzau(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramString, paramBoolean);
  }
  
  public static zzau zza(String paramString, Context paramContext, boolean paramBoolean)
  {
    zza(paramContext, paramBoolean);
    return new zzau(paramContext, paramString, paramBoolean);
  }
  
  protected List<Callable<Void>> zzb(zzbc paramZzbc, zzaf.zza paramZza, zzad.zza paramZza1)
  {
    if ((paramZzbc.zzaJ() == null) || (!zzpX)) {
      return super.zzb(paramZzbc, paramZza, paramZza1);
    }
    int i = paramZzbc.zzT();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(super.zzb(paramZzbc, paramZza, paramZza1));
    localArrayList.add(new zzbm(paramZzbc, zzay.zzaj(), zzay.zzak(), paramZza, i, 24));
    return localArrayList;
  }
}
