package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

@TargetApi(14)
@RequiresApi(14)
class AppCompatDelegateImplV14
  extends AppCompatDelegateImplV11
{
  private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
  private boolean mApplyDayNightCalled;
  private AutoNightModeManager mAutoNightModeManager;
  private boolean mHandleNativeActionModes = true;
  private int mLocalNightMode = -100;
  
  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private void ensureAutoNightModeManager()
  {
    if (mAutoNightModeManager == null) {
      mAutoNightModeManager = new AutoNightModeManager(TwilightManager.getInstance(mContext));
    }
  }
  
  private int getNightMode()
  {
    if (mLocalNightMode != -100) {
      return mLocalNightMode;
    }
    return getDefaultNightMode();
  }
  
  private boolean shouldRecreateOnNightModeChange()
  {
    if ((mApplyDayNightCalled) && ((mContext instanceof Activity)))
    {
      PackageManager localPackageManager = mContext.getPackageManager();
      try
      {
        int i = getActivityInfoComponentNamemContext, mContext.getClass()), 0).configChanges;
        return (i & 0x200) == 0;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        return true;
      }
    }
    return false;
  }
  
  private boolean updateForNightMode(int paramInt)
  {
    Resources localResources = mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label109;
      }
      if (!shouldRecreateOnNightModeChange()) {
        break label61;
      }
      ((Activity)mContext).recreate();
    }
    for (;;)
    {
      return true;
      paramInt = 16;
      break;
      label61:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      uiMode = (uiMode & 0xFFFFFFCF | paramInt);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      ResourcesFlusher.flush(localResources);
    }
    label109:
    return false;
  }
  
  public boolean applyDayNight()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = mapNightMode(i);
    if (j != -1) {
      bool = updateForNightMode(j);
    }
    if (i == 0)
    {
      ensureAutoNightModeManager();
      mAutoNightModeManager.setup();
    }
    mApplyDayNightCalled = true;
    return bool;
  }
  
  @VisibleForTesting
  final AutoNightModeManager getAutoNightModeManager()
  {
    ensureAutoNightModeManager();
    return mAutoNightModeManager;
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return mHandleNativeActionModes;
  }
  
  int mapNightMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      ensureAutoNightModeManager();
      return mAutoNightModeManager.getApplyableNightMode();
    }
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (mLocalNightMode == -100)) {
      mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (mAutoNightModeManager != null) {
      mAutoNightModeManager.cleanup();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mLocalNightMode != -100) {
      paramBundle.putInt("appcompat:local_night_mode", mLocalNightMode);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    applyDayNight();
  }
  
  public void onStop()
  {
    super.onStop();
    if (mAutoNightModeManager != null) {
      mAutoNightModeManager.cleanup();
    }
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    mHandleNativeActionModes = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
      do
      {
        return;
      } while (mLocalNightMode == paramInt);
      mLocalNightMode = paramInt;
    } while (!mApplyDayNightCalled);
    applyDayNight();
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackV14(paramCallback);
  }
  
  class AppCompatWindowCallbackV14
    extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase
  {
    AppCompatWindowCallbackV14(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (isHandleNativeActionModesEnabled()) {
        return startAsSupportActionMode(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback paramCallback)
    {
      paramCallback = new SupportActionModeWrapper.CallbackWrapper(mContext, paramCallback);
      android.support.v7.view.ActionMode localActionMode = startSupportActionMode(paramCallback);
      if (localActionMode != null) {
        return paramCallback.getActionModeWrapper(localActionMode);
      }
      return null;
    }
  }
  
  @VisibleForTesting
  final class AutoNightModeManager
  {
    private BroadcastReceiver mAutoTimeChangeReceiver;
    private IntentFilter mAutoTimeChangeReceiverFilter;
    private boolean mIsNight;
    private TwilightManager mTwilightManager;
    
    AutoNightModeManager(TwilightManager paramTwilightManager)
    {
      mTwilightManager = paramTwilightManager;
      mIsNight = paramTwilightManager.isNight();
    }
    
    final void cleanup()
    {
      if (mAutoTimeChangeReceiver != null)
      {
        mContext.unregisterReceiver(mAutoTimeChangeReceiver);
        mAutoTimeChangeReceiver = null;
      }
    }
    
    final void dispatchTimeChanged()
    {
      boolean bool = mTwilightManager.isNight();
      if (bool != mIsNight)
      {
        mIsNight = bool;
        applyDayNight();
      }
    }
    
    final int getApplyableNightMode()
    {
      mIsNight = mTwilightManager.isNight();
      if (mIsNight) {
        return 2;
      }
      return 1;
    }
    
    final void setup()
    {
      cleanup();
      if (mAutoTimeChangeReceiver == null) {
        mAutoTimeChangeReceiver = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            dispatchTimeChanged();
          }
        };
      }
      if (mAutoTimeChangeReceiverFilter == null)
      {
        mAutoTimeChangeReceiverFilter = new IntentFilter();
        mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_SET");
        mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
      }
      mContext.registerReceiver(mAutoTimeChangeReceiver, mAutoTimeChangeReceiverFilter);
    }
  }
}
