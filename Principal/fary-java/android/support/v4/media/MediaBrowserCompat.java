package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class MediaBrowserCompat
{
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
  public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
  static final String TAG = "MediaBrowserCompat";
  private final MediaBrowserImpl mImpl;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, ConnectionCallback paramConnectionCallback, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 24) || (BuildCompat.isAtLeastN()))
    {
      mImpl = new MediaBrowserImplApi24(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      mImpl = new MediaBrowserImplApi23(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      mImpl = new MediaBrowserImplApi21(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    mImpl = new MediaBrowserImplBase(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
  }
  
  public void connect()
  {
    mImpl.connect();
  }
  
  public void disconnect()
  {
    mImpl.disconnect();
  }
  
  @Nullable
  public Bundle getExtras()
  {
    return mImpl.getExtras();
  }
  
  public void getItem(@NonNull String paramString, @NonNull ItemCallback paramItemCallback)
  {
    mImpl.getItem(paramString, paramItemCallback);
  }
  
  @NonNull
  public String getRoot()
  {
    return mImpl.getRoot();
  }
  
  @NonNull
  public ComponentName getServiceComponent()
  {
    return mImpl.getServiceComponent();
  }
  
  @NonNull
  public MediaSessionCompat.Token getSessionToken()
  {
    return mImpl.getSessionToken();
  }
  
  public boolean isConnected()
  {
    return mImpl.isConnected();
  }
  
  public void subscribe(@NonNull String paramString, @NonNull Bundle paramBundle, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("parentId is empty");
    }
    if (paramSubscriptionCallback == null) {
      throw new IllegalArgumentException("callback is null");
    }
    if (paramBundle == null) {
      throw new IllegalArgumentException("options are null");
    }
    mImpl.subscribe(paramString, paramBundle, paramSubscriptionCallback);
  }
  
  public void subscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("parentId is empty");
    }
    if (paramSubscriptionCallback == null) {
      throw new IllegalArgumentException("callback is null");
    }
    mImpl.subscribe(paramString, null, paramSubscriptionCallback);
  }
  
  public void unsubscribe(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("parentId is empty");
    }
    mImpl.unsubscribe(paramString, null);
  }
  
  public void unsubscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("parentId is empty");
    }
    if (paramSubscriptionCallback == null) {
      throw new IllegalArgumentException("callback is null");
    }
    mImpl.unsubscribe(paramString, paramSubscriptionCallback);
  }
  
  private static class CallbackHandler
    extends Handler
  {
    private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
    private WeakReference<Messenger> mCallbacksMessengerRef;
    
    CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl paramMediaBrowserServiceCallbackImpl)
    {
      mCallbackImplRef = new WeakReference(paramMediaBrowserServiceCallbackImpl);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((mCallbacksMessengerRef == null) || (mCallbacksMessengerRef.get() == null) || (mCallbackImplRef.get() == null)) {
        return;
      }
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
      switch (what)
      {
      default: 
        Log.w("MediaBrowserCompat", "Unhandled message: " + paramMessage + "\n  Client version: " + 1 + "\n  Service version: " + arg1);
        return;
      case 1: 
        ((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)mCallbackImplRef.get()).onServiceConnected((Messenger)mCallbacksMessengerRef.get(), localBundle.getString("data_media_item_id"), (MediaSessionCompat.Token)localBundle.getParcelable("data_media_session_token"), localBundle.getBundle("data_root_hints"));
        return;
      case 2: 
        ((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)mCallbackImplRef.get()).onConnectionFailed((Messenger)mCallbacksMessengerRef.get());
        return;
      }
      ((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)mCallbackImplRef.get()).onLoadChildren((Messenger)mCallbacksMessengerRef.get(), localBundle.getString("data_media_item_id"), localBundle.getParcelableArrayList("data_media_item_list"), localBundle.getBundle("data_options"));
    }
    
    void setCallbacksMessenger(Messenger paramMessenger)
    {
      mCallbacksMessengerRef = new WeakReference(paramMessenger);
    }
  }
  
  public static class ConnectionCallback
  {
    ConnectionCallbackInternal mConnectionCallbackInternal;
    final Object mConnectionCallbackObj;
    
    public ConnectionCallback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
        return;
      }
      mConnectionCallbackObj = null;
    }
    
    public void onConnected() {}
    
    public void onConnectionFailed() {}
    
    public void onConnectionSuspended() {}
    
    void setInternalConnectionCallback(ConnectionCallbackInternal paramConnectionCallbackInternal)
    {
      mConnectionCallbackInternal = paramConnectionCallbackInternal;
    }
    
    static abstract interface ConnectionCallbackInternal
    {
      public abstract void onConnected();
      
      public abstract void onConnectionFailed();
      
      public abstract void onConnectionSuspended();
    }
    
    private class StubApi21
      implements MediaBrowserCompatApi21.ConnectionCallback
    {
      StubApi21() {}
      
      public void onConnected()
      {
        if (mConnectionCallbackInternal != null) {
          mConnectionCallbackInternal.onConnected();
        }
        MediaBrowserCompat.ConnectionCallback.this.onConnected();
      }
      
      public void onConnectionFailed()
      {
        if (mConnectionCallbackInternal != null) {
          mConnectionCallbackInternal.onConnectionFailed();
        }
        MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
      }
      
      public void onConnectionSuspended()
      {
        if (mConnectionCallbackInternal != null) {
          mConnectionCallbackInternal.onConnectionSuspended();
        }
        MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
      }
    }
  }
  
  public static abstract class ItemCallback
  {
    final Object mItemCallbackObj;
    
    public ItemCallback()
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
        return;
      }
      mItemCallbackObj = null;
    }
    
    public void onError(@NonNull String paramString) {}
    
    public void onItemLoaded(MediaBrowserCompat.MediaItem paramMediaItem) {}
    
    private class StubApi23
      implements MediaBrowserCompatApi23.ItemCallback
    {
      StubApi23() {}
      
      public void onError(@NonNull String paramString)
      {
        MediaBrowserCompat.ItemCallback.this.onError(paramString);
      }
      
      public void onItemLoaded(Parcel paramParcel)
      {
        paramParcel.setDataPosition(0);
        MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(paramParcel);
        paramParcel.recycle();
        onItemLoaded(localMediaItem);
      }
    }
  }
  
  private static class ItemReceiver
    extends ResultReceiver
  {
    private final MediaBrowserCompat.ItemCallback mCallback;
    private final String mMediaId;
    
    ItemReceiver(String paramString, MediaBrowserCompat.ItemCallback paramItemCallback, Handler paramHandler)
    {
      super();
      mMediaId = paramString;
      mCallback = paramItemCallback;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {
        paramBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      }
      if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("media_item")))
      {
        mCallback.onError(mMediaId);
        return;
      }
      paramBundle = paramBundle.getParcelable("media_item");
      if ((paramBundle == null) || ((paramBundle instanceof MediaBrowserCompat.MediaItem)))
      {
        mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)paramBundle);
        return;
      }
      mCallback.onError(mMediaId);
    }
  }
  
  static abstract interface MediaBrowserImpl
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    @Nullable
    public abstract Bundle getExtras();
    
    public abstract void getItem(@NonNull String paramString, @NonNull MediaBrowserCompat.ItemCallback paramItemCallback);
    
    @NonNull
    public abstract String getRoot();
    
    public abstract ComponentName getServiceComponent();
    
    @NonNull
    public abstract MediaSessionCompat.Token getSessionToken();
    
    public abstract boolean isConnected();
    
    public abstract void subscribe(@NonNull String paramString, Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);
    
    public abstract void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);
  }
  
  static class MediaBrowserImplApi21
    implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl, MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
  {
    protected final Object mBrowserObj;
    protected Messenger mCallbacksMessenger;
    protected final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    protected final Bundle mRootHints;
    protected MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();
    
    public MediaBrowserImplApi21(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      if (Build.VERSION.SDK_INT < 25)
      {
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
          localBundle = new Bundle();
        }
        localBundle.putInt("extra_client_version", 1);
        mRootHints = new Bundle(localBundle);
        paramConnectionCallback.setInternalConnectionCallback(this);
        mBrowserObj = MediaBrowserCompatApi21.createBrowser(paramContext, paramComponentName, mConnectionCallbackObj, mRootHints);
        return;
      }
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = new Bundle(paramBundle))
      {
        mRootHints = paramBundle;
        break;
      }
    }
    
    public void connect()
    {
      MediaBrowserCompatApi21.connect(mBrowserObj);
    }
    
    public void disconnect()
    {
      if ((mServiceBinderWrapper != null) && (mCallbacksMessenger != null)) {}
      try
      {
        mServiceBinderWrapper.unregisterCallbackMessenger(mCallbacksMessenger);
        MediaBrowserCompatApi21.disconnect(mBrowserObj);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        }
      }
    }
    
    @Nullable
    public Bundle getExtras()
    {
      return MediaBrowserCompatApi21.getExtras(mBrowserObj);
    }
    
    public void getItem(@NonNull final String paramString, @NonNull final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("mediaId is empty");
      }
      if (paramItemCallback == null) {
        throw new IllegalArgumentException("cb is null");
      }
      if (!MediaBrowserCompatApi21.isConnected(mBrowserObj))
      {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      if (mServiceBinderWrapper == null)
      {
        mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      MediaBrowserCompat.ItemReceiver localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramItemCallback, mHandler);
      try
      {
        mServiceBinderWrapper.getMediaItem(paramString, localItemReceiver, mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error getting media item: " + paramString);
        mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
      }
    }
    
    @NonNull
    public String getRoot()
    {
      return MediaBrowserCompatApi21.getRoot(mBrowserObj);
    }
    
    public ComponentName getServiceComponent()
    {
      return MediaBrowserCompatApi21.getServiceComponent(mBrowserObj);
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken()
    {
      return MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(mBrowserObj));
    }
    
    public boolean isConnected()
    {
      return MediaBrowserCompatApi21.isConnected(mBrowserObj);
    }
    
    public void onConnected()
    {
      Object localObject = MediaBrowserCompatApi21.getExtras(mBrowserObj);
      if (localObject == null) {}
      do
      {
        return;
        localObject = BundleCompat.getBinder((Bundle)localObject, "extra_messenger");
      } while (localObject == null);
      mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper((IBinder)localObject, mRootHints);
      mCallbacksMessenger = new Messenger(mHandler);
      mHandler.setCallbacksMessenger(mCallbacksMessenger);
      try
      {
        mServiceBinderWrapper.registerCallbackMessenger(mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
      }
    }
    
    public void onConnectionFailed() {}
    
    public void onConnectionFailed(Messenger paramMessenger) {}
    
    public void onConnectionSuspended()
    {
      mServiceBinderWrapper = null;
      mCallbacksMessenger = null;
      mHandler.setCallbacksMessenger(null);
    }
    
    public void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle)
    {
      if (mCallbacksMessenger != paramMessenger) {}
      do
      {
        do
        {
          return;
          paramMessenger = (MediaBrowserCompat.Subscription)mSubscriptions.get(paramString);
          if (paramMessenger != null) {
            break;
          }
        } while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + paramString);
        return;
        paramMessenger = paramMessenger.getCallback(paramBundle);
      } while (paramMessenger == null);
      if (paramBundle == null)
      {
        paramMessenger.onChildrenLoaded(paramString, paramList);
        return;
      }
      paramMessenger.onChildrenLoaded(paramString, paramList, paramBundle);
    }
    
    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public void subscribe(@NonNull String paramString, Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription2 = (MediaBrowserCompat.Subscription)mSubscriptions.get(paramString);
      MediaBrowserCompat.Subscription localSubscription1 = localSubscription2;
      if (localSubscription2 == null)
      {
        localSubscription1 = new MediaBrowserCompat.Subscription();
        mSubscriptions.put(paramString, localSubscription1);
      }
      MediaBrowserCompat.SubscriptionCallback.access$100(paramSubscriptionCallback, localSubscription1);
      localSubscription1.putCallback(paramBundle, paramSubscriptionCallback);
      if (mServiceBinderWrapper == null)
      {
        MediaBrowserCompatApi21.subscribe(mBrowserObj, paramString, MediaBrowserCompat.SubscriptionCallback.access$200(paramSubscriptionCallback));
        return;
      }
      try
      {
        mServiceBinderWrapper.addSubscription(paramString, MediaBrowserCompat.SubscriptionCallback.access$000(paramSubscriptionCallback), paramBundle, mCallbacksMessenger);
        return;
      }
      catch (RemoteException paramBundle)
      {
        Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + paramString);
      }
    }
    
    public void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)mSubscriptions.get(paramString);
      if (localSubscription == null) {
        return;
      }
      if (mServiceBinderWrapper == null) {
        if (paramSubscriptionCallback == null) {
          MediaBrowserCompatApi21.unsubscribe(mBrowserObj, paramString);
        }
      }
      for (;;)
      {
        if ((localSubscription.isEmpty()) || (paramSubscriptionCallback == null))
        {
          mSubscriptions.remove(paramString);
          return;
          List localList1 = localSubscription.getCallbacks();
          localList3 = localSubscription.getOptionsList();
          i = localList1.size() - 1;
          while (i >= 0)
          {
            if (localList1.get(i) == paramSubscriptionCallback)
            {
              localList1.remove(i);
              localList3.remove(i);
            }
            i -= 1;
          }
          if (localList1.size() != 0) {
            continue;
          }
          MediaBrowserCompatApi21.unsubscribe(mBrowserObj, paramString);
          continue;
          if (paramSubscriptionCallback == null) {
            try
            {
              mServiceBinderWrapper.removeSubscription(paramString, null, mCallbacksMessenger);
            }
            catch (RemoteException localRemoteException)
            {
              Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + paramString);
            }
          }
        }
        else
        {
          break;
        }
        List localList2 = localSubscription.getCallbacks();
        List localList3 = localSubscription.getOptionsList();
        int i = localList2.size() - 1;
        while (i >= 0)
        {
          if (localList2.get(i) == paramSubscriptionCallback)
          {
            mServiceBinderWrapper.removeSubscription(paramString, MediaBrowserCompat.SubscriptionCallback.access$000(paramSubscriptionCallback), mCallbacksMessenger);
            localList2.remove(i);
            localList3.remove(i);
          }
          i -= 1;
        }
      }
    }
  }
  
  static class MediaBrowserImplApi23
    extends MediaBrowserCompat.MediaBrowserImplApi21
  {
    public MediaBrowserImplApi23(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }
    
    public void getItem(@NonNull String paramString, @NonNull MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (mServiceBinderWrapper == null)
      {
        MediaBrowserCompatApi23.getItem(mBrowserObj, paramString, mItemCallbackObj);
        return;
      }
      super.getItem(paramString, paramItemCallback);
    }
  }
  
  static class MediaBrowserImplApi24
    extends MediaBrowserCompat.MediaBrowserImplApi23
  {
    public MediaBrowserImplApi24(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }
    
    public void subscribe(@NonNull String paramString, @NonNull Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if (paramBundle == null)
      {
        MediaBrowserCompatApi21.subscribe(mBrowserObj, paramString, MediaBrowserCompat.SubscriptionCallback.access$200(paramSubscriptionCallback));
        return;
      }
      MediaBrowserCompatApi24.subscribe(mBrowserObj, paramString, paramBundle, MediaBrowserCompat.SubscriptionCallback.access$200(paramSubscriptionCallback));
    }
    
    public void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if (paramSubscriptionCallback == null)
      {
        MediaBrowserCompatApi21.unsubscribe(mBrowserObj, paramString);
        return;
      }
      MediaBrowserCompatApi24.unsubscribe(mBrowserObj, paramString, MediaBrowserCompat.SubscriptionCallback.access$200(paramSubscriptionCallback));
    }
  }
  
  static class MediaBrowserImplBase
    implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl
  {
    private static final int CONNECT_STATE_CONNECTED = 2;
    static final int CONNECT_STATE_CONNECTING = 1;
    static final int CONNECT_STATE_DISCONNECTED = 0;
    static final int CONNECT_STATE_SUSPENDED = 3;
    final MediaBrowserCompat.ConnectionCallback mCallback;
    Messenger mCallbacksMessenger;
    final Context mContext;
    private Bundle mExtras;
    final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    private MediaSessionCompat.Token mMediaSessionToken;
    final Bundle mRootHints;
    private String mRootId;
    MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    final ComponentName mServiceComponent;
    MediaServiceConnection mServiceConnection;
    int mState = 0;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();
    
    public MediaBrowserImplBase(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      if (paramContext == null) {
        throw new IllegalArgumentException("context must not be null");
      }
      if (paramComponentName == null) {
        throw new IllegalArgumentException("service component must not be null");
      }
      if (paramConnectionCallback == null) {
        throw new IllegalArgumentException("connection callback must not be null");
      }
      mContext = paramContext;
      mServiceComponent = paramComponentName;
      mCallback = paramConnectionCallback;
      if (paramBundle == null) {}
      for (paramContext = null;; paramContext = new Bundle(paramBundle))
      {
        mRootHints = paramContext;
        return;
      }
    }
    
    private static String getStateLabel(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "UNKNOWN/" + paramInt;
      case 0: 
        return "CONNECT_STATE_DISCONNECTED";
      case 1: 
        return "CONNECT_STATE_CONNECTING";
      case 2: 
        return "CONNECT_STATE_CONNECTED";
      }
      return "CONNECT_STATE_SUSPENDED";
    }
    
    private boolean isCurrent(Messenger paramMessenger, String paramString)
    {
      if (mCallbacksMessenger != paramMessenger)
      {
        if (mState != 0) {
          Log.i("MediaBrowserCompat", paramString + " for " + mServiceComponent + " with mCallbacksMessenger=" + mCallbacksMessenger + " this=" + this);
        }
        return false;
      }
      return true;
    }
    
    public void connect()
    {
      if (mState != 0) {
        throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(mState) + ")");
      }
      if ((MediaBrowserCompat.DEBUG) && (mServiceConnection != null)) {
        throw new RuntimeException("mServiceConnection should be null. Instead it is " + mServiceConnection);
      }
      if (mServiceBinderWrapper != null) {
        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + mServiceBinderWrapper);
      }
      if (mCallbacksMessenger != null) {
        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + mCallbacksMessenger);
      }
      mState = 1;
      Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
      localIntent.setComponent(mServiceComponent);
      final MediaServiceConnection localMediaServiceConnection = new MediaServiceConnection();
      mServiceConnection = localMediaServiceConnection;
      int i = 0;
      try
      {
        boolean bool = mContext.bindService(localIntent, mServiceConnection, 1);
        i = bool;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MediaBrowserCompat", "Failed binding to service " + mServiceComponent);
        }
      }
      if (i == 0) {
        mHandler.post(new Runnable()
        {
          public void run()
          {
            if (localMediaServiceConnection == mServiceConnection)
            {
              forceCloseConnection();
              mCallback.onConnectionFailed();
            }
          }
        });
      }
      if (MediaBrowserCompat.DEBUG)
      {
        Log.d("MediaBrowserCompat", "connect...");
        dump();
      }
    }
    
    public void disconnect()
    {
      if (mCallbacksMessenger != null) {}
      try
      {
        mServiceBinderWrapper.disconnect(mCallbacksMessenger);
        forceCloseConnection();
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "disconnect...");
          dump();
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.w("MediaBrowserCompat", "RemoteException during connect for " + mServiceComponent);
        }
      }
    }
    
    void dump()
    {
      Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
      Log.d("MediaBrowserCompat", "  mServiceComponent=" + mServiceComponent);
      Log.d("MediaBrowserCompat", "  mCallback=" + mCallback);
      Log.d("MediaBrowserCompat", "  mRootHints=" + mRootHints);
      Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(mState));
      Log.d("MediaBrowserCompat", "  mServiceConnection=" + mServiceConnection);
      Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + mServiceBinderWrapper);
      Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + mCallbacksMessenger);
      Log.d("MediaBrowserCompat", "  mRootId=" + mRootId);
      Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + mMediaSessionToken);
    }
    
    void forceCloseConnection()
    {
      if (mServiceConnection != null) {
        mContext.unbindService(mServiceConnection);
      }
      mState = 0;
      mServiceConnection = null;
      mServiceBinderWrapper = null;
      mCallbacksMessenger = null;
      mHandler.setCallbacksMessenger(null);
      mRootId = null;
      mMediaSessionToken = null;
    }
    
    @Nullable
    public Bundle getExtras()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(mState) + ")");
      }
      return mExtras;
    }
    
    public void getItem(@NonNull final String paramString, @NonNull final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("mediaId is empty");
      }
      if (paramItemCallback == null) {
        throw new IllegalArgumentException("cb is null");
      }
      if (mState != 2)
      {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      MediaBrowserCompat.ItemReceiver localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramItemCallback, mHandler);
      try
      {
        mServiceBinderWrapper.getMediaItem(paramString, localItemReceiver, mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error getting media item.");
        mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
      }
    }
    
    @NonNull
    public String getRoot()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(mState) + ")");
      }
      return mRootId;
    }
    
    @NonNull
    public ComponentName getServiceComponent()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getServiceComponent() called while not connected (state=" + mState + ")");
      }
      return mServiceComponent;
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken()
    {
      if (!isConnected()) {
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + mState + ")");
      }
      return mMediaSessionToken;
    }
    
    public boolean isConnected()
    {
      return mState == 2;
    }
    
    public void onConnectionFailed(Messenger paramMessenger)
    {
      Log.e("MediaBrowserCompat", "onConnectFailed for " + mServiceComponent);
      if (!isCurrent(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (mState != 1)
      {
        Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(mState) + "... ignoring");
        return;
      }
      forceCloseConnection();
      mCallback.onConnectionFailed();
    }
    
    public void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle)
    {
      if (!isCurrent(paramMessenger, "onLoadChildren")) {}
      do
      {
        do
        {
          return;
          if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "onLoadChildren for " + mServiceComponent + " id=" + paramString);
          }
          paramMessenger = (MediaBrowserCompat.Subscription)mSubscriptions.get(paramString);
          if (paramMessenger != null) {
            break;
          }
        } while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + paramString);
        return;
        paramMessenger = paramMessenger.getCallback(paramBundle);
      } while (paramMessenger == null);
      if (paramBundle == null)
      {
        paramMessenger.onChildrenLoaded(paramString, paramList);
        return;
      }
      paramMessenger.onChildrenLoaded(paramString, paramList, paramBundle);
    }
    
    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!isCurrent(paramMessenger, "onConnect")) {}
      for (;;)
      {
        return;
        if (mState != 1)
        {
          Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(mState) + "... ignoring");
          return;
        }
        mRootId = paramString;
        mMediaSessionToken = paramToken;
        mExtras = paramBundle;
        mState = 2;
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
          dump();
        }
        mCallback.onConnected();
        try
        {
          paramMessenger = mSubscriptions.entrySet().iterator();
          while (paramMessenger.hasNext())
          {
            paramToken = (Map.Entry)paramMessenger.next();
            paramString = (String)paramToken.getKey();
            paramBundle = (MediaBrowserCompat.Subscription)paramToken.getValue();
            paramToken = paramBundle.getCallbacks();
            paramBundle = paramBundle.getOptionsList();
            int i = 0;
            while (i < paramToken.size())
            {
              mServiceBinderWrapper.addSubscription(paramString, MediaBrowserCompat.SubscriptionCallback.access$000((MediaBrowserCompat.SubscriptionCallback)paramToken.get(i)), (Bundle)paramBundle.get(i), mCallbacksMessenger);
              i += 1;
            }
          }
          return;
        }
        catch (RemoteException paramMessenger)
        {
          Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }
      }
    }
    
    public void subscribe(@NonNull String paramString, Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription2 = (MediaBrowserCompat.Subscription)mSubscriptions.get(paramString);
      MediaBrowserCompat.Subscription localSubscription1 = localSubscription2;
      if (localSubscription2 == null)
      {
        localSubscription1 = new MediaBrowserCompat.Subscription();
        mSubscriptions.put(paramString, localSubscription1);
      }
      localSubscription1.putCallback(paramBundle, paramSubscriptionCallback);
      if (mState == 2) {}
      try
      {
        mServiceBinderWrapper.addSubscription(paramString, MediaBrowserCompat.SubscriptionCallback.access$000(paramSubscriptionCallback), paramBundle, mCallbacksMessenger);
        return;
      }
      catch (RemoteException paramBundle)
      {
        Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + paramString);
      }
    }
    
    public void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)mSubscriptions.get(paramString);
      if (localSubscription == null) {}
      for (;;)
      {
        return;
        if (paramSubscriptionCallback == null) {}
        try
        {
          if (mState == 2) {
            mServiceBinderWrapper.removeSubscription(paramString, null, mCallbacksMessenger);
          }
          while ((localSubscription.isEmpty()) || (paramSubscriptionCallback == null))
          {
            mSubscriptions.remove(paramString);
            return;
            List localList1 = localSubscription.getCallbacks();
            List localList2 = localSubscription.getOptionsList();
            int i = localList1.size() - 1;
            while (i >= 0)
            {
              if (localList1.get(i) == paramSubscriptionCallback)
              {
                if (mState == 2) {
                  mServiceBinderWrapper.removeSubscription(paramString, MediaBrowserCompat.SubscriptionCallback.access$000(paramSubscriptionCallback), mCallbacksMessenger);
                }
                localList1.remove(i);
                localList2.remove(i);
              }
              i -= 1;
            }
          }
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + paramString);
          }
        }
      }
    }
    
    private class MediaServiceConnection
      implements ServiceConnection
    {
      MediaServiceConnection() {}
      
      private void postOrRun(Runnable paramRunnable)
      {
        if (Thread.currentThread() == mHandler.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        mHandler.post(paramRunnable);
      }
      
      boolean isCurrent(String paramString)
      {
        if (mServiceConnection != this)
        {
          if (mState != 0) {
            Log.i("MediaBrowserCompat", paramString + " for " + mServiceComponent + " with mServiceConnection=" + mServiceConnection + " this=" + this);
          }
          return false;
        }
        return true;
      }
      
      public void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + paramComponentName + " binder=" + paramIBinder);
              dump();
            }
            if (!isCurrent("onServiceConnected")) {}
            do
            {
              return;
              mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(paramIBinder, mRootHints);
              mCallbacksMessenger = new Messenger(mHandler);
              mHandler.setCallbacksMessenger(mCallbacksMessenger);
              mState = 1;
              try
              {
                if (MediaBrowserCompat.DEBUG)
                {
                  Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                  dump();
                }
                mServiceBinderWrapper.connect(mContext, mCallbacksMessenger);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                Log.w("MediaBrowserCompat", "RemoteException during connect for " + mServiceComponent);
              }
            } while (!MediaBrowserCompat.DEBUG);
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            dump();
          }
        });
      }
      
      public void onServiceDisconnected(final ComponentName paramComponentName)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + paramComponentName + " this=" + this + " mServiceConnection=" + mServiceConnection);
              dump();
            }
            if (!isCurrent("onServiceDisconnected")) {
              return;
            }
            mServiceBinderWrapper = null;
            mCallbacksMessenger = null;
            mHandler.setCallbacksMessenger(null);
            mState = 3;
            mCallback.onConnectionSuspended();
          }
        });
      }
    }
  }
  
  static abstract interface MediaBrowserServiceCallbackImpl
  {
    public abstract void onConnectionFailed(Messenger paramMessenger);
    
    public abstract void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle);
    
    public abstract void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
  }
  
  public static class MediaItem
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator()
    {
      public MediaBrowserCompat.MediaItem createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MediaBrowserCompat.MediaItem(paramAnonymousParcel);
      }
      
      public MediaBrowserCompat.MediaItem[] newArray(int paramAnonymousInt)
      {
        return new MediaBrowserCompat.MediaItem[paramAnonymousInt];
      }
    };
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;
    
    MediaItem(Parcel paramParcel)
    {
      mFlags = paramParcel.readInt();
      mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }
    
    public MediaItem(@NonNull MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat == null) {
        throw new IllegalArgumentException("description cannot be null");
      }
      if (TextUtils.isEmpty(paramMediaDescriptionCompat.getMediaId())) {
        throw new IllegalArgumentException("description must have a non-empty media id");
      }
      mFlags = paramInt;
      mDescription = paramMediaDescriptionCompat;
    }
    
    public static MediaItem fromMediaItem(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      int i = MediaBrowserCompatApi21.MediaItem.getFlags(paramObject);
      return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(paramObject)), i);
    }
    
    public static List<MediaItem> fromMediaItemList(List<?> paramList)
    {
      if ((paramList == null) || (Build.VERSION.SDK_INT < 21))
      {
        paramList = null;
        return paramList;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(fromMediaItem(localIterator.next()));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    @NonNull
    public MediaDescriptionCompat getDescription()
    {
      return mDescription;
    }
    
    public int getFlags()
    {
      return mFlags;
    }
    
    @NonNull
    public String getMediaId()
    {
      return mDescription.getMediaId();
    }
    
    public boolean isBrowsable()
    {
      return (mFlags & 0x1) != 0;
    }
    
    public boolean isPlayable()
    {
      return (mFlags & 0x2) != 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
      localStringBuilder.append("mFlags=").append(mFlags);
      localStringBuilder.append(", mDescription=").append(mDescription);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(mFlags);
      mDescription.writeToParcel(paramParcel, paramInt);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static @interface Flags {}
  }
  
  private static class ServiceBinderWrapper
  {
    private Messenger mMessenger;
    private Bundle mRootHints;
    
    public ServiceBinderWrapper(IBinder paramIBinder, Bundle paramBundle)
    {
      mMessenger = new Messenger(paramIBinder);
      mRootHints = paramBundle;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      what = paramInt;
      arg1 = 1;
      localMessage.setData(paramBundle);
      replyTo = paramMessenger;
      mMessenger.send(localMessage);
    }
    
    void addSubscription(String paramString, IBinder paramIBinder, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      BundleCompat.putBinder(localBundle, "data_callback_token", paramIBinder);
      localBundle.putBundle("data_options", paramBundle);
      sendRequest(3, localBundle, paramMessenger);
    }
    
    void connect(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putBundle("data_root_hints", mRootHints);
      sendRequest(1, localBundle, paramMessenger);
    }
    
    void disconnect(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(2, null, paramMessenger);
    }
    
    void getMediaItem(String paramString, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(5, localBundle, paramMessenger);
    }
    
    void registerCallbackMessenger(Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putBundle("data_root_hints", mRootHints);
      sendRequest(6, localBundle, paramMessenger);
    }
    
    void removeSubscription(String paramString, IBinder paramIBinder, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      BundleCompat.putBinder(localBundle, "data_callback_token", paramIBinder);
      sendRequest(4, localBundle, paramMessenger);
    }
    
    void unregisterCallbackMessenger(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(7, null, paramMessenger);
    }
  }
  
  private static class Subscription
  {
    private final List<MediaBrowserCompat.SubscriptionCallback> mCallbacks = new ArrayList();
    private final List<Bundle> mOptionsList = new ArrayList();
    
    public Subscription() {}
    
    public MediaBrowserCompat.SubscriptionCallback getCallback(Bundle paramBundle)
    {
      int i = 0;
      while (i < mOptionsList.size())
      {
        if (MediaBrowserCompatUtils.areSameOptions((Bundle)mOptionsList.get(i), paramBundle)) {
          return (MediaBrowserCompat.SubscriptionCallback)mCallbacks.get(i);
        }
        i += 1;
      }
      return null;
    }
    
    public List<MediaBrowserCompat.SubscriptionCallback> getCallbacks()
    {
      return mCallbacks;
    }
    
    public List<Bundle> getOptionsList()
    {
      return mOptionsList;
    }
    
    public boolean isEmpty()
    {
      return mCallbacks.isEmpty();
    }
    
    public void putCallback(Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      int i = 0;
      while (i < mOptionsList.size())
      {
        if (MediaBrowserCompatUtils.areSameOptions((Bundle)mOptionsList.get(i), paramBundle))
        {
          mCallbacks.set(i, paramSubscriptionCallback);
          return;
        }
        i += 1;
      }
      mCallbacks.add(paramSubscriptionCallback);
      mOptionsList.add(paramBundle);
    }
  }
  
  public static abstract class SubscriptionCallback
  {
    private final Object mSubscriptionCallbackObj;
    WeakReference<MediaBrowserCompat.Subscription> mSubscriptionRef;
    private final IBinder mToken;
    
    public SubscriptionCallback()
    {
      if ((Build.VERSION.SDK_INT >= 24) || (BuildCompat.isAtLeastN()))
      {
        mSubscriptionCallbackObj = MediaBrowserCompatApi24.createSubscriptionCallback(new StubApi24());
        mToken = null;
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21());
        mToken = new Binder();
        return;
      }
      mSubscriptionCallbackObj = null;
      mToken = new Binder();
    }
    
    private void setSubscription(MediaBrowserCompat.Subscription paramSubscription)
    {
      mSubscriptionRef = new WeakReference(paramSubscription);
    }
    
    public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowserCompat.MediaItem> paramList) {}
    
    public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowserCompat.MediaItem> paramList, @NonNull Bundle paramBundle) {}
    
    public void onError(@NonNull String paramString) {}
    
    public void onError(@NonNull String paramString, @NonNull Bundle paramBundle) {}
    
    private class StubApi21
      implements MediaBrowserCompatApi21.SubscriptionCallback
    {
      StubApi21() {}
      
      List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
      {
        if (paramList == null) {
          paramBundle = null;
        }
        int m;
        do
        {
          return paramBundle;
          i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
          m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
          if (i != -1) {
            break;
          }
          paramBundle = paramList;
        } while (m == -1);
        int k = m * i;
        int j = k + m;
        if ((i < 0) || (m < 1) || (k >= paramList.size())) {
          return Collections.EMPTY_LIST;
        }
        int i = j;
        if (j > paramList.size()) {
          i = paramList.size();
        }
        return paramList.subList(k, i);
      }
      
      public void onChildrenLoaded(@NonNull String paramString, List<?> paramList)
      {
        if (mSubscriptionRef == null) {}
        for (Object localObject = null; localObject == null; localObject = (MediaBrowserCompat.Subscription)mSubscriptionRef.get())
        {
          MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, MediaBrowserCompat.MediaItem.fromMediaItemList(paramList));
          return;
        }
        paramList = MediaBrowserCompat.MediaItem.fromMediaItemList(paramList);
        List localList = ((MediaBrowserCompat.Subscription)localObject).getCallbacks();
        localObject = ((MediaBrowserCompat.Subscription)localObject).getOptionsList();
        int i = 0;
        label70:
        Bundle localBundle;
        if (i < localList.size())
        {
          localBundle = (Bundle)((List)localObject).get(i);
          if (localBundle != null) {
            break label115;
          }
          MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, paramList);
        }
        for (;;)
        {
          i += 1;
          break label70;
          break;
          label115:
          onChildrenLoaded(paramString, applyOptions(paramList, localBundle), localBundle);
        }
      }
      
      public void onError(@NonNull String paramString)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString);
      }
    }
    
    private class StubApi24
      extends MediaBrowserCompat.SubscriptionCallback.StubApi21
      implements MediaBrowserCompatApi24.SubscriptionCallback
    {
      StubApi24()
      {
        super();
      }
      
      public void onChildrenLoaded(@NonNull String paramString, List<?> paramList, @NonNull Bundle paramBundle)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, MediaBrowserCompat.MediaItem.fromMediaItemList(paramList), paramBundle);
      }
      
      public void onError(@NonNull String paramString, @NonNull Bundle paramBundle)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString, paramBundle);
      }
    }
  }
}
