package android.support.v4.hardware.fingerprint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@TargetApi(23)
@RequiresApi(23)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class FingerprintManagerCompatApi23
{
  public FingerprintManagerCompatApi23() {}
  
  public static void authenticate(Context paramContext, CryptoObject paramCryptoObject, int paramInt, Object paramObject, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    paramContext = getFingerprintManagerOrNull(paramContext);
    if (paramContext != null) {
      paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
    }
  }
  
  private static FingerprintManager getFingerprintManagerOrNull(Context paramContext)
  {
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    paramContext = getFingerprintManagerOrNull(paramContext);
    return (paramContext != null) && (paramContext.hasEnrolledFingerprints());
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    paramContext = getFingerprintManagerOrNull(paramContext);
    return (paramContext != null) && (paramContext.isHardwareDetected());
  }
  
  private static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new CryptoObject(paramCryptoObject.getMac());
  }
  
  private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    new FingerprintManager.AuthenticationCallback()
    {
      public void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
      }
      
      public void onAuthenticationFailed()
      {
        val$callback.onAuthenticationFailed();
      }
      
      public void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
      }
      
      public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAnonymousAuthenticationResult)
      {
        val$callback.onAuthenticationSucceeded(new FingerprintManagerCompatApi23.AuthenticationResultInternal(FingerprintManagerCompatApi23.unwrapCryptoObject(paramAnonymousAuthenticationResult.getCryptoObject())));
      }
    };
  }
  
  private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
  }
  
  public static abstract class AuthenticationCallback
  {
    public AuthenticationCallback() {}
    
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal paramAuthenticationResultInternal) {}
  }
  
  public static final class AuthenticationResultInternal
  {
    private FingerprintManagerCompatApi23.CryptoObject mCryptoObject;
    
    public AuthenticationResultInternal(FingerprintManagerCompatApi23.CryptoObject paramCryptoObject)
    {
      mCryptoObject = paramCryptoObject;
    }
    
    public FingerprintManagerCompatApi23.CryptoObject getCryptoObject()
    {
      return mCryptoObject;
    }
  }
  
  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(Signature paramSignature)
    {
      mSignature = paramSignature;
      mCipher = null;
      mMac = null;
    }
    
    public CryptoObject(Cipher paramCipher)
    {
      mCipher = paramCipher;
      mSignature = null;
      mMac = null;
    }
    
    public CryptoObject(Mac paramMac)
    {
      mMac = paramMac;
      mCipher = null;
      mSignature = null;
    }
    
    public Cipher getCipher()
    {
      return mCipher;
    }
    
    public Mac getMac()
    {
      return mMac;
    }
    
    public Signature getSignature()
    {
      return mSignature;
    }
  }
}
