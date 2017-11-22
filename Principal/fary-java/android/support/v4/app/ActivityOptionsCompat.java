package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat
{
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  protected ActivityOptionsCompat() {}
  
  public static ActivityOptionsCompat makeBasic()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeBasic());
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeBasic());
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeClipRevealAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Pair<View, String>... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramVarArgs != null)
      {
        View[] arrayOfView = new View[paramVarArgs.length];
        String[] arrayOfString = new String[paramVarArgs.length];
        int i = 0;
        for (;;)
        {
          localObject1 = arrayOfString;
          localObject2 = arrayOfView;
          if (i >= paramVarArgs.length) {
            break;
          }
          arrayOfView[i] = ((View)first);
          arrayOfString[i] = ((String)second);
          i += 1;
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {
        return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(paramActivity, localObject2, localObject1));
      }
      if (Build.VERSION.SDK_INT >= 23) {
        return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(paramActivity, localObject2, localObject1));
      }
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, localObject2, localObject1));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeTaskLaunchBehind()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeTaskLaunchBehind());
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeTaskLaunchBehind());
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeTaskLaunchBehind());
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  @Nullable
  public Rect getLaunchBounds()
  {
    return null;
  }
  
  public void requestUsageTimeReport(PendingIntent paramPendingIntent) {}
  
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
  {
    return null;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  @TargetApi(21)
  @RequiresApi(21)
  private static class ActivityOptionsImpl21
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat21 mImpl;
    
    ActivityOptionsImpl21(ActivityOptionsCompat21 paramActivityOptionsCompat21)
    {
      mImpl = paramActivityOptionsCompat21;
    }
    
    public Bundle toBundle()
    {
      return mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl21))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl21)paramActivityOptionsCompat;
        mImpl.update(mImpl);
      }
    }
  }
  
  @TargetApi(23)
  @RequiresApi(23)
  private static class ActivityOptionsImpl23
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat23 mImpl;
    
    ActivityOptionsImpl23(ActivityOptionsCompat23 paramActivityOptionsCompat23)
    {
      mImpl = paramActivityOptionsCompat23;
    }
    
    public void requestUsageTimeReport(PendingIntent paramPendingIntent)
    {
      mImpl.requestUsageTimeReport(paramPendingIntent);
    }
    
    public Bundle toBundle()
    {
      return mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl23))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl23)paramActivityOptionsCompat;
        mImpl.update(mImpl);
      }
    }
  }
  
  @TargetApi(24)
  @RequiresApi(24)
  private static class ActivityOptionsImpl24
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat24 mImpl;
    
    ActivityOptionsImpl24(ActivityOptionsCompat24 paramActivityOptionsCompat24)
    {
      mImpl = paramActivityOptionsCompat24;
    }
    
    public Rect getLaunchBounds()
    {
      return mImpl.getLaunchBounds();
    }
    
    public void requestUsageTimeReport(PendingIntent paramPendingIntent)
    {
      mImpl.requestUsageTimeReport(paramPendingIntent);
    }
    
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
    {
      return new ActivityOptionsImpl24(mImpl.setLaunchBounds(paramRect));
    }
    
    public Bundle toBundle()
    {
      return mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl24))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl24)paramActivityOptionsCompat;
        mImpl.update(mImpl);
      }
    }
  }
  
  @TargetApi(16)
  @RequiresApi(16)
  private static class ActivityOptionsImplJB
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompatJB mImpl;
    
    ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
    {
      mImpl = paramActivityOptionsCompatJB;
    }
    
    public Bundle toBundle()
    {
      return mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
      {
        paramActivityOptionsCompat = (ActivityOptionsImplJB)paramActivityOptionsCompat;
        mImpl.update(mImpl);
      }
    }
  }
}
