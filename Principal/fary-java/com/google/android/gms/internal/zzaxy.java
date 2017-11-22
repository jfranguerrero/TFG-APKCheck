package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf.zzi;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzr;

public class zzaxy
  extends com.google.android.gms.common.internal.zzl<zzaxv>
  implements zzaxn
{
  private Integer zzaEe;
  private final zzg zzazs;
  private final Bundle zzbCf;
  private final boolean zzbCq;
  
  public zzaxy(Context paramContext, Looper paramLooper, boolean paramBoolean, zzg paramZzg, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramZzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzbCq = paramBoolean;
    zzazs = paramZzg;
    zzbCf = paramBundle;
    zzaEe = paramZzg.zzxl();
  }
  
  public zzaxy(Context paramContext, Looper paramLooper, boolean paramBoolean, zzg paramZzg, zzaxo paramZzaxo, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramBoolean, paramZzg, zza(paramZzg), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private zzad zzOn()
  {
    Account localAccount = zzazs.zzwU();
    GoogleSignInAccount localGoogleSignInAccount = null;
    if ("<<default account>>".equals(name)) {
      localGoogleSignInAccount = com.google.android.gms.auth.api.signin.internal.zzl.zzaa(getContext()).zzrc();
    }
    return new zzad(localAccount, zzaEe.intValue(), localGoogleSignInAccount);
  }
  
  public static Bundle zza(zzg paramZzg)
  {
    zzaxo localZzaxo = paramZzg.zzxk();
    Integer localInteger = paramZzg.zzxl();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramZzg.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localZzaxo != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localZzaxo.zzOf());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localZzaxo.zzqK());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localZzaxo.zzqN());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localZzaxo.zzqM());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localZzaxo.zzqO());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localZzaxo.zzOg());
      if (localZzaxo.zzOh() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localZzaxo.zzOh().longValue());
      }
      if (localZzaxo.zzOi() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localZzaxo.zzOi().longValue());
      }
    }
    return localBundle;
  }
  
  public void connect()
  {
    zza(new zzf.zzi(this));
  }
  
  public void zzOe()
  {
    try
    {
      ((zzaxv)zzwW()).zzmK(zzaEe.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  public void zza(zzr paramZzr, boolean paramBoolean)
  {
    try
    {
      ((zzaxv)zzwW()).zza(paramZzr, zzaEe.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramZzr)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public void zza(zzaxu paramZzaxu)
  {
    zzac.zzb(paramZzaxu, "Expecting a valid ISignInCallbacks");
    try
    {
      zzad localZzad = zzOn();
      ((zzaxv)zzwW()).zza(new zzaxz(localZzad), paramZzaxu);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        paramZzaxu.zzb(new zzayb(8));
        return;
      }
      catch (RemoteException paramZzaxu)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  protected zzaxv zzeZ(IBinder paramIBinder)
  {
    return zzaxv.zza.zzeY(paramIBinder);
  }
  
  protected String zzeu()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected String zzev()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public boolean zzqD()
  {
    return zzbCq;
  }
  
  protected Bundle zzql()
  {
    String str = zzazs.zzxh();
    if (!getContext().getPackageName().equals(str)) {
      zzbCf.putString("com.google.android.gms.signin.internal.realClientPackageName", zzazs.zzxh());
    }
    return zzbCf;
  }
}
