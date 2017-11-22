package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.SupportActivity;
import android.support.v4.app.SupportActivity.ExtraData;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat
{
  static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
  static final String TAG = "MediaControllerCompat";
  private final MediaControllerImpl mImpl;
  private final MediaSessionCompat.Token mToken;
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
    throws RemoteException
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    mToken = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      mImpl = new MediaControllerImplApi24(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      mImpl = new MediaControllerImplApi23(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      mImpl = new MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    mImpl = new MediaControllerImplBase(mToken);
  }
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
  {
    if (paramMediaSessionCompat == null) {
      throw new IllegalArgumentException("session must not be null");
    }
    mToken = paramMediaSessionCompat.getSessionToken();
    if (Build.VERSION.SDK_INT >= 24)
    {
      mImpl = new MediaControllerImplApi24(paramContext, paramMediaSessionCompat);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      mImpl = new MediaControllerImplApi23(paramContext, paramMediaSessionCompat);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      mImpl = new MediaControllerImplApi21(paramContext, paramMediaSessionCompat);
      return;
    }
    mImpl = new MediaControllerImplBase(mToken);
  }
  
  public static MediaControllerCompat getMediaController(Activity paramActivity)
  {
    Object localObject2 = null;
    if ((paramActivity instanceof SupportActivity))
    {
      paramActivity = (MediaControllerExtraData)((SupportActivity)paramActivity).getExtraData(MediaControllerExtraData.class);
      localObject1 = localObject2;
      if (paramActivity != null) {
        localObject1 = paramActivity.getMediaController();
      }
    }
    Object localObject3;
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (Build.VERSION.SDK_INT < 21);
      localObject3 = MediaControllerCompatApi21.getMediaController(paramActivity);
      localObject1 = localObject2;
    } while (localObject3 == null);
    Object localObject1 = MediaControllerCompatApi21.getSessionToken(localObject3);
    try
    {
      paramActivity = new MediaControllerCompat(paramActivity, MediaSessionCompat.Token.fromToken(localObject1));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      Log.e("MediaControllerCompat", "Dead object in getMediaController. " + paramActivity);
    }
    return null;
  }
  
  public static void setMediaController(Activity paramActivity, MediaControllerCompat paramMediaControllerCompat)
  {
    if ((paramActivity instanceof SupportActivity)) {
      ((SupportActivity)paramActivity).putExtraData(new MediaControllerExtraData(paramMediaControllerCompat));
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = null;
      if (paramMediaControllerCompat != null) {
        localObject = MediaControllerCompatApi21.fromToken(paramActivity, paramMediaControllerCompat.getSessionToken().getToken());
      }
      MediaControllerCompatApi21.setMediaController(paramActivity, localObject);
    }
  }
  
  public void adjustVolume(int paramInt1, int paramInt2)
  {
    mImpl.adjustVolume(paramInt1, paramInt2);
  }
  
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {
      throw new IllegalArgumentException("KeyEvent may not be null");
    }
    return mImpl.dispatchMediaButtonEvent(paramKeyEvent);
  }
  
  public Bundle getExtras()
  {
    return mImpl.getExtras();
  }
  
  public long getFlags()
  {
    return mImpl.getFlags();
  }
  
  public Object getMediaController()
  {
    return mImpl.getMediaController();
  }
  
  public MediaMetadataCompat getMetadata()
  {
    return mImpl.getMetadata();
  }
  
  public String getPackageName()
  {
    return mImpl.getPackageName();
  }
  
  public PlaybackInfo getPlaybackInfo()
  {
    return mImpl.getPlaybackInfo();
  }
  
  public PlaybackStateCompat getPlaybackState()
  {
    return mImpl.getPlaybackState();
  }
  
  public List<MediaSessionCompat.QueueItem> getQueue()
  {
    return mImpl.getQueue();
  }
  
  public CharSequence getQueueTitle()
  {
    return mImpl.getQueueTitle();
  }
  
  public int getRatingType()
  {
    return mImpl.getRatingType();
  }
  
  public PendingIntent getSessionActivity()
  {
    return mImpl.getSessionActivity();
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return mToken;
  }
  
  public TransportControls getTransportControls()
  {
    return mImpl.getTransportControls();
  }
  
  public void registerCallback(Callback paramCallback)
  {
    registerCallback(paramCallback, null);
  }
  
  public void registerCallback(Callback paramCallback, Handler paramHandler)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("callback cannot be null");
    }
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler();
    }
    mImpl.registerCallback(paramCallback, localHandler);
  }
  
  public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("command cannot be null or empty");
    }
    mImpl.sendCommand(paramString, paramBundle, paramResultReceiver);
  }
  
  public void setVolumeTo(int paramInt1, int paramInt2)
  {
    mImpl.setVolumeTo(paramInt1, paramInt2);
  }
  
  public void unregisterCallback(Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("callback cannot be null");
    }
    mImpl.unregisterCallback(paramCallback);
  }
  
  public static abstract class Callback
    implements IBinder.DeathRecipient
  {
    private final Object mCallbackObj;
    MessageHandler mHandler;
    boolean mHasExtraCallback;
    boolean mRegistered = false;
    
    public Callback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21());
        return;
      }
      mCallbackObj = new StubCompat();
    }
    
    private void setHandler(Handler paramHandler)
    {
      mHandler = new MessageHandler(paramHandler.getLooper());
    }
    
    public void binderDied()
    {
      onSessionDestroyed();
    }
    
    public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo paramPlaybackInfo) {}
    
    public void onExtrasChanged(Bundle paramBundle) {}
    
    public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) {}
    
    public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) {}
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList) {}
    
    public void onQueueTitleChanged(CharSequence paramCharSequence) {}
    
    public void onSessionDestroyed() {}
    
    public void onSessionEvent(String paramString, Bundle paramBundle) {}
    
    private class MessageHandler
      extends Handler
    {
      private static final int MSG_DESTROYED = 8;
      private static final int MSG_EVENT = 1;
      private static final int MSG_UPDATE_EXTRAS = 7;
      private static final int MSG_UPDATE_METADATA = 3;
      private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
      private static final int MSG_UPDATE_QUEUE = 5;
      private static final int MSG_UPDATE_QUEUE_TITLE = 6;
      private static final int MSG_UPDATE_VOLUME = 4;
      
      public MessageHandler(Looper paramLooper)
      {
        super();
      }
      
      public void handleMessage(Message paramMessage)
      {
        if (!mRegistered) {
          return;
        }
        switch (what)
        {
        default: 
          return;
        case 1: 
          onSessionEvent((String)obj, paramMessage.getData());
          return;
        case 2: 
          onPlaybackStateChanged((PlaybackStateCompat)obj);
          return;
        case 3: 
          onMetadataChanged((MediaMetadataCompat)obj);
          return;
        case 5: 
          onQueueChanged((List)obj);
          return;
        case 6: 
          onQueueTitleChanged((CharSequence)obj);
          return;
        case 7: 
          onExtrasChanged((Bundle)obj);
          return;
        case 4: 
          onAudioInfoChanged((MediaControllerCompat.PlaybackInfo)obj);
          return;
        }
        onSessionDestroyed();
      }
      
      public void post(int paramInt, Object paramObject, Bundle paramBundle)
      {
        paramObject = obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
    
    private class StubApi21
      implements MediaControllerCompatApi21.Callback
    {
      StubApi21() {}
      
      public void onAudioInfoChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        onAudioInfoChanged(new MediaControllerCompat.PlaybackInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
      }
      
      public void onExtrasChanged(Bundle paramBundle)
      {
        MediaControllerCompat.Callback.this.onExtrasChanged(paramBundle);
      }
      
      public void onMetadataChanged(Object paramObject)
      {
        onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(paramObject));
      }
      
      public void onPlaybackStateChanged(Object paramObject)
      {
        if ((mHasExtraCallback) && (Build.VERSION.SDK_INT < 22)) {
          return;
        }
        onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(paramObject));
      }
      
      public void onQueueChanged(List<?> paramList)
      {
        MediaControllerCompat.Callback.this.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(paramList));
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        MediaControllerCompat.Callback.this.onQueueTitleChanged(paramCharSequence);
      }
      
      public void onSessionDestroyed()
      {
        MediaControllerCompat.Callback.this.onSessionDestroyed();
      }
      
      public void onSessionEvent(String paramString, Bundle paramBundle)
      {
        if ((mHasExtraCallback) && (Build.VERSION.SDK_INT < 23)) {
          return;
        }
        MediaControllerCompat.Callback.this.onSessionEvent(paramString, paramBundle);
      }
    }
    
    private class StubCompat
      extends IMediaControllerCallback.Stub
    {
      StubCompat() {}
      
      public void onEvent(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        mHandler.post(1, paramString, paramBundle);
      }
      
      public void onExtrasChanged(Bundle paramBundle)
        throws RemoteException
      {
        mHandler.post(7, paramBundle, null);
      }
      
      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        mHandler.post(3, paramMediaMetadataCompat, null);
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat)
        throws RemoteException
      {
        mHandler.post(2, paramPlaybackStateCompat, null);
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
        throws RemoteException
      {
        mHandler.post(5, paramList, null);
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
        throws RemoteException
      {
        mHandler.post(6, paramCharSequence, null);
      }
      
      public void onSessionDestroyed()
        throws RemoteException
      {
        mHandler.post(8, null, null);
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        MediaControllerCompat.PlaybackInfo localPlaybackInfo = null;
        if (paramParcelableVolumeInfo != null) {
          localPlaybackInfo = new MediaControllerCompat.PlaybackInfo(volumeType, audioStream, controlType, maxVolume, currentVolume);
        }
        mHandler.post(4, localPlaybackInfo, null);
      }
    }
  }
  
  private static class MediaControllerExtraData
    extends SupportActivity.ExtraData
  {
    private final MediaControllerCompat mMediaController;
    
    MediaControllerExtraData(MediaControllerCompat paramMediaControllerCompat)
    {
      mMediaController = paramMediaControllerCompat;
    }
    
    MediaControllerCompat getMediaController()
    {
      return mMediaController;
    }
  }
  
  static abstract interface MediaControllerImpl
  {
    public abstract void adjustVolume(int paramInt1, int paramInt2);
    
    public abstract boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent);
    
    public abstract Bundle getExtras();
    
    public abstract long getFlags();
    
    public abstract Object getMediaController();
    
    public abstract MediaMetadataCompat getMetadata();
    
    public abstract String getPackageName();
    
    public abstract MediaControllerCompat.PlaybackInfo getPlaybackInfo();
    
    public abstract PlaybackStateCompat getPlaybackState();
    
    public abstract List<MediaSessionCompat.QueueItem> getQueue();
    
    public abstract CharSequence getQueueTitle();
    
    public abstract int getRatingType();
    
    public abstract PendingIntent getSessionActivity();
    
    public abstract MediaControllerCompat.TransportControls getTransportControls();
    
    public abstract void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler);
    
    public abstract void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver);
    
    public abstract void setVolumeTo(int paramInt1, int paramInt2);
    
    public abstract void unregisterCallback(MediaControllerCompat.Callback paramCallback);
  }
  
  static class MediaControllerImplApi21
    implements MediaControllerCompat.MediaControllerImpl
  {
    private HashMap<MediaControllerCompat.Callback, ExtraCallback> mCallbackMap = new HashMap();
    protected final Object mControllerObj;
    private IMediaSession mExtraBinder;
    private List<MediaControllerCompat.Callback> mPendingCallbacks;
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
      throws RemoteException
    {
      mControllerObj = MediaControllerCompatApi21.fromToken(paramContext, paramToken.getToken());
      if (mControllerObj == null) {
        throw new RemoteException();
      }
      requestExtraBinder();
    }
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
    {
      mControllerObj = MediaControllerCompatApi21.fromToken(paramContext, paramMediaSessionCompat.getSessionToken().getToken());
      requestExtraBinder();
    }
    
    private void requestExtraBinder()
    {
      sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ResultReceiver(new Handler())
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          if (paramAnonymousBundle != null)
          {
            MediaControllerCompat.MediaControllerImplApi21.access$202(MediaControllerCompat.MediaControllerImplApi21.this, IMediaSession.Stub.asInterface(BundleCompat.getBinder(paramAnonymousBundle, "android.support.v4.media.session.EXTRA_BINDER")));
            if (mPendingCallbacks != null)
            {
              paramAnonymousBundle = mPendingCallbacks.iterator();
              while (paramAnonymousBundle.hasNext())
              {
                MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)paramAnonymousBundle.next();
                MediaControllerCompat.MediaControllerImplApi21.ExtraCallback localExtraCallback = new MediaControllerCompat.MediaControllerImplApi21.ExtraCallback(MediaControllerCompat.MediaControllerImplApi21.this, localCallback);
                mCallbackMap.put(localCallback, localExtraCallback);
                mHasExtraCallback = true;
                try
                {
                  mExtraBinder.registerCallbackListener(localExtraCallback);
                }
                catch (RemoteException paramAnonymousBundle)
                {
                  Log.e("MediaControllerCompat", "Dead object in registerCallback. " + paramAnonymousBundle);
                }
              }
              MediaControllerCompat.MediaControllerImplApi21.access$302(MediaControllerCompat.MediaControllerImplApi21.this, null);
            }
          }
        }
      });
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      MediaControllerCompatApi21.adjustVolume(mControllerObj, paramInt1, paramInt2);
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return MediaControllerCompatApi21.dispatchMediaButtonEvent(mControllerObj, paramKeyEvent);
    }
    
    public Bundle getExtras()
    {
      return MediaControllerCompatApi21.getExtras(mControllerObj);
    }
    
    public long getFlags()
    {
      return MediaControllerCompatApi21.getFlags(mControllerObj);
    }
    
    public Object getMediaController()
    {
      return mControllerObj;
    }
    
    public MediaMetadataCompat getMetadata()
    {
      Object localObject = MediaControllerCompatApi21.getMetadata(mControllerObj);
      if (localObject != null) {
        return MediaMetadataCompat.fromMediaMetadata(localObject);
      }
      return null;
    }
    
    public String getPackageName()
    {
      return MediaControllerCompatApi21.getPackageName(mControllerObj);
    }
    
    public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
    {
      Object localObject = MediaControllerCompatApi21.getPlaybackInfo(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(localObject), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(localObject), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(localObject), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(localObject), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(localObject));
      }
      return null;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      if ((Build.VERSION.SDK_INT < 22) && (mExtraBinder != null)) {
        try
        {
          PlaybackStateCompat localPlaybackStateCompat = mExtraBinder.getPlaybackState();
          return localPlaybackStateCompat;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + localRemoteException);
        }
      }
      Object localObject = MediaControllerCompatApi21.getPlaybackState(mControllerObj);
      if (localObject != null) {
        return PlaybackStateCompat.fromPlaybackState(localObject);
      }
      return null;
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue()
    {
      List localList = MediaControllerCompatApi21.getQueue(mControllerObj);
      if (localList != null) {
        return MediaSessionCompat.QueueItem.fromQueueItemList(localList);
      }
      return null;
    }
    
    public CharSequence getQueueTitle()
    {
      return MediaControllerCompatApi21.getQueueTitle(mControllerObj);
    }
    
    public int getRatingType()
    {
      if ((Build.VERSION.SDK_INT < 22) && (mExtraBinder != null)) {
        try
        {
          int i = mExtraBinder.getRatingType();
          return i;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getRatingType. " + localRemoteException);
        }
      }
      return MediaControllerCompatApi21.getRatingType(mControllerObj);
    }
    
    public PendingIntent getSessionActivity()
    {
      return MediaControllerCompatApi21.getSessionActivity(mControllerObj);
    }
    
    public MediaControllerCompat.TransportControls getTransportControls()
    {
      Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.TransportControlsApi21(localObject);
      }
      return null;
    }
    
    public final void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler)
    {
      MediaControllerCompatApi21.registerCallback(mControllerObj, mCallbackObj, paramHandler);
      if (mExtraBinder != null)
      {
        paramCallback.setHandler(paramHandler);
        paramHandler = new ExtraCallback(paramCallback);
        mCallbackMap.put(paramCallback, paramHandler);
        mHasExtraCallback = true;
        try
        {
          mExtraBinder.registerCallbackListener(paramHandler);
          return;
        }
        catch (RemoteException paramCallback)
        {
          Log.e("MediaControllerCompat", "Dead object in registerCallback. " + paramCallback);
          return;
        }
      }
      if (mPendingCallbacks == null) {
        mPendingCallbacks = new ArrayList();
      }
      paramCallback.setHandler(paramHandler);
      mPendingCallbacks.add(paramCallback);
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      MediaControllerCompatApi21.sendCommand(mControllerObj, paramString, paramBundle, paramResultReceiver);
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2)
    {
      MediaControllerCompatApi21.setVolumeTo(mControllerObj, paramInt1, paramInt2);
    }
    
    public final void unregisterCallback(MediaControllerCompat.Callback paramCallback)
    {
      MediaControllerCompatApi21.unregisterCallback(mControllerObj, mCallbackObj);
      if (mExtraBinder != null) {
        try
        {
          paramCallback = (ExtraCallback)mCallbackMap.remove(paramCallback);
          if (paramCallback != null) {
            mExtraBinder.unregisterCallbackListener(paramCallback);
          }
          return;
        }
        catch (RemoteException paramCallback)
        {
          Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + paramCallback);
          return;
        }
      }
      if (mPendingCallbacks == null) {
        mPendingCallbacks = new ArrayList();
      }
      mPendingCallbacks.remove(paramCallback);
    }
    
    private class ExtraCallback
      extends IMediaControllerCallback.Stub
    {
      private MediaControllerCompat.Callback mCallback;
      
      ExtraCallback(MediaControllerCompat.Callback paramCallback)
      {
        mCallback = paramCallback;
      }
      
      public void onEvent(final String paramString, final Bundle paramBundle)
        throws RemoteException
      {
        mCallback.mHandler.post(new Runnable()
        {
          public void run()
          {
            mCallback.onSessionEvent(paramString, paramBundle);
          }
        });
      }
      
      public void onExtrasChanged(Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onPlaybackStateChanged(final PlaybackStateCompat paramPlaybackStateCompat)
        throws RemoteException
      {
        mCallback.mHandler.post(new Runnable()
        {
          public void run()
          {
            mCallback.onPlaybackStateChanged(paramPlaybackStateCompat);
          }
        });
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onSessionDestroyed()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        throw new AssertionError();
      }
    }
  }
  
  static class MediaControllerImplApi23
    extends MediaControllerCompat.MediaControllerImplApi21
  {
    public MediaControllerImplApi23(Context paramContext, MediaSessionCompat.Token paramToken)
      throws RemoteException
    {
      super(paramToken);
    }
    
    public MediaControllerImplApi23(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
    {
      super(paramMediaSessionCompat);
    }
    
    public MediaControllerCompat.TransportControls getTransportControls()
    {
      Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.TransportControlsApi23(localObject);
      }
      return null;
    }
  }
  
  static class MediaControllerImplApi24
    extends MediaControllerCompat.MediaControllerImplApi23
  {
    public MediaControllerImplApi24(Context paramContext, MediaSessionCompat.Token paramToken)
      throws RemoteException
    {
      super(paramToken);
    }
    
    public MediaControllerImplApi24(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
    {
      super(paramMediaSessionCompat);
    }
    
    public MediaControllerCompat.TransportControls getTransportControls()
    {
      Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.TransportControlsApi24(localObject);
      }
      return null;
    }
  }
  
  static class MediaControllerImplBase
    implements MediaControllerCompat.MediaControllerImpl
  {
    private IMediaSession mBinder;
    private MediaSessionCompat.Token mToken;
    private MediaControllerCompat.TransportControls mTransportControls;
    
    public MediaControllerImplBase(MediaSessionCompat.Token paramToken)
    {
      mToken = paramToken;
      mBinder = IMediaSession.Stub.asInterface((IBinder)paramToken.getToken());
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      try
      {
        mBinder.adjustVolume(paramInt1, paramInt2, null);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + localRemoteException);
      }
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent == null) {
        throw new IllegalArgumentException("event may not be null.");
      }
      try
      {
        mBinder.sendMediaButton(paramKeyEvent);
        return false;
      }
      catch (RemoteException paramKeyEvent)
      {
        for (;;)
        {
          Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + paramKeyEvent);
        }
      }
    }
    
    public Bundle getExtras()
    {
      try
      {
        Bundle localBundle = mBinder.getExtras();
        return localBundle;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getExtras. " + localRemoteException);
      }
      return null;
    }
    
    public long getFlags()
    {
      try
      {
        long l = mBinder.getFlags();
        return l;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getFlags. " + localRemoteException);
      }
      return 0L;
    }
    
    public Object getMediaController()
    {
      return null;
    }
    
    public MediaMetadataCompat getMetadata()
    {
      try
      {
        MediaMetadataCompat localMediaMetadataCompat = mBinder.getMetadata();
        return localMediaMetadataCompat;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getMetadata. " + localRemoteException);
      }
      return null;
    }
    
    public String getPackageName()
    {
      try
      {
        String str = mBinder.getPackageName();
        return str;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getPackageName. " + localRemoteException);
      }
      return null;
    }
    
    public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
    {
      try
      {
        Object localObject = mBinder.getVolumeAttributes();
        localObject = new MediaControllerCompat.PlaybackInfo(volumeType, audioStream, controlType, maxVolume, currentVolume);
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + localRemoteException);
      }
      return null;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      try
      {
        PlaybackStateCompat localPlaybackStateCompat = mBinder.getPlaybackState();
        return localPlaybackStateCompat;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + localRemoteException);
      }
      return null;
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue()
    {
      try
      {
        List localList = mBinder.getQueue();
        return localList;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getQueue. " + localRemoteException);
      }
      return null;
    }
    
    public CharSequence getQueueTitle()
    {
      try
      {
        CharSequence localCharSequence = mBinder.getQueueTitle();
        return localCharSequence;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + localRemoteException);
      }
      return null;
    }
    
    public int getRatingType()
    {
      try
      {
        int i = mBinder.getRatingType();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getRatingType. " + localRemoteException);
      }
      return 0;
    }
    
    public PendingIntent getSessionActivity()
    {
      try
      {
        PendingIntent localPendingIntent = mBinder.getLaunchPendingIntent();
        return localPendingIntent;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + localRemoteException);
      }
      return null;
    }
    
    public MediaControllerCompat.TransportControls getTransportControls()
    {
      if (mTransportControls == null) {
        mTransportControls = new MediaControllerCompat.TransportControlsBase(mBinder);
      }
      return mTransportControls;
    }
    
    public void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler)
    {
      if (paramCallback == null) {
        throw new IllegalArgumentException("callback may not be null.");
      }
      try
      {
        mBinder.asBinder().linkToDeath(paramCallback, 0);
        mBinder.registerCallbackListener((IMediaControllerCallback)mCallbackObj);
        paramCallback.setHandler(paramHandler);
        mRegistered = true;
        return;
      }
      catch (RemoteException paramHandler)
      {
        Log.e("MediaControllerCompat", "Dead object in registerCallback. " + paramHandler);
        paramCallback.onSessionDestroyed();
      }
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      try
      {
        mBinder.sendCommand(paramString, paramBundle, new MediaSessionCompat.ResultReceiverWrapper(paramResultReceiver));
        return;
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in sendCommand. " + paramString);
      }
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2)
    {
      try
      {
        mBinder.setVolumeTo(paramInt1, paramInt2, null);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + localRemoteException);
      }
    }
    
    public void unregisterCallback(MediaControllerCompat.Callback paramCallback)
    {
      if (paramCallback == null) {
        throw new IllegalArgumentException("callback may not be null.");
      }
      try
      {
        mBinder.unregisterCallbackListener((IMediaControllerCallback)mCallbackObj);
        mBinder.asBinder().unlinkToDeath(paramCallback, 0);
        mRegistered = false;
        return;
      }
      catch (RemoteException paramCallback)
      {
        Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + paramCallback);
      }
    }
  }
  
  public static final class PlaybackInfo
  {
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    private final int mAudioStream;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;
    
    PlaybackInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      mPlaybackType = paramInt1;
      mAudioStream = paramInt2;
      mVolumeControl = paramInt3;
      mMaxVolume = paramInt4;
      mCurrentVolume = paramInt5;
    }
    
    public int getAudioStream()
    {
      return mAudioStream;
    }
    
    public int getCurrentVolume()
    {
      return mCurrentVolume;
    }
    
    public int getMaxVolume()
    {
      return mMaxVolume;
    }
    
    public int getPlaybackType()
    {
      return mPlaybackType;
    }
    
    public int getVolumeControl()
    {
      return mVolumeControl;
    }
  }
  
  public static abstract class TransportControls
  {
    TransportControls() {}
    
    public abstract void fastForward();
    
    public abstract void pause();
    
    public abstract void play();
    
    public abstract void playFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void playFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void playFromUri(Uri paramUri, Bundle paramBundle);
    
    public abstract void prepare();
    
    public abstract void prepareFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void prepareFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void prepareFromUri(Uri paramUri, Bundle paramBundle);
    
    public abstract void rewind();
    
    public abstract void seekTo(long paramLong);
    
    public abstract void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle);
    
    public abstract void sendCustomAction(String paramString, Bundle paramBundle);
    
    public abstract void setRating(RatingCompat paramRatingCompat);
    
    public abstract void skipToNext();
    
    public abstract void skipToPrevious();
    
    public abstract void skipToQueueItem(long paramLong);
    
    public abstract void stop();
  }
  
  static class TransportControlsApi21
    extends MediaControllerCompat.TransportControls
  {
    protected final Object mControlsObj;
    
    public TransportControlsApi21(Object paramObject)
    {
      mControlsObj = paramObject;
    }
    
    public void fastForward()
    {
      MediaControllerCompatApi21.TransportControls.fastForward(mControlsObj);
    }
    
    public void pause()
    {
      MediaControllerCompatApi21.TransportControls.pause(mControlsObj);
    }
    
    public void play()
    {
      MediaControllerCompatApi21.TransportControls.play(mControlsObj);
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
    {
      MediaControllerCompatApi21.TransportControls.playFromMediaId(mControlsObj, paramString, paramBundle);
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
    {
      MediaControllerCompatApi21.TransportControls.playFromSearch(mControlsObj, paramString, paramBundle);
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      if ((paramUri == null) || (Uri.EMPTY.equals(paramUri))) {
        throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
      }
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", paramUri);
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", localBundle);
    }
    
    public void prepare()
    {
      sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
    }
    
    public void prepareFromMediaId(String paramString, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", paramString);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", localBundle);
    }
    
    public void prepareFromSearch(String paramString, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", paramString);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", localBundle);
    }
    
    public void prepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", paramUri);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", localBundle);
    }
    
    public void rewind()
    {
      MediaControllerCompatApi21.TransportControls.rewind(mControlsObj);
    }
    
    public void seekTo(long paramLong)
    {
      MediaControllerCompatApi21.TransportControls.seekTo(mControlsObj, paramLong);
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle)
    {
      MediaControllerCompatApi21.TransportControls.sendCustomAction(mControlsObj, paramCustomAction.getAction(), paramBundle);
    }
    
    public void sendCustomAction(String paramString, Bundle paramBundle)
    {
      MediaControllerCompatApi21.TransportControls.sendCustomAction(mControlsObj, paramString, paramBundle);
    }
    
    public void setRating(RatingCompat paramRatingCompat)
    {
      Object localObject = mControlsObj;
      if (paramRatingCompat != null) {}
      for (paramRatingCompat = paramRatingCompat.getRating();; paramRatingCompat = null)
      {
        MediaControllerCompatApi21.TransportControls.setRating(localObject, paramRatingCompat);
        return;
      }
    }
    
    public void skipToNext()
    {
      MediaControllerCompatApi21.TransportControls.skipToNext(mControlsObj);
    }
    
    public void skipToPrevious()
    {
      MediaControllerCompatApi21.TransportControls.skipToPrevious(mControlsObj);
    }
    
    public void skipToQueueItem(long paramLong)
    {
      MediaControllerCompatApi21.TransportControls.skipToQueueItem(mControlsObj, paramLong);
    }
    
    public void stop()
    {
      MediaControllerCompatApi21.TransportControls.stop(mControlsObj);
    }
  }
  
  static class TransportControlsApi23
    extends MediaControllerCompat.TransportControlsApi21
  {
    public TransportControlsApi23(Object paramObject)
    {
      super();
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      MediaControllerCompatApi23.TransportControls.playFromUri(mControlsObj, paramUri, paramBundle);
    }
  }
  
  static class TransportControlsApi24
    extends MediaControllerCompat.TransportControlsApi23
  {
    public TransportControlsApi24(Object paramObject)
    {
      super();
    }
    
    public void prepare()
    {
      MediaControllerCompatApi24.TransportControls.prepare(mControlsObj);
    }
    
    public void prepareFromMediaId(String paramString, Bundle paramBundle)
    {
      MediaControllerCompatApi24.TransportControls.prepareFromMediaId(mControlsObj, paramString, paramBundle);
    }
    
    public void prepareFromSearch(String paramString, Bundle paramBundle)
    {
      MediaControllerCompatApi24.TransportControls.prepareFromSearch(mControlsObj, paramString, paramBundle);
    }
    
    public void prepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      MediaControllerCompatApi24.TransportControls.prepareFromUri(mControlsObj, paramUri, paramBundle);
    }
  }
  
  static class TransportControlsBase
    extends MediaControllerCompat.TransportControls
  {
    private IMediaSession mBinder;
    
    public TransportControlsBase(IMediaSession paramIMediaSession)
    {
      mBinder = paramIMediaSession;
    }
    
    public void fastForward()
    {
      try
      {
        mBinder.fastForward();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in fastForward. " + localRemoteException);
      }
    }
    
    public void pause()
    {
      try
      {
        mBinder.pause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in pause. " + localRemoteException);
      }
    }
    
    public void play()
    {
      try
      {
        mBinder.play();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in play. " + localRemoteException);
      }
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
    {
      try
      {
        mBinder.playFromMediaId(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + paramString);
      }
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
    {
      try
      {
        mBinder.playFromSearch(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + paramString);
      }
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      try
      {
        mBinder.playFromUri(paramUri, paramBundle);
        return;
      }
      catch (RemoteException paramUri)
      {
        Log.e("MediaControllerCompat", "Dead object in playFromUri. " + paramUri);
      }
    }
    
    public void prepare()
    {
      try
      {
        mBinder.prepare();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in prepare. " + localRemoteException);
      }
    }
    
    public void prepareFromMediaId(String paramString, Bundle paramBundle)
    {
      try
      {
        mBinder.prepareFromMediaId(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId. " + paramString);
      }
    }
    
    public void prepareFromSearch(String paramString, Bundle paramBundle)
    {
      try
      {
        mBinder.prepareFromSearch(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in prepareFromSearch. " + paramString);
      }
    }
    
    public void prepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      try
      {
        mBinder.prepareFromUri(paramUri, paramBundle);
        return;
      }
      catch (RemoteException paramUri)
      {
        Log.e("MediaControllerCompat", "Dead object in prepareFromUri. " + paramUri);
      }
    }
    
    public void rewind()
    {
      try
      {
        mBinder.rewind();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in rewind. " + localRemoteException);
      }
    }
    
    public void seekTo(long paramLong)
    {
      try
      {
        mBinder.seekTo(paramLong);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in seekTo. " + localRemoteException);
      }
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle)
    {
      sendCustomAction(paramCustomAction.getAction(), paramBundle);
    }
    
    public void sendCustomAction(String paramString, Bundle paramBundle)
    {
      try
      {
        mBinder.sendCustomAction(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + paramString);
      }
    }
    
    public void setRating(RatingCompat paramRatingCompat)
    {
      try
      {
        mBinder.rate(paramRatingCompat);
        return;
      }
      catch (RemoteException paramRatingCompat)
      {
        Log.e("MediaControllerCompat", "Dead object in setRating. " + paramRatingCompat);
      }
    }
    
    public void skipToNext()
    {
      try
      {
        mBinder.next();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in skipToNext. " + localRemoteException);
      }
    }
    
    public void skipToPrevious()
    {
      try
      {
        mBinder.previous();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + localRemoteException);
      }
    }
    
    public void skipToQueueItem(long paramLong)
    {
      try
      {
        mBinder.skipToQueueItem(paramLong);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + localRemoteException);
      }
    }
    
    public void stop()
    {
      try
      {
        mBinder.stop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in stop. " + localRemoteException);
      }
    }
  }
}
