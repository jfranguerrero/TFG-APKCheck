package com.google.android.gms.internal;

public final class zzapr
{
  private static zzapr zzaWJ;
  private final zzapo zzaWK = new zzapo();
  private final zzapp zzaWL = new zzapp();
  
  static
  {
    zza(new zzapr());
  }
  
  private zzapr() {}
  
  private static zzapr zzCP()
  {
    try
    {
      zzapr localZzapr = zzaWJ;
      return localZzapr;
    }
    finally {}
  }
  
  public static zzapo zzCQ()
  {
    return zzCPzzaWK;
  }
  
  public static zzapp zzCR()
  {
    return zzCPzzaWL;
  }
  
  protected static void zza(zzapr paramZzapr)
  {
    try
    {
      zzaWJ = paramZzapr;
      return;
    }
    finally {}
  }
}
