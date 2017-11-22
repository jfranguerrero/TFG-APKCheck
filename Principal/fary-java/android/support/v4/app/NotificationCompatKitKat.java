package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
@RequiresApi(19)
class NotificationCompatKitKat
{
  NotificationCompatKitKat() {}
  
  public static NotificationCompatBase.Action getAction(Notification paramNotification, int paramInt, NotificationCompatBase.Action.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
  {
    Notification.Action localAction = actions[paramInt];
    Object localObject = null;
    SparseArray localSparseArray = extras.getSparseParcelableArray("android.support.actionExtras");
    paramNotification = localObject;
    if (localSparseArray != null) {
      paramNotification = (Bundle)localSparseArray.get(paramInt);
    }
    return NotificationCompatJellybean.readAction(paramFactory, paramFactory1, icon, title, actionIntent, paramNotification);
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    if (actions != null) {
      return actions.length;
    }
    return 0;
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    return extras;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    return extras.getString("android.support.groupKey");
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    return extras.getBoolean("android.support.localOnly");
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    return extras.getString("android.support.sortKey");
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    return extras.getBoolean("android.support.isGroupSummary");
  }
  
  public static class Builder
    implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions
  {
    private Notification.Builder b;
    private List<Bundle> mActionExtrasList = new ArrayList();
    private RemoteViews mBigContentView;
    private RemoteViews mContentView;
    private Bundle mExtras;
    
    public Builder(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews1, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean4, ArrayList<String> paramArrayList, Bundle paramBundle, String paramString1, boolean paramBoolean5, String paramString2, RemoteViews paramRemoteViews2, RemoteViews paramRemoteViews3)
    {
      paramContext = new Notification.Builder(paramContext).setWhen(when).setShowWhen(paramBoolean2).setSmallIcon(icon, iconLevel).setContent(contentView).setTicker(tickerText, paramRemoteViews1).setSound(sound, audioStreamType).setVibrate(vibrate).setLights(ledARGB, ledOnMS, ledOffMS);
      if ((flags & 0x2) != 0)
      {
        paramBoolean2 = true;
        paramContext = paramContext.setOngoing(paramBoolean2);
        if ((flags & 0x8) == 0) {
          break label392;
        }
        paramBoolean2 = true;
        label128:
        paramContext = paramContext.setOnlyAlertOnce(paramBoolean2);
        if ((flags & 0x10) == 0) {
          break label398;
        }
        paramBoolean2 = true;
        label148:
        paramContext = paramContext.setAutoCancel(paramBoolean2).setDefaults(defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(deleteIntent);
        if ((flags & 0x80) == 0) {
          break label404;
        }
        paramBoolean2 = true;
        label207:
        b = paramContext.setFullScreenIntent(paramPendingIntent2, paramBoolean2).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean3).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
        mExtras = new Bundle();
        if (paramBundle != null) {
          mExtras.putAll(paramBundle);
        }
        if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
          mExtras.putStringArray("android.people", (String[])paramArrayList.toArray(new String[paramArrayList.size()]));
        }
        if (paramBoolean4) {
          mExtras.putBoolean("android.support.localOnly", true);
        }
        if (paramString1 != null)
        {
          mExtras.putString("android.support.groupKey", paramString1);
          if (!paramBoolean5) {
            break label410;
          }
          mExtras.putBoolean("android.support.isGroupSummary", true);
        }
      }
      for (;;)
      {
        if (paramString2 != null) {
          mExtras.putString("android.support.sortKey", paramString2);
        }
        mContentView = paramRemoteViews2;
        mBigContentView = paramRemoteViews3;
        return;
        paramBoolean2 = false;
        break;
        label392:
        paramBoolean2 = false;
        break label128;
        label398:
        paramBoolean2 = false;
        break label148;
        label404:
        paramBoolean2 = false;
        break label207;
        label410:
        mExtras.putBoolean("android.support.useSideChannel", true);
      }
    }
    
    public void addAction(NotificationCompatBase.Action paramAction)
    {
      mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(b, paramAction));
    }
    
    public Notification build()
    {
      Object localObject = NotificationCompatJellybean.buildActionExtrasMap(mActionExtrasList);
      if (localObject != null) {
        mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
      }
      b.setExtras(mExtras);
      localObject = b.build();
      if (mContentView != null) {
        contentView = mContentView;
      }
      if (mBigContentView != null) {
        bigContentView = mBigContentView;
      }
      return localObject;
    }
    
    public Notification.Builder getBuilder()
    {
      return b;
    }
  }
}
