package android.support.v7.util;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ParallelExecutorCompat;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T>
  implements ThreadUtil<T>
{
  MessageThreadUtil() {}
  
  public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> paramBackgroundCallback)
  {
    new ThreadUtil.BackgroundCallback()
    {
      static final int LOAD_TILE = 3;
      static final int RECYCLE_TILE = 4;
      static final int REFRESH = 1;
      static final int UPDATE_RANGE = 2;
      private Runnable mBackgroundRunnable = new Runnable()
      {
        public void run()
        {
          for (;;)
          {
            MessageThreadUtil.SyncQueueItem localSyncQueueItem = mQueue.next();
            if (localSyncQueueItem == null)
            {
              mBackgroundRunning.set(false);
              return;
            }
            switch (what)
            {
            default: 
              Log.e("ThreadUtil", "Unsupported message, what=" + what);
              break;
            case 1: 
              mQueue.removeMessages(1);
              val$callback.refresh(arg1);
              break;
            case 2: 
              mQueue.removeMessages(2);
              mQueue.removeMessages(3);
              val$callback.updateRange(arg1, arg2, arg3, arg4, arg5);
              break;
            case 3: 
              val$callback.loadTile(arg1, arg2);
              break;
            case 4: 
              val$callback.recycleTile((TileList.Tile)data);
            }
          }
        }
      };
      AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
      private final Executor mExecutor = ParallelExecutorCompat.getParallelExecutor();
      final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
      
      private void maybeExecuteBackgroundRunnable()
      {
        if (mBackgroundRunning.compareAndSet(false, true)) {
          mExecutor.execute(mBackgroundRunnable);
        }
      }
      
      private void sendMessage(MessageThreadUtil.SyncQueueItem paramAnonymousSyncQueueItem)
      {
        mQueue.sendMessage(paramAnonymousSyncQueueItem);
        maybeExecuteBackgroundRunnable();
      }
      
      private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem paramAnonymousSyncQueueItem)
      {
        mQueue.sendMessageAtFrontOfQueue(paramAnonymousSyncQueueItem);
        maybeExecuteBackgroundRunnable();
      }
      
      public void loadTile(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, paramAnonymousInt1, paramAnonymousInt2));
      }
      
      public void recycleTile(TileList.Tile<T> paramAnonymousTile)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, paramAnonymousTile));
      }
      
      public void refresh(int paramAnonymousInt)
      {
        sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(1, paramAnonymousInt, null));
      }
      
      public void updateRange(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
      {
        sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(2, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, null));
      }
    };
  }
  
  public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> paramMainThreadCallback)
  {
    new ThreadUtil.MainThreadCallback()
    {
      static final int ADD_TILE = 2;
      static final int REMOVE_TILE = 3;
      static final int UPDATE_ITEM_COUNT = 1;
      private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
      private Runnable mMainThreadRunnable = new Runnable()
      {
        public void run()
        {
          MessageThreadUtil.SyncQueueItem localSyncQueueItem = mQueue.next();
          if (localSyncQueueItem != null)
          {
            switch (what)
            {
            default: 
              Log.e("ThreadUtil", "Unsupported message, what=" + what);
            }
            for (;;)
            {
              localSyncQueueItem = mQueue.next();
              break;
              val$callback.updateItemCount(arg1, arg2);
              continue;
              val$callback.addTile(arg1, (TileList.Tile)data);
              continue;
              val$callback.removeTile(arg1, arg2);
            }
          }
        }
      };
      final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
      
      private void sendMessage(MessageThreadUtil.SyncQueueItem paramAnonymousSyncQueueItem)
      {
        mQueue.sendMessage(paramAnonymousSyncQueueItem);
        mMainThreadHandler.post(mMainThreadRunnable);
      }
      
      public void addTile(int paramAnonymousInt, TileList.Tile<T> paramAnonymousTile)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(2, paramAnonymousInt, paramAnonymousTile));
      }
      
      public void removeTile(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, paramAnonymousInt1, paramAnonymousInt2));
      }
      
      public void updateItemCount(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(1, paramAnonymousInt1, paramAnonymousInt2));
      }
    };
  }
  
  static class MessageQueue
  {
    private MessageThreadUtil.SyncQueueItem mRoot;
    
    MessageQueue() {}
    
    /* Error */
    MessageThreadUtil.SyncQueueItem next()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   21: astore_1
      //   22: aload_0
      //   23: aload_0
      //   24: getfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   27: invokestatic 24	android/support/v7/util/MessageThreadUtil$SyncQueueItem:access$000	(Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;)Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   30: putfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   33: goto -20 -> 13
      //   36: astore_1
      //   37: aload_0
      //   38: monitorexit
      //   39: aload_1
      //   40: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	41	0	this	MessageQueue
      //   6	16	1	localSyncQueueItem	MessageThreadUtil.SyncQueueItem
      //   36	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	36	finally
      //   17	33	36	finally
    }
    
    void removeMessages(int paramInt)
    {
      try
      {
        while ((mRoot != null) && (mRoot.what == paramInt))
        {
          MessageThreadUtil.SyncQueueItem localSyncQueueItem1 = mRoot;
          mRoot = MessageThreadUtil.SyncQueueItem.access$000(mRoot);
          localSyncQueueItem1.recycle();
        }
        if (mRoot == null) {
          break label105;
        }
      }
      finally {}
      Object localObject3 = mRoot;
      Object localObject2 = MessageThreadUtil.SyncQueueItem.access$000((MessageThreadUtil.SyncQueueItem)localObject3);
      if (localObject2 != null)
      {
        MessageThreadUtil.SyncQueueItem localSyncQueueItem2 = MessageThreadUtil.SyncQueueItem.access$000((MessageThreadUtil.SyncQueueItem)localObject2);
        if (what == paramInt)
        {
          MessageThreadUtil.SyncQueueItem.access$002((MessageThreadUtil.SyncQueueItem)localObject3, localSyncQueueItem2);
          ((MessageThreadUtil.SyncQueueItem)localObject2).recycle();
        }
        for (;;)
        {
          localObject2 = localSyncQueueItem2;
          break;
          localObject3 = localObject2;
        }
      }
      label105:
    }
    
    /* Error */
    void sendMessage(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   6: ifnonnull +11 -> 17
      //   9: aload_0
      //   10: aload_1
      //   11: putfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   14: aload_0
      //   15: monitorexit
      //   16: return
      //   17: aload_0
      //   18: getfield 18	android/support/v7/util/MessageThreadUtil$MessageQueue:mRoot	Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   21: astore_2
      //   22: aload_2
      //   23: invokestatic 24	android/support/v7/util/MessageThreadUtil$SyncQueueItem:access$000	(Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;)Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   26: ifnull +11 -> 37
      //   29: aload_2
      //   30: invokestatic 24	android/support/v7/util/MessageThreadUtil$SyncQueueItem:access$000	(Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;)Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   33: astore_2
      //   34: goto -12 -> 22
      //   37: aload_2
      //   38: aload_1
      //   39: invokestatic 37	android/support/v7/util/MessageThreadUtil$SyncQueueItem:access$002	(Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;)Landroid/support/v7/util/MessageThreadUtil$SyncQueueItem;
      //   42: pop
      //   43: goto -29 -> 14
      //   46: astore_1
      //   47: aload_0
      //   48: monitorexit
      //   49: aload_1
      //   50: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	51	0	this	MessageQueue
      //   0	51	1	paramSyncQueueItem	MessageThreadUtil.SyncQueueItem
      //   21	17	2	localSyncQueueItem	MessageThreadUtil.SyncQueueItem
      // Exception table:
      //   from	to	target	type
      //   2	14	46	finally
      //   17	22	46	finally
      //   22	34	46	finally
      //   37	43	46	finally
    }
    
    void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
    {
      try
      {
        MessageThreadUtil.SyncQueueItem.access$002(paramSyncQueueItem, mRoot);
        mRoot = paramSyncQueueItem;
        return;
      }
      finally
      {
        paramSyncQueueItem = finally;
        throw paramSyncQueueItem;
      }
    }
  }
  
  static class SyncQueueItem
  {
    private static SyncQueueItem sPool;
    private static final Object sPoolLock = new Object();
    public int arg1;
    public int arg2;
    public int arg3;
    public int arg4;
    public int arg5;
    public Object data;
    private SyncQueueItem next;
    public int what;
    
    SyncQueueItem() {}
    
    static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, int paramInt3)
    {
      return obtainMessage(paramInt1, paramInt2, paramInt3, 0, 0, 0, null);
    }
    
    static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject)
    {
      synchronized (sPoolLock)
      {
        if (sPool == null)
        {
          localSyncQueueItem = new SyncQueueItem();
          what = paramInt1;
          arg1 = paramInt2;
          arg2 = paramInt3;
          arg3 = paramInt4;
          arg4 = paramInt5;
          arg5 = paramInt6;
          data = paramObject;
          return localSyncQueueItem;
        }
        SyncQueueItem localSyncQueueItem = sPool;
        sPool = sPoolnext;
        next = null;
      }
    }
    
    static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, Object paramObject)
    {
      return obtainMessage(paramInt1, paramInt2, 0, 0, 0, 0, paramObject);
    }
    
    void recycle()
    {
      next = null;
      arg5 = 0;
      arg4 = 0;
      arg3 = 0;
      arg2 = 0;
      arg1 = 0;
      what = 0;
      data = null;
      synchronized (sPoolLock)
      {
        if (sPool != null) {
          next = sPool;
        }
        sPool = this;
        return;
      }
    }
  }
}
