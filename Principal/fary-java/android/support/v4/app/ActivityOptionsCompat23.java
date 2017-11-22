package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.view.View;

@TargetApi(23)
@RequiresApi(23)
class ActivityOptionsCompat23
{
  private final ActivityOptions mActivityOptions;
  
  private ActivityOptionsCompat23(ActivityOptions paramActivityOptions)
  {
    mActivityOptions = paramActivityOptions;
  }
  
  public static ActivityOptionsCompat23 makeBasic()
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeBasic());
  }
  
  public static ActivityOptionsCompat23 makeClipRevealAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static ActivityOptionsCompat23 makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeCustomAnimation(paramContext, paramInt1, paramInt2));
  }
  
  public static ActivityOptionsCompat23 makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static ActivityOptionsCompat23 makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
  }
  
  public static ActivityOptionsCompat23 makeSceneTransitionAnimation(Activity paramActivity, View[] paramArrayOfView, String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfView != null)
    {
      Pair[] arrayOfPair = new Pair[paramArrayOfView.length];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfPair;
        if (i >= arrayOfPair.length) {
          break;
        }
        arrayOfPair[i] = Pair.create(paramArrayOfView[i], paramArrayOfString[i]);
        i += 1;
      }
    }
    return new ActivityOptionsCompat23(ActivityOptions.makeSceneTransitionAnimation(paramActivity, localObject));
  }
  
  public static ActivityOptionsCompat23 makeTaskLaunchBehind()
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeTaskLaunchBehind());
  }
  
  public static ActivityOptionsCompat23 makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return new ActivityOptionsCompat23(ActivityOptions.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
  }
  
  public void requestUsageTimeReport(PendingIntent paramPendingIntent)
  {
    mActivityOptions.requestUsageTimeReport(paramPendingIntent);
  }
  
  public Bundle toBundle()
  {
    return mActivityOptions.toBundle();
  }
  
  public void update(ActivityOptionsCompat23 paramActivityOptionsCompat23)
  {
    mActivityOptions.update(mActivityOptions);
  }
}
