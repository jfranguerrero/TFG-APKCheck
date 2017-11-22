package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewPropertyAnimator;

@TargetApi(12)
@RequiresApi(12)
class HoneycombMr1AnimatorCompatProvider
  implements AnimatorProvider
{
  private TimeInterpolator mDefaultInterpolator;
  
  HoneycombMr1AnimatorCompatProvider() {}
  
  public void clearInterpolator(View paramView)
  {
    if (mDefaultInterpolator == null) {
      mDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(mDefaultInterpolator);
  }
  
  public ValueAnimatorCompat emptyValueAnimator()
  {
    return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
  }
  
  static class AnimatorListenerCompatWrapper
    implements Animator.AnimatorListener
  {
    final ValueAnimatorCompat mValueAnimatorCompat;
    final AnimatorListenerCompat mWrapped;
    
    public AnimatorListenerCompatWrapper(AnimatorListenerCompat paramAnimatorListenerCompat, ValueAnimatorCompat paramValueAnimatorCompat)
    {
      mWrapped = paramAnimatorListenerCompat;
      mValueAnimatorCompat = paramValueAnimatorCompat;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      mWrapped.onAnimationCancel(mValueAnimatorCompat);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      mWrapped.onAnimationEnd(mValueAnimatorCompat);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      mWrapped.onAnimationRepeat(mValueAnimatorCompat);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      mWrapped.onAnimationStart(mValueAnimatorCompat);
    }
  }
  
  static class HoneycombValueAnimatorCompat
    implements ValueAnimatorCompat
  {
    final Animator mWrapped;
    
    public HoneycombValueAnimatorCompat(Animator paramAnimator)
    {
      mWrapped = paramAnimator;
    }
    
    public void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
    {
      mWrapped.addListener(new HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper(paramAnimatorListenerCompat, this));
    }
    
    public void addUpdateListener(final AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
    {
      if ((mWrapped instanceof ValueAnimator)) {
        ((ValueAnimator)mWrapped).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramAnimatorUpdateListenerCompat.onAnimationUpdate(HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.this);
          }
        });
      }
    }
    
    public void cancel()
    {
      mWrapped.cancel();
    }
    
    public float getAnimatedFraction()
    {
      return ((ValueAnimator)mWrapped).getAnimatedFraction();
    }
    
    public void setDuration(long paramLong)
    {
      mWrapped.setDuration(paramLong);
    }
    
    public void setTarget(View paramView)
    {
      mWrapped.setTarget(paramView);
    }
    
    public void start()
    {
      mWrapped.start();
    }
  }
}
