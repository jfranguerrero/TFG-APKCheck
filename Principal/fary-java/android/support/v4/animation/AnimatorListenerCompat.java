package android.support.v4.animation;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface AnimatorListenerCompat
{
  public abstract void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat);
  
  public abstract void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat);
  
  public abstract void onAnimationRepeat(ValueAnimatorCompat paramValueAnimatorCompat);
  
  public abstract void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat);
}
