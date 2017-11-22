package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SnackbarManager
{
  private static final int LONG_DURATION_MS = 2750;
  static final int MSG_TIMEOUT = 0;
  private static final int SHORT_DURATION_MS = 1500;
  private static SnackbarManager sSnackbarManager;
  private SnackbarRecord mCurrentSnackbar;
  private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (what)
      {
      default: 
        return false;
      }
      handleTimeout((SnackbarManager.SnackbarRecord)obj);
      return true;
    }
  });
  private final Object mLock = new Object();
  private SnackbarRecord mNextSnackbar;
  
  private SnackbarManager() {}
  
  private boolean cancelSnackbarLocked(SnackbarRecord paramSnackbarRecord, int paramInt)
  {
    Callback localCallback = (Callback)callback.get();
    if (localCallback != null)
    {
      mHandler.removeCallbacksAndMessages(paramSnackbarRecord);
      localCallback.dismiss(paramInt);
      return true;
    }
    return false;
  }
  
  static SnackbarManager getInstance()
  {
    if (sSnackbarManager == null) {
      sSnackbarManager = new SnackbarManager();
    }
    return sSnackbarManager;
  }
  
  private boolean isCurrentSnackbarLocked(Callback paramCallback)
  {
    return (mCurrentSnackbar != null) && (mCurrentSnackbar.isSnackbar(paramCallback));
  }
  
  private boolean isNextSnackbarLocked(Callback paramCallback)
  {
    return (mNextSnackbar != null) && (mNextSnackbar.isSnackbar(paramCallback));
  }
  
  private void scheduleTimeoutLocked(SnackbarRecord paramSnackbarRecord)
  {
    if (duration == -2) {
      return;
    }
    int i = 2750;
    if (duration > 0) {
      i = duration;
    }
    for (;;)
    {
      mHandler.removeCallbacksAndMessages(paramSnackbarRecord);
      mHandler.sendMessageDelayed(Message.obtain(mHandler, 0, paramSnackbarRecord), i);
      return;
      if (duration == -1) {
        i = 1500;
      }
    }
  }
  
  private void showNextSnackbarLocked()
  {
    if (mNextSnackbar != null)
    {
      mCurrentSnackbar = mNextSnackbar;
      mNextSnackbar = null;
      Callback localCallback = (Callback)mCurrentSnackbar.callback.get();
      if (localCallback != null) {
        localCallback.show();
      }
    }
    else
    {
      return;
    }
    mCurrentSnackbar = null;
  }
  
  public void cancelTimeout(Callback paramCallback)
  {
    synchronized (mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback)) {
        mHandler.removeCallbacksAndMessages(mCurrentSnackbar);
      }
      return;
    }
  }
  
  public void dismiss(Callback paramCallback, int paramInt)
  {
    synchronized (mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback)) {
        cancelSnackbarLocked(mCurrentSnackbar, paramInt);
      }
      while (!isNextSnackbarLocked(paramCallback)) {
        return;
      }
      cancelSnackbarLocked(mNextSnackbar, paramInt);
    }
  }
  
  void handleTimeout(SnackbarRecord paramSnackbarRecord)
  {
    synchronized (mLock)
    {
      if ((mCurrentSnackbar == paramSnackbarRecord) || (mNextSnackbar == paramSnackbarRecord)) {
        cancelSnackbarLocked(paramSnackbarRecord, 2);
      }
      return;
    }
  }
  
  public boolean isCurrent(Callback paramCallback)
  {
    synchronized (mLock)
    {
      boolean bool = isCurrentSnackbarLocked(paramCallback);
      return bool;
    }
  }
  
  public boolean isCurrentOrNext(Callback paramCallback)
  {
    for (;;)
    {
      synchronized (mLock)
      {
        if (!isCurrentSnackbarLocked(paramCallback))
        {
          if (!isNextSnackbarLocked(paramCallback)) {
            break label40;
          }
          break label35;
          return bool;
        }
      }
      label35:
      boolean bool = true;
      continue;
      label40:
      bool = false;
    }
  }
  
  public void onDismissed(Callback paramCallback)
  {
    synchronized (mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
      {
        mCurrentSnackbar = null;
        if (mNextSnackbar != null) {
          showNextSnackbarLocked();
        }
      }
      return;
    }
  }
  
  public void onShown(Callback paramCallback)
  {
    synchronized (mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback)) {
        scheduleTimeoutLocked(mCurrentSnackbar);
      }
      return;
    }
  }
  
  public void restoreTimeout(Callback paramCallback)
  {
    synchronized (mLock)
    {
      if (isCurrentSnackbarLocked(paramCallback)) {
        scheduleTimeoutLocked(mCurrentSnackbar);
      }
      return;
    }
  }
  
  public void show(int paramInt, Callback paramCallback)
  {
    for (;;)
    {
      synchronized (mLock)
      {
        if (isCurrentSnackbarLocked(paramCallback))
        {
          mCurrentSnackbar.duration = paramInt;
          mHandler.removeCallbacksAndMessages(mCurrentSnackbar);
          scheduleTimeoutLocked(mCurrentSnackbar);
          return;
        }
        if (isNextSnackbarLocked(paramCallback))
        {
          mNextSnackbar.duration = paramInt;
          if ((mCurrentSnackbar == null) || (!cancelSnackbarLocked(mCurrentSnackbar, 4))) {
            break;
          }
          return;
        }
      }
      mNextSnackbar = new SnackbarRecord(paramInt, paramCallback);
    }
    mCurrentSnackbar = null;
    showNextSnackbarLocked();
  }
  
  static abstract interface Callback
  {
    public abstract void dismiss(int paramInt);
    
    public abstract void show();
  }
  
  private static class SnackbarRecord
  {
    final WeakReference<SnackbarManager.Callback> callback;
    int duration;
    
    SnackbarRecord(int paramInt, SnackbarManager.Callback paramCallback)
    {
      callback = new WeakReference(paramCallback);
      duration = paramInt;
    }
    
    boolean isSnackbar(SnackbarManager.Callback paramCallback)
    {
      return (paramCallback != null) && (callback.get() == paramCallback);
    }
  }
}
