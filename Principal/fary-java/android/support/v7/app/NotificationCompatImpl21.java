package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;

@TargetApi(21)
@RequiresApi(21)
class NotificationCompatImpl21
{
  NotificationCompatImpl21() {}
  
  public static void addMediaStyle(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, int[] paramArrayOfInt, Object paramObject)
  {
    paramNotificationBuilderWithBuilderAccessor = new Notification.MediaStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder());
    if (paramArrayOfInt != null) {
      paramNotificationBuilderWithBuilderAccessor.setShowActionsInCompactView(paramArrayOfInt);
    }
    if (paramObject != null) {
      paramNotificationBuilderWithBuilderAccessor.setMediaSession((MediaSession.Token)paramObject);
    }
  }
}
