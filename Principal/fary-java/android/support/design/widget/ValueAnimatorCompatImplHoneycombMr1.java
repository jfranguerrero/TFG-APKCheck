package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;

@TargetApi(12)
@RequiresApi(12)
class ValueAnimatorCompatImplHoneycombMr1
  extends ValueAnimatorCompat.Impl
{
  private final ValueAnimator mValueAnimator = new ValueAnimator();
  
  ValueAnimatorCompatImplHoneycombMr1() {}
  
  public void addListener(final ValueAnimatorCompat.Impl.AnimatorListenerProxy paramAnimatorListenerProxy)
  {
    mValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramAnimatorListenerProxy.onAnimationCancel();
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnimatorListenerProxy.onAnimationEnd();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramAnimatorListenerProxy.onAnimationStart();
      }
    });
  }
  
  public void addUpdateListener(final ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy)
  {
    mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramAnimatorUpdateListenerProxy.onAnimationUpdate();
      }
    });
  }
  
  public void cancel()
  {
    mValueAnimator.cancel();
  }
  
  public void end()
  {
    mValueAnimator.end();
  }
  
  public float getAnimatedFloatValue()
  {
    return ((Float)mValueAnimator.getAnimatedValue()).floatValue();
  }
  
  public float getAnimatedFraction()
  {
    return mValueAnimator.getAnimatedFraction();
  }
  
  public int getAnimatedIntValue()
  {
    return ((Integer)mValueAnimator.getAnimatedValue()).intValue();
  }
  
  public long getDuration()
  {
    return mValueAnimator.getDuration();
  }
  
  public boolean isRunning()
  {
    return mValueAnimator.isRunning();
  }
  
  public void setDuration(long paramLong)
  {
    mValueAnimator.setDuration(paramLong);
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    mValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    mValueAnimator.setIntValues(new int[] { paramInt1, paramInt2 });
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    mValueAnimator.setInterpolator(paramInterpolator);
  }
  
  public void start()
  {
    mValueAnimator.start();
  }
}
